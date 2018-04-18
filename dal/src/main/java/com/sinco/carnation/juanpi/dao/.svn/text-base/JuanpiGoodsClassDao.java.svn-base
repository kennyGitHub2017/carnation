package com.sinco.carnation.juanpi.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.juanpi.mapper.JuanpiGoodsClassMapper;
import com.sinco.carnation.juanpi.model.JuanpiGoodsClass;
import com.sinco.carnation.juanpi.bo.JuanpiGoodsClassBO;
import com.sinco.carnation.juanpi.model.JuanpiGoodsClassExample;
import com.sinco.carnation.juanpi.vo.JuanpiGoodsClassVO;
import com.sinco.dal.common.MyPage;

@Repository
public class JuanpiGoodsClassDao {

	@Autowired
	private JuanpiGoodsClassMapper mapper;

	/** generate code begin **/
	public List<JuanpiGoodsClassBO> findAll() {
		JuanpiGoodsClassExample example = new JuanpiGoodsClassExample();
		return mapper.selectByExample(example);
	}

	List<JuanpiGoodsClassBO> findAll(Iterable<Long> ids) {
		JuanpiGoodsClassExample example = new JuanpiGoodsClassExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		JuanpiGoodsClassExample example = new JuanpiGoodsClassExample();
		return mapper.countByExample(example);
	}

	public List<JuanpiGoodsClass> save(Iterable<JuanpiGoodsClass> entities) {
		List<JuanpiGoodsClass> list = new ArrayList<JuanpiGoodsClass>();
		for (JuanpiGoodsClass JuanpiGoodsClass : entities) {
			list.add(save(JuanpiGoodsClass));
		}
		return list;
	}

	public JuanpiGoodsClass save(JuanpiGoodsClass record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(JuanpiGoodsClass record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public JuanpiGoodsClassBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		JuanpiGoodsClassExample example = new JuanpiGoodsClassExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(JuanpiGoodsClass entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<JuanpiGoodsClass> entities) {
		List<Long> ids = Lists.newArrayList();
		for (JuanpiGoodsClass entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		JuanpiGoodsClassExample example = new JuanpiGoodsClassExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		JuanpiGoodsClassExample example = new JuanpiGoodsClassExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<JuanpiGoodsClassBO> findByClass3Id(Long class3Id) {
		JuanpiGoodsClassExample example = new JuanpiGoodsClassExample();
		example.createCriteria().andClass3IdEqualTo(class3Id);
		return mapper.selectByExample(example);
	}

	public int synClass(JuanpiGoodsClass cls) {
		return mapper.synClass(cls);
	}

	public List<JuanpiGoodsClassBO> pageByVO(MyPage<JuanpiGoodsClassBO> page, JuanpiGoodsClassVO vo) {
		List<JuanpiGoodsClassBO> result = new ArrayList<>();
		result = mapper.pageByVO(page, vo);
		return result == null ? new ArrayList<JuanpiGoodsClassBO>() : result;
	}

	public int saveResult(JuanpiGoodsClass record) {
		record.setUpdateTime(new Date());
		if (record.getId() == null) {
			record.setAddTime(new Date());
			return mapper.insertSelective(record);
		} else {
			return mapper.updateByPrimaryKeySelective(record);
		}
	}
	
	public void deleteUnsynJuanpiClass() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		mapper.deleteUnsynJuanpiClass(cal.getTime());
	}
	
	public List<JuanpiGoodsClassBO> listByLevelId(String level ,Long classId ,Integer isJoin) {
		return mapper.listByLevelId(level, classId ,isJoin);
	}

}
