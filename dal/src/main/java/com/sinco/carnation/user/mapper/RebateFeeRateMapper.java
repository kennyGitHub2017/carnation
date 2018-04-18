package com.sinco.carnation.user.mapper;

import java.util.List;

import com.sinco.carnation.user.bo.RebateFeeRateBO;
import com.sinco.carnation.user.model.RebateFeeRateExample;

public interface RebateFeeRateMapper {

	List<RebateFeeRateBO> selectByExample(RebateFeeRateExample example);

}