package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.shop.mapper.BalanceExceptionOrderMapper;
import com.sinco.carnation.shop.model.BalanceExceptionOrder;
import com.sinco.carnation.shop.bo.BalanceExceptionOrderBO;
import com.sinco.carnation.shop.model.BalanceExceptionOrderExample;

@Repository
public class BalanceExceptionOrderDao {

	@Autowired
	private BalanceExceptionOrderMapper mapper;


   /** generate code begin**/
	public List<BalanceExceptionOrderBO> findAll(){
		BalanceExceptionOrderExample example=new BalanceExceptionOrderExample();
		return mapper.selectByExample(example);
	}
	List<BalanceExceptionOrderBO> findAll(Iterable<Long> ids){
		BalanceExceptionOrderExample example=new BalanceExceptionOrderExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}
	
	public long count(){
		BalanceExceptionOrderExample example=new BalanceExceptionOrderExample();
		return mapper.countByExample(example);
	}

	public List<BalanceExceptionOrder> save(Iterable<BalanceExceptionOrder> entities){
		List<BalanceExceptionOrder> list=new ArrayList<BalanceExceptionOrder>();
		for (BalanceExceptionOrder BalanceExceptionOrder : entities) {
			list.add(save(BalanceExceptionOrder));
		}
		return list;
	}
	
	public BalanceExceptionOrder save(BalanceExceptionOrder record){
		if(record.getId() == null){
			mapper.insertSelective(record);
		}else{
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}
	

	public void update(BalanceExceptionOrder record) {
		mapper.updateByPrimaryKeySelective(record);
	}
	
	public BalanceExceptionOrderBO findOne(java.lang.Long id){
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id){
		BalanceExceptionOrderExample example=new BalanceExceptionOrderExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}
	
	 public void delete(java.lang.Long id){
		 mapper.deleteByPrimaryKey(id);
	 }
	 
	 public void remove(java.lang.Long id){
		 mapper.deleteByPrimaryKey(id);
	 }

	public void delete(BalanceExceptionOrder entity){
		 mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<BalanceExceptionOrder> entities){
		List<Long> ids=Lists.newArrayList();
		for (BalanceExceptionOrder  entity: entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}
	
	public void deleteByIds(Iterable<Long> ids){
		BalanceExceptionOrderExample example=new BalanceExceptionOrderExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		 mapper.deleteByExample(example);
	}

	public void deleteAll(){
		BalanceExceptionOrderExample example=new BalanceExceptionOrderExample();
		mapper.deleteByExample(example);
	}
	/** generate code end**/
	public List<BalanceExceptionOrderBO> queryExceptionOrder() {
		BalanceExceptionOrderExample example=new BalanceExceptionOrderExample();
		example.createCriteria().andDeleteStatusEqualTo(false);
		return mapper.selectByExample(example);
	}
}
