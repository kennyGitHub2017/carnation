package com.sinco.carnation.user.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.sys.bo.RoleBO;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.dao.RoleDao;
import com.sinco.carnation.sys.dao.UserAccountDao;
import com.sinco.carnation.sys.model.Role;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.security.PasswordUtils;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.sys.vo.ExpertsVO;
import com.sinco.carnation.user.bo.UserExpertsBO;
import com.sinco.carnation.user.dao.UserExpertsDao;
import com.sinco.carnation.user.model.UserExperts;
import com.sinco.carnation.user.vo.UserExpertsVO;
import com.sinco.dal.common.MyPage;

@Service
@Transactional(readOnly = true)
public class ExpertsService {

	@Autowired
	private UserExpertsDao expertsDao;

	@Autowired
	private UserAccountDao accountDao;

	@Autowired
	private UserService userService;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private UserAccountService accountService;

	public final static String ROLE_EXPERT = "ROLE_EXPERT";

	public void selectExpertsListByVO(UserExpertsVO vo, MyPage<UserExpertsBO> page) {
		List<UserExpertsBO> list = expertsDao.selectExpertsListByVO(vo, page);
		page.setContent(list);
	}

	public UserExpertsBO selectExpertsDetail(Long uid, Long userId) {
		UserExpertsBO detail = expertsDao.selectExpertsDetail(uid);
		if (null != detail) {
			if (StringUtils.isNotBlank(detail.getFavorInfo())
					&& detail.getFavorInfo().indexOf(userId.toString()) != -1) {
				detail.setIsFavor(true);
			} else {
				detail.setIsFavor(false);
			}

			if (StringUtils.isNotBlank(detail.getPraiseInfo())
					&& detail.getPraiseInfo().indexOf(userId.toString()) != -1) {
				detail.setIsPraise(true);
			} else {
				detail.setIsPraise(false);
			}
		}
		return detail;
	}

	/**
	 * 专家点赞
	 * 
	 * @return
	 */
	@SuppressWarnings({"unchecked", "unused"})
	@Transactional(readOnly = false)
	public int usersPraise(String praiseInfo, Long expertsId) {
		UserExpertsBO detail = expertsDao.selectExpertsDetail(expertsId);
		if (detail != null && StringUtils.isNotBlank(detail.getPraiseInfo())) {

			String[] idsArr = detail.getPraiseInfo().split(",");
			List<String> idsList = CollectionUtils.arrayToList(idsArr);
			if (CollectionUtils.arrayToList(idsArr).contains(String.valueOf(praiseInfo))) {
				// 说明已经赞过了
				return -1;
			}
		}
		return expertsDao.updateExpertsPraises(expertsId, praiseInfo);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public int usersUnPraise(String praiseInfo, Long expertsId) {
		UserExpertsBO detail = expertsDao.selectExpertsDetail(expertsId);
		if (detail != null && StringUtils.isNotBlank(detail.getPraiseInfo())) {
			String[] idsArr = detail.getPraiseInfo().split(",");
			List<String> idsList = new ArrayList<String>();
			idsList.addAll(CollectionUtils.arrayToList(idsArr));
			if (!CollectionUtils.arrayToList(idsArr).contains(String.valueOf(praiseInfo))) {
				// 说明没赞过了
				return -1;
			}
			idsList.remove(String.valueOf(praiseInfo));
			String praise = "";
			if (idsList.size() > 0) {
				praise = StringUtils.join(idsList, ",") + ",";
			}
			return expertsDao.updateExpertsUnPraises(expertsId, praise);
		}
		return -1;

	}

	public void queryExpertsList(ExpertsVO vo, MyPage<UserExpertsBO> page) {
		page.setContent(expertsDao.queryExpertsList(vo, page));
	}

	/**
	 * 添加/更新专家
	 * 
	 * @param uid
	 * @param name
	 * @param title
	 * @param email
	 * @param sex
	 * @param mobile
	 * @param description
	 * @return
	 */
	@Transactional(readOnly = false)
	public void createExperts(String requestIp, ExpertsVO vo) {

		if (null != vo.getUid()) {
			// 如果uid不为空，更新专家信息
			updateExperts(vo, vo.getUid());
		} else {
			UserAccountBO account = accountService
					.findByMobile(vo.getLoginName(), UserContant.ACCOUNT_TYPE_2);
			if (account != null) {
				// 如果account不为空，只需要添加专家信息
				reateExpPub(account.getUid(), vo);
			} else {

				// account为空，先添加account,再添加专家信息
				Long userId = userService.createUser(UserContant.USER_TYPE_3, UserContant.ACCOUNT_TYPE_2,
						vo.getLoginName(), vo.getPassword(), requestIp);
				if (userId > 0) {
					reateExpPub(userId, vo);

					// 添加专家权限,管理员首页权限
					List<RoleBO> roles = this.roleDao.findByRoleCode(ROLE_EXPERT);
					List<Long> rids = new ArrayList<Long>();

					for (Role role : roles) {
						rids.add(role.getId());
					}
					userService.saveUserRole(userId, UserContant.ROLE_TYPE_ADMIN,
							rids.toArray(new Long[rids.size()]));

				}
			}
		}
	}

	public Long reateExpPub(Long uid, ExpertsVO vo) {
		UserExperts experts = new UserExperts();
		experts.setUid(uid);
		experts.setName(vo.getName());
		experts.setTitle(vo.getTitle());
		experts.setEmail(vo.getEmail());
		experts.setSex(vo.getSex());
		experts.setMobile(vo.getMobile());
		experts.setDescription(vo.getDescription());
		experts.setCreateTime(new Date());
		experts.setStatus("0");
		experts.setIsDeleted(false);
		experts.setHeadImgPath(vo.getHeadImgPath());
		experts.setExpertType(vo.getExpertType());
		experts.setPraiseInfo("");
		experts.setFavorInfo("");
		experts.setPraiseCount(0);
		experts.setFavorCount(0);
		experts.setExpertIndex(0);
		expertsDao.insert(experts);
		return experts.getUid();
	}

	public UserExpertsBO selectById(Long uid) {
		return expertsDao.selectById(uid);
	}

	/**
	 * 修改专家信息
	 * 
	 * @param vo
	 * @param uid
	 */
	@Transactional(readOnly = false)
	public void updateExperts(ExpertsVO vo, Long uid) {

		UserAccount account = accountDao.queryAccountByUid(vo.getUid());
		if (null != account) {
			account.setLoginName(vo.getLoginName());
			if (org.apache.commons.lang.StringUtils.isNotBlank(vo.getPassword())) {
				account.setPassword(PasswordUtils.entryptPassword(vo.getPassword()));
			}
			account.setUpdateBy(uid.toString());
			account.setUpdateTime(new Date());
			accountDao.updateById(account);

			UserExperts exp = new UserExperts();
			BeanUtils.copyProperties(vo, exp);
			exp.setUid(uid);
			exp.setUpdateTime(new Date());
			expertsDao.update(exp);
		}
		// UserAccount account = new UserAccount();
	}

	@Transactional(readOnly = false)
	public void delExpert(String ids) {
		if (StringUtils.isNotBlank(ids)) {
			String[] uids = ids.split(",");
			Long[] longIds = new Long[uids.length];
			for (int i = 0; i < uids.length; i++) {
				longIds[i] = CommUtil.null2Long(uids[i]);
			}
			expertsDao.delectExpertByIds(longIds);
		}
	}

	@Transactional(readOnly = true)
	public List<UserExpertsBO> findList(Integer expertType) {
		if (expertType != null) {
			return expertsDao.selectExpertsList(expertType);
		}
		return null;
	}

	@Transactional(readOnly = false)
	public void batchUpdate(List<UserExperts> list) {
		for (UserExperts ue : list) {
			expertsDao.update(ue);
		}
	}
}
