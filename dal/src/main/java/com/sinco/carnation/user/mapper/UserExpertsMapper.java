package com.sinco.carnation.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.sys.vo.ExpertsVO;
import com.sinco.carnation.user.bo.UserExpertsBO;
import com.sinco.carnation.user.model.UserExperts;
import com.sinco.carnation.user.model.UserExpertsExample;
import com.sinco.carnation.user.vo.UserExpertsVO;
import com.sinco.dal.common.MyPage;

public interface UserExpertsMapper {
	int countByExample(UserExpertsExample example);

	int deleteByExample(UserExpertsExample example);

	int deleteByPrimaryKey(Long uid);

	int insert(UserExperts record);

	int insertSelective(UserExperts record);

	List<UserExperts> selectByExampleWithBLOBs(UserExpertsExample example);

	List<UserExperts> selectByExample(UserExpertsExample example);

	UserExperts selectByPrimaryKey(Long uid);

	UserExpertsBO selectExpertsDetail(@Param("uid") Long uid);

	int updateByExampleSelective(@Param("record") UserExperts record,
			@Param("example") UserExpertsExample example);

	int updateByExampleWithBLOBs(@Param("record") UserExperts record,
			@Param("example") UserExpertsExample example);

	int updateByExample(@Param("record") UserExperts record, @Param("example") UserExpertsExample example);

	int updateByPrimaryKeySelective(UserExperts record);

	int updateByPrimaryKeyWithBLOBs(UserExperts record);

	int updateByPrimaryKey(UserExperts record);

	int updateExpertsPraises(@Param("uid") Long uid, @Param("praiseInfo") String praiseInfo);

	int updateExpertsUnPraises(@Param("uid") Long uid, @Param("praiseInfo") String praiseInfo);

	List<UserExpertsBO> queryExperts(@Param("uid") Long uid, @Param("expertType") Integer expertType,
			@Param("type") String type, MyPage<UserExpertsBO> page);

	List<UserExpertsBO> selectExpertsListByVO(@Param("vo") UserExpertsVO vo, MyPage<UserExpertsBO> page);

	List<UserExpertsBO> queryExpertsList(@Param("vo") ExpertsVO vo, @Param("page") MyPage<UserExpertsBO> page);

	UserExpertsBO selectById(@Param("uid") Long uid);

	int updateExpertsFavo(@Param("uid") Long uid, @Param("favorInfo") String favorInfo);

	int delectExpertByIds(@Param("uid") Long[] uid);

	int updateExpertsUnFavo(@Param("uid") Long uid, @Param("favorInfo") String favorInfo);

	List<UserExpertsBO> selectExpertsList(@Param("expertType") Integer expertType);
}