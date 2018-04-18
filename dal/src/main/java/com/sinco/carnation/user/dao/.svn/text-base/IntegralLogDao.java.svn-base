package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sys.vo.IntegralRegVO;
import com.sinco.carnation.user.bo.IntegralLogBO;
import com.sinco.carnation.user.mapper.IntegralLogMapper;
import com.sinco.carnation.user.model.IntegralLog;
import com.sinco.carnation.user.model.IntegralLogExample;
import com.sinco.carnation.user.vo.IntegralLogVO;
import com.sinco.dal.common.MyPage;

@Repository
public class IntegralLogDao {

	@Autowired
	private IntegralLogMapper mapper;

	/** generate code begin **/
	public List<IntegralLogBO> findAll() {
		IntegralLogExample example = new IntegralLogExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		IntegralLogExample example = new IntegralLogExample();
		return mapper.countByExample(example);
	}

	public List<IntegralLog> save(Iterable<IntegralLog> entities) {
		List<IntegralLog> list = new ArrayList<IntegralLog>();
		for (IntegralLog IntegralLog : entities) {
			list.add(save(IntegralLog));
		}
		return list;
	}

	public IntegralLog save(IntegralLog record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	
	
	public void update(IntegralLog record) {
		mapper.updateByPrimaryKeySelective(record);
	}
	public void updateBlanceByPrimaryKeySelective(IntegralLog record) {
		mapper.updateBlanceByPrimaryKeySelective(record);
	}
	
	public IntegralLogBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public IntegralLogBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		IntegralLogExample example = new IntegralLogExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public List<IntegralLogBO> findAll(Iterable<Long> ids) {
		IntegralLogExample example = new IntegralLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public List<IntegralLogBO> findByType(String type, Long id) {
		IntegralLogExample example = new IntegralLogExample();
		example.createCriteria().andTypeEqualTo(type).andIntegralUserIdEqualTo(id);
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(IntegralLog entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<IntegralLog> entities) {
		List<Long> ids = Lists.newArrayList();
		for (IntegralLog entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		IntegralLogExample example = new IntegralLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		IntegralLogExample example = new IntegralLogExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<IntegralLogBO> queryIntegralPageList(String loginName, MyPage<IntegralLogBO> page) {
		return mapper.queryIntegralPageList(loginName, page);
	}

	public int checkIntegralLog(IntegralRegVO vo) {
		return this.mapper.checkIntegralLog(vo);
	}
	public int checkIntegralLogByTime(IntegralRegVO vo) {
		return this.mapper.checkIntegralLogByTime(vo);
	}

	public IntegralLogBO querySignIntegralLogYestoday(Long integralUserId, String type, String regType) {
		List<IntegralLogBO> list = this.mapper.querySignIntegralLogYestoday(integralUserId, type, regType);
		return list != null && list.size() > 0 ? list.get(0) : null;
	}

	public List<IntegralLogBO> queryByVO(IntegralLogVO vo, MyPage<IntegralLogBO> page) {
		return mapper.queryByVO(vo, page);
	}

	public List<IntegralLogBO> queryIntegralPageListByUid(Long uid, MyPage<IntegralLogBO> page) {
		return mapper.queryIntegralPageListByUid(uid, page);
	}

	public List<IntegralLogBO> queryUserIntegralPageListByUid(Long uid, String markType,
			MyPage<IntegralLogBO> page) {
		return mapper.queryUserIntegralPageListByUid(uid, markType, page);
	}

	public List<IntegralLogBO> selectIntegralPageList(String loginName, String type,String beginTime,String endTime,
			MyPage<IntegralLogBO> page) {
		return mapper.selectIntegralPageList(loginName, type,beginTime,endTime,page);
	}

	/**
	 * 根据uid查询会员当天的积分日志
	 * 
	 * @param Uid
	 * @return
	 */
	public List<IntegralLogBO> findListByUid(Long Uid) {
		return mapper.findListByUid(Uid);
	}
	/**
	 * 根据uid查询会员指定日期的积分日志
	 * 
	 * @param Uid
	 * @return
	 */
	public List<IntegralLogBO> findListByUidTime(Long Uid,Date addTime) {
		return mapper.findListByUidTime(Uid,addTime);
	}

	/** 根据uid time type 获取积分日志**/
	public IntegralLogBO getByUidTimeType(Long uid ,Date time ,String type){
		if(null == uid || null == time || null == type){
			return null;
		}
		List<IntegralLogBO> list = mapper.getByUidTimeType(uid, time, type);
		if(null != list && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	/** 根据uid time type 获取积分日志**/
	public IntegralLogBO getLastByUidType(Long uid ,String type){
		if(null == uid || null == type){
			return null;
		}
		return mapper.getLastByUidType(uid, type);
	}
	
//	public List<IntegralLogBO> listErrorUidByType(){
//		return mapper.listErrorUidByType();
//	}
//	public List<IntegralLogBO> listErrorByUidId(){
//		return mapper.listErrorUidByType();
//	}
//	public Integer sumErrorByUidType(Long uid ,String type){
//		Integer result = mapper.sumErrorByUidType(uid,type);
//		if(result == null){
//			result = 0;
//		}
//		return result;
//	}
//	public List<IntegralLogBO> listErrorByUidId(Long uid ,Long id){
//		return mapper.listErrorByUidId(uid, id);
//	}
//	public List<IntegralLogBO> listErrorByUidType(Long uid ,String type){
//		return mapper.listErrorByUidType(uid, type);
//	}
}
