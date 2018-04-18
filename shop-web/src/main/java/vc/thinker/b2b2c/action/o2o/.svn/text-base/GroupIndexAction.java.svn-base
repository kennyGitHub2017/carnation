package vc.thinker.b2b2c.action.o2o;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.elasticsearch.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.interceptor.LbsInterceptorAdapter;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.lucene.LuceneUtil;

import com.sinco.carnation.goods.service.GoodsCartService;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.o2o.bo.GroupClassBO;
import com.sinco.carnation.o2o.bo.GroupFloorBO;
import com.sinco.carnation.o2o.bo.GroupGoodsBO;
import com.sinco.carnation.o2o.service.GroupCaseService;
import com.sinco.carnation.o2o.service.GroupClassService;
import com.sinco.carnation.o2o.service.GroupFloorService;
import com.sinco.carnation.o2o.service.GroupGoodsService;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.o2o.tools.GroupViewTools;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.PayTools;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.store.tools.StoreViewTools;
import com.sinco.carnation.store.vo.GroupStoreListVO;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.model.Accessory;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.sys.tools.NavViewTools;
import com.sinco.carnation.user.UserContants;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.dic.client.DicContent;

/**
 * 
 * <p>
 * Title: GroupViewAction.java
 * </p>
 * 
 * <p>
 * Description:团购管理控制器，超级后台用来发起团购、审核团购商品，添加团购商品类目、价格区间等等
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
 * @date 2014-5-28
 * 
 * @version 1.0.1
 */
@Controller
public class GroupIndexAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private GroupClassService groupClassService;
	@Autowired
	private GroupGoodsService groupGoodsService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private GoodsCartService goodsCartService;
	@Autowired
	private UserService userService;
	@Autowired
	private GroupOrderService groupOrderService;
	@Autowired
	private GroupViewTools groupViewTools;
	@Autowired
	private GoodsClassService goodsClassService;
	@Autowired
	private NavViewTools navTools;
	@Autowired
	private UserCustomerService userCustomerService;
	@Autowired
	private StoreViewTools storeViewTools;
	@Autowired
	private StoreService storeService;
	@Autowired
	private LuceneUtil luceneUtil;
	@Autowired
	private AccessoryServiceImpl accessoryService;
	@Autowired
	private GroupCaseService groupCaseService;
	@Autowired
	private PayTools payTools;
	@Autowired
	private GroupFloorService groupFloorService;
	@Autowired
	private AreaServiceImpl areaService;

	@Autowired
	private DicContent dicContent;
	@Autowired
	private UserAccountService userAccountService;
	
	/**
	 * 静态页面云尚pc
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/static_index.htm")
	public ModelAndView static_index(HttpServletRequest request,
			HttpServletResponse response) {
		
	 
		ModelAndView mv = new JModelAndView("static_pc/index.html",
				configService.getSysConfig(),
				 1, request, response);
		return mv;
	}
	

	@RequestMapping("/group/index.htm")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {

		/*		ModelAndView mv = new JModelAndView("o2o/index.html",
						configService.getSysConfig(),1, request, response);*/
		ModelAndView mv = new JModelAndView("o2o/jiankangshenhuoquan.html", configService.getSysConfig(), 1,
				request, response);

		Area city = (Area) request.getAttribute(LbsInterceptorAdapter.O2O_CITY);
		mv.addObject("city", city);
		// 加载橱窗
		/*GroupCaseShowVO caseVO=new GroupCaseShowVO();
		caseVO.setCount(4);
		caseVO.setDisplay(true);
		List<GroupCaseBO> caseList=groupCaseService.findShow(caseVO);
		GroupGoodsListShowVO  caseGoodsVO=new GroupGoodsListShowVO();
		if(caseList.size() > 0){
			GroupCaseBO groupCase=caseList.get(0);
			GroupGoodsListShowVO  caseGoodsVO=new GroupGoodsListShowVO();
			caseGoodsVO.setCaseId(groupCase.getId());
			caseGoodsVO.setCityId(city.getId());
			List<GroupGoodsBO> caseGoodsList=groupGoodsService.findListShow(caseGoodsVO);
			mv.addObject("caseGoodsList", caseGoodsList);
			mv.addObject("groupCase",groupCase);
		}*/
		// 加载楼层
		List<GroupFloorBO> floorList = groupFloorService.findDisplayAll();
		for (GroupFloorBO floor : floorList) {
			GroupStoreListVO vo = new GroupStoreListVO();
			vo.setCount(4);
			vo.setFloorId(floor.getId());
			vo.setCityId(city.getId());
			floor.setStores(storeService.findGroupStoreList(vo));
		}
		mv.addObject("groupViewTools", groupViewTools);
		mv.addObject("floorList", floorList);
		return mv;
	}

	@RequestMapping("/group/head.htm")
	public ModelAndView group_head(HttpServletRequest request, HttpServletResponse response, String ga_id,
			String type, String keyword, String classId) {
		ModelAndView mv = new JModelAndView("o2o/head.html", configService.getSysConfig(), 1, request,
				response);
//		mv.addObject("gas", gas);
		mv.addObject("type", type);
		mv.addObject("keyword", keyword);
		return mv;
	}

	@RequestMapping("/group/top.htm")
	public ModelAndView top(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new JModelAndView("o2o/top.html", configService.getSysConfig(), 1, request,
				response);
		mv.addObject("navTools", navTools);
		return mv;
	}

	@RequestMapping("/group/nav.htm")
	public ModelAndView group_nav(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("o2o/nav.html", configService.getSysConfig(), 1, request,
				response);
		UserBO userBo = SecurityUserHolder.getCurrentUser();
		if (null != userBo) {
			UserAccount userAccount = this.userAccountService.findUserAccount(userBo.getId(),
					UserContant.ACCOUNT_TYPE_8);
			if (null == userAccount) {
				mv.addObject("cnFlagFalse", 1);
			}
		} else {
			mv.addObject("cnFlagFalse", 1);
		}

		List<GroupClassBO> list = groupClassService.findCacheLevelAll();
		List<GroupClassBO> gcs = new ArrayList<>();
		for(GroupClassBO bo : list){
			if(bo.getGcType().equals(10)){//10 跳转H5的分类 用于app周边 酒店 机票等H5跳转
			}else{
				gcs.add(bo);
			}
		}
		if (gcs.size() > 8) {
			gcs = gcs.subList(0, 8);
		}
		mv.addObject("gcs", gcs);
		return mv;
	}

//
//	@RequestMapping("/group/view.htm")
//	public ModelAndView group_view(HttpServletRequest request,
//			HttpServletResponse response, String id) {
//		ModelAndView mv = new JModelAndView("group_view.html",
//				configService.getSysConfig(),
//				this.userConfigService.getUserConfig(), 1, request, response);
//		GroupGoods obj = this.groupGoodsService.getObjById(CommUtil
//				.null2Long(id));
//		User user = SecurityUserHolder.getCurrentUser();
//		boolean view = false;
//		if (obj.getGroup().getBeginTime().before(new Date())
//				&& obj.getGroup().getEndTime().after(new Date())
//				&& obj.getGg_status() == 1) {
//			view = true;
//		}
//		if (user != null && user.getUserRole().indexOf("ADMIN") >= 0) {
//			view = true;
//		}
//		if (view) {
//			mv.addObject("obj", obj);
//			Map params = new HashMap();
//			params.put("beginTime", new Date());
//			params.put("endTime", new Date());
//			params.put("status", 0);
//			params.put("group_type", 0);
//			List<Group> groups = this.groupService
//					.query("select obj from Group obj where obj.beginTime<=:beginTime and obj.endTime>=:endTime and obj.status=:status and obj.group_type=:group_type",
//							params, -1, -1);
//			if (groups.size() > 0) {
//				GroupGoodsQueryObject ggqo = new GroupGoodsQueryObject("1", mv,
//						"gg_recommend", "desc");
//				ggqo.addQuery("obj.gg_status", new SysMap("gg_status", 1), "=");
//				ggqo.addQuery("obj.group.id", new SysMap("group_id", obj
//						.getGroup().getId()), "=");
//				ggqo.addQuery("obj.id", new SysMap("goods_id", obj.getId()),
//						"!=");
//				ggqo.addQuery("obj.beginTime", new SysMap("beginTime",
//						new Date()), "<=");
//				ggqo.addQuery("obj.endTime", new SysMap("endTime", new Date()),
//						">=");
//				ggqo.setPageSize(4);
//				IPageList pList = this.groupGoodsService.list(ggqo);
//				mv.addObject("hot_ggs", pList.getResult());
//				mv.addObject("group", groups.get(0));
//			}
//		} else {
//			mv = new JModelAndView("error.html", configService.getSysConfig(),
//					this.userConfigService.getUserConfig(), 1, request,
//					response);
//			mv.addObject("op_title", "团购商品参数错误");
//			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
//		}
//		return mv;
//	}
//
	@RequestMapping("/group/view_{id}.htm")
	public ModelAndView grouplife_view(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("id") Long id) {
		ModelAndView mv = new JModelAndView("o2o/group_view.html", configService.getSysConfig(), 1, request,
				response);

		GroupGoodsBO obj = this.groupGoodsService.getObjById(id);
		if (obj == null) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "服务不存在，或者已经下架");
			mv.addObject("url", CommUtil.getURL(request) + "/group/index.htm");
			return mv;
		}

		StoreBO store = this.storeService.getObjById(obj.getStoreId());

		Long userId = SecurityUserHolder.getCurrentUserId();

		if (userId != null) {
			boolean isFavorite = userCustomerService.queryIsFavorites(userId,
					CommUtil.null2String(obj.getId()), UserContants.FAVORITES_TYPE_5);
			mv.addObject("isFavorite", isFavorite);
		}

		List<Accessory> goodsAccList = accessoryService.selectGroupGoodsByGoodsId(obj.getId());

		// 获取分类信息
		mv.addObject("groupClassNav", makeNav(obj.getGgGcId()));
		mv.addObject("obj", obj);
		mv.addObject("store", store);
		mv.addObject("goodsAccList", goodsAccList);

		mv.addObject("groupViewTools", groupViewTools);
		return mv;
	}

	@RequestMapping("/group/city_select.htm")
	public ModelAndView selectCity(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("o2o/city_select.html", configService.getSysConfig(), 1, request,
				response);
		List<Area> areas = areaService.getAllParentIsNull();
		mv.addObject("areas", areaService.getAllParentIsNull());

		if (areas.size() > 0) {
			Long parentId = areas.get(0).getId();
			mv.addObject("citys", areaService.getCacheByParentId(parentId.toString()));
		}

		List<Area> hotCitys = areaService.findGroupHotCity();
		mv.addObject("hotCitys", hotCitys);

		Map<String, List<Area>> cityAll = areaService.findPinyinMap();
		mv.addObject("cityAll", cityAll);

		return mv;
	}

	@RequestMapping("/group/saecity_select_save.htm")
	public String selectCitySave(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("cityId") String cityId) {

		Cookie cookie = new Cookie(LbsInterceptorAdapter.O2O_CITY_ID, cityId);
		cookie.setDomain(CommUtil.generic_domain(request));
		cookie.setPath("/");
		cookie.setMaxAge(60 * 60 * 24 * 30);
		response.addCookie(cookie);

		return "redirect:/group/index.htm";
	}

	private List<GroupClassBO> makeNav(Long gcId) {
		List<GroupClassBO> result = Lists.newArrayList();
		GroupClassBO gc = this.dicContent.getTreeDic(GroupClassBO.class, String.valueOf(gcId));
		makeNav(gc, result);
		Collections.reverse(result);
		result.add(gc);
		return result;
	}

	private void makeNav(GroupClassBO gc, List<GroupClassBO> list) {
		if (gc.getParent() != null) {
			list.add(gc.getParent());
			makeNav(gc.getParent(), list);
		}
	}
}
