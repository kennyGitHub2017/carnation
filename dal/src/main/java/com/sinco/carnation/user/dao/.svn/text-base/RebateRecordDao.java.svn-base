package com.sinco.carnation.user.dao;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.store.vo.StoreVO;
import com.sinco.carnation.user.bo.RebateRecordBO;
import com.sinco.carnation.user.mapper.RebateRecordMapper;
import com.sinco.carnation.user.model.RebateRecord;
import com.sinco.carnation.user.model.RebateRecordExample;
import com.sinco.carnation.user.vo.RebateRecordVO;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.DicNameMappingHandle;

@Repository
public class RebateRecordDao {

	@Autowired
	private RebateRecordMapper mapper;
	@Autowired
	private DicNameMappingHandle dicNameMappingHandle;

//	public boolean updatePreRecordToAlready(String ordernum, long uid, String rebateType) {
//		Map<String, String> argumentsMap = new HashMap<String, String>();
//		argumentsMap.put("ordernum", ordernum);
//		argumentsMap.put("uid", String.valueOf(uid));
//		argumentsMap.put("rebateType", rebateType);
//		// 修改时间为到账时间
//		Date date = new Date();
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String time = formatter.format(date);
//		argumentsMap.put("createTime", time);
//		return mapper.updatePreRecordToAlready(argumentsMap);
//	}

	public boolean updatePreRecordToAlready(long id) {
		Map<String, String> argumentsMap = new HashMap<String, String>();
		// 修改时间为到账时间
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = formatter.format(date);
		argumentsMap.put("createTime", time);
		argumentsMap.put("id", String.valueOf(id));
		return mapper.updatePreRecordToAlready(argumentsMap);
	}

	public List<RebateRecordBO> selectOperatorRebateRecordList(Long operatorUserId, String status,
			RebateRecordVO vo, MyPage<RebateRecordBO> page) {
		return mapper.selectOperatorRebateRecordList(operatorUserId, status, vo, page);
	}

	public List<RebateRecordBO> findByChargeFeeOrderIdAndAndSellerId(Long orderId, Long sellerUserId) {
		RebateRecordExample example = new RebateRecordExample();
		example.createCriteria().andOrderIdEqualTo(orderId).andRebateTypeBetween("200", "300");
		return mapper.selectByExample(example);
	}

	/** generate code begin **/
	public List<RebateRecordBO> findAll() {
		RebateRecordExample example = new RebateRecordExample();
		return mapper.selectByExample(example);
	}

	public List<RebateRecordBO> queryByUser(RebateRecordVO vo, MyPage<RebateRecordBO> page) {
		return mapper.queryByUser(vo, page);
	}

	public long count() {
		RebateRecordExample example = new RebateRecordExample();
		return mapper.countByExample(example);
	}

	public List<RebateRecord> save(Iterable<RebateRecord> entities) {
		List<RebateRecord> list = new ArrayList<RebateRecord>();
		for (RebateRecord RebateRecord : entities) {
			list.add(save(RebateRecord));
		}
		return list;
	}

	public RebateRecord selectOneRecordByCodeAndType(String code, String type) {
		Map<String, String> argumentsMap = new HashMap<String, String>();
		argumentsMap.put("rebateType", type);
		argumentsMap.put("rebateCode", code);
		return mapper.selectOneRecordByCodeAndType(argumentsMap);
	}

	public List<RebateRecord> selectOneRecordeByCode(String code) {
		Map<String, String> argumentsMap = new HashMap<String, String>();
		argumentsMap.put("rebateCode", code);
		return mapper.selectOneRecordeByCode(argumentsMap);
	}

	public RebateRecord save(RebateRecord record) {
		int i = mapper.insertSelective(record);
		if (i <= 0) {
			throw new RuntimeException("add rebate record error.");
		}
		return record;
	}

	public void update(RebateRecord record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public RebateRecordBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public RebateRecordBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		RebateRecordExample example = new RebateRecordExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<RebateRecordBO> findAll(Iterable<Long> ids) {
		RebateRecordExample example = new RebateRecordExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(RebateRecord entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<RebateRecord> entities) {
		List<Long> ids = Lists.newArrayList();
		for (RebateRecord entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		RebateRecordExample example = new RebateRecordExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public RebateRecordBO queryrebatesum(Long storeId, String startTime, String endTime, String userType) {
		return mapper.queryrebatesum(storeId, startTime, endTime, userType);
	}

	public List<RebateRecordBO> queryRebateCount(Long uid, String userType) {
		return mapper.queryRebateCount(uid, userType);
	}

	public List<RebateRecordBO> queryShareDetails(Long uid, StoreVO vo, MyPage<RebateRecordBO> page,
			String userType) {
		return mapper.queryShareDetails(uid, vo, page, userType);
	}

	public BigDecimal selectSumAreaByVO(RebateRecordVO vo) {
		return mapper.selectSumAreaByVO(vo);
	}

	public BigDecimal selectSumOwnByVO(RebateRecordVO vo) {
		return mapper.selectSumOwnByVO(vo);
	}

	public BigDecimal selectRebateSumByArea(String areaId, String rebateType) {
		return mapper.selectRebateSumByArea(areaId, rebateType);
	}

	public BigDecimal selectSumByTypeAndUserId(Long userId, String[] typeList, Date startTime, Date endTime) {
		return mapper.selectSumByTypeAndUserId(userId, typeList, startTime, endTime);
	}

	public BigDecimal selectSumByTypeUid(Long userId, String[] typeList, Date startTime, Date endTime,
			int type) {
		return mapper.selectSumByTypeUid(userId, typeList, startTime, endTime, type);
	}

	public BigDecimal selectSumRechargeByUserId(Long userId, Long operatorId, Integer isOwn, Date startTime,
			Date endTime) {
		return mapper.selectSumRechargeByUserId(userId, operatorId, isOwn, startTime, endTime);
	}

	public List<RebateRecordBO> selectOperatorRebateCode(RebateRecordVO vo, MyPage<RebateRecordBO> page) {
		List<RebateRecordBO> result = mapper.selectOperatorRebateCode(vo, page);
		dicNameMappingHandle.mappinHandle(result);
		if (page != null) {
			page.setContent(result);
		}
		return result;
	}

	public List<RebateRecordBO> queryOperatorProfitList(Long uid, Boolean group, Boolean shop,
			MyPage<RebateRecordBO> page) {
		return mapper.queryOperatorProfitList(uid, group, shop, page);
	}

	public List<RebateRecordBO> queryShareListByVO(RebateRecordVO vo, MyPage<RebateRecordBO> page) {
		return mapper.queryShareListByVO(vo, page);
	}

	public BigDecimal selectOperatorRebateRecordTotal(Long operatorUserId, String status) {
		return mapper.selectOperatorRebateRecordTotal(operatorUserId, status);
	}

	public List<RebateRecordBO> findAllByUidAndTime(Long uid, Date startTime, Date endTime) {
		return mapper.findAllByUidAndTime(uid, startTime, endTime);
	}
}
