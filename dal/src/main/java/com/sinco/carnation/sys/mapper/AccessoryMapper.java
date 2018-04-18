package com.sinco.carnation.sys.mapper;

import com.sinco.carnation.sys.bo.AccessoryBO;
import com.sinco.carnation.sys.model.Accessory;
import com.sinco.carnation.sys.model.AccessoryExample;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AccessoryMapper {
	int countByExample(AccessoryExample example);

	int deleteByExample(AccessoryExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Accessory record);

	int insertSelective(Accessory record);

	List<Accessory> selectByExample(AccessoryExample example);

	List<Accessory> findByConfigId(Long configId);

	List<Accessory> selectGoodsPhontListByGoodsId(@Param("goodsId") Long goodsId);

	List<Accessory> selectGroupGoodsByGoodsId(@Param("goodsId") Long goodsId);

	Accessory selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Accessory record, @Param("example") AccessoryExample example);

	int updateByExample(@Param("record") Accessory record, @Param("example") AccessoryExample example);

	int updateByPrimaryKeySelective(Accessory record);

	int updateByPrimaryKey(Accessory record);

	int queryAlbumListCount(@Param("albumId") Long albumId, @Param("userId") Long userId);

	List<AccessoryBO> queryAccessoriesById(@Param("userId") Long userId, @Param("albumId") Long albumId,
			@Param("page") MyPage<AccessoryBO> page);

	int deleteAccessotyById(@Param("id") Long[] id);

	int updateAlbumTransfer(@Param("ids") Long[] ids, @Param("toAlbumId") Long toAlbumId,
			@Param("albumId") Long albumId);

	int accessoryDelByAlbumId(@Param("albumId") Long albumId);

	List<AccessoryBO> storeAccessoryList(@Param("albumId") Long albumId,
			@Param("page") MyPage<AccessoryBO> page);
}