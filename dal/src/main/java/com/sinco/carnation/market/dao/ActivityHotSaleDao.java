package com.sinco.carnation.market.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.market.bo.ActivityHotSaleBO;
import com.sinco.carnation.market.bo.ActivityHotSaleGoodsInfoBO;
import com.sinco.carnation.market.mapper.ActivityHotSaleMapper;
import com.sinco.carnation.market.model.ActivityHotSale;
import com.sinco.carnation.market.model.ActivityHotSaleExample;
import com.sinco.carnation.market.vo.ActivityHotSaleVO;
import com.sinco.dal.common.MyPage;

@Repository
public class ActivityHotSaleDao {

	@Autowired
	private ActivityHotSaleMapper mapper;

	/** generate code begin **/
	public List<ActivityHotSaleBO> findAll() {
		ActivityHotSaleExample example = new ActivityHotSaleExample();
		return mapper.selectByExample(example);
	}

	List<ActivityHotSaleBO> findAll(Iterable<Long> ids) {
		ActivityHotSaleExample example = new ActivityHotSaleExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		ActivityHotSaleExample example = new ActivityHotSaleExample();
		return mapper.countByExample(example);
	}

	public List<ActivityHotSale> save(Iterable<ActivityHotSale> entities) {
		List<ActivityHotSale> list = new ArrayList<ActivityHotSale>();
		for (ActivityHotSale ActivityHotSale : entities) {
			list.add(save(ActivityHotSale));
		}
		return list;
	}

	public ActivityHotSale save(ActivityHotSale record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(ActivityHotSale record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public ActivityHotSaleBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		ActivityHotSaleExample example = new ActivityHotSaleExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(ActivityHotSale entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<ActivityHotSale> entities) {
		List<Long> ids = Lists.newArrayList();
		for (ActivityHotSale entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ActivityHotSaleExample example = new ActivityHotSaleExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ActivityHotSaleExample example = new ActivityHotSaleExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	// 查询出有效的促销活动广告信息
	public List<ActivityHotSaleBO> findAllByStartTime() {
		Date date = new Date();
		Byte is_enable = 1;
		Byte deleteStatus = 0;
		ActivityHotSaleExample example = new ActivityHotSaleExample();
		example.createCriteria().andStartTimeLessThanOrEqualTo(date).andEndTimeGreaterThanOrEqualTo(date)
				.andIsEnabledEqualTo(is_enable).andDeleteStatusEqualTo(deleteStatus);

		example.setOrderByClause(" start_time asc");
		return mapper.selectByExample(example);
	}

	// 查询参加促销活动的商品列表信息
	public List<ActivityHotSaleGoodsInfoBO> findActHotSaleGoodsList(Long actHotSaleId, String vcode) {
		return mapper.findActHotSaleGoodsList(actHotSaleId, vcode);
	}

	// 查询参加促销活动的商品分页列表信息
	public List<ActivityHotSaleGoodsInfoBO> findActHotSaleGoodsListByPage(Long actHotSaleId, String vcode,
			MyPage<ActivityHotSaleGoodsInfoBO> page) {
		return mapper.findActHotSaleGoodsListByPage(actHotSaleId, vcode, page);
	}

	public List<ActivityHotSaleBO> findAllByPage(ActivityHotSaleVO vo, MyPage<ActivityHotSaleBO> page) {
		return mapper.findAllByPage(vo, page);
	}

	/**
	 * 根据vcode查询开启状态活动信息
	 * 
	 * @param actCode
	 * @return
	 */
	public List<ActivityHotSaleBO> findByCode(String actCode) {
		// Date date = new Date();
		Byte is_enable = 1;
		Byte deleteStatus = 0;
		ActivityHotSaleExample example = new ActivityHotSaleExample();
		example.createCriteria().andIsEnabledEqualTo(is_enable).andDeleteStatusEqualTo(deleteStatus)
				.andVcodeEqualTo(actCode);

		example.setOrderByClause(" start_time desc");
		return mapper.selectByExample(example);
	}

	public List<ActivityHotSaleBO> queryInfoByCode(String actCode) {
		Date date = new Date();
		Byte is_enable = 1;
		Byte deleteStatus = 0;
		ActivityHotSaleExample example = new ActivityHotSaleExample();
		example.createCriteria().andStartTimeLessThanOrEqualTo(date).andEndTimeGreaterThanOrEqualTo(date)
				.andIsEnabledEqualTo(is_enable).andDeleteStatusEqualTo(deleteStatus).andVcodeEqualTo(actCode);

		example.setOrderByClause(" start_time asc");
		return mapper.selectByExample(example);
	}

	public List<ActivityHotSaleGoodsInfoBO> queryActHotSaleGoodsListByPage(Long maxId, String vcode, Integer start,
			Integer pageSize) {
		return mapper.queryActHotSaleGoodsListByPage(maxId, vcode, start, pageSize);
	}

	public List<ActivityHotSaleBO> selectByExample(ActivityHotSaleExample example) {
		return this.mapper.selectByExample(example);
	}

	public List<ActivityHotSale> findByActHotSaleGoodsList(ActivityHotSale obj) {
		return this.mapper.findByActHotSaleGoodsList(obj);
	}

	public ActivityHotSaleBO findNewAppHotSaleInfo(String vcode, Date currentTime, Integer dayOfMinutes) {
		return this.mapper.findNewAppHotSaleInfo(vcode, currentTime, dayOfMinutes);
	}
}
