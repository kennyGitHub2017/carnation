package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sns.bo.SnsActivityBO;
import com.sinco.carnation.sns.mapper.SnsActivityMapper;
import com.sinco.carnation.sns.model.SnsActivity;
import com.sinco.carnation.sns.model.SnsActivityExample;
import com.sinco.carnation.sns.vo.SnsActivityVO;
import com.sinco.dal.common.MyPage;

@Repository
public class SnsActivityDao {

	@Autowired
	private SnsActivityMapper mapper;

	/** generate code begin **/
	public List<SnsActivityBO> findAll() {
		SnsActivityExample example = new SnsActivityExample();
		return mapper.selectByExample(example);
	}

	List<SnsActivityBO> findAll(Iterable<Long> ids) {
		SnsActivityExample example = new SnsActivityExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		SnsActivityExample example = new SnsActivityExample();
		return mapper.countByExample(example);
	}

	public List<SnsActivity> save(Iterable<SnsActivity> entities) {
		List<SnsActivity> list = new ArrayList<SnsActivity>();
		for (SnsActivity SnsActivity : entities) {
			list.add(save(SnsActivity));
		}
		return list;
	}

	public SnsActivity save(SnsActivity snsActivity) {
		if (snsActivity.getId() == null) {
			snsActivity.setAddTime(new Date());
			mapper.insertSelective(snsActivity);
		} else {
			mapper.updateByPrimaryKeySelective(snsActivity);
		}
		return snsActivity;
	}

	public void update(SnsActivity record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public SnsActivityBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		SnsActivityExample example = new SnsActivityExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(SnsActivity entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<SnsActivity> entities) {
		List<Long> ids = Lists.newArrayList();
		for (SnsActivity entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		SnsActivityExample example = new SnsActivityExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		SnsActivityExample example = new SnsActivityExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public SnsActivityBO findActById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	/**
	 * 根据地区id 查询sns_activity count条记录
	 * 
	 * @param id
	 * @param count
	 * @param ord
	 *            (排序--null： 时间, 1：id,2：id降序,3:权重)
	 * @return
	 */
	public List<SnsActivityBO> findTopAc(Long count, Integer ord, Integer isdel) {
		return mapper.findTopAc(count, ord, isdel);
	}

	/**
	 * 根据条件查询分页 sns_activity
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public List<SnsActivityBO> selectListByVo(SnsActivityVO vo, MyPage<SnsActivityBO> page) {
		return mapper.selectListByVo(vo, page);
	}

	/**
	 * 根据条件查询分页限制查询数目 sns_activity
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public List<SnsActivityBO> findbyVO(SnsActivityVO vo, MyPage<SnsActivityBO> page, Integer count,
			Integer isdel) {
		return mapper.findbyVO(vo, page, count, isdel);
	}

}
