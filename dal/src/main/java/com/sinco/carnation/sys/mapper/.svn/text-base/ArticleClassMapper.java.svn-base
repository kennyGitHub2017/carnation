package com.sinco.carnation.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.sys.bo.ArticleClassBO;
import com.sinco.carnation.sys.model.ArticleClass;
import com.sinco.carnation.sys.model.ArticleClassExample;
import com.sinco.dal.common.MyPage;

public interface ArticleClassMapper {

	List<ArticleClassBO> findByPage(@Param("page") MyPage<ArticleClassBO> page);

	int countByExample(ArticleClassExample example);

	int deleteByExample(ArticleClassExample example);

	int deleteByPrimaryKey(Long id);

	int insert(ArticleClass record);

	int insertSelective(ArticleClass record);

	List<ArticleClassBO> topClass();

	List<ArticleClassBO> selectByExample(ArticleClassExample example);

	List<ArticleClassBO> selectBOByExample(ArticleClassExample example);

	ArticleClass selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") ArticleClass record,
			@Param("example") ArticleClassExample example);

	int updateByExample(@Param("record") ArticleClass record, @Param("example") ArticleClassExample example);

	int updateByPrimaryKeySelective(ArticleClass record);

	int updateByPrimaryKey(ArticleClass record);

	List<ArticleClassBO> queryArticleList(@Param("mark") String mark);
}