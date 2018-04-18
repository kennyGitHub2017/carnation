package com.sinco.carnation.goods.tools;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.google.common.collect.Lists;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.bo.GoodsCaseBO;
import com.sinco.carnation.goods.dao.GoodsCaseDao;
import com.sinco.carnation.goods.dao.GoodsDao;
import com.sinco.carnation.goods.vo.GoodsShowListVO;

/**
 * 
 * <p>
 * Title: GoodsCaseViewTools.java
 * </p>
 * 
 * <p>
 * Description: 橱窗工具类
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 新科聚合 thinker.vc
 * </p>
 * 
 * @author thinker
 * 
 * @date 2014-11-24
 * 
 * @version 1.0.1
 */
@Component
public class GoodsCaseViewTools {

	@Autowired
	private GoodsCaseDao goodsCaseDao;
	@Autowired
	private GoodsDao goodsDao;

	/**
	 * 得到购物车session id
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String getCartSessionId(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("cart_session_id")) {
					return CommUtil.null2String(cookie.getValue());
				}
			}
		}
		String cart_session_id = UUID.randomUUID().toString();
		Cookie cookie = new Cookie("cart_session_id", cart_session_id);
		cookie.setDomain(CommUtil.generic_domain(request));
		response.addCookie(cookie);
		return cart_session_id;
	}

	public List<GoodsCaseBO> queryGoodsCase(String case_id) {
		return this.goodsCaseDao.findCaseId(case_id, true, 5);
	}

	@SuppressWarnings("rawtypes")
	public List<GoodsBO> queryCaseGoods(String case_content) {
		if (StringUtils.isNotBlank(case_content)) {
			List list = (List) Json.fromJson(case_content);
			List<Long> goodsIds = Lists.newArrayList();
			if (list.size() > 6) {
				for (Object id : list.subList(0, 6)) {
					goodsIds.add(CommUtil.null2Long(id));
				}

			} else {
				for (Object id : list) {
					goodsIds.add(CommUtil.null2Long(id));
				}
			}
			GoodsShowListVO vo = new GoodsShowListVO();
			vo.setIds(goodsIds);

			return this.goodsDao.findShopListBO(vo);
		}
		return null;
	}
}
