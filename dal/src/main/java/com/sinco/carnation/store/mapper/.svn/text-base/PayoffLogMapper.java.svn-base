package com.sinco.carnation.store.mapper;

import com.sinco.carnation.store.bo.PayoffLogBO;
import com.sinco.carnation.store.model.PayoffLog;
import com.sinco.carnation.store.model.PayoffLogExample;
import com.sinco.carnation.store.vo.PayoffLogVO;
import com.sinco.dal.common.MyPage;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface PayoffLogMapper {
	int countByExample(PayoffLogExample example);

	int deleteByExample(PayoffLogExample example);

	int deleteByPrimaryKey(Long id);

	int insert(PayoffLog record);

	int insertSelective(PayoffLog record);

	PayoffLogBO selectBOByVO(@Param("id") Long id);

	List<PayoffLogBO> selectBOByOidAndOrderId(@Param("oid") String oid, @Param("orderId") String orderId);

	List<PayoffLogBO> selectPayoffLogListByVO(MyPage<PayoffLogBO> page, @Param("vo") PayoffLogVO vo);

	List<PayoffLogBO> selectShopPageListByVO(MyPage<PayoffLogBO> page, @Param("vo") PayoffLogVO vo);

	Map<String, Object> selectPayoffLogStatByVO(@Param("vo") PayoffLogVO vo);

	List<PayoffLogBO> selectByExampleWithBLOBs(PayoffLogExample example);

	List<PayoffLogBO> selectByExample(PayoffLogExample example);

	PayoffLogBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") PayoffLog record, @Param("example") PayoffLogExample example);

	int updateByExampleWithBLOBs(@Param("record") PayoffLog record, @Param("example") PayoffLogExample example);

	int updateByExample(@Param("record") PayoffLog record, @Param("example") PayoffLogExample example);

	int updateByPrimaryKeySelective(PayoffLog record);

	int updateByPrimaryKeyWithBLOBs(PayoffLog record);

	int updateByPrimaryKey(PayoffLog record);
}