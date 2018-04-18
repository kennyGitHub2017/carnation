package vc.thinker.b2b2c.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.security.support.OperatorUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.o2o.bo.GroupComplaintBO;
import com.sinco.carnation.o2o.bo.GroupOrderBO;
import com.sinco.carnation.o2o.service.GroupComplaintService;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.o2o.vo.GroupComplaintVO;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.dal.common.MyPage;

@Controller
public class ComplaintManagerAction {

	@Autowired
	GroupComplaintService groupComplaintService;

	/**
	 * 投诉管理列表
	 * 
	 * @param model
	 * @param page
	 *            分页数据
	 * @param vo
	 *            业务对象，查询数据载体
	 * @return
	 */
	@SecurityMapping(title = "新投诉列表", value = "/operator/complaint_new_list.htm*", rtype = "operator", rname = "新投诉列表", rcode = "complaint_new_list", rgroup = "运营商管理")
	@RequestMapping("/operator/complaint_new_list.htm")
	public String complaintNewList(Model model, MyPage<GroupComplaintBO> page, GroupComplaintVO vo) {
		OperatorUserDetails user = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		if (user == null) {
			model.addAttribute("op_title", "没有操作权限！");
			return "tips.html";
		}

		vo.setOperatorId(user.getOperatorBO().getId());
		vo.setStatus(1);
		groupComplaintService.searchOperatorList(vo, page);

		CommUtil.saveIPageList2Model("", "", "", page, model);
		model.addAttribute("vo", vo);
		return "complaint_new_list.html";
	}

	/**
	 * 已完成投诉列表
	 * 
	 * @param model
	 * @param page
	 *            分页数据
	 * @param vo
	 *            业务对象，查询数据载体
	 * @return
	 */
	@SecurityMapping(title = "已完成投诉列表", value = "/operator/complaint_deal_list.htm*", rtype = "operator", rname = "新投诉列表", rcode = "complaint_deal_list", rgroup = "运营商管理")
	@RequestMapping("/operator/complaint_deal_list.htm")
	public String complaintDealList(Model model, MyPage<GroupComplaintBO> page, GroupComplaintVO vo) {
		OperatorUserDetails user = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		if (user == null) {
			model.addAttribute("op_title", "没有操作权限！");
			return "tips.html";
		}

		vo.setOperatorId(user.getOperatorBO().getId());
		vo.setStatus(3);
		groupComplaintService.searchOperatorList(vo, page);

		CommUtil.saveIPageList2Model("", "", "", page, model);
		model.addAttribute("vo", vo);
		return "complaint_deal_list.html";
	}

	@Autowired
	private GroupOrderService groupOrderService;
	@Autowired
	private OrderFormTools orderFormTools;

	/**
	 * 投诉处理
	 * 
	 * @param model
	 * @param page
	 *            分页数据
	 * @param vo
	 *            业务对象，查询数据载体
	 * @return
	 */
	@SecurityMapping(title = "投诉处理", value = "/operator/complaint_deal.htm*", rtype = "operator", rname = "投诉处理", rcode = "complaint_deal", rgroup = "运营商管理")
	@RequestMapping("/operator/complaint_deal.htm")
	public String complaintDeal(HttpServletRequest request, HttpServletResponse response, Model model, Long id) {
		OperatorUserDetails user = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		if (user == null) {
			model.addAttribute("op_title", "没有操作权限！");
			return "tips.html";
		}
		GroupOrderBO obj = groupOrderService.getObjById(CommUtil.null2Long(id));
		if (obj == null) {

			model.addAttribute("op_title", "订单编号错误！");
			return "tips.html";
		}

		model.addAttribute("infos", obj.getGroupInfoBOList());
		model.addAttribute("order", obj);
		model.addAttribute("orderFormTools", orderFormTools);

		return "complaint_deal.html";
	}

	/**
	 * 处理服务投诉
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "投诉处理", value = "/operator/complaint_handle_close.htm*", rtype = "operator", rname = "投诉处理", rcode = "complaint_deal", rgroup = "运营商管理")
	@RequestMapping("/operator/complaint_handle_close.htm")
	public String complaint_handle_close(HttpServletRequest request, HttpServletResponse response,
			Model model, String id, String handle_content) {

		Long uid = SecurityUserHolder.getCurrentUserId();
		GroupComplaintBO gc = new GroupComplaintBO();
		gc.setId(Long.parseLong(id));
		gc.setStatus(3);
		gc.setHandleUserId(uid);
		gc.setHandleContent(handle_content);
		gc.setHandleTime(new Date());
		groupComplaintService.update(gc);

		return "complaint_deal_list.htm";
	}

	/**
	 * 投诉图片
	 * 
	 * @param request
	 * @param response
	 * @param orderId
	 * @return
	 */
	@RequestMapping("/operator/complaintDetails_img.htm")
	public String complaintDetails_img(HttpServletRequest request, HttpServletResponse response, Model model,
			Long orderId) {
		GroupOrderBO obj = groupOrderService.getObjById(orderId);
		model.addAttribute("order", obj);

		return "complaintDetails_img.html";
	}
}
