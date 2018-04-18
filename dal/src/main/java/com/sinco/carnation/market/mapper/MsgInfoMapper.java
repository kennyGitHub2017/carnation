package com.sinco.carnation.market.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.market.bo.MsgInfoBO;
import com.sinco.carnation.market.model.MsgInfo;
import com.sinco.carnation.market.model.MsgInfoExample;
import com.sinco.carnation.market.vo.MsgInfoVO;
import com.sinco.dal.common.MyPage;

public interface MsgInfoMapper {
	int countByExample(MsgInfoExample example);

	int deleteByExample(MsgInfoExample example);

	int deleteByPrimaryKey(Long id);

	int insert(MsgInfo record);

	int insertSelective(MsgInfo record);

	List<MsgInfoBO> selectByExampleWithBLOBs(MsgInfoExample example);

	List<MsgInfoBO> selectByExample(MsgInfoExample example);

	MsgInfoBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") MsgInfo record, @Param("example") MsgInfoExample example);

	int updateByExampleWithBLOBs(@Param("record") MsgInfo record, @Param("example") MsgInfoExample example);

	int updateByExample(@Param("record") MsgInfo record, @Param("example") MsgInfoExample example);

	int updateByPrimaryKeySelective(MsgInfo record);

	int updateByPrimaryKeyWithBLOBs(MsgInfo record);

	int updateByPrimaryKey(MsgInfo record);

	List<MsgInfoBO> findListByVo(@Param("vo") MsgInfoVO vo, MyPage<MsgInfoBO> page);
}