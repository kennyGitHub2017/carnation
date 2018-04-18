package com.sinco.carnation.market.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.market.bo.RedPackageGetRecordBO;
import com.sinco.carnation.market.model.RedPackageGetRecord;
import com.sinco.carnation.market.model.RedPackageGetRecordExample;
import com.sinco.carnation.market.vo.RedPackageGetRecordVO;
import com.sinco.dal.common.MyPage;

public interface RedPackageGetRecordMapper {
	int countByExample(RedPackageGetRecordExample example);

	int deleteByExample(RedPackageGetRecordExample example);

	int deleteByPrimaryKey(Long id);

	int insert(RedPackageGetRecord record);

	int insertSelective(RedPackageGetRecord record);

	List<RedPackageGetRecordBO> selectByExample(RedPackageGetRecordExample example);

	RedPackageGetRecordBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") RedPackageGetRecord record,
			@Param("example") RedPackageGetRecordExample example);

	int updateByExample(@Param("record") RedPackageGetRecord record,
			@Param("example") RedPackageGetRecordExample example);

	int updateByPrimaryKeySelective(RedPackageGetRecord record);

	int updateByPrimaryKey(RedPackageGetRecord record);

	// 根据红包id更新信息
	int updateActRedPacketRecord(RedPackageGetRecordVO vo);

	int updateByCookieIdandPacketId(RedPackageGetRecord vo);

	RedPackageGetRecordBO findRedPackageByPhone(@Param("phone") String phone,
			@Param("packageId") Long packageId);

	List<RedPackageGetRecordBO> getActRedPacketRecordUserList(RedPackageGetRecordVO vo);

	List<RedPackageGetRecordBO> findAllByPage(@Param("vo") RedPackageGetRecordVO vo,
			MyPage<RedPackageGetRecordBO> page);

	// 已领取金额
	Float getSumMoney(Long id);
}