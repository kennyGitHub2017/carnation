package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.shop.bo.ComplaintBO;
import com.sinco.carnation.shop.mapper.ComplaintMapper;
import com.sinco.carnation.shop.model.Complaint;
import com.sinco.carnation.shop.model.ComplaintExample;
import com.sinco.carnation.shop.vo.ComplaintVO;
import com.sinco.dal.common.MyPage;

@Repository
public class ComplaintDao {

	@Autowired
	private ComplaintMapper mapper;

	public int findCountByStatusAndTime(Integer status, Date time) {
		ComplaintExample example = new ComplaintExample();
		example.createCriteria().andStatusEqualTo(status).andDeleteStatusEqualTo(false)
				.andAddTimeGreaterThanOrEqualTo(time);
		return mapper.countByExample(example);
	}

	public int findCountByStatusAndToUserId(Integer status, Long toUserId) {
		ComplaintExample example = new ComplaintExample();
		example.createCriteria().andStatusEqualTo(status).andDeleteStatusEqualTo(false)
				.andToUserIdEqualTo(toUserId);
		return mapper.countByExample(example);
	}

	/** generate code begin **/
	public List<ComplaintBO> findAll() {
		ComplaintExample example = new ComplaintExample();
		return mapper.selectByExample(example);
	}

	public List<ComplaintBO> selectByUser(Long fromUserId, String status, MyPage<ComplaintBO> page) {
		return mapper.selectByUser(fromUserId, status, page);
	}

	public long count() {
		ComplaintExample example = new ComplaintExample();
		return mapper.countByExample(example);
	}

	public List<Complaint> save(Iterable<Complaint> entities) {
		List<Complaint> list = new ArrayList<Complaint>();
		for (Complaint Complaint : entities) {
			list.add(save(Complaint));
		}
		return list;
	}

	public Complaint save(Complaint record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(Complaint record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public ComplaintBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public ComplaintBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		ComplaintExample example = new ComplaintExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<ComplaintBO> findAll(Iterable<Long> ids) {
		ComplaintExample example = new ComplaintExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Complaint entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Complaint> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Complaint entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ComplaintExample example = new ComplaintExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ComplaintExample example = new ComplaintExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<ComplaintBO> queryComplaintPageList(String status, String title, String formName,
			String beginTime, String endTime, MyPage<ComplaintBO> page) {
		return mapper.queryComplaintPageList(status, title, formName, beginTime, endTime, page);
	}

	public List<ComplaintBO> queryComplaintPageListSelf(String status, String title, String formName,
			String beginTime, String endTime, MyPage<ComplaintBO> page) {
		return mapper.queryComplaintPageListSelf(status, title, formName, beginTime, endTime, page);
	}

	public ComplaintBO queryComplaintById(Long comId) {
		List<ComplaintBO> list = mapper.queryComplaintById(comId);
		return list.isEmpty() ? null : list.get(0);
	}

	public List<ComplaintBO> querySelfComplaintPageList(String status, String title, String formName,
			String beginTime, String endTime, MyPage<ComplaintBO> page) {
		return mapper.querySelfComplaintPageList(status, title, formName, beginTime, endTime, page);
	}

	public List<ComplaintBO> findListByVO(MyPage<ComplaintBO> page, ComplaintVO vo) {
		return mapper.findListByVO(page, vo);
	}

	public List<Map<String, Integer>> findCountByToUserId(Long userId) {
		return mapper.findCountByToUserId(userId);
	}
}
