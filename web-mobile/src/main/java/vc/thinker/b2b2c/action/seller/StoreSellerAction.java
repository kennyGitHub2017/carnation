package vc.thinker.b2b2c.action.seller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.weedfs.client.WeedFSClient;

import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.constant.UploadConstants;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.FileUploadTools;

import com.sinco.carnation.goods.model.GoodsClass;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.goods.tools.StoreTools;
import com.sinco.carnation.o2o.model.GroupClass;
import com.sinco.carnation.o2o.service.GroupClassService;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.store.model.StoreGrade;
import com.sinco.carnation.store.model.StoreSlide;
import com.sinco.carnation.store.service.StoreGradeService;
import com.sinco.carnation.store.service.StoreSearchService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.store.service.StoreSlideService;
import com.sinco.carnation.store.vo.StoreSlideVO;
import com.sinco.carnation.store.vo.StoreVO;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.carnation.user.service.UserOwnService;

/**
 * 
 * <p>
 * Title: StoreSellerAction.java
 * </p>
 * 
 * <p>
 * Description: 卖家中心店铺控制器
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
 * @author thinker
 * 
 * @date 2014-4-25
 * 
 * @version 1.0.1
 */
@Controller
public class StoreSellerAction {
	@Autowired
	private SysConfigService configService;
//	@Autowired
//	private IUserConfigService userConfigService;
	@Autowired
	private StoreGradeService storeGradeService;
	@Autowired
	private AreaServiceImpl areaService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private UserService userService;
//	@Autowired
//	private IRoleService roleService;
	@Autowired
	private GoodsClassService goodsClassService;
//	@Autowired
//	private IAccessoryService accessoryService;
	@Autowired
	private StoreSlideService storeSlideService;
	@Autowired
	private StoreTools storeTools;
	// @Autowired
	// private AreaViewTools areaViewTools;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private WeedFSClient fsClient;
	@Autowired
	private GroupClassService groupClassService;

	@Autowired
	private StoreSearchService searchService;
	@Autowired
	private UserOwnService userOwnService;

	@SecurityMapping(title = "店铺设置", value = "/seller/store_set.htm*", rtype = "seller", rname = "店铺设置", rcode = "store_set_seller", rgroup = "我的店铺")
	@RequestMapping("/seller/store_set.htm")
	public ModelAndView store_set(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/store_set.html",
				configService.getSysConfig(), 0, request, response);
		// 获取商户的商铺
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		Store store = new Store();
		if (userDetails != null) {
			if (userDetails.getStoreId() != null) {
				store = storeService.getObjById(userDetails.getStoreId());
			}
		}
		List<Area> areas = areaService.findParentArea();
		String fullName = "";
		if (store.getAreaId() != null) {
			fullName = areaService.fullName(store.getAreaId());
		}

		StoreGrade grade = storeGradeService.getObjById(store.getGradeId());
		if (store.getGcDetailInfo() != null) {// 店铺商品详细类目
			Set<GoodsClass> detail_gcs = this.storeTools.query_store_DetailGc(store.getGcDetailInfo());
			mv.addObject("detail_gcs", detail_gcs);
		}
		GoodsClass main_gc = this.goodsClassService.getObjById(store.getGcMainId());// 店铺商品主营类目

		GroupClass main_group = this.groupClassService.getObjById(store.getGroupMainId());// 店铺服务主营类目

		if (store.getGroupDetailInfo() != null && !store.getGroupDetailInfo().equals("")) {// 店铺服务详细类目
			Set<GroupClass> detail_groups = this.storeTools.query_o2o_store_DetailGc(store
					.getGroupDetailInfo());
			mv.addObject("detail_groups", detail_groups);
		}
		// 反润比例
		if (store.getCommissionRebate() != null) {
			NumberFormat num = NumberFormat.getPercentInstance();
			num.setMaximumIntegerDigits(3);
			num.setMaximumFractionDigits(2);
			mv.addObject("rebate", num.format(store.getCommissionRebate()));
		}
		// 所属运营商
		// String operatorName = userService.findOperatorNameByUid(userDetails.getId());
		Integer ownType = 1;
		mv.addObject("operatorName", this.userOwnService.getUserName(store.getCreateUserId(),ownType));

		mv.addObject("main_gc", main_gc);
		mv.addObject("main_group", main_group);
		mv.addObject("store", store);
		mv.addObject("grade", grade);
		mv.addObject("areas", areas);
		mv.addObject("fullName", fullName);
		mv.addObject("seller", sellerService.findByUid(userDetails.getSeller().getUid()));
		return mv;
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	@SecurityMapping(title = "店铺设置保存", value = "/seller/store_set_save.htm*", rtype = "seller", rname = "店铺设置", rcode = "store_set_seller", rgroup = "我的店铺")
	@RequestMapping("/seller/store_set_save.htm")
	public void store_set_save(HttpServletRequest request, HttpServletResponse response, StoreVO vo,
			String mobile, @RequestParam("logo") MultipartFile logoFile,
			@RequestParam("banner") MultipartFile bannerFile,
			@RequestParam("logocover") MultipartFile coverFile) {
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		Store store = new Store();
		if (userDetails != null) {
			if (userDetails.getStoreId() != null) {
				store = storeService.getObjById(userDetails.getStoreId());
			}
		}
		storeService.storeSetSave(store, vo, mobile, logoFile, bannerFile, coverFile, userDetails.getSeller().getUid());
		searchService.updateIndex(userDetails.getStoreId());

		Map json = new HashMap();
		json.put("ret", true);
		json.put("op_title", "店铺设置成功");
		json.put("url", CommUtil.getURL(request) + "/seller/store_set.htm");
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(json, JsonFormat.compact()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	/**
//	 * 店铺二级域名申请
//	 * 
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws IOException
//	 */
//	@SecurityMapping(title = "店铺二级域名申请", value = "/seller/store_sld.htm*", rtype = "seller", rname = "二级域名", rcode = "store_sld_seller", rgroup = "我的店铺")
//	@RequestMapping("/seller/store_sld.htm")
//	public ModelAndView store_sld(HttpServletRequest request,
//			HttpServletResponse response) throws IOException {
//		ModelAndView mv = new JModelAndView(
//				"user/default/sellercenter/store_sld.html",
//				configService.getSysConfig(),
//				this.userConfigService.getUserConfig(), 0, request, response);
//		SysConfig sysconfig = this.configService.getSysConfig();
//		String serverName = request.getServerName();
//		if (serverName.equals("localhost") || CommUtil.isIp(serverName)
//				|| serverName.indexOf("www.") > 0) {
//			mv = new JModelAndView(
//					"user/default/sellercenter/seller_error.html",
//					configService.getSysConfig(),
//					this.userConfigService.getUserConfig(), 0, request,
//					response);
//			mv.addObject("op_title", "系统未绑定顶级域名，无法设定二级域名");
//			mv.addObject("url", CommUtil.getURL(request) + "/seller/index.htm");
//		} else {
//			if (sysconfig.isSecond_domain_open()) {
//				User user = this.userService.getObjById(SecurityUserHolder
//						.getCurrentUser().getId());
//				user = user.getParent() == null ? user : user.getParent();
//				Store store = user.getStore();
//				String store_second_domain = "";
//				if (!CommUtil.null2String(store.getStore_second_domain())
//						.equals("")) {
//					store_second_domain = store.getStore_second_domain() + "."
//							+ CommUtil.generic_domain(request);
//				} else {
//					store_second_domain = user.getUsername() + "."
//							+ CommUtil.generic_domain(request);
//				}
//				mv.addObject("store_second_domain",
//						store_second_domain.split("\\.")[0]);
//				mv.addObject("store", store);
//				mv.addObject("serverName", serverName.substring(4));
//			} else {
//				mv = new JModelAndView(
//						"user/default/sellercenter/seller_error.html",
//						configService.getSysConfig(),
//						this.userConfigService.getUserConfig(), 0, request,
//						response);
//				mv.addObject("op_title", "系统未开启二级域名");
//				mv.addObject("url", CommUtil.getURL(request)
//						+ "/seller/index.htm");
//			}
//		}
//
//		return mv;
//	}
//
//	/**
//	 * 二级域名申请保存成功
//	 * 
//	 * @param request
//	 * @param response
//	 * @return
//	 */
//	@SecurityMapping(title = "二级域名申请保存", value = "/seller/store_sld_save.htm*", rtype = "seller", rname = "二级域名", rcode = "store_sld_seller", rgroup = "我的店铺")
//	@RequestMapping("/seller/store_sld_save.htm")
//	public String store_sld_save(HttpServletRequest request,
//			HttpServletResponse response, String store_second_domain) {
//		User user = this.userService.getObjById(SecurityUserHolder
//				.getCurrentUser().getId());
//		user = user.getParent() == null ? user : user.getParent();
//		Store store = user.getStore();
//		WebForm wf = new WebForm();
//		wf.toPo(request, store);
//		if (this.configService.getSysConfig().isSecond_domain_open()
//				&& this.configService.getSysConfig().getDomain_allow_count() > store
//						.getDomain_modify_count()) {
//			if (!CommUtil.null2String(store_second_domain).equals("")
//					&& !store_second_domain.equals(store
//							.getStore_second_domain())) {
//				store.setStore_second_domain(store_second_domain);
//				store.setDomain_modify_count(store.getDomain_modify_count() + 1);
//			}
//		}
//		this.storeService.update(store);
//		request.getSession(false).setAttribute("url",
//				CommUtil.getURL(request) + "/seller/store_sld.htm");
//		request.getSession(false).setAttribute("op_title", "店铺二级域名设置成功");
//		return "redirect:/seller/success.htm";
//	}
//
//	/**
//	 * 店铺二级域名验证
//	 * 
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws IOException
//	 */
//	@SecurityMapping(title = "店铺二级域名验证", value = "/seller/store_sld_verify.htm*", rtype = "seller", rname = "二级域名", rcode = "store_sld_seller", rgroup = "我的店铺")
//	@RequestMapping("/seller/store_sld_verify.htm")
//	public void store_sld_verify(HttpServletRequest request,
//			HttpServletResponse response, String sld_name, String store_id)
//			throws IOException {
//		SysConfig sysconfig = this.configService.getSysConfig();
//		User user = this.userService.getObjById(SecurityUserHolder
//				.getCurrentUser().getId());
//		user = user.getParent() == null ? user : user.getParent();
//		Store store = user.getStore();
//		boolean ret = true;
//		for (String domain : CommUtil.str2list(sysconfig.getSys_domain())) {// 系统限定域名不可以绑定
//			if (domain.equals(sld_name)) {
//				ret = false;
//				break;
//			}
//		}
//		if (sysconfig.getDomain_allow_count() > 0
//				&& store.getDomain_modify_count() >= sysconfig
//						.getDomain_allow_count()) {// 超过系统允许修改的次数，不允许修改
//			ret = false;
//		}
//		Map params = new HashMap();
//		params.put("store_second_domain", CommUtil.null2String(sld_name));
//		params.put("store_id", CommUtil.null2Long(store_id));
//		List<Store> stores = this.storeService
//				.query("select obj from Store obj where obj.store_second_domain=:store_second_domain and obj.id!=:store_id",
//						params, -1, -1);
//		if (stores.size() > 0) {
//			ret = false;
//		}
//		response.setContentType("text/plain");
//		response.setHeader("Cache-Control", "no-cache");
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter writer;
//		try {
//			writer = response.getWriter();
//			writer.print(ret);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	@SecurityMapping(title = "店铺幻灯", value = "/seller/store_slide.htm*", rtype = "seller", rname = "店铺设置", rcode = "store_set_seller", rgroup = "我的店铺")
	@RequestMapping("/seller/store_slide.htm")
	public ModelAndView store_slide(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/store_slide.html",
				configService.getSysConfig(), 0, request, response);
		StoreSlideVO vo = new StoreSlideVO();
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		if (userDetails != null) {
			if (userDetails.getStoreId() != null) {
				vo.setStoreId(userDetails.getStoreId());
			}
		}
		vo.setSlideType("0");
		List<StoreSlide> slides = storeSlideService.findListByVo(vo);
		mv.addObject("slides", slides);
		return mv;
	}

	@SecurityMapping(title = "店铺幻灯上传窗口", value = "/seller/store_slide_upload.htm*", rtype = "seller", rname = "店铺设置", rcode = "store_set_seller", rgroup = "我的店铺")
	@RequestMapping("/seller/store_slide_upload.htm")
	public ModelAndView store_slide_upload(HttpServletRequest request, HttpServletResponse response,
			String index) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/store_slide_upload.html",
				configService.getSysConfig(), 0, request, response);
		// 获取商户的商铺
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		Store store = new Store();
		if (userDetails != null) {
			if (userDetails.getStoreId() != null) {
				store = storeService.getObjById(userDetails.getStoreId());
			}
		}
		mv.addObject("store", store);
		mv.addObject("index", CommUtil.null2Int(index));
		return mv;
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	@SecurityMapping(title = "店铺幻灯保存", value = "/seller/store_slide_save.htm*", rtype = "seller", rname = "店铺设置", rcode = "store_set_seller", rgroup = "我的店铺")
	@RequestMapping("/seller/store_slide_save.htm")
	public void store_slide_save(HttpServletRequest request, HttpServletResponse response, String index,
			String accUrl, @RequestParam("acc") MultipartFile accFile) {
		StoreSlideVO vo = new StoreSlideVO();
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		Store store = new Store();
		if (userDetails != null) {
			if (userDetails.getStoreId() != null) {
				store = storeService.getObjById(userDetails.getStoreId());
				vo.setStoreId(userDetails.getStoreId());
			}
		}
		vo.setSlideType("0");
		List<StoreSlide> slides = storeSlideService.findListByVo(vo);
//		String uploadFilePath = this.configService.getSysConfig()
//				.getUploadFilePath();
//		String saveFilePathName = request.getSession().getServletContext()
//				.getRealPath("/")
//				+ uploadFilePath
//				+ File.separator
//				+ "store_slide"
//				+ File.separator + store.getId();
//		if (!CommUtil.fileExist(saveFilePathName)) {
//			CommUtil.createFolder(saveFilePathName);
//		}
		StoreSlide slide = null;
		if (slides.size() >= CommUtil.null2Int(index)) {
//			fileName = slides.get(CommUtil.null2Int(index) - 1).getAcc()
//					.getName();
			slide = slides.get(CommUtil.null2Int(index) - 1);
		}
		// 图片上传开始logo
		if (accFile != null && accFile.getSize() != 0) {
			try {
				String fileUrl=FileUploadTools.fileUpload(accFile, UploadConstants.EDITOR);
				store.setStoreLogoPath(fileUrl);
				if (slide == null) {
					slide = new StoreSlide();
					slide.setAccPath(fileUrl);
					slide.setAddTime(new Date());
					slide.setStoreId(store.getId());
					slide.setSlideType(0);
					slide.setUrl(accUrl);
					this.storeSlideService.save(slide);
				} else {
					slide.setAccPath(fileUrl);
					slide.setUrl(accUrl);
					this.storeSlideService.update(slide);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Map json = new HashMap();
		json.put("ret", true);
		json.put("op_title", "店铺幻灯设置成功");
		json.put("url", CommUtil.getURL(request) + "/seller/store_slide.htm");
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(json, JsonFormat.compact()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
