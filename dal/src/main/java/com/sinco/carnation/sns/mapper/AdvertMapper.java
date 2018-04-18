package com.sinco.carnation.sns.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.sns.bo.AdvertBO;
import com.sinco.carnation.sns.model.Advert;
import com.sinco.carnation.sns.model.AdvertExample;
import com.sinco.carnation.sns.vo.AdvertVO;
import com.sinco.dal.common.MyPage;

public interface AdvertMapper {

	int increaseClickNum(Long id);

	List<AdvertBO> selectBOByExample(AdvertExample example);

	int selectCountByAddTime(@Param("sadCode") String sadCode, @Param("timeStapm") String timeStapm);

	int countByExample(AdvertExample example);

	int deleteByExample(AdvertExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Advert record);

	int insertSelective(Advert record);

	List<Advert> selectByExample(AdvertExample example);

	List<AdvertBO> findAdByCode(@Param("sadCode") String sadCode, @Param("cityId") Long cityId, @Param("time") String time);

	List<Advert> findTopAdByApCode(@Param("apCode") String apCode, @Param("count") Long count);

	Advert selectByPrimaryKey(Long id);

	List<AdvertBO> findByApCode(@Param("apCode") String apCode);

	int updateByExampleSelective(@Param("record") Advert record, @Param("example") AdvertExample example);

	int updateByExample(@Param("record") Advert record, @Param("example") AdvertExample example);

	int updateByPrimaryKeySelective(Advert record);

	int updateByPrimaryKey(Advert record);

	/* grey added begin */
	List<AdvertBO> selectListByVo(@Param("vo") AdvertVO vo, MyPage<AdvertBO> page);

	AdvertBO selectBoByPrimaryKey(Long id);

	int updateAdSlideSequenceAddOne(@Param("id") Long id, @Param("adApId") Long adApId);
	/* grey added end */

}