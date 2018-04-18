package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.bo.ShopQrServerInfoBO;
import com.sinco.carnation.shop.model.ShopQrServerInfo;
import com.sinco.carnation.shop.model.ShopQrServerInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopQrServerInfoMapper {
	int countByExample(ShopQrServerInfoExample example);

	int deleteByExample(ShopQrServerInfoExample example);

	int deleteByPrimaryKey(Long id);

	int insert(ShopQrServerInfo record);

	int insertSelective(ShopQrServerInfo record);

	List<ShopQrServerInfoBO> selectByExample(ShopQrServerInfoExample example);

	ShopQrServerInfoBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") ShopQrServerInfo record,
			@Param("example") ShopQrServerInfoExample example);

	int updateByExample(@Param("record") ShopQrServerInfo record,
			@Param("example") ShopQrServerInfoExample example);

	int updateByPrimaryKeySelective(ShopQrServerInfo record);

	int updateByPrimaryKey(ShopQrServerInfo record);
}