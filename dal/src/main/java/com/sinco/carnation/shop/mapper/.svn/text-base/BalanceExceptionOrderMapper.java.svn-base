package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.bo.BalanceExceptionOrderBO;
import com.sinco.carnation.shop.model.BalanceExceptionOrder;
import com.sinco.carnation.shop.model.BalanceExceptionOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BalanceExceptionOrderMapper {
    int countByExample(BalanceExceptionOrderExample example);

    int deleteByExample(BalanceExceptionOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BalanceExceptionOrder record);

    int insertSelective(BalanceExceptionOrder record);

    List<BalanceExceptionOrderBO> selectByExampleWithBLOBs(BalanceExceptionOrderExample example);

    List<BalanceExceptionOrderBO> selectByExample(BalanceExceptionOrderExample example);

    BalanceExceptionOrderBO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BalanceExceptionOrder record, @Param("example") BalanceExceptionOrderExample example);

    int updateByExampleWithBLOBs(@Param("record") BalanceExceptionOrder record, @Param("example") BalanceExceptionOrderExample example);

    int updateByExample(@Param("record") BalanceExceptionOrder record, @Param("example") BalanceExceptionOrderExample example);

    int updateByPrimaryKeySelective(BalanceExceptionOrder record);

    int updateByPrimaryKeyWithBLOBs(BalanceExceptionOrder record);

    int updateByPrimaryKey(BalanceExceptionOrder record);
}