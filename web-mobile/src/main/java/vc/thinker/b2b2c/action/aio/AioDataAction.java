package vc.thinker.b2b2c.action.aio;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dozer.Mapper;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.DateFormatUtil;
import vc.thinker.b2b2c.mo.aio.CholMO;
import vc.thinker.b2b2c.mo.aio.EcgMO;
import vc.thinker.b2b2c.mo.aio.GluMO;
import vc.thinker.b2b2c.mo.aio.SpoMO;
import vc.thinker.b2b2c.mo.aio.SysDiaMO;
import vc.thinker.b2b2c.mo.aio.TpMO;
import vc.thinker.b2b2c.mo.aio.UaMO;
import vc.thinker.b2b2c.tools.AnalysisCodeUtil;
import vc.thinker.b2b2c.tools.MapperUtils;
import vc.thinker.b2b2c.vo.aio.AioDataVO;

import com.sinco.carnation.aio.model.AioBinding;
import com.sinco.carnation.aio.model.Chol;
import com.sinco.carnation.aio.model.Ecg;
import com.sinco.carnation.aio.model.Glu;
import com.sinco.carnation.aio.model.Spo;
import com.sinco.carnation.aio.model.SysDia;
import com.sinco.carnation.aio.model.Tp;
import com.sinco.carnation.aio.model.Ua;
import com.sinco.carnation.aio.service.AioBindingService;
import com.sinco.carnation.aio.service.AioDataService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

/**
 * 一体机健康数据
 * 
 * @author yuanming
 * 
 */
@Controller
public class AioDataAction {
	@Autowired
	private SysConfigService configService;

	@Autowired
	private AioDataService aioDataService;

	@Autowired
	private AioBindingService aioBindingService;

	@Autowired
	private Mapper mapper;

	/**
	 * 获取胆固醇列表
	 * 
	 * @param pagerReq
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1/get_chol_list.htm")
	public ModelAndView getCholList(HttpServletRequest request, HttpServletResponse response,
			AioDataVO aioDataVO) {
		ModelAndView mv = new JModelAndView("aio/chol_list.html", configService.getSysConfig(), 1, request,
				response);
		// 根据用户ID查询一体机绑定信息
		AioBinding aioBinding = aioBindingService.getAioBindingByUid(aioDataVO.getUid());
		if (null == aioBinding) {
			mv = new JModelAndView("aio/nonedata.html", configService.getSysConfig(), 1, request, response);
			return mv;
		}
		// 分页获取胆固醇列表
		MyPage<Chol> page = new MyPage<Chol>();
		if (null != aioDataVO.getPageNum() || null != aioDataVO.getPageSize()) {
			page.setPageNumber(aioDataVO.getPageNum());
			page.setPageSize(aioDataVO.getPageSize());
		}
		aioDataService.getCholList(page, aioBinding.getIdCard(),
				null != aioDataVO.getStartDate() ? CommUtil.formatDate(aioDataVO.getStartDate()) : null,
				null != aioDataVO.getEndDate() ? CommUtil.formatDate(aioDataVO.getEndDate()) : null);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		// 对象转换
		List<CholMO> cholList = MapperUtils.map(mapper, page.getContent(), CholMO.class);
		if (null == cholList || cholList.size() == 0) {
			mv = new JModelAndView("aio/nonedata.html", configService.getSysConfig(), 1, request, response);
			return mv;
		}
		for (CholMO item : cholList) {
			// 获取日期
			item.setDate(DateFormatUtil.formatDate(item.getTime()));
			// 获取时间（时分）
			item.setTime(DateFormatUtil.formatTime(item.getTime()));
		}
		mv.addObject("cholList", cholList);
		mv.addObject("uid", aioDataVO.getUid());
		return mv;
	}

	/**
	 * 获取心率列表
	 * 
	 * @param pagerReq
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1/get_ecg_list.htm")
	public ModelAndView getEcgList(HttpServletRequest request, HttpServletResponse response,
			AioDataVO aioDataVO) {
		ModelAndView mv = new JModelAndView("aio/ecg_list.html", configService.getSysConfig(), 1, request,
				response);

		// 根据用户ID查询一体机绑定信息
		AioBinding aioBinding = aioBindingService.getAioBindingByUid(aioDataVO.getUid());
		if (null == aioBinding) {
			mv = new JModelAndView("aio/nonedata.html", configService.getSysConfig(), 1, request, response);
			return mv;
		}
		// 分页获取心率列表
		MyPage<Ecg> page = new MyPage<Ecg>();
		if (null != aioDataVO.getPageNum() || null != aioDataVO.getPageSize()) {
			page.setPageNumber(aioDataVO.getPageNum());
			page.setPageSize(aioDataVO.getPageSize());
		}
		aioDataService.getEcgList(page, aioBinding.getIdCard(),
				null != aioDataVO.getStartDate() ? CommUtil.formatDate(aioDataVO.getStartDate()) : null,
				null != aioDataVO.getEndDate() ? CommUtil.formatDate(aioDataVO.getEndDate()) : null);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		// 对象转换
		List<EcgMO> ecgList = MapperUtils.map(mapper, page.getContent(), EcgMO.class);
		if (null == ecgList || ecgList.size() == 0) {
			mv = new JModelAndView("aio/nonedata.html", configService.getSysConfig(), 1, request, response);
			return mv;
		}
		// 获取心率结论信息
		for (EcgMO item : ecgList) {
			item.setAnalysisCode(AnalysisCodeUtil.analysisMessage(item.getAnalysisCode()));
			// 获取日期
			item.setDate(DateFormatUtil.formatDate(item.getTime()));
			// 获取时间（时分）
			item.setTime(DateFormatUtil.formatTime(item.getTime()));
		}
		mv.addObject("ecgList", ecgList);
		mv.addObject("uid", aioDataVO.getUid());
		return mv;
	}

	/**
	 * 获取血糖列表
	 * 
	 * @param pagerReq
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1/get_glu_list.htm")
	public ModelAndView getGluList(HttpServletRequest request, HttpServletResponse response,
			AioDataVO aioDataVO) {
		ModelAndView mv = new JModelAndView("aio/glu_list.html", configService.getSysConfig(), 1, request,
				response);
		// 根据用户ID查询一体机绑定信息
		AioBinding aioBinding = aioBindingService.getAioBindingByUid(aioDataVO.getUid());
		if (null == aioBinding) {
			mv = new JModelAndView("aio/nonedata.html", configService.getSysConfig(), 1, request, response);
			return mv;
		}
		// 分页获取血糖列表
		MyPage<Glu> page = new MyPage<Glu>();
		if (null != aioDataVO.getPageNum() || null != aioDataVO.getPageSize()) {
			page.setPageNumber(aioDataVO.getPageNum());
			page.setPageSize(aioDataVO.getPageSize());
		}
		aioDataService.getGluList(page, aioBinding.getIdCard(),
				null != aioDataVO.getStartDate() ? CommUtil.formatDate(aioDataVO.getStartDate()) : null,
				null != aioDataVO.getEndDate() ? CommUtil.formatDate(aioDataVO.getEndDate()) : null);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		// 对象转换
		List<GluMO> gluList = MapperUtils.map(mapper, page.getContent(), GluMO.class);
		if (null == gluList || gluList.size() == 0) {
			mv = new JModelAndView("aio/nonedata.html", configService.getSysConfig(), 1, request, response);
			return mv;
		}
		for (GluMO item : gluList) {
			String flagMessage = getFlagMessage(item.getFlag());
			item.setFlag(flagMessage);
			// 获取日期
			item.setDate(DateFormatUtil.formatDate(item.getTime()));
			// 获取时间（时分）
			item.setTime(DateFormatUtil.formatTime(item.getTime()));
		}
		mv.addObject("gluList", gluList);
		mv.addObject("uid", aioDataVO.getUid());
		return mv;
	}

	/**
	 * 获取血氧列表
	 * 
	 * @param pagerReq
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1/get_spo_list.htm")
	public ModelAndView getSpoList(HttpServletRequest request, HttpServletResponse response,
			AioDataVO aioDataVO) {
		ModelAndView mv = new JModelAndView("aio/spo_list.html", configService.getSysConfig(), 1, request,
				response);
		// 根据用户ID查询一体机绑定信息
		AioBinding aioBinding = aioBindingService.getAioBindingByUid(aioDataVO.getUid());
		if (null == aioBinding) {
			mv = new JModelAndView("aio/nonedata.html", configService.getSysConfig(), 1, request, response);
			return mv;
		}
		// 分页获取血氧列表
		MyPage<Spo> page = new MyPage<Spo>();
		if (null != aioDataVO.getPageNum() || null != aioDataVO.getPageSize()) {
			page.setPageNumber(aioDataVO.getPageNum());
			page.setPageSize(aioDataVO.getPageSize());
		}
		aioDataService.getSpoList(page, aioBinding.getIdCard(),
				null != aioDataVO.getStartDate() ? CommUtil.formatDate(aioDataVO.getStartDate()) : null,
				null != aioDataVO.getEndDate() ? CommUtil.formatDate(aioDataVO.getEndDate()) : null);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		// 对象转换
		List<SpoMO> spoList = MapperUtils.map(mapper, page.getContent(), SpoMO.class);
		if (null == spoList || spoList.size() == 0) {
			mv = new JModelAndView("aio/nonedata.html", configService.getSysConfig(), 1, request, response);
			return mv;
		}
		for (SpoMO item : spoList) {
			// 获取日期
			item.setDate(DateFormatUtil.formatDate(item.getTime()));
			// 获取时间（时分）
			item.setTime(DateFormatUtil.formatTime(item.getTime()));
		}
		mv.addObject("spoList", spoList);
		mv.addObject("uid", aioDataVO.getUid());
		return mv;
	}

	/**
	 * 获取血压列表
	 * 
	 * @param pagerReq
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1/get_sys_dia_list.htm")
	public ModelAndView getSysDiaList(HttpServletRequest request, HttpServletResponse response,
			AioDataVO aioDataVO) {
		ModelAndView mv = new JModelAndView("aio/sys_dia_list.html", configService.getSysConfig(), 1,
				request, response);
		// 根据用户ID查询一体机绑定信息
		AioBinding aioBinding = aioBindingService.getAioBindingByUid(aioDataVO.getUid());
		if (null == aioBinding) {
			mv = new JModelAndView("aio/nonedata.html", configService.getSysConfig(), 1, request, response);
			return mv;
		}
		// 分页获取血压列表
		MyPage<SysDia> page = new MyPage<SysDia>();
		if (null != aioDataVO.getPageNum() || null != aioDataVO.getPageSize()) {
			page.setPageNumber(aioDataVO.getPageNum());
			page.setPageSize(aioDataVO.getPageSize());
		}
		aioDataService.getSysDiaList(page, aioBinding.getIdCard(),
				null != aioDataVO.getStartDate() ? CommUtil.formatDate(aioDataVO.getStartDate()) : null,
				null != aioDataVO.getEndDate() ? CommUtil.formatDate(aioDataVO.getEndDate()) : null);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		// 对象转换
		List<SysDiaMO> sysDiaList = MapperUtils.map(mapper, page.getContent(), SysDiaMO.class);
		if (null == sysDiaList || sysDiaList.size() == 0) {
			mv = new JModelAndView("aio/nonedata.html", configService.getSysConfig(), 1, request, response);
			return mv;
		}
		for (SysDiaMO item : sysDiaList) {
			// 获取日期
			item.setDate(DateFormatUtil.formatDate(item.getTime()));
			// 获取时间（时分）
			item.setTime(DateFormatUtil.formatTime(item.getTime()));
		}
		mv.addObject("sysDiaList", sysDiaList);
		mv.addObject("uid", aioDataVO.getUid());
		return mv;
	}

	/**
	 * 获取体温列表
	 * 
	 * @param pagerReq
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1/get_tp_list.htm")
	public ModelAndView getTpList(HttpServletRequest request, HttpServletResponse response,
			AioDataVO aioDataVO) {
		ModelAndView mv = new JModelAndView("aio/tp_list.html", configService.getSysConfig(), 1, request,
				response);
		// 根据用户ID查询一体机绑定信息
		AioBinding aioBinding = aioBindingService.getAioBindingByUid(aioDataVO.getUid());
		if (null == aioBinding) {
			mv = new JModelAndView("aio/nonedata.html", configService.getSysConfig(), 1, request, response);
			return mv;
		}
		// 分页获取体温列表
		MyPage<Tp> page = new MyPage<Tp>();
		if (null != aioDataVO.getPageNum() || null != aioDataVO.getPageSize()) {
			page.setPageNumber(aioDataVO.getPageNum());
			page.setPageSize(aioDataVO.getPageSize());
		}
		aioDataService.getTpList(page, aioBinding.getIdCard(),
				null != aioDataVO.getStartDate() ? CommUtil.formatDate(aioDataVO.getStartDate()) : null,
				null != aioDataVO.getEndDate() ? CommUtil.formatDate(aioDataVO.getEndDate()) : null);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		// 对象转换
		List<TpMO> tpList = MapperUtils.map(mapper, page.getContent(), TpMO.class);
		if (null == tpList || tpList.size() == 0) {
			mv = new JModelAndView("aio/nonedata.html", configService.getSysConfig(), 1, request, response);
			return mv;
		}
		for (TpMO item : tpList) {
			// 获取日期
			item.setDate(DateFormatUtil.formatDate(item.getTime()));
			// 获取时间（时分）
			item.setTime(DateFormatUtil.formatTime(item.getTime()));
		}
		mv.addObject("tpList", tpList);
		mv.addObject("uid", aioDataVO.getUid());
		return mv;
	}

	/**
	 * 获取尿酸列表
	 * 
	 * @param pagerReq
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1/get_ua_list.htm")
	public ModelAndView getUaList(HttpServletRequest request, HttpServletResponse response,
			AioDataVO aioDataVO) {
		ModelAndView mv = new JModelAndView("aio/ua_list.html", configService.getSysConfig(), 1, request,
				response);
		// 根据用户ID查询一体机绑定信息
		AioBinding aioBinding = aioBindingService.getAioBindingByUid(aioDataVO.getUid());
		if (null == aioBinding) {
			mv = new JModelAndView("aio/nonedata.html", configService.getSysConfig(), 1, request, response);
			return mv;
		}
		// 分页获取尿酸列表
		MyPage<Ua> page = new MyPage<Ua>();
		if (null != aioDataVO.getPageNum() || null != aioDataVO.getPageSize()) {
			page.setPageNumber(aioDataVO.getPageNum());
			page.setPageSize(aioDataVO.getPageSize());
		}
		aioDataService.getUaList(page, aioBinding.getIdCard(),
				null != aioDataVO.getStartDate() ? CommUtil.formatDate(aioDataVO.getStartDate()) : null,
				null != aioDataVO.getEndDate() ? CommUtil.formatDate(aioDataVO.getEndDate()) : null);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		// 对象转换
		List<UaMO> uaList = MapperUtils.map(mapper, page.getContent(), UaMO.class);
		if (null == uaList || uaList.size() == 0) {
			mv = new JModelAndView("aio/nonedata.html", configService.getSysConfig(), 1, request, response);
			return mv;
		}
		for (UaMO item : uaList) {
			// 获取日期
			item.setDate(DateFormatUtil.formatDate(item.getTime()));
			// 获取时间（时分）
			item.setTime(DateFormatUtil.formatTime(item.getTime()));
		}
		mv.addObject("uaList", uaList);
		mv.addObject("uid", aioDataVO.getUid());
		return mv;
	}

	/**
	 * 获取胆固醇列表(ajax)
	 * 
	 * @param pagerReq
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1/get_chol_list_ajax.htm")
	public void getCholListAjax(HttpServletRequest request, HttpServletResponse response, AioDataVO aioDataVO) {
		// 根据用户ID查询一体机绑定信息
		AioBinding aioBinding = aioBindingService.getAioBindingByUid(aioDataVO.getUid());
		// 分页获取胆固醇列表
		MyPage<Chol> page = new MyPage<Chol>();
		if (null != aioDataVO.getPageNum() || null != aioDataVO.getPageSize()) {
			page.setPageNumber(aioDataVO.getPageNum());
			page.setPageSize(aioDataVO.getPageSize());
		}
		aioDataService.getCholList(page, aioBinding.getIdCard(),
				null != aioDataVO.getStartDate() ? CommUtil.formatDate(aioDataVO.getStartDate()) : null,
				null != aioDataVO.getEndDate() ? CommUtil.formatDate(aioDataVO.getEndDate()) : null);
		// 对象转换
		List<CholMO> cholList = MapperUtils.map(mapper, page.getContent(), CholMO.class);
		for (CholMO item : cholList) {
			// 获取日期
			item.setDate(DateFormatUtil.formatDate(item.getTime()));
			// 获取时间（时分）
			item.setTime(DateFormatUtil.formatTime(item.getTime()));
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(cholList));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取心率列表(ajax)
	 * 
	 * @param pagerReq
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1/get_ecg_list_ajax.htm")
	public void getEcgListAjax(HttpServletRequest request, HttpServletResponse response, AioDataVO aioDataVO) {

		// 根据用户ID查询一体机绑定信息
		AioBinding aioBinding = aioBindingService.getAioBindingByUid(aioDataVO.getUid());
		// 分页获取心率列表
		MyPage<Ecg> page = new MyPage<Ecg>();
		if (null != aioDataVO.getPageNum() || null != aioDataVO.getPageSize()) {
			page.setPageNumber(aioDataVO.getPageNum());
			page.setPageSize(aioDataVO.getPageSize());
		}
		aioDataService.getEcgList(page, aioBinding.getIdCard(),
				null != aioDataVO.getStartDate() ? CommUtil.formatDate(aioDataVO.getStartDate()) : null,
				null != aioDataVO.getEndDate() ? CommUtil.formatDate(aioDataVO.getEndDate()) : null);
		// 对象转换
		List<EcgMO> ecgList = MapperUtils.map(mapper, page.getContent(), EcgMO.class);
		// 获取心率结论信息
		for (EcgMO item : ecgList) {
			item.setAnalysisCode(AnalysisCodeUtil.analysisMessage(item.getAnalysisCode()));
			// 获取日期
			item.setDate(DateFormatUtil.formatDate(item.getTime()));
			// 获取时间（时分）
			item.setTime(DateFormatUtil.formatTime(item.getTime()));
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(ecgList));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取血糖列表(ajax)
	 * 
	 * @param pagerReq
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1/get_glu_list_ajax.htm")
	public void getGluListAjax(HttpServletRequest request, HttpServletResponse response, AioDataVO aioDataVO) {
		// 根据用户ID查询一体机绑定信息
		AioBinding aioBinding = aioBindingService.getAioBindingByUid(aioDataVO.getUid());

		// 分页获取血糖列表
		MyPage<Glu> page = new MyPage<Glu>();
		if (null != aioDataVO.getPageNum() || null != aioDataVO.getPageSize()) {
			page.setPageNumber(aioDataVO.getPageNum());
			page.setPageSize(aioDataVO.getPageSize());
		}
		aioDataService.getGluList(page, aioBinding.getIdCard(),
				null != aioDataVO.getStartDate() ? CommUtil.formatDate(aioDataVO.getStartDate()) : null,
				null != aioDataVO.getEndDate() ? CommUtil.formatDate(aioDataVO.getEndDate()) : null);
		// 对象转换
		List<GluMO> gluList = MapperUtils.map(mapper, page.getContent(), GluMO.class);
		for (GluMO item : gluList) {
			String flagMessage = getFlagMessage(item.getFlag());
			item.setFlag(flagMessage);
			// 获取日期
			item.setDate(DateFormatUtil.formatDate(item.getTime()));
			// 获取时间（时分）
			item.setTime(DateFormatUtil.formatTime(item.getTime()));
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(gluList));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取血氧列表(ajax)
	 * 
	 * @param pagerReq
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1/get_spo_list_ajax.htm")
	public void getSpoListAjax(HttpServletRequest request, HttpServletResponse response, AioDataVO aioDataVO) {
		// 根据用户ID查询一体机绑定信息
		AioBinding aioBinding = aioBindingService.getAioBindingByUid(aioDataVO.getUid());
		// 分页获取血氧列表
		MyPage<Spo> page = new MyPage<Spo>();
		if (null != aioDataVO.getPageNum() || null != aioDataVO.getPageSize()) {
			page.setPageNumber(aioDataVO.getPageNum());
			page.setPageSize(aioDataVO.getPageSize());
		}
		aioDataService.getSpoList(page, aioBinding.getIdCard(),
				null != aioDataVO.getStartDate() ? CommUtil.formatDate(aioDataVO.getStartDate()) : null,
				null != aioDataVO.getEndDate() ? CommUtil.formatDate(aioDataVO.getEndDate()) : null);
		// 对象转换
		List<SpoMO> spoList = MapperUtils.map(mapper, page.getContent(), SpoMO.class);
		for (SpoMO item : spoList) {
			// 获取日期
			item.setDate(DateFormatUtil.formatDate(item.getTime()));
			// 获取时间（时分）
			item.setTime(DateFormatUtil.formatTime(item.getTime()));
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(spoList));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取血压列表(ajax)
	 * 
	 * @param pagerReq
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1/get_sys_dia_list_ajax.htm")
	public void getSysDiaListAjax(HttpServletRequest request, HttpServletResponse response,
			AioDataVO aioDataVO) {
		// 根据用户ID查询一体机绑定信息
		AioBinding aioBinding = aioBindingService.getAioBindingByUid(aioDataVO.getUid());
		// 分页获取血压列表
		MyPage<SysDia> page = new MyPage<SysDia>();
		if (null != aioDataVO.getPageNum() || null != aioDataVO.getPageSize()) {
			page.setPageNumber(aioDataVO.getPageNum());
			page.setPageSize(aioDataVO.getPageSize());
		}
		aioDataService.getSysDiaList(page, aioBinding.getIdCard(),
				null != aioDataVO.getStartDate() ? CommUtil.formatDate(aioDataVO.getStartDate()) : null,
				null != aioDataVO.getEndDate() ? CommUtil.formatDate(aioDataVO.getEndDate()) : null);
		// 对象转换
		List<SysDiaMO> sysDiaList = MapperUtils.map(mapper, page.getContent(), SysDiaMO.class);
		for (SysDiaMO item : sysDiaList) {
			// 获取日期
			item.setDate(DateFormatUtil.formatDate(item.getTime()));
			// 获取时间（时分）
			item.setTime(DateFormatUtil.formatTime(item.getTime()));
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(sysDiaList));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取体温列表(ajax)
	 * 
	 * @param pagerReq
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1/get_tp_list_ajax.htm")
	public void getTpListAjax(HttpServletRequest request, HttpServletResponse response, AioDataVO aioDataVO) {
		// 根据用户ID查询一体机绑定信息
		AioBinding aioBinding = aioBindingService.getAioBindingByUid(aioDataVO.getUid());
		// 分页获取体温列表
		MyPage<Tp> page = new MyPage<Tp>();
		if (null != aioDataVO.getPageNum() || null != aioDataVO.getPageSize()) {
			page.setPageNumber(aioDataVO.getPageNum());
			page.setPageSize(aioDataVO.getPageSize());
		}
		aioDataService.getTpList(page, aioBinding.getIdCard(),
				null != aioDataVO.getStartDate() ? CommUtil.formatDate(aioDataVO.getStartDate()) : null,
				null != aioDataVO.getEndDate() ? CommUtil.formatDate(aioDataVO.getEndDate()) : null);
		// 对象转换
		List<TpMO> tpList = MapperUtils.map(mapper, page.getContent(), TpMO.class);
		for (TpMO item : tpList) {
			// 获取日期
			item.setDate(DateFormatUtil.formatDate(item.getTime()));
			// 获取时间（时分）
			item.setTime(DateFormatUtil.formatTime(item.getTime()));
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(tpList));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取尿酸列表(ajax)
	 * 
	 * @param pagerReq
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1/get_ua_list_ajax.htm")
	public void getUaListToAjax(HttpServletRequest request, HttpServletResponse response, AioDataVO aioDataVO) {
		// 根据用户ID查询一体机绑定信息
		AioBinding aioBinding = aioBindingService.getAioBindingByUid(aioDataVO.getUid());

		// 分页获取尿酸列表
		MyPage<Ua> page = new MyPage<Ua>();
		if (null != aioDataVO.getPageNum() || null != aioDataVO.getPageSize()) {
			page.setPageNumber(aioDataVO.getPageNum());
			page.setPageSize(aioDataVO.getPageSize());
		}
		aioDataService.getUaList(page, aioBinding.getIdCard(),
				null != aioDataVO.getStartDate() ? CommUtil.formatDate(aioDataVO.getStartDate()) : null,
				null != aioDataVO.getEndDate() ? CommUtil.formatDate(aioDataVO.getEndDate()) : null);
		// 对象转换
		List<UaMO> uaList = MapperUtils.map(mapper, page.getContent(), UaMO.class);

		for (UaMO item : uaList) {
			// 获取日期
			item.setDate(DateFormatUtil.formatDate(item.getTime()));
			// 获取时间（时分）
			item.setTime(DateFormatUtil.formatTime(item.getTime()));
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(uaList));
		} catch (IOException e) {
			e.printStackTrace();
		}
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
