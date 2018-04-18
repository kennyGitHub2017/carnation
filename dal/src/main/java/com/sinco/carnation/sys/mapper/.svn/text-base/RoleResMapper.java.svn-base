package com.sinco.carnation.sys.mapper;

import com.sinco.carnation.sys.model.RoleRes;
import com.sinco.carnation.sys.model.RoleResExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleResMapper {

	List<RoleRes> findByResType(String type);

	int countByExample(RoleResExample example);

	int deleteByExample(RoleResExample example);

	int deleteByPrimaryKey(@Param("resId") Long resId, @Param("roleId") Long roleId);

	int insert(RoleRes record);

	int insertSelective(RoleRes record);

	List<RoleRes> selectByExample(RoleResExample example);

	int updateByExampleSelective(@Param("record") RoleRes record, @Param("example") RoleResExample example);

	int updateByExample(@Param("record") RoleRes record, @Param("example") RoleResExample example);
}