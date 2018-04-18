package com.sinco.carnation.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.user.bo.UserGroupBO;
import com.sinco.carnation.user.bo.UserGroupMapBO;
import com.sinco.carnation.user.dao.UserGroupDao;
import com.sinco.carnation.user.dao.UserGroupMapDao;
import com.sinco.carnation.user.dao.UserGroupRoleDao;
import com.sinco.carnation.user.model.UserGroupMap;
import com.sinco.carnation.user.model.UserGroupRole;
import com.sinco.carnation.user.vo.UserGroupVO;
import com.sinco.dal.common.MyPage;

/**
 * <p>
 * Title:UserGroupService
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author： 陈舟
 * 
 * @date：2016年2月17日 下午3:03:58
 * @version V1.0
 */
@Service
public class UserGroupService {

	@Autowired
	private UserGroupDao userGroupDao;

	@Autowired
	private UserGroupRoleDao userGroupRoleDao;

	@Autowired
	private UserGroupMapDao userGroupMapDao;

	/**
	 * 获取当前系统默认的用户组
	 * 
	 * @return
	 */
	public UserGroupBO getUserGroupIsSystem() {

		List<UserGroupBO> list = userGroupDao.getUserGroupIsSystem();
		if (CollectionUtils.isEmpty(list))
			return null;
		return list.get(0);
	}

	/**
	 * 保存用户的权限
	 * 
	 * @param uid
	 * @param rids
	 */
	@Transactional(readOnly = false)
	public void saveUserGroupRole(UserGroupVO vo, String roleType, Long[] rids) {
		userGroupDao.save(vo);
		saveUserGroupRole(vo.getId(), roleType, rids);
	}

	/**
	 * 保存用户的权限
	 * 
	 * @param uid
	 * @param rids
	 */
	@Transactional(readOnly = false)
	public void saveUserGroupRole(Long groupId, String roleType, Long[] rids) {
		UserGroupBO userGroup = userGroupDao.findOne(groupId);
		if (userGroup != null) {
			userGroupRoleDao.deleteByRoleTypeAndGroupId(groupId, roleType);

			List<UserGroupRole> urs = new ArrayList<UserGroupRole>();
			for (Long rid : rids) {
				UserGroupRole ur = new UserGroupRole();
				ur.setRoleId(rid);
				ur.setUserGroupId(groupId);
				urs.add(ur);
			}
			userGroupRoleDao.save(urs);
		}
	}

	/**
	 * 用户组，用户映射
	 * 
	 * @param groupId
	 * @param userId
	 */
	public void saveUserGroupMap(Long groupId, Long userId) {
		UserGroupMap record = new UserGroupMap();
		record.setUserGroupId(groupId);
		record.setUserId(userId);

		UserGroupMapBO bo = userGroupMapDao.findByUserGroupIdAndUserId(groupId, userId);
		if (bo == null)
			userGroupMapDao.save(record);
	}

	public List<UserGroupBO> findAllUserGroup() {
		return userGroupDao.findAllValid();
	}

	public List<UserGroupBO> selectGroupPageByVO(UserGroupVO vo, MyPage<UserGroupBO> page) {
		return userGroupDao.selectGroupPageByVO(vo, page);
	}

	public UserGroupBO findById(java.lang.Long id) {
		return userGroupDao.findOne(id);
	}

	public UserGroupBO findUserGroupByName(String groupName) {
		return userGroupDao.findUserGroupByName(groupName);
	}

	public void deleteUserGroup(String... ids) {
		for (String id : ids) {
			List<UserGroupMapBO> list = userGroupMapDao.findByUserGroupId(CommUtil.null2Long(id));
			if (CollectionUtils.isNotEmpty(list)) {
				throw new RuntimeException("角色正在使用不能删除！");
			}
			userGroupDao.delete(CommUtil.null2Long(id));
		}
	}

	public UserGroupBO findUserGroupByUid(Long uid) {
		List<UserGroupMapBO> listUserGroupMap = userGroupMapDao.findByUserId(uid);
		if (CollectionUtils.isNotEmpty(listUserGroupMap)) {
			return userGroupDao.findOne(listUserGroupMap.get(0).getUserGroupId());
		}
		return null;
	}
}
