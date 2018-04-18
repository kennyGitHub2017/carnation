package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sns.bo.UserHealthtaskBO;
import com.sinco.carnation.sns.bo.UserHealthtaskRelationBO;
import com.sinco.carnation.sns.mapper.UserHealthtaskMapper;
import com.sinco.carnation.sns.mapper.UserHealthtaskRelationMapper;
import com.sinco.carnation.sns.model.UserHealthtaskRelation;
import com.sinco.carnation.sns.model.UserHealthtaskRelationExample;
import com.sinco.dal.common.MyPage;

@Repository
public class UserHealthtaskRelationDao {

	private Logger log = LoggerFactory.getLogger(UserHealthtaskRelationDao.class);

	@Autowired
	private UserHealthtaskRelationMapper mapper;

	@Autowired
	private UserHealthtaskMapper userHealthtaskMapper;

	/** generate code begin **/
	public List<UserHealthtaskRelationBO> findAll() {
		UserHealthtaskRelationExample example = new UserHealthtaskRelationExample();
		return mapper.selectByExample(example);
	}

	List<UserHealthtaskRelationBO> findAll(Iterable<Long> ids) {
		UserHealthtaskRelationExample example = new UserHealthtaskRelationExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		UserHealthtaskRelationExample example = new UserHealthtaskRelationExample();
		return mapper.countByExample(example);
	}

	/*public List<UserHealthtaskRelation> save(Iterable<UserHealthtaskRelation> entities){
		List<UserHealthtaskRelation> list=new ArrayList<UserHealthtaskRelation>();
		for (UserHealthtaskRelation UserHealthtaskRelation : entities) {
			list.add(save(UserHealthtaskRelation));
		}
		return list;
	}*/

	/*public UserHealthtaskRelation save(UserHealthtaskRelation record){
		if(record.getId() == null){
			mapper.insertSelective(record);
		}else{
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}*/

	public void update(UserHealthtaskRelation record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public UserHealthtaskRelationBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		UserHealthtaskRelationExample example = new UserHealthtaskRelationExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(UserHealthtaskRelation entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<UserHealthtaskRelation> entities) {
		List<Long> ids = Lists.newArrayList();
		for (UserHealthtaskRelation entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		UserHealthtaskRelationExample example = new UserHealthtaskRelationExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		UserHealthtaskRelationExample example = new UserHealthtaskRelationExample();
		mapper.deleteByExample(example);
	}

	/**
	 * 根据用户ID获取健康任务
	 * 
	 * @param userID
	 *            ：用户ID
	 * @return
	 */
	public List<UserHealthtaskRelationBO> select_UserHealthtaskRelation_By_UserId(Long userID,
			MyPage<UserHealthtaskRelationBO> page) {
		List<UserHealthtaskRelationBO> obj_list = this.mapper.select_UserHealthtaskRelation_By_UserId(userID,
				page);;
		List<UserHealthtaskRelationBO> return_list = new ArrayList<UserHealthtaskRelationBO>();

		if (obj_list != null && obj_list.size() > 0) {
			log.info("......." + obj_list.size());
			List<Long> healthTaskID_List = new ArrayList<Long>();
			Map<Long, UserHealthtaskRelationBO> map = new HashMap<Long, UserHealthtaskRelationBO>();
			for (UserHealthtaskRelationBO obj : obj_list) {
				long userHealthtaskId = obj.getUserHealthtaskId();
				healthTaskID_List.add(userHealthtaskId);
				map.put(userHealthtaskId, obj);
			}

			List<UserHealthtaskBO> user_HealthTask_List = userHealthtaskMapper
					.select_UserHealthtask_in_ID(healthTaskID_List);

			UserHealthtaskRelationBO userHealthTaskRelationBO = null;

			for (UserHealthtaskBO obj : user_HealthTask_List) {
				Long id = obj.getId();

				UserHealthtaskRelationBO temp_Obj = map.get(id);
				userHealthTaskRelationBO = new UserHealthtaskRelationBO();
				userHealthTaskRelationBO.setTaskName(obj.getTaskName());
				userHealthTaskRelationBO.setDoDays(temp_Obj.getDoDays());
				userHealthTaskRelationBO.setHealthTaskID(obj.getId());
				userHealthTaskRelationBO.setIconURL(obj.getIconURL());
				return_list.add(userHealthTaskRelationBO);
			}

		}
		return return_list;
	}

	public int insert_UserHealthtaskRelationDao(UserHealthtaskRelation record) {
		return this.mapper.insert_UserHealthtaskRelation(record);
	}

	/**
	 * 获取用户已参与的活动ID
	 * 
	 * @param userID
	 * @return
	 */
	public List<Long> get_userJoinTaskID_ByUserID(Long userID) {
		List<UserHealthtaskRelationBO> list = this.mapper.select_UserHealthtaskRelation_By_UserId(userID);
		List<Long> id_List = new ArrayList<Long>();
		for (UserHealthtaskRelationBO obj : list) {
			id_List.add(obj.getUserHealthtaskId());
		}
		return id_List;
	}

	public List<UserHealthtaskRelationBO> get_Today_HealthTaskRelationDao(Long userID, List<Long> idlist) {
		return this.mapper.select_today_HealthTaskRelation(userID, idlist);
	}

	public UserHealthtaskRelationBO getUserHealthtaskRelationOne(Long userID, Long taskID) {
		return this.mapper.getOne_HealthTaskRelation_By_uid_taskID(userID, taskID);
	}

	/**
	 * 用户健康任务签到
	 * 
	 * @param id
	 * @param uid
	 * @param taskID
	 * @param finishTime
	 * @return
	 */
	public int updateUserHealthTaskSign(long id, long uid, long taskID, String finishTime) {
		return this.mapper.update_HealthTask_Sing(id, uid, taskID, finishTime);
	}

	public int deleteHealthtaskRelation(long uid, long taskID) {
		return this.mapper.deleteHealthtaskRelation(uid, taskID);
	}
}
