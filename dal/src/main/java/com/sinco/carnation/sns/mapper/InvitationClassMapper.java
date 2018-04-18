package com.sinco.carnation.sns.mapper;

import com.sinco.carnation.sns.bo.InvitationClassBO;
import com.sinco.carnation.sns.model.InvitationClass;
import com.sinco.carnation.sns.model.InvitationClassExample;
import com.sinco.dal.common.MyPage;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface InvitationClassMapper {
	int countByExample(InvitationClassExample example);

	int deleteByExample(InvitationClassExample example);

	int deleteByPrimaryKey(Long id);

	int insert(InvitationClass record);

	int insertSelective(InvitationClass record);

	List<InvitationClass> selectByExample(InvitationClassExample example);

	InvitationClass selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") InvitationClass record,
			@Param("example") InvitationClassExample example);

	int updateByExample(@Param("record") InvitationClass record,
			@Param("example") InvitationClassExample example);

	int updateByPrimaryKeySelective(InvitationClass record);

	int updateByPrimaryKey(InvitationClass record);

	List<InvitationClassBO> queryInvitationClass(@Param("name") String name,
			@Param("parentId") Long parentId, MyPage<InvitationClassBO> page);

	List<InvitationClassBO> queryInvitationClassBoByParentId(@Param("parentId") Long parentId);

	Long countChild(Long id);

	List<InvitationClassBO> queryByIds(Set<Long> ids);

}