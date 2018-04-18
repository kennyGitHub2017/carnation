package com.sinco.carnation.market.mapper;

import com.sinco.carnation.market.bo.ActivitySaleMessageTemplateBO;
import com.sinco.carnation.market.model.ActivitySaleMessageTemplate;
import com.sinco.carnation.market.model.ActivitySaleMessageTemplateExample;
import com.sinco.carnation.market.vo.ActivitySaleMessageTemplateVO;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ActivitySaleMessageTemplateMapper {
	int countByExample(ActivitySaleMessageTemplateExample example);

	int deleteByExample(ActivitySaleMessageTemplateExample example);

	int deleteByPrimaryKey(Long id);

	int insert(ActivitySaleMessageTemplate record);

	int insertSelective(ActivitySaleMessageTemplate record);

	List<ActivitySaleMessageTemplateBO> selectByExampleWithBLOBs(ActivitySaleMessageTemplateExample example);

	List<ActivitySaleMessageTemplateBO> selectByExample(ActivitySaleMessageTemplateExample example);

	ActivitySaleMessageTemplateBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") ActivitySaleMessageTemplate record,
			@Param("example") ActivitySaleMessageTemplateExample example);

	int updateByExampleWithBLOBs(@Param("record") ActivitySaleMessageTemplate record,
			@Param("example") ActivitySaleMessageTemplateExample example);

	int updateByExample(@Param("record") ActivitySaleMessageTemplate record,
			@Param("example") ActivitySaleMessageTemplateExample example);

	int updateByPrimaryKeySelective(ActivitySaleMessageTemplate record);

	int updateByPrimaryKeyWithBLOBs(ActivitySaleMessageTemplate record);

	int updateByPrimaryKey(ActivitySaleMessageTemplate record);

	List<ActivitySaleMessageTemplateBO> findAllByPage(@Param("vo") ActivitySaleMessageTemplateVO vo,
			MyPage<ActivitySaleMessageTemplateBO> page);
}