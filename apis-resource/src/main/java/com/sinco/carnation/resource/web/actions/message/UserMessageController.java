package com.sinco.carnation.resource.web.actions.message;

import java.util.List;

import javax.validation.Valid;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.util.MapperUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.resource.bo.message.APIMessageBO;
import com.sinco.carnation.resource.vo.message.MessageVO;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.response.message.UserMessageListResponse;
import com.sinco.carnation.resource.web.response.message.UserMessagedetailResponse;
import com.sinco.carnation.sys.bo.MessageBO;
import com.sinco.carnation.sys.contants.SysContants;
import com.sinco.carnation.sys.model.Message;
import com.sinco.carnation.sys.service.MessageService;
import com.sinco.dal.common.MyPage;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "用户消息中心", namespace = "userMessage")
public class UserMessageController extends BasicApiController {
	@Autowired
	private MessageService messageService;

	@Autowired
	private Mapper mapper;

	@RequestMapping(value = "/user/message/list", method = RequestMethod.POST)
	@MethodMapping(desc = "消息列表")
	public @ResponseBody
	UserMessageListResponse userMessageList(@Valid @ModelAttribute @Param MessageVO vo) {
		UserMessageListResponse response = new UserMessageListResponse();

		MyPage<MessageBO> page = new MyPage<MessageBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		Long uid = ActionsUtil.getOwnerUid();

		messageService.selectByUser(uid, vo.getType(), page);
		List<APIMessageBO> list = MapperUtils.map(mapper, page.getContent(), APIMessageBO.class);
		response.setMessages(list);//消息列表

		int unreadMessageNo = messageService.countByToUser(uid, SysContants.MESSAGE_STATUS_0); // 站内消息未读数量
		int readMessageNo = messageService.countByToUser(uid, SysContants.MESSAGE_STATUS_1); // 站内消息未读数量
		response.setUnreadMessageNo(unreadMessageNo);
		response.setReadMessageNo(readMessageNo);
		return response;
	}

	@RequestMapping(value = "/user/message/detail", method = RequestMethod.POST)
	@MethodMapping(desc = "消息详情")
	public @ResponseBody
	UserMessagedetailResponse userMessageDetail(
			@Valid @RequestParam(value = "id") @Param(desc = "消息id") Long id) {
		UserMessagedetailResponse response = new UserMessagedetailResponse();
		Message message = messageService.findOneByMesId(id);
		message.setStatus(SysContants.MESSAGE_STATUS_1);// 短信状态改成已读
		messageService.update(message);
		APIMessageBO messageBO = mapper.map(message, APIMessageBO.class);
		/*messageBO.setContent(JsoupUtils.queryHtml(messageBO.getContent()));*/
		response.setMessage(messageBO);// 消息列表

		return response;
	}

	/*	@RequestMapping(value = "", method = RequestMethod.POST)
		@MethodMapping(desc="用户成功创建，发送短信给推荐人")
		public @ResponseBody void userBuildMessage(){
			
		}*/
}
