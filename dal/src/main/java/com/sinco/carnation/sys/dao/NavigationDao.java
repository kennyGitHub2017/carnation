package com.sinco.carnation.sys.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sys.bo.NavigationBO;
import com.sinco.carnation.sys.mapper.NavigationMapper;
import com.sinco.carnation.sys.model.Navigation;
import com.sinco.carnation.sys.model.NavigationExample;
import com.sinco.dal.common.MyPage;

@Repository
public class NavigationDao {

	@Autowired
	private NavigationMapper mapper;

	/**
	 * 根据location 查找
	 * 
	 * @param location
	 * @param count
	 * @param type
	 * @return
	 */
	public List<NavigationBO> findByLocation(Integer location, Integer count, String notType) {
		return mapper.findByLocation(location, count, notType);
	}

	/** generate code begin **/
	public List<NavigationBO> findAll() {
		NavigationExample example = new NavigationExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		NavigationExample example = new NavigationExample();
		return mapper.countByExample(example);
	}

	@SuppressWarnings("rawtypes")
	public List<Map> selectByTitle(String title, MyPage<Map> page) {
		return mapper.selectByTitle(title, page);
	}

	public List<Navigation> save(Iterable<Navigation> entities) {
		List<Navigation> list = new ArrayList<Navigation>();
		for (Navigation Navigation : entities) {
			list.add(save(Navigation));
		}
		return list;
	}

	public Navigation save(Navigation record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(Navigation record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public NavigationBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public NavigationBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		NavigationExample example = new NavigationExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<NavigationBO> findAll(Iterable<Long> ids) {
		NavigationExample example = new NavigationExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Navigation entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Navigation> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Navigation entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		NavigationExample example = new NavigationExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		NavigationExample example = new NavigationExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
