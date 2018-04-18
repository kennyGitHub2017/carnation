package com.sinco.carnation.resource.web.actions;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.util.MapperUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.check.service.CheckResultService;
import com.sinco.carnation.resource.bo.check.CheckReportBO;
import com.sinco.carnation.resource.bo.check.ResultDetailsBO;
import com.sinco.carnation.resource.bo.check.ResultGroupBO;
import com.sinco.carnation.resource.bo.check.ResultItemBO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;
import com.sinco.carnation.resource.vo.ReportReplyDetailsVO;
import com.sinco.carnation.resource.vo.check.CheckReportVO;
import com.sinco.carnation.resource.vo.check.ReportAddVO;
import com.sinco.carnation.resource.vo.check.ResultClassVO;
import com.sinco.carnation.resource.vo.check.ResultDetailsUpdateVO;
import com.sinco.carnation.resource.vo.check.ResultDetailsVO;
import com.sinco.carnation.resource.vo.check.ResultItemSaveVO;
import com.sinco.carnation.resource.web.response.check.CheckReportResponse;
import com.sinco.carnation.sns.bo.CheckResultDetailsBO;
import com.sinco.carnation.sns.bo.CheckResultGroupBO;
import com.sinco.carnation.sns.bo.CheckResultItemBO;
import com.sinco.carnation.sns.bo.CheckResultReplyBO;
import com.sinco.carnation.sns.model.CheckResultDetails;
import com.sinco.carnation.sns.model.CheckResultReply;
import com.sinco.carnation.user.service.CheckReportService;
import com.sinco.dal.common.MyPage;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "体检报告", namespace = "report")
public class CheckReportControl extends BasicApiController {

	@Autowired
	private CheckReportService reportService;

	@Autowired
	private CheckResultService checkResultServer;

	@Autowired
	private Mapper mapper;

	@RequestMapping(value = "/report/add", method = RequestMethod.POST)
	@MethodMapping(desc = "添加报告")
	public @ResponseBody
	CheckReportResponse addCheckReport(@Valid @ModelAttribute @Param ReportAddVO vo, BindingResult result,
			HttpServletRequest request) {
		CheckReportResponse response = new CheckReportResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		Long uid = ActionsUtil.getOwnerUid();

		CheckResultReply resultReply = new CheckResultReply();
		resultReply.setCreateBy(uid);
		resultReply.setCreateTime(new Date());
		resultReply.setHospital(vo.getHospital());
		resultReply.setStatus(1);
		resultReply.setResultName(vo.getReportName());
		resultReply.setId(vo.getReplyId());
		resultReply.setCheckTime(CommUtil.formatDate(vo.getTime()));
		CheckResultReply reply = checkResultServer.resultReplySave(resultReply);
		if (reply != null) {
			CheckReportBO report = new CheckReportBO();
			report.setId(reply.getId());
			report.setCreatetime(reply.getCreateTime());
			report.setResultname(reply.getResultName());
			report.setStatus(reply.getStatus());
			report.setCheckTime(reply.getCheckTime());
			response.setReport(report);
		}
		return response;
	}

	@RequestMapping(value = "/report/result_class/list", method = RequestMethod.POST)
	@MethodMapping(desc = "体检报告分类列表")
	public @ResponseBody
	CheckReportResponse checkResultClassList(
			@Valid @RequestParam(value = "id", required = false) @Param(desc = "id|查询分类列表时不用传值，查询体检项列表时传分类id,常用传-1") Long id,
			HttpServletRequest request) {
		CheckReportResponse response = new CheckReportResponse();

		// 分类列表
		if (id == null) {
			List<CheckResultGroupBO> groupBOs = checkResultServer.queryCheckResultGroupList();
			if (groupBOs != null) {
				CheckResultGroupBO resultGroupBO = new CheckResultGroupBO();
				resultGroupBO.setCreateTime(new Date());
				resultGroupBO.setGroupName("常用检查");
				resultGroupBO.setId(-1l);
				groupBOs.add(0, resultGroupBO);
				List<ResultGroupBO> result = MapperUtils.map(mapper, groupBOs, ResultGroupBO.class);
				response.setResultGroupBOs(result);
				return response;
			}
		}
		// 常用体检项
		if (id == -1) {
			List<CheckResultItemBO> resultItemBO = checkResultServer.queryResultByUsing(0L);
			if (resultItemBO != null) {
				List<ResultItemBO> resultItemBOs = MapperUtils.map(mapper, resultItemBO, ResultItemBO.class);
				response.setUsingResultItemBOs(resultItemBOs);
				return response;
			}
		} else {
			List<CheckResultItemBO> resultItemBOs = checkResultServer.queryResultByGroupId(id);
			if (resultItemBOs != null) {
				List<ResultItemBO> resultItemBO = MapperUtils.map(mapper, resultItemBOs, ResultItemBO.class);
				response.setResultItemBOs(resultItemBO);
				return response;
			}
		}

		return response;
	}

	/**
	 * 
	 * 我的体检报告列表
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/report/check/list", method = RequestMethod.POST)
	@MethodMapping(desc = "我的体检报告列表")
	public @ResponseBody
	CheckReportResponse checkReportOfSelfList(@Valid @ModelAttribute @Param CheckReportVO vo,
			BindingResult result, HttpServletRequest request) {
		CheckReportResponse response = new CheckReportResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		Long uid = ActionsUtil.getOwnerUid();
		MyPage<CheckResultReplyBO> page = new MyPage<CheckResultReplyBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		reportService.checkReportList(uid, page);
		if (null != page.getContent() && page.getContent().size() > 0) {
			List<CheckReportBO> ckeckReportBOs = MapperUtils.map(mapper, page.getContent(),
					CheckReportBO.class);
			response.setCircle(ckeckReportBOs);
			// 设置总记录数
			response.setTotalCount(page.getTotalElements());

			return response;
		}
		response.setTotalCount(0L);
		return response;
	}

	@RequestMapping(value = "/report/result/details", method = RequestMethod.POST)
	@MethodMapping(desc = "报告明细")
	public @ResponseBody
	CheckReportResponse resultDetails(@Valid @ModelAttribute @Param ResultDetailsVO vo, BindingResult result,
			HttpServletRequest request) {
		CheckReportResponse response = new CheckReportResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		MyPage<CheckResultDetailsBO> page = new MyPage<CheckResultDetailsBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		CheckResultReplyBO replyBO = checkResultServer.get(vo.getId());
		if (replyBO != null) {
			CheckReportBO reportBOs = mapper.map(replyBO, CheckReportBO.class);
			checkResultServer.queryResultDetailsList(vo.getId(), page);
			if (page != null) {
				// 设置体检项
				List<ResultDetailsBO> detailsBOs = MapperUtils.map(mapper, page.getContent(),
						ResultDetailsBO.class);
				reportBOs.setDetailsList(detailsBOs);
			}
			int successCount = checkResultServer.queryResultStatusCount(replyBO.getId(), 0);// 正确项
			int wrongCount = checkResultServer.queryResultStatusCount(replyBO.getId(), 1);// 超标项
			reportBOs.setRightCount(successCount);
			reportBOs.setWrongCount(wrongCount);
			response.setReport(reportBOs);
		}

		return response;
	}

	@RequestMapping(value = "/report/item", method = RequestMethod.POST)
	@MethodMapping(desc = "查询体检项信息")
	public @ResponseBody
	CheckReportResponse resultItem(@Valid @RequestParam(value = "id") @Param(desc = "体检项id") Long id,
			HttpServletRequest request) {
		CheckReportResponse response = new CheckReportResponse();
		if (id == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}

		CheckResultItemBO itemBO = checkResultServer.queryResultItemById(id);
		if (itemBO != null) {
			ResultItemBO reBo = mapper.map(itemBO, ResultItemBO.class);
			if (itemBO.getType() == 0) {
				if (StringUtils.isNotBlank(itemBO.getMaxValue())
						&& StringUtils.isNotBlank(itemBO.getMinValue())) {
					reBo.setValue(itemBO.getMinValue() + "-" + itemBO.getMaxValue() + "/" + itemBO.getUnit());
				} else if (StringUtils.isNotBlank(itemBO.getMaxValue())) {
					reBo.setValue(itemBO.getMaxValue());
				} else if (StringUtils.isNotBlank(itemBO.getMinValue())) {
					reBo.setValue(itemBO.getMinValue());
				}
			}
			response.setResultItem(reBo);
			return response;
		}
		return response;
	}

	@RequestMapping(value = "/report/result_details/save", method = RequestMethod.POST)
	@MethodMapping(desc = "添加体检项目")
	public @ResponseBody
	CheckReportResponse saveResultDetails(@Valid @ModelAttribute @Param ResultItemSaveVO vo,
			BindingResult result, HttpServletRequest request) {
		CheckReportResponse response = new CheckReportResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		// getDetailsId不为空，则修改体检项
		if (vo.getDetailsId() != null) {
			CheckResultDetailsBO details = checkResultServer.queryCheckResultDetails(vo.getDetailsId());
			if (details.getType() == 0) {
				details.setReferenceValue(CommUtil.null2String(vo.getValue()));
				if (StringUtils.isNotBlank(details.getMaxValue())
						&& StringUtils.isNotBlank(details.getMinVale())) {
					if (CommUtil.null2Int(details.getMinVale()) <= vo.getValue()
							&& vo.getValue() <= CommUtil.null2Int(details.getMaxValue())) {
						details.setResult("0");// 正常
					} else {
						details.setResult("1");// 超标
					}
				} else {
					if (StringUtils.isNotBlank(details.getMaxValue())) {
						if (vo.getValue() <= CommUtil.null2Int(details.getMaxValue())) {
							details.setResult("0");// 正常
						} else {
							details.setResult("1");// 超标
						}

					} else if (StringUtils.isNotBlank(details.getMinVale())) {
						if (vo.getValue() >= CommUtil.null2Int(details.getMinVale())) {
							details.setResult("0");// 正常
						} else {
							details.setResult("1");// 超标
						}
					}
				}
				checkResultServer.savaResultDetails(details, vo.getReplyId());
			} else if (details.getType() == 1) {
				details.setReferenceValue(CommUtil.null2String(vo.getValue()));
				if (CommUtil.null2Int(details.getPositive()) == vo.getValue()) {
					details.setResult("0");// 正常
				} else {
					details.setResult("1");// 超标
				}
				checkResultServer.savaResultDetails(details, vo.getReplyId());
			}

		} else {
			CheckResultItemBO itemBO = checkResultServer.queryResultItemById(vo.getItemId());
			if (itemBO != null) {
				CheckResultDetails details = new CheckResultDetails();
				details.setPhysicalName(itemBO.getItemName());
				details.setReplyId(vo.getReplyId());
				details.setType(itemBO.getType());
				details.setUnit(itemBO.getUnit());
				// 录入数值
				if (itemBO.getType() == 0) {
					details.setMaxValue(itemBO.getMaxValue());
					details.setMinVale(itemBO.getMinValue());
					details.setReferenceValue(CommUtil.null2String(vo.getValue()));
					if (StringUtils.isNotBlank(itemBO.getMaxValue())
							&& StringUtils.isNotBlank(itemBO.getMinValue())) {
						if (CommUtil.null2Int(itemBO.getMinValue()) <= vo.getValue()
								&& vo.getValue() <= CommUtil.null2Int(itemBO.getMaxValue())) {
							details.setResult("0");// 正常
						} else {
							details.setResult("1");// 超标
						}
					} else {
						if (StringUtils.isNotBlank(itemBO.getMaxValue())) {
							if (vo.getValue() <= CommUtil.null2Int(itemBO.getMaxValue())) {
								details.setResult("0");// 正常
							} else {
								details.setResult("1");// 超标
							}

						} else if (StringUtils.isNotBlank(itemBO.getMinValue())) {
							if (vo.getValue() >= CommUtil.null2Int(itemBO.getMinValue())) {
								details.setResult("0");// 正常
							} else {
								details.setResult("1");// 超标
							}
						}
					}
					checkResultServer.savaResultDetails(details, null);
					// 选项型|阴，阳
				} else if (itemBO.getType() == 1) {
					details.setReferenceValue(CommUtil.null2String(vo.getValue()));
					details.setPositive(CommUtil.null2String(itemBO.getReferenceValue()));
					if (CommUtil.null2Int(itemBO.getReferenceValue()) == vo.getValue()) {
						details.setResult("0");// 正常
					} else {
						details.setResult("1");// 超标
					}
					checkResultServer.savaResultDetails(details, null);
				}
			}
		}
		return response;
	}

	@RequestMapping(value = "/report/result_details/update", method = RequestMethod.POST)
	@MethodMapping(desc = "修改体检项")
	public @ResponseBody
	CheckReportResponse updateCheckResultDetals(@Valid @ModelAttribute @Param ResultDetailsUpdateVO vo,
			BindingResult result, HttpServletRequest request) {
		CheckReportResponse response = new CheckReportResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		CheckResultReplyBO reply = checkResultServer.get(vo.getReplyId());
		reply.setStatus(2);
		reply.setCreateTime(new Date());
		checkResultServer.resultReplySave(reply);
		return response;
	}

	@RequestMapping(value = "/report/details", method = RequestMethod.POST)
	@MethodMapping(desc = "用户体检项明细")
	public @ResponseBody
	CheckReportResponse details(@Valid @RequestParam(value = "id") @Param(desc = "体检明细id") Long id) {
		CheckReportResponse response = new CheckReportResponse();
		if (id == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		CheckResultDetailsBO check = checkResultServer.queryCheckResultDetails(id);
		if (check != null) {
			ResultDetailsBO detailsBO = mapper.map(check, ResultDetailsBO.class);
			if (detailsBO.getType() == 0) {
				if (StringUtils.isNotBlank(detailsBO.getMaxValue())
						&& StringUtils.isNotBlank(detailsBO.getMinVale())) {
					detailsBO.setValue(detailsBO.getMinVale() + "-" + detailsBO.getMaxValue() + "/"
							+ detailsBO.getUnit());
				} else if (StringUtils.isNotBlank(detailsBO.getMaxValue())) {
					detailsBO.setValue(detailsBO.getMaxValue());
				} else if (StringUtils.isNotBlank(detailsBO.getMinVale())) {
					detailsBO.setValue(detailsBO.getMinVale());
				}
			} else {
				detailsBO.setValue(detailsBO.getPositive());
			}

			response.setUserDetails(detailsBO);
		}
		return response;
	}

	@RequestMapping(value = "/report/search", method = RequestMethod.POST)
	@MethodMapping(desc = "搜索")
	public @ResponseBody
	CheckReportResponse search(@Valid @ModelAttribute @Param ResultClassVO vo, BindingResult result) {
		CheckReportResponse response = new CheckReportResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		List<CheckResultItemBO> list = checkResultServer.queryItemSearch(vo.getName());
		List<ResultItemBO> itemBOs = MapperUtils.map(mapper, list, ResultItemBO.class);
		response.setResultItemBOs(itemBOs);
		return response;
	}

	@RequestMapping(value = "/report/rep/details", method = RequestMethod.POST)
	@MethodMapping(desc = "报告信息")
	public @ResponseBody
	CheckReportResponse search(@Valid @ModelAttribute @Param ReportReplyDetailsVO vo, BindingResult result) {
		CheckReportResponse response = new CheckReportResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		CheckResultReplyBO replyBO = checkResultServer.queryReplyDetails(vo.getId());
		if (replyBO != null) {
			CheckReportBO reportBO = mapper.map(replyBO, CheckReportBO.class);
			response.setReport(reportBO);
			return response;
		}
		return response;
	}

}
