package com.sinco.carnation.sns.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.sns.bo.CircleInvitationBO;
import com.sinco.carnation.sns.model.CircleInvitation;
import com.sinco.carnation.sns.model.CircleInvitationExample;
import com.sinco.carnation.sns.vo.CircleInvitationVO;
import com.sinco.dal.common.MyPage;

public interface CircleInvitationMapper {
	int countByExample(CircleInvitationExample example);

	int deleteByExample(CircleInvitationExample example);

	int deleteByPrimaryKey(Long id);

	int insert(CircleInvitation record);

	int insertSelective(CircleInvitation record);

	List<CircleInvitation> selectByExampleWithBLOBs(CircleInvitationExample example);

	List<CircleInvitation> selectByExample(CircleInvitationExample example);

	List<CircleInvitation> selectPageByVO(@Param("vo") CircleInvitationVO vo, MyPage<CircleInvitation> page);

	List<CircleInvitation> selectPageByOfficVO(@Param("vo") CircleInvitationVO vo,
			MyPage<CircleInvitation> page);

	List<CircleInvitation> selectInvitationByClassId(@Param("classId") Long classId);

	CircleInvitation selectByPrimaryKey(Long id);

	CircleInvitationBO selectInvitationDetail(@Param("invitationId") Long id);

	int updateByExampleSelective(@Param("record") CircleInvitation record,
			@Param("example") CircleInvitationExample example);

	int updateByExampleWithBLOBs(@Param("record") CircleInvitation record,
			@Param("example") CircleInvitationExample example);

	int updateByExample(@Param("record") CircleInvitation record,
			@Param("example") CircleInvitationExample example);

	int updateByPrimaryKeySelective(CircleInvitation record);

	int updateByPrimaryKeyWithBLOBs(CircleInvitation record);

	int updateByPrimaryKey(CircleInvitation record);

	List<CircleInvitationBO> queryCircleInvitation(@Param("uid") Long uid, @Param("type") String type,
			@Param("circleType") Integer circleType, @Param("timeStamp") String timeStamp,
			MyPage<CircleInvitationBO> page);

	List<CircleInvitationBO> circleInvitationList(@Param("uid") Long uid, MyPage<CircleInvitationBO> page);

	List<CircleInvitationBO> circleList(@Param("circleId") Long circleId,
			@Param("circleType") Long circleType, @Param("timeStamp") String timeStamp,
			MyPage<CircleInvitationBO> page);

	List<CircleInvitationBO> invitationAllListPage(@Param("invitationType") Long invitationType,
			@Param("timeStamp") String timeStamp, MyPage<CircleInvitationBO> page);

	List<CircleInvitationBO> searchInvitation(@Param("title") String title,
			@Param("timeStamp") String timeStamp, MyPage<CircleInvitationBO> page);

	int updateFavo(@Param("id") Long id, @Param("praiseInfo") String praiseInfo);

	int updateInvitationUnFavo(@Param("id") Long id, @Param("favoritesInfo") String favoritesInfo);

	int updateInvitationPraise(@Param("id") Long id, @Param("praiseInfo") String praiseInfo);

	int updateInvitationUnPraise(@Param("id") Long id, @Param("praiseInfo") String praiseInfo);

	List<CircleInvitationBO> queryByIds(@Param("ids") Set<Long> ids);
}