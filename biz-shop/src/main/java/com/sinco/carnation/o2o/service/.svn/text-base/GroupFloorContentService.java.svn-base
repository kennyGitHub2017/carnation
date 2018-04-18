package com.sinco.carnation.o2o.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.o2o.bo.GroupFloorContentBO;
import com.sinco.carnation.o2o.dao.GroupFloorContentDao;
import com.sinco.carnation.o2o.model.GroupFloorContent;

/**
 * <p>
 * Title: GroupCaseService.java
 * </p>
 * 
 * <p>
 * Description: 团购橱窗商品相关业务实现
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 深圳市新科聚合网络技术有限公司 www.thinker.vc
 * </p>
 * 
 * @author t2w
 * @date 2015-9-8
 * @version 1.0.1
 */
@Service
@Transactional
public class GroupFloorContentService {

	@Autowired
	private GroupFloorContentDao groupFloorContentDao;

	/**
	 * 保存团购 橱窗商品
	 * 
	 * @param groupCase
	 * @return isSuccess
	 */
	public boolean save(GroupFloorContent groupFloorContent) {
		try {
			groupFloorContentDao.save(groupFloorContent);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 删除团购 楼层商品
	 * 
	 * @param id
	 * @return isSuccess
	 */
	public boolean delete(Long id) {
		try {
			groupFloorContentDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 根据groupFloorId查询团购 楼层商品
	 */
	public List<GroupFloorContentBO> groupCaseGoodsList(Long floorId) {
		return groupFloorContentDao.queryGroupCaseContentlistByFloorId(floorId);
	}

	/**
	 * 根据groupFloorId和cityId查询团购 橱窗商品
	 */
	public List<GroupFloorContentBO> queryGroupCaseContentlistByFloorIdAndCityId(Long floorId, Long cityId) {
		return groupFloorContentDao.queryGroupCaseContentlistByFloorIdAndCityId(floorId, cityId);
	}
}
