package com.sinco.carnation.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.user.bo.OperatorBO;
import com.sinco.carnation.user.model.Operator;
import com.sinco.carnation.user.model.OperatorExample;
import com.sinco.carnation.user.vo.OperatorVO;
import com.sinco.dal.common.MyPage;

public interface OperatorMapper {
	int selectRegisterOperatorCount(@Param("vo") OperatorVO vo);

	int selectOwnOperatorCount(@Param("vo") OperatorVO vo);

	public OperatorBO selectByInvitationCode(String invitationCode);

	List<OperatorBO> selectOperatorPageList(MyPage<OperatorBO> page, @Param("vo") OperatorVO vo);

	List<OperatorBO> selectRegisterOperatorPageList(MyPage<OperatorBO> page, @Param("vo") OperatorVO vo);

	List<OperatorBO> selectOwnOperatorPageList(MyPage<OperatorBO> page, @Param("vo") OperatorVO vo);

	public List<OperatorBO> getCheckOkOperatorByOperatorAreaId(@Param("operatorAreaId") String operatorAreaId);

	int countByExample(OperatorExample example);

	int deleteByExample(OperatorExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Operator record);

	int insertSelective(Operator record);

	List<OperatorBO> selectByExample(OperatorExample example);

	OperatorBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Operator record, @Param("example") OperatorExample example);

	int updateByExample(@Param("record") Operator record, @Param("example") OperatorExample example);

	int updateByPrimaryKeySelective(Operator record);

	int updateByPrimaryKey(Operator record);

	OperatorBO queryOperatorInfo(@Param("uid") Long uid);

	List<OperatorBO> selectOperatorBySellerUserId(@Param("sellerUserId") Long sellerUserId,
			@Param("queryLevel") String queryLevel);

	List<OperatorBO> selectOperatorByAreaAndCode(@Param("operatorCode") String operatorCode,
			@Param("areaId") String areaId);

	int selectOperatorCountByArea(@Param("areaId") String areaId);

	OperatorBO selectOperatorByCnUserName(@Param("cn_username") String cn_username);

	List<OperatorBO> getLevelAndArea(@Param("areaId") String areaId, @Param("level") Integer level);
	
	public OperatorBO queryOperatorByOperatorCode(@Param("operatorCode")String operatorCode);
	
	List<OperatorBO> listAllOperator();
}