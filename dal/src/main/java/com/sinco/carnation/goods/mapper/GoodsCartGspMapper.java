package com.sinco.carnation.goods.mapper;

import com.sinco.carnation.goods.bo.GoodsCartGspBO;
import com.sinco.carnation.goods.model.GoodsCartGsp;
import com.sinco.carnation.goods.model.GoodsCartGspExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsCartGspMapper {
	int countByExample(GoodsCartGspExample example);

	int deleteByExample(GoodsCartGspExample example);

	int deleteByPrimaryKey(@Param("cartId") Long cartId, @Param("gspId") Long gspId);

	int insert(GoodsCartGsp record);

	int insertSelective(GoodsCartGsp record);

	List<GoodsCartGspBO> selectByExample(GoodsCartGspExample example);

	int updateByExampleSelective(@Param("record") GoodsCartGsp record,
			@Param("example") GoodsCartGspExample example);

	int updateByExample(@Param("record") GoodsCartGsp record, @Param("example") GoodsCartGspExample example);
}