package com.sinco.carnation.sys.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.sys.bo.AreaMPBO;
import com.sinco.carnation.sys.mapper.AreaMPMapper;

/**
 * 地域映射DAO
 * 
 * @author xing.wen
 *
 */
@Repository
public class AreaMPDao {

	@Autowired
	private AreaMPMapper mapper;

	/**
	 * 查找服务热闹城市
	 * 
	 * @return
	 */
	public AreaMPBO getYSAreaCode(String elongCityCode, String elongDistrictCode) {
		return mapper.selectYSAreaCode(elongCityCode, elongDistrictCode);
	}
}
