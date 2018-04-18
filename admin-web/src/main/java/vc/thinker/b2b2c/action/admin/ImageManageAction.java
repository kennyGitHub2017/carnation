package vc.thinker.b2b2c.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.sys.bo.AccessoryBO;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.bo.AlbumBO;
import com.sinco.carnation.user.model.Album;
import com.sinco.carnation.user.service.AlbumService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: ImageManageAction.java
 * </p>
 * 
 * <p>
 * Description: 平台图片管理控制器，删除数据的同时也删除物理文件
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
 * @author jxz
 * 
 * @date 2014年5月27日
 * 
 * @version 1.0.1
 */
@Controller
public class ImageManageAction {
	@Autowired
	private SysConfigService configService;

	@Autowired
	private AccessoryServiceImpl accessoryService;

	@Autowired
	private AlbumService albumService;

	@SecurityMapping(title = "会员相册列表", value = "/admin/user_photo_list.htm*", rtype = "admin", rname = "图片管理", rcode = "user_image", rgroup = "用户管理")
	@RequestMapping("/admin/user_photo_list.htm")
	public ModelAndView user_album_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String albumName, MyPage<AlbumBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/photo_list.html", configService.getSysConfig(), 0,
				request, response);
		page.setPageSize(20);
		albumService.albumUserList(albumName, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("objs", page.getContent());
		mv.addObject("albumName", albumName);
		return mv;
	}

	@SecurityMapping(title = "会员相册删除", value = "/admin/user_photo_del.htm*", rtype = "admin", rname = "图片管理", rcode = "user_image", rgroup = "用户管理")
	@RequestMapping("/admin/user_photo_del.htm")
	public String user_album_del(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String mulitId) {
		albumService.albumDelete(mulitId);
		String url = "redirect:/admin/user_photo_list.htm?currentPage=1";
		return url;
	}

	@SecurityMapping(title = "会员相册图片列表", value = "/admin/user_pic_list.htm*", rtype = "admin", rname = "图片管理", rcode = "user_image", rgroup = "用户管理")
	@RequestMapping("/admin/user_pic_list.htm")
	public ModelAndView user_pic_list(HttpServletRequest request, HttpServletResponse response, Long id,
			String currentPage, MyPage<AccessoryBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/pic_list.html", configService.getSysConfig(), 0,
				request, response);

		// 图片列表 分页
		accessoryService.queryAccessoriesById(id, page);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("objs", page.getContent());

		Album album = albumService.getObjById(id);
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
	@SecurityMapping(title = "会员相册图片删除", value = "/admin/user_pic_del.htm*", rtype = "admin", rname = "图片管理", rcode = "user_image", rgroup = "用户管理")
	@RequestMapping("/admin/user_pic_del.htm")
	public String user_pic_del(HttpServletRequest request, HttpServletResponse response, String currentPage,
			String mulitId, String aid) {
		accessoryService.deleteAccessoryById(mulitId);
		String url = "redirect:/admin/user_pic_list.htm?currentPage=" + currentPage + "&id=" + aid;
		return url;
	}
}
