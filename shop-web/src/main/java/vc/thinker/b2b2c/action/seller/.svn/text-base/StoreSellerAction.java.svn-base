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

import net.weedfs.client.RequestResult;
import net.weedfs.client.WeedFSClient;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.helper.StringUtil;
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

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.goods.model.GoodsClass;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.goods.tools.StoreTools;
import com.sinco.carnation.o2o.model.GroupClass;
import com.sinco.carnation.o2o.service.GroupClassService;
import com.sinco.carnation.store.bo.StoreApplyInfoBO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.constants.StoreConstants;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.store.model.StoreGrade;
import com.sinco.carnation.store.model.StoreSlide;
import com.sinco.carnation.store.service.StoreGradeService;
import com.sinco.carnation.store.service.StoreSearchService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.store.service.StoreSlideService;
import com.sinco.carnation.store.vo.StoreApplyVO;
import com.sinco.carnation.store.vo.StoreSlideVO;
import com.sinco.carnation.store.vo.StoreVO;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.bo.SellerBO;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.carnation.user.service.UserOwnService;
import com.sinco.dic.client.DicContent;

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
	@Autowired
	private DicContent dicContent;
	
	@Autowired
	private UserAccountService userAccountService;

	@SecurityMapping(title = "店铺设置", value = "/seller/store_set.htm*", rtype = "seller", rname = "店铺设置", rcode = "store_set_seller", rgroup = "我的店铺")
	@RequestMapping("/seller/store_set.htm")
	public ModelAndView store_set(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/store_set.html",
				configService.getSysConfig(), 0, request, response);
		// 获取商户的商铺
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		StoreBO store = new StoreBO();
		if (userDetails != null) {
			if (userDetails.getStoreId() != null) {
				store = storeService.getObjById(userDetails.getStoreId());
			}
		}
			
		if (StringUtil.isBlank(store.getStoreName())//判断必须填的数据 是否补充完整
				|| StringUtil.isBlank(store.getStoreLogoPath())
				|| StringUtil.isBlank(store.getStoreCoverPath())
				|| StringUtil.isBlank(store.getMobile())) {
			
			System.out.println(store.getStoreName()+"---"+store.getStoreLogoPath()+"--"+store.getStoreCoverPath()+"-----"+store.getMobile());
			
			mv.addObject("storeSet", "false");
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
		Integer ownType=1;
		mv.addObject("operatorName", this.userOwnService.getUserName(store.getCreateUserId(),ownType));

		mv.addObject("main_gc", main_gc);
		mv.addObject("main_group", main_group);
		mv.addObject("store", store);
		mv.addObject("grade", grade);
		mv.addObject("areas", areas);
		mv.addObject("fullName", fullName);
		//供应商的发货短信提醒不是默认该会员绑定的手机号，是在店铺设置里填写短信提醒的手机号  单号：1056
		SellerBO seller = sellerService.findByUid(userDetails.getSeller().getUid());
		if(seller!=null)
		{
			String mobile = seller.getMobile();
			if(mobile==null || mobile.trim().length() <= 0)
			{
				UserAccountBO userAccount = new UserAccountBO();
				userAccount.setUid(userDetails.getSeller().getUid());
				userAccount.setAccountType(UserContant.ACCOUNT_TYPE_2);
				UserAccountBO phoneUserAccount = this.userAccountService.findAccountByVo(userAccount);
				if(phoneUserAccount!=null)
				{
					String mobile_ = phoneUserAccount.getLoginName();
					seller.setMobile(mobile_);
				}
			}
		}
		mv.addObject("seller", seller);
		return mv;
	}

	@SecurityMapping(title = "商户申请pos机", value = "/seller/store_info_save.htm*", rtype = "seller", rname = "店铺设置", rcode = "store_set_seller", rgroup = "我的店铺")
	@RequestMapping("/seller/store_info_save.htm")
	public String store_info_save(HttpServletRequest request, HttpServletResponse response,
			StoreApplyVO applyVO) {

		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		StoreBO store = storeService.queryStoreStatus(user.getId(),true,false);
		try {
			if (store != null) {
				if (store.getStoreStatus() >= StoreConstants.STORE_STATUS_SHOP_AUDIT_SUCCESS
						&& !store.getIsEepay()) {
					applyVO.setIsEepay(Boolean.TRUE);
					this.storeService.applyStoreForPos(applyVO, user.getId(), store.getId());
				}
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return "redirect:index.htm";
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
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

	@SuppressWarnings({"unchecked", "rawtypes", "unused"})
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
			RequestResult result;
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

	@SecurityMapping(title = "认证信息", value = "/seller/store_info.htm*", rtype = "seller", rname = "店铺信息", rcode = "store_set_seller", rgroup = "我的店铺")
	@RequestMapping("/seller/store_info.htm")
	public ModelAndView store_info(HttpServletRequest request, HttpServletResponse response, Long id) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/store_info.html",
				configService.getSysConfig(), 0, request, response);

		if (null != id && id > 0) {

			StoreBO store = this.storeService.getObjById(id);
			StoreApplyInfoBO storeInfo = this.storeService.getStoreApplyInfoBO(id);
			GroupClass gc = this.groupClassService.getObjById(store.getGroupMainId());
			Set<GroupClass> groupClassDetailSet = this.storeTools.queryStoreDetailInfo(store
					.getGroupDetailInfo());
			Long bankAreaId = store.getBankAreaId();
			Long areaId = store.getAreaId();
			setViewArea(mv, areaId); // 详细地址
			setViewBankArea(mv, bankAreaId);// 银行地址
			String[] otherPhotos = null;
			if (storeInfo != null) {
				String otherphoto = storeInfo.getOtherPhotoPath();
				if (StringUtils.isNotEmpty(otherphoto)) {
					otherPhotos = otherphoto.split(";");
				}
			}
			List<Area> areas = this.areaService.queryParentArea();
			mv.addObject("areas", areas);
			mv.addObject("groupClassDetail", groupClassDetailSet);
			mv.addObject("groupClass_main", gc);
			mv.addObject("store", store);
			mv.addObject("storeInfo", storeInfo);
			mv.addObject("otherPhotos", otherPhotos);
			Integer ownType=1;
			mv.addObject("operatorName", this.userOwnService.getUserName(store.getCreateUserId(),ownType));
			mv.addObject("groupClassList", groupClassService.findCacheLevelAll());
			mv.addObject("subGroupClassList", groupClassService.findCahceByParent(store.getGroupMainId()));
			mv.addObject("StoreConstants", new StoreConstants());

		}

		return mv;
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
