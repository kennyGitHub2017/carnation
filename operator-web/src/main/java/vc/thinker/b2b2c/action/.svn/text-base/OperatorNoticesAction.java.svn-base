package vc.thinker.b2b2c.action;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.security.support.OperatorUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.notice.service.OperatorNoticesService;
import com.sinco.carnation.sns.bo.OperatorNoticesBO;
import com.sinco.carnation.sns.model.OperatorNotices;
import com.sinco.carnation.sns.vo.OperatorNoticesVO;
import com.sinco.carnation.user.UserContants;
import com.sinco.dal.common.MyPage;

/**
 * 
 * @ClassName: OperatorNoticeAction
 * @Description: TODO(运营商公告，PS:只有市级运营商才有此功能权限)
 * @author 陈舟
 * @date 2015年10月21日 下午3:06:17
 * 
 */
@Controller
public class OperatorNoticesAction {

	@Autowired
	private OperatorNoticesService operatorNoticesService;

	/**
	 * 运营商公告列表
	 * 
	 * @param model
	 * @param page
	 *            分页数据
	 * @param vo
	 *            业务对象，查询数据载体
	 * @return
	 */
	@SecurityMapping(title = "运营商公告列表", value = "/operator/operator_notice_list.htm*", rtype = "operator", rname = "运营商公告列表", rcode = "operator_notice_list", rgroup = "运营商管理")
	@RequestMapping("/operator/operator_notice_list.htm")
	public String operatorAdList(Model model, MyPage<OperatorNoticesBO> page, OperatorNoticesVO vo) {
		OperatorUserDetails user = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		if (!UserContants.OPERATOR_LEVEL_SHI.equals(user.getOperatorBO().getLevel())) {
			model.addAttribute("op_title", "没有操作权限！");
			return "tips.html";
		}

		vo.setOperatorId(user.getOperatorBO().getId());
		operatorNoticesService.findPageByVO(vo, page);
		CommUtil.saveIPageList2Model("", "", "", page, model);
		model.addAttribute("vo", vo);
		return "operator_notice_list.html";
	}

	/**
	 * 运营商公告添加
	 * 
	 * @param model
	 * @return
	 */
	@SecurityMapping(title = "运营商公告添加", value = "/operator/operator_notice_add.htm*", rtype = "operator", rname = "运营商公告添加", rcode = "operator_notice_add", rgroup = "运营商管理")
	@RequestMapping("/operator/operator_notice_add.htm")
	public String operatorNoticeAdd(Model model) {
		OperatorUserDetails user = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		if (!UserContants.OPERATOR_LEVEL_SHI.equals(user.getOperatorBO().getLevel())) {
			model.addAttribute("op_title", "没有操作权限！");
			return "tips.html";
		}
		return "operator_notice_add.html";
	}

	/**
	 * 运营商公告编辑
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "运营商公告编辑", value = "/operator/operator_notice_edit.htm*", rtype = "operator", rname = "运营商公告编辑", rcode = "operator_notice_edit", rgroup = "运营商管理")
	@RequestMapping("/operator/operator_notice_edit.htm")
	public String operatorNoticeEdit(Model model, Long id) {

		OperatorUserDetails user = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		if (!UserContants.OPERATOR_LEVEL_SHI.equals(user.getOperatorBO().getLevel())) {
			model.addAttribute("op_title", "没有操作权限！");
			return "tips.html";
		}
		OperatorNoticesBO operatorNoticesBO = operatorNoticesService.getBoById(id);
		if (!operatorNoticesBO.getOperatorId().equals(user.getOperatorBO().getId())) {
			model.addAttribute("op_title", "没有操作权限！");
			return "tips.html";
		}
		model.addAttribute("noticeBO", operatorNoticesBO);
		return "operator_notice_add.html";
	}

	/**
	 * 运营商公告查看
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "运营商公告查看", value = "/operator/operator_notice_view.htm*", rtype = "operator", rname = "运营商公告查看", rcode = "operator_notice_view", rgroup = "运营商管理")
	@RequestMapping("/operator/operator_notice_view.htm")
	public String operator_notice_view(Model model, Long id) {

		OperatorUserDetails user = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		if (!UserContants.OPERATOR_LEVEL_SHI.equals(user.getOperatorBO().getLevel())) {
			model.addAttribute("op_title", "没有操作权限！");
			return "tips.html";
		}
		OperatorNoticesBO operatorNoticesBO = operatorNoticesService.getBoById(id);
		if (!operatorNoticesBO.getOperatorId().equals(user.getOperatorBO().getId())) {
			model.addAttribute("op_title", "没有操作权限！");
			return "tips.html";
		}
		model.addAttribute("noticeBO", operatorNoticesBO);
		return "operator_notice_view.html";
	}

	/**
	 * 运营商公告保存
	 * 
	 * @param model
	 * @param operatorNoticesVO
	 *            业务对象
	 * @return
	 */
	@SecurityMapping(title = "运营商公告保存", value = "/operator/operator_notice_save.htm*", rtype = "operator", rname = "运营商公告保存", rcode = "operator_notice_save", rgroup = "运营商管理")
	@RequestMapping("/operator/operator_notice_save.htm")
	public String operatorNoticeSave(Model model, OperatorNoticesVO operatorNoticesVO) {
		OperatorUserDetails user = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		if (!UserContants.OPERATOR_LEVEL_SHI.equals(user.getOperatorBO().getLevel())) {
			model.addAttribute("op_title", "没有操作权限！");
			return "tips.html";
		}
		if (operatorNoticesVO != null) {
			OperatorNotices operatorNotices = operatorNoticesVO;
			operatorNotices.setOperatorId(user.getOperatorBO().getId());
			operatorNotices.setDeleteStatus(false);
			operatorNotices.setNtStatus(0);// 设置为待审核

			if (operatorNotices.getId() != null && operatorNotices.getId() > 0) { // 判断新增状态和编辑状态

				operatorNoticesService.update(operatorNotices);
			} else {
				operatorNotices.setAddTime(new Date());
				operatorNoticesService.save(operatorNotices);
			}
		}
		model.addAttribute("url", "/operator/operator_notice_list.htm");
		model.addAttribute("op_title", "保存公告成功");
		return "tips.html";
	}

	/**
	 * 公告删除
	 * 
	 * @param model
	 * @param id
	 *            删除主键标志
	 * @return
	 */
	@SecurityMapping(title = "运营商公告删除", value = "/operator/operator_notice_del.htm*", rtype = "operator", rname = "运营商公告删除", rcode = "operator_ad_del", rgroup = "运营商管理")
	@RequestMapping("/operator/operator_notice_del.htm")
	public String operatorAdDel(Model model, Long id) {

		OperatorUserDetails user = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		OperatorNoticesBO operatorNoticesBO = operatorNoticesService.getBoById(id);
		if (operatorNoticesBO == null
				|| !UserContants.OPERATOR_LEVEL_SHI.equals(user.getOperatorBO().getLevel())) {
			model.addAttribute("op_title", "没有操作权限！");
			return "tips.html";
		}
		operatorNoticesService.delete(id);
		model.addAttribute("op_title", "删除成功！");
		model.addAttribute("url", "/operator/operator_notice_list.htm");
		return "tips.html";
	}
}
