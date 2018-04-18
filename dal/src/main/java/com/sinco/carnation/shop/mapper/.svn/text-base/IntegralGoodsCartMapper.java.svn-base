package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.bo.IntegralGoodsCartBO;
import com.sinco.carnation.shop.model.IntegralGoodsCart;
import com.sinco.carnation.shop.model.IntegralGoodsCartExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface IntegralGoodsCartMapper {
	int countByExample(IntegralGoodsCartExample example);

	int deleteByExample(IntegralGoodsCartExample example);

	int deleteByPrimaryKey(Long id);

	int insert(IntegralGoodsCart record);

	int insertSelective(IntegralGoodsCart record);

	List<IntegralGoodsCartBO> selectByExample(IntegralGoodsCartExample example);

	@SuppressWarnings("rawtypes")
	List<Map> selectByTop20();

	IntegralGoodsCartBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") IntegralGoodsCart record,
			@Param("example") IntegralGoodsCartExample example);

	int updateByExample(@Param("record") IntegralGoodsCart record,
			@Param("example") IntegralGoodsCartExample example);

	int updateByPrimaryKeySelective(IntegralGoodsCart record);

	int updateByPrimaryKey(IntegralGoodsCart record);
}