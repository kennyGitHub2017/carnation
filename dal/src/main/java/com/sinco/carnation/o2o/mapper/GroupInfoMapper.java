package com.sinco.carnation.o2o.mapper;

import com.sinco.carnation.o2o.bo.GroupInfoBO;
import com.sinco.carnation.o2o.model.GroupInfo;
import com.sinco.carnation.o2o.model.GroupInfoExample;
import com.sinco.carnation.o2o.vo.GroupInfoVO;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GroupInfoMapper {
	int countByExample(GroupInfoExample example);

	int deleteByExample(GroupInfoExample example);

	int deleteByPrimaryKey(Long id);

	int insert(GroupInfo record);

	int insertSelective(GroupInfo record);

	List<GroupInfoBO> selectByExample(GroupInfoExample example);

	List<GroupInfoBO> selectByApply(@Param("vo") GroupInfoVO vo, MyPage<GroupInfoBO> page);

	List<GroupInfoBO> selectGroupGoodsByOrderId(@Param("vo") GroupInfoVO vo);

	List<GroupInfoBO> selectByRefund(@Param("vo") GroupInfoVO vo, MyPage<GroupInfoBO> page);

	GroupInfoBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") GroupInfo record, @Param("example") GroupInfoExample example);

	int updateByExample(@Param("record") GroupInfo record, @Param("example") GroupInfoExample example);

	int updateByPrimaryKeySelective(GroupInfo record);

	int updateByPrimaryKey(GroupInfo record);

	List<GroupInfoBO> queryGroupInfoList(@Param("orderId") Long orderId);

	List<GroupInfoBO> findPageByStoreId(@Param("page") MyPage<GroupInfoBO> page, @Param("vo") GroupInfoVO vo);

	GroupInfoBO checkGroupSn(@Param("sellerUid") Long sellerUid, @Param("groupSn") String groupSn);

	List<GroupInfoBO> findExpiredGroupInfo(@Param("startTime") String startTime,
			@Param("endTime") String endTime);

	List<GroupInfoBO> checkMultiGroupSn(@Param("sellerUid") Long sellerUid,
			@Param("groupSnList") List<String> groupSnList);
	
	boolean changeReadStatus (@Param("record") GroupInfo record);
}