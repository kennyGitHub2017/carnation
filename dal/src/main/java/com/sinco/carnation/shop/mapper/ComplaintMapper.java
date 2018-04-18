package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.bo.ComplaintBO;
import com.sinco.carnation.shop.model.Complaint;
import com.sinco.carnation.shop.model.ComplaintExample;
import com.sinco.carnation.shop.vo.ComplaintVO;
import com.sinco.dal.common.MyPage;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ComplaintMapper {
	int countByExample(ComplaintExample example);

	int deleteByExample(ComplaintExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Complaint record);

	int insertSelective(Complaint record);

	List<ComplaintBO> selectByExampleWithBLOBs(ComplaintExample example);

	List<ComplaintBO> selectByExample(ComplaintExample example);

	List<ComplaintBO> selectByUser(@Param("fromUserId") Long fromUserId, @Param("status") String status,
			MyPage<ComplaintBO> page);

	ComplaintBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Complaint record, @Param("example") ComplaintExample example);

	int updateByExampleWithBLOBs(@Param("record") Complaint record, @Param("example") ComplaintExample example);

	int updateByExample(@Param("record") Complaint record, @Param("example") ComplaintExample example);

	int updateByPrimaryKeySelective(Complaint record);

	int updateByPrimaryKeyWithBLOBs(Complaint record);

	int updateByPrimaryKey(Complaint record);

	List<ComplaintBO> queryComplaintPageList(@Param("status") String status, @Param("title") String title,
			@Param("formName") String formName, @Param("beginTime") String beginTime,
			@Param("endTime") String endTime, @Param("page") MyPage<ComplaintBO> page);

	List<ComplaintBO> queryComplaintPageListSelf(@Param("status") String status,
			@Param("title") String title, @Param("formName") String formName,
			@Param("beginTime") String beginTime, @Param("endTime") String endTime,
			@Param("page") MyPage<ComplaintBO> page);

	List<ComplaintBO> queryComplaintById(@Param("comId") Long comId);

	List<ComplaintBO> querySelfComplaintPageList(@Param("status") String status,
			@Param("title") String title, @Param("formName") String formName,
			@Param("beginTime") String beginTime, @Param("endTime") String endTime,
			@Param("page") MyPage<ComplaintBO> page);

	List<ComplaintBO> findListByVO(@Param("page") MyPage<ComplaintBO> page, @Param("vo") ComplaintVO vo);

	List<Map<String, Integer>> findCountByToUserId(@Param("userId") Long userId);
}