package com.sinco.carnation.sys.mapper;

import com.sinco.carnation.sys.bo.SysTaskLogBO;
import com.sinco.carnation.sys.model.SysTaskLog;
import com.sinco.carnation.sys.model.SysTaskLogExample;
import com.sinco.carnation.sys.vo.SysTaskLogVO;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysTaskLogMapper {
	int countByExample(SysTaskLogExample example);

	int deleteByExample(SysTaskLogExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SysTaskLog record);

	int insertSelective(SysTaskLog record);

	List<SysTaskLogBO> selectByExampleWithBLOBs(SysTaskLogExample example);

	List<SysTaskLogBO> selectByExample(SysTaskLogExample example);

	SysTaskLogBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SysTaskLog record,
			@Param("example") SysTaskLogExample example);

	int updateByExampleWithBLOBs(@Param("record") SysTaskLog record,
			@Param("example") SysTaskLogExample example);

	int updateByExample(@Param("record") SysTaskLog record, @Param("example") SysTaskLogExample example);

	int updateByPrimaryKeySelective(SysTaskLog record);

	int updateByPrimaryKeyWithBLOBs(SysTaskLog record);

	int updateByPrimaryKey(SysTaskLog record);

	List<SysTaskLogBO> selectByVO(@Param("vo") SysTaskLogVO vo, MyPage<SysTaskLogBO> page);

	int insertTaskLog(@Param("vo") SysTaskLogVO vo);
}