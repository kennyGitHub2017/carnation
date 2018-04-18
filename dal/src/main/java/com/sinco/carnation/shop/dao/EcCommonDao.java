package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.shop.mapper.EcCommonMapper;
import com.sinco.carnation.shop.model.EcCommon;
import com.sinco.carnation.shop.bo.EcCommonBO;
import com.sinco.carnation.shop.model.EcCommonExample;
import com.sinco.carnation.shop.vo.EcCommonVO;
import com.sinco.dal.common.MyPage;

@Repository
public class EcCommonDao {

	@Autowired
	private EcCommonMapper mapper;

	/** generate code begin **/
	public List<EcCommonBO> findAll() {
		EcCommonExample example = new EcCommonExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		EcCommonExample example = new EcCommonExample();
		return mapper.countByExample(example);
	}

	public List<EcCommon> save(Iterable<EcCommon> entities) {
		List<EcCommon> list = new ArrayList<EcCommon>();
		for (EcCommon EcCommon : entities) {
			list.add(save(EcCommon));
		}
		return list;
	}

	public EcCommon save(EcCommon record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(EcCommon record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public EcCommonBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public EcCommonBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		EcCommonExample example = new EcCommonExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<EcCommonBO> findAll(Iterable<Long> ids) {
		EcCommonExample example = new EcCommonExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(EcCommon entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<EcCommon> entities) {
		List<Long> ids = Lists.newArrayList();
		for (EcCommon entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		EcCommonExample example = new EcCommonExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		EcCommonExample example = new EcCommonExample();
		mapper.deleteByExample(example);
	}

	/**
	 * generate code end
	 * 
	 * @param eccStoreId
	 **/

	public List<EcCommonBO> selectAllByCondition(Integer eccType, Integer eccDefault, Long eccStoreId,
			Long eccEcId) {
		return mapper.selectAllByCondition(eccType, eccDefault, eccStoreId, eccEcId);
	}

	/**
	 * 删除常用物流
	 * 
	 * @param ecIds
	 *            物流公司的id
	 * @param eccType
	 *            类型，用于区别自营还是商家的
	 */
	public int delete(List<Long> ecIds, Integer eccType) {
		return mapper.deleteSelfEcCommon(ecIds, eccType);
	}

	/**
	 * 根据id数组查询列表
	 * 
	 * @param ecIds
	 * @return
	 */
	public List<EcCommonBO> findByIds(List<Long> ecIds) {
		return mapper.findByIds(ecIds);
	}

	public List<EcCommonBO> findListByVo(MyPage<EcCommonBO> page, EcCommonVO vo) {
		return mapper.findListByVo(page, vo);
	}
}
