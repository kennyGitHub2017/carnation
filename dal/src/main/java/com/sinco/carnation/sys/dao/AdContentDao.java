package com.sinco.carnation.sys.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sys.mapper.AdContentMapper;
import com.sinco.carnation.sys.model.AdContent;
import com.sinco.carnation.sys.bo.AdContentBO;
import com.sinco.carnation.sys.model.AdContentExample;
import com.sinco.carnation.sys.vo.AdContentVO;
import com.sinco.dal.common.MyPage;

@Repository
public class AdContentDao {

	@Autowired
	private AdContentMapper mapper;

	/** generate code begin **/
	public List<AdContentBO> findAll() {
		AdContentExample example = new AdContentExample();
		return mapper.selectByExample(example);
	}

	List<AdContentBO> findAll(Iterable<Long> ids) {
		AdContentExample example = new AdContentExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		AdContentExample example = new AdContentExample();
		return mapper.countByExample(example);
	}

	public int updateAllOrdersById(AdContent record){
		return mapper.updateAllOrdersById(record);
	}
	
	
	
//	public List<AdContent> save(Iterable<AdContent> entities){
//		List<AdContent> list=new ArrayList<AdContent>();
//		for (AdContent AdContent : entities) {
//			list.add(save(AdContent));
//		}
//		return list;
//	}

	public Integer save(AdContent record) {
		Integer result = 0;
		if (record.getId() == null) {
			result = mapper.insertSelective(record);
		} else {
			result = mapper.updateByPrimaryKeySelective(record);
		}
		return result;
	}

	public void update(AdContent record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public AdContentBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		AdContentExample example = new AdContentExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public boolean delete(java.lang.Long id) {
		boolean result = false;
		if (mapper.deleteByPrimaryKey(id) > 0) {
			result = true;
		}
		return result;
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(AdContent entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<AdContent> entities) {
		List<Long> ids = Lists.newArrayList();
		for (AdContent entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		AdContentExample example = new AdContentExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		AdContentExample example = new AdContentExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	/**
	 * 查询内容列表
	 * 
	 * @param page
	 * @return
	 */
	public List<AdContentBO> findContentsByPage(@Param("page") MyPage<AdContentBO> page, AdContentVO vo) {
		List<AdContentBO> list = mapper.findContentsByPage(page, vo);
		page.setContent(list);
		return list;
	}

	/**
	 * 
	 * @param vo
	 * @param page
	 * @param queryType
	 *            all 全部查询
	 * @return
	 */
	@SuppressWarnings("unused")
	public List<AdContentBO> listByVO(AdContentVO vo, MyPage<AdContentBO> page, String queryType) {
		AdContentExample example = new AdContentExample();
		List<AdContentBO> result = new ArrayList<>();
		if (null == vo) {
			return result;
		}

		/*	example.createCriteria().andIdEqualTo(vo.getId()).andNameLike(vo.getName())
					.andParentIdEqualTo(vo.getParentId()).andAreaAdIdEqualTo(vo.getAreaAdId())
					.andAreaIdEqualTo(vo.getAreaId());
			example.setOrderByClause("id desc");*/

		result = mapper.listByVOPage(vo, page, queryType);
		return result;
	}

	/**
	 * 查询所有区域名称
	 * 
	 * @return
	 */
	public List<AdContentBO> findAllName(AdContentVO vo) {
		return mapper.findAllName(vo);
	}

	/**
	 * 查询区域信息
	 * 
	 * @return
	 */
	public List<AdContentBO> queryContentsList(Map<String, Object> map) {
		return mapper.queryContentsList(map);
	}

	public int findCountByAreaAdId(long areaAdId) {
		AdContentExample example = new AdContentExample();
		example.createCriteria().andAreaAdIdEqualTo(areaAdId);
		return mapper.countByExample(example);
	}

}
