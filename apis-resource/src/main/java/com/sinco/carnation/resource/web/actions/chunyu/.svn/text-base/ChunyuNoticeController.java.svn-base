package com.sinco.carnation.resource.web.actions.chunyu;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aliyun.oss.common.utils.IOUtils;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.api.util.ActionsUtil;
import com.sinco.carnation.resource.vo.chunyu.ProblemCloseNoticeVO;
import com.sinco.carnation.resource.vo.chunyu.ProblemReplyNoticeVO;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.response.chunyu.AccountSynResponse;
import com.sinco.carnation.resource.web.util.ChunyuSign;
import com.sinco.carnation.sys.service.NoticeMessageService;
import com.weixin.utils.HttpsRequest;

import vc.thinker.b2b2c.core.tools.CommUtil;

/**
 * 春雨医生消息通知处理类
 * @author tw
 *
 */
@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "春雨医生", namespace = "chunyu")
public class ChunyuNoticeController {
	private static final Logger LOG = LoggerFactory.getLogger(ChunyuNoticeController.class);
	@Autowired
	private NoticeMessageService noticeMessageService;
	private ObjectMapper mapper;
	
	public ChunyuNoticeController(){
		mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.setSerializationInclusion(Include.NON_EMPTY);
	}
	
	@RequestMapping(value = "/chunyu/account_syn", method = RequestMethod.POST)
	@MethodMapping(desc = "帐号同步")
	@ResponseBody
	public AccountSynResponse accountSyn(HttpServletRequest request) {
		Long uid = ActionsUtil.getOwnerUid();
		Long atime = System.currentTimeMillis() / 1000;
		AccountSynResponse response = new AccountSynResponse();
		response.setUserId(uid);
		response.setSign(ChunyuSign.getSign(atime, String.valueOf(uid)));
		response.setAtime(atime);
		response.setPartner(ChunyuSign.PARTNER);
		response.setSignUrl(ChunyuSign.LOGIN_URL + "?user_id=" + uid + "&atime=" + atime + "&partner=" + ChunyuSign.PARTNER + "&sign=" + response.getSign());
		response.setUrl(String.format(ChunyuSign.HOST_URL, ChunyuSign.PARTNER));
		response.setSessionid(HttpsRequest.getSessionid(response.getSignUrl()));
		LOG.info(response.getSessionid());
		return response;
	}
	
	@RequestMapping(value = "/chunyu/problem/reply_notice", method = RequestMethod.POST)
	@MethodMapping(desc = "回复通知")
	@ResponseBody
	public ApiResponse replyNotice(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String content = null;
		ProblemReplyNoticeVO vo = null;
		try {
			content = IOUtils.readStreamAsString(request.getInputStream(), "UTF-8");
			vo = mapper.readValue(content, ProblemReplyNoticeVO.class);
			LOG.info("收到春雨医生回复通知：" + content);
		} catch (IOException e) {
			LOG.error("春雨医生问题回复通知-数据解析失败", e);
		}
		if(vo != null){
			boolean flag = ChunyuSign.verifySign(vo.getAtime(), vo.getProblem_id(), vo.getSign());
			if(flag){
				Long uid = CommUtil.null2Long(vo.getUser_id());
				String title = "『春雨医生』问题回复通知";
				String message = "您咨询的问题，专家已为您解答，立即查看！";
				String url = String.format(ChunyuSign.PROBLEM_URL, ChunyuSign.PARTNER, vo.getProblem_id());
				noticeMessageService.pushProblemReplyMessage(uid, title, message, url);
			}else{
				LOG.warn("春雨医生问题回复通知签名失败：" + content);
			}
		}
		response.getWriter().write("{\"error\": 0}");
		return null;
	}
	
	@RequestMapping(value = "/chunyu/problem/close_notice", method = RequestMethod.POST)
	@MethodMapping(desc = "关闭通知")
	@ResponseBody
	public ApiResponse closeNotice(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String content = null;
		ProblemCloseNoticeVO vo = null;
		try {
			content = IOUtils.readStreamAsString(request.getInputStream(), "UTF-8");
			vo = mapper.readValue(content, ProblemCloseNoticeVO.class);
			LOG.info("收到春雨医生关闭通知：" + content);
		} catch (IOException e) {
			LOG.error("春雨医生问题关闭通知-数据解析失败", e);
		}
		if(vo != null){
			boolean flag = ChunyuSign.verifySign(vo.getAtime(), vo.getProblem_id(), vo.getSign());
			if(flag){
				Long uid = CommUtil.null2Long(vo.getUser_id());
				if("refund".equals(vo.getStatus())){
					String title = "『春雨医生』问题退款通知";
					String message = "您咨询付款问题已退款，立即查看！";
					String url = String.format(ChunyuSign.HOST_URL, ChunyuSign.PARTNER);
					noticeMessageService.pushProblemCloseMessage(uid, title, message, url);
				}else{
					String title = "『春雨医生』问题关闭通知";
					String message = "专家关闭您咨询的问题，立即查看！";
					String url = String.format(ChunyuSign.PROBLEM_URL, ChunyuSign.PARTNER, vo.getProblem_id());
					noticeMessageService.pushProblemCloseMessage(uid, title, message, url);
				}
			}else{
				LOG.warn("春雨医生问题关闭通知签名失败：" + content);
			}
		}
		response.getWriter().write("{\"error\": 0}");
		return null;
	}
	
}
