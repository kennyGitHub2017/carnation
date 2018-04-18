package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.sns.bo.FoodCaloriesBO;
import com.sinco.carnation.sns.mapper.FoodCaloriesMapper;
import com.sinco.carnation.sns.model.FoodCalories;
import com.sinco.carnation.sns.model.FoodCaloriesExample;
import com.sinco.carnation.sns.vo.FoodCaloriesVO;
import com.sinco.dal.common.MyPage;

@Repository
public class FoodCaloriesDao {

	@Autowired
	private FoodCaloriesMapper mapper;

	/** generate code begin **/
	public List<FoodCaloriesBO> findAll() {
		FoodCaloriesExample example = new FoodCaloriesExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		FoodCaloriesExample example = new FoodCaloriesExample();
		return mapper.countByExample(example);
	}

	public List<FoodCalories> save(Iterable<FoodCalories> entities) {
		List<FoodCalories> list = new ArrayList<FoodCalories>();
		for (FoodCalories FoodCalories : entities) {
			list.add(save(FoodCalories));
		}
		return list;
	}

	public FoodCalories save(FoodCalories record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(FoodCalories record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public FoodCaloriesBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public FoodCaloriesBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Integer id) {
		FoodCaloriesExample example = new FoodCaloriesExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	// List<FoodCaloriesBO> findAll(Iterable<Long> ids){
	// FoodCaloriesExample example=new FoodCaloriesExample();
	// example.createCriteria().andIdIn(Lists.newArrayList(ids));
	// return mapper.selectByExample(example);
	// }

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(FoodCalories entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	// public void delete(Iterable<FoodCalories> entities){
	// List<Long> ids=Lists.newArrayList();
	// for (FoodCalories entity: entities) {
	// ids.add(entity.getId());
	// }
	// deleteByIds(ids);
	// }
	//
	// public void deleteByIds(Iterable<Long> ids){
	// FoodCaloriesExample example=new FoodCaloriesExample();
	// example.createCriteria().andIdIn(Lists.newArrayList(ids));
	// mapper.deleteByExample(example);
	// }

	public void deleteAll() {
		FoodCaloriesExample example = new FoodCaloriesExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<FoodCaloriesBO> findPageByVO(MyPage<FoodCaloriesBO> page, FoodCaloriesVO vo) {
		return this.mapper.findPageByVO(page, vo);
	}

	public void add(FoodCalories foodCalories) {
		this.mapper.insert(foodCalories);
	}

	public List<FoodCaloriesBO> queryFoodCaloriesById(Long classId) {
		return mapper.queryFoodCaloriesById(classId);
	}

	public List<FoodCaloriesBO> findByClassId(Long id) {
		FoodCaloriesExample example = new FoodCaloriesExample();
		example.createCriteria().andClassIdEqualTo(id);
		return this.mapper.selectByExample(example);
	}

	public void delete(List<Long> idList) {
		this.mapper.deleteByIdList(idList);
	}
}
