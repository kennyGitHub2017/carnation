package com.sinco.carnation.user.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.user.bo.AddressBO;
import com.sinco.carnation.user.model.Address;
import com.sinco.carnation.user.model.AddressExample;

public interface AddressMapper {
	int countByExample(AddressExample example);

	int deleteByExample(AddressExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Address record);

	int insertSelective(Address record);

	List<AddressBO> selectByExample(AddressExample example);

	@SuppressWarnings("rawtypes")
	List<Map> selectByTop100(@Param("userId") int userId);

	AddressBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressExample example);

	int updateByExample(@Param("record") Address record, @Param("example") AddressExample example);

	int updateByPrimaryKeySelective(Address record);

	int updateByPrimaryKey(Address record);

	Address getDefaultByUserId(Long id);

	public List<Address> queryByUserId(Long userId);
}