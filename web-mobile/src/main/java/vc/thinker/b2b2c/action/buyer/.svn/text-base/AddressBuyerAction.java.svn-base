package vc.thinker.b2b2c.action.buyer;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.WebForm;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.integral.service.IntegralGoodsOrderService;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.model.Address;
import com.sinco.carnation.user.service.AddressService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: AddressBuyerAction.java
 * </p>
 * 
 * <p>
 * Description:买家中心地址管理控制器，该控制用来添加、修改、删除地址、设置常用地址
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
 * @date 2014-9-17
 * 
 * @version 1.0.1
 */
@Controller
public class AddressBuyerAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private AreaServiceImpl areaService;
	@Autowired
	private IntegralGoodsOrderService igorder;

	/**
	 * Address列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "收货地址列表", value = "/buyer/address.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/address.htm")
	public ModelAndView address(HttpServletRequest request, HttpServletResponse response,
			MyPage<Address> page, String currentPage) {

		/*ModelAndView mv = new JModelAndView("user/default/usercenter/address.html",configService.getSysConfig(), 0, request, response);*/
		ModelAndView mv = new JModelAndView("web_mobile/addressList.html", configService.getSysConfig(), 1,
				request, response);
		String url = this.configService.getSysConfig().getAddress();
		if (url == null || url.equals(""))
			url = CommUtil.getURL(request);

		List<Address> list = addressService.queryByUserId(SecurityUserHolder.getCurrentUserId());
//		CommUtil.saveIPageList2ModelAndView(url + "/buyer/address.htm", "",
//				params, pList, mv);
//		CommUtil.saveIPageList2ModelAndView(url + "/buyer/address.htm", "", "", page, mv);
		mv.addObject("areas", areaService.getAllParentIsNull());
		mv.addObject("addresses", list);
		return mv;
	}

	@SecurityMapping(title = "新增收货地址", value = "/buyer/address_add.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/address_add.htm")
	public ModelAndView address_add(HttpServletRequest request, HttpServletResponse response,
			String currentPage) {

		/*		ModelAndView mv = new JModelAndView("user/default/usercenter/address_add.html", configService.getSysConfig(), 0, request, response);*/
		ModelAndView mv = new JModelAndView("web_mobile/editorAddress.html", configService.getSysConfig(), 1,
				request, response);

		mv.addObject("areas", areaService.getAllParentIsNull());
		mv.addObject("currentPage", currentPage);
		return mv;
	}

//
	@SecurityMapping(title = "编辑收货地址", value = "/buyer/address_edit.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/address_edit.htm")
	public ModelAndView address_edit(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {

		/*		ModelAndView mv = new JModelAndView("user/default/usercenter/address_add.html",configService.getSysConfig(), 0, request, response);*/
		ModelAndView mv = new JModelAndView("web_mobile/editorAddress.html", configService.getSysConfig(), 1,
				request, response);

		List<Area> areas = areaService.getAllParentIsNull();
		Address obj = this.addressService.getObjById(CommUtil.null2Long(id));
		mv.addObject("obj", obj);
		mv.addObject("areas", areas);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

//
	/**
	 * address保存管理
	 * 
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@SecurityMapping(title = "收货地址保存", value = "/buyer/address_save.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/address_save.htm")
	public String address_save(HttpServletRequest request, HttpServletResponse response, String id,
			String area_id, String currentPage) throws ServiceException {
		WebForm wf = new WebForm();
		Address address = null;
		if (id.equals("")) {
			address = wf.toPo(request, Address.class);
			address.setUserId(SecurityUserHolder.getCurrentUserId());
		} else {
			Address obj = addressService.getObjById(Long.parseLong(id));
			if (obj.getUserId().equals(SecurityUserHolder.getCurrentUser().getId())) {// 只允许修改自己的地址信息
				address = (Address) wf.toPo(request, obj);
			}
		}
		addressService.save(address, SecurityUserHolder.getCurrentUserId());
		return "redirect:/buyer/address.htm";
	}

	@SecurityMapping(title = "收货地址删除", value = "/buyer/address_del.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/address_del.htm")
	public void address_del(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		// 先查询是否为最后一个
		List<Address> list = addressService.queryByUserId(SecurityUserHolder.getCurrentUser().getId());
		if (list != null && list.size() < 2)// 如果是，则不允许删除
		{
			try {
				response.getWriter().print("0");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			Address address = addressService.getObjById(Long.parseLong(id));
			if (address.getUserId().equals(SecurityUserHolder.getCurrentUser().getId())) // 只允许删除自己的地址信息
			{
				// 判断是否为默认收货地址
				if (address.getDefaultVal())// 如果是，则删除后把下一个设置为默认
				{
					addressService.deleteAndSetDefault(Long.parseLong(id),
							SecurityUserHolder.getCurrentUserId());
				} else {
					addressService.delete(Long.parseLong(id));
				}
			}
			try {
				response.getWriter().print("1");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

//
	@SecurityMapping(title = "收货地址默认设置", value = "/buyer/address_default.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/address_default.htm")
	public String address_default(HttpServletRequest request, HttpServletResponse response, Long id,
			String currentPage) {
		addressService.setDefaultAddress(id, SecurityUserHolder.getCurrentUserId());
		return "redirect:/buyer/address.htm";
	}

}