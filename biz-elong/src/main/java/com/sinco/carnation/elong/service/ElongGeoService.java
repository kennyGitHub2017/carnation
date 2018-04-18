package com.sinco.carnation.elong.service;

import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.elong.dao.ElongGeoDao;
import com.sinco.carnation.elong.model.ElongGeo;
import com.sinco.carnation.elong.model.elong.HotelGeoList;
import com.sinco.carnation.elong.model.elong.HotelGeos;
import com.sinco.carnation.elong.model.elong.LocationObj;
import com.sinco.carnation.elong.util.XmlUtil;

@Service
@Transactional(rollbackFor = {ServiceException.class})
public class ElongGeoService {
	@Autowired
	private ElongGeoDao elongGeoDao;

	/**
	 * 导入艺龙地域数据
	 */
	public void saveGeoInfo() {
		try {
			HotelGeos geo = XmlUtil.xmlToObject("D://elong.xml", HotelGeos.class);
			if (null != geo) {
				List<HotelGeoList> hotelGeoList = geo.getHotelGeoList();
				if (null != hotelGeoList) {
					for (HotelGeoList item : hotelGeoList) {
						ElongGeo selected = elongGeoDao.getGeoByAreaCode(CommUtil.null2Long(item
								.getProvinceId()));
						if (null == selected) {
							// 保存省份信息
							ElongGeo addProvince = new ElongGeo();
							addProvince.setAreaCode(CommUtil.null2Long(item.getProvinceId()));
							addProvince.setAreaName(item.getProvinceName());
							addProvince.setDeleteStatus(0);
							addProvince.setIsGroupHot(false);
							addProvince.setLevel(0);
							addProvince.setCreateTime(new Date());
							addProvince.setLastUpdateTime(new Date());
							elongGeoDao.save(addProvince);
							System.out.println("save province succes====geoAreaCode" + item.getProvinceId());
						}
						// 保存城市信息
						if (!"3800".equals(item.getCityCode())) {
							ElongGeo addCity = new ElongGeo();
							addCity.setAreaCode(CommUtil.null2Long(item.getCityCode()));
							addCity.setAreaName(item.getCityName());
							addCity.setDeleteStatus(0);
							addCity.setIsGroupHot(false);
							addCity.setLevel(1);
							addCity.setParentCode(CommUtil.null2Long(item.getProvinceId()));
							addCity.setCreateTime(new Date());
							addCity.setLastUpdateTime(new Date());
							elongGeoDao.save(addCity);
							System.out.println("save city succes====geoAreaCode" + item.getCityCode());
						}
						// 保存区域信息
						List<LocationObj> districts = item.getDistricts();
						if (null != districts) {
							for (LocationObj location : districts) {
								ElongGeo addDistrict = new ElongGeo();
								addDistrict.setAreaCode(CommUtil.null2Long(location.getId()));
								addDistrict.setAreaName(location.getName());
								addDistrict.setDeleteStatus(0);
								addDistrict.setIsGroupHot(false);
								addDistrict.setLevel(2);
								addDistrict.setParentCode(CommUtil.null2Long(item.getCityCode()));
								addDistrict.setCreateTime(new Date());
								addDistrict.setLastUpdateTime(new Date());
								elongGeoDao.save(addDistrict);
								System.out.println("save district succes====geoAreaCode" + location.getId());
							}
						}
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public List<ElongGeo> getGeoByAreaName(String areaName) {
		List<ElongGeo> result = elongGeoDao.getGeoByAreaName(areaName);
		return result;
	}

	public ElongGeo getGeoByAreaCode(Long areaCode) {
		ElongGeo result = elongGeoDao.getGeoByAreaCode(areaCode);
		return result;
	}
}
