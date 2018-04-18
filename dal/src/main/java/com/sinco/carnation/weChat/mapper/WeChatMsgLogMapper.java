package com.sinco.carnation.weChat.mapper;

import com.sinco.carnation.weChat.bo.WeChatMsgLogBO;
import com.sinco.carnation.weChat.model.WeChatMsgLog;
import com.sinco.carnation.weChat.model.WeChatMsgLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeChatMsgLogMapper {
	int countByExample(WeChatMsgLogExample example);

	int deleteByExample(WeChatMsgLogExample example);

	int deleteByPrimaryKey(Long id);

	int insert(WeChatMsgLog record);

	int insertSelective(WeChatMsgLog record);

	List<WeChatMsgLogBO> selectByExampleWithBLOBs(WeChatMsgLogExample example);

	List<WeChatMsgLogBO> selectByExample(WeChatMsgLogExample example);

	WeChatMsgLogBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") WeChatMsgLog record,
			@Param("example") WeChatMsgLogExample example);

	int updateByExampleWithBLOBs(@Param("record") WeChatMsgLog record,
			@Param("example") WeChatMsgLogExample example);

	int updateByExample(@Param("record") WeChatMsgLog record, @Param("example") WeChatMsgLogExample example);

	int updateByPrimaryKeySelective(WeChatMsgLog record);

	int updateByPrimaryKeyWithBLOBs(WeChatMsgLog record);

	int updateByPrimaryKey(WeChatMsgLog record);
}