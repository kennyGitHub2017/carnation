package vc.thinker.b2b2c.action.elong;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dozer.Mapper;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import vc.thinker.b2b2c.model.elong.mo.ElongGeoMO;
import vc.thinker.b2b2c.tools.MapperUtils;

import com.sinco.carnation.elong.model.ElongGeo;
import com.sinco.carnation.elong.service.ElongGeoService;
import com.sinco.carnation.sys.service.SysConfigService;

/**
 * 艺龙地域模块
 * 
 * @author yuanming
 * 
 */
@Controller
public class ElongGeoAction {
	@Autowired
	private SysConfigService configService;

	@Autowired
	private ElongGeoService elongGeoService;

	@Autowired
	private Mapper mapper;

	/**
	 * 导入艺龙地域数据
	 * 
	 * @param pagerReq
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1/save_elong_geo.htm")
	public void saveElongGeo(HttpServletRequest request, HttpServletResponse response) {
		// 需要导入放开注解
		// elongGeoService.saveGeoInfo();
	}

	@RequestMapping(value = "/v1/get_geo_by_area_name.htm")
	public void getGeoByAreaName(String areaName, HttpServletRequest request, HttpServletResponse response) {

		// 获取艺龙酒店列表数据
		List<ElongGeo> elongGeos = elongGeoService.getGeoByAreaName(areaName);

		List<ElongGeoMO> geoList = MapperUtils.map(mapper, elongGeos, ElongGeoMO.class);

		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(geoList, JsonFormat.compact()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
