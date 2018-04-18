package com.sinco.carnation.sys.mapper;

import com.sinco.carnation.sys.bo.AreaAdBO;
import com.sinco.carnation.sys.model.AreaAd;
import com.sinco.carnation.sys.model.AreaAdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AreaAdMapper {
    int countByExample(AreaAdExample example);

    int deleteByExample(AreaAdExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AreaAd record);

    int insertSelective(AreaAd record);

    List<AreaAdBO> selectByExample(AreaAdExample example);

    AreaAdBO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AreaAd record, @Param("example") AreaAdExample example);

    int updateByExample(@Param("record") AreaAd record, @Param("example") AreaAdExample example);

    int updateByPrimaryKeySelective(AreaAd record);

    int updateByPrimaryKey(AreaAd record);
    
}