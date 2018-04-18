package com.sinco.carnation.market.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.market.bo.ActRedPackageBO;
import com.sinco.carnation.market.model.ActRedPackage;
import com.sinco.carnation.market.model.ActRedPackageExample;
import com.sinco.carnation.market.vo.ActRedPackageVO;
import com.sinco.dal.common.MyPage;

public interface ActRedPackageMapper {
	int countByExample(ActRedPackageExample example);

	int deleteByExample(ActRedPackageExample example);

	int deleteByPrimaryKey(Long id);

	int insert(ActRedPackage record);

	int insertSelective(ActRedPackage record);

	List<ActRedPackageBO> selectByExampleWithBLOBs(ActRedPackageExample example);

	List<ActRedPackageBO> selectByExample(ActRedPackageExample example);

	ActRedPackageBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") ActRedPackage record,
			@Param("example") ActRedPackageExample example);

	int updateByExampleWithBLOBs(@Param("record") ActRedPackage record,
			@Param("example") ActRedPackageExample example);

	int updateByExample(@Param("record") ActRedPackage record, @Param("example") ActRedPackageExample example);

	int updateByPrimaryKeySelective(ActRedPackage record);

	int updateByPrimaryKeyWithBLOBs(ActRedPackage record);

	int updateByPrimaryKey(ActRedPackage record);

	List<ActRedPackageBO> findAllByPage(@Param("vo") ActRedPackageVO vo, MyPage<ActRedPackageBO> page);

	//
//	List<ActRedPackageBO> getActRedPackageBO();

	//
	int updateActRedPackageRecordById(@Param("id") Long packageId);

}