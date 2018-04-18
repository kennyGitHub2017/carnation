package com.sinco.carnation.store.mapper;

import com.sinco.carnation.store.bo.StoreApplyInfoBO;
import com.sinco.carnation.store.model.StoreApplyInfo;
import com.sinco.carnation.store.model.StoreApplyInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreApplyInfoMapper {
	int countByExample(StoreApplyInfoExample example);

	int deleteByExample(StoreApplyInfoExample example);

	int deleteByPrimaryKey(Long storeId);

	int insert(StoreApplyInfo record);

	int insertSelective(StoreApplyInfo record);

	List<StoreApplyInfoBO> selectByExample(StoreApplyInfoExample example);

	StoreApplyInfoBO selectByPrimaryKey(Long storeId);

	int updateByExampleSelective(@Param("record") StoreApplyInfo record,
			@Param("example") StoreApplyInfoExample example);

	int updateByExample(@Param("record") StoreApplyInfo record,
			@Param("example") StoreApplyInfoExample example);

	int updateByPrimaryKeySelective(StoreApplyInfo record);

	int updateByPrimaryKey(StoreApplyInfo record);

	StoreApplyInfoBO queryStoreApplyInfo(@Param("storeId") Long storeId);
}