package com.sinco.carnation.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.sys.bo.ArticleBO;
import com.sinco.carnation.sys.model.Article;
import com.sinco.carnation.sys.model.ArticleExample;
import com.sinco.carnation.sys.vo.ArticleShopVO;
import com.sinco.dal.common.MyPage;

public interface ArticleMapper {

	List<ArticleBO> findShopByVO(ArticleShopVO vo);

	List<ArticleBO> findShopPageByVO(@Param("vo") ArticleShopVO vo, MyPage<ArticleBO> page);

	List<ArticleBO> findByPage(@Param("title") String title,
			@Param("articleClassName") String articleClassName, @Param("page") MyPage<ArticleBO> page);

	int countByExample(ArticleExample example);

	int deleteByExample(ArticleExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Article record);

	int insertSelective(Article record);

	List<ArticleBO> selectByExampleWithBLOBs(ArticleExample example);

	List<ArticleBO> findByParentMark(MyPage<ArticleBO> page, @Param("mark") String mark);

	List<ArticleBO> top6();

	List<Article> selectByExample(ArticleExample example);

	List<ArticleBO> selectPageByClassId(@Param("type") String type, @Param("classId") Long classId,
			MyPage<ArticleBO> page);

	List<ArticleBO> selectByClassId(@Param("type") String type, @Param("classId") Long classId,
			@Param("count") Integer count);

	List<ArticleBO> findByParentClassMark(@Param("type") String type, @Param("marks") List<String> marks,
			@Param("display") Boolean display, @Param("count") Integer count);

	Article selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);

	int updateByExampleWithBLOBs(@Param("record") Article record, @Param("example") ArticleExample example);

	int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

	int updateByPrimaryKeySelective(Article record);

	int updateByPrimaryKeyWithBLOBs(Article record);

	int updateByPrimaryKey(Article record);

	// 公司动态分页显示列表
	List<ArticleBO> selectViewPageListByMark(MyPage<ArticleBO> page, @Param("vo") ArticleShopVO vo);

	List<ArticleBO> selectViewPageList(MyPage<ArticleBO> page, @Param("vo") ArticleShopVO vo);

	// 显示动态明细
	List<ArticleBO> selectViewDetailsPrevious(@Param("cid") Long cid, @Param("aid") Long aid);

	List<ArticleBO> selectViewDetailsNext(@Param("cid") Long cid, @Param("aid") Long aid);

	List<ArticleBO> queryMerchantNoticeList(@Param("mark") String mark, @Param("page") MyPage<ArticleBO> page);

	List<ArticleBO> queryUserArticList(@Param("id") Long id, @Param("user") String user);

	List<ArticleBO> listByParentMarkAndCount(@Param("count") Long count, @Param("mark") String mark);

}