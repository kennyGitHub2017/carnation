package com.sinco.carnation.store.mapper;

import com.sinco.carnation.store.bo.StoreNavigationBO;
import com.sinco.carnation.store.model.StoreNavigation;
import com.sinco.carnation.store.model.StoreNavigationExample;
import com.sinco.carnation.store.vo.StoreNavigationVO;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StoreNavigationMapper {
	int countByExample(StoreNavigationExample example);

	int deleteByExample(StoreNavigationExample example);

	int deleteByPrimaryKey(Long id);

	int insert(StoreNavigation record);

	int insertSelective(StoreNavigation record);

	List<StoreNavigationBO> selectByExampleWithBLOBs(StoreNavigationExample example);

	List<StoreNavigationBO> selectByExample(StoreNavigationExample example);

	StoreNavigationBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") StoreNavigation record,
			@Param("example") StoreNavigationExample example);

	int updateByExampleWithBLOBs(@Param("record") StoreNavigation record,
			@Param("example") StoreNavigationExample example);

	int updateByExample(@Param("record") StoreNavigation record,
			@Param("example") StoreNavigationExample example);

	int updateByPrimaryKeySelective(StoreNavigation record);

	int updateByPrimaryKeyWithBLOBs(StoreNavigation record);

	int updateByPrimaryKey(StoreNavigation record);

	List<StoreNavigationBO> findListByVo(@Param("page") MyPage<StoreNavigationBO> page,
			@Param("vo") StoreNavigationVO vo);
}