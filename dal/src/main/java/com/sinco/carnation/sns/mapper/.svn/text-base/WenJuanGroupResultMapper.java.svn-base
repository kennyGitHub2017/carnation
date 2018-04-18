package com.sinco.carnation.sns.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.sns.bo.WenJuanGroupResultBO;
import com.sinco.carnation.sns.model.WenJuanGroupResult;
import com.sinco.carnation.sns.model.WenJuanGroupResultExample;
import com.sinco.carnation.sns.vo.WenJuanGroupResultVO;
import com.sinco.dal.common.MyPage;

public interface WenJuanGroupResultMapper {
	int countByExample(WenJuanGroupResultExample example);

	int deleteByExample(WenJuanGroupResultExample example);

	int deleteByPrimaryKey(Long id);

	int insert(WenJuanGroupResult record);

	int insertSelective(WenJuanGroupResult record);

	List<WenJuanGroupResultBO> selectByExample(WenJuanGroupResultExample example);

	WenJuanGroupResultBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") WenJuanGroupResult record,
			@Param("example") WenJuanGroupResultExample example);

	int updateByExample(@Param("record") WenJuanGroupResult record,
			@Param("example") WenJuanGroupResultExample example);

	int updateByPrimaryKeySelective(WenJuanGroupResult record);

	int updateByPrimaryKey(WenJuanGroupResult record);

	/**
	 * 根据题ID获取题分数设定范围
	 * 
	 * @param groupID
	 * @return
	 */
	public List<WenJuanGroupResultBO> select_groupResults_byGroupID(Long groupID);

	public List<WenJuanGroupResultBO> select_groupResults_byThemeID(Long groupID);

	public List<WenJuanGroupResultBO> findByPage(MyPage<WenJuanGroupResultVO> page,
			@Param("obj") WenJuanGroupResultVO vo);

	public WenJuanGroupResultBO selectMaxAndMinByThemeID(@Param("themeID") Long themeID);

	public WenJuanGroupResultBO selectMaxAndMinByGroupID(@Param("groupID") Long groupID);
}