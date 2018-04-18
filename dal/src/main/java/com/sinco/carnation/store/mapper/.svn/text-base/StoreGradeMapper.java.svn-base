package com.sinco.carnation.store.mapper;

import com.sinco.carnation.store.bo.StoreGradeBO;
import com.sinco.carnation.store.model.StoreGrade;
import com.sinco.carnation.store.model.StoreGradeExample;
import com.sinco.carnation.store.vo.StoreGradeVO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StoreGradeMapper {
	int countByExample(StoreGradeExample example);

	int deleteByExample(StoreGradeExample example);

	int deleteByPrimaryKey(Long id);

	int insert(StoreGrade record);

	int insertSelective(StoreGrade record);

	List<StoreGradeBO> selectByExampleWithBLOBs(StoreGradeExample example);

	List<StoreGradeBO> selectByExample(StoreGradeExample example);

	StoreGradeBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") StoreGrade record,
			@Param("example") StoreGradeExample example);

	int updateByExampleWithBLOBs(@Param("record") StoreGrade record,
			@Param("example") StoreGradeExample example);

	int updateByExample(@Param("record") StoreGrade record, @Param("example") StoreGradeExample example);

	int updateByPrimaryKeySelective(StoreGrade record);

	int updateByPrimaryKeyWithBLOBs(StoreGrade record);

	int updateByPrimaryKey(StoreGrade record);

	List<StoreGradeBO> findPageByVo(@Param("vo") StoreGradeVO vo);

	List<StoreGradeBO> queryStoreGradePageList();

	List<StoreGrade> findAllList();
}