package com.sinco.carnation.sys.mapper;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.sys.bo.AreaMPBO;

public interface AreaMPMapper {
	AreaMPBO selectYSAreaCode(@Param("elongCityCode") String elongCityCode,
			@Param("elongDistrictCode") String elongDistrictCode);
}