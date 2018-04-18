package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.bo.ShipAddressBO;
import com.sinco.carnation.shop.model.ShipAddress;
import com.sinco.carnation.shop.model.ShipAddressExample;
import com.sinco.carnation.shop.vo.ShipAddressVO;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ShipAddressMapper {
	int countByExample(ShipAddressExample example);

	int deleteByExample(ShipAddressExample example);

	int deleteByPrimaryKey(Long id);

	int insert(ShipAddress record);

	int insertSelective(ShipAddress record);

	List<ShipAddressBO> selectByExample(ShipAddressExample example);

	ShipAddressBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") ShipAddress record,
			@Param("example") ShipAddressExample example);

	int updateByExample(@Param("record") ShipAddress record, @Param("example") ShipAddressExample example);

	int updateByPrimaryKeySelective(ShipAddress record);

	int updateByPrimaryKey(ShipAddress record);

	List<ShipAddressBO> queryShipAddress(@Param("saType") Integer saType,
			@Param("page") MyPage<ShipAddressBO> page);

	ShipAddressBO queryShipAddressById(@Param("id") Long id);

	List<ShipAddress> selectBySaType(@Param("saType") Integer saType);

	List<ShipAddressBO> findAllByCondition(@Param("saType") Integer saType, @Param("saUserId") Long saUserId,
			@Param("saDefault") Boolean saDefault);

	List<ShipAddressBO> findPageByVo(MyPage<ShipAddressBO> page, @Param("vo") ShipAddressVO vo);

}