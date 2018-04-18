package vc.thinker.b2b2c.action.buyer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.alibaba.fastjson.JSON;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.tools.FootPointTools;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.model.UserFootPoint;
import com.sinco.carnation.user.service.FootPointService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: FootPointBuyerAction.java
 * </p>
 * 
 * <p>
 * Description: 用户中心，足迹管理控制器，显示、删除所有浏览过的足迹信息
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
 * @date 2014-10-16
 * 
 * @version 1.0.1
 */
@Controller
public class FootPointBuyerAction {
	@Autowired
	private SysConfigService configService;
	// @Autowired
	// private IUserConfigService userConfigService;
	@Autowired
	private FootPointService footPointService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private FootPointTools footPointTools;

	//
	@SecurityMapping(title = "用户足迹记录", value = "/buyer/foot_point.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/foot_point.htm")
	public ModelAndView foot_point(HttpServletRequest request, HttpServletResponse response,
			MyPage<UserFootPoint> page, String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/foot_point.html",
				configService.getSysConfig(), 0, request, response);
//		page.setPageSize(5);
		footPointService.queryByUserId(SecurityUserHolder.getCurrentUserId(), page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("footPointTools", this.footPointTools);

		// 猜您喜欢 根据cookie商品的分类 销量查询 如果没有cookie则按销量查询
		// List<Goods> your_like_goods = new ArrayList<Goods>();
		// Long your_like_GoodsClass = null;
		// Cookie[] cookies = request.getCookies();
		// if (cookies != null) {
		// for (Cookie cookie : cookies) {
		// if (cookie.getName().equals("goodscookie")) {
		// String[] like_gcid = cookie.getValue().split(",", 2);
		// Goods goods =
		// this.goodsService.getObjById(CommUtil.null2Long(like_gcid[0]));
		// if (goods == null)
		// break;
		// // your_like_GoodsClass = goods.getGc().getId();
		// your_like_goods = this.goodsService.query(
		// "select obj from Goods obj where obj.goods_status=0 and obj.gc.id = "
		// + your_like_GoodsClass + " and obj.id is not " + goods.getId() + "
		// order by obj.goods_salenum desc",
		// null, 0, 20);
		// int gcs_size = your_like_goods.size();
		// if (gcs_size < 20) {
		// List<Goods> like_goods = this.goodsService.query("select obj from
		// Goods obj where obj.goods_status=0 and obj.id is not " +
		// goods.getId() + " order by obj.goods_salenum desc",
		// null, 0, 20 - gcs_size);
		// for (int i = 0; i < like_goods.size(); i++) {
		// // 去除重复商品
		// int k = 0;
		// for (int j = 0; j < your_like_goods.size(); j++) {
		// if (like_goods.get(i).getId().equals(your_like_goods.get(j).getId()))
		// {
		// k++;
		// }
		// }
		// if (k == 0) {
		// your_like_goods.add(like_goods.get(i));
		// }
		// }
		// }
		// break;
		// } else {
		// your_like_goods = this.goodsService.query("select obj from Goods obj
		// where obj.goods_status=0 order by obj.goods_salenum desc", null, 0,
		// 20);
		// }
		// }
		// } else {
		// your_like_goods = this.goodsService.query("select obj from Goods obj
		// where obj.goods_status=0 order by obj.goods_salenum desc", null, 0,
		// 20);
		// }
		// mv.addObject("your_like_goods", your_like_goods);
		return mv;
	}

	//
	@SuppressWarnings({"unchecked", "rawtypes"})
	@SecurityMapping(title = "用户足迹记录删除", value = "/buyer/foot_point_remove.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/foot_point_remove.htm")
	public void foot_point_remove(HttpServletRequest request, HttpServletResponse response, String date,
			String goods_id) {
		boolean ret = true;
		if (!CommUtil.null2String(date).equals("") && CommUtil.null2String(goods_id).equals("")) {// 删除当日所有足迹
//			Map params = new HashMap();
//			params.put("fp_date", CommUtil.formatDate(date));
//			params.put("fp_user_id", SecurityUserHolder.getCurrentUser().getId());
//			List<FootPoint> fps = this.footPointService.query("select obj from FootPoint obj where obj.fp_date=:fp_date and obj.fp_user_id=:fp_user_id", params, -1, -1);
			List<UserFootPoint> fps = footPointService.findListByUserId(
					SecurityUserHolder.getCurrentUserId(), CommUtil.formatDate(date));
			for (UserFootPoint fp : fps) {
				this.footPointService.delete(fp.getId());
			}
		}

		if (!CommUtil.null2String(date).equals("") && !CommUtil.null2String(goods_id).equals("")) {// 删除某一个足迹
//			Map params = new HashMap();
//			params.put("fp_date", CommUtil.formatDate(date));
//			params.put("fp_user_id", SecurityUserHolder.getCurrentUser().getId());
//			List<FootPoint> fps = this.footPointService.query("select obj from FootPoint obj where obj.fp_date=:fp_date and  obj.fp_user_id=:fp_user_id", params, -1, -1);
			List<UserFootPoint> fps = footPointService.findListByUserId(
					SecurityUserHolder.getCurrentUserId(), CommUtil.formatDate(date));

			for (UserFootPoint fp : fps) {
				List<Map> list = JSON.parseObject(fp.getFpGoodsContent(), List.class);
				for (Map map : list) {
					if (CommUtil.null2String(map.get("goods_id")).equals(goods_id)) {
						list.remove(map);
						break;
					}
				}

//				fp.setFp_goods_content(Json.toJson(list, JsonFormat.compact()));
				fp.setFpGoodsContent(JSON.toJSONString(list));
				fp.setFpGoodsCount(list.size());;
				this.footPointService.update(fp);
			}
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(ret);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
