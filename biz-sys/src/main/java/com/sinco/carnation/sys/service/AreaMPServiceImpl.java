package com.sinco.carnation.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.sys.bo.AreaMPBO;
import com.sinco.carnation.sys.dao.AreaMPDao;

@Service
@Transactional(readOnly = true)
public class AreaMPServiceImpl {
	@Autowired
	private AreaMPDao areaMPDao;

	public AreaMPBO getYSAreaCode(String elongCityCode, String elongDistrictCode) {
		return areaMPDao.getYSAreaCode(elongCityCode, elongDistrictCode);
	}
}
