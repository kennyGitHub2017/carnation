package com.sinco.carnation.user.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.user.bo.ManagerBO;
import com.sinco.carnation.user.model.Manager;
import com.sinco.carnation.user.model.ManagerExample;
import com.sinco.carnation.user.vo.ManagerVO;
import com.sinco.dal.common.MyPage;

public interface ManagerMapper {
	int countByExample(ManagerExample example);

	int deleteByExample(ManagerExample example);

	int deleteByPrimaryKey(Long uid);

	int insert(Manager record);

	int insertSelective(Manager record);

	List<Manager> selectByExample(ManagerExample example);

	List<ManagerBO> selectManagePageByVO(@Param("vo") ManagerVO vo, MyPage<ManagerBO> page);

	List<ManagerBO> selectManagePageByVO(@Param("vo") ManagerVO vo);

	ManagerBO selectByPrimaryKey(Long uid);

	int updateByExampleSelective(@Param("record") Manager record, @Param("example") ManagerExample example);

	int updateByExample(@Param("record") Manager record, @Param("example") ManagerExample example);

	int updateByPrimaryKeySelective(Manager record);

	int updateByPrimaryKey(Manager record);

	List<HashMap<String, Object>> getResultBySql(@Param("sql") String sql);
}