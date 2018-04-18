package com.sinco.carnation.evaluate.tools;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.evaluate.service.EvaluateService;
import com.sinco.carnation.shop.model.Evaluate;
import com.sinco.carnation.shop.model.EvaluateExample;
import com.sinco.carnation.shop.model.EvaluateExample.Criteria;
import com.sinco.carnation.sys.model.Accessory;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;

/**
 * 
 * <p>
 * Title: EvaluateViewTools.java
 * </p>
 * 
 * <p>
 * Description:商品评价查询类，用来查询商品评价信息并在前台显示
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
 * @date 2014-9-29
 * 
 * @version 1.0.1
 */
@Component
public class EvaluateViewTools {
	@Autowired
	private EvaluateService evaluateService;
	@Autowired
	private AccessoryServiceImpl accessoryService;

	public List<Evaluate> queryByEva(String goods_id, String eva) {
		EvaluateExample query = new EvaluateExample();
		Criteria criteria = query.createCriteria().andEvaluateGoodsIdEqualTo(CommUtil.null2Long(goods_id))
				.andEvaluateTypeEqualTo("goods").andEvaluateStatusEqualTo(0).andDeleteStatusEqualTo(0);
		List<Evaluate> list = new ArrayList<Evaluate>();
		if (eva.equals("100")) {
			criteria.andEvaluatePhotosIsNotNull().andEvaluatePhotosNotEqualTo("");
			list = evaluateService.selectByExample(query);
		} else if (eva.equals("all")) {
			list = evaluateService.selectByExample(query);
		} else {
			// 查询好评数
			criteria.andEvaluateBuyerValEqualTo(CommUtil.null2Int(eva));
			list = evaluateService.selectByExample(query);
		}
		return list;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	public List queryEvaImgSrc(String ids) {
		List list = new ArrayList();
		if (ids != null && !ids.equals("")) {
			for (String str : ids.split(",")) {
				if (str != null && !str.equals("")) {
					Accessory img = this.accessoryService.getObjById(CommUtil.null2Long(str));
					if (img != null) {
						list.add(img);
					}
				}
			}
		}

		return list;
	}
}
