package vc.thinker.b2b2c.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.weedfs.client.WeedFSClient;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.consulting.service.ConsultingService;
import com.sinco.carnation.sns.bo.ConsultingBO;
import com.sinco.carnation.sns.bo.ConsultingRepayBO;
import com.sinco.carnation.sns.bo.KnowledgeClassBO;
import com.sinco.carnation.sns.model.Consulting;
import com.sinco.carnation.sns.model.ConsultingRepay;
import com.sinco.carnation.sns.vo.ConsultingVO;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.RoleService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.SysLogServiceImpl;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.service.ExpertsService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: CircleManageAction.java
 * </p>
 * 
 * <p>
 * Description: 专家回答
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
 * @date 2014-11-20
 * 
 * @version 1.0.1
 */
@Controller
public class ExpertReplyManageAction {

	@Autowired
	private SysConfigService configService;

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private AccessoryServiceImpl accessoryService;

	@Autowired
	private SysLogServiceImpl syslogService;

	@Autowired
	private UserCustomerService customerService;

	@Autowired
	private ExpertsService expertService;

	@Autowired
	private UserAccountService accountService;
	@Autowired
	private ConsultingService consultingService;

	@Autowired
	private WeedFSClient fsClient;

	@Autowired
	private ConsultingService consulService;

	@SecurityMapping(title = "专家咨询", value = "/admin/experts_reply_list.htm*", rtype = "admin", rname = "专家资讯", rcode = "expert", rgroup = "内容管理")
	@RequestMapping("/admin/experts_reply_list.htm")
	public ModelAndView experts_list(HttpServletRequest request, HttpServletResponse response,
			ConsultingVO vo, MyPage<ConsultingBO> page) {

		ModelAndView mv = new JModelAndView("admin/blue/experts_reply_list.html",
				configService.getSysConfig(), 0, request, response);
		page.setPageSize(20);
		User user = SecurityUserHolder.getCurrentUser();
		if (user.getUserType() == 3) {
			consulService.queryConsulListByExp(user.getId(), vo, page);
		} else
			consulService.queryConsulListByExp(null, vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("vo", vo);
		mv.addObject("userType", user.getUserType());
		mv.addObject("pages", page.getContent());
		return mv;
	}

	@SecurityMapping(title = "查看咨询详情", value = "/admin/consulting_details.htm*", rtype = "admin", rname = "专家回答", rcode = "expert", rgroup = "内容管理")
	@RequestMapping("/admin/consulting_details.htm")
	public ModelAndView consulting_details(HttpServletRequest request, HttpServletResponse response,
			Long consId) {

		// ModelAndView mv = new
		// JModelAndView("admin/blue/consulting_details.html",
		// configService.getSysConfig(), 0, request, response);
		ModelAndView mv = new JModelAndView("admin/blue/consulting_details.html",
				configService.getSysConfig(), 0, request, response);

		ConsultingBO con = consulService.queryConsulDetails(consId);
		List<ConsultingRepayBO> list = consulService.consultReplyList(consId);
		if (StringUtils.isNotBlank(con.getImages())) {
			mv.addObject("imageList", con.getImages().split("\\|"));
		}

		User user = SecurityUserHolder.getCurrentUser();
		mv.addObject("userid", user.getId());
		mv.addObject("userType", user.getUserType());
		mv.addObject("obj", con);
		mv.addObject("pages", list);
		if (StringUtils.isNotBlank(con.getImages())) {
			String[] img = con.getImages().split("||");
			mv.addObject("imgs", img);
		}

		List<KnowledgeClassBO> classList = consultingService.findAll();
		mv.addObject("classList", classList);
		return mv;
	}

	@SecurityMapping(title = "查看咨询详情", value = "/admin/consulting_detail.htm*", rtype = "admin", rname = "咨询详情", rcode = "expert", rgroup = "内容管理")
	@RequestMapping("/admin/consulting_detail.htm")
	public ModelAndView consulting_detail(HttpServletRequest request, HttpServletResponse response,
			Long consId) {

		// ModelAndView mv = new
		// JModelAndView("admin/blue/consulting_details.html",
		// configService.getSysConfig(), 0, request, response);
		ModelAndView mv = new JModelAndView("admin/blue/consulting_detail.html",
				configService.getSysConfig(), 0, request, response);

		ConsultingBO con = consulService.queryConsulDetails(consId);
		List<ConsultingRepayBO> list = consulService.consultReplyList(consId);
		if (StringUtils.isNotBlank(con.getImages())) {
			mv.addObject("imageList", con.getImages().split("\\|"));
		}

		User user = SecurityUserHolder.getCurrentUser();
		mv.addObject("userid", user.getId());
		mv.addObject("obj", con);
		mv.addObject("pages", list);
		if (StringUtils.isNotBlank(con.getImages())) {
			String[] img = con.getImages().split("||");
			mv.addObject("imgs", img);
		}

		return mv;
	}

	@SecurityMapping(title = "专家回复", value = "/admin/consulting_reply.htm*", rtype = "admin", rname = "专家回答", rcode = "expert", rgroup = "内容管理")
	@RequestMapping("/admin/consulting_reply.htm")
	public @ResponseBody
	ModelAndView consulting_reply(HttpServletRequest request, HttpServletResponse response, String content,
			String id) {

		ModelAndView mv = new JModelAndView("admin/blue/invitation_template.html",
				configService.getSysConfig(), 0, request, response);

		User user = SecurityUserHolder.getCurrentUser();
		// 回复保存内容
		int num = consulService.repyConsulting(id, content, String.valueOf(user.getId()));
		// 问题回复列表
		List<ConsultingRepayBO> list = consulService.consultReplyList(Long.parseLong(id));
		if (num > 0) {
			Consulting consulting = consulService.selectConsultingById(Long.parseLong(id));
			ConsultingRepay reply = consulService.selectById((long) num);
			if (null != consulting && null != reply) {
				// 给客户端推送消息
				consulService.sendRepayMessage(consulting, reply);
			}
		}
		mv.addObject("userid", user.getId());
		mv.addObject("pages", list);

		return mv;
	}

}
