package vc.thinker.b2b2c.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.mv.JModelAndView;

import com.sinco.carnation.goods.service.ZeroGoodsService;
import com.sinco.carnation.market.bo.ActivityHotSaleBO;
import com.sinco.carnation.market.bo.ActivitySaleMessageBO;
import com.sinco.carnation.market.model.ActivitySaleMessageTemplate;
import com.sinco.carnation.market.service.ActivitySaleMessageTemplateService;
import com.sinco.carnation.market.service.SaleActivityMessageService;
import com.sinco.carnation.market.service.SaleActivityService;
import com.sinco.carnation.shop.bo.ZeroGoodsBO;
import com.sinco.carnation.shop.vo.ZeroGoodsVO;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.tools.WxshareTools;
import com.sinco.dal.common.MyPage;

@Controller
public class ActGoodsAction {

	@Autowired
	private SysConfigService configService;
	@Autowired
	private ZeroGoodsService zeroGoodsService;
	@Autowired
	private ActivitySaleMessageTemplateService activitySaleMessageTemplateService;
	@Autowired
	private SaleActivityMessageService saleActivityMessageService;
	@Autowired
	private SaleActivityService saleActivityService;

	/***
	 * 0云购商品
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 */
	@RequestMapping("/zeroList.htm")
	public ModelAndView zeroGoodsList(HttpServletRequest request, HttpServletResponse response,
			MyPage<ZeroGoodsBO> page) {

		ModelAndView mv = new JModelAndView("zeroShop/zero_goods.html", configService.getSysConfig(), 1,
				request, response);
		WxshareTools wxshareTools = new WxshareTools();
		wxshareTools.wxShareMv(mv, request);
		/*				ZeroGoodsVO vo = new ZeroGoodsVO();
						List<ZeroGoodsBO> list = this.zeroGoodsService.findByVo(vo);
						page.setContent(list);
						CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);*/
		String isflag = request.getParameter("isflag");
		mv.addObject("isflag", isflag);
		return mv;
	}

	@RequestMapping("/zero/goodsList.htm")
	public void goodsList(HttpServletRequest request, HttpServletResponse response) {
		ZeroGoodsVO vo = new ZeroGoodsVO();
		vo.setGoodsStatus(true);
		List<ZeroGoodsBO> list = this.zeroGoodsService.findByVo(vo);
		JSONArray json = JSONArray.fromObject(list);
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/***
	 * 统一活动商品列表页面
	 * 
	 * @param id
	 *            弹框id
	 * @param page
	 * @return
	 */
	@RequestMapping("/act_goods_list.htm")
	public ModelAndView actGoodsList(HttpServletRequest request, HttpServletResponse response,
			MyPage<ZeroGoodsBO> page, Long id) {
		ModelAndView mv = new JModelAndView("zeroShop/act_goods_list.html", configService.getSysConfig(), 1,
				request, response);
		if (null == id) {
			request.setAttribute("message", "参数错误");
			return mv;
		}

		// 查询弹框
		ActivitySaleMessageBO activitySaleMessage = saleActivityMessageService.getSaleMessageById(id);
		if (activitySaleMessage == null) {
			request.setAttribute("message", "参数错误");
			return mv;
		}
		Long actId = activitySaleMessage.getActId();
		Long templateId = activitySaleMessage.getTemplateId();
		ActivityHotSaleBO hotSale = null;
		// 查询弹框对应的活动
		List<ActivityHotSaleBO> list = saleActivityService.findAll();
		for (ActivityHotSaleBO bo : list) {
			if (bo.getId() == actId) {
				hotSale = bo;
			}
		}
		if (hotSale == null) {
			request.setAttribute("message", "活动未开启");
			return mv;
		}
		// 查询弹框信息的模板
		ActivitySaleMessageTemplate activitySaleMessageTemplate = activitySaleMessageTemplateService
				.findOne(templateId);
		String isflag = request.getParameter("isflag");
		mv.addObject("isflag", isflag);
		mv.addObject("hotSale", hotSale);// 活动信息
		mv.addObject("saleMessage", activitySaleMessage);// 弹框信息
		mv.addObject("template", activitySaleMessageTemplate);// 模板信息
		WxshareTools wxshareTools = new WxshareTools();
		wxshareTools.wxShareMv(mv, request);
		return mv;
	}
}
