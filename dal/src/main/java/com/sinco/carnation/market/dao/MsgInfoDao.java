package com.sinco.carnation.market.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.market.mapper.MsgInfoMapper;
import com.sinco.carnation.market.model.MsgInfo;
import com.sinco.carnation.market.bo.MsgInfoBO;
import com.sinco.carnation.market.model.MsgInfoExample;
import com.sinco.carnation.market.vo.MsgInfoVO;
import com.sinco.dal.common.MyPage;

@Repository
public class MsgInfoDao {

	@Autowired
	private MsgInfoMapper mapper;

	/** generate code begin **/
	public List<MsgInfoBO> findAll() {
		MsgInfoExample example = new MsgInfoExample();
		return mapper.selectByExample(example);
	}

	List<MsgInfoBO> findAll(Iterable<Long> ids) {
		MsgInfoExample example = new MsgInfoExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		MsgInfoExample example = new MsgInfoExample();
		return mapper.countByExample(example);
	}

	public List<MsgInfo> save(Iterable<MsgInfo> entities) {
		List<MsgInfo> list = new ArrayList<MsgInfo>();
		for (MsgInfo MsgInfo : entities) {
			list.add(save(MsgInfo));
		}
		return list;
	}

	public MsgInfo save(MsgInfo record) {
		if (record.getId() == null || record.getId() < 1) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(MsgInfo record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public MsgInfoBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		MsgInfoExample example = new MsgInfoExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(MsgInfo entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<MsgInfo> entities) {
		List<Long> ids = Lists.newArrayList();
		for (MsgInfo entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		MsgInfoExample example = new MsgInfoExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		MsgInfoExample example = new MsgInfoExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	/**
	 * 
	 * 
	 * @return
	 */
	public List<MsgInfoBO> findListByVo(MsgInfoVO vo, MyPage<MsgInfoBO> myPage) {

		return mapper.findListByVo(vo, myPage);
	}
}
