package com.sinco.carnation.sys.mapper;

import com.sinco.carnation.sys.bo.SysKeyWordMapBO;
import com.sinco.carnation.sys.model.SysKeyWordMap;
import com.sinco.carnation.sys.model.SysKeyWordMapExample;
import com.sinco.carnation.sys.vo.SysKeyWordMapVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysKeyWordMapMapper {
	int countByExample(SysKeyWordMapExample example);

	int deleteByExample(SysKeyWordMapExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SysKeyWordMap record);

	int insertSelective(SysKeyWordMap record);

	List<SysKeyWordMapBO> selectByExample(SysKeyWordMapExample example);

	SysKeyWordMapBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SysKeyWordMap record,
			@Param("example") SysKeyWordMapExample example);

	int updateByExample(@Param("record") SysKeyWordMap record, @Param("example") SysKeyWordMapExample example);

	int updateByPrimaryKeySelective(SysKeyWordMap record);

	int updateByPrimaryKey(SysKeyWordMap record);

	/**
	 * 精华推荐
	 * 
	 * @param idsList
	 * @param sysTypeCode
	 * @return
	 */
	List<SysKeyWordMapBO> findListByCond4Recommed(@Param("idsList") List<Long> idsList,
			@Param("typeCode") long typeCode, @Param("suggestTypeCode") long suggestTypeCode);

	/**
	 * 根据typeCode和关联的ID列表批量删除
	 * 
	 * @param typeCode
	 *            关联类型 1:体检建议 2:任务 3:帖子 4:商品 5:服务
	 * @param typeIds
	 *            关联表的id集合
	 */
	void batchDeleteByTypeCodeAndIds(@Param("typeCode") long typeCode, @Param("typeIds") List<Long> typeIds);

	/***
	 * 添加
	 * 
	 * @param record
	 * @return
	 */
	int insertKeyWordMap(SysKeyWordMap record);

	/***
	 * 根据条件查询
	 * 
	 * @return
	 */
	List<SysKeyWordMapBO> selectListByVo(@Param("vo") SysKeyWordMapVO vo);

	int deleteByTypeIdAdTypeCode(@Param("typeId") Long typeId, @Param("typeCode") Long typeCode);
}