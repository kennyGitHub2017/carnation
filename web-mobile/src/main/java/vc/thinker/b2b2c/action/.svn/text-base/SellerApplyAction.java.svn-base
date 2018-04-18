package vc.thinker.b2b2c.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.common.collect.Maps;
import org.elasticsearch.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.o2o.bo.GroupClassBO;
import com.sinco.carnation.o2o.service.GroupClassService;
import com.sinco.carnation.store.bo.StoreApplyInfoBO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.constants.StoreConstants;
import com.sinco.carnation.store.service.StoreSearchService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.store.vo.StoreApplyVO;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.DocumentService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.dic.client.DicContent;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

/**
 * 
 * 
 * <p>
 * Title:SellerApplyAction.java
 * </p>
 * 
 * <p>
 * Description:商家入驻流程控制器，商城所有注册用户的都可以申请成为商家，需要完成相关申请流程，运营商审批通过后即可开通在线店铺入驻
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 深圳市新科聚合网络技术有限公司 www.thinker.vc
 * </p>
 * 
 * @author wyj、jy、erikzhang
 * 
 * @date 2014年4月25日
 * 
 * @version 1.0.1
 */
@Controller
public class SellerApplyAction {
	@SuppressWarnings("unused")
	private static final boolean GoodsClass = false;
	@Autowired
	private SysConfigService configService;
	@Autowired
	private AreaServiceImpl areaService;
	@Autowired
	private AccessoryServiceImpl accessoryService;
	@Autowired
	private UserService userService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private GroupClassService groupClassService;
	@Autowired
	private DocumentService documentService;
	@Autowired
	private DicContent dicContent;
	@Autowired
	private StoreSearchService searchService;

	@SecurityMapping(title = "服务商家入驻申请", value = "/seller_apply/group.htm*", rtype = "buyer", rname = "商家入驻", rcode = "group_seller_apply", rgroup = "商家入驻")
	@RequestMapping("/seller_apply/group.htm")
	public ModelAndView seller_apply(HttpServletRequest request, HttpServletResponse response, String step) {
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		StoreBO store = storeService.queryStoreStatus(user.getId(),true,false);

		if (store != null) {// 申请分为7步，走完第7步流程进入审核状态，就不允许继续修改资料了
			return toExistStore(request, response, store);
		} else {
			if (StringUtils.isNotBlank(step)) {
				if ("1".equals(step)) {
					return seller_apply_step1(request, response);
				}
			}
			return seller_apply_step0(request, response);
		}
	}

	@RequestMapping("/storeIndex/test/{id}")
	public void seller_apply(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("id") Long id) {
		searchService.updateIndex(id);
	}

	/**
	 * 转到已存在商户页面
	 * 
	 * @param request
	 * @param response
	 * @param store
	 * @return
	 */
	private ModelAndView toExistStore(HttpServletRequest request, HttpServletResponse response, StoreBO store) {
		// 是否已经完成审批，未完成查看审批进度
		return seller_store_query(request, response);
	}

	/**
	 * 商家入驻须知
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView seller_apply_step0(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("seller_apply/seller_apply_step0.html",
				configService.getSysConfig(), 1, request, response);
		mv.addObject("doc", this.documentService.findByMark("apply_agreement"));
		return mv;
	}

	/**
	 * 商户信息填写
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param currentPage
	 * @return
	 */
	private ModelAndView seller_apply_step1(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("seller_apply/seller_apply_step1.html",
				configService.getSysConfig(), 1, request, response);

		List<GroupClassBO> groupClassList = groupClassService.findCacheLevelAll();
		mv.addObject("groupClassList", groupClassList);

		List<Area> areas = areaService.getAllParentIsNull();
		mv.addObject("areas", areas);

		return mv;
	}

	/**
	 * 商户申请信息修改
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "商户信息填写", value = "/seller_apply/group/step1_update.htm*", rtype = "buyer", rname = "商家入驻", rcode = "group_seller_apply", rgroup = "商家入驻")
	@RequestMapping("/seller_apply/group/step1_update.htm")
	public ModelAndView seller_apply_step1_update(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("seller_apply/seller_apply_step1.html",
				configService.getSysConfig(), 1, request, response);

		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		StoreBO store = storeService.queryStoreStatus(user.getId(),true,false);
		if (store != null) {
			if (store.getStoreStatus() >= StoreConstants.STORE_STATUS_SHOP_AUDIT_SUCCESS) {
				mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", "您已经是商户!");
				mv.addObject("url", CommUtil.getURL(request) + "/seller/index.htm");
				return mv;
			} else if (store.getStoreStatus() == StoreConstants.STORE_STATUS_SHOP_OPREATE_AUDIT_FAIL
					|| store.getStoreStatus() == StoreConstants.STORE_STATUS_SYS_AUDIT_FAIL
					|| store.getStoreStatus() == StoreConstants.STORE_STATUS_OTHER_PAY_AUDIT_FAIL) {

				store = storeService.getObjById(store.getId());
				mv.addObject("store", store);
				Set<Long> groupDetailInfo = Sets.newHashSet();
				for (String gcId : store.getGroupDetailInfo().split(",")) {
					groupDetailInfo.add(Long.parseLong(gcId));
				}
				mv.addObject("groupDetailInfo", groupDetailInfo);

				StoreApplyInfoBO applyInfo = storeService.findStoreApplyInfoById(store.getId());
				mv.addObject("applyInfo", applyInfo);

				setViewArea(mv, store.getAreaId());
				setViewBankArea(mv, store.getBankAreaId());

				// 如果为审批失败，修改申请
				List<GroupClassBO> groupClassList = groupClassService.findCacheLevelAll();
				mv.addObject("groupClassList", groupClassList);
				mv.addObject("subGroupClassList", groupClassService.findCahceByParent(store.getGroupMainId()));

				List<Area> areas = areaService.getAllParentIsNull();
				mv.addObject("areas", areas);

			} else {
				return seller_store_query(request, response);
			}
		} else {
			return seller_apply_step0(request, response);
		}

		return mv;
	}

	@SecurityMapping(title = "商户信息填写", value = "/seller_apply/group/step1_save.htm*", rtype = "buyer", rname = "商家入驻", rcode = "group_seller_apply", rgroup = "商家入驻")
	@RequestMapping("/seller_apply/group/step1_save.htm")
	private ModelAndView seller_apply_step1_save(HttpServletRequest request, HttpServletResponse response,
			StoreApplyVO applyVO) {
		ModelAndView mv = null;

		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		StoreBO store = storeService.queryStoreStatus(user.getId(),true,false);
		try {
			if (store != null) {
				if (store.getStoreStatus() >= StoreConstants.STORE_STATUS_SHOP_AUDIT_SUCCESS) {
					mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
					mv.addObject("op_title", "您已经是商户!");
					mv.addObject("url", CommUtil.getURL(request) + "/seller/index.htm");
					return mv;
				} else if (store.getStoreStatus() == StoreConstants.STORE_STATUS_SHOP_OPREATE_AUDIT_FAIL
						|| store.getStoreStatus() == StoreConstants.STORE_STATUS_SYS_AUDIT_FAIL
						|| store.getStoreStatus() == StoreConstants.STORE_STATUS_OTHER_PAY_AUDIT_FAIL) {
					// 如果为审批失败，修改申请
					storeService.applyStore(applyVO, user.getId(), store.getId());
				} else {
					return seller_store_query(request, response);
				}
			} else {
				// 新增申请
				storeService.applyStore(applyVO, user.getId());
			}
		} catch (ServiceException e) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", e.getErrorCode());
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
			return mv;
		}

		mv = new JModelAndView("success.html", configService.getSysConfig(), 1, request, response);
		mv.addObject("op_title", "商户申请成功，请等待审批！");
		mv.addObject("url", CommUtil.getURL(request) + "/seller_apply/group/query.htm");
		return mv;
	}

//
//	/**
//	 * 商家申请页面 商家由买家注册后申请
//	 * 
//	 * @param request
//	 * @param response
//	 * @return
//	 */
//	private ModelAndView seller_apply_step2(HttpServletRequest request,
//			HttpServletResponse response) {
//		ModelAndView mv = new JModelAndView(
//				"seller_apply/seller_apply_step2.html",
//				configService.getSysConfig(),
//				this.userConfigService.getUserConfig(), 1, request, response);
//		User user = this.userService.getObjById(SecurityUserHolder
//				.getCurrentUser().getId());
//		Store store = user.getStore();
//		if (store == null) {
//			store = new Store();
//			store.setAddTime(new Date());
//			this.storeService.save(store);
//			StorePoint sp = new StorePoint();
//			sp.setAddTime(new Date());
//			sp.setStore(store);
//			sp.setDescription_evaluate(BigDecimal.valueOf(0));
//			sp.setService_evaluate(BigDecimal.valueOf(0));
//			sp.setShip_evaluate(BigDecimal.valueOf(0));
//			this.storePointService.save(sp);
//			user.setStore(store);
//			this.userService.update(user);
//		}
//		mv.addObject("user", user);
//		mv.addObject("store", store);
//		return mv;
//	}
//
//	/**
//	 * 商家申请联系方式保存
//	 * 
//	 * @param request
//	 * @param response
//	 * @param trueName
//	 * @param telephone
//	 * @param email
//	 * @return
//	 */
//	@SecurityMapping(title = "入驻联系方式保存", value = "/seller_apply_step2_save.htm*", rtype = "buyer", rname = "商家入驻", rcode = "seller_apply", rgroup = "商家入驻")
//	@RequestMapping("/seller_apply_step2_save.htm")
//	public String seller_apply_step2_save(HttpServletRequest request,
//			HttpServletResponse response, String trueName, String telephone,
//			String email) {
//		User user = this.userService.getObjById(SecurityUserHolder
//				.getCurrentUser().getId());
//		if (!CommUtil.null2String(trueName).equals("")
//				&& !CommUtil.null2String(telephone).equals("")
//				&& !CommUtil.null2String(email).equals("")) {
//			user.setTrueName(trueName);
//			user.setTelephone(telephone);
//			user.setEmail(email);
//			this.userService.update(user);
//		}
//		return "redirect:seller_apply.htm?step=3";
//	}
//
//	/**
//	 * 完善公司信息
//	 * 
//	 * @param request
//	 * @param response
//	 * @return
//	 */
//	private ModelAndView seller_apply_step3(HttpServletRequest request,
//			HttpServletResponse response) {
//		ModelAndView mv = new JModelAndView(
//				"seller_apply/seller_apply_step3.html",
//				configService.getSysConfig(),
//				this.userConfigService.getUserConfig(), 1, request, response);
//		User user = this.userService.getObjById(SecurityUserHolder
//				.getCurrentUser().getId());
//		if (user.getStore().getStore_status() == 6) {
//			Store store = user.getStore();
//			store.setStore_status(0);
//			this.storeService.update(store);
//		}
//		List<Area> areas = this.areaService.query(
//				"select obj from Area obj where obj.parent.id is null", null,
//				-1, -1);
//		mv.addObject("areas", areas);
//		mv.addObject("store", user.getStore());
//		System.out.println(request.getSession().getId());
//		mv.addObject("jsessionid", request.getSession().getId());
//		return mv;
//	}
//
//	/**
//	 * 商家申请公司信息保存
//	 * 
//	 * @param request
//	 * @param response
//	 * @param id
//	 * @param currentPage
//	 * @return
//	 */
//	@SecurityMapping(title = "入驻公司信息保存", value = "/seller_apply_step3_save.htm*", rtype = "buyer", rname = "商家入驻", rcode = "seller_apply", rgroup = "商家入驻")
//	@RequestMapping("/seller_apply_step3_save.htm")
//	public String seller_apply_step3_save(HttpServletRequest request,
//			HttpServletResponse response, String lid2, String cid2, String step) {
//		User user = this.userService.getObjById(SecurityUserHolder
//				.getCurrentUser().getId());
//		user.setStore_apply_step(CommUtil.null2Int(step));
//		this.userService.update(user);
//		WebForm wf = new WebForm();
//		Store store = null;
//		Store obj = user.getStore();
//		store = (Store) wf.toPo(request, obj);
//		store.setLicense_area(this.areaService.getObjById(CommUtil
//				.null2Long(lid2)));
//		store.setLicense_c_area(this.areaService.getObjById(CommUtil
//				.null2Long(cid2)));
//		this.storeService.update(store);
//		return "redirect:seller_apply.htm";
//	}
//
//	/**
//	 * 完善税务以及银行信息
//	 * 
//	 * @param request
//	 * @param response
//	 * @param id
//	 * @param currentPage
//	 * @return
//	 */
//	private ModelAndView seller_apply_step4(HttpServletRequest request,
//			HttpServletResponse response) {
//		ModelAndView mv = new JModelAndView(
//				"seller_apply/seller_apply_step4.html",
//				configService.getSysConfig(),
//				this.userConfigService.getUserConfig(), 1, request, response);
//		User user = this.userService.getObjById(SecurityUserHolder
//				.getCurrentUser().getId());
//		List<Area> areas = this.areaService.query(
//				"select obj from Area obj where obj.parent.id is null", null,
//				-1, -1);
//		mv.addObject("areas", areas);
//		mv.addObject("store", user.getStore());
//		mv.addObject("jsessionid", request.getSession().getId());
//		return mv;
//	}
//
//	/**
//	 * 保存税务以及银行信息
//	 * 
//	 * @param request
//	 * @param response
//	 * @param id
//	 * @param currentPage
//	 * @return
//	 */
//	@SecurityMapping(title = "入驻财务信息保存", value = "/seller_apply_step4_save.htm*", rtype = "buyer", rname = "商家入驻", rcode = "seller_apply", rgroup = "商家入驻")
//	@RequestMapping("/seller_apply_step4_save.htm")
//	public String seller_apply_step4_save(HttpServletRequest request,
//			HttpServletResponse response, String bid2, String step) {
//		User user = this.userService.getObjById(SecurityUserHolder
//				.getCurrentUser().getId());
//		user.setStore_apply_step(CommUtil.null2Int(step));
//		this.userService.update(user);
//		WebForm wf = new WebForm();
//		Store store = null;
//		Store obj = user.getStore();
//		store = (Store) wf.toPo(request, obj);
//		store.setBank_area(this.areaService.getObjById(CommUtil.null2Long(bid2)));
//		this.storeService.update(store);
//		return "redirect:seller_apply.htm";
//	}
//
//	/**
//	 * 完善店铺信息
//	 * 
//	 * @param request
//	 * @param response
//	 * @return
//	 */
//	private ModelAndView seller_apply_step5(HttpServletRequest request,
//			HttpServletResponse response) {
//		ModelAndView mv = new JModelAndView(
//				"seller_apply/seller_apply_step5.html",
//				configService.getSysConfig(),
//				this.userConfigService.getUserConfig(), 1, request, response);
//		User user = this.userService.getObjById(SecurityUserHolder
//				.getCurrentUser().getId());
//		if (user.getStore().getStore_status() == 11) {
//			Store store = user.getStore();
//			store.setStore_status(0);
//			this.storeService.update(store);
//		}
//		List<Area> areas = this.areaService.query(
//				"select obj from Area obj where obj.parent.id is null", null,
//				-1, -1);
//		List<StoreGrade> storeGrades = this.storegradeService.query(
//				"select obj from StoreGrade obj", null, -1, -1);
//		List<GoodsClass> goodsClass = this.goodsClassService.query(
//				"select obj from GoodsClass obj where obj.parent.id is null",
//				null, -1, -1);
//		mv.addObject("goodsClass", goodsClass);
//		mv.addObject("storeGrades", storeGrades);
//		mv.addObject("areas", areas);
//		mv.addObject("store", user.getStore());
//		return mv;
//	}
//
//	/**
//	 * 保存店铺信息
//	 * 
//	 * @param request
//	 * @param response
//	 * @param id
//	 * @param currentPage
//	 * @return
//	 */
//	@SecurityMapping(title = "入驻店铺信息保存", value = "/seller_apply_step5_save.htm*", rtype = "buyer", rname = "商家入驻", rcode = "seller_apply", rgroup = "商家入驻")
//	@RequestMapping("/seller_apply_step5_save.htm")
//	public String seller_apply_step5_save(HttpServletRequest request,
//			HttpServletResponse response, String aid2, String step,
//			String storeGrades, String gc_main_id, String validity) {
//		User user = this.userService.getObjById(SecurityUserHolder
//				.getCurrentUser().getId());
//		user.setStore_apply_step(CommUtil.null2Int(step));
//		this.userService.update(user);
//		Store obj = user.getStore();
//		WebForm wf = new WebForm();
//		Store store = null;
//		store = (Store) wf.toPo(request, obj);
//		if (aid2 != null && !"".equals(aid2)) {
//			store.setArea(this.areaService.getObjById(CommUtil.null2Long(aid2)));
//		}
//		store.setGrade(this.storegradeService.getObjById(CommUtil
//				.null2Long(storeGrades)));
//		store.setGc_main_id(CommUtil.null2Long(gc_main_id));
//		store.setGc_detail_info(null);
//		store.setValidity(CommUtil.formatDate(validity));
//		this.storeService.update(store);
//		return "redirect:seller_apply.htm";
//	}
//
//	/**
//	 * 店铺经营类目
//	 * 
//	 * @param request
//	 * @param response
//	 * @return
//	 */
//	private ModelAndView seller_apply_step6(HttpServletRequest request,
//			HttpServletResponse response) {
//		ModelAndView mv = new JModelAndView(
//				"seller_apply/seller_apply_step6.html",
//				configService.getSysConfig(),
//				this.userConfigService.getUserConfig(), 1, request, response);
//		User user = this.userService.getObjById(SecurityUserHolder
//				.getCurrentUser().getId());
//		Store user_store = user.getStore();
//		if (user_store.getGrade().getMain_limit() == 1) {// 查出该主营类目下的二级类目
//			GoodsClass gc = this.goodsClassService.getObjById(user_store
//					.getGc_main_id());
//			mv.addObject("gc", gc);
//		} else {// 不限制
//			List<GoodsClass> goodsClass = this.goodsClassService
//					.query("select obj from GoodsClass obj where obj.parent.id is null",
//							null, -1, -1);
//			mv.addObject("goodsClass", goodsClass);
//			mv.addObject("gc", goodsClass.get(0));
//		}
//		mv.addObject("store", user_store);
//		Set<GoodsClass> all_details_gcs = this.storeTools
//				.query_store_DetailGc(user_store.getGc_detail_info());
//		mv.addObject("details_gcs", all_details_gcs);
//		return mv;
//	}
//
//	/**
//	 * 保存店铺类型及类目信息
//	 * 
//	 * @param request
//	 * @param response
//	 * @param goodsClass_main
//	 * @param sg
//	 * @return
//	 */
//	@SecurityMapping(title = "入驻店铺类型保存", value = "/seller_apply_step6_save.htm*", rtype = "buyer", rname = "商家入驻", rcode = "seller_apply", rgroup = "商家入驻")
//	@RequestMapping("/seller_apply_step6_save.htm")
//	public String seller_apply_step6_save(HttpServletRequest request,
//			HttpServletResponse response, String goodsClass_main, String step) {
//		User user = this.userService.getObjById(SecurityUserHolder
//				.getCurrentUser().getId());
//		user.setStore_apply_step(CommUtil.null2Int(step));
//		this.userService.update(user);
//		Store store = user.getStore();
//		this.storeService.update(store);
//		return "redirect:seller_apply.htm";
//	}
//
//	/**
//	 * 确认入驻协议
//	 * 
//	 * @param request
//	 * @param response
//	 * @return
//	 */
//	private ModelAndView seller_apply_step7(HttpServletRequest request,
//			HttpServletResponse response) {
//		ModelAndView mv = new JModelAndView(
//				"seller_apply/seller_apply_step7.html",
//				configService.getSysConfig(),
//				this.userConfigService.getUserConfig(), 1, request, response);
//		mv.addObject("doc", this.documentService.getObjByProperty(null,"mark",
//				"apply_agreement"));
//		return mv;
//	}
//
//	/**
//	 * 商家入驻佣金信息
//	 * 
//	 * @param request
//	 * @param response
//	 * @return
//	 */
//	@SecurityMapping(title = "入驻佣金", value = "/seller_apply_money.htm*", rtype = "buyer", rname = "商家入驻", rcode = "seller_apply", rgroup = "商家入驻")
//	@RequestMapping("/seller_apply_money.htm")
//	private ModelAndView seller_apply_money(HttpServletRequest request,
//			HttpServletResponse response) {
//		ModelAndView mv = new JModelAndView(
//				"seller_apply/seller_apply_money.html",
//				configService.getSysConfig(),
//				this.userConfigService.getUserConfig(), 1, request, response);
//		List<GoodsClass> goodsClass = this.goodsClassService.query(
//				"select obj from GoodsClass obj where obj.parent.id is null",
//				null, -1, -1);
//		mv.addObject("goodsClass", goodsClass);
//		return mv;
//	}
//
//	/**
//	 * 确认提交申请
//	 * 
//	 * @param request
//	 * @param response
//	 * @return
//	 */
//	@SecurityMapping(title = "入驻申请提交", value = "/seller_store_wait.htm*", rtype = "buyer", rname = "商家入驻", rcode = "seller_apply", rgroup = "商家入驻")
//	@RequestMapping("/seller_store_wait.htm")
//	public ModelAndView seller_store_wait(HttpServletRequest request,
//			HttpServletResponse response) {
//		ModelAndView mv = new JModelAndView(
//				"seller_apply/seller_apply_wait.html",
//				configService.getSysConfig(),
//				this.userConfigService.getUserConfig(), 1, request, response);
//		User user = this.userService.getObjById(SecurityUserHolder
//				.getCurrentUser().getId());
//		if (user.getStore().getStore_status() > 0) {// 已经提交过申请了，进入查询请求
//			return this.seller_store_query(request, response);
//		}
//		Store store = user.getStore();
//		store.setStore_status(5);// 将店铺状态设置为“公司等待信息审核”
//		user.setStore_apply_step(8);// 将用户的申请进度设置为“已提交入驻申请”
//		this.userService.update(user);
//		this.storeService.update(store);
//		return mv;
//	}
//
	/**
	 * 入驻进度查询
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "入驻进度查询", value = "/seller_apply/group/query.htm*", rtype = "buyer", rname = "商家入驻", rcode = "group_seller_apply", rgroup = "商家入驻")
	@RequestMapping("/seller_apply/group/query.htm")
	public ModelAndView seller_store_query(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("seller_apply/seller_apply_wait.html",
				configService.getSysConfig(), 1, request, response);;

		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		StoreBO store = storeService.queryStoreStatus(user.getId(),true,false);

		if (store != null) {
			mv.addObject("store", store);
			return mv;
		} else {
			return seller_apply_step0(request, response);
		}
	}

//
//	/**
//	 * 审核拒绝，重新提交
//	 * 
//	 * @param request
//	 * @param response
//	 * @return
//	 */
//	@SecurityMapping(title = "重新申请入驻", value = "/seller_store_rewrite.htm*", rtype = "buyer", rname = "商家入驻", rcode = "seller_apply", rgroup = "商家入驻")
//	@RequestMapping("/seller_store_rewrite.htm")
//	public ModelAndView seller_store_rewrite(HttpServletRequest request,
//			HttpServletResponse response, String step) {
//		User user = this.userService.getObjById(SecurityUserHolder
//				.getCurrentUser().getId());
//		if (step.equals("3")) {// 重新填写公司信息
//			user.setStore_apply_step(3);
//		}
//		if (step.equals("5")) {// 重新填写店铺信息
//			user.setStore_apply_step(5);
//		}
//		this.userService.update(user);
//		return seller_apply(request, response, null, step);
//	}
//
	/**
	 * 商家入驻照片保存上传
	 * 
	 * @param request
	 * @param response
	 */
	@SecurityMapping(title = "商品图片上传", value = "/seller_apply/image_save.htm*", rtype = "buyer", rname = "商品发布", rcode = "seller_apply", rgroup = "商家入驻")
	@RequestMapping("/seller_apply/image_save.htm")
	public void seller_apply_image_save(HttpServletRequest request, HttpServletResponse response, String mark) {

		Long uid = SecurityUserHolder.getCurrentUserId();
		Map<String, String> map = Maps.newHashMap();

		if ("other".equals(mark)) {
			String path = accessoryService.upload(request, mark + "_file", null);
			map.put("path", path);
		} else {
			String path = accessoryService.upload(request, mark + "_file", "/seller/" + uid + "/" + mark
					+ "_file");
			map.put("path", path);
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(JSON.toJSONString(map));
			writer.flush();
			writer.close();
		} catch (IOException e) {
		}
	}

	private void setViewArea(ModelAndView mv, Long areaCode) {
		Area area = (Area) dicContent.getDic(Area.class, String.valueOf(areaCode));
		if (area != null) {
			mv.addObject("areaTowId", area.getParentCode());
			mv.addObject("areas3", dicContent.getDicsByParentCode(Area.class, area.getParentCode()));

			Area parentArea = (Area) dicContent.getDic(Area.class, area.getParentCode());
			if (parentArea != null) {
				mv.addObject("areaOneId", parentArea.getParentCode());
				mv.addObject("areas2", dicContent.getDicsByParentCode(Area.class, parentArea.getParentCode()));
			}

		}

	}

	private void setViewBankArea(ModelAndView mv, Long areaCode) {
		Area area = (Area) dicContent.getDic(Area.class, String.valueOf(areaCode));
		if (area != null) {
			mv.addObject("bankAreaOneId", area.getParentCode());
			mv.addObject("bankAreas2", dicContent.getDicsByParentCode(Area.class, area.getParentCode()));
		}

	}
}
