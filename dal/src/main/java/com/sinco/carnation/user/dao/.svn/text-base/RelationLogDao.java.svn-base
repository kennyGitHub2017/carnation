package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.user.mapper.RelationLogMapper;
import com.sinco.carnation.user.model.RelationLog;
import com.sinco.carnation.user.bo.RelationLogBO;
import com.sinco.carnation.user.model.RelationLogExample;

@Repository
public class RelationLogDao {

	@Autowired
	private RelationLogMapper mapper;


   /** generate code begin**/
	public List<RelationLogBO> findAll(){
		RelationLogExample example=new RelationLogExample();
		return mapper.selectByExample(example);
	}
	List<RelationLogBO> findAll(Iterable<Long> ids){
		RelationLogExample example=new RelationLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}
	
	public long count(){
		RelationLogExample example=new RelationLogExample();
		return mapper.countByExample(example);
	}

	public List<RelationLog> save(Iterable<RelationLog> entities){
		List<RelationLog> list=new ArrayList<RelationLog>();
		for (RelationLog RelationLog : entities) {
			list.add(save(RelationLog));
		}
		return list;
	}
	
	public RelationLog save(RelationLog record){
		if(null == record){
			return null;
		}
		record.setModifyTime(new Date());
		if(record.getId() == null){
			record.setCreateTime(new Date());
			mapper.insertSelective(record);
		}else{
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}
	
	/** 修改 **/
	public void update(RelationLog record) {
		if(record == null){
			return;
		}
		record.setModifyTime(new Date());
		mapper.updateByPrimaryKeySelective(record);
	}
	
	public RelationLogBO findOne(java.lang.Long id){
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id){
		RelationLogExample example=new RelationLogExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}
	
	 public void delete(java.lang.Long id){
		 mapper.deleteByPrimaryKey(id);
	 }
	 
	 public void remove(java.lang.Long id){
		 mapper.deleteByPrimaryKey(id);
	 }

	public void delete(RelationLog entity){
		 mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<RelationLog> entities){
		List<Long> ids=Lists.newArrayList();
		for (RelationLog  entity: entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}
	
	public void deleteByIds(Iterable<Long> ids){
		RelationLogExample example=new RelationLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		 mapper.deleteByExample(example);
	}

	public void deleteAll(){
		RelationLogExample example=new RelationLogExample();
		mapper.deleteByExample(example);
	}
	/** generate code end**/
}
