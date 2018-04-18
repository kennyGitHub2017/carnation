package com.sinco.carnation.healthcircle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.healthcircle.bo.PostBO;
import com.sinco.carnation.healthcircle.model.Post;
import com.sinco.carnation.healthcircle.model.PostEvaluate;
import com.sinco.carnation.healthcircle.model.PostExample;
import com.sinco.carnation.healthcircle.vo.PostSelectVO;
import com.sinco.carnation.healthcircle.vo.PostVO;
import com.sinco.carnation.healthcircle.vo.SelectPriseCenterVO;
import com.sinco.dal.common.MyPage;

public interface PostMapper {
	int countByExample(PostExample example);

	int deleteByExample(PostExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Post record);

	int insertSelective(Post record);

	List<PostBO> selectByExampleWithBLOBs(PostExample example);

	List<PostBO> selectByExample(PostExample example);

	PostBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Post record, @Param("example") PostExample example);

	int updateByExampleWithBLOBs(@Param("record") Post record, @Param("example") PostExample example);

	int updateByExample(@Param("record") Post record, @Param("example") PostExample example);

	int updateByPrimaryKeySelective(Post record);

	int updateByPrimaryKeyWithBLOBs(Post record);

	int updateByPrimaryKey(Post record);

	List<Post> findPageByVo(MyPage<Post> page, @Param("vo") PostVO vo);

	int updatePraiseNum(@Param("id") Long id);

	int updateEvalueteNum(@Param("id") Long id, @Param("topThirdEvaluate") String topThirdEvaluate);

	int updateDecPraiseNum(@Param("id") Long id);

	Post selectById(Long id);

	List<PostEvaluate> getEvaluate(@Param("postIds") List<Long> postIds);

	List<Post> findPageByLabel(MyPage<Post> page, @Param("vo") SelectPriseCenterVO vo);

	List<Post> findHotPageByVo(MyPage<Post> page, @Param("vo") PostVO vo);

	List<PostBO> findByPage(MyPage<PostBO> page, @Param("vo") PostSelectVO vo);

	void deleteByUIdPId(@Param("userId") Long userId, @Param("postId") Long postId);

	int selectCurrentNumber(@Param("userId") Long userId);

	Post selectLatelyPost(@Param("userId") Long userId);

	List<Post> listByisAddIntegral();
	int updateIsAddIntegralByid(@Param("id") Long id);
}