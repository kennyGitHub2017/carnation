package vc.thinker.b2b2c.action.seller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.carnation.goods.tools.GoodsViewTools;
import com.sinco.carnation.goods.tools.StoreTools;
import com.sinco.carnation.o2o.bo.GroupClassBO;
import com.sinco.carnation.o2o.bo.GroupGoodsBO;
import com.sinco.carnation.o2o.bo.GroupInfoBO;
import com.sinco.carnation.o2o.constants.GroupGoodsConstants;
import com.sinco.carnation.o2o.model.GroupClass;
import com.sinco.carnation.o2o.service.GroupClassService;
import com.sinco.carnation.o2o.service.GroupGoodsService;
import com.sinco.carnation.o2o.service.GroupInfoService;
import com.sinco.carnation.o2o.vo.GroupGoodsVO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.constants.StoreConstants;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.store.service.StoreSearchService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.model.Accessory;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.DicContent;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

@Controller
public class GroupGoodsAction {

	@Autowired
	private SysConfigService configService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private StoreTools storeTools;
	@Autowired
	private DicContent dicContent;
	@Autowired
	private GroupClassService groupClassService;
	@Autowired
	private GroupGoodsService groupGoodsService;
	@Autowired
	private GoodsViewTools goodsViewTools;
	@Autowired
	private AreaServiceImpl areaService;
	@Autowired
	private GroupInfoService groupInfoService;
	@Autowired
	private StoreSearchService storeSearchService;
	@Autowired
	private AccessoryServiceImpl accessoryService;

	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 服务发布第一步
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "服务发布第一步", value = "/seller/add_group_goods_first.htm*", rtype = "seller", rname = "服务发布", rcode = "group_seller", rgroup = "商户服务")
	@RequestMapping("/seller/add_group_goods_first.htm")
	public ModelAndView add_group_goods_first(HttpServletRequest request, HttpServletResponse response,
			String id) {

		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_error.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		request.getSession(false).removeAttribute("group_goods_class_info");
		Long storeId = userDetails.getSeller().getStoreId();
		StoreBO store = storeService.getObjById(storeId);

		Integer storeStatus = (store == null ? 0 : store.getStoreStatus());
		Boolean isO2o = (store == null ? Boolean.FALSE : store.getIsO2o());
		if (isO2o && storeStatus.equals(StoreConstants.STORE_STATUS_SHOP_AUDIT_SUCCESS)) {
			mv = new JModelAndView("user/default/sellercenter/add_group_goods_first.html",
					configService.getSysConfig(), 0, request, response);
			if (store != null) {
				if (StringUtils.isNotBlank(store.getGroupDetailInfo())) {
					String[] groupClassIds = store.getGroupDetailInfo().split(",");
					List<GroupClass> gcs = new ArrayList<GroupClass>();
					if (groupClassIds != null && groupClassIds.length > 0) {
						for (int i = 0; i < groupClassIds.length; i++) {
							gcs.add(this.groupClassService.getObjById(CommUtil.null2Long(groupClassIds[i])));
						}
					}
					mv.addObject("gcs", gcs);
				} else if (store.getGroupMainId() != null && store.getGroupMainId() > 0) {// 商户详细类目(根据主营类目查询)
					List<GroupClassBO> gcs = this.groupClassService.findChildList(store.getGroupMainId());
					mv.addObject("gcs", gcs);
				} else {
					mv.addObject("op_title", "您的商户主营类目有问题，暂时不能发布服务");
					mv.addObject("url", CommUtil.getURL(request) + "/seller/index.htm");
				}

				mv.addObject("id", CommUtil.null2String(id));
			}
		}

		if (storeStatus == 0) {
			mv.addObject("op_title", "您尚未开通商户，不能发布服务");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/index.htm");
		} else if (storeStatus == 10) {
			mv.addObject("op_title", "您的商户在审核中，不能发布服务");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/index.htm");
		} else if (storeStatus == 20) {
			mv.addObject("op_title", "您的商户已被关闭，不能发布服务");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/index.htm");
		}

		return mv;
	}

	/**
	 * 服务发布第二步
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "服务发布第二步", value = "/seller/add_group_goods_second.htm*", rtype = "seller", rname = "服务发布", rcode = "group_seller", rgroup = "商户服务")
	@RequestMapping("/seller/add_group_goods_second.htm")
	public ModelAndView add_group_goods_second(HttpServletRequest request, HttpServletResponse response,
			String id) {

		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_error.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		Long storeId = userDetails.getSeller().getStoreId();
		StoreBO store = storeService.getObjById(storeId);

		Integer storeStatus = (store == null ? 0 : store.getStoreStatus());
		Boolean isO2o = (store == null ? Boolean.FALSE : store.getIsO2o());

		if (isO2o && storeStatus.equals(StoreConstants.STORE_STATUS_SHOP_AUDIT_SUCCESS)) {
			if (request.getSession(false).getAttribute("group_goods_class_info") != null) {
				mv = new JModelAndView("user/default/sellercenter/add_group_goods_second.html",
						configService.getSysConfig(), 0, request, response);
				GroupClass gc = (GroupClass) request.getSession(false).getAttribute("group_goods_class_info");
				gc = this.groupClassService.getObjById(gc.getId());
				if (gc != null) {
					mv.addObject("ggcId", gc.getId());
				}
				String goods_class_info = this.groupGoodsService.genericGoodsClassInfo(gc);
				mv.addObject("goods_class_info", goods_class_info.substring(0, goods_class_info.length() - 1));
				request.getSession(false).removeAttribute("group_goods_class_info");
				// 处理上传格式
				String[] strs = this.configService.getSysConfig().getImageSuffix().split("\\|");
				StringBuffer sb = new StringBuffer();
				for (String str : strs) {
					sb.append("." + str + ",");
				}
				mv.addObject("imageSuffix1", sb);
				Date now = new Date();
				// now.setDate(now.getDate() + 1);
				mv.addObject("beginTimeStr", CommUtil.formatShortDate(now));
				String goods_session = CommUtil.randomString(32);
				mv.addObject("goods_session", goods_session);
				request.getSession(false).setAttribute("group_goods_session", goods_session);
				mv.addObject("store", store);
			} else {
				mv.addObject("op_title", "Session信息丢失，请重新发布服务");
				mv.addObject("url", CommUtil.getURL(request) + "/seller/index.htm");
			}
		}
		if (storeStatus == 0) {
			mv.addObject("op_title", "您尚未开通店铺，不能发布服务");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/index.htm");
		}
		if (storeStatus == 10) {
			mv.addObject("op_title", "您的店铺在审核中，不能发布服务");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/index.htm");
		}
		if (storeStatus == 20) {
			mv.addObject("op_title", "您的店铺已被关闭，不能发布服务");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/index.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "发布服务第三步", value = "/seller/add_group_goods_finish.htm*", rtype = "seller", rname = "服务发布", rcode = "group_seller", rgroup = "服务管理")
	@RequestMapping("/seller/add_group_goods_finish.htm")
	public ModelAndView add_group_goods_finish(HttpServletRequest request, HttpServletResponse response,
			GroupGoodsBO goods, String goods_session, String beginTimeStr, String endTimeStr, Boolean isEdit) {
		ModelAndView mv = null;
		// String goods_session1 =
		// CommUtil.null2String(request.getSession(false).getAttribute("group_goods_session"));
		if ((isEdit == null || isEdit == Boolean.FALSE)
				&& (goods_session == null || goods_session.equals(""))) {
			mv = new JModelAndView("user/default/sellercenter/seller_error.html",
					configService.getSysConfig(), 0, request, response);
			mv.addObject("op_title", "禁止重复提交表单");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/group_goods_list.htm?ggStatus=0");
		} else {
			mv = new JModelAndView("user/default/sellercenter/add_group_goods_finish.html",
					configService.getSysConfig(), 0, request, response);
			CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder
					.getCurrentUserDetails();
			Store store = storeService.getObjById(userDetails.getStoreId());
			if (store != null) {
				// 判断所发布的服务分类是否和商户经营分类匹配
				boolean m = Boolean.FALSE;
				if (StringUtils.isNotBlank(store.getGroupDetailInfo())
						&& (goods.getGgGcId() != null && goods.getGgGcId() > 0)) {
					String[] groupClassIds = store.getGroupDetailInfo().split(",");
					for (String groupClassId : groupClassIds) {
						if (CommUtil.null2Long(groupClassId).equals(goods.getGgGcId())) {
							m = Boolean.TRUE;
							break;
						}
					}
				}

				if (m) {
					if (StringUtils.isNotBlank(beginTimeStr)) {
						Date beginTime = CommUtil.formatDate(beginTimeStr);
						goods.setBeginTime(beginTime);
					}
					if (StringUtils.isNotBlank(endTimeStr)) {
						Date endTime = CommUtil.formatDate(endTimeStr);
						goods.setEndTime(endTime);
					}

					// 插入市级地区
					if (store.getAreaId() != null) {
						Area area = this.areaService.getObjById(store.getAreaId());
						if (area != null) {
							goods.setGgGaId(area.getParentId());
						}
					}
					goods.setGgStatus(GroupGoodsConstants.GROUP_GOODS_STATUS_STORE);// 仓库中
					if (goods.getPublishGoodsStatus().equals("0")) {// 立即发布
						goods.setGroupStatus(0);
					} else {
						goods.setGroupStatus(null);
					}
					if(StringUtils.isBlank(goods.getGroupMobileDesc())){//手机端商品简介没填 默认值为PC端商品简介
						goods.setGroupMobileDesc(goods.getGroupDesc());
					}
					goods.setStoreId(store.getId());
					goods.setUserId(store.getCreateUserId());
					goods.setAddTime(new Date());

					this.groupGoodsService.save(goods, store.getCreateUserId());

					mv.addObject("goods_view_url", CommUtil.getURL(request) + "/group/view_" + goods.getId()
							+ ".htm");
					mv.addObject("goods_edit_url", CommUtil.getURL(request)
							+ "/seller/group_goods_edit.htm?id=" + goods.getId());

					mv.addObject("op_title", "恭喜您！服务发布成功,平台会尽快为您审核！");
					mv.addObject("url", CommUtil.getURL(request) + "/seller/group_goods_list.htm?ggStatus=0");
				} else {
					mv.addObject("op_title", "服务类别和商户类别不一样，发布失败。");
					mv.addObject("url", CommUtil.getURL(request) + "/seller/group_goods_list.htm?ggStatus=0");
				}
			} else {
				mv.addObject("op_title", "登录失败，请重新登录");
				mv.addObject("url", CommUtil.getURL(request) + "/seller/index.htm");
			}
		}
		return mv;
	}

	@SecurityMapping(title = "出售中的服务列表", value = "/seller/group_goods_list.htm*", rtype = "seller", rname = "服务列表", rcode = "group_seller", rgroup = "服务管理")
	@RequestMapping("/seller/group_goods_list.htm")
	public ModelAndView group_goods_list(HttpServletRequest request, HttpServletResponse response,
			MyPage<GroupGoodsBO> page, GroupGoodsVO vo) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/group_goods_list.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		page.setPageSize(10);
		vo.setStoreId(userDetails.getSeller().getStoreId());
		vo.setGgStatus(GroupGoodsConstants.GROUP_GOODS_STATUS_SELLING);
		this.groupGoodsService.findListByVO(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);

		mv.addObject("storeTools", storeTools);
		mv.addObject("goodsViewTools", goodsViewTools);
		mv.addObject("vo", vo);
		mv.addObject("currentPage", page.getCurrentPage());
		return mv;
	}

	@SecurityMapping(title = "仓库中的服务列表", value = "/seller/group_goods_list_warehouse.htm*", rtype = "seller", rname = "服务列表", rcode = "group_seller", rgroup = "服务管理")
	@RequestMapping("/seller/group_goods_list_warehouse.htm")
	public ModelAndView group_goods_list_warehouse(HttpServletRequest request, HttpServletResponse response,
			MyPage<GroupGoodsBO> page, GroupGoodsVO vo) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/group_goods_list_warehouse.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		page.setPageSize(10);
		vo.setStoreId(userDetails.getSeller().getStoreId());
		// vo.setGgStatus(GroupGoodsConstants.GROUP_GOODS_STATUS_STORE);
		vo.setTarget("1");
		this.groupGoodsService.findListByVO(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("storeTools", storeTools);
		mv.addObject("goodsViewTools", goodsViewTools);
		mv.addObject("vo", vo);
		mv.addObject("currentPage", page.getCurrentPage());
		return mv;
	}

	@SecurityMapping(title = "违规下架的服务列表", value = "/seller/group_goods_list_out.htm*", rtype = "seller", rname = "服务列表", rcode = "group_seller", rgroup = "服务管理")
	@RequestMapping("/seller/group_goods_list_out.htm")
	public ModelAndView group_goods_list_out(HttpServletRequest request, HttpServletResponse response,
			MyPage<GroupGoodsBO> page, GroupGoodsVO vo) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/group_goods_list_out.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		page.setPageSize(10);
		vo.setStoreId(userDetails.getSeller().getStoreId());
		vo.setGgStatus(GroupGoodsConstants.GROUP_GOODS_STATUS_ILLEGAL_DOWN);
		this.groupGoodsService.findListByVO(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("storeTools", storeTools);
		mv.addObject("goodsViewTools", goodsViewTools);
		mv.addObject("vo", vo);
		mv.addObject("currentPage", page.getCurrentPage());
		return mv;
	}

	/**
	 * AJAX加载服务分类数据
	 * 
	 * @param request
	 * @param response
	 * @param pid
	 *            上级分类Id
	 * @param session
	 *            是否加载到session中
	 */
	@SuppressWarnings({"rawtypes", "unused"})
	@SecurityMapping(title = "加载服务分类", value = "/seller/load_group_goods_class.htm*", rtype = "seller", rname = "服务分类", rcode = "group_seller", rgroup = "服务管理")
	@RequestMapping("/seller/load_group_goods_class.htm")
	public void load_goods_class(HttpServletRequest request, HttpServletResponse response, String pid,
			String session) {
		GroupClassBO obj = this.dicContent.getTreeDic(GroupClassBO.class, pid);

		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		Store store = storeService.getObjById(userDetails.getSeller().getStoreId());
		List<Map> list = new ArrayList<Map>();
		if (obj != null) {
//			if (obj.getGcLevel() == 0) {// 加载二级分类
//				Map map = this.storeTools.query_MainGc_Map(CommUtil.null2String(obj.getId()), store.getGcDetailInfo());
//				if (map != null) {
//					List<Integer> ls = (List) map.get("gc_list");
//					if (ls != null && !ls.equals("")) {
//						for (Integer l : ls) {
//							Map map_gc = new HashMap();
//							GroupClass gc = this.groupClassService.getObjById(CommUtil.null2Long(l));
//							map_gc.put("id", gc.getId());
//							map_gc.put("className", gc.getGcName());
//							list.add(map_gc);
//						}
//					}
//				}
//			}
			if (CommUtil.null2Boolean(session)) {
				request.getSession(false).setAttribute("group_goods_class_info", obj);
			}
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(list));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SecurityMapping(title = "删除服务", value = "/seller/group_goods_del.htm*", rtype = "seller", rname = "服务删除", rcode = "group_seller", rgroup = "服务管理XX")
	@RequestMapping("/seller/group_goods_del.htm")
	public String group_goods_del(HttpServletRequest request, HttpServletResponse response, Long id,
			Integer ggStatus) {
		String url = "/seller/group_goods_list.htm";
		if (null != ggStatus && (null != id && id > 0)) {
			if (ggStatus.equals(GroupGoodsConstants.GROUP_GOODS_STATUS_SELLING)) {
				url = "/seller/group_goods_list.htm";
			}
			if (ggStatus.equals(GroupGoodsConstants.GROUP_GOODS_STATUS_STORE)) {
				url = "/seller/group_goods_list_warehouse.htm";
			}
			if (ggStatus.equals(GroupGoodsConstants.GROUP_GOODS_STATUS_ILLEGAL_DOWN)) {
				url = "/seller/group_goods_list_out.htm";
			}
			CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder
					.getCurrentUserDetails();
			this.groupGoodsService.delete(id);

			this.storeSearchService.updateIndex(userDetails.getStoreId());
		}
		return "redirect:" + url.toString();
	}

	@SecurityMapping(title = "批量删除服务", value = "/seller/group_goods_batch_del.htm*", rtype = "seller", rname = "删除服务", rcode = "group_seller", rgroup = "服务管理")
	@RequestMapping("/seller/group_goods_batch_del.htm")
	public String group_goods_batch_del(HttpServletRequest request, HttpServletResponse response,
			String mulitId, Integer ggStatus) {
		String url = "/seller/group_goods_list.htm";
		if (null != ggStatus) {
			if (ggStatus.equals(GroupGoodsConstants.GROUP_GOODS_STATUS_SELLING)) {
				url = "/seller/group_goods_list.htm";
			}
			if (ggStatus.equals(GroupGoodsConstants.GROUP_GOODS_STATUS_STORE)) {
				url = "/seller/group_goods_list_warehouse.htm";
			}
			if (ggStatus.equals(GroupGoodsConstants.GROUP_GOODS_STATUS_ILLEGAL_DOWN)) {
				url = "/seller/group_goods_list_out.htm";
			}
		}
		if (StringUtils.isNotBlank(mulitId)) {
			if (StringUtils.isNotBlank(mulitId)) {
				String[] ids = mulitId.split(",");
				for (String id : ids) {
					if (StringUtils.isNotBlank(id)) {
						this.groupGoodsService.delete(CommUtil.null2Long(id));
					}
				}
			}

			CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder
					.getCurrentUserDetails();
			this.storeSearchService.updateIndex(userDetails.getStoreId());
		}
		return "redirect:" + url.toString();
	}

	@SecurityMapping(title = "批量上下架服务", value = "/seller/group_goods_batch_sale.htm*", rtype = "seller", rname = "发布新服务", rcode = "group_seller", rgroup = "服务管理")
	@RequestMapping("/seller/group_goods_batch_sale.htm")
	public String group_goods_batch_sale(HttpServletRequest request, HttpServletResponse response,
			String mulitId) {
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		String url = "/seller/group_goods_list.htm";
		if (StringUtils.isNotBlank(mulitId)) {
			if (StringUtils.isNotBlank(mulitId)) {
				String[] ids = mulitId.split(",");
				for (String id : ids) {
					if (StringUtils.isNotBlank(id)) {
						GroupGoodsBO groupgoods = this.groupGoodsService.getObjById(CommUtil.null2Long(id));
						if (groupgoods.getGgStatus().equals(GroupGoodsConstants.GROUP_GOODS_STATUS_SELLING)) {// 下架
							groupgoods.setGgStatus(GroupGoodsConstants.GROUP_GOODS_STATUS_STORE);
						} else if (groupgoods.getGgStatus().equals(
								GroupGoodsConstants.GROUP_GOODS_STATUS_STORE)) {// 上架
							url = "/seller/group_goods_list_warehouse.htm";
							groupgoods.setGgStatus(GroupGoodsConstants.GROUP_GOODS_STATUS_SELLING);
						}
						this.groupGoodsService.update(groupgoods);
					}
				}
			}
			this.storeSearchService.updateIndex(userDetails.getSeller().getStoreId()); // 更新索引
		}

		return "redirect:" + url.toString();
	}

	@SecurityMapping(title = "上架下架服务", value = "/seller/group_goods_sale.htm*", rtype = "seller", rname = "上架下架服务", rcode = "group_seller", rgroup = "服务管理")
	@RequestMapping("/seller/group_goods_sale.htm")
	public String group_goods_sale(HttpServletRequest request, HttpServletResponse response, Long id) {
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		String url = "/seller/group_goods_list.htm";
		if (null != id && id > 0) {
			GroupGoodsBO groupgoods = this.groupGoodsService.getObjById(id);
			if (groupgoods.getGgStatus().equals(GroupGoodsConstants.GROUP_GOODS_STATUS_SELLING)) {
				groupgoods.setGgStatus(GroupGoodsConstants.GROUP_GOODS_STATUS_STORE);
			} else if (groupgoods.getGgStatus().equals(GroupGoodsConstants.GROUP_GOODS_STATUS_STORE)) {
				url = "/seller/group_goods_list_warehouse.htm";
				groupgoods.setGgStatus(GroupGoodsConstants.GROUP_GOODS_STATUS_SELLING);
			}
			this.groupGoodsService.update(groupgoods);
			this.storeSearchService.updateIndex(userDetails.getSeller().getStoreId()); // 更新索引
		}

		return "redirect:" + url.toString();
	}

	@SecurityMapping(title = "发布仓库中的服务", value = "/seller/group_goods_publish.htm*", rtype = "seller", rname = "上架下架服务", rcode = "group_seller", rgroup = "服务管理")
	@RequestMapping("/seller/group_goods_publish.htm")
	public String group_goods_publish(HttpServletRequest request, HttpServletResponse response, Long id) {
		String url = "/seller/group_goods_list_warehouse.htm";
		if (null != id && id > 0) {
			GroupGoodsBO groupgoods = this.groupGoodsService.getObjById(id);
			groupgoods.setGroupStatus(0);
			this.groupGoodsService.update(groupgoods);
		}
		return "redirect:" + url.toString();
	}

	@SecurityMapping(title = "服务补货", value = "/seller/group_goods_supplement.htm*", rtype = "seller", rname = "服务补货", rcode = "group_seller", rgroup = "服务管理")
	@RequestMapping("/seller/group_goods_supplement.htm")
	public ModelAndView group_goods_supplement(HttpServletRequest request, HttpServletResponse response,
			Long id) throws IOException {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/group_goods_supplement.html",
				configService.getSysConfig(), 0, request, response);

		if (id != null && id > 0) {
			GroupGoodsBO obj = this.groupGoodsService.getObjById(id);
			mv.addObject("obj", obj);
		}

		return mv;
	}

	@SecurityMapping(title = "服务补货保存", value = "/seller/group_goods_supplement_save.htm*", rtype = "seller", rname = "服务补货", rcode = "group_seller", rgroup = "服务管理")
	@RequestMapping("/seller/group_goods_supplement_save.htm")
	public void group_goods_supplement_save(HttpServletRequest request, HttpServletResponse response,
			Long id, Integer groupCount) throws IOException {

		Map<String, Integer> json_map = new HashMap<String, Integer>();
		Integer code = -100;

		if ((id != null && id > 0) && (groupCount != null && groupCount > 0)) {
			GroupGoodsBO obj = this.groupGoodsService.getObjById(id);
			if (obj != null) {
				obj.setGroupCount(groupCount);
				this.groupGoodsService.update(obj);
				code = 100;
			}
		}

		json_map.put("code", code);
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(json_map, org.nutz.json.JsonFormat.compact()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SecurityMapping(title = "服务编辑", value = "/seller/group_goods_edit.htm*", rtype = "seller", rname = "服务编辑", rcode = "group_seller", rgroup = "服务管理")
	@RequestMapping("/seller/group_goods_edit.htm")
	public ModelAndView group_goods_edit(HttpServletRequest request, HttpServletResponse response, Long id)
			throws IOException {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_error.html",
				configService.getSysConfig(), 0, request, response);

		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		Long storeId = userDetails.getSeller().getStoreId();
		StoreBO store = storeService.getObjById(storeId);

		if (id != null && id > 0) {
			GroupGoodsBO obj = this.groupGoodsService.getObjById(id);
			Long groupClassId = obj.getGgGcId();
			if (groupClassId != null && groupClassId > 0) {
				if (store != null && StringUtils.isNotBlank(store.getGroupDetailInfo())) {
					Boolean flag = Boolean.FALSE;
					String[] groupClassIds = store.getGroupDetailInfo().split(",");
					for (String gcId : groupClassIds) {
						if (CommUtil.null2Long(gcId).equals(groupClassId)) {
							flag = Boolean.TRUE;
							break;
						}
					}
					if (flag) {
						mv = new JModelAndView("user/default/sellercenter/add_group_goods_second.html",
								configService.getSysConfig(), 0, request, response);
						String gcName = "";
						if (request.getSession(false).getAttribute("group_goods_class_info") != null) {
							GroupClass gc = (GroupClass) request.getSession(false).getAttribute(
									"group_goods_class_info");
							gc = this.groupClassService.getObjById(gc.getId());
							if (gc != null) {
								obj.setGgGcId(gc.getId());
							}
							String goods_class_info = this.groupGoodsService.genericGoodsClassInfo(gc);
							gcName = goods_class_info.substring(0, goods_class_info.length() - 1);
							request.getSession(false).removeAttribute("group_goods_class_info");
						} else {
							GroupClass groupClass = this.groupClassService.getObjById(groupClassId);
							if (groupClass != null) {
								if (StringUtils.isNotBlank(groupClass.getGcName())) {
									gcName = groupClass.getGcName();
								}
								if (groupClass.getId() != null && groupClass.getId() > 0) {
									GroupClass parentGroupClass = this.groupClassService
											.getObjById(groupClass.getParentId());
									if (parentGroupClass != null
											&& StringUtils.isNotBlank(parentGroupClass.getGcName())) {
										gcName = parentGroupClass.getGcName() + " > " + gcName;
									}
								}
							}
						}
						mv.addObject("gcName", gcName);
						List<Accessory> goodsAccList = accessoryService
								.selectGroupGoodsByGoodsId(obj.getId());
						mv.addObject("goodsAccList", goodsAccList);
					} else {
						mv.addObject("op_title", "您的服务类目与现商户主营类目不相符，暂时不能编辑服务");
						mv.addObject("url", CommUtil.getURL(request)
								+ "/seller/group_goods_list.htm?ggStatus=0");
					}
				}
			} else {
				mv.addObject("op_title", "服务ID丢失，暂时不能编辑服务");
				mv.addObject("url", CommUtil.getURL(request) + "/seller/group_goods_list.htm?ggStatus=0");
			}

			mv.addObject("edit", true);
			mv.addObject("obj", obj);
		} else {
			mv.addObject("op_title", "服务ID丢失，暂时不能编辑服务");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/group_goods_list.htm?ggStatus=0");
		}

		return mv;
	}

	@SecurityMapping(title = "虚拟团购码验证", value = "/seller/group_code.htm*", rtype = "seller", rname = "团购套餐", rcode = "group_code_seller", rgroup = "交易管理")
	@RequestMapping("/seller/group_code.htm")
	public ModelAndView group_code(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/group_code.html",
				configService.getSysConfig(), 0, request, response);
		return mv;
	}

	@SecurityMapping(title = "使用消费码", value = "/seller/check_group_code.htm*", rtype = "seller", rname = "团购码管理", rcode = "group_seller", rgroup = "交易管理")
	@RequestMapping("/seller/check_group_code.htm")
	public void check_group_code(HttpServletRequest request, HttpServletResponse response, String value) {
		String code = "0";// 不存在

		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		Store store = storeService.getObjById(userDetails.getSeller().getStoreId());
		GroupGoodsBO info = null;

		if (StringUtils.isNotBlank(value) && store != null) {
			info = this.groupGoodsService.queryGroupDetails(value, store.getCreateUserId());
		}
		if (info != null) {
			if (info.getStatus() == GroupGoodsConstants.GROUP_INFO_STATUS_USED) {
				code = "-30";// 使用后
			}
			if (info.getStatus() == -1) {
				code = "-50";// 过期
			}
			if (info.getStatus() == 3) {
				code = "-100";// 审核中
			}
			if (info.getStatus() == 5) {
				code = "-150";// 审核通过
			}
//			if (info.getStatus() == 6) {//审核不通过仍然可以使用
//				code = "-130";// 审核不通过
//			}
			if (info.getStatus() == 7) {
				code = "-200";// 已经退款
			}
			if (info.getStatus() == 0 || info.getStatus() == 6) {//审核不通过仍然可以使用
				// info.setStatus(1);
				try {
					// this.groupInfoService.consumerSure(value, store.getCreateUserId());
					// 因为muxi修改了消码接口而修改代码
					GroupInfoBO infoBO = groupInfoService.queryGroupInfoBySn(store.getCreateUserId(), value);
					this.groupInfoService.consumerSure(infoBO);
					code = "100";// 成功
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(code);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SecurityMapping(title = "服务图片删除", value = "/seller/group_goods_image_del.htm*", rtype = "seller", rname = "发布新服务", rcode = "group_seller", rgroup = "服务管理")
	@RequestMapping("/seller/group_goods_image_del.htm")
	public void group_goods_image_del(HttpServletRequest request, HttpServletResponse response, Long imageId,
			Long groupGoodsId) {
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			Map<String, Boolean> map = new HashMap<String, Boolean>();
			Accessory img = this.accessoryService.getObjById(CommUtil.null2Long(imageId));
			boolean ret = false;
			if (img != null) {
				groupGoodsService.deleteGroupPhoto(imageId, groupGoodsId);
				ret = true;
			}
			map.put("result", ret);
			writer = response.getWriter();
			writer.print(Json.toJson(map));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
