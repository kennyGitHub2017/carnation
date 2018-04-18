package com.sinco.carnation.goods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.goods.bo.GoodsCartBO;
import com.sinco.carnation.goods.model.GoodsCart;
import com.sinco.carnation.goods.model.GoodsCartExample;
import com.sinco.carnation.shop.vo.GoodsCartMyVO;

public interface GoodsCartMapper {

	List<GoodsCartBO> findMyCart(GoodsCartMyVO vo);

	int countByExample(GoodsCartExample example);

	int deleteByExample(GoodsCartExample example);

	int deleteByPrimaryKey(Long id);

	int insert(GoodsCart record);

	int insertSelective(GoodsCart record);

	List<GoodsCartBO> selectByExampleWithBLOBs(GoodsCartExample example);

	List<GoodsCartBO> selectByExample(GoodsCartExample example);

	GoodsCartBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") GoodsCart record, @Param("example") GoodsCartExample example);

	int updateByExampleWithBLOBs(@Param("record") GoodsCart record, @Param("example") GoodsCartExample example);

	int updateByExample(@Param("record") GoodsCart record, @Param("example") GoodsCartExample example);

	int updateByPrimaryKeySelective(GoodsCart record);

	int updateByPrimaryKeyWithBLOBs(GoodsCart record);

	int updateByPrimaryKey(GoodsCart record);

	GoodsCartBO findMyByIdCart(@Param("cartId") Long cartId);

	List<GoodsCartBO> getByUserAndGoodsId(@Param("userId") Long userId, @Param("goodsId") Long goodsId);
}