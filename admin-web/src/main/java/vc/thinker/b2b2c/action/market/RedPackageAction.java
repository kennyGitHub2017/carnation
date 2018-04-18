package vc.thinker.b2b2c.action.market;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.AdminUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.IpAddressByDetails;

import com.sinco.carnation.market.bo.ActRedPackageBO;
import com.sinco.carnation.market.bo.RedPackageGetRecordBO;
import com.sinco.carnation.market.enums.EmActPosition;
import com.sinco.carnation.market.enums.EmFixType;
import com.sinco.carnation.market.enums.EmRedPackageStatus;
import com.sinco.carnation.market.enums.EmRepPackageGetStatus;
import com.sinco.carnation.market.enums.EmRepPackageGetType;
import com.sinco.carnation.market.enums.EmRepPackageGetUserMation;
import com.sinco.carnation.market.enums.EmRepPackageUserType;
import com.sinco.carnation.market.enums.EmTerminalType;
import com.sinco.carnation.market.enums.EnumUtil;
import com.sinco.carnation.market.service.ActRedPackageService;
import com.sinco.carnation.market.vo.ActRedPackageVO;
import com.sinco.carnation.market.vo.RedPackageGetRecordVO;
import com.sinco.dal.common.MyPage;

@Controller
public class RedPackageAction extends BaseAction {

	@SuppressWarnings("unused")
	private final Logger log = LoggerFactory.getLogger(RedPackageAction.class);

	@Autowired
	private ActRedPackageService actRedPackageService;

	@SecurityMapping(title = "红包管理列表", value = "/admin/red_package_list.htm*", rtype = "admin", rname = "红包管理", rcode = "market_red_package_admin", rgroup = "营销")
	@RequestMapping("/admin/red_package_list.htm")
	public ModelAndView redPackageList(HttpServletRequest request, HttpServletResponse response,
			ActRedPackageVO vo, MyPage<ActRedPackageBO> myPage, Integer size, Integer page) {
		ModelAndView mv = new JModelAndView("admin/blue/red_package/red_package_list.html",
				configService.getSysConfig(), 0, request, response);

		System.out.println(String.format("size:%s currentPage:%s", size, page));
		if (page == null)
			page = 1;
		if (size == null)
			size = myPage.getPageSize();

		myPage.setPageSize(size);
		myPage.setPageNumber(page);

		getRedPackageDefaultVo(vo);
		mv.addObject("vo", vo);

		this.actRedPackageService.findAllByPage(vo, myPage);
		CommUtil.saveIPageList2ModelAndView("", "", "", myPage, mv);

		mv.addObject("statusMap", EmRedPackageStatus.GetMap(EnumUtil.NewEnumMap("状态")));
		mv.addObject("terminalTypeMap", EmTerminalType.GetMap(EnumUtil.NewEnumMap("终端类型")));
		mv.addObject("actPositionMap", EmActPosition.GetMap(EnumUtil.NewEnumMap("活动位置")));
		mv.addObject("repPackageGetTypeMap", EmRepPackageGetType.GetMap(null));
		mv.addObject("repPackageUserTypeMap", EmRepPackageUserType.GetMap(null));
		mv.addObject("actRedPackageTools", actRedPackageService);

		return mv;
	}

	private void getRedPackageDefaultVo(ActRedPackageVO vo) {
		if (vo.getStatus() == null) {
			vo.setStatus(EnumUtil.NEW_ENUM_INT);
		}
		if (vo.getActPosition() == null) {
			vo.setActPosition(EnumUtil.NEW_ENUM_INT.toString());
		}
		if (vo.getTerminalType() == null) {
			vo.setTerminalType((byte) EnumUtil.NEW_ENUM_INT.intValue());
		}
	}

	@SecurityMapping(title = "红包新增", value = "/admin/red_package_add.htm*", rtype = "admin", rname = "红包管理", rcode = "market_red_package_admin", rgroup = "营销")
	@RequestMapping("/admin/red_package_add.htm")
	public ModelAndView redPackageAdd(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/red_package/red_package_add.html",
				configService.getSysConfig(), 0, request, response);

		mv.addObject("terminalTypeMap", EmTerminalType.GetMap(null));
		mv.addObject("actPositionMap", EmActPosition.GetMap(null));
		mv.addObject("fixTypeMap", EmFixType.GetMap(null));
		mv.addObject("repPackageGetTypeMap", EmRepPackageGetType.GetMap(null));
		mv.addObject("repPackageUserTypeMap", EmRepPackageUserType.GetMap(null));

		ActRedPackageBO bo = new ActRedPackageBO();
		Date dtNow = new Date();
		bo.setStartTime(CommUtil.getFirstDateOfCurrentMonth(dtNow));
		bo.setEndTime(CommUtil.getLastDateOfCurrentMonth(dtNow));
		bo.setPerLimitCount(1L);

		mv.addObject("obj", bo);

		return mv;
	}

	@SecurityMapping(title = "红包编辑", value = "/admin/red_package_edit.htm*", rtype = "admin", rname = "红包管理", rcode = "market_red_package_admin", rgroup = "营销")
	@RequestMapping("/admin/red_package_edit.htm")
	public ModelAndView redPackageEdit(HttpServletRequest request, HttpServletResponse response, Long id) {
		ModelAndView mv = new JModelAndView("admin/blue/red_package/red_package_add.html",
				configService.getSysConfig(), 0, request, response);

		mv.addObject("terminalTypeMap", EmTerminalType.GetMap(null));
		mv.addObject("actPositionMap", EmActPosition.GetMap(null));
		mv.addObject("fixTypeMap", EmFixType.GetMap(null));
		mv.addObject("repPackageGetTypeMap", EmRepPackageGetType.GetMap(null));
		mv.addObject("repPackageUserTypeMap", EmRepPackageUserType.GetMap(null));

		mv.addObject("obj", this.actRedPackageService.findRedPackageById(id));

		return mv;
	}

	@SecurityMapping(title = "红包删除", value = "/admin/red_package_del.htm*", rtype = "admin", rname = "红包管理", rcode = "market_red_package_admin", rgroup = "营销")
	@RequestMapping("/admin/red_package_del.htm")
	public ModelAndView redPackageDel(HttpServletRequest request, HttpServletResponse response, String id) {
		this.actRedPackageService.deleteRedPackage(id);

		return new ModelAndView("redirect:/admin/red_package_list.htm");
	}

	@SecurityMapping(title = "红包启用操作", value = "/admin/red_package_handle.htm*", rtype = "admin", rname = "红包管理", rcode = "market_red_package_admin", rgroup = "营销")
	@RequestMapping("/admin/red_package_handle.htm")
	public ModelAndView redPackageHandle(HttpServletRequest request, HttpServletResponse response, Long id,
			byte isEnabled) {
		this.actRedPackageService.handleRedPackage(id, isEnabled);

		return new ModelAndView("redirect:/admin/red_package_list.htm");
	}

	@SecurityMapping(title = "红包vcode是否唯一", value = "/admin/red_package_only.htm*", rtype = "admin", rname = "红包管理", rcode = "market_red_package_admin", rgroup = "营销")
	@RequestMapping("/admin/red_package_only.htm")
	@ResponseBody
	public String vcodeIsOnly(HttpServletRequest request, HttpServletResponse response, String vcode) {
		ActRedPackageBO bo = this.actRedPackageService.findOneByVcode(vcode);
		return (bo == null ? "true" : "false");
	}

	@SecurityMapping(title = "红包保存", value = "/admin/red_package_save.htm*", rtype = "admin", rname = "红包管理", rcode = "market_red_package_admin", rgroup = "营销")
	@RequestMapping("/admin/red_package_save.htm")
	public ModelAndView redPackageSave(HttpServletRequest request, HttpServletResponse response,
			ActRedPackageVO vo) {

		// 规则验证
		if (vo.getTotalMoney() == null || vo.getTotalMoney().compareTo(BigDecimal.ZERO) <= 0) {
			return super.returnError("红包金额不能为空并且必须大于零！", request, response);
		}
		// 红包生成类型 1-随机,2-固定(取min_money)
		if (vo.getFixType() == null) {
			return super.returnError("红包面额类型不能为空！", request, response);
		}

		if (vo.getMinMoney() == null) {
			return super.returnError("红包面额不能为空！", request, response);
		}

		if (vo.getTotalCount() == null || vo.getTotalCount() <= 0) {
			return super.returnError("红包发行量不能为空并且必须大于零！", request, response);
		}

		// 红包 红包平均金额 = 发行金额 /发行量
		BigDecimal avgMoney = vo.getTotalMoney().divide(BigDecimal.valueOf(vo.getTotalCount()));

		if (vo.getFixType() == EmFixType.Random.getValue()) {
			if (vo.getMinMoney() == null || vo.getMaxMoney() == null) {
				return super.returnError("红包面额范围不能为空！", request, response);
			}
			if (vo.getMinMoney().compareTo(vo.getMaxMoney()) > -1) {
				return super.returnError("红包面额范围设置错误！", request, response);
			}

			if (avgMoney.compareTo(vo.getMinMoney()) <= 0 || avgMoney.compareTo(vo.getMaxMoney()) >= 0) {
				return super.returnError("红包面额范围设置必须包含红包平均金额（发行金额 /发行量）！", request, response);
			}
			if (vo.getMaxMoney().compareTo(avgMoney.multiply(BigDecimal.valueOf(2L))) >= 0) {
				return super.returnError("红包面额最大值不能大于红包平均金额（发行金额 /发行量）的两倍！", request, response);
			}
		} else {
			vo.setMinMoney(avgMoney);
			vo.setMaxMoney(avgMoney);
		}
		AdminUserDetails user = (AdminUserDetails) SecurityUserHolder.getCurrentUserDetails();
		if (vo.getId() == null) {
			vo.setCreateBy(user.getId());
		} else {
			vo.setModifyBy(user.getId());
		}

		if (vo.getIsEnabled() == null) {
			vo.setIsEnabled((byte) 0);
		}

		try {
			this.actRedPackageService.save(request, vo);
		} catch (Exception e) {
			return super.returnError(e.getMessage(), request, response);
		}

		/*
		 * response.setContentType("text/plain");
		 * response.setHeader("Cache-Control", "no-cache");
		 * response.setCharacterEncoding("UTF-8"); PrintWriter writer; try {
		 * writer = response.getWriter(); writer.print("success"); } catch
		 * (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		return new ModelAndView("redirect:/admin/red_package_list.htm");
	}

	@SecurityMapping(title = "红包领取列表", value = "/admin/red_package_get_list.htm*", rtype = "admin", rname = "红包领取查询", rcode = "market_red_package_getRecord", rgroup = "营销")
	@RequestMapping("/admin/red_package_get_list.htm")
	public ModelAndView redPackageGetList(HttpServletRequest request, HttpServletResponse response,
			String currentPage, RedPackageGetRecordVO vo, MyPage<RedPackageGetRecordBO> myPage, Integer size,
			Integer page) {
		ModelAndView mv = new JModelAndView("admin/blue/red_package/red_package_get_list.html",
				configService.getSysConfig(), 0, request, response);
		if (page == null)
			page = 1;
		if (size == null)
			size = myPage.getPageSize();
		myPage.setPageSize(size);
		myPage.setPageNumber(page);

		getPackageGetDefaultVo(vo);
		mv.addObject("vo", vo);

		this.actRedPackageService.findAllByPage(vo, myPage);
		CommUtil.saveIPageList2ModelAndView("", "", "", myPage, mv);
		mv.addObject("actRedPackageTools", actRedPackageService);
		mv.addObject("statusMap", EmRepPackageGetStatus.GetMap(EnumUtil.NewEnumMap("所有状态")));
		mv.addObject("terminalTypeMap", EmRepPackageGetUserMation.GetMap(EnumUtil.NewEnumMap("请选择")));

		return mv;
	}

	@SecurityMapping(title = "红包ip查询", value = "/admin/red_package_get_ipdetail.htm*", rtype = "admin", rname = "红包领取查询", rcode = "market_red_package_getRecord", rgroup = "营销")
	@RequestMapping("/admin/red_package_get_ipdetail.htm")
	@ResponseBody
	public String redIpFind(HttpServletRequest request, HttpServletResponse response, String ip) {
		String ipdetail = "[---IP地址不正确!----]";
		if (ip != null && !ip.equals("") && ip.indexOf("0:0:0:0") < 0) {
			String[] split = ip.trim().split(",");
			ipdetail = IpAddressByDetails.GetAddressByIp(split[0].trim());
		}

		return ipdetail;
	}

	private void getPackageGetDefaultVo(RedPackageGetRecordVO vo) {
		if (vo.getStatus() == null) {
			vo.setStatus((byte) EnumUtil.NEW_ENUM_INT.intValue());
		}
	}

}
