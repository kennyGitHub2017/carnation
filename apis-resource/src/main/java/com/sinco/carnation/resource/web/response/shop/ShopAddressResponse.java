package com.sinco.carnation.resource.web.response.shop;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.shop.ShopAddresBO;

/**
 * 商品收获地址
 * 
 * @author king
 * 
 */
public class ShopAddressResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("addressList")
	@ReturnMapping(desc = "地址列表")
	private List<ShopAddresBO> addressList;

	public List<ShopAddresBO> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<ShopAddresBO> addressList) {
		this.addressList = addressList;
	}

}
