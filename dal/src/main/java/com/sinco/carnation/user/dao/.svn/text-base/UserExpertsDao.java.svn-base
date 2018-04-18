package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sys.vo.ExpertsVO;
import com.sinco.carnation.user.bo.UserExpertsBO;
import com.sinco.carnation.user.mapper.UserExpertsMapper;
import com.sinco.carnation.user.model.UserExperts;
import com.sinco.carnation.user.model.UserExpertsExample;
import com.sinco.carnation.user.vo.UserExpertsVO;
import com.sinco.dal.common.MyPage;

@Repository
public class UserExpertsDao {

	@Autowired
	private UserExpertsMapper mapper;

	public int updateExpertsPraises(Long uid, String praiseInfo) {
		return mapper.updateExpertsPraises(uid, praiseInfo);
	}

	public int updateExpertsUnPraises(Long uid, String praiseInfo) {
		return mapper.updateExpertsUnPraises(uid, praiseInfo);
	}

	/** generate code begin **/
	public List<UserExperts> findAll() {
		UserExpertsExample example = new UserExpertsExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		UserExpertsExample example = new UserExpertsExample();
		return mapper.countByExample(example);
	}

	public List<UserExperts> save(Iterable<UserExperts> entities) {
		List<UserExperts> list = new ArrayList<UserExperts>();
		for (UserExperts UserExperts : entities) {
			list.add(save(UserExperts));
		}
		return list;
	}

	public UserExperts save(UserExperts record) {
		if (record.getUid() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(UserExperts record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public UserExperts findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public UserExpertsBO selectExpertsDetail(java.lang.Long uId) {
		return mapper.selectExpertsDetail(uId);
	}

	public UserExperts get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		UserExpertsExample example = new UserExpertsExample();
		example.createCriteria().andUidEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<UserExperts> findAll(Iterable<Long> ids) {
		UserExpertsExample example = new UserExpertsExample();
		example.createCriteria().andUidIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(UserExperts entity) {
		mapper.deleteByPrimaryKey(entity.getUid());
	}

	public void delete(Iterable<UserExperts> entities) {
		List<Long> ids = Lists.newArrayList();
		for (UserExperts entity : entities) {
			ids.add(entity.getUid());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		UserExpertsExample example = new UserExpertsExample();
		example.createCriteria().andUidIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		UserExpertsExample example = new UserExpertsExample();
		mapper.deleteByExample(example);
	}

	public int insert(UserExperts record) {
		return mapper.insert(record);
	}

	public int insertSelective(UserExperts record) {
		return mapper.insertSelective(record);
	}

	/** generate code end **/

	public List<UserExpertsBO> queryUserExperts(Long uid, Integer expertType, String type,
			MyPage<UserExpertsBO> page) {
		return mapper.queryExperts(uid, expertType, type, page);
	}

	public List<UserExpertsBO> selectExpertsListByVO(UserExpertsVO vo, MyPage<UserExpertsBO> page) {
		return mapper.selectExpertsListByVO(vo, page);
	}

	public List<UserExpertsBO> queryExpertsList(ExpertsVO vo, MyPage<UserExpertsBO> page) {
		return mapper.queryExpertsList(vo, page);
	}

	public UserExpertsBO selectById(Long uid) {
		return mapper.selectById(uid);
	}

	public int delectExpertByIds(Long[] uid) {
		return mapper.delectExpertByIds(uid);
	}

	public void updateExpertsFavo(Long uid, String favorInfo) {
		mapper.updateExpertsFavo(uid, favorInfo);
	}

	public UserExperts queryExpertById(Long uid) {
		return mapper.selectByPrimaryKey(uid);
	}

	public int updateExpertsUnFavo(Long uid, String favorInfo) {
		return mapper.updateExpertsUnFavo(uid, favorInfo);
	}

	public List<UserExpertsBO> selectExpertsList(Integer expertType) {
		return mapper.selectExpertsList(expertType);
	}

}
