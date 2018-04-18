package com.sinco.carnation.sns.mapper;

import com.sinco.carnation.sns.model.InvitationRClass;
import com.sinco.carnation.sns.model.InvitationRClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InvitationRClassMapper {
	int countByExample(InvitationRClassExample example);

	int deleteByExample(InvitationRClassExample example);

	int deleteByPrimaryKey(Long id);

	int insert(InvitationRClass record);

	int insertSelective(InvitationRClass record);

	List<InvitationRClass> selectByExample(InvitationRClassExample example);

	InvitationRClass selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") InvitationRClass record,
			@Param("example") InvitationRClassExample example);

	int updateByExample(@Param("record") InvitationRClass record,
			@Param("example") InvitationRClassExample example);

	int updateByPrimaryKeySelective(InvitationRClass record);

	int updateByPrimaryKey(InvitationRClass record);
}