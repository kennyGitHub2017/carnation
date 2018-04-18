package vc.thinker.b2b2c.action.self;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.sys.bo.AccessoryBO;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.bo.AlbumBO;
import com.sinco.carnation.user.service.AlbumService;
import com.sinco.dal.common.MyPage;

/**
 * 自营图片管理控制器
 * 
 * @info 平台图片管理控制器，删除数据的同时也删除物理文件
 * @since V1.0
 * 
 */
/**
 * @info 自营商品相册管理控制器
 * @since V1.0
 */
@Controller
public class SelfImageManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private AlbumService albumService;
	@Autowired
	private AccessoryServiceImpl accessoryService;
	@Autowired
	private GoodsService goodsService;

	@SecurityMapping(title = "自营相册列表", value = "/admin/imageself_list.htm*", rtype = "admin", rname = "图片管理", rcode = "selfimg_manage", rgroup = "商城管理")
	@RequestMapping("/admin/imageself_list.htm")
	public ModelAndView imageself_list(HttpServletRequest request, HttpServletResponse response, String loginName, MyPage<AlbumBO> page, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/imageself_list.html", configService.getSysConfig(), 0, request, response);
		page.setPageSize(20);
		User user = SecurityUserHolder.getCurrentUser();
		if (null != user) {
			albumService.queryAlbumByUserNameList(loginName, page);
			CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
			mv.addObject("objs", page.getContent());
			mv.addObject("loginName", loginName);
		}
		return mv;
	}

	@SecurityMapping(title = "会员相册删除", value = "/admin/imageself_del.htm*", rtype = "admin", rname = "图片管理", rcode = "selfimg_manage", rgroup = "商城管理")
	@RequestMapping("/admin/imageself_del.htm")
	public String imageself_del(HttpServletRequest request, HttpServletResponse response, String currentPage, String mulitId) {
		albumService.albumDelete(mulitId);
		String url = "redirect:/admin/imageself_list.htm?currentPage=1";
		return url;
	}

	@SecurityMapping(title = "会员相册图片列表", value = "/admin/selfpic_list.htm*", rtype = "admin", rname = "图片管理", rcode = "selfimg_manage", rgroup = "商城管理")
	@RequestMapping("/admin/selfpic_list.htm")
	public ModelAndView selfpic_list(HttpServletRequest request, HttpServletResponse response, String aid, String currentPage, MyPage<AccessoryBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/selfpic_list.html", configService.getSysConfig(), 0, request, response);
		if (StringUtils.isNotBlank(aid)) {
			page.setPageSize(20);
			accessoryService.queryAccessoriesById(CommUtil.null2Long(aid), page);
			CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
			mv.addObject("objs", page.getContent());
		}
		AlbumBO album = albumService.queryAlbumById(CommUtil.null2Long(aid));
		mv.addObject("album", album);
		return mv;
	}

	/**
	 * 会员相册图片删除，删除数据的同时删除服务器上的图片资源
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param mulitId
	 * @return
	 */
	@SecurityMapping(title = "会员相册图片删除", value = "/admin/selfpic_del.htm*", rtype = "admin", rname = "图片管理", rcode = "selfimg_manage", rgroup = "商城管理")
	@RequestMapping("/admin/selfpic_del.htm")
	public String selfpic_del(HttpServletRequest request, HttpServletResponse response, String currentPage, String mulitId, String aid) {
		accessoryService.deleteAccessoryById(mulitId);
		String url = "redirect:/admin/selfpic_list.htm?currentPage=" + currentPage + "&aid=" + aid;
		return url;
	}
}
