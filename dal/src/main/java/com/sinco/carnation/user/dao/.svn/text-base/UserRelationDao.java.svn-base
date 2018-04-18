package com.sinco.carnation.user.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.bo.UserRelationBO;
import com.sinco.carnation.user.mapper.UserCustomerMapper;
import com.sinco.carnation.user.mapper.UserRelationMapper;
import com.sinco.carnation.user.model.UserRelation;
import com.sinco.carnation.user.model.UserRelationExample;

@Repository
public class UserRelationDao {

	@Autowired
	private UserRelationMapper mapper;

	/**
	 * 将某用户的推荐人置为null
	 * 
	 * @return
	 */
	public boolean updateUserReferee2Nll(long uid) {
		return 1 == mapper.updateUserReferee2Nll(uid);
	}

	/** generate code begin **/
	public List<UserRelationBO> findAll() {
		UserRelationExample example = new UserRelationExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		UserRelationExample example = new UserRelationExample();
		return mapper.countByExample(example);
	}

	// public List<UserRelation> save(Iterable<UserRelation> entities) {
	// List<UserRelation> list = new ArrayList<UserRelation>();
	// for (UserRelation UserRelation : entities) {
	// list.add(save(UserRelation));
	// }
	// return list;
	// }
	public int insertSelective(UserRelation record) {
		return mapper.insertSelective(record);
	}

//	public UserRelation save(UserRelation record) {
//		if (record.getUserId() == null) {
//			mapper.insertSelective(record);
//		} else {
//			mapper.updateByPrimaryKeySelective(record);
//		}
//		return record;
//	}

	public int update(UserRelation record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Autowired
	private UserCustomerMapper customerMapper;

	public void updateOrCreate(UserRelation record, String currentPhone, String currentCity,
			String sellerCity, StoreBO storeBo) {
		StringBuilder sb = new StringBuilder();

		int i = mapper.updateByPrimaryKeySelective(record);

		if (i <= 0) {
			Date dt = new Date();
			record.setCreateTime(dt);
			record.setUpdateTime(dt);
			mapper.insert(record);

			sb.append("insert into user_relation (user_id, seller_user_id, update_time, create_time,relation_type)");
			sb.append(String.format("values ('%s', '%s',  NOW(), NOW(),0);", record.getUserId(),
					record.getSellerUserId()));

			write(sb.toString(), "insert");

		} else {

			if (record.getSellerUserId() > 0) {
				String uName = "", reName = "", sName = "";

				UserCustomerBO bo = customerMapper.findBOByUserId(record.getUserId());
				if (bo != null) {
					uName = String.format(" 昵称：%s, 名字：%s, 手机：%s, 手机所在城市：%s", bo.getNickname(), bo.getName(),
							currentPhone, currentCity);
				}
				UserCustomerBO rebo = customerMapper.findBOByUserId(record.getRefereeUserId());
				if (rebo != null) {
					reName = String.format(" 昵称：%s, 名字：%s", rebo.getNickname(), rebo.getName());
				}

				UserCustomerBO sbo = customerMapper.findBOByUserId(record.getSellerUserId());
				if (sbo != null) {
					sName = String.format(" 昵称：%s, 商铺：%s, 名字：%s, 商家所在城市：%s", sbo.getNickname(),
							bo == null ? "" : bo.getStoreName(), bo == null ? "" : bo.getName(), sellerCity);
				}

				write(String.format("# 推荐关系修改 用户：[%s] 推荐人为：[%s] 所属商户由空改为：[%s] ", uName, reName, sName),
						"update");

				write(sb.toString(), "update");

				write(String.format(
						"update user_relation set seller_user_id = %s, update_time = NOW() Where user_id = %s AND ifnull(seller_user_id,'') = '';",
						record.getSellerUserId(), record.getUserId()), "update");

				write(sb.toString(), "update");

				write(String.format(
						"update user_relation set seller_user_id = NULL, update_time = NOW() Where user_id = %s;",
						record.getUserId()), "update_re");
			}
		}
	}

	public void write(String sql, String fileName) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(String.format("c:\\%s.txt",
					fileName)), true));
			writer.write(sql);
			writer.write("\r\n");
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UserRelationBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public UserRelationBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		UserRelationExample example = new UserRelationExample();
		example.createCriteria().andUserIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<UserRelationBO> findAll(Iterable<Long> ids) {
		UserRelationExample example = new UserRelationExample();
		example.createCriteria().andUserIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(UserRelation entity) {
		mapper.deleteByPrimaryKey(entity.getUserId());
	}

	public void delete(Iterable<UserRelation> entities) {
		List<Long> ids = Lists.newArrayList();
		for (UserRelation entity : entities) {
			ids.add(entity.getUserId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		UserRelationExample example = new UserRelationExample();
		example.createCriteria().andUserIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		UserRelationExample example = new UserRelationExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public UserRelationBO queryUserRation(Long userId) {
		UserRelationExample example = new UserRelationExample();
		// .andSellerUserIdEqualTo(sellerUid);
		example.createCriteria().andUserIdEqualTo(userId);
		List<UserRelationBO> list = mapper.selectByExample(example);
		return list.isEmpty() ? null : list.get(0);
	}

	public int queryRefereeUserCount(Long refereeUserId, String startDate, String endDate) {
		return mapper.queryRefereeUserCount(refereeUserId, startDate, endDate);
	}

	public int queryOwnCustomerCount(Long refereeUserId, String startDate, String endDate) {
		return mapper.queryOwnCustomerCount(refereeUserId, startDate, endDate);
	}

	public int queryRefereeSellerCount(Long refereeUserId, String startDate, String endDate) {
		return mapper.queryRefereeSellerCount(refereeUserId, startDate, endDate);
	}

	public UserRelationBO queryReferee(Long uid) {
		return mapper.queryReferee(uid);
	}

	public UserRelationBO queryUserRelation(Long uid) {
		return mapper.queryUserRelation(uid);
	}

	public UserRelationBO queryExistUserRelationCode(Long uid) {
		return mapper.queryExistUserRelationCode(uid);
	}

	public UserRelationBO findFirstNORelationBelongSeller() {
		return mapper.findFirstNORelationBelongSeller();
	}

	public List<UserRelationBO> findRelationListByRefereeUserId(Long refereeUserId) {
		UserRelationExample example = new UserRelationExample();
		example.createCriteria().andRefereeUserIdEqualTo(refereeUserId);
		List<UserRelationBO> list = mapper.selectByExample(example);
		return list;
	}

	/**
	 * 将 所属商家Id 0 改为null
	 * 
	 * @return
	 */
	public int updateUserRelationToNull() {
		return mapper.updateUserRelationToNull();
	}

	public List<Long> queryUserRefereeByInRefereeUserID(List<Long> list) {
		if (list == null || list.size() == 0) {
			return new ArrayList<Long>();
		}
		List<Long> resultList = this.mapper.queryUserRefereeByInRefereeUserID(list);
		return resultList;
	}

	/**
	 * 根据CN账号查询CN会员注册数量
	 * 
	 * @param cnUserName
	 * @return
	 */
	public Integer queryRegistCountByCnUserNameFromAccount(List<String> cnUserName, String start, String end) {
		return this.mapper.queryRegistCountByCnUserNameFromAccount(cnUserName, start, end);
	}

	/**
	 * 根据CN账号查询CN运营商注册数量
	 * 
	 * @param cnUserName
	 * @return
	 */
	public Integer queryRegistCountByCnUserNameFromOperator(List<String> cnUserName, String start, String end) {
		return this.mapper.queryRegistCountByCnUserNameFromOperator(cnUserName, start, end);
	}

	/**
	 * 根据CN账号查询CN 会员/运营商 注册商户注册会员数量
	 * 
	 * @param cnUserName
	 * @param type
	 *            1,用户 2,运营商
	 * @return
	 */
	public Integer queryRegistShopRegistCountByCnUserName(List<String> cnUserName, String type, String start,
			String end) {
		if(cnUserName == null){
			return 0;
		}
		return this.mapper.queryRegistShopRegistCountByCnUserName(cnUserName, type, start, end);
	}

	/**
	 * 根据uid查询下级关系uid
	 * 
	 * @param list
	 * @return
	 */
	public List<Long> getRelationUidByUid(List<Long> list) {
		return this.mapper.getRelationUidByUid(list);
	}

	/** 根据推荐人uid查询该会员推荐的人数 **/
	public Integer countRelationByRefereeUid(Long refereeUid) {
		if (null == refereeUid) {
			return 0;
		}
		return this.mapper.countRelationByRefereeUid(refereeUid);
	}

	/** 更新推荐人 **/
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Integer updateRefereeUidByOldRefereeUid(Long oldRefereeUid, Long newRefereeUid) {
		if (null == oldRefereeUid || null == newRefereeUid) {
			return 0;
		}
		return this.mapper.updateRefereeUidByOldRefereeUid(oldRefereeUid, newRefereeUid);
	}

	/** 根据推荐人uid查询该商户绑定会员人数 **/
	public Integer countSellerRelationByUid(Long sellerUid) {
		if (null == sellerUid) {
			return 0;
		}
		return this.mapper.countSellerRelationByUid(sellerUid);
	}

	/** 更新商户绑定关系 **/
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Integer updateSellerByOldRefereeUid(Long oldUid, Long newUid) {
		if (null == oldUid || null == newUid) {
			return 0;
		}
		return this.mapper.updateSellerByOldRefereeUid(oldUid, newUid);
	}
}
