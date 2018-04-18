package vc.thinker.b2b2c.action.market;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.carnation.market.bo.MsgInfoBO;
import com.sinco.carnation.market.enums.EmReceiveLocation;
import com.sinco.carnation.market.enums.EmReceiveType;
import com.sinco.carnation.market.enums.EmSendStatus;
import com.sinco.carnation.market.enums.EnumUtil;
import com.sinco.carnation.market.service.MsgInfoService;
import com.sinco.carnation.market.vo.MsgInfoVO;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.common.utils.StringUtils;
import com.sinco.dal.common.MyPage;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

@Controller
public class MessageAction extends BaseAction {

	@Autowired
	private MsgInfoService msgInfoService;

	@SecurityMapping(title = "消息列表", value = "/admin/message_list.htm*", rtype = "admin", rname = "消息管理", rcode = "message_admin", rgroup = "内容管理")
	@RequestMapping("/admin/message_list.htm")
	public ModelAndView message_list(HttpServletRequest request, HttpServletResponse response, MsgInfoVO vo,
			MyPage<MsgInfoBO> myPage) {
		ModelAndView mv = new JModelAndView("admin/blue/message/message_list.html",
				configService.getSysConfig(), 0, request, response);

		System.out.println(String.format("getPageSize:%s getPageNumber:%s", myPage.getPageSize(),
				myPage.getPageNumber()));

		this.getRedPackageDefaultVo(vo);
		mv.addObject("vo", vo);

		this.msgInfoService.findListByVo(vo, myPage);
		CommUtil.saveIPageList2ModelAndView("", "", "", myPage, mv);

		this.getMsgInfoEmMap(mv, true);

		return mv;
	}

	/**
	 * 获取枚举类型的Map
	 * 
	 * @param mv
	 * @param addDefaultValue
	 *            是否添加默认值
	 */
	private void getMsgInfoEmMap(ModelAndView mv, boolean addDefaultValue) {

		if (addDefaultValue) {
			mv.addObject("receiveLocationMap", EmReceiveLocation.GetMap(EnumUtil.NewEnumMap("发送位置")));
			mv.addObject("receiveTypeMap", EmReceiveType.GetMap(EnumUtil.NewEnumMap("接收类型")));
			mv.addObject("sendStatusMap", EmSendStatus.GetMap(EnumUtil.NewEnumMap("发送状态")));
		} else {
			mv.addObject("receiveLocationMap", EmReceiveLocation.GetMap(null));
			mv.addObject("receiveTypeMap", EmReceiveType.GetMap(null));
			mv.addObject("sendStatusMap", EmSendStatus.GetMap(null));
		}
	}

	/**
	 * 默认初始化条件
	 * 
	 * @param vo
	 */
	private void getRedPackageDefaultVo(MsgInfoVO vo) {
		if (vo.getReceiveLocation() == null) {
			vo.setReceiveLocation(CommUtil.null2Long(EnumUtil.NEW_ENUM_INT));
		}
		if (vo.getReceiveType() == null) {
			vo.setReceiveType((byte) EnumUtil.NEW_ENUM_INT.intValue());
		}
		if (vo.getSendStatus() == null) {
			vo.setSendStatus(CommUtil.null2Long(EnumUtil.NEW_ENUM_INT));
		}
		if (vo.getTopIndex() == null) {
			vo.setTopIndex(-1);
		}
		// if (!CommUtil.isNotNull(vo.getStartTimeStr())) {
		// vo.setStartTimeStr(CommUtil.formatShortDate(CommUtil.getFirstDateOfCurrentMonth()));
		// }
		// if (!CommUtil.isNotNull(vo.getEndTimeStr())) {
		// vo.setEndTimeStr(CommUtil.formatShortDate(CommUtil.getLastDateOfCurrentMonth()));
		// }
	}

	@SecurityMapping(title = "消息新增", value = "/admin/message_add.htm*", rtype = "admin", rname = "消息管理", rcode = "message_admin", rgroup = "内容管理")
	@RequestMapping("/admin/message_add.htm")
	public ModelAndView message_add(HttpServletRequest request, HttpServletResponse response, Long id) {
		ModelAndView mv = new JModelAndView("admin/blue/message/message_add.html",
				configService.getSysConfig(), 0, request, response);

		this.getMsgInfoEmMap(mv, false);
		MsgInfoBO bo = null;
		if (id == null || id < 1) {
			bo = new MsgInfoBO();
			bo.setReceiveLocation(CommUtil.null2Long(EmReceiveLocation.YesApp.getValue()));
			bo.setReceiveType((byte) EmReceiveType.ReadOnly.getValue());
			bo.setPriority(1);
		} else {
			bo = this.msgInfoService.findOne(id);
		}

		mv.addObject("obj", bo);
		return mv;
	}

	@SecurityMapping(title = "消息保存", value = "/admin/message_save.htm*", rtype = "admin", rname = "消息管理", rcode = "message_admin", rgroup = "内容管理")
	@RequestMapping("/admin/message_save.htm")
	public ModelAndView message_save(HttpServletRequest request, HttpServletResponse response, MsgInfoVO vo) {
		save(vo);
		return new ModelAndView("redirect:/admin/message_list.htm");
	}

	private void save(MsgInfoVO vo) {
		vo.setCreateBy(SecurityUserHolder.getCurrentUserDetails().getId());
		this.msgInfoService.save(vo);
	}

	@SecurityMapping(title = "消息发送", value = "/admin/message_send.htm*", rtype = "admin", rname = "消息管理", rcode = "message_admin", rgroup = "内容管理")
	@RequestMapping("/admin/message_send.htm")
	public ModelAndView message_send(HttpServletRequest request, HttpServletResponse response, String id) {
		if (id != null) {
			String err = this.msgInfoService.sendMsg(id);

			if (StringUtils.isNotBlank(err)) {
				return super.returnError(err, request, response);
			}
		}
		return new ModelAndView("redirect:/admin/message_list.htm");
	}

	@SecurityMapping(title = "消息置顶", value = "/admin/message_go_top.htm*", rtype = "admin", rname = "消息管理", rcode = "message_admin", rgroup = "内容管理")
	@RequestMapping("/admin/message_go_top.htm")
	public ModelAndView message_go_top(HttpServletRequest request, HttpServletResponse response, String id,
			int topIndex) {
		if (id != null) {
			this.msgInfoService.goTop(id, topIndex == 1);
		}
		return new ModelAndView("redirect:/admin/message_list.htm");
	}

	@Autowired
	private AccessoryServiceImpl accessoryService;

	@RequestMapping("/admin/img_replace_aaaa.htm")
	public ModelAndView img_replace_aaaa(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new JModelAndView("admin/blue/img_replace.html", configService.getSysConfig(), 0,
				request, response);
		return mv;
	}

	@RequestMapping("/admin/img_replace_save.htm")
	public void img_replace_save(HttpServletRequest request, HttpServletResponse response, String imagePath) {
		if (SecurityUserHolder.getCurrentUserDetails().getUsername().equalsIgnoreCase("admin")) {
			String url = this.accessoryService.uploadReplace(request, "imgNew", imagePath);
			CommUtil.returnBody(response, url);
		} else {
			CommUtil.returnBody(response, "admin 才能操作！");
		}
	}
}
