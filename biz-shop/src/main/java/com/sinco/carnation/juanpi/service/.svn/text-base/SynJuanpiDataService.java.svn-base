package com.sinco.carnation.juanpi.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.juanpi.bo.JuanpiGoodsBO;
import com.sinco.carnation.juanpi.bo.JuanpiGoodsClassBO;
import com.sinco.carnation.juanpi.bo.JuanpiOrderBO;
import com.sinco.carnation.juanpi.bo.JuanpiOrderGoodsBO;
import com.sinco.carnation.juanpi.dao.JuanpiGoodsClassDao;
import com.sinco.carnation.juanpi.dao.JuanpiGoodsDao;
import com.sinco.carnation.juanpi.dao.JuanpiOrderDao;
import com.sinco.carnation.juanpi.dao.JuanpiOrderGoodsDao;
import com.sinco.carnation.juanpi.tools.JuanpiDataApi;
import com.sinco.common.utils.DateUtils;

import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.lucene.GoodsDocument;
import vc.thinker.b2b2c.lucene.LuceneUtil;

/**
 * 卷皮数据同步处理
 * @author Tivan
 *
 */
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class SynJuanpiDataService {
	private static final Logger LOG = LoggerFactory.getLogger(SynJuanpiDataService.class);
	@Autowired
	private LuceneUtil luceneUtil;
	@Autowired
	private JuanpiGoodsDao juanpiGoodsDao;
	@Autowired
	private JuanpiGoodsClassDao juanpiGoodsClassDao;
	@Autowired
	private GoodsClassService goodsClassService;
	@Autowired
	private JuanpiOrderDao juanpiOrderDao;
	@Autowired
	private JuanpiOrderGoodsDao juanpiOrderGoodsDao;
	private static final int pageTotal = 1000;
	
	/**
	 * 同步卷皮商品到云尚数据库
	 */
	public void synJuanpiGoods(){
		int page = 1;
		try{
			List<JuanpiGoodsBO> goods = JuanpiDataApi.getGoods(page);
			while(goods != null && goods.size() > 0){
				LOG.info("正在同步第" + page + "页，共" + goods.size() + "条商品记录");
				synJuanpiGoods(goods);
				//最多只加载pageTotal页的数据，防止死循环
				if(page < pageTotal){
					goods = JuanpiDataApi.getGoods(++page);
				}else{
					goods = null;
				}
			}
			//处理没有同步到的商品
			juanpiGoodsDao.deleteUnsynJuanpiGoods();
			//处理没有同步的分类
			juanpiGoodsClassDao.deleteUnsynJuanpiClass();
			//更新卷皮商品搜索引擎
			page = 1;
			List<Long> ids = juanpiGoodsDao.findAllIds(page);
			while(ids != null && ids.size() > 0){
				LOG.info("同步搜索引擎卷皮商品，第" + page + "页，共" + ids.size() + "条商品记录");
				for(Long id : ids){
					updateLucene(id);
				}
				ids = juanpiGoodsDao.findAllIds(++page);
			}
		}catch(Exception e){
			LOG.error("同步卷皮商品失败", e);
		}
	}
	
	protected void synJuanpiGoods(List<JuanpiGoodsBO> goods){
		if(goods != null && goods.size() > 0){
			for(JuanpiGoodsBO good : goods){
				good.setUpdateTime(new Date());
				good.setDeleteStatus(0);
				//更新商品
				int effect = juanpiGoodsDao.update(good);
				if(effect == 0){
					//如果商品不存在，新增商品
					good.setAddTime(good.getUpdateTime());
					good.setSales(0l);
					juanpiGoodsDao.save(good);
				}
				//更新商品分类
				synJuanpiClass(good);
			}
		}
	}
	
	protected void synJuanpiClass(JuanpiGoodsBO good){
		JuanpiGoodsClassBO cls = new JuanpiGoodsClassBO();
		cls.setCateId(good.getCateId());
		cls.setCateName(good.getCateName());
		cls.setCate2Id(good.getCate2Id());
		cls.setCate2Name(good.getCate2Name());
		cls.setCate3Id(good.getCate3Id());
		cls.setCate3Name(good.getCate3Name());
		cls.setUpdateTime(new Date());
		cls.setDeleteStatus(0);
		//更新分类
		int effect = juanpiGoodsClassDao.synClass(cls);
		if(effect == 0){
			//如果分类不存在，新增分类
			cls.setAddTime(cls.getUpdateTime());
			cls.setIsJoin(0);
			juanpiGoodsClassDao.save(cls);
		}
	}
	
	/**
	 * 更新商品搜索引擎（卷皮商品专用）
	 * @param goodId 商品ID
	 */
	public void updateLucene(Long goodId){
		JuanpiGoodsBO good = juanpiGoodsDao.findOne(goodId);
		if(good == null){
			return;
		}
		//更新商品索引
		String exId = "JP" + good.getId();//区分卷皮商品和云尚商品，ID添加前缀
		if(good.getDeleteStatus() == 1 || good.getIsShow() == 0){
			luceneUtil.delete_index(GoodsDocument.class, exId);
		}else{
			GoodsDocument doc = new GoodsDocument();
			doc.setId(exId);
			doc.setTitle(good.getGoodsTitle());
			doc.setMain_photo_url(good.getImageUrl());
			doc.setPhotos_url(good.getImageUrl());
			//索引类型，商品为goods，店铺为store ,生活购为lifegoods
			doc.setType("goods");
			//商品添加时间
			doc.setAdd_time(good.getAddTime().getTime());
			//商品收藏数量
			doc.setGoods_collect(0);
			//商品销售数量
			doc.setGoods_salenum(good.getSales().intValue());
			if(good.getGoodsPrice() != null){
				//商品店铺售价
				doc.setGoods_price(good.getGoodsPrice().doubleValue());
			}
			if(good.getGoodsCprice() != null){
				//商品出售价
				doc.setStore_price(good.getGoodsCprice().doubleValue());
			}
			//设置默认库存为1
			doc.setGoods_inventory(1);
			//商品类型 0-自营 1-第三方经营
			doc.setGoods_type("1");
			//商品评价数量
			doc.setGoods_evas("0");
			//商品好评率
			doc.setWell_evaluate(0);
			//库存方式 All为全局库存，spec按规格库存
			doc.setInventory_type("All");
			//是否支持货到付款，默认为0：支持货到付款，-1为不支持货到付款
			//doc.setGoods_cod("-1");
			//商品运费承担方式，0为买家承担，1为卖家承担
			doc.setGoods_transfee((good.getFreeDelivery() != null && good.getFreeDelivery() == 1) ? "1" : "0");
			//是否为活动 0为无活动1为团购,2为活动，3为满送，4为满减，5为组合，6为F码，7为预售
			doc.setWhether_active("0");
			//是否为F码销售商品，0为不是F码销售商品，1为F码销售商品
			doc.setF_sale_type("0");
			//商品所属分类,格式为：二级分类id+"_"+三级分类id
			doc.setIs_juanpi(1);
			if(good.getClassId() != null){
				//如果单个商品映射到云尚分类，保存云尚分类ID，可直接搜索出来
				//分类映射不做修改，1会和单个映射冲突，2分类映射关系变更后不用刷新搜索引擎
				GoodsClassBO gcBo = goodsClassService.getBOById(good.getClassId());
				if (gcBo != null && gcBo.getLevel() == 2) {
					doc.setGoods_class(CommUtil.null2String(gcBo.getParentId()) + "_"
							+ CommUtil.null2String(good.getClassId()));
				} else {
					doc.setGoods_class(CommUtil.null2String(good.getClassId()) + "_");
				}
			}else{
				doc.setJuanpi_class(CommUtil.null2String(good.getCate3Id()));
			}
			doc.setIs_tuangou(good.getIsTuangou() == 1 ? 1 : 0);
			doc.setTuangou_price(good.getTuanCprice().doubleValue());
			doc.setTarget_url_m(good.getTargetUrlM());
			luceneUtil.update(doc);
		}
	}
	
	/**
	 * 同步卷皮订单到云尚数据库
	 * 仅同步120分钟内的订单数据
	 */
	public void synJuanpiOrder(){
		LOG.info("===============>>synJuanpiOrder");
		try{
			Calendar cal = Calendar.getInstance();
			Date endTime = cal.getTime();
			cal.add(Calendar.HOUR, -2);
			Date startTime = cal.getTime();
			List<JuanpiOrderBO> orders = JuanpiDataApi.getOrders(startTime.getTime()/1000, endTime.getTime()/1000);
			synOrder(orders);
		}catch(Exception e){
			LOG.error("同步卷皮订单失败", e);
		}
	}
	/**
	 * 同步卷皮订单到云尚数据库
	 * 仅同步3天内的订单数据
	 */
	public void synJuanpiOrder2(int days){
		LOG.info("===============>>synJuanpiOrder2");
		try{
			List<String> dates = new ArrayList<String>();
			for(int i = 0; i < days; i++){
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, -i);
				dates.add(DateUtils.formatDate(cal.getTime(), "yyyy-MM-dd"));
			}
			if(dates != null && dates.size() > 0){
				Calendar cal = Calendar.getInstance();
				for(String date : dates){
					if(date == null){
						continue;
					}
					//取每一天未完成订单
					String[] dateStr = date.split("-");
					int year = Integer.parseInt(dateStr[0]);
					int month = Integer.parseInt(dateStr[1]);
					int day = Integer.parseInt(dateStr[2]);
					cal.set(year, month-1, day, 0, 0, 0);
					Date startTime = cal.getTime();
					cal.add(Calendar.DATE, 1);
					Date endTime = cal.getTime();
					List<JuanpiOrderBO> orders = JuanpiDataApi.getOrders(startTime.getTime()/1000, endTime.getTime()/1000);
					synOrder(orders);
				}
			}
		}catch(Exception e){
			LOG.error("同步卷皮订单失败", e);
		}
	}
	
	/**
	 * 修复订单状态
	 * 仅同步数据库订单商品不为3,4的订单
	 */
	public void fixJuanpiOrder(){
		LOG.info("===============>>fixJuanpiOrder");
		//取数据库订单状态为1,2的订单按天分组（卷皮只提供一天内订单列表查询，不支持订单详情查询）
		try{
			List<String> dates = juanpiOrderDao.findUnsynOrderGroupByDate();
			if(dates != null && dates.size() > 0){
				Calendar cal = Calendar.getInstance();
				for(String date : dates){
					if(date == null){
						continue;
					}
					//取每一天未完成订单
					String[] dateStr = date.split("-");
					int year = Integer.parseInt(dateStr[0]);
					int month = Integer.parseInt(dateStr[1]);
					int day = Integer.parseInt(dateStr[2]);
					cal.set(year, month-1, day, 0, 0, 0);
					Date startTime = cal.getTime();
					cal.add(Calendar.DATE, 1);
					Date endTime = cal.getTime();
					List<JuanpiOrderBO> orders = JuanpiDataApi.getOrders(startTime.getTime()/1000, endTime.getTime()/1000);
					synOrder(orders);
				}
			}
		}catch(Exception e){
			LOG.error("修复卷皮订单失败", e);
		}
	}
	
	protected void synOrder(List<JuanpiOrderBO> orders){
		if(orders != null && orders.size() > 0){
			LOG.info("正在同步共" + orders.size() + "条订单记录");
			//同步订单数据
			for(JuanpiOrderBO order : orders){
				if(StringUtils.hasText(order.getOrderno())){
					JuanpiOrderBO oo = juanpiOrderDao.getByOrderNo(order.getOrderno());
					if(oo != null){
						order.setUpdateTime(new Date());
						order.setId(oo.getId());
						juanpiOrderDao.update(order);
					}else{
						order.setDeleteStatus(0);
						order.setUpdateTime(new Date());
						order.setAddTime(order.getUpdateTime());
						juanpiOrderDao.save(order);
					}
					synOrderGoods(order.getId(), order.getGoodss());
				}
			}
		}
	}
	
	protected void synOrderGoods(Long orderId, List<JuanpiOrderGoodsBO> goodss) {
		if(goodss != null && goodss.size() > 0){
			List<JuanpiOrderGoodsBO> oldGoodss = juanpiOrderGoodsDao.findGoodsByOrder(orderId);
			//通过订单ID+商品ID确定唯一性
			Map<String, JuanpiOrderGoodsBO> map = new HashMap<String, JuanpiOrderGoodsBO>();
			if(oldGoodss != null && oldGoodss.size() > 0){
				for(JuanpiOrderGoodsBO goods : oldGoodss){
					map.put(goods.getOrderId() + "_" + goods.getGoodsid(), goods);
				}
			}
			//同步订单下商品列表
			for(JuanpiOrderGoodsBO goods : goodss){
				goods.setOrderId(orderId);
				int effect = juanpiOrderGoodsDao.synOrderGoods(goods);
				if(effect == 0){
					goods.setAddTime(new Date());
					juanpiOrderGoodsDao.save(goods);
				}
				//如果订单商品为已结算，更新商品销量
				if(goods.getStatus() != null && goods.getStatus() == 3){
					if(effect == 0){
						//如果为新增，直接加销量
						juanpiGoodsDao.upateGoodsSales(goods.getId(), goods.getGoodsnumber());
					}else{
						//判断销量是否已经加上销量
						JuanpiOrderGoodsBO oldGoods = map.get(goods.getOrderId() + "_" + goods.getGoodsid());
						if(oldGoods == null || oldGoods.getStatus() == null || oldGoods.getStatus() != 3){
							juanpiGoodsDao.upateGoodsSales(oldGoods.getId(), goods.getGoodsnumber());
						}
					}
				}
			}
		}
	}

}
