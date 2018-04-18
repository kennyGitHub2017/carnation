package vc.thinker.b2b2c.action.seller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.carnation.goods.bo.GoodsFormatBO;
import com.sinco.carnation.goods.model.GoodsFormat;
import com.sinco.carnation.goods.service.GoodsFormatService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

/**
 * 
 * <p>
 * Title: GoodsFormatSellerAction.java
 * </p>
 * 
 * <p>
 * Description: 商品顶部、底部版式管理控制器
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
 * @date 2014-10-19
 * 
 * @version 1.0.1
 */
@Controller
public class GoodsFormatSellerAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private GoodsFormatService goodsFormatService;

	@SecurityMapping(title = "卖家商品版式列表", value = "/seller/goods_format_list.htm*", rtype = "seller", rname = "版式管理", rcode = "goods_format_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods_format_list.htm")
	public ModelAndView goods_format_list(HttpServletRequest request, HttpServletResponse response,
			MyPage<GoodsFormatBO> page) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/goods_format_list.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		goodsFormatService.selectBOPageByStoreId(page, userDetails.getSeller().getStoreId());
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		return mv;
	}

	@SecurityMapping(title = "卖家商品版式添加", value = "/seller/goods_format_add.htm*", rtype = "seller", rname = "版式管理", rcode = "goods_format_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods_format_add.htm")
	public ModelAndView goods_format_add(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/goods_format_add.html",
				configService.getSysConfig(), 0, request, response);
		return mv;
	}

	@SecurityMapping(title = "卖家商品版式编辑", value = "/seller/goods_format_edit.htm*", rtype = "seller", rname = "版式管理", rcode = "goods_format_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods_format_edit.htm")
	public ModelAndView goods_format_edit(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/goods_format_add.html",
				configService.getSysConfig(), 0, request, response);
		GoodsFormat obj = this.goodsFormatService.getObjById(CommUtil.null2Long(id));
		mv.addObject("obj", obj);
		return mv;
	}

	@SecurityMapping(title = "卖家商品版式保存", value = "/seller/goods_format_save.htm*", rtype = "seller", rname = "版式管理", rcode = "goods_format_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods_format_save.htm")
	public void goods_format_save(HttpServletRequest request, HttpServletResponse response,
			GoodsFormat goodsFormat) {
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		boolean ret = true;
		if (goodsFormat.getId() == null) {
			goodsFormat.setAddTime(new Date());
			goodsFormat.setGfStoreId(userDetails.getSeller().getStoreId());
			ret = this.goodsFormatService.save(goodsFormat);
		} else {
			ret = this.goodsFormatService.update(goodsFormat);
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

	@SecurityMapping(title = "卖家商品版式删除", value = "/seller/goods_format_delete.htm*", rtype = "seller", rname = "版式管理", rcode = "goods_format_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods_format_delete.htm")
	public String goods_format_delete(HttpServletRequest request, String id, String currentPage) {
		if (!id.equals("")) {
			GoodsFormat obj = this.goodsFormatService.getObjById(CommUtil.null2Long(id));
			CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder
					.getCurrentUserDetails();
			if (obj.getGfStoreId().equals(userDetails.getSeller().getStoreId())) {
				this.goodsFormatService.delete(CommUtil.null2Long(id));
			}
		}
		return "redirect:goods_format_list.htm?currentPage=" + currentPage;
	}
}
