package com.sinco.carnation.market.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.market.mapper.RedPackageGetRecordMapper;
import com.sinco.carnation.market.model.RedPackageGetRecord;
import com.sinco.carnation.market.bo.RedPackageGetRecordBO;
import com.sinco.carnation.market.model.RedPackageGetRecordExample;
import com.sinco.carnation.market.vo.RedPackageGetRecordVO;
import com.sinco.dal.common.MyPage;

@Repository
public class RedPackageGetRecordDao {

	@Autowired
	private RedPackageGetRecordMapper mapper;

	/**
	 * 已激活的红包 Long id
	 * 
	 * @return
	 */
	public List<RedPackageGetRecordBO> findActivateRed(Long id) {
		RedPackageGetRecordExample example = new RedPackageGetRecordExample();
		example.createCriteria().andPackageIdEqualTo(id).andPhoneIsNotNull().andCookIdIsNotNull()
				.andUserIdIsNotNull();
		return mapper.selectByExample(example);
	}

	/** generate code begin **/
	public List<RedPackageGetRecordBO> findAll() {
		RedPackageGetRecordExample example = new RedPackageGetRecordExample();
		return mapper.selectByExample(example);
	}

	public List<RedPackageGetRecordBO> selectByExample(RedPackageGetRecordExample example) {
		return mapper.selectByExample(example);
	}

	List<RedPackageGetRecordBO> findAll(Iterable<Long> ids) {
		RedPackageGetRecordExample example = new RedPackageGetRecordExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		RedPackageGetRecordExample example = new RedPackageGetRecordExample();
		return mapper.countByExample(example);
	}

	public List<RedPackageGetRecord> save(Iterable<RedPackageGetRecord> entities) {
		List<RedPackageGetRecord> list = new ArrayList<RedPackageGetRecord>();
		for (RedPackageGetRecord RedPackageGetRecord : entities) {
			list.add(save(RedPackageGetRecord));
		}
		return list;
	}

	public RedPackageGetRecord save(RedPackageGetRecord record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(RedPackageGetRecord record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public RedPackageGetRecordBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		RedPackageGetRecordExample example = new RedPackageGetRecordExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(RedPackageGetRecord entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<RedPackageGetRecord> entities) {
		List<Long> ids = Lists.newArrayList();
		for (RedPackageGetRecord entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		RedPackageGetRecordExample example = new RedPackageGetRecordExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		RedPackageGetRecordExample example = new RedPackageGetRecordExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	// 用户抢取红包
	public int updateActRedPacketRecord(RedPackageGetRecordVO vo) {
		return mapper.updateActRedPacketRecord(vo);
	}

	public List<RedPackageGetRecordBO> findAllByPage(RedPackageGetRecordVO vo,
			MyPage<RedPackageGetRecordBO> page) {
		return mapper.findAllByPage(vo, page);
	}

	public RedPackageGetRecordBO findRedPackageByPhone(String phone, Long packageId) {
		return mapper.findRedPackageByPhone(phone, packageId);
	}

	public List<RedPackageGetRecordBO> getActRedPacketRecordUserList(RedPackageGetRecordVO vo) {
		return mapper.getActRedPacketRecordUserList(vo);
	}

	public void deleteByPackageId(Long packageId) {
		RedPackageGetRecordExample example = new RedPackageGetRecordExample();
		example.createCriteria().andPackageIdEqualTo(packageId);
		mapper.deleteByExample(example);
	}

	public boolean existsOpenRedPackageRecord(Long packageId) {
		RedPackageGetRecordExample example = new RedPackageGetRecordExample();
		example.createCriteria().andPackageIdEqualTo(packageId).andStatusGreaterThan((byte) 0);
		return mapper.countByExample(example) > 0;
	}

	// 更新信息
	public int updateByCookieIdandPacketId(RedPackageGetRecord vo) {
		return mapper.updateByCookieIdandPacketId(vo);

	}

	// 已领取金额
	public Float getSumMoney(Long id) {
		return mapper.getSumMoney(id);

	}

}
