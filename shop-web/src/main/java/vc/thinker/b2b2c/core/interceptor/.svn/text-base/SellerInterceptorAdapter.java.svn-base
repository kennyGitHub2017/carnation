package vc.thinker.b2b2c.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.constants.StoreConstants;
import com.sinco.carnation.store.service.StoreService;

import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

/**
 * 商户拦截器，用于拦截店铺状态不正常访问
 * 
 * @author james
 * 
 */
public class SellerInterceptorAdapter extends HandlerInterceptorAdapter {

	private static final Logger log = LoggerFactory.getLogger(SellerInterceptorAdapter.class);

	private StoreService storeService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		if (user != null && user.getStoreId() != null) {
			StoreBO store = storeService.getStoreStatus(user.getStoreId());
			if (store.getIsO2o()) {
				if (store.getStoreStatus() < StoreConstants.STORE_STATUS_SHOP_AUDIT_SUCCESS) {
					log.info("O2O-用户店铺还在审批状态，跳转到审批进度查询");
					response.sendRedirect(CommUtil.getURL(request) + "/seller_apply/group/query.htm");
					return false;
				}

			}

			if (store.getIsShop()) {
				if (store.getStoreStatus() < StoreConstants.STORE_STATUS_SHOP_AUDIT_SUCCESS) {
					response.sendRedirect(CommUtil.getURL(request) + "/seller_apply/group/query.htm");
					return false;
				}

			}

		}

		return true;
	}

	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}
}
