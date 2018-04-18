package com.sinco.carnation.sns.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.sinco.carnation.sns.bo.ConsultingBO;
import com.sinco.carnation.sns.model.Consulting;
import com.sinco.carnation.sns.model.ConsultingExample;
import com.sinco.carnation.sns.vo.ConsultingVO;
import com.sinco.dal.common.MyPage;

public interface ConsultingMapper {
	int countByExample(ConsultingExample example);

	int deleteByExample(ConsultingExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Consulting record);

	int insertSelective(Consulting record);

	List<Consulting> selectByExampleWithBLOBs(ConsultingExample example);

	List<ConsultingBO> selectConsultingPageByUserId(@Param("userId") Long userId, MyPage<ConsultingBO> page);

	List<Consulting> selectByExample(ConsultingExample example);

	Consulting selectByPrimaryKey(Long id);

	ConsultingBO selectConsultingById(Long id);

	int updateByExampleSelective(@Param("record") Consulting record,
			@Param("example") ConsultingExample example);

	int updateByExampleWithBLOBs(@Param("record") Consulting record,
			@Param("example") ConsultingExample example);

	int updateByExample(@Param("record") Consulting record, @Param("example") ConsultingExample example);

	int updateByPrimaryKeySelective(Consulting record);

	int updateByPrimaryKeyWithBLOBs(Consulting record);

	int updateByPrimaryKey(Consulting record);

	List<ConsultingBO> queryConsulListByExp(@Param("uid") Long uid, @Param("vo") ConsultingVO vo,
			@Param("page") MyPage<ConsultingBO> page);

	List<ConsultingBO> queryConsulList(@Param("vo") ConsultingVO vo, @Param("page") MyPage<ConsultingBO> page);

	ConsultingBO queryConsulDetails(@Param("conId") Long conId);

	int updateConsulting(@Param("con") Consulting con);

	List<ConsultingBO> queryNotDoConsulListByExp(@Param("id") Long id);

	List<ConsultingBO> queryConsultingByExpId(@Param("expId") Long expId, @Param("title") String title,
			@Param("page") MyPage<ConsultingBO> page);
}