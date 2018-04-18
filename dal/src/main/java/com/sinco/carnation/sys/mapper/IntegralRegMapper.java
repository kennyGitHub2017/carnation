package com.sinco.carnation.sys.mapper;

import com.sinco.carnation.sys.bo.IntegralRegBO;
import com.sinco.carnation.sys.model.IntegralReg;
import com.sinco.carnation.sys.model.IntegralRegExample;
import com.sinco.carnation.sys.vo.IntegralRegVO;
import com.sinco.dal.common.MyPage;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IntegralRegMapper {
	int countByExample(IntegralRegExample example);

	int deleteByExample(IntegralRegExample example);

	int deleteByPrimaryKey(Long id);

	int insert(IntegralReg record);

	int insertSelective(IntegralReg record);

	List<IntegralRegBO> selectByExample(IntegralRegExample example);

	IntegralRegBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") IntegralReg record,
			@Param("example") IntegralRegExample example);

	int updateByExample(@Param("record") IntegralReg record, @Param("example") IntegralRegExample example);

	int updateByPrimaryKeySelective(IntegralReg record);

	int updateByPrimaryKey(IntegralReg record);

	List<IntegralRegBO> selectListByVO(MyPage<IntegralRegBO> page, @Param("vo") IntegralRegVO vo);

	List<IntegralRegBO> checkIntegral(@Param("vo") IntegralRegVO vo);

	List<IntegralRegBO> selectRegByUserid(Long userid);

	List<IntegralRegBO> selectOtherRegByUserid(Long userid);

	int changeShow();
	
	List<IntegralRegBO> selectAllType();

}