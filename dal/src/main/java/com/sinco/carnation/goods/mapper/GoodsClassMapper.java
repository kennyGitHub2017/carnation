package com.sinco.carnation.goods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.carnation.goods.model.GoodsClass;
import com.sinco.carnation.goods.model.GoodsClassExample;
import com.sinco.carnation.goods.vo.GoodsClassCountVO;
import com.sinco.data.core.Page;

public interface GoodsClassMapper {

	List<GoodsClassBO> findRelatedGoodsClass(@Param("level") Integer level,
			@Param("className") String className);

	List<GoodsClassBO> findBySpec(Long specId);

	List<GoodsClassBO> findBySpecAndClassId(@Param("specId") Long specId, @Param("classId") Long classId);

	List<GoodsClassBO> findParentIsNullPage(@Param("page") Page<GoodsClassBO> page);

	List<GoodsClassBO> findByParent(@Param("parentId") Long parentId);

	List<GoodsClassBO> findByCount(GoodsClassCountVO vo);
	List<GoodsClassBO> findByCountVO(GoodsClassCountVO vo);

	List<GoodsClassBO> selectBOByExample(GoodsClassExample example);

	GoodsClassBO selectBOByPrimaryKey(Long id);

	int countByExample(GoodsClassExample example);

	int deleteByExample(GoodsClassExample example);

	int deleteByPrimaryKey(Long id);

	int insert(GoodsClass record);

	int insertSelective(GoodsClass record);

	List<GoodsClass> selectByExampleWithBLOBs(GoodsClassExample example);

	List<GoodsClass> selectByExample(GoodsClassExample example);

	GoodsClass selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") GoodsClass record,
			@Param("example") GoodsClassExample example);

	int updateByExampleWithBLOBs(@Param("record") GoodsClass record,
			@Param("example") GoodsClassExample example);

	int updateByExample(@Param("record") GoodsClass record, @Param("example") GoodsClassExample example);

	int updateByPrimaryKeySelective(GoodsClass record);

	int updateByPrimaryKeyWithBLOBs(GoodsClass record);

	int updateByPrimaryKey(GoodsClass record);

	GoodsClassBO selectBoWithParentByPrimaryKey(Long id);

	List<GoodsClassBO> findGoodsClassByLevel(@Param("level") Integer level);
	
	String findBnameById(@Param("id") String id);
}