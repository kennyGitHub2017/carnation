package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.bo.BuygiftBO;
import com.sinco.carnation.shop.model.Buygift;
import com.sinco.carnation.shop.model.BuygiftExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuygiftMapper {
	int countByExample(BuygiftExample example);

	int deleteByExample(BuygiftExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Buygift record);

	int insertSelective(Buygift record);

	List<BuygiftBO> selectByExampleWithBLOBs(BuygiftExample example);

	List<BuygiftBO> selectByExample(BuygiftExample example);

	BuygiftBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Buygift record, @Param("example") BuygiftExample example);

	int updateByExampleWithBLOBs(@Param("record") Buygift record, @Param("example") BuygiftExample example);

	int updateByExample(@Param("record") Buygift record, @Param("example") BuygiftExample example);

	int updateByPrimaryKeySelective(Buygift record);

	int updateByPrimaryKeyWithBLOBs(Buygift record);

	int updateByPrimaryKey(Buygift record);
}