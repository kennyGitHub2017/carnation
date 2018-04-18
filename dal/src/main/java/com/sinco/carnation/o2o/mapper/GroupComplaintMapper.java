package com.sinco.carnation.o2o.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.o2o.bo.GroupComplaintBO;
import com.sinco.carnation.o2o.model.GroupComplaint;
import com.sinco.carnation.o2o.model.GroupComplaintExample;
import com.sinco.carnation.o2o.vo.GroupComplaintVO;
import com.sinco.dal.common.MyPage;

public interface GroupComplaintMapper {
	int countByExample(GroupComplaintExample example);

	int deleteByExample(GroupComplaintExample example);

	int deleteByPrimaryKey(Long id);

	int insert(GroupComplaint record);

	int insertSelective(GroupComplaint record);

	List<GroupComplaintBO> selectByExampleWithBLOBs(GroupComplaintExample example);

	List<GroupComplaintBO> search(@Param("vo") GroupComplaintVO vo,
			@Param("page") MyPage<GroupComplaintBO> page);

	List<GroupComplaintBO> selectByExample(GroupComplaintExample example);

	GroupComplaintBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") GroupComplaint record,
			@Param("example") GroupComplaintExample example);

	int updateByExampleWithBLOBs(@Param("record") GroupComplaint record,
			@Param("example") GroupComplaintExample example);

	int updateByExample(@Param("record") GroupComplaint record,
			@Param("example") GroupComplaintExample example);

	int updateByPrimaryKeySelective(GroupComplaint record);

	int updateByPrimaryKeyWithBLOBs(GroupComplaint record);

	int updateByPrimaryKey(GroupComplaint record);

	/** 我的运营商投诉列表 **/
	List<GroupComplaintBO> groupComplaintList(@Param("status") int status, @Param("name") String name,
			@Param("uid") Long uid, @Param("page") MyPage<GroupComplaintBO> page);

	/** 我的运营商投诉明细 **/
	List<GroupComplaintBO> groupComplaintDetails(@Param("id") Integer id);

	// 查询运营商的投诉列表
	List<GroupComplaintBO> searchOperatorList(@Param("vo") GroupComplaintVO vo,
			@Param("page") MyPage<GroupComplaintBO> page);

}