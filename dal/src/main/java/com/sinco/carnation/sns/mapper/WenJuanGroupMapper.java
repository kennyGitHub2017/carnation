package com.sinco.carnation.sns.mapper;

import com.sinco.carnation.sns.bo.WenJuanGroupBO;
import com.sinco.carnation.sns.model.WenJuanGroup;
import com.sinco.carnation.sns.model.WenJuanGroupExample;
import com.sinco.carnation.sns.vo.WenJuanGroupVO;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface WenJuanGroupMapper {

	int countByExample(WenJuanGroupExample example);

	int deleteByExample(WenJuanGroupExample example);

	int deleteByPrimaryKey(Long id);

	int insert(WenJuanGroup record);

	int insertSelective(WenJuanGroup record);

	List<WenJuanGroupBO> selectByExample(WenJuanGroupExample example);

	WenJuanGroupBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") WenJuanGroup record,
			@Param("example") WenJuanGroupExample example);

	int updateByExample(@Param("record") WenJuanGroup record, @Param("example") WenJuanGroupExample example);

	int updateByPrimaryKeySelective(WenJuanGroup record);

	int updateByPrimaryKey(WenJuanGroup record);

	/**
	 * 获取ID集合
	 */
	public List<Long> getGropIDList();

	/**
	 * 获取问卷题
	 */
	public List<WenJuanGroupBO> getWenJuanGroupAll(WenJuanGroup obj);

	/**
	 * 获取所有问卷题(分页)
	 * 
	 * @param page
	 * @param vo
	 * @return
	 */
	public List<WenJuanGroupBO> findByPage(MyPage<WenJuanGroupVO> page, @Param("obj") WenJuanGroupVO vo);

	public int updateByID(@Param("obj") WenJuanGroupVO vo);
}