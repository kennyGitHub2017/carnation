package com.sinco.carnation.goods.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.goods.GoodsConstants;
import com.sinco.carnation.goods.bo.GoodsCartBO;
import com.sinco.carnation.goods.mapper.GoodsCartMapper;
import com.sinco.carnation.goods.model.GoodsCart;
import com.sinco.carnation.goods.model.GoodsCartExample;
import com.sinco.carnation.shop.vo.GoodsCartMyVO;

@Repository
public class GoodsCartDao {

	@Autowired
	private GoodsCartMapper mapper;

	/**
	 * 根据创建时间删除
	 * 
	 * @param uid
	 * @param ltAddTime
	 *            小于创建时间
	 * @return
	 */
	public int deleteByAddTime(Long uid, Date ltAddTime) {
		GoodsCartExample example = new GoodsCartExample();
		example.createCriteria().andUserIdEqualTo(uid).andAddTimeLessThan(ltAddTime);
		return mapper.deleteByExample(example);
	}

	/**
	 * 查找用户购物车数量
	 * 
	 * @param uid
	 * @param sessionId
	 * @return
	 */
	public int countByUidOrSessionId(Long uid, String sessionId) {
		if (uid != null && StringUtils.isBlank(sessionId)) {
			return 0;
		}

		GoodsCartExample example = new GoodsCartExample();

		if (uid != null) {
			example.or(example.createCriteria().andUserIdEqualTo(uid)
					.andCartStatusEqualTo(GoodsConstants.GOODS_CART_STATUS_0));
		}
		if (StringUtils.isNotBlank(sessionId)) {
			example.or(example.createCriteria().andCartSessionIdEqualTo(sessionId)
					.andCartStatusEqualTo(GoodsConstants.GOODS_CART_STATUS_0));
		}
		return mapper.countByExample(example);
	}

	/**
	 * 查找我的购物车
	 * 
	 * @param vo
	 * @return
	 */
	public List<GoodsCartBO> findMyCart(GoodsCartMyVO vo) {
		return mapper.findMyCart(vo);
	}

	/**
	 * 处理超过1天未登录用户并且未提交订单的购物车信息
	 * 
	 * @param vo
	 * @return
	 */
	public List<GoodsCartBO> findGoodsCartHasNotUserByTime(Date addTime, Integer cartStatus) {
		GoodsCartExample example = new GoodsCartExample();
		example.createCriteria().andUserIdIsNull().andDeleteStatusEqualTo(0)
				.andAddTimeLessThanOrEqualTo(addTime).andCartStatusEqualTo(cartStatus);
		return mapper.selectByExample(example);
	}

	/**
	 * 处理超过7天已经登录用户未提交订单的购物车信息
	 * 
	 * @param vo
	 * @return
	 */
	public List<GoodsCartBO> findGoodsCartHasUserByTime(Date addTime, Integer cartStatus) {
		GoodsCartExample example = new GoodsCartExample();
		example.createCriteria().andUserIdIsNotNull().andDeleteStatusEqualTo(0)
				.andAddTimeLessThanOrEqualTo(addTime).andCartStatusEqualTo(cartStatus);
		return mapper.selectByExample(example);
	}

	/** generate code begin **/
	public List<GoodsCartBO> findAll() {
		GoodsCartExample example = new GoodsCartExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		GoodsCartExample example = new GoodsCartExample();
		return mapper.countByExample(example);
	}

	public List<GoodsCart> save(Iterable<GoodsCart> entities) {
		List<GoodsCart> list = new ArrayList<GoodsCart>();
		for (GoodsCart GoodsCart : entities) {
			list.add(save(GoodsCart));
		}
		return list;
	}

	public GoodsCart save(GoodsCart record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(GoodsCart record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public GoodsCartBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public GoodsCartBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		GoodsCartExample example = new GoodsCartExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<GoodsCartBO> findAll(Iterable<Long> ids) {
		GoodsCartExample example = new GoodsCartExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(GoodsCart entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<GoodsCart> entities) {
		List<Long> ids = Lists.newArrayList();
		for (GoodsCart entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByGoods(Long goodsId) {
		GoodsCartExample example = new GoodsCartExample();
		example.createCriteria().andGoodsIdEqualTo(goodsId);
		mapper.deleteByExample(example);
	}

	public void deleteByIds(Iterable<Long> ids) {
		GoodsCartExample example = new GoodsCartExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		GoodsCartExample example = new GoodsCartExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public GoodsCartBO findMyByIdCart(Long cartId) {
		return mapper.findMyByIdCart(cartId);
	}

	public List<GoodsCartBO> getByUserAndGoodsId(Long userId, Long goodsId) {
		return this.mapper.getByUserAndGoodsId(userId, goodsId);
	}
}
