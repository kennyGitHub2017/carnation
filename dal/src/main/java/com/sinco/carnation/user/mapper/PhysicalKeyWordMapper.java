package com.sinco.carnation.user.mapper;

import com.sinco.carnation.user.bo.PhysicalKeyWordBO;
import com.sinco.carnation.user.bo.PhysicalKeyWordTypeBO;
import com.sinco.carnation.user.model.PhysicalKeyWord;
import com.sinco.carnation.user.model.PhysicalKeyWordExample;
import com.sinco.carnation.user.vo.PhysicalKeyWordVO;
import com.sinco.dal.common.MyPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PhysicalKeyWordMapper {
	int countByExample(PhysicalKeyWordExample example);

	int deleteByExample(PhysicalKeyWordExample example);

	int deleteByPrimaryKey(Long id);

	int insert(@Param("vo") PhysicalKeyWordVO vo);

	int insertSelective(PhysicalKeyWord record);

	List<PhysicalKeyWordBO> selectByExample(PhysicalKeyWordExample example);

	PhysicalKeyWordBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") PhysicalKeyWord record,
			@Param("example") PhysicalKeyWordExample example);

	int updateByExample(@Param("record") PhysicalKeyWord record,
			@Param("example") PhysicalKeyWordExample example);

	int updateByPrimaryKeySelective(PhysicalKeyWord record);

	int updateByPrimaryKey(PhysicalKeyWord record);

	List<PhysicalKeyWordBO> selectListByVo(@Param("vo") PhysicalKeyWordVO vo, MyPage<PhysicalKeyWordBO> Page);

	List<PhysicalKeyWordBO> selectAll();

	List<PhysicalKeyWordTypeBO> selectKeyWordTypeList();

	List<PhysicalKeyWord> findKeyWordByType(Integer type);

	/**
	 * 根据关联类型和关联表ID获取PhysicalKeyWord对象
	 * 
	 * @param typeCode
	 *            关联类型 1:体检建议 2:任务 3:帖子 4:商品 5:服务
	 * @param typeId
	 *            关联表的id
	 * 
	 * @return
	 */
	List<PhysicalKeyWord> findByTypeCodeAndId(@Param("typeCode") Long typeCode, @Param("typeId") Long typeId);
}