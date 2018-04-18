package com.sinco.carnation.juanpi.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.juanpi.bo.JuanpiGoodsBO;
import com.sinco.carnation.juanpi.mapper.JuanpiGoodsMapper;
import com.sinco.carnation.juanpi.model.JuanpiGoods;
import com.sinco.carnation.juanpi.model.JuanpiGoodsExample;
import com.sinco.carnation.juanpi.vo.JuanpiGoodsVO;
import com.sinco.dal.common.MyPage;

@Repository
public class JuanpiGoodsDao {

	@Autowired
	private JuanpiGoodsMapper mapper;


   /** generate code begin**/
	public List<JuanpiGoodsBO> findAll(){
		JuanpiGoodsExample example=new JuanpiGoodsExample();
		return mapper.selectByExample(example);
	}
	List<JuanpiGoodsBO> findAll(Iterable<Long> ids){
		JuanpiGoodsExample example=new JuanpiGoodsExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}
	
	public long count(){
		JuanpiGoodsExample example=new JuanpiGoodsExample();
		return mapper.countByExample(example);
	}

	public List<JuanpiGoods> save(Iterable<JuanpiGoods> entities){
		List<JuanpiGoods> list=new ArrayList<JuanpiGoods>();
		for (JuanpiGoods JuanpiGoods : entities) {
			list.add(save(JuanpiGoods));
		}
		return list;
	}
	
	public JuanpiGoods save(JuanpiGoods record){
		mapper.insertSelective(record);
		return record;
	}

	public int update(JuanpiGoods record) {
		return mapper.updateByPrimaryKeySelective(record);
	}
	
	public JuanpiGoodsBO findOne(java.lang.Long id){
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id){
		JuanpiGoodsExample example=new JuanpiGoodsExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}
	
	 public void delete(java.lang.Long id){
		 mapper.deleteByPrimaryKey(id);
	 }
	 
	 public void remove(java.lang.Long id){
		 mapper.deleteByPrimaryKey(id);
	 }

	public void delete(JuanpiGoods entity){
		 mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<JuanpiGoods> entities){
		List<Long> ids=Lists.newArrayList();
		for (JuanpiGoods  entity: entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}
	
	public void deleteByIds(Iterable<Long> ids){
		JuanpiGoodsExample example=new JuanpiGoodsExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		 mapper.deleteByExample(example);
	}

	public void deleteAll(){
		JuanpiGoodsExample example=new JuanpiGoodsExample();
		mapper.deleteByExample(example);
	}
	/** generate code end**/
	public List<Long> findAllSellingGoods() {
		return mapper.findAllSellingGoods();
	}
	public void deleteUnsynJuanpiGoods() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		mapper.deleteUnsynJuanpiGoods(cal.getTime());
	}
	
	public void upateGoodsSales(Long id, Long goodsnumber) {
		mapper.upateGoodsSales(id, goodsnumber);
	}
	
	public List<JuanpiGoodsBO> findGoodsByVO(JuanpiGoodsVO vo,MyPage<JuanpiGoodsBO> page){
		return mapper.findGoodsByVO(vo,page);
	}
	


	public int updateIsShow(JuanpiGoodsVO vo){
		return mapper.updateIsShow(vo);
	}
	
	public int updateClass(JuanpiGoodsVO vo){
		return mapper.updateClass(vo);
	}
	
	public int deleteGood(Long id){
		return mapper.deleteByPrimaryKey(id);
	}
	
	public List<JuanpiGoodsBO> findClassNameById(Long cId){
		return mapper.findClassNameById(cId);
	}
	public List<JuanpiGoodsBO> selectByRand(Integer limitStart, Integer limitEnd) {
		return this.mapper.selectByRand(limitStart, limitEnd);
	}
	public List<Long> findAllIds(int pageNo) {
		if(pageNo <= 0){
			pageNo = 1;
		}
		return mapper.findAllIds((pageNo - 1) * 1000, 1000);
	}
}
