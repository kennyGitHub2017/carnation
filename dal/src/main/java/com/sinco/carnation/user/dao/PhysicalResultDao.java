package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.user.bo.PhysicalResultBO;
import com.sinco.carnation.user.mapper.PhysicalResultMapper;
import com.sinco.carnation.user.model.PhysicalResult;
import com.sinco.carnation.user.model.PhysicalResultExample;
import com.sinco.carnation.user.vo.PhysicalResultVO;
import com.sinco.dal.common.MyPage;

@Repository
public class PhysicalResultDao {

	@Autowired
	private PhysicalResultMapper mapper;

	/** generate code begin **/
	public List<PhysicalResultBO> findAll() {
		PhysicalResultExample example = new PhysicalResultExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		PhysicalResultExample example = new PhysicalResultExample();
		return mapper.countByExample(example);
	}

	public List<PhysicalResult> save(Iterable<PhysicalResult> entities) {
		List<PhysicalResult> list = new ArrayList<PhysicalResult>();
		for (PhysicalResult PhysicalResult : entities) {
			list.add(save(PhysicalResult));
		}
		return list;
	}

	public PhysicalResult save(PhysicalResult record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public boolean update(PhysicalResult record) {
		if (mapper.updateByPrimaryKeySelective(record) > 0)
			return true;
		else
			return false;
	}

	public PhysicalResultBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public PhysicalResultBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		PhysicalResultExample example = new PhysicalResultExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<PhysicalResultBO> findAll(Iterable<Long> ids) {
		PhysicalResultExample example = new PhysicalResultExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(PhysicalResult entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<PhysicalResult> entities) {
		List<Long> ids = Lists.newArrayList();
		for (PhysicalResult entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		PhysicalResultExample example = new PhysicalResultExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		PhysicalResultExample example = new PhysicalResultExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public PhysicalResult queryPhysicalResult(String createBy, String code, String time) {
		return mapper.queryPhysicalResult(createBy, code, time);
	}

	public List<PhysicalResultBO> queryPhysicalResultList(String createBy, String time) {
		return mapper.queryPhysicalResultList(createBy, time);
	}

	public PhysicalResultBO queryPhysicalResultByCond(Float minValue, Float maxValue, Float middleValue,
			Integer type, int sex, int age) {
		return mapper.queryPhysicalResultByCond(minValue, maxValue, middleValue, type, sex, age);
	}

	public List<PhysicalResultBO> selectPhysicalResultList(Long userId, Integer itemCode, Integer lmt) {
		return mapper.selectPhysicalResultList(userId, itemCode, lmt);
	}

	public List<PhysicalResultBO> selectPhysicalResultByVO(PhysicalResultVO vo, MyPage<PhysicalResultBO> page) {
		return mapper.selectPhysicalResultByVO(vo, page);
	}

	public int updateByIdForIsDel(Integer id, boolean isdel) {
		return mapper.updateByIdForIsDel(id, isdel);
	}

	public List<PhysicalResultBO> selectPhysicalResultByUserIdSix(Long userId) {
		return mapper.selectPhysicalResultByUserIdSix(userId);
	}

	/** 查询未加分记录 **/
	public List<PhysicalResultBO> listByisAddIntegral(){
		return mapper.listByisAddIntegral();
	}
	/** 更新加分状态 **/
	public int updateIsAddIntegralByid(Long id){
		return mapper.updateIsAddIntegralByid(id);
	}
}
