package vc.thinker.b2b2c.action.o2o;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.elasticsearch.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.lucene.WordFind;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sinco.carnation.o2o.bo.GroupEvaluationBO;
import com.sinco.carnation.o2o.bo.GroupOrderBO;
import com.sinco.carnation.o2o.model.GroupEvaluation;
import com.sinco.carnation.o2o.service.GroupEvaluationService;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.o2o.service.exceptions.CheckException;
import com.sinco.carnation.o2o.service.exceptions.EvaluationContentSizeExcepiton;
import com.sinco.carnation.o2o.service.exceptions.EvaluationPhotoSizeExcepiton;
import com.sinco.carnation.o2o.service.exceptions.EvaluationScoreZeroException;
import com.sinco.carnation.o2o.vo.GroupEvaluationVO;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

@Controller
public class GroupEvaluationAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private GroupOrderService orderService;
	@Autowired
	private GroupEvaluationService evaluationService;
	@Autowired
	private AccessoryServiceImpl accessoryService;
	@Autowired
	private OrderFormTools orderFormTools;
	@Autowired
	private StoreService storeService;

	@SecurityMapping(title = "服务评价列表", value = "/group/evaluate_list.htm*", rtype = "seller", rname = "卖家团购评价", rcode = "seller_group_evaluate", rgroup = "卖家团购评价")
	@RequestMapping("/group/evaluate_list.htm")
	public ModelAndView evaluate_list(HttpServletRequest request, HttpServletResponse response,
			MyPage<GroupEvaluationBO> page, String status) {
		ModelAndView mv = new JModelAndView("o2o/evaluate_list.html", configService.getSysConfig(), 1,
				request, response);

		GroupEvaluationVO vo = new GroupEvaluationVO();
		// 获取商户的商铺
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		vo.setStoreId(userDetails.getStoreId());
		if ("yes".equals(status)) {
			vo.setStatus(3);
		}
		if ("no".equals(status)) {
			vo.setStatus(2);
		}
		evaluationService.query(vo, page);
		page.setPageNumber(10);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("status", status);
		mv.addObject("orderFormTools", orderFormTools);
		mv.addObject("orderService", orderService);
		return mv;
	}

	@SecurityMapping(title = "评价详情", value = "/group/evaluate_info.htm*", rtype = "seller", rname = "卖家团购评价", rcode = "seller_group_evaluate", rgroup = "卖家团购评价")
	@RequestMapping("/group/evaluate_info.htm")
	public ModelAndView evaluate_info(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("o2o/evaluate_info.html", configService.getSysConfig(), 1,
				request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		GroupEvaluationBO evl = this.evaluationService.fetch(CommUtil.null2Long(id));
		if (evl != null) {
			if (userDetails.getStoreId() != null
					&& evl.getStoreId().toString().equals(userDetails.getStoreId().toString())) {
				mv.addObject("evl", evl);
			} else {
				mv.addObject("ret", 0);
			}

			mv.addObject("photos", evl.getPhotoUrls().split(";"));
		} else {
			mv.addObject("ret", 0);
		}
		return mv;
	}

	@SecurityMapping(title = "商品评价回复内容", value = "/group/evaluate_reply.htm*", rtype = "seller", rname = "卖家团购评价", rcode = "seller_group_evaluate", rgroup = "卖家团购评价")
	@RequestMapping("/group/evaluate_reply.htm")
	public ModelAndView evaluate_reply(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("o2o/evaluate_reply.html", configService.getSysConfig(), 1,
				request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		GroupEvaluationBO evl = this.evaluationService.fetch(CommUtil.null2Long(id));
		if (evl != null) {
			if (userDetails.getStoreId() != null
					&& evl.getStoreId().toString().equals(userDetails.getStoreId().toString())) {
				mv.addObject("evl", evl);
			} else {
				mv.addObject("ret", 0);
			}
		} else {
			mv.addObject("ret", 0);
		}
		mv.addObject("id", id);
		return mv;
	}

	@SecurityMapping(title = "商品评价回复保存", value = "/group/evaluate_reply_save.htm*", rtype = "seller", rname = "团购评价", rcode = "seller_group_evaluate", rgroup = "团购评价")
	@RequestMapping("/group/evaluate_reply_save.htm")
	@ResponseBody
	public String evaluate_reply_save(HttpServletRequest request, HttpServletResponse response, String id,
			String replyContent) {
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		response.setContentType("text/html;charset=UTF-8");
		Map<String, Object> resp = new HashMap<>();
		try {
			boolean b = evaluationService.reply(userDetails.getId(), CommUtil.null2Long(id), replyContent);
			resp.put("success", b);
		} catch (CheckException e) {
			resp.put("error", "参数有误");
		} catch (EvaluationContentSizeExcepiton e) {
			resp.put("error", "1~500字之间");
		}
		return JSON.toJSONString(resp);
	}

	@SecurityMapping(title = "订单评价", value = "/group/group_order_evaluation.htm*", rtype = "buyer", rname = "团购评价", rcode = "buyer_group_evaluate", rgroup = "团购评价")
	@RequestMapping("/group/group_order_evaluation.htm")
	public ModelAndView groupOrderEvaluation(long orderId, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("o2o/evaluate.html", configService.getSysConfig(), 1, request,
				response);
		GroupOrderBO order = orderService.getObjById(orderId);
		if (null == order || order.getOrderStatus() != 30) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "你无权访问！");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/group.htm?orderType=1");
			return mv;
		}
		mv.addObject("order", order);
		mv.addObject("orderFormTools", orderFormTools);
		mv.addObject("orderService", orderService);
		GroupEvaluationBO evaluationBO = evaluationService.fetch(orderId);
		if (null != evaluationBO) {
			if (evaluationBO.getStatus() != 1) {
				mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", "你无权访问！");
				mv.addObject("url", CommUtil.getURL(request) + "/buyer/group.htm?orderType=1");
				return mv;
			}

			mv.addObject("photoUrls", JSON.toJSONString(evaluationBO.getPhotoUrls()));
		} else
			mv.addObject("photoUrls", null);

		return mv;
	}

	@SecurityMapping(title = "评价商户服务页面", value = "/group/evaluation.htm*", rtype = "buyer", rname = "团购评价", rcode = "buyer_group_evaluate", rgroup = "团购评价")
	@RequestMapping(value = "/group/evaluation.html", method = RequestMethod.POST)
	@ResponseBody
	public String save(@RequestBody GroupEvaluation evaluation, HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		Map<String, Object> resp = new HashMap<>();
		try {
			WordFind wordFind = new WordFind("/dic/sensitive.dic", "sensitive");
			String[] words = wordFind.find(evaluation.getContent());
			if (words.length > 0) {
				resp.put("error", "评论不能包含敏感词汇！");
				return JSON.toJSONString(resp);
			}
			long currentUserId = SecurityUserHolder.getCurrentUserId();
			evaluation.setEvaluateUserId(currentUserId);
			boolean b = evaluationService.save(evaluation);
			resp.put("success", b);
			return JSON.toJSONString(resp);
		} catch (CheckException e) {
			resp.put("error", "请求参数有误！");
			return JSON.toJSONString(resp);
		} catch (EvaluationPhotoSizeExcepiton e) {
			resp.put("error", "最多上传6张图片");
			return JSON.toJSONString(resp);
		} catch (EvaluationContentSizeExcepiton e) {
			resp.put("error", "评论字数1~500");
			return JSON.toJSONString(resp);
		} catch (EvaluationScoreZeroException e) {
			resp.put("error", "评分项必填");
			return JSON.toJSONString(resp);
		}
	}

	@SecurityMapping(title = "上传评价图片", value = "/group/evaluation/upload.htm*", rtype = "buyer", rname = "团购评价", rcode = "buyer_group_evaluate", rgroup = "团购评价")
	@RequestMapping(value = "/group/evaluation/upload.html", method = RequestMethod.POST)
	@ResponseBody
	public String uploadPhotos(long orderId, String photoUrls, HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		Map<String, Object> resp = new HashMap<>();
		if (orderId < 1) {
			resp.put("error", "请检查提交的参数");
			return JSON.toJSONString(resp);
		}
		long currentUserId = SecurityUserHolder.getCurrentUserId();
		String photoUrl = accessoryService.upload(request, "myFile", null);
		if (Strings.isNullOrEmpty(photoUrl)) {
			resp.put("error", "上传图片失败");
			return JSON.toJSONString(resp);
		}

		photoUrls = Strings.isNullOrEmpty(photoUrls) ? photoUrl : photoUrls + ";" + photoUrl;
		try {
			boolean b = evaluationService.updatePhotos(currentUserId, orderId, photoUrls);
			resp.put("success", b);
			if (b) {
				resp.put("photoUrl", photoUrl);
			}
		} catch (CheckException e) {
			resp.put("error", "请检查提交的参数");
		} catch (EvaluationPhotoSizeExcepiton e) {
			resp.put("error", "最多上传6张图片");
		}
		return JSON.toJSONString(resp);
	}

	@SecurityMapping(title = "上传评价图片", value = "/group/evaluation/photos*", rtype = "buyer", rname = "团购评价", rcode = "buyer_group_evaluate", rgroup = "团购评价")
	@RequestMapping(value = "/group/evaluation/photos", method = RequestMethod.PUT)
	@ResponseBody
	public String deletePhotos(long orderId, @RequestBody JSONObject jsonStr, HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		String photoUrls = jsonStr.getString("photoUrls");
		long currentUserId = SecurityUserHolder.getCurrentUserId();
		Map<String, Object> resp = new HashMap<>();
		try {
			boolean b = evaluationService.updatePhotos(currentUserId, orderId, photoUrls);
			resp.put("success", b);
		} catch (CheckException e) {
			resp.put("error", "请检查提交的参数");
		} catch (EvaluationPhotoSizeExcepiton e) {
			resp.put("error", "最多上传6张图片");
		}
		return JSON.toJSONString(resp);
	}

}
