package com.sinco.carnation.healthcircle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.healthcircle.bo.PostPraiseBO;
import com.sinco.carnation.healthcircle.model.PostPraise;
import com.sinco.carnation.healthcircle.model.PostPraiseExample;

public interface PostPraiseMapper {
	int countByExample(PostPraiseExample example);

	int deleteByExample(PostPraiseExample example);

	int deleteByPrimaryKey(Long id);

	int insert(PostPraise record);

	int insertSelective(PostPraise record);

	List<PostPraiseBO> selectByExample(PostPraiseExample example);

	PostPraiseBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") PostPraise record,
			@Param("example") PostPraiseExample example);

	int updateByExample(@Param("record") PostPraise record, @Param("example") PostPraiseExample example);

	int updateByPrimaryKeySelective(PostPraise record);

	int updateByPrimaryKey(PostPraise record);

	int insertByVo(PostPraise vo);

	PostPraise selectByVo(@Param("vo") PostPraise vo);

	int deleteByVo(@Param("vo") PostPraise vo);

	List<PostPraise> selectByUserId(@Param("userId") Long userId);

	List<String> selectUsernameByPostId(@Param("postId") Long postId);

	/** 查询未加分记录 **/
	public List<PostPraise> listByisAddIntegral();
	/** 更新加分状态 **/
	public int updateIsAddIntegralByid(@Param("id") Long id);
}