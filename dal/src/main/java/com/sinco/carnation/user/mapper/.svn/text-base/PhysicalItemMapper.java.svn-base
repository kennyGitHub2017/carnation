package com.sinco.carnation.user.mapper;

import com.sinco.carnation.user.bo.PhysicalItemBO;
import com.sinco.carnation.user.model.PhysicalItem;
import com.sinco.carnation.user.model.PhysicalItemExample;
import com.sinco.carnation.user.vo.PhysicalItemVO;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PhysicalItemMapper {
	int countByExample(PhysicalItemExample example);

	int deleteByExample(PhysicalItemExample example);

	int deleteByPrimaryKey(Long id);

	int insert(PhysicalItem record);

	int insertSelective(PhysicalItem record);

	List<PhysicalItemBO> selectByExample(PhysicalItemExample example);

	PhysicalItemBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") PhysicalItem record,
			@Param("example") PhysicalItemExample example);

	int updateByExample(@Param("record") PhysicalItem record, @Param("example") PhysicalItemExample example);

	int updateByPrimaryKeySelective(PhysicalItem record);

	int updateByPrimaryKey(PhysicalItem record);

	List<PhysicalItemBO> selectListByVo(PhysicalItemVO vo, MyPage<PhysicalItemBO> page);
}