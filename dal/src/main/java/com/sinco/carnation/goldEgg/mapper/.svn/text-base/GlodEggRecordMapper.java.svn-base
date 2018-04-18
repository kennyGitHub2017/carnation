package com.sinco.carnation.goldEgg.mapper;

import com.sinco.carnation.goldEgg.bo.GlodEggRecordBO;
import com.sinco.carnation.goldEgg.model.GlodEggRecord;
import com.sinco.carnation.goldEgg.model.GlodEggRecordExample;

import java.math.BigDecimal;
import java.util.Date;
import com.sinco.carnation.goldEgg.vo.GlodEggRecordVO;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GlodEggRecordMapper {
	int countByExample(GlodEggRecordExample example);

	int deleteByExample(GlodEggRecordExample example);

	int deleteByPrimaryKey(Long id);

	int insert(GlodEggRecord record);

	int insertSelective(GlodEggRecord record);

	List<GlodEggRecordBO> selectByExample(GlodEggRecordExample example);

	GlodEggRecordBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") GlodEggRecord record,
			@Param("example") GlodEggRecordExample example);

	int updateByExample(@Param("record") GlodEggRecord record, @Param("example") GlodEggRecordExample example);

	int updateByPrimaryKeySelective(GlodEggRecord record);

	int updateByPrimaryKey(GlodEggRecord record);

	BigDecimal staticsCurrentGrantMoney(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

	public List<GlodEggRecordBO> findPageByVO(MyPage<GlodEggRecordBO> page, @Param("vo") GlodEggRecordVO vo);
}