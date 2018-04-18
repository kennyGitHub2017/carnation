package com.sinco.carnation.user.mapper;

import com.sinco.carnation.user.bo.UserShareBO;
import com.sinco.carnation.user.model.UserShare;
import com.sinco.carnation.user.model.UserShareExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserShareMapper {
	int countByExample(UserShareExample example);

	int deleteByExample(UserShareExample example);

	int deleteByPrimaryKey(Long id);

	int insert(UserShare record);

	int insertSelective(UserShare record);

	List<UserShareBO> selectByExampleWithBLOBs(UserShareExample example);

	List<UserShareBO> selectByExample(UserShareExample example);

	UserShareBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") UserShare record, @Param("example") UserShareExample example);

	int updateByExampleWithBLOBs(@Param("record") UserShare record, @Param("example") UserShareExample example);

	int updateByExample(@Param("record") UserShare record, @Param("example") UserShareExample example);

	int updateByPrimaryKeySelective(UserShare record);

	int updateByPrimaryKeyWithBLOBs(UserShare record);

	int updateByPrimaryKey(UserShare record);
}