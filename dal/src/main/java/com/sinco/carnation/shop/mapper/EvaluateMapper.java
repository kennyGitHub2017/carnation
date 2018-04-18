package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.bo.EvaluateBO;
import com.sinco.carnation.shop.model.Evaluate;
import com.sinco.carnation.shop.model.EvaluateExample;
import com.sinco.carnation.shop.vo.EvaluateVO;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface EvaluateMapper {
	int countByExample(EvaluateExample example);

	int deleteByExample(EvaluateExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Evaluate record);

	int insertSelective(Evaluate record);

	List<Evaluate> selectByExampleWithBLOBs(EvaluateExample example);

	List<Long> selectDistinctGoodsId();

	List<Evaluate> selectByExample(EvaluateExample example);

	Evaluate selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Evaluate record, @Param("example") EvaluateExample example);

	int updateByExampleWithBLOBs(@Param("record") Evaluate record, @Param("example") EvaluateExample example);

	int updateByExample(@Param("record") Evaluate record, @Param("example") EvaluateExample example);

	int updateByPrimaryKeySelective(Evaluate record);

	int updateByPrimaryKeyWithBLOBs(Evaluate record);

	int updateByPrimaryKey(Evaluate record);

	List<EvaluateBO> queryEvaluateList(@Param("nickName") String nickName,
			@Param("goodsName") String goodsName, @Param("page") MyPage<EvaluateBO> page);

	List<EvaluateBO> queryEvaluateListByVO(@Param("vo") EvaluateVO vo, MyPage<EvaluateBO> page);

	EvaluateBO queryEvaluateById(@Param("evaId") Long evaId);

	public List<EvaluateBO> queryEvaluateGoods(@Param("replyStatus") Integer replyStatus,
			@Param("goodsType") Integer goodsType, @Param("page") MyPage<EvaluateBO> page);

	List<EvaluateBO> queryByUserId(Long userId);

	List<EvaluateBO> queryByVO(@Param("vo") EvaluateVO vo, @Param("page") MyPage<EvaluateBO> page);

	List<EvaluateBO> queryByStoreId(Long storeId);

	List<EvaluateBO> queryStatusLess2(Long storeId);

	List<EvaluateBO> findListByVo(@Param("page") MyPage<EvaluateBO> page, @Param("vo") EvaluateVO vo);

	List<EvaluateBO> queryEvaultePageList(@Param("userId") Long userId, @Param("page") MyPage<EvaluateBO> page);

	List<EvaluateBO> queryEvaultePageListByVal(@Param("userId") Long userId,
			@Param("evaluateBuyerVal") String evaluateBuyerVal, @Param("page") MyPage<EvaluateBO> page);

	Evaluate fetch(@Param("userId") Long userId, @Param("goodsId") Long goodsId);

	Evaluate getEvaluate(@Param("userId") Long userId, @Param("goodsId") Long goodsId, @Param("ofId") Long ofId);

}