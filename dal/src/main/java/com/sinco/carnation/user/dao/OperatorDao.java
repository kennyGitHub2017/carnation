package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.user.UserContants;
import com.sinco.carnation.user.bo.OperatorBO;
import com.sinco.carnation.user.mapper.OperatorMapper;
import com.sinco.carnation.user.model.Operator;
import com.sinco.carnation.user.model.OperatorExample;
import com.sinco.carnation.user.vo.OperatorVO;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.DicNameMappingHandle;

@Repository
public class OperatorDao {

	@Autowired
	private OperatorMapper mapper;
	@Autowired
	private DicNameMappingHandle dicNameMappingHandle;

	public int selectOperatorCountByArea(String areaId) {
		return mapper.selectOperatorCountByArea(areaId);
	}

	public List<OperatorBO> selectOperatorByAreaAndCode(String operatorCode, String areaId) {
		return mapper.selectOperatorByAreaAndCode(operatorCode, areaId);
	}

	public List<OperatorBO> selectOperatorBySellerUserId(Long sellerUserId, String queryLevel) {
		return mapper.selectOperatorBySellerUserId(sellerUserId, queryLevel);
	}

	public OperatorBO selectByInvitationCode(String invitationCode) {
		return mapper.selectByInvitationCode(invitationCode);
	}

	/**
	 * 注册运营商数量
	 * 
	 * @param vo
	 * @return
	 */
	public int selectRegisterOperatorCount(OperatorVO vo) {
		return mapper.selectRegisterOperatorCount(vo);
	}

	public int selectOwnOperatorCount(OperatorVO vo) {
		return mapper.selectOwnOperatorCount(vo);
	}

	/**
	 * 根据运营商编码 count
	 * 
	 * @param operatorCode
	 * @return
	 */
	public int countByOperatorCode(String operatorCode) {
		OperatorExample example = new OperatorExample();
		example.createCriteria().andOperatorCodeEqualTo(operatorCode)
				.andStatusEqualTo(UserContants.OPERATOR_CHECK_STATUS_PASS);
		return mapper.countByExample(example);
	}

	public OperatorBO getOperatorBOByUserId(Long userId) {
		OperatorExample example = new OperatorExample();
		// example.createCriteria().andUserIdEqualTo(userId).andIsDeletedEqualTo(false).andStatusEqualTo(UserContants.OPERATOR_CHECK_STATUS_PASS);
		example.createCriteria().andUserIdEqualTo(userId).andIsDeletedEqualTo(false);
		List<OperatorBO> list = mapper.selectByExample(example);
		dicNameMappingHandle.mappinHandle(list);
		return list.size() > 0 ? list.get(0) : null;
	}

	public OperatorBO getOperatorBOByOperatorCode(String operatorCode) {
		OperatorExample example = new OperatorExample();
		example.createCriteria().andOperatorCodeEqualTo(operatorCode).andIsDeletedEqualTo(false)
				.andStatusEqualTo(UserContants.OPERATOR_CHECK_STATUS_PASS);
		List<OperatorBO> list = mapper.selectByExample(example);
		return list.size() > 0 ? list.get(0) : null;
	}

	public List<OperatorBO> getOperatorBOByOperatorAreaId(String operatorAreaId) {
		OperatorExample example = new OperatorExample();
		example.createCriteria().andOperatorAreaIdEqualTo(operatorAreaId).andIsDeletedEqualTo(false)
				.andStatusNotEqualTo(UserContants.OPERATOR_CHECK_STATUS_FAILD);
		List<OperatorBO> list = mapper.selectByExample(example);
		return list;
	}

	public List<OperatorBO> getCheckOkOperatorByOperatorAreaId(String operatorAreaId) {
		return mapper.getCheckOkOperatorByOperatorAreaId(operatorAreaId);
	}

	public List<OperatorBO> getOperatorBOByOperatorAreaIdOrderByAssignedTime(String operatorAreaId) {
		OperatorExample example = new OperatorExample();
		example.createCriteria().andOperatorAreaIdEqualTo(operatorAreaId).andIsDeletedEqualTo(false)
				.andStatusEqualTo(UserContants.OPERATOR_CHECK_STATUS_PASS);
		example.setOrderByClause("assigned_time asc");
		List<OperatorBO> list = mapper.selectByExample(example);
		return list;
	}

	public List<OperatorBO> getOperatorBOByOperatorAreaIdAndLevel(String operatorAreaId, String level) {
		OperatorExample example = new OperatorExample();
		example.createCriteria().andOperatorAreaIdEqualTo(operatorAreaId).andLevelEqualTo(level)
				.andIsDeletedEqualTo(false).andStatusEqualTo(UserContants.OPERATOR_CHECK_STATUS_PASS);
		List<OperatorBO> list = mapper.selectByExample(example);
		return list;
	}

	public OperatorBO getOperatorBOByIdAndStatus(Long id, String status) {
		OperatorExample example = new OperatorExample();
		example.createCriteria().andIdEqualTo(id).andStatusEqualTo(status).andIsDeletedEqualTo(false);
		List<OperatorBO> list = mapper.selectByExample(example);
		dicNameMappingHandle.mappinHandle(list);
		return list.size() > 0 ? list.get(0) : null;
	}

	public List<OperatorBO> selectOperatorPageList(MyPage<OperatorBO> page, OperatorVO vo) {
		List<OperatorBO> list = mapper.selectOperatorPageList(page, vo);
		dicNameMappingHandle.mappinHandle(list);
		dicNameMappingHandle.mappinHandle(vo);
		if (page != null) {
			page.setContent(list);
		}
		return list;
	}

	public List<OperatorBO> selectRegisterOperatorPageList(MyPage<OperatorBO> page, OperatorVO vo) {
		List<OperatorBO> list = mapper.selectRegisterOperatorPageList(page, vo);
		dicNameMappingHandle.mappinHandle(list);
		return list;
	}

	public List<OperatorBO> selectOwnOperatorPageList(MyPage<OperatorBO> page, OperatorVO vo) {
		List<OperatorBO> list = mapper.selectOwnOperatorPageList(page, vo);
		dicNameMappingHandle.mappinHandle(list);
		return list;
	}

	/** generate code begin **/
	public List<OperatorBO> findAll() {
		OperatorExample example = new OperatorExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		OperatorExample example = new OperatorExample();
		return mapper.countByExample(example);
	}

	public List<Operator> save(Iterable<Operator> entities) {
		List<Operator> list = new ArrayList<Operator>();
		for (Operator Operator : entities) {
			list.add(save(Operator));
		}
		return list;
	}

	public Operator save(Operator record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(Operator record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public OperatorBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public OperatorBO get(java.lang.Long id) {
		OperatorBO operatorBO = mapper.selectByPrimaryKey(id);
		dicNameMappingHandle.mappinHandle(operatorBO);
		return operatorBO;
	}

	public boolean exists(java.lang.Long id) {
		OperatorExample example = new OperatorExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<OperatorBO> findAll(Iterable<Long> ids) {
		OperatorExample example = new OperatorExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Operator entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Operator> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Operator entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		OperatorExample example = new OperatorExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		OperatorExample example = new OperatorExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public OperatorBO queryOperatorInfo(Long uid) {
		return mapper.queryOperatorInfo(uid);
	}

	public OperatorBO getOperatorByMobile(String mobile) {
		OperatorExample example = new OperatorExample();
		example.createCriteria().andPhoneEqualTo(mobile);
		List<OperatorBO> list = mapper.selectByExample(example);
		return list.isEmpty() ? null : list.get(0);
	}

	public OperatorBO selectOperatorByCnUserName(String cn_username) {
		// TODO Auto-generated method stub
		return mapper.selectOperatorByCnUserName(cn_username);
	}

	public List<OperatorBO> getLevelAndArea(String areaId, Integer level) {
		return this.mapper.getLevelAndArea(areaId, level);
	}
	
	public OperatorBO queryOperatorByOperatorCode(String operatorCode)
	{
		return this.mapper.queryOperatorByOperatorCode(operatorCode);
	}


	public List<OperatorBO> listAllOperator() {
		return this.mapper.listAllOperator();
	}
}
