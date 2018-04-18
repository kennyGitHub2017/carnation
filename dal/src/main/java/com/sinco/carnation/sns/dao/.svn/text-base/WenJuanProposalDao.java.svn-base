package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.sns.mapper.WenJuanProposalMapper;
import com.sinco.carnation.sns.model.WenJuanProposal;
import com.sinco.carnation.sns.bo.WenJuanProposalBO;
import com.sinco.carnation.sns.model.WenJuanProposalExample;

@Repository
public class WenJuanProposalDao {

	@Autowired
	private WenJuanProposalMapper mapper;

	/** generate code begin **/
	public List<WenJuanProposalBO> findAll() {
		WenJuanProposalExample example = new WenJuanProposalExample();
		return mapper.selectByExample(example);
	}

	List<WenJuanProposalBO> findAll(Iterable<Long> ids) {
		WenJuanProposalExample example = new WenJuanProposalExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		WenJuanProposalExample example = new WenJuanProposalExample();
		return mapper.countByExample(example);
	}

	public List<WenJuanProposal> save(Iterable<WenJuanProposal> entities) {
		List<WenJuanProposal> list = new ArrayList<WenJuanProposal>();
		for (WenJuanProposal WenJuanProposal : entities) {
			list.add(save(WenJuanProposal));
		}
		return list;
	}

	public WenJuanProposal save(WenJuanProposal record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(WenJuanProposal record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public WenJuanProposalBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		WenJuanProposalExample example = new WenJuanProposalExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(WenJuanProposal entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<WenJuanProposal> entities) {
		List<Long> ids = Lists.newArrayList();
		for (WenJuanProposal entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		WenJuanProposalExample example = new WenJuanProposalExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		WenJuanProposalExample example = new WenJuanProposalExample();
		mapper.deleteByExample(example);
	}

	public List<WenJuanProposalBO> select_proposal_by_groupResultID(Long groupResultID) {
		return this.mapper.select_proposal_by_groupResultID(groupResultID);
	}

	public List<WenJuanProposalBO> selectByGroupResultIDTypeDao(Long groupResultID, Integer type) {
		return this.mapper.select_By_groupResultID_Type(groupResultID, type);
	}

	public List<WenJuanProposalBO> selectProposalByInGroupResultID(List<Long> list) {
		return this.mapper.select_proposal_By_In_groupResultID(list);
	}

	public WenJuanProposalBO selectByWJGroupResultID(long resultID) {
		return this.mapper.selectByWJGroupResultID(resultID);
	}
}
