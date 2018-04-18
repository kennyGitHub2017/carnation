package com.sinco.carnation.shop.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.sinco.carnation.shop.bo.PredepositCashBO;
import com.sinco.carnation.shop.mapper.PredepositCashMapper;
import com.sinco.carnation.shop.model.PredepositCash;
import com.sinco.carnation.shop.model.PredepositCashExample;
import com.sinco.carnation.shop.vo.PredepositCashVO;
import com.sinco.carnation.user.vo.OperatorVO;
import com.sinco.dal.common.MyPage;

@Repository
public class PredepositCashDao {

	@Autowired
	private PredepositCashMapper mapper;

	/** generate code begin **/
	public List<PredepositCashBO> findAll() {
		PredepositCashExample example = new PredepositCashExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		PredepositCashExample example = new PredepositCashExample();
		return mapper.countByExample(example);
	}

	public List<PredepositCash> save(Iterable<PredepositCash> entities) {
		List<PredepositCash> list = new ArrayList<PredepositCash>();
		for (PredepositCash PredepositCash : entities) {
			list.add(save(PredepositCash));
		}
		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public PredepositCash save(PredepositCash record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(PredepositCash record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public PredepositCashBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public PredepositCashBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		PredepositCashExample example = new PredepositCashExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<PredepositCashBO> findAll(Iterable<Long> ids) {
		PredepositCashExample example = new PredepositCashExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(PredepositCash entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<PredepositCash> entities) {
		List<Long> ids = Lists.newArrayList();
		for (PredepositCash entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		PredepositCashExample example = new PredepositCashExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		PredepositCashExample example = new PredepositCashExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<PredepositCashBO> queryPredepositCashByUid(Long userId) {
		return mapper.queryPredepositCashByUid(userId);
	}

	public PredepositCashBO queryOnlyOneByUid(Long userId) {
		return mapper.queryOnlyOneByUid(userId);
	}

	public List<PredepositCashBO> queryByUserId(Long userId, OperatorVO vo, MyPage<PredepositCashBO> page) {
		return mapper.queryByUserId(userId, vo, page);
	}

	public List<PredepositCashBO> queryPredepositCashPageList(String pdPayment, String pdPayStatus,
			String pdStatus, String pdRemittanceUser, String pdRemittanceBank, String pdUserName,
			String beginTime, String endTime, String userType, MyPage<PredepositCashBO> page) {
		return mapper.queryPredepositCashPageList(pdPayment, pdPayStatus, pdStatus, pdRemittanceUser,
				pdRemittanceBank, pdUserName, beginTime, endTime, userType, page);
	}
	
	public List<PredepositCashBO>  ListPredepositCashPageByUserCode(String userCode,String pdPayment, String pdPayStatus,
			String pdStatus, String pdRemittanceUser, String pdRemittanceBank, String pdUserName,
			String beginTime, String endTime, String userType, MyPage<PredepositCashBO> page) {
		return mapper.queryPredepositCashPageList(pdPayment, pdPayStatus, pdStatus, pdRemittanceUser,
				pdRemittanceBank, pdUserName, beginTime, endTime, userType, page);
	}

	public List<PredepositCashBO> findPredepositPageList(Long uid, MyPage<PredepositCashBO> page) {
		return mapper.findPredepositPageList(uid, page);
	}

	/** 根据VO查询提现记录 **/
	public List<PredepositCashBO> listPredepositCashByVO(PredepositCashVO vo) {
		if (vo == null) {
			return null;
		}
		if (vo.getCashUserId() == null) {
			return null;
		}
		return mapper.listPredepositCashByVO(vo);
	}

	/** 根据VO查询提现总金额 **/
	public BigDecimal countCashAmountByVO(PredepositCashVO vo) {
		if (vo == null) {
			return BigDecimal.ZERO;
		}
		if (vo.getCashUserId() == null) {
			return BigDecimal.ZERO;
		}
		BigDecimal result = mapper.countCashAmountByVO(vo);
		return result == null ? BigDecimal.ZERO : result;
	}	
	
	public BigDecimal sumPredepositCashPageList(String pdPayment, String pdPayStatus,
			String pdStatus, String pdRemittanceUser, String pdRemittanceBank, String pdUserName,
			String beginTime, String endTime, String userType) {
		return mapper.sumPredepositCashPageList(pdPayment, pdPayStatus, pdStatus, pdRemittanceUser,
				pdRemittanceBank, pdUserName, beginTime, endTime, userType);
	}
}
