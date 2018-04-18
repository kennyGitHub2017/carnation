package com.sinco.carnation.store.mapper;

import com.sinco.carnation.store.bo.StorePartnerBO;
import com.sinco.carnation.store.model.StorePartner;
import com.sinco.carnation.store.model.StorePartnerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StorePartnerMapper {
	int countByExample(StorePartnerExample example);

	int deleteByExample(StorePartnerExample example);

	int deleteByPrimaryKey(Long id);

	int insert(StorePartner record);

	int insertSelective(StorePartner record);

	List<StorePartnerBO> selectByExample(StorePartnerExample example);

	StorePartnerBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") StorePartner record,
			@Param("example") StorePartnerExample example);

	int updateByExample(@Param("record") StorePartner record, @Param("example") StorePartnerExample example);

	int updateByPrimaryKeySelective(StorePartner record);

	int updateByPrimaryKey(StorePartner record);
}