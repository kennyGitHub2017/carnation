package com.sinco.carnation.shop.tools;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinco.carnation.shop.bo.ConsultBO;
import com.sinco.carnation.shop.dao.ConsultDao;
import com.sinco.carnation.shop.model.ConsultExample;
import com.sinco.carnation.shop.model.ConsultExample.Criteria;

import vc.thinker.b2b2c.core.tools.CommUtil;

/**
 * 
 * <p>
 * Title: ConsultViewTools.java
 * </p>
 * 
 * <p>
 * Description: 商品咨询管理类，用于前端velocity中的信息查询并显示
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
public class ConsultViewTools {
	@Autowired
	private ConsultDao consultDao;

	/**
	 * 根据分类查询所有该分类的商品咨询
	 * 
	 * @param type
	 *            咨询类型
	 * @return 返回商品咨询列表
	 */
	public List<ConsultBO> queryByType(String type, String goods_id) {
		List<ConsultBO> list = new ArrayList<ConsultBO>();
		ConsultExample example = new ConsultExample();
		Criteria criteria = example.createCriteria().andDeleteStatusEqualTo(false)
				.andGoodsIdEqualTo(CommUtil.null2Long(goods_id));
		example.setOrderByClause(" add_time desc");
		if (!CommUtil.null2String(type).equals("")) {
			criteria.andConsultTypeEqualTo(type);
		}
		list = consultDao.findByExample(example);
		return list;
	}

}
