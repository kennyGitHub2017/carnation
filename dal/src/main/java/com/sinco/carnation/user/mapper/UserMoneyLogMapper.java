package com.sinco.carnation.user.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.sinco.carnation.user.bo.UserMoneyLogBO;
import com.sinco.carnation.user.model.UserMoneyLog;
import com.sinco.carnation.user.model.UserMoneyLogExample;
import com.sinco.dal.common.MyPage;

public interface UserMoneyLogMapper {
	int countByExample(UserMoneyLogExample example);

	int deleteByExample(UserMoneyLogExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(UserMoneyLog record);

	int insertSelective(UserMoneyLog record);

	List<UserMoneyLogBO> selectByExample(UserMoneyLogExample example);

	UserMoneyLogBO selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") UserMoneyLog record,
			@Param("example") UserMoneyLogExample example);

	int updateByExample(@Param("record") UserMoneyLog record, @Param("example") UserMoneyLogExample example);

	int updateByPrimaryKeySelective(UserMoneyLog record);

	int updateByPrimaryKey(UserMoneyLog record);

	List<UserMoneyLogBO> findByUid(@Param("uid") Long uid, MyPage<UserMoneyLogBO> page);
}