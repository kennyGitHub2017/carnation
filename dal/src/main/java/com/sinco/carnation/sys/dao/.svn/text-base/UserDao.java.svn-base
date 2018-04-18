package com.sinco.carnation.sys.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.sys.bo.RelationBO;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.mapper.UserMapper;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.model.UserExample;
import com.sinco.carnation.sys.vo.UserVO;
import com.sinco.dal.common.MyPage;

@Repository
public class UserDao {

	@Autowired
	private UserMapper mapper;

	public int selectUserCountByTime(Date time) {
		UserExample example = new UserExample();
		example.createCriteria().andCreateTimeGreaterThanOrEqualTo(time);
		return mapper.countByExample(example);
	}

	public UserBO findByLoginName(String loginName) {
		return mapper.findByLoginName(loginName);
	}

	public UserBO findByInvitationCode(String invitationCode) {
		return mapper.findByInvitationCode(invitationCode);
	}

	public RelationBO findRelationSidByInvitationCode(String invitationCode) {
		return mapper.findRelationSidByInvitationCode(invitationCode);
	}

	public int deleteById(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	public int insert(User record) {
		return mapper.insert(record);
	}

	public UserBO findById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public int updateById(User record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	public List<User> findByVO(UserVO vo) {
		UserExample example = new UserExample();
		return mapper.selectByExample(example);
	}

	public UserBO fetchRefereeUser(Long userId) {
		return mapper.fetchRefereeUser(userId);
	}

	public List<UserBO> findRefereeUserList(Long userId, MyPage<UserBO> page) {
		return mapper.findRefereeUserList(userId, page);
	}

	public User queryUserById(Long userId) {
		UserExample example = new UserExample();
		example.createCriteria().andIdEqualTo(userId).andStatusEqualTo(1);
		List<User> list = mapper.selectByExample(example);
		return list.isEmpty() ? null : list.get(0);
	}

	public Long countUserRegister(Boolean isDeleted) {
		return this.mapper.countUserRegister(isDeleted);
	}

	public int updateUserForIsDeleted(Long uid, Long currentUserID, boolean isDeleted) {
		if (uid == null) {
			return 1;
		}
		this.mapper.updateUserForIsDeleted(uid, currentUserID, isDeleted);
		return 0;
	}

	public void update(User user) {
		this.mapper.updateByPrimaryKey(user);
	}

	public List<User> getByTimeAndCoupon(Integer couponId, String startTime, String endTime) {
		return this.mapper.getByTimeAndCoupon(couponId, startTime, endTime);
	}
}
