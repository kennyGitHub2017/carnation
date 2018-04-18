package com.sinco.carnation.sys.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sys.mapper.ShareMapper;
import com.sinco.carnation.sys.model.Share;
import com.sinco.carnation.sys.bo.ShareBO;
import com.sinco.carnation.sys.model.ShareExample;
import com.sinco.carnation.sys.vo.ShareVO;

@Repository
public class ShareDao {

	@Autowired
	private ShareMapper mapper;

	/** generate code begin **/
	public List<ShareBO> findAll() {
		ShareExample example = new ShareExample();
		return mapper.selectByExample(example);
	}

	List<ShareBO> findAll(Iterable<Long> ids) {
		ShareExample example = new ShareExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		ShareExample example = new ShareExample();
		return mapper.countByExample(example);
	}

//	public List<Share> save(Iterable<Share> entities){
//		List<Share> list=new ArrayList<Share>();
//		for (Share Share : entities) {
//			list.add(save(Share));
//		}
//		return list;
//	}

	public int save(Share record) {
		record.setLastUpdateTime(new Date());
		if (record.getId() == null) {
			record.setCreateTime(new Date());
			return mapper.insertSelective(record);
		} else {
			return mapper.updateByPrimaryKeySelective(record);
		}
	}

	public void update(Share record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public ShareBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		ShareExample example = new ShareExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Share entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Share> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Share entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ShareExample example = new ShareExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ShareExample example = new ShareExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
	public List<ShareBO> listByVO(ShareVO vo){
		return mapper.listByVO(vo);
	}
	 public ShareBO findOneByGoodsId(Long goodsId){
		 return this.mapper.findOneByGoodsId(goodsId);
	 }
}
