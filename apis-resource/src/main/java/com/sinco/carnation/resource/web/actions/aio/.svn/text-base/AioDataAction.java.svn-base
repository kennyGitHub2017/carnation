package com.sinco.carnation.resource.web.actions.aio;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.dozer.Mapper;
import org.nlpcn.commons.lang.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.api.util.MapperUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.aio.model.AioBinding;
import com.sinco.carnation.aio.model.AioUserLog;
import com.sinco.carnation.aio.model.Chol;
import com.sinco.carnation.aio.model.Ecg;
import com.sinco.carnation.aio.model.Glu;
import com.sinco.carnation.aio.model.Spo;
import com.sinco.carnation.aio.model.SysDia;
import com.sinco.carnation.aio.model.Tp;
import com.sinco.carnation.aio.model.Ua;
import com.sinco.carnation.aio.service.AioBindingService;
import com.sinco.carnation.aio.service.AioDataService;
import com.sinco.carnation.resource.bo.aio.AioDataMO;
import com.sinco.carnation.resource.bo.aio.CholMO;
import com.sinco.carnation.resource.bo.aio.EcgMO;
import com.sinco.carnation.resource.bo.aio.GluMO;
import com.sinco.carnation.resource.bo.aio.SpoMO;
import com.sinco.carnation.resource.bo.aio.SysDiaMO;
import com.sinco.carnation.resource.bo.aio.TpMO;
import com.sinco.carnation.resource.bo.aio.UaMO;
import com.sinco.carnation.resource.constant.AioDataConstant;
import com.sinco.carnation.resource.constant.ResultCodeConstant;
import com.sinco.carnation.resource.constant.ResultMsgConstant;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.response.aio.AioCholResponse;
import com.sinco.carnation.resource.web.response.aio.AioDataResponse;
import com.sinco.carnation.resource.web.response.aio.AioEcgResponse;
import com.sinco.carnation.resource.web.response.aio.AioGluResponse;
import com.sinco.carnation.resource.web.response.aio.AioSpoResponse;
import com.sinco.carnation.resource.web.response.aio.AioSysDiaResponse;
import com.sinco.carnation.resource.web.response.aio.AioTpResponse;
import com.sinco.carnation.resource.web.response.aio.AioUaResponse;
import com.sinco.carnation.resource.web.util.AnalysisCodeUtil;
import com.sinco.dal.common.MyPage;

/**
 * 健康一体机数据
 * 
 * @author yuanmin.feng
 */
@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "健康一体机数据", namespace = "aioData")
public class AioDataAction extends BasicApiController {

	@Autowired
	private AioDataService aioDataService;

	@Autowired
	private AioBindingService aioBindingService;

	@Autowired
	private Mapper mapper;

	/**
	 * 获取健康一体机数据
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/get/aio/data", method = RequestMethod.POST)
	@MethodMapping(desc = "获取健康一体机数据")
	@ResponseBody
	public AioDataResponse getAioDataList(HttpServletRequest request, String time) {

		AioDataResponse response = new AioDataResponse();
		AioBinding aioBinding = getAioBinding();
		if (null == aioBinding) {
			response.setM_status(ResultCodeConstant.ERROR_STATUS);
			response.setM_errorCode(ResultCodeConstant.NOT_BINDING_ID_CARD);
			response.setM_errorMsg(ResultMsgConstant.NOT_BINDING_ID_CARD);
			return response;
		}
		if (StringUtil.isBlank(time)) {
			// 获取用户最后一条一体机数据日志
			AioUserLog aioUserLog = aioDataService.getLatestDataByUserLog(aioBinding.getIdCard());
			if (null == aioUserLog) {
				response.setM_status(ResultCodeConstant.ERROR_STATUS);
				response.setM_errorCode(ResultCodeConstant.NOT_AIO_DATA);
				response.setM_errorMsg(ResultMsgConstant.NOT_AIO_DATA);
				return response;
			}
			time = CommUtil.convertDateToString(CommUtil.formatDate(aioUserLog.getTime()));
		}
		AioDataMO aioDataMO = new AioDataMO();
		aioDataMO.setTime(time);
		// 获取胆固醇值
		MyPage<Chol> pageChol = new MyPage<Chol>();
		pageChol.setPageNumber(1);
		pageChol.setPageSize(1);
		List<Chol> chols = aioDataService.getCholList(pageChol, aioBinding.getIdCard(),
				CommUtil.formatDate(time));
		if (null != chols && chols.size() > 0) {
			aioDataMO.setChol(chols.get(0).getChol());
		}
		// 获取心率值
		MyPage<Ecg> pageEcg = new MyPage<Ecg>();
		pageEcg.setPageNumber(1);
		pageEcg.setPageSize(1);
		List<Ecg> ecgs = aioDataService
				.getEcgList(pageEcg, aioBinding.getIdCard(), CommUtil.formatDate(time));
		if (null != ecgs && ecgs.size() > 0) {
			aioDataMO.setHr(ecgs.get(0).getHr());
		}
		// 获取血糖值
		MyPage<Glu> pageGlu = new MyPage<Glu>();
		pageGlu.setPageNumber(1);
		pageGlu.setPageSize(1);
		List<Glu> glus = aioDataService
				.getGluList(pageGlu, aioBinding.getIdCard(), CommUtil.formatDate(time));
		if (null != glus && glus.size() > 0) {
			aioDataMO.setGlu(glus.get(0).getGlu());
			aioDataMO.setFlag(getFlagMessage(glus.get(0).getFlag()));
		}
		// 获取血氧值
		MyPage<Spo> pageSpo = new MyPage<Spo>();
		pageSpo.setPageNumber(1);
		pageSpo.setPageSize(1);
		List<Spo> spos = aioDataService
				.getSpoList(pageSpo, aioBinding.getIdCard(), CommUtil.formatDate(time));
		if (null != spos && spos.size() > 0) {
			aioDataMO.setSpo(spos.get(0).getSpo());
			aioDataMO.setSpoPr(spos.get(0).getPr());
		}
		// 获取血压值
		MyPage<SysDia> pageSysDia = new MyPage<SysDia>();
		pageSysDia.setPageNumber(1);
		pageSysDia.setPageSize(1);
		List<SysDia> sysDias = aioDataService.getSysDiaList(pageSysDia, aioBinding.getIdCard(),
				CommUtil.formatDate(time));
		if (null != sysDias && sysDias.size() > 0) {
			aioDataMO.setSysDia(sysDias.get(0).getSysDia());
			aioDataMO.setSysDiaPr(sysDias.get(0).getPr());
		}
		// 获取体温值
		MyPage<Tp> pageTp = new MyPage<Tp>();
		pageTp.setPageNumber(1);
		pageTp.setPageSize(1);
		List<Tp> tps = aioDataService.getTpList(pageTp, aioBinding.getIdCard(), CommUtil.formatDate(time));
		if (null != tps && tps.size() > 0) {
			aioDataMO.setTp(tps.get(0).getTp());
		}
		// 获取尿酸值
		MyPage<Ua> pageUa = new MyPage<Ua>();
		pageUa.setPageNumber(1);
		pageUa.setPageSize(1);
		List<Ua> uas = aioDataService.getUaList(pageUa, aioBinding.getIdCard(), CommUtil.formatDate(time));
		if (null != uas && uas.size() > 0) {
			aioDataMO.setUa(uas.get(0).getUa());
		}
		// 相关项目详情URL返回
		aioDataMO.setCholUrl(AioDataConstant.H5_CHOL_URL);
		aioDataMO.setGluUrl(AioDataConstant.H5_GLU_URL);
		aioDataMO.setHrUrl(AioDataConstant.H5_ECG_URL);
		aioDataMO.setSpoUrl(AioDataConstant.H5_SPO_URL);
		aioDataMO.setSysDiaUrl(AioDataConstant.H5_SYS_DIA_URL);
		aioDataMO.setTpUrl(AioDataConstant.H5_TP_URL);
		aioDataMO.setUaUrl(AioDataConstant.H5_UA_URL);

		response.setAioDataMO(aioDataMO);
		return response;
	}

	/**
	 * 获取胆固醇列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/aio/data/get/chol/list", method = RequestMethod.POST)
	@MethodMapping(desc = "获取胆固醇列表")
	@ResponseBody
	public AioCholResponse getCholList(@Valid @ModelAttribute @Param BasicPageParamVo vo,
			HttpServletRequest request) {

		AioCholResponse response = new AioCholResponse();
		AioBinding aioBinding = getAioBinding();
		if (null == aioBinding) {
			response.setM_status(ResultCodeConstant.ERROR_STATUS);
			response.setM_errorCode(ResultCodeConstant.NOT_BINDING_ID_CARD);
			response.setM_errorMsg(ResultMsgConstant.NOT_BINDING_ID_CARD);
			return response;
		}
		// 分页获取胆固醇列表
		MyPage<Chol> page = new MyPage<Chol>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		List<Chol> chols = aioDataService.getCholList(page, aioBinding.getIdCard(), null);
		// 对象转换
		List<CholMO> cholList = MapperUtils.map(mapper, chols, CholMO.class);

		response.setCholList(cholList);
		return response;
	}

	/**
	 * 获取心率列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/aio/data/get/ecg/list", method = RequestMethod.POST)
	@MethodMapping(desc = "获取心率列表")
	@ResponseBody
	public AioEcgResponse getEcgList(@Valid @ModelAttribute @Param BasicPageParamVo vo,
			HttpServletRequest request) {

		AioEcgResponse response = new AioEcgResponse();
		AioBinding aioBinding = getAioBinding();
		if (null == aioBinding) {
			response.setM_status(ResultCodeConstant.ERROR_STATUS);
			response.setM_errorCode(ResultCodeConstant.NOT_BINDING_ID_CARD);
			response.setM_errorMsg(ResultMsgConstant.NOT_BINDING_ID_CARD);
			return response;
		}
		// 分页获取心率列表
		MyPage<Ecg> page = new MyPage<Ecg>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		List<Ecg> ecgs = aioDataService.getEcgList(page, aioBinding.getIdCard(), null);
		// 对象转换
		List<EcgMO> ecgList = MapperUtils.map(mapper, ecgs, EcgMO.class);

		// 获取心率结论信息
		for (EcgMO item : ecgList) {
			item.setAnalysisCode(AnalysisCodeUtil.analysisMessage(item.getAnalysisCode()));
		}
		response.setEcgList(ecgList);
		return response;
	}

	/**
	 * 获取血糖列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/aio/data/get/glu/list", method = RequestMethod.POST)
	@MethodMapping(desc = "获取血糖列表")
	@ResponseBody
	public AioGluResponse getGluList(@Valid @ModelAttribute @Param BasicPageParamVo vo,
			HttpServletRequest request) {

		AioGluResponse response = new AioGluResponse();
		AioBinding aioBinding = getAioBinding();
		if (null == aioBinding) {
			response.setM_status(ResultCodeConstant.ERROR_STATUS);
			response.setM_errorCode(ResultCodeConstant.NOT_BINDING_ID_CARD);
			response.setM_errorMsg(ResultMsgConstant.NOT_BINDING_ID_CARD);
			return response;
		}
		// 分页获取血糖列表
		MyPage<Glu> page = new MyPage<Glu>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		List<Glu> glus = aioDataService.getGluList(page, aioBinding.getIdCard(), null);
		// 对象转换
		List<GluMO> gluList = MapperUtils.map(mapper, glus, GluMO.class);

		response.setGluList(gluList);
		return response;
	}

	/**
	 * 获取血氧列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/aio/data/get/spo/list", method = RequestMethod.POST)
	@MethodMapping(desc = "获取血氧列表")
	@ResponseBody
	public AioSpoResponse getSpoList(@Valid @ModelAttribute @Param BasicPageParamVo vo,
			HttpServletRequest request) {

		AioSpoResponse response = new AioSpoResponse();
		AioBinding aioBinding = getAioBinding();
		if (null == aioBinding) {
			response.setM_status(ResultCodeConstant.ERROR_STATUS);
			response.setM_errorCode(ResultCodeConstant.NOT_BINDING_ID_CARD);
			response.setM_errorMsg(ResultMsgConstant.NOT_BINDING_ID_CARD);
			return response;
		}
		// 分页获取血氧列表
		MyPage<Spo> page = new MyPage<Spo>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		List<Spo> spos = aioDataService.getSpoList(page, aioBinding.getIdCard(), null);
		// 对象转换
		List<SpoMO> spoList = MapperUtils.map(mapper, spos, SpoMO.class);

		response.setSpoList(spoList);
		return response;
	}

	/**
	 * 获取血压列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/aio/data/get/sys/dia/list", method = RequestMethod.POST)
	@MethodMapping(desc = "获取血压列表")
	@ResponseBody
	public AioSysDiaResponse getSysDiaList(@Valid @ModelAttribute @Param BasicPageParamVo vo,
			HttpServletRequest request) {

		AioSysDiaResponse response = new AioSysDiaResponse();
		AioBinding aioBinding = getAioBinding();
		if (null == aioBinding) {
			response.setM_status(ResultCodeConstant.ERROR_STATUS);
			response.setM_errorCode(ResultCodeConstant.NOT_BINDING_ID_CARD);
			response.setM_errorMsg(ResultMsgConstant.NOT_BINDING_ID_CARD);
			return response;
		}
		// 分页获取血压列表
		MyPage<SysDia> page = new MyPage<SysDia>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		List<SysDia> sysDias = aioDataService.getSysDiaList(page, aioBinding.getIdCard(), null);
		// 对象转换
		List<SysDiaMO> sysDiaList = MapperUtils.map(mapper, sysDias, SysDiaMO.class);

		response.setSysDiaList(sysDiaList);
		return response;
	}

	/**
	 * 获取体温列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/aio/data/get/tp/list", method = RequestMethod.POST)
	@MethodMapping(desc = "获取体温列表")
	@ResponseBody
	public AioTpResponse getTpList(@Valid @ModelAttribute @Param BasicPageParamVo vo,
			HttpServletRequest request) {

		AioTpResponse response = new AioTpResponse();
		AioBinding aioBinding = getAioBinding();
		if (null == aioBinding) {
			response.setM_status(ResultCodeConstant.ERROR_STATUS);
			response.setM_errorCode(ResultCodeConstant.NOT_BINDING_ID_CARD);
			response.setM_errorMsg(ResultMsgConstant.NOT_BINDING_ID_CARD);
			return response;
		}
		// 分页获取血压列表
		MyPage<Tp> page = new MyPage<Tp>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		List<Tp> tps = aioDataService.getTpList(page, aioBinding.getIdCard(), null);
		// 对象转换
		List<TpMO> tpList = MapperUtils.map(mapper, tps, TpMO.class);

		response.setTpList(tpList);
		return response;
	}

	/**
	 * 获取尿酸列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/aio/data/get/ua/list", method = RequestMethod.POST)
	@MethodMapping(desc = "获取尿酸列表")
	@ResponseBody
	public AioUaResponse getUaList(@Valid @ModelAttribute @Param BasicPageParamVo vo,
			HttpServletRequest request) {

		AioUaResponse response = new AioUaResponse();
		AioBinding aioBinding = getAioBinding();
		if (null == aioBinding) {
			response.setM_status(ResultCodeConstant.ERROR_STATUS);
			response.setM_errorCode(ResultCodeConstant.NOT_BINDING_ID_CARD);
			response.setM_errorMsg(ResultMsgConstant.NOT_BINDING_ID_CARD);
			return response;
		}
		// 分页获取尿酸列表
		MyPage<Ua> page = new MyPage<Ua>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		List<Ua> uas = aioDataService.getUaList(page, aioBinding.getIdCard(), null);
		// 对象转换
		List<UaMO> uaList = MapperUtils.map(mapper, uas, UaMO.class);

		response.setUaList(uaList);
		return response;
	}

	private AioBinding getAioBinding() {
		// 获取当前用户ID
		Long uid = ActionsUtil.getOwnerUid();
//		Long uid = (long) 15867;
		// 根据用户ID查询一体机绑定信息
		AioBinding aioBinding = aioBindingService.getAioBindingByUid(uid);
		return aioBinding;
	}

	private String getFlagMessage(String flag) {
		String flagMessage;
		if ("0".equals(flag)) {
			flagMessage = "餐后2小时";
		} else if ("1".equals(flag)) {
			flagMessage = "空腹";
		} else {
			flagMessage = "随机";
		}
		return flagMessage;
	}
}
