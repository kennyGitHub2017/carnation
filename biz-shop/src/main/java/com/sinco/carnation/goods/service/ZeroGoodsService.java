package com.sinco.carnation.goods.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.market.bo.ActivityHotSaleBO;
import com.sinco.carnation.market.service.SaleActivityService;
import com.sinco.carnation.shop.bo.ZeroGoodsBO;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.shop.dao.ZeroGoodsDao;
import com.sinco.carnation.shop.model.ZeroGoods;
import com.sinco.carnation.shop.vo.ZeroGoodsVO;
import com.sinco.carnation.sys.contants.ActAppHotSaleContant;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class ZeroGoodsService {
	@Autowired
	private ZeroGoodsDao zeroGoodsDao;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private SaleActivityService saleActivityService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/***
	 * 根据GOODSID 查询
	 * 
	 * @param goodsId
	 * @return
	 */
	public ZeroGoods getByGoodsId(Long goodsId) {
		return this.zeroGoodsDao.getByGoodsId(goodsId);
	}

	public List<ZeroGoodsBO> findByVo(ZeroGoodsVO vo) {
		return this.zeroGoodsDao.findByVo(vo);
	}

	/**
	 * 商品添加到0元购
	 * 
	 * @param goodsId
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean addGoodstoZeroGoods(Long goodsId) {
		ZeroGoods zeroGoods = new ZeroGoods();
		GoodsBO goodsBO = goodsService.findBOByid(goodsId);
		if (goodsBO != null) {
			String goodsName = "";
			if (null != goodsBO.getGoodsName()) {
				goodsName = goodsBO.getGoodsName();
			}
			zeroGoods.setGoodsId(goodsId);
			zeroGoods.setGoodsName(goodsName);
			zeroGoods.setCreatTime(new Date());
			this.zeroGoodsDao.save(zeroGoods);
			return true;
		}
		return false;
	}

	/**
	 * 编辑0元购商品 库存从原商品库存中扣除
	 * 
	 * @param record
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean updateZeroGoods(ZeroGoods record) {
		if (record != null) {
			Long goodsId = record.getGoodsId();
			// 商品原库存
			GoodsBO goodsBO = goodsService.findBOByid(goodsId);
			ZeroGoods zeroGoods = this.getByGoodsId(goodsId);
			if (goodsBO == null || zeroGoods == null) {
				return false;
			}
			if (zeroGoods.getGoodsInventory() < 0 || goodsBO.getGoodsInventory() < 0
					|| record.getGoodsInventory() < 0) {
				log.error("[updateZeroGoods] this goods=" + goodsId + ", inventory < 0 , this is a big bug");
				return false;
			}
			// 0元购商品原库存
			int zeroInventory = 0;
			zeroInventory = zeroGoods.getGoodsInventory();
			int goodsInventory = 0;
			goodsInventory = goodsBO.getGoodsInventory();
			// 商品总库存
			goodsInventory = goodsInventory + zeroInventory;
			// 新分配给0元购的库存
			int newZeroInventory = 0;
			newZeroInventory = record.getGoodsInventory();
			// 0元购库存不能大于商品原库存
			if ((goodsInventory - newZeroInventory) <= 0) {
				log.error("[updateZeroGoods] goodsInventory less than newZeroInventory");
				return false;
			}

			Goods goods = new Goods();
			goods.setId(goodsBO.getId());
			goods.setGoodsInventory(goodsInventory - newZeroInventory);
			// 更新库存
			goodsService.update(goods);

			record.setGoodsInventory(newZeroInventory);
			record.setGoodsStatus(true);
			this.zeroGoodsDao.save(record);
			return true;
		}
		return false;
	}

	/**
	 * 更新上下架状态 status:1 上架 0 下架
	 */
	public boolean updateZeroGoodsStatus(ZeroGoods record, int status) {
		if (record == null) {
			return false;
		}
		if (status == 1) {
			record.setGoodsStatus(true);
		} else {
			record.setGoodsStatus(false);
		}
		this.zeroGoodsDao.save(record);
		return true;
	}

	/**
	 * 移除0元购商品 同时将销售数量和浏览次数加入原商品信息
	 * 
	 * @param record
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean removeZeroGoods(Long goodsId) {
		if (goodsId != null) {
			try {
				ZeroGoods zeroGoods = this.getByGoodsId(goodsId);
				GoodsBO goodsBO = goodsService.findBOByid(goodsId);
				Goods goods = new Goods();
				goods.setId(goodsBO.getId());
				// 库存
				goods.setGoodsInventory(goodsBO.getGoodsInventory() + zeroGoods.getGoodsInventory());
				// 售出数量
				goods.setGoodsSalenum(goodsBO.getGoodsSalenum() + zeroGoods.getGoodsSalenum());
				// 浏览次数
				goods.setGoodsClick(goodsBO.getGoodsClick() + zeroGoods.getGoodsClick());
				// 更新库存 售出数量 浏览次数
				goodsService.update(goods);
				this.zeroGoodsDao.remove(zeroGoods.getId());
				return true;
			} catch (Exception e) {
				log.error("[removeZeroGoods] remove this zero goods is unsuccess the goodsId=" + goodsId);
			}
		}
		return false;
	}

	/**
	 * 根据vo查询分页
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public List<ZeroGoodsBO> findPageByVo(ZeroGoodsVO vo, MyPage<ZeroGoodsBO> page) {
		return this.zeroGoodsDao.findPageByVo(vo, page);
	}

	public ZeroGoods findById(Long id) {
		return this.zeroGoodsDao.findOne(id);
	}

	/**
	 * 活动时间一过，将0元购中所有的商品移除
	 */
	public void ActTimeOut() {
		ActivityHotSaleBO bo = saleActivityService.findTopByCode(ActAppHotSaleContant.act_vecode_4);
		// 活动是否存在
		if (bo != null) {
			// 是否有结束时间
			if (null != bo.getEndTime()) {
				Long endTime = bo.getEndTime().getTime();
				Long time = new Date().getTime();
				// 是否过了结束时间
				if (time >= endTime) {
					ZeroGoodsVO vo = new ZeroGoodsVO();
					List<ZeroGoodsBO> list = this.findByVo(vo);
					// 商品列表是否还有商品
					if (list.size() > 0) {
						for (ZeroGoodsBO zeroGoodsBO : list) {
							if (null != zeroGoodsBO.getGoodsId()) {
								// 根据goodsId移除0元购商品 同时将销售数量和浏览次数加入原商品信息
								this.removeZeroGoods(zeroGoodsBO.getGoodsId());
							}
						}
					} else {
						log.info("[ActTimeOut] ZeroGoods havn't goods , don't need remove");
					}
				}
			}
		}
	}

}
