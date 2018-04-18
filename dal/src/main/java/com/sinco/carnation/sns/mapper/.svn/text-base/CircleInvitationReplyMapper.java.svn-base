package com.sinco.carnation.sns.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.sns.bo.CircleInvitationReplyBO;
import com.sinco.carnation.sns.model.CircleInvitationReply;
import com.sinco.carnation.sns.model.CircleInvitationReplyExample;
import com.sinco.carnation.sns.vo.CircleInvitationReplyVO;
import com.sinco.dal.common.MyPage;

public interface CircleInvitationReplyMapper {
	int countByExample(CircleInvitationReplyExample example);

	int deleteByExample(CircleInvitationReplyExample example);

	int deleteByPrimaryKey(Long id);

	int insert(CircleInvitationReply record);

	int insertSelective(CircleInvitationReply record);

	List<CircleInvitationReply> selectByExampleWithBLOBs(CircleInvitationReplyExample example);

	List<CircleInvitationReply> selectByExample(CircleInvitationReplyExample example);

	public List<CircleInvitationReply> selectPageByVO(@Param("vo") CircleInvitationReplyVO vo,
			MyPage<CircleInvitationReply> page);

	CircleInvitationReply selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") CircleInvitationReply record,
			@Param("example") CircleInvitationReplyExample example);

	int updateByExampleWithBLOBs(@Param("record") CircleInvitationReply record,
			@Param("example") CircleInvitationReplyExample example);

	int updateByExample(@Param("record") CircleInvitationReply record,
			@Param("example") CircleInvitationReplyExample example);

	int updateByPrimaryKeySelective(CircleInvitationReply record);

	int updateByPrimaryKeyWithBLOBs(CircleInvitationReply record);

	int updateByPrimaryKey(CircleInvitationReply record);

	List<CircleInvitationReplyBO> invitationReplyList(@Param("maxId") Long maxId,
			@Param("invitationId") Long invitationId, @Param("start") Integer start,
			@Param("pageSize") Integer pageSize);

	int replyInvitationCount(@Param("invitationId") Long invitationId);

	/** 查询未加分记录 **/
	public List<CircleInvitationReply> listByisAddIntegral();
	/** 更新加分状态 **/
	public int updateIsAddIntegralByid(@Param("id") Long id);
}