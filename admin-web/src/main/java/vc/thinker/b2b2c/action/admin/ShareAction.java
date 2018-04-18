package vc.thinker.b2b2c.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.sys.bo.ShareBO;
import com.sinco.carnation.sys.contants.ShareContants;
import com.sinco.carnation.sys.service.ShareService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.vo.ShareVO;

/**
 * 分享管理
 * 
 * @author Administrator
 * 
 */
@Controller
public class ShareAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private ShareService shareService;

	@SecurityMapping(title = "分享管理", value = "/admin/juanpi_share_set.htm*", rtype = "admin", rname = "分享管理", rcode = "advert_admin", rgroup = "内容管理")
	@RequestMapping("/admin/share_list.htm")
	public ModelAndView juanpiShareSet(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/juanpi_share_set.html", configService.getSysConfig(),
				0, request, response);
		ShareBO ptBO = new ShareBO();
		ShareBO tgBO = new ShareBO();
		// 普通
		ShareVO vo = new ShareVO();
		vo.setMark(ShareContants.MARK_JUANPI_PUTONG);
		List<ShareBO> list1 = shareService.listByVO(vo);
		if (list1.size() > 0) {
			for (ShareBO bo : list1) {
				if (null == bo.getShareId()) {
					ptBO = bo;
				}
			}
		}
		// 团购
		vo.setMark(ShareContants.MARK_JUANPI_TUANGOU);
		List<ShareBO> list2 = shareService.listByVO(vo);
		if (list1.size() > 0) {
			for (ShareBO bo : list2) {
				if (null == bo.getShareId()) {
					tgBO = bo;
				}
			}
		}

		mv.addObject("ptBO", ptBO);
		mv.addObject("tgBO", tgBO);
		return mv;
	}

	@SecurityMapping(title = "分享保存", value = "/admin/share_save.htm*", rtype = "admin", rname = "分享管理", rcode = "advert_admin", rgroup = "内容管理")
	@RequestMapping("/admin/share_save.htm")
	public void share_save(HttpServletRequest request, HttpServletResponse response, ShareVO vo) {
//		ModelAndView mv = new JModelAndView("admin/blue/share_list.html", configService.getSysConfig(), 0,
//				request, response);
		String result = "保存成功";
		if(vo != null && vo.getMark() != null && vo.getShareId() != null){
			ShareBO bo = shareService.getByShareIdMark(vo.getMark(), vo.getShareId());
			if(null != bo){
				vo.setId(bo.getId());
			}
		}
		try {
			if (null != vo) {
				shareService.save(vo);
				if (StringUtils.isNotBlank(vo.getGroupmark())) {
					if (null != vo.getShareId() || null != vo.getGroupshareId()) {
						throw new ServiceException("请输入正确的信息");
					}
					ShareVO groupVO = new ShareVO();
					groupVO.setId(vo.getGroupid());
					groupVO.setMark(vo.getGroupmark());
					groupVO.setContext(vo.getGroupcontext());
					groupVO.setShareId(vo.getGroupshareId());
					groupVO.setTitleClass(vo.getGrouptitleClass());
					groupVO.setTitle(vo.getGrouptitle());
					groupVO.setImgClass(vo.getGroupimgClass());
					groupVO.setImgUrl(vo.getGroupimgUrl());
					groupVO.setUrl(vo.getGroupurl());
					shareService.save(groupVO);
				}
			} else {
				result = "内容不能为空";
			}
		} catch (ServiceException e) {
			result = e.getErrorCode();
		} catch (Exception e) {
			result = "保存失败";
		}
		responseWriter(response, result);
	}

	@SecurityMapping(title = "分享编辑", value = "/admin/share_edit.htm*", rtype = "admin", rname = "分享管理", rcode = "advert_admin", rgroup = "内容管理")
	@RequestMapping("/admin/share_edit.htm")
	public void share_edit(HttpServletRequest request, HttpServletResponse response, Long goods_id,
			String mark) {
		ModelAndView mv = new JModelAndView("admin/blue/share_list.html", configService.getSysConfig(), 0,
				request, response);

		ShareBO result = new ShareBO();
		ShareVO vo = new ShareVO();
		vo.setMark(mark);
		vo.setShareId(goods_id);
		List<ShareBO> list = shareService.listByVO(vo);
		if (list.size() > 0)
			result = list.get(0);

		mv.addObject("obj", result);
		
	}
	
	@SuppressWarnings({"unchecked", "unused", "rawtypes"})
	@SecurityMapping(title = "分享编辑", value = "/admin/share_edit_json.htm*", rtype = "admin", rname = "分享管理", rcode = "advert_admin", rgroup = "内容管理")
	@RequestMapping("/admin/share_edit_json.htm")
	public void share_edit_json(HttpServletRequest request, HttpServletResponse response, Long goods_id,
			String mark) {

		ShareBO result = new ShareBO();
		ShareVO vo = new ShareVO();
		vo.setMark(mark);
		vo.setShareId(goods_id);
		List<ShareBO> bos = shareService.listByVO(vo);
		if (bos.size() > 0)
			result = bos.get(0);
		List<Map> list = new ArrayList<Map>();
		for(ShareBO bo : bos){
			Map map = new HashMap();
			map.put("id", bo.getId());
			map.put("shareId", bo.getShareId());
			map.put("titleClass", bo.getTitleClass());
			map.put("title", bo.getTitle());
			map.put("imgClass", bo.getImgClass());
			map.put("imgUrl", bo.getImgUrl());
			map.put("url", bo.getUrl());
			map.put("context", bo.getContext());
			map.put("mark", bo.getMark());
			list.add(map);
		}
		String temp = Json.toJson(list, JsonFormat.compact());
		responseWriter(response, temp);
	}

	private void responseWriter(HttpServletResponse response, String result) {
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
