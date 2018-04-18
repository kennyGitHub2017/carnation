package com.sinco.carnation.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.shop.bo.ShopBonusRepeatLogBO;
import com.sinco.carnation.shop.model.ShopBonusRepeatLog;
import com.sinco.carnation.shop.model.ShopBonusRepeatLogExample;
import com.sinco.carnation.shop.vo.ShopBonusRepeatLogVO;
import com.sinco.dal.common.MyPage;

public interface ShopBonusRepeatLogMapper {
	int countByExample(ShopBonusRepeatLogExample example);

	int deleteByExample(ShopBonusRepeatLogExample example);

	int deleteByPrimaryKey(Long id);

	int insert(ShopBonusRepeatLog record);

	int insertSelective(ShopBonusRepeatLog record);

	List<ShopBonusRepeatLogBO> selectByExample(ShopBonusRepeatLogExample example);

	ShopBonusRepeatLogBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") ShopBonusRepeatLog record,
			@Param("example") ShopBonusRepeatLogExample example);

	int updateByExample(@Param("record") ShopBonusRepeatLog record,
			@Param("example") ShopBonusRepeatLogExample example);

	int updateByPrimaryKeySelective(ShopBonusRepeatLog record);

	int updateByPrimaryKey(ShopBonusRepeatLog record);

	ShopBonusRepeatLog getByVo(@Param("vo") ShopBonusRepeatLog vo);

	List<ShopBonusRepeatLogBO> getByVo(@Param("vo") ShopBonusRepeatLogVO vo, MyPage<ShopBonusRepeatLogBO> page);

}