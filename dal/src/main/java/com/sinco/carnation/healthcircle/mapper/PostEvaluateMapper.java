package com.sinco.carnation.healthcircle.mapper;

import com.sinco.carnation.healthcircle.bo.PostEvaluateBO;
import com.sinco.carnation.healthcircle.model.PostEvaluate;
import com.sinco.carnation.healthcircle.model.PostEvaluateExample;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PostEvaluateMapper {
	int countByExample(PostEvaluateExample example);

	int deleteByExample(PostEvaluateExample example);

	int deleteByPrimaryKey(Long id);

	int insert(PostEvaluate record);

	int insertSelective(PostEvaluate record);

	List<PostEvaluateBO> selectByExample(PostEvaluateExample example);

	PostEvaluateBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") PostEvaluate record,
			@Param("example") PostEvaluateExample example);

	int updateByExample(@Param("record") PostEvaluate record, @Param("example") PostEvaluateExample example);

	int updateByPrimaryKeySelective(PostEvaluate record);

	int updateByPrimaryKey(PostEvaluate record);

	List<PostEvaluate> selectAllByPid(@Param("postId") Long postId);

	List<PostEvaluate> selectPageByPostId(MyPage<PostEvaluate> page, @Param("postId") Long postId);

	/** 查询未加分记录 **/
	public List<PostEvaluate> listByisAddIntegral();
	/** 更新加分状态 **/
	public int updateIsAddIntegralByid(@Param("id") Long id);
}