package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.shop.mapper.FreeGoodsMapper;
import com.sinco.carnation.shop.model.FreeGoods;
import com.sinco.carnation.shop.bo.FreeGoodsBO;
import com.sinco.carnation.shop.model.FreeGoodsExample;

@Repository
public class FreeGoodsDao {

	@Autowired
	private FreeGoodsMapper mapper;


   /** generate code begin**/
	public List<FreeGoodsBO> findAll(){
		FreeGoodsExample example=new FreeGoodsExample();
		return mapper.selectByExample(example);
	}
	
	public long count(){
		FreeGoodsExample example=new FreeGoodsExample();
		return mapper.countByExample(example);
	}

	public List<FreeGoods> save(Iterable<FreeGoods> entities){
		List<FreeGoods> list=new ArrayList<FreeGoods>();
		for (FreeGoods FreeGoods : entities) {
			list.add(save(FreeGoods));
		}
		return list;
	}
	
	public FreeGoods save(FreeGoods record){
		if(record.getId() == null){
			mapper.insertSelective(record);
		}else{
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}
	

	public void update(FreeGoods record) {
		mapper.updateByPrimaryKeySelective(record);
	}
	
	public FreeGoodsBO findOne(java.lang.Long id){
		return mapper.selectByPrimaryKey(id);
	}
	
	public FreeGoodsBO get(java.lang.Long id){
		return mapper.selectByPrimaryKey(id);
	}


	public boolean exists(java.lang.Long id){
		FreeGoodsExample example=new FreeGoodsExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}


	List<FreeGoodsBO> findAll(Iterable<Long> ids){
		FreeGoodsExample example=new FreeGoodsExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}
	
	 public void delete(java.lang.Long id){
		 mapper.deleteByPrimaryKey(id);
	 }
	 
	 public void remove(java.lang.Long id){
		 mapper.deleteByPrimaryKey(id);
	 }

	public void delete(FreeGoods entity){
		 mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<FreeGoods> entities){
		List<Long> ids=Lists.newArrayList();
		for (FreeGoods  entity: entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}
	
	public void deleteByIds(Iterable<Long> ids){
		FreeGoodsExample example=new FreeGoodsExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		 mapper.deleteByExample(example);
	}

	public void deleteAll(){
		FreeGoodsExample example=new FreeGoodsExample();
		mapper.deleteByExample(example);
	}
	/** generate code end**/
}
