package com.sinco.carnation.integral.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.beans.BeanUtils;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.integral.tools.IntegralViewTools;
import com.sinco.carnation.shop.bo.IntegralGoodsBO;
import com.sinco.carnation.shop.bo.IntegralGoodsCartBO;
import com.sinco.carnation.shop.constants.IntegralGoodsOrderConstants;
import com.sinco.carnation.shop.dao.IntegralGoodsDao;
import com.sinco.carnation.shop.model.IntegralGoods;
import com.sinco.carnation.shop.model.IntegralGoodsCart;
import com.sinco.carnation.shop.model.IntegralGoodsOrder;
import com.sinco.carnation.shop.vo.IntegralGoodsVO;
import com.sinco.carnation.sys.constant.IntegralConstants;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.NoticeMessageService;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.dao.UserCustomerDao;
import com.sinco.carnation.user.model.Address;
import com.sinco.carnation.user.service.AddressService;
import com.sinco.carnation.user.service.IntegralLogService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.dal.common.MyPage;

@Service
@Transactional(rollbackFor = {Exception.class})
public class IntegralGoodsService {
	@Autowired
	private IntegralGoodsDao integralGoodsDao;
	@Autowired
	private AddressService addressService;
	@Autowired
	private AreaServiceImpl areaServiceImpl;
	@Autowired
	private IntegralGoodsOrderService integralGoodsOrderService;
	@Autowired
	private IntegralGoodsCartService integralGoodsCartService;
	@Autowired
	private UserCustomerDao userCustomerDao;
	@Autowired
	private IntegralLogService integralLogService;
	@Autowired
	private UserCustomerService userCustomerService;
	@Autowired
	private IntegralViewTools integralViewTools;

	@Autowired
	private NoticeMessageService noticeMessageService;

	private static final Logger logger = LoggerFactory.getLogger(IntegralGoodsService.class);

	public boolean save(IntegralGoods integralGoods) {
		/**
		 * init other field here
		 */
		try {
			this.integralGoodsDao.save(integralGoods);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("rawtypes")
	public List<Map> searchA(boolean recommend, boolean show) {
		return integralGoodsDao.searchA(recommend, show);
	}

	@SuppressWarnings("rawtypes")
	public List<Map> searchB(boolean recommend, boolean show, int begin) {
		return integralGoodsDao.searchB(recommend, show, begin);
	}

	@SuppressWarnings("rawtypes")
	public List<Map> searchC(boolean recommend, boolean show, int begin, int end) {
		return integralGoodsDao.searchC(recommend, show, begin, end);
	}

	@SuppressWarnings("rawtypes")
	public List<Map> selectForDesc() {
		return integralGoodsDao.selectForDesc();
	}

	@SuppressWarnings("rawtypes")
	public List<Map> selectForList(String orderType, String rang_begin, String rang_end, MyPage<Map> page) {
		List<Map> list = integralGoodsDao.selectForList(orderType, rang_begin, rang_end, page);
		page.setContent(list);

		return list;
	}

	public List<IntegralGoodsBO> selectForListBean(String orderType, String rang_begin, String rang_end,
			MyPage<IntegralGoodsBO> page) {
		return integralGoodsDao.selectForListBean(orderType, rang_begin, rang_end, page);
	}

	public IntegralGoods getObjById(Long id) {
		IntegralGoods integralGoods = this.integralGoodsDao.get(id);
		if (integralGoods != null) {
			return integralGoods;
		}
		return null;
	}

	/**
	 * 处理待兑换的商品（单个）
	 * 
	 * @param id
	 * @param exchange_count
	 * @param userId
	 * @return
	 */
	public Object[] singleGoods(String id, int exchange_count, long userId) {
		IntegralGoods obj = getObjById(CommUtil.null2Long(id));
		UserCustomerBO user = null;
		int exchange_status = 0;// -1为数量不足，-2为限制兑换，-3为积分不足，-4为兑换时间已过,-5为会员等级不够，-6为库存不足 0为正常兑换
		if (obj != null) {

			// add by yuleijia on 2017.4.13
			Integer igGoodsCount = obj.getIgGoodsCount();
			if (igGoodsCount != null && igGoodsCount <= 0) {
				exchange_status = -6;
			}

			if (obj.getIgGoodsCount() < exchange_count) {
				exchange_status = -1;
			}

			if (obj.getIgLimitType() && obj.getIgLimitCount() < exchange_count) {
				exchange_status = -2;
			}

			int cart_total_integral = obj.getIgGoodsIntegral() * exchange_count;
			user = userCustomerService.queryUserByUid(userId); // 获取用户积分
			if (user.getIntegral() < cart_total_integral) {
				exchange_status = -3;
			}

			if (obj.getIgTimeType()) {
				if (obj.getIgBeginTime() != null && obj.getIgEndTime() != null) {
					if ((obj.getIgBeginTime().after(new Date()) || obj.getIgEndTime().before(new Date()))) {
						exchange_status = -4;
					}
				}
			}

			if (integralViewTools.query_user_level(CommUtil.null2String(user.getUid())) < obj
					.getIgUserLevel()) {
				exchange_status = -5;
			}
		}

		return new Object[] {exchange_status, obj, user};
	}

	public Object[] computeOrder(String goodsJson, Long userId) {
		JSONArray array = JSON.parseArray(goodsJson);
		int integralCount = 0;
		double transFeeCount = 0;
		for (Object o : array) {
			JSONObject jo = (JSONObject) o;
			Integer count = jo.getInteger("count");
			Long goodsId = jo.getLong("goodsId");
			IntegralGoodsBO goods = integralGoodsDao.get(goodsId);
			if (goods != null) {
				integralCount += goods.getIgGoodsIntegral() * count;
				transFeeCount += goods.getIgTransfee().doubleValue();
			}
			// transFeeCount += goods.getIgTransfee().doubleValue();
		}
		return new Object[] {userCustomerDao.findById(userId).getIntegral(), integralCount, transFeeCount};
	}

	public synchronized  int exchangeApp(String goodsJson, Address addr, String igoMsg, Long userId,
			IntegralGoodsOrder order) throws ServiceException {
		List<IntegralGoodsCartBO> igcs = new ArrayList<>();
		JSONArray array = JSON.parseArray(goodsJson);
		for (Object o : array) {
			JSONObject jo = (JSONObject) o;
			Integer count = jo.getInteger("count");
			Long goodsId = jo.getLong("goodsId");
			IntegralGoodsBO integralGoodsBO = this.integralGoodsDao.get(goodsId);
			if (integralGoodsBO != null && integralGoodsBO.getIgGoodsCount() <= 0) {
				throw new ServiceException("501", "存在库存数量不足，无法进行兑换");
			}
			
			IntegralGoodsBO goods = integralGoodsDao.get(goodsId);
			IntegralGoodsCartBO cart = new IntegralGoodsCartBO();
			cart.setIntegralGoods(goods);
			cart.setCount(count);
			cart.setIntegral(goods.getIgGoodsIntegral() * count);
			cart.setTransFee(goods.getIgTransfee());
			cart.setGoodsId(goodsId);
			igcs.add(cart);
		}

		return exchange(igcs, addr.getId() == null ? "new" : addr.getId().toString(), addr, igoMsg, userId,
				order);
	}

	/**
	 * 积分兑换商品
	 * 
	 * @param igcs
	 * @param addr_id
	 * @param addr
	 * @param igo_msg
	 * @param userId
	 * @param order
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	public synchronized int exchange(List<IntegralGoodsCartBO> igcs, String addr_id, Address addr, String igo_msg,
			long userId, IntegralGoodsOrder order) throws ServiceException {
		int result;
		int total_integral = 0; // 所需积分总和
		double trans_fee = 0; // 所需运费总和
		for (IntegralGoodsCart igc : igcs) {
			total_integral += igc.getIntegral();
			trans_fee += CommUtil.null2Double(igc.getTransFee());
		}

		if (igcs == null || igcs.size() <= 0) {
			throw new ServiceException("501", "下单失败，您没有选择兑换的商品！");
		}

		// 获取收货地址 并且验证收货地址
		if (addr_id.equals("new")) {
			if (StringUtils.isBlank(addr.getAreaInfo()) || StringUtils.isBlank(addr.getTrueName())
					|| null == addr.getAreaId() || (StringUtils.isBlank(addr.getMobile()) && StringUtils.isBlank(addr.getTelephone()))) {
				throw new ServiceException("501", "下单失败，收货信息不完善！");
			}
			addressService.save(addr);
		} else {
			addr = addressService.getObjById(CommUtil.null2Long(addr_id));
			if (StringUtils.isBlank(addr.getAreaInfo()) || StringUtils.isBlank(addr.getTrueName())
					|| null == addr.getAreaId() || (StringUtils.isBlank(addr.getMobile()) && StringUtils.isBlank(addr.getTelephone()))) {
				throw new ServiceException("501", "下单失败，收货信息不完善！");
			}
		}

		order.setReceiverArea(areaServiceImpl.fullName(CommUtil.null2Long(addr.getAreaId()))); // 收货地址全称
		order.setAddTime(new Date());
		order.setReceiverName(addr.getTrueName()); // 设置收货地址信息
		order.setReceiverAreaInfo(addr.getAreaInfo());
		order.setReceiverMobile(addr.getMobile());
		order.setReceiverTelephone(addr.getTelephone());
		order.setReceiverZip(addr.getZip());
		List<Map> json_list = new ArrayList<Map>();
		for (IntegralGoodsCartBO gc : igcs) {
			if (gc.getCount() <= 0) {
				throw new ServiceException("501", "兑换数量不能为0，无法进行兑换");
			}
			IntegralGoods goods = getObjById(gc.getIntegralGoods().getId());
			if (null == goods) {
				throw new ServiceException("501", "商品信息异常，无法进行兑换");
			}
			if (goods.getIgGoodsCount() <= 0 || goods.getIgGoodsCount()-gc.getCount()<
					0) {
				throw new ServiceException("501", "库存数量不足，无法进行兑换");
			}
			logger.debug("积分商品库存 还剩下------>{}", goods.getIgGoodsCount());
			
		
			
			
			goods.setIgGoodsCount(goods.getIgGoodsCount() - gc.getCount());
			goods.setIgExchangeCount(goods.getIgExchangeCount() + gc.getCount());
			update(goods);

			IntegralGoods ig = gc.getIntegralGoods();
			Map json_map = new HashMap();
			json_map.put("id", gc.getGoodsId());
			json_map.put("ig_goods_name", ig.getIgGoodsName());
			json_map.put("ig_goods_price", ig.getIgGoodsPrice());
			json_map.put("ig_goods_count", gc.getCount());
			json_map.put("ig_goods_integral", CommUtil.mul(ig.getIgGoodsIntegral(), gc.getCount()));
			json_map.put("ig_goods_tran_fee", ig.getIgTransfee());
			json_map.put("ig_goods_img", ig.getIgGoodsImg());
			json_list.add(json_map);
		}
		String json = Json.toJson(json_list, JsonFormat.compact());
		order.setGoodsInfo(json); // 商品信息json
		order.setIgoMsg(igo_msg);
		order.setIgoOrderSn("igo" + CommUtil.formatTime("yyyyMMddHHmmss", new Date()) + userId);
		order.setIgoUserId(userId);
		order.setIgoTransFee(BigDecimal.valueOf(trans_fee));
		order.setIgoTotalIntegral(total_integral);

		if (trans_fee == 0) {
			order.setIgoStatus(IntegralGoodsOrderConstants.IGO_STATUS_HAVE_PAYED); // 无运费订单，默认状态为已付款
			order.setIgoPayTime(new Date());
			order.setIgoPayment("no_fee");
			integralGoodsOrderService.save(order);
			/*			for (IntegralGoodsCartBO igc : igcs) {
							IntegralGoods goods = getObjById(igc.getIntegralGoods().getId());
							goods.setIgGoodsCount(goods.getIgGoodsCount() - igc.getCount());
							goods.setIgExchangeCount(goods.getIgExchangeCount() + igc.getCount());
							update(goods);
							IntegralGoods ig = getObjById(goods.getId());
							if (ig.getIgGoodsCount() < 0)
								throw new ServiceException("501", "库存数量不足，无法进行兑换");
						}*/
			result = 1;
		} else {
			order.setIgoStatus(IntegralGoodsOrderConstants.IGO_STATUS_NO_PAY); // 有运费订单，默认状态为未付款
			integralGoodsOrderService.save(order);

			result = 2;
		}

		// XXX 删除积分商城兑换购物车里的物品（似乎可以删掉此代码，因为购物车的商品并没有保存到数据库）
		for (IntegralGoodsCart igc : igcs) {
			integralGoodsCartService.delete(igc.getId());
		}

		// 记录日志
		UserCustomerBO userBO = userCustomerDao.findSessionUser(userId);
		
		userCustomerDao.subtractIntegral(userId, order.getIgoTotalIntegral()); // 用户积分减少
		if (userCustomerDao.findById(userId).getIntegral() < 0)
			throw new ServiceException("500", "你的积分不足，无法进行兑换");
		
		integralLogService.saveLog("兑换商品消耗积分", userId, null,
				-order.getIgoTotalIntegral(), userBO.getIntegral(), IntegralConstants.INTEGRAL_ORDER);
		//个人端除春雨医生推送消息，其它都关闭2017-05-26 tw
		/*try {
			// 更新消息推送日志
			NoticeMessage noticeMesg = new NoticeMessage();
			noticeMesg.setUid(userId);
			noticeMesg.setCreateTime(new Date());
			noticeMesg.setNotcieLogAmount(new BigDecimal(order.getIgoTotalIntegral()));
			String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			String message = "您于" + date + "消费" + order.getIgoTotalIntegral() + "积分";
			noticeMesg.setNoticeMessage(message);
			noticeMesg.setPushType("integral");

			noticeMessageService.save(noticeMesg);
			noticeMessageService.pushMessage(noticeMesg);
			logger.info("=======积分消息推送=========");
		} catch (Exception e) {
			logger.error("消息日志推送失败" + e.getStackTrace());
		}*/

		return result;
	}

	@SuppressWarnings("rawtypes")
	public Map selectByKeyForMap(Long id) {
		return integralGoodsDao.selectByKeyForMap(id);
	}

	public boolean delete(Long id) {
		try {
			this.integralGoodsDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> integralGoodsIds) {
		for (Serializable id : integralGoodsIds) {
			delete((Long) id);
		}
		return true;
	}

	public boolean update(IntegralGoods integralGoods) {
		try {
			this.integralGoodsDao.update(integralGoods);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(IntegralGoodsVO integralGoods) {
		try {
			if (integralGoods != null) {
				IntegralGoods goods = new IntegralGoods();
				BeanUtils.copyProperties(integralGoods, goods);
				if (goods.getIgTransfeeType() != null && goods.getIgTransfeeType() == 0)
					goods.setIgTransfee(new BigDecimal("0.00"));
				integralGoodsDao.update(goods);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean save(IntegralGoodsVO integralGoods) {
		if (integralGoods != null) {
			IntegralGoods goods = new IntegralGoods();
			BeanUtils.copyProperties(integralGoods, goods);
			if (goods.getIgTransfeeType() != null && goods.getIgTransfeeType() == 0)
				goods.setIgTransfee(new BigDecimal("0.00"));
			integralGoodsDao.save(goods);
			return true;
		} else {
			return false;
		}
	}

	public void findPageByVo(MyPage<IntegralGoodsBO> page, IntegralGoodsVO vo) {
		List<IntegralGoodsBO> content = integralGoodsDao.findListByVo(page, vo);
		page.setContent(content);
	}

	public List<IntegralGoodsBO> queryIntegralGoodsCountList(Long[] goodIds) {
		return integralGoodsDao.queryIntegralGoodsCountList(goodIds);
	}

	public List<IntegralGoodsBO> selectListByCriteria(String orderType, String rang_begin, String rang_end,
			MyPage<IntegralGoodsBO> page) {
		return integralGoodsDao.selectListByCriteria(orderType, rang_begin, rang_end, page);
	}

}
