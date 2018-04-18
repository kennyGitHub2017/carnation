package com.sinco.carnation.resource.web.actions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.dozer.Mapper;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.util.MapperUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.o2o.bo.GroupComplaintBO;
import com.sinco.carnation.o2o.service.GroupComplaintService;
import com.sinco.carnation.resource.bo.groupComplaint.GroupComplaintsBO;
import com.sinco.carnation.resource.vo.groupComplaint.GroupComplaintVO;
import com.sinco.carnation.resource.vo.groupComplaint.GroupComplaintsDetailsVO;
import com.sinco.carnation.resource.vo.o2o.ComplaintHandlerVO;
import com.sinco.carnation.resource.web.response.groupComplaint.GroupComplaintResponse;
import com.sinco.dal.common.MyPage;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "运营商投诉列表", namespace = "complaints")
public class GroupComplaintController extends BasicApiController {

	@Autowired
	private GroupComplaintService groupComplaintService;

	@Autowired
	private Mapper mapper;

	/**
	 * 
	 * 我的运营商投诉列表
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/complaints/users/list", method = RequestMethod.POST)
	@MethodMapping(desc = "我的投诉列表/加名称搜索")
	public @ResponseBody
	GroupComplaintResponse checkReportOfSelfList(@Valid @ModelAttribute @Param GroupComplaintVO vo,
			BindingResult result, HttpServletRequest request) {
		GroupComplaintResponse response = new GroupComplaintResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		Long uid = ActionsUtil.getOwnerUid();
		MyPage<GroupComplaintBO> page = new MyPage<GroupComplaintBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		groupComplaintService.groupComplaintList(vo.getStatus(), vo.getName(), uid, page);
		if (null != page.getContent() && page.getContent().size() > 0) {
			List<GroupComplaintsBO> groupComplaintBOs = MapperUtils.map(mapper, page.getContent(),
					GroupComplaintsBO.class);
			response.setGroupComplaintBOs(groupComplaintBOs);
			// 设置总记录数
			response.setTotalCount(page.getTotalElements());

			return response;
		}
		response.setTotalCount(0L);
		return response;
	}

	/**
	 * 
	 * 我的运营商投诉列表明细
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/complaints/users/details", method = RequestMethod.POST)
	@MethodMapping(desc = "我的投诉明细")
	public @ResponseBody
	GroupComplaintResponse checkReportOfSelfDetails(
			@Valid @ModelAttribute @Param GroupComplaintsDetailsVO vo, BindingResult result,
			HttpServletRequest request) {
		GroupComplaintResponse response = new GroupComplaintResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		GroupComplaintBO groupComplaintDetails = groupComplaintService.groupComplaintDetails(vo.getId());

		GroupComplaintsBO details = mapper.map(groupComplaintDetails, GroupComplaintsBO.class);
		if (details != null) {
			// 设置投诉证据数组
			List<String> list = new ArrayList<String>();
			if (null != details.getFromAcc1()) {
				list.add(details.getFromAcc1());
			} else if (null != details.getFromAcc2()) {
				list.add(details.getFromAcc2());
			} else if (null != details.getFromAcc3()) {
				list.add(details.getFromAcc3());
			}

			details.setFromAccArry(list);
			if (groupComplaintDetails.getGroupInfo() != null
					&& groupComplaintDetails.getGroupInfo().length() > 0) {
				Map map = Json.fromJson(HashMap.class, groupComplaintDetails.getGroupInfo());
				if (null != map) {
					details.setGroupName(map.get("goods_name").toString());
					details.setGroupPhoto(map.get("goods_mainphoto_path").toString());
					details.setPrice(new BigDecimal(CommUtil.null2Int(map.get("goods_price"))));
				}
			}
		}
		response.setGroupComplaintsBO(details);
		return response;
	}

	@RequestMapping(value = "/complaints/handler", method = RequestMethod.POST)
	@MethodMapping(desc = "营运商投诉处理")
	public @ResponseBody
	GroupComplaintResponse handleIdea(@Valid @ModelAttribute @Param ComplaintHandlerVO vo,
			BindingResult result) {
		GroupComplaintResponse response = new GroupComplaintResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		GroupComplaintBO gBo = groupComplaintService.getObject(vo.getId());
		if (gBo != null) {
			gBo.setStatus(3);
			gBo.setHandleContent(vo.getResult());
			groupComplaintService.save(gBo);
		}
		return response;
	}

}
