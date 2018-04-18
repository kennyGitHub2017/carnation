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
import vc.thinker.b2b2c.core.tools.WebForm;
import vc.thinker.b2b2c.core.tools.database.DatabaseTools;

import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.tools.StoreTools;
import com.sinco.carnation.store.service.StoreSearchService;
import com.sinco.carnation.store.tools.StoreViewTools;
import com.sinco.carnation.sys.bo.AccessoryBO;
import com.sinco.carnation.sys.model.Accessory;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.bo.AlbumBO;
import com.sinco.carnation.user.model.Album;
import com.sinco.carnation.user.service.AlbumService;
import com.sinco.carnation.user.tools.ImageTools;
import com.sinco.carnation.watermark.service.WaterMarkService;
import com.sinco.dal.common.MyPage;

/**
 * @info 卖家相册中心管理控制器
 * @since V1.0
 * 
 */
@Controller
public class AlbumSellerAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private AlbumService albumService;
	@Autowired
	private AccessoryServiceImpl accessoryService;
	@Autowired
	private WaterMarkService waterMarkService;
	@Autowired
	private GoodsService goodsSerivce;
//	@Autowired
//	private AlbumViewTools albumViewTools;
	@Autowired
	private DatabaseTools databaseTools;
	@Autowired
	private StoreTools storeTools;
	@Autowired
	private StoreViewTools storeViewTools;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private StoreSearchService searchService;
	@Autowired
	private ImageTools ImageTools;

	@SecurityMapping(title = "相册列表", value = "/seller/album.htm*", rtype = "seller", rname = "图片空间", rcode = "album_seller", rgroup = "其他管理")
	@RequestMapping("/seller/album.htm")
	public ModelAndView album(HttpServletRequest request, HttpServletResponse response, MyPage<AlbumBO> page) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/album.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		albumService.list(userDetails.getUser().getId(), page);
		String url = this.configService.getSysConfig().getAddress();
//		String path = this.storeTools.createUserFolder(request, user.getStore());
//		double csize = CommUtil.fileSize(new File(path));
//		double remainSpace = 0;
//		if (user.getStore().getGrade().getSpaceSize() > 0) {
//			remainSpace = CommUtil.div(user.getStore().getGrade()
//					.getSpaceSize()
//					* 1024 - csize, 1024);
//			mv.addObject("remainSpace", remainSpace);
//		}
		if (url == null || url.equals("")) {
			url = CommUtil.getURL(request);
		}
		CommUtil.saveIPageList2ModelAndView(url + "/seller/album.htm", "", "", page, mv);
//		mv.addObject("albumViewTools", albumViewTools);
		return mv;
	}

	@SecurityMapping(title = "新增相册", value = "/seller/album_add.htm*", rtype = "seller", rname = "图片空间", rcode = "album_seller", rgroup = "其他管理")
	@RequestMapping("/seller/album_add.htm")
	public ModelAndView album_add(HttpServletRequest request, HttpServletResponse response, String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/album_add.html",
				configService.getSysConfig(), 0, request, response);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	@SecurityMapping(title = "新增相册", value = "/seller/album_edit.htm*", rtype = "seller", rname = "图片空间", rcode = "album_seller", rgroup = "其他管理")
	@RequestMapping("/seller/album_edit.htm")
	public ModelAndView album_edit(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String id) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/album_add.html",
				configService.getSysConfig(), 0, request, response);
		Album obj = this.albumService.getObjById(CommUtil.null2Long(id));
		mv.addObject("obj", obj);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	@SecurityMapping(title = "相册保存", value = "/seller/album_save.htm*", rtype = "seller", rname = "图片空间", rcode = "album_seller", rgroup = "其他管理")
	@RequestMapping("/seller/album_save.htm")
	public String album_save(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		WebForm wf = new WebForm();
		Album album = null;
		if (id.equals("")) {
			album = wf.toPo(request, Album.class);
			album.setAddTime(new Date());
		} else {
			Album obj = this.albumService.getObjById(Long.parseLong(id));
			album = (Album) wf.toPo(request, obj);
		}
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		album.setUserId(userDetails.getUser().getId());;
		this.albumService.albumSave(userDetails.getUser().getId(), album);
		return "redirect:album.htm?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "商家相册图片上传", value = "/seller/swf_album_upload.htm*", rtype = "seller", rname = "图片空间", rcode = "album_seller", rgroup = "其他管理")
	@RequestMapping("/seller/swf_album_upload.htm")
	public void swf_album_upload(HttpServletRequest request, HttpServletResponse response, String album_id,
			String session_u_id) {
		accessoryService
				.accessoryImgSave(request, "imgFile", album_id, SecurityUserHolder.getCurrentUserId());
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
	}

	@SecurityMapping(title = "图片上传", value = "/seller/album_upload.htm*", rtype = "seller", rname = "图片空间", rcode = "album_seller", rgroup = "其他管理")
	@RequestMapping("/seller/album_upload.htm")
	public ModelAndView album_upload(HttpServletRequest request, HttpServletResponse response,
			String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/album_upload.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		List<AlbumBO> objs = this.albumService.findAllByUserId(userDetails.getId(), 0);
		mv.addObject("objs", objs);
		mv.addObject("currentPage", currentPage);
		mv.addObject("jsessionid", request.getSession().getId());
//		mv.addObject("imageSuffix", this.storeViewTools
//				.genericImageSuffix(this.configService.getSysConfig()
//						.getImageSuffix()));
		// 生成user_id字符串，防止在特定环境下swf上传无法获取session
		String temp_begin = request.getSession().getId().toString().substring(0, 5);
		String temp_end = CommUtil.randomInt(5);
		String user_id = CommUtil.null2String(SecurityUserHolder.getCurrentUser().getId());
		mv.addObject("session_u_id", temp_begin + user_id + temp_end);
		return mv;
	}

	@SecurityMapping(title = "相册删除", value = "/seller/album_del.htm*", rtype = "seller", rname = "图片空间", rcode = "album_seller", rgroup = "其他管理")
	@RequestMapping("/seller/album_del.htm")
	public String album_del(HttpServletRequest request, String mulitId) {
		String[] ids = mulitId.split(",");
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		for (String id : ids) {
			if (!id.equals("")) {
				Album album = this.albumService.getObjById(CommUtil.null2Long(id));
				if (album != null && album.getUserId().equals(userDetails.getId())) {
					List<Accessory> accs = this.accessoryService.queryAccessroyByAlbumId(album.getId());
					for (Accessory acc : accs) {
//						CommUtil.del_acc(request, acc);
//						for (Goods goods : acc.getGoodsMainList)) {
//							goods.setGoods_main_photo(null);
//							this.goodsService.update(goods);
//						}
//						for (Goods goods1 : acc.getGoods_list()) {
//							goods1.getGoods_photos().remove(acc);
//							this.goodsService.update(goods1);
//						}
						this.accessoryService.deleteByPhotoId(acc.getId());
					}
					this.albumService.albumDelete(id);
				}
			}
		}
		return "redirect:album.htm";
	}

	@SecurityMapping(title = "相册封面设置", value = "/seller/album_cover.htm*", rtype = "seller", rname = "图片空间", rcode = "album_seller", rgroup = "其他管理")
	@RequestMapping("/seller/album_cover.htm")
	public String album_cover(HttpServletRequest request, String album_id, String id, String currentPage) {
		Accessory album_cover = this.accessoryService.getObjById(Long.parseLong(id));
		Album album = this.albumService.getObjById(Long.parseLong(album_id));
		album.setAlbumCoverId(album_cover.getId());
		this.albumService.updateAlbum(album);
		return "redirect:album_image.htm?id=" + album_id + "&currentPage=" + currentPage;
	}

	@SecurityMapping(title = "相册转移", value = "/seller/album_transfer.htm*", rtype = "seller", rname = "图片空间", rcode = "album_seller", rgroup = "其他管理")
	@RequestMapping("/seller/album_transfer.htm")
	public ModelAndView album_transfer(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String album_id, String id) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/album_transfer.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		List<AlbumBO> objs = this.albumService.findAllByUserId(userDetails.getUser().getId(), 0);
		mv.addObject("objs", objs);
		mv.addObject("currentPage", currentPage);
		mv.addObject("album_id", album_id);
		mv.addObject("mulitId", id);
		return mv;
	}

	@SecurityMapping(title = "图片转移相册", value = "/seller/album_transfer_save.htm*", rtype = "seller", rname = "图片空间", rcode = "album_seller", rgroup = "其他管理")
	@RequestMapping("/seller/album_transfer_save.htm")
	public String album_transfer_save(HttpServletRequest request, String mulitId, String album_id,
			Long to_album_id, String currentPage) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!id.equals("")) {
				Accessory acc = new Accessory();
				acc.setId(CommUtil.null2Long(id));
				acc.setAlbumId(to_album_id);
				this.accessoryService.update(acc);
			}
		}
		return "redirect:album_image.htm?id=" + album_id + "&currentPage=" + currentPage;
	}

	@SecurityMapping(title = "图片列表", value = "/seller/album_image.htm*", rtype = "seller", rname = "图片空间", rcode = "album_seller", rgroup = "其他管理")
	@RequestMapping("/seller/album_image.htm")
	public ModelAndView album_image(HttpServletRequest request, HttpServletResponse response, Long id,
			MyPage<AccessoryBO> page) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/album_image.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		Album album = this.albumService.getObjById(id);

		if (!album.getUserId().equals(user.getUser().getId())) {
			mv = new JModelAndView("user/default/sellercenter/seller_error.html",
					configService.getSysConfig(), 0, request, response);
			mv.addObject("op_title", "参数错误");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/index.htm");
			return mv;
		}

		page.setPageSize(16);
		accessoryService.queryAccessoriesByIdAndUserId(null, id, page);

		String url = this.configService.getSysConfig().getAddress();
		if (url == null || url.equals("")) {
			url = CommUtil.getURL(request);
		}
//		String path = this.storeTools
//				.createUserFolder(request, user.getStore());
//		double csize = CommUtil.fileSize(new File(path));
//		double remainSpace = 0;
//		if (user.getStore().getGrade().getSpaceSize() > 0) {
//			remainSpace = CommUtil.div(user.getStore().getGrade()
//					.getSpaceSize()
//					* 1024 - csize, 1024);
//			mv.addObject("remainSpace", remainSpace);
//		}
		CommUtil.saveIPageList2ModelAndView(url + "/seller/album_image.htm", "", "&id=" + id, page, mv);
		List<AlbumBO> albums = this.albumService.findAllByUserId(user.getId(), 0);
		mv.addObject("albums", albums);
		mv.addObject("album", album);
		mv.addObject("currentPage", page.getCurrentPage());
		return mv;
	}

	@SecurityMapping(title = "图片幻灯查看", value = "/seller/image_slide.htm*", rtype = "seller", rname = "图片空间", rcode = "album_seller", rgroup = "其他管理")
	@RequestMapping("/seller/image_slide.htm")
	public ModelAndView image_slide(HttpServletRequest request, HttpServletResponse response,
			String album_id, String id) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/image_slide.html",
				configService.getSysConfig(), 0, request, response);
		Album album = this.albumService.getObjById(CommUtil.null2Long(album_id));
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		if (!album.getUserId().equals(user.getUser().getId())) {
			mv = new JModelAndView("user/default/sellercenter/seller_error.html",
					configService.getSysConfig(), 0, request, response);
			mv.addObject("op_title", "参数错误");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/index.htm");
			return mv;
		}
		List<AccessoryBO> accessories = accessoryService.queryAccessoriesByIdAndUserId(null,
				CommUtil.null2Long(album_id), null);
		mv.addObject("album", album);
		mv.addObject("accessories", accessories);
		Accessory current_img = this.accessoryService.getObjById(CommUtil.null2Long(id));
		mv.addObject("current_img", current_img);
		mv.addObject("ImageTools", ImageTools);
		return mv;
	}

	@SecurityMapping(title = "相册内图片删除", value = "/seller/album_img_del.htm*", rtype = "seller", rname = "图片空间", rcode = "album_seller", rgroup = "其他管理")
	@RequestMapping("/seller/album_img_del.htm")
	public String album_img_del(HttpServletRequest request, String mulitId, String album_id,
			String currentPage) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!id.equals("")) {
				Accessory acc = this.accessoryService.getObjById(Long.parseLong(id));
//				String middle_path = request.getSession().getServletContext()
//						.getRealPath("/")
//						+ acc.getPath()
//						+ File.separator
//						+ acc.getName()
//						+ "_middle." + acc.getExt();
//				CommUtil.deleteFile(middle_path);
//				CommUtil.del_acc(request, acc);
//				for (Goods goods : acc.getGoods_main_list()) {
//					goods.setGoods_main_photo(null);
//					this.goodsSerivce.update(goods);
//				}
//				for (Goods goods : acc.getGoods_list()) {
//					goods.getGoods_photos().remove(acc);
//					this.goodsSerivce.update(goods);
//				}
				accessoryService.deleteByPhotoId(acc.getId());
				this.accessoryService.delete(acc.getId());
			}
		}
		return "redirect:album_image.htm?id=" + album_id + "&currentPage=" + currentPage;
	}

//	@SecurityMapping(title = "图片转移相册", value = "/seller/album_watermark.htm*", rtype = "seller", rname = "图片空间", rcode = "album_seller", rgroup = "其他管理")
//	@RequestMapping("/seller/album_watermark.htm")
//	public String album_watermark(HttpServletRequest request, String mulitId, String album_id, String to_album_id, String currentPage) {
//		Long store_id = null;
//		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
//		if (user.getSeller().getStore() != null) {
//			store_id = user.getSeller().getStore().getId();
//		}
//		if (store_id != null) {
//			Watermark waterMark = this.waterMarkService.get;
//			if (waterMark != null) {
//				String[] ids = mulitId.split(",");
//				for (String id : ids) {
//					if (!id.equals("")) {
//						Accessory acc = this.accessoryService.getObjById(Long
//								.parseLong(id));
//						String path = request.getSession().getServletContext()
//								.getRealPath("/")
//								+ acc.getPath()
//								+ File.separator
//								+ acc.getName();
//						path = path.replace("/", "\\");
//						if (waterMark.isWm_image_open()) {
//							String wm_path = request.getSession()
//									.getServletContext().getRealPath("/")
//									+ waterMark.getWm_image().getPath()
//									+ File.separator
//									+ waterMark.getWm_image().getName();
//							CommUtil.waterMarkWithImage(wm_path, path,
//									waterMark.getWm_image_pos(),
//									waterMark.getWm_image_alpha());
//						}
//						if (waterMark.isWm_text_open()) {
//							Font font = new Font(waterMark.getWm_text_font(),
//									Font.BOLD, waterMark.getWm_text_font_size());
//							CommUtil.waterMarkWithText(path, path,
//									waterMark.getWm_text(),
//									waterMark.getWm_text_color(), font,
//									waterMark.getWm_text_pos(), 100f);
//						}
//						// 同步生成小图片
//						String ext = acc.getExt().indexOf(".") < 0 ? "."
//								+ acc.getExt() : acc.getExt();
//						String source = request.getSession()
//								.getServletContext().getRealPath("/")
//								+ acc.getPath()
//								+ File.separator
//								+ acc.getName();
//						source = source.replace("/", "\\");
//						String target = source + "_small" + ext;
//						CommUtil.createSmall(source, target, this.configService
//								.getSysConfig().getSmallWidth(),
//								this.configService.getSysConfig()
//										.getSmallHeight());
//						// 同步生成中等图片
//						String midext = acc.getExt().indexOf(".") < 0 ? "."
//								+ acc.getExt() : acc.getExt();
//						String midtarget = source + "_middle" + ext;
//						CommUtil.createSmall(source, midtarget,
//								this.configService.getSysConfig()
//										.getMiddleWidth(), this.configService
//										.getSysConfig().getMiddleHeight());
//					}
//				}
//			}
//		}
//		return "redirect:album_image.htm?id=" + album_id + "&currentPage="
//				+ currentPage;
//	}

	@SecurityMapping(title = "商户环境相册列表", value = "/seller/album_store.htm*", rtype = "seller", rname = "商户环境图片", rcode = "album_seller", rgroup = "其他管理")
	@RequestMapping("/seller/album_store.htm")
	public ModelAndView album_store(HttpServletRequest request, HttpServletResponse response,
			MyPage<AlbumBO> page) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/album_store.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		albumService.listStoreAlbum(userDetails.getUser().getId(), page);
		String url = this.configService.getSysConfig().getAddress();
		if (url == null || url.equals("")) {
			url = CommUtil.getURL(request);
		}
		CommUtil.saveIPageList2ModelAndView(url + "/seller/album_store.htm", "", "", page, mv);
		return mv;
	}

	@SecurityMapping(title = "环境相册图片上传", value = "/seller/album_store_upload.htm*", rtype = "seller", rname = "图片空间", rcode = "album_seller", rgroup = "其他管理")
	@RequestMapping("/seller/album_store_upload.htm")
	public ModelAndView album_store_upload(HttpServletRequest request, HttpServletResponse response,
			String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/album_store_upload.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		List<AlbumBO> objs = this.albumService.findAllByUserId(userDetails.getId(), 1);
		mv.addObject("objs", objs);
		mv.addObject("currentPage", currentPage);
		mv.addObject("jsessionid", request.getSession().getId());
		String temp_begin = request.getSession().getId().toString().substring(0, 5);
		String temp_end = CommUtil.randomInt(5);
		String user_id = CommUtil.null2String(SecurityUserHolder.getCurrentUser().getId());
		mv.addObject("session_u_id", temp_begin + user_id + temp_end);
		return mv;
	}

	@SecurityMapping(title = "环境相册保存", value = "/seller/album_store_save.htm*", rtype = "seller", rname = "图片空间", rcode = "album_seller", rgroup = "其他管理")
	@RequestMapping("/seller/album_store_save.htm")
	public String album_store_save(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		WebForm wf = new WebForm();
		Album album = null;
		if (id.equals("")) {
			album = wf.toPo(request, Album.class);
			album.setAddTime(new Date());
		} else {
			Album obj = this.albumService.getObjById(Long.parseLong(id));
			album = (Album) wf.toPo(request, obj);
		}
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		album.setUserId(userDetails.getUser().getId());;
		this.albumService.albumSave(userDetails.getUser().getId(), album);
		return "redirect:album_store.htm?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "环境相册图片列表", value = "/seller/album_store_image.htm*", rtype = "seller", rname = "图片空间", rcode = "album_seller", rgroup = "其他管理")
	@RequestMapping("/seller/album_store_image.htm")
	public ModelAndView album_store_image(HttpServletRequest request, HttpServletResponse response, Long id,
			MyPage<AccessoryBO> page) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/album_store_image.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		Album album = this.albumService.getObjById(id);

		if (!album.getUserId().equals(user.getUser().getId())) {
			mv = new JModelAndView("user/default/sellercenter/seller_error.html",
					configService.getSysConfig(), 0, request, response);
			mv.addObject("op_title", "参数错误");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/index.htm");
			return mv;
		}

		page.setPageSize(16);
		accessoryService.queryAccessoriesByIdAndUserId(null, id, page);

		String url = this.configService.getSysConfig().getAddress();
		if (url == null || url.equals("")) {
			url = CommUtil.getURL(request);
		}
		CommUtil.saveIPageList2ModelAndView(url + "/seller/album_store_image.htm", "", "&id=" + id, page, mv);
		mv.addObject("album", album);
		mv.addObject("currentPage", page.getCurrentPage());
		return mv;
	}

	@SecurityMapping(title = "环境相册封面设置", value = "/seller/album_store_cover.htm*", rtype = "seller", rname = "图片空间", rcode = "album_seller", rgroup = "其他管理")
	@RequestMapping("/seller/album_store_cover.htm")
	public String album_store_cover(HttpServletRequest request, String album_id, String id, String currentPage) {
		Accessory album_cover = this.accessoryService.getObjById(Long.parseLong(id));
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		Album album = this.albumService.getObjById(Long.parseLong(album_id));
		album.setAlbumCoverId(album_cover.getId());
		this.albumService.updateAlbum(album);
		// 更新索引
		searchService.updateIndex(userDetails.getStoreId());
		return "redirect:album_store_image.htm?id=" + album_id + "&currentPage=" + currentPage;
	}

	@SecurityMapping(title = "环境相册内图片删除", value = "/seller/album_store_img_del.htm*", rtype = "seller", rname = "图片空间", rcode = "album_seller", rgroup = "其他管理")
	@RequestMapping("/seller/album_store_img_del.htm")
	public String album_store_img_del(HttpServletRequest request, String mulitId, String album_id,
			String currentPage) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!id.equals("")) {
				Accessory acc = this.accessoryService.getObjById(Long.parseLong(id));
				accessoryService.deleteByPhotoId(acc.getId());
				this.accessoryService.delete(acc.getId());
			}
		}
		return "redirect:album_store_image.htm?id=" + album_id + "&currentPage=" + currentPage;
	}

	@SecurityMapping(title = "环境相册图片幻灯查看", value = "/seller/image_store_slide.htm*", rtype = "seller", rname = "图片空间", rcode = "album_seller", rgroup = "其他管理")
	@RequestMapping("/seller/image_store_slide.htm")
	public ModelAndView image_store_slide(HttpServletRequest request, HttpServletResponse response,
			String album_id, String id) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/image_store_slide.html",
				configService.getSysConfig(), 0, request, response);
		Album album = this.albumService.getObjById(CommUtil.null2Long(album_id));
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		if (!album.getUserId().equals(user.getUser().getId())) {
			mv = new JModelAndView("user/default/sellercenter/seller_error.html",
					configService.getSysConfig(), 0, request, response);
			mv.addObject("op_title", "参数错误");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/index.htm");
			return mv;
		}
		List<AccessoryBO> accessories = accessoryService.queryAccessoriesByIdAndUserId(null,
				CommUtil.null2Long(album_id), null);
		mv.addObject("album", album);
		mv.addObject("accessories", accessories);
		Accessory current_img = this.accessoryService.getObjById(CommUtil.null2Long(id));
		mv.addObject("current_img", current_img);
		mv.addObject("ImageTools", ImageTools);
		return mv;
	}
}
