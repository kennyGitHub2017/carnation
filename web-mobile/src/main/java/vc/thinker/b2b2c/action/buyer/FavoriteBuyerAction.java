package vc.thinker.b2b2c.action.buyer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.goods.tools.GoodsViewTools;
import com.sinco.carnation.goods.tools.LuceneVoTools;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.bo.UserCustomerFavoritesBO;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.vo.UserCustomerFavoritesVO;
import com.sinco.dal.common.MyPage;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

/**
 * 
 * <p>
 * Title: FavoriteBuyerAction.java
 * </p>
 * 
 * <p>
 * Description: 收藏管理控制器，用来显示买家收藏的商品信息、店铺信息
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
 * @date 2014-8-8
 * 
 * @version 1.0.1
 */
@Controller
public class FavoriteBuyerAction {
	@Autowired
	private SysConfigService configService;
	// @Autowired
	// private IUserConfigService userConfigService;
	@Autowired
	private UserCustomerService favoriteService;
	@Autowired
	private LuceneVoTools luceneVoTools;
	// @Autowired
	// private IGoodsService goodsService;
	// @Autowired
	// private IMessageService messageService;
	// @Autowired
	// private IUserService userService;
	// @Autowired
	// private IStoreService storeService;
	// @Autowired
	// private UserTools userTools;
	@Autowired
	private GoodsViewTools goodsViewTools;

	// @Autowired
	// private LuceneUtil luceneUtil;
	/**
	 * Favorite列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "用户商品收藏", value = "/buyer/favorite_goods.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/favorite_goods.htm")
	public ModelAndView favorite_goods(HttpServletRequest request, HttpServletResponse response,
			MyPage<UserCustomerFavoritesBO> page, String orderBy, String orderType) {
		// ModelAndView mv = new JModelAndView(
		// "user/default/usercenter/favorite_goods.html",
		// configService.getSysConfig(),
		// this.userConfigService.getUserConfig(), 0, request, response);
		// String url = this.configService.getSysConfig().getAddress();
		// if (url == null || url.equals("")) {
		// url = CommUtil.getURL(request);
		// }
		// String params = "";
		// FavoriteQueryObject qo = new FavoriteQueryObject(currentPage, mv,
		// orderBy, orderType);
		// qo.addQuery("obj.type", new SysMap("type", 0), "=");
		// qo.addQuery("obj.user_id", new SysMap("user_id", SecurityUserHolder
		// .getCurrentUser().getId()), "=");
		// IPageList pList = this.favoriteService.list(qo);
		// CommUtil.saveIPageList2ModelAndView(url +
		// "/buyer/favorite_goods.htm",
		// "", params, pList, mv);
		// mv.addObject("userTools", userTools);
		// mv.addObject("goodsViewTools", goodsViewTools);
		ModelAndView mv = new JModelAndView("user/default/usercenter/favorite_goods.html",
				configService.getSysConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if (url == null || url.equals(""))
			url = CommUtil.getURL(request);

		String params = "";
		UserCustomerFavoritesVO vo = new UserCustomerFavoritesVO();
		vo.setUid(SecurityUserHolder.getCurrentUserId());
		vo.setType("3");
		favoriteService.queryFavorites(vo, page);
		CommUtil.saveIPageList2ModelAndView(url + "/buyer/favorite_goods.htm", "", params, page, mv);
		mv.addObject("goodsViewTools", goodsViewTools);

		return mv;
	}

	//
	/**
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @return
	 */
	@SuppressWarnings("unused")
	@SecurityMapping(title = "用户店铺收藏", value = "/buyer/favorite_store.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/favorite_store.htm")
	public ModelAndView favorite_store(HttpServletRequest request, HttpServletResponse response,
			MyPage<UserCustomerFavoritesBO> page, UserCustomerFavoritesVO vo, String orderBy, String orderType) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/favorite_store.html",
				configService.getSysConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if (url == null || url.equals(""))
			url = CommUtil.getURL(request);

		// String params = "";
		// FavoriteQueryObject qo = new FavoriteQueryObject(currentPage, mv,
		// orderBy, orderType);
		// qo.addQuery("obj.type", new SysMap("type", 1), "=");
		// qo.addQuery("obj.user_id", new SysMap("user_id",
		// SecurityUserHolder.getCurrentUser().getId()), "=");
		// IPageList pList = this.favoriteService.list(qo);
		// SecurityUserHolder.
		String params = "";
		if (null == vo)
			vo = new UserCustomerFavoritesVO();
		vo.setUid(SecurityUserHolder.getCurrentUserId());
		vo.setType("4");
		favoriteService.queryFavorites(vo, page);
		CommUtil.saveIPageList2ModelAndView(url + "/buyer/favorite_store.htm", "", "", page, mv);
		return mv;
	}

	//
	@SecurityMapping(title = "用户收藏删除", value = "/buyer/favorite_del.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/favorite_del.htm")
	public String favorite_del(HttpServletRequest request, HttpServletResponse response, Long id,
			String currentPage, int type) {

		if (id != 0) {
			try {
				favoriteService.cancleGoodsOrStoreFavoritesById(id);
			} catch (ServiceException e) {
				return "redirect:/buyer/index.htm";
			}
		}
		switch (type) {
			case 3:
				return "redirect:favorite_goods.htm?currentPage=" + currentPage;
			case 4:
				return "redirect:favorite_store.htm?currentPage=" + currentPage;
			case 5:
				return "redirect:/group/favorite_service.htm?currentPage=" + currentPage;
			case 6:
				return "redirect:/group/favorite_store.htm?currentPage=" + currentPage;
		}
		return null;
	}
}