package com.sinco.carnation.weChat.mapper;

import com.sinco.carnation.weChat.bo.WeChatInvitationRelationBO;
import com.sinco.carnation.weChat.model.WeChatInvitationRelation;
import com.sinco.carnation.weChat.model.WeChatInvitationRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeChatInvitationRelationMapper {
	int countByExample(WeChatInvitationRelationExample example);

	int deleteByExample(WeChatInvitationRelationExample example);

	int deleteByPrimaryKey(Long id);

	int insert(WeChatInvitationRelation record);

	int insertSelective(WeChatInvitationRelation record);

	List<WeChatInvitationRelationBO> selectByExample(WeChatInvitationRelationExample example);

	WeChatInvitationRelationBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") WeChatInvitationRelation record,
			@Param("example") WeChatInvitationRelationExample example);

	int updateByExample(@Param("record") WeChatInvitationRelation record,
			@Param("example") WeChatInvitationRelationExample example);

	int updateByPrimaryKeySelective(WeChatInvitationRelation record);

	int updateByPrimaryKey(WeChatInvitationRelation record);
}