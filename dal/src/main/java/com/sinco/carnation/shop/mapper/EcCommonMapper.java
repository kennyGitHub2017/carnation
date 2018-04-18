package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.bo.EcCommonBO;
import com.sinco.carnation.shop.model.EcCommon;
import com.sinco.carnation.shop.model.EcCommonExample;
import com.sinco.carnation.shop.vo.EcCommonVO;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface EcCommonMapper {
	int countByExample(EcCommonExample example);

	int deleteByExample(EcCommonExample example);

	int deleteByPrimaryKey(Long id);

	int insert(EcCommon record);

	int insertSelective(EcCommon record);

	List<EcCommonBO> selectByExampleWithBLOBs(EcCommonExample example);

	List<EcCommonBO> selectByExample(EcCommonExample example);

	EcCommonBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") EcCommon record, @Param("example") EcCommonExample example);

	int updateByExampleWithBLOBs(@Param("record") EcCommon record, @Param("example") EcCommonExample example);

	int updateByExample(@Param("record") EcCommon record, @Param("example") EcCommonExample example);

	int updateByPrimaryKeySelective(EcCommon record);

	int updateByPrimaryKeyWithBLOBs(EcCommon record);

	int updateByPrimaryKey(EcCommon record);

	List<EcCommonBO> selectAllByCondition(@Param("eccType") Integer eccType,
			@Param("eccDefault") Integer eccDefault, @Param("eccStoreId") Long eccStoreId,
			@Param("eccEcId") Long eccEcId);

	int deleteSelfEcCommon(@Param("ids") List<Long> ecIds, @Param("eccType") Integer eccType);

	List<EcCommonBO> findByIds(@Param("ids") List<Long> ecIds);

	List<EcCommonBO> findListByVo(MyPage<EcCommonBO> page, @Param("vo") EcCommonVO vo);
}