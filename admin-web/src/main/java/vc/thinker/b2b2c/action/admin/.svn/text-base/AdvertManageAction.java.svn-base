package vc.thinker.b2b2c.action.admin;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.weedfs.client.WeedFSClient;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.constant.UploadConstants;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.FileUploadTools;

import com.sinco.carnation.circle.service.InvitationServiceImpl;
import com.sinco.carnation.cms.service.InformationServiceImpl;
import com.sinco.carnation.o2o.model.GroupGoods;
import com.sinco.carnation.o2o.service.GroupGoodsService;
import com.sinco.carnation.recommend.service.AdvertPositionService;
import com.sinco.carnation.recommend.service.AdvertService;
import com.sinco.carnation.sns.bo.AdvertBO;
import com.sinco.carnation.sns.bo.InformationBO;
import com.sinco.carnation.sns.contants.AdvertContant;
import com.sinco.carnation.sns.model.Advert;
import com.sinco.carnation.sns.model.AdvertPosition;
import com.sinco.carnation.sns.model.CircleInvitation;
import com.sinco.carnation.sns.vo.AdvertPositionVO;
import com.sinco.carnation.sns.vo.AdvertVO;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

/**
 * <p>
 * Title: 广告管理action
 * </p>
 * <p>
 * Description: 商城广告管理器1.0版
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: 深圳市新科聚合网络技术有限公司 www.thinker.vc
 * </p>
 * 
 * @author thinker
 * @date 2014年5月27日
 * @version 1.0.1
 */
@Controller
public class AdvertManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private AdvertService advertService;
	@Autowired
	private AdvertPositionService advertPositionService;
	@Autowired
	private WeedFSClient fsClient;
	@Autowired
	private InformationServiceImpl informationService;
	@Autowired
	private InvitationServiceImpl invitationService;
	@Autowired
	private AreaServiceImpl areaService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private GroupGoodsService groupGoodsService;

	/**
	 * Advert列表页
	 * 
	 * @param request
	 * @param response
	 * @param vo
	 * @param page
	 * @return
	 */
	@SecurityMapping(title = "广告列表", value = "/admin/advert_list.htm*", rtype = "admin", rname = "广告管理", rcode = "advert_admin", rgroup = "内容管理")
	@RequestMapping("/admin/advert_list.htm")
	public ModelAndView advert_list(HttpServletRequest request, HttpServletResponse response, AdvertVO vo,
			MyPage<AdvertBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/advert_list.html", configService.getSysConfig(), 0,
				request, response);
		page.setPageSize(10);

		List<AdvertPosition> aps = advertPositionService.findAll();
		advertService.findPageByVO(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);

		mv.addObject("vo", vo);
		mv.addObject("aps", aps);

		return mv;
	}

	/**
	 * 待审批广告
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param ad_title
	 * @return
	 */
	@SecurityMapping(title = "待审批广告列表", value = "/admin/advert_list_audit.htm*", rtype = "admin", rname = "广告管理", rcode = "advert_admin", rgroup = "内容管理")
	@RequestMapping("/admin/advert_list_audit.htm")
	public ModelAndView advert_list_audit(HttpServletRequest request, HttpServletResponse response,
			AdvertVO vo, MyPage<AdvertBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/advert_list_audit.html",
				configService.getSysConfig(), 0, request, response);
		page.setPageSize(10);
		vo.setAdStatus(AdvertContant.AD_STATUS_NO_AUDIT);
		advertService.findPageByVO(vo, page);
		List<AdvertPosition> aps = advertPositionService.findAll();
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);

		mv.addObject("vo", vo);
		mv.addObject("aps", aps);
		return mv;
	}

	/**
	 * advert添加管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "广告增加", value = "/admin/advert_add.htm*", rtype = "admin", rname = "广告管理", rcode = "advert_admin", rgroup = "内容管理")
	@RequestMapping("/admin/advert_add.htm")
	public ModelAndView advert_add(HttpServletRequest request, HttpServletResponse response,AdvertVO advertVo,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/advert_add.html", configService.getSysConfig(), 0,
				request, response);
		/*List<AdvertPosition> aps = advertPositionService.findByRelease(2);*/
		List<AdvertPosition> aps = advertPositionService.findList();
		// 省份列表
		List<Area> provinces = this.areaService.getAllParentIsNull();
		mv.addObject("provinces", provinces);
		mv.addObject("aps", aps);
		mv.addObject("currentPage", currentPage);
		mv.addObject("vo", advertVo);
		return mv;
	}

	/**
	 * advert编辑管理
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "广告编辑", value = "/admin/advert_edit.htm*", rtype = "admin", rname = "广告管理", rcode = "advert_admin", rgroup = "内容管理")
	@RequestMapping("/admin/advert_edit.htm")
	public ModelAndView advert_edit(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/advert_add.html", configService.getSysConfig(), 0,
				request, response);
		if (id != null && !id.equals("")) {
			String originalTitle = null;
			AdvertBO advert = advertService.getBoById(Long.parseLong(id));
			AdvertPosition advertPosition = advertPositionService.getObjById(advert.getAdApId());
			List<AdvertPosition> aps = advertPositionService.findByRelease(advertPosition.getReleaseType());

			if (advert.getAdUrl() != null && advert.getAdType() != null
					&& CommUtil.isNumeric(advert.getAdUrl())) {
				if (advert.getAdType().equals(AdvertContant.ADVERT_TPYE_INFOMATION)) {// 当是资讯的情况
					CircleInvitation circleInvitation = invitationService.getObjById(Long.parseLong(advert
							.getAdUrl()));
					if (circleInvitation != null) {
						originalTitle = circleInvitation.getTitle();
					}
				} else if (advert.getAdType().equals(AdvertContant.ADVERT_TPYE_JG_PROJECT)) {// 当是云尚项目的情况
					InformationBO information = informationService.findById(CommUtil.null2Long(advert
							.getAdUrl()));
					if (information != null) {
						originalTitle = information.getTitle();
					}
				}
			}
			// 省份列表
			List<Area> provinces = this.areaService.getAllParentIsNull();
			mv.addObject("provinces", provinces);
			if (null != advert.getAreaId()) {
				Area area = this.areaService.fetchAndAllParent(advert.getAreaId());
				mv.addObject("provinceId", area.getParentId());
			}
			mv.addObject("originalTitle", originalTitle);
			mv.addObject("aps", aps);
			mv.addObject("obj", advert);
			mv.addObject("currentPage", currentPage);
			mv.addObject("edit", true);
			mv.addObject("advcode", advertPosition.getApCode());
		}
		return mv;
	}

	/**
	 * 广告查看
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "广告查看", value = "/admin/advert_view.htm*", rtype = "admin", rname = "广告管理（审核）", rcode = "advert_admin_check", rgroup = "内容管理")
	@RequestMapping("/admin/advert_view.htm")
	public ModelAndView advert_view(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/advert_view.html", configService.getSysConfig(), 0,
				request, response);
		if (id != null && !id.equals("")) {
			AdvertBO advertBo = advertService.getBoById(CommUtil.null2Long(id));
			mv.addObject("obj", advertBo);
			mv.addObject("currentPage", currentPage);
		}
		return mv;
	}

	@SecurityMapping(title = "广告审核", value = "/admin/advert_audit.htm*", rtype = "admin", rname = "广告管理", rcode = "advert_admin", rgroup = "内容管理")
	@RequestMapping("/admin/advert_audit.htm")
	public ModelAndView advert_audit(HttpServletRequest request, HttpServletResponse response, String id,
			String adStatus, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		Advert advert = advertService.getObjById(CommUtil.null2Long(id));
		Integer status = CommUtil.null2Int(adStatus);
		if (adStatus != null
				&& (status == AdvertContant.AD_STATUS_PASS || status == AdvertContant.AD_STATUS_FAILE)) {
			advert.setAdStatus(status);
			advertService.update(advert);
		}
		mv.addObject("op_title", "广告审核成功");
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/advert_list_audit.htm");
		return mv;
	}

	/**
	 * advert保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "广告保存", value = "/admin/advert_save.htm*", rtype = "admin", rname = "广告管理", rcode = "advert_admin", rgroup = "内容管理")
	@RequestMapping("/admin/advert_save.htm")
	public ModelAndView advert_save(HttpServletRequest request, HttpServletResponse response,
			AdvertVO advertVo, @RequestParam("advertImg") MultipartFile file, String recommendType,
			String storeId, String groupId) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		if (advertVo != null) {
			Date beginDate = null;
			Date endDate = null;
			if (advertVo.getStrAdBeginDate() != null && advertVo.getStrAdBeginDate() != "") {
				beginDate = CommUtil.formatDate(advertVo.getStrAdBeginDate());
			}
			if (advertVo.getStrAdEndDate() != null && advertVo.getStrAdEndDate() != "") {
				endDate = CommUtil.formatDate(advertVo.getStrAdEndDate());
			}
			Advert advert = advertVo;
			advert.setAdBeginTime(beginDate);
			advert.setAdEndTime(endDate);
			if (file != null && file.getSize() != 0) {
				try {
					String fileUrl=FileUploadTools.fileUpload(file, UploadConstants.EDITOR);
					advert.setAdImgPath(fileUrl);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (advertVo.getId() != null && advertVo.getId() > 0) { // udapte
				advert.setAdStatus(0);
				advertService.update(advert);
			} else { // insert
				// 先把各种默认值设置为0
				advert.setAdClickNum(0);
				advert.setAdGold(0);
				advert.setAdStatus(0);
				advert.setAddTime(new Date());
				advert.setAdUserId(SecurityUserHolder.getCurrentUser().getId());
				if (advert.getAdSlideSequence() == null) {
					advert.setAdSlideSequence(0);
				}
				if (StringUtils.isNotEmpty(recommendType)) {
					if ("merchant".equals(recommendType)) {// 商户推广告
						if (StringUtils.isNotEmpty(storeId)) {
							Store store = this.storeService.getObjById(CommUtil.null2Long(storeId));
							if (null != store) {
								Area area = this.areaService.getObjById(store.getAreaId());
								if (area != null) {
									advert.setAreaId(area.getParentId());
								}
							}
						}
					} else if ("group".equals(recommendType)) {// 服务推广告
						if (StringUtils.isNotEmpty(groupId)) {
							GroupGoods groupGoods = this.groupGoodsService.getObjById(CommUtil
									.null2Long(groupId));
							if (null != groupGoods) {
								advert.setAreaId(groupGoods.getGgGaId());
							}
						}
					}
				}
				advertService.save(advert);
			}
		}
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/advert_list.htm");
		mv.addObject("op_title", "保存广告成功");
//		mv.addObject("add_url", CommUtil.getURL(request) + "/admin/advert_add.htm");
		return mv;
	}

	/**
	 * 广告删除
	 * 
	 * @param request
	 * @param mulitId
	 * @return
	 */
	@SecurityMapping(title = "广告删除", value = "/admin/advert_del.htm*", rtype = "admin", rname = "广告管理", rcode = "advert_admin", rgroup = "内容管理")
	@RequestMapping("/admin/advert_del.htm")
	public String advert_del(HttpServletRequest request, String mulitId) {
		String[] ids = mulitId.split(",");
		if (ids != null && ids.length > 0) {
			if (ids.length == 1) {
				advertService.delete(CommUtil.null2Long(ids[0]));
			} else {
				// 由于业务是有审核过的不给删除，所以这里暂不支持批量删除
			}
		}
		return "redirect:advert_list.htm";
	}

	/**
	 * 广告位添加
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "广告位添加", value = "/admin/adv_pos_add.htm*", rtype = "admin", rname = "广告管理", rcode = "advert_admin", rgroup = "内容管理")
	@RequestMapping("/admin/adv_pos_add.htm")
	public ModelAndView adv_pos_add(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/adv_pos_add.html", configService.getSysConfig(), 0,
				request, response);
		return mv;
	}

	/**
	 * 广告位保存
	 * 
	 * @param request
	 * @param response
	 * @param ap
	 * @param currentPage
	 * @param list_url
	 * @param add_url
	 * @param file
	 * @return
	 */
	@SecurityMapping(title = "广告位保存", value = "/admin/adv_pos_save.htm*", rtype = "admin", rname = "广告管理", rcode = "advert_admin", rgroup = "内容管理")
	@RequestMapping("/admin/adv_pos_save.htm")
	public ModelAndView adv_pos_save(HttpServletRequest request, HttpServletResponse response,
			AdvertPosition ap, String currentPage, String list_url, String add_url,
			@RequestParam("advertImg") MultipartFile file) {
		if (ap != null) {
			if (file != null && file.getSize() != 0) {
				try {
					String fileUrl=FileUploadTools.fileUpload(file, UploadConstants.ADV_POS);
					ap.setApImgPath(fileUrl);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (ap.getId() != null && ap.getId() > 0) {
				advertPositionService.update(ap);
			} else {
				ap.setApPrice(0);// 把暂时不用的价格的设成0
//				ap.setApStatus(0);
//				ap.setApSysType(0);
//				ap.setApShowType(0);
				ap.setApSaleType(0);// 由于广告位不暂时不能购买，统一设置为商城投放的广告类型
				ap.setApUseStatus(0);// 广告位使用状态，默认0， 即为空闲
				ap.setAddTime(new Date());
				advertPositionService.save(ap);
			}
		}
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", list_url);
		mv.addObject("op_title", "保存广告位成功");
		if (add_url != null) {
			mv.addObject("add_url", add_url + "?currentPage=" + currentPage);
		}
		return mv;
	}

	/**
	 * 广告位列表
	 * 
	 * @param request
	 * @param response
	 * @param vo
	 * @param page
	 * @return
	 */
	@SecurityMapping(title = "广告位列表", value = "/admin/adv_pos_list.htm*", rtype = "admin", rname = "广告管理", rcode = "advert_admin", rgroup = "内容管理")
	@RequestMapping("/admin/adv_pos_list.htm")
	public ModelAndView adv_pos_list(HttpServletRequest request, HttpServletResponse response,
			AdvertPositionVO vo, MyPage<AdvertPosition> page) {
		ModelAndView mv = new JModelAndView("admin/blue/adv_pos_list.html", configService.getSysConfig(), 0,
				request, response);

		page.setPageSize(10);

		advertPositionService.findPageByVO(vo, page);
		List<AdvertPosition> aps = advertPositionService.findAll();
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);

		mv.addObject("vo", vo);
		mv.addObject("aps", aps);
		return mv;
	}

	/**
	 * 广告位编辑
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "广告位编辑", value = "/admin/adv_pos_edit.htm*", rtype = "admin", rname = "广告管理", rcode = "advert_admin", rgroup = "内容管理")
	@RequestMapping("/admin/adv_pos_edit.htm")
	public ModelAndView adv_pos_edit(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/adv_pos_add.html", configService.getSysConfig(), 0,
				request, response);
		if (id != null && !id.equals("")) {
			AdvertPosition obj = this.advertPositionService.getObjById(Long.parseLong(id));
			mv.addObject("obj", obj);
			mv.addObject("currentPage", currentPage);
			mv.addObject("edit", true);
		}
		return mv;
	}

	/**
	 * 广告位删除
	 * 
	 * @param request
	 * @param response
	 * @param mulitId
	 * @return
	 */
	@SecurityMapping(title = "广告位删除", value = "/admin/adv_pos_del.htm*", rtype = "admin", rname = "广告管理", rcode = "advert_admin", rgroup = "内容管理")
	@RequestMapping("/admin/adv_pos_del.htm")
	public String adv_pos_del(HttpServletRequest request, HttpServletResponse response, String mulitId) {
		String[] ids = mulitId.split(",");
		if (ids != null && ids.length > 0) {
			if (ids.length == 1) {
				advertPositionService.delete(CommUtil.null2Long(ids[0]));
			} else {
				// 由于系统广告位不可删除,所以暂不支持批量删除
			}
		}
		return "redirect:adv_pos_list.htm";
	}

	@SecurityMapping(title = "广告排序", value = "/admin/advert_sort.htm*", rtype = "admin", rname = "广告管理", rcode = "advert_admin", rgroup = "内容管理")
	@RequestMapping("/admin/advert_sort.htm")
	public ModelAndView advert_sort(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/advert_sort.html", configService.getSysConfig(), 0,
				request, response);
		List<Advert> result = null;
		if (id != null && !id.equals("")) {
			result = advertService.findListByAdApId(CommUtil.null2Long(id));
		}
		mv.addObject("objs", result);
		mv.addObject("sort", true);
		return mv;
	}

	@SecurityMapping(title = "广告顺序保存", value = "/admin/advert_sort_save.htm*", rtype = "admin", rname = "广告管理", rcode = "advert_admin", rgroup = "内容管理")
	@RequestMapping("/admin/advert_sort_save.htm")
	public ModelAndView advert_sort_save(HttpServletRequest request, HttpServletResponse response,
			String idVals) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);

		List<Advert> list = null;
		if (idVals != null && idVals.length() > 0) {
			String[] idValArr = idVals.split(";");
			list = new ArrayList<Advert>(idValArr.length);
			for (String idValStrs : idValArr) {
				String[] idValStr = idValStrs.split(",");
				Advert ad = new Advert();
				ad.setId(CommUtil.null2Long(idValStr[0]));
				ad.setAdSlideSequence(CommUtil.null2Int(idValStr[1]));
				list.add(ad);
			}
			advertService.batchUpdate(list);
		}

		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/adv_pos_list.htm");
		mv.addObject("op_title", "保存广告顺序成功");

		return mv;
	}

	/**
	 * 广告冻结
	 * 
	 * @param request
	 * @param mulitId
	 * @return
	 */
	@SecurityMapping(title = "广告冻结", value = "/admin/advert_frozen.htm*", rtype = "admin", rname = "广告管理", rcode = "advert_admin", rgroup = "内容管理")
	@RequestMapping("/admin/advert_frozen.htm")
	public String advert_frozen(HttpServletRequest request, String mulitId) {
		String[] ids = mulitId.split(",");
		Advert advert = new Advert();
		advert.setId(CommUtil.null2Long(ids[0]));
		advert.setDeleteStatus(1);
		if (ids != null && ids.length > 0) {
			if (ids.length == 1) {
				advertService.update(advert);
				System.out.println("冰冻了！" + advert.getDeleteStatus());
			} else {
			}
		}
		return "redirect:advert_list.htm";
	}

	/**
	 * 广告解冻
	 * 
	 * @param request
	 * @param mulitId
	 * @return
	 */
	@SecurityMapping(title = "广告解冻", value = "/admin/advert_thaw.htm*", rtype = "admin", rname = "广告管理", rcode = "advert_admin", rgroup = "内容管理")
	@RequestMapping("/admin/advert_thaw.htm")
	public String advert_thaw(HttpServletRequest request, String mulitId) {
		String[] ids = mulitId.split(",");
		Advert advert = new Advert();
		advert.setId(CommUtil.null2Long(ids[0]));
		advert.setDeleteStatus(0);
		if (ids != null && ids.length > 0) {
			if (ids.length == 1) {
				advertService.update(advert);
				System.out.println("解冻了！" + advert.getDeleteStatus());
			} else {
			}
		}
		return "redirect:advert_list.htm";
	}

	/***
	 * 广告位 删除 {逻辑删除，即锁定解锁}
	 * 
	 * @param status
	 *            3：锁定
	 * @param id
	 * @return
	 * @author Kenny
	 */
	@SecurityMapping(title = "广告锁定", value = "/admin/locked_adv_pos.htm*", rtype = "admin", rname = "广告管理", rcode = "advert_admin", rgroup = "内容管理")
	@RequestMapping("/admin/locked_adv_pos.htm")
	public String locked_adv_pos(Integer status, Integer id) {
		this.advertPositionService.updateStatuaById(3, id);
		return "redirect:adv_pos_list.htm";

	}
}