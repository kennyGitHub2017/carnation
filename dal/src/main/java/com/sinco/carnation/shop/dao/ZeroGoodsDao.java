package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.shop.bo.ZeroGoodsBO;
import com.sinco.carnation.shop.mapper.ZeroGoodsMapper;
import com.sinco.carnation.shop.model.ZeroGoods;
import com.sinco.carnation.shop.model.ZeroGoodsExample;
import com.sinco.carnation.shop.vo.ZeroGoodsVO;
import com.sinco.dal.common.MyPage;

@Repository
public class ZeroGoodsDao {

	@Autowired
	private ZeroGoodsMapper mapper;

	/** generate code begin **/
	public List<ZeroGoodsBO> findAll() {
		ZeroGoodsExample example = new ZeroGoodsExample();
		return mapper.selectByExample(example);
	}

	List<ZeroGoodsBO> findAll(Iterable<Long> ids) {
		ZeroGoodsExample example = new ZeroGoodsExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		ZeroGoodsExample example = new ZeroGoodsExample();
		return mapper.countByExample(example);
	}

	public List<ZeroGoods> save(Iterable<ZeroGoods> entities) {
		List<ZeroGoods> list = new ArrayList<ZeroGoods>();
		for (ZeroGoods ZeroGoods : entities) {
			list.add(save(ZeroGoods));
		}
		return list;
	}

	public ZeroGoods save(ZeroGoods record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(ZeroGoods record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public ZeroGoodsBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		ZeroGoodsExample example = new ZeroGoodsExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(ZeroGoods entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<ZeroGoods> entities) {
		List<Long> ids = Lists.newArrayList();
		for (ZeroGoods entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ZeroGoodsExample example = new ZeroGoodsExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ZeroGoodsExample example = new ZeroGoodsExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public ZeroGoods getByGoodsId(Long goodsId) {
		return mapper.getByGoodsId(goodsId);
	}

	public List<ZeroGoodsBO> findByVo(ZeroGoodsVO vo) {
		return this.mapper.findByVo(vo);
	}

	public List<ZeroGoodsBO> findPageByVo(ZeroGoodsVO vo, MyPage<ZeroGoodsBO> page) {
		return this.mapper.findPageByVo(vo, page);
	}
}
