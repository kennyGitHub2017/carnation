package com.sinco.carnation.sys.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.mapper.UserAccountMapper;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.model.UserAccountExample;
import com.sinco.carnation.user.vo.UpdateWxVO;

@Repository
public class UserAccountDao {

	@Autowired
	private UserAccountMapper mapper;

	public int updateRecordBalance() {
		return mapper.updateRecordBalance();
	}

	public UserAccount save(UserAccount record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	/**
	 * 得到最后登入的账户
	 * 
	 * @param uid
	 * @return
	 */
	public UserAccountBO findLastLogin(Long uid) {
		return mapper.findLastLogin(uid);
	}

	public int updateByUid(Long uid, UserAccount account) {
		UserAccountExample example = new UserAccountExample();
		example.createCriteria().andUidEqualTo(uid);
		return mapper.updateByExampleSelective(account, example);
	}

	public int updateByUid(UserAccount account) {
		return this.mapper.updatePassWordByUID(account);
	}

	public int updatePwdByID(UserAccount account) {
		return this.mapper.updatePassWordByID(account);
	}

	public int updatePassWordAndUIDByID(UserAccount account) {
		return this.mapper.updatePassWordAndUIDByID(account);
	}

	public int updateByLoginName(String loginName, UserAccount account) {
		UserAccountExample example = new UserAccountExample();
		example.createCriteria().andLoginNameEqualTo(loginName);
		return mapper.updateByExampleSelective(account, example);
	}

	public List<UserAccount> findCustomerByLoginNames(List<String> loginNames) {
		UserAccountExample example = new UserAccountExample();
		example.createCriteria().andLoginNameIn(loginNames).andIsDeletedEqualTo(false);
		return mapper.selectByExample(example);
	}

	public int deleteById(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	public int insert(UserAccount record) {
		if (null != record.getAccountType() && UserContant.ACCOUNT_TYPE_2.equals(record.getAccountType())) {
			record.setThirdNickName(record.getLoginName());
		}
		return mapper.insert(record);
	}

	public int insertSelective(UserAccount record) {
		return mapper.insertSelective(record);
	}

	public UserAccount findById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public int updateById(UserAccount record) {
		return mapper.updateByPrimaryKey(record);
	}

	public UserAccountBO queryByLoginName(String loginName) {
		return queryByLoginName(loginName, null);
	}

	public UserAccountBO queryByLoginName(String loginName, Long uid) {
		UserAccountExample example = new UserAccountExample();
		UserAccountExample.Criteria c = example.createCriteria();
		c.andLoginNameEqualTo(loginName);
		if (uid != null) {
			c.andUidNotEqualTo(uid);
		}
		List<UserAccountBO> list = mapper.selectByExampleBO(example);
		return list.size() > 0 ? list.get(0) : null;
	}

	public UserAccountBO findByLoginName(String loginName) {
		return findByLoginName(loginName, null);
	}

	public UserAccountBO findByLoginName(String loginName, Long uid) {
		UserAccountExample example = new UserAccountExample();
		UserAccountExample.Criteria c = example.createCriteria();
		c.andLoginNameEqualTo(loginName).andIsDeletedEqualTo(false);
		if (uid != null) {
			c.andUidNotEqualTo(uid);
		}
		List<UserAccountBO> list = mapper.selectByExampleBO(example);
		return list.size() > 0 ? list.get(0) : null;
	}

	/**
	 * by young 用于需求修改为冻结账户不可登录并提示
	 * 
	 * @param loginName
	 * @return
	 */
	public UserAccountBO fetchByLoginName(String loginName) {
		UserAccountExample example = new UserAccountExample();
		UserAccountExample.Criteria c = example.createCriteria();
		c.andLoginNameEqualTo(loginName);
		c.andIsDeletedEqualTo(false);
		List<UserAccountBO> list = mapper.selectByExampleBO(example);
		return list.size() > 0 ? list.get(0) : null;
	}

	public UserAccountBO findByMobile(String mobile, String accountType) {
		UserAccountExample example = new UserAccountExample();
		example.createCriteria().andLoginNameEqualTo(mobile).andAccountTypeEqualTo(accountType)
				.andIsDeletedEqualTo(false);
		List<UserAccountBO> list = mapper.selectByExampleBO(example);
		return list.isEmpty() ? null : list.get(0);
	}

	public UserAccount findUserAccount(Long uid, String accountType) {
		return mapper.findUserAccount(uid, Integer.valueOf(accountType));
	}

	public UserAccount findUserAccount(String loginName, String accountType) {
		return mapper.findUserAccount2(loginName, Integer.valueOf(accountType));
	}

	public int updateChangePassword(UserAccount account) {
		UserAccountExample example = new UserAccountExample();
		example.createCriteria().andUidEqualTo(account.getUid());
		return mapper.updateByExampleSelective(account, example);
	}

	public UserAccount findByUid(Long userId, String accountType) {
		UserAccountExample example = new UserAccountExample();
		example.createCriteria().andUidEqualTo(userId).andAccountTypeEqualTo(accountType)
				.andIsDeletedEqualTo(false);
		List<UserAccount> list = mapper.selectByExample(example);
		return list.isEmpty() ? null : list.get(0);
	}

	public int passwordUpdate(UserAccount account) {
		UserAccountExample example = new UserAccountExample();
		example.createCriteria().andUidEqualTo(account.getUid());
		return mapper.updateByExampleSelective(account, example);
	}

	public int delExpert(Long uid) {
		UserAccountExample example = new UserAccountExample();
		example.createCriteria().andUidEqualTo(uid);
		return mapper.deleteByExample(example);
	}

	public UserAccount queryAccountByUid(Long uid) {
		UserAccountExample example = new UserAccountExample();
		example.createCriteria().andUidEqualTo(uid);
		List<UserAccount> list = mapper.selectByExample(example);
		return list.isEmpty() ? null : list.get(0);
	}

	public List<UserAccountBO> findUserAccountByUid(Long uid) {
		return mapper.findUserAccountByUid(uid);
	}

	public UserAccountBO queryAccountByOpenId(String openId, Integer type) {
		return mapper.queryAccountByOpenId(openId, type);
	}

	public UserAccountBO queryAccountByOpenId2(String openId, Integer type) {
		return mapper.queryAccountByOpenId2(openId, type);
	}

	public UserAccountBO queryAccountByUnionid(String unionid, Integer type) {
		return mapper.queryAccountByUnionid(unionid, type);
	}

	// public int freezeUser(Long id,boolean freezed){
	// UserAccount record = new UserAccount();
	// record.setIsDeleted(freezed);
	// UserAccountExample example=new UserAccountExample();
	// example.createCriteria().andIdEqualTo(id);
	// return mapper.updateByExampleSelective(record, example);
	// }
	public void update(UserAccount record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public List<UserAccount> findUserAccountList() {
		UserAccountExample example = new UserAccountExample();
		example.createCriteria().andAccountTypeEqualTo("2").andIsDeletedEqualTo(false);
		List<UserAccount> list = mapper.selectByExample(example);
		return list;
	}

	public boolean deleteAccount(Long uid, String type) {
		UserAccount bo = findByUid(uid, type);
		if (bo != null) {
			UserAccount record = new UserAccount();
			record.setIsDeleted(true);
			record.setId(bo.getId());
			return mapper.updateByPrimaryKeySelective(record) > 0;
		}
		return false;
	}

	public UserAccountBO findAccountByVo(UserAccountBO vo) {
		return this.mapper.findAccountByVo(vo);
	}

	public String queryAccountBindingWx(Long uid) {
		UserAccountBO userAccountBO = new UserAccountBO();
		userAccountBO.setUid(uid);
		userAccountBO.setAccountType("4");
		UserAccountBO userAccountBOResult = mapper.findAccountByVo(userAccountBO);
		if (userAccountBOResult != null) {
			return userAccountBOResult.getLoginName();
		} else {
			return "";
		}
	}

	public int updatePassWordAndUIDByOuid(UserAccount record, Long ouid) {
		return this.mapper.updatePassWordAndUIDByOuid(record, ouid);
	}

	public void updateWx(UpdateWxVO accountup) {
		this.mapper.updateWx(accountup);
	}

	public UserAccountBO queryByUserAccount(UserAccount obj) {
		return this.mapper.queryByUserAccount(obj);
	}

	public int updateUserAccountForIsDeleted(Long uid, Long currentUserID, boolean isDeleted) {
		return this.mapper.updateUserAccountForIsDeleted(uid, isDeleted, currentUserID);
	}

	public int deleteByUID(Long uid) {
		return this.mapper.deleteByUID(uid);
	}

	public UserAccountBO selectAcocountByCnUserAlias(String loginName) {
		return this.mapper.selectAcocountByCnUserAlias(loginName);
	}

	public UserAccountBO selectAcocountOperatorByCnUserAlias(String loginName) {
		return this.mapper.selectAcocountOperatorByCnUserAlias(loginName);
	}

	public List<UserAccount> findByUid(Long userId) {
		UserAccountExample example = new UserAccountExample();
		example.createCriteria().andUidEqualTo(userId).andIsDeletedEqualTo(false);
		List<UserAccount> list = mapper.selectByExample(example);
		return list;
	}

	public UserAccount findByLoginNameAndUid(String loginName, Long uid) {
		UserAccountExample example = new UserAccountExample();
		example.createCriteria().andUidEqualTo(uid).andLoginNameEqualTo(loginName).andIsDeletedEqualTo(false);
		List<UserAccount> list = mapper.selectByExample(example);
		return list.isEmpty() ? null : list.get(0);
	}
	
	public List<UserAccount> listCNUser(){
		return mapper.listCNUser();
	}

	public List<UserAccount> findUserAccountByUids(List<Long> ids, String accountType) {
		UserAccountExample example = new UserAccountExample();
		if(accountType == null){
			example.createCriteria().andUidIn(ids);
		}else{
			example.createCriteria().andUidIn(ids).andAccountTypeEqualTo(accountType);
		}
		return mapper.selectByExample(example);
	}
}
