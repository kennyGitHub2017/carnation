package com.sinco.carnation.sys.dao;

import com.google.common.collect.Lists;
import com.sinco.carnation.sys.bo.SysKeyWordMapBO;
import com.sinco.carnation.sys.mapper.SysKeyWordMapMapper;
import com.sinco.carnation.sys.model.SysKeyWordMap;
import com.sinco.carnation.sys.model.SysKeyWordMapExample;
import com.sinco.carnation.sys.vo.SysKeyWordMapVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SysKeyWordMapDao {

	@Autowired
	private SysKeyWordMapMapper mapper;

	/** generate code begin **/
	public List<SysKeyWordMapBO> findAll() {
		SysKeyWordMapExample example = new SysKeyWordMapExample();
		return mapper.selectByExample(example);
	}

	List<SysKeyWordMapBO> findAll(Iterable<Long> ids) {
		SysKeyWordMapExample example = new SysKeyWordMapExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		SysKeyWordMapExample example = new SysKeyWordMapExample();
		return mapper.countByExample(example);
	}

	public List<SysKeyWordMap> save(Iterable<SysKeyWordMap> entities) {
		List<SysKeyWordMap> list = new ArrayList<SysKeyWordMap>();
		for (SysKeyWordMap SysKeyWordMap : entities) {
			list.add(save(SysKeyWordMap));
		}
		return list;
	}

	public SysKeyWordMap save(SysKeyWordMap record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(SysKeyWordMap record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public SysKeyWordMapBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		SysKeyWordMapExample example = new SysKeyWordMapExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(SysKeyWordMap entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<SysKeyWordMap> entities) {
		List<Long> ids = Lists.newArrayList();
		for (SysKeyWordMap entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		SysKeyWordMapExample example = new SysKeyWordMapExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		SysKeyWordMapExample example = new SysKeyWordMapExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	/**
	 * 精华推荐
	 * 
	 * @param idsList
	 * @param sysTypeCode
	 */
	public List<SysKeyWordMapBO> findListByCond(List<Long> idsList, long sysTypeCode) {
		SysKeyWordMapExample example = new SysKeyWordMapExample();
		example.createCriteria().andTypeCodeEqualTo(sysTypeCode).andTypeIdIn(idsList);
		return mapper.selectByExample(example);

	}

	/**
	 * 精华推荐
	 */
	public List<SysKeyWordMapBO> findListByCond4Recommed(List<Long> idsList, long typeCode,
			long suggestTypeCode) {
		return mapper.findListByCond4Recommed(idsList, typeCode, suggestTypeCode);

	}

	/**
	 * 根据关联类型和关联表ID获取SysKeyWordMapBO对象
	 * 
	 * @param typeCode
	 *            关联类型 1:体检建议 2:任务 3:帖子 4:商品 5:服务
	 * @param typeId
	 *            关联表的id
	 * 
	 * @return
	 */
	public List<SysKeyWordMapBO> getByTypeCodeAndId(Long typeCode, Long typeId) {
		SysKeyWordMapExample example = new SysKeyWordMapExample();
		example.createCriteria().andTypeCodeEqualTo(typeCode).andTypeIdEqualTo(typeId);
		return mapper.selectByExample(example);
	}

	/**
	 * 根据typeCode和关联的ID列表批量删除
	 * 
	 * @param typeCode
	 *            关联类型 1:体检建议 2:任务 3:帖子 4:商品 5:服务
	 * @param typeIds
	 *            关联表的id集合
	 */
	public void batchDeleteByTypeCodeAndIds(long typeCode, List<Long> typeIds) {
		mapper.batchDeleteByTypeCodeAndIds(typeCode, typeIds);
	}

	/***
	 * 添加
	 * 
	 * @param record
	 * @return
	 */
	public int insertKeyWordMap(SysKeyWordMap record) {
		return this.mapper.insertKeyWordMap(record);
	}

	/****
	 * 根据vo查询
	 * 
	 * @param vo
	 * @return
	 */
	public List<SysKeyWordMapBO> selectListByVo(SysKeyWordMapVO vo) {
		return this.mapper.selectListByVo(vo);
	}

	/**
	 * 根据typeID和typeCode删除
	 * 
	 * @param typeId
	 * @return
	 */
	public int deleteByTypeIdAdTypeCode(Long typeId, Long typeCode) {
		return this.mapper.deleteByTypeIdAdTypeCode(typeId, typeCode);
	}

}
