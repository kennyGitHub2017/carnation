package com.sinco.carnation.notice.mapper;

import com.sinco.carnation.notice.bo.NoticeMessageBO;
import com.sinco.carnation.notice.model.NoticeMessage;
import com.sinco.carnation.notice.model.NoticeMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoticeMessageMapper {
	int countByExample(NoticeMessageExample example);

	int deleteByExample(NoticeMessageExample example);

	int deleteByPrimaryKey(Long id);

	int insert(NoticeMessage record);

	int insertSelective(NoticeMessage record);

	List<NoticeMessageBO> selectByExample(NoticeMessageExample example);

	NoticeMessageBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") NoticeMessage record,
			@Param("example") NoticeMessageExample example);

	int updateByExample(@Param("record") NoticeMessage record, @Param("example") NoticeMessageExample example);

	int updateByPrimaryKeySelective(NoticeMessage record);

	int updateByPrimaryKey(NoticeMessage record);

	void cleanUnreadMessage(@Param("uid") Long uid, @Param("noticeType") int noticeType);

	int queryUnreadMessageCount(@Param("uid") Long uid, @Param("noticeType") int noticeType);
}