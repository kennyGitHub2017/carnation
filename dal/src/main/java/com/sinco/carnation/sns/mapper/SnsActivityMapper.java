package com.sinco.carnation.sns.mapper;

import com.sinco.carnation.sns.bo.SnsActivityBO;
import com.sinco.carnation.sns.model.SnsActivity;
import com.sinco.carnation.sns.model.SnsActivityExample;
import com.sinco.carnation.sns.vo.SnsActivityVO;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SnsActivityMapper {
	int countByExample(SnsActivityExample example);

	int deleteByExample(SnsActivityExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SnsActivity record);

	int insertSelective(SnsActivity record);

	List<SnsActivityBO> selectByExampleWithBLOBs(SnsActivityExample example);

	List<SnsActivityBO> selectByExample(SnsActivityExample example);

	SnsActivityBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SnsActivity record,
			@Param("example") SnsActivityExample example);

	int updateByExampleWithBLOBs(@Param("record") SnsActivity record,
			@Param("example") SnsActivityExample example);

	int updateByExample(@Param("record") SnsActivity record, @Param("example") SnsActivityExample example);

	int updateByPrimaryKeySelective(SnsActivity record);

	int updateByPrimaryKeyWithBLOBs(SnsActivity record);

	int updateByPrimaryKey(SnsActivity record);

	List<SnsActivityBO> findTopAc(@Param("count") Long count, @Param("ord") Integer ord,
			@Param("isdel") Integer isdel);

	List<SnsActivityBO> selectListByVo(@Param("vo") SnsActivityVO vo, MyPage<SnsActivityBO> page);

	public List<SnsActivityBO> findbyVO(@Param("vo") SnsActivityVO vo, MyPage<SnsActivityBO> page,
			@Param("count") Integer count, @Param("isdel") Integer isdel);

}