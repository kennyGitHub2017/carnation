package com.sinco.carnation.sns.mapper;

import com.sinco.carnation.sns.bo.WenJuanQuestionBO;
import com.sinco.carnation.sns.model.WenJuanQuestion;
import com.sinco.carnation.sns.model.WenJuanQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WenJuanQuestionMapper {
	int countByExample(WenJuanQuestionExample example);

	int deleteByExample(WenJuanQuestionExample example);

	int deleteByPrimaryKey(Long id);

	int insert(WenJuanQuestion record);

	int insertSelective(WenJuanQuestion record);

	List<WenJuanQuestionBO> selectByExample(WenJuanQuestionExample example);

	WenJuanQuestionBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") WenJuanQuestion record,
			@Param("example") WenJuanQuestionExample example);

	int updateByExample(@Param("record") WenJuanQuestion record,
			@Param("example") WenJuanQuestionExample example);

	int updateByPrimaryKeySelective(WenJuanQuestion record);

	int updateByPrimaryKey(WenJuanQuestion record);

	/**
	 * 根据题ID获取题目信息
	 */
	public List<WenJuanQuestionBO> get_WJ_Question_By_GroupID(Long wj_group_id);

	/**
	 * 根据题groupID获取题目信息
	 */
	public List<WenJuanQuestionBO> query_Question_List_ByID(@Param("list") List<Long> list);

	public List<WenJuanQuestionBO> queryQuestionByGroupID(@Param("groupID") Long groupID);

}