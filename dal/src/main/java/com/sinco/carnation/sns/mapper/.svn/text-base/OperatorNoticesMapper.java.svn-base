package com.sinco.carnation.sns.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.sns.bo.OperatorNoticesBO;
import com.sinco.carnation.sns.model.OperatorNotices;
import com.sinco.carnation.sns.model.OperatorNoticesExample;
import com.sinco.carnation.sns.vo.OperatorNoticesVO;
import com.sinco.dal.common.MyPage;

public interface OperatorNoticesMapper {
	int countByExample(OperatorNoticesExample example);

	int deleteByExample(OperatorNoticesExample example);

	int deleteByPrimaryKey(Long id);

	int insert(OperatorNotices record);

	int insertSelective(OperatorNotices record);

	List<OperatorNoticesBO> selectByExampleWithBLOBs(OperatorNoticesExample example);

	List<OperatorNoticesBO> selectByExample(OperatorNoticesExample example);

	OperatorNoticesBO selectByPrimaryKey(Long id);

	OperatorNoticesBO selectBoByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") OperatorNotices record,
			@Param("example") OperatorNoticesExample example);

	int updateByExampleWithBLOBs(@Param("record") OperatorNotices record,
			@Param("example") OperatorNoticesExample example);

	int updateByExample(@Param("record") OperatorNotices record,
			@Param("example") OperatorNoticesExample example);

	int updateByPrimaryKeySelective(OperatorNotices record);

	int updateByPrimaryKeyWithBLOBs(OperatorNotices record);

	int updateByPrimaryKey(OperatorNotices record);

	/* grey added begin */
	List<OperatorNoticesBO> selectListByVo(@Param("vo") OperatorNoticesVO vo, MyPage<OperatorNoticesBO> page);

	List<OperatorNoticesBO> queryNoticesList(@Param("opertorId") Long opertorId,
			@Param("page") MyPage<OperatorNoticesBO> page);
}