package vc.thinker.b2b2c.action.o2o;

import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.o2o.bo.GroupEvaluationBO;
import com.sinco.carnation.o2o.bo.GroupGoodsBO;
import com.sinco.carnation.o2o.service.GroupEvaluationService;
import com.sinco.carnation.o2o.service.GroupGoodsService;
import com.sinco.carnation.o2o.vo.GroupEvaluationVO;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.model.Accessory;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.service.AlbumService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.tools.ImageTools;
import com.sinco.dal.common.MyPage;

import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

@Controller
public class GroupStoreAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private GroupEvaluationService evaluationService;
	@Autowired
	private ImageTools imageTools;
	@Autowired
	private AlbumService albumService;
	@Autowired
	private UserCustomerService customerService;
	@Autowired
	private GroupGoodsService groupGoodsService;
	@Autowired
	private OrderFormTools orderFormTools;

	@RequestMapping("/group/store.htm")
	public ModelAndView store(Long id, MyPage<GroupEvaluationBO> page, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("o2o/store_default.html", configService.getSysConfig(), 1,
				request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		StoreBO store = storeService.getObjById(id);
		if (null == store) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "不存在的店铺！");
			mv.addObject("url", CommUtil.getURL(request) + "/");
			return mv;
		}

//		page.setPageSize(3);
		mv.addObject("store", store);
		mv.addObject("imageTools", imageTools);

		// 店铺的评价总分和总评价人数
		GroupEvaluationBO storeTotal = evaluationService.fetchStoreTotal(id);
		// 店铺好评率
		long storeRate = 0;
		mv.addObject("storeRate", storeRate);
		if (null != storeTotal && null != storeTotal.getNum() && storeTotal.getNum() > 0) {
			if (storeTotal.getTotalScore() % (long) storeTotal.getNum() == 0) {
				storeRate = storeTotal.getTotalScore() / (long) storeTotal.getNum();
				mv.addObject("storeRate", storeRate);
			} else {
				DecimalFormat df = new DecimalFormat("0.0");
				double a = storeTotal.getTotalScore() * 1.0 / (long) storeTotal.getNum();
				double result = Double.parseDouble(df.format(a));
				mv.addObject("storeRate", result);
			}

		}

		mv.addObject("storeTotal", storeTotal);
		// 店铺按各个分数的汇总
		mv.addObject("scores", evaluationService.queryStoreByScores(id));

		// //////////////////////////////////////////////
		// //////////////////////////////////////////////

		List<Accessory> accessories = albumService.queryAccessories(store.getCreateUserId());
		mv.addObject("accessories", accessories);

		GroupEvaluationVO vo = new GroupEvaluationVO();
		vo.setStoreId(id);
		evaluationService.query(vo, page);

		for (GroupEvaluationBO bo : page.getContent()) {
			bo.setNickName(this.orderFormTools.dealNickNameDisplay(bo.getNickName()));
		}
		mv.addObject("isLogin", null != SecurityUserHolder.getCurrentUserId());
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		List<GroupGoodsBO> groupGoods = groupGoodsService.queryByStoreId(store.getId(), null, 0);
		mv.addObject("groupGoods", groupGoods);

//		int favoriteCount = customerService.countStoreFavorite(id, 6);
		mv.addObject("favoriteCount", store.getFavoriteCount());
		mv.addObject("userDetails", userDetails);
		return mv;
	}

	@RequestMapping("/group/collectStore.htm")
	@ResponseBody
	public String collect(Long id, HttpServletRequest request, HttpServletResponse response) {
		// user_dialog_login.htm

		Map<String, Object> resp = new HashMap<>();
		response.setContentType("text/html;charset=UTF-8");
		StoreBO store = storeService.getObjById(id);
		if (null == store) {
			resp.put("error", 1);// 不存在的店铺
			return JSON.toJSONString(resp);
		}

		Long userId = SecurityUserHolder.getCurrentUserId();
		if (null == userId) {
			resp.put("error", 2);// 未登录
			return JSON.toJSONString(resp);
		}
		int i = 3;
		try {
			i = customerService.addFavorites(userId, id + "", "6");
		} catch (ServiceException e) {
			i = 3;
		}
		resp.put("success", i);

		return JSON.toJSONString(resp);
	}

	/**
	 * 底部根据流程猜你喜欢商品列表， 使用自定义标签$!httpInclude.include("/goods_list_bottom.htm") 完成页面引用,默认查询20条数据
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping("/goodslike_list.htm")
	// 由于工程起不来，这里暂时加了1
	public ModelAndView goodslike_list(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("o2o/goodslike_list.html", configService.getSysConfig(), 1,
				request, response);
		// 猜您喜欢 根据cookie商品的分类 销量查询 如果没有cookie则按销量查询
		List<GroupGoodsBO> your_like_goods = new ArrayList<GroupGoodsBO>();
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("goodsStr")) {
					String str = URLDecoder.decode(cookie.getValue());
					List<GroupGoodsBO> goods = JSON.parseArray(str, GroupGoodsBO.class);
					Set<Long> goodsIds = new HashSet<>();
					for (int i = 0; i < goods.size(); i++) {
						GroupGoodsBO good = goods.get(i);
						goodsIds.add(good.getId());
						good = groupGoodsService.queryGroupGoodsById(good.getId());
//						goods.set(i, good);
						if (null != good && good.getGgStatus() == 0)
							your_like_goods.add(good);
					}

//					your_like_goods.addAll(goods);
					if (goods.size() >= 6) {
						break;
					} else {
						List<GroupGoodsBO> like_goods = this.groupGoodsService.selectGoodsYourLike(null, 0,
								6 - goods.size(), goodsIds, null);

						if (like_goods.size() > 0) {
							for (int i = 0; i < like_goods.size(); i++) {
								GroupGoodsBO good = like_goods.get(i);
//								goodsIds.add(good.getId());
								good = groupGoodsService.queryGroupGoodsById(good.getId());
								like_goods.set(i, good);
							}
							your_like_goods.addAll(like_goods);
						}
					}
					break;
				}
			}
		}
		if (your_like_goods.size() == 0)
			your_like_goods = this.groupGoodsService.selectGoodsYourLike(null, 0, 6, null, null);
		mv.addObject("your_like_goods", your_like_goods);
		return mv;
	}
}
