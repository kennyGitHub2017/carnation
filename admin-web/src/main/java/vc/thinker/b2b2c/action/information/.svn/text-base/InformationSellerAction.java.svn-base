package vc.thinker.b2b2c.action.information;

import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.weedfs.client.RequestResult;
import net.weedfs.client.WeedFSClient;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.WebForm;

import com.sinco.carnation.cms.service.InformationClassServiceImpl;
import com.sinco.carnation.cms.service.InformationServiceImpl;
import com.sinco.carnation.cms.view.tools.CmsTools;
import com.sinco.carnation.sns.model.Information;
import com.sinco.carnation.sys.model.Accessory;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserService;

/**
 * 
 * <p>
 * Title: InformationManageAction.java
 * </p>
 * 
 * <p>
 * Description:资讯管理；发布，提交审核
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
 * @date 2014-12-4
 * 
 * @version 1.0.1
 */
@Controller
public class InformationSellerAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private InformationServiceImpl informationService;
//	@Autowired
//	private IGoodsService goodsService;
//	@Autowired
//	private IGoodsClassService goodsClassService;
	@Autowired
	private UserService userService;
//	@Autowired
//	private ManagerService managerService;
	@Autowired
	private InformationClassServiceImpl informationClassService;
	@Autowired
	private AccessoryServiceImpl accessoryService;
	@Autowired
	private CmsTools cmsTools;
//	@Autowired
//	private ImageTools imageTools;
	@Autowired
	// 其它管理
	private WeedFSClient fsClient;

	/**
	 * Information列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "资讯列表", value = "/seller/information_list.htm*", rtype = "admin", rname = "资讯管理", rcode = "information_seller", rgroup = "其它管理")
	@RequestMapping("/seller/information_list.htm")
	public ModelAndView information_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String title, String author) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/information_list.html",
				configService.getSysConfig(), 0, request, response);
//		InformationQueryObject qo = new InformationQueryObject(currentPage, mv,
//				"addTime", "desc");
//		User user = this.userService.getObjById(SecurityUserHolder
//				.getCurrentUser().getId());
//		user = user.getParent() == null ? user : user.getParent();
//		Store store = user.getStore();
//		qo.addQuery("obj.store_id", new SysMap("store_id", store.getId()), "=");
//		if (title != null && !title.equals("")) {
//			qo.addQuery("obj.title", new SysMap("title", "%" + title + "%"),
//					"LIKE");
//			mv.addObject("title", title);
//		}
//		if (author != null && !author.equals("")) {
//			qo.addQuery("obj.author", new SysMap("author", "%" + author + "%"),
//					"LIKE");
//			mv.addObject("author", author);
//		}
//		IPageList pList = this.informationService.list(qo);
//		CommUtil.saveIPageList2ModelAndView("", "", "", pList, mv);
//		List<InformationClass> infoclass = this.informationClassService.query(
//				"select obj from InformationClass obj", null, -1, -1);
//		Map map = new HashMap();
//		for (InformationClass informationClass : infoclass) {
//			map.put(informationClass.getId(), informationClass.getIc_name());
//		}
//		mv.addObject("classmap", map);
		return mv;
	}

	/**
	 * information添加管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "资讯添加", value = "/seller/information_add.htm*", rtype = "admin", rname = "资讯管理", rcode = "information_seller", rgroup = "其它管理")
	@RequestMapping("/seller/information_add.htm")
	public ModelAndView information_add(HttpServletRequest request, HttpServletResponse response,
			String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/information_add.html",
				configService.getSysConfig(), 0, request, response);
		mv.addObject("currentPage", currentPage);
//		List<InformationClass> infoclass = this.informationClassService
//				.query("select obj from InformationClass obj where obj.ic_pid is null",
//						null, -1, -1);
		mv.addObject("cmsTools", cmsTools);
//		mv.addObject("infoclass", infoclass);
		String goods_session = CommUtil.randomString(32);
		mv.addObject("goods_session", goods_session);
		request.getSession(false).setAttribute("goods_session", goods_session);
		return mv;
	}

	/**
	 * information编辑管理
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SuppressWarnings("unused")
	@SecurityMapping(title = "资讯编辑", value = "/seller/information_edit.htm*", rtype = "admin", rname = "资讯管理", rcode = "information_seller", rgroup = "其它管理")
	@RequestMapping("/seller/information_edit.htm")
	public ModelAndView information_edit(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/information_add.html",
				configService.getSysConfig(), 0, request, response);
		if (id != null && !id.equals("")) {
			Information information = this.informationService.getObjById(Long.parseLong(id));
			User user = this.userService.findById(SecurityUserHolder.getCurrentUser().getId());
			mv.addObject("currentPage", currentPage);
//			List<InformationClass> infoclass = this.informationClassService
//					.query("select obj from InformationClass obj where obj.ic_pid is null",
//							null, -1, -1);
			mv.addObject("cmsTools", cmsTools);
//			mv.addObject("infoclass", infoclass);
		}
		String goods_session = CommUtil.randomString(32);
		mv.addObject("goods_session", goods_session);
		request.getSession(false).setAttribute("goods_session", goods_session);
		return mv;
	}

	/**
	 * information保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings({"unused", "rawtypes"})
	@SecurityMapping(title = "资讯保存", value = "/seller/information_save.htm*", rtype = "admin", rname = "内容管理", rcode = "information_seller", rgroup = "其它管理")
	@RequestMapping("/seller/information_save.htm")
	public ModelAndView information_save(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage, String cmd, String list_url, String add_url, String goods_session,
			@RequestParam("cover") MultipartFile file) {
		ModelAndView mv = null;
		String goods_session1 = CommUtil.null2String(request.getSession(false).getAttribute("goods_session"));
		if (goods_session1.equals("")) {
			mv = new JModelAndView("user/default/sellercenter/seller_error.html",
					configService.getSysConfig(), 0, request, response);
			mv.addObject("op_title", "禁止重复提交表单");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/information_list.htm");
		} else {
			if (goods_session1.equals(goods_session)) {
				WebForm wf = new WebForm();
				Information information = null;
				User user = this.userService.findById(SecurityUserHolder.getCurrentUser().getId());
				if (id.equals("")) {
					information = wf.toPo(request, Information.class);
					information.setAddTime(new Date());
//					information.setAuthor(user.getUsername());
					information.setAuthorId(user.getId());
					information.setType(1);
					information.setStatus(0);
				} else {
					information = this.informationService.getObjById(Long.parseLong(id));
//					if (information.getStore_id() == store.getId()) {
//						information = (Information) wf.toPo(request,
//								information);
//					} else {
					information = wf.toPo(request, Information.class);
					information.setAddTime(new Date());
//						information.setAuthor(user.getUsername());
//						information.setAuthor_id(user.getId());
//						information.setStore_id(store.getId());
//						information.setStore(store.getStore_name());
					information.setType(1);
					information.setStatus(0);
//					}
				}
				// 封面图片图片
				String uploadFilePath = this.configService.getSysConfig().getUploadFilePath();
				String saveFilePathName = request.getSession().getServletContext().getRealPath("/")
						+ uploadFilePath + File.separator + "information_cover";
				Map map = new HashMap();
				try {
					String fileName = "";
					Accessory photo = null;
					if (information.getCover() != null && information.getCover() != 0) {
						photo = this.accessoryService.getObjById(information.getCover());
						fileName = photo.getName();
					}
					if (file != null) {
						RequestResult result;
						try {
							result = fsClient.upload(file.getInputStream(), file.getName(),
									URLConnection.guessContentTypeFromName((file.getOriginalFilename())));
							//String fileUrl=FileUploadTools.imageUpload(file, UploadConstants.EDITOR);
							if (result.isSuccess()) {
								if (StringUtils.isEmpty(fileName)) {
									photo = new Accessory();
									photo.setName(result.getFileName());
									photo.setExt(result.getMime());
									photo.setSize(result.getSize());
									photo.setPath(result.getUrl());
									photo.setWidth(result.getWidth());
									photo.setHeight(result.getHeight());
									photo.setAddTime(new Date());
									this.accessoryService.save(photo);
									information.setCover(photo.getId());
								} else {
									photo.setName(result.getFileName());
									photo.setExt(result.getMime());
									photo.setSize(result.getSize());
									photo.setPath(result.getUrl());
									photo.setWidth(result.getWidth());
									photo.setHeight(result.getHeight());
									photo.setAddTime(new Date());
									this.accessoryService.update(photo);
								}
							}

						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (id.equals("")) {
					this.informationService.save(information);
				} else
					this.informationService.update(information);
				mv = new JModelAndView("user/default/sellercenter/seller_success.html",
						configService.getSysConfig(), 0, request, response);
				mv.addObject("op_title", "保存资讯成功");
				mv.addObject("url", CommUtil.getURL(request) + "/seller/information_list.htm");
				request.getSession(false).removeAttribute("goods_session");
			} else {
				mv = new JModelAndView("user/default/sellercenter/seller_error.html",
						configService.getSysConfig(), 0, request, response);
				mv.addObject("op_title", "参数错误");
				mv.addObject("url", CommUtil.getURL(request) + "/seller/goods.htm");
			}
		}
		return mv;
	}

	@SuppressWarnings("unused")
	@SecurityMapping(title = "资讯提交审核", value = "/seller/information_apply.htm*", rtype = "admin", rname = "资讯管理", rcode = "information_seller", rgroup = "其它管理")
	@RequestMapping("/seller/information_apply.htm")
	public String information_apply(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		Information information = null;
		if (id != null && !id.equals("")) {
			information = this.informationService.getObjById(CommUtil.null2Long(id));
			User user = this.userService.findById(SecurityUserHolder.getCurrentUser().getId());
		}
		return "redirect:information_list.htm?currentPage=" + currentPage;
	}

	@SuppressWarnings("unused")
	@SecurityMapping(title = "资讯删除", value = "/seller/information_del.htm*", rtype = "admin", rname = "资讯管理", rcode = "information_seller", rgroup = "其它管理")
	@RequestMapping("/seller/information_del.htm")
	public String information_del(HttpServletRequest request, HttpServletResponse response, String mulitId,
			String currentPage) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!id.equals("")) {
				Information information = this.informationService.getObjById(Long.parseLong(id));
//				User user = this.userService.getObjById(SecurityUserHolder
//						.getCurrentUser().getId());
//				user = user.getParent() == null ? user : user.getParent();
//				Store store = user.getStore();
//				if (information.getStore_id() == store.getId()) {
				this.informationService.delete(Long.parseLong(id));
//				}
			}
		}
		return "redirect:information_list.htm?currentPage=" + currentPage;
	}

//	@SecurityMapping(title = "资讯商品", value = "/seller/information_goods.htm*", rtype = "admin", rname = "资讯管理", rcode = "information_seller", rgroup = "其它管理")
//	@RequestMapping("/seller/information_goods.htm")
//	public ModelAndView information_goods(HttpServletRequest request,
//			HttpServletResponse response, String currentPage, String gc_id,
//			String goods_name) {
//		ModelAndView mv = new JModelAndView(
//				"admin/blue/information_goods.html",
//				configService.getSysConfig(),
//				0, request, response);
//		GoodsQueryObject qo = new GoodsQueryObject(currentPage, mv, "addTime",
//				"desc");
//		User user = this.userService.getObjById(SecurityUserHolder
//				.getCurrentUser().getId());
//		user = user.getParent() == null ? user : user.getParent();
//		qo.addQuery("obj.goods_status", new SysMap("goods_status", 0), "=");
//		qo.addQuery("obj.goods_store.id", new SysMap("goods_store_id", user
//				.getStore().getId()), "=");
//		qo.setPageSize(5);
//		if (!CommUtil.null2String(gc_id).equals("")) {
//			Set<Long> ids = this.genericIds(this.goodsClassService
//					.getObjById(CommUtil.null2Long(gc_id)));
//			Map paras = new HashMap();
//			paras.put("ids", ids);
//			qo.addQuery("obj.gc.id in (:ids)", paras);
//			mv.addObject("gc_id", gc_id);
//		}
//		if (!CommUtil.null2String(goods_name).equals("")) {
//			qo.addQuery("obj.goods_name", new SysMap("goods_name", "%"
//					+ goods_name + "%"), "like");
//			mv.addObject("goods_name", goods_name);
//		}
//		IPageList pList = this.goodsService.list(qo);
//		String photo_url = CommUtil.getURL(request)
//				+ "/admin/information_goods.htm";
//		mv.addObject("goods", pList.getResult());
//		mv.addObject("gotoPageAjaxHTML", CommUtil.showPageAjaxHtml(photo_url,
//				"", pList.getCurrentPage(), pList.getPages()));
//		List<GoodsClass> gcs = this.goodsClassService
//				.query("select obj from GoodsClass obj where obj.parent.id is null order by obj.sequence asc",
//						null, -1, -1);
//		mv.addObject("gcs", gcs);
//		return mv;
//	}

//	@SecurityMapping(title = "商品图片", value = "/seller/information_goods_imgs.htm*", rtype = "admin", rname = "资讯管理", rcode = "information_seller", rgroup = "其它管理")
//	@RequestMapping("/seller/information_goods_imgs.htm")
//	public ModelAndView information_goods_imgs(HttpServletRequest request,
//			HttpServletResponse response, String goods_id, String currentPage,
//			String gc_id, String goods_name) {
//		ModelAndView mv = new JModelAndView(
//				"admin/blue/information_goods_imgs.html",
//				configService.getSysConfig(),
//				this.userConfigService.getUserConfig(), 0, request, response);
//		Goods goods = this.goodsService
//				.getObjById(CommUtil.null2Long(goods_id));
//		List list = new ArrayList();
//		if (goods.getGoods_main_photo() != null) {
//			list.add(goods.getGoods_main_photo());
//			list.addAll(goods.getGoods_photos());
//		}
//		mv.addObject("photos", list);
//		mv.addObject("goods_id", goods_id);
//		return mv;
//	}
//
//	@SecurityMapping(title = "资讯预览", value = "/seller/info_preview.htm*", rtype = "admin", rname = "资讯管理", rcode = "information_seller", rgroup = "其它管理")
//	@RequestMapping("/seller/info_preview.htm")
//	public ModelAndView info_preview(HttpServletRequest request,
//			HttpServletResponse response, String id) {
//		ModelAndView mv = new JModelAndView("/cms/detail.html",
//				configService.getSysConfig(),
//				1, request, response);
//		Information info = this.informationService.getObjById(CommUtil
//				.null2Long(id));
//		if (info != null) {
//			User user = this.userService.getObjById(SecurityUserHolder
//					.getCurrentUser().getId());
//			user = user.getParent() == null ? user : user.getParent();
//			if (info.getStore_id().equals(user.getStore().getId())) {
//				mv.addObject("obj", info);
//				mv.addObject("className", this.informationClassService
//						.getObjById(info.getClassid()).getIc_name());
//				Map map = new HashMap();
//				map.put("addTime", info.getAddTime());
//				List<Information> before = this.informationService
//						.query("select obj from Information obj where obj.addTime>:addTime and obj.status=20 order by addTime asc",
//								map, 0, 1);
//				if (before.size() > 0) {
//					mv.addObject("before", before.get(0));
//				}
//				List<Information> after = this.informationService
//						.query("select obj from Information obj where obj.addTime<:addTime and obj.status=20 order by addTime desc",
//								map, 0, 1);
//				if (after.size() > 0) {
//					mv.addObject("after", after.get(0));
//				}
//				List<InformationClass> infoclass = this.informationClassService
//						.query("select obj from InformationClass obj order by ic_sequence asc",
//								null, -1, -1);
//				mv.addObject("infoclass", infoclass);
//				List<Information> hotinfo = this.informationService
//						.query("select obj from Information obj where obj.status=20 order by sequence asc",
//								null, 0, 5);
//				mv.addObject("hotinfo", hotinfo);
//				mv.addObject("imageTools", imageTools);
//			} else {
//				mv = new JModelAndView(
//						"user/default/sellercenter/seller_error.html",
//						configService.getSysConfig(),
//						this.userConfigService.getUserConfig(), 0, request,
//						response);
//				mv.addObject("op_title", "参数不正确");
//				mv.addObject("url", CommUtil.getURL(request)
//						+ "/seller/information_list.htm");
//			}
//
//		} else {
//			mv = new JModelAndView(
//					"user/default/sellercenter/seller_error.html",
//					configService.getSysConfig(),
//					this.userConfigService.getUserConfig(), 0, request,
//					response);
//			mv.addObject("op_title", "参数不正确");
//			mv.addObject("url", CommUtil.getURL(request)
//					+ "/seller/information_list.htm");
//		}
//
//		return mv;
//	}
//
//	private Set<Long> genericIds(GoodsClass gc) {
//		Set<Long> ids = new HashSet<Long>();
//		ids.add(gc.getId());
//		for (GoodsClass child : gc.getChilds()) {
//			Set<Long> cids = genericIds(child);
//			for (Long cid : cids) {
//				ids.add(cid);
//			}
//			ids.add(child.getId());
//		}
//		return ids;
//	}
}