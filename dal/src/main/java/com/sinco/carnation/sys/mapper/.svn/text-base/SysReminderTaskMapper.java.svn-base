package com.sinco.carnation.sys.mapper;

import com.sinco.carnation.sys.bo.SysReminderTaskBO;
import com.sinco.carnation.sys.model.SysReminderTask;
import com.sinco.carnation.sys.model.SysReminderTaskExample;
import java.util.List;

import com.sinco.carnation.sys.vo.SysReminderTaskVO;
import com.sinco.dal.common.MyPage;
import org.apache.ibatis.annotations.Param;

public interface SysReminderTaskMapper {
	int countByExample(SysReminderTaskExample example);

	int deleteByExample(SysReminderTaskExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SysReminderTask record);

	int insertSelective(SysReminderTask record);

	List<SysReminderTaskBO> selectByExampleWithBLOBs(SysReminderTaskExample example);

	List<SysReminderTaskBO> selectByExample(SysReminderTaskExample example);

	SysReminderTaskBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SysReminderTask record,
			@Param("example") SysReminderTaskExample example);

	int updateByExampleWithBLOBs(@Param("record") SysReminderTask record,
			@Param("example") SysReminderTaskExample example);

	int updateByExample(@Param("record") SysReminderTask record,
			@Param("example") SysReminderTaskExample example);

	int updateByPrimaryKeySelective(SysReminderTask record);

	int updateByPrimaryKeyWithBLOBs(SysReminderTask record);

	int updateByPrimaryKey(SysReminderTask record);

	List<SysReminderTaskBO> findPageByVo(@Param("vo") SysReminderTaskVO vo, MyPage<SysReminderTaskBO> page);
}