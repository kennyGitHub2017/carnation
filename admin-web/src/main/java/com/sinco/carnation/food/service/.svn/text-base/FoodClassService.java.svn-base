package com.sinco.carnation.food.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinco.carnation.sns.bo.FoodCaloriesBO;
import com.sinco.carnation.sns.bo.FoodClassBO;
import com.sinco.carnation.sns.dao.FoodCaloriesDao;
import com.sinco.carnation.sns.dao.FoodClassDao;
import com.sinco.carnation.sns.model.FoodClass;
import com.sinco.carnation.sns.vo.FoodClassVO;
import com.sinco.dal.common.MyPage;

@Service
public class FoodClassService {

	@Autowired
	private FoodClassDao foodClassDao;
	@Autowired
	private FoodCaloriesDao foodCaloriesDao;

	public void findPageByVO(MyPage<FoodClassBO> page, FoodClassVO vo) {
		this.foodClassDao.findPageByVO(page, vo);
	}

	public List<FoodClassBO> findListByParentId(Long id) {
		return this.foodClassDao.findListByParentId(id);
	}

	public boolean save(FoodClass foodClass) {
		boolean result = Boolean.FALSE;
		try {
			this.foodClassDao.add(foodClass);
			result = Boolean.TRUE;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public boolean update(FoodClass foodClass) {
		boolean result = Boolean.FALSE;
		try {
			this.foodClassDao.update(foodClass);
			result = Boolean.TRUE;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public FoodClass getById(Long id) {
		return this.foodClassDao.get(id);
	}

	public void delete(Long... array) {
		List<Long> idList = new ArrayList<Long>();
		for (Long id : array) {
			List<FoodCaloriesBO> list = this.foodCaloriesDao.findByClassId(id);
			for (FoodCaloriesBO bo : list) {
				idList.add(bo.getId());
			}
		}

		if (idList != null && idList.size() > 0) {
			this.foodCaloriesDao.delete(idList);
		}

		this.foodClassDao.updateDeleteStatus(array);
	}

	public List<FoodClassBO> findAll() {
		return this.foodClassDao.findAll();
	}

}
