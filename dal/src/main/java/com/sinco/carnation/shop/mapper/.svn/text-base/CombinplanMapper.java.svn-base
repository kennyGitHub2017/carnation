package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.bo.CombinplanBO;
import com.sinco.carnation.shop.model.Combinplan;
import com.sinco.carnation.shop.model.CombinplanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CombinplanMapper {
	int countByExample(CombinplanExample example);

	int deleteByExample(CombinplanExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Combinplan record);

	int insertSelective(Combinplan record);

	List<CombinplanBO> selectByExampleWithBLOBs(CombinplanExample example);

	List<CombinplanBO> selectByExample(CombinplanExample example);

	CombinplanBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Combinplan record,
			@Param("example") CombinplanExample example);

	int updateByExampleWithBLOBs(@Param("record") Combinplan record,
			@Param("example") CombinplanExample example);

	int updateByExample(@Param("record") Combinplan record, @Param("example") CombinplanExample example);

	int updateByPrimaryKeySelective(Combinplan record);

	int updateByPrimaryKeyWithBLOBs(Combinplan record);

	int updateByPrimaryKey(Combinplan record);
}