package com.sinco.carnation.sys.mapper;

import com.sinco.carnation.sys.bo.UserPhoneAreaBO;
import com.sinco.carnation.sys.model.UserPhoneArea;
import com.sinco.carnation.sys.model.UserPhoneAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPhoneAreaMapper {
	int countByExample(UserPhoneAreaExample example);

	int deleteByExample(UserPhoneAreaExample example);

	int deleteByPrimaryKey(Long id);

	int insert(UserPhoneArea record);

	int insertSelective(UserPhoneArea record);

	List<UserPhoneAreaBO> selectByExample(UserPhoneAreaExample example);

	UserPhoneAreaBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") UserPhoneArea record,
			@Param("example") UserPhoneAreaExample example);

	int updateByExample(@Param("record") UserPhoneArea record, @Param("example") UserPhoneAreaExample example);

	int updateByPrimaryKeySelective(UserPhoneArea record);

	int updateByPrimaryKey(UserPhoneArea record);
}