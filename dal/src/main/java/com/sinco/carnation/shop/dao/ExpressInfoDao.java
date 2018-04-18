package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.shop.mapper.ExpressInfoMapper;
import com.sinco.carnation.shop.model.ExpressInfo;
import com.sinco.carnation.shop.bo.ExpressInfoBO;
import com.sinco.carnation.shop.model.ExpressInfoExample;

@Repository
public class ExpressInfoDao {

	@Autowired
	private ExpressInfoMapper mapper;

	/**
	 * 根据订单查询
	 * @param orderId
	 * @return
	 */
	public ExpressInfoBO findByOrderId(Long orderId){
		ExpressInfoExample example=new ExpressInfoExample();
		example.createCriteria().andOrderIdEqualTo(orderId);
		List<ExpressInfoBO> list=mapper.selectByExample(example);
		return list.size() > 0 ?list.get(0):null;
	}

   /** generate code begin**/
	public List<ExpressInfoBO> findAll(){
		ExpressInfoExample example=new ExpressInfoExample();
		return mapper.selectByExample(example);
	}
	
	public long count(){
		ExpressInfoExample example=new ExpressInfoExample();
		return mapper.countByExample(example);
	}

	public List<ExpressInfo> save(Iterable<ExpressInfo> entities){
		List<ExpressInfo> list=new ArrayList<ExpressInfo>();
		for (ExpressInfo ExpressInfo : entities) {
			list.add(save(ExpressInfo));
		}
		return list;
	}
	
	public ExpressInfo save(ExpressInfo record){
		if(record.getId() == null){
			mapper.insertSelective(record);
		}else{
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}
	

	public void update(ExpressInfo record) {
		mapper.updateByPrimaryKeySelective(record);
	}
	
	public ExpressInfoBO findOne(java.lang.Long id){
		return mapper.selectByPrimaryKey(id);
	}
	
	public ExpressInfoBO get(java.lang.Long id){
		return mapper.selectByPrimaryKey(id);
	}


	public boolean exists(java.lang.Long id){
		ExpressInfoExample example=new ExpressInfoExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}


	List<ExpressInfoBO> findAll(Iterable<Long> ids){
		ExpressInfoExample example=new ExpressInfoExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}
	
	 public void delete(java.lang.Long id){
		 mapper.deleteByPrimaryKey(id);
	 }
	 
	 public void remove(java.lang.Long id){
		 mapper.deleteByPrimaryKey(id);
	 }

	public void delete(ExpressInfo entity){
		 mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<ExpressInfo> entities){
		List<Long> ids=Lists.newArrayList();
		for (ExpressInfo  entity: entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}
	
	public void deleteByIds(Iterable<Long> ids){
		ExpressInfoExample example=new ExpressInfoExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		 mapper.deleteByExample(example);
	}

	public void deleteAll(){
		ExpressInfoExample example=new ExpressInfoExample();
		mapper.deleteByExample(example);
	}
	/** generate code end**/
}
