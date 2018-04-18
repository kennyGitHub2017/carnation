package com.sinco.carnation.goods.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.goods.bo.GoodsCartGspBO;
import com.sinco.carnation.goods.mapper.GoodsCartGspMapper;
import com.sinco.carnation.goods.model.GoodsCartGsp;
import com.sinco.carnation.goods.model.GoodsCartGspExample;

@Repository
public class GoodsCartGspDao {

	@Autowired
	private GoodsCartGspMapper mapper;

	/** generate code begin **/
	public List<GoodsCartGspBO> findAll() {
		GoodsCartGspExample example = new GoodsCartGspExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		GoodsCartGspExample example = new GoodsCartGspExample();
		return mapper.countByExample(example);
	}

	public List<GoodsCartGsp> save(Iterable<GoodsCartGsp> entities) {
		List<GoodsCartGsp> list = new ArrayList<GoodsCartGsp>();
		for (GoodsCartGsp GoodsCartGsp : entities) {
			list.add(save(GoodsCartGsp));
		}
		return list;
	}

	public GoodsCartGsp save(GoodsCartGsp record) {

		mapper.insertSelective(record);

		return record;
	}

	public List<GoodsCartGspBO> findByCartId(java.lang.Long cartId) {
		GoodsCartGspExample example = new GoodsCartGspExample();
		example.createCriteria().andCartIdEqualTo(cartId);
		return mapper.selectByExample(example);
	}

	public int deleteByCartId(java.lang.Long cartId) {
		GoodsCartGspExample example = new GoodsCartGspExample();
		example.createCriteria().andCartIdEqualTo(cartId);
		return mapper.deleteByExample(example);
	}

	public List<GoodsCartGspBO> findByGspId(java.lang.Long gspId) {
		GoodsCartGspExample example = new GoodsCartGspExample();
		example.createCriteria().andGspIdEqualTo(gspId);
		return mapper.selectByExample(example);
	}

	public int deleteByGspId(java.lang.Long gspId) {
		GoodsCartGspExample example = new GoodsCartGspExample();
		example.createCriteria().andGspIdEqualTo(gspId);
		return mapper.deleteByExample(example);
	}
	/** generate code end **/
}
