package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sns.mapper.WenJuanProposalDetailedMapper;
import com.sinco.carnation.sns.model.WenJuanProposalDetailed;
import com.sinco.carnation.sns.bo.WenJuanProposalDetailedBO;
import com.sinco.carnation.sns.model.WenJuanProposalDetailedExample;

@Repository
public class WenJuanProposalDetailedDao {

	@Autowired
	private WenJuanProposalDetailedMapper mapper;

	/** generate code begin **/
	public List<WenJuanProposalDetailedBO> findAll() {
		WenJuanProposalDetailedExample example = new WenJuanProposalDetailedExample();
		return mapper.selectByExample(example);
	}

	List<WenJuanProposalDetailedBO> findAll(Iterable<Long> ids) {
		WenJuanProposalDetailedExample example = new WenJuanProposalDetailedExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		WenJuanProposalDetailedExample example = new WenJuanProposalDetailedExample();
		return mapper.countByExample(example);
	}

	public List<WenJuanProposalDetailed> save(Iterable<WenJuanProposalDetailed> entities) {
		List<WenJuanProposalDetailed> list = new ArrayList<WenJuanProposalDetailed>();
		for (WenJuanProposalDetailed WenJuanProposalDetailed : entities) {
			list.add(save(WenJuanProposalDetailed));
		}
		return list;
	}

	public WenJuanProposalDetailed save(WenJuanProposalDetailed record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(WenJuanProposalDetailed record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public WenJuanProposalDetailedBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		WenJuanProposalDetailedExample example = new WenJuanProposalDetailedExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(WenJuanProposalDetailed entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<WenJuanProposalDetailed> entities) {
		List<Long> ids = Lists.newArrayList();
		for (WenJuanProposalDetailed entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		WenJuanProposalDetailedExample example = new WenJuanProposalDetailedExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		WenJuanProposalDetailedExample example = new WenJuanProposalDetailedExample();
		mapper.deleteByExample(example);
	}

	public List<WenJuanProposalDetailedBO> select_ProposalDetailed_By_ProposalID(Long proposalID) {
		return this.mapper.select_ProposalDetailed_By_ProposalID(proposalID);
	}

	public List<WenJuanProposalDetailedBO> select_ProposalDetailed_By_ProposalIDAndType(Long proposalID,
			Long types) {
		return this.mapper.select_ProposalDetailed_By_ProposalIDAndType(proposalID, types);
	}

	public WenJuanProposalDetailedBO selectOneByProposalIDAndType(Long proposalID, Long types) {
		return this.mapper.selectOneByProposalIDAndType(proposalID, types);
	}
}
