package com.sinco.carnation.resource.web.actions.ad;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.util.MapperUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.resource.bo.ad.AdContentMO;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.response.ad.AdContentResponse;
import com.sinco.carnation.sys.bo.AdContentBO;
import com.sinco.carnation.sys.service.ContentService;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "区域内容管理", namespace = "adContent")
public class AdContentAction extends BasicApiController {

	@Autowired
	private ContentService contentService;

	@Autowired
	private Mapper mapper;

	@RequestMapping(value = "/get/ad/content", method = RequestMethod.POST)
	@MethodMapping(desc = "获取区域广告内容")
	@ResponseBody
	public AdContentResponse getAdContent(@RequestParam(value = "code", required = true) String code,
			@RequestParam(value = "areaId", required = false) Long areaId, HttpServletRequest request) {
		AdContentResponse response = new AdContentResponse();

		List<AdContentBO> contentList = contentService.getContentList(code, areaId);

		List<AdContentMO> list = new ArrayList<AdContentMO>();
		if (null != contentList && contentList.size() > 0) {
			list = MapperUtils.map(mapper, contentList, AdContentMO.class);
			Iterator<AdContentMO> iterator = list.iterator();
			while (iterator.hasNext()) {
				AdContentMO item = iterator.next();
				if (null == item.getId()) {
					iterator.remove();
				}
			}
			response.setStyle(contentList.get(0).getStyle());
		}
		// 返回保存数据
		response.setAdContentMO(list);
		return response;
	}

}
