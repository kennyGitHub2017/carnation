package vc.thinker.b2b2c.action.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sinco.carnation.sys.bo.AdContentBO;
import com.sinco.carnation.sys.bo.AreaAdBO;
import com.sinco.carnation.sys.service.AreaAdService;
import com.sinco.carnation.sys.service.ContentService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

/**
 * 专区广告
 * @author Tivan
 *
 */
@Controller
public class AreaAdManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private AreaAdService areaAdService;
	@Autowired
	private ContentService contentService;
	
	@SecurityMapping(title = "专区列表", value = "/admin/areaAd/list.htm*", rtype = "admin", rname = "专区管理", rcode = "areaad", rgroup = "营销")
	@RequestMapping("/admin/areaAd/list.htm")
	public ModelAndView list(AreaAdBO areaAd, HttpServletRequest request, HttpServletResponse response, MyPage<AreaAdBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/advert/advert_zone.html", configService.getSysConfig(), 0, request, response);
		areaAdService.findPage(areaAd, page);
		mv.addObject("areaAd", areaAd);
		CommUtil.saveIPageList2ModelAndView("/admin/areaAd/list.htm", "", "", page, mv);
		return mv;
	}
	
	@SecurityMapping(title = "专区编辑", value = "/admin/areaAd/toEdit.htm*", rtype = "admin", rname = "专区管理", rcode = "areaad", rgroup = "营销")
	@RequestMapping("/admin/areaAd/toEdit.htm")
	public ModelAndView toEdit(Long id, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/advert/advert_zone_add.html", configService.getSysConfig(), 0, request, response);
		AreaAdBO areaAd = areaAdService.getById(id);
		mv.addObject("areaAd", areaAd);
		return mv;
	}
	
	@SecurityMapping(title = "专区更新", value = "/admin/areaAd/update.htm*", rtype = "admin", rname = "专区管理", rcode = "areaad", rgroup = "营销")
	@RequestMapping("/admin/areaAd/update.htm")
	public ModelAndView update(AreaAdBO areaAd, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0, request, response);
		mv.addObject("op_title", "专区保存成功");
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/areaAd/list.htm");
		mv.addObject("add_url", CommUtil.getURL(request) + "/admin/areaAd/toEdit.htm");
		//检测专区代码是否已经存在
		boolean exists = areaAdService.checkCodeExists(areaAd.getId(), areaAd.getCode());
		if(exists){
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request, response);
			mv.addObject("op_title", "专区代码["+ areaAd.getCode() +"]已经存在，保存失败！");
			return mv;
		}
		Long userId = SecurityUserHolder.getCurrentUserId();
		if(areaAd.getId() == null){
			areaAd.setCreateBy(userId);
			areaAd.setCreateTime(new Date());
			areaAd.setModifyBy(areaAd.getCreateBy());
			areaAd.setModifyTime(areaAd.getCreateTime());
		}else{
			areaAd.setModifyBy(userId);
			areaAd.setModifyTime(new Date());
		}
		areaAdService.saveOrUpdate(areaAd);
		return mv;
	}
	
	@SecurityMapping(title = "专区删除", value = "/admin/areaAd/delete.htm*", rtype = "admin", rname = "专区管理", rcode = "areaad", rgroup = "营销")
	@RequestMapping("/admin/areaAd/delete.htm")
	@ResponseBody
	public String delete(String mulitId) {
		List<Map<String, Object>> errorList = new ArrayList<Map<String, Object>>();
		String[] ids = StringUtils.tokenizeToStringArray(mulitId, ",");
		if(ids != null && ids.length > 0){
			for(String id : ids){
				long tempId = Long.parseLong(id);
				int count = contentService.findCountByAreaAdId(tempId);
				if(count == 0){
					areaAdService.delete(tempId);
				}
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", tempId);
				map.put("state", count == 0);
				errorList.add(map);
			}
		}
		return JSONArray.toJSONString(errorList);
	}
	
	@SecurityMapping(title = "专区显示/隐藏", value = "/admin/areaAd/enabled.htm*", rtype = "admin", rname = "专区管理", rcode = "areaad", rgroup = "营销")
	@RequestMapping("/admin/areaAd/enabled.htm")
	@ResponseBody
	public String enabled(String mulitId) {
		Map<Long, Integer> status = new HashMap<Long, Integer>();
		String[] ids = StringUtils.tokenizeToStringArray(mulitId, ",");
		if(ids != null && ids.length > 0){
			for(String id : ids){
				AreaAdBO areaAd = areaAdService.getById(Long.parseLong(id));
				if(areaAd.getDisabled() == 0){
					areaAd.setDisabled(1);
				}else{
					areaAd.setDisabled(0);
				}
				areaAdService.saveOrUpdate(areaAd);
				status.put(areaAd.getId(), areaAd.getDisabled());
			}
		}
		//return new JModelAndView("forward:/admin/areaAd/list.htm");
		return JSONObject.toJSONString(status);
	}
	
	@SecurityMapping(title = "添加专区内容", value = "/admin/areaAd/addAdContent.htm*", rtype = "admin", rname = "专区管理", rcode = "areaad", rgroup = "营销")
	@RequestMapping("/admin/areaAd/addAdContent.htm")
	public ModelAndView addAdContent(Long id, HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new JModelAndView("admin/blue/advert/advert_area_add.html", configService.getSysConfig(), 0, request, response); 
		AdContentBO adContent = new AdContentBO();
		adContent.setAreaAdId(id);
		//展示专区列表
		List<AreaAdBO> areaads = areaAdService.findAllShow();
		mv.addObject("areaads", areaads);
		mv.addObject("vo", adContent);
		return mv;
	}
	
}
