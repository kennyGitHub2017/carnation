package vc.thinker.b2b2c.action.admin;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.ship.service.ShipAddressService;
import com.sinco.carnation.shop.bo.ShipAddressBO;
import com.sinco.carnation.shop.constants.ShipAddressConstants;
import com.sinco.carnation.shop.model.ShipAddress;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.DicContent;
import com.sinco.dic.client.model.DicBase;

/**
 * 
 * <p>
 * Title: ShipAddressManageAction.java
 * </p>
 * 
 * <p>
 * Description:自营商家发货地址管理控制器，用来管理自营发货地址信息
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
 * @date 2014-11-11
 * 
 * @version 1.0.1
 */
@Controller
public class ShipAddressManageAction {
	@Autowired
	private SysConfigService configService;

	@Autowired
	private ShipAddressService shipAddressService;

	@Autowired
	private AreaServiceImpl areaService;

	@Autowired
	private DicContent dicContent;

	/**
	 * ShipAddress列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 *            * @return
	 */
	@SecurityMapping(title = "自营发货地址列表", value = "/admin/ship_address_list.htm*", rtype = "admin", rname = "发货地址", rcode = "ship_adress", rgroup = "商城管理")
	@RequestMapping("/admin/ship_address_list.htm")
	public ModelAndView ship_address_list(HttpServletRequest request, HttpServletResponse response,
			MyPage<ShipAddressBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/ship_address_list.html",
				configService.getSysConfig(), 0, request, response);
		page.setPageSize(20);
		shipAddressService.queryShipAddress(ShipAddressConstants.SA_TYPE_ADMIN, page);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("objs", page.getContent());
		return mv;
	}

	/**
	 * shipaddress添加管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "自营发货地址添加", value = "/admin/ship_address_add.htm*", rtype = "admin", rname = "发货地址", rcode = "ship_adress", rgroup = "商城管理")
	@RequestMapping("/admin/ship_address_add.htm")
	public ModelAndView ship_address_add(HttpServletRequest request, HttpServletResponse response,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/ship_address_add.html", configService.getSysConfig(),
				0, request, response);
		List<Area> rootBases = dicContent.getRootDics(Area.class);

		mv.addObject("areas", rootBases);
		return mv;
	}

	/**
	 * shipaddress编辑管理
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "自营发货地址编辑", value = "/admin/ship_address_edit.htm*", rtype = "admin", rname = "发货地址", rcode = "ship_adress", rgroup = "商城管理")
	@RequestMapping("/admin/ship_address_edit.htm")
	public ModelAndView ship_address_edit(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/ship_address_update.html",
				configService.getSysConfig(), 0, request, response);
		if (id != null && !id.equals("")) {
			ShipAddress shipaddress = shipAddressService.getObjById(CommUtil.null2Long(id));
			List<Area> rootBases = dicContent.getRootDics(Area.class);// 第一级 省级
			Area area = areaService.queryAreaById(shipaddress.getSaAreaId());// 县级对象
			Area shijiArea = areaService.queryAreaById(area.getParentId());
			List<DicBase> erlist = dicContent.getDicsByParentCode(Area.class,
					String.valueOf(shijiArea.getParentId()));// 第二级
			List<DicBase> sanlist = dicContent.getDicsByParentCode(Area.class,
					String.valueOf(shijiArea.getId()));// 第三级
			mv.addObject("areas", rootBases);
			mv.addObject("obj", shipaddress);
			mv.addObject("area", area);
			mv.addObject("shijiArea", shijiArea);
			mv.addObject("erlist", erlist);
			mv.addObject("sanlist", sanlist);
			mv.addObject("edit", true);
		}
		return mv;
	}

	/**
	 * shipaddress保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "自营发货地址保存", value = "/admin/ship_address_save.htm*", rtype = "admin", rname = "发货地址", rcode = "ship_adress", rgroup = "商城管理")
	@RequestMapping("/admin/ship_address_save.htm")
	public ModelAndView ship_address_save(HttpServletRequest request, HttpServletResponse response,
			ShipAddressBO vo) {
		vo.setSaType(ShipAddressConstants.SA_TYPE_ADMIN);
		shipAddressService.shipAddress(vo);
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("op_title", "发货地址保存成功");
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/ship_address_list.htm?currentPage=1");
		mv.addObject("add_url", CommUtil.getURL(request) + "/admin/ship_address_add.htm?currentPage=1");
		return mv;
	}

	@SecurityMapping(title = "自营发货地址删除", value = "/admin/ship_address_del.htm*", rtype = "admin", rname = "发货地址", rcode = "ship_adress", rgroup = "商城管理")
	@RequestMapping("/admin/ship_address_del.htm")
	public String ship_address_del(HttpServletRequest request, HttpServletResponse response, String mulitId,
			String currentPage) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!id.equals("")) {
				ShipAddress obj = shipAddressService.getObjById(CommUtil.null2Long(id));
				if (obj.getSaType() == 1) {// 只能删除自营发货地址
					shipAddressService.delete(obj.getId());
				}
			}
		}
		return "redirect:ship_address_list.htm?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "设置默认发货地址", value = "/admin/ship_address_default.htm*", rtype = "admin", rname = "发货地址", rcode = "ship_adress", rgroup = "商城管理")
	@RequestMapping("/admin/ship_address_default.htm")
	public String ship_address_default(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ShipAddress obj = this.shipAddressService.getObjById(CommUtil.null2Long(id));
		if (obj.getSaType() == 1) {// 只能设置自营发货地址
			obj.setSaDefault(true);
			this.shipAddressService.update(obj);
		}
		return "redirect:ship_address_list.htm?currentPage=" + currentPage;
	}

}