package com.sinco.carnation.juanpi.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.juanpi.bo.JuanpiOrderBO;
import com.sinco.carnation.juanpi.bo.JuanpiOrderGoodsBO;
import com.sinco.carnation.juanpi.dao.JuanpiOrderDao;
import com.sinco.carnation.juanpi.dao.JuanpiOrderGoodsDao;
import com.sinco.carnation.juanpi.model.JuanpiOrder;
import com.sinco.carnation.juanpi.vo.JuanpiOrderGoodsVO;
import com.sinco.carnation.juanpi.vo.JuanpiOrderVO;
import com.sinco.carnation.sys.constant.IntegralConstants;
import com.sinco.carnation.sys.service.IntegralService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class JuanpiOrderService {
	private static final Logger LOG = LoggerFactory.getLogger(JuanpiOrderService.class);
	@Autowired
	private JuanpiOrderDao juanpiOrderDao;
	@Autowired
	private JuanpiOrderGoodsDao juanpiOrderGoodsDao;
	@Autowired
	private IntegralService integralService;	
	@Autowired
	private UserCustomerService userCustomerService;
	
	public List<JuanpiOrderBO> selectOrderListByVO(JuanpiOrderVO vo,MyPage<JuanpiOrderBO> page){
		return juanpiOrderDao.selectOrderListByVO(vo, page);
	}
	
	
	public List<JuanpiOrderGoodsBO> selectOrderGoodsListByVO(JuanpiOrderGoodsVO vo,MyPage<JuanpiOrderGoodsBO> page) {
		List<JuanpiOrderGoodsBO> orderGoodsBOs = new ArrayList<>();
		List<JuanpiOrderGoodsBO> orderGoodsBO = juanpiOrderGoodsDao.selectOrderGoodsListByVO(vo,page);
		
		for (JuanpiOrderGoodsBO juanpiOrderGoodsBO : orderGoodsBO) {
			juanpiOrderGoodsBO.setBrokerageratiocale(juanpiOrderGoodsBO.getBrokerageratiocale().multiply(BigDecimal.valueOf(100)));
			orderGoodsBOs.add(juanpiOrderGoodsBO);
		}
		return orderGoodsBOs;
	}
	public JuanpiOrderGoodsBO selectMoneyTotal(JuanpiOrderGoodsVO vo) {
		return juanpiOrderGoodsDao.selectMoneyTotal(vo);
	}

	public List<JuanpiOrderBO> findRebateByJuanPiOrderStatus() {
		return juanpiOrderDao.selectRebateByJuanPiOrderStatus();
	}

	public JuanpiOrder findById(long id) {
		return juanpiOrderDao.selectFindById(id);
	}

	public void update(JuanpiOrder record) {
		juanpiOrderDao.update(record);
	}

	/** 查询可加积分订单 **/
	private List<JuanpiOrderGoodsBO> listAddIntegral(){
		return juanpiOrderGoodsDao.listAddIntegral();
	}
	/** 修改加积分状态 **/
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	private int updateAddIntegral(Long id){
		return juanpiOrderGoodsDao.updateAddIntegral(id);
	}
	
	/** 改变订单加积分状态 给相关用户加积分
	 * @throws ServiceException **/
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	private synchronized void addIntegralByid(Long id, Long uid, String type,BigDecimal goodsmoney){
			if(userCustomerService.findById(uid) == null){
				return;
			}
			if(this.updateAddIntegral(id)>0){
				try {
					integralService.addIntegral(type, uid, goodsmoney.toString(), null, null, null);
				} catch (Exception e) {
					LOG.error("[addIntegralByid] ERROR uid="+uid+",type="+type);
					e.printStackTrace();
				}
			}
	 }
	
	/** 卷皮订单加积分 **/
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void juanpiOrderAddIntegral(){
		 List<JuanpiOrderGoodsBO> list = this.listAddIntegral();
		 String type = IntegralConstants.INTEGRAL_JUANPI_ORDER;
		 if(null != list && list.size() > 0){
			 for(JuanpiOrderGoodsBO bo : list){
				 if(null != bo && bo.getUid() > 0){
					this.addIntegralByid(bo.getId(), bo.getUid(), type, bo.getGoodsmoney());
				 }
			 }
		 }
	}
}
