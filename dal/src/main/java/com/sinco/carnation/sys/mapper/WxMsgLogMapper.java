package com.sinco.carnation.sys.mapper;

import com.sinco.carnation.sys.bo.WxMsgLogBO;
import com.sinco.carnation.sys.model.WxMsgLog;
import com.sinco.carnation.sys.model.WxMsgLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxMsgLogMapper {
	int countByExample(WxMsgLogExample example);

	int deleteByExample(WxMsgLogExample example);

	int deleteByPrimaryKey(Long id);

	int insert(WxMsgLog record);

	int insertSelective(WxMsgLog record);

	List<WxMsgLogBO> selectByExampleWithBLOBs(WxMsgLogExample example);

	List<WxMsgLogBO> selectByExample(WxMsgLogExample example);

	WxMsgLogBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") WxMsgLog record, @Param("example") WxMsgLogExample example);

	int updateByExampleWithBLOBs(@Param("record") WxMsgLog record, @Param("example") WxMsgLogExample example);

	int updateByExample(@Param("record") WxMsgLog record, @Param("example") WxMsgLogExample example);

	int updateByPrimaryKeySelective(WxMsgLog record);

	int updateByPrimaryKeyWithBLOBs(WxMsgLog record);

	int updateByPrimaryKey(WxMsgLog record);
}