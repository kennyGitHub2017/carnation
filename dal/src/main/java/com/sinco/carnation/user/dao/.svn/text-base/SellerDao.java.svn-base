package com.sinco.carnation.user.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vc.thinker.b2b2c.core.beans.BeanUtils;

import com.google.common.collect.Lists;
import com.sinco.carnation.user.bo.SellerBO;
import com.sinco.carnation.user.mapper.SellerMapper;
import com.sinco.carnation.user.model.Seller;
import com.sinco.carnation.user.model.SellerExample;
import com.sinco.carnation.user.vo.SellerVO;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.DicNameMappingHandle;

@Repository
public class SellerDao {

	@Autowired
	private SellerMapper mapper;
	@Autowired
	private DicNameMappingHandle mappingHandle;

	public int findSellerMemberById(Long sellerId) {
		return mapper.findSellerMemberById(sellerId);
	}

	public int findSellerOwnMemberById(Long sellerId) {
		return mapper.findSellerOwnMemberById(sellerId);
	}

	public int findSellerOwnSellerById(Long sellerId) {
		return mapper.findSellerOwnSellerById(sellerId);
	}

	public int findSellerAllOrderCount(Long sellerId) {
		return mapper.findSellerAllOrderCount(sellerId);
	}

	public int findSellerWeekOrderCount(Long sellerId) {
		return mapper.findSellerWeekOrderCount(sellerId);
	}

	public BigDecimal findSellerRebateOrderCount(Long sellerId) {
		return mapper.findSellerRebateOrderCount(sellerId);
	}

	public BigDecimal findSellerWeekRebateOrderCount(Long sellerId) {
		return mapper.findSellerWeekRebateOrderCount(sellerId);
	}

	public BigDecimal findSellerMonthRebateOrderCount(Long sellerId) {
		return mapper.findSellerMonthRebateOrderCount(sellerId);
	}

	public int selectOperatorSellerCount(SellerVO vo) {
		return mapper.selectOperatorSellerCount(vo);
	}

	/**
	 * 运营商注册商户数量
	 * 
	 * @param vo
	 * @return
	 */
	public int selectOperatorRegisterSellerCount(SellerVO vo) {
		return mapper.selectOperatorRegisterSellerCount(vo);
	}

	/**
	 * 运营商注册供应商数量
	 * 
	 * @param vo
	 * @return
	 */
	public int selectOperatorRegisterGoodsSellerCount(SellerVO vo) {
		return mapper.selectOperatorRegisterGoodsSellerCount(vo);
	}

	/**
	 * 运营商隶属供应商注册会员数量
	 * 
	 * @param vo
	 * @return
	 */
	public int selectSellerRegisterUserCount(Long operaid) {
		return mapper.selectSellerRegisterUserCount(operaid, null, null);
	}

	/**
	 * 运营商隶属供应商注册会员数量
	 * 
	 * @param vo
	 * @return
	 */
	public int selectSellerRegisterUserCount(Long operaid, String startTime, String endTime) {
		return mapper.selectSellerRegisterUserCount(operaid, startTime, endTime);
	}

	/**
	 * 
	 * @Title: selectOperatorSellerPageList
	 * @Description: TODO(查询运营商所属商户)
	 * @param @param page
	 * @param @param vo
	 * @param @return 设定文件
	 * @return List<SellerBO> 返回类型
	 * @author Tang
	 * @throws
	 */
	public List<SellerBO> selectOperatorSellerPageList(MyPage<SellerBO> page, SellerVO vo) {
		List<SellerBO> list = mapper.selectOperatorSellerPageList(page, vo);
		mappingHandle.mappinHandle(list);
		if (page != null) {
			page.setContent(list);
		}
		return list;
	}

	/**
	 * 
	 * @Title: selectOperatorSellerPageList
	 * @Description: TODO(查询运营商所属商户 ，这里没有消费反润总额计算，比上个方法简单)
	 * @param @param page
	 * @param @param vo
	 * @param @return 设定文件
	 * @return List<SellerBO> 返回类型
	 * @author Tang
	 * @throws
	 */
	public List<SellerBO> selectOperatorSellerSimplePageList(MyPage<SellerBO> page, SellerVO vo) {
		List<SellerBO> list = mapper.selectOperatorSellerSimplePageList(page, vo);
		mappingHandle.mappinHandle(list);
		if (page != null) {
			page.setContent(list);
		}
		return list;
	}

	/**
	 * 
	 * @Title: selectOperatorRegisterSellerPageList
	 * @Description: TODO(查询运营商注册商户)
	 * @param @param page
	 * @param @param vo
	 * @param @return 设定文件
	 * @return List<SellerBO> 返回类型
	 * @author Tang
	 * @throws
	 */
	public List<SellerBO> selectOperatorRegisterSellerPageList(MyPage<SellerBO> page, SellerVO vo) {
		List<SellerBO> list = mapper.selectOperatorRegisterSellerPageList(page, vo);
		mappingHandle.mappinHandle(list);
		if (page != null) {
			page.setContent(list);
		}
		return list;
	}
	
	public SellerBO findSessionById(Long uid,Boolean group, Boolean shop) {
		return mapper.findSessionById(uid,group,shop);
	}

	/**
	 * 根据店铺查找商户
	 * 
	 * @param storeId
	 * @return
	 */
	public Seller findByStore(Long storeId) {
		SellerExample example = new SellerExample();
		example.createCriteria().andStoreIdEqualTo(storeId);
		List<Seller> list = mapper.selectByExample(example);
		return list.size() > 0 ? list.get(0) : null;
	}

	/** generate code begin **/
	public List<Seller> findAll() {
		SellerExample example = new SellerExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		SellerExample example = new SellerExample();
		return mapper.countByExample(example);
	}

	public List<Seller> create(Iterable<Seller> entities) {
		List<Seller> list = new ArrayList<Seller>();
		for (Seller Seller : entities) {
			list.add(create(Seller));
		}
		return list;
	}

	public SellerBO selectByStore(String storeId) {
		return mapper.selectByStore(storeId);
	}

	public Seller create(Seller record) {
		record.setCreateTime(new Date());
		mapper.insertSelective(record);
		return record;
	}

	public void update(Seller record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public SellerBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public SellerBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		SellerExample example = new SellerExample();
		example.createCriteria().andUidEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<Seller> findAll(Iterable<Long> ids) {
		SellerExample example = new SellerExample();
		example.createCriteria().andUidIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Seller entity) {
		mapper.deleteByPrimaryKey(entity.getUid());
	}

	public void delete(Iterable<Seller> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Seller entity : entities) {
			ids.add(entity.getUid());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		SellerExample example = new SellerExample();
		example.createCriteria().andUidIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		SellerExample example = new SellerExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public SellerBO findByUsername(String username) {
		return mapper.selectByUsername(username);
	}

	public Seller getByStoreId(Long storeId) {
		SellerExample example = new SellerExample();
		example.createCriteria().andStoreIdEqualTo(storeId).andParentIdIsNull();
		List<Seller> list = mapper.selectByExample(example);
		return list.size() > 0 ? list.get(0) : null;
	}

	public Seller findByUid(Long uid) {
		return mapper.findByUid(uid);
	}

	public int updateByCondition(Seller record) {
		return mapper.updateByCondition(record);
	}

	public int updateByCondition(SellerVO vo) {
		try {
			Seller s = null;
			if (vo != null) {
				s = new Seller();
				BeanUtils.copyProperties(vo, s);
			}
			this.mapper.updateByCondition(s);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public List<Seller> selectSellerinUIDList(List<Long> uidList) {
		return this.mapper.selectSellerinUIDList(uidList);
	}

	public Integer sellerIsO2oByUid(Long uid) {
		return this.mapper.sellerIsO2oByUid(uid);
	}

	public Integer sellerIsB2CByUid(Long uid) {
		return this.mapper.sellerIsB2CByUid(uid);
	}

	public List<Seller> listAllSeller() {
		return this.mapper.listAllSeller();
	}
	@SuppressWarnings("unchecked")
	public List<SellerBO> findSellerByUIdList(Long uid) {
		return this.mapper.findSellerByUIdList(uid);
	}
}
