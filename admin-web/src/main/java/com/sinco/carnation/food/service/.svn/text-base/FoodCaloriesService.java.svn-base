package com.sinco.carnation.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinco.carnation.sns.bo.FoodCaloriesBO;
import com.sinco.carnation.sns.dao.FoodCaloriesDao;
import com.sinco.carnation.sns.model.FoodCalories;
import com.sinco.carnation.sns.vo.FoodCaloriesVO;
import com.sinco.dal.common.MyPage;

@Service
public class FoodCaloriesService {

	@Autowired
	private FoodCaloriesDao foodCaloriesDao;

	public void findPageByVO(MyPage<FoodCaloriesBO> page, FoodCaloriesVO vo) {
		this.foodCaloriesDao.findPageByVO(page, vo);
	}

	public FoodCaloriesBO getById(Long id) {
		return this.foodCaloriesDao.get(id);
	}

	public void delete(Long... array) {
		for (Long id : array) {
			this.foodCaloriesDao.delete(id);
		}
	}

	public boolean save(FoodCalories foodCalories) {
		boolean result = Boolean.FALSE;
		try {
			this.foodCaloriesDao.add(foodCalories);
			result = Boolean.TRUE;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public boolean update(FoodCalories foodCalories) {
		boolean result = Boolean.FALSE;
		try {
			this.foodCaloriesDao.update(foodCalories);
			result = Boolean.TRUE;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

}
