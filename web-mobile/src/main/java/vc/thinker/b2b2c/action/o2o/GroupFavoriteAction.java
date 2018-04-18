package vc.thinker.b2b2c.action.o2o;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.carnation.o2o.bo.GroupGoodsBO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.bo.UserCustomerFavoritesBO;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.vo.UserCustomerFavoritesVO;
import com.sinco.dal.common.MyPage;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

@Controller
public class GroupFavoriteAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private UserCustomerService customerService;
	@Autowired
	private StoreService storeService;

	@SecurityMapping(title = "买家服务商家收藏列表", value = "/group/favorite_store_list.htm*", rtype = "buyer", rname = "买家服务商家收藏列表", rcode = "buyer_group_favorite_store_list", rgroup = "买家服务商家收藏列表")
	@RequestMapping("/group/favorite_store.htm")
	public ModelAndView store(String currentPage, HttpServletRequest request, HttpServletResponse response,
			MyPage<UserCustomerFavoritesBO> page, String status) {
		ModelAndView mv = new JModelAndView("o2o/favorite_store.html", configService.getSysConfig(), 1,
				request, response);
		Long userId = SecurityUserHolder.getCurrentUserId();
		UserCustomerFavoritesVO vo = new UserCustomerFavoritesVO();
		vo.setUid(userId);
		vo.setType("6");
		customerService.queryFavorites(vo, page);
		List<UserCustomerFavoritesBO> list = page.getContent();
		for (UserCustomerFavoritesBO bo : list) {
			StoreBO storeBO = storeService.getObjById(Long.parseLong(bo.getFid()));
			bo.setStoreLogoPath(storeBO.getStoreInfoPath());
		}
		page.setContent(list);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);

		mv.addObject("customerService", customerService);
		return mv;
	}

	@SecurityMapping(title = "买家服务收藏列表", value = "/group/favorite_service_list.htm*", rtype = "buyer", rname = "买家服务收藏列表", rcode = "favorite_service_list", rgroup = "买家服务收藏列表")
	@RequestMapping("/group/favorite_service.htm")
	public ModelAndView service(String currentPage, HttpServletRequest request, HttpServletResponse response,
			MyPage<GroupGoodsBO> page, String status) {
		ModelAndView mv = new JModelAndView("o2o/favorite_service.html", configService.getSysConfig(), 1,
				request, response);

		Long userId = SecurityUserHolder.getCurrentUserId();
		customerService.queryGroupServiceFavorites(userId, page);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		return mv;
	}
}
