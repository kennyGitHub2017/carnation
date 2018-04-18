package vc.thinker.b2b2c.action;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.weedfs.client.WeedFSClient;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.common.collect.Maps;
import org.elasticsearch.common.collect.Sets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.alibaba.fastjson.JSON;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.o2o.bo.GroupClassBO;
import com.sinco.carnation.o2o.service.GroupClassService;
import com.sinco.carnation.store.bo.StoreApplyInfoBO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.constants.StoreConstants;
import com.sinco.carnation.store.model.StoreApplyInfo;
import com.sinco.carnation.store.service.StoreSearchService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.store.vo.StoreApplyVO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.DocumentService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.bo.OperatorBO;
import com.sinco.carnation.user.bo.SellerBO;
import com.sinco.carnation.user.service.OperatorService;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.dic.client.DicContent;

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
	@Autowired
	private WeedFSClient fsClient;
	@Autowired
	private GoodsClassService goodsclassService;
	@Autowired
	private OperatorService operatorService;
	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private SellerService sellerService;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@SecurityMapping(title = "服务商家入驻申请", value = "/seller_apply/group.htm*", rtype = "buyer", rname = "商家入驻", rcode = "group_seller_apply", rgroup = "商家入驻")
	@RequestMapping("/seller_apply/group.htm")
	public ModelAndView seller_apply(HttpServletRequest request, HttpServletResponse response, String step) {
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		StoreBO store = null;
		if (UserContant.ACCOUNT_TYPE_RESOURCE.equals(user.getSource())) {
			SellerBO seller = sellerService.findSessionById(user.getId(),true,null);
			if (seller != null) {
				store = this.storeService.getStoreStatus(seller.getStoreId());
			}
			
		} else {
			store = this.storeService.getStoreStatus(user.getStoreId());
		}
		
		if (store != null && store.getIsO2o()) {// 申请分为7步，走完第7步流程进入审核状态，就不允许继续修改资料了
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

	/**
	 * 下载商户入驻协议
	 * 
	 * @param request
	 * @param response
	 * @param step
	 * @return
	 */
	@SecurityMapping(title = "服务商家入驻协议下载", value = "/seller_apply/agreementDownload.htm*", rtype = "buyer", rname = "商家入驻", rcode = "group_seller_apply_download", rgroup = "商家入驻")
	@RequestMapping("/seller_apply/agreementDownload.htm")
	public void agreementDownload(HttpServletRequest request, HttpServletResponse response, String step) {

		try {
			String fileName = "商户电子协议", wholeFileName = "商户电子协议.rar", encodedFileName, suffix = ".rar";
			encodedFileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");// 避免中文乱码
			response.addHeader("Content-Disposition", "attachment;filename=" + encodedFileName + suffix);

			OutputStream ous = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("application/octet-stream;charset=UTF-8");
			// http://localhost:8087/seller_apply/agreementDownload.htm
			// String path2 =
			// request.getSession().getServletContext().getRealPath("resources")+"\\word\\"+"agreementDoc.doc";//war的部署方式，会获取不到webapp文件下的路径
			// this.getClass().getClassLoader().getResource("/").getPath()+"attachmentFiles"+"/agreementDoc.doc";

			//
			String templatePath = "/resources/file/";// templateFileName=＂source.xls＂
			ServletContext context = request.getSession().getServletContext();
			InputStream bis = context.getResourceAsStream(templatePath + wholeFileName);

			// bis = new BufferedInputStream(new FileInputStream(path));
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				ous.write(buff, 0, bytesRead);
			}

			// ous.write(b);
			bis.close();
			ous.flush();
			ous.close();
		} catch (IOException e) {
			e.printStackTrace();
			// log.info("下载二维码出现读写IO异常");
		} catch (Exception e) {
			e.printStackTrace();
			// log.info("下载二维码出现异常");
		}

	}
	/**
	 * 下载供应商入驻协议
	 * 
	 * @param request
	 * @param response
	 * @param step
	 * @return
	 */
	@SecurityMapping(title = "下载供应商入驻协议", value = "/seller_apply/agreementB2CDownload.htm*", rtype = "buyer", rname = "商家入驻", rcode = "group_seller_apply_download", rgroup = "商家入驻")
	@RequestMapping("/seller_apply/agreementB2CDownload.htm")
	public void agreementB2CDownload(HttpServletRequest request, HttpServletResponse response, String step) {

		try {
			String fileName = "供应商电子协议", wholeFileName = "供应商电子协议.rar", encodedFileName, suffix = ".rar";
			encodedFileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");// 避免中文乱码
			response.addHeader("Content-Disposition", "attachment;filename=" + encodedFileName + suffix);

			OutputStream ous = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("application/octet-stream;charset=UTF-8");
			// http://localhost:8087/seller_apply/agreementDownload.htm
			// String path2 =
			// request.getSession().getServletContext().getRealPath("resources")+"\\word\\"+"agreementDoc.doc";//war的部署方式，会获取不到webapp文件下的路径
			// this.getClass().getClassLoader().getResource("/").getPath()+"attachmentFiles"+"/agreementDoc.doc";

			//
			String templatePath = "/resources/file/";// templateFileName=＂source.xls＂
			ServletContext context = request.getSession().getServletContext();
			InputStream bis = context.getResourceAsStream(templatePath + wholeFileName);

			// bis = new BufferedInputStream(new FileInputStream(path));
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				ous.write(buff, 0, bytesRead);
			}

			// ous.write(b);
			bis.close();
			ous.flush();
			ous.close();
		} catch (IOException e) {
			e.printStackTrace();
			// log.info("下载二维码出现读写IO异常");
		} catch (Exception e) {
			e.printStackTrace();
			// log.info("下载二维码出现异常");
		}

	}

	/**
	 * 下载商家返佣比例文档
	 * 
	 * @param request
	 * @param response
	 * @param step
	 * @return
	 */
	@SecurityMapping(title = "下载商家返佣比例文档", value = "/seller_apply/commissionRatioDownload.htm*", rtype = "buyer", rname = "商家入驻", rcode = "group_seller_apply_download", rgroup = "商家入驻")
	@RequestMapping("/seller_apply/commissionRatioDownload.htm")
	public void commissionRatioDownload(HttpServletRequest request, HttpServletResponse response, String step) {

		try {
			String fileName = "商家返佣比例(电子打印版)", wholeFileName = "sellerCommissionRatioDoc.doc", encodedFileName, suffix = ".doc";
			encodedFileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");// 避免中文乱码
			response.addHeader("Content-Disposition", "attachment;filename=" + encodedFileName + suffix);

			OutputStream ous = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("application/octet-stream;charset=UTF-8");
			// http://localhost:8087/seller_apply/agreementDownload.htm
			// String path2 =
			// request.getSession().getServletContext().getRealPath("resources")+"\\word\\"+"agreementDoc.doc";//war的部署方式，会获取不到webapp文件下的路径
			// String path =
			// this.getClass().getClassLoader().getResource("/").getPath()+"attachmentFiles"+"/agreementDoc.doc";

			//
			String templatePath = "/WEB-INF/templates/attachmentFile/";// templateFileName=＂source.xls＂
			ServletContext context = request.getSession().getServletContext();
			InputStream bis = context.getResourceAsStream(templatePath + wholeFileName);

			// bis = new BufferedInputStream(new FileInputStream(path));
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				ous.write(buff, 0, bytesRead);
			}

			// ous.write(b);
			bis.close();
			ous.flush();
			ous.close();
		} catch (IOException e) {
			e.printStackTrace();
			// log.info("下载二维码出现读写IO异常");
		} catch (Exception e) {
			e.printStackTrace();
			// log.info("下载二维码出现异常");
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
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		SellerBO sellerBO = sellerService.findByUid(user.getId());
		
		if(null != sellerBO ){
			StoreBO storeBo = storeService.findObjById(sellerBO.getStoreId());
			if(null != storeBo && storeBo.getIsO2o()){
				mv = null;
				mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", "您已经是商户!");
				mv.addObject("url", CommUtil.getURL(request) + "/seller/index.htm");
			}
		}
		List<GroupClassBO> groupClassList = groupClassService.findCacheLevelAll();
		mv.addObject("groupClassList", groupClassList);

		List<Area> areas = areaService.getAllParentIsNull();
		mv.addObject("areas", areas);

		return mv;
	}

	/**
	 * 返佣比例表格页面
	 */
	@SecurityMapping(title = "返佣比例表格页面 ", value = "/seller_apply/group/commissionRatio.htm*", rtype = "buyer", rname = "商家入驻", rcode = "group_seller_apply", rgroup = "商家入驻")
	@RequestMapping("/seller_apply/group/commissionRatio.htm")
	private ModelAndView commissionRatio(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("/seller_apply/commissionRatio.html",
				configService.getSysConfig(), 1, request, response);
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
		StoreBO store = null;
		if (UserContant.ACCOUNT_TYPE_RESOURCE.equals(user.getSource())) {
			SellerBO seller = sellerService.findSessionById(user.getId(),true,null);
			if (seller != null) {
				store = this.storeService.getStoreStatus(seller.getStoreId());
			}
		} else {
			store = this.storeService.getStoreStatus(user.getStoreId());
		}
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

				if (StringUtils.isNotBlank(store.getGroupDetailInfo())) {// 增加为空判断
					for (String gcId : store.getGroupDetailInfo().split(",")) {
						groupDetailInfo.add(Long.parseLong(gcId));
					}
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

	@SuppressWarnings("unused")
	@SecurityMapping(title = "商户信息填写", value = "/seller_apply/group/step1_save.htm*", rtype = "buyer", rname = "商家入驻", rcode = "group_seller_apply", rgroup = "商家入驻")
	@RequestMapping("/seller_apply/group/step1_save.htm")
	private ModelAndView seller_apply_step1_save(HttpServletRequest request, HttpServletResponse response,
			StoreApplyVO applyVO) {
		ModelAndView mv = null;
		String operateNumber = applyVO.getOperateNumber();
		if(null != applyVO.getLicenseCDesc()){
			StringBuffer desc = new StringBuffer(applyVO.getLicenseCDesc());
			applyVO.setLicenseCDesc(desc.toString());
		}
		if(StringUtils.isBlank(applyVO.getStoreName())){
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "商户全称不能为空");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
		}
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		SellerBO seller0 = sellerService.findSessionById(user.getId(),false,true);//是否是供应商
		if (seller0 != null) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "您已经是供应商了，不能入住商户!");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
			return mv;
		}
		
		StoreBO store = null;
		if (UserContant.ACCOUNT_TYPE_RESOURCE.equals(user.getSource())) {
			SellerBO seller = sellerService.findSessionById(user.getId(),true,null);
			if (seller != null) {
				store = this.storeService.getStoreStatus(seller.getStoreId());
			}
		} else {
			store = this.storeService.getStoreStatus(user.getStoreId());
		}
		
		
		applyVO.setLicenseCName(applyVO.getStoreName());//入驻时候全称LicenseCName  简称StoreName默认为一个值
		try {
			if (store != null && store.getIsO2o()) {
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
				/**
				 * 商户、供应商入驻页面限制CN账号申请 add by yuleijia 2017.2.20
				 */
				long uid = user.getId();
				boolean result = this.userService.queryIncludeCNUserAccount(uid);
				if (result) {
					log.debug("************申请入驻用户包含CN账号，禁止申请动作");
				}
				// 新增申请
				storeService.applyStore(applyVO, user.getId());
			}
		} catch (ServiceException e) {
			log.error("[seller_apply_step1_save] uid="+user.getId()+e);
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
	// /**
	// * 商家申请页面 商家由买家注册后申请
	// *
	// * @param request
	// * @param response
	// * @return
	// */
	// private ModelAndView seller_apply_step2(HttpServletRequest request,
	// HttpServletResponse response) {
	// ModelAndView mv = new JModelAndView(
	// "seller_apply/seller_apply_step2.html",
	// configService.getSysConfig(),
	// this.userConfigService.getUserConfig(), 1, request, response);
	// User user = this.userService.getObjById(SecurityUserHolder
	// .getCurrentUser().getId());
	// Store store = user.getStore();
	// if (store == null) {
	// store = new Store();
	// store.setAddTime(new Date());
	// this.storeService.save(store);
	// StorePoint sp = new StorePoint();
	// sp.setAddTime(new Date());
	// sp.setStore(store);
	// sp.setDescription_evaluate(BigDecimal.valueOf(0));
	// sp.setService_evaluate(BigDecimal.valueOf(0));
	// sp.setShip_evaluate(BigDecimal.valueOf(0));
	// this.storePointService.save(sp);
	// user.setStore(store);
	// this.userService.update(user);
	// }
	// mv.addObject("user", user);
	// mv.addObject("store", store);
	// return mv;
	// }
	//
	// /**
	// * 商家申请联系方式保存
	// *
	// * @param request
	// * @param response
	// * @param trueName
	// * @param telephone
	// * @param email
	// * @return
	// */
	// @SecurityMapping(title = "入驻联系方式保存", value =
	// "/seller_apply_step2_save.htm*", rtype = "buyer", rname = "商家入驻", rcode =
	// "seller_apply", rgroup = "商家入驻")
	// @RequestMapping("/seller_apply_step2_save.htm")
	// public String seller_apply_step2_save(HttpServletRequest request,
	// HttpServletResponse response, String trueName, String telephone,
	// String email) {
	// User user = this.userService.getObjById(SecurityUserHolder
	// .getCurrentUser().getId());
	// if (!CommUtil.null2String(trueName).equals("")
	// && !CommUtil.null2String(telephone).equals("")
	// && !CommUtil.null2String(email).equals("")) {
	// user.setTrueName(trueName);
	// user.setTelephone(telephone);
	// user.setEmail(email);
	// this.userService.update(user);
	// }
	// return "redirect:seller_apply.htm?step=3";
	// }
	//
	// /**
	// * 完善公司信息
	// *
	// * @param request
	// * @param response
	// * @return
	// */
	// private ModelAndView seller_apply_step3(HttpServletRequest request,
	// HttpServletResponse response) {
	// ModelAndView mv = new JModelAndView(
	// "seller_apply/seller_apply_step3.html",
	// configService.getSysConfig(),
	// this.userConfigService.getUserConfig(), 1, request, response);
	// User user = this.userService.getObjById(SecurityUserHolder
	// .getCurrentUser().getId());
	// if (user.getStore().getStore_status() == 6) {
	// Store store = user.getStore();
	// store.setStore_status(0);
	// this.storeService.update(store);
	// }
	// List<Area> areas = this.areaService.query(
	// "select obj from Area obj where obj.parent.id is null", null,
	// -1, -1);
	// mv.addObject("areas", areas);
	// mv.addObject("store", user.getStore());
	// System.out.println(request.getSession().getId());
	// mv.addObject("jsessionid", request.getSession().getId());
	// return mv;
	// }
	//
	// /**
	// * 商家申请公司信息保存
	// *
	// * @param request
	// * @param response
	// * @param id
	// * @param currentPage
	// * @return
	// */
	// @SecurityMapping(title = "入驻公司信息保存", value =
	// "/seller_apply_step3_save.htm*", rtype = "buyer", rname = "商家入驻", rcode =
	// "seller_apply", rgroup = "商家入驻")
	// @RequestMapping("/seller_apply_step3_save.htm")
	// public String seller_apply_step3_save(HttpServletRequest request,
	// HttpServletResponse response, String lid2, String cid2, String step) {
	// User user = this.userService.getObjById(SecurityUserHolder
	// .getCurrentUser().getId());
	// user.setStore_apply_step(CommUtil.null2Int(step));
	// this.userService.update(user);
	// WebForm wf = new WebForm();
	// Store store = null;
	// Store obj = user.getStore();
	// store = (Store) wf.toPo(request, obj);
	// store.setLicense_area(this.areaService.getObjById(CommUtil
	// .null2Long(lid2)));
	// store.setLicense_c_area(this.areaService.getObjById(CommUtil
	// .null2Long(cid2)));
	// this.storeService.update(store);
	// return "redirect:seller_apply.htm";
	// }
	//
	// /**
	// * 完善税务以及银行信息
	// *
	// * @param request
	// * @param response
	// * @param id
	// * @param currentPage
	// * @return
	// */
	// private ModelAndView seller_apply_step4(HttpServletRequest request,
	// HttpServletResponse response) {
	// ModelAndView mv = new JModelAndView(
	// "seller_apply/seller_apply_step4.html",
	// configService.getSysConfig(),
	// this.userConfigService.getUserConfig(), 1, request, response);
	// User user = this.userService.getObjById(SecurityUserHolder
	// .getCurrentUser().getId());
	// List<Area> areas = this.areaService.query(
	// "select obj from Area obj where obj.parent.id is null", null,
	// -1, -1);
	// mv.addObject("areas", areas);
	// mv.addObject("store", user.getStore());
	// mv.addObject("jsessionid", request.getSession().getId());
	// return mv;
	// }
	//
	// /**
	// * 保存税务以及银行信息
	// *
	// * @param request
	// * @param response
	// * @param id
	// * @param currentPage
	// * @return
	// */
	// @SecurityMapping(title = "入驻财务信息保存", value =
	// "/seller_apply_step4_save.htm*", rtype = "buyer", rname = "商家入驻", rcode =
	// "seller_apply", rgroup = "商家入驻")
	// @RequestMapping("/seller_apply_step4_save.htm")
	// public String seller_apply_step4_save(HttpServletRequest request,
	// HttpServletResponse response, String bid2, String step) {
	// User user = this.userService.getObjById(SecurityUserHolder
	// .getCurrentUser().getId());
	// user.setStore_apply_step(CommUtil.null2Int(step));
	// this.userService.update(user);
	// WebForm wf = new WebForm();
	// Store store = null;
	// Store obj = user.getStore();
	// store = (Store) wf.toPo(request, obj);
	// store.setBank_area(this.areaService.getObjById(CommUtil.null2Long(bid2)));
	// this.storeService.update(store);
	// return "redirect:seller_apply.htm";
	// }
	//
	// /**
	// * 完善店铺信息
	// *
	// * @param request
	// * @param response
	// * @return
	// */
	// private ModelAndView seller_apply_step5(HttpServletRequest request,
	// HttpServletResponse response) {
	// ModelAndView mv = new JModelAndView(
	// "seller_apply/seller_apply_step5.html",
	// configService.getSysConfig(),
	// this.userConfigService.getUserConfig(), 1, request, response);
	// User user = this.userService.getObjById(SecurityUserHolder
	// .getCurrentUser().getId());
	// if (user.getStore().getStore_status() == 11) {
	// Store store = user.getStore();
	// store.setStore_status(0);
	// this.storeService.update(store);
	// }
	// List<Area> areas = this.areaService.query(
	// "select obj from Area obj where obj.parent.id is null", null,
	// -1, -1);
	// List<StoreGrade> storeGrades = this.storegradeService.query(
	// "select obj from StoreGrade obj", null, -1, -1);
	// List<GoodsClass> goodsClass = this.goodsClassService.query(
	// "select obj from GoodsClass obj where obj.parent.id is null",
	// null, -1, -1);
	// mv.addObject("goodsClass", goodsClass);
	// mv.addObject("storeGrades", storeGrades);
	// mv.addObject("areas", areas);
	// mv.addObject("store", user.getStore());
	// return mv;
	// }
	//
	// /**
	// * 保存店铺信息
	// *
	// * @param request
	// * @param response
	// * @param id
	// * @param currentPage
	// * @return
	// */
	// @SecurityMapping(title = "入驻店铺信息保存", value =
	// "/seller_apply_step5_save.htm*", rtype = "buyer", rname = "商家入驻", rcode =
	// "seller_apply", rgroup = "商家入驻")
	// @RequestMapping("/seller_apply_step5_save.htm")
	// public String seller_apply_step5_save(HttpServletRequest request,
	// HttpServletResponse response, String aid2, String step,
	// String storeGrades, String gc_main_id, String validity) {
	// User user = this.userService.getObjById(SecurityUserHolder
	// .getCurrentUser().getId());
	// user.setStore_apply_step(CommUtil.null2Int(step));
	// this.userService.update(user);
	// Store obj = user.getStore();
	// WebForm wf = new WebForm();
	// Store store = null;
	// store = (Store) wf.toPo(request, obj);
	// if (aid2 != null && !"".equals(aid2)) {
	// store.setArea(this.areaService.getObjById(CommUtil.null2Long(aid2)));
	// }
	// store.setGrade(this.storegradeService.getObjById(CommUtil
	// .null2Long(storeGrades)));
	// store.setGc_main_id(CommUtil.null2Long(gc_main_id));
	// store.setGc_detail_info(null);
	// store.setValidity(CommUtil.formatDate(validity));
	// this.storeService.update(store);
	// return "redirect:seller_apply.htm";
	// }
	//
	// /**
	// * 店铺经营类目
	// *
	// * @param request
	// * @param response
	// * @return
	// */
	// private ModelAndView seller_apply_step6(HttpServletRequest request,
	// HttpServletResponse response) {
	// ModelAndView mv = new JModelAndView(
	// "seller_apply/seller_apply_step6.html",
	// configService.getSysConfig(),
	// this.userConfigService.getUserConfig(), 1, request, response);
	// User user = this.userService.getObjById(SecurityUserHolder
	// .getCurrentUser().getId());
	// Store user_store = user.getStore();
	// if (user_store.getGrade().getMain_limit() == 1) {// 查出该主营类目下的二级类目
	// GoodsClass gc = this.goodsClassService.getObjById(user_store
	// .getGc_main_id());
	// mv.addObject("gc", gc);
	// } else {// 不限制
	// List<GoodsClass> goodsClass = this.goodsClassService
	// .query("select obj from GoodsClass obj where obj.parent.id is null",
	// null, -1, -1);
	// mv.addObject("goodsClass", goodsClass);
	// mv.addObject("gc", goodsClass.get(0));
	// }
	// mv.addObject("store", user_store);
	// Set<GoodsClass> all_details_gcs = this.storeTools
	// .query_store_DetailGc(user_store.getGc_detail_info());
	// mv.addObject("details_gcs", all_details_gcs);
	// return mv;
	// }
	//
	// /**
	// * 保存店铺类型及类目信息
	// *
	// * @param request
	// * @param response
	// * @param goodsClass_main
	// * @param sg
	// * @return
	// */
	// @SecurityMapping(title = "入驻店铺类型保存", value =
	// "/seller_apply_step6_save.htm*", rtype = "buyer", rname = "商家入驻", rcode =
	// "seller_apply", rgroup = "商家入驻")
	// @RequestMapping("/seller_apply_step6_save.htm")
	// public String seller_apply_step6_save(HttpServletRequest request,
	// HttpServletResponse response, String goodsClass_main, String step) {
	// User user = this.userService.getObjById(SecurityUserHolder
	// .getCurrentUser().getId());
	// user.setStore_apply_step(CommUtil.null2Int(step));
	// this.userService.update(user);
	// Store store = user.getStore();
	// this.storeService.update(store);
	// return "redirect:seller_apply.htm";
	// }
	//
	// /**
	// * 确认入驻协议
	// *
	// * @param request
	// * @param response
	// * @return
	// */
	// private ModelAndView seller_apply_step7(HttpServletRequest request,
	// HttpServletResponse response) {
	// ModelAndView mv = new JModelAndView(
	// "seller_apply/seller_apply_step7.html",
	// configService.getSysConfig(),
	// this.userConfigService.getUserConfig(), 1, request, response);
	// mv.addObject("doc", this.documentService.getObjByProperty(null,"mark",
	// "apply_agreement"));
	// return mv;
	// }
	//
	// /**
	// * 商家入驻佣金信息
	// *
	// * @param request
	// * @param response
	// * @return
	// */
	// @SecurityMapping(title = "入驻佣金", value = "/seller_apply_money.htm*",
	// rtype = "buyer", rname = "商家入驻", rcode = "seller_apply", rgroup = "商家入驻")
	// @RequestMapping("/seller_apply_money.htm")
	// private ModelAndView seller_apply_money(HttpServletRequest request,
	// HttpServletResponse response) {
	// ModelAndView mv = new JModelAndView(
	// "seller_apply/seller_apply_money.html",
	// configService.getSysConfig(),
	// this.userConfigService.getUserConfig(), 1, request, response);
	// List<GoodsClass> goodsClass = this.goodsClassService.query(
	// "select obj from GoodsClass obj where obj.parent.id is null",
	// null, -1, -1);
	// mv.addObject("goodsClass", goodsClass);
	// return mv;
	// }
	//
	// /**
	// * 确认提交申请
	// *
	// * @param request
	// * @param response
	// * @return
	// */
	// @SecurityMapping(title = "入驻申请提交", value = "/seller_store_wait.htm*",
	// rtype = "buyer", rname = "商家入驻", rcode = "seller_apply", rgroup = "商家入驻")
	// @RequestMapping("/seller_store_wait.htm")
	// public ModelAndView seller_store_wait(HttpServletRequest request,
	// HttpServletResponse response) {
	// ModelAndView mv = new JModelAndView(
	// "seller_apply/seller_apply_wait.html",
	// configService.getSysConfig(),
	// this.userConfigService.getUserConfig(), 1, request, response);
	// User user = this.userService.getObjById(SecurityUserHolder
	// .getCurrentUser().getId());
	// if (user.getStore().getStore_status() > 0) {// 已经提交过申请了，进入查询请求
	// return this.seller_store_query(request, response);
	// }
	// Store store = user.getStore();
	// store.setStore_status(5);// 将店铺状态设置为“公司等待信息审核”
	// user.setStore_apply_step(8);// 将用户的申请进度设置为“已提交入驻申请”
	// this.userService.update(user);
	// this.storeService.update(store);
	// return mv;
	// }
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
		ModelAndView mv = null;
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		SellerBO sellerBO = sellerService.findByUid(user.getId());
		if(null != sellerBO){
			StoreBO store = null;
			if (UserContant.ACCOUNT_TYPE_SUPPLIER.equals(user.getSource())) {
				SellerBO seller = sellerService.findSessionById(user.getId(),null,true);
				if (seller != null) {
					store = this.storeService.getStoreStatus(seller.getStoreId());
				}
				
			}else if(UserContant.ACCOUNT_TYPE_MERCHANT.equals(user.getSource())) {
				SellerBO seller = sellerService.findSessionById(user.getId(),true,null);
				if(seller != null) {
					store = this.storeService.getStoreStatus(seller.getStoreId());
				}
			
			} else {
				SellerBO seller = this.sellerService.findByUid(user.getId());
				if (seller != null){
					store = this.storeService.getStoreStatus(seller.getStoreId());
				}
			}
			
			if (store != null) {
				if (store.getIsO2o()) {
					mv = new JModelAndView("seller_apply/seller_apply_wait.html", configService.getSysConfig(),
							1, request, response);
				}

				if (store.getIsShop()) {
					mv = new JModelAndView("gongyingshang/chakansehngpijindu.html", configService.getSysConfig(),
							1, request, response);
				}

				mv.addObject("store", store);
				return mv;
			}
		}
		return seller_apply_step0(request, response);
	}

	//
	// /**
	// * 审核拒绝，重新提交
	// *
	// * @param request
	// * @param response
	// * @return
	// */
	// @SecurityMapping(title = "重新申请入驻", value = "/seller_store_rewrite.htm*",
	// rtype = "buyer", rname = "商家入驻", rcode = "seller_apply", rgroup = "商家入驻")
	// @RequestMapping("/seller_store_rewrite.htm")
	// public ModelAndView seller_store_rewrite(HttpServletRequest request,
	// HttpServletResponse response, String step) {
	// User user = this.userService.getObjById(SecurityUserHolder
	// .getCurrentUser().getId());
	// if (step.equals("3")) {// 重新填写公司信息
	// user.setStore_apply_step(3);
	// }
	// if (step.equals("5")) {// 重新填写店铺信息
	// user.setStore_apply_step(5);
	// }
	// this.userService.update(user);
	// return seller_apply(request, response, null, step);
	// }
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
//		String path = accessoryService.uploadForPath(request, mark + "_file", "seller/" + uid + "/" + mark + "_file");
//		map.put("path", path);
		if ("other".equals(mark)) {
		String path = accessoryService.uploadForPath2(request, mark + "_file",  "seller/" + uid + "/" + mark + "_file");
		map.put("path", path);
	} else {
		// 以商户id为目录存储（商户id=用户id）
		String path = accessoryService.uploadForPath(request, mark + "_file", "seller/" + uid + "/" + mark + "_file");
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

	/***
	 * 供应商入驻 -提交资料
	 * 
	 * @return
	 */
	@SecurityMapping(title = "供应商信息填写", value = "/seller_apply/group/supplier_save.htm*", rtype = "buyer", rname = "供应商入驻", rcode = "group_seller_apply", rgroup = "供应商入驻")
	@RequestMapping(value = "/seller_apply/group/supplier_save.htm", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public ModelAndView supplier_save(HttpServletRequest request, HttpServletResponse response,
			StoreApplyVO applyVO, Long storeId) {

		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		ModelAndView mv = new JModelAndView("gongyingshang/chakansehngpijindu.html",
				configService.getSysConfig(), 1, request, response);
		
		String ruzhu_session = CommUtil.null2String(request.getSession(false).getAttribute("ruzhu_session"));
		if (ruzhu_session.equals("")) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "禁止重复提交!");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
			return mv;
		}
		request.getSession(false).removeAttribute("ruzhu_session");
		
		SellerBO seller0 = sellerService.findSessionById(user.getId(),true,false);//是否是商户O2O
		if (seller0 != null) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "您已经是商户了，不能入住供应商!");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
			return mv;
		}
		try {
			/**
			 * 商户、供应商入驻页面限制CN账号申请 add by yuleijia 2017.2.20
			 */
			long uid = user.getId();
			boolean result = this.userService.queryIncludeCNUserAccount(uid);
			if (result) {
				log.debug(" ********** 申请入驻用户包含CN账号，禁止申请入驻动作");
			}
			StoreApplyInfo res = storeService.supplierSaveService(user.getName(), applyVO, user.getId(),
					storeId);
			if (res != null) {
				//StoreBO store = storeService.queryStoreStatus(user.getId());
				SellerBO seller = sellerService.findSessionById(uid,null,true);
				StoreBO store = this.storeService.getStoreStatus(seller.getStoreId());
				mv.addObject("store", store);
			}

		} catch (ServiceException e) {
			log.error("[supplier_save] uid="+user.getId()+e);
			e.printStackTrace();
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", e.getErrorCode());
			return mv;
		}
		return mv;
	}

	/**
	 * 修改重新提交页面
	 * 
	 * @param request
	 * @param response
	 * @param sotreId
	 * @return
	 */
	@RequestMapping("/seller_apply/ruzhu_shenqing.htm")
	public ModelAndView ruzhu_shenqing(HttpServletRequest request, HttpServletResponse response, Long storeId) {
		ModelAndView mv = new JModelAndView("gongyingshang/tijiaoruzhushenqing.html",
				configService.getSysConfig(), 1, request, response);
		List<GoodsClassBO> gcs = this.goodsclassService.findLevelAll();
		List<GoodsClassBO> list = new ArrayList<>();
		for (GoodsClassBO bo : gcs) {
			if (bo.getClassName().equals("热门品牌") || bo.getClassName().equals("热门搜索")) {
			} else {
				list.add(bo);
			}
		}
		mv.addObject("storeId", storeId);
		mv.addObject("groupClassList", list);

		StoreBO store = this.storeService.getObjById(storeId);
		String ruzhu_session = CommUtil.randomString(32);
		mv.addObject("ruzhu_session", ruzhu_session);
		request.getSession(false).setAttribute("ruzhu_session", ruzhu_session);
		mv.addObject("storeBo", store);
		return mv;
	}

	/***
	 * 修改重新提交修改保存
	 * 
	 * @param request
	 * @param response
	 * @param applyVO
	 * @param storeId
	 * @return
	 */
	@RequestMapping("seller_apply/group/supplier_update.htm")
	public ModelAndView supplier_update(HttpServletRequest request, HttpServletResponse response,
			StoreApplyVO applyVO, Long storeId) {
		ModelAndView mv = null;
			mv = new JModelAndView("gongyingshang/chakansehngpijindu.html",
				configService.getSysConfig(), 1, request, response);
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		
		String ruzhu_session = CommUtil.null2String(request.getSession(false).getAttribute("ruzhu_session"));
		
		if (ruzhu_session.equals("")) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "禁止重复提交!");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
			return mv;
		}
		request.getSession(false).removeAttribute("ruzhu_session");
		if (storeId == null) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "参数错误!");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
			return mv;
		}

		try {
			this.storeService.supplierUpdate(applyVO, storeId, user.getId());
		} catch (ServiceException e) {

			e.printStackTrace();
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", e.getErrorCode());
			return mv;
		}
		StoreBO store = storeService.getStoreStatus(storeId);
		mv.addObject("store", store);
		return mv;
	}

	@RequestMapping("/seller_apply/verifyOperatorCode.htm")
	public void operateNumber(HttpServletRequest request, HttpServletResponse response, String code) {
		code = code.toUpperCase();
		// 同步运营商等级
		// 更新运营商等级
		OperatorBO operator = operatorService.queryOperatorByLoginName(code);
		if (operator != null) {
			boolean isCN = this.userAccountService.check_User_Is_CN(operator.getUserId());
			// CN账户获取基本信息前的检验
			if (isCN) {
				try {
					operatorService.updateCnLevel(code);// 更新CN运营商等级信息
					log.info("[updateCnLevel] cnName=" + code);
				} catch (Exception e) {
					log.error("can't [updateCnLevel] cnName=" + code + e);
				}
			}
		}
		Integer res = this.storeService.checkOperateNo(code);

		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * 验证会员身份
	 * @param request
	 * @param response
	 */
	@RequestMapping("/seller_apply/validateUserSellerType.htm")
	public void validateUserSellerType(HttpServletRequest request, HttpServletResponse response){
		Integer result = 0;
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		StoreBO store=this.storeService.fetchStoreByCreateUserId(user.getId());

		if (store != null && store.getIsO2o()) {
			result = 1;
		}
		if (store != null && store.getIsShop()) {
			result = 2;
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		System.out.println("=========================================888888888888888888888888888888888888=========="+result);
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
