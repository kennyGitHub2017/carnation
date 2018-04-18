package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sns.mapper.UserHealthtaskMapper;
import com.sinco.carnation.sns.model.UserHealthtask;
import com.sinco.carnation.sns.bo.UserHealthtaskBO;
import com.sinco.carnation.sns.model.UserHealthtaskExample;
import com.sinco.dal.common.MyPage;

@Repository
public class UserHealthtaskDao {

	@Autowired
	private UserHealthtaskMapper mapper;

	/** generate code begin **/
	public List<UserHealthtaskBO> findAll() {
		UserHealthtaskExample example = new UserHealthtaskExample();
		return mapper.selectByExample(example);
	}

	List<UserHealthtaskBO> findAll(Iterable<Long> ids) {
		UserHealthtaskExample example = new UserHealthtaskExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		UserHealthtaskExample example = new UserHealthtaskExample();
		return mapper.countByExample(example);
	}

	public List<UserHealthtask> save(Iterable<UserHealthtask> entities) {
		List<UserHealthtask> list = new ArrayList<UserHealthtask>();
		for (UserHealthtask UserHealthtask : entities) {
			list.add(save(UserHealthtask));
		}
		return list;
	}

	public UserHealthtask save(UserHealthtask record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(UserHealthtask record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public UserHealthtaskBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		UserHealthtaskExample example = new UserHealthtaskExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(UserHealthtask entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<UserHealthtask> entities) {
		List<Long> ids = Lists.newArrayList();
		for (UserHealthtask entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		UserHealthtaskExample example = new UserHealthtaskExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		UserHealthtaskExample example = new UserHealthtaskExample();
		mapper.deleteByExample(example);
	}

	public List<UserHealthtaskBO> get_HealthTaskList_Dao(MyPage<UserHealthtaskBO> page, List<Long> list) {
		return this.mapper.select_healthTask_List(page, list);
	}

	public List<UserHealthtaskBO> get_HealthTaskList_Dao(String taskName, List<java.lang.Long> idList) {
		return this.mapper.select_healthTaskByLike_List(taskName, idList);
	}

	public int insert_userHealthTaskDao(UserHealthtask obj) {
		return this.mapper.insert_userHealthTask(obj);
	}

	public int update_JoinNum_ByPrimaryKeyDao(long id) {
		return this.mapper.update_JoinNum_ByPrimaryKey(id);
	}

	public List<UserHealthtaskBO> get_List_In_ID(List<Long> idList) {
		return this.mapper.select_UserHealthtask_in_ID(idList);
	}

	/**
	 * 假删除
	 * 
	 * @param id
	 * @return
	 */
	public int deleteByID(long id) {
		return this.mapper.update_Del_By_ID(id);
	}

	public List<UserHealthtaskBO> getHealthTaskListList(int num) {
		return this.mapper.select_UserHealthTask_limit(num);
	}

	/**
	 * 获取系统创建的健康任务
	 * 
	 * @param page
	 * @return
	 */
	public List<UserHealthtaskBO> getSysHealthTask(MyPage<UserHealthtaskBO> page, List<Long> list) {
		return this.mapper.select_SysHealthTaskList(page, list);
	}
}
