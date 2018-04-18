package com.sinco.carnation.user.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.sinco.carnation.user.bo.PhysicalResultBO;
import com.sinco.carnation.user.model.PhysicalResult;
import com.sinco.carnation.user.model.PhysicalResultExample;
import com.sinco.carnation.user.vo.PhysicalResultVO;
import com.sinco.dal.common.MyPage;

public interface PhysicalResultMapper {
	int countByExample(PhysicalResultExample example);

	int deleteByExample(PhysicalResultExample example);

	int deleteByPrimaryKey(Long id);

	int insert(PhysicalResult record);

	int insertSelective(PhysicalResult record);

	List<PhysicalResultBO> selectByExample(PhysicalResultExample example);

	PhysicalResultBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") PhysicalResult record,
			@Param("example") PhysicalResultExample example);

	int updateByExample(@Param("record") PhysicalResult record,
			@Param("example") PhysicalResultExample example);

	int updateByPrimaryKeySelective(@Param("record") PhysicalResult record);

	int updateByPrimaryKey(PhysicalResult record);

	PhysicalResult queryPhysicalResult(@Param("userId") String userId, @Param("code") String code,
			@Param("time") String time);

	List<PhysicalResultBO> queryPhysicalResultList(@Param("userId") String userId, @Param("time") String time);

	PhysicalResultBO queryPhysicalResultByCond(@Param("minValue") Float minValue,
			@Param("maxValue") Float maxValue, @Param("middleValue") Float middleValue,
			@Param("type") Integer type, @Param("sex") int sex, @Param("age") int age);

	List<PhysicalResultBO> selectPhysicalResultList(@Param("userId") Long userId,
			@Param("itemCode") Integer itemCode, @Param("lmt") Integer lmt);

	List<PhysicalResultBO> selectPhysicalResultByVO(@Param("vo") PhysicalResultVO vo,
			MyPage<PhysicalResultBO> page);

	int updateByIdForIsDel(@Param("id") Integer id, @Param("isdel") boolean isdel);

	List<PhysicalResultBO> selectPhysicalResultByUserIdSix(@Param("userId") Long userId);
	/** 查询未加分记录 **/
	public List<PhysicalResultBO> listByisAddIntegral();
	/** 更新加分状态 **/
	public int updateIsAddIntegralByid(@Param("id") Long id);

}