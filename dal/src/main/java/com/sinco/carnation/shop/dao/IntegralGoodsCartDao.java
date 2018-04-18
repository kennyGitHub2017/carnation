package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.shop.mapper.IntegralGoodsCartMapper;
import com.sinco.carnation.shop.model.IntegralGoodsCart;
import com.sinco.carnation.shop.bo.IntegralGoodsCartBO;
import com.sinco.carnation.shop.model.IntegralGoodsCartExample;

@Repository
public class IntegralGoodsCartDao {

	@Autowired
	private IntegralGoodsCartMapper mapper;

	/**
	 * 处理超过7天用户未提交订单的积分商品购物车
	 * 
	 * @return
	 */
	public List<IntegralGoodsCartBO> findHasNotOrderByTime(Date addTime) {
		IntegralGoodsCartExample example = new IntegralGoodsCartExample();
		example.createCriteria().andDeleteStatusEqualTo(false).andAddTimeLessThanOrEqualTo(addTime);
		return mapper.selectByExample(example);
	}

	/** generate code begin **/
	public List<IntegralGoodsCartBO> findAll() {
		IntegralGoodsCartExample example = new IntegralGoodsCartExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		IntegralGoodsCartExample example = new IntegralGoodsCartExample();
		return mapper.countByExample(example);
	}

	public List<IntegralGoodsCart> save(Iterable<IntegralGoodsCart> entities) {
		List<IntegralGoodsCart> list = new ArrayList<IntegralGoodsCart>();
		for (IntegralGoodsCart IntegralGoodsCart : entities) {
			list.add(save(IntegralGoodsCart));
		}
		return list;
	}

	@SuppressWarnings("rawtypes")
	public List<Map> selectByTop20() {
		return mapper.selectByTop20();
	}

	public IntegralGoodsCart save(IntegralGoodsCart record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(IntegralGoodsCart record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public IntegralGoodsCartBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public IntegralGoodsCartBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		IntegralGoodsCartExample example = new IntegralGoodsCartExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<IntegralGoodsCartBO> findAll(Iterable<Long> ids) {
		IntegralGoodsCartExample example = new IntegralGoodsCartExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(IntegralGoodsCart entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<IntegralGoodsCart> entities) {
		List<Long> ids = Lists.newArrayList();
		for (IntegralGoodsCart entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		IntegralGoodsCartExample example = new IntegralGoodsCartExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		IntegralGoodsCartExample example = new IntegralGoodsCartExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
