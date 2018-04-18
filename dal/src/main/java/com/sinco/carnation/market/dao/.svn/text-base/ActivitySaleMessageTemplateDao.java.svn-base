package com.sinco.carnation.market.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.market.mapper.ActivitySaleMessageTemplateMapper;
import com.sinco.carnation.market.model.ActivitySaleMessageTemplate;
import com.sinco.carnation.market.bo.ActivitySaleMessageTemplateBO;
import com.sinco.carnation.market.model.ActivitySaleMessageTemplateExample;
import com.sinco.carnation.market.vo.ActivitySaleMessageTemplateVO;
import com.sinco.dal.common.MyPage;

@Repository
public class ActivitySaleMessageTemplateDao {

	@Autowired
	private ActivitySaleMessageTemplateMapper mapper;

	/** generate code begin **/
	public List<ActivitySaleMessageTemplateBO> findAll() {
		ActivitySaleMessageTemplateExample example = new ActivitySaleMessageTemplateExample();
		return mapper.selectByExample(example);
	}

	List<ActivitySaleMessageTemplateBO> findAll(Iterable<Long> ids) {
		ActivitySaleMessageTemplateExample example = new ActivitySaleMessageTemplateExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		ActivitySaleMessageTemplateExample example = new ActivitySaleMessageTemplateExample();
		return mapper.countByExample(example);
	}

	public List<ActivitySaleMessageTemplate> save(Iterable<ActivitySaleMessageTemplate> entities) {
		List<ActivitySaleMessageTemplate> list = new ArrayList<ActivitySaleMessageTemplate>();
		for (ActivitySaleMessageTemplate ActivitySaleMessageTemplate : entities) {
			list.add(save(ActivitySaleMessageTemplate));
		}
		return list;
	}

	public ActivitySaleMessageTemplate save(ActivitySaleMessageTemplate record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(ActivitySaleMessageTemplate record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public ActivitySaleMessageTemplateBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		ActivitySaleMessageTemplateExample example = new ActivitySaleMessageTemplateExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(ActivitySaleMessageTemplate entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<ActivitySaleMessageTemplate> entities) {
		List<Long> ids = Lists.newArrayList();
		for (ActivitySaleMessageTemplate entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ActivitySaleMessageTemplateExample example = new ActivitySaleMessageTemplateExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ActivitySaleMessageTemplateExample example = new ActivitySaleMessageTemplateExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<ActivitySaleMessageTemplateBO> findAllByPage(ActivitySaleMessageTemplateVO vo,
			MyPage<ActivitySaleMessageTemplateBO> page) {
		return mapper.findAllByPage(vo, page);
	}
}
