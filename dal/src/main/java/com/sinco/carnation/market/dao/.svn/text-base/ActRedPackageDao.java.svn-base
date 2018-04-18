package com.sinco.carnation.market.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.market.bo.ActRedPackageBO;
import com.sinco.carnation.market.mapper.ActRedPackageMapper;
import com.sinco.carnation.market.model.ActRedPackage;
import com.sinco.carnation.market.model.ActRedPackageExample;
import com.sinco.carnation.market.vo.ActRedPackageVO;
import com.sinco.dal.common.MyPage;

@Repository
public class ActRedPackageDao {

	@Autowired
	private ActRedPackageMapper mapper;

	// ����Ƿ񼤻�
	public boolean isActivateRed(Long id) {
		ActRedPackageExample example = new ActRedPackageExample();
		example.createCriteria().andIdEqualTo(id).andIsEnabledEqualTo((byte) 1)
				.andStartTimeLessThanOrEqualTo(new Date());
		List<ActRedPackageBO> bos = mapper.selectByExample(example);
		return (bos != null && bos.size() > 0 ? true : false);
	}

	/** generate code begin **/
	public List<ActRedPackageBO> findAll() {
		ActRedPackageExample example = new ActRedPackageExample();
		return mapper.selectByExample(example);
	}

	List<ActRedPackageBO> findAll(Iterable<Long> ids) {
		ActRedPackageExample example = new ActRedPackageExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		ActRedPackageExample example = new ActRedPackageExample();
		return mapper.countByExample(example);
	}

	public List<ActRedPackage> save(Iterable<ActRedPackage> entities) {
		List<ActRedPackage> list = new ArrayList<ActRedPackage>();
		for (ActRedPackage ActRedPackage : entities) {
			list.add(save(ActRedPackage));
		}
		return list;
	}

	public ActRedPackage save(ActRedPackage record) {
		if (record.getId() == null) {
			record.setCreateTime(new Date());
			mapper.insertSelective(record);
		} else {

			record.setModifyTime(new Date());
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(ActRedPackage record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public ActRedPackageBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		ActRedPackageExample example = new ActRedPackageExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(ActRedPackage entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<ActRedPackage> entities) {
		List<Long> ids = Lists.newArrayList();
		for (ActRedPackage entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ActRedPackageExample example = new ActRedPackageExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ActRedPackageExample example = new ActRedPackageExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<ActRedPackageBO> findAllByPage(ActRedPackageVO vo, MyPage<ActRedPackageBO> page) {
		return mapper.findAllByPage(vo, page);
	}

	public ActRedPackageBO findOneByVcode(String vcode) {
		ActRedPackageExample example = new ActRedPackageExample();
		example.createCriteria().andVcodeEqualTo(vcode);
		List<ActRedPackageBO> list = mapper.selectByExample(example);

		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;

	}

	// ���º����ȡ����
	public int updateActRedPackageRecordById(Long packageId) {
		return mapper.updateActRedPackageRecordById(packageId);
	}

	// ��ȡ��Ч�ĺ����Ϣ
	public List<ActRedPackageBO> getActRedPackageBO() {
		Date dt = new Date();

		ActRedPackageExample example = new ActRedPackageExample();
		example.createCriteria().andStartTimeLessThan(dt).andEndTimeGreaterThan(dt)
				.andDeleteStatusEqualTo((byte) 0).andIsEnabledEqualTo((byte) 1);

		example.setOrderByClause(" priority DESC ");
		return mapper.selectByExample(example);

	}

}
