package com.sinco.carnation.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.user.bo.PhysicalValuationBO;
import com.sinco.carnation.user.model.PhysicalValuation;
import com.sinco.carnation.user.model.PhysicalValuationExample;
import com.sinco.carnation.user.vo.PhysicalValuationVO;
import com.sinco.dal.common.MyPage;

public interface PhysicalValuationMapper {
	int countByExample(PhysicalValuationExample example);

	int deleteByExample(PhysicalValuationExample example);

	int deleteByPrimaryKey(Long id);

	int insertSelective(PhysicalValuation record);

	List<PhysicalValuationBO> selectByExampleWithBLOBs(PhysicalValuationExample example);

	List<PhysicalValuationBO> selectByExample(PhysicalValuationExample example);

	PhysicalValuationBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") PhysicalValuation record,
			@Param("example") PhysicalValuationExample example);

	int updateByExampleWithBLOBs(@Param("record") PhysicalValuation record,
			@Param("example") PhysicalValuationExample example);

	int updateByExample(@Param("record") PhysicalValuation record,
			@Param("example") PhysicalValuationExample example);

	int updateByPrimaryKeySelective(PhysicalValuation record);

	int updateByPrimaryKeyWithBLOBs(PhysicalValuation record);

	int updateByPrimaryKey(PhysicalValuation record);

	// kenny 02-07
	List<PhysicalValuationBO> selectListByVo(@Param("vo") PhysicalValuationVO vo,
			MyPage<PhysicalValuationBO> page);

	List<PhysicalValuationBO> selectList();

	int insert(@Param("vo") PhysicalValuationVO vo);

	/**
	 * 根据单个检测值查询对应结果
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	List<PhysicalValuationBO> selectCheckResultByVo(@Param("vo") PhysicalValuationVO vo,
			MyPage<PhysicalValuationBO> page);

}