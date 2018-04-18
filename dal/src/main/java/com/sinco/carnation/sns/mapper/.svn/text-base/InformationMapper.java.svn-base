package com.sinco.carnation.sns.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.sns.bo.InformationBO;
import com.sinco.carnation.sns.model.Information;
import com.sinco.carnation.sns.model.InformationExample;
import com.sinco.carnation.sns.vo.InformationVO;
import com.sinco.dal.common.MyPage;

public interface InformationMapper {
	int countByExample(InformationExample example);

	int deleteByExample(InformationExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Information record);

	int insertSelective(Information record);

	List<Information> selectByExampleWithBLOBs(InformationExample example);

	List<Information> selectByExample(InformationExample example);

	List<InformationBO> selectBOByExample(InformationExample example);

	List<InformationBO> selectPageByClassId(@Param("classId") Long classId, MyPage<InformationBO> page);

	Information selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Information record,
			@Param("example") InformationExample example);

	int updateByExampleWithBLOBs(@Param("record") Information record,
			@Param("example") InformationExample example);

	int updateByExample(@Param("record") Information record, @Param("example") InformationExample example);

	int updateByPrimaryKeySelective(Information record);

	int updateByPrimaryKeyWithBLOBs(Information record);

	int updateByPrimaryKey(Information record);

	List<InformationBO> selectByList(@Param("vo") InformationVO vo, MyPage<InformationBO> page);

	InformationBO selectById(Long id);

	List<InformationBO> queryByIds(@Param("ids") Set<Long> ids);
}