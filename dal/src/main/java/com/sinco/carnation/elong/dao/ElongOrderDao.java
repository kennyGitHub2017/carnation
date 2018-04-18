package com.sinco.carnation.elong.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.elong.bo.ElongOrderBO;
import com.sinco.carnation.elong.mapper.ElongOrderMapper;
import com.sinco.carnation.elong.model.ElongOrder;
import com.sinco.carnation.elong.vo.ElongOrderVO;
import com.sinco.dal.common.MyPage;

@Repository
public class ElongOrderDao {

	@Autowired
	private ElongOrderMapper mapper;

	/**
	 * 艺龙酒店可分润集合
	 * 
	 * @return
	 */
	public List<ElongOrder> selectRebateByElongOrderStatus() {
		return mapper.selectRebateByElongOrderStatus();
	}

	public List<ElongOrder> queryElongOrderList(Long userId, MyPage<ElongOrderBO> page) {
		return mapper.queryElongOrderlist(userId, page);
	}

	/**
	 * 获取需要的同步订单
	 * 
	 * @return
	 */
	public List<ElongOrder> querySynOrderList() {
		return mapper.querySynOrderList();
	}

	/**
	 * 根据ID更新订单信息
	 * 
	 * @param order
	 */
	public void updateById(ElongOrder order) {
		mapper.updateByPrimaryKeySelective(order);
	}

	/**
	 * 保存订单数据
	 * 
	 * @param order
	 */
	public void save(ElongOrder order) {
		mapper.insertSelective(order);
	}

	/**
	 * 根据主键ID查询
	 * 
	 * @param id
	 * @return
	 */
	public ElongOrder getById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	/**
	 * 根据订单编号查询
	 * 
	 * @param id
	 * @return
	 */
	public ElongOrder getByOrderId(Long orderId) {
		return mapper.selectByOrderId(orderId);
	}
	
	/**
	 * 酒店订单列表
	 * @param vo
	 * @return
	 */
	public List<ElongOrderBO> findElongOrderVOs(ElongOrderVO vo,MyPage<ElongOrderBO> page){
			return mapper.findElongOrderVOs(vo,page);
	}
}
