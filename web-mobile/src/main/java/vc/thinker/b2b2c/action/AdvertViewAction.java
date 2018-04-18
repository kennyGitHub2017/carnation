package vc.thinker.b2b2c.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.interceptor.LbsInterceptorAdapter;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.google.common.collect.Lists;
import com.sinco.carnation.recommend.service.AdvertPositionService;
import com.sinco.carnation.recommend.service.AdvertService;
import com.sinco.carnation.sns.bo.AdvertBO;
import com.sinco.carnation.sns.bo.AdvertPositionBO;
import com.sinco.carnation.sns.contants.AdvertContant;
import com.sinco.carnation.sns.model.Advert;
import com.sinco.carnation.sns.model.AdvertPosition;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.service.SysConfigService;

/**
 * 
 * <p>
 * Title: AdvertViewAction.java
 * </p>
 * 
 * <p>
 * Description:广告调用控制器,系统采用广告位形式管理广告信息，前端使用js完成调用，js调用的是该控制器中的invoke方法， redirect方法用来控制并记录广告点击信息
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
 * @date 2014-9-16
 * 
 * @version 1.0.1
 */
@Controller
public class AdvertViewAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private AdvertPositionService advertPositionService;
	@Autowired
	private AdvertService advertService;

	/**
	 * 广告调用方法
	 * 
	 * ps:该方法已经改造为通知广告位code查找，对应页面需做出相应调整。update by james
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping("/advert_invoke.htm")
	public ModelAndView advert_invoke(HttpServletRequest request, HttpServletResponse response, String apCode) {
		ModelAndView mv = new JModelAndView("advert_invoke.html", configService.getSysConfig(), 1, request,
				response);
		if (StringUtils.isNotEmpty(apCode)) {
			AdvertPosition ap = this.advertPositionService.findByCode(apCode);
			if (ap != null) {
				AdvertPositionBO obj = new AdvertPositionBO();
				obj.setId(ap.getId());
				obj.setApType(ap.getApType());
				obj.setApStatus(ap.getApStatus());
				obj.setApShowType(ap.getApShowType());
				obj.setApWidth(ap.getApWidth());
				obj.setApHeight(ap.getApHeight());
				obj.setApLocation(ap.getApLocation());
				obj.setAdvs(new ArrayList<Advert>());
				List<Advert> advs = advertService.findListByAdApId(obj.getId(), AdvertContant.AP_STATUS_1,
						new Date(), new Date());

				if (advs.size() > 0) {
					if (obj.getApType().equals(AdvertContant.AP_TYPE_TEXT)) {// 文字广告
						if (obj.getApShowType() == AdvertContant.AP_SHOW_TYPE_0) {// 固定广告
							obj.setApText(advs.get(0).getAdText());
							obj.setApAccUrl(advs.get(0).getAdUrl());
							obj.setAdvId(advs.get(0).getId());
						}
						if (obj.getApShowType() == AdvertContant.AP_SHOW_TYPE_1) {// 随机广告
							Random random = new Random();
							int i = random.nextInt(advs.size());
							obj.setApText(advs.get(i).getAdText());
							obj.setApAccUrl(advs.get(i).getAdUrl());
							obj.setAdvId(advs.get(i).getId());
						}
					}
					if (obj.getApType().equals(AdvertContant.AP_TYPE_IMG)) {// 图片广告
						if (obj.getApShowType() == AdvertContant.AP_SHOW_TYPE_0) {// 固定广告
							obj.setApImgPath(advs.get(0).getAdImgPath());
							obj.setApAccUrl(advs.get(0).getAdUrl());
							obj.setAdvId(advs.get(0).getId());
						}
						if (obj.getApShowType() == AdvertContant.AP_SHOW_TYPE_1) {// 随机广告
							Random random = new Random();
							int i = random.nextInt(advs.size());
							obj.setApImgPath(advs.get(i).getAdImgPath());
							obj.setApAccUrl(advs.get(i).getAdUrl());
							obj.setAdvId(advs.get(i).getId());
						}
					}
					if (obj.getApType().equals(AdvertContant.AP_TYPE_SLIDE)) {// 幻灯广告
						if (obj.getApShowType() == AdvertContant.AP_SHOW_TYPE_0) {// 固定广告
							obj.setAdvs(advs);
						}
						if (obj.getApShowType() == AdvertContant.AP_SHOW_TYPE_1) {// 随机广告

							if (advs.size() < 8) {
								obj.getAdvs().addAll(advs);
							} else {
								Set<Integer> list = CommUtil.randomInt(advs.size(), 8);
								for (int i : list) {
									obj.getAdvs().add(advs.get(i));
								}
							}
						}
					}
					if (obj.getApType().equals(AdvertContant.AP_TYPE_SCROLL)) {// 滚动广告
						if (obj.getApShowType() == AdvertContant.AP_SHOW_TYPE_0) {// 固定广告
							obj.setAdvs(advs);
						}
						if (obj.getApShowType() == AdvertContant.AP_SHOW_TYPE_1) {// 随机广告
							if (advs.size() < 12) {
								obj.getAdvs().addAll(advs);
							} else {
								Set<Integer> list = CommUtil.randomInt(advs.size(), 12);
								for (int i : list) {
									obj.getAdvs().add(advs.get(i));
								}
							}
						}
					}
					if (obj.getApType().equals(AdvertContant.AP_TYPE_BG_SLIDE)) {
						if (obj.getApShowType() == AdvertContant.AP_SHOW_TYPE_0) {// 固定广告
							obj.setAdvs(advs);
						}
						if (obj.getApShowType() == AdvertContant.AP_SHOW_TYPE_1) {// 随机广告
							if (advs.size() < 5) {
								obj.getAdvs().addAll(advs);
							} else {
								Set<Integer> list = CommUtil.randomInt(advs.size(), 5);
								for (int i : list) {
									obj.getAdvs().add(advs.get(i));
								}
							}
						}
					}
				} else {
					obj.setApImgPath(ap.getApImgPath());
					obj.setApText(ap.getApText());
					obj.setApAccUrl(ap.getApAccUrl());
					Advert adv = new Advert();
					adv.setAdUrl(obj.getApAccUrl());
					adv.setAdImgPath(ap.getApImgPath());
					obj.setAdvs(Lists.newArrayList(adv));
					obj.setApLocation(ap.getApLocation());
				}
				if (obj.getApStatus() == 1) {
					mv.addObject("obj", obj);
				} else {
					mv.addObject("obj", new AdvertPosition());
				}
			}
		}
		return mv;
	}

	/**
	 * 服务首页广告专用
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/group/advert_invoke_group.htm")
	public ModelAndView advert_invoke_group(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("advert_invoke_group.html", configService.getSysConfig(), 1,
				request, response);
		Area city = (Area) request.getAttribute(LbsInterceptorAdapter.O2O_CITY);
		AdvertPosition obj = advertPositionService.findByCode("GROUP_HOME_SLIDE");
		List<AdvertBO> advertList = advertService.currCityGroupHomeAdver(city);
		mv.addObject("obj", obj);
		mv.addObject("advertList", advertList);

		return mv;
	}

	/**
	 * 服务首页广告专用的广告URL跳转方法
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param url
	 */
	@RequestMapping("/advert_redirect_group.htm")
	public void advert_redirect_group(HttpServletRequest request, HttpServletResponse response, String id,
			String url) {
		try {
			Advert adv = advertService.getObjById(CommUtil.null2Long(id));
			if (adv != null) {
				advertService.increaseClickNum(CommUtil.null2Long(id));
				if ("5".equals(adv.getAdType())) // 商户
					response.sendRedirect(CommUtil.getURL(request) + "/group/store.htm?id=" + adv.getAdUrl());
				else if ("6".equals(adv.getAdType())) // 服务
					response.sendRedirect(CommUtil.getURL(request) + "/group/view_" + adv.getAdUrl() + ".htm");
				else
					response.sendRedirect(CommUtil.getURL(request) + "/");
			} else
				response.sendRedirect(CommUtil.getURL(request) + "/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 广告URL跳转方法
	 * 
	 * @param request
	 * @param response
	 * @param url
	 * @param id
	 */
	@RequestMapping("/advert_redirect.htm")
	public void advert_redirect(HttpServletRequest request, HttpServletResponse response, String id,
			String url) {
		try {
			Advert adv = this.advertService.getObjById(CommUtil.null2Long(id));
			if (adv != null) {
				this.advertService.increaseClickNum(CommUtil.null2Long(id));
				url = adv.getAdUrl();
			}
			if (url.startsWith("http")) {
				response.sendRedirect(url);
			} else {
				response.sendRedirect(CommUtil.getURL(request) + "/" + url);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
