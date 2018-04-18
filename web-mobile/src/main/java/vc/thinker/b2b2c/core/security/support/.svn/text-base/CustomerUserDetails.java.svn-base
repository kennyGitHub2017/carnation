package vc.thinker.b2b2c.core.security.support;

import com.sinco.carnation.user.bo.SellerBO;
import com.sinco.carnation.user.bo.UserCustomerBO;

public class CustomerUserDetails extends BasicUserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2567038825306107862L;

	private UserCustomerBO customer;

	/**
	 * 商家用户
	 */
	private SellerBO seller;

	/**
	 * 得到商家的店铺id
	 * 
	 * @return
	 */
	public Long getStoreId() {
		return seller != null ? seller.getStoreId() : null;
	}

	public SellerBO getSeller() {
		return seller;
	}

	public void setSeller(SellerBO seller) {
		this.seller = seller;
	}

	/**
	 * 是否为自己店铺
	 * 
	 * @param storeId
	 * @return
	 */
	public boolean isMyStore(Long storeId) {
		if (seller == null) {
			return false;
		}
		if (seller.getStoreId().equals(storeId)) {
			return true;
		}
		return false;
	}

	/**
	 * 得到登陆用户名称
	 * 
	 * @return
	 */
	public String getName() {
		return customer.getNickname();
	}

	public UserCustomerBO getCustomer() {
		return customer;
	}

	public void setCustomer(UserCustomerBO customer) {
		this.customer = customer;
	}

}
