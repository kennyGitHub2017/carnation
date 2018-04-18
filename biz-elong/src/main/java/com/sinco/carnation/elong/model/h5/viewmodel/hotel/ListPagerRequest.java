/**   
 * @(#)ListPagerRequest.java	2016年11月22日	上午11:08:24	   
 *     
 * Copyrights (C) 2016艺龙旅行网保留所有权利
 */
package com.sinco.carnation.elong.model.h5.viewmodel.hotel;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 酒店列表页请求实体
 * 
 * <p>
 * 修改历史: <br>
 * 修改日期 修改人员 版本 修改内容<br>
 * -------------------------------------------------<br>
 * 2016年11月22日 上午11:08:24 user 1.0 初始化创建<br>
 * </p>
 * 
 * @author user
 * @version 1.0
 * @since JDK1.7
 */
public class ListPagerRequest {

	/**
	 * 入职日期
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date arrivalDate;

	/**
	 * 离店日期
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date departureDate;

	/**
	 * 城市编码
	 */
	private String cityId;

	/**
	 * 城市名称
	 */
	private String cityName;

	/**
	 * 查询文本
	 */
	private String queryText;

	/**
	 * 请求页码 默认第一页
	 */
	private Integer pageIndex;

	/**
	 * 每页显示的数量
	 */
	private Integer pageSize;

	/**
	 * 经度
	 */
	private BigDecimal longitude;

	/**
	 * 维度
	 */
	private BigDecimal latitude;

	/**
	 * 推荐星级 (3：舒适；4：高档；5：豪华；A：公寓 )
	 */
	private String starRate;
	/**
	 * 最小价格
	 */
	private Integer lowRate;
	/**
	 * 最大价格
	 */
	private Integer highRate;
	/**
	 * 排序（Default艺龙默认排序 StarRankDesc推荐星级降序 RateAsc价格升序 RateDesc价格降序 DistanceAsc距离升序）
	 */
	private String sort;

	/**
	 * 得到arrivalDate的值
	 * 
	 * @return arrivalDate的值
	 */
	public Date getArrivalDate() {
		return arrivalDate;
	}

	/**
	 * 设置arrivalDate的值
	 * 
	 * @param arrivalDate
	 *            被设置的值
	 */
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	/**
	 * 得到departureDate的值
	 * 
	 * @return departureDate的值
	 */
	public Date getDepartureDate() {
		return departureDate;
	}

	/**
	 * 设置departureDate的值
	 * 
	 * @param departureDate
	 *            被设置的值
	 */
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	/**
	 * 得到cityId的值
	 * 
	 * @return cityId的值
	 */
	public String getCityId() {
		return cityId;
	}

	/**
	 * 设置cityId的值
	 * 
	 * @param cityId
	 *            被设置的值
	 */
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	/**
	 * 得到queryText的值
	 * 
	 * @return queryText的值
	 */
	public String getQueryText() {
		return queryText;
	}

	/**
	 * 设置queryText的值
	 * 
	 * @param queryText
	 *            被设置的值
	 */
	public void setQueryText(String queryText) {
		this.queryText = queryText;
	}

	/**
	 * 得到pageIndex的值
	 * 
	 * @return pageIndex的值
	 */
	public Integer getPageIndex() {
		return pageIndex;
	}

	/**
	 * 设置pageIndex的值
	 * 
	 * @param pageIndex
	 *            被设置的值
	 */
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	/**
	 * 得到longitude的值
	 * 
	 * @return longitude的值
	 */
	public BigDecimal getLongitude() {
		return longitude;
	}

	/**
	 * 设置longitude的值
	 * 
	 * @param longitude
	 *            被设置的值
	 */
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	/**
	 * 得到latitude的值
	 * 
	 * @return latitude的值
	 */
	public BigDecimal getLatitude() {
		return latitude;
	}

	/**
	 * 设置latitude的值
	 * 
	 * @param latitude
	 *            被设置的值
	 */
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getStarRate() {
		return starRate;
	}

	public void setStarRate(String starRate) {
		this.starRate = starRate;
	}

	public Integer getLowRate() {
		return lowRate;
	}

	public void setLowRate(Integer lowRate) {
		this.lowRate = lowRate;
	}

	public Integer getHighRate() {
		return highRate;
	}

	public void setHighRate(Integer highRate) {
		this.highRate = highRate;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
