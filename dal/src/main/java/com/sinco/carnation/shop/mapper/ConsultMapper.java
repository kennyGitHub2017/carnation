package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.bo.ConsultBO;
import com.sinco.carnation.shop.model.Consult;
import com.sinco.carnation.shop.model.ConsultExample;
import com.sinco.carnation.shop.vo.ConsultVO;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ConsultMapper {
	int countByExample(ConsultExample example);

	int deleteByExample(ConsultExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Consult record);

	int insertSelective(Consult record);

	List<ConsultBO> selectByExampleWithBLOBs(ConsultExample example);

	List<ConsultBO> selectByExample(ConsultExample example);

	ConsultBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Consult record, @Param("example") ConsultExample example);

	int updateByExampleWithBLOBs(@Param("record") Consult record, @Param("example") ConsultExample example);

	int updateByExample(@Param("record") Consult record, @Param("example") ConsultExample example);

	int updateByPrimaryKeySelective(Consult record);

	int updateByPrimaryKeyWithBLOBs(Consult record);

	int updateByPrimaryKey(Consult record);

	List<ConsultBO> queryConsultList(@Param("consultUserName") String consultUserName,
			@Param("page") MyPage<ConsultBO> page);

	List<ConsultBO> selectConsultListByVO(@Param("vo") ConsultVO vo, @Param("page") MyPage<ConsultBO> page);

	int deleteConsultById(@Param("ids") Long[] ids);

	public List<Consult> queryConsultById(@Param("id") Long id);

	public List<ConsultBO> queryConsultSelfList(@Param("consultUserName") String consultUserName,
			@Param("reply") Boolean reply, @Param("page") MyPage<ConsultBO> page);

	List<ConsultBO> findListByVO(@Param("page") MyPage<ConsultBO> page, @Param("vo") ConsultVO vo);
}