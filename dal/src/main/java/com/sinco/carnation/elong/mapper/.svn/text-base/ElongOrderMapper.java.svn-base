package com.sinco.carnation.elong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.elong.bo.ElongOrderBO;
import com.sinco.carnation.elong.model.ElongOrder;
import com.sinco.carnation.elong.vo.ElongOrderVO;
import com.sinco.dal.common.MyPage;

public interface ElongOrderMapper {
	List<ElongOrder> selectRebateByElongOrderStatus();
	List<ElongOrder> queryElongOrderlist(@Param("userId") Long userId, @Param("page") MyPage<ElongOrderBO> page);

	List<ElongOrder> querySynOrderList();

	int updateByPrimaryKeySelective(ElongOrder record);

	int insertSelective(ElongOrder record);

	ElongOrder selectByPrimaryKey(Long id);

	ElongOrder selectByOrderId(Long orderId);
	
	List<ElongOrderBO> findElongOrderVOs(@Param("vo") ElongOrderVO vo,MyPage<ElongOrderBO> page);
}