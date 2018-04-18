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

import net.weedfs.client.WeedFSClient;

import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.constant.UploadConstants;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.FileUploadTools;

import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.shop.bo.ComplaintBO;
import com.sinco.carnation.shop.bo.ComplaintGoodsBO;
import com.sinco.carnation.shop.model.Complaint;
import com.sinco.carnation.shop.model.ComplaintSubject;
import com.sinco.carnation.shop.model.OrderForm;
import com.sinco.carnation.shop.service.ComplaintGoodsService;
import com.sinco.carnation.shop.service.ComplaintService;
import com.sinco.carnation.shop.service.ComplaintSubjectService;
import com.sinco.carnation.shop.vo.ComplaintGoodsVO;
import com.sinco.carnation.shop.vo.ComplaintVO;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.dal.common.MyPage;

/**
 * @info 卖家中心投诉管理，V1.3版开始将卖家投诉中心、买家投诉分开管理，更加合理
 * @since V1.3
 * 
 */
@Controller
public class ComplaintSellerAction {
	@Autowired
	private SysConfigService configService;
//	@Autowired
//	private IUserConfigService userConfigService;
	@Autowired
	private ComplaintService complaintService;
	@Autowired
	private ComplaintSubjectService complaintSubjectService;
	@Autowired
	private OrderFormService orderFormService;
//	@Autowired
//	private IGoodsService goodsService;
//	@Autowired
//	private IAccessoryService accessoryService;
//	@Autowired
//	private UserService userService;
	@Autowired
	private OrderFormTools orderFormTools;
	@Autowired
	private UserCustomerService userCustomerService;
	@Autowired
	private ComplaintGoodsService complaintGoodsService;
	@Autowired
	private WeedFSClient fsClient;

//
//	@SecurityMapping(title = "卖家投诉发起", value = "/seller/complaint_handle.htm*", rtype = "seller", rname = "投诉管理", rcode = "complaint_seller", rgroup = "客户服务")
//	@RequestMapping("/seller/complaint_handle.htm")
//	public ModelAndView complaint_handle(HttpServletRequest request,
//			HttpServletResponse response, String order_id) {
//		ModelAndView mv = new JModelAndView(
//				"user/default/usercenter/complaint_handle.html",
//				configService.getSysConfig(),
//				this.userConfigService.getUserConfig(), 0, request, response);
//		OrderForm of = this.orderFormService.getObjById(CommUtil
//				.null2Long(order_id));
//		Calendar calendar = Calendar.getInstance();
//		calendar.add(Calendar.DAY_OF_YEAR, -this.configService.getSysConfig()
//				.getComplaint_time());
//		User user = this.userService.getObjById(SecurityUserHolder
//				.getCurrentUser().getId());
//		user = user.getParent() == null ? user : user.getParent();
//		boolean result = true;
//		if (of.getOrder_status() == 60) {
//			if (of.getFinishTime().before(calendar.getTime())) {
//				result = false;
//			}
//		}
//		boolean result1 = true;
//		if (of.getComplaints().size() > 0) {
//			for (Complaint complaint : of.getComplaints()) {
//				if (complaint.getFrom_user().getId().equals(user.getId())) {
//					result1 = false;
//				}
//			}
//		}
//		if (result) {
//			if (result1) {
//				Complaint obj = new Complaint();
//				obj.setFrom_user(user);
//				obj.setStatus(0);
//				obj.setType("seller");
//				obj.setOf(of);
//				User buyer = this.userService.getObjById(CommUtil.null2Long(of
//						.getUser_id()));
//				obj.setTo_user(buyer);
//				mv.addObject("obj", obj);
//				Map params = new HashMap();
//				params.put("type", "seller");
//				List<ComplaintSubject> css = this.complaintSubjectService
//						.query("select obj from ComplaintSubject obj where obj.type=:type",
//								params, -1, -1);
//				mv.addObject("css", css);
//			} else {
//				mv = new JModelAndView(
//						"user/default/sellercenter/seller_error.html",
//						configService.getSysConfig(),
//						this.userConfigService.getUserConfig(), 0, request,
//						response);
//				mv.addObject("op_title", "该订单已经投诉，不允许重复投诉");
//				mv.addObject("url", CommUtil.getURL(request)
//						+ "/seller/order.htm");
//			}
//		} else {
//			mv = new JModelAndView(
//					"user/default/sellercenter/seller_error.html",
//					configService.getSysConfig(),
//					this.userConfigService.getUserConfig(), 0, request,
//					response);
//			mv.addObject("op_title", "该订单已经超过投诉有效期，不能投诉");
//			mv.addObject("url", CommUtil.getURL(request) + "/seller/order.htm");
//		}
//		return mv;
//	}

	@SecurityMapping(title = "卖家被投诉列表", value = "/seller/complaint.htm*", rtype = "seller", rname = "投诉管理", rcode = "complaint_seller", rgroup = "客户服务")
	@RequestMapping("/seller/complaint.htm")
	public ModelAndView complaint_seller(HttpServletRequest request, HttpServletResponse response,
			MyPage<ComplaintBO> page, String status) {
		ComplaintVO vo = new ComplaintVO();
		vo.setStatus(status);
		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_complaint.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		vo.setToUserId(userDetails.getId() + "");
		complaintService.findListByVO(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("status", status);
		return mv;
	}

	@SecurityMapping(title = "卖家查看投诉详情", value = "/seller/complaint_view.htm*", rtype = "seller", rname = "投诉管理", rcode = "complaint_seller", rgroup = "客户服务")
	@RequestMapping("/seller/complaint_view.htm")
	public ModelAndView complaint_view(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_complaint_view.html",
				configService.getSysConfig(), 0, request, response);
		Complaint obj = this.complaintService.getObjById(CommUtil.null2Long(id));
		OrderForm of = orderFormService.getObjById(obj.getOfId());
		if (obj.getFromUserId() != null) {
			UserCustomer fromUser = userCustomerService.findById(obj.getFromUserId());
			mv.addObject("fromUser", fromUser);
		}
		if (obj.getToUserId() != null) {
			UserCustomer toUser = userCustomerService.findById(obj.getToUserId());
			mv.addObject("toUser", toUser);
		}
		if (obj.getHandleUserId() != null) {
			UserCustomer handleUser = userCustomerService.findById(obj.getHandleUserId());
			mv.addObject("handleUser", handleUser);
		}
		ComplaintSubject cs = complaintSubjectService.getObjById(obj.getCsId());
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		ComplaintGoodsVO vo = new ComplaintGoodsVO();
		vo.setComplaintId(obj.getId());
		List<ComplaintGoodsBO> gs = complaintGoodsService.findListByVo(vo);
		if (obj.getFromUserId().equals(userDetails.getId()) || obj.getToUserId().equals(userDetails.getId())) {
			mv.addObject("obj", obj);
			mv.addObject("of", of);
			mv.addObject("cs", cs);
			mv.addObject("gs", gs);
			mv.addObject("orderFormTools", orderFormTools);
		} else {
			mv = new JModelAndView("user/default/sellercenter/seller_error.html",
					configService.getSysConfig(), 0, request, response);
			mv.addObject("op_title", "参数错误，不存在该投诉");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/complaint.htm");
		}
		return mv;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@SecurityMapping(title = "卖家提交申诉", value = "/seller/complaint_appeal.htm*", rtype = "seller", rname = "投诉管理", rcode = "complaint_seller", rgroup = "客户服务")
	@RequestMapping("/seller/complaint_appeal.htm")
	public void complaint_appeal(HttpServletRequest request, HttpServletResponse response, String id,
			String toUserContent, @RequestParam("img1") MultipartFile file1,
			@RequestParam("img2") MultipartFile file2, @RequestParam("img3") MultipartFile file3) {
		Complaint obj = this.complaintService.getObjById(CommUtil.null2Long(id));
		obj.setStatus(2);
		obj.setToUserContent(toUserContent);
		obj.setAppealTime(new Date());
		String fileUrl=null;
		if (file1 != null && file1.getSize() != 0) {
			try {
				fileUrl=FileUploadTools.fileUpload(file1, UploadConstants.EDITOR);
				obj.setToAcc1(fileUrl);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (file2 != null && file2.getSize() != 0) {
			try {
				fileUrl=FileUploadTools.fileUpload(file2, UploadConstants.EDITOR);
				obj.setToAcc2(fileUrl);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (file3 != null && file3.getSize() != 0) {
			try {
				fileUrl=FileUploadTools.fileUpload(file3, UploadConstants.EDITOR);
				obj.setToAcc3(fileUrl);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.complaintService.update(obj);
		Map json = new HashMap();
		json.put("url", CommUtil.getURL(request) + "/seller/complaint.htm");
		json.put("op_title", "提交申诉成功");
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(json, JsonFormat.compact()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@SecurityMapping(title = "发布投诉对话", value = "/seller/complaint_talk.htm*", rtype = "seller", rname = "投诉管理", rcode = "complaint_seller", rgroup = "客户服务")
	@RequestMapping("/seller/complaint_talk.htm")
	public void complaint_talk(HttpServletRequest request, HttpServletResponse response, String id,
			String talkContent) throws IOException {
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		Complaint obj = this.complaintService.getObjById(CommUtil.null2Long(id));
		if (!CommUtil.null2String(talkContent).equals("")) {
			String user_role = "";
			if (SecurityUserHolder.getCurrentUser().getId().equals(obj.getFromUserId())) {
				user_role = "投诉人";
			}
			if (SecurityUserHolder.getCurrentUser().getId().equals(obj.getToUserId())) {
				user_role = "申诉人";
			}
			String temp = user_role + "[" + userDetails.getCustomer().getNickname() + "] "
					+ CommUtil.formatLongDate(new Date()) + "说: " + talkContent;
			if (obj.getTalkContent() == null) {
				obj.setTalkContent(temp);
			} else {
				obj.setTalkContent(temp + "\n\r" + obj.getTalkContent());
			}
			this.complaintService.update(obj);
		}
		List<Map> maps = new ArrayList<Map>();
		for (String s : CommUtil.str2list(obj.getTalkContent())) {
			Map map = new HashMap();
			map.put("content", s);
			if (s.indexOf("管理员") == 0) {
				map.put("role", "admin");
			}
			if (s.indexOf("投诉") == 0) {
				map.put("role", "from_user");
			}
			if (s.indexOf("申诉") == 0) {
				map.put("role", "to_user");
			}
			maps.add(map);
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(maps, JsonFormat.compact()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	@SecurityMapping(title = "申请仲裁", value = "/seller/complaint_arbitrate.htm*", rtype = "seller", rname = "投诉管理", rcode = "complaint_seller", rgroup = "客户服务")
	@RequestMapping("/seller/complaint_arbitrate.htm")
	public void complaint_arbitrate(HttpServletRequest request, HttpServletResponse response, String id,
			String toUserContent) {
		Complaint obj = this.complaintService.getObjById(CommUtil.null2Long(id));
		obj.setStatus(3);
		this.complaintService.update(obj);
		Map json = new HashMap();
		json.put("url", CommUtil.getURL(request) + "/seller/complaint.htm");
		json.put("op_title", "申请仲裁成功");
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(json, JsonFormat.compact()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SecurityMapping(title = "查看取证图片", value = "/seller/complaint_img.htm*", rtype = "seller", rname = "投诉管理", rcode = "complaint_seller", rgroup = "客户服务")
	@RequestMapping("/seller/complaint_img.htm")
	public ModelAndView complaint_img(HttpServletRequest request, HttpServletResponse response, String id,
			String type) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/complaint_img.html",
				configService.getSysConfig(), 0, request, response);
		Complaint obj = this.complaintService.getObjById(CommUtil.null2Long(id));
		mv.addObject("type", type);
		mv.addObject("obj", obj);
		return mv;
	}
}
