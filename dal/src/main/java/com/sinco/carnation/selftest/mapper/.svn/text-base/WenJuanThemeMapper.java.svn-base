package com.sinco.carnation.selftest.mapper;

import com.sinco.carnation.selftest.bo.WenJuanThemeBO;
import com.sinco.carnation.selftest.model.WenJuanTheme;
import com.sinco.carnation.selftest.model.WenJuanThemeExample;
import com.sinco.carnation.selftest.vo.WenJuanThemeVO;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface WenJuanThemeMapper {
	int countByExample(WenJuanThemeExample example);

	int deleteByExample(WenJuanThemeExample example);

	int deleteByPrimaryKey(Long id);

	int insert(WenJuanTheme record);

	int insertSelective(WenJuanTheme record);

	List<WenJuanThemeBO> selectByExample(WenJuanThemeExample example);

	WenJuanThemeBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") WenJuanTheme record,
			@Param("example") WenJuanThemeExample example);

	int updateByExample(@Param("record") WenJuanTheme record, @Param("example") WenJuanThemeExample example);

	int updateByPrimaryKeySelective(WenJuanTheme record);

	int updateByPrimaryKey(WenJuanTheme record);

	public List<WenJuanThemeBO> findByPage(MyPage<WenJuanTheme> page, @Param("vo") WenJuanThemeVO vo);
}