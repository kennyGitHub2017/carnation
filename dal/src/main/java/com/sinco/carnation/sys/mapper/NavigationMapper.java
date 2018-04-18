package com.sinco.carnation.sys.mapper;

import com.sinco.carnation.sys.bo.NavigationBO;
import com.sinco.carnation.sys.model.Navigation;
import com.sinco.carnation.sys.model.NavigationExample;
import com.sinco.dal.common.MyPage;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface NavigationMapper {

	List<NavigationBO> findByLocation(@Param("location") Integer location, @Param("count") Integer count,
			@Param("notType") String notType);

	int countByExample(NavigationExample example);

	int deleteByExample(NavigationExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Navigation record);

	int insertSelective(Navigation record);

	@SuppressWarnings("rawtypes")
	List<Map> selectByTitle(@Param("title") String title, MyPage<Map> page);

	List<NavigationBO> selectByExample(NavigationExample example);

	NavigationBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Navigation record,
			@Param("example") NavigationExample example);

	int updateByExample(@Param("record") Navigation record, @Param("example") NavigationExample example);

	int updateByPrimaryKeySelective(Navigation record);

	int updateByPrimaryKey(Navigation record);
}