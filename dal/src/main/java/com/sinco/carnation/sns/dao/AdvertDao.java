package com.sinco.carnation.sns.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sns.bo.AdvertBO;
import com.sinco.carnation.sns.contants.AdvertContant;
import com.sinco.carnation.sns.mapper.AdvertMapper;
import com.sinco.carnation.sns.model.Advert;
import com.sinco.carnation.sns.model.AdvertExample;
import com.sinco.carnation.sns.vo.AdvertVO;
import com.sinco.common.utils.DateUtils;
import com.sinco.dal.common.MyPage;

@Repository
public class AdvertDao {

	@Autowired
	private AdvertMapper mapper;

	/**
	 * 增加点击数
	 * 
	 * @param id
	 * @return
	 */
	public int increaseClickNum(Long id) {
		return mapper.increaseClickNum(id);
	}

	public List<AdvertBO> findAdByCode(String sadCode, Long cityId ,String time) {
		return mapper.findAdByCode(sadCode, cityId, time);
	}

	/**
	 * 根据apCode 查找前 count记录
	 * 
	 * @param apCode
	 * @param count
	 * @return
	 */
	public List<Advert> findTopAdByApCode(String apCode, Long count) {

		return mapper.findTopAdByApCode(apCode, count);
	}

	/** generate code begin **/
	public List<Advert> findAll() {
		AdvertExample example = new AdvertExample();
		return mapper.selectByExample(example);
	}

	public List<AdvertBO> findByApCode(String apCode) {
		return mapper.findByApCode(apCode);
	}

	public long count() {
		AdvertExample example = new AdvertExample();
		return mapper.countByExample(example);
	}

	public List<Advert> save(Iterable<Advert> entities) {
		List<Advert> list = new ArrayList<Advert>();
		for (Advert Advert : entities) {
			list.add(save(Advert));
		}
		return list;
	}

	public Advert save(Advert record) {
		if (record != null) {
			if (record.getId() == null) {
				mapper.insertSelective(record);
			} else {
				mapper.updateByPrimaryKeySelective(record);
			}
		}
		return record;
	}

	public void update(Advert record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public Advert findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public Advert get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		AdvertExample example = new AdvertExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<Advert> findAll(Iterable<Long> ids) {
		AdvertExample example = new AdvertExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Advert entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Advert> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Advert entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		AdvertExample example = new AdvertExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		AdvertExample example = new AdvertExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	/* grey added begin */
	public List<AdvertBO> findList(AdvertVO vo, MyPage<AdvertBO> page) {
		return mapper.selectListByVo(vo, page);
	}

	public AdvertBO getBoById(Long id) {
		return mapper.selectBoByPrimaryKey(id);
	}

	public void updateAdSlideSequenceAddOne(Long id, Long adApId) {
		mapper.updateAdSlideSequenceAddOne(id, adApId);
	}

	public List<Advert> findListByAdApId(Long adApId) {
		AdvertExample example = new AdvertExample();
		example.createCriteria().andAdApIdEqualTo(adApId).andAdStatusEqualTo(AdvertContant.AD_STATUS_PASS);
		return mapper.selectByExample(example);
	}

	public List<Advert> findListByAdApId(Long adApId, Integer status, Date beginDate, Date endDate) {
		AdvertExample example = new AdvertExample();
		AdvertExample.Criteria c = example.createCriteria().andAdApIdEqualTo(adApId);
		if (status != null) {
			c.andAdStatusEqualTo(status);
		}
		if (beginDate != null) {
			try {
				c.andAdBeginTimeLessThanOrEqualTo(DateUtils.parseDate(
						DateUtils.formatDate(beginDate, "yyyyMMdd"), "yyyyMMdd"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (endDate != null) {
			try {
				c.andAdEndTimeGreaterThanOrEqualTo(DateUtils.parseDate(
						DateUtils.formatDate(endDate, "yyyyMMdd"), "yyyyMMdd"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		example.setOrderByClause(" ad_slide_sequence asc");

		return mapper.selectByExample(example);
	}

	/* grey added end */

	public int selectCountByAddTime(String sadCode, String timeStapm) {
		return mapper.selectCountByAddTime(sadCode, timeStapm);
	}

}
