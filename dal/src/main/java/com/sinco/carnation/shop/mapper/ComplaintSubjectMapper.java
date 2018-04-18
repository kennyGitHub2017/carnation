package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.bo.ComplaintSubjectBO;
import com.sinco.carnation.shop.model.ComplaintSubject;
import com.sinco.carnation.shop.model.ComplaintSubjectExample;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ComplaintSubjectMapper {
	int countByExample(ComplaintSubjectExample example);

	int deleteByExample(ComplaintSubjectExample example);

	int deleteByPrimaryKey(Long id);

	int insert(ComplaintSubject record);

	int insertSelective(ComplaintSubject record);

	List<ComplaintSubjectBO> selectByExampleWithBLOBs(ComplaintSubjectExample example);

	List<ComplaintSubjectBO> selectByExample(ComplaintSubjectExample example);

	List<ComplaintSubjectBO> allSeller();

	ComplaintSubjectBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") ComplaintSubject record,
			@Param("example") ComplaintSubjectExample example);

	int updateByExampleWithBLOBs(@Param("record") ComplaintSubject record,
			@Param("example") ComplaintSubjectExample example);

	int updateByExample(@Param("record") ComplaintSubject record,
			@Param("example") ComplaintSubjectExample example);

	int updateByPrimaryKeySelective(ComplaintSubject record);

	int updateByPrimaryKeyWithBLOBs(ComplaintSubject record);

	int updateByPrimaryKey(ComplaintSubject record);

	List<ComplaintSubject> queryComplaintPageList(@Param("type") String type,
			@Param("page") MyPage<ComplaintSubject> page);

	int deleteComplaint(@Param("ids") Long[] ids);
}