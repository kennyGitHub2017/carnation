package vc.thinker.b2b2c.action.seller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.sinco.carnation.store.bo.StoreNavigationBO;
import com.sinco.carnation.store.model.StoreNavigation;
import com.sinco.carnation.store.service.StoreNavigationService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.store.vo.StoreNavigationVO;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;
import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.WebForm;

/**
 * 
 * 
 * <p>
 * Title:StoreNavSellerAction.java
 * </p>
 * 
 * <p>
 * Description:商家后台店铺导航管理控制器
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
 * @author thinker,wyj
 * 
 * @date 2014年4月24日
 * 
 * @version 1.0.1
 */
@Controller
public class StoreNavSellerAction {
	@Autowired
	private SysConfigService configService;
//	@Autowired
//	private IUserConfigService userConfigService;
	@Autowired
	private StoreNavigationService storenavigationService;
	@Autowired
	private StoreService storeService;

//	@Autowired
//	private IUserService userService;

	/**
	 * StoreNavigation列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "卖家导航管理", value = "/seller/store_nav.htm*", rtype = "seller", rname = "店铺导航", rcode = "store_nav", rgroup = "我的店铺")
	@RequestMapping("/seller/store_nav.htm")
	public ModelAndView store_nav(HttpServletRequest request, HttpServletResponse response,
			MyPage<StoreNavigationBO> page) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/store_nav.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		StoreNavigationVO vo = new StoreNavigationVO();
		vo.setStoreId(userDetails.getStoreId());
		storenavigationService.findListByVo(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		return mv;
	}

	/**
	 * storenavigation添加管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "卖家导航添加", value = "/seller/store_nav_add.htm*", rtype = "seller", rname = "店铺导航", rcode = "store_nav", rgroup = "我的店铺")
	@RequestMapping("/seller/store_nav_add.htm")
	public ModelAndView store_nav_add(HttpServletRequest request, HttpServletResponse response,
			String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/store_nav_add.html",
				configService.getSysConfig(), 0, request, response);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	/**
	 * storenavigation编辑管理
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "卖家导航编辑", value = "/seller/store_nav_edit.htm*", rtype = "seller", rname = "店铺导航", rcode = "store_nav", rgroup = "我的店铺")
	@RequestMapping("/seller/store_nav_edit.htm")
	public ModelAndView store_nav_edit(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/store_nav_add.html",
				configService.getSysConfig(), 0, request, response);
		if (id != null && !id.equals("")) {
			StoreNavigation storenavigation = this.storenavigationService.getObjById(Long.parseLong(id));
			mv.addObject("obj", storenavigation);
			mv.addObject("currentPage", currentPage);
			mv.addObject("edit", true);
		}
		return mv;
	}

	/**
	 * storenavigation保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	@SecurityMapping(title = "卖家导航保存", value = "/seller/store_nav_save.htm*", rtype = "seller", rname = "店铺导航", rcode = "store_nav", rgroup = "我的店铺")
	@RequestMapping("/seller/store_nav_save.htm")
	public void store_nav_save(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage, String cmd) {
		WebForm wf = new WebForm();
		StoreNavigation storenavigation = null;
		if (id.equals("")) {
			storenavigation = wf.toPo(request, StoreNavigation.class);
			storenavigation.setAddTime(new Date());
		} else {
			StoreNavigation obj = this.storenavigationService.getObjById(Long.parseLong(id));
			storenavigation = (StoreNavigation) wf.toPo(request, obj);
		}
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		storenavigation.setStoreId(userDetails.getStoreId());
		if (id.equals("")) {
			this.storenavigationService.save(storenavigation);
		} else
			this.storenavigationService.update(storenavigation);
		Map json = new HashMap();
		json.put("ret", true);
		json.put("op_title", "保存导航成功");
		json.put("url", CommUtil.getURL(request) + "/seller/store_nav.htm");
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(json, JsonFormat.compact()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SecurityMapping(title = "卖家导航删除", value = "/seller/store_nav_del.htm*", rtype = "seller", rname = "店铺导航", rcode = "store_nav", rgroup = "我的店铺")
	@RequestMapping("/seller/store_nav_del.htm")
	public String store_nav_del(HttpServletRequest request, HttpServletResponse response, String mulitId,
			String currentPage) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!id.equals("")) {
				StoreNavigation storenavigation = this.storenavigationService.getObjById(Long.parseLong(id));
				CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder
						.getCurrentUserDetails();
				if (CommUtil.null2String(storenavigation.getStoreId()).equals(
						userDetails.getStoreId().toString())) {
					this.storenavigationService.delete(Long.parseLong(id));
				}
			}
		}
		return "redirect:store_nav.htm?currentPage=" + currentPage;
	}

}