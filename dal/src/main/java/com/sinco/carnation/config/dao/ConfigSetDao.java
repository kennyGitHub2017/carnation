package com.sinco.carnation.config.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.google.common.collect.Lists;
import com.sinco.carnation.config.bo.ConfigSetBO;
import com.sinco.carnation.config.constant.DictionKey;
import com.sinco.carnation.config.mapper.ConfigSetMapper;
import com.sinco.carnation.config.model.ConfigSet;
import com.sinco.carnation.config.model.ConfigSetExample;

@Repository
public class ConfigSetDao {

	@Autowired
	private ConfigSetMapper mapper;

	/**
	 * 把List换成map
	 * 
	 * @return
	 */
	public Map<String, String> getMapFindAll() {
		Map<String, String> map = new HashMap<String, String>();
		for (ConfigSetBO at : findAll()) {
			map.put(at.getNameKey(), at.getNameValue());
		}
		return map;
	}

	/**
	 * 双倍积分是否开启
	 * 
	 * @param map
	 * @return
	 */
	public boolean doubleScoreIsUnlock(Map<String, String> map, Date payTime) {

		boolean falg = false;
		String status = map.get(DictionKey.SCORE_STATUS);// 状态
		String startDate = map.get(DictionKey.SCORE_START_DATE);// 开始日期
		String endDate = map.get(DictionKey.SCORE_END_DATE);// 结束日期
		Date start = null;
		Date end = null;
		if (startDate != null && !startDate.equals("")) {
			start = CommUtil.formatDate(startDate, "yyyy-MM-dd HH:mm:ss");
		}
		if (endDate != null && !endDate.equals("")) {
			end = CommUtil.formatDate(endDate, "yyyy-MM-dd HH:mm:ss");
		}

		if (payTime != null && start.before(payTime) && end.after(payTime) && status.equals("1")) {
			falg = true;
		}

		return falg;
	}

	/** generate code begin **/
	public List<ConfigSetBO> findAll() {
		ConfigSetExample example = new ConfigSetExample();
		return mapper.selectByExample(example);
	}

	List<ConfigSetBO> findAll(Iterable<Long> ids) {
		ConfigSetExample example = new ConfigSetExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		ConfigSetExample example = new ConfigSetExample();
		return mapper.countByExample(example);
	}

	public List<ConfigSet> save(Iterable<ConfigSet> entities) {
		List<ConfigSet> list = new ArrayList<ConfigSet>();
		for (ConfigSet ConfigSet : entities) {
			list.add(save(ConfigSet));
		}
		return list;
	}

	public ConfigSet save(ConfigSet record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(ConfigSet record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public ConfigSetBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		ConfigSetExample example = new ConfigSetExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(ConfigSet entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<ConfigSet> entities) {
		List<Long> ids = Lists.newArrayList();
		for (ConfigSet entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ConfigSetExample example = new ConfigSetExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ConfigSetExample example = new ConfigSetExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
