package vc.thinker.b2b2c.action.seller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.goods.bo.GoodsYgClassBO;
import com.sinco.carnation.goods.service.GoodsYgClassService;
import com.sinco.carnation.goods.service.UserGoodsClassService;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.bo.UserGoodsClassBO;
import com.sinco.carnation.user.model.UserGoodsClass;
import com.sinco.carnation.user.vo.UserGoodsClassVO;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: GoodsClassSellerAction.java
 * </p>
 * 
 * <p>
 * Description: 商家后台商品分类管理
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
 * @author wangyujue、erikzhang
 * 
 * @date 2014-10-19
 * 
 * @version 1.0.1
 */
@Controller
public class GoodsClassSellerAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private UserGoodsClassService usergoodsclassService;
	@Autowired
	private AccessoryServiceImpl accessoryService;
	@Autowired
	private GoodsYgClassService goodsYgClassService;

	/**
	 * UserGoodsClass列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "卖家商品分类列表", value = "/seller/goods_class_list.htm*", rtype = "seller", rname = "商品分类", rcode = "goods_class_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods_class_list.htm")
	public ModelAndView goods_class_list(HttpServletRequest request, HttpServletResponse response,
			MyPage<UserGoodsClassBO> page, UserGoodsClassVO vo) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/goods_class_list.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		page.setPageSize(20);

		vo.setUserId(userDetails.getUser().getId());
		usergoodsclassService.selectParentPageByVO(vo, page);

		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		return mv;
	}

	/**
	 * 商家商品分类保存
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "卖家商品分类保存", value = "/seller/goods_class_save.htm*", rtype = "seller", rname = "商品分类", rcode = "goods_class_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods_class_save.htm")
	public String goods_class_save(HttpServletRequest request, HttpServletResponse response,
			UserGoodsClass usergoodsclass) {
		if (usergoodsclass.getId() == null) {
			usergoodsclass.setAddtime(new Date());
		}
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		usergoodsclass.setUserId(userDetails.getUser().getId());
		if (usergoodsclass.getParentId() != null) {
			usergoodsclass.setParentId(usergoodsclass.getParentId());
			UserGoodsClass parent = usergoodsclassService.getObjById(usergoodsclass.getParentId());
			usergoodsclass.setLevel(parent.getLevel() + 1);
		} else {
			usergoodsclass.setLevel(0);
		}
		if (usergoodsclass.getId() == null) {
			this.usergoodsclassService.save(usergoodsclass);
		} else
			this.usergoodsclassService.update(usergoodsclass);
		return "redirect:/seller/goods_class_list.htm";
	}

	@SecurityMapping(title = "卖家商品分类删除", value = "/seller/goods_class_del.htm*", rtype = "seller", rname = "商品分类", rcode = "goods_class_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods_class_del.htm")
	public String goods_class_del(HttpServletRequest request, String mulitId) {
		String[] ids = mulitId.split(",");
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		for (String id : ids) {
			if (!id.equals("")) {
				UserGoodsClass uc = this.usergoodsclassService.getObjById(Long.parseLong(id));
				if (uc != null) {
					if (uc.getUserId().equals(userDetails.getUser().getId())) {
						this.usergoodsclassService.removeByParentId(uc.getId());
						this.usergoodsclassService.delete(uc.getId());
					}

				}
			}
		}
		return "redirect:goods_class_list.htm";
	}

	@SecurityMapping(title = "新增卖家商品分类", value = "/seller/goods_class_add.htm*", rtype = "seller", rname = "商品分类", rcode = "goods_class_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods_class_add.htm")
	public ModelAndView goods_class_add(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String pid) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/goods_class_add.html",
				configService.getSysConfig(), 0, request, response);
		List<UserGoodsClassBO> ugcs = this.usergoodsclassService.findParentByUserId(SecurityUserHolder
				.getCurrentUserId());
		if (!CommUtil.null2String(pid).equals("")) {
			UserGoodsClass parent = this.usergoodsclassService.getObjById(CommUtil.null2Long(pid));
			mv.addObject("parent", parent);
		}
		mv.addObject("ugcs", ugcs);
		return mv;
	}

	@SecurityMapping(title = "编辑卖家商品分类", value = "/seller/goods_class_edit.htm*", rtype = "seller", rname = "商品分类", rcode = "goods_class_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods_class_edit.htm")
	public ModelAndView goods_class_edit(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String id) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/goods_class_add.html",
				configService.getSysConfig(), 0, request, response);

		List<UserGoodsClassBO> ugcs = this.usergoodsclassService.findParentByUserId(SecurityUserHolder
				.getCurrentUserId());
		UserGoodsClass obj = this.usergoodsclassService.getObjById(CommUtil.null2Long(id));
		if (obj.getParentId() != null) {
			UserGoodsClass parent = this.usergoodsclassService.getObjById(obj.getParentId());
			mv.addObject("parent", parent);
		}
		mv.addObject("obj", obj);
		mv.addObject("ugcs", ugcs);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	@SecurityMapping(title = "云购卖家商品分类列表", value = "/seller/yungou_class_list.htm*", rtype = "seller", rname = "商品分类", rcode = "goods_class_seller", rgroup = "商品管理")
	@RequestMapping("/seller/yungou_class_list.htm")
	public ModelAndView yungou_class_list(HttpServletRequest request, HttpServletResponse response,
			MyPage<UserGoodsClassBO> page, UserGoodsClassVO vo) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/goods_yg_class_list.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		page.setPageSize(20);
		vo.setIsyg(true);
		vo.setUserId(userDetails.getUser().getId());
		usergoodsclassService.selectParentPageByVO(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		return mv;
	}

	@SecurityMapping(title = "云购卖家商品分类", value = "/seller/yungou_class_add.htm*", rtype = "seller", rname = "商品分类", rcode = "goods_class_seller", rgroup = "商品管理")
	@RequestMapping("/seller/yungou_class_add.htm")
	public ModelAndView yungou_class_add(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String pid) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/goods_yungou_class_add.html",
				configService.getSysConfig(), 0, request, response);
		List<UserGoodsClassBO> ugcs = this.usergoodsclassService.findParentByUserId(SecurityUserHolder
				.getCurrentUserId());
		if (!CommUtil.null2String(pid).equals("")) {
			UserGoodsClass parent = this.usergoodsclassService.getObjById(CommUtil.null2Long(pid));
			mv.addObject("parent", parent);
		}
		mv.addObject("ugcs", ugcs);
		return mv;
	}

	@SecurityMapping(title = "编辑卖家商品分类", value = "/seller/yungou_class_edit.htm*", rtype = "seller", rname = "商品分类", rcode = "goods_class_seller", rgroup = "商品管理")
	@RequestMapping("/seller/yungou_class_edit.htm")
	public ModelAndView yungou_class_edit(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String id) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/goods_yungou_class_add.html",
				configService.getSysConfig(), 0, request, response);

		List<UserGoodsClassBO> ugcs = this.usergoodsclassService.findParentByUserId(SecurityUserHolder
				.getCurrentUserId());
		UserGoodsClass obj = this.usergoodsclassService.getObjById(CommUtil.null2Long(id));
		if (obj.getParentId() != null) {
			UserGoodsClass parent = this.usergoodsclassService.getObjById(obj.getParentId());
			mv.addObject("parent", parent);
		}
		mv.addObject("obj", obj);
		mv.addObject("ugcs", ugcs);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	/**
	 * 商家商品分类保存
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "云购卖家商品分类保存", value = "/seller/yungou_class_save.htm*", rtype = "seller", rname = "商品分类", rcode = "goods_class_seller", rgroup = "商品管理")
	@RequestMapping("/seller/yungou_class_save.htm")
	public String yungou_class_save(HttpServletRequest request, HttpServletResponse response,
			GoodsYgClassBO usergoodsclass) {
		if (usergoodsclass.getId() == null) {
			usergoodsclass.setAddtime(new Date());
		}
		// 上传图标
		String iconAcc = accessoryService.upload(request, "iconAcc", usergoodsclass.getIconAccId());
		usergoodsclass.setIconAccId(iconAcc);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		usergoodsclass.setUserId(userDetails.getUser().getId());
		if (usergoodsclass.getParentId() != null) {
			usergoodsclass.setParentId(usergoodsclass.getParentId());
			UserGoodsClass parent = usergoodsclassService.getObjById(usergoodsclass.getParentId());
			usergoodsclass.setLevel(parent.getLevel() + 1);
		} else {
			usergoodsclass.setLevel(0);
		}
		if (usergoodsclass.getId() == null) {
			usergoodsclass.setIsyg(true);
			this.usergoodsclassService.save(usergoodsclass);
		} else
			this.usergoodsclassService.update(usergoodsclass);
		goodsYgClassService.refreshDicCache();
		return "redirect:/seller/yungou_class_list.htm";
	}

}