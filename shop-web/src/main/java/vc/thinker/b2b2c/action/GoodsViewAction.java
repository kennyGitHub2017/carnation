package vc.thinker.b2b2c.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.common.collect.Lists;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.activity.service.ActivityGoodsService;
import com.sinco.carnation.buygift.service.BuyGiftService;
import com.sinco.carnation.combin.service.CombinPlanService;
import com.sinco.carnation.evaluate.service.EvaluateService;
import com.sinco.carnation.evaluate.tools.EvaluateViewTools;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.carnation.goods.bo.GoodsYgClassBO;
import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.goods.model.GoodsClass;
import com.sinco.carnation.goods.service.GoodsBrandService;
import com.sinco.carnation.goods.service.GoodsCartService;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.goods.service.GoodsLogService;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.service.GoodsSpecPropertyService;
import com.sinco.carnation.goods.service.GoodsTypePropertyService;
import com.sinco.carnation.goods.service.GoodsTypeService;
import com.sinco.carnation.goods.service.UserGoodsClassService;
import com.sinco.carnation.goods.service.ZeroGoodsService;
import com.sinco.carnation.goods.tools.GoodsViewTools;
import com.sinco.carnation.goods.vo.GoodsVO;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.sales.service.EnoughReduceService;
import com.sinco.carnation.shop.bo.ConsultBO;
import com.sinco.carnation.shop.bo.EvaluateBO;
import com.sinco.carnation.shop.bo.GoodsReceiptBO;
import com.sinco.carnation.shop.model.Consult;
import com.sinco.carnation.shop.model.ZeroGoods;
import com.sinco.carnation.shop.service.ConsultService;
import com.sinco.carnation.shop.service.GoodsReceiptService;
import com.sinco.carnation.shop.tools.ConsultViewTools;
import com.sinco.carnation.shop.vo.ConsultVO;
import com.sinco.carnation.shop.vo.EvaluateVO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.service.StoreNavigationService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.store.tools.StoreViewTools;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.transport.tools.TransportTools;
import com.sinco.carnation.user.UserContants;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.model.UserGoodsClass;
import com.sinco.carnation.user.service.FootPointService;
import com.sinco.carnation.user.service.ManagerService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.DicContent;
import com.sinco.dic.client.model.DicBase;
import com.sinco.dic.client.model.DicParentBase;

/**
 * 
 * <p>
 * Title: GoodsViewAction.java
 * </p>
 * 
 * <p>
 * Description: 商品前台控制器,用来显示商品列表、商品详情、商品其他信息
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2012-2014
 * </p>
 * 
 * <p>
 * Company: 深圳市新科聚合网络技术有限公司 www.thinker.vc
 * </p>
 * 
 * @author thinker
 * 
 * @date 2014-4-28
 * 
 * @version 1.0.1
 */
@Controller
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
public class GoodsViewAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private GoodsClassService goodsClassService;
	@Autowired
	private UserGoodsClassService userGoodsClassService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private EvaluateService evaluateService;

	@Autowired
	private GoodsReceiptService goodsReceiptService;

	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private GoodsCartService goodsCartService;
	@Autowired
	private ConsultService consultService;
	@Autowired
	private GoodsBrandService brandService;
	@Autowired
	private GoodsSpecPropertyService goodsSpecPropertyService;
	@Autowired
	private GoodsTypePropertyService goodsTypePropertyService;
	@Autowired
	private AreaServiceImpl areaService;
	// @Autowired
	// private AreaViewTools areaViewTools;
	@Autowired
	private GoodsViewTools goodsViewTools;
	@Autowired
	private StoreViewTools storeViewTools;
	// @Autowired
	// private UserTools userTools;
	@Autowired
	private TransportTools transportTools;
	@Autowired
	private ConsultViewTools consultViewTools;
	@Autowired
	private EvaluateViewTools evaluateViewTools;
	@Autowired
	private UserService userService;
	@Autowired
	private UserCustomerService userCustomerService;
	@Autowired
	private ManagerService manageService;
	@Autowired
	private StoreNavigationService storenavigationService;
	// @Autowired
	// private ConsultSatisService consultsatisService;
	// @Autowired
	// private IntegralViewTools integralViewTools;
	@Autowired
	private EnoughReduceService enoughReduceService;
	@Autowired
	private FootPointService footPointService;
	@Autowired
	private ActivityGoodsService actgoodsService;
	// @Autowired
	// private ActivityViewTools activityViewTools;
	@Autowired
	private GoodsLogService goodsLogService;
	@Autowired
	private CombinPlanService combinplanService;
	@Autowired
	private OrderFormTools orderFormTools;
	@Autowired
	private BuyGiftService buyGiftService;
	@Autowired
	private DicContent dicContent;
	@Autowired
	private GoodsTypeService goodsTypeService;
	@Autowired
	private ZeroGoodsService zeroGoodsService;
	@Autowired
	private UserAccountService userAccountService;

	private Set<Long> genericUserGcIds(UserGoodsClass ugc) {
		Set<Long> ids = new HashSet<Long>();
		ids.add(ugc.getId());
		// for (UserGoodsClass child : ugc.getChilds()) {
		// Set<Long> cids = genericUserGcIds(child);
		// for (Long cid : cids) {
		// ids.add(cid);
		// }
		// ids.add(child.getId());
		// }
		return ids;
	}

	@RequestMapping("/getPartsPrice.htm")
	public void genericCombinPartsPrice(HttpServletRequest request, HttpServletResponse response,
			String parts_ids, String gid) {
		double all_price = 0.00;
		if (gid != null && !gid.equals("")) {
			Goods obj = this.goodsService.getObjById(CommUtil.null2Long(gid));
			all_price = CommUtil.null2Double(obj.getGoodsCurrentPrice());
		}
		if (parts_ids != null && !parts_ids.equals("")) {
			String ids[] = parts_ids.split(",");
			for (String id : ids) {
				if (!id.equals("")) {
					Goods obj = this.goodsService.getObjById(CommUtil.null2Long(id));
					all_price = CommUtil.add(all_price, obj.getGoodsCurrentPrice());
				}
			}
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(CommUtil.formatMoney(all_price));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 查看店铺商品详细信息
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping("/goods.htm")
	public ModelAndView goods(HttpServletRequest request, HttpServletResponse response, String id,
			String falg, Boolean admin_view) {
		if (admin_view == null) {
			admin_view = false;
		}
		ModelAndView mv = null;
		if (!StringUtils.isNotEmpty(id)) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "参数错误，商品查看失败");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
			return mv;
		}
		GoodsBO obj = this.goodsService.getFullGoodsById(CommUtil.null2Long(id));
		Long uid = SecurityUserHolder.getCurrentUserId();
		Integer userIntegral = 0;
		boolean isCN = Boolean.FALSE;
		System.out.println("=========" + obj.getCnSelfAddPrice() + "  goodstype:" + obj.getGoodsType());
		if (obj == null || obj.getDeleteStatus() == 1) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "对不起，商品已下架！");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
			return mv;
		}
		if (obj != null) {
			if (this.configService.getSysConfig().getSecondDomainOpen()) {// 如果系统开启了二级域名，则判断该商品是不是对应的二级域名下的，如果不是则返回错误页面
				String serverName = request.getServerName().toLowerCase();
				String secondDomain = CommUtil.null2String(serverName.substring(0, serverName.indexOf(".")));
				if (serverName.indexOf(".") == serverName.lastIndexOf(".")) {
					secondDomain = "www";
				}
				// System.out.println("已经开启二级域名，二级域名为：" + secondDomain);
				if (!secondDomain.equals("")) {
					if (obj.getGoodsType() == 0) {// 自营商品禁止使用二级域名访问
						if (!secondDomain.equals("www")) {
							mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request,
									response);
							mv.addObject("op_title", "参数错误，商品查看失败");
							mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
							return mv;
						}
						// System.out.println("已经开启二级域名，自营商品禁止二级域名访问");
					} else {
						if (!obj.getGoodsStore().getStoreSecondDomain().equals(secondDomain)) {
							mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request,
									response);
							mv.addObject("op_title", "参数错误，商品查看失败");
							mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
							// System.out.println("已经开启二级域名，非本店商品，二级域名错误");
							return mv;
						}
					}
				} else {
					mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
					mv.addObject("op_title", "参数错误，商品查看失败");
					mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
					return mv;
				}
			}
			addGoodsCookie(request, response, id);
			UserBO current_user = SecurityUserHolder.getCurrentUser();

			mv = new JModelAndView("default/store_goods.html", configService.getSysConfig(), 1, request,
					response);
			// boolean admin_view = false;// 超级管理员可以查看未审核得到商品信息
			if (current_user != null) {
				/*UserCustomerBO userCustomer = userCustomerService.findSessionUser(current_user.getId());*/
				UserCustomerBO userCustomer = this.userCustomerService.findOneByUserId(current_user.getId());//修改
				
				if (userCustomer != null) {
					// 判断是否已经收藏
					boolean isFavorite = userCustomerService.queryIsFavorites(userCustomer.getUid(),
							CommUtil.null2String(obj.getId()), UserContants.FAVORITES_TYPE_3);
					mv.addObject("isFavorite", isFavorite);
					footPointService.saveFootPoint(
							current_user,
							obj,
							obj.getGoodsMainPhotoPath() != null ? obj.getGoodsMainPhotoPath() : CommUtil
									.getURL(request)
									+ "/"
									+ this.configService.getSysConfig().getGoodsImage().getPath()
									+ "/"
									+ this.configService.getSysConfig().getGoodsImage().getName(),
							userCustomer.getNickname());

					/**
					 * 会员登陆后 检查是否为CN用户 CN用户，新增 BV值，云购币值+现金值 add by yuleijia 2017.2.20
					 */
					UserAccountBO account1 = new UserAccountBO();
					account1.setUid(uid);
					account1.setAccountType(UserContant.ACCOUNT_TYPE_8);
					UserAccountBO cnUserAccount = userAccountService.findAccountByVo(account1);
					if (cnUserAccount != null) {
						isCN = Boolean.TRUE;
					}
					
					if(uid != null){//检查用户积分是否足够购买商品	
						boolean userIsCn = userAccountService.check_User_Is_CN(uid);
						if(userIsCn){
							
						}else{
							UserCustomerBO user = userCustomerService.findSessionUser(uid);
							if(null != user){
								userIntegral = user.getIntegral();
							}
						}
					}
				}

			}
			mv.addObject("isCN", isCN);
			mv.addObject("userIntegral", userIntegral);
			// 记录商品点击日志
			String from = clickfrom_to_chinese(CommUtil.null2String(request.getParameter("from")));
			goodsLogService.saveClickLog(obj.getId(), from);

			// falg不为null，则是从商家后台点击，不验证商品上下架，否则验证
			if (StringUtils.isNotBlank(falg)) {

				obj.setGoodsClick(obj.getGoodsClick() + 1);
				if (this.configService.getSysConfig().getZtcStatus() && obj.getZtcStatus() == 2) {
					obj.setZtcClickNum(obj.getZtcClickNum() + 1);
				}
				// 检测商品所有活动状态
				if (obj.getActivityStatus() == 1 || obj.getActivityStatus() == 2) {// 检查商城促销商品是否过期
					if (!CommUtil.null2String(obj.getActivityGoodsId()).equals("")) {
					}
				}
				this.goodsService.update(obj);
				mv.addObject("admin_view", admin_view);
				mv.addObject("obj", obj);
				mv.addObject("goodsViewTools", goodsViewTools);
				mv.addObject("transportTools", transportTools);
				// 计算当期访问用户的IP地址，并计算对应的运费信息
				String current_ip = CommUtil.getIpAddr(request);// 获得本机IP
				// System.out.println("当前IP："+current_ip);
				if (CommUtil.isIp(current_ip)) {
					vc.thinker.b2b2c.core.ip.IPSeeker ip = new vc.thinker.b2b2c.core.ip.IPSeeker(null, null);
					String current_city = ip.getIPLocation(current_ip).getCountry();
					mv.addObject("current_city", current_city);
				} else {
					mv.addObject("current_city", "未知地区");
				}
				// 查询运费地区
				List<Area> areas = this.dicContent.getRootTreeDic(Area.class);
				mv.addObject("areas", areas);
				// 相关分类
				// Map params = new HashMap();
				// params.put("parent_id", obj.getGc().getParent().getId());
				// params.put("display", true);

				DicParentBase gcBo = (DicParentBase) dicContent.getDic(GoodsClassBO.class,
						CommUtil.null2String(obj.getGcId()));
				List<DicBase> about_gcs = this.dicContent.getDicsByParentCode(GoodsClassBO.class,
						gcBo.getParentCode());

				mv.addObject("about_gcs", about_gcs);
				// mv.addObject("userTools", userTools);
				// mv.addObject("activityViewTools", activityViewTools);
				if (obj.getGoodsType() == 0) {// 平台自营商品
				} else {// 商家商品
					StoreBO store = storeService.getObjById(obj.getGoodsStoreId());
					obj.setGoodsStore(store);
					this.generic_evaluate(store, mv);
					mv.addObject("store", store);
					String fullName = "";
					if (store.getAreaId() != null) {
						fullName = areaService.fullName(store.getAreaId());
					}
					mv.addObject("fullName", fullName);
				}
				List<GoodsBO> sameClassGoods = null;
				// 查询同类产品云购币页面 和 普通页面
				if (obj.getIsYgb() == 1) {
					GoodsVO vo = new GoodsVO();
					vo.setIsYgb(1);
					sameClassGoods = this.goodsService.findGoodsByVoAndLimit(vo, 0, 5);
				} else {
					sameClassGoods = goodsService.selectSameClassGoodsList(obj.getGcId(), obj.getId(), 0, 5);
				}

				mv.addObject("sameClassGoods", sameClassGoods);
				// 查詢评价第一页信息
				MyPage<EvaluateBO> page = new MyPage<EvaluateBO>();
				page.setPageSize(10);
				EvaluateVO vo = new EvaluateVO();
				vo.setEvaluateGoodsId(CommUtil.null2Long(id));
				vo.setEvaluateType("goods");
				vo.setEvaluateStatus(0);
				evaluateService.queryEvaluateListByVO(vo, page);

				String url = CommUtil.getURL(request) + "/goods_evaluation.htm";
				mv.addObject("eva_objs", page.getResult());
				mv.addObject("evaObjsTotal", page.getTotalElements());
				mv.addObject(
						"eva_gotoPageAjaxHTML",
						CommUtil.showPageAjaxHtml(url, "&evaluateGoodsId="+CommUtil.null2Long(id)+"&evaluateType="+"goods"+"&evaluateStatus="+0, page.getCurrentPage(), page.getPages(),
								page.getPageSize(), page.getRowCount()));
				mv.addObject("evaluateViewTools", this.evaluateViewTools);
				mv.addObject("orderFormTools", this.orderFormTools);

				goodsReceiptListView(request, id, null, mv);
//				// 查询成交记录第一页
//				MyPage<GoodsReceiptBO> goodsReceiptPage = new MyPage<GoodsReceiptBO>();
//				goodsReceiptPage.setPageSize(10);
//				List<GoodsReceiptBO> list = goodsReceiptPage.getResult();
//				for (GoodsReceiptBO item : list) {
//					item.setBuyerName(orderFormTools.dealNickNameDisplay(item.getBuyerName()));
//				}
//				goodsReceiptService.findGoodsReceiptList(goodsReceiptPage, CommUtil.null2Long(id));
//
//				url = CommUtil.getURL(request) + "/goods_order.htm";
//				mv.addObject("order_objs", list);
//				mv.addObject("order_gotoPageAjaxHTML",
//						CommUtil.showPageAjaxHtml(url, "", goodsReceiptPage.getCurrentPage(),
//								goodsReceiptPage.getPages(), goodsReceiptPage.getPageSize(),
//								goodsReceiptPage.getRowCount()));

				// 查询商品咨询第一页
				MyPage<ConsultBO> pageConsult = new MyPage<ConsultBO>();
				pageConsult.setPageSize(10);
				ConsultVO voConsult = new ConsultVO();
				voConsult.setGoodsId(CommUtil.null2Long(id));
				this.consultService.selectConsultListByVO(voConsult, pageConsult);;
				url = CommUtil.getURL(request) + "/goods_consult.htm";
				mv.addObject("consult_objs", pageConsult.getResult());
				mv.addObject(
						"consult_gotoPageAjaxHTML",
						CommUtil.showPageAjaxHtml(url, "", pageConsult.getCurrentPage(),
								pageConsult.getPages(), pageConsult.getPageSize(), pageConsult.getRowCount()));
				mv.addObject("consultViewTools", this.consultViewTools);

				mv.addObject("goodsClassNav", makeNav(obj.getGcId()));


			} else {
				if (obj.getGoodsStatus() == 0 || admin_view) {
					obj.setGoodsClick(obj.getGoodsClick() + 1);
					if (this.configService.getSysConfig().getZtcStatus() && obj.getZtcStatus() == 2) {
						obj.setZtcClickNum(obj.getZtcClickNum() + 1);
					}
					// 检测商品所有活动状态
					if (obj.getActivityStatus() == 1 || obj.getActivityStatus() == 2) {// 检查商城促销商品是否过期
						if (!CommUtil.null2String(obj.getActivityGoodsId()).equals("")) {
						}
					}
					this.goodsService.update(obj);
					mv.addObject("admin_view", admin_view);
					mv.addObject("obj", obj);
					mv.addObject("goodsViewTools", goodsViewTools);
					mv.addObject("transportTools", transportTools);
					// 计算当期访问用户的IP地址，并计算对应的运费信息
					String current_ip = CommUtil.getIpAddr(request);// 获得本机IP
					// System.out.println("当前IP："+current_ip);
					if (CommUtil.isIp(current_ip)) {
						vc.thinker.b2b2c.core.ip.IPSeeker ip = new vc.thinker.b2b2c.core.ip.IPSeeker(null,
								null);
						String current_city = ip.getIPLocation(current_ip).getCountry();
						mv.addObject("current_city", current_city);
					} else {
						mv.addObject("current_city", "未知地区");
					}
					// 查询运费地区
					List<Area> areas = this.dicContent.getRootTreeDic(Area.class);
					mv.addObject("areas", areas);
					// 相关分类
					// Map params = new HashMap();
					// params.put("parent_id", obj.getGc().getParent().getId());
					// params.put("display", true);

					DicParentBase gcBo = (DicParentBase) dicContent.getDic(GoodsClassBO.class,
							CommUtil.null2String(obj.getGcId()));
					if (null != gcBo) {
						List<DicBase> about_gcs = this.dicContent.getDicsByParentCode(GoodsClassBO.class,
								gcBo.getParentCode());

						mv.addObject("about_gcs", about_gcs);
					}
					// mv.addObject("userTools", userTools);
					// mv.addObject("activityViewTools", activityViewTools);
					if (obj.getGoodsType() == 0) // 平台自营商品
					{

					} else // 商家商品
					{
						StoreBO store = storeService.getObjById(obj.getGoodsStoreId());
						obj.setGoodsStore(store);
						this.generic_evaluate(store, mv);
						mv.addObject("store", store);
						String fullName = "";
						if (store.getAreaId() != null) {
							fullName = areaService.fullName(store.getAreaId());
						}
						mv.addObject("fullName", fullName);
					}

					List<GoodsBO> sameClassGoods = null;
					// 查询同类产品云购币页面 和 普通页面
					if (null != obj.getIsYgb() && obj.getIsYgb() == 1) {
						GoodsVO vo = new GoodsVO();
						vo.setIsYgb(1);
						sameClassGoods = this.goodsService.findGoodsByVoAndLimit(vo, 0, 5);
					} else {
						sameClassGoods = goodsService.selectSameClassGoodsList(obj.getGcId(), obj.getId(), 0,
								5);
					}
					mv.addObject("sameClassGoods", sameClassGoods);

					// 查詢评价第一页信息
					MyPage<EvaluateBO> page = new MyPage<EvaluateBO>();
					page.setPageSize(10);
					EvaluateVO vo = new EvaluateVO();
					vo.setEvaluateGoodsId(CommUtil.null2Long(id));
					vo.setEvaluateType("goods");
					vo.setEvaluateStatus(0);
					evaluateService.queryEvaluateListByVO(vo, page);

					String url = CommUtil.getURL(request) + "/goods_evaluation.htm";
					mv.addObject("eva_objs", page.getResult());
					mv.addObject("evaObjsTotal", page.getTotalElements());
					mv.addObject(
							"eva_gotoPageAjaxHTML",
							CommUtil.showPageAjaxHtml(url, "&evaluateGoodsId="+CommUtil.null2Long(id)+"&evaluateType="+"goods"+"&evaluateStatus="+0, page.getCurrentPage(), page.getPages(),
									page.getPageSize(), page.getRowCount()));
					mv.addObject("evaluateViewTools", this.evaluateViewTools);
					mv.addObject("orderFormTools", this.orderFormTools);

					goodsReceiptListView(request, id, null, mv);
//					// 查询成交记录第一页
//					MyPage<GoodsReceiptBO> goodsReceiptPage = new MyPage<GoodsReceiptBO>();
//					goodsReceiptPage.setPageSize(10);
//
//					goodsReceiptService.findGoodsReceiptList(goodsReceiptPage, CommUtil.null2Long(id));
//
//					url = CommUtil.getURL(request) + "/goods_order.htm";
//					mv.addObject("order_objs", goodsReceiptPage.getResult());
//					mv.addObject("order_gotoPageAjaxHTML",
//							CommUtil.showPageAjaxHtml(url, "", goodsReceiptPage.getCurrentPage(),
//									goodsReceiptPage.getPages(), goodsReceiptPage.getPageSize(),
//									goodsReceiptPage.getRowCount()));

					// 查询商品咨询第一页
					MyPage<ConsultBO> pageConsult = new MyPage<ConsultBO>();
					pageConsult.setPageSize(10);
					ConsultVO voConsult = new ConsultVO();
					voConsult.setGoodsId(CommUtil.null2Long(id));
					this.consultService.selectConsultListByVO(voConsult, pageConsult);;
					url = CommUtil.getURL(request) + "/goods_consult.htm";
					mv.addObject("consult_objs", pageConsult.getResult());
					mv.addObject(
							"consult_gotoPageAjaxHTML",
							CommUtil.showPageAjaxHtml(url, "", pageConsult.getCurrentPage(),
									pageConsult.getPages(), pageConsult.getPageSize(),
									pageConsult.getRowCount()));
					mv.addObject("consultViewTools", this.consultViewTools);

					mv.addObject("goodsClassNav", makeNav(obj.getGcId()));

				} else {
					mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
					mv.addObject("op_title", "对不起，您要找的物品已下架！");
					mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
				}
			}
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "对不起，您查看得商品不存在！");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
			return mv;
		}
		ZeroGoods zeroGoods = this.zeroGoodsService.getByGoodsId(CommUtil.null2Long(id));
		if (null != zeroGoods && zeroGoods.getGoodsStatus()) {
			mv.addObject("zeroFlag", 1);
		}
		return mv;
	}

	private List<GoodsClassBO> makeNav(Long goodsClassId) {
		List<GoodsClassBO> result = Lists.newArrayList();
		GoodsClassBO gc = this.dicContent.getTreeDic(GoodsClassBO.class, String.valueOf(goodsClassId));
		makeNav(gc, result);
		Collections.reverse(result);
		result.add(gc);
		return result;
	}

	private void makeNav(GoodsClassBO gc, List<GoodsClassBO> list) {
		if (null != gc && gc.getParent() != null) {
			list.add(gc.getParent());
			makeNav(gc.getParent(), list);
		}
	}

	private void addGoodsCookie(HttpServletRequest request, HttpServletResponse response, String id) {
		// System.out.println("未开启二级域名");
		// 利用cookie添加浏览过的商品
		Cookie[] cookies = request.getCookies();
		Cookie goodscookie = null;
		int k = 0;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("goodscookie")) {
					String goods_ids = cookie.getValue();
					int m = 6;
					int n = goods_ids.split(",").length;
					if (m > n) {
						m = n + 1;
					}
					String[] new_goods_ids = goods_ids.split(",", m);
					for (int i = 0; i < new_goods_ids.length; i++) {
						if ("".equals(new_goods_ids[i])) {
							for (int j = i + 1; j < new_goods_ids.length; j++) {
								new_goods_ids[i] = new_goods_ids[j];
							}
						}
					}
					String[] new_ids = new String[6];
					for (int i = 0; i < m - 1; i++) {
						if (id.equals(new_goods_ids[i])) {
							k++;
						}
					}
					if (k == 0) {
						new_ids[0] = id;
						for (int j = 1; j < m; j++) {
							new_ids[j] = new_goods_ids[j - 1];
						}
						goods_ids = id + ",";
						if (m == 2) {
							for (int i = 1; i <= m - 1; i++) {
								goods_ids = goods_ids + new_ids[i] + ",";
							}
						} else {
							for (int i = 1; i < m; i++) {
								goods_ids = goods_ids + new_ids[i] + ",";
							}
						}
						goodscookie = new Cookie("goodscookie", goods_ids);
					} else {
						new_ids = new_goods_ids;
						goods_ids = "";
						for (int i = 0; i < m - 1; i++) {
							goods_ids += new_ids[i] + ",";
						}
						goodscookie = new Cookie("goodscookie", goods_ids);
					}
					goodscookie.setMaxAge(60 * 60 * 24 * 7);
					goodscookie.setDomain(CommUtil.generic_domain(request));
					response.addCookie(goodscookie);
					break;
				} else {
					goodscookie = new Cookie("goodscookie", id + ",");
					goodscookie.setMaxAge(60 * 60 * 24 * 7);
					goodscookie.setDomain(CommUtil.generic_domain(request));
					response.addCookie(goodscookie);
				}
			}
		} else {
			goodscookie = new Cookie("goodscookie", id + ",");
			goodscookie.setMaxAge(60 * 60 * 24 * 7);
			goodscookie.setDomain(CommUtil.generic_domain(request));
			response.addCookie(goodscookie);
		}
	}

	public String clickfrom_to_chinese(String key) {
		String str = "其它";
		if (key.equals("search")) {
			str = "搜索";
		}
		if (key.equals("floor")) {
			str = "首页楼层";
		}
		if (key.equals("gcase")) {
			str = "橱窗";
		}

		return str;
	}

	/**
	 * 根据商城分类查看商品列表
	 * 
	 * @param request
	 * @param response
	 * @param gc_id
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @return
	 */
	@RequestMapping("/store_goods_list.htm")
	public ModelAndView store_goods_list(HttpServletRequest request, HttpServletResponse response,
			GoodsVO vo, MyPage<GoodsBO> page, String gc_id, String brand_ids, String gs_ids,
			String all_property_status, String detail_property_status, String ex_price_flag) {
		ModelAndView mv = new JModelAndView("store_goods_list.html", configService.getSysConfig(), 1,
				request, response);
		vo.setIsYgb(0);// 非云购币专区产品
		vo.setBrandIds(brand_ids);
		vo.setGsIdsStr(gs_ids);
		page.setPageSize(24);// 设定分页查询，每页24件商品
		Integer exPriceFlag = null;
		if (ex_price_flag != null && "cn".equals(ex_price_flag.trim()) && ex_price_flag.trim().length() > 0) {
			exPriceFlag = GoodsVO.EXPRICEFLAG_CN_PRODUCT;
			mv.addObject("exPriceFlag", true);
		}
		vo.setExPriceFlag(exPriceFlag);
		GoodsClassBO gc = goodsService.getFullGoodsClassByClassId(gc_id);
		List<GoodsClassBO> gc_list = goodsService.getRelationClassByGcId(gc);
		goodsService.queryGoodsByClass(vo, gc, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		List<Goods> list = page.getResult();
		for (Goods good : list) {
			System.out.println("" + good.getCnSelfAddPrice() + " " + good.getExPriceFlag());
			String goodsDetailsMobile = good.getGoodsDetailsMobile();
			if (goodsDetailsMobile != null && goodsDetailsMobile.length() >= 0) {

			}
		}
		if (SecurityUserHolder.getCurrentUser() != null) {
			Long uid = SecurityUserHolder.getCurrentUserId();
			/**
			 * 会员登陆后 检查是否为CN用户 CN用户 显示新增商品BV值 add by yuleijia 2017.2.20
			 */
			UserAccountBO account1 = new UserAccountBO();
			account1.setUid(uid);
			account1.setAccountType(UserContant.ACCOUNT_TYPE_8);
			UserAccountBO cnUserAccount = userAccountService.findAccountByVo(account1);
			boolean isCN = Boolean.FALSE;
			if (cnUserAccount != null) {
				isCN = Boolean.TRUE;
			}
			mv.addObject("isCN", isCN);
		}

		// 热卖推荐－－－查询当前分类的
		List<GoodsBO> hotGoods = goodsService.selectGoodsYourLike(null, null, 0, 8, null,
				vo.getGoodsClassIds());
		mv.addObject("hotGoods", hotGoods);
		mv.addObject("nearLooks",
				goodsService.queryNearLooks(SecurityUserHolder.getCurrentUser(), CommUtil.getURL(request)));
		mv.addObject("vo", vo);
		mv.addObject("gc", gc);
		mv.addObject("orderBy", vo.getOrderBy());
		mv.addObject("orderType", vo.getOrderType());
		mv.addObject("goods_property", vo.getGoodsProperty());
		mv.addObject("allCount", page.getRowCount());
		mv.addObject("goodsViewTools", goodsViewTools);
		mv.addObject("gc_list", gc_list);
		mv.addObject("gc", gc);
		mv.addObject("gs_ids", vo.getGsIdsStr());
		mv.addObject("properties", vo.getProperties());
		mv.addObject("brand_ids", vo.getBrandIds());

		mv.addObject("filter_properties", vo.getFilterProperties());
		return mv;
	}

	/**
	 * 底部根据流程猜你喜欢商品列表， 使用自定义标签$!httpInclude.include("/goods_list_bottom.htm") 完成页面引用,默认查询20条数据
	 */
	@RequestMapping("/goods_list_bottom.htm")
	public ModelAndView goods_list_bottom(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("goods_list_bottom.html", configService.getSysConfig(), 1,
				request, response);
		// 猜您喜欢 根据cookie商品的分类 销量查询 如果没有cookie则按销量查询
		List<GoodsBO> your_like_goods = new ArrayList<GoodsBO>();
		Long your_like_GoodsClass = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("goodscookie")) {
					String[] like_gcid = cookie.getValue().split(",", 2);
					Goods goods = this.goodsService.getObjById(CommUtil.null2Long(like_gcid[0]));
					if (goods == null)
						break;
					your_like_GoodsClass = goods.getGcId();
					your_like_goods = this.goodsService.selectGoodsYourLike(your_like_GoodsClass,
							goods.getId(), 0, 8, null, null);
					int gcs_size = your_like_goods.size();
					if (gcs_size < 20) {
						List<GoodsBO> like_goods = this.goodsService.selectGoodsYourLike(null, goods.getId(),
								0, 8 - gcs_size, null, null);
						for (int i = 0; i < like_goods.size(); i++) {
							// 去除重复商品
							int k = 0;
							for (int j = 0; j < your_like_goods.size(); j++) {
								if (like_goods.get(i).getId().equals(your_like_goods.get(j).getId())) {
									k++;
								}
							}
							if (k == 0) {
								your_like_goods.add(like_goods.get(i));
							}
						}
					}
					break;
				} else {
					your_like_goods = this.goodsService.selectGoodsYourLike(null, null, 0, 8, null, null);
				}
			}
		} else {
			your_like_goods = this.goodsService.selectGoodsYourLike(null, null, 0, -1, null, null);
		}
		Long uid = SecurityUserHolder.getCurrentUserId();
		if (uid != null) {
			boolean isCN = this.userAccountService.check_User_Is_CN(uid);
			mv.addObject("isCN", isCN);
		}
		mv.addObject("your_like_goods", your_like_goods);
		// List<GoodsBO> goods_last = new ArrayList<GoodsBO>();
		// Cookie[] cookies_last = request.getCookies();
		// Set<Long> ids = new HashSet<Long>();
		// if (cookies_last != null) {
		// for (Cookie co : cookies_last) {
		// if (co.getName().equals("goodscookie")) {
		// String[] goods_id = co.getValue().split(",");
		// int j = 4;
		// if (j > goods_id.length) {
		// j = goods_id.length;
		// }
		// for (int i = 0; i < j; i++) {
		// ids.add(CommUtil.null2Long(goods_id[i]));
		// }
		// }
		// }
		// }
		// if (!ids.isEmpty()) {
		// goods_last = this.goodsService.selectGoodsYourLike(null, null, 0, 20,
		// ids);
		// }
		// mv.addObject("goods_last", goods_last);
		return mv;
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param goods_id
	 * @param currentPage
	 * @return
	 */
	@RequestMapping("/goods_evaluation.htm")
	public ModelAndView goods_evaluation(HttpServletRequest request, HttpServletResponse response,
			EvaluateVO vo, MyPage<EvaluateBO> page) {
		ModelAndView mv = new JModelAndView("default/goods_evaluation.html", configService.getSysConfig(), 1,
				request, response);
		page.setPageSize(10);
		if (vo.getId() != null) {
			vo.setEvaluateGoodsId(vo.getId());
		}
		vo.setEvaluateType("goods");
		vo.setEvaluateStatus(0);
		if (!CommUtil.null2String(vo.getGoodsEva()).equals("")) {
			if (vo.getGoodsEva().equals("100")) {
				vo.setEvaluatePhotos("");
			} else {
				vo.setEvaluateBuyerVal(CommUtil.null2Int(vo.getGoodsEva()));
			}
		}
		evaluateService.queryEvaluateListByVO(vo, page);

		String url = CommUtil.getURL(request) + "/goods_evaluation.htm";
		mv.addObject("eva_objs", page.getResult());
		mv.addObject("eva_gotoPageAjaxHTML", CommUtil.showPageAjaxHtml(url, "&evaluateGoodsId="+CommUtil.null2Long(vo.getEvaluateGoodsId())+"&evaluateType="+"goods"+"&evaluateStatus="+0, page.getCurrentPage(),
				page.getPages(), page.getPageSize(), page.getRowCount()));
		mv.addObject("evaluateViewTools", this.evaluateViewTools);
		mv.addObject("orderFormTools", this.orderFormTools);
		mv.addObject("vo", vo);
		return mv;
	}

	@RequestMapping("/goods_detail.htm")
	public ModelAndView goods_detail(HttpServletRequest request, HttpServletResponse response, String goods_id) {
		ModelAndView mv = new JModelAndView("default/goods_detail.html", configService.getSysConfig(), 1,
				request, response);
		Goods goods = this.goodsService.getObjById(CommUtil.null2Long(goods_id));
		mv.addObject("obj", goods);
		return mv;
	}

	@RequestMapping("/goods_order.htm")
	public ModelAndView goods_order(HttpServletRequest request, HttpServletResponse response,
			String goods_id, MyPage<GoodsReceiptBO> page) {
		ModelAndView mv = new JModelAndView("default/goods_order.html", configService.getSysConfig(), 1,
				request, response);

		goodsReceiptListView(request, goods_id, page, mv);

		//
		// // 查询成交记录第一页
		// page.setPageSize(10);
		// EvaluateVO orderEvaVo = new EvaluateVO();
		// orderEvaVo.setEvaluateGoodsId(CommUtil.null2Long(goods_id));
		// orderEvaVo.setEvaluateType("goods");
		// evaluateService.queryEvaluateListByVO(orderEvaVo, page);

		// String url = CommUtil.getURL(request) + "/goods_order.htm";
		// mv.addObject("order_objs", page.getResult());
		// mv.addObject("order_gotoPageAjaxHTML", CommUtil.showPageAjaxHtml(url,
		// "", page.getCurrentPage(), page.getPages(),page.getPageSize(),
		// page.getRowCount()));
		return mv;
	}

	private void goodsReceiptListView(HttpServletRequest request, String goods_id,
			MyPage<GoodsReceiptBO> page, ModelAndView mv) {
		if (page == null) {
			page = new MyPage<GoodsReceiptBO>();
		}
		// 查询成交记录第一页
		page.setPageSize(10);
		goodsReceiptService.findGoodsReceiptList(page, CommUtil.null2Long(goods_id));

		List<GoodsReceiptBO> list = page.getResult();
		// 昵称显示处理；
		for (GoodsReceiptBO item : list) {
			item.setBuyerName(orderFormTools.dealNickNameDisplay(item.getBuyerName()));
		}
		String url = CommUtil.getURL(request) + "/goods_order.htm";
		mv.addObject("order_objs", list);
		mv.addObject("order_gotoPageAjaxHTML", CommUtil.showPageAjaxHtml(url, "", page.getCurrentPage(),
				page.getPages(), page.getPageSize(), page.getRowCount()));
	}

	@RequestMapping("/goods_consult.htm")
	public ModelAndView goods_consult(HttpServletRequest request, HttpServletResponse response,
			String goods_id, String consult_type, MyPage<ConsultBO> pageConsult) {
		ModelAndView mv = new JModelAndView("default/goods_consult.html", configService.getSysConfig(), 1,
				request, response);

		pageConsult.setPageSize(10);
		ConsultVO voConsult = new ConsultVO();
		voConsult.setGoodsId(CommUtil.null2Long(goods_id));
		if (!CommUtil.null2String(consult_type).equals("")) {
			voConsult.setConsultType(consult_type);
		}
		this.consultService.selectConsultListByVO(voConsult, pageConsult);
		String url2 = CommUtil.getURL(request) + "/goods_consult.htm";
		mv.addObject("consult_objs", pageConsult.getResult());
		mv.addObject("consult_gotoPageAjaxHTML", CommUtil.showPageAjaxHtml(url2, "",
				pageConsult.getCurrentPage(), pageConsult.getPages(), pageConsult.getPageSize(),
				pageConsult.getRowCount()));

		mv.addObject("goods_id", goods_id);
		mv.addObject("consultViewTools", this.consultViewTools);
		mv.addObject("consult_type", CommUtil.null2String(consult_type));
		return mv;
	}

	@RequestMapping("/load_goods_gsp.htm")
	public void load_goods_gsp(HttpServletRequest request, HttpServletResponse response, String gsp, String id) {
		Goods goods = this.goodsService.getObjById(CommUtil.null2Long(id));
		Map<String, Object> map = new HashMap<>();
		int count = 0;
		double price = 0;
		double act_price = 0;
		double needYgb = 0;
		double selfAddPrice = 0;
		double needMoney = 0;
		double cnSelfAddPrice = 0;
		count = goods.getGoodsInventory();
		price = CommUtil.null2Double(goods.getStorePrice());
		if (goods.getInventoryType().equals("spec")) {
			List<HashMap> list = Json.fromJson(ArrayList.class, goods.getGoodsInventoryDetail());
			String[] gsp_ids = gsp.split(",");
			for (Map temp : list) {
				String[] temp_ids = CommUtil.null2String(temp.get("id")).split("_");
				Arrays.sort(gsp_ids);
				Arrays.sort(temp_ids);
				if (Arrays.equals(gsp_ids, temp_ids)) {
					count = CommUtil.null2Int(temp.get("count"));
					price = CommUtil.null2Double(temp.get("price"));
					needYgb = CommUtil.null2Double(temp.get("needYgb"));
					needMoney = CommUtil.null2Double(temp.get("needMoney"));
					selfAddPrice = CommUtil.null2Double(temp.get("selfAddPrice"));
					cnSelfAddPrice = CommUtil.null2Double(temp.get("cnSelfAddPrice"));
					double mobilePrice = CommUtil.null2Double(temp.get("mobilePrice"));
					if (mobilePrice > 0)
						map.put("mobilePrice", CommUtil.formatMoney(mobilePrice));
					double integralPrice = CommUtil.null2Double(temp.get("integralPrice"));
					if (integralPrice > 0)
						map.put("integralPrice", CommUtil.formatMoney(integralPrice));
					int integralCount = CommUtil.null2Int(temp.get("integralCount"));
					if (integralCount > 0)
						map.put("integralCount", integralCount);
				}
			}
		}
		map.put("count", count);
		map.put("price", CommUtil.formatMoney(price));
		map.put("needYgb", needYgb);
		map.put("needMoney", needMoney);
		map.put("selfAddPrice", selfAddPrice);
		map.put("cnSelfAddPrice", cnSelfAddPrice);
		if (act_price != 0) {
			map.put("act_price", CommUtil.formatMoney(act_price));
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(map, JsonFormat.compact()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/trans_fee.htm")
	public void trans_fee(HttpServletRequest request, HttpServletResponse response, String city_name,
			String goods_id) {
		Map map = new HashMap();
		GoodsBO goods = this.goodsService.getGoodsBOById(CommUtil.null2Long(goods_id));
		float mail_fee = 0;
		float express_fee = 0;
		float ems_fee = 0;
		if (goods != null && goods.getTransport() != null) {
			mail_fee = this.transportTools.cal_goods_trans_fee(CommUtil.null2String(goods.getTransportId()),
					"mail", CommUtil.null2String(goods.getGoodsWeight()),
					CommUtil.null2String(goods.getGoodsVolume()), city_name);
			express_fee = this.transportTools.cal_goods_trans_fee(
					CommUtil.null2String(goods.getTransportId()), "express",
					CommUtil.null2String(goods.getGoodsWeight()),
					CommUtil.null2String(goods.getGoodsVolume()), city_name);
			ems_fee = this.transportTools.cal_goods_trans_fee(CommUtil.null2String(goods.getTransportId()),
					"ems", CommUtil.null2String(goods.getGoodsWeight()),
					CommUtil.null2String(goods.getGoodsVolume()), city_name);
		}
		map.put("mail_fee", mail_fee);
		map.put("express_fee", express_fee);
		map.put("ems_fee", ems_fee);
		map.put("current_city_info", CommUtil.substring(city_name, 5));
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			// System.out.println(Json.toJson(map, JsonFormat.compact()));
			writer.print(Json.toJson(map, JsonFormat.compact()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/goods_share.htm")
	public ModelAndView goods_share(HttpServletRequest request, HttpServletResponse response, String goods_id) {
		ModelAndView mv = new JModelAndView("goods_share.html", configService.getSysConfig(), 1, request,
				response);
		Goods goods = this.goodsService.getObjById(CommUtil.null2Long(goods_id));
		mv.addObject("obj", goods);
		return mv;
	}

	private Set<Long> genericIds(Long id) {
		Set<Long> ids = new HashSet<Long>();
		if (id != null) {
			ids.add(id);
			List<DicBase> dicList = dicContent.getDicsByParentCode(GoodsClassBO.class, String.valueOf(id));
			if (CollectionUtils.isNotEmpty(dicList)) {
				for (DicBase dicBase : dicList) {
					ids.add(Long.parseLong(dicBase.getCode()));
				}
			}

			for (int i = 0; i < dicList.size(); i++) {
				Long cid = CommUtil.null2Long(dicList.get(i).getCode());
				Set<Long> cids = genericIds(cid);
				ids.addAll(cids);
			}
		}
		return ids;
	}

	@RequestMapping("/goods_consult_win.htm")
	public ModelAndView goods_consult_win(HttpServletRequest request, HttpServletResponse response,
			String goods_id) {
		ModelAndView mv = new JModelAndView("default/goods_consult_win.html", configService.getSysConfig(),
				1, request, response);
		mv.addObject("goods_id", goods_id);
		mv.addObject("time", CommUtil.formatLongDate(new Date()));
		return mv;
	}

	/**
	 * 商品咨询
	 * 
	 * @param request
	 * @param response
	 * @param goods_id
	 * @param consult_content
	 * @param consult_type
	 * @param consult_code
	 * @return
	 */
	@RequestMapping("/buyer/goods_consult_save.htm")
	public ModelAndView goods_consult_save(HttpServletRequest request, HttpServletResponse response,
			String goods_id, String consult_content, String consult_type, String consult_code) {
		String verify_code = CommUtil.null2String(request.getSession(false).getAttribute("verify_code"));
		request.getSession(false).removeAttribute("verify_code");
		boolean visit_consult = true;
		if (!this.configService.getSysConfig().getVisitorConsult()) {
			if (SecurityUserHolder.getCurrentUser() == null) {
				visit_consult = false;
			}
		}
		if (visit_consult) {
			if (CommUtil.null2String(consult_code).equals(verify_code)) {
				Consult obj = new Consult();
				obj.setReply(false);
				GoodsBO goods = this.goodsService.getFullGoodsById(CommUtil.null2Long(goods_id));
				obj.setAddTime(new Date());
				obj.setConsultType(consult_type);
				obj.setConsultContent(consult_content);
				User user = SecurityUserHolder.getCurrentUser();
				if (user != null) {
					UserCustomerBO userCustomerBO = userCustomerService.findSessionUser(user.getId());
					obj.setConsultUserId(user.getId());
					obj.setConsultUserName(userCustomerBO.getNickname());
					obj.setConsultEmail(userCustomerBO.getEmail());
				} else {
					obj.setConsultUserName("游客");
				}
				List<Map<String, String>> maps = new ArrayList<Map<String, String>>();
				Map<String, String> map = new HashMap<String, String>();
				map.put("goods_id", CommUtil.null2String(goods.getId()));
				map.put("goods_name", goods.getGoodsName());
				map.put("goods_main_photo", goods.getGoodsMainPhotoPath());
				map.put("goods_price", CommUtil.null2String(goods.getGoodsCurrentPrice()));
				String goods_domainPath = CommUtil.getURL(request) + "/goods_" + goods.getId() + ".htm";
				if (this.configService.getSysConfig().getSecondDomainOpen() && goods.getGoodsStore() != null
						&& goods.getGoodsStore().getStoreSecondDomain() != "" && goods.getGoodsType() == 1) {
					String store_second_domain = "http://" + goods.getGoodsStore().getStoreSecondDomain()
							+ "." + CommUtil.generic_domain(request);
					goods_domainPath = store_second_domain + "/goods_" + goods.getId() + ".htm";
				}
				map.put("goods_domainPath", goods_domainPath);// 商品二级域名路径
				maps.add(map);
				obj.setGoodsInfo(Json.toJson(maps, JsonFormat.compact()));
				obj.setGoodsId(goods.getId());
				if (goods.getGoodsStoreId() == null || goods.getGoodsType() == 0) {
					obj.setWhetherSelf(1);
				} else {
					obj.setStoreId(goods.getGoodsStoreId());
					obj.setStoreName(goods.getGoodsStore().getStoreName());
				}
				consultService.save(obj);
				request.getSession(false).removeAttribute("consult_code");
			}
		}
		ModelAndView mv = new JModelAndView("default/goods_consult.html", configService.getSysConfig(), 1,
				request, response);

		MyPage<ConsultBO> pageConsult = new MyPage<ConsultBO>();
		pageConsult.setPageSize(10);
		ConsultVO voConsult = new ConsultVO();
		voConsult.setGoodsId(CommUtil.null2Long(goods_id));
		if (!CommUtil.null2String(consult_type).equals("")) {
			voConsult.setConsultType(consult_type);
		}
		consultService.selectConsultListByVO(voConsult, pageConsult);

		String url2 = CommUtil.getURL(request) + "/goods_consult.htm";
		mv.addObject("consult_objs", pageConsult.getResult());
		mv.addObject("consult_gotoPageAjaxHTML", CommUtil.showPageAjaxHtml(url2, "",
				pageConsult.getCurrentPage(), pageConsult.getPages(), pageConsult.getPageSize(),
				pageConsult.getRowCount()));
		mv.addObject("goods_id", goods_id);
		mv.addObject("consultViewTools", this.consultViewTools);
		mv.addObject("consult_type", CommUtil.null2String(consult_type));

		return mv;
	}

	/**
	 * 用户对某条咨询点击满意
	 * 
	 * @param request
	 * @param response
	 * @param consult_id
	 */
	@RequestMapping("/goods_consult_satisfy.htm")
	public void goods_consult_satisfy(HttpServletRequest request, HttpServletResponse response,
			String consult_id) {
		User user = SecurityUserHolder.getCurrentUser();
		// Consult obj = this.consultService.getObjById(CommUtil
		// .null2Long(consult_id));
		// if (user != null) {// 如果用户不为空，则更加用户id检测是否已经进行满意度点评
		// Map params = new HashMap();
		// params.put("user_id", user.getId());
		// params.put("cs_consult_id", CommUtil.null2Long(consult_id));
		// List<ConsultSatis> css = this.consultsatisService
		// .query("select obj from ConsultSatis obj where
		// obj.cs_user_id=:user_id and obj.cs_consult_id=:cs_consult_id",
		// params, -1, -1);
		// if (css.size() == 0) {
		// ConsultSatis cs = new ConsultSatis();
		// cs.setAddTime(new Date());
		// cs.setCs_consult_id(CommUtil.null2Long(consult_id));
		// cs.setCs_ip(CommUtil.getIpAddr(request));
		// cs.setCs_type(0);
		// cs.setCs_user_id(user.getId());
		// this.consultsatisService.save(cs);
		// //
		// obj.setSatisfy(obj.getSatisfy() + 1);
		// this.consultService.update(obj);
		// }
		// } else {// 用户为空则根据ip检测，如果该ip已经进行点评则不可以进行操作
		// Map params = new HashMap();
		// params.put("cs_ip", CommUtil.getIpAddr(request));
		// params.put("cs_consult_id", CommUtil.null2Long(consult_id));
		// List<ConsultSatis> css = this.consultsatisService
		// .query("select obj from ConsultSatis obj where obj.cs_ip=:cs_ip and
		// obj.cs_consult_id=:cs_consult_id",
		// params, -1, -1);
		// if (css.size() == 0) {
		// ConsultSatis cs = new ConsultSatis();
		// cs.setAddTime(new Date());
		// cs.setCs_consult_id(CommUtil.null2Long(consult_id));
		// cs.setCs_ip(CommUtil.getIpAddr(request));
		// cs.setCs_type(0);
		// this.consultsatisService.save(cs);
		// //
		// obj.setSatisfy(obj.getSatisfy() + 1);
		// this.consultService.update(obj);
		// }
		// }
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			// writer.print(obj.getSatisfy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 用户对某条评论点不满意
	 * 
	 * @param request
	 * @param response
	 * @param consult_id
	 */
	@RequestMapping("/goods_consult_unsatisfy.htm")
	public void goods_consult_unsatisfy(HttpServletRequest request, HttpServletResponse response,
			String consult_id) {
		User user = SecurityUserHolder.getCurrentUser();
		// Consult obj = this.consultService.getObjById(CommUtil
		// .null2Long(consult_id));
		// if (user != null) {// 如果用户不为空，则更加用户id检测是否已经进行满意度点评
		// Map params = new HashMap();
		// params.put("user_id", user.getId());
		// params.put("cs_consult_id", CommUtil.null2Long(consult_id));
		// List<ConsultSatis> css = this.consultsatisService
		// .query("select obj from ConsultSatis obj where
		// obj.cs_user_id=:user_id and obj.cs_consult_id=:cs_consult_id",
		// params, -1, -1);
		// if (css.size() == 0) {
		// ConsultSatis cs = new ConsultSatis();
		// cs.setAddTime(new Date());
		// cs.setCs_consult_id(CommUtil.null2Long(consult_id));
		// cs.setCs_ip(CommUtil.getIpAddr(request));
		// cs.setCs_type(-1);
		// cs.setCs_user_id(user.getId());
		// this.consultsatisService.save(cs);
		// //
		// obj.setUnsatisfy(obj.getUnsatisfy() + 1);
		// this.consultService.update(obj);
		// }
		// } else {// 用户为空则根据ip检测，如果该ip已经进行点评则不可以进行操作
		// Map params = new HashMap();
		// params.put("cs_ip", CommUtil.getIpAddr(request));
		// params.put("cs_consult_id", CommUtil.null2Long(consult_id));
		// List<ConsultSatis> css = this.consultsatisService
		// .query("select obj from ConsultSatis obj where obj.cs_ip=:cs_ip and
		// obj.cs_consult_id=:cs_consult_id",
		// params, -1, -1);
		// if (css.size() == 0) {
		// ConsultSatis cs = new ConsultSatis();
		// cs.setAddTime(new Date());
		// cs.setCs_consult_id(CommUtil.null2Long(consult_id));
		// cs.setCs_ip(CommUtil.getIpAddr(request));
		// cs.setCs_type(-1);
		// this.consultsatisService.save(cs);
		// //
		// obj.setUnsatisfy(obj.getUnsatisfy() + 1);
		// this.consultService.update(obj);
		// }
		// }
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			// writer.print(obj.getUnsatisfy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 加载店铺评分信息
	 * 
	 * @param store
	 * @param mv
	 */
	private void generic_evaluate(StoreBO store, ModelAndView mv) {
		double description_result = 0;
		double service_result = 0;
		double ship_result = 0;
		GoodsClass gc = this.goodsClassService.getObjById(store.getGcMainId());
		if (store != null && gc != null && store.getPoint() != null) {
			float description_evaluate = CommUtil.null2Float(gc.getDescriptionEvaluate());
			float service_evaluate = CommUtil.null2Float(gc.getServiceEvaluate());
			float ship_evaluate = CommUtil.null2Float(gc.getShipEvaluate());

			float store_description_evaluate = CommUtil.null2Float(store.getPoint().getDescriptionEvaluate());
			float store_service_evaluate = CommUtil.null2Float(store.getPoint().getServiceEvaluate());
			float store_ship_evaluate = CommUtil.null2Float(store.getPoint().getShipEvaluate());
			// 计算和同行比较结果
			description_result = CommUtil.div(store_description_evaluate - description_evaluate,
					description_evaluate);
			service_result = CommUtil.div(store_service_evaluate - service_evaluate, service_evaluate);
			ship_result = CommUtil.div(store_ship_evaluate - ship_evaluate, ship_evaluate);
		}
		if (description_result > 0) {
			mv.addObject("description_css", "value_strong");
			mv.addObject(
					"description_result",
					CommUtil.null2String(CommUtil.mul(description_result, 100) > 100 ? 100 : CommUtil.mul(
							description_result, 100)) + "%");
		}
		if (description_result == 0) {
			mv.addObject("description_css", "value_normal");
			mv.addObject("description_result", "-----");
		}
		if (description_result < 0) {
			mv.addObject("description_css", "value_light");
			mv.addObject("description_result", CommUtil.null2String(CommUtil.mul(-description_result, 100))
					+ "%");
		}
		if (service_result > 0) {
			mv.addObject("service_css", "value_strong");
			mv.addObject(
					"service_result",
					CommUtil.null2String(CommUtil.mul(service_result, 100) > 100 ? 100 : CommUtil.mul(
							service_result, 100)) + "%");
		}
		if (service_result == 0) {
			mv.addObject("service_css", "value_normal");
			mv.addObject("service_result", "-----");
		}
		if (service_result < 0) {
			mv.addObject("service_css", "value_light");
			mv.addObject("service_result", CommUtil.null2String(CommUtil.mul(-service_result, 100)) + "%");
		}
		if (ship_result > 0) {
			mv.addObject("ship_css", "value_strong");
			mv.addObject(
					"ship_result",
					CommUtil.null2String(CommUtil.mul(ship_result, 100) > 100 ? 100 : CommUtil.mul(
							ship_result, 100)) + "%");
		}
		if (ship_result == 0) {
			mv.addObject("ship_css", "value_normal");
			mv.addObject("ship_result", "-----");
		}
		if (ship_result < 0) {
			mv.addObject("ship_css", "value_light");
			mv.addObject("ship_result", CommUtil.null2String(CommUtil.mul(-ship_result, 100)) + "%");
		}
	}

	/**
	 * 打开商品对比页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/goods_compare.htm")
	public ModelAndView goods_compare(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("goods_compare.html", configService.getSysConfig(), 1, request,
				response);
		List<Goods> goods_compare_cart = (List<Goods>) request.getSession()
				.getAttribute("goods_compare_cart");
		// List<GoodsCompareView> goods_compare_list = new
		// ArrayList<GoodsCompareView>();
		// if (goods_compare_cart != null && goods_compare_cart.size() > 0) {
		// Goods goods = goods_compare_cart.get(goods_compare_cart.size() - 1);
		// goods = this.goodsService.getObjById(goods.getId());
		// GoodsClass gc = goods.getGc();
		// if (goods.getGc().getParent() != null) {
		// gc = goods.getGc().getParent();
		// }
		// if (goods.getGc().getParent() != null
		// && goods.getGc().getParent().getParent() != null) {
		// gc = goods.getGc().getParent().getParent();
		// }
		// mv.addObject("gc", gc);
		// // 20150227add 当商品类型没有添加时屏蔽此处
		// List<GoodsTypeProperty> gtps = null;
		// if (gc.getGoodsType() != null) {
		// gtps = gc.getGoodsType().getProperties();
		// }
		// mv.addObject("gtps", gtps);
		// for (Goods obj : goods_compare_cart) {
		// obj = this.goodsService.getObjById(obj.getId());
		// GoodsCompareView gcv = new GoodsCompareView();
		// gcv.setBad_evaluate(CommUtil.mul(obj.getBad_evaluate(), 100)
		// + "%");
		// gcv.setGoods_brand(obj.getGoods_brand() != null ? obj
		// .getGoods_brand().getName() : "-----");
		// gcv.setGoods_cod(obj.getGoods_cod() == 0 ? "支持" : "不支持");
		// gcv.setGoods_id(obj.getId());
		// gcv.setGoods_img(this.generic_goods_img(request, obj));
		// gcv.setGoods_name(obj.getGoods_name());
		// gcv.setGoods_price(obj.getGoods_current_price());
		// gcv.setGoods_url(this.generic_goods_url(request, obj));
		// gcv.setGoods_weight(obj.getGoods_weight());
		// gcv.setMiddle_evaluate(CommUtil.mul(obj.getMiddle_evaluate(),
		// 100) + "%");
		// gcv.setTax_invoice(obj.getTax_invoice() == 0 ? "不支持" : "支持");
		// gcv.setWell_evaluate(CommUtil.mul(obj.getWell_evaluate(), 100)
		// + "%");
		// if (gtps != null) {
		// List<Map> list = Json.fromJson(List.class,
		// obj.getGoods_property());
		// Map gcv_props = new HashMap();
		// for (GoodsTypeProperty gtp : gtps) {
		// for (Map map : list) {
		// if (CommUtil.null2Long(map.get("id")).equals(
		// gtp.getId())) {
		// if (!CommUtil.null2String(map.get("val"))
		// .equals("")) {
		// gcv_props
		// .put(gtp.getName(), map.get("val"));
		// } else {
		// gcv_props.put(gtp.getName(), "-----");
		// }
		// }
		// }
		// }
		// gcv.setProps(gcv_props);
		// }
		// goods_compare_list.add(gcv);
		// }
		//
		// }
		// mv.addObject("goods_compare_list", goods_compare_list);
		return mv;
	}

	/**
	 * 生成商品主图片路径
	 * 
	 * @param obj
	 * @return
	 */
	private String generic_goods_img(HttpServletRequest request, Goods obj) {
		String img = "";
		// if (obj.getGoods_main_photo() != null) {
		// img = CommUtil.getURL(request) + "/"
		// + obj.getGoods_main_photo().getPath() + "/"
		// + obj.getGoods_main_photo().getName() + "_middle."
		// + obj.getGoods_main_photo().getExt();
		// } else {
		// img = CommUtil.getURL(request)
		// + "/"
		// + this.configService.getSysConfig().getGoodsImage()
		// .getPath()
		// + "/"
		// + this.configService.getSysConfig().getGoodsImage()
		// .getName();
		// }
		return img;
	}

	/**
	 * 生成商品url
	 * 
	 * @param request
	 * @param obj
	 * @return
	 */
	private String generic_goods_url(HttpServletRequest request, Goods obj) {
		String url = CommUtil.getURL(request) + "/goods_" + obj.getId() + ".htm";
		// if (this.configService.getSysConfig().isSecond_domain_open()
		// && obj.getGoods_type() == 1
		// && !CommUtil.null2String(
		// obj.getGoods_store().getStore_second_domain()).equals(
		// "")) {
		// url = "http://" + obj.getGoods_store().getStore_second_domain()
		// + "." + CommUtil.generic_domain(request) + "/" + "/goods_"
		// + obj.getId() + ".htm";
		// }
		return url;
	}

	/**
	 * 添加商品到对比栏
	 * 
	 * @param request
	 * @param response
	 * @param goods_id
	 * @return
	 */
	@RequestMapping("/add_goods_compare_cart.htm")
	public ModelAndView add_goods_compare_cart(HttpServletRequest request, HttpServletResponse response,
			String goods_id) {
		ModelAndView mv = new JModelAndView("goods_compare_cart_info.html", configService.getSysConfig(), 1,
				request, response);
		List<Goods> goods_compare_cart = (List<Goods>) request.getSession()
				.getAttribute("goods_compare_cart");
		if (goods_compare_cart == null) {
			goods_compare_cart = new ArrayList<Goods>();
		}
		if (goods_compare_cart.size() < 4) {
			Goods obj = this.goodsService.getObjById(CommUtil.null2Long(goods_id));
			boolean add = true;
			for (Goods goods : goods_compare_cart) {
				if (goods.getId().equals(obj.getId())) {
					add = false;
				}
			}
			if (add)
				goods_compare_cart.add(0, obj);
		}
		request.getSession(false).setAttribute("goods_compare_cart", goods_compare_cart);
		mv.addObject("objs", goods_compare_cart);
		return mv;
	}

	/**
	 * 从商品对比栏移除商品
	 * 
	 * @param request
	 * @param response
	 * @param goods_id
	 * @return
	 */
	@RequestMapping("/remove_goods_compare_cart.htm")
	public ModelAndView remove_goods_compare_cart(HttpServletRequest request, HttpServletResponse response,
			String goods_id) {
		ModelAndView mv = new JModelAndView("goods_compare_cart_info.html", configService.getSysConfig(), 1,
				request, response);
		List<Goods> goods_compare_cart = (List<Goods>) request.getSession()
				.getAttribute("goods_compare_cart");
		Goods obj = this.goodsService.getObjById(CommUtil.null2Long(goods_id));
		for (int i = 0; i < goods_compare_cart.size(); i++) {
			if (goods_compare_cart.get(i).getId().equals(obj.getId())) {
				goods_compare_cart.remove(i);
				break;
			}
		}
		request.getSession(false).setAttribute("goods_compare_cart", goods_compare_cart);
		mv.addObject("objs", goods_compare_cart);
		return mv;
	}

	/**
	 * 清空商品对比栏数据
	 * 
	 * @param request
	 * @param response
	 * @param goods_id
	 * @return
	 */
	@RequestMapping("/remove_all_goods_compare_cart.htm")
	public ModelAndView remove_all_goods_compare_cart(HttpServletRequest request, HttpServletResponse response) {
		List<Goods> goods_compare_cart = (List<Goods>) request.getSession()
				.getAttribute("goods_compare_cart");
		goods_compare_cart.clear();
		request.getSession(false).removeAttribute("goods_compare_cart");
		ModelAndView mv = new JModelAndView("goods_compare_cart_info.html", configService.getSysConfig(), 1,
				request, response);
		mv.addObject("objs", goods_compare_cart);
		return mv;
	}

	/**
	 * 在对比页删除某件商品
	 * 
	 * @param request
	 * @param response
	 * @param goods_id
	 * @return
	 */
	@RequestMapping("/remove_goods_compart.htm")
	public String remove_goods_compart(HttpServletRequest request, HttpServletResponse response,
			String goods_id) {
		List<Goods> goods_compare_cart = (List<Goods>) request.getSession()
				.getAttribute("goods_compare_cart");
		Goods obj = this.goodsService.getObjById(CommUtil.null2Long(goods_id));
		for (int i = 0; i < goods_compare_cart.size(); i++) {
			if (goods_compare_cart.get(i).getId().equals(obj.getId())) {
				goods_compare_cart.remove(i);
				break;
			}
		}
		request.getSession(false).setAttribute("goods_compare_cart", goods_compare_cart);
		return "redirect:goods_compare.htm";
	}

	/**
	 * 根据云购专区分类查看商品列表
	 * 
	 * @param request
	 * @param response
	 * @param gc_id
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @return
	 */
	@RequestMapping("/store_goods_yg_list.htm")
	public ModelAndView store_goods_yg_list(HttpServletRequest request, HttpServletResponse response,
			GoodsVO vo, MyPage<GoodsBO> page, String gc_id, String brand_ids, String gs_ids,
			String all_property_status, String detail_property_status) {
		ModelAndView mv = new JModelAndView("store_yg_goods_list.html", configService.getSysConfig(), 1,
				request, response);
		vo.setIsYgb(1);// 云购币专区产品
		vo.setBrandIds(brand_ids);
		vo.setGsIdsStr(gs_ids);
		page.setPageSize(24);// 设定分页查询，每页24件商品
		GoodsYgClassBO gc = goodsService.getFullGoodsYgClassByClassId(gc_id);
		List<GoodsYgClassBO> gc_list = goodsService.getRelationYgClassByGcId(gc);
		goodsService.queryYgGoodsByClass(vo, gc, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);

		// 热卖推荐－－－查询当前分类的
		/*List<GoodsBO> hotGoods = goodsService.selectGoodsYourLike(null, null, 0, 8, null, vo.getGoodsClassIds());
		mv.addObject("hotGoods", hotGoods);
		mv.addObject("nearLooks",
				goodsService.queryNearLooks(SecurityUserHolder.getCurrentUser(), CommUtil.getURL(request)));*/
		mv.addObject("vo", vo);
		mv.addObject("gc", gc);
		mv.addObject("orderBy", vo.getOrderBy());
		mv.addObject("orderType", vo.getOrderType());
		mv.addObject("goods_property", vo.getGoodsProperty());
		mv.addObject("allCount", page.getRowCount());
		mv.addObject("goodsViewTools", goodsViewTools);
		mv.addObject("gc_list", gc_list);
		mv.addObject("gs_ids", vo.getGsIdsStr());
		mv.addObject("properties", vo.getProperties());
		mv.addObject("brand_ids", vo.getBrandIds());

		mv.addObject("filter_properties", vo.getFilterProperties());
		return mv;
	}
}
