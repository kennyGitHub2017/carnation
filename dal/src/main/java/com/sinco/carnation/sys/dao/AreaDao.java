package com.sinco.carnation.sys.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sys.bo.AreaBO;
import com.sinco.carnation.sys.mapper.AreaMapper;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.model.AreaExample;
import com.sinco.carnation.sys.model.AreaExample.Criteria;
import com.sinco.dal.common.MyPage;
import com.sinco.data.core.Page;

@Repository
public class AreaDao {

	@Autowired
	private AreaMapper mapper;
	
	/**
	 * 查找服务热闹城市
	 * @return
	 */
	public List<Area> findGroupHotCity(){
		AreaExample example=new AreaExample();
		example.createCriteria().andIsGroupHotEqualTo(true);
		example.setOrderByClause(" sequence ");
		return mapper.selectByExample(example);
	}
	
	/**
	 * 查找服务热门城市
	 * @return
	 */
	public List<AreaBO> findGroupHotCityByPage(@Param("page") Page<AreaBO> page){
		List<AreaBO> list=mapper.findGroupHotCityByPage(page);
		page.setContent(list);
		return list;
	}
	
	public Area findParentById(Long id){
		return mapper.findParentById(id);
	}

	public Area findCityByName(String name){
		AreaExample example=new AreaExample();
		example.createCriteria().andLevelEqualTo(1).andAreaNameEqualTo(name);
		List<Area> list=mapper.selectByExample(example);
		return list.size() > 0 ? list.get(0):null;
	}

   /** generate code begin**/
	public List<Area> findAll(){
		AreaExample example=new AreaExample();
		return mapper.selectByExample(example);
	}
	
	public long count(){
		AreaExample example=new AreaExample();
		return mapper.countByExample(example);
	}

	public List<Area> save(Iterable<Area> entities){
		List<Area> list=new ArrayList<Area>();
		for (Area Area : entities) {
			list.add(save(Area));
		}
		return list;
	}
	
	@SuppressWarnings("rawtypes")
	public List<Map> selectByProvince() {
		return mapper.selectByProvince();
	}
	
	public Area save(Area record){
		if(record.getId() == null){
			mapper.insertSelective(record);
		}else{
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}
	

	public void update(Area record) {
		mapper.updateByPrimaryKeySelective(record);
	}
	
	public Area findOne(java.lang.Long id){
		return mapper.selectByPrimaryKey(id);
	}
	
	public Area get(java.lang.Long id){
		return mapper.selectByPrimaryKey(id);
	}


	public boolean exists(java.lang.Long id){
		AreaExample example=new AreaExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}


	List<Area> findAll(Iterable<Long> ids){
		AreaExample example=new AreaExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}
	
	 public void delete(java.lang.Long id){
		 mapper.deleteByPrimaryKey(id);
	 }
	 
	 public void remove(java.lang.Long id){
		 mapper.deleteByPrimaryKey(id);
	 }

	public void delete(Area entity){
		 mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Area> entities){
		List<Long> ids=Lists.newArrayList();
		for (Area  entity: entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}
	
	public void deleteByIds(Iterable<Long> ids){
		AreaExample example=new AreaExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		 mapper.deleteByExample(example);
	}

	public void deleteAll(){
		AreaExample example=new AreaExample();
		mapper.deleteByExample(example);
	}
	/** generate code end**/
	
	public List<Area> queryAreaByParentId(Long parentId){
		return mapper.queryAreaByParentId(parentId);
	}

	public List<Area> queryParentArea() {
		return mapper.queryParentArea();
	}
	
	public List<Area> queryAreaList(Long pid,MyPage<Area> page){
		return mapper.queryAreaList(pid,page);
	}
	
	public List<Area> findByParentId(Long parentId) {
		AreaExample example = new AreaExample();
		Criteria criteria = example.createCriteria();
		if (parentId == null) {
			criteria.andParentIdIsNull();
		} else {
			criteria.andParentIdEqualTo(parentId);
		}
		example.setOrderByClause(" sequence asc ");
		return mapper.selectByExample(example);
	}
	
	public Area queryAreaByName(String areaName){
		List<Area> area= mapper.queryAreaByName(areaName);
		return area.get(0);
	}
	
	public Area queryAreaByPidAndName(Long parentId , String areaName){
		return mapper.queryAreaByPidAndName(parentId,areaName);
	}
	
	public AreaBO selectNameByAreaId(Long areaId){
		return mapper.selectNameByAreaId(areaId);
	}
}
