package com.sinco.carnation.sns.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.sinco.carnation.sns.model.InformationReply;
import com.sinco.carnation.sns.model.InformationReplyExample;

public interface InformationReplyMapper {
	int countByExample(InformationReplyExample example);

	int deleteByExample(InformationReplyExample example);

	int deleteByPrimaryKey(Long id);

	int insert(InformationReply record);

	int insertSelective(InformationReply record);

	List<InformationReply> selectByExampleWithBLOBs(InformationReplyExample example);

	List<InformationReply> selectByExample(InformationReplyExample example);

	InformationReply selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") InformationReply record,
			@Param("example") InformationReplyExample example);

	int updateByExampleWithBLOBs(@Param("record") InformationReply record,
			@Param("example") InformationReplyExample example);

	int updateByExample(@Param("record") InformationReply record,
			@Param("example") InformationReplyExample example);

	int updateByPrimaryKeySelective(InformationReply record);

	int updateByPrimaryKeyWithBLOBs(InformationReply record);

	int updateByPrimaryKey(InformationReply record);
}