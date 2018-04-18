package com.sinco.carnation.juanpi.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.juanpi.bo.JuanpiGoodsBO;
import com.sinco.carnation.juanpi.model.JuanpiGoods;
import com.sinco.carnation.juanpi.model.JuanpiGoodsExample;
import com.sinco.carnation.juanpi.vo.JuanpiGoodsVO;
import com.sinco.dal.common.MyPage;

public interface JuanpiGoodsMapper {
    int countByExample(JuanpiGoodsExample example);

    int deleteByExample(JuanpiGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JuanpiGoods record);

    int insertSelective(JuanpiGoods record);

    List<JuanpiGoodsBO> selectByExample(JuanpiGoodsExample example);

    JuanpiGoodsBO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") JuanpiGoods record, @Param("example") JuanpiGoodsExample example);

    int updateByExample(@Param("record") JuanpiGoods record, @Param("example") JuanpiGoodsExample example);

    int updateByPrimaryKeySelective(JuanpiGoods record);

    int updateByPrimaryKey(JuanpiGoods record);

	List<Long> findAllSellingGoods();

	void deleteUnsynJuanpiGoods(@Param("lastUpdateTime") Date lastUpdateTime);
	
	
	List<JuanpiGoodsBO> findGoodsByVO(@Param("vo")JuanpiGoodsVO vo,@Param("page")MyPage<JuanpiGoodsBO> page);
	
	
	int updateIsShow(@Param("vo")JuanpiGoodsVO vo);
	
	void upateGoodsSales(@Param("id") Long id, @Param("goodsnumber") Long goodsnumber);

	int updateClass(@Param("vo")JuanpiGoodsVO vo);
	
	List<JuanpiGoodsBO> findClassNameById(@Param("cId")Long cId);
	List<JuanpiGoodsBO> selectByRand(@Param("limitStart") Integer limitStart, @Param("limitEnd")Integer limitEnd);

	List<Long> findAllIds(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
}