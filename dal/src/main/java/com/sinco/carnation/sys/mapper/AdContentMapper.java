package com.sinco.carnation.sys.mapper;

import com.sinco.carnation.sys.bo.AdContentBO;
import com.sinco.carnation.sys.model.AdContent;
import com.sinco.carnation.sys.model.AdContentExample;
import com.sinco.carnation.sys.vo.AdContentVO;
import com.sinco.dal.common.MyPage;
import com.sinco.data.core.Page;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AdContentMapper {
	int countByExample(AdContentExample example);

    int deleteByExample(AdContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdContent record);

    int insertSelective(AdContent record);

    List<AdContentBO> findQuYunById(@Param("did")Long did);
    
    List<AdContentBO> selectByExample(AdContentExample example);

    List<AdContentBO> selectByExample(AdContentExample example ,@Param("page") Page<AdContentBO> page);
    
    List<AdContentBO> listByVOPage(@Param("vo")AdContentVO vo ,@Param("page") Page<AdContentBO> page,@Param("queryType") String queryType);

    AdContentBO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdContent record, @Param("example") AdContentExample example);

    int updateByExample(@Param("record") AdContent record, @Param("example") AdContentExample example);

    int updateByPrimaryKeySelective(AdContent record);

    int updateByPrimaryKey(AdContent record);
    
    List<AdContentBO> findAllName(@Param("vo")AdContentVO vo);

	List<AdContentBO> findContentsByPage(MyPage<AdContentBO> page,
			@Param("vo")AdContentVO vo);
    List<AdContentBO> findAll();
    
	List<AdContentBO> queryContentsList(Map<String, Object> map);
	
	int updateAllOrdersById(AdContent record);
    
}