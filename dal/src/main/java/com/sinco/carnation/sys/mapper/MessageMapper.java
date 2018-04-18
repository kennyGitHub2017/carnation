package com.sinco.carnation.sys.mapper;

import com.sinco.carnation.sys.bo.MessageBO;
import com.sinco.carnation.sys.model.Message;
import com.sinco.carnation.sys.model.MessageExample;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MessageMapper {
	int countByExample(MessageExample example);

	int deleteByExample(MessageExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Message record);

	int insertSelective(Message record);

	int markRead(@Param("messageId") long messageId, @Param("toUserId") long toUserId);

	List<MessageBO> selectByExampleWithBLOBs(MessageExample example);

	List<MessageBO> selectByExample(MessageExample example);

	List<MessageBO> selectByUser(@Param("userId") Long userId, @Param("type") String type,
			MyPage<MessageBO> page);

	List<MessageBO> selectByParent(@Param("parentId") Long parentId, MyPage<MessageBO> page);

	List<MessageBO> forCountAll(@Param("userId") Long userId);

	List<MessageBO> forCountA(@Param("userId") Long userId);

	List<MessageBO> forCountB(@Param("userId") Long userId);

	List<MessageBO> forCountC(@Param("userId") Long userId);

	MessageBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageExample example);

	int updateByExampleWithBLOBs(@Param("record") Message record, @Param("example") MessageExample example);

	int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);

	int updateByPrimaryKeySelective(Message record);

	int updateByPrimaryKeyWithBLOBs(Message record);

	int updateByPrimaryKey(Message record);

	// 随机排序
	int updateInvitationRand();

	int updateShopGoodsRand();

	int updateCheckGroupRand();
}