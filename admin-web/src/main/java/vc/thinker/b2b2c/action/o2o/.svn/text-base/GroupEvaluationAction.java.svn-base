package vc.thinker.b2b2c.action.o2o;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.o2o.bo.GroupEvaluationBO;
import com.sinco.carnation.o2o.service.GroupEvaluationService;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.o2o.vo.GroupEvaluationVO;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

@Controller
public class GroupEvaluationAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private GroupEvaluationService groupEvaluationService;
	@Autowired
	private OrderFormTools orderFormTools;
	@Autowired
	private GroupOrderService orderService;

	@SecurityMapping(title = "服务评价列表", value = "/admin/group_evaluation_list.htm*", rtype = "admin", rname = "服务评价", rcode = "admin_group_evaluation", rgroup = "商户管理")
	@RequestMapping("/admin/group_evaluation_list.htm")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response,
			MyPage<GroupEvaluationBO> page, GroupEvaluationVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/group_evaluation_list.html",
				configService.getSysConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if (url == null || url.equals("")) {
			url = CommUtil.getURL(request);
		}
		page.setPageSize(10);
		// groupEvaluationService.queryByStoreName(storeName, page);
		groupEvaluationService.queryByVO(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("orderFormTools", orderFormTools);
		mv.addObject("orderService", orderService);
		mv.addObject("vo", vo);
		return mv;
	}
}
