package vc.thinker.b2b2c.action.sale;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.weedfs.client.WeedFSClient;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.AdminUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.goldEgg.service.ActGlodEggService;
import com.sinco.carnation.goldEgg.service.GlodEggItemService;
import com.sinco.carnation.market.bo.ActivityHotSaleBO;
import com.sinco.carnation.market.bo.ActivitySaleMessageBO;
import com.sinco.carnation.market.bo.ActivitySaleMessageTemplateBO;
import com.sinco.carnation.market.model.ActivityHotSale;
import com.sinco.carnation.market.model.ActivitySaleMessageTemplate;
import com.sinco.carnation.market.service.ActivitySaleMessageTemplateService;
import com.sinco.carnation.market.service.SaleActivityMessageService;
import com.sinco.carnation.market.service.SaleActivityService;
import com.sinco.carnation.market.vo.ActivityHotSaleVO;
import com.sinco.carnation.market.vo.ActivitySaleMessageTemplateVO;
import com.sinco.carnation.sys.contants.ActAppHotSaleContant;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.common.utils.DateUtils;
import com.sinco.dal.common.MyPage;

@Controller
public class SaleAction {

	@Autowired
	protected SysConfigService configService;

	@Autowired
	private SaleActivityService saleActivityService;

	@Autowired
	private WeedFSClient fsClient;

	@Autowired
	private ActGlodEggService actGlodEggService;

	@Autowired
	private GlodEggItemService glodEggItemService;

	@Autowired
	private ActivitySaleMessageTemplateService activitySaleMessageTemplateService;

	@Autowired
	private AccessoryServiceImpl accessoryService;

	@Autowired
	private SaleActivityMessageService saleActivityMessageService;

	@SecurityMapping(title = "热销活动管理列表", value = "/admin/hot_sale_list.htm*", rtype = "admin", rname = "活动管理", rcode = "market_hot_sale_admin", rgroup = "营销")
	@RequestMapping("/admin/hot_sale_list.htm")
	public ModelAndView hotSaleList(HttpServletRequest request, HttpServletResponse response,
			ActivityHotSaleVO vo, MyPage<ActivityHotSaleBO> myPage) {
		ModelAndView mv = new JModelAndView("admin/blue/act/act_sale_list.html",
				configService.getSysConfig(), 0, request, response);
		vo.setVcode(ActAppHotSaleContant.act_vecode_6);

		saleActivityService.findAllByPage(vo, myPage);

		mv.addObject("vo", vo);
		CommUtil.saveIPageList2ModelAndView("", "", "", myPage, mv);
		return mv;
	}

	@SecurityMapping(title = "活动新增", value = "/admin/hot_sale_add.htm*", rtype = "admin", rname = "活动管理", rcode = "market_hot_sale_admin", rgroup = "营销")
	@RequestMapping("/admin/hot_sale_add.htm")
	public ModelAndView hotSaleAdd(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/act/act_sale_edit.html",
				configService.getSysConfig(), 0, request, response);
		return mv;
	}

	@SecurityMapping(title = "活动编辑", value = "/admin/hot_sale_edit.htm*", rtype = "admin", rname = "活动管理", rcode = "market_hot_sale_admin", rgroup = "营销")
	@RequestMapping("/admin/hot_sale_edit.htm")
	public ModelAndView hotSaleEdit(HttpServletRequest request, HttpServletResponse response, Long id) {
		ModelAndView mv = new JModelAndView("admin/blue/act/act_sale_edit.html",
				configService.getSysConfig(), 0, request, response);

		ActivityHotSaleBO hotSaleBO = saleActivityService.findById(id);
		if (hotSaleBO != null) {
			ActivitySaleMessageBO saleMessageBO = saleActivityMessageService.getSaleMessageByActId(hotSaleBO
					.getId());
			if (saleMessageBO != null) {
				if (saleMessageBO.getTemplateId() != null) {
					ActivitySaleMessageTemplateBO saleTemplateBO = activitySaleMessageTemplateService
							.getById(saleMessageBO.getTemplateId());
					// 模板
					mv.addObject("saleTemplate", saleTemplateBO);
				} else {
					mv.addObject("saleTemplate", new ActivitySaleMessageTemplateBO());
				}
				// 弹框
				mv.addObject("saleMessage", saleMessageBO);
			} else {
				mv.addObject("saleMessage", new ActivitySaleMessageBO());
			}
			// 活动
			mv.addObject("hotSale", hotSaleBO);
		} else {
			mv.addObject("hotSale", new ActivityHotSaleBO());
		}
		return mv;
	}

	@SecurityMapping(title = "活动删除", value = "/admin/hot_sale_del.htm*", rtype = "admin", rname = "活动管理", rcode = "market_hot_sale_admin", rgroup = "营销")
	@RequestMapping("/admin/hot_sale_del.htm")
	public ModelAndView hotSaleDel(HttpServletRequest request, HttpServletResponse response, String id) {
		ActivityHotSale sale = new ActivityHotSale();
		sale.setId(Long.parseLong(id));
		sale.setDeleteStatus((byte) 1);
		this.saleActivityService.getActivityHotSaleDao().update(sale);

		// this.actGlodEggService.deleteByActID(Long.parseLong(id));
		return new ModelAndView("redirect:/admin/hot_sale_list.htm");
	}

	@SecurityMapping(title = "活动保存", value = "/admin/hot_sale_save.htm*", rtype = "admin", rname = "活动管理", rcode = "market_hot_sale_admin", rgroup = "营销")
	@RequestMapping("/admin/hot_sale_save.htm")
	public ModelAndView hotSaleSave(ActivityHotSaleVO hotSale, HttpServletRequest request,
			HttpServletResponse response) {
		AdminUserDetails user = (AdminUserDetails) SecurityUserHolder.getCurrentUserDetails();
		// hotSale.setAlterPic(uploadImage(alterPic1));
		// hotSale.setHeadImage(uploadImage(headImage1));
		// hotSale.setFootImage(uploadImage(footImage1));
		// hotSale.setFloatPic(uploadImage(floatPic1));
		if (hotSale == null || hotSale.getSaleMessage() == null
				|| hotSale.getSaleMessage().getTemplateId() == null) {
			ModelAndView mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0,
					request, response);
			mv.addObject("op_title", "参数错误");
			return mv;
		}
		if (hotSale.getId() != null) {
			ActivityHotSaleBO hotSaleBO = saleActivityService.findById(hotSale.getId());
			hotSale.setUpdateMark(hotSaleBO.getUpdateMark() + 1);
		}

		hotSale.setVcode(ActAppHotSaleContant.act_vecode_6);
		hotSale.setStartTime(DateUtils.parseDate(hotSale.getStrStartTime()));
		hotSale.setEndTime(DateUtils.parseDate(hotSale.getStrEndTime()));
		hotSale.setFirstImage(hotSale.getAlterPic());
		if (hotSale.getId() == null) {
			hotSale.setCreateBy(user.getId());
			hotSale.setCreateTime(new Date());
		} else {
			hotSale.setModifyBy(user.getId());
			hotSale.setModifyTime(new Date());
		}
		if (hotSale.getIsEnabled() == null) {
			hotSale.setIsEnabled((byte) 0);
		}
		if (hotSale.getFirstOpen() == null) {
			hotSale.setFirstOpen(false);
		}
		if (hotSale.getCustomOpen() == null) {
			hotSale.setCustomOpen(false);
		}
		saleActivityService.save(hotSale);

		ActivitySaleMessageBO saleMessageBO = saleActivityMessageService.getSaleMessageByActId(hotSale
				.getId());
		if (saleMessageBO != null) {
			hotSale.getSaleMessage().setId(saleMessageBO.getId());
			hotSale.getSaleMessage().setActId(saleMessageBO.getActId());
		} else {
			hotSale.getSaleMessage().setActId(hotSale.getId());
		}
		// saleMessage.setSharePic(uploadImage(sharePic1));
		hotSale.getSaleMessage().setShareUrl(hotSale.getAdsUrl());
		saleActivityMessageService.save(hotSale.getSaleMessage());
		return new ModelAndView("redirect:/admin/hot_sale_list.htm");
	}

	@SecurityMapping(title = "选择活动模板", value = "/admin/hot_sale_template.htm*", rtype = "admin", rname = "活动管理", rcode = "market_hot_sale_admin", rgroup = "营销")
	@RequestMapping("/admin/hot_sale_template.htm")
	public ModelAndView hotSaleTemplate(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/act/act_sale_template_select.html",
				configService.getSysConfig(), 0, request, response);

		return mv;
	}

	@SecurityMapping(title = "活动模板列表", value = "/admin/act_sale_template_list.htm*", rtype = "admin", rname = "活动管理", rcode = "market_hot_sale_admin", rgroup = "营销")
	@RequestMapping(value = "/admin/act_sale_template_list.htm")
	public ModelAndView activeTempleList(HttpServletRequest request, HttpServletResponse response,
			ActivitySaleMessageTemplateVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/act/act_sale_template_list.html",
				configService.getSysConfig(), 0, request, response);
		MyPage<ActivitySaleMessageTemplateBO> page = new MyPage<>();
		page.setPageSize(200);
		activitySaleMessageTemplateService.findAllByPage(vo, page);
		mv.addObject("objs", page.getContent());
		return mv;
	}

	@SecurityMapping(title = "活动模板选择页面", value = "/admin/act_sale_template_choose.htm*", rtype = "admin", rname = "活动管理", rcode = "market_hot_sale_admin", rgroup = "营销")
	@RequestMapping(value = "/admin/act_sale_template_choose.htm")
	public ModelAndView activeTempleChoose(HttpServletRequest request, HttpServletResponse response,
			ActivitySaleMessageTemplateVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/act/act_sale_template_choose.html",
				configService.getSysConfig(), 0, request, response);
		MyPage<ActivitySaleMessageTemplateBO> page = new MyPage<>();
		page.setPageSize(200);
		activitySaleMessageTemplateService.findAllByPage(vo, page);
		mv.addObject("objs", page.getContent());
		return mv;
	}

	@RequestMapping(value = "/admin/act_sale_template_edit.htm")
	public ModelAndView act_sale_template_edit(HttpServletRequest request, HttpServletResponse response,
			ActivitySaleMessageTemplateVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/act/act_sale_template_edit.html",
				configService.getSysConfig(), 0, request, response);
		if (vo != null && vo.getId() != null) {
			ActivitySaleMessageTemplate obj = activitySaleMessageTemplateService.findOne(vo.getId());
			mv.addObject("obj", obj);
		}
		return mv;
	}

	/**
	 * 添加/编辑活动模板 add by yuleijia on 2017.3.14
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/admin/act_sale_template_save.htm", method = RequestMethod.POST)
	public ModelAndView actSaleTemplateSave(HttpServletRequest request, HttpServletResponse response,
			ActivitySaleMessageTemplateVO vo) {
		String picture = request.getParameter("templateImage");
		if (StringUtils.isNotEmpty(picture)) {
			vo.setPicture(picture);
		}
		Long userId = SecurityUserHolder.getCurrentUserId();
		Date nowDate = new Date();
		vo.setDeleteStatus(false);
		vo.setCreateBy(userId);
		vo.setCreateTime(nowDate);
		vo.setModifyTime(nowDate);
		vo.setModifyBy(userId);
		this.activitySaleMessageTemplateService.save(vo);
		return new ModelAndView("redirect:/admin/act_sale_template_list.htm");
	}

	@SecurityMapping(title = "活动模板删除", value = "/admin/act_sale_template_delete.htm*", rtype = "admin", rname = "活动管理", rcode = "market_hot_sale_admin", rgroup = "营销")
	@RequestMapping(value = "/admin/act_sale_template_delete.htm")
	public ModelAndView activeTempleDelete(HttpServletRequest request, HttpServletResponse response,
			ActivitySaleMessageTemplateVO vo) {
		Long userId = SecurityUserHolder.getCurrentUserId();
		// 验证是否可以删除（只要是关联了模板就不能删除，就算是活动已经失效）
		List<ActivityHotSaleBO> list = saleActivityService.findAll();
		if (list != null) {
			boolean hasDel = false;
			// 当前模板正在被实用时不可删除
			for (ActivityHotSaleBO bo : list) {
				ActivitySaleMessageBO saleMessageBO = saleActivityMessageService.getSaleMessageByActId(bo
						.getId());
				if (saleMessageBO != null && null != saleMessageBO.getTemplateId()
						&& saleMessageBO.getTemplateId() == vo.getId()) {
					hasDel = true;
				}
			}
			if (hasDel) {
				ModelAndView mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0,
						request, response);
				mv.addObject("op_title", "模板使用中，不可以删除");
				return mv;
			}
		}

		if (vo == null || userId == null) {
			return activeTempleList(request, response, vo);
		}
		if (vo.getId() != null) {
			Date nowDate = new Date();
			vo.setDeleteStatus(true);
			vo.setModifyTime(nowDate);
			vo.setModifyBy(userId);
			this.activitySaleMessageTemplateService.save(vo);
		}
		return activeTempleList(request, response, vo);
	}
}
