package com.sinco.carnation.user.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.user.bo.UserMoneyBO;
import com.sinco.carnation.user.mapper.UserMoneyMapper;
import com.sinco.carnation.user.model.UserMoney;
import com.sinco.carnation.user.model.UserMoneyExample;

@Repository
public class UserMoneyDao {

	private static final Logger logger = LoggerFactory.getLogger(UserMoneyDao.class);

	@Autowired
	private UserMoneyMapper mapper;

	/**
	 * 根据用户id count
	 * 
	 * @param uid
	 * @param gtEqAmount
	 * @return
	 */
	public int countByUid(Long uid, BigDecimal gtEqAmount) {
		UserMoneyExample example = new UserMoneyExample();
		example.createCriteria().andAvailableBalanceGreaterThanOrEqualTo(gtEqAmount).andUidEqualTo(uid);
		return mapper.countByExample(example);
	}

	public int countByUidV2(Long uid, BigDecimal gtEqAmount, String source) {

		if (StringUtils.isBlank(source)) {
			source = UserContant.ACCOUNT_TYPE_RESOURCE;
		}
		UserMoneyExample example = new UserMoneyExample();
		switch (source) {
			case UserContant.ACCOUNT_TYPE_RESOURCE:
				example.createCriteria().andAvailableBalanceGreaterThanOrEqualTo(gtEqAmount)
						.andUidEqualTo(uid);
				return mapper.countByExample(example);
			case UserContant.ACCOUNT_TYPE_YY:
				example.createCriteria().andAvailableBalanceGreaterThanOrEqualTo(gtEqAmount)
						.andUidEqualTo(uid);
				return mapper.countByExample(example);
			case UserContant.ACCOUNT_TYPE_SUPPLIER:
				example.createCriteria().andB2cBalanceGreaterThanOrEqualTo(gtEqAmount).andUidEqualTo(uid);
				return mapper.countByExample(example);
			case UserContant.ACCOUNT_TYPE_MERCHANT:
				example.createCriteria().andO2oBalanceGreaterThanOrEqualTo(gtEqAmount).andUidEqualTo(uid);
				return mapper.countByExample(example);
			default:
				example.createCriteria().andYysBalanceGreaterThanOrEqualTo(gtEqAmount).andUidEqualTo(uid);
				return mapper.countByExample(example);
		}
	}

	public BigDecimal selectSumBalance() {
		return mapper.selectSumBalance();
	}

	public int subtractMoney(Long uid, BigDecimal money) {
		if (mapper.subtractMoney(uid, money) > 0) {
			return 1;
		}
		logger.error("subtractMoney is unsuccess where uid = " + uid);
		return 0;
	}

	/** resource 会员端、 merchant 商户端、supplier 供应商端 、CN CN账户、YY YY账户 **/
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int subtractMoneyV2(Long uid, BigDecimal money, String source) {
		if (StringUtils.isBlank(source)) {
			source = UserContant.ACCOUNT_TYPE_RESOURCE;
		}	
		switch (source) {
			case UserContant.ACCOUNT_TYPE_RESOURCE:// 个人
				if (mapper.subtractMoney(uid, money) > 0) {
					return 1;
				}
				break;

			case UserContant.ACCOUNT_TYPE_SUPPLIER:// 供应商
				if (mapper.subtractB2cMoney(uid, money) > 0) {
					return 1;
				}
				break;

			case UserContant.ACCOUNT_TYPE_MERCHANT:// 商户
				if (mapper.subtractO2oMoney(uid, money) > 0) {
					return 1;
				}
				break;

			case UserContant.ACCOUNT_TYPE_YY:// YY运营商
				if (mapper.subtractMoney(uid, money) > 0) {
					return 1;
				}
				break;

			default:// CN运营商
				if (mapper.subtractYysMoney(uid, money) > 0) {
					return 1;
				}
				break;
		}
		logger.error("subtractMoney is unsuccess where uid = " + uid + " ,source =" + source);
		return 0;
	}

	public int addMoney(Long uid, double money) {
		if (money < 0) {
			logger.error("can not add negative money where uid = " + uid);
		}
		if (mapper.addMoney(uid, money) > 0) {
			return 1;
		}
		logger.error("addMoney is unsuccess where uid = " + uid);
		return 0;
	}

	public int addMoneyV2(Long uid, double money, String source) {
		if (money < 0) {
			logger.error("add negative money where uid = " + uid);
		}
		if (StringUtils.isBlank(source)) {
			source = UserContant.ACCOUNT_TYPE_RESOURCE;
		}
		switch (source) {
			case UserContant.ACCOUNT_TYPE_RESOURCE:// 个人
				if (mapper.addMoney(uid, money) > 0) {
					return 1;
				}
				break;

			case UserContant.ACCOUNT_TYPE_SUPPLIER:// 供应商
				if (mapper.addB2cMoney(uid, money) > 0) {
					return 1;
				}
				break;

			case UserContant.ACCOUNT_TYPE_MERCHANT:// 商户
				if (mapper.addO2oMoney(uid, money) > 0) {
					return 1;
				}
				break;

			case UserContant.ACCOUNT_TYPE_YY:// YY运营商
				if (mapper.addMoney(uid, money) > 0) {
					return 1;
				}
				break;

			default:// CN运营商
				if (mapper.addYysMoney(uid, money) > 0) {
					return 1;
				}
				break;
		}
		logger.error("addMoney is unsuccess where uid = " + uid);
		return 0;
	}

	public int subtractRecordMoney(Long uid, BigDecimal money) {
		if (mapper.subtractRecordMoney(uid, money) > 0) {
			return 1;
		}
		logger.error("subtractMoney is unsuccess where uid = " + uid);
		return 0;
	}

	public int addRecordMoney(Long uid, double money) {
		if (money < 0) {
			logger.error("can not add negative record money where uid = " + uid);
		}
		if (mapper.addRecordMoney(uid, money) > 0) {
			return 1;
		}
		logger.error("addRecordMoney is unsuccess where uid = " + uid);
		return 0;
	}

	/** generate code begin **/
	public List<UserMoneyBO> findAll() {
		UserMoneyExample example = new UserMoneyExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		UserMoneyExample example = new UserMoneyExample();
		return mapper.countByExample(example);
	}

	public List<UserMoney> create(Iterable<UserMoney> entities) {
		List<UserMoney> list = new ArrayList<UserMoney>();
		for (UserMoney UserMoney : entities) {
			list.add(create(UserMoney));
		}
		return list;
	}

	public UserMoney create(UserMoney record) {
		mapper.insertSelective(record);
		return record;
	}

	public void update(UserMoney record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public UserMoneyBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public UserMoneyBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		UserMoneyExample example = new UserMoneyExample();
		example.createCriteria().andUidEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<UserMoneyBO> findAll(Iterable<Long> ids) {
		UserMoneyExample example = new UserMoneyExample();
		example.createCriteria().andUidIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(UserMoney entity) {
		mapper.deleteByPrimaryKey(entity.getUid());
	}

	public void delete(Iterable<UserMoney> entities) {
		List<Long> ids = Lists.newArrayList();
		for (UserMoney entity : entities) {
			ids.add(entity.getUid());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		UserMoneyExample example = new UserMoneyExample();
		example.createCriteria().andUidIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		UserMoneyExample example = new UserMoneyExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
