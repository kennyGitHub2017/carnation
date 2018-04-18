package com.sinco.carnation.user.vo;

import com.sinco.carnation.user.model.PhysicalSuggest;

public class PhysicalSuggestVO extends PhysicalSuggest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String keyWordIdStr; // 多个关键字的id字符串

	public String getKeyWordIdStr() {
		return keyWordIdStr;
	}

	public void setKeyWordIdStr(String keyWordIdStr) {
		this.keyWordIdStr = keyWordIdStr;
	}

}