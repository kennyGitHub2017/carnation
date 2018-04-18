package com.sinco.carnation.juanpi.mapper;

import com.sinco.carnation.juanpi.bo.JuanpiGoodsClassBO;
import com.sinco.carnation.juanpi.model.JuanpiGoodsClass;
import com.sinco.carnation.juanpi.model.JuanpiGoodsClassExample;
import com.sinco.carnation.juanpi.vo.JuanpiGoodsClassVO;
import com.sinco.dal.common.MyPage;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface JuanpiGoodsClassMapper {
	int countByExample(JuanpiGoodsClassExample example);

	int deleteByExample(JuanpiGoodsClassExample example);

	int deleteByPrimaryKey(Long id);

	int insert(JuanpiGoodsClass record);

	int insertSelective(JuanpiGoodsClass record);

	List<JuanpiGoodsClassBO> selectByExample(JuanpiGoodsClassExample example);

	JuanpiGoodsClassBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") JuanpiGoodsClass record,
			@Param("example") JuanpiGoodsClassExample example);

	int updateByExample(@Param("record") JuanpiGoodsClass record,
			@Param("example") JuanpiGoodsClassExample example);

	int updateByPrimaryKeySelective(JuanpiGoodsClass record);

	int updateByPrimaryKey(JuanpiGoodsClass record);

	int synClass(JuanpiGoodsClass cls);
	
	List<JuanpiGoodsClassBO> pageByVO(@Param("page") MyPage<JuanpiGoodsClassBO> page,
			@Param("vo") JuanpiGoodsClassVO vo);

	void deleteUnsynJuanpiClass(@Param("lastUpdateTime") Date lastUpdateTime);

	List<JuanpiGoodsClassBO> listByLevelId(@Param("level")String level ,@Param("classId") Long classId ,@Param("isJoin") Integer isJoin);
	
}