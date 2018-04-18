package com.sinco.carnation.goods.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.goods.GoodsConstants;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.bo.ReturnGoodsLogBO;
import com.sinco.carnation.goods.dao.ReturnGoodsLogDao;
import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.goods.model.ReturnGoodsLog;
import com.sinco.carnation.goods.vo.ReturnGoodsLogVO;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.shop.dao.ExpressCompanyDao;
import com.sinco.carnation.shop.model.ExpressCompany;
import com.sinco.carnation.shop.model.OrderForm;
import com.sinco.carnation.sys.model.Message;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.service.MessageService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.dal.common.MyPage;

import vc.thinker.b2b2c.core.tools.CommUtil;

@Service
@Transactional(rollbackFor = ServiceException.class)
public class ReturnGoodsLogService {
	@Autowired
	private ReturnGoodsLogDao returnGoodsLogDao;

	@Autowired
	private OrderFormService orderFormService;

	@Autowired
	private OrderFormTools orderFormTools;

	@Autowired
	private MessageService messageService;

	@Autowired
	private ExpressCompanyDao expressCompayDao;

	@Autowired
	private UserService userService;

	/**
	 * 保存用户退货的物流信息
	 * 
	 * @param id
	 * @param expressId
	 * @param expressCode
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	public ReturnGoodsLog saveUserReturnExpress(Long id, Long uid, Long expressId, String expressCode)
			throws ServiceException {
		ReturnGoodsLog obj = getObjById(id);
		String goodsGspIds = obj.getGoodsGspIds();

		if (!obj.getUserId().equals(uid)) {
			throw new ServiceException("您没有为" + obj.getReturnServiceId() + "的退货服务号！");
		}

		ExpressCompany ec = expressCompayDao.get(CommUtil.null2Long(expressId));

		Map json_map = new HashMap();
		json_map.put("express_company_id", ec.getId());
		json_map.put("express_company_name", ec.getCompanyName());
		json_map.put("express_company_mark", ec.getCompanyMark());
		json_map.put("express_company_type", ec.getCompanyType());
		String express_json = Json.toJson(json_map);
		obj.setReturnExpressInfo(express_json);
		obj.setExpressCode(expressCode);
		obj.setGoodsReturnStatus(GoodsConstants.GOODS_RETURN_STATUS_7);
		update(obj);

		OrderForm return_of = orderFormService.getObjById(obj.getReturnOrderId());
		List<Map> maps = orderFormTools.queryGoodsInfo(return_of.getGoodsInfo());
		List<Map> new_maps = new ArrayList<Map>();
//		Map gls = new HashMap();
		for (Map m : maps) {
			if (StringUtils.isNotBlank(goodsGspIds)) {
				if (CommUtil.null2Long(m.get("goods_id")).equals(obj.getGoodsId())
						&& (goodsGspIds.equals(m.get("goods_gsp_ids").toString()))) {
					m.put("goods_return_status", GoodsConstants.GOODS_RETURN_STATUS_7);
//					gls.putAll(m);
				}
			} else {
				if (CommUtil.null2Long(m.get("goods_id")).equals(obj.getGoodsId())) {
					m.put("goods_return_status", GoodsConstants.GOODS_RETURN_STATUS_7);
//					gls.putAll(m);
				}
			}
			new_maps.add(m);
		}
		OrderForm updateOrderForm = new OrderForm();
		updateOrderForm.setId(return_of.getId());
		updateOrderForm.setGoodsInfo(Json.toJson(new_maps));
		this.orderFormService.update(updateOrderForm);

		return obj;
	}

	public int selectCountByStatus(Long storeId, String goodsReturnStatus) {
		return returnGoodsLogDao.selectCountByStatus(storeId, goodsReturnStatus);
	}

	@Transactional(readOnly = false)
	public void save(ReturnGoodsLog returnGoodsLog) {
		returnGoodsLogDao.save(returnGoodsLog);
	}

	public ReturnGoodsLogBO findBOById(Long id) {
		return returnGoodsLogDao.findBOById(id);
	}

	public ReturnGoodsLog getObjById(Long id) {
		ReturnGoodsLog returnGoodsLog = this.returnGoodsLogDao.get(id);
		if (returnGoodsLog != null) {
			return returnGoodsLog;
		}
		return null;
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		returnGoodsLogDao.remove(id);
	}

	/**
	 * 取消退货
	 * 
	 * @param vo
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings({"unused", "rawtypes", "unchecked"})
	public int cancelReturnGoods(Long orderId, Long goodsId, String goodsGspIds, Long userId)
			throws ServiceException {

		OrderForm obj = orderFormService.getObjById(orderId);

		if (!obj.getUserId().equals(userId)) {
			throw new ServiceException("该订单不属于您！");
		}

		List<GoodsBO> goods_list = orderFormTools.queryOfGoods(obj.getId().toString());
		Goods goods = null;
		for (Goods g : goods_list) {
			if (g.getId().equals(goodsId)) {
				goods = g;
			}
		}

		OrderForm updateObj = new OrderForm();
		updateObj.setId(obj.getId());
		updateObj.setReturnGoodsInfo("");

		List<Map> maps = orderFormTools.queryGoodsInfo(obj.getGoodsInfo());
//		Map gls = new HashMap();
		for (Map m : maps) {
			if (StringUtils.isNotBlank(goodsGspIds)) {
				if (CommUtil.null2Long(m.get("goods_id")).equals(goodsId)
						&& (goodsGspIds.equals(m.get("goods_gsp_ids").toString()))) {
					m.put("goods_return_status", "");
//					gls.putAll(m);
				}
			} else {
				if (CommUtil.null2Long(m.get("goods_id")).equals(goodsId)) {
					m.put("goods_return_status", "");
//					gls.putAll(m);
				}
			}
		}
		updateObj.setGoodsInfo(Json.toJson(maps, JsonFormat.compact()));
		orderFormService.update(updateObj);

		ReturnGoodsLogVO param = new ReturnGoodsLogVO();
		param.setGoodsId(goodsId.toString());
		param.setReturnOrderId(orderId);
		param.setGoodsGspIds(goodsGspIds);
		param.setUserId(userId);

		return returnGoodsLogDao.cancelReturnGoods(param);
	}

	@Transactional(readOnly = false)
	public void batchDelete(List<Serializable> returnGoodsLogIds) {
		for (Serializable id : returnGoodsLogIds) {
			delete((Long) id);
		}
	}

	@SuppressWarnings("rawtypes")
	public List<ReturnGoodsLogBO> search(ReturnGoodsLogVO vo, MyPage<Map> page) {
		return returnGoodsLogDao.search(vo, page);
	}

	@Transactional(readOnly = false)
	public void update(ReturnGoodsLog returnGoodsLog) {
		returnGoodsLogDao.update(returnGoodsLog);
	}

	public void queryReturnGoodsLogPageList(String userName, String goodsName, String returnServiceId,
			String status, MyPage<ReturnGoodsLog> page) {
		page.setContent(returnGoodsLogDao.queryReturnGoodsLogPageList(userName, goodsName, returnServiceId,
				status, page));
	}

	@SuppressWarnings("rawtypes")
	public List<ReturnGoodsLogBO> selectByUser(Long userId, MyPage<Map> page) {
		return returnGoodsLogDao.selectByUser(userId, page);
	}

	/**
	 * 商户退货审核
	 * 
	 * @param id
	 * @param goodsReturnStatus
	 * @param selfAddress
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	@Transactional(readOnly = false)
	public void sellerReturnCheckSave(String id, String goodsReturnStatus, String selfAddress, Long uid,
			String goodsGspIds) {
		if (StringUtils.isNotBlank(id)) {
			ReturnGoodsLog obj = this.getObjById(Long.parseLong(id));
			obj.setGoodsReturnStatus(goodsReturnStatus);
			obj.setSelfAddress(selfAddress);
			this.update(obj);
			User user = userService.getObjById(obj.getUserId());
			String msg_content = "订单号：" + obj.getReturnServiceId() + "退货申请审核未通过。";
			if (goodsReturnStatus.equals(GoodsConstants.GOODS_RETURN_STATUS_6)) {
				msg_content = "订单号：" + obj.getReturnServiceId() + "退货申请审核通过，请在'退货/退款'-'查看返修/退换记录'中提交退货物流信息。";

				OrderForm return_of = orderFormService.getObjById(obj.getReturnOrderId());
				List<Map> maps = orderFormTools.queryGoodsInfo(return_of.getGoodsInfo());
				List<Map> new_maps = new ArrayList<Map>();
//				Map gls = new HashMap();
				for (Map m : maps) {
					if (StringUtils.isNotBlank(goodsGspIds)) {
						if (CommUtil.null2Long(m.get("goods_id")).equals(obj.getGoodsId())
								&& (goodsGspIds.equals(m.get("goods_gsp_ids").toString()))) {
							m.put("goods_return_status", GoodsConstants.GOODS_RETURN_STATUS_6);
//							gls.putAll(m);
						}
					} else {
						if (CommUtil.null2Long(m.get("goods_id")).equals(obj.getGoodsId())) {
							m.put("goods_return_status", GoodsConstants.GOODS_RETURN_STATUS_6);
//							gls.putAll(m);
						}
					}
					new_maps.add(m);
				}
				return_of.setGoodsInfo(Json.toJson(new_maps));
				this.orderFormService.update(return_of);
			}
			// 发送系统站内信
			Message msg = new Message();
			msg.setAddTime(new Date());
			msg.setStatus(0);
			msg.setType(0);
			msg.setContent(msg_content);
			msg.setFromUserId(uid);
			msg.setToUserId(user.getId());
			messageService.save(msg);
		}
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@Transactional(readOnly = false)
	public void selfReturnCheckSave(String id, String goodsReturnStatus, String selfAddress, Long uid,
			String goodsGspIds) {
		if (StringUtils.isNotBlank(id)) {
			ReturnGoodsLog obj = getObjById(Long.parseLong(id));
			obj.setGoodsReturnStatus(goodsReturnStatus);
			obj.setSelfAddress(selfAddress);
			update(obj);

			String msgContent = "退货申请审核未通过。";
			if (goodsReturnStatus.equals("6")) {
				msgContent = "退货申请审核通过，请在'退货/退款'-'查看返修/退换记录'中提交退货物流信息。";
				OrderForm returnOf = orderFormService.getObjById(obj.getReturnOrderId());
				List<Map> maps = orderFormTools.queryGoodsInfo(returnOf.getGoodsInfo());
				List<Map> new_maps = new ArrayList<Map>();
//				Map<String, Object> gls = new HashMap<String, Object>();
				for (Map<String, Object> m : maps) {
					if (StringUtils.isNotBlank(goodsGspIds)) {
						if (CommUtil.null2Long(m.get("goods_id")).equals(obj.getGoodsId())
								&& (goodsGspIds.equals(m.get("goods_gsp_ids").toString()))) {
							m.put("goods_return_status", 6);
//							gls.putAll(m);
						}
					} else {
						if (CommUtil.null2Long(m.get("goods_id")).equals(obj.getGoodsId())) {
							m.put("goods_return_status", 6);
//							gls.putAll(m);
						}
					}
					new_maps.add(m);
				}
				returnOf.setGoodsInfo(Json.toJson(new_maps));
				orderFormService.update(returnOf);
			}
			// 发送系统站内信
			Message msg = new Message();
			msg.setAddTime(new Date());
			msg.setStatus(0);
			msg.setType(0);
			msg.setContent(msgContent);
			msg.setFromUserId(uid);
			msg.setToUserId(obj.getUserId());
			messageService.save(msg);
		}
	}

	/**
	 * 商户确认收货
	 * 
	 * @param id
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	@Transactional(readOnly = false)
	public void sellerReturnConfirm(String id) {
		if (StringUtils.isNotBlank(id)) {
			ReturnGoodsLog obj = getObjById(Long.parseLong(id));
			String goodsGspIds = obj.getGoodsGspIds();
			obj.setGoodsReturnStatus(GoodsConstants.GOODS_RETURN_STATUS_10);
			this.update(obj);
			OrderForm return_of = orderFormService.getObjById(obj.getReturnOrderId());
			List<Map> maps = orderFormTools.queryGoodsInfo(return_of.getGoodsInfo());
			List<Map> new_maps = new ArrayList<Map>();
//			Map gls = new HashMap();
			for (Map m : maps) {
				if (StringUtils.isNotBlank(goodsGspIds)) {
					if (CommUtil.null2Long(m.get("goods_id")).equals(obj.getGoodsId())
							&& (goodsGspIds.equals(m.get("goods_gsp_ids").toString()))) {
						m.put("goods_return_status", 8);
//						gls.putAll(m);
					}
				} else {
					if (CommUtil.null2Long(m.get("goods_id")).equals(obj.getGoodsId())) {
						m.put("goods_return_status", 8);
//						gls.putAll(m);
					}
				}
				new_maps.add(m);
			}
			return_of.setGoodsInfo(Json.toJson(new_maps));
			orderFormService.update(return_of);
		}
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	@Transactional(readOnly = false)
	public void selfReturnConfirm(String id) {
		if (StringUtils.isNotBlank(id)) {
			ReturnGoodsLog obj = getObjById(CommUtil.null2Long(id));
			String goodsGspIds = obj.getGoodsGspIds();
			obj.setGoodsReturnStatus("10");
			update(obj);

			OrderForm returnOf = orderFormService.getObjById(obj.getReturnOrderId());
			List<Map> maps = orderFormTools.queryGoodsInfo(returnOf.getGoodsInfo());
			List<Map> new_maps = new ArrayList<Map>();
//			Map gls = new HashMap();
			for (Map m : maps) {
				if (StringUtils.isNotBlank(goodsGspIds)) {
					if (CommUtil.null2Long(m.get("goods_id")).equals(obj.getGoodsId())
							&& (goodsGspIds.equals(m.get("goods_gsp_ids").toString()))) {
						m.put("goods_return_status", 8);
//						gls.putAll(m);
					}
				} else {
					if (CommUtil.null2Long(m.get("goods_id")).equals(obj.getGoodsId())) {
						m.put("goods_return_status", 8);
//						gls.putAll(m);
					}
				}
				new_maps.add(m);
			}
			returnOf.setGoodsInfo(Json.toJson(new_maps));
			orderFormService.update(returnOf);
		}
	}

	public void findPageByVo(MyPage<ReturnGoodsLogBO> page, ReturnGoodsLogVO vo) {
		this.returnGoodsLogDao.findListByVo(page, vo);
	}

	public int selectReturningCountByOrderId(Long orderId) {
		List<String> status = new ArrayList<>();
		status.add(GoodsConstants.GOODS_RETURN_STATUS_1);
		status.add(GoodsConstants.GOODS_RETURN_STATUS_5);
		status.add(GoodsConstants.GOODS_RETURN_STATUS_6);
		status.add(GoodsConstants.GOODS_RETURN_STATUS_7);
		status.add(GoodsConstants.GOODS_RETURN_STATUS_10);
		return returnGoodsLogDao.selectCountByOrderIdAndStatus(orderId, status);
	}
}
