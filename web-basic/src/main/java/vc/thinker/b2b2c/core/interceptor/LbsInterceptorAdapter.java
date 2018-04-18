package vc.thinker.b2b2c.core.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.common.utils.IPUtil;
import com.sinco.dic.client.DicContent;

/**
 * 位置拦截器
 * 
 * @author james
 * 
 */
public class LbsInterceptorAdapter extends HandlerInterceptorAdapter {

	private AreaServiceImpl areaService;

	private DicContent dicContent;

	private Area defaultArea;

	private String defaultAreaCode;

	public static String O2O_CITY_ID = "o2o_city_id";

	/**
	 * city key
	 */
	public static String O2O_CITY = "o2o_city";

	/**
	 * 
	 * @return
	 */
	private Area getDefaultArea() {
		if (defaultArea == null) {
			if (StringUtils.isNotBlank(defaultAreaCode)) {
				defaultArea = areaService.getObjById(Long.parseLong(defaultAreaCode));
			}
		}
		return defaultArea;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String cityId = getCityId(request);
		String ip = IPUtil.getIpAddr(request);
		Area area = null;

		// 如果cookie存在，已cookie里为准，否则使用ip定位，如果ip定位不到使用默认城市
		if (StringUtils.isBlank(cityId)) {
			area = areaService.findCityByIp(ip);
		} else {
			area = (Area) dicContent.getDic(Area.class, cityId);
			if (area == null) {
				area = areaService.findCityByIp(ip);
			}
		}

		if (area == null) {
			area = getDefaultArea();
		}

		request.setAttribute(O2O_CITY, area);
		if (null == area.getId()) {
			return true;
		}
		setCityId(area.getId().toString(), request, response);

		return true;
	}

	/**
	 * 得到cookie中的city id
	 * 
	 * @param request
	 * @return
	 */
	private String getCityId(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(O2O_CITY_ID)) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}

	private void setCityId(String cityId, HttpServletRequest request, HttpServletResponse response) {
		Cookie cookie = new Cookie(O2O_CITY_ID, cityId);
		cookie.setDomain(CommUtil.generic_domain(request));
		cookie.setPath("/");
		cookie.setMaxAge(60 * 60 * 24 * 30);
		response.addCookie(cookie);
	}

	public String getDefaultAreaCode() {
		return defaultAreaCode;
	}

	public void setDefaultAreaCode(String defaultAreaCode) {
		this.defaultAreaCode = defaultAreaCode;
	}

	public DicContent getDicContent() {
		return dicContent;
	}

	public void setDicContent(DicContent dicContent) {
		this.dicContent = dicContent;
	}

	public AreaServiceImpl getAreaService() {
		return areaService;
	}

	public void setAreaService(AreaServiceImpl areaService) {
		this.areaService = areaService;
	}
}
