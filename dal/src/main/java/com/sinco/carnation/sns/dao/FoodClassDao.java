package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.sns.bo.FoodClassBO;
import com.sinco.carnation.sns.mapper.FoodClassMapper;
import com.sinco.carnation.sns.model.FoodClass;
import com.sinco.carnation.sns.model.FoodClassExample;
import com.sinco.carnation.sns.vo.FoodClassVO;
import com.sinco.dal.common.MyPage;

@Repository
public class FoodClassDao {

	@Autowired
	private FoodClassMapper mapper;

	/** generate code begin **/
	public List<FoodClassBO> findAll() {
		FoodClassExample example = new FoodClassExample();
		example.createCriteria().andDeleteStatusEqualTo(false);
		return mapper.selectByExample(example);
	}

	public long count() {
		FoodClassExample example = new FoodClassExample();
		return mapper.countByExample(example);
	}

	public List<FoodClass> save(Iterable<FoodClass> entities) {
		List<FoodClass> list = new ArrayList<FoodClass>();
		for (FoodClass FoodClass : entities) {
			list.add(save(FoodClass));
		}
		return list;
	}

	public FoodClass save(FoodClass record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public FoodClass add(FoodClass record) {
		mapper.insert(record);
		return record;
	}

	public void update(FoodClass record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public FoodClassBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public FoodClassBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		FoodClassExample example = new FoodClassExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	// List<FoodClassBO> findAll(Iterable<Long> ids){
	// FoodClassExample example=new FoodClassExample();
	// example.createCriteria().andIdIn(Lists.newArrayList(ids));
	// return mapper.selectByExample(example);
	// }

	public void delete(java.lang.Integer id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Integer id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(FoodClass entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	// public void delete(Iterable<FoodClass> entities){
	// List<Long> ids=Lists.newArrayList();
	// for (FoodClass entity: entities) {
	// ids.add(entity.getId());
	// }
	// deleteByIds(ids);
	// }
	//
	// public void deleteByIds(Iterable<Long> ids){
	// FoodClassExample example=new FoodClassExample();
	// example.createCriteria().andIdIn(Lists.newArrayList(ids));
	// mapper.deleteByExample(example);
	// }

	public void deleteAll() {
		FoodClassExample example = new FoodClassExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<FoodClassBO> findPageByVO(MyPage<FoodClassBO> page, FoodClassVO vo) {
		return this.mapper.findPageByVO(page, vo);
	}

	public List<FoodClassBO> findListByParentId(Long id) {
		FoodClassExample ex = new FoodClassExample();
		ex.createCriteria().andParentIdEqualTo(id).andDeleteStatusEqualTo(false);
		return this.mapper.selectByExample(ex);
	}

	public void updateDeleteStatus(Long... array) {
		this.mapper.updateDeleteStatus(array);
	}

	public List<FoodClassBO> queryFoodList(Integer parentId, MyPage<FoodClassBO> page) {
		return mapper.queryFoodList(parentId, page);
	}
}
