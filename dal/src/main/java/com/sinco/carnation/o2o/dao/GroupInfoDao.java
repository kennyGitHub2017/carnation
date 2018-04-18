package com.sinco.carnation.o2o.dao;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.google.common.collect.Lists;
import com.sinco.carnation.o2o.bo.GroupInfoBO;
import com.sinco.carnation.o2o.bo.GroupOrderBO;
import com.sinco.carnation.o2o.mapper.GroupInfoMapper;
import com.sinco.carnation.o2o.mapper.GroupOrderMapper;
import com.sinco.carnation.o2o.model.GroupInfo;
import com.sinco.carnation.o2o.model.GroupInfoExample;
import com.sinco.carnation.o2o.vo.GroupInfoVO;
import com.sinco.dal.common.MyPage;

@Repository
public class GroupInfoDao {
	@Autowired
	GroupOrderMapper orderMapper;
	@Autowired
	private GroupInfoMapper mapper;

	/**
	 * 根据消费码查询
	 * 
	 * @param groupSN
	 * @return
	 */
	public GroupInfoBO findByGroupSN(String groupSN) {
		GroupInfoExample example = new GroupInfoExample();
		example.createCriteria().andGroupSnEqualTo(groupSN);
		List<GroupInfoBO> list = mapper.selectByExample(example);
		return list.size() > 0 ? list.get(0) : null;
	}

	/** generate code begin **/
	public List<GroupInfoBO> findAll() {
		GroupInfoExample example = new GroupInfoExample();
		return mapper.selectByExample(example);
	}

	public List<GroupInfoBO> findByOrder(Long orderId) {
		GroupInfoExample example = new GroupInfoExample();
		example.createCriteria().andOrderIdEqualTo(orderId);

		return mapper.selectByExample(example);
	}

	public List<GroupInfoBO> findByOrderStatus(Long orderId) {
		Integer status = new Integer(0);// 未消费的状态

		GroupInfoExample example = new GroupInfoExample();
		example.createCriteria().andOrderIdEqualTo(orderId).andStatusEqualTo(status);

		return mapper.selectByExample(example);
	}

	public List<GroupInfoBO> selectByApply(GroupInfoVO vo, MyPage<GroupInfoBO> page) {
		List<GroupInfoBO> list = mapper.selectByApply(vo, page);
		for (GroupInfoBO bo : list)
			bo.setGroupOrderBO(orderMapper.selectByPrimaryKey(bo.getOrderId()));

		return list;
	}

	@SuppressWarnings("rawtypes")
	public List<GroupInfoBO> selectByRefund(GroupInfoVO vo, MyPage<GroupInfoBO> page) {
		List<GroupInfoBO> list = mapper.selectByRefund(vo, page);
		GroupOrderBO gg = null;
		for (GroupInfoBO bo : list) {
			gg = orderMapper.selectByPrimaryKey(bo.getOrderId());
			if (null != gg) {
				String groupInfo = gg.getGroupInfo();
				if (StringUtils.isNotEmpty(groupInfo)) {
					Map map = (Map) Json.fromJson(groupInfo);
					if (map.containsKey("goods_name")
							&& StringUtils.isNotEmpty(String.valueOf(map.get("goods_name")))) {
						gg.setLocalGroupName(String.valueOf(map.get("goods_name")));
					}
					if (map.containsKey("goods_total_price")
							&& StringUtils.isNotEmpty(String.valueOf(map.get("goods_total_price")))) {
						gg.setTotalPrice(BigDecimal.valueOf(CommUtil.null2Double(map.get("goods_total_price"))));
					}
				}
			}
			bo.setGroupOrderBO(gg);
		}
		return list;
	}

	public long count() {
		GroupInfoExample example = new GroupInfoExample();
		return mapper.countByExample(example);
	}

	public List<GroupInfo> save(Iterable<GroupInfo> entities) {
		List<GroupInfo> list = new ArrayList<GroupInfo>();
		for (GroupInfo GroupInfo : entities) {
			list.add(save(GroupInfo));
		}
		return list;
	}

	public GroupInfo save(GroupInfo record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int update(GroupInfo record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	public GroupInfoBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public GroupInfoBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		GroupInfoExample example = new GroupInfoExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<GroupInfoBO> findAll(Iterable<Long> ids) {
		GroupInfoExample example = new GroupInfoExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(GroupInfo entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<GroupInfo> entities) {
		List<Long> ids = Lists.newArrayList();
		for (GroupInfo entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		GroupInfoExample example = new GroupInfoExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		GroupInfoExample example = new GroupInfoExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<GroupInfoBO> queryGroupInfoList(Long orderId) {
		return mapper.queryGroupInfoList(orderId);
	}

	public List<GroupInfoBO> findPageByStoreId(MyPage<GroupInfoBO> page, GroupInfoVO vo) {
		return mapper.findPageByStoreId(page, vo);
	}

	public GroupInfoBO queryGroupInfoBySn(Long sellerUid, String groupSn) {
		return mapper.checkGroupSn(sellerUid, groupSn);
	}

	public List<GroupInfoBO> selectGroupGoodsByOrderId(@Param("vo") GroupInfoVO vo) {
		return mapper.selectGroupGoodsByOrderId(vo);
	}

	public List<GroupInfoBO> findExpiredGroupInfo() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		String startTime = df.format(new Date(d.getTime() - 2 * 24 * 60 * 60 * 1000));
		String endTime = df.format(d);
		return this.mapper.findExpiredGroupInfo(startTime, endTime);
	}

	public List<GroupInfoBO> queryMultiGroupInfoBySn(Long sellerUid, List<String> groupSnList) {
		return mapper.checkMultiGroupSn(sellerUid, groupSnList);
	}
	
	public boolean changeReadStatus(GroupInfo record){
		return mapper.changeReadStatus(record);
	}
}
