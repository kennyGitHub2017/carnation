package com.sinco.carnation.goods.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.goods.bo.ReturnGoodsLogBO;
import com.sinco.carnation.goods.mapper.ReturnGoodsLogMapper;
import com.sinco.carnation.goods.model.ReturnGoodsLog;
import com.sinco.carnation.goods.model.ReturnGoodsLogExample;
import com.sinco.carnation.goods.vo.ReturnGoodsLogVO;
import com.sinco.dal.common.MyPage;

@Repository
public class ReturnGoodsLogDao {

	@Autowired
	private ReturnGoodsLogMapper mapper;

	public ReturnGoodsLogBO findBOById(Long id) {
		return mapper.findBOById(id);
	}

	public int selectCountByStatus(Integer refundStatus, String goodsReturnStatus) {
		ReturnGoodsLogExample example = new ReturnGoodsLogExample();
		example.createCriteria().andDeleteStatusEqualTo(false).andRefundStatusEqualTo(refundStatus)
				.andGoodsReturnStatusEqualTo(goodsReturnStatus);
		return mapper.countByExample(example);
	}

	public int selectCountByStatus(Long storeId, String goodsReturnStatus) {
		ReturnGoodsLogExample example = new ReturnGoodsLogExample();
		example.createCriteria().andDeleteStatusEqualTo(false).andStoreIdEqualTo(storeId)
				.andGoodsReturnStatusEqualTo(goodsReturnStatus);
		example.setOrderByClause(" addTime desc");
		return mapper.countByExample(example);
	}

	public int selectCountByGoodsTypeAndStatus(Integer goodsType, String goodsReturnStatus) {
		ReturnGoodsLogExample example = new ReturnGoodsLogExample();
		example.createCriteria().andDeleteStatusEqualTo(false).andGoodsTypeEqualTo(goodsType)
				.andGoodsReturnStatusEqualTo(goodsReturnStatus);
		return mapper.countByExample(example);
	}

	/** generate code begin **/
	public List<ReturnGoodsLogBO> findAll() {
		ReturnGoodsLogExample example = new ReturnGoodsLogExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		ReturnGoodsLogExample example = new ReturnGoodsLogExample();
		return mapper.countByExample(example);
	}

	public List<ReturnGoodsLog> save(Iterable<ReturnGoodsLog> entities) {
		List<ReturnGoodsLog> list = new ArrayList<ReturnGoodsLog>();
		for (ReturnGoodsLog ReturnGoodsLog : entities) {
			list.add(save(ReturnGoodsLog));
		}
		return list;
	}

	public ReturnGoodsLog save(ReturnGoodsLog record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	@SuppressWarnings("rawtypes")
	public List<ReturnGoodsLogBO> selectByUser(Long userId, MyPage<Map> page) {
		return mapper.selectByUser(userId, page);
	}

	@SuppressWarnings("rawtypes")
	public List<ReturnGoodsLogBO> search(ReturnGoodsLogVO vo, MyPage<Map> page) {
		return mapper.search(vo, page);
	}

	public int goodsUserIdCount(Long userId, Long goodsId, Long returnOrderId, String goodsGspIds) {
		ReturnGoodsLogExample example = new ReturnGoodsLogExample();
		ReturnGoodsLogExample.Criteria c = example.createCriteria().andUserIdEqualTo(userId)
				.andGoodsIdEqualTo(goodsId).andReturnOrderIdEqualTo(returnOrderId);
		if (StringUtils.isNotBlank(goodsGspIds)) {
			c.andGoodsGspIdsEqualTo(goodsGspIds);
		}
		return mapper.countByExample(example);
	}

	public void update(ReturnGoodsLog record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public ReturnGoodsLogBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public ReturnGoodsLogBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		ReturnGoodsLogExample example = new ReturnGoodsLogExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<ReturnGoodsLogBO> findAll(Iterable<Long> ids) {
		ReturnGoodsLogExample example = new ReturnGoodsLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(ReturnGoodsLog entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public int cancelReturnGoods(ReturnGoodsLogVO vo) {
		return mapper.cancelReturnGoods(vo);
	}

	public void delete(Iterable<ReturnGoodsLog> entities) {
		List<Long> ids = Lists.newArrayList();
		for (ReturnGoodsLog entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ReturnGoodsLogExample example = new ReturnGoodsLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ReturnGoodsLogExample example = new ReturnGoodsLogExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<ReturnGoodsLog> queryReturnGoodsLogPageList(String userName, String goodsName,
			String returnServiceId, String status, MyPage<ReturnGoodsLog> page) {
		return mapper.queryReturnGoodsLogPageList(userName, goodsName, returnServiceId, status, page);
	}

	public List<ReturnGoodsLogBO> findListByVo(MyPage<ReturnGoodsLogBO> page, ReturnGoodsLogVO vo) {
		return this.mapper.selectListByVo(page, vo);
	}

	public int selectCountByOrderIdAndStatus(Long orderId, List<String> status) {
		ReturnGoodsLogExample example = new ReturnGoodsLogExample();
		example.createCriteria().andDeleteStatusEqualTo(false).andReturnOrderIdEqualTo(orderId)
				.andGoodsReturnStatusIn(status);
		return mapper.countByExample(example);
	}

	public List<ReturnGoodsLogBO> selectByOrderId(Long orderId) {
		ReturnGoodsLogExample example = new ReturnGoodsLogExample();
		example.createCriteria().andDeleteStatusEqualTo(false).andReturnOrderIdEqualTo(orderId);
		return mapper.selectByExample(example);
	}

}
