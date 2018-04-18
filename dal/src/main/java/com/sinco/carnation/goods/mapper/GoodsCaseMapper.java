package com.sinco.carnation.goods.mapper;

import com.sinco.carnation.goods.bo.GoodsCaseBO;
import com.sinco.carnation.goods.model.GoodsCase;
import com.sinco.carnation.goods.model.GoodsCaseExample;
import com.sinco.carnation.goods.vo.GoodsCaseVO;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoodsCaseMapper {
	int countByExample(GoodsCaseExample example);

	int deleteByExample(GoodsCaseExample example);

	int deleteByPrimaryKey(Long id);

	int insert(GoodsCase record);

	int insertSelective(GoodsCase record);

	List<GoodsCaseBO> selectByExampleWithBLOBs(GoodsCaseExample example);

	List<GoodsCaseBO> selectByExample(GoodsCaseExample example);

	GoodsCaseBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") GoodsCase record, @Param("example") GoodsCaseExample example);

	int updateByExampleWithBLOBs(@Param("record") GoodsCase record, @Param("example") GoodsCaseExample example);

	int updateByExample(@Param("record") GoodsCase record, @Param("example") GoodsCaseExample example);

	int updateByPrimaryKeySelective(GoodsCase record);

	int updateByPrimaryKeyWithBLOBs(GoodsCase record);

	int updateByPrimaryKey(GoodsCase record);

	List<GoodsCaseBO> findPageByVO(@Param("vo") GoodsCaseVO vo, MyPage<GoodsCaseBO> page);
}