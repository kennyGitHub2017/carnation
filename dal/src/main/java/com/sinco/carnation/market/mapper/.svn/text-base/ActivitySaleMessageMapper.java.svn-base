package com.sinco.carnation.market.mapper;

import com.sinco.carnation.market.bo.ActivitySaleMessageBO;
import com.sinco.carnation.market.model.ActivitySaleMessage;
import com.sinco.carnation.market.model.ActivitySaleMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivitySaleMessageMapper {
    int countByExample(ActivitySaleMessageExample example);

    int deleteByExample(ActivitySaleMessageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActivitySaleMessage record);

    int insertSelective(ActivitySaleMessage record);

    List<ActivitySaleMessageBO> selectByExample(ActivitySaleMessageExample example);

    ActivitySaleMessageBO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActivitySaleMessage record, @Param("example") ActivitySaleMessageExample example);

    int updateByExample(@Param("record") ActivitySaleMessage record, @Param("example") ActivitySaleMessageExample example);

    int updateByPrimaryKeySelective(ActivitySaleMessage record);

    int updateByPrimaryKey(ActivitySaleMessage record);
}