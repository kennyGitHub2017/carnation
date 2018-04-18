package vc.thinker.b2b2c.action.self;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.WebForm;

import com.sinco.carnation.goods.GoodsConstants;
import com.sinco.carnation.goods.bo.GoodsFormatBO;
import com.sinco.carnation.goods.model.GoodsFormat;
import com.sinco.carnation.goods.service.GoodsFormatService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: GoodsFormatManageAction.java
 * </p>
 * 
 * <p>
 * Description: 商品版式管理控制器，用来管理自营商品的版式
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
 * @date 2014-10-29
 * 
 * @version 1.0.1
 */
@Controller
public class SelfGoodsFormatManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private UserService userService;
	@Autowired
	private GoodsFormatService goodsFormatService;

	@SecurityMapping(title = "商品版式列表", value = "/admin/goods_format_list.htm*", rtype = "admin", rname = "商品版式", rcode = "goods_format_self", rgroup = "商城管理")
	@RequestMapping("/admin/goods_format_list.htm")
	public ModelAndView goodsFormatList(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String orderBy, String orderType) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_format_list.html",
				configService.getSysConfig(), 0, request, response);

		MyPage<GoodsFormatBO> page = new MyPage<GoodsFormatBO>();

		this.goodsFormatService.list(page, GoodsConstants.GOODS_FORMAT_SELF);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		return mv;
	}

	@SecurityMapping(title = "商品版式添加", value = "/admin/goods_format_add.htm*", rtype = "admin", rname = "商品版式", rcode = "goods_format_self", rgroup = "商城管理")
	@RequestMapping("/admin/goods_format_add.htm")
	public ModelAndView goods_format_add(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_format_add.html", configService.getSysConfig(),
				0, request, response);

		return mv;
	}

	@SecurityMapping(title = "商品版式编辑", value = "/admin/goods_format_edit.htm*", rtype = "admin", rname = "商品版式", rcode = "goods_format_self", rgroup = "商城管理")
	@RequestMapping("/admin/goods_format_edit.htm")
	public ModelAndView goods_format_edit(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_format_add.html", configService.getSysConfig(),
				0, request, response);
		GoodsFormat obj = this.goodsFormatService.getObjById(CommUtil.null2Long(id));
		mv.addObject("obj", obj);
		return mv;
	}

	@SecurityMapping(title = "商品版式保存", value = "/admin/goods_format_save.htm*", rtype = "admin", rname = "商品版式", rcode = "goods_format_self", rgroup = "商城管理")
	@RequestMapping("/admin/goods_format_save.htm")
	public ModelAndView goods_format_save(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage) {
		WebForm wf = new WebForm();
		if (CommUtil.null2String(id).equals("")) {
			GoodsFormat obj = wf.toPo(request, GoodsFormat.class);
			obj.setAddTime(new Date());
			obj.setGfCat(1);
			this.goodsFormatService.save(obj);
		} else {
			GoodsFormat obj = this.goodsFormatService.getObjById(CommUtil.null2Long(id));
			GoodsFormat gf = (GoodsFormat) wf.toPo(request, obj);
			this.goodsFormatService.update(gf);
		}
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/goods_format_list.htm?currentPage="
				+ currentPage);
		mv.addObject("op_title", "商品版式保存成功");
		return mv;
	}

	@SecurityMapping(title = "商品版式删除", value = "/admin/goods_format_delete.htm*", rtype = "admin", rname = "商品版式", rcode = "goods_format_self", rgroup = "商城管理")
	@RequestMapping("/admin/goods_format_delete.htm")
	public String goods_format_delete(HttpServletRequest request, String mulitId, String currentPage) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!id.equals("")) {
				GoodsFormat obj = this.goodsFormatService.getObjById(CommUtil.null2Long(id));
				if (obj.getGfCat() == 1) {
					this.goodsFormatService.delete(CommUtil.null2Long(id));
				}
			}
		}
		return "redirect:goods_format_list.htm?currentPage=" + currentPage;
	}
}
