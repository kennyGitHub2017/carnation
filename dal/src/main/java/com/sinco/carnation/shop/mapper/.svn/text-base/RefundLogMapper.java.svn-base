package com.sinco.carnation.shop.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.shop.bo.RefundLogBO;
import com.sinco.carnation.shop.model.RefundLog;
import com.sinco.carnation.shop.model.RefundLogExample;
import com.sinco.carnation.shop.vo.RefundLogVO;
import com.sinco.dal.common.MyPage;

public interface RefundLogMapper {
	int countByExample(RefundLogExample example);

	int deleteByExample(RefundLogExample example);

	int deleteByPrimaryKey(Long id);

	int insert(RefundLog record);

	int insertSelective(RefundLog record);

	List<RefundLogBO> selectByExample(RefundLogExample example);

	@SuppressWarnings("rawtypes")
	List<Map> search(@Param("vo") RefundLogVO vo, MyPage<Map> page);

	RefundLogBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") RefundLog record, @Param("example") RefundLogExample example);

	int updateByExample(@Param("record") RefundLog record, @Param("example") RefundLogExample example);

	int updateByPrimaryKeySelective(RefundLog record);

	int updateByPrimaryKey(RefundLog record);
}