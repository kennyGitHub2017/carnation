package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.bo.ExpressCompanyBO;
import com.sinco.carnation.shop.model.ExpressCompany;
import com.sinco.carnation.shop.model.ExpressCompanyExample;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ExpressCompanyMapper {
	int countByExample(ExpressCompanyExample example);

	int deleteByExample(ExpressCompanyExample example);

	int deleteByPrimaryKey(Long id);

	int insert(ExpressCompany record);

	int insertSelective(ExpressCompany record);

	List<ExpressCompanyBO> selectByExampleWithBLOBs(ExpressCompanyExample example);

	List<ExpressCompanyBO> selectByExample(ExpressCompanyExample example);

	ExpressCompanyBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") ExpressCompany record,
			@Param("example") ExpressCompanyExample example);

	int updateByExampleWithBLOBs(@Param("record") ExpressCompany record,
			@Param("example") ExpressCompanyExample example);

	int updateByExample(@Param("record") ExpressCompany record,
			@Param("example") ExpressCompanyExample example);

	int updateByPrimaryKeySelective(ExpressCompany record);

	int updateByPrimaryKeyWithBLOBs(ExpressCompany record);

	int updateByPrimaryKey(ExpressCompany record);

	List<ExpressCompanyBO> queryExpressCompanyPage(@Param("page") MyPage<ExpressCompanyBO> page);

	int deleteExpressCompanyById(@Param("ids") Long[] ids);

	List<ExpressCompanyBO> findListByStatus(@Param("companyStatus") Integer companyStatus);
}