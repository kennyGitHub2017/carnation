package com.sinco.carnation.juanpi.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.juanpi.bo.JuanpiGoodsBO;
import com.sinco.carnation.juanpi.bo.JuanpiOrderGoodsBO;
import com.sinco.carnation.juanpi.dao.JuanpiGoodsDao;
import com.sinco.carnation.juanpi.dao.JuanpiOrderGoodsDao;
import com.sinco.carnation.juanpi.vo.JuanpiGoodsVO;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class JuanpiGoodsService {
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(JuanpiGoodsService.class);
	@Autowired
	private JuanpiGoodsDao juanpiGoodsDao;
	@Autowired
	private JuanpiOrderGoodsDao juanpiOrderGoodsDao;

	public List<Long> findAllSellingGoods() {
		return juanpiGoodsDao.findAllSellingGoods();
	}
	
	public JuanpiGoodsBO findOne(java.lang.Long id){
		return juanpiGoodsDao.findOne(id);
	}
	public List<JuanpiGoodsBO> findGoodsByVO(JuanpiGoodsVO vo,MyPage<JuanpiGoodsBO> page){
		return juanpiGoodsDao.findGoodsByVO(vo,page);
	}
	
	public List<JuanpiOrderGoodsBO> findGoodsByOrderId(Integer orderId,MyPage<JuanpiOrderGoodsBO> page){
		List<JuanpiOrderGoodsBO> orderGoodsBOs = new ArrayList<>();
		List<JuanpiOrderGoodsBO> orderGoodsBO = juanpiOrderGoodsDao.findGoodsByOrderId(orderId,page);
		for (JuanpiOrderGoodsBO juanpiOrderGoodsBO : orderGoodsBO) {
			juanpiOrderGoodsBO.setBrokerageratiocale(juanpiOrderGoodsBO.getBrokerageratiocale().multiply(BigDecimal.valueOf(100)));
			orderGoodsBOs.add(juanpiOrderGoodsBO);
		}
		return orderGoodsBOs;
	}
	public List<JuanpiOrderGoodsBO> findGoodsByOrderId(Integer orderId){
		return juanpiOrderGoodsDao.findGoodsByOrderId(orderId);
	}


	public int updateIsShow(JuanpiGoodsVO vo){
		return juanpiGoodsDao.updateIsShow(vo);
	}
	
	public int updateClass(JuanpiGoodsVO vo){
		return juanpiGoodsDao.updateClass(vo);
	}
	
	public int deleteGood(Long id){
		return juanpiGoodsDao.deleteGood(id);
	}
	
	public List<JuanpiGoodsBO> findClassNameById(Long cId){
		return juanpiGoodsDao.findClassNameById(cId);
	}
	public List<JuanpiGoodsBO> selectByRand(Integer limitStart, Integer limitEnd) {
		return this.juanpiGoodsDao.selectByRand(limitStart, limitEnd);
	}
}
