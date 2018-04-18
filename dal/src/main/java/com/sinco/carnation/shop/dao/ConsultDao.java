package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.shop.bo.ConsultBO;
import com.sinco.carnation.shop.mapper.ConsultMapper;
import com.sinco.carnation.shop.model.Consult;
import com.sinco.carnation.shop.model.ConsultExample;
import com.sinco.carnation.shop.vo.ConsultVO;
import com.sinco.dal.common.MyPage;

@Repository
public class ConsultDao {

	@Autowired
	private ConsultMapper mapper;

	public int selectCountByRepayAndSelf(Boolean reply, Integer whetherSelf) {
		ConsultExample example = new ConsultExample();
		example.createCriteria().andReplyEqualTo(reply).andWhetherSelfEqualTo(whetherSelf)
				.andDeleteStatusEqualTo(false);
		return mapper.countByExample(example);
	}

	public int selectCountByRepayAndStoreId(Boolean reply, Long storeId) {
		ConsultExample example = new ConsultExample();
		example.createCriteria().andReplyEqualTo(reply).andStoreIdEqualTo(storeId)
				.andDeleteStatusEqualTo(false);
		return mapper.countByExample(example);
	}

	public List<ConsultBO> findByExample(ConsultExample example) {
		return mapper.selectByExample(example);
	}

	/** generate code begin **/
	public List<ConsultBO> findAll() {
		ConsultExample example = new ConsultExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		ConsultExample example = new ConsultExample();
		return mapper.countByExample(example);
	}

	public List<Consult> save(Iterable<Consult> entities) {
		List<Consult> list = new ArrayList<Consult>();
		for (Consult Consult : entities) {
			list.add(save(Consult));
		}
		return list;
	}

	public Consult save(Consult record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(Consult record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public ConsultBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public ConsultBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		ConsultExample example = new ConsultExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<ConsultBO> findAll(Iterable<Long> ids) {
		ConsultExample example = new ConsultExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Consult entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Consult> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Consult entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ConsultExample example = new ConsultExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ConsultExample example = new ConsultExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<ConsultBO> queryConsultList(String consultUserName, MyPage<ConsultBO> page) {
		return mapper.queryConsultList(consultUserName, page);
	}

	public List<ConsultBO> selectConsultListByVO(ConsultVO vo, MyPage<ConsultBO> page) {
		return mapper.selectConsultListByVO(vo, page);
	}

	public int deleteConsultById(Long[] ids) {
		return mapper.deleteConsultById(ids);
	}

	public Consult queryConsultById(Long id) {
		List<Consult> list = mapper.queryConsultById(id);
		return list.isEmpty() ? null : list.get(0);
	}

	public List<ConsultBO> queryConsultSelfList(String consultUserName, Boolean reply, MyPage<ConsultBO> page) {
		return mapper.queryConsultSelfList(consultUserName, reply, page);
	}

	public List<ConsultBO> findListByVO(MyPage<ConsultBO> page, ConsultVO vo) {
		return mapper.findListByVO(page, vo);

	}
}
