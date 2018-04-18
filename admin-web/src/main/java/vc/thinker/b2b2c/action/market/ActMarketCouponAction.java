package vc.thinker.b2b2c.action.market;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.elasticsearch.common.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.action.admin.BaseManageAction;
import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.market.bo.ActCouponGetInfoBO;
import com.sinco.carnation.market.bo.ActMarketCouponBO;
import com.sinco.carnation.market.service.ActMarketCouponGetService;
import com.sinco.carnation.market.service.ActMarketCouponService;
import com.sinco.carnation.market.vo.ActCouponGetInfoVO;
import com.sinco.carnation.market.vo.ActMarketCouponVO;
import com.sinco.carnation.operation.service.CouponInfoService;
import com.sinco.carnation.operation.service.CouponService;
import com.sinco.dal.common.MyPage;

@Controller
public class ActMarketCouponAction extends BaseAction {

	@SuppressWarnings("unused")
	private final Logger log = LoggerFactory.getLogger(BaseManageAction.class);

	@Autowired
	private ActMarketCouponService actMarketCouponService;

	@Autowired
	private CouponService couponService;

	@Autowired
	private CouponInfoService couponInfoService;

	@Autowired
	private ActMarketCouponGetService actMarketCouponGetService;

	@SecurityMapping(title = "优惠券管理列表", value = "/admin/market_coupon_setList.htm*", rtype = "admin", rname = "优惠券管理", rcode = "market_coupon_setList_admin", rgroup = "优惠券管理")
	@RequestMapping("/admin/market_coupon_setList.htm")
	public ModelAndView marketCouponSetList(HttpServletRequest request, HttpServletResponse response,
			ActMarketCouponVO vo, MyPage<ActMarketCouponBO> myPage, Integer size, Integer page) {
		ModelAndView mv = new JModelAndView("admin/blue/market_coupon/market_coupon_list.html",
				configService.getSysConfig(), 0, request, response);

		if (page == null)
			page = 1;
		if (size == null)
			size = myPage.getPageSize();

		myPage.setPageSize(size);
		myPage.setPageNumber(page);

		// getRedPackageDefaultVo(vo);//查询状态
		mv.addObject("vo", vo);

		this.actMarketCouponService.findAllByPage(vo, myPage);
		CommUtil.saveIPageList2ModelAndView("", "", "", myPage, mv);

		/*mv.addObject("statusMap", EmRedPackageStatus.GetMap(EnumUtil.NewEnumMap("状态")));
		mv.addObject("terminalTypeMap", EmTerminalType.GetMap(EnumUtil.NewEnumMap("终端类型")));
		mv.addObject("actPositionMap", EmActPosition.GetMap(EnumUtil.NewEnumMap("活动位置")));
		mv.addObject("repPackageGetTypeMap", EmRepPackageGetType.GetMap(null));
		mv.addObject("repPackageUserTypeMap", EmRepPackageUserType.GetMap(null));*/
		mv.addObject("actMarketCouponGetTools", actMarketCouponGetService);

		return mv;
	}

	@SecurityMapping(title = "新增优惠券", value = "/admin/market_coupon_add.htm*", rtype = "admin", rname = "优惠券管理", rcode = "market_coupon_add_admin", rgroup = "优惠券")
	@RequestMapping("/admin/market_coupon_add.htm")
	public ModelAndView marketCouponAdd(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/market_coupon/market_coupon_add.html",
				configService.getSysConfig(), 0, request, response);

		ActMarketCouponBO bo = new ActMarketCouponBO();
		bo.setPerLimitCount(1L);

		mv.addObject("obj", bo);
		return mv;
	}

	@SecurityMapping(title = "创建优惠券", value = "/admin/market_coupon_save.htm*", rtype = "admin", rname = "优惠券管理", rcode = "market_coupon_save_admin", rgroup = "优惠券")
	@RequestMapping("/admin/market_coupon_save.htm")
	public ModelAndView marketCouponSave(HttpServletRequest request, HttpServletResponse response,
			ActMarketCouponVO vo) throws UnsupportedEncodingException {

		if (vo.getIsEnabled() == null) {
			vo.setIsEnabled((byte) 0);
		}

		try {
			actMarketCouponService.saveOrCreate(request, vo);
		} catch (Exception e) {
			// e.printStackTrace();
			return new JModelAndView("redirect:/admin/market_coupon_setList.htm?message="
					+ URLEncoder.encode(e.getMessage(), "utf-8"));

		}

		return new ModelAndView("redirect:/admin/market_coupon_setList.htm");
	}

	@SecurityMapping(title = "优惠券活动编辑", value = "/admin/market_coupon_edit.htm*", rtype = "admin", rname = "优惠券管理", rcode = "market_coupon_edit_admin", rgroup = "营销")
	@RequestMapping("/admin/market_coupon_edit.htm")
	public ModelAndView marketCouponEdit(HttpServletRequest request, HttpServletResponse response, Long id) {
		ModelAndView mv = new JModelAndView("admin/blue/market_coupon/market_coupon_add.html",
				configService.getSysConfig(), 0, request, response);

		mv.addObject("obj", this.actMarketCouponService.findById(id));

		return mv;
	}

	@SecurityMapping(title = "优惠券活动删除", value = "/admin/market_coupon_delete.htm*", rtype = "admin", rname = "优惠券管理", rcode = "market_coupon_delete_admin", rgroup = "营销")
	@RequestMapping("/admin/market_coupon_delete.htm")
	public ModelAndView marketCouponDelete(HttpServletRequest request, HttpServletResponse response, String id)
			throws UnsupportedEncodingException {
		ActMarketCouponVO vo = new ActMarketCouponVO();
		if (StringUtils.isNotBlank(id)) {
			vo.setId(new Long(id));
			try {
				actMarketCouponService.deleteRecord(vo);
			} catch (Exception e) {
				// e.printStackTrace();
				return new JModelAndView("redirect:/admin/market_coupon_setList.htm?message="
						+ URLEncoder.encode(e.getMessage(), "utf-8"));
			}
		}

		return new ModelAndView("redirect:/admin/market_coupon_setList.htm");
	}

	@SecurityMapping(title = "优惠券活动启用", value = "/admin/market_coupon_enable.htm*", rtype = "admin", rname = "优惠券管理", rcode = "market_coupon_enable_admin", rgroup = "营销")
	@RequestMapping("/admin/market_coupon_enable.htm")
	public ModelAndView marketCouponEnable(HttpServletRequest request, HttpServletResponse response, Long id,
			byte isEnabled) {
		actMarketCouponService.handleEnable(id, isEnabled);

		return new ModelAndView("redirect:/admin/market_coupon_setList.htm");
	}

	@SecurityMapping(title = "优惠券领取列表", value = "/admin/coupon_get_list.htm*", rtype = "admin", rname = "优惠券领取查询", rcode = "coupon_get_list_getRecord", rgroup = "营销")
	@RequestMapping("/admin/coupon_get_list.htm")
	public ModelAndView couponMarketGetList(HttpServletRequest request, HttpServletResponse response,
			String currentPage, ActCouponGetInfoVO vo, MyPage<ActCouponGetInfoBO> myPage, Integer size,
			Integer page) {
		ModelAndView mv = new JModelAndView("admin/blue/market_coupon/market_coupon_get_list.html",
				configService.getSysConfig(), 0, request, response);
		if (page == null)
			page = 1;
		if (size == null)
			size = myPage.getPageSize();
		myPage.setPageSize(size);
		myPage.setPageNumber(page);

		mv.addObject("vo", vo);

		this.actMarketCouponGetService.findAllByPage(vo, myPage);
		CommUtil.saveIPageList2ModelAndView("", "", "", myPage, mv);

		return mv;
	}

}
