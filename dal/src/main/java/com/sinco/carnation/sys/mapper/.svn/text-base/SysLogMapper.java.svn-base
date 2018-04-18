package com.sinco.carnation.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.sys.bo.SysLogBO;
import com.sinco.carnation.sys.model.SysLog;
import com.sinco.carnation.sys.model.SysLogExample;
import com.sinco.dal.common.MyPage;

public interface SysLogMapper {

	List<SysLogBO> findByPage(@Param("page") MyPage<SysLogBO> page);

	int countByExample(SysLogExample example);

	int deleteByExample(SysLogExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SysLog record);

	int insertSelective(SysLog record);

	List<SysLog> selectByExampleWithBLOBs(SysLogExample example);

	List<SysLog> selectByExample(SysLogExample example);

	SysLog selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SysLog record, @Param("example") SysLogExample example);

	int updateByExampleWithBLOBs(@Param("record") SysLog record, @Param("example") SysLogExample example);

	int updateByExample(@Param("record") SysLog record, @Param("example") SysLogExample example);

	int updateByPrimaryKeySelective(SysLog record);

	int updateByPrimaryKeyWithBLOBs(SysLog record);

	int updateByPrimaryKey(SysLog record);

	public List<SysLog> querySysLogByUid(@Param("userId") Long userId);

	public SysLog selectOneByUid(@Param("userId") Long userId);
}