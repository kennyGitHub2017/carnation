package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.bo.FreeClassBO;
import com.sinco.carnation.shop.model.FreeClass;
import com.sinco.carnation.shop.model.FreeClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FreeClassMapper {
	int countByExample(FreeClassExample example);

	int deleteByExample(FreeClassExample example);

	int deleteByPrimaryKey(Long id);

	int insert(FreeClass record);

	int insertSelective(FreeClass record);

	List<FreeClassBO> selectByExample(FreeClassExample example);

	FreeClassBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") FreeClass record, @Param("example") FreeClassExample example);

	int updateByExample(@Param("record") FreeClass record, @Param("example") FreeClassExample example);

	int updateByPrimaryKeySelective(FreeClass record);

	int updateByPrimaryKey(FreeClass record);
}