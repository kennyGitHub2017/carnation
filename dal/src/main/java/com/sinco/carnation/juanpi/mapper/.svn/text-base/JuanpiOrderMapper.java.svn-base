package com.sinco.carnation.juanpi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.juanpi.bo.JuanpiOrderBO;
import com.sinco.carnation.juanpi.model.JuanpiOrder;
import com.sinco.carnation.juanpi.model.JuanpiOrderExample;
import com.sinco.carnation.juanpi.vo.JuanpiOrderVO;
import com.sinco.dal.common.MyPage;

public interface JuanpiOrderMapper {
	int countByExample(JuanpiOrderExample example);

	int deleteByExample(JuanpiOrderExample example);

	int deleteByPrimaryKey(Long id);

	int insert(JuanpiOrder record);

	int insertSelective(JuanpiOrder record);

	List<JuanpiOrderBO> selectByExampleWithBLOBs(JuanpiOrderExample example);

	List<JuanpiOrderBO> selectByExample(JuanpiOrderExample example);

	JuanpiOrderBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") JuanpiOrder record,
			@Param("example") JuanpiOrderExample example);

	int updateByExampleWithBLOBs(@Param("record") JuanpiOrder record,
			@Param("example") JuanpiOrderExample example);

	int updateByExample(@Param("record") JuanpiOrder record, @Param("example") JuanpiOrderExample example);

	int updateByPrimaryKeySelective(JuanpiOrder record);

	int updateByPrimaryKeyWithBLOBs(JuanpiOrder record);

	int updateByPrimaryKey(JuanpiOrder record);

	List<JuanpiOrderBO> selectOrderListByVO(@Param("vo") JuanpiOrderVO vo, MyPage<JuanpiOrderBO> page);

	List<String> findUnsynOrderGroupByDate();

	List<JuanpiOrderBO> selectRebateByJuanPiOrderStatus();

	JuanpiOrder selectFindById(long id);
}