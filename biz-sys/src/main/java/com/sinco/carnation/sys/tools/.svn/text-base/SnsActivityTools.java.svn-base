package com.sinco.carnation.sys.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinco.carnation.sys.service.AreaServiceImpl;

@Component
public class SnsActivityTools {

	@Autowired
	private AreaServiceImpl areaService;

	public String getAreaInfoById(Long areaId) {
		System.out.println("areaName:" + areaService.areaName(areaId));
		return areaService.areaName(areaId);
	}
}
