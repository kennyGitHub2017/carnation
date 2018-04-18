package vc.thinker.b2b2c.action.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.nutz.json.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinco.carnation.sys.service.ReportService;

import vc.thinker.b2b2c.core.mv.ActionResult;
import vc.thinker.b2b2c.core.tools.CommUtil;

/**
 * 
 * <p>
 * Title: BaseManageAction.java
 * </p>
 * 
 * <p>
 * Description: 平台管理基础控制，这里包含平台管理的基础方法、系统全局配置信息的保存、修改及一些系统常用请求
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
 * @date 2014-5-9
 * 
 * @version 1.0.1
 */
@Controller
public class ReportIndexAction {
	@Autowired
	private ReportService reportService;

	Logger logger = LoggerFactory.getLogger(ReportIndexAction.class);

	/**
	 * 
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("admin/report_index.htm")
	@ResponseBody
	public String report_index(String type) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();

			if ("shop".equals(type)) {
				map = reportService.findShopGroup();
			} else if ("integral".equals(type)) {
				map = reportService.findIntegralOrderGroup();
			} else if ("member".equals(type)) {
				map = reportService.findMemberGroup();
			} else if ("merchant".equals(type)) {
				map = reportService.findMerchantGroup();
			} else if ("sns".equals(type)) {
				map = reportService.findSnsGroup();
			} else if ("exportConsulting".equals(type)) {
				map = reportService.findExportConsultingGroup();
			} else if ("operator".equals(type)) {
				map = reportService.findOperatorGroup();
			}
			return Json.toJson(ActionResult.NewSuccess(map));
		} catch (Exception e) {
			logger.error(CommUtil.getStackTrace(e));
		}
		return Json.toJson(ActionResult.NewFail("商城数据获取异常"));
	}

}
