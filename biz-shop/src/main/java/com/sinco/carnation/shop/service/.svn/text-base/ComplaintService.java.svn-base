package com.sinco.carnation.shop.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.shop.bo.ComplaintBO;
import com.sinco.carnation.shop.dao.ComplaintDao;
import com.sinco.carnation.shop.model.Complaint;
import com.sinco.carnation.shop.model.ComplaintGoods;
import com.sinco.carnation.shop.model.ComplaintSubject;
import com.sinco.carnation.shop.model.OrderForm;
import com.sinco.carnation.shop.vo.ComplaintVO;
import com.sinco.carnation.sys.model.SysConfig;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class ComplaintService {
	@Autowired
	private ComplaintDao complaintDao;
	@Autowired
	OrderFormService orderFormService;
	@Autowired
	OrderFormTools orderFormTools;
	@Autowired
	ComplaintSubjectService complaintSubjectService;
	@Autowired
	GoodsService goodsService;
	@Autowired
	AccessoryServiceImpl accessoryService;
	@Autowired
	ComplaintGoodsService complaintGoodsService;

	@Autowired
	private SysConfigService configService;

	public int findCountByStatusAndToUserId(Integer status, Long toUserId) {
		return complaintDao.findCountByStatusAndToUserId(status, toUserId);
	}

	@Transactional(readOnly = false)
	public void save(Complaint complaint) {
		complaintDao.save(complaint);
	}

	public ComplaintBO getObjById(Long id) {
		ComplaintBO complaint = complaintDao.get(id);
		if (complaint != null) {
			return complaint;
		}

		return null;
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		complaintDao.remove(id);
	}

	@Transactional(readOnly = false)
	public void batchDelete(List<Serializable> complaintIds) {
		for (Serializable id : complaintIds) {
			delete((Long) id);
		}
	}

	public List<ComplaintBO> selectByUser(Long fromUserId, String status, MyPage<ComplaintBO> page) {
		return complaintDao.selectByUser(fromUserId, status, page);
	}

	@Transactional(readOnly = false)
	public void update(Complaint complaint) {
		complaintDao.update(complaint);
	}

	/**
	 * 保存投诉操作
	 * 
	 * @param request
	 * @param order_id
	 * @param cs_id
	 * @param from_user_content
	 * @param goods_ids
	 * @param to_user_id
	 * @param type
	 * @param goods_gsp_ids
	 * @param currUserId
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	@Transactional(rollbackFor = {Exception.class})
	public void saveComplaint(HttpServletRequest request, String order_id, String cs_id,
			String from_user_content, String goods_ids, String to_user_id, String type, String goods_gsp_ids,
			long currUserId) {
		OrderForm of = orderFormService.getObjById(CommUtil.null2Long(order_id));
		List<Map> maps = orderFormTools.queryGoodsInfo(of.getGoodsInfo());
		List<Map> new_maps = new ArrayList<Map>();
		Map gls = new HashMap();
		for (Map m : maps) {
			if (m.get("goods_id").toString().equals(goods_ids)
					&& goods_gsp_ids.equals(m.get("goods_gsp_ids").toString())) {
				m.put("goods_complaint_status", 1);
				gls.putAll(m);
			}
			new_maps.add(m);
		}
		of.setGoodsInfo(Json.toJson(new_maps));
		orderFormService.update(of);
		Complaint obj = new Complaint();
		obj.setAddTime(new Date());
		ComplaintSubject cs = complaintSubjectService.getObjById(CommUtil.null2Long(cs_id));
		obj.setCsId(cs.getId());
		obj.setFromUserContent(from_user_content);
		obj.setFromUserId(currUserId);
		if (of.getOrderForm() == 0)
			obj.setToUserId(CommUtil.null2Long(to_user_id));
		obj.setType(type);
		obj.setOfId(of.getId());
		Goods goods = goodsService.getObjById(CommUtil.null2Long(goods_ids));
		ComplaintGoods cg = new ComplaintGoods();
		cg.setAddTime(new Date());
		cg.setComplaintId(obj.getId());
		cg.setGoodsId(goods.getId());
		cg.setContent(CommUtil.null2String(request.getParameter("content_" + goods_ids)));

		// 处理投诉人上传的图片
		String img1Path = accessoryService.upload(request, "img1", null);
		obj.setFromAcc1(img1Path);
		String img2Path = accessoryService.upload(request, "img2", null);
		obj.setFromAcc2(img2Path);
		String img3Path = accessoryService.upload(request, "img3", null);
		obj.setFromAcc3(img3Path);

		if (of.getOrderForm() == 0)
			obj.setStatus(0);
		else
			obj.setStatus(2);

		save(obj);
		cg.setComplaintId(obj.getId());
		complaintGoodsService.save(cg);
	}

	public void queryComplaintPageList(String status, String title, String formName, String beginTime,
			String endTime, MyPage<ComplaintBO> page) {
		if (CommUtil.null2String(status).equals("") || CommUtil.null2String(status).equals("new")) {
			status = "0";
		}
		if (CommUtil.null2String(status).equals("complain")) {
			status = "1";
		}
		if (CommUtil.null2String(status).equals("talk")) {
			status = "2";
		}
		if (CommUtil.null2String(status).equals("arbitrate")) {
			status = "3";
		}
		if (CommUtil.null2String(status).equals("close")) {
			status = "4";
		}
		page.setContent(complaintDao
				.queryComplaintPageList(status, title, formName, beginTime, endTime, page));
	}

	public void queryComplaintPageListSelf(String status, String title, String formName, String beginTime,
			String endTime, MyPage<ComplaintBO> page) {
		if (CommUtil.null2String(status).equals("") || CommUtil.null2String(status).equals("new")) {
			status = "0";
		}
		if (CommUtil.null2String(status).equals("complain")) {
			status = "1";
		}
		if (CommUtil.null2String(status).equals("talk")) {
			status = "2";
		}
		if (CommUtil.null2String(status).equals("arbitrate")) {
			status = "3";
		}
		if (CommUtil.null2String(status).equals("close")) {
			status = "4";
		}
		page.setContent(complaintDao.queryComplaintPageListSelf(status, title, formName, beginTime, endTime,
				page));
	}

	public ComplaintBO queryComplaintById(Long comId) {
		return complaintDao.queryComplaintById(comId);
	}

	@Transactional(readOnly = false)
	public void updateComplaintHandleClose(Long uid, String id, String handleContent) {
		if (StringUtils.isNotBlank(id)) {
			Complaint obj = this.getObjById(CommUtil.null2Long(id));
			obj.setStatus(4);
			obj.setHandleContent(handleContent);
			obj.setHandleTime(new Date());
			obj.setHandleUserId(uid);
			this.update(obj);
		}
	}

	@Transactional(readOnly = false)
	public void updateComplaintClose(String id, String handleContent) {
		if (StringUtils.isNotBlank(id)) {
			Complaint obj = this.getObjById(CommUtil.null2Long(id));
			obj.setStatus(4);
			obj.setHandleContent(handleContent);
			obj.setHandleTime(new Date());
			this.update(obj);
		}
	}

	@Transactional(readOnly = false)
	public void saveComplaintSet(String id, SysConfig config) {
		if (StringUtils.isNotBlank(id))
			configService.update(config);
		else
			configService.save(config);
	}

	public void querySelfComplaintPageList(String status, String title, String formName, String beginTime,
			String endTime, MyPage<ComplaintBO> page) {
		if (CommUtil.null2String(status).equals("") || CommUtil.null2String(status).equals("new")) {
			status = "0";
		}
		if (CommUtil.null2String(status).equals("complain")) {
			status = "1";
		}
		if (CommUtil.null2String(status).equals("talk")) {
			status = "2";
		}
		if (CommUtil.null2String(status).equals("arbitrate")) {
			status = "3";
		}
		if (CommUtil.null2String(status).equals("close")) {
			status = "4";
		}
		page.setContent(complaintDao.querySelfComplaintPageList(status, title, formName, beginTime, endTime,
				page));
	}

	public void findListByVO(MyPage<ComplaintBO> page, ComplaintVO vo) {
		this.complaintDao.findListByVO(page, vo);
	}

	public Map<Integer, Integer> findCountByToUserId(Long userId) {
		Map<Integer, Integer> resultMap = new HashMap<>();
		List<Map<String, Integer>> list = complaintDao.findCountByToUserId(userId);
		if (CollectionUtils.isNotEmpty(list)) {
			for (Map<String, Integer> map : list) {
				resultMap.put(CommUtil.null2Int(map.get("status")), CommUtil.null2Int(map.get("count")));
			}
		}
		return resultMap;
	}
}
