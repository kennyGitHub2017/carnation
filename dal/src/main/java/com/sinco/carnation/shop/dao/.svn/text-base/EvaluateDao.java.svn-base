package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.shop.bo.EvaluateBO;
import com.sinco.carnation.shop.mapper.EvaluateMapper;
import com.sinco.carnation.shop.model.Evaluate;
import com.sinco.carnation.shop.model.EvaluateExample;
import com.sinco.carnation.shop.vo.EvaluateVO;
import com.sinco.dal.common.MyPage;

@Repository
public class EvaluateDao {

	@Autowired
	private EvaluateMapper mapper;

	public List<Long> selectDistinctGoodsId() {
		return mapper.selectDistinctGoodsId();
	}

	public List<Evaluate> selectByExample(EvaluateExample example) {
		return mapper.selectByExample(example);
	}

	public List<Evaluate> selectEvaluateByGoodsId(Long goodsId) {
		EvaluateExample example = new EvaluateExample();
		example.createCriteria().andEvaluateGoodsIdEqualTo(goodsId).andDeleteStatusEqualTo(0);
		example.setOrderByClause(" add_time desc");
		return mapper.selectByExample(example);
	}

	public List<EvaluateBO> queryStatusLess2(Long storeId) {
		return mapper.queryStatusLess2(storeId);
	}

	public List<Evaluate> selectEvaluateByAndBuyerGoodsId(Long goodsId, Integer evaluateBuyer) {
		EvaluateExample example = new EvaluateExample();
		example.createCriteria().andEvaluateGoodsIdEqualTo(goodsId).andDeleteStatusEqualTo(0)
				.andEvaluateBuyerValEqualTo(evaluateBuyer);
		return mapper.selectByExample(example);
	}

	/** generate code begin **/
	public List<Evaluate> findAll() {
		EvaluateExample example = new EvaluateExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		EvaluateExample example = new EvaluateExample();
		return mapper.countByExample(example);
	}

	public List<Evaluate> save(Iterable<Evaluate> entities) {
		List<Evaluate> list = new ArrayList<Evaluate>();
		for (Evaluate Evaluate : entities) {
			list.add(save(Evaluate));
		}
		return list;
	}

	public Evaluate save(Evaluate record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(Evaluate record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public Evaluate findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public Evaluate get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		EvaluateExample example = new EvaluateExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<Evaluate> findAll(Iterable<Long> ids) {
		EvaluateExample example = new EvaluateExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Evaluate entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Evaluate> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Evaluate entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		EvaluateExample example = new EvaluateExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		EvaluateExample example = new EvaluateExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<EvaluateBO> queryEvaluateList(String nickName, String goodsName, MyPage<EvaluateBO> page) {
		return mapper.queryEvaluateList(nickName, goodsName, page);
	}

	public List<EvaluateBO> queryEvaluateListByVO(EvaluateVO vo, MyPage<EvaluateBO> page) {
		return mapper.queryEvaluateListByVO(vo, page);
	}

	public EvaluateBO queryEvaluateById(Long evaId) {
		return mapper.queryEvaluateById(evaId);
	}

	public List<EvaluateBO> queryEvaluateGoods(Integer replyStatus, Integer goodsType, MyPage<EvaluateBO> page) {
		return mapper.queryEvaluateGoods(replyStatus, goodsType, page);
	}

	public List<EvaluateBO> queryByUserId(Long userId) {
		return mapper.queryByUserId(userId);
	}

	public List<EvaluateBO> queryByVO(EvaluateVO vo, MyPage<EvaluateBO> page) {
		return mapper.queryByVO(vo, page);
	}

	public List<EvaluateBO> queryByStoreId(Long storeId) {
		return mapper.queryByStoreId(storeId);
	}

	public List<EvaluateBO> findListByVo(MyPage<EvaluateBO> page, EvaluateVO vo) {
		return mapper.findListByVo(page, vo);
	}

	public List<EvaluateBO> queryEvaultePageList(Long userId, MyPage<EvaluateBO> page) {
		return mapper.queryEvaultePageList(userId, page);
	}

	public List<EvaluateBO> queryEvaultePageListByVal(Long userId, String evaluateBuyerVal,
			MyPage<EvaluateBO> page) {
		return mapper.queryEvaultePageListByVal(userId, evaluateBuyerVal, page);
	}

	public Evaluate fetch(Long userId, Long goodsId) {
		return mapper.fetch(userId, goodsId);
	}

	public Evaluate fetch(Long userId, Long goodsId, Long ofId) {
		return mapper.getEvaluate(userId, goodsId, ofId);
	}

}
