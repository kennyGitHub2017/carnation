package com.sinco.carnation.goods.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.goods.bo.ReturnGoodsLogBO;
import com.sinco.carnation.goods.model.ReturnGoodsLog;
import com.sinco.carnation.goods.model.ReturnGoodsLogExample;
import com.sinco.carnation.goods.vo.ReturnGoodsLogVO;
import com.sinco.dal.common.MyPage;

public interface ReturnGoodsLogMapper {
	int countByExample(ReturnGoodsLogExample example);

	int deleteByExample(ReturnGoodsLogExample example);

	int deleteByPrimaryKey(Long id);

	int insert(ReturnGoodsLog record);

	int insertSelective(ReturnGoodsLog record);

	int cancelReturnGoods(@Param("vo") ReturnGoodsLogVO vo);

	List<ReturnGoodsLogBO> selectByExampleWithBLOBs(ReturnGoodsLogExample example);

	List<ReturnGoodsLogBO> selectByExample(ReturnGoodsLogExample example);

	@SuppressWarnings("rawtypes")
	List<ReturnGoodsLogBO> search(@Param("vo") ReturnGoodsLogVO vo, MyPage<Map> page);

	@SuppressWarnings("rawtypes")
	List<ReturnGoodsLogBO> selectByUser(@Param("userId") Long userId, MyPage<Map> page);

	ReturnGoodsLogBO selectByPrimaryKey(Long id);

	int goodsUserIdCount(@Param("userId") Long userId, @Param("goodsId") Long goodsId);

	int updateByExampleSelective(@Param("record") ReturnGoodsLog record,
			@Param("example") ReturnGoodsLogExample example);

	int updateByExampleWithBLOBs(@Param("record") ReturnGoodsLog record,
			@Param("example") ReturnGoodsLogExample example);

	int updateByExample(@Param("record") ReturnGoodsLog record,
			@Param("example") ReturnGoodsLogExample example);

	int updateByPrimaryKeySelective(ReturnGoodsLog record);

	int updateByPrimaryKeyWithBLOBs(ReturnGoodsLog record);

	int updateByPrimaryKey(ReturnGoodsLog record);

	List<ReturnGoodsLog> queryReturnGoodsLogPageList(@Param("userName") String userName,
			@Param("goodsName") String goodsName, @Param("returnServiceId") String returnServiceId,
			@Param("status") String status, @Param("page") MyPage<ReturnGoodsLog> page);

	List<ReturnGoodsLogBO> selectListByVo(@Param("page") MyPage<ReturnGoodsLogBO> page,
			@Param("vo") ReturnGoodsLogVO vo);

	ReturnGoodsLogBO findBOById(Long id);
}