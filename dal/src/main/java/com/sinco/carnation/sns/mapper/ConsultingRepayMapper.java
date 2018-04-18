package com.sinco.carnation.sns.mapper;

import com.sinco.carnation.sns.bo.ConsultingRepayBO;
import com.sinco.carnation.sns.model.ConsultingRepay;
import com.sinco.carnation.sns.model.ConsultingRepayExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ConsultingRepayMapper {
	int countByExample(ConsultingRepayExample example);

	int deleteByExample(ConsultingRepayExample example);

	int deleteByPrimaryKey(Long id);

	int insert(ConsultingRepay record);

	int insertSelective(ConsultingRepay record);

	List<ConsultingRepay> selectByExample(ConsultingRepayExample example);

	ConsultingRepay selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") ConsultingRepay record,
			@Param("example") ConsultingRepayExample example);

	int updateByExample(@Param("record") ConsultingRepay record,
			@Param("example") ConsultingRepayExample example);

	int updateByPrimaryKeySelective(ConsultingRepay record);

	int updateByPrimaryKey(ConsultingRepay record);

	List<ConsultingRepayBO> consultReplyList(@Param("conId") Long conId);
}