package vc.thinker.b2b2c.action.self;

import java.util.List;

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
import vc.thinker.b2b2c.core.tools.WebForm;
import vc.thinker.b2b2c.core.tools.database.DatabaseTools;

import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.sys.bo.AccessoryBO;
import com.sinco.carnation.sys.model.Accessory;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.bo.AlbumBO;
import com.sinco.carnation.user.model.Album;
import com.sinco.carnation.user.service.AlbumService;
import com.sinco.carnation.watermark.service.WaterMarkService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: AlbumSelfManageAction.java
 * </p>
 * 
 * <p>
 * Description:自营相册管理类
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
 * @date 2014年5月27日
 * 
 * @version 1.0.1
 */
@Controller
public class SelfAlbumManageAction {
	@Autowired
	private SysConfigService configService;

	@Autowired
	private AlbumService albumService;
	@Autowired
	private AccessoryServiceImpl accessoryService;
	@Autowired
	private WaterMarkService waterMarkService;
	@Autowired
	private UserService userService;
	@Autowired
	private GoodsService goodsSerivce;
	@Autowired
	private DatabaseTools databaseTools;
	@Autowired
	private WaterMarkService watermarkService;
	@Autowired
	private GoodsService goodsService;

	@SecurityMapping(title = "相册列表", value = "/admin/album.htm*", rtype = "admin", rname = "自营相册", rcode = "album_admin", rgroup = "商城管理")
	@RequestMapping("/admin/album.htm")
	public ModelAndView album(HttpServletRequest request, HttpServletResponse response, MyPage<AlbumBO> page,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/album.html", configService.getSysConfig(), 0,
				request, response);
		page.setPageSize(20);
		User user = SecurityUserHolder.getCurrentUser();
		if (null != user) {
			albumService.list(user.getId(), page);
			CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
			mv.addObject("objs", page.getContent());
		}
		return mv;
	}

	@SecurityMapping(title = "修改相册", value = "/admin/album_add.htm*", rtype = "admin", rname = "自营相册", rcode = "album_admin", rgroup = "商城管理")
	@RequestMapping("/admin/album_add.htm")
	public ModelAndView album_add(HttpServletRequest request, HttpServletResponse response, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/album_add.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	@SecurityMapping(title = "新增相册", value = "/admin/album_edit.htm*", rtype = "admin", rname = "自营相册", rcode = "album_admin", rgroup = "商城管理")
	@RequestMapping("/admin/album_edit.htm")
	public ModelAndView album_edit(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/album_add.html", configService.getSysConfig(), 0,
				request, response);
		// id不为空 为编辑相册
		if (StringUtils.isNotBlank(id)) {
			Album obj = albumService.getObjById(CommUtil.null2Long(id));
			mv.addObject("obj", obj);
			mv.addObject("currentPage", currentPage);
		}
		return mv;
	}

	@SecurityMapping(title = "相册保存", value = "/admin/album_save.htm*", rtype = "admin", rname = "自营相册", rcode = "album_admin", rgroup = "商城管理")
	@RequestMapping("/admin/album_save.htm")
	public ModelAndView album_save(HttpServletRequest request, HttpServletResponse response,
			String albumName, String albumSequence, String currentPage) {
		WebForm wf = new WebForm();
		Album album = wf.toPo(request, Album.class);
		User user = SecurityUserHolder.getCurrentUser();
		if (user != null && album != null) {
			albumService.albumSave(user.getId(), album);
		}
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/album.htm" + "?currentPage="
				+ currentPage);
		mv.addObject("op_title", "保存相册成功");
		return mv;
	}

	@SecurityMapping(title = "图片上传", value = "/admin/album_upload.htm*", rtype = "admin", rname = "自营相册", rcode = "album_admin", rgroup = "商城管理")
	@RequestMapping("/admin/album_upload.htm")
	public ModelAndView album_upload(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String album_id) {
		ModelAndView mv = new JModelAndView("admin/blue/album_upload.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("currentPage", currentPage);
		mv.addObject("album_id", album_id);
		mv.addObject("jsessionid", request.getSession().getId());
		String temp_begin = request.getSession().getId().toString().substring(0, 5);
		String temp_end = CommUtil.randomInt(5);
		String user_id = CommUtil.null2String(SecurityUserHolder.getCurrentUser().getId());
		mv.addObject("session_u_id", temp_begin + user_id + temp_end);
		return mv;
	}

	@SecurityMapping(title = "自营相册图片上传", value = "/admin/swf_album_upload.htm*", rtype = "admin", rname = "商品发布", rcode = "goods_self_add", rgroup = "商城管理")
	@RequestMapping("/admin/swf_album_upload.htm")
	public void swfAlbumUpload(HttpServletRequest request, HttpServletResponse response, String album_id,
			String session_u_id) {
		accessoryService.accessoryImgSave(request, "imgFile", album_id);
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
	}

	@SecurityMapping(title = "相册删除", value = "/admin/album_del.htm*", rtype = "admin", rname = "自营相册", rcode = "album_admin", rgroup = "商城管理")
	@RequestMapping("/admin/album_del.htm")
	public String album_del(HttpServletRequest request, String mulitId) {
		albumService.albumDelete(mulitId);
		return "redirect:album.htm";
	}

	@SecurityMapping(title = "相册封面设置", value = "/admin/album_cover.htm*", rtype = "admin", rname = "自营相册", rcode = "album_admin", rgroup = "商城管理")
	@RequestMapping("/admin/album_cover.htm")
	public String album_cover(HttpServletRequest request, String albumId, String id, String currentPage) {

		// 相册对象
		Album album = albumService.queryAlbumById(CommUtil.null2Long(albumId));
		// 设置封面图片id
		album.setAlbumCoverId(CommUtil.null2Long(id));
		// 更新相册封面id
		albumService.updateAlbum(album);
		return "redirect:album_image.htm?id=" + albumId + "&currentPage=" + currentPage;
	}

	@SecurityMapping(title = "相册转移", value = "/admin/album_transfer.htm*", rtype = "admin", rname = "自营相册", rcode = "album_admin", rgroup = "商城管理")
	@RequestMapping("/admin/album_transfer.htm")
	public ModelAndView album_transfer(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String albumId, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/album_transfer.html", configService.getSysConfig(),
				0, request, response);

		User user = SecurityUserHolder.getCurrentUser();
		if (user != null) {
			// 相册列表
			MyPage<AlbumBO> myPage = new MyPage<AlbumBO>();
			albumService.list(user.getId(), myPage);
			mv.addObject("objs", myPage.getContent());
			mv.addObject("albumId", albumId);// 相册id
			mv.addObject("mulitId", id);// 图片id
		}
		return mv;
	}

	@SecurityMapping(title = "图片转移相册", value = "/admin/album_transfer_save.htm*", rtype = "admin", rname = "自营相册", rcode = "album_admin", rgroup = "商城管理")
	@RequestMapping("/admin/album_transfer_save.htm")
	public String album_transfer_save(HttpServletRequest request, String mulitId, String album_id,
			String to_album_id, String currentPage) {
		User user = SecurityUserHolder.getCurrentUser();
		accessoryService.updateAlbumTransfer(mulitId, to_album_id, user.getId());
		return "redirect:album_image.htm?id=" + album_id;// + "&currentPage=" + currentPage;
	}

	@SecurityMapping(title = "图片列表", value = "/admin/album_image.htm*", rtype = "admin", rname = "自营相册", rcode = "album_admin", rgroup = "商城管理")
	@RequestMapping("/admin/album_image.htm")
	public ModelAndView album_image(HttpServletRequest request, HttpServletResponse response, Long id,
			MyPage<AccessoryBO> page, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/album_image.html", configService.getSysConfig(), 0,
				request, response);
		User user = SecurityUserHolder.getCurrentUser();
		page.setCurrentPage(StringUtils.isEmpty(currentPage) ? 1 : Integer.parseInt(currentPage));
		// 图片列表 分页
		accessoryService.queryAccessoriesById(id, page);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);

		// 相册列表
		MyPage<AlbumBO> myPage = new MyPage<AlbumBO>();
		albumService.list(user.getId(), myPage);

		Album album = albumService.getObjById(id);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("objs", page.getContent());
		mv.addObject("albums", myPage.getContent());
		mv.addObject("album", album);
		return mv;
	}

	@SecurityMapping(title = "图片幻灯查看", value = "/admin/image_slide.htm*", rtype = "admin", rname = "自营相册", rcode = "album_admin", rgroup = "商城管理")
	@RequestMapping("/admin/image_slide.htm")
	public ModelAndView image_slide(HttpServletRequest request, HttpServletResponse response,
			String album_id, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/image_slide.html", configService.getSysConfig(), 0,
				request, response);
		// Album album =albumService.getObjById(CommUtil.null2Long(album_id));
		User user = SecurityUserHolder.getCurrentUser();
		// 相册信息
		Album album = albumService.queryAblumAccessory(CommUtil.null2Long(album_id), user.getId());
		// 图片列表
		List<Accessory> list = accessoryService.queryAccessroyByAlbumId(CommUtil.null2Long(album_id));
		// 图片信息
		Accessory current_img = accessoryService.getObjById(CommUtil.null2Long(id));
		mv.addObject("current_img", current_img);
		mv.addObject("album", album);
		mv.addObject("imgList", list);
		return mv;
	}

	@SecurityMapping(title = "相册内图片删除", value = "/admin/album_img_del.htm*", rtype = "admin", rname = "自营相册", rcode = "album_admin", rgroup = "商城管理")
	@RequestMapping("/admin/album_img_del.htm")
	public String album_img_del(HttpServletRequest request, String mulitId, String album_id,
			String currentPage) {
		accessoryService.deleteAccessoryById(mulitId);
		return "redirect:album_image.htm?id=" + album_id + "&currentPage=" + currentPage;
	}

	@SecurityMapping(title = "图片转移相册", value = "/admin/album_watermark.htm*", rtype = "admin", rname = "自营相册", rcode = "album_admin", rgroup = "商城管理")
	@RequestMapping("/admin/album_watermark.htm")
	public String album_watermark(HttpServletRequest request, String mulitId, String album_id,
			String to_album_id, String currentPage) {
		return "redirect:album_image.htm?id=" + album_id + "&currentPage=" + currentPage;
	}

	@SecurityMapping(title = "图片水印", value = "/admin/watermark.htm*", rtype = "admin", rname = "自营相册", rcode = "album_admin", rgroup = "商城管理")
	@RequestMapping("/admin/watermark.htm")
	public ModelAndView watermark(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/watermark.html", configService.getSysConfig(), 0,
				request, response);
		return mv;
	}

	/**
	 * watermark保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("null")
	@SecurityMapping(title = "图片水印保存", value = "/admin/watermark_save.htm*", rtype = "admin", rname = "自营相册", rcode = "album_admin", rgroup = "商城管理")
	@RequestMapping("/admin/watermark_save.htm")
	public ModelAndView watermark_save(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = null;
		mv.addObject("add_url", CommUtil.getURL(request) + "/admin/album.htm");
		return mv;
	}
}
