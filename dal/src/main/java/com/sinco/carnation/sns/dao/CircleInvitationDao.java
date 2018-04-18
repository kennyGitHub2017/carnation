package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sns.bo.CircleInvitationBO;
import com.sinco.carnation.sns.mapper.CircleInvitationMapper;
import com.sinco.carnation.sns.model.CircleInvitation;
import com.sinco.carnation.sns.model.CircleInvitationExample;
import com.sinco.carnation.sns.vo.CircleInvitationVO;
import com.sinco.dal.common.MyPage;

@Repository
public class CircleInvitationDao {

	@Autowired
	private CircleInvitationMapper mapper;

	public List<CircleInvitation> findAll() {
		CircleInvitationExample example = new CircleInvitationExample();
		return mapper.selectByExample(example);
	}

	public List<CircleInvitation> selectInvitationByClassId(Long classId) {
		return mapper.selectInvitationByClassId(classId);
	}

	public List<CircleInvitation> save(Iterable<CircleInvitation> entities) {
		List<CircleInvitation> list = new ArrayList<CircleInvitation>();
		for (CircleInvitation CircleInvitation : entities) {
			list.add(save(CircleInvitation));
		}
		return list;
	}

	public CircleInvitation save(CircleInvitation record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(CircleInvitation record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public CircleInvitation findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public CircleInvitation get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		CircleInvitationExample example = new CircleInvitationExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<CircleInvitation> findAll(Iterable<Long> ids) {
		CircleInvitationExample example = new CircleInvitationExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public List<CircleInvitation> selectPageByVO(CircleInvitationVO vo, MyPage<CircleInvitation> page) {
		return mapper.selectPageByVO(vo, page);
	}

	public List<CircleInvitation> selectPageByOfficVO(CircleInvitationVO vo, MyPage<CircleInvitation> page) {
		return mapper.selectPageByOfficVO(vo, page);
	}

	public long count() {
		CircleInvitationExample example = new CircleInvitationExample();
		return mapper.countByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(CircleInvitation entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<CircleInvitation> entities) {
		List<Long> ids = Lists.newArrayList();
		for (CircleInvitation entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		CircleInvitationExample example = new CircleInvitationExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		CircleInvitationExample example = new CircleInvitationExample();
		mapper.deleteByExample(example);
	}

	public List<CircleInvitationBO> queryCircleInvatation(Long uid, String type, Integer circleType,
			String timeStamp, MyPage<CircleInvitationBO> page) {
		return mapper.queryCircleInvitation(uid, type, circleType, timeStamp, page);
	}

	public CircleInvitation queryCircleInvitationById(Long fid) {
		CircleInvitationExample example = new CircleInvitationExample();
		example.createCriteria().andIdEqualTo(fid);
		List<CircleInvitation> list = mapper.selectByExample(example);
		return list.isEmpty() ? null : list.get(0);
	}

	public int usersPraise(CircleInvitation invitation) {
		CircleInvitationExample circle = new CircleInvitationExample();
		circle.createCriteria().andIdEqualTo(invitation.getId());
		return mapper.updateByExampleSelective(invitation, circle);
	}

	public List<CircleInvitation> lookInvitation(Long id) {
		CircleInvitationExample example = new CircleInvitationExample();
		example.createCriteria().andIdEqualTo(id);
		List<CircleInvitation> list = mapper.selectByExample(example);
		return list;
	}

	public CircleInvitationBO selectInvitationDetail(Long id) {
		return mapper.selectInvitationDetail(id);
	}

	public List<CircleInvitationBO> circleByInvitationList(Long circleId, Long circleType, String timeStamp,
			MyPage<CircleInvitationBO> page) {
		return mapper.circleList(circleId, circleType, timeStamp, page);
	}

	public List<CircleInvitationBO> circleInvitationList(Long uid, MyPage<CircleInvitationBO> page) {
		return mapper.circleInvitationList(uid, page);
	}

	public int addInvitation(CircleInvitation invitation) {
		return mapper.insertSelective(invitation);
	}

	public List<CircleInvitationBO> invitationAllListPage(Long invitationType, String timeStamp,
			MyPage<CircleInvitationBO> page) {
		return mapper.invitationAllListPage(invitationType, timeStamp, page);
	}

	public List<CircleInvitationBO> searchInvitation(String title, String timeStamp,
			MyPage<CircleInvitationBO> page) {
		return mapper.searchInvitation(title, timeStamp, page);
	}

	public void updateFavo(Long id, String praiseInfo) {
		mapper.updateFavo(id, praiseInfo);
	}

	public void updateInvitationUnFavo(Long id, String favoritesInfo) {
		mapper.updateInvitationUnFavo(id, favoritesInfo);
	}

	public int updateInvitationUnPraise(Long id, String praiseInfo) {
		return mapper.updateInvitationUnPraise(id, praiseInfo);
	}

	public int updateInvitationPraise(Long id, String praiseInfo) {
		return mapper.updateInvitationPraise(id, praiseInfo);
	}

	public List<CircleInvitationBO> queryByIds(Set<Long> set) {
		return mapper.queryByIds(set);
	}

	public List<CircleInvitation> findAllByIds(List<Long> relationIds) {
		return this.findAll(relationIds);
	}

}
