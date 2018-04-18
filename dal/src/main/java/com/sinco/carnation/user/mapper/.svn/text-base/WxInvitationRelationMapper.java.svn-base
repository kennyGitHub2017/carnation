package com.sinco.carnation.user.mapper;

import com.sinco.carnation.user.bo.WxInvitationRelationBO;
import com.sinco.carnation.user.model.WxInvitationRelation;
import com.sinco.carnation.user.model.WxInvitationRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxInvitationRelationMapper {
	int countByExample(WxInvitationRelationExample example);

	int deleteByExample(WxInvitationRelationExample example);

	int deleteByPrimaryKey(Long id);

	int insert(WxInvitationRelation record);

	int insertSelective(WxInvitationRelation record);

	List<WxInvitationRelationBO> selectByExample(WxInvitationRelationExample example);

	WxInvitationRelationBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") WxInvitationRelation record,
			@Param("example") WxInvitationRelationExample example);

	int updateByExample(@Param("record") WxInvitationRelation record,
			@Param("example") WxInvitationRelationExample example);

	int updateByPrimaryKeySelective(WxInvitationRelation record);

	int updateByPrimaryKey(WxInvitationRelation record);

	/***
	 * wx_auth_info 用户微信表
	 * 
	 * @param userId
	 * @return
	 */
	WxInvitationRelationBO getWxAuthInfo(@Param("userId") Long userId);

	/***
	 * 添加用户信息
	 * 
	 * @param openId
	 * @param userId
	 * @return
	 */
	int saveWxAuthInfo(@Param("openId") String openId, @Param("userId") Long userId);
}