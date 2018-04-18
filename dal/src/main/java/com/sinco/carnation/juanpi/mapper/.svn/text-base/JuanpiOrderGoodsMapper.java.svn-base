package com.sinco.carnation.juanpi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.juanpi.bo.JuanpiOrderGoodsBO;
import com.sinco.carnation.juanpi.model.JuanpiOrderGoods;
import com.sinco.carnation.juanpi.model.JuanpiOrderGoodsExample;
import com.sinco.carnation.juanpi.vo.JuanpiOrderGoodsVO;
import com.sinco.dal.common.MyPage;

public interface JuanpiOrderGoodsMapper {
    int countByExample(JuanpiOrderGoodsExample example);

    int deleteByExample(JuanpiOrderGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JuanpiOrderGoods record);

    int insertSelective(JuanpiOrderGoods record);

    List<JuanpiOrderGoodsBO> selectByExample(JuanpiOrderGoodsExample example);

    JuanpiOrderGoodsBO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") JuanpiOrderGoods record, @Param("example") JuanpiOrderGoodsExample example);

    int updateByExample(@Param("record") JuanpiOrderGoods record, @Param("example") JuanpiOrderGoodsExample example);

    int updateByPrimaryKeySelective(JuanpiOrderGoods record);

    int updateByPrimaryKey(JuanpiOrderGoods record);

	int synOrderGoods(JuanpiOrderGoodsBO record);
	
	List<JuanpiOrderGoodsBO> findOrderInfoByOrderId(Long orderId);
	
	List<JuanpiOrderGoodsBO> findGoodsByOrderId(@Param("orderId")Integer orderId,@Param("page")MyPage<JuanpiOrderGoodsBO> page);
	List<JuanpiOrderGoodsBO> findGoodsByOnlyOrderId(@Param("orderId")Integer orderId);
	List<JuanpiOrderGoodsBO> selectOrderGoodsListByVO(@Param("vo") JuanpiOrderGoodsVO vo,MyPage<JuanpiOrderGoodsBO> page);
	JuanpiOrderGoodsBO selectMoneyTotal(@Param("vo") JuanpiOrderGoodsVO vo);	
	
	List<JuanpiOrderGoodsBO> listAddIntegral();
	int updateAddIntegral(Long id);
}