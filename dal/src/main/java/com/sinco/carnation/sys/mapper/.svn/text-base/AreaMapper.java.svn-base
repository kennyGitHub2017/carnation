package com.sinco.carnation.sys.mapper;

import com.sinco.carnation.sys.bo.AreaBO;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.model.AreaExample;
import com.sinco.dal.common.MyPage;
import com.sinco.data.core.Page;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AreaMapper {
	int countByExample(AreaExample example);

	int deleteByExample(AreaExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Area record);

	int insertSelective(Area record);

	List<Area> selectByExample(AreaExample example);

	@SuppressWarnings("rawtypes")
	List<Map> selectByProvince();

	Area findParentById(Long id);

	Area selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Area record, @Param("example") AreaExample example);

	int updateByExample(@Param("record") Area record, @Param("example") AreaExample example);

	int updateByPrimaryKeySelective(Area record);

	int updateByPrimaryKey(Area record);

	List<Area> queryAreaByParentId(@Param("parentId") Long parentId);

	List<Area> queryParentArea();

	public List<Area> queryAreaList(@Param("pid") Long pid, MyPage<Area> page);

	public List<AreaBO> findGroupHotCityByPage(@Param("page") Page<AreaBO> page);

	public List<Area> queryAreaByName(@Param("areaName") String areaName);

	public Area queryAreaByPidAndName(@Param("parentId") Long parentId, @Param("areaName") String areaName);

	public AreaBO selectNameByAreaId(@Param("areaId") Long areaId);
}