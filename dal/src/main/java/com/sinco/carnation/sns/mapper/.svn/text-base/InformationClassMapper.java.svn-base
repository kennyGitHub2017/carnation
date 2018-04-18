package com.sinco.carnation.sns.mapper;

import com.sinco.carnation.sns.bo.InformationClassBO;
import com.sinco.carnation.sns.model.InformationClass;
import com.sinco.carnation.sns.model.InformationClassExample;
import com.sinco.carnation.sns.vo.InformationClassVO;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface InformationClassMapper {
	int countByExample(InformationClassExample example);

	int deleteByExample(InformationClassExample example);

	int deleteByPrimaryKey(Long id);

	int insert(InformationClass record);

	int insertSelective(InformationClass record);

	List<InformationClass> selectByExample(InformationClassExample example);

	List<InformationClassBO> selectBOByExample(InformationClassExample example);

	InformationClass selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") InformationClass record,
			@Param("example") InformationClassExample example);

	int updateByExample(@Param("record") InformationClass record,
			@Param("example") InformationClassExample example);

	int updateByPrimaryKeySelective(InformationClass record);

	int updateByPrimaryKey(InformationClass record);

	List<InformationClassBO> selectAll();

	List<InformationClassBO> findPageByVO(MyPage<InformationClassBO> page, @Param("vo") InformationClassVO vo);

	void updateDeleteStatusByIds(@Param("ids") List<Long> childIds);

	List<InformationClassBO> selectInfomationClassList(@Param("parentId") Long parentId);
}