package com.sinco.carnation.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.sys.bo.ActApplyBO;
import com.sinco.carnation.sys.model.ActApply;
import com.sinco.carnation.sys.model.ActApplyExample;
import com.sinco.carnation.sys.vo.ActApplyVO;
import com.sinco.dal.common.MyPage;

public interface ActApplyMapper {
	int countByExample(ActApplyExample example);

	int deleteByExample(ActApplyExample example);

	int deleteByPrimaryKey(Long id);

	int insert(ActApply record);

	int insertSelective(ActApply record);

	List<ActApplyBO> selectByExample(ActApplyExample example);

	ActApplyBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") ActApply record, @Param("example") ActApplyExample example);

	int updateByExample(@Param("record") ActApply record, @Param("example") ActApplyExample example);

	int updateByPrimaryKeySelective(ActApply record);

	int updateByPrimaryKey(ActApply record);

	List<ActApplyBO> selectListByVo(@Param("vo") ActApplyVO vo, MyPage<ActApplyBO> page);
}