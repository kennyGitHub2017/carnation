package com.sinco.carnation.store.mapper;

import com.sinco.carnation.store.bo.StorePointBO;
import com.sinco.carnation.store.model.StorePoint;
import com.sinco.carnation.store.model.StorePointExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StorePointMapper {
	int countByExample(StorePointExample example);

	int deleteByExample(StorePointExample example);

	int deleteByPrimaryKey(Long id);

	int insert(StorePoint record);

	int insertSelective(StorePoint record);

	List<StorePointBO> selectByExample(StorePointExample example);

	List<StorePoint> selectPointByStoreGcAndStatus(@Param("gcMainId") Long gcId,
			@Param("storeStatus") Integer status);

	StorePointBO selectByPrimaryKey(Long id);

	StorePointBO fetchByStoreId(Long storeId);

	StorePointBO fetchByUserId(Long userId);

	List<StorePointBO> selectByStoreId(Long storeId);

	List<StorePointBO> selectByUserId(Long userId);

	int updateByExampleSelective(@Param("record") StorePoint record,
			@Param("example") StorePointExample example);

	int updateByExample(@Param("record") StorePoint record, @Param("example") StorePointExample example);

	int updateByPrimaryKeySelective(StorePoint record);

	int updateByPrimaryKey(StorePoint record);

}