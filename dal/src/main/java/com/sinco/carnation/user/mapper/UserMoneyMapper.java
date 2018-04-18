package com.sinco.carnation.user.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.user.bo.UserMoneyBO;
import com.sinco.carnation.user.model.UserMoney;
import com.sinco.carnation.user.model.UserMoneyExample;

public interface UserMoneyMapper {

	BigDecimal selectSumBalance();

	int subtractMoney(@Param("uid") Long uid, @Param("money") BigDecimal money);

	int subtractB2cMoney(@Param("uid") Long uid, @Param("money") BigDecimal money);

	int subtractO2oMoney(@Param("uid") Long uid, @Param("money") BigDecimal money);

	int subtractYysMoney(@Param("uid") Long uid, @Param("money") BigDecimal money);

	int addB2cMoney(@Param("uid") Long uid, @Param("money") double money);

	int addO2oMoney(@Param("uid") Long uid, @Param("money") double money);

	int addYysMoney(@Param("uid") Long uid, @Param("money") double money);

	int addMoney(@Param("uid") Long uid, @Param("money") double money);

	int countByExample(UserMoneyExample example);

	int deleteByExample(UserMoneyExample example);

	int deleteByPrimaryKey(Long uid);

	int insert(UserMoney record);

	int insertSelective(UserMoney record);

	List<UserMoneyBO> selectByExample(UserMoneyExample example);

	UserMoneyBO selectByPrimaryKey(Long uid);

	int updateByExampleSelective(@Param("record") UserMoney record, @Param("example") UserMoneyExample example);

	int updateByExample(@Param("record") UserMoney record, @Param("example") UserMoneyExample example);

	int updateByPrimaryKeySelective(UserMoney record);

	int updateByPrimaryKey(UserMoney record);

	int addRecordMoney(@Param("uid") Long uid, @Param("money") double money);

	int subtractRecordMoney(@Param("uid") Long uid, @Param("money") BigDecimal money);
}