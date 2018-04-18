/**   
 * @(#)ListPagerRequest.java	2016年11月22日	上午11:08:24	   
 *     
 * Copyrights (C) 2016艺龙旅行网保留所有权利
 */
package com.sinco.carnation.elong.model.h5.viewmodel.order;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


/**
 * 酒店列表页请求实体
 *
 * <p>
 * 修改历史:											<br>  
 * 修改日期    		修改人员   	版本	 		修改内容<br>  
 * -------------------------------------------------<br>  
 * 2016年11月22日 上午11:08:24   user     1.0    	初始化创建<br>
 * </p> 
 *
 * @author		user 
 * @version		1.0  
 * @since		JDK1.7
 */
public class ListPagerRequest {
	/**
	 * 预定事件开始点
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date creationTimeFrom;
	
	/**
	 * 预定事件结束点
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date creationTimeTo;
	
	/**
	 * 入住日期开始点
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
    private Date arrivalDateFrom;

	/**
	 * 入住日期结束点
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
    private Date arrivalDateTo;

	
    /**
     * 离店日期开始点
     */
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
    private Date departureDateFrom;
	
    /**
     * 离店日期结束点
     */
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
    private Date departureDateTo;
	
	/**
	 * 查询文本
	 */
	private String queryText;
	
	/**
	 * 请求页码
	 * 默认第一页
	 */
	private Integer pageIndex;
	
	/**   
	 * 得到creationTimeFrom的值   
	 *   
	 * @return creationTimeFrom的值
	 */
	public Date getCreationTimeFrom() {
		return creationTimeFrom;
	}
	
	/**
	 * 设置creationTimeFrom的值
	 * 
	 * @param creationTimeFrom 被设置的值
	 */
	public void setCreationTimeFrom(Date creationTimeFrom){
		this.creationTimeFrom = creationTimeFrom;
	}

	/**
	 * 得到creationtimeTo的值
	 * 
	 * @return creationTimeTo的值
	 */
	public Date getCreationTimeTo(){
		return creationTimeTo;
	}
	
	/**
	 * 设置creationTimeTo的值
	 * 
	 * @param creationTimeTo 被设置的值
	 */
	public void setCreationTimeTo(Date creationTimeTo){
		this.creationTimeTo = creationTimeTo;
	}
	
	/**   
	 * 得到arrivalDateFrom的值   
	 *   
	 * @return arrivalDateFrom的值
	 */
	public Date getArrivalDateFrom() {
		return arrivalDateFrom;
	}

	/**
	 * 设置arrivalDateFrom的值
	 *   
	 * @param arrivalDateFrom 被设置的值
	 */
	public void setArrivalDateFrom(Date arrivalDateFrom) {
		this.arrivalDateFrom = arrivalDateFrom;
	}
	
	/**   
	 * 得到arrivalDateTo的值   
	 *   
	 * @return arrivalDateTo的值
	 */
	public Date getArrivalDateTo() {
		return arrivalDateTo;
	}

	/**
	 * 设置arrivalDateTo的值
	 *   
	 * @param arrivalDateTo 被设置的值
	 */
	public void setArrivalDateTo(Date arrivalDateTo) {
		this.arrivalDateTo = arrivalDateTo;
	}

	/**
	 * 得到departureDateFrom的值
	 * 
	 * @return departureDateFrom的值
	 */
	public Date getDepartureDateFrom(){
		return departureDateFrom;
	}
	
	/**
	 * 设置departureDateFrom的值
	 * 
	 * @param departureDateFrom 被设置的值
	 */
	public void setDepartureFrom(Date departureDateFrom){
		this.departureDateFrom = departureDateFrom;
	}
	
	/**
	 * 得到departureDateTo的值
	 * 
	 * @return departureTo的值
	 */
	public Date getDepartureDateTo(){
		return departureDateTo;
	}
	
	/**
	 * 设置departureDateTo的值
	 * 
	 * @param departureDateTo的值
	 */
	public void setDepartureTo(Date departureDateTo){
		this.departureDateTo = departureDateTo;
	}
	
	/**
	 * 获取queryText的值
	 * 
	 * @return queryText的值
	 */
	public String getQueryText(){
		return queryText;
	}
	
	/**
	 * 设置queryText的值
	 * 
	 * @param queryText 被设置的值
	 */
	public void setQueryText(String queryText){
		this.queryText = queryText;
	}
	
	/**
	 * 获取分页页码
	 * 
	 * @return pageIndex的值
	 */
	public Integer getPageIndex(){
		return pageIndex;
	}
	
	/**
	 * 设置pageIndex的值
	 * 
	 * @param pageIndex的值
	 */
	public void setPageIndex(Integer pageIndex){
		this.pageIndex = pageIndex;
	}
}
