package com.sinco.dal.common;

import java.util.List;
import java.util.Map;

import vc.thinker.b2b2c.core.query.support.IPageList;
import vc.thinker.b2b2c.core.query.support.IQuery;

import com.sinco.data.core.Page;

public class MyPage<T> extends Page<T> implements IPageList {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2133698494140403613L;

	public void setCurrentPage(Integer currentPage) {
		super.setPageNumber(currentPage);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getResult() {
		return this.getContent();
	}

	@Override
	public void setQuery(IQuery q) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getPages() {
		return super.getTotalPages();
	}

	@Override
	public int getRowCount() {
		return new Long(super.getTotalElements()).intValue();
	}

	@Override
	public int getCurrentPage() {
		return super.getPageNumber();
	}

	@Override
	public void doList(int pageSize, int pageNo, String totalSQL, String construct, String queryHQL) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("rawtypes")
	@Override
	public void doList(int pageSize, int pageNo, String totalSQL, String construct, String queryHQL,
			Map params) {
		// TODO Auto-generated method stub

	}

}
