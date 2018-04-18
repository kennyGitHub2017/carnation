package com.sinco.carnation.o2o.mapper;

import com.sinco.carnation.o2o.bo.GroupEvaluationBO;
import com.sinco.carnation.o2o.model.GroupEvaluation;
import com.sinco.carnation.o2o.model.GroupEvaluationExample;
import com.sinco.carnation.o2o.vo.GroupEvaluationVO;
import com.sinco.dal.common.MyPage;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupEvaluationMapper {
	int countByExample(GroupEvaluationExample example);

	int deleteByExample(GroupEvaluationExample example);

	int deleteByPrimaryKey(Long orderId);

	int insert(GroupEvaluation record);

	int insertSelective(GroupEvaluation record);

	List<GroupEvaluationBO> selectByExample(GroupEvaluationExample example);

	GroupEvaluationBO selectByPrimaryKey(Long orderId);

	int updateByExampleSelective(@Param("record") GroupEvaluation record,
			@Param("example") GroupEvaluationExample example);

	int updateByExample(@Param("record") GroupEvaluation record,
			@Param("example") GroupEvaluationExample example);

	int updateByPrimaryKeySelective(GroupEvaluation record);

	int updateByPrimaryKey(GroupEvaluation record);

	List<GroupEvaluationBO> query(@Param("vo") GroupEvaluationVO vo, MyPage<GroupEvaluationBO> page);

	List<GroupEvaluationBO> queryByVO(@Param("vo") GroupEvaluationVO vo, MyPage<GroupEvaluationBO> page);

//	List<GroupEvaluationBO> queryStoreTotal(@Param("storeId")Long storeId,MyPage<GroupEvaluationBO> page);
//	List<GroupEvaluationBO> queryScoreTotal(@Param("storeId")Long storeId,MyPage<GroupEvaluationBO> page);

	List<GroupEvaluationBO> queryByStoreName(@Param("storeName") String storeName,
			MyPage<GroupEvaluationBO> page);

	/**
	 * 获取某店铺的总评分和总评价人数
	 * 
	 * @param storeId
	 * @return
	 */
	GroupEvaluationBO fetchStoreTotal(@Param("storeId") Long storeId);

	/**
	 * 获取某店铺的评价，并按照评分分组
	 * 
	 * @param storeId
	 * @return
	 */
	List<GroupEvaluationBO> queryStoreByScores(@Param("storeId") Long storeId);
}