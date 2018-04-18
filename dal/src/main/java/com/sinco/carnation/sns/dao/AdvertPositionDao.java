package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sns.mapper.AdvertPositionMapper;
import com.sinco.carnation.sns.model.AdvertPosition;
import com.sinco.carnation.sns.model.AdvertPositionExample;
import com.sinco.carnation.sns.vo.AdvertPositionVO;
import com.sinco.dal.common.MyPage;

@Repository
public class AdvertPositionDao {

	@Autowired
	private AdvertPositionMapper mapper;

	/**
	 * 根据标识查找
	 * 
	 * @param code
	 * @return
	 */
	public AdvertPosition findByCode(String code) {
		AdvertPositionExample example = new AdvertPositionExample();
		example.createCriteria().andApCodeEqualTo(code);
		List<AdvertPosition> list = mapper.selectByExample(example);
		return list.size() > 0 ? list.get(0) : null;
	}

	/**
	 * find by ap_type
	 * 
	 * @param type
	 * @param status
	 * @return
	 */
	@SuppressWarnings("unused")
	public List<AdvertPosition> findByType(String type, Integer status) {
		AdvertPositionExample example = new AdvertPositionExample();
		AdvertPositionExample.Criteria c = example.createCriteria().andApTypeEqualTo(type)
				.andApStatusEqualTo(status);
		example.setOrderByClause(" add_Time desc ");
		return mapper.selectByExample(example);
	}

	/**
	 * find by ap_type
	 * 
	 * @param type
	 * @param status
	 * @return
	 */
	public List<AdvertPosition> findByTypeAndlLocation(String type, String location, Integer width,
			Integer height, Integer status) {

		AdvertPositionExample example = new AdvertPositionExample();
		AdvertPositionExample.Criteria c = example.createCriteria().andApTypeEqualTo(type)
				.andApStatusEqualTo(status);
		if (width != null) {
			c.andApWidthEqualTo(width);
		}
		if (location != null) {
			c.andApLocationEqualTo(location);
		}
		if (height != null) {
			c.andApHeightEqualTo(height);
		}
		example.setOrderByClause(" add_Time desc ");
		return mapper.selectByExample(example);
	}

	/** generate code begin **/
	public List<AdvertPosition> findAll() {
		AdvertPositionExample example = new AdvertPositionExample();
		return mapper.selectByExample(example);
	}

	public List<AdvertPosition> findByRelease(int releaseType) {
		return mapper.findByRelease(releaseType);
	}

	public long count() {
		AdvertPositionExample example = new AdvertPositionExample();
		return mapper.countByExample(example);
	}

	public List<AdvertPosition> save(Iterable<AdvertPosition> entities) {
		List<AdvertPosition> list = new ArrayList<AdvertPosition>();
		for (AdvertPosition AdvertPosition : entities) {
			list.add(save(AdvertPosition));
		}
		return list;
	}

	public AdvertPosition save(AdvertPosition record) {
		if (record != null) {
			if (record.getId() == null) {
				mapper.insertSelective(record);
			} else {
				mapper.updateByPrimaryKeySelective(record);
			}
		}
		return record;
	}

	public void update(AdvertPosition record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public AdvertPosition findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public AdvertPosition get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		AdvertPositionExample example = new AdvertPositionExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<AdvertPosition> findAll(Iterable<Long> ids) {
		AdvertPositionExample example = new AdvertPositionExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(AdvertPosition entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<AdvertPosition> entities) {
		List<Long> ids = Lists.newArrayList();
		for (AdvertPosition entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		AdvertPositionExample example = new AdvertPositionExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		AdvertPositionExample example = new AdvertPositionExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	/* grey added begin */
	public List<AdvertPosition> findList(AdvertPositionVO vo, MyPage<AdvertPosition> page) {
		return mapper.selectListByVo(vo, page);
	}

	public List<AdvertPosition> findList() {
		return mapper.selectList();
	}

	/**
	 * 根据apCode来查找广告位
	 * 
	 * @param apCode
	 * @return
	 */
	public List<AdvertPosition> findByApCode(String apCode) {
		AdvertPositionExample example = new AdvertPositionExample();
		example.createCriteria().andApCodeLike(apCode);
		return mapper.selectByExample(example);
	}

	/* grey added end */

	public void updateStatusById(int status, int id) {
		this.mapper.updateStatusById(status, id);
	}
}
