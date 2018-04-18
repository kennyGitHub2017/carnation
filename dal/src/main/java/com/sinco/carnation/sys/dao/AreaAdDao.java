package com.sinco.carnation.sys.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.google.common.collect.Lists;

import com.sinco.carnation.sys.mapper.AreaAdMapper;
import com.sinco.carnation.sys.model.AreaAd;
import com.sinco.carnation.sys.bo.AreaAdBO;
import com.sinco.carnation.sys.model.AreaAdExample;
import com.sinco.data.core.Page;

@Repository
public class AreaAdDao {

	@Autowired
	private AreaAdMapper mapper;


   /** generate code begin**/
	public List<AreaAdBO> findAll(){
		AreaAdExample example=new AreaAdExample();
		return mapper.selectByExample(example);
	}
	List<AreaAdBO> findAll(Iterable<Long> ids){
		AreaAdExample example=new AreaAdExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}
	
	public long count(){
		AreaAdExample example=new AreaAdExample();
		return mapper.countByExample(example);
	}

	public List<AreaAd> save(Iterable<AreaAd> entities){
		List<AreaAd> list=new ArrayList<AreaAd>();
		for (AreaAd AreaAd : entities) {
			list.add(save(AreaAd));
		}
		return list;
	}
	
	public AreaAd save(AreaAd record){
		if(record.getId() == null){
			mapper.insertSelective(record);
		}else{
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}
	

	public void update(AreaAd record) {
		mapper.updateByPrimaryKeySelective(record);
	}
	
	public AreaAdBO findOne(java.lang.Long id){
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id){
		AreaAdExample example=new AreaAdExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}
	
	 public void delete(java.lang.Long id){
		 mapper.deleteByPrimaryKey(id);
	 }
	 
	 public void remove(java.lang.Long id){
		 mapper.deleteByPrimaryKey(id);
	 }

	public void delete(AreaAd entity){
		 mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<AreaAd> entities){
		List<Long> ids=Lists.newArrayList();
		for (AreaAd  entity: entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}
	
	public void deleteByIds(Iterable<Long> ids){
		AreaAdExample example=new AreaAdExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		 mapper.deleteByExample(example);
	}

	public void deleteAll(){
		AreaAdExample example=new AreaAdExample();
		mapper.deleteByExample(example);
	}
	/** generate code end**/
	public void findPage(AreaAdBO areaAd, Page<AreaAdBO> page) {
		AreaAdExample example=new AreaAdExample();
		if(areaAd != null){
			if(StringUtils.hasText(areaAd.getName())){
				example.createCriteria().andNameLike("%" + areaAd.getName() + "%");
			}
		}
		example.setLimit(page.getOffset(), page.getPageSize());
		example.setOrderByClause(" orders ");
		page.setTotal(mapper.countByExample(example));
		if(page.getTotalElements() > 0){
			page.setContent(mapper.selectByExample(example));
		}
	}
	
	public List<AreaAdBO> findAllShow(){
		AreaAdExample example=new AreaAdExample();
		example.createCriteria().andDisabledEqualTo(0);
		return mapper.selectByExample(example);
	}
	public boolean checkCodeExists(Long id, String code) {
		AreaAdExample example=new AreaAdExample();
		if(id == null){
			example.createCriteria().andCodeEqualTo(code);
		}else{
			example.createCriteria().andCodeEqualTo(code).andIdNotEqualTo(id);
		}
		return mapper.countByExample(example) > 0;
	}
	
	
	
}
