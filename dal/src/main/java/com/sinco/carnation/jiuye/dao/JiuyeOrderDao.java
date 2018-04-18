package com.sinco.carnation.jiuye.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.jiuye.bo.JiuyeOrderBO;
import com.sinco.carnation.jiuye.bo.JiuyeTotalDataBO;
import com.sinco.carnation.jiuye.mapper.JiuyeOrderMapper;
import com.sinco.carnation.jiuye.model.JiuyeOrder;
import com.sinco.carnation.jiuye.vo.JiuyeOrderManageVO;
import com.sinco.dal.common.MyPage;

@Repository
public class JiuyeOrderDao {

	@Autowired
	private JiuyeOrderMapper mapper;

	public void save(JiuyeOrder record) {
		mapper.insertSelective(record);
	}

	public void update(JiuyeOrder record) {
		mapper.updateByOrderId(record);
	}

	public JiuyeOrder findByOrderId(long orderId) {
		return mapper.findByOrderId(orderId);
	}

	public JiuyeOrder payStateCheck(long orderId) {
		return mapper.payStateCheck(orderId);
	}
	
	public List<JiuyeOrderBO> getJiuyeOrderList(JiuyeOrderManageVO vo,
			MyPage<JiuyeOrderBO> page){
		return mapper.findOrderList(vo,page);
	}
	public JiuyeTotalDataBO findOrderTotalPayMoney(JiuyeOrderManageVO vo){
		return mapper.findOrderTotalPayMoney(vo);
	}
	
	public JiuyeTotalDataBO findOrderTotalRefundsMoney(JiuyeOrderManageVO vo){
		return mapper.findOrderTotalRefundsMoney(vo);
	}
	
	

	public List<String> querySynOrderId(int start, int end) {
		return mapper.querySynOrderId(start, end);
	}

	public int updateOrderStatusByOrderId(String orderId, int orderStatus) {
		return mapper.updateOrderStatusByOrderId(orderId, orderStatus);
	}

	public Map<String, Object> getRefundOrderByOrderId(String orderId) {
		return mapper.getRefundOrderByOrderId(orderId);
	}
}
