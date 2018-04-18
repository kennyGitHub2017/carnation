package com.sinco.carnation.sns.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.sns.model.AdvertPosition;
import com.sinco.carnation.sns.model.AdvertPositionExample;
import com.sinco.carnation.sns.vo.AdvertPositionVO;
import com.sinco.dal.common.MyPage;

public interface AdvertPositionMapper {
	int countByExample(AdvertPositionExample example);

	int deleteByExample(AdvertPositionExample example);

	int deleteByPrimaryKey(Long id);

	int insert(AdvertPosition record);

	int insertSelective(AdvertPosition record);

	List<AdvertPosition> selectByExampleWithBLOBs(AdvertPositionExample example);

	List<AdvertPosition> selectByExample(AdvertPositionExample example);

	List<AdvertPosition> findByRelease(@Param("releaseType") int releaseType);

	AdvertPosition selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") AdvertPosition record,
			@Param("example") AdvertPositionExample example);

	int updateByExampleWithBLOBs(@Param("record") AdvertPosition record,
			@Param("example") AdvertPositionExample example);

	int updateByExample(@Param("record") AdvertPosition record,
			@Param("example") AdvertPositionExample example);

	int updateByPrimaryKeySelective(AdvertPosition record);

	int updateByPrimaryKeyWithBLOBs(AdvertPosition record);

	int updateByPrimaryKey(AdvertPosition record);

	List<AdvertPosition> selectListByVo(@Param("vo") AdvertPositionVO vo, MyPage<AdvertPosition> page);

	List<AdvertPosition> selectList();

	int updateStatusById(@Param("status") int status, @Param("id") int id);
}