package com.sinco.carnation.sys.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sys.bo.MessageBO;
import com.sinco.carnation.sys.mapper.MessageMapper;
import com.sinco.carnation.sys.model.Message;
import com.sinco.carnation.sys.model.MessageExample;
import com.sinco.dal.common.MyPage;

@Repository
public class MessageDao {

	@Autowired
	private MessageMapper mapper;

	/**
	 * 根据接收方 count
	 * 
	 * @param toUid
	 * @param status
	 * @return
	 */
	public int countByToUser(Long toUid, Integer status) {
		MessageExample example = new MessageExample();
		MessageExample.Criteria c = example.createCriteria();
		c.andToUserIdEqualTo(toUid);
		if (status != null) {
			c.andStatusEqualTo(status);
		}
		return mapper.countByExample(example);
	}

	/** generate code begin **/
	public List<MessageBO> findAll() {
		MessageExample example = new MessageExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		MessageExample example = new MessageExample();
		return mapper.countByExample(example);
	}

	public List<Message> save(Iterable<Message> entities) {
		List<Message> list = new ArrayList<Message>();
		for (Message Message : entities) {
			if (save(Message)) {
				list.add(Message);
			}
		}
		return list;
	}

	public int markRead(long messageId, long toUserId) {
		return mapper.markRead(messageId, toUserId);
	}

	public List<MessageBO> selectByUser(Long userId, String type, MyPage<MessageBO> page) {
		return mapper.selectByUser(userId, type, page);
	}

	public List<MessageBO> selectByParent(Long parentId, MyPage<MessageBO> page) {
		return mapper.selectByParent(parentId, page);
	}

	public List<MessageBO> forCountAll(Long userId) {
		return mapper.forCountAll(userId);
	}

	public List<MessageBO> forCountA(Long userId) {
		return mapper.forCountA(userId);
	}

	public List<MessageBO> forCountB(Long userId) {
		return mapper.forCountB(userId);
	}

	public List<MessageBO> forCountC(Long userId) {
		return mapper.forCountC(userId);
	}

	public boolean save(Message record) {
		if (record.getId() == null) {
			return 1 == mapper.insertSelective(record);
		} else {
			return 1 == mapper.updateByPrimaryKeySelective(record);
		}
	}

	public void update(Message record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public MessageBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public MessageBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		MessageExample example = new MessageExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<MessageBO> findAll(Iterable<Long> ids) {
		MessageExample example = new MessageExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Message entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Message> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Message entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		MessageExample example = new MessageExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		MessageExample example = new MessageExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public int updateInvitationRand() {
		return mapper.updateInvitationRand();
	}

	public int updateShopGoodsRand() {
		return mapper.updateShopGoodsRand();
	}

	public int updateCheckGroupRand() {
		return mapper.updateCheckGroupRand();
	}
}
