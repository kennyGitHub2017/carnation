package com.sinco.carnation.market.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.market.mapper.ActivitySaleMessageMapper;
import com.sinco.carnation.market.model.ActivitySaleMessage;
import com.sinco.carnation.market.bo.ActivitySaleMessageBO;
import com.sinco.carnation.market.model.ActivitySaleMessageExample;

@Repository
public class ActivitySaleMessageDao {

	@Autowired
	private ActivitySaleMessageMapper mapper;


   /** generate code begin**/
	public List<ActivitySaleMessageBO> findAll(){
		ActivitySaleMessageExample example=new ActivitySaleMessageExample();
		return mapper.selectByExample(example);
	}
	List<ActivitySaleMessageBO> findAll(Iterable<Long> ids){
		ActivitySaleMessageExample example=new ActivitySaleMessageExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}
	
	public long count(){
		ActivitySaleMessageExample example=new ActivitySaleMessageExample();
		return mapper.countByExample(example);
	}

	public List<ActivitySaleMessage> save(Iterable<ActivitySaleMessage> entities){
		List<ActivitySaleMessage> list=new ArrayList<ActivitySaleMessage>();
		for (ActivitySaleMessage ActivitySaleMessage : entities) {
			list.add(save(ActivitySaleMessage));
		}
		return list;
	}
	
	public ActivitySaleMessage save(ActivitySaleMessage record){
		if(record.getId() == null){
			mapper.insertSelective(record);
		}else{
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}
	

	public void update(ActivitySaleMessage record) {
		mapper.updateByPrimaryKeySelective(record);
	}
	
	public ActivitySaleMessageBO findOne(java.lang.Long id){
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id){
		ActivitySaleMessageExample example=new ActivitySaleMessageExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}
	
	 public void delete(java.lang.Long id){
		 mapper.deleteByPrimaryKey(id);
	 }
	 
	 public void remove(java.lang.Long id){
		 mapper.deleteByPrimaryKey(id);
	 }

	public void delete(ActivitySaleMessage entity){
		 mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<ActivitySaleMessage> entities){
		List<Long> ids=Lists.newArrayList();
		for (ActivitySaleMessage  entity: entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}
	
	public void deleteByIds(Iterable<Long> ids){
		ActivitySaleMessageExample example=new ActivitySaleMessageExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		 mapper.deleteByExample(example);
	}

	public void deleteAll(){
		ActivitySaleMessageExample example=new ActivitySaleMessageExample();
		mapper.deleteByExample(example);
	}
	
	public ActivitySaleMessageBO getSaleMessageByActId(Long id) {
		ActivitySaleMessageExample example=new ActivitySaleMessageExample();
		example.createCriteria().andActIdEqualTo(id);
		List<ActivitySaleMessageBO> bos = mapper.selectByExample(example);
		return bos != null && bos.size() > 0 ? bos.get(0) : null;
	}

}
