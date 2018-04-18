package com.sinco.carnation.evaluate.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.order.service.OrderFormLogService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.shop.bo.EvaluateBO;
import com.sinco.carnation.shop.bo.OrderFormBO;
import com.sinco.carnation.shop.dao.EvaluateDao;
import com.sinco.carnation.shop.model.Evaluate;
import com.sinco.carnation.shop.model.EvaluateExample;
import com.sinco.carnation.shop.model.OrderLog;
import com.sinco.carnation.shop.vo.EvaluateVO;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.store.model.StorePoint;
import com.sinco.carnation.store.service.StorePointService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.constant.IntegralConstants;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.IntegralService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.dao.UserCustomerDao;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.service.IntegralLogService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.dal.common.MyPage;

@Service
@Transactional(readOnly = true)
public class EvaluateService {
	private static final Logger logger = LoggerFactory.getLogger(IntegralService.class);
	@Autowired
	private EvaluateDao evaluateDao;
	@Autowired
	private OrderFormTools orderFormTools;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private IntegralLogService integralLogService;
	@Autowired
	private StorePointService storePointService;
	@Autowired
	private AccessoryServiceImpl accessoryService;
	@Autowired
	private OrderFormLogService orderFormLogService;
	@Autowired
	private UserCustomerService customerService;
	@Autowired
	private UserCustomerDao customerDao;
	@Autowired
	private SysConfigService configService;
	@Autowired
	private IntegralService integralService;

	public List<Evaluate> selectEvaluateByGoodsId(Long goodsId) {
		return this.evaluateDao.selectEvaluateByGoodsId(goodsId);

	}

	/**
	 * 初次添加评价 批量的
	 * 
	 * @param order
	 *            所属订单
	 * @param evaluates
	 *            评价列表 by young
	 */
	@Transactional(readOnly = false)
	public void add(OrderFormBO order, List<Evaluate> evaluates) {
		Date now = new Date();

		// 1.更新订单状态为已评价
		order.setOrderStatus(50);
		order.setFinishTime(now);
		orderFormService.update(order);

		// 2.更新订单日志
		OrderLog orderLog = new OrderLog();
		orderLog.setAddTime(now);
		orderLog.setLogInfo("添加评价订单");
		orderLog.setLogUserId(order.getUserId());
		orderLog.setOfId(order.getId());
		orderFormLogService.save(orderLog);

		for (Evaluate evaluate : evaluates) {
			Goods goods = this.goodsService.getObjById(evaluate.getEvaluateGoodsId());
			StorePoint point = getByEvaluates(goods.getGoodsType(), goods.getGoodsStoreId(),
					order.getUserId(), false);
			// 更新店铺综合信息
			if (point.getId() != null && point.getId() > 0) {
				this.storePointService.update(point);
			} else {
				this.storePointService.save(point);
			}

			// 更新店铺信息
			if (goods.getGoodsType() == 1) {
				Store store = storeService.getObjById(goods.getGoodsStoreId());
				if (null == store.getStoreCredit())
					store.setStoreCredit(0);
				store.setStoreCredit(store.getStoreCredit() + evaluate.getEvaluateBuyerVal());
				storeService.save(store);
			}

			// 更新商品评价数量
			goods.setEvaluateCount(goods.getEvaluateCount() + 1);
			//更新商品评价数量
			goodsService.update(goods);
			// 保存评价
			save(evaluate);

			UserCustomer user = customerService.queryUserByUid(order.getUserId());
//			// 增加评价积分
//			user.setIntegral(user.getIntegral() + this.configService.getSysConfig().getIndentComment());
			// 增加用户消费金额
			user.setUserGoodsFee(BigDecimal.valueOf(CommUtil.add(user.getUserGoodsFee(),
					order.getTotalPrice())));
			customerDao.updateById(user);

			try {
				integralService.addIntegral(IntegralConstants.INTEGRAL_EVALUATE,
						evaluate.getEvaluateUserId(), null);
			} catch (Exception e) {
				logger.error("add integral is unsuccess userid=" + evaluate.getEvaluateUserId());
			}

//			if (configService.getSysConfig().getIntegral()) {
//				IntegralLog log = new IntegralLog();
//				log.setAddtime(new Date());
//				log.setContent("订单评价增加" + this.configService.getSysConfig().getIndentComment() + "分");
//				log.setIntegral(this.configService.getSysConfig().getIndentComment());
//				log.setIntegralUserId(user.getUid());
//				log.setType("order");
//				this.integralLogService.save(log);
//			}
		}

	}

	/**
	 * 修改单个评价
	 * 
	 * @param evaluate
	 *            by young
	 */
	@Transactional(readOnly = false)
	public void updateEvaluate(OrderFormBO order, Evaluate evaluate) {
		evaluate.setEvaluateBuyerVal(1);

		Goods goods = this.goodsService.getObjById(evaluate.getEvaluateGoodsId());

		StorePoint point = getByEvaluates(goods.getGoodsType(), goods.getGoodsStoreId(), order.getUserId(),
				false);
		// 更新店铺综合信息
		if (point.getId() != null && point.getId() > 0) {
			this.storePointService.update(point);
		} else {
			this.storePointService.save(point);
		}

		// 更新店铺信息
		if (goods.getGoodsType() == 1) {
			Store store = storeService.getObjById(goods.getGoodsStoreId());
			if (null == store.getStoreCredit())
				store.setStoreCredit(0);
			store.setStoreCredit(store.getStoreCredit() + evaluate.getEvaluateBuyerVal());
			storeService.save(store);
		}

		// 保存评价
		save(evaluate);
	}

	/**
	 * 追加评价
	 * 
	 * @param order
	 *            被评价订单
	 * @param evaluate
	 *            被修改的评价 by young
	 */
	@Transactional(readOnly = false)
	public void addAnother(OrderFormBO order, Evaluate evaluate) {
		OrderLog ofl = new OrderLog();
		ofl.setAddTime(new Date());
		ofl.setLogInfo("追加评价订单");
		ofl.setLogUserId(order.getUserId());
		ofl.setOfId(order.getId());
		orderFormLogService.save(ofl);

		evaluate.setAddevaStatus(1);
		evaluate.setAddevaTime(new Date());
		update(evaluate);
	}

	/**
	 * 计算店铺综合评分
	 * 
	 * @param goodsType
	 *            商品类型：自营和非自营
	 * @param storeId
	 *            店铺id
	 * @param userId
	 *            用户id
	 * @return by young
	 */
	private StorePoint getByEvaluates(int goodsType, Long storeId, Long userId, boolean isCancelEvaluate) {
		List<EvaluateBO> evaluates = new ArrayList<>();
		if (goodsType == 1) {// 经销商的商品
			if (isCancelEvaluate)
				evaluates = queryStatusLess2(storeId);
			else
				evaluates = queryByStoreId(storeId);
		} else {// 自营商品
			evaluates = queryByUserId(userId);
		}

		double store_evaluate = 0;
		double description_evaluate = 0;
		double description_evaluate_total = 0;
		double service_evaluate = 0;
		double service_evaluate_total = 0;
		double ship_evaluate = 0;
		double ship_evaluate_total = 0;
		DecimalFormat df = new DecimalFormat("0.0");
		for (Evaluate evaluate : evaluates) {
			description_evaluate_total = description_evaluate_total
					+ CommUtil.null2Double(evaluate.getDescriptionEvaluate());
			service_evaluate_total = service_evaluate_total
					+ CommUtil.null2Double(evaluate.getServiceEvaluate());
			ship_evaluate_total = ship_evaluate_total + CommUtil.null2Double(evaluate.getShipEvaluate());
		}
		description_evaluate = CommUtil.null2Double(df.format(description_evaluate_total / evaluates.size()));
		service_evaluate = CommUtil.null2Double(df.format(service_evaluate_total / evaluates.size()));
		ship_evaluate = CommUtil.null2Double(df.format(ship_evaluate_total / evaluates.size()));
		store_evaluate = CommUtil.null2Double(df
				.format((description_evaluate + service_evaluate + ship_evaluate) / 3));// 综合评分=三项具体评分之和/3

		StorePoint point = null;

		if (goodsType == 1) {// 经销商的商品
			point = storePointService.fetchByStoreId(storeId);
		} else {// 自营商品
			point = storePointService.fetchByUserId(userId);
		}
		if (null == point)
			point = new StorePoint();
		if (goodsType == 1) {// 经销商的商品
			point.setStoreId(storeId);
		} else {// 自营商品
			point.setUserId(userId);
		}
		point.setAddTime(new Date());
		point.setDescriptionEvaluate(BigDecimal.valueOf(description_evaluate > 5 ? 5 : description_evaluate));
		point.setServiceEvaluate(BigDecimal.valueOf(service_evaluate > 5 ? 5 : service_evaluate));
		point.setShipEvaluate(BigDecimal.valueOf(ship_evaluate > 5 ? 5 : ship_evaluate));
		point.setStoreEvaluate(BigDecimal.valueOf(store_evaluate > 5 ? 5 : store_evaluate));

		return point;
	}

	/**
	 * 取消订单评价
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = false)
	public boolean delete(Long id) {
		EvaluateBO evaluate = this.queryEvaluateById(id);
		OrderFormBO order = orderFormService.fetch(evaluate.getOfId());

		// 更新评价状态
		evaluate.setEvaluateStatus(2);
		update(evaluate);

		// 添加删除订单日志
		OrderLog ofl = new OrderLog();
		ofl.setAddTime(new Date());
		ofl.setLogInfo("删除评价");
		ofl.setLogUserId(order.getUserId());
		ofl.setOfId(order.getId());
		this.orderFormLogService.save(ofl);

		GoodsBO goods = goodsService.getGoodsBOById(evaluate.getEvaluateGoodsId());
		StorePoint point = getByEvaluates(goods.getGoodsType(), goods.getGoodsStoreId(), order.getUserId(),
				true);
		// 更新店铺综合信息
		if (point.getId() != null && point.getId() > 0) {
			this.storePointService.update(point);
		} else {
			this.storePointService.save(point);
		}

		// //更新店铺信息
		// if(goods.getGoodsType() == 1){
		// Store store =storeService.getObjById(goods.getGoodsStoreId());
		// store.setStoreCredit(store.getStoreCredit() +
		// evaluate.getEvaluateBuyerVal());
		// storeService.save(store);
		// }

		return true;
	}

	/**
	 * 删除订单评价
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = false)
	public boolean changDelStatus(Long id) {
		EvaluateBO evaluate = this.queryEvaluateById(id);
		evaluate.setDeleteStatus(1);
		this.evaluateDao.update(evaluate);

		return true;
	}

	public List<Evaluate> selectByExample(EvaluateExample queryExample) {
		return this.evaluateDao.selectByExample(queryExample);
	}

	// @Override
	// public List<Goods> query_goods(String query, Map params, int begin, int
	// max) {
	// // TODO Auto-generated method stub
	// return this.evaluateDao.query(query, params, begin, max);
	// }

	public void queryEvaluateList(String nickName, String goodsName, MyPage<EvaluateBO> page) {
		page.setContent(evaluateDao.queryEvaluateList(nickName, goodsName, page));
	}

	public EvaluateBO queryEvaluateById(Long evaId) {
		return evaluateDao.queryEvaluateById(evaId);
	}

	public List<EvaluateBO> queryByVO(EvaluateVO vo, MyPage<EvaluateBO> page) {
		return evaluateDao.queryByVO(vo, page);
	}

	public List<EvaluateBO> queryByUserId(Long userId) {
		return evaluateDao.queryByUserId(userId);
	}

	public Evaluate findOne(Long id) {
		return evaluateDao.findOne(id);
	}

	public Evaluate fetch(Long userId, Long goodsId) {
		return evaluateDao.fetch(userId, goodsId);
	}

	@Transactional(readOnly = false)
	public void update(Evaluate evaluate) {
		evaluateDao.update(evaluate);
	}

	public void queryEvaluateListByVO(EvaluateVO vo, MyPage<EvaluateBO> page) {
		evaluateDao.queryEvaluateListByVO(vo, page);
	}

	public void queryEvaluateGoods(Integer replyStatus, Integer goodsType, MyPage<EvaluateBO> page) {
		page.setContent(evaluateDao.queryEvaluateGoods(replyStatus, goodsType, page));
	}

	public Evaluate queryEvaluateId(Long id) {
		return evaluateDao.findOne(id);
	}

	@Transactional(readOnly = false)
	public void save(Evaluate t) {
		String evaluatePhotos = t.getEvaluatePhotos();
		String[] imgs = CommUtil.null2String(evaluatePhotos).split(";");

		if (null != imgs && imgs.length > 4) {
			String photos = "";
			for (int i = 0; i < imgs.length; i++) {
				String string = imgs[i];
				if (i < 4) {
					photos += string;
				} else {
					break;
				}
			}
			t.setEvaluatePhotos(photos);
		} else
			t.setEvaluatePhotos(evaluatePhotos);

		evaluateDao.save(t);
	}

	public List<EvaluateBO> queryStatusLess2(Long storeId) {
		return evaluateDao.queryStatusLess2(storeId);
	}

	public List<EvaluateBO> queryByStoreId(Long storeId) {
		return evaluateDao.queryByStoreId(storeId);
	}

	public void findListByVo(MyPage<EvaluateBO> page, EvaluateVO vo) {
		this.evaluateDao.findListByVo(page, vo);
	}

	public void queryEvaultePageList(Long userId, MyPage<EvaluateBO> page) {
		page.setContent(evaluateDao.queryEvaultePageList(userId, page));
	}

	public void queryEvaultePageListByVal(Long userId, String evaluateBuyerVal, MyPage<EvaluateBO> page) {
		page.setContent(evaluateDao.queryEvaultePageListByVal(userId, evaluateBuyerVal, page));
	}

	public Evaluate fetch(Long userId, Long goodsId, Long ofId) {
		return evaluateDao.fetch(userId, goodsId, ofId);
	}
}
