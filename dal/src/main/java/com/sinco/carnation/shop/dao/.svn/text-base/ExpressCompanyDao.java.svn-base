package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.shop.mapper.ExpressCompanyMapper;
import com.sinco.carnation.shop.model.ExpressCompany;
import com.sinco.carnation.shop.bo.ExpressCompanyBO;
import com.sinco.carnation.shop.model.ExpressCompanyExample;
import com.sinco.dal.common.MyPage;

@Repository
public class ExpressCompanyDao {

	@Autowired
	private ExpressCompanyMapper mapper;

	/** generate code begin **/
	public List<ExpressCompanyBO> findAll() {
		ExpressCompanyExample example = new ExpressCompanyExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		ExpressCompanyExample example = new ExpressCompanyExample();
		return mapper.countByExample(example);
	}

	public List<ExpressCompany> save(Iterable<ExpressCompany> entities) {
		List<ExpressCompany> list = new ArrayList<ExpressCompany>();
		for (ExpressCompany ExpressCompany : entities) {
			list.add(save(ExpressCompany));
		}
		return list;
	}

	public ExpressCompany save(ExpressCompany record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(ExpressCompany record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public ExpressCompanyBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public ExpressCompanyBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		ExpressCompanyExample example = new ExpressCompanyExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<ExpressCompanyBO> findAll(Iterable<Long> ids) {
		ExpressCompanyExample example = new ExpressCompanyExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(ExpressCompany entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<ExpressCompany> entities) {
		List<Long> ids = Lists.newArrayList();
		for (ExpressCompany entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ExpressCompanyExample example = new ExpressCompanyExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ExpressCompanyExample example = new ExpressCompanyExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<ExpressCompanyBO> queryExpressCompanyPage(MyPage<ExpressCompanyBO> page) {
		return mapper.queryExpressCompanyPage(page);
	}

	public int deleteExpressCompanyById(Long[] ids) {
		return mapper.deleteExpressCompanyById(ids);
	}

	public List<ExpressCompanyBO> selectByExampleWithBLOBs(ExpressCompanyExample example) {
		return mapper.selectByExample(example);
	}

	public List<ExpressCompanyBO> findListByStatus(Integer companyStatus) {
		return mapper.findListByStatus(companyStatus);
	}
}
