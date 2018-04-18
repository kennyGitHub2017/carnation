package com.sinco.carnation.o2o.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringEscapeUtils;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.o2o.bo.GroupComplaintBO;
import com.sinco.carnation.o2o.dao.GroupComplaintDao;
import com.sinco.carnation.o2o.model.GroupComplaint;
import com.sinco.carnation.o2o.vo.GroupComplaintVO;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.shop.dao.ComplaintDao;
import com.sinco.carnation.sys.dao.UserAccountDao;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.dao.UserCustomerDao;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.DicContent;

@Service
@Transactional
public class GroupComplaintService {
	@Autowired
	UserAccountDao userAccountDao;
	@Autowired
	UserCustomerDao userCustomerDao;
	@Autowired
	GroupComplaintDao groupComplaintDao;
	@Autowired
	private ComplaintDao complaintDao;
	@Autowired
	OrderFormService orderFormService;
	@Autowired
	OrderFormTools orderFormTools;
	@Autowired
	GoodsService goodsService;
	@Autowired
	AccessoryServiceImpl accessoryService;
	@Autowired
	private SysConfigService configService;
	@Autowired
	private DicContent dicContent;

	@Transactional(readOnly = false)
	public GroupComplaint save(GroupComplaint record) {
		return groupComplaintDao.save(record);
	}

	public GroupComplaintBO getObject(Long id) {
		return groupComplaintDao.get(id);
	}

	public void update(GroupComplaint record) {
		groupComplaintDao.update(record);
	}

	/**
	 * 投诉列表
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public List<GroupComplaintBO> search(GroupComplaintVO vo, MyPage<GroupComplaintBO> page) {
		List<GroupComplaintBO> list = groupComplaintDao.search(vo, page);
		for (GroupComplaintBO bo : list) {
			try {
				Integer createUserId = bo.getCreateUserId();
				UserAccount ua = userAccountDao.queryAccountByUid(createUserId.longValue());
				bo.setStoreMobile(ua.getLoginName());
			} catch (Exception e) {

			}
		}

		return list;
	}

	/**
	 * 添加投诉
	 * 
	 * @param request
	 * @param vo
	 * @param currUserId
	 */
	public void addComplaint(HttpServletRequest request, GroupComplaintVO vo, long currUserId) {
		GroupComplaint comp = new GroupComplaint();
		comp.setAddTime(new Date());
		comp.setAppealTime(new Date());
		comp.setFromUserContent(StringEscapeUtils.escapeHtml4(vo.getFromUserContent()));
		comp.setStatus(1);
		comp.setFromUserId(currUserId);
		comp.setOfId(vo.getOrderId());
		comp.setToUserId(vo.getStoreId());
		comp.setProblemDesc(StringEscapeUtils.escapeHtml4(vo.getProblemDesc()));
		String img1Path = accessoryService.upload(request, "img1", null);
		comp.setFromAcc1(img1Path);
		String img2Path = accessoryService.upload(request, "img2", null);
		comp.setFromAcc2(img2Path);
		String img3Path = accessoryService.upload(request, "img3", null);
		comp.setFromAcc3(img3Path);

		save(comp);
	}

	/**
	 * 我的运营商投诉列表
	 * 
	 * @param uid
	 * @param page
	 */
	public void groupComplaintList(int status, String name, Long uid, MyPage<GroupComplaintBO> page) {
		List<GroupComplaintBO> list = groupComplaintDao.groupComplaintList(status, name, uid, page);
		page.setContent(list);

	}

	/**
	 * 我的运营商投诉列表明细
	 * 
	 * @param id
	 * @param page
	 */
	public GroupComplaintBO groupComplaintDetails(Integer id) {
		// List<GroupComplaintBO> list =
		// groupComplaintDao.groupComplaintDetails(id);
		// return list;
		return groupComplaintDao.groupComplaintDetails(id);
	}

	// 查询运营商的投诉列表
	@SuppressWarnings("rawtypes")
	public List<GroupComplaintBO> searchOperatorList(GroupComplaintVO vo, MyPage<GroupComplaintBO> page) {
		List<GroupComplaintBO> list = groupComplaintDao.searchOperatorList(vo, page);
		for (GroupComplaintBO bo : list) {
			String json = bo.getGroupInfo();
			bo.setGroupInfo("");
			Map gJsonMap = Json.fromJson(Map.class, json);
			if (gJsonMap != null && gJsonMap.containsKey("goods_name")) {
				bo.setGroupInfo(CommUtil.null2String(gJsonMap.get("goods_name")));
			}
		}
		return list;
	}
}
