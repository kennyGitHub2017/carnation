package com.sinco.carnation.weChat.mapper;

import com.sinco.carnation.weChat.bo.WeChatAuthInfoBO;
import com.sinco.carnation.weChat.model.WeChatAuthInfo;
import com.sinco.carnation.weChat.model.WeChatAuthInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeChatAuthInfoMapper {
	int countByExample(WeChatAuthInfoExample example);

	int deleteByExample(WeChatAuthInfoExample example);

	int deleteByPrimaryKey(Long id);

	int insert(WeChatAuthInfo record);

	int insertSelective(WeChatAuthInfo record);

	List<WeChatAuthInfoBO> selectByExample(WeChatAuthInfoExample example);

	WeChatAuthInfoBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") WeChatAuthInfo record,
			@Param("example") WeChatAuthInfoExample example);

	int updateByExample(@Param("record") WeChatAuthInfo record,
			@Param("example") WeChatAuthInfoExample example);

	int updateByPrimaryKeySelective(WeChatAuthInfo record);

	int updateByPrimaryKey(WeChatAuthInfo record);

	public WeChatAuthInfoBO findOneByOpenID(@Param("openid") String openid);
}