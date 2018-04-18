package vc.thinker.b2b2c.core.query;

/**
 * 
 * <p>
 * Title: PageObject.java
 * </p>
 * 
 * <p>
 * Description:包装分页信息
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 深圳市新科聚合网络技术有限公司 www.thinker.vc
 * </p>
 * 
 * @author thinker
 * 
 * @date 2015-5-20
 * 
 * @version 1.0.1
 */
public class PageObject {
	private Integer currentPage = -1;

	private Integer pageSize = -1;

	public Integer getCurrentPage() {
		if (currentPage == null) {
			currentPage = -1;
		}
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		if (currentPage == null) {
			currentPage = -1;
		}
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
