package com.sinco.carnation.user.dao;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.mapper.UserCustomerFavoritesMapper;
import com.sinco.carnation.user.mapper.UserCustomerMapper;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.model.UserCustomerExample;
import com.sinco.carnation.user.vo.UserCustomerVO;
import com.sinco.dal.common.MyPage;

@Repository
public class UserCustomerDao {

	@Autowired
	private UserCustomerMapper mapper;

	@Autowired
	private UserCustomerFavoritesMapper favoritesMapper;

	public int selectCustomerCountByArea(String areaId) {
		return mapper.selectCustomerCountByArea(areaId);
	}

	public int selectOperatorCustomerCount(UserCustomerVO vo) {
		return mapper.selectOperatorCustomerCount(vo);
	}

	public int selectOwnCustomerCount(UserCustomerVO vo) {
		return mapper.selectOwnCustomerCount(vo);
	}

	public List<UserCustomerBO> selectUserCustomerByOperatorUserId(UserCustomerVO vo,
			MyPage<UserCustomerBO> page) {
		return mapper.selectUserCustomerByOperatorUserId(vo, page);
	}

	public List<UserCustomerBO> selectOwnCustomerByOperatorUserId(UserCustomerVO vo,
			MyPage<UserCustomerBO> page) {
		return mapper.selectOwnCustomerByOperatorUserId(vo, page);
	}

	public int count() {
		UserCustomerExample example = new UserCustomerExample();
		return mapper.countByExample(example);
	}

	/**
	 * 根据昵称 count
	 * 
	 * @param nickname
	 * @return
	 */
	public int countByNickname(String nickname, Long notUid) {
		UserCustomerExample example = new UserCustomerExample();
		UserCustomerExample.Criteria c = example.createCriteria();
		c.andNicknameEqualTo(nickname);
		if (notUid != null) {
			c.andUidNotEqualTo(notUid);
		}
		return mapper.countByExample(example);
	}

	/**
	 * 查找所有用户
	 * 
	 * @param isDelete
	 * @return
	 */
	public List<UserCustomerBO> findAll(Boolean isDelete) {
		UserCustomerExample example = new UserCustomerExample();
		if (isDelete != null) {
			example.createCriteria().andIsDeletedEqualTo(isDelete);
		}
		return mapper.selectByExampleBO(example);
	}

	/**
	 * 增加用户积分
	 * 
	 * @param uid
	 * @param integral
	 * @return
	 */
	public int addIntegral(Long uid, int integral) {
		return mapper.addIntegral(uid, integral);
	}

	/**
	 * 减少用户积分
	 * 
	 * @param uid
	 * @param integral
	 * @return
	 */
	public int subtractIntegral(Long uid, int integral) {
		return mapper.subtractIntegral(uid, integral);
	}

	/**
	 * 得到放session里的个人数据
	 * 
	 * @param id
	 * @return
	 */
	public UserCustomerBO findSessionUser(Long id) {
		return mapper.findSessionUser(id);
	}

	public UserCustomerBO findBOByUserId(Long id) {
		return mapper.findBOByUserId(id);
	}

	public int deleteById(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	public int insert(UserCustomer record) {
		// 昵称最多12个字符串
		if (null != record.getNickname() && record.getNickname().toString().trim().length() > 12) {
			record.setNickname(record.getNickname().substring(0, 11));
			record.setNickname(StringFilter(record.getNickname()));
		}
		return mapper.insertSelective(record);
	}

//	public int updateBalance(String balance, String userId) {
//		return mapper.updateBalance(balance, userId);
//	}

	public UserCustomer findById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public int updateById(UserCustomer record) {
		// 昵称最多12个字符串
		if (null != record.getNickname() && record.getNickname().toString().trim().length() > 12) {
			record.setNickname(record.getNickname().substring(0, 11));
			record.setNickname(StringFilter(record.getNickname()));
		}
		return mapper.updateByPrimaryKeyForMobile(record);

	}

	public UserCustomerBO findByMobile(String mobile) {
		UserCustomerExample example = new UserCustomerExample();
		example.createCriteria().andMobileEqualTo(mobile);
		List<UserCustomerBO> list = mapper.selectByExampleBO(example);
		return list.isEmpty() ? null : list.get(0);
	}

	public UserCustomerBO searchCustomerBO(Long userId) {
		UserCustomerExample example = new UserCustomerExample();
		example.createCriteria().andUidEqualTo(userId).andStatusEqualTo("1").andIsDeletedEqualTo(false);
		List<UserCustomerBO> list = mapper.selectByExampleBO(example);
		return list.isEmpty() ? null : list.get(0);
	}

	public List<UserCustomer> searchCustomer(Long userId) {
		UserCustomerExample example = new UserCustomerExample();
		example.createCriteria().andUidEqualTo(userId);
		List<UserCustomer> list = mapper.selectByExample(example);
		return list;
	}

	public int updateByPrimaryKeySelective(UserCustomer record) {
		// 昵称最多12个字符串
		if (null != record.getNickname() && record.getNickname().toString().trim().length() > 12) {
			record.setNickname(record.getNickname().substring(0, 11));
			record.setNickname(StringFilter(record.getNickname()));
		}
		return mapper.updateByPrimaryKeySelective(record);
	}

	public List<UserCustomerBO> queryCustomerPageList(UserCustomerVO vo, MyPage<UserCustomerBO> page) {
		return mapper.queryCustomerPageList(vo, page);
	}

	public List<UserCustomerBO> queryCustomerPageList2(UserCustomerVO vo, MyPage<UserCustomerBO> page) {
		return mapper.queryCustomerPageList2(vo, page);
	}

	public UserCustomerBO selectByNickname(String nickname) {
		return mapper.selectByNickname(nickname);
	}

	public UserCustomerBO queryUserByUid(Long uid) {
		List<UserCustomerBO> list = mapper.queryUserByUid(uid);
		return list.isEmpty() ? null : list.get(0);
	}

	public List<UserCustomerBO> queryUserCuxtomerList() {
		return mapper.queryUserCuxtomerList();
	}

	public UserCustomerBO queryUserCuxtomerByLoginName(String loginName) {
		List<UserCustomerBO> list = mapper.queryUserCuxtomerByLoginName(loginName);
		return list.isEmpty() ? null : list.get(0);
	}

	public List<UserCustomerBO> queryStoreCustomer(Long sellerUid, String mobile, MyPage<UserCustomerBO> page) {
		return mapper.queryStoreCustomer(sellerUid, mobile, page);
	}

	public List<UserCustomerBO> queryUserCustomerByOperatorUserId(UserCustomerVO vo,
			MyPage<UserCustomerBO> page) {
		return mapper.queryUserCustomerByOperatorUserId(vo, page);
	}

	public List<UserCustomerBO> queryUserStatistics() {
		return mapper.queryUserStatistics();
	}

	public List<UserCustomerBO> queryRelationList(Long uid, MyPage<UserCustomerBO> page) {
		return mapper.queryRelationList(uid, page);
	}

	public List<UserCustomerBO> queryUserByRelation1(Long relationId, MyPage<UserCustomerBO> page) {
		return mapper.queryUserByRelation1(relationId, page);
	}

	public List<UserCustomerBO> queryUserByRelation2(Long relationId, MyPage<UserCustomerBO> page) {
		return mapper.queryUserByRelation2(relationId, page);
	}

	public List<UserCustomerBO> queryUserByRelation3(Long relationId, MyPage<UserCustomerBO> page) {
		return mapper.queryUserByRelation3(relationId, page);
	}

	public int queryUserByRelation1Count(Long relationId, String startTime, String endTime) {
		return mapper.queryUserByRelation1_count(relationId, startTime, endTime);
	}

	public int queryUserByRelation2Count(Long relationId, String startTime, String endTime) {
		return mapper.queryUserByRelation2_count(relationId, startTime, endTime);
	}

	public int queryUserByRelation3Count(Long relationId, String startTime, String endTime) {
		return mapper.queryUserByRelation3_count(relationId, startTime, endTime);
	}

	public int updateMobileByUID(Long uid, String mobile) {
		UserCustomer userCustomer = this.mapper.selectByPrimaryKey(uid);
		if (null != userCustomer) {
			userCustomer.setMobile(mobile);
			return this.mapper.updateByPrimaryKeyForMobile(userCustomer);
		} else {
			return 0;
		}
	}

	public List<UserCustomerBO> queryUserByRelationByIn_RefereeUserId(List<Long> relationIDList) {
		return this.mapper.queryUserByRelationByIn_RefereeUserId(relationIDList);
	}

	public int updateUserCustomerForIsDelete(Long uid, Long currentUserID, boolean isDeleted) {
		return this.mapper.updateUserCustomerForIsDelete(uid, currentUserID, isDeleted);
	}

	public static String StringFilter(String str) throws PatternSyntaxException {
		// 只允许字母和数字
		// String regEx = "[^a-zA-Z0-9]";
		// 清除掉所有特殊字符
		String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}
	public UserCustomerBO findOneByUserId(Long id){
		return this.mapper.findOneByUserId(id);
	}
}
