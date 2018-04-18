package com.sinco.carnation.elong.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.elong.mapper.ElongGeoMapper;
import com.sinco.carnation.elong.model.ElongGeo;

@Repository
public class ElongGeoDao {

	@Autowired
	private ElongGeoMapper mapper;

	/**
	 * 保存艺龙地域数据
	 * 
	 * @param order
	 */
	public void save(ElongGeo geo) {
		mapper.insertSelective(geo);
	}

	/**
	 * 根据区域编号查询省份信息
	 * 
	 * @param areaName
	 * @return
	 */
	public ElongGeo getGeoByAreaCode(Long areaCode) {
		return mapper.selectByAreaCode(areaCode);
	}

	/**
	 * 根据区域名称查询地域信息
	 * 
	 * @param areaName
	 * @return
	 */
	public List<ElongGeo> getGeoByAreaName(String areaName) {
		return mapper.queryGeoByName(areaName);
	}
}
