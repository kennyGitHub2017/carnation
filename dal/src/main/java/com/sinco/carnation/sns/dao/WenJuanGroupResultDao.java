package com.sinco.carnation.sns.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.sns.bo.WenJuanGroupResultBO;
import com.sinco.carnation.sns.mapper.WenJuanGroupResultMapper;
import com.sinco.carnation.sns.model.WenJuanGroupResult;
import com.sinco.carnation.sns.vo.WenJuanGroupResultVO;
import com.sinco.dal.common.MyPage;

@Repository
public class WenJuanGroupResultDao {

	@Autowired
	private WenJuanGroupResultMapper mapper;

	/** generate code begin **/
	public List<WenJuanGroupResultBO> findAll() {
		/*WenJuanGroupResultExample example=new WenJuanGroupResultExample();
		return mapper.selectByExample(example);*/
		return null;
	}

	List<WenJuanGroupResultBO> findAll(Iterable<Long> ids) {
		/*WenJuanGroupResultExample example=new WenJuanGroupResultExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);*/
		return null;
	}

	public long count() {
		/*WenJuanGroupResultExample example=new WenJuanGroupResultExample();
		return mapper.countByExample(example);*/
		return 0L;
	}

	public List<WenJuanGroupResult> save(Iterable<WenJuanGroupResult> entities) {
		/*List<WenJuanGroupResult> list=new ArrayList<WenJuanGroupResult>();
		for (WenJuanGroupResult WenJuanGroupResult : entities) {
			list.add(save(WenJuanGroupResult));
		}*/
		return null;
	}

	public WenJuanGroupResult save(WenJuanGroupResultVO record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(WenJuanGroupResult record) {
		/*mapper.updateByPrimaryKeySelective(record);*/
	}

	public WenJuanGroupResultBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		/*WenJuanGroupResultExample example=new WenJuanGroupResultExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;*/
		return false;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		/*mapper.deleteByPrimaryKey(id);*/
	}

	public void delete(WenJuanGroupResult entity) {
		/*mapper.deleteByPrimaryKey(entity.getId());*/
	}

	public void delete(Iterable<WenJuanGroupResult> entities) {
		/*List<Long> ids=Lists.newArrayList();
		for (WenJuanGroupResult  entity: entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);*/
	}

	public void deleteByIds(Iterable<Long> ids) {
		/*WenJuanGroupResultExample example=new WenJuanGroupResultExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		 mapper.deleteByExample(example);*/
	}

	public void deleteAll() {
		/*WenJuanGroupResultExample example=new WenJuanGroupResultExample();
		mapper.deleteByExample(example);*/
	}

	public List<WenJuanGroupResultBO> select_groupResults_byGroupID(Long groupID) {
		return this.mapper.select_groupResults_byGroupID(groupID);
	}

	public List<WenJuanGroupResultBO> select_groupResults_byThemeID(Long groupID) {
		return this.mapper.select_groupResults_byThemeID(groupID);
	}

	/**
	 * 分页
	 * 
	 * @param page
	 * @param vo
	 * @return
	 */
	public List<WenJuanGroupResultBO> findByPage(MyPage<WenJuanGroupResultVO> page, WenJuanGroupResultVO vo) {
		return this.mapper.findByPage(page, vo);
	}

	public WenJuanGroupResultBO selectMaxAndMinByThemeID(Long themeID) {
		return this.mapper.selectMaxAndMinByThemeID(themeID);
	}

	public WenJuanGroupResultBO selectMaxAndMinByGroupID(Long groupID) {
		return this.mapper.selectMaxAndMinByGroupID(groupID);
	}
}
