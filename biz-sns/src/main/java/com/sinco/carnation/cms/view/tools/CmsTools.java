package com.sinco.carnation.cms.view.tools;

import java.util.List;
import java.util.Map;

import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.cms.service.InformationClassServiceImpl;
import com.sinco.carnation.cms.service.InformationReplyServiceImpl;
import com.sinco.carnation.sns.dao.InformationClassDao;
import com.sinco.carnation.sns.dao.InformationReplyDao;
import com.sinco.carnation.sns.model.InformationClass;

@Component
public class CmsTools {
	@Autowired
	private InformationClassServiceImpl informationClassService;
	@Autowired
	private InformationReplyServiceImpl informationReplyService;

	@Autowired
	private InformationClassDao informationClassDao;

	@Autowired
	private InformationReplyDao informationReplyDao;

	@SuppressWarnings("rawtypes")
	public List<Map> getCmsList(String json) {
		List<Map> maps = null;
		if (json != null && !json.equals("")) {
			Json.fromJson(List.class, json);
		}
		return maps;
	}

	@SuppressWarnings("rawtypes")
	public Map getCmsMap(String json) {
		Map map = null;
		if (json != null && !json.equals("")) {
			Json.fromJson(Map.class, json);
		}
		return map;
	}

	public String queryInforClass(String id) {
		InformationClass informationClass = this.informationClassService.getObjById(CommUtil.null2Long(id));
		if (informationClass != null) {
			return informationClass.getIcName();
		} else {
			return "";
		}
	}

	public List<InformationClass> queryChildClass(String id) {
		return informationClassDao.queryChildClass(CommUtil.null2Long(id));
	}

	public int queryComment(String id) {
		return informationReplyDao.queryComment(CommUtil.null2Long(id));
	}
}
