package com.sinco.carnation.user.mapper;

import com.sinco.carnation.user.model.CustomerFavorites;
import com.sinco.carnation.user.model.CustomerFavoritesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerFavoritesMapper {
	int countByExample(CustomerFavoritesExample example);

	int deleteByExample(CustomerFavoritesExample example);

	int deleteByPrimaryKey(Long id);

	int insert(CustomerFavorites record);

	int insertSelective(CustomerFavorites record);

	List<CustomerFavorites> selectByExample(CustomerFavoritesExample example);

	CustomerFavorites selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") CustomerFavorites record,
			@Param("example") CustomerFavoritesExample example);

	int updateByExample(@Param("record") CustomerFavorites record,
			@Param("example") CustomerFavoritesExample example);

	int updateByPrimaryKeySelective(CustomerFavorites record);

	int updateByPrimaryKey(CustomerFavorites record);
}