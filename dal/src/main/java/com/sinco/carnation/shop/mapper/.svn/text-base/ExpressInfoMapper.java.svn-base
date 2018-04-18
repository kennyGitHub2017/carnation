package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.bo.ExpressInfoBO;
import com.sinco.carnation.shop.model.ExpressInfo;
import com.sinco.carnation.shop.model.ExpressInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpressInfoMapper {
	int countByExample(ExpressInfoExample example);

	int deleteByExample(ExpressInfoExample example);

	int deleteByPrimaryKey(Long id);

	int insert(ExpressInfo record);

	int insertSelective(ExpressInfo record);

	List<ExpressInfoBO> selectByExampleWithBLOBs(ExpressInfoExample example);

	List<ExpressInfoBO> selectByExample(ExpressInfoExample example);

	ExpressInfoBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") ExpressInfo record,
			@Param("example") ExpressInfoExample example);

	int updateByExampleWithBLOBs(@Param("record") ExpressInfo record,
			@Param("example") ExpressInfoExample example);

	int updateByExample(@Param("record") ExpressInfo record, @Param("example") ExpressInfoExample example);

	int updateByPrimaryKeySelective(ExpressInfo record);

	int updateByPrimaryKeyWithBLOBs(ExpressInfo record);

	int updateByPrimaryKey(ExpressInfo record);
}