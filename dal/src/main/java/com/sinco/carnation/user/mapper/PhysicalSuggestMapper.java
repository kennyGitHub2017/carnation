package com.sinco.carnation.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.user.bo.PhysicalSuggestBO;
import com.sinco.carnation.user.model.PhysicalSuggest;
import com.sinco.carnation.user.model.PhysicalSuggestExample;
import com.sinco.carnation.user.vo.PhysicalSuggestVO;
import com.sinco.dal.common.MyPage;

public interface PhysicalSuggestMapper {
	int countByExample(PhysicalSuggestExample example);

	int deleteByExample(PhysicalSuggestExample example);

	int deleteByPrimaryKey(Long id);

	int insert(PhysicalSuggestVO vo);

	int insertSelective(PhysicalSuggest record);

	List<PhysicalSuggestBO> selectByExampleWithBLOBs(PhysicalSuggestExample example);

	List<PhysicalSuggestBO> selectByExample(PhysicalSuggestExample example);

	PhysicalSuggestBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") PhysicalSuggest record,
			@Param("example") PhysicalSuggestExample example);

	int updateByExampleWithBLOBs(@Param("record") PhysicalSuggest record,
			@Param("example") PhysicalSuggestExample example);

	int updateByExample(@Param("record") PhysicalSuggest record,
			@Param("example") PhysicalSuggestExample example);

	int updateByPrimaryKeySelective(PhysicalSuggestVO record);

	int updateByPrimaryKeyWithBLOBs(PhysicalSuggest record);

	int updateByPrimaryKey(PhysicalSuggest record);

	List<PhysicalSuggestBO> selectListByVo(@Param("vo") PhysicalSuggestVO vo, MyPage<PhysicalSuggestBO> page);

	List<PhysicalSuggestBO> queryPhysicalSuggestByCond(@Param("vo") PhysicalSuggestVO vo);

	/*List<PhysicalSuggestBO> queryPhySuggestAndTaskByCond(@Param("vo") PhysicalSuggestVO suggestVO);*/
}