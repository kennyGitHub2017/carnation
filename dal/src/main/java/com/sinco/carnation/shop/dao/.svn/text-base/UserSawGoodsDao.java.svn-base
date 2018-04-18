package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.shop.mapper.UserSawGoodsMapper;
import com.sinco.carnation.shop.model.UserSawGoods;
import com.sinco.carnation.shop.bo.UserSawGoodsBO;
import com.sinco.carnation.shop.model.UserSawGoodsExample;

@Repository
public class UserSawGoodsDao {

	@Autowired
	private UserSawGoodsMapper mapper;


   /** generate code begin**/
	public List<UserSawGoodsBO> findAll(){
		UserSawGoodsExample example=new UserSawGoodsExample();
		return mapper.selectByExample(example);
	}
	List<UserSawGoodsBO> findAll(Iterable<Long> ids){
		UserSawGoodsExample example=new UserSawGoodsExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}
	
	public long count(){
		UserSawGoodsExample example=new UserSawGoodsExample();
		return mapper.countByExample(example);
	}

	public List<UserSawGoods> save(Iterable<UserSawGoods> entities){
		List<UserSawGoods> list=new ArrayList<UserSawGoods>();
		for (UserSawGoods UserSawGoods : entities) {
			list.add(save(UserSawGoods));
		}
		return list;
	}
	
	public UserSawGoods save(UserSawGoods record){
		if(record.getId() == null){
			mapper.insertSelective(record);
		}else{
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}
	

	public void update(UserSawGoods record) {
		mapper.updateByPrimaryKeySelective(record);
	}
	
	public UserSawGoodsBO findOne(java.lang.Long id){
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id){
		UserSawGoodsExample example=new UserSawGoodsExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}
	
	 public void delete(java.lang.Long id){
		 mapper.deleteByPrimaryKey(id);
	 }
	 
	 public void remove(java.lang.Long id){
		 mapper.deleteByPrimaryKey(id);
	 }

	public void delete(UserSawGoods entity){
		 mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<UserSawGoods> entities){
		List<Long> ids=Lists.newArrayList();
		for (UserSawGoods  entity: entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}
	
	public void deleteByIds(Iterable<Long> ids){
		UserSawGoodsExample example=new UserSawGoodsExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		 mapper.deleteByExample(example);
	}

	public void deleteAll(){
		UserSawGoodsExample example=new UserSawGoodsExample();
		mapper.deleteByExample(example);
	}
	/** generate code end**/
	
	public UserSawGoodsBO getByUid(Long uid) {
		return this.mapper.getByUid(uid);
	}
}
