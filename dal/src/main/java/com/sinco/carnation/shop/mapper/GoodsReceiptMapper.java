package com.sinco.carnation.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.shop.bo.GoodsReceiptBO;
import com.sinco.carnation.shop.model.GoodsReceipt;
import com.sinco.carnation.shop.model.GoodsReceiptExample;
import com.sinco.dal.common.MyPage;

public interface GoodsReceiptMapper {
	int countByExample(GoodsReceiptExample example);

	int deleteByExample(GoodsReceiptExample example);

	int deleteByPrimaryKey(Long id);

	int insert(GoodsReceipt record);

	int insertSelective(GoodsReceipt record);

	List<GoodsReceiptBO> selectByExample(GoodsReceiptExample example);

	GoodsReceiptBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") GoodsReceipt record,
			@Param("example") GoodsReceiptExample example);

	int updateByExample(@Param("record") GoodsReceipt record, @Param("example") GoodsReceiptExample example);

	int updateByPrimaryKeySelective(GoodsReceipt record);

	int updateByPrimaryKey(GoodsReceipt record);

	List<GoodsReceiptBO> findGoodsReceiptList(MyPage<GoodsReceiptBO> page, @Param("goodsId") Long goodsId);
}