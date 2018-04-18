package com.sinco.carnation.sns.mapper;

import com.sinco.carnation.sns.model.CmsIndexTemplate;
import com.sinco.carnation.sns.model.CmsIndexTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsIndexTemplateMapper {
	int countByExample(CmsIndexTemplateExample example);

	int deleteByExample(CmsIndexTemplateExample example);

	int deleteByPrimaryKey(Long id);

	int insert(CmsIndexTemplate record);

	int insertSelective(CmsIndexTemplate record);

	List<CmsIndexTemplate> selectByExampleWithBLOBs(CmsIndexTemplateExample example);

	List<CmsIndexTemplate> selectByExample(CmsIndexTemplateExample example);

	CmsIndexTemplate selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") CmsIndexTemplate record,
			@Param("example") CmsIndexTemplateExample example);

	int updateByExampleWithBLOBs(@Param("record") CmsIndexTemplate record,
			@Param("example") CmsIndexTemplateExample example);

	int updateByExample(@Param("record") CmsIndexTemplate record,
			@Param("example") CmsIndexTemplateExample example);

	int updateByPrimaryKeySelective(CmsIndexTemplate record);

	int updateByPrimaryKeyWithBLOBs(CmsIndexTemplate record);

	int updateByPrimaryKey(CmsIndexTemplate record);
}