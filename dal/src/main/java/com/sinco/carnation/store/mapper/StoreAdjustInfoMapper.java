package com.sinco.carnation.store.mapper;

import com.sinco.carnation.store.bo.StoreAdjustInfoBO;
import com.sinco.carnation.store.model.StoreAdjustInfo;
import com.sinco.carnation.store.model.StoreAdjustInfoExample;
import com.sinco.carnation.store.vo.StoreAdjustInfoVO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StoreAdjustInfoMapper {
	int countByExample(StoreAdjustInfoExample example);

	int deleteByExample(StoreAdjustInfoExample example);

	int deleteByPrimaryKey(Long id);

	int insert(StoreAdjustInfo record);

	int insertSelective(StoreAdjustInfo record);

	List<StoreAdjustInfoBO> selectByExampleWithBLOBs(StoreAdjustInfoExample example);

	List<StoreAdjustInfoBO> selectByExample(StoreAdjustInfoExample example);

	StoreAdjustInfoBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") StoreAdjustInfo record,
			@Param("example") StoreAdjustInfoExample example);

	int updateByExampleWithBLOBs(@Param("record") StoreAdjustInfo record,
			@Param("example") StoreAdjustInfoExample example);

	int updateByExample(@Param("record") StoreAdjustInfo record,
			@Param("example") StoreAdjustInfoExample example);

	int updateByPrimaryKeySelective(StoreAdjustInfo record);

	int updateByPrimaryKeyWithBLOBs(StoreAdjustInfo record);

	int updateByPrimaryKey(StoreAdjustInfo record);

	List<StoreAdjustInfo> findListByVo(@Param("vo") StoreAdjustInfoVO vo);
}