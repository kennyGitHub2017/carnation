package com.sinco.carnation.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;

import com.sinco.carnation.sys.bo.RoleBO;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.dao.RoleDao;
import com.sinco.carnation.sys.dao.UserAccountDao;
import com.sinco.carnation.sys.dao.UserDao;
import com.sinco.carnation.sys.model.Role;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.service.UserGroupService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.bo.ManagerBO;
import com.sinco.carnation.user.bo.UserGroupBO;
import com.sinco.carnation.user.dao.ManagerDao;
import com.sinco.carnation.user.dao.UserExpertsDao;
import com.sinco.carnation.user.dao.UserGroupMapDao;
import com.sinco.carnation.user.model.Manager;
import com.sinco.carnation.user.model.UserExperts;
import com.sinco.carnation.user.model.UserGroupMap;
import com.sinco.carnation.user.vo.ManagerVO;
import com.sinco.dal.common.MyPage;

@Service
@Transactional(readOnly = true)
public class ManagerService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserService userService;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private UserAccountDao userAccountDao;

	@Autowired
	private ManagerDao managerDao;

	@Autowired
	private UserGroupMapDao userGroupMapDao;

	@Autowired
	private UserExpertsDao userExpertsDao;

	public ManagerBO getObjById(Long id) {
		return managerDao.findOne(id);
	}

	/**
	 * 删除管理员
	 * 
	 * @param currentUserId
	 * @param ids
	 */
	@Transactional(readOnly = false)
	public void deleteManager(String currentUserId, String... ids) {
		for (String id : ids) {
			if (StringUtils.isNotBlank(id)) {
				Long uid = Long.parseLong(id);
				Manager manager = this.managerDao.findOne(uid);

				if (manager != null && !manager.getName().equals("admin")) {
					// 删除管理员操作日志

					// 管理员伪删除,取消所有管理员权限
					manager.setCurrentUserId(currentUserId);
					manager.setIsDeleted(true);
					this.managerDao.update(manager);

					User user = new User();
					user.setIsDeleted(true);
					user.setId(uid);
					user.setCurrentUserId(currentUserId);
					this.userDao.updateById(user);
				}
			}
		}
	}

	@Autowired
	private UserGroupService userGroupService;

	/**
	 * 初始化后台权限
	 * 
	 * @param mappings
	 */
	@Transactional(readOnly = false)
	public void initManagerUser(List<SecurityMapping> mappings) {

		// 初始化资源
		userService.initRole(mappings);

		UserBO user = this.userService.findByLoginName("admin");
		List<RoleBO> roles = this.roleDao.findAll();
		if (user == null) {
			Manager manager = new Manager();
			manager.setIsDeleted(false);
			manager.setName("超级管理员");

			Long uid = save(manager, "admin", "123456", null, "0.0.0.0", null);
			user = new UserBO();
			user.setId(uid);

		}

		List<Long> rids = new ArrayList<Long>();

		for (Role role : roles) {
			if (role.getType().equals(UserContant.ROLE_TYPE_ADMIN)) {
				rids.add(role.getId());
			}
		}

		// 获取 用户组 系统默认的
		UserGroupBO userGroupBO = userGroupService.getUserGroupIsSystem();
		userGroupService.saveUserGroupRole(userGroupBO.getId(), UserContant.ROLE_TYPE_ADMIN,
				rids.toArray(new Long[rids.size()]));

		// 保存用户组，用户映射
		userGroupService.saveUserGroupMap(userGroupBO.getId(), user.getId());

		// 初始化专家权限＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
		// List<UserExperts> listExperts = userExpertsDao.findAll();
		// if (CollectionUtils.isNotEmpty(listExperts))
		// {
		// //添加专家权限,管理员首页权限 expert_knowledge_admin
		// List<RoleBO> rolesE =
		// this.roleDao.findByRoleCode("ROLE_EXPERT","ROLE_EXPERT_KNOWLEDGE_ADMIN");
		// List<RoleBO> rolesC =
		// this.roleDao.findByRoleCode("ROLE_CHECK_REPORT_ADMIN");
		// rolesE.addAll(rolesC);
		// List<Long> ridsE=new ArrayList<Long>();
		//
		// for (Role role : rolesE) {
		// ridsE.add(role.getId());
		// }
		//
		// for (UserExperts userExperts : listExperts)
		// {
		// userService.saveUserRole(userExperts.getUid(),UserContant.ROLE_TYPE_ADMIN,ridsE.toArray(new
		// Long[ridsE.size()]));
		// }
		// }
		// 初始化专家权限＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
	}

	/**
	 * 
	 * @param manager
	 * @param loginName
	 * @param password
	 * @param requestIp
	 * @return
	 */
	@Transactional(readOnly = false)
	public Long save(Manager manager, String loginName, String password, String newPassword,
			String requestIp, Long userGroupId) {

		if (manager.getUid() == null) {
			Long uid = userService.createUser(UserContant.USER_TYPE_9, UserContant.ACCOUNT_TYPE_9, loginName,
					password, requestIp);
			manager.setUid(uid);
		} else {
			if (StringUtils.isNotBlank(newPassword)) {
				userService.updatePassword(manager.getUid(), newPassword);
			}
		}

		manager.setCurrentUserId(String.valueOf(manager.getUid()));
		managerDao.save(manager);

		if (userGroupId != null && userGroupId > 0) {
			UserGroupMap userGroupMap = new UserGroupMap();
			userGroupMap.setUserGroupId(userGroupId);
			userGroupMap.setUserId(manager.getUid());

			this.userGroupMapDao.deleteByUserId(manager.getUid());
			this.userGroupMapDao.save(userGroupMap);
		}
		return manager.getUid();
	}

	public void selectManagePageByVO(ManagerVO vo, MyPage<ManagerBO> page) {
		List<ManagerBO> listManager = managerDao.selectManagePageByVO(vo, page);
		page.setContent(listManager);
	}

	public List<ManagerBO> selectManageByVO(ManagerVO vo) {
		return managerDao.selectManageByVO(vo);
	}

	public void initManagerUser1() {
		// 初始化专家权限＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
		List<UserExperts> listExperts = userExpertsDao.findAll();
		if (CollectionUtils.isNotEmpty(listExperts)) {
			for (UserExperts userExperts : listExperts) {
				// 添加专家权限,管理员首页权限
				List<RoleBO> rolesE = this.roleDao.findByRoleCode("ROLE_EXPERT");
				List<RoleBO> rolesC = this.roleDao.findByRoleCode("ROLE_CHECK_REPORT_ADMIN");
				rolesE.addAll(rolesC);
				List<Long> ridsE = new ArrayList<Long>();

				for (Role role : rolesE) {
					ridsE.add(role.getId());
				}
				// userService.saveUserRole(userExperts.getUid(),
				// UserContant.ROLE_TYPE_ADMIN,
				// ridsE.toArray(new Long[ridsE.size()]));
				System.out.println("```````````````` " + userExperts.getUid());
				System.out.println("################ " + ridsE.toArray(new Long[ridsE.size()]));
			}
		}
		// 初始化专家权限＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
	}

	public List<HashMap<String, Object>> getResultBySql(String sql) {
		return managerDao.getResultBySql(sql);
	}
}
