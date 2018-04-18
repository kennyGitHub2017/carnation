package com.sinco.carnation.goods.mapper;

import com.sinco.carnation.goods.bo.GoodsBrandBO;
import com.sinco.carnation.goods.dao.BrandFindVO;
import com.sinco.carnation.goods.model.GoodsBrand;
import com.sinco.carnation.goods.model.GoodsBrandExample;
import com.sinco.carnation.goods.vo.GoodsBrandShowIndexVO;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoodsBrandMapper {

	List<GoodsBrandBO> findByShowIndex(GoodsBrandShowIndexVO vo);

	GoodsBrandBO findBOById(Long id);

	List<GoodsBrandBO> findByPage(@Param("vo") BrandFindVO brandFindVO, MyPage<GoodsBrandBO> page);

	List<GoodsBrandBO> findByGoodsClass(Long gcId);

	List<GoodsBrandBO> findByGoodsType(Long gtId);

	List<GoodsBrandBO> selectBOByExample(GoodsBrandExample example);

	int countByExample(GoodsBrandExample example);

	int deleteByExample(GoodsBrandExample example);

	int deleteByPrimaryKey(Long id);

	int insert(GoodsBrand record);

	int insertSelective(GoodsBrand record);

	List<GoodsBrand> selectByExampleWithBLOBs(GoodsBrandExample example);

	List<GoodsBrand> selectByExample(GoodsBrandExample example);

	GoodsBrand selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") GoodsBrand record,
			@Param("example") GoodsBrandExample example);

	int updateByExampleWithBLOBs(@Param("record") GoodsBrand record,
			@Param("example") GoodsBrandExample example);

	int updateByExample(@Param("record") GoodsBrand record, @Param("example") GoodsBrandExample example);

	int updateByPrimaryKeySelective(GoodsBrand record);

	int updateByPrimaryKeyWithBLOBs(GoodsBrand record);

	int updateByPrimaryKey(GoodsBrand record);

	List<GoodsBrandBO> findByVo(@Param("record") GoodsBrand record);
	
	public List<GoodsBrandBO> selectByAll();
}