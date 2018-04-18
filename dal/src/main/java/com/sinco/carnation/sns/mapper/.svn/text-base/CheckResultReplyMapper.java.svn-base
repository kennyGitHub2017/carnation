package com.sinco.carnation.sns.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.sinco.carnation.sns.bo.CheckResultReplyBO;
import com.sinco.carnation.sns.model.CheckResultReply;
import com.sinco.carnation.sns.model.CheckResultReplyExample;
import com.sinco.carnation.sns.vo.CheckResultReplyVO;
import com.sinco.dal.common.MyPage;

public interface CheckResultReplyMapper {
	int countByExample(CheckResultReplyExample example);

	int deleteByExample(CheckResultReplyExample example);

	int deleteByPrimaryKey(Long id);

	int insert(CheckResultReply record);

	int insertSelective(CheckResultReply record);

	List<CheckResultReplyBO> selectByExample(CheckResultReplyExample example);

	List<CheckResultReplyBO> search(@Param("vo") CheckResultReplyVO vo,
			@Param("page") MyPage<CheckResultReplyBO> page);

	CheckResultReplyBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") CheckResultReply record,
			@Param("example") CheckResultReplyExample example);

	int updateByExample(@Param("record") CheckResultReply record,
			@Param("example") CheckResultReplyExample example);

	int updateByPrimaryKeySelective(CheckResultReply record);

	int updateByPrimaryKey(CheckResultReply record);

	/** 我的体检报告列表 **/
	List<CheckResultReplyBO> checkReportList(@Param("uid") Long uid,
			@Param("page") MyPage<CheckResultReplyBO> page);
}