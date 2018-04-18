package com.sinco.carnation.sys.mapper;

import com.sinco.carnation.sys.bo.PartnerBO;
import com.sinco.carnation.sys.model.Partner;
import com.sinco.carnation.sys.model.PartnerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PartnerMapper {
	int countByExample(PartnerExample example);

	int deleteByExample(PartnerExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Partner record);

	int insertSelective(Partner record);

	List<PartnerBO> selectByExample(PartnerExample example);

	PartnerBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Partner record, @Param("example") PartnerExample example);

	int updateByExample(@Param("record") Partner record, @Param("example") PartnerExample example);

	int updateByPrimaryKeySelective(Partner record);

	int updateByPrimaryKey(Partner record);
}