package com.sinco.carnation.elong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.elong.model.ElongGeo;

public interface ElongGeoMapper {

	int insertSelective(ElongGeo geo);

	ElongGeo selectByPrimaryKey(Long id);

	ElongGeo selectByAreaCode(Long areaCode);
	
	List<ElongGeo> queryGeoByName(@Param("areaName") String areaName);
}