package com.sinco.carnation.store.mapper;

import com.sinco.carnation.store.bo.StoreStatBO;
import com.sinco.carnation.store.model.StoreStat;
import com.sinco.carnation.store.model.StoreStatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreStatMapper {
	int countByExample(StoreStatExample example);

	int deleteByExample(StoreStatExample example);

	int deleteByPrimaryKey(Long id);

	int insert(StoreStat record);

	int insertSelective(StoreStat record);

	List<StoreStatBO> selectByExample(StoreStatExample example);

	StoreStatBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") StoreStat record, @Param("example") StoreStatExample example);

	int updateByExample(@Param("record") StoreStat record, @Param("example") StoreStatExample example);

	int updateByPrimaryKeySelective(StoreStat record);

	int updateByPrimaryKey(StoreStat record);
}