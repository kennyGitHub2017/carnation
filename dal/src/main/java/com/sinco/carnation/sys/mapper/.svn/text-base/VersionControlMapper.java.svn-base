package com.sinco.carnation.sys.mapper;

import com.sinco.carnation.sys.bo.VersionControlBO;
import com.sinco.carnation.sys.model.VersionControl;
import com.sinco.carnation.sys.model.VersionControlExample;
import com.sinco.carnation.sys.vo.VersionControlVO;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface VersionControlMapper {
	int countByExample(VersionControlExample example);

	int deleteByExample(VersionControlExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(VersionControl record);

	int insertSelective(VersionControl record);

	List<VersionControlBO> selectByExample(VersionControlExample example);

	VersionControlBO selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") VersionControl record,
			@Param("example") VersionControlExample example);

	int updateByExample(@Param("record") VersionControl record,
			@Param("example") VersionControlExample example);

	int updateByPrimaryKeySelective(VersionControl record);

	int updateByPrimaryKey(VersionControl record);

	VersionControlBO findOneByTypeNew(Integer type);

	List<VersionControlBO> selectListByVO(MyPage<VersionControlBO> page, @Param("vo") VersionControlVO vo);
}