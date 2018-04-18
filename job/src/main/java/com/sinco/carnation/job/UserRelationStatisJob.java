package com.sinco.carnation.job;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.store.vo.StoreVO;
import com.sinco.carnation.user.bo.OperatorBO;
import com.sinco.carnation.user.service.OperatorService;
import com.sinco.carnation.user.service.UserRelationService;
import com.sinco.dal.common.MyPage;

public class UserRelationStatisJob {

	private UserRelationService userRelationService;
	private OperatorService operatorService;
	private StoreService storeService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public synchronized void executeJob() {
		logger.info("[updateUserRelationStatis] begin");
		List<OperatorBO> operator = operatorService.listAllOperator();
		for(OperatorBO bo : operator){
			if(null != bo.getUserId()){
				userRelationService.saveStatisByUid(bo.getUserId(), 0L);
			}
		}
		StoreVO vo = new StoreVO();
		MyPage<StoreBO> page = new MyPage<>();
		page.setPageSize(9999999);
		List<StoreBO> stores = this.storeService.findPageByVo(page, vo);
		for(StoreBO bo : stores){
			if(null != bo.getUid()){
				userRelationService.saveStatisByUid(bo.getUid(), 0L);
			}
		}
		logger.info("[updateUserRelationStatis] end");
	}

	public UserRelationService getUserRelationService() {
		return userRelationService;
	}

	public void setUserRelationService(UserRelationService userRelationService) {
		this.userRelationService = userRelationService;
	}

	public OperatorService getOperatorService() {
		return operatorService;
	}

	public void setOperatorService(OperatorService operatorService) {
		this.operatorService = operatorService;
	}

	public StoreService getStoreService() {
		return storeService;
	}

	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}


}
