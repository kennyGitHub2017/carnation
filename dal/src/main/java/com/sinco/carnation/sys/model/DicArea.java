package com.sinco.carnation.sys.model;

import java.util.Collection;
import java.util.List;

import com.sinco.dic.client.model.DicParentBase;

public class DicArea implements DicParentBase<DicArea> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1271844666651474730L;

	private Long id;

	private String code;

	private String name;

	private String cname;
	
	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	private String parentCode;

	private Integer language;

	private Collection<DicArea> childs;

	private DicArea parent;

	public DicArea getParent() {
		return parent;
	}

	public void setParent(DicArea parent) {
		this.parent = parent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public Integer getLanguage() {
		return language;
	}

	public void setLanguage(Integer language) {
		this.language = language;
	}

	public static void sortList(List<DicArea> list, List<DicArea> sourcelist, String parendCode) {
		for (int i = 0; i < sourcelist.size(); i++) {
			DicArea e = sourcelist.get(i);
			if (e.getParentCode() != null && e.getParentCode().equals(parendCode)) {
				list.add(e);
				// 鍒ゆ柇鏄惁杩樻湁瀛愯妭鐐�, 鏈夊垯缁х画鑾峰彇瀛愯妭鐐�
				for (int j = 0; j < sourcelist.size(); j++) {
					DicArea childe = sourcelist.get(j);
					if (childe.getParentCode() != null && childe.getParentCode().equals(e.getCode())) {
						sortList(list, sourcelist, e.getCode());
						break;
					}
				}
			}
		}
	}

	@Override
	public Collection<DicArea> getChilds() {
		return childs;
	}

	@Override
	public void setChilds(Collection<DicArea> childs) {
		this.childs = childs;
	}

}