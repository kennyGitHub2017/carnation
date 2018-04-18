package com.sinco.carnation.goldEgg.mapper;

import com.sinco.carnation.goldEgg.bo.ActGlodEggBO;
import com.sinco.carnation.goldEgg.model.ActGlodEgg;
import com.sinco.carnation.goldEgg.model.ActGlodEggExample;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActGlodEggMapper {
	int countByExample(ActGlodEggExample example);

	int deleteByExample(ActGlodEggExample example);

	int deleteByPrimaryKey(Long id);

	int insert(ActGlodEgg record);

	int insertSelective(ActGlodEgg record);

	List<ActGlodEggBO> selectByExample(ActGlodEggExample example);

	ActGlodEggBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") ActGlodEgg record,
			@Param("example") ActGlodEggExample example);

	int updateByExample(@Param("record") ActGlodEgg record, @Param("example") ActGlodEggExample example);

	int updateByPrimaryKeySelective(ActGlodEgg record);

	int updateByPrimaryKey(ActGlodEgg record);

	void addCurrentGetMoney(@Param("id") Long id, @Param("money") BigDecimal money);

	public ActGlodEgg findByActID(@Param("obj") ActGlodEgg record);

	public List<ActGlodEggBO> findListByActID(@Param("act_id") Long act_id);
}