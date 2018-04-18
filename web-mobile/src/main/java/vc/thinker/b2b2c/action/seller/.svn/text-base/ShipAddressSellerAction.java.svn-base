package vc.thinker.b2b2c.action.seller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.carnation.ship.service.ShipAddressService;
import com.sinco.carnation.shop.bo.ShipAddressBO;
import com.sinco.carnation.shop.constants.ShipAddressConstants;
import com.sinco.carnation.shop.model.ShipAddress;
import com.sinco.carnation.shop.vo.ShipAddressVO;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.DicContent;
import com.sinco.dic.client.model.DicBase;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

/**
 * 
 * <p>
 * Title: ShipAddressSellerAction.java
 * </p>
 * 
 * <p>
 * Description:卖家发货地址管理控制器，用来添加、删除、编辑卖家发货地址信息，发货地址主要用在发货设置、快递跟踪等
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
 * @date 2014-11-12
 * 
 * @version 1.0.1
 */
@Controller
public class ShipAddressSellerAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private ShipAddressService shipAddressService;
	@Autowired
	private AreaServiceImpl areaService;
	@Autowired
	private DicContent dicContent;

	@SecurityMapping(title = "发货地址列表", value = "/seller/ship_address.htm*", rtype = "seller", rname = "发货信息", rcode = "ship_address_seller", rgroup = "交易管理")
	@RequestMapping("/seller/ship_address.htm")
	public ModelAndView ship_address(HttpServletRequest request, HttpServletResponse response,
			ShipAddressVO vo, MyPage<ShipAddressBO> page) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/ship_address.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		page.setPageSize(10);
		vo.setSaUserId(user.getId());
		this.shipAddressService.findPageByVo(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("vo", vo);

		return mv;
	}

	@SecurityMapping(title = "新增发货地址", value = "/seller/ship_address_add.htm*", rtype = "seller", rname = "发货信息", rcode = "ship_address_seller", rgroup = "交易管理")
	@RequestMapping("/seller/ship_address_add.htm")
	public ModelAndView ship_address_add(HttpServletRequest request, HttpServletResponse response,
			String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/ship_address_add.html",
				configService.getSysConfig(), 0, request, response);
		List<Area> areas = dicContent.getRootDics(Area.class);
		mv.addObject("areas1", areas);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	@SecurityMapping(title = "编辑发货地址", value = "/seller/ship_address_add.htm*", rtype = "seller", rname = "发货信息", rcode = "ship_address_seller", rgroup = "交易管理")
	@RequestMapping("/seller/ship_address_edit.htm")
	public ModelAndView ship_address_edit(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/ship_address_add.html",
				configService.getSysConfig(), 0, request, response);
		ShipAddress obj = this.shipAddressService.getObjById(CommUtil.null2Long(id));
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		if (obj != null && obj.getSaUserId().equals(user.getId())) {
			Area a3 = this.areaService.getObjById(obj.getSaAreaId());// 县区级对象
			Area a2 = this.areaService.getObjById(a3.getParentId());// 市级对象
			Area a1 = this.areaService.getObjById(a2.getParentId());// 省级对象
			List<Area> areas1 = dicContent.getRootDics(Area.class);// 省级地区列表
			List<DicBase> areas2 = dicContent.getDicsByParentCode(Area.class,
					String.valueOf(a2.getParentId()));// 市级地区列表
			List<DicBase> areas3 = dicContent.getDicsByParentCode(Area.class, String.valueOf(a2.getId()));// 县区级地区列表
			mv.addObject("a1", a1);
			mv.addObject("a2", a2);
			mv.addObject("a3", a3);
			mv.addObject("areas1", areas1);
			mv.addObject("areas2", areas2);
			mv.addObject("areas3", areas3);
			mv.addObject("obj", obj);
			mv.addObject("currentPage", currentPage);
		} else {
			mv = new JModelAndView("user/default/sellercenter/seller_error.html",
					configService.getSysConfig(), 0, request, response);
			mv.addObject("url", "/seller/ship_address.htm");
			mv.addObject("op_title", "参数错误");
		}
		return mv;
	}

	@SecurityMapping(title = "发货地址保存", value = "/seller/ship_address_add.htm*", rtype = "seller", rname = "发货信息", rcode = "ship_address_seller", rgroup = "交易管理")
	@RequestMapping("/seller/ship_address_save.htm")
	public void ship_address_save(HttpServletRequest request, HttpServletResponse response,
			ShipAddress shipAddress, String currentPage) {
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		boolean ret = true;
		if (shipAddress != null) {
			if (shipAddress.getId() != null && shipAddress.getId() > 0) {
				ret = this.shipAddressService.update(shipAddress);
			} else {
				shipAddress.setAddTime(new Date());
				shipAddress.setDeleteStatus(false);
				shipAddress.setSaUserId(user.getId());
				ret = this.shipAddressService.save(shipAddress);
			}
		}

		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(ret);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SecurityMapping(title = "发货地址删除", value = "/seller/ship_address_del.htm*", rtype = "seller", rname = "发货信息", rcode = "ship_address_seller", rgroup = "交易管理")
	@RequestMapping("/seller/ship_address_del.htm")
	public String ship_address_del(HttpServletRequest request, HttpServletResponse response, String mulitId,
			String currentPage) {
		String[] ids = mulitId.split(",");
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		for (String id : ids) {
			if (!id.equals("")) {
				ShipAddress obj = this.shipAddressService.getObjById(CommUtil.null2Long(id));
				if (obj != null && obj.getSaType() == 0 && obj.getSaUserId().equals(user.getId())) {// 只能删除自己添加的发货地址
					this.shipAddressService.delete(obj.getId());
				}
			}
		}
		return "redirect:ship_address.htm?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "设置默认发货地址", value = "/seller/ship_address_default.htm*", rtype = "seller", rname = "发货信息", rcode = "ship_address_seller", rgroup = "交易管理")
	@RequestMapping("/seller/ship_address_default.htm")
	public String ship_address_default(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
//		Map params = new HashMap();
//		params.put("sa_default", 1);
//		params.put("sa_user_id", user.getId());
//		List<ShipAddress> sa_list = this.shipAddressService.query(
//				"select obj from ShipAddress obj where obj.sa_default=:sa_default and obj.sa_user_id=:sa_user_id",
//				params, -1, -1);

		List<ShipAddressBO> saList = this.shipAddressService.findAllByCondition(
				ShipAddressConstants.IS_SA_DEFAULT, user.getId());
		for (ShipAddress sa : saList) {
			sa.setSaDefault(false);
			this.shipAddressService.update(sa);
		}
		ShipAddress obj = this.shipAddressService.getObjById(CommUtil.null2Long(id));
		if (obj.getSaUserId().equals(user.getId())) {// 只能设置自己添加地址为默认地址
			obj.setSaDefault(true);
			this.shipAddressService.update(obj);
		}
		return "redirect:ship_address.htm?currentPage=" + currentPage;
	}
}
