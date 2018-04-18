package com.sinco.carnation.sys.mapper;

import com.sinco.carnation.sys.bo.TemplateBO;
import com.sinco.carnation.sys.model.Template;
import com.sinco.carnation.sys.model.TemplateExample;
import com.sinco.carnation.sys.vo.TemplateVO;
import com.sinco.dal.common.MyPage;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TemplateMapper {
	int countByExample(TemplateExample example);

	int deleteByExample(TemplateExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Template record);

	int insertSelective(Template record);

	List<TemplateBO> selectByExampleWithBLOBs(TemplateExample example);

	List<TemplateBO> selectByExample(TemplateExample example);

	TemplateBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Template record, @Param("example") TemplateExample example);

	int updateByExampleWithBLOBs(@Param("record") Template record, @Param("example") TemplateExample example);

	int updateByExample(@Param("record") Template record, @Param("example") TemplateExample example);

	int updateByPrimaryKeySelective(Template record);

	int updateByPrimaryKeyWithBLOBs(Template record);

	int updateByPrimaryKey(Template record);

	List<TemplateBO> selectListByVO(MyPage<TemplateBO> page, @Param("vo") TemplateVO vo);
}