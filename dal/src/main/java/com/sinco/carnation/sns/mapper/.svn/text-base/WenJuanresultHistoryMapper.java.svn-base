package com.sinco.carnation.sns.mapper;

import com.sinco.carnation.sns.bo.WenJuanresultHistoryBO;
import com.sinco.carnation.sns.model.WenJuanresultHistory;
import com.sinco.carnation.sns.model.WenJuanresultHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WenJuanresultHistoryMapper {

	int countByExample(WenJuanresultHistoryExample example);

	int deleteByExample(WenJuanresultHistoryExample example);

	int deleteByPrimaryKey(Long id);

	int insert(WenJuanresultHistory record);

	int insertSelective(WenJuanresultHistory record);

	List<WenJuanresultHistoryBO> selectByExample(WenJuanresultHistoryExample example);

	WenJuanresultHistoryBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") WenJuanresultHistory record,
			@Param("example") WenJuanresultHistoryExample example);

	int updateByExample(@Param("record") WenJuanresultHistory record,
			@Param("example") WenJuanresultHistoryExample example);

	int updateByPrimaryKeySelective(WenJuanresultHistory record);

	int updateByPrimaryKey(WenJuanresultHistory record);

	public WenJuanresultHistoryBO select_result_by_UserID(Long userID);

	public List<WenJuanresultHistoryBO> select_result_by_UserID2(@Param("userID") Long userID,
			@Param("type") Long type);

	public List<WenJuanresultHistoryBO> select_result_by_UserID2Type(@Param("userID") Long userID,
			@Param("type") Long type);

	public int update_result_deleted(Long id);

	int delete_ResultHistory_By_UserIDAndTypes(@Param("userID") Long userID, @Param("type") Long type,
			@Param("resultID") Long resultID);

	public WenJuanresultHistoryBO selectJuanresultHistory(@Param("obj") WenJuanresultHistory obj);
	
	public List<WenJuanresultHistoryBO> listWenJuanHistoryByType(@Param("type") Long type);
	
	/** 查询未加分记录 **/
	public List<WenJuanresultHistoryBO> listByisAddIntegral();
	/** 更新加分状态 **/
	public int updateIsAddIntegralByid(@Param("id") Long id);

}