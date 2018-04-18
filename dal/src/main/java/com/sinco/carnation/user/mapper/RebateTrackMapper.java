package com.sinco.carnation.user.mapper;

import com.sinco.carnation.user.bo.RebateTrackBO;
import com.sinco.carnation.user.model.RebateTrack;
import com.sinco.carnation.user.model.RebateTrackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RebateTrackMapper {
	int countByExample(RebateTrackExample example);

	int deleteByExample(RebateTrackExample example);

	int deleteByPrimaryKey(Long id);

	int insert(RebateTrack record);

	int insertSelective(RebateTrack record);

	List<RebateTrackBO> selectByExample(RebateTrackExample example);

	RebateTrackBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") RebateTrack record,
			@Param("example") RebateTrackExample example);

	int updateByExample(@Param("record") RebateTrack record, @Param("example") RebateTrackExample example);

	int updateByPrimaryKeySelective(RebateTrack record);

	int updateByPrimaryKey(RebateTrack record);
}