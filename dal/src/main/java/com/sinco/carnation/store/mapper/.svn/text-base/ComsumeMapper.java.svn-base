package com.sinco.carnation.store.mapper;

import com.sinco.carnation.store.bo.ComsumeBO;
import com.sinco.carnation.store.model.Comsume;
import com.sinco.carnation.store.model.ComsumeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComsumeMapper {
	int countByExample(ComsumeExample example);

	int deleteByExample(ComsumeExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Comsume record);

	int insertSelective(Comsume record);

	List<ComsumeBO> selectByExample(ComsumeExample example);

	ComsumeBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Comsume record, @Param("example") ComsumeExample example);

	int updateByExample(@Param("record") Comsume record, @Param("example") ComsumeExample example);

	int updateByPrimaryKeySelective(Comsume record);

	int updateByPrimaryKey(Comsume record);
}