package com.sinco.carnation.user.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.shop.RebateConstants;
import com.sinco.carnation.user.bo.RebateFeeRateBO;
import com.sinco.carnation.user.mapper.RebateFeeRateMapper;
import com.sinco.carnation.user.model.RebateFeeRateExample;

@Repository
public class RebateFeeRateDao {

	@Autowired
	private RebateFeeRateMapper mapper;

	@PostConstruct
	public void init() {
		List<RebateFeeRateBO> list = findAll();
		if (CollectionUtils.isNotEmpty(list)) {
			RebateConstants.MAP_FEE_RATE = new HashMap<>();
			for (RebateFeeRateBO rebateFeeRateBO : list) {
				RebateConstants.MAP_FEE_RATE.put(rebateFeeRateBO.getCode(), rebateFeeRateBO);
			}
		}
	}

	/** generate code begin **/
	public List<RebateFeeRateBO> findAll() {
		RebateFeeRateExample example = new RebateFeeRateExample();
		return mapper.selectByExample(example);
	}
}
