package com.sinco.carnation.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.sys.bo.AreaAdBO;
import com.sinco.carnation.sys.dao.AreaAdDao;
import com.sinco.data.core.Page;

@Service
@Transactional
public class AreaAdService {
	@Autowired
	private AreaAdDao areaAdDao;
	
	/**
	 * 分页查询专区列表数据
	 * @param areaAd 查询实体
	 * @param page
	 */
	public void findPage(AreaAdBO areaAd, Page<AreaAdBO> page) {
		areaAdDao.findPage(areaAd, page);
	}

	/**
	 * 根据专区ID查询
	 * @param id 专区ID
	 * @return
	 */
	public AreaAdBO getById(Long id) {
		return id == null ? null : areaAdDao.findOne(id);
	}

	/**
	 * 保存或更新专区数据
	 * @param areaAd
	 */
	public void saveOrUpdate(AreaAdBO areaAd) {
		if(areaAd.getId() == null){
			areaAdDao.save(areaAd);
		}else{
			areaAdDao.update(areaAd);
		}
	}

	/**
	 * 删除专区数据
	 * @param id 专区ID
	 */
	public void delete(Long id) {
		areaAdDao.delete(id);
	}
	
	public List<AreaAdBO> findAllShow(){
		return areaAdDao.findAllShow();
	}

	public boolean checkCodeExists(Long id, String code) {
		return areaAdDao.checkCodeExists(id, code);
	}

	
	
		
}
