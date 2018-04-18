package com.sinco.carnation.sns.bo;

import java.util.List;

import com.sinco.carnation.sns.model.WenJuanGroup;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class WenJuanGroupBO extends WenJuanGroup {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8440837608398160349L;

	private String themeName;

	private List<WenJuanGroupBO> wenJuanGroupList;

	public List<WenJuanGroupBO> getWenJuanGroupList() {
		return wenJuanGroupList;
	}

	public void setWenJuanGroupList(List<WenJuanGroupBO> wenJuanGroupList) {
		this.wenJuanGroupList = wenJuanGroupList;
	}

	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	/**
	 * 附属题
	 */
	List<WenJuanGroupBO> subNodeList;

	public List<WenJuanGroupBO> getSubNodeList() {
		return subNodeList;
	}

	public void setSubNodeList(List<WenJuanGroupBO> subNodeList) {
		this.subNodeList = subNodeList;
	}

}