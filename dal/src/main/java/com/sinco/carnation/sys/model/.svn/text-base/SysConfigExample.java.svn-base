package com.sinco.carnation.sys.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysConfigExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public SysConfigExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Long value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Long value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Long value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Long value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Long value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Long value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Long> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Long> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Long value1, Long value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Long value1, Long value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andAddTimeIsNull() {
			addCriterion("add_time is null");
			return (Criteria) this;
		}

		public Criteria andAddTimeIsNotNull() {
			addCriterion("add_time is not null");
			return (Criteria) this;
		}

		public Criteria andAddTimeEqualTo(Date value) {
			addCriterion("add_time =", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeNotEqualTo(Date value) {
			addCriterion("add_time <>", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeGreaterThan(Date value) {
			addCriterion("add_time >", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("add_time >=", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeLessThan(Date value) {
			addCriterion("add_time <", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeLessThanOrEqualTo(Date value) {
			addCriterion("add_time <=", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeIn(List<Date> values) {
			addCriterion("add_time in", values, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeNotIn(List<Date> values) {
			addCriterion("add_time not in", values, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeBetween(Date value1, Date value2) {
			addCriterion("add_time between", value1, value2, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeNotBetween(Date value1, Date value2) {
			addCriterion("add_time not between", value1, value2, "addTime");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusIsNull() {
			addCriterion("delete_status is null");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusIsNotNull() {
			addCriterion("delete_status is not null");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusEqualTo(Integer value) {
			addCriterion("delete_status =", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotEqualTo(Integer value) {
			addCriterion("delete_status <>", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThan(Integer value) {
			addCriterion("delete_status >", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("delete_status >=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThan(Integer value) {
			addCriterion("delete_status <", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThanOrEqualTo(Integer value) {
			addCriterion("delete_status <=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusIn(List<Integer> values) {
			addCriterion("delete_status in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotIn(List<Integer> values) {
			addCriterion("delete_status not in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusBetween(Integer value1, Integer value2) {
			addCriterion("delete_status between", value1, value2, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("delete_status not between", value1, value2, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andAddressIsNull() {
			addCriterion("address is null");
			return (Criteria) this;
		}

		public Criteria andAddressIsNotNull() {
			addCriterion("address is not null");
			return (Criteria) this;
		}

		public Criteria andAddressEqualTo(String value) {
			addCriterion("address =", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotEqualTo(String value) {
			addCriterion("address <>", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressGreaterThan(String value) {
			addCriterion("address >", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressGreaterThanOrEqualTo(String value) {
			addCriterion("address >=", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLessThan(String value) {
			addCriterion("address <", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLessThanOrEqualTo(String value) {
			addCriterion("address <=", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLike(String value) {
			addCriterion("address like", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotLike(String value) {
			addCriterion("address not like", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressIn(List<String> values) {
			addCriterion("address in", values, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotIn(List<String> values) {
			addCriterion("address not in", values, "address");
			return (Criteria) this;
		}

		public Criteria andAddressBetween(String value1, String value2) {
			addCriterion("address between", value1, value2, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotBetween(String value1, String value2) {
			addCriterion("address not between", value1, value2, "address");
			return (Criteria) this;
		}

		public Criteria andAndroidDownloadIsNull() {
			addCriterion("android_download is null");
			return (Criteria) this;
		}

		public Criteria andAndroidDownloadIsNotNull() {
			addCriterion("android_download is not null");
			return (Criteria) this;
		}

		public Criteria andAndroidDownloadEqualTo(String value) {
			addCriterion("android_download =", value, "androidDownload");
			return (Criteria) this;
		}

		public Criteria andAndroidDownloadNotEqualTo(String value) {
			addCriterion("android_download <>", value, "androidDownload");
			return (Criteria) this;
		}

		public Criteria andAndroidDownloadGreaterThan(String value) {
			addCriterion("android_download >", value, "androidDownload");
			return (Criteria) this;
		}

		public Criteria andAndroidDownloadGreaterThanOrEqualTo(String value) {
			addCriterion("android_download >=", value, "androidDownload");
			return (Criteria) this;
		}

		public Criteria andAndroidDownloadLessThan(String value) {
			addCriterion("android_download <", value, "androidDownload");
			return (Criteria) this;
		}

		public Criteria andAndroidDownloadLessThanOrEqualTo(String value) {
			addCriterion("android_download <=", value, "androidDownload");
			return (Criteria) this;
		}

		public Criteria andAndroidDownloadLike(String value) {
			addCriterion("android_download like", value, "androidDownload");
			return (Criteria) this;
		}

		public Criteria andAndroidDownloadNotLike(String value) {
			addCriterion("android_download not like", value, "androidDownload");
			return (Criteria) this;
		}

		public Criteria andAndroidDownloadIn(List<String> values) {
			addCriterion("android_download in", values, "androidDownload");
			return (Criteria) this;
		}

		public Criteria andAndroidDownloadNotIn(List<String> values) {
			addCriterion("android_download not in", values, "androidDownload");
			return (Criteria) this;
		}

		public Criteria andAndroidDownloadBetween(String value1, String value2) {
			addCriterion("android_download between", value1, value2, "androidDownload");
			return (Criteria) this;
		}

		public Criteria andAndroidDownloadNotBetween(String value1, String value2) {
			addCriterion("android_download not between", value1, value2, "androidDownload");
			return (Criteria) this;
		}

		public Criteria andAndroidVersionIsNull() {
			addCriterion("android_version is null");
			return (Criteria) this;
		}

		public Criteria andAndroidVersionIsNotNull() {
			addCriterion("android_version is not null");
			return (Criteria) this;
		}

		public Criteria andAndroidVersionEqualTo(String value) {
			addCriterion("android_version =", value, "androidVersion");
			return (Criteria) this;
		}

		public Criteria andAndroidVersionNotEqualTo(String value) {
			addCriterion("android_version <>", value, "androidVersion");
			return (Criteria) this;
		}

		public Criteria andAndroidVersionGreaterThan(String value) {
			addCriterion("android_version >", value, "androidVersion");
			return (Criteria) this;
		}

		public Criteria andAndroidVersionGreaterThanOrEqualTo(String value) {
			addCriterion("android_version >=", value, "androidVersion");
			return (Criteria) this;
		}

		public Criteria andAndroidVersionLessThan(String value) {
			addCriterion("android_version <", value, "androidVersion");
			return (Criteria) this;
		}

		public Criteria andAndroidVersionLessThanOrEqualTo(String value) {
			addCriterion("android_version <=", value, "androidVersion");
			return (Criteria) this;
		}

		public Criteria andAndroidVersionLike(String value) {
			addCriterion("android_version like", value, "androidVersion");
			return (Criteria) this;
		}

		public Criteria andAndroidVersionNotLike(String value) {
			addCriterion("android_version not like", value, "androidVersion");
			return (Criteria) this;
		}

		public Criteria andAndroidVersionIn(List<String> values) {
			addCriterion("android_version in", values, "androidVersion");
			return (Criteria) this;
		}

		public Criteria andAndroidVersionNotIn(List<String> values) {
			addCriterion("android_version not in", values, "androidVersion");
			return (Criteria) this;
		}

		public Criteria andAndroidVersionBetween(String value1, String value2) {
			addCriterion("android_version between", value1, value2, "androidVersion");
			return (Criteria) this;
		}

		public Criteria andAndroidVersionNotBetween(String value1, String value2) {
			addCriterion("android_version not between", value1, value2, "androidVersion");
			return (Criteria) this;
		}

		public Criteria andApiKeyIsNull() {
			addCriterion("api_key is null");
			return (Criteria) this;
		}

		public Criteria andApiKeyIsNotNull() {
			addCriterion("api_key is not null");
			return (Criteria) this;
		}

		public Criteria andApiKeyEqualTo(String value) {
			addCriterion("api_key =", value, "apiKey");
			return (Criteria) this;
		}

		public Criteria andApiKeyNotEqualTo(String value) {
			addCriterion("api_key <>", value, "apiKey");
			return (Criteria) this;
		}

		public Criteria andApiKeyGreaterThan(String value) {
			addCriterion("api_key >", value, "apiKey");
			return (Criteria) this;
		}

		public Criteria andApiKeyGreaterThanOrEqualTo(String value) {
			addCriterion("api_key >=", value, "apiKey");
			return (Criteria) this;
		}

		public Criteria andApiKeyLessThan(String value) {
			addCriterion("api_key <", value, "apiKey");
			return (Criteria) this;
		}

		public Criteria andApiKeyLessThanOrEqualTo(String value) {
			addCriterion("api_key <=", value, "apiKey");
			return (Criteria) this;
		}

		public Criteria andApiKeyLike(String value) {
			addCriterion("api_key like", value, "apiKey");
			return (Criteria) this;
		}

		public Criteria andApiKeyNotLike(String value) {
			addCriterion("api_key not like", value, "apiKey");
			return (Criteria) this;
		}

		public Criteria andApiKeyIn(List<String> values) {
			addCriterion("api_key in", values, "apiKey");
			return (Criteria) this;
		}

		public Criteria andApiKeyNotIn(List<String> values) {
			addCriterion("api_key not in", values, "apiKey");
			return (Criteria) this;
		}

		public Criteria andApiKeyBetween(String value1, String value2) {
			addCriterion("api_key between", value1, value2, "apiKey");
			return (Criteria) this;
		}

		public Criteria andApiKeyNotBetween(String value1, String value2) {
			addCriterion("api_key not between", value1, value2, "apiKey");
			return (Criteria) this;
		}

		public Criteria andAppDownloadIsNull() {
			addCriterion("app_download is null");
			return (Criteria) this;
		}

		public Criteria andAppDownloadIsNotNull() {
			addCriterion("app_download is not null");
			return (Criteria) this;
		}

		public Criteria andAppDownloadEqualTo(Integer value) {
			addCriterion("app_download =", value, "appDownload");
			return (Criteria) this;
		}

		public Criteria andAppDownloadNotEqualTo(Integer value) {
			addCriterion("app_download <>", value, "appDownload");
			return (Criteria) this;
		}

		public Criteria andAppDownloadGreaterThan(Integer value) {
			addCriterion("app_download >", value, "appDownload");
			return (Criteria) this;
		}

		public Criteria andAppDownloadGreaterThanOrEqualTo(Integer value) {
			addCriterion("app_download >=", value, "appDownload");
			return (Criteria) this;
		}

		public Criteria andAppDownloadLessThan(Integer value) {
			addCriterion("app_download <", value, "appDownload");
			return (Criteria) this;
		}

		public Criteria andAppDownloadLessThanOrEqualTo(Integer value) {
			addCriterion("app_download <=", value, "appDownload");
			return (Criteria) this;
		}

		public Criteria andAppDownloadIn(List<Integer> values) {
			addCriterion("app_download in", values, "appDownload");
			return (Criteria) this;
		}

		public Criteria andAppDownloadNotIn(List<Integer> values) {
			addCriterion("app_download not in", values, "appDownload");
			return (Criteria) this;
		}

		public Criteria andAppDownloadBetween(Integer value1, Integer value2) {
			addCriterion("app_download between", value1, value2, "appDownload");
			return (Criteria) this;
		}

		public Criteria andAppDownloadNotBetween(Integer value1, Integer value2) {
			addCriterion("app_download not between", value1, value2, "appDownload");
			return (Criteria) this;
		}

		public Criteria andAutoOrderConfirmIsNull() {
			addCriterion("auto_order_confirm is null");
			return (Criteria) this;
		}

		public Criteria andAutoOrderConfirmIsNotNull() {
			addCriterion("auto_order_confirm is not null");
			return (Criteria) this;
		}

		public Criteria andAutoOrderConfirmEqualTo(Integer value) {
			addCriterion("auto_order_confirm =", value, "autoOrderConfirm");
			return (Criteria) this;
		}

		public Criteria andAutoOrderConfirmNotEqualTo(Integer value) {
			addCriterion("auto_order_confirm <>", value, "autoOrderConfirm");
			return (Criteria) this;
		}

		public Criteria andAutoOrderConfirmGreaterThan(Integer value) {
			addCriterion("auto_order_confirm >", value, "autoOrderConfirm");
			return (Criteria) this;
		}

		public Criteria andAutoOrderConfirmGreaterThanOrEqualTo(Integer value) {
			addCriterion("auto_order_confirm >=", value, "autoOrderConfirm");
			return (Criteria) this;
		}

		public Criteria andAutoOrderConfirmLessThan(Integer value) {
			addCriterion("auto_order_confirm <", value, "autoOrderConfirm");
			return (Criteria) this;
		}

		public Criteria andAutoOrderConfirmLessThanOrEqualTo(Integer value) {
			addCriterion("auto_order_confirm <=", value, "autoOrderConfirm");
			return (Criteria) this;
		}

		public Criteria andAutoOrderConfirmIn(List<Integer> values) {
			addCriterion("auto_order_confirm in", values, "autoOrderConfirm");
			return (Criteria) this;
		}

		public Criteria andAutoOrderConfirmNotIn(List<Integer> values) {
			addCriterion("auto_order_confirm not in", values, "autoOrderConfirm");
			return (Criteria) this;
		}

		public Criteria andAutoOrderConfirmBetween(Integer value1, Integer value2) {
			addCriterion("auto_order_confirm between", value1, value2, "autoOrderConfirm");
			return (Criteria) this;
		}

		public Criteria andAutoOrderConfirmNotBetween(Integer value1, Integer value2) {
			addCriterion("auto_order_confirm not between", value1, value2, "autoOrderConfirm");
			return (Criteria) this;
		}

		public Criteria andAutoOrderEvaluateIsNull() {
			addCriterion("auto_order_evaluate is null");
			return (Criteria) this;
		}

		public Criteria andAutoOrderEvaluateIsNotNull() {
			addCriterion("auto_order_evaluate is not null");
			return (Criteria) this;
		}

		public Criteria andAutoOrderEvaluateEqualTo(Integer value) {
			addCriterion("auto_order_evaluate =", value, "autoOrderEvaluate");
			return (Criteria) this;
		}

		public Criteria andAutoOrderEvaluateNotEqualTo(Integer value) {
			addCriterion("auto_order_evaluate <>", value, "autoOrderEvaluate");
			return (Criteria) this;
		}

		public Criteria andAutoOrderEvaluateGreaterThan(Integer value) {
			addCriterion("auto_order_evaluate >", value, "autoOrderEvaluate");
			return (Criteria) this;
		}

		public Criteria andAutoOrderEvaluateGreaterThanOrEqualTo(Integer value) {
			addCriterion("auto_order_evaluate >=", value, "autoOrderEvaluate");
			return (Criteria) this;
		}

		public Criteria andAutoOrderEvaluateLessThan(Integer value) {
			addCriterion("auto_order_evaluate <", value, "autoOrderEvaluate");
			return (Criteria) this;
		}

		public Criteria andAutoOrderEvaluateLessThanOrEqualTo(Integer value) {
			addCriterion("auto_order_evaluate <=", value, "autoOrderEvaluate");
			return (Criteria) this;
		}

		public Criteria andAutoOrderEvaluateIn(List<Integer> values) {
			addCriterion("auto_order_evaluate in", values, "autoOrderEvaluate");
			return (Criteria) this;
		}

		public Criteria andAutoOrderEvaluateNotIn(List<Integer> values) {
			addCriterion("auto_order_evaluate not in", values, "autoOrderEvaluate");
			return (Criteria) this;
		}

		public Criteria andAutoOrderEvaluateBetween(Integer value1, Integer value2) {
			addCriterion("auto_order_evaluate between", value1, value2, "autoOrderEvaluate");
			return (Criteria) this;
		}

		public Criteria andAutoOrderEvaluateNotBetween(Integer value1, Integer value2) {
			addCriterion("auto_order_evaluate not between", value1, value2, "autoOrderEvaluate");
			return (Criteria) this;
		}

		public Criteria andAutoOrderNoticeIsNull() {
			addCriterion("auto_order_notice is null");
			return (Criteria) this;
		}

		public Criteria andAutoOrderNoticeIsNotNull() {
			addCriterion("auto_order_notice is not null");
			return (Criteria) this;
		}

		public Criteria andAutoOrderNoticeEqualTo(Integer value) {
			addCriterion("auto_order_notice =", value, "autoOrderNotice");
			return (Criteria) this;
		}

		public Criteria andAutoOrderNoticeNotEqualTo(Integer value) {
			addCriterion("auto_order_notice <>", value, "autoOrderNotice");
			return (Criteria) this;
		}

		public Criteria andAutoOrderNoticeGreaterThan(Integer value) {
			addCriterion("auto_order_notice >", value, "autoOrderNotice");
			return (Criteria) this;
		}

		public Criteria andAutoOrderNoticeGreaterThanOrEqualTo(Integer value) {
			addCriterion("auto_order_notice >=", value, "autoOrderNotice");
			return (Criteria) this;
		}

		public Criteria andAutoOrderNoticeLessThan(Integer value) {
			addCriterion("auto_order_notice <", value, "autoOrderNotice");
			return (Criteria) this;
		}

		public Criteria andAutoOrderNoticeLessThanOrEqualTo(Integer value) {
			addCriterion("auto_order_notice <=", value, "autoOrderNotice");
			return (Criteria) this;
		}

		public Criteria andAutoOrderNoticeIn(List<Integer> values) {
			addCriterion("auto_order_notice in", values, "autoOrderNotice");
			return (Criteria) this;
		}

		public Criteria andAutoOrderNoticeNotIn(List<Integer> values) {
			addCriterion("auto_order_notice not in", values, "autoOrderNotice");
			return (Criteria) this;
		}

		public Criteria andAutoOrderNoticeBetween(Integer value1, Integer value2) {
			addCriterion("auto_order_notice between", value1, value2, "autoOrderNotice");
			return (Criteria) this;
		}

		public Criteria andAutoOrderNoticeNotBetween(Integer value1, Integer value2) {
			addCriterion("auto_order_notice not between", value1, value2, "autoOrderNotice");
			return (Criteria) this;
		}

		public Criteria andAutoOrderReturnIsNull() {
			addCriterion("auto_order_return is null");
			return (Criteria) this;
		}

		public Criteria andAutoOrderReturnIsNotNull() {
			addCriterion("auto_order_return is not null");
			return (Criteria) this;
		}

		public Criteria andAutoOrderReturnEqualTo(Integer value) {
			addCriterion("auto_order_return =", value, "autoOrderReturn");
			return (Criteria) this;
		}

		public Criteria andAutoOrderReturnNotEqualTo(Integer value) {
			addCriterion("auto_order_return <>", value, "autoOrderReturn");
			return (Criteria) this;
		}

		public Criteria andAutoOrderReturnGreaterThan(Integer value) {
			addCriterion("auto_order_return >", value, "autoOrderReturn");
			return (Criteria) this;
		}

		public Criteria andAutoOrderReturnGreaterThanOrEqualTo(Integer value) {
			addCriterion("auto_order_return >=", value, "autoOrderReturn");
			return (Criteria) this;
		}

		public Criteria andAutoOrderReturnLessThan(Integer value) {
			addCriterion("auto_order_return <", value, "autoOrderReturn");
			return (Criteria) this;
		}

		public Criteria andAutoOrderReturnLessThanOrEqualTo(Integer value) {
			addCriterion("auto_order_return <=", value, "autoOrderReturn");
			return (Criteria) this;
		}

		public Criteria andAutoOrderReturnIn(List<Integer> values) {
			addCriterion("auto_order_return in", values, "autoOrderReturn");
			return (Criteria) this;
		}

		public Criteria andAutoOrderReturnNotIn(List<Integer> values) {
			addCriterion("auto_order_return not in", values, "autoOrderReturn");
			return (Criteria) this;
		}

		public Criteria andAutoOrderReturnBetween(Integer value1, Integer value2) {
			addCriterion("auto_order_return between", value1, value2, "autoOrderReturn");
			return (Criteria) this;
		}

		public Criteria andAutoOrderReturnNotBetween(Integer value1, Integer value2) {
			addCriterion("auto_order_return not between", value1, value2, "autoOrderReturn");
			return (Criteria) this;
		}

		public Criteria andBigHeightIsNull() {
			addCriterion("big_height is null");
			return (Criteria) this;
		}

		public Criteria andBigHeightIsNotNull() {
			addCriterion("big_height is not null");
			return (Criteria) this;
		}

		public Criteria andBigHeightEqualTo(Integer value) {
			addCriterion("big_height =", value, "bigHeight");
			return (Criteria) this;
		}

		public Criteria andBigHeightNotEqualTo(Integer value) {
			addCriterion("big_height <>", value, "bigHeight");
			return (Criteria) this;
		}

		public Criteria andBigHeightGreaterThan(Integer value) {
			addCriterion("big_height >", value, "bigHeight");
			return (Criteria) this;
		}

		public Criteria andBigHeightGreaterThanOrEqualTo(Integer value) {
			addCriterion("big_height >=", value, "bigHeight");
			return (Criteria) this;
		}

		public Criteria andBigHeightLessThan(Integer value) {
			addCriterion("big_height <", value, "bigHeight");
			return (Criteria) this;
		}

		public Criteria andBigHeightLessThanOrEqualTo(Integer value) {
			addCriterion("big_height <=", value, "bigHeight");
			return (Criteria) this;
		}

		public Criteria andBigHeightIn(List<Integer> values) {
			addCriterion("big_height in", values, "bigHeight");
			return (Criteria) this;
		}

		public Criteria andBigHeightNotIn(List<Integer> values) {
			addCriterion("big_height not in", values, "bigHeight");
			return (Criteria) this;
		}

		public Criteria andBigHeightBetween(Integer value1, Integer value2) {
			addCriterion("big_height between", value1, value2, "bigHeight");
			return (Criteria) this;
		}

		public Criteria andBigHeightNotBetween(Integer value1, Integer value2) {
			addCriterion("big_height not between", value1, value2, "bigHeight");
			return (Criteria) this;
		}

		public Criteria andBigWidthIsNull() {
			addCriterion("big_width is null");
			return (Criteria) this;
		}

		public Criteria andBigWidthIsNotNull() {
			addCriterion("big_width is not null");
			return (Criteria) this;
		}

		public Criteria andBigWidthEqualTo(Integer value) {
			addCriterion("big_width =", value, "bigWidth");
			return (Criteria) this;
		}

		public Criteria andBigWidthNotEqualTo(Integer value) {
			addCriterion("big_width <>", value, "bigWidth");
			return (Criteria) this;
		}

		public Criteria andBigWidthGreaterThan(Integer value) {
			addCriterion("big_width >", value, "bigWidth");
			return (Criteria) this;
		}

		public Criteria andBigWidthGreaterThanOrEqualTo(Integer value) {
			addCriterion("big_width >=", value, "bigWidth");
			return (Criteria) this;
		}

		public Criteria andBigWidthLessThan(Integer value) {
			addCriterion("big_width <", value, "bigWidth");
			return (Criteria) this;
		}

		public Criteria andBigWidthLessThanOrEqualTo(Integer value) {
			addCriterion("big_width <=", value, "bigWidth");
			return (Criteria) this;
		}

		public Criteria andBigWidthIn(List<Integer> values) {
			addCriterion("big_width in", values, "bigWidth");
			return (Criteria) this;
		}

		public Criteria andBigWidthNotIn(List<Integer> values) {
			addCriterion("big_width not in", values, "bigWidth");
			return (Criteria) this;
		}

		public Criteria andBigWidthBetween(Integer value1, Integer value2) {
			addCriterion("big_width between", value1, value2, "bigWidth");
			return (Criteria) this;
		}

		public Criteria andBigWidthNotBetween(Integer value1, Integer value2) {
			addCriterion("big_width not between", value1, value2, "bigWidth");
			return (Criteria) this;
		}

		public Criteria andBuygiftMealGoldIsNull() {
			addCriterion("buygift_meal_gold is null");
			return (Criteria) this;
		}

		public Criteria andBuygiftMealGoldIsNotNull() {
			addCriterion("buygift_meal_gold is not null");
			return (Criteria) this;
		}

		public Criteria andBuygiftMealGoldEqualTo(Integer value) {
			addCriterion("buygift_meal_gold =", value, "buygiftMealGold");
			return (Criteria) this;
		}

		public Criteria andBuygiftMealGoldNotEqualTo(Integer value) {
			addCriterion("buygift_meal_gold <>", value, "buygiftMealGold");
			return (Criteria) this;
		}

		public Criteria andBuygiftMealGoldGreaterThan(Integer value) {
			addCriterion("buygift_meal_gold >", value, "buygiftMealGold");
			return (Criteria) this;
		}

		public Criteria andBuygiftMealGoldGreaterThanOrEqualTo(Integer value) {
			addCriterion("buygift_meal_gold >=", value, "buygiftMealGold");
			return (Criteria) this;
		}

		public Criteria andBuygiftMealGoldLessThan(Integer value) {
			addCriterion("buygift_meal_gold <", value, "buygiftMealGold");
			return (Criteria) this;
		}

		public Criteria andBuygiftMealGoldLessThanOrEqualTo(Integer value) {
			addCriterion("buygift_meal_gold <=", value, "buygiftMealGold");
			return (Criteria) this;
		}

		public Criteria andBuygiftMealGoldIn(List<Integer> values) {
			addCriterion("buygift_meal_gold in", values, "buygiftMealGold");
			return (Criteria) this;
		}

		public Criteria andBuygiftMealGoldNotIn(List<Integer> values) {
			addCriterion("buygift_meal_gold not in", values, "buygiftMealGold");
			return (Criteria) this;
		}

		public Criteria andBuygiftMealGoldBetween(Integer value1, Integer value2) {
			addCriterion("buygift_meal_gold between", value1, value2, "buygiftMealGold");
			return (Criteria) this;
		}

		public Criteria andBuygiftMealGoldNotBetween(Integer value1, Integer value2) {
			addCriterion("buygift_meal_gold not between", value1, value2, "buygiftMealGold");
			return (Criteria) this;
		}

		public Criteria andBuygiftStatusIsNull() {
			addCriterion("buygift_status is null");
			return (Criteria) this;
		}

		public Criteria andBuygiftStatusIsNotNull() {
			addCriterion("buygift_status is not null");
			return (Criteria) this;
		}

		public Criteria andBuygiftStatusEqualTo(Integer value) {
			addCriterion("buygift_status =", value, "buygiftStatus");
			return (Criteria) this;
		}

		public Criteria andBuygiftStatusNotEqualTo(Integer value) {
			addCriterion("buygift_status <>", value, "buygiftStatus");
			return (Criteria) this;
		}

		public Criteria andBuygiftStatusGreaterThan(Integer value) {
			addCriterion("buygift_status >", value, "buygiftStatus");
			return (Criteria) this;
		}

		public Criteria andBuygiftStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("buygift_status >=", value, "buygiftStatus");
			return (Criteria) this;
		}

		public Criteria andBuygiftStatusLessThan(Integer value) {
			addCriterion("buygift_status <", value, "buygiftStatus");
			return (Criteria) this;
		}

		public Criteria andBuygiftStatusLessThanOrEqualTo(Integer value) {
			addCriterion("buygift_status <=", value, "buygiftStatus");
			return (Criteria) this;
		}

		public Criteria andBuygiftStatusIn(List<Integer> values) {
			addCriterion("buygift_status in", values, "buygiftStatus");
			return (Criteria) this;
		}

		public Criteria andBuygiftStatusNotIn(List<Integer> values) {
			addCriterion("buygift_status not in", values, "buygiftStatus");
			return (Criteria) this;
		}

		public Criteria andBuygiftStatusBetween(Integer value1, Integer value2) {
			addCriterion("buygift_status between", value1, value2, "buygiftStatus");
			return (Criteria) this;
		}

		public Criteria andBuygiftStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("buygift_status not between", value1, value2, "buygiftStatus");
			return (Criteria) this;
		}

		public Criteria andCircleAuditIsNull() {
			addCriterion("circle_audit is null");
			return (Criteria) this;
		}

		public Criteria andCircleAuditIsNotNull() {
			addCriterion("circle_audit is not null");
			return (Criteria) this;
		}

		public Criteria andCircleAuditEqualTo(Integer value) {
			addCriterion("circle_audit =", value, "circleAudit");
			return (Criteria) this;
		}

		public Criteria andCircleAuditNotEqualTo(Integer value) {
			addCriterion("circle_audit <>", value, "circleAudit");
			return (Criteria) this;
		}

		public Criteria andCircleAuditGreaterThan(Integer value) {
			addCriterion("circle_audit >", value, "circleAudit");
			return (Criteria) this;
		}

		public Criteria andCircleAuditGreaterThanOrEqualTo(Integer value) {
			addCriterion("circle_audit >=", value, "circleAudit");
			return (Criteria) this;
		}

		public Criteria andCircleAuditLessThan(Integer value) {
			addCriterion("circle_audit <", value, "circleAudit");
			return (Criteria) this;
		}

		public Criteria andCircleAuditLessThanOrEqualTo(Integer value) {
			addCriterion("circle_audit <=", value, "circleAudit");
			return (Criteria) this;
		}

		public Criteria andCircleAuditIn(List<Integer> values) {
			addCriterion("circle_audit in", values, "circleAudit");
			return (Criteria) this;
		}

		public Criteria andCircleAuditNotIn(List<Integer> values) {
			addCriterion("circle_audit not in", values, "circleAudit");
			return (Criteria) this;
		}

		public Criteria andCircleAuditBetween(Integer value1, Integer value2) {
			addCriterion("circle_audit between", value1, value2, "circleAudit");
			return (Criteria) this;
		}

		public Criteria andCircleAuditNotBetween(Integer value1, Integer value2) {
			addCriterion("circle_audit not between", value1, value2, "circleAudit");
			return (Criteria) this;
		}

		public Criteria andCircleCountIsNull() {
			addCriterion("circle_count is null");
			return (Criteria) this;
		}

		public Criteria andCircleCountIsNotNull() {
			addCriterion("circle_count is not null");
			return (Criteria) this;
		}

		public Criteria andCircleCountEqualTo(Integer value) {
			addCriterion("circle_count =", value, "circleCount");
			return (Criteria) this;
		}

		public Criteria andCircleCountNotEqualTo(Integer value) {
			addCriterion("circle_count <>", value, "circleCount");
			return (Criteria) this;
		}

		public Criteria andCircleCountGreaterThan(Integer value) {
			addCriterion("circle_count >", value, "circleCount");
			return (Criteria) this;
		}

		public Criteria andCircleCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("circle_count >=", value, "circleCount");
			return (Criteria) this;
		}

		public Criteria andCircleCountLessThan(Integer value) {
			addCriterion("circle_count <", value, "circleCount");
			return (Criteria) this;
		}

		public Criteria andCircleCountLessThanOrEqualTo(Integer value) {
			addCriterion("circle_count <=", value, "circleCount");
			return (Criteria) this;
		}

		public Criteria andCircleCountIn(List<Integer> values) {
			addCriterion("circle_count in", values, "circleCount");
			return (Criteria) this;
		}

		public Criteria andCircleCountNotIn(List<Integer> values) {
			addCriterion("circle_count not in", values, "circleCount");
			return (Criteria) this;
		}

		public Criteria andCircleCountBetween(Integer value1, Integer value2) {
			addCriterion("circle_count between", value1, value2, "circleCount");
			return (Criteria) this;
		}

		public Criteria andCircleCountNotBetween(Integer value1, Integer value2) {
			addCriterion("circle_count not between", value1, value2, "circleCount");
			return (Criteria) this;
		}

		public Criteria andCircleLimitIsNull() {
			addCriterion("circle_limit is null");
			return (Criteria) this;
		}

		public Criteria andCircleLimitIsNotNull() {
			addCriterion("circle_limit is not null");
			return (Criteria) this;
		}

		public Criteria andCircleLimitEqualTo(Integer value) {
			addCriterion("circle_limit =", value, "circleLimit");
			return (Criteria) this;
		}

		public Criteria andCircleLimitNotEqualTo(Integer value) {
			addCriterion("circle_limit <>", value, "circleLimit");
			return (Criteria) this;
		}

		public Criteria andCircleLimitGreaterThan(Integer value) {
			addCriterion("circle_limit >", value, "circleLimit");
			return (Criteria) this;
		}

		public Criteria andCircleLimitGreaterThanOrEqualTo(Integer value) {
			addCriterion("circle_limit >=", value, "circleLimit");
			return (Criteria) this;
		}

		public Criteria andCircleLimitLessThan(Integer value) {
			addCriterion("circle_limit <", value, "circleLimit");
			return (Criteria) this;
		}

		public Criteria andCircleLimitLessThanOrEqualTo(Integer value) {
			addCriterion("circle_limit <=", value, "circleLimit");
			return (Criteria) this;
		}

		public Criteria andCircleLimitIn(List<Integer> values) {
			addCriterion("circle_limit in", values, "circleLimit");
			return (Criteria) this;
		}

		public Criteria andCircleLimitNotIn(List<Integer> values) {
			addCriterion("circle_limit not in", values, "circleLimit");
			return (Criteria) this;
		}

		public Criteria andCircleLimitBetween(Integer value1, Integer value2) {
			addCriterion("circle_limit between", value1, value2, "circleLimit");
			return (Criteria) this;
		}

		public Criteria andCircleLimitNotBetween(Integer value1, Integer value2) {
			addCriterion("circle_limit not between", value1, value2, "circleLimit");
			return (Criteria) this;
		}

		public Criteria andCircleOpenIsNull() {
			addCriterion("circle_open is null");
			return (Criteria) this;
		}

		public Criteria andCircleOpenIsNotNull() {
			addCriterion("circle_open is not null");
			return (Criteria) this;
		}

		public Criteria andCircleOpenEqualTo(Integer value) {
			addCriterion("circle_open =", value, "circleOpen");
			return (Criteria) this;
		}

		public Criteria andCircleOpenNotEqualTo(Integer value) {
			addCriterion("circle_open <>", value, "circleOpen");
			return (Criteria) this;
		}

		public Criteria andCircleOpenGreaterThan(Integer value) {
			addCriterion("circle_open >", value, "circleOpen");
			return (Criteria) this;
		}

		public Criteria andCircleOpenGreaterThanOrEqualTo(Integer value) {
			addCriterion("circle_open >=", value, "circleOpen");
			return (Criteria) this;
		}

		public Criteria andCircleOpenLessThan(Integer value) {
			addCriterion("circle_open <", value, "circleOpen");
			return (Criteria) this;
		}

		public Criteria andCircleOpenLessThanOrEqualTo(Integer value) {
			addCriterion("circle_open <=", value, "circleOpen");
			return (Criteria) this;
		}

		public Criteria andCircleOpenIn(List<Integer> values) {
			addCriterion("circle_open in", values, "circleOpen");
			return (Criteria) this;
		}

		public Criteria andCircleOpenNotIn(List<Integer> values) {
			addCriterion("circle_open not in", values, "circleOpen");
			return (Criteria) this;
		}

		public Criteria andCircleOpenBetween(Integer value1, Integer value2) {
			addCriterion("circle_open between", value1, value2, "circleOpen");
			return (Criteria) this;
		}

		public Criteria andCircleOpenNotBetween(Integer value1, Integer value2) {
			addCriterion("circle_open not between", value1, value2, "circleOpen");
			return (Criteria) this;
		}

		public Criteria andCombinAmountIsNull() {
			addCriterion("combin_amount is null");
			return (Criteria) this;
		}

		public Criteria andCombinAmountIsNotNull() {
			addCriterion("combin_amount is not null");
			return (Criteria) this;
		}

		public Criteria andCombinAmountEqualTo(Integer value) {
			addCriterion("combin_amount =", value, "combinAmount");
			return (Criteria) this;
		}

		public Criteria andCombinAmountNotEqualTo(Integer value) {
			addCriterion("combin_amount <>", value, "combinAmount");
			return (Criteria) this;
		}

		public Criteria andCombinAmountGreaterThan(Integer value) {
			addCriterion("combin_amount >", value, "combinAmount");
			return (Criteria) this;
		}

		public Criteria andCombinAmountGreaterThanOrEqualTo(Integer value) {
			addCriterion("combin_amount >=", value, "combinAmount");
			return (Criteria) this;
		}

		public Criteria andCombinAmountLessThan(Integer value) {
			addCriterion("combin_amount <", value, "combinAmount");
			return (Criteria) this;
		}

		public Criteria andCombinAmountLessThanOrEqualTo(Integer value) {
			addCriterion("combin_amount <=", value, "combinAmount");
			return (Criteria) this;
		}

		public Criteria andCombinAmountIn(List<Integer> values) {
			addCriterion("combin_amount in", values, "combinAmount");
			return (Criteria) this;
		}

		public Criteria andCombinAmountNotIn(List<Integer> values) {
			addCriterion("combin_amount not in", values, "combinAmount");
			return (Criteria) this;
		}

		public Criteria andCombinAmountBetween(Integer value1, Integer value2) {
			addCriterion("combin_amount between", value1, value2, "combinAmount");
			return (Criteria) this;
		}

		public Criteria andCombinAmountNotBetween(Integer value1, Integer value2) {
			addCriterion("combin_amount not between", value1, value2, "combinAmount");
			return (Criteria) this;
		}

		public Criteria andCombinCountIsNull() {
			addCriterion("combin_count is null");
			return (Criteria) this;
		}

		public Criteria andCombinCountIsNotNull() {
			addCriterion("combin_count is not null");
			return (Criteria) this;
		}

		public Criteria andCombinCountEqualTo(Integer value) {
			addCriterion("combin_count =", value, "combinCount");
			return (Criteria) this;
		}

		public Criteria andCombinCountNotEqualTo(Integer value) {
			addCriterion("combin_count <>", value, "combinCount");
			return (Criteria) this;
		}

		public Criteria andCombinCountGreaterThan(Integer value) {
			addCriterion("combin_count >", value, "combinCount");
			return (Criteria) this;
		}

		public Criteria andCombinCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("combin_count >=", value, "combinCount");
			return (Criteria) this;
		}

		public Criteria andCombinCountLessThan(Integer value) {
			addCriterion("combin_count <", value, "combinCount");
			return (Criteria) this;
		}

		public Criteria andCombinCountLessThanOrEqualTo(Integer value) {
			addCriterion("combin_count <=", value, "combinCount");
			return (Criteria) this;
		}

		public Criteria andCombinCountIn(List<Integer> values) {
			addCriterion("combin_count in", values, "combinCount");
			return (Criteria) this;
		}

		public Criteria andCombinCountNotIn(List<Integer> values) {
			addCriterion("combin_count not in", values, "combinCount");
			return (Criteria) this;
		}

		public Criteria andCombinCountBetween(Integer value1, Integer value2) {
			addCriterion("combin_count between", value1, value2, "combinCount");
			return (Criteria) this;
		}

		public Criteria andCombinCountNotBetween(Integer value1, Integer value2) {
			addCriterion("combin_count not between", value1, value2, "combinCount");
			return (Criteria) this;
		}

		public Criteria andCombinSchemeCountIsNull() {
			addCriterion("combin_scheme_count is null");
			return (Criteria) this;
		}

		public Criteria andCombinSchemeCountIsNotNull() {
			addCriterion("combin_scheme_count is not null");
			return (Criteria) this;
		}

		public Criteria andCombinSchemeCountEqualTo(Integer value) {
			addCriterion("combin_scheme_count =", value, "combinSchemeCount");
			return (Criteria) this;
		}

		public Criteria andCombinSchemeCountNotEqualTo(Integer value) {
			addCriterion("combin_scheme_count <>", value, "combinSchemeCount");
			return (Criteria) this;
		}

		public Criteria andCombinSchemeCountGreaterThan(Integer value) {
			addCriterion("combin_scheme_count >", value, "combinSchemeCount");
			return (Criteria) this;
		}

		public Criteria andCombinSchemeCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("combin_scheme_count >=", value, "combinSchemeCount");
			return (Criteria) this;
		}

		public Criteria andCombinSchemeCountLessThan(Integer value) {
			addCriterion("combin_scheme_count <", value, "combinSchemeCount");
			return (Criteria) this;
		}

		public Criteria andCombinSchemeCountLessThanOrEqualTo(Integer value) {
			addCriterion("combin_scheme_count <=", value, "combinSchemeCount");
			return (Criteria) this;
		}

		public Criteria andCombinSchemeCountIn(List<Integer> values) {
			addCriterion("combin_scheme_count in", values, "combinSchemeCount");
			return (Criteria) this;
		}

		public Criteria andCombinSchemeCountNotIn(List<Integer> values) {
			addCriterion("combin_scheme_count not in", values, "combinSchemeCount");
			return (Criteria) this;
		}

		public Criteria andCombinSchemeCountBetween(Integer value1, Integer value2) {
			addCriterion("combin_scheme_count between", value1, value2, "combinSchemeCount");
			return (Criteria) this;
		}

		public Criteria andCombinSchemeCountNotBetween(Integer value1, Integer value2) {
			addCriterion("combin_scheme_count not between", value1, value2, "combinSchemeCount");
			return (Criteria) this;
		}

		public Criteria andCombinStatusIsNull() {
			addCriterion("combin_status is null");
			return (Criteria) this;
		}

		public Criteria andCombinStatusIsNotNull() {
			addCriterion("combin_status is not null");
			return (Criteria) this;
		}

		public Criteria andCombinStatusEqualTo(Integer value) {
			addCriterion("combin_status =", value, "combinStatus");
			return (Criteria) this;
		}

		public Criteria andCombinStatusNotEqualTo(Integer value) {
			addCriterion("combin_status <>", value, "combinStatus");
			return (Criteria) this;
		}

		public Criteria andCombinStatusGreaterThan(Integer value) {
			addCriterion("combin_status >", value, "combinStatus");
			return (Criteria) this;
		}

		public Criteria andCombinStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("combin_status >=", value, "combinStatus");
			return (Criteria) this;
		}

		public Criteria andCombinStatusLessThan(Integer value) {
			addCriterion("combin_status <", value, "combinStatus");
			return (Criteria) this;
		}

		public Criteria andCombinStatusLessThanOrEqualTo(Integer value) {
			addCriterion("combin_status <=", value, "combinStatus");
			return (Criteria) this;
		}

		public Criteria andCombinStatusIn(List<Integer> values) {
			addCriterion("combin_status in", values, "combinStatus");
			return (Criteria) this;
		}

		public Criteria andCombinStatusNotIn(List<Integer> values) {
			addCriterion("combin_status not in", values, "combinStatus");
			return (Criteria) this;
		}

		public Criteria andCombinStatusBetween(Integer value1, Integer value2) {
			addCriterion("combin_status between", value1, value2, "combinStatus");
			return (Criteria) this;
		}

		public Criteria andCombinStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("combin_status not between", value1, value2, "combinStatus");
			return (Criteria) this;
		}

		public Criteria andCompanyNameIsNull() {
			addCriterion("company_name is null");
			return (Criteria) this;
		}

		public Criteria andCompanyNameIsNotNull() {
			addCriterion("company_name is not null");
			return (Criteria) this;
		}

		public Criteria andCompanyNameEqualTo(String value) {
			addCriterion("company_name =", value, "companyName");
			return (Criteria) this;
		}

		public Criteria andCompanyNameNotEqualTo(String value) {
			addCriterion("company_name <>", value, "companyName");
			return (Criteria) this;
		}

		public Criteria andCompanyNameGreaterThan(String value) {
			addCriterion("company_name >", value, "companyName");
			return (Criteria) this;
		}

		public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
			addCriterion("company_name >=", value, "companyName");
			return (Criteria) this;
		}

		public Criteria andCompanyNameLessThan(String value) {
			addCriterion("company_name <", value, "companyName");
			return (Criteria) this;
		}

		public Criteria andCompanyNameLessThanOrEqualTo(String value) {
			addCriterion("company_name <=", value, "companyName");
			return (Criteria) this;
		}

		public Criteria andCompanyNameLike(String value) {
			addCriterion("company_name like", value, "companyName");
			return (Criteria) this;
		}

		public Criteria andCompanyNameNotLike(String value) {
			addCriterion("company_name not like", value, "companyName");
			return (Criteria) this;
		}

		public Criteria andCompanyNameIn(List<String> values) {
			addCriterion("company_name in", values, "companyName");
			return (Criteria) this;
		}

		public Criteria andCompanyNameNotIn(List<String> values) {
			addCriterion("company_name not in", values, "companyName");
			return (Criteria) this;
		}

		public Criteria andCompanyNameBetween(String value1, String value2) {
			addCriterion("company_name between", value1, value2, "companyName");
			return (Criteria) this;
		}

		public Criteria andCompanyNameNotBetween(String value1, String value2) {
			addCriterion("company_name not between", value1, value2, "companyName");
			return (Criteria) this;
		}

		public Criteria andComplaintTimeIsNull() {
			addCriterion("complaint_time is null");
			return (Criteria) this;
		}

		public Criteria andComplaintTimeIsNotNull() {
			addCriterion("complaint_time is not null");
			return (Criteria) this;
		}

		public Criteria andComplaintTimeEqualTo(Integer value) {
			addCriterion("complaint_time =", value, "complaintTime");
			return (Criteria) this;
		}

		public Criteria andComplaintTimeNotEqualTo(Integer value) {
			addCriterion("complaint_time <>", value, "complaintTime");
			return (Criteria) this;
		}

		public Criteria andComplaintTimeGreaterThan(Integer value) {
			addCriterion("complaint_time >", value, "complaintTime");
			return (Criteria) this;
		}

		public Criteria andComplaintTimeGreaterThanOrEqualTo(Integer value) {
			addCriterion("complaint_time >=", value, "complaintTime");
			return (Criteria) this;
		}

		public Criteria andComplaintTimeLessThan(Integer value) {
			addCriterion("complaint_time <", value, "complaintTime");
			return (Criteria) this;
		}

		public Criteria andComplaintTimeLessThanOrEqualTo(Integer value) {
			addCriterion("complaint_time <=", value, "complaintTime");
			return (Criteria) this;
		}

		public Criteria andComplaintTimeIn(List<Integer> values) {
			addCriterion("complaint_time in", values, "complaintTime");
			return (Criteria) this;
		}

		public Criteria andComplaintTimeNotIn(List<Integer> values) {
			addCriterion("complaint_time not in", values, "complaintTime");
			return (Criteria) this;
		}

		public Criteria andComplaintTimeBetween(Integer value1, Integer value2) {
			addCriterion("complaint_time between", value1, value2, "complaintTime");
			return (Criteria) this;
		}

		public Criteria andComplaintTimeNotBetween(Integer value1, Integer value2) {
			addCriterion("complaint_time not between", value1, value2, "complaintTime");
			return (Criteria) this;
		}

		public Criteria andConsumptionRatioIsNull() {
			addCriterion("consumption_ratio is null");
			return (Criteria) this;
		}

		public Criteria andConsumptionRatioIsNotNull() {
			addCriterion("consumption_ratio is not null");
			return (Criteria) this;
		}

		public Criteria andConsumptionRatioEqualTo(Integer value) {
			addCriterion("consumption_ratio =", value, "consumptionRatio");
			return (Criteria) this;
		}

		public Criteria andConsumptionRatioNotEqualTo(Integer value) {
			addCriterion("consumption_ratio <>", value, "consumptionRatio");
			return (Criteria) this;
		}

		public Criteria andConsumptionRatioGreaterThan(Integer value) {
			addCriterion("consumption_ratio >", value, "consumptionRatio");
			return (Criteria) this;
		}

		public Criteria andConsumptionRatioGreaterThanOrEqualTo(Integer value) {
			addCriterion("consumption_ratio >=", value, "consumptionRatio");
			return (Criteria) this;
		}

		public Criteria andConsumptionRatioLessThan(Integer value) {
			addCriterion("consumption_ratio <", value, "consumptionRatio");
			return (Criteria) this;
		}

		public Criteria andConsumptionRatioLessThanOrEqualTo(Integer value) {
			addCriterion("consumption_ratio <=", value, "consumptionRatio");
			return (Criteria) this;
		}

		public Criteria andConsumptionRatioIn(List<Integer> values) {
			addCriterion("consumption_ratio in", values, "consumptionRatio");
			return (Criteria) this;
		}

		public Criteria andConsumptionRatioNotIn(List<Integer> values) {
			addCriterion("consumption_ratio not in", values, "consumptionRatio");
			return (Criteria) this;
		}

		public Criteria andConsumptionRatioBetween(Integer value1, Integer value2) {
			addCriterion("consumption_ratio between", value1, value2, "consumptionRatio");
			return (Criteria) this;
		}

		public Criteria andConsumptionRatioNotBetween(Integer value1, Integer value2) {
			addCriterion("consumption_ratio not between", value1, value2, "consumptionRatio");
			return (Criteria) this;
		}

		public Criteria andCopyRightIsNull() {
			addCriterion("copy_right is null");
			return (Criteria) this;
		}

		public Criteria andCopyRightIsNotNull() {
			addCriterion("copy_right is not null");
			return (Criteria) this;
		}

		public Criteria andCopyRightEqualTo(String value) {
			addCriterion("copy_right =", value, "copyRight");
			return (Criteria) this;
		}

		public Criteria andCopyRightNotEqualTo(String value) {
			addCriterion("copy_right <>", value, "copyRight");
			return (Criteria) this;
		}

		public Criteria andCopyRightGreaterThan(String value) {
			addCriterion("copy_right >", value, "copyRight");
			return (Criteria) this;
		}

		public Criteria andCopyRightGreaterThanOrEqualTo(String value) {
			addCriterion("copy_right >=", value, "copyRight");
			return (Criteria) this;
		}

		public Criteria andCopyRightLessThan(String value) {
			addCriterion("copy_right <", value, "copyRight");
			return (Criteria) this;
		}

		public Criteria andCopyRightLessThanOrEqualTo(String value) {
			addCriterion("copy_right <=", value, "copyRight");
			return (Criteria) this;
		}

		public Criteria andCopyRightLike(String value) {
			addCriterion("copy_right like", value, "copyRight");
			return (Criteria) this;
		}

		public Criteria andCopyRightNotLike(String value) {
			addCriterion("copy_right not like", value, "copyRight");
			return (Criteria) this;
		}

		public Criteria andCopyRightIn(List<String> values) {
			addCriterion("copy_right in", values, "copyRight");
			return (Criteria) this;
		}

		public Criteria andCopyRightNotIn(List<String> values) {
			addCriterion("copy_right not in", values, "copyRight");
			return (Criteria) this;
		}

		public Criteria andCopyRightBetween(String value1, String value2) {
			addCriterion("copy_right between", value1, value2, "copyRight");
			return (Criteria) this;
		}

		public Criteria andCopyRightNotBetween(String value1, String value2) {
			addCriterion("copy_right not between", value1, value2, "copyRight");
			return (Criteria) this;
		}

		public Criteria andCurrencyCodeIsNull() {
			addCriterion("currency_code is null");
			return (Criteria) this;
		}

		public Criteria andCurrencyCodeIsNotNull() {
			addCriterion("currency_code is not null");
			return (Criteria) this;
		}

		public Criteria andCurrencyCodeEqualTo(String value) {
			addCriterion("currency_code =", value, "currencyCode");
			return (Criteria) this;
		}

		public Criteria andCurrencyCodeNotEqualTo(String value) {
			addCriterion("currency_code <>", value, "currencyCode");
			return (Criteria) this;
		}

		public Criteria andCurrencyCodeGreaterThan(String value) {
			addCriterion("currency_code >", value, "currencyCode");
			return (Criteria) this;
		}

		public Criteria andCurrencyCodeGreaterThanOrEqualTo(String value) {
			addCriterion("currency_code >=", value, "currencyCode");
			return (Criteria) this;
		}

		public Criteria andCurrencyCodeLessThan(String value) {
			addCriterion("currency_code <", value, "currencyCode");
			return (Criteria) this;
		}

		public Criteria andCurrencyCodeLessThanOrEqualTo(String value) {
			addCriterion("currency_code <=", value, "currencyCode");
			return (Criteria) this;
		}

		public Criteria andCurrencyCodeLike(String value) {
			addCriterion("currency_code like", value, "currencyCode");
			return (Criteria) this;
		}

		public Criteria andCurrencyCodeNotLike(String value) {
			addCriterion("currency_code not like", value, "currencyCode");
			return (Criteria) this;
		}

		public Criteria andCurrencyCodeIn(List<String> values) {
			addCriterion("currency_code in", values, "currencyCode");
			return (Criteria) this;
		}

		public Criteria andCurrencyCodeNotIn(List<String> values) {
			addCriterion("currency_code not in", values, "currencyCode");
			return (Criteria) this;
		}

		public Criteria andCurrencyCodeBetween(String value1, String value2) {
			addCriterion("currency_code between", value1, value2, "currencyCode");
			return (Criteria) this;
		}

		public Criteria andCurrencyCodeNotBetween(String value1, String value2) {
			addCriterion("currency_code not between", value1, value2, "currencyCode");
			return (Criteria) this;
		}

		public Criteria andDepositIsNull() {
			addCriterion("deposit is null");
			return (Criteria) this;
		}

		public Criteria andDepositIsNotNull() {
			addCriterion("deposit is not null");
			return (Criteria) this;
		}

		public Criteria andDepositEqualTo(Boolean value) {
			addCriterion("deposit =", value, "deposit");
			return (Criteria) this;
		}

		public Criteria andDepositNotEqualTo(Boolean value) {
			addCriterion("deposit <>", value, "deposit");
			return (Criteria) this;
		}

		public Criteria andDepositGreaterThan(Boolean value) {
			addCriterion("deposit >", value, "deposit");
			return (Criteria) this;
		}

		public Criteria andDepositGreaterThanOrEqualTo(Boolean value) {
			addCriterion("deposit >=", value, "deposit");
			return (Criteria) this;
		}

		public Criteria andDepositLessThan(Boolean value) {
			addCriterion("deposit <", value, "deposit");
			return (Criteria) this;
		}

		public Criteria andDepositLessThanOrEqualTo(Boolean value) {
			addCriterion("deposit <=", value, "deposit");
			return (Criteria) this;
		}

		public Criteria andDepositIn(List<Boolean> values) {
			addCriterion("deposit in", values, "deposit");
			return (Criteria) this;
		}

		public Criteria andDepositNotIn(List<Boolean> values) {
			addCriterion("deposit not in", values, "deposit");
			return (Criteria) this;
		}

		public Criteria andDepositBetween(Boolean value1, Boolean value2) {
			addCriterion("deposit between", value1, value2, "deposit");
			return (Criteria) this;
		}

		public Criteria andDepositNotBetween(Boolean value1, Boolean value2) {
			addCriterion("deposit not between", value1, value2, "deposit");
			return (Criteria) this;
		}

		public Criteria andDescriptionIsNull() {
			addCriterion("description is null");
			return (Criteria) this;
		}

		public Criteria andDescriptionIsNotNull() {
			addCriterion("description is not null");
			return (Criteria) this;
		}

		public Criteria andDescriptionEqualTo(String value) {
			addCriterion("description =", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotEqualTo(String value) {
			addCriterion("description <>", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionGreaterThan(String value) {
			addCriterion("description >", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
			addCriterion("description >=", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLessThan(String value) {
			addCriterion("description <", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLessThanOrEqualTo(String value) {
			addCriterion("description <=", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLike(String value) {
			addCriterion("description like", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotLike(String value) {
			addCriterion("description not like", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionIn(List<String> values) {
			addCriterion("description in", values, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotIn(List<String> values) {
			addCriterion("description not in", values, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionBetween(String value1, String value2) {
			addCriterion("description between", value1, value2, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotBetween(String value1, String value2) {
			addCriterion("description not between", value1, value2, "description");
			return (Criteria) this;
		}

		public Criteria andDomainAllowCountIsNull() {
			addCriterion("domain_allow_count is null");
			return (Criteria) this;
		}

		public Criteria andDomainAllowCountIsNotNull() {
			addCriterion("domain_allow_count is not null");
			return (Criteria) this;
		}

		public Criteria andDomainAllowCountEqualTo(Integer value) {
			addCriterion("domain_allow_count =", value, "domainAllowCount");
			return (Criteria) this;
		}

		public Criteria andDomainAllowCountNotEqualTo(Integer value) {
			addCriterion("domain_allow_count <>", value, "domainAllowCount");
			return (Criteria) this;
		}

		public Criteria andDomainAllowCountGreaterThan(Integer value) {
			addCriterion("domain_allow_count >", value, "domainAllowCount");
			return (Criteria) this;
		}

		public Criteria andDomainAllowCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("domain_allow_count >=", value, "domainAllowCount");
			return (Criteria) this;
		}

		public Criteria andDomainAllowCountLessThan(Integer value) {
			addCriterion("domain_allow_count <", value, "domainAllowCount");
			return (Criteria) this;
		}

		public Criteria andDomainAllowCountLessThanOrEqualTo(Integer value) {
			addCriterion("domain_allow_count <=", value, "domainAllowCount");
			return (Criteria) this;
		}

		public Criteria andDomainAllowCountIn(List<Integer> values) {
			addCriterion("domain_allow_count in", values, "domainAllowCount");
			return (Criteria) this;
		}

		public Criteria andDomainAllowCountNotIn(List<Integer> values) {
			addCriterion("domain_allow_count not in", values, "domainAllowCount");
			return (Criteria) this;
		}

		public Criteria andDomainAllowCountBetween(Integer value1, Integer value2) {
			addCriterion("domain_allow_count between", value1, value2, "domainAllowCount");
			return (Criteria) this;
		}

		public Criteria andDomainAllowCountNotBetween(Integer value1, Integer value2) {
			addCriterion("domain_allow_count not between", value1, value2, "domainAllowCount");
			return (Criteria) this;
		}

		public Criteria andEmailEnableIsNull() {
			addCriterion("email_enable is null");
			return (Criteria) this;
		}

		public Criteria andEmailEnableIsNotNull() {
			addCriterion("email_enable is not null");
			return (Criteria) this;
		}

		public Criteria andEmailEnableEqualTo(Boolean value) {
			addCriterion("email_enable =", value, "emailEnable");
			return (Criteria) this;
		}

		public Criteria andEmailEnableNotEqualTo(Boolean value) {
			addCriterion("email_enable <>", value, "emailEnable");
			return (Criteria) this;
		}

		public Criteria andEmailEnableGreaterThan(Boolean value) {
			addCriterion("email_enable >", value, "emailEnable");
			return (Criteria) this;
		}

		public Criteria andEmailEnableGreaterThanOrEqualTo(Boolean value) {
			addCriterion("email_enable >=", value, "emailEnable");
			return (Criteria) this;
		}

		public Criteria andEmailEnableLessThan(Boolean value) {
			addCriterion("email_enable <", value, "emailEnable");
			return (Criteria) this;
		}

		public Criteria andEmailEnableLessThanOrEqualTo(Boolean value) {
			addCriterion("email_enable <=", value, "emailEnable");
			return (Criteria) this;
		}

		public Criteria andEmailEnableIn(List<Boolean> values) {
			addCriterion("email_enable in", values, "emailEnable");
			return (Criteria) this;
		}

		public Criteria andEmailEnableNotIn(List<Boolean> values) {
			addCriterion("email_enable not in", values, "emailEnable");
			return (Criteria) this;
		}

		public Criteria andEmailEnableBetween(Boolean value1, Boolean value2) {
			addCriterion("email_enable between", value1, value2, "emailEnable");
			return (Criteria) this;
		}

		public Criteria andEmailEnableNotBetween(Boolean value1, Boolean value2) {
			addCriterion("email_enable not between", value1, value2, "emailEnable");
			return (Criteria) this;
		}

		public Criteria andEmailHostIsNull() {
			addCriterion("email_host is null");
			return (Criteria) this;
		}

		public Criteria andEmailHostIsNotNull() {
			addCriterion("email_host is not null");
			return (Criteria) this;
		}

		public Criteria andEmailHostEqualTo(String value) {
			addCriterion("email_host =", value, "emailHost");
			return (Criteria) this;
		}

		public Criteria andEmailHostNotEqualTo(String value) {
			addCriterion("email_host <>", value, "emailHost");
			return (Criteria) this;
		}

		public Criteria andEmailHostGreaterThan(String value) {
			addCriterion("email_host >", value, "emailHost");
			return (Criteria) this;
		}

		public Criteria andEmailHostGreaterThanOrEqualTo(String value) {
			addCriterion("email_host >=", value, "emailHost");
			return (Criteria) this;
		}

		public Criteria andEmailHostLessThan(String value) {
			addCriterion("email_host <", value, "emailHost");
			return (Criteria) this;
		}

		public Criteria andEmailHostLessThanOrEqualTo(String value) {
			addCriterion("email_host <=", value, "emailHost");
			return (Criteria) this;
		}

		public Criteria andEmailHostLike(String value) {
			addCriterion("email_host like", value, "emailHost");
			return (Criteria) this;
		}

		public Criteria andEmailHostNotLike(String value) {
			addCriterion("email_host not like", value, "emailHost");
			return (Criteria) this;
		}

		public Criteria andEmailHostIn(List<String> values) {
			addCriterion("email_host in", values, "emailHost");
			return (Criteria) this;
		}

		public Criteria andEmailHostNotIn(List<String> values) {
			addCriterion("email_host not in", values, "emailHost");
			return (Criteria) this;
		}

		public Criteria andEmailHostBetween(String value1, String value2) {
			addCriterion("email_host between", value1, value2, "emailHost");
			return (Criteria) this;
		}

		public Criteria andEmailHostNotBetween(String value1, String value2) {
			addCriterion("email_host not between", value1, value2, "emailHost");
			return (Criteria) this;
		}

		public Criteria andEmailPortIsNull() {
			addCriterion("email_port is null");
			return (Criteria) this;
		}

		public Criteria andEmailPortIsNotNull() {
			addCriterion("email_port is not null");
			return (Criteria) this;
		}

		public Criteria andEmailPortEqualTo(Integer value) {
			addCriterion("email_port =", value, "emailPort");
			return (Criteria) this;
		}

		public Criteria andEmailPortNotEqualTo(Integer value) {
			addCriterion("email_port <>", value, "emailPort");
			return (Criteria) this;
		}

		public Criteria andEmailPortGreaterThan(Integer value) {
			addCriterion("email_port >", value, "emailPort");
			return (Criteria) this;
		}

		public Criteria andEmailPortGreaterThanOrEqualTo(Integer value) {
			addCriterion("email_port >=", value, "emailPort");
			return (Criteria) this;
		}

		public Criteria andEmailPortLessThan(Integer value) {
			addCriterion("email_port <", value, "emailPort");
			return (Criteria) this;
		}

		public Criteria andEmailPortLessThanOrEqualTo(Integer value) {
			addCriterion("email_port <=", value, "emailPort");
			return (Criteria) this;
		}

		public Criteria andEmailPortIn(List<Integer> values) {
			addCriterion("email_port in", values, "emailPort");
			return (Criteria) this;
		}

		public Criteria andEmailPortNotIn(List<Integer> values) {
			addCriterion("email_port not in", values, "emailPort");
			return (Criteria) this;
		}

		public Criteria andEmailPortBetween(Integer value1, Integer value2) {
			addCriterion("email_port between", value1, value2, "emailPort");
			return (Criteria) this;
		}

		public Criteria andEmailPortNotBetween(Integer value1, Integer value2) {
			addCriterion("email_port not between", value1, value2, "emailPort");
			return (Criteria) this;
		}

		public Criteria andEmailPwsIsNull() {
			addCriterion("email_pws is null");
			return (Criteria) this;
		}

		public Criteria andEmailPwsIsNotNull() {
			addCriterion("email_pws is not null");
			return (Criteria) this;
		}

		public Criteria andEmailPwsEqualTo(String value) {
			addCriterion("email_pws =", value, "emailPws");
			return (Criteria) this;
		}

		public Criteria andEmailPwsNotEqualTo(String value) {
			addCriterion("email_pws <>", value, "emailPws");
			return (Criteria) this;
		}

		public Criteria andEmailPwsGreaterThan(String value) {
			addCriterion("email_pws >", value, "emailPws");
			return (Criteria) this;
		}

		public Criteria andEmailPwsGreaterThanOrEqualTo(String value) {
			addCriterion("email_pws >=", value, "emailPws");
			return (Criteria) this;
		}

		public Criteria andEmailPwsLessThan(String value) {
			addCriterion("email_pws <", value, "emailPws");
			return (Criteria) this;
		}

		public Criteria andEmailPwsLessThanOrEqualTo(String value) {
			addCriterion("email_pws <=", value, "emailPws");
			return (Criteria) this;
		}

		public Criteria andEmailPwsLike(String value) {
			addCriterion("email_pws like", value, "emailPws");
			return (Criteria) this;
		}

		public Criteria andEmailPwsNotLike(String value) {
			addCriterion("email_pws not like", value, "emailPws");
			return (Criteria) this;
		}

		public Criteria andEmailPwsIn(List<String> values) {
			addCriterion("email_pws in", values, "emailPws");
			return (Criteria) this;
		}

		public Criteria andEmailPwsNotIn(List<String> values) {
			addCriterion("email_pws not in", values, "emailPws");
			return (Criteria) this;
		}

		public Criteria andEmailPwsBetween(String value1, String value2) {
			addCriterion("email_pws between", value1, value2, "emailPws");
			return (Criteria) this;
		}

		public Criteria andEmailPwsNotBetween(String value1, String value2) {
			addCriterion("email_pws not between", value1, value2, "emailPws");
			return (Criteria) this;
		}

		public Criteria andEmailTestIsNull() {
			addCriterion("email_test is null");
			return (Criteria) this;
		}

		public Criteria andEmailTestIsNotNull() {
			addCriterion("email_test is not null");
			return (Criteria) this;
		}

		public Criteria andEmailTestEqualTo(String value) {
			addCriterion("email_test =", value, "emailTest");
			return (Criteria) this;
		}

		public Criteria andEmailTestNotEqualTo(String value) {
			addCriterion("email_test <>", value, "emailTest");
			return (Criteria) this;
		}

		public Criteria andEmailTestGreaterThan(String value) {
			addCriterion("email_test >", value, "emailTest");
			return (Criteria) this;
		}

		public Criteria andEmailTestGreaterThanOrEqualTo(String value) {
			addCriterion("email_test >=", value, "emailTest");
			return (Criteria) this;
		}

		public Criteria andEmailTestLessThan(String value) {
			addCriterion("email_test <", value, "emailTest");
			return (Criteria) this;
		}

		public Criteria andEmailTestLessThanOrEqualTo(String value) {
			addCriterion("email_test <=", value, "emailTest");
			return (Criteria) this;
		}

		public Criteria andEmailTestLike(String value) {
			addCriterion("email_test like", value, "emailTest");
			return (Criteria) this;
		}

		public Criteria andEmailTestNotLike(String value) {
			addCriterion("email_test not like", value, "emailTest");
			return (Criteria) this;
		}

		public Criteria andEmailTestIn(List<String> values) {
			addCriterion("email_test in", values, "emailTest");
			return (Criteria) this;
		}

		public Criteria andEmailTestNotIn(List<String> values) {
			addCriterion("email_test not in", values, "emailTest");
			return (Criteria) this;
		}

		public Criteria andEmailTestBetween(String value1, String value2) {
			addCriterion("email_test between", value1, value2, "emailTest");
			return (Criteria) this;
		}

		public Criteria andEmailTestNotBetween(String value1, String value2) {
			addCriterion("email_test not between", value1, value2, "emailTest");
			return (Criteria) this;
		}

		public Criteria andEmailUserIsNull() {
			addCriterion("email_user is null");
			return (Criteria) this;
		}

		public Criteria andEmailUserIsNotNull() {
			addCriterion("email_user is not null");
			return (Criteria) this;
		}

		public Criteria andEmailUserEqualTo(String value) {
			addCriterion("email_user =", value, "emailUser");
			return (Criteria) this;
		}

		public Criteria andEmailUserNotEqualTo(String value) {
			addCriterion("email_user <>", value, "emailUser");
			return (Criteria) this;
		}

		public Criteria andEmailUserGreaterThan(String value) {
			addCriterion("email_user >", value, "emailUser");
			return (Criteria) this;
		}

		public Criteria andEmailUserGreaterThanOrEqualTo(String value) {
			addCriterion("email_user >=", value, "emailUser");
			return (Criteria) this;
		}

		public Criteria andEmailUserLessThan(String value) {
			addCriterion("email_user <", value, "emailUser");
			return (Criteria) this;
		}

		public Criteria andEmailUserLessThanOrEqualTo(String value) {
			addCriterion("email_user <=", value, "emailUser");
			return (Criteria) this;
		}

		public Criteria andEmailUserLike(String value) {
			addCriterion("email_user like", value, "emailUser");
			return (Criteria) this;
		}

		public Criteria andEmailUserNotLike(String value) {
			addCriterion("email_user not like", value, "emailUser");
			return (Criteria) this;
		}

		public Criteria andEmailUserIn(List<String> values) {
			addCriterion("email_user in", values, "emailUser");
			return (Criteria) this;
		}

		public Criteria andEmailUserNotIn(List<String> values) {
			addCriterion("email_user not in", values, "emailUser");
			return (Criteria) this;
		}

		public Criteria andEmailUserBetween(String value1, String value2) {
			addCriterion("email_user between", value1, value2, "emailUser");
			return (Criteria) this;
		}

		public Criteria andEmailUserNotBetween(String value1, String value2) {
			addCriterion("email_user not between", value1, value2, "emailUser");
			return (Criteria) this;
		}

		public Criteria andEmailUserNameIsNull() {
			addCriterion("email_user_name is null");
			return (Criteria) this;
		}

		public Criteria andEmailUserNameIsNotNull() {
			addCriterion("email_user_name is not null");
			return (Criteria) this;
		}

		public Criteria andEmailUserNameEqualTo(String value) {
			addCriterion("email_user_name =", value, "emailUserName");
			return (Criteria) this;
		}

		public Criteria andEmailUserNameNotEqualTo(String value) {
			addCriterion("email_user_name <>", value, "emailUserName");
			return (Criteria) this;
		}

		public Criteria andEmailUserNameGreaterThan(String value) {
			addCriterion("email_user_name >", value, "emailUserName");
			return (Criteria) this;
		}

		public Criteria andEmailUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("email_user_name >=", value, "emailUserName");
			return (Criteria) this;
		}

		public Criteria andEmailUserNameLessThan(String value) {
			addCriterion("email_user_name <", value, "emailUserName");
			return (Criteria) this;
		}

		public Criteria andEmailUserNameLessThanOrEqualTo(String value) {
			addCriterion("email_user_name <=", value, "emailUserName");
			return (Criteria) this;
		}

		public Criteria andEmailUserNameLike(String value) {
			addCriterion("email_user_name like", value, "emailUserName");
			return (Criteria) this;
		}

		public Criteria andEmailUserNameNotLike(String value) {
			addCriterion("email_user_name not like", value, "emailUserName");
			return (Criteria) this;
		}

		public Criteria andEmailUserNameIn(List<String> values) {
			addCriterion("email_user_name in", values, "emailUserName");
			return (Criteria) this;
		}

		public Criteria andEmailUserNameNotIn(List<String> values) {
			addCriterion("email_user_name not in", values, "emailUserName");
			return (Criteria) this;
		}

		public Criteria andEmailUserNameBetween(String value1, String value2) {
			addCriterion("email_user_name between", value1, value2, "emailUserName");
			return (Criteria) this;
		}

		public Criteria andEmailUserNameNotBetween(String value1, String value2) {
			addCriterion("email_user_name not between", value1, value2, "emailUserName");
			return (Criteria) this;
		}

		public Criteria andEmailBuyIsNull() {
			addCriterion("email_buy is null");
			return (Criteria) this;
		}

		public Criteria andEmailBuyIsNotNull() {
			addCriterion("email_buy is not null");
			return (Criteria) this;
		}

		public Criteria andEmailBuyEqualTo(Integer value) {
			addCriterion("email_buy =", value, "emailBuy");
			return (Criteria) this;
		}

		public Criteria andEmailBuyNotEqualTo(Integer value) {
			addCriterion("email_buy <>", value, "emailBuy");
			return (Criteria) this;
		}

		public Criteria andEmailBuyGreaterThan(Integer value) {
			addCriterion("email_buy >", value, "emailBuy");
			return (Criteria) this;
		}

		public Criteria andEmailBuyGreaterThanOrEqualTo(Integer value) {
			addCriterion("email_buy >=", value, "emailBuy");
			return (Criteria) this;
		}

		public Criteria andEmailBuyLessThan(Integer value) {
			addCriterion("email_buy <", value, "emailBuy");
			return (Criteria) this;
		}

		public Criteria andEmailBuyLessThanOrEqualTo(Integer value) {
			addCriterion("email_buy <=", value, "emailBuy");
			return (Criteria) this;
		}

		public Criteria andEmailBuyIn(List<Integer> values) {
			addCriterion("email_buy in", values, "emailBuy");
			return (Criteria) this;
		}

		public Criteria andEmailBuyNotIn(List<Integer> values) {
			addCriterion("email_buy not in", values, "emailBuy");
			return (Criteria) this;
		}

		public Criteria andEmailBuyBetween(Integer value1, Integer value2) {
			addCriterion("email_buy between", value1, value2, "emailBuy");
			return (Criteria) this;
		}

		public Criteria andEmailBuyNotBetween(Integer value1, Integer value2) {
			addCriterion("email_buy not between", value1, value2, "emailBuy");
			return (Criteria) this;
		}

		public Criteria andEmailBuyCostIsNull() {
			addCriterion("email_buy_cost is null");
			return (Criteria) this;
		}

		public Criteria andEmailBuyCostIsNotNull() {
			addCriterion("email_buy_cost is not null");
			return (Criteria) this;
		}

		public Criteria andEmailBuyCostEqualTo(Integer value) {
			addCriterion("email_buy_cost =", value, "emailBuyCost");
			return (Criteria) this;
		}

		public Criteria andEmailBuyCostNotEqualTo(Integer value) {
			addCriterion("email_buy_cost <>", value, "emailBuyCost");
			return (Criteria) this;
		}

		public Criteria andEmailBuyCostGreaterThan(Integer value) {
			addCriterion("email_buy_cost >", value, "emailBuyCost");
			return (Criteria) this;
		}

		public Criteria andEmailBuyCostGreaterThanOrEqualTo(Integer value) {
			addCriterion("email_buy_cost >=", value, "emailBuyCost");
			return (Criteria) this;
		}

		public Criteria andEmailBuyCostLessThan(Integer value) {
			addCriterion("email_buy_cost <", value, "emailBuyCost");
			return (Criteria) this;
		}

		public Criteria andEmailBuyCostLessThanOrEqualTo(Integer value) {
			addCriterion("email_buy_cost <=", value, "emailBuyCost");
			return (Criteria) this;
		}

		public Criteria andEmailBuyCostIn(List<Integer> values) {
			addCriterion("email_buy_cost in", values, "emailBuyCost");
			return (Criteria) this;
		}

		public Criteria andEmailBuyCostNotIn(List<Integer> values) {
			addCriterion("email_buy_cost not in", values, "emailBuyCost");
			return (Criteria) this;
		}

		public Criteria andEmailBuyCostBetween(Integer value1, Integer value2) {
			addCriterion("email_buy_cost between", value1, value2, "emailBuyCost");
			return (Criteria) this;
		}

		public Criteria andEmailBuyCostNotBetween(Integer value1, Integer value2) {
			addCriterion("email_buy_cost not between", value1, value2, "emailBuyCost");
			return (Criteria) this;
		}

		public Criteria andEmailQueueIsNull() {
			addCriterion("email_queue is null");
			return (Criteria) this;
		}

		public Criteria andEmailQueueIsNotNull() {
			addCriterion("email_queue is not null");
			return (Criteria) this;
		}

		public Criteria andEmailQueueEqualTo(Integer value) {
			addCriterion("email_queue =", value, "emailQueue");
			return (Criteria) this;
		}

		public Criteria andEmailQueueNotEqualTo(Integer value) {
			addCriterion("email_queue <>", value, "emailQueue");
			return (Criteria) this;
		}

		public Criteria andEmailQueueGreaterThan(Integer value) {
			addCriterion("email_queue >", value, "emailQueue");
			return (Criteria) this;
		}

		public Criteria andEmailQueueGreaterThanOrEqualTo(Integer value) {
			addCriterion("email_queue >=", value, "emailQueue");
			return (Criteria) this;
		}

		public Criteria andEmailQueueLessThan(Integer value) {
			addCriterion("email_queue <", value, "emailQueue");
			return (Criteria) this;
		}

		public Criteria andEmailQueueLessThanOrEqualTo(Integer value) {
			addCriterion("email_queue <=", value, "emailQueue");
			return (Criteria) this;
		}

		public Criteria andEmailQueueIn(List<Integer> values) {
			addCriterion("email_queue in", values, "emailQueue");
			return (Criteria) this;
		}

		public Criteria andEmailQueueNotIn(List<Integer> values) {
			addCriterion("email_queue not in", values, "emailQueue");
			return (Criteria) this;
		}

		public Criteria andEmailQueueBetween(Integer value1, Integer value2) {
			addCriterion("email_queue between", value1, value2, "emailQueue");
			return (Criteria) this;
		}

		public Criteria andEmailQueueNotBetween(Integer value1, Integer value2) {
			addCriterion("email_queue not between", value1, value2, "emailQueue");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMaxCountIsNull() {
			addCriterion("enoughreduce_max_count is null");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMaxCountIsNotNull() {
			addCriterion("enoughreduce_max_count is not null");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMaxCountEqualTo(Integer value) {
			addCriterion("enoughreduce_max_count =", value, "enoughreduceMaxCount");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMaxCountNotEqualTo(Integer value) {
			addCriterion("enoughreduce_max_count <>", value, "enoughreduceMaxCount");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMaxCountGreaterThan(Integer value) {
			addCriterion("enoughreduce_max_count >", value, "enoughreduceMaxCount");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMaxCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("enoughreduce_max_count >=", value, "enoughreduceMaxCount");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMaxCountLessThan(Integer value) {
			addCriterion("enoughreduce_max_count <", value, "enoughreduceMaxCount");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMaxCountLessThanOrEqualTo(Integer value) {
			addCriterion("enoughreduce_max_count <=", value, "enoughreduceMaxCount");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMaxCountIn(List<Integer> values) {
			addCriterion("enoughreduce_max_count in", values, "enoughreduceMaxCount");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMaxCountNotIn(List<Integer> values) {
			addCriterion("enoughreduce_max_count not in", values, "enoughreduceMaxCount");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMaxCountBetween(Integer value1, Integer value2) {
			addCriterion("enoughreduce_max_count between", value1, value2, "enoughreduceMaxCount");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMaxCountNotBetween(Integer value1, Integer value2) {
			addCriterion("enoughreduce_max_count not between", value1, value2, "enoughreduceMaxCount");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMealGoldIsNull() {
			addCriterion("enoughreduce_meal_gold is null");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMealGoldIsNotNull() {
			addCriterion("enoughreduce_meal_gold is not null");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMealGoldEqualTo(Integer value) {
			addCriterion("enoughreduce_meal_gold =", value, "enoughreduceMealGold");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMealGoldNotEqualTo(Integer value) {
			addCriterion("enoughreduce_meal_gold <>", value, "enoughreduceMealGold");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMealGoldGreaterThan(Integer value) {
			addCriterion("enoughreduce_meal_gold >", value, "enoughreduceMealGold");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMealGoldGreaterThanOrEqualTo(Integer value) {
			addCriterion("enoughreduce_meal_gold >=", value, "enoughreduceMealGold");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMealGoldLessThan(Integer value) {
			addCriterion("enoughreduce_meal_gold <", value, "enoughreduceMealGold");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMealGoldLessThanOrEqualTo(Integer value) {
			addCriterion("enoughreduce_meal_gold <=", value, "enoughreduceMealGold");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMealGoldIn(List<Integer> values) {
			addCriterion("enoughreduce_meal_gold in", values, "enoughreduceMealGold");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMealGoldNotIn(List<Integer> values) {
			addCriterion("enoughreduce_meal_gold not in", values, "enoughreduceMealGold");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMealGoldBetween(Integer value1, Integer value2) {
			addCriterion("enoughreduce_meal_gold between", value1, value2, "enoughreduceMealGold");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMealGoldNotBetween(Integer value1, Integer value2) {
			addCriterion("enoughreduce_meal_gold not between", value1, value2, "enoughreduceMealGold");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceStatusIsNull() {
			addCriterion("enoughreduce_status is null");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceStatusIsNotNull() {
			addCriterion("enoughreduce_status is not null");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceStatusEqualTo(Integer value) {
			addCriterion("enoughreduce_status =", value, "enoughreduceStatus");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceStatusNotEqualTo(Integer value) {
			addCriterion("enoughreduce_status <>", value, "enoughreduceStatus");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceStatusGreaterThan(Integer value) {
			addCriterion("enoughreduce_status >", value, "enoughreduceStatus");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("enoughreduce_status >=", value, "enoughreduceStatus");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceStatusLessThan(Integer value) {
			addCriterion("enoughreduce_status <", value, "enoughreduceStatus");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceStatusLessThanOrEqualTo(Integer value) {
			addCriterion("enoughreduce_status <=", value, "enoughreduceStatus");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceStatusIn(List<Integer> values) {
			addCriterion("enoughreduce_status in", values, "enoughreduceStatus");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceStatusNotIn(List<Integer> values) {
			addCriterion("enoughreduce_status not in", values, "enoughreduceStatus");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceStatusBetween(Integer value1, Integer value2) {
			addCriterion("enoughreduce_status between", value1, value2, "enoughreduceStatus");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("enoughreduce_status not between", value1, value2, "enoughreduceStatus");
			return (Criteria) this;
		}

		public Criteria andEvaluateAddDeadlineIsNull() {
			addCriterion("evaluate_add_deadline is null");
			return (Criteria) this;
		}

		public Criteria andEvaluateAddDeadlineIsNotNull() {
			addCriterion("evaluate_add_deadline is not null");
			return (Criteria) this;
		}

		public Criteria andEvaluateAddDeadlineEqualTo(Integer value) {
			addCriterion("evaluate_add_deadline =", value, "evaluateAddDeadline");
			return (Criteria) this;
		}

		public Criteria andEvaluateAddDeadlineNotEqualTo(Integer value) {
			addCriterion("evaluate_add_deadline <>", value, "evaluateAddDeadline");
			return (Criteria) this;
		}

		public Criteria andEvaluateAddDeadlineGreaterThan(Integer value) {
			addCriterion("evaluate_add_deadline >", value, "evaluateAddDeadline");
			return (Criteria) this;
		}

		public Criteria andEvaluateAddDeadlineGreaterThanOrEqualTo(Integer value) {
			addCriterion("evaluate_add_deadline >=", value, "evaluateAddDeadline");
			return (Criteria) this;
		}

		public Criteria andEvaluateAddDeadlineLessThan(Integer value) {
			addCriterion("evaluate_add_deadline <", value, "evaluateAddDeadline");
			return (Criteria) this;
		}

		public Criteria andEvaluateAddDeadlineLessThanOrEqualTo(Integer value) {
			addCriterion("evaluate_add_deadline <=", value, "evaluateAddDeadline");
			return (Criteria) this;
		}

		public Criteria andEvaluateAddDeadlineIn(List<Integer> values) {
			addCriterion("evaluate_add_deadline in", values, "evaluateAddDeadline");
			return (Criteria) this;
		}

		public Criteria andEvaluateAddDeadlineNotIn(List<Integer> values) {
			addCriterion("evaluate_add_deadline not in", values, "evaluateAddDeadline");
			return (Criteria) this;
		}

		public Criteria andEvaluateAddDeadlineBetween(Integer value1, Integer value2) {
			addCriterion("evaluate_add_deadline between", value1, value2, "evaluateAddDeadline");
			return (Criteria) this;
		}

		public Criteria andEvaluateAddDeadlineNotBetween(Integer value1, Integer value2) {
			addCriterion("evaluate_add_deadline not between", value1, value2, "evaluateAddDeadline");
			return (Criteria) this;
		}

		public Criteria andEvaluateEditDeadlineIsNull() {
			addCriterion("evaluate_edit_deadline is null");
			return (Criteria) this;
		}

		public Criteria andEvaluateEditDeadlineIsNotNull() {
			addCriterion("evaluate_edit_deadline is not null");
			return (Criteria) this;
		}

		public Criteria andEvaluateEditDeadlineEqualTo(Integer value) {
			addCriterion("evaluate_edit_deadline =", value, "evaluateEditDeadline");
			return (Criteria) this;
		}

		public Criteria andEvaluateEditDeadlineNotEqualTo(Integer value) {
			addCriterion("evaluate_edit_deadline <>", value, "evaluateEditDeadline");
			return (Criteria) this;
		}

		public Criteria andEvaluateEditDeadlineGreaterThan(Integer value) {
			addCriterion("evaluate_edit_deadline >", value, "evaluateEditDeadline");
			return (Criteria) this;
		}

		public Criteria andEvaluateEditDeadlineGreaterThanOrEqualTo(Integer value) {
			addCriterion("evaluate_edit_deadline >=", value, "evaluateEditDeadline");
			return (Criteria) this;
		}

		public Criteria andEvaluateEditDeadlineLessThan(Integer value) {
			addCriterion("evaluate_edit_deadline <", value, "evaluateEditDeadline");
			return (Criteria) this;
		}

		public Criteria andEvaluateEditDeadlineLessThanOrEqualTo(Integer value) {
			addCriterion("evaluate_edit_deadline <=", value, "evaluateEditDeadline");
			return (Criteria) this;
		}

		public Criteria andEvaluateEditDeadlineIn(List<Integer> values) {
			addCriterion("evaluate_edit_deadline in", values, "evaluateEditDeadline");
			return (Criteria) this;
		}

		public Criteria andEvaluateEditDeadlineNotIn(List<Integer> values) {
			addCriterion("evaluate_edit_deadline not in", values, "evaluateEditDeadline");
			return (Criteria) this;
		}

		public Criteria andEvaluateEditDeadlineBetween(Integer value1, Integer value2) {
			addCriterion("evaluate_edit_deadline between", value1, value2, "evaluateEditDeadline");
			return (Criteria) this;
		}

		public Criteria andEvaluateEditDeadlineNotBetween(Integer value1, Integer value2) {
			addCriterion("evaluate_edit_deadline not between", value1, value2, "evaluateEditDeadline");
			return (Criteria) this;
		}

		public Criteria andEveryindentLimitIsNull() {
			addCriterion("everyIndent_limit is null");
			return (Criteria) this;
		}

		public Criteria andEveryindentLimitIsNotNull() {
			addCriterion("everyIndent_limit is not null");
			return (Criteria) this;
		}

		public Criteria andEveryindentLimitEqualTo(Integer value) {
			addCriterion("everyIndent_limit =", value, "everyindentLimit");
			return (Criteria) this;
		}

		public Criteria andEveryindentLimitNotEqualTo(Integer value) {
			addCriterion("everyIndent_limit <>", value, "everyindentLimit");
			return (Criteria) this;
		}

		public Criteria andEveryindentLimitGreaterThan(Integer value) {
			addCriterion("everyIndent_limit >", value, "everyindentLimit");
			return (Criteria) this;
		}

		public Criteria andEveryindentLimitGreaterThanOrEqualTo(Integer value) {
			addCriterion("everyIndent_limit >=", value, "everyindentLimit");
			return (Criteria) this;
		}

		public Criteria andEveryindentLimitLessThan(Integer value) {
			addCriterion("everyIndent_limit <", value, "everyindentLimit");
			return (Criteria) this;
		}

		public Criteria andEveryindentLimitLessThanOrEqualTo(Integer value) {
			addCriterion("everyIndent_limit <=", value, "everyindentLimit");
			return (Criteria) this;
		}

		public Criteria andEveryindentLimitIn(List<Integer> values) {
			addCriterion("everyIndent_limit in", values, "everyindentLimit");
			return (Criteria) this;
		}

		public Criteria andEveryindentLimitNotIn(List<Integer> values) {
			addCriterion("everyIndent_limit not in", values, "everyindentLimit");
			return (Criteria) this;
		}

		public Criteria andEveryindentLimitBetween(Integer value1, Integer value2) {
			addCriterion("everyIndent_limit between", value1, value2, "everyindentLimit");
			return (Criteria) this;
		}

		public Criteria andEveryindentLimitNotBetween(Integer value1, Integer value2) {
			addCriterion("everyIndent_limit not between", value1, value2, "everyindentLimit");
			return (Criteria) this;
		}

		public Criteria andGoldIsNull() {
			addCriterion("gold is null");
			return (Criteria) this;
		}

		public Criteria andGoldIsNotNull() {
			addCriterion("gold is not null");
			return (Criteria) this;
		}

		public Criteria andGoldEqualTo(Boolean value) {
			addCriterion("gold =", value, "gold");
			return (Criteria) this;
		}

		public Criteria andGoldNotEqualTo(Boolean value) {
			addCriterion("gold <>", value, "gold");
			return (Criteria) this;
		}

		public Criteria andGoldGreaterThan(Boolean value) {
			addCriterion("gold >", value, "gold");
			return (Criteria) this;
		}

		public Criteria andGoldGreaterThanOrEqualTo(Boolean value) {
			addCriterion("gold >=", value, "gold");
			return (Criteria) this;
		}

		public Criteria andGoldLessThan(Boolean value) {
			addCriterion("gold <", value, "gold");
			return (Criteria) this;
		}

		public Criteria andGoldLessThanOrEqualTo(Boolean value) {
			addCriterion("gold <=", value, "gold");
			return (Criteria) this;
		}

		public Criteria andGoldIn(List<Boolean> values) {
			addCriterion("gold in", values, "gold");
			return (Criteria) this;
		}

		public Criteria andGoldNotIn(List<Boolean> values) {
			addCriterion("gold not in", values, "gold");
			return (Criteria) this;
		}

		public Criteria andGoldBetween(Boolean value1, Boolean value2) {
			addCriterion("gold between", value1, value2, "gold");
			return (Criteria) this;
		}

		public Criteria andGoldNotBetween(Boolean value1, Boolean value2) {
			addCriterion("gold not between", value1, value2, "gold");
			return (Criteria) this;
		}

		public Criteria andGoldMarketValueIsNull() {
			addCriterion("gold_market_value is null");
			return (Criteria) this;
		}

		public Criteria andGoldMarketValueIsNotNull() {
			addCriterion("gold_market_value is not null");
			return (Criteria) this;
		}

		public Criteria andGoldMarketValueEqualTo(Integer value) {
			addCriterion("gold_market_value =", value, "goldMarketValue");
			return (Criteria) this;
		}

		public Criteria andGoldMarketValueNotEqualTo(Integer value) {
			addCriterion("gold_market_value <>", value, "goldMarketValue");
			return (Criteria) this;
		}

		public Criteria andGoldMarketValueGreaterThan(Integer value) {
			addCriterion("gold_market_value >", value, "goldMarketValue");
			return (Criteria) this;
		}

		public Criteria andGoldMarketValueGreaterThanOrEqualTo(Integer value) {
			addCriterion("gold_market_value >=", value, "goldMarketValue");
			return (Criteria) this;
		}

		public Criteria andGoldMarketValueLessThan(Integer value) {
			addCriterion("gold_market_value <", value, "goldMarketValue");
			return (Criteria) this;
		}

		public Criteria andGoldMarketValueLessThanOrEqualTo(Integer value) {
			addCriterion("gold_market_value <=", value, "goldMarketValue");
			return (Criteria) this;
		}

		public Criteria andGoldMarketValueIn(List<Integer> values) {
			addCriterion("gold_market_value in", values, "goldMarketValue");
			return (Criteria) this;
		}

		public Criteria andGoldMarketValueNotIn(List<Integer> values) {
			addCriterion("gold_market_value not in", values, "goldMarketValue");
			return (Criteria) this;
		}

		public Criteria andGoldMarketValueBetween(Integer value1, Integer value2) {
			addCriterion("gold_market_value between", value1, value2, "goldMarketValue");
			return (Criteria) this;
		}

		public Criteria andGoldMarketValueNotBetween(Integer value1, Integer value2) {
			addCriterion("gold_market_value not between", value1, value2, "goldMarketValue");
			return (Criteria) this;
		}

		public Criteria andGroupBuyIsNull() {
			addCriterion("group_buy is null");
			return (Criteria) this;
		}

		public Criteria andGroupBuyIsNotNull() {
			addCriterion("group_buy is not null");
			return (Criteria) this;
		}

		public Criteria andGroupBuyEqualTo(Boolean value) {
			addCriterion("group_buy =", value, "groupBuy");
			return (Criteria) this;
		}

		public Criteria andGroupBuyNotEqualTo(Boolean value) {
			addCriterion("group_buy <>", value, "groupBuy");
			return (Criteria) this;
		}

		public Criteria andGroupBuyGreaterThan(Boolean value) {
			addCriterion("group_buy >", value, "groupBuy");
			return (Criteria) this;
		}

		public Criteria andGroupBuyGreaterThanOrEqualTo(Boolean value) {
			addCriterion("group_buy >=", value, "groupBuy");
			return (Criteria) this;
		}

		public Criteria andGroupBuyLessThan(Boolean value) {
			addCriterion("group_buy <", value, "groupBuy");
			return (Criteria) this;
		}

		public Criteria andGroupBuyLessThanOrEqualTo(Boolean value) {
			addCriterion("group_buy <=", value, "groupBuy");
			return (Criteria) this;
		}

		public Criteria andGroupBuyIn(List<Boolean> values) {
			addCriterion("group_buy in", values, "groupBuy");
			return (Criteria) this;
		}

		public Criteria andGroupBuyNotIn(List<Boolean> values) {
			addCriterion("group_buy not in", values, "groupBuy");
			return (Criteria) this;
		}

		public Criteria andGroupBuyBetween(Boolean value1, Boolean value2) {
			addCriterion("group_buy between", value1, value2, "groupBuy");
			return (Criteria) this;
		}

		public Criteria andGroupBuyNotBetween(Boolean value1, Boolean value2) {
			addCriterion("group_buy not between", value1, value2, "groupBuy");
			return (Criteria) this;
		}

		public Criteria andGroupMealGoldIsNull() {
			addCriterion("group_meal_gold is null");
			return (Criteria) this;
		}

		public Criteria andGroupMealGoldIsNotNull() {
			addCriterion("group_meal_gold is not null");
			return (Criteria) this;
		}

		public Criteria andGroupMealGoldEqualTo(Integer value) {
			addCriterion("group_meal_gold =", value, "groupMealGold");
			return (Criteria) this;
		}

		public Criteria andGroupMealGoldNotEqualTo(Integer value) {
			addCriterion("group_meal_gold <>", value, "groupMealGold");
			return (Criteria) this;
		}

		public Criteria andGroupMealGoldGreaterThan(Integer value) {
			addCriterion("group_meal_gold >", value, "groupMealGold");
			return (Criteria) this;
		}

		public Criteria andGroupMealGoldGreaterThanOrEqualTo(Integer value) {
			addCriterion("group_meal_gold >=", value, "groupMealGold");
			return (Criteria) this;
		}

		public Criteria andGroupMealGoldLessThan(Integer value) {
			addCriterion("group_meal_gold <", value, "groupMealGold");
			return (Criteria) this;
		}

		public Criteria andGroupMealGoldLessThanOrEqualTo(Integer value) {
			addCriterion("group_meal_gold <=", value, "groupMealGold");
			return (Criteria) this;
		}

		public Criteria andGroupMealGoldIn(List<Integer> values) {
			addCriterion("group_meal_gold in", values, "groupMealGold");
			return (Criteria) this;
		}

		public Criteria andGroupMealGoldNotIn(List<Integer> values) {
			addCriterion("group_meal_gold not in", values, "groupMealGold");
			return (Criteria) this;
		}

		public Criteria andGroupMealGoldBetween(Integer value1, Integer value2) {
			addCriterion("group_meal_gold between", value1, value2, "groupMealGold");
			return (Criteria) this;
		}

		public Criteria andGroupMealGoldNotBetween(Integer value1, Integer value2) {
			addCriterion("group_meal_gold not between", value1, value2, "groupMealGold");
			return (Criteria) this;
		}

		public Criteria andGrouplifeOrderReturnIsNull() {
			addCriterion("grouplife_order_return is null");
			return (Criteria) this;
		}

		public Criteria andGrouplifeOrderReturnIsNotNull() {
			addCriterion("grouplife_order_return is not null");
			return (Criteria) this;
		}

		public Criteria andGrouplifeOrderReturnEqualTo(Integer value) {
			addCriterion("grouplife_order_return =", value, "grouplifeOrderReturn");
			return (Criteria) this;
		}

		public Criteria andGrouplifeOrderReturnNotEqualTo(Integer value) {
			addCriterion("grouplife_order_return <>", value, "grouplifeOrderReturn");
			return (Criteria) this;
		}

		public Criteria andGrouplifeOrderReturnGreaterThan(Integer value) {
			addCriterion("grouplife_order_return >", value, "grouplifeOrderReturn");
			return (Criteria) this;
		}

		public Criteria andGrouplifeOrderReturnGreaterThanOrEqualTo(Integer value) {
			addCriterion("grouplife_order_return >=", value, "grouplifeOrderReturn");
			return (Criteria) this;
		}

		public Criteria andGrouplifeOrderReturnLessThan(Integer value) {
			addCriterion("grouplife_order_return <", value, "grouplifeOrderReturn");
			return (Criteria) this;
		}

		public Criteria andGrouplifeOrderReturnLessThanOrEqualTo(Integer value) {
			addCriterion("grouplife_order_return <=", value, "grouplifeOrderReturn");
			return (Criteria) this;
		}

		public Criteria andGrouplifeOrderReturnIn(List<Integer> values) {
			addCriterion("grouplife_order_return in", values, "grouplifeOrderReturn");
			return (Criteria) this;
		}

		public Criteria andGrouplifeOrderReturnNotIn(List<Integer> values) {
			addCriterion("grouplife_order_return not in", values, "grouplifeOrderReturn");
			return (Criteria) this;
		}

		public Criteria andGrouplifeOrderReturnBetween(Integer value1, Integer value2) {
			addCriterion("grouplife_order_return between", value1, value2, "grouplifeOrderReturn");
			return (Criteria) this;
		}

		public Criteria andGrouplifeOrderReturnNotBetween(Integer value1, Integer value2) {
			addCriterion("grouplife_order_return not between", value1, value2, "grouplifeOrderReturn");
			return (Criteria) this;
		}

		public Criteria andHotSearchIsNull() {
			addCriterion("hot_search is null");
			return (Criteria) this;
		}

		public Criteria andHotSearchIsNotNull() {
			addCriterion("hot_search is not null");
			return (Criteria) this;
		}

		public Criteria andHotSearchEqualTo(String value) {
			addCriterion("hot_search =", value, "hotSearch");
			return (Criteria) this;
		}

		public Criteria andHotSearchNotEqualTo(String value) {
			addCriterion("hot_search <>", value, "hotSearch");
			return (Criteria) this;
		}

		public Criteria andHotSearchGreaterThan(String value) {
			addCriterion("hot_search >", value, "hotSearch");
			return (Criteria) this;
		}

		public Criteria andHotSearchGreaterThanOrEqualTo(String value) {
			addCriterion("hot_search >=", value, "hotSearch");
			return (Criteria) this;
		}

		public Criteria andHotSearchLessThan(String value) {
			addCriterion("hot_search <", value, "hotSearch");
			return (Criteria) this;
		}

		public Criteria andHotSearchLessThanOrEqualTo(String value) {
			addCriterion("hot_search <=", value, "hotSearch");
			return (Criteria) this;
		}

		public Criteria andHotSearchLike(String value) {
			addCriterion("hot_search like", value, "hotSearch");
			return (Criteria) this;
		}

		public Criteria andHotSearchNotLike(String value) {
			addCriterion("hot_search not like", value, "hotSearch");
			return (Criteria) this;
		}

		public Criteria andHotSearchIn(List<String> values) {
			addCriterion("hot_search in", values, "hotSearch");
			return (Criteria) this;
		}

		public Criteria andHotSearchNotIn(List<String> values) {
			addCriterion("hot_search not in", values, "hotSearch");
			return (Criteria) this;
		}

		public Criteria andHotSearchBetween(String value1, String value2) {
			addCriterion("hot_search between", value1, value2, "hotSearch");
			return (Criteria) this;
		}

		public Criteria andHotSearchNotBetween(String value1, String value2) {
			addCriterion("hot_search not between", value1, value2, "hotSearch");
			return (Criteria) this;
		}

		public Criteria andImageFilesizeIsNull() {
			addCriterion("image_filesize is null");
			return (Criteria) this;
		}

		public Criteria andImageFilesizeIsNotNull() {
			addCriterion("image_filesize is not null");
			return (Criteria) this;
		}

		public Criteria andImageFilesizeEqualTo(Integer value) {
			addCriterion("image_filesize =", value, "imageFilesize");
			return (Criteria) this;
		}

		public Criteria andImageFilesizeNotEqualTo(Integer value) {
			addCriterion("image_filesize <>", value, "imageFilesize");
			return (Criteria) this;
		}

		public Criteria andImageFilesizeGreaterThan(Integer value) {
			addCriterion("image_filesize >", value, "imageFilesize");
			return (Criteria) this;
		}

		public Criteria andImageFilesizeGreaterThanOrEqualTo(Integer value) {
			addCriterion("image_filesize >=", value, "imageFilesize");
			return (Criteria) this;
		}

		public Criteria andImageFilesizeLessThan(Integer value) {
			addCriterion("image_filesize <", value, "imageFilesize");
			return (Criteria) this;
		}

		public Criteria andImageFilesizeLessThanOrEqualTo(Integer value) {
			addCriterion("image_filesize <=", value, "imageFilesize");
			return (Criteria) this;
		}

		public Criteria andImageFilesizeIn(List<Integer> values) {
			addCriterion("image_filesize in", values, "imageFilesize");
			return (Criteria) this;
		}

		public Criteria andImageFilesizeNotIn(List<Integer> values) {
			addCriterion("image_filesize not in", values, "imageFilesize");
			return (Criteria) this;
		}

		public Criteria andImageFilesizeBetween(Integer value1, Integer value2) {
			addCriterion("image_filesize between", value1, value2, "imageFilesize");
			return (Criteria) this;
		}

		public Criteria andImageFilesizeNotBetween(Integer value1, Integer value2) {
			addCriterion("image_filesize not between", value1, value2, "imageFilesize");
			return (Criteria) this;
		}

		public Criteria andImageSaveTypeIsNull() {
			addCriterion("image_save_type is null");
			return (Criteria) this;
		}

		public Criteria andImageSaveTypeIsNotNull() {
			addCriterion("image_save_type is not null");
			return (Criteria) this;
		}

		public Criteria andImageSaveTypeEqualTo(String value) {
			addCriterion("image_save_type =", value, "imageSaveType");
			return (Criteria) this;
		}

		public Criteria andImageSaveTypeNotEqualTo(String value) {
			addCriterion("image_save_type <>", value, "imageSaveType");
			return (Criteria) this;
		}

		public Criteria andImageSaveTypeGreaterThan(String value) {
			addCriterion("image_save_type >", value, "imageSaveType");
			return (Criteria) this;
		}

		public Criteria andImageSaveTypeGreaterThanOrEqualTo(String value) {
			addCriterion("image_save_type >=", value, "imageSaveType");
			return (Criteria) this;
		}

		public Criteria andImageSaveTypeLessThan(String value) {
			addCriterion("image_save_type <", value, "imageSaveType");
			return (Criteria) this;
		}

		public Criteria andImageSaveTypeLessThanOrEqualTo(String value) {
			addCriterion("image_save_type <=", value, "imageSaveType");
			return (Criteria) this;
		}

		public Criteria andImageSaveTypeLike(String value) {
			addCriterion("image_save_type like", value, "imageSaveType");
			return (Criteria) this;
		}

		public Criteria andImageSaveTypeNotLike(String value) {
			addCriterion("image_save_type not like", value, "imageSaveType");
			return (Criteria) this;
		}

		public Criteria andImageSaveTypeIn(List<String> values) {
			addCriterion("image_save_type in", values, "imageSaveType");
			return (Criteria) this;
		}

		public Criteria andImageSaveTypeNotIn(List<String> values) {
			addCriterion("image_save_type not in", values, "imageSaveType");
			return (Criteria) this;
		}

		public Criteria andImageSaveTypeBetween(String value1, String value2) {
			addCriterion("image_save_type between", value1, value2, "imageSaveType");
			return (Criteria) this;
		}

		public Criteria andImageSaveTypeNotBetween(String value1, String value2) {
			addCriterion("image_save_type not between", value1, value2, "imageSaveType");
			return (Criteria) this;
		}

		public Criteria andImageSuffixIsNull() {
			addCriterion("image_suffix is null");
			return (Criteria) this;
		}

		public Criteria andImageSuffixIsNotNull() {
			addCriterion("image_suffix is not null");
			return (Criteria) this;
		}

		public Criteria andImageSuffixEqualTo(String value) {
			addCriterion("image_suffix =", value, "imageSuffix");
			return (Criteria) this;
		}

		public Criteria andImageSuffixNotEqualTo(String value) {
			addCriterion("image_suffix <>", value, "imageSuffix");
			return (Criteria) this;
		}

		public Criteria andImageSuffixGreaterThan(String value) {
			addCriterion("image_suffix >", value, "imageSuffix");
			return (Criteria) this;
		}

		public Criteria andImageSuffixGreaterThanOrEqualTo(String value) {
			addCriterion("image_suffix >=", value, "imageSuffix");
			return (Criteria) this;
		}

		public Criteria andImageSuffixLessThan(String value) {
			addCriterion("image_suffix <", value, "imageSuffix");
			return (Criteria) this;
		}

		public Criteria andImageSuffixLessThanOrEqualTo(String value) {
			addCriterion("image_suffix <=", value, "imageSuffix");
			return (Criteria) this;
		}

		public Criteria andImageSuffixLike(String value) {
			addCriterion("image_suffix like", value, "imageSuffix");
			return (Criteria) this;
		}

		public Criteria andImageSuffixNotLike(String value) {
			addCriterion("image_suffix not like", value, "imageSuffix");
			return (Criteria) this;
		}

		public Criteria andImageSuffixIn(List<String> values) {
			addCriterion("image_suffix in", values, "imageSuffix");
			return (Criteria) this;
		}

		public Criteria andImageSuffixNotIn(List<String> values) {
			addCriterion("image_suffix not in", values, "imageSuffix");
			return (Criteria) this;
		}

		public Criteria andImageSuffixBetween(String value1, String value2) {
			addCriterion("image_suffix between", value1, value2, "imageSuffix");
			return (Criteria) this;
		}

		public Criteria andImageSuffixNotBetween(String value1, String value2) {
			addCriterion("image_suffix not between", value1, value2, "imageSuffix");
			return (Criteria) this;
		}

		public Criteria andImageWebServerIsNull() {
			addCriterion("image_web_server is null");
			return (Criteria) this;
		}

		public Criteria andImageWebServerIsNotNull() {
			addCriterion("image_web_server is not null");
			return (Criteria) this;
		}

		public Criteria andImageWebServerEqualTo(String value) {
			addCriterion("image_web_server =", value, "imageWebServer");
			return (Criteria) this;
		}

		public Criteria andImageWebServerNotEqualTo(String value) {
			addCriterion("image_web_server <>", value, "imageWebServer");
			return (Criteria) this;
		}

		public Criteria andImageWebServerGreaterThan(String value) {
			addCriterion("image_web_server >", value, "imageWebServer");
			return (Criteria) this;
		}

		public Criteria andImageWebServerGreaterThanOrEqualTo(String value) {
			addCriterion("image_web_server >=", value, "imageWebServer");
			return (Criteria) this;
		}

		public Criteria andImageWebServerLessThan(String value) {
			addCriterion("image_web_server <", value, "imageWebServer");
			return (Criteria) this;
		}

		public Criteria andImageWebServerLessThanOrEqualTo(String value) {
			addCriterion("image_web_server <=", value, "imageWebServer");
			return (Criteria) this;
		}

		public Criteria andImageWebServerLike(String value) {
			addCriterion("image_web_server like", value, "imageWebServer");
			return (Criteria) this;
		}

		public Criteria andImageWebServerNotLike(String value) {
			addCriterion("image_web_server not like", value, "imageWebServer");
			return (Criteria) this;
		}

		public Criteria andImageWebServerIn(List<String> values) {
			addCriterion("image_web_server in", values, "imageWebServer");
			return (Criteria) this;
		}

		public Criteria andImageWebServerNotIn(List<String> values) {
			addCriterion("image_web_server not in", values, "imageWebServer");
			return (Criteria) this;
		}

		public Criteria andImageWebServerBetween(String value1, String value2) {
			addCriterion("image_web_server between", value1, value2, "imageWebServer");
			return (Criteria) this;
		}

		public Criteria andImageWebServerNotBetween(String value1, String value2) {
			addCriterion("image_web_server not between", value1, value2, "imageWebServer");
			return (Criteria) this;
		}

		public Criteria andIndentCommentIsNull() {
			addCriterion("indent_comment is null");
			return (Criteria) this;
		}

		public Criteria andIndentCommentIsNotNull() {
			addCriterion("indent_comment is not null");
			return (Criteria) this;
		}

		public Criteria andIndentCommentEqualTo(Integer value) {
			addCriterion("indent_comment =", value, "indentComment");
			return (Criteria) this;
		}

		public Criteria andIndentCommentNotEqualTo(Integer value) {
			addCriterion("indent_comment <>", value, "indentComment");
			return (Criteria) this;
		}

		public Criteria andIndentCommentGreaterThan(Integer value) {
			addCriterion("indent_comment >", value, "indentComment");
			return (Criteria) this;
		}

		public Criteria andIndentCommentGreaterThanOrEqualTo(Integer value) {
			addCriterion("indent_comment >=", value, "indentComment");
			return (Criteria) this;
		}

		public Criteria andIndentCommentLessThan(Integer value) {
			addCriterion("indent_comment <", value, "indentComment");
			return (Criteria) this;
		}

		public Criteria andIndentCommentLessThanOrEqualTo(Integer value) {
			addCriterion("indent_comment <=", value, "indentComment");
			return (Criteria) this;
		}

		public Criteria andIndentCommentIn(List<Integer> values) {
			addCriterion("indent_comment in", values, "indentComment");
			return (Criteria) this;
		}

		public Criteria andIndentCommentNotIn(List<Integer> values) {
			addCriterion("indent_comment not in", values, "indentComment");
			return (Criteria) this;
		}

		public Criteria andIndentCommentBetween(Integer value1, Integer value2) {
			addCriterion("indent_comment between", value1, value2, "indentComment");
			return (Criteria) this;
		}

		public Criteria andIndentCommentNotBetween(Integer value1, Integer value2) {
			addCriterion("indent_comment not between", value1, value2, "indentComment");
			return (Criteria) this;
		}

		public Criteria andIntegralIsNull() {
			addCriterion("integral is null");
			return (Criteria) this;
		}

		public Criteria andIntegralIsNotNull() {
			addCriterion("integral is not null");
			return (Criteria) this;
		}

		public Criteria andIntegralEqualTo(Boolean value) {
			addCriterion("integral =", value, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralNotEqualTo(Boolean value) {
			addCriterion("integral <>", value, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralGreaterThan(Boolean value) {
			addCriterion("integral >", value, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralGreaterThanOrEqualTo(Boolean value) {
			addCriterion("integral >=", value, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralLessThan(Boolean value) {
			addCriterion("integral <", value, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralLessThanOrEqualTo(Boolean value) {
			addCriterion("integral <=", value, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralIn(List<Boolean> values) {
			addCriterion("integral in", values, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralNotIn(List<Boolean> values) {
			addCriterion("integral not in", values, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralBetween(Boolean value1, Boolean value2) {
			addCriterion("integral between", value1, value2, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralNotBetween(Boolean value1, Boolean value2) {
			addCriterion("integral not between", value1, value2, "integral");
			return (Criteria) this;
		}

		public Criteria andIntegralRateIsNull() {
			addCriterion("integral_rate is null");
			return (Criteria) this;
		}

		public Criteria andIntegralRateIsNotNull() {
			addCriterion("integral_rate is not null");
			return (Criteria) this;
		}

		public Criteria andIntegralRateEqualTo(Integer value) {
			addCriterion("integral_rate =", value, "integralRate");
			return (Criteria) this;
		}

		public Criteria andIntegralRateNotEqualTo(Integer value) {
			addCriterion("integral_rate <>", value, "integralRate");
			return (Criteria) this;
		}

		public Criteria andIntegralRateGreaterThan(Integer value) {
			addCriterion("integral_rate >", value, "integralRate");
			return (Criteria) this;
		}

		public Criteria andIntegralRateGreaterThanOrEqualTo(Integer value) {
			addCriterion("integral_rate >=", value, "integralRate");
			return (Criteria) this;
		}

		public Criteria andIntegralRateLessThan(Integer value) {
			addCriterion("integral_rate <", value, "integralRate");
			return (Criteria) this;
		}

		public Criteria andIntegralRateLessThanOrEqualTo(Integer value) {
			addCriterion("integral_rate <=", value, "integralRate");
			return (Criteria) this;
		}

		public Criteria andIntegralRateIn(List<Integer> values) {
			addCriterion("integral_rate in", values, "integralRate");
			return (Criteria) this;
		}

		public Criteria andIntegralRateNotIn(List<Integer> values) {
			addCriterion("integral_rate not in", values, "integralRate");
			return (Criteria) this;
		}

		public Criteria andIntegralRateBetween(Integer value1, Integer value2) {
			addCriterion("integral_rate between", value1, value2, "integralRate");
			return (Criteria) this;
		}

		public Criteria andIntegralRateNotBetween(Integer value1, Integer value2) {
			addCriterion("integral_rate not between", value1, value2, "integralRate");
			return (Criteria) this;
		}

		public Criteria andIntegralStoreIsNull() {
			addCriterion("integral_store is null");
			return (Criteria) this;
		}

		public Criteria andIntegralStoreIsNotNull() {
			addCriterion("integral_store is not null");
			return (Criteria) this;
		}

		public Criteria andIntegralStoreEqualTo(Boolean value) {
			addCriterion("integral_store =", value, "integralStore");
			return (Criteria) this;
		}

		public Criteria andIntegralStoreNotEqualTo(Boolean value) {
			addCriterion("integral_store <>", value, "integralStore");
			return (Criteria) this;
		}

		public Criteria andIntegralStoreGreaterThan(Boolean value) {
			addCriterion("integral_store >", value, "integralStore");
			return (Criteria) this;
		}

		public Criteria andIntegralStoreGreaterThanOrEqualTo(Boolean value) {
			addCriterion("integral_store >=", value, "integralStore");
			return (Criteria) this;
		}

		public Criteria andIntegralStoreLessThan(Boolean value) {
			addCriterion("integral_store <", value, "integralStore");
			return (Criteria) this;
		}

		public Criteria andIntegralStoreLessThanOrEqualTo(Boolean value) {
			addCriterion("integral_store <=", value, "integralStore");
			return (Criteria) this;
		}

		public Criteria andIntegralStoreIn(List<Boolean> values) {
			addCriterion("integral_store in", values, "integralStore");
			return (Criteria) this;
		}

		public Criteria andIntegralStoreNotIn(List<Boolean> values) {
			addCriterion("integral_store not in", values, "integralStore");
			return (Criteria) this;
		}

		public Criteria andIntegralStoreBetween(Boolean value1, Boolean value2) {
			addCriterion("integral_store between", value1, value2, "integralStore");
			return (Criteria) this;
		}

		public Criteria andIntegralStoreNotBetween(Boolean value1, Boolean value2) {
			addCriterion("integral_store not between", value1, value2, "integralStore");
			return (Criteria) this;
		}

		public Criteria andIosDownloadIsNull() {
			addCriterion("ios_download is null");
			return (Criteria) this;
		}

		public Criteria andIosDownloadIsNotNull() {
			addCriterion("ios_download is not null");
			return (Criteria) this;
		}

		public Criteria andIosDownloadEqualTo(String value) {
			addCriterion("ios_download =", value, "iosDownload");
			return (Criteria) this;
		}

		public Criteria andIosDownloadNotEqualTo(String value) {
			addCriterion("ios_download <>", value, "iosDownload");
			return (Criteria) this;
		}

		public Criteria andIosDownloadGreaterThan(String value) {
			addCriterion("ios_download >", value, "iosDownload");
			return (Criteria) this;
		}

		public Criteria andIosDownloadGreaterThanOrEqualTo(String value) {
			addCriterion("ios_download >=", value, "iosDownload");
			return (Criteria) this;
		}

		public Criteria andIosDownloadLessThan(String value) {
			addCriterion("ios_download <", value, "iosDownload");
			return (Criteria) this;
		}

		public Criteria andIosDownloadLessThanOrEqualTo(String value) {
			addCriterion("ios_download <=", value, "iosDownload");
			return (Criteria) this;
		}

		public Criteria andIosDownloadLike(String value) {
			addCriterion("ios_download like", value, "iosDownload");
			return (Criteria) this;
		}

		public Criteria andIosDownloadNotLike(String value) {
			addCriterion("ios_download not like", value, "iosDownload");
			return (Criteria) this;
		}

		public Criteria andIosDownloadIn(List<String> values) {
			addCriterion("ios_download in", values, "iosDownload");
			return (Criteria) this;
		}

		public Criteria andIosDownloadNotIn(List<String> values) {
			addCriterion("ios_download not in", values, "iosDownload");
			return (Criteria) this;
		}

		public Criteria andIosDownloadBetween(String value1, String value2) {
			addCriterion("ios_download between", value1, value2, "iosDownload");
			return (Criteria) this;
		}

		public Criteria andIosDownloadNotBetween(String value1, String value2) {
			addCriterion("ios_download not between", value1, value2, "iosDownload");
			return (Criteria) this;
		}

		public Criteria andIosVersionIsNull() {
			addCriterion("ios_version is null");
			return (Criteria) this;
		}

		public Criteria andIosVersionIsNotNull() {
			addCriterion("ios_version is not null");
			return (Criteria) this;
		}

		public Criteria andIosVersionEqualTo(String value) {
			addCriterion("ios_version =", value, "iosVersion");
			return (Criteria) this;
		}

		public Criteria andIosVersionNotEqualTo(String value) {
			addCriterion("ios_version <>", value, "iosVersion");
			return (Criteria) this;
		}

		public Criteria andIosVersionGreaterThan(String value) {
			addCriterion("ios_version >", value, "iosVersion");
			return (Criteria) this;
		}

		public Criteria andIosVersionGreaterThanOrEqualTo(String value) {
			addCriterion("ios_version >=", value, "iosVersion");
			return (Criteria) this;
		}

		public Criteria andIosVersionLessThan(String value) {
			addCriterion("ios_version <", value, "iosVersion");
			return (Criteria) this;
		}

		public Criteria andIosVersionLessThanOrEqualTo(String value) {
			addCriterion("ios_version <=", value, "iosVersion");
			return (Criteria) this;
		}

		public Criteria andIosVersionLike(String value) {
			addCriterion("ios_version like", value, "iosVersion");
			return (Criteria) this;
		}

		public Criteria andIosVersionNotLike(String value) {
			addCriterion("ios_version not like", value, "iosVersion");
			return (Criteria) this;
		}

		public Criteria andIosVersionIn(List<String> values) {
			addCriterion("ios_version in", values, "iosVersion");
			return (Criteria) this;
		}

		public Criteria andIosVersionNotIn(List<String> values) {
			addCriterion("ios_version not in", values, "iosVersion");
			return (Criteria) this;
		}

		public Criteria andIosVersionBetween(String value1, String value2) {
			addCriterion("ios_version between", value1, value2, "iosVersion");
			return (Criteria) this;
		}

		public Criteria andIosVersionNotBetween(String value1, String value2) {
			addCriterion("ios_version not between", value1, value2, "iosVersion");
			return (Criteria) this;
		}

		public Criteria andKeywordsIsNull() {
			addCriterion("keywords is null");
			return (Criteria) this;
		}

		public Criteria andKeywordsIsNotNull() {
			addCriterion("keywords is not null");
			return (Criteria) this;
		}

		public Criteria andKeywordsEqualTo(String value) {
			addCriterion("keywords =", value, "keywords");
			return (Criteria) this;
		}

		public Criteria andKeywordsNotEqualTo(String value) {
			addCriterion("keywords <>", value, "keywords");
			return (Criteria) this;
		}

		public Criteria andKeywordsGreaterThan(String value) {
			addCriterion("keywords >", value, "keywords");
			return (Criteria) this;
		}

		public Criteria andKeywordsGreaterThanOrEqualTo(String value) {
			addCriterion("keywords >=", value, "keywords");
			return (Criteria) this;
		}

		public Criteria andKeywordsLessThan(String value) {
			addCriterion("keywords <", value, "keywords");
			return (Criteria) this;
		}

		public Criteria andKeywordsLessThanOrEqualTo(String value) {
			addCriterion("keywords <=", value, "keywords");
			return (Criteria) this;
		}

		public Criteria andKeywordsLike(String value) {
			addCriterion("keywords like", value, "keywords");
			return (Criteria) this;
		}

		public Criteria andKeywordsNotLike(String value) {
			addCriterion("keywords not like", value, "keywords");
			return (Criteria) this;
		}

		public Criteria andKeywordsIn(List<String> values) {
			addCriterion("keywords in", values, "keywords");
			return (Criteria) this;
		}

		public Criteria andKeywordsNotIn(List<String> values) {
			addCriterion("keywords not in", values, "keywords");
			return (Criteria) this;
		}

		public Criteria andKeywordsBetween(String value1, String value2) {
			addCriterion("keywords between", value1, value2, "keywords");
			return (Criteria) this;
		}

		public Criteria andKeywordsNotBetween(String value1, String value2) {
			addCriterion("keywords not between", value1, value2, "keywords");
			return (Criteria) this;
		}

		public Criteria andKuaidiTypeIsNull() {
			addCriterion("kuaidi_type is null");
			return (Criteria) this;
		}

		public Criteria andKuaidiTypeIsNotNull() {
			addCriterion("kuaidi_type is not null");
			return (Criteria) this;
		}

		public Criteria andKuaidiTypeEqualTo(Integer value) {
			addCriterion("kuaidi_type =", value, "kuaidiType");
			return (Criteria) this;
		}

		public Criteria andKuaidiTypeNotEqualTo(Integer value) {
			addCriterion("kuaidi_type <>", value, "kuaidiType");
			return (Criteria) this;
		}

		public Criteria andKuaidiTypeGreaterThan(Integer value) {
			addCriterion("kuaidi_type >", value, "kuaidiType");
			return (Criteria) this;
		}

		public Criteria andKuaidiTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("kuaidi_type >=", value, "kuaidiType");
			return (Criteria) this;
		}

		public Criteria andKuaidiTypeLessThan(Integer value) {
			addCriterion("kuaidi_type <", value, "kuaidiType");
			return (Criteria) this;
		}

		public Criteria andKuaidiTypeLessThanOrEqualTo(Integer value) {
			addCriterion("kuaidi_type <=", value, "kuaidiType");
			return (Criteria) this;
		}

		public Criteria andKuaidiTypeIn(List<Integer> values) {
			addCriterion("kuaidi_type in", values, "kuaidiType");
			return (Criteria) this;
		}

		public Criteria andKuaidiTypeNotIn(List<Integer> values) {
			addCriterion("kuaidi_type not in", values, "kuaidiType");
			return (Criteria) this;
		}

		public Criteria andKuaidiTypeBetween(Integer value1, Integer value2) {
			addCriterion("kuaidi_type between", value1, value2, "kuaidiType");
			return (Criteria) this;
		}

		public Criteria andKuaidiTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("kuaidi_type not between", value1, value2, "kuaidiType");
			return (Criteria) this;
		}

		public Criteria andLuceneUpdateIsNull() {
			addCriterion("lucene_update is null");
			return (Criteria) this;
		}

		public Criteria andLuceneUpdateIsNotNull() {
			addCriterion("lucene_update is not null");
			return (Criteria) this;
		}

		public Criteria andLuceneUpdateEqualTo(Date value) {
			addCriterion("lucene_update =", value, "luceneUpdate");
			return (Criteria) this;
		}

		public Criteria andLuceneUpdateNotEqualTo(Date value) {
			addCriterion("lucene_update <>", value, "luceneUpdate");
			return (Criteria) this;
		}

		public Criteria andLuceneUpdateGreaterThan(Date value) {
			addCriterion("lucene_update >", value, "luceneUpdate");
			return (Criteria) this;
		}

		public Criteria andLuceneUpdateGreaterThanOrEqualTo(Date value) {
			addCriterion("lucene_update >=", value, "luceneUpdate");
			return (Criteria) this;
		}

		public Criteria andLuceneUpdateLessThan(Date value) {
			addCriterion("lucene_update <", value, "luceneUpdate");
			return (Criteria) this;
		}

		public Criteria andLuceneUpdateLessThanOrEqualTo(Date value) {
			addCriterion("lucene_update <=", value, "luceneUpdate");
			return (Criteria) this;
		}

		public Criteria andLuceneUpdateIn(List<Date> values) {
			addCriterion("lucene_update in", values, "luceneUpdate");
			return (Criteria) this;
		}

		public Criteria andLuceneUpdateNotIn(List<Date> values) {
			addCriterion("lucene_update not in", values, "luceneUpdate");
			return (Criteria) this;
		}

		public Criteria andLuceneUpdateBetween(Date value1, Date value2) {
			addCriterion("lucene_update between", value1, value2, "luceneUpdate");
			return (Criteria) this;
		}

		public Criteria andLuceneUpdateNotBetween(Date value1, Date value2) {
			addCriterion("lucene_update not between", value1, value2, "luceneUpdate");
			return (Criteria) this;
		}

		public Criteria andLucenenQueueIsNull() {
			addCriterion("lucenen_queue is null");
			return (Criteria) this;
		}

		public Criteria andLucenenQueueIsNotNull() {
			addCriterion("lucenen_queue is not null");
			return (Criteria) this;
		}

		public Criteria andLucenenQueueEqualTo(Integer value) {
			addCriterion("lucenen_queue =", value, "lucenenQueue");
			return (Criteria) this;
		}

		public Criteria andLucenenQueueNotEqualTo(Integer value) {
			addCriterion("lucenen_queue <>", value, "lucenenQueue");
			return (Criteria) this;
		}

		public Criteria andLucenenQueueGreaterThan(Integer value) {
			addCriterion("lucenen_queue >", value, "lucenenQueue");
			return (Criteria) this;
		}

		public Criteria andLucenenQueueGreaterThanOrEqualTo(Integer value) {
			addCriterion("lucenen_queue >=", value, "lucenenQueue");
			return (Criteria) this;
		}

		public Criteria andLucenenQueueLessThan(Integer value) {
			addCriterion("lucenen_queue <", value, "lucenenQueue");
			return (Criteria) this;
		}

		public Criteria andLucenenQueueLessThanOrEqualTo(Integer value) {
			addCriterion("lucenen_queue <=", value, "lucenenQueue");
			return (Criteria) this;
		}

		public Criteria andLucenenQueueIn(List<Integer> values) {
			addCriterion("lucenen_queue in", values, "lucenenQueue");
			return (Criteria) this;
		}

		public Criteria andLucenenQueueNotIn(List<Integer> values) {
			addCriterion("lucenen_queue not in", values, "lucenenQueue");
			return (Criteria) this;
		}

		public Criteria andLucenenQueueBetween(Integer value1, Integer value2) {
			addCriterion("lucenen_queue between", value1, value2, "lucenenQueue");
			return (Criteria) this;
		}

		public Criteria andLucenenQueueNotBetween(Integer value1, Integer value2) {
			addCriterion("lucenen_queue not between", value1, value2, "lucenenQueue");
			return (Criteria) this;
		}

		public Criteria andMemberDayLoginIsNull() {
			addCriterion("member_day_login is null");
			return (Criteria) this;
		}

		public Criteria andMemberDayLoginIsNotNull() {
			addCriterion("member_day_login is not null");
			return (Criteria) this;
		}

		public Criteria andMemberDayLoginEqualTo(Integer value) {
			addCriterion("member_day_login =", value, "memberDayLogin");
			return (Criteria) this;
		}

		public Criteria andMemberDayLoginNotEqualTo(Integer value) {
			addCriterion("member_day_login <>", value, "memberDayLogin");
			return (Criteria) this;
		}

		public Criteria andMemberDayLoginGreaterThan(Integer value) {
			addCriterion("member_day_login >", value, "memberDayLogin");
			return (Criteria) this;
		}

		public Criteria andMemberDayLoginGreaterThanOrEqualTo(Integer value) {
			addCriterion("member_day_login >=", value, "memberDayLogin");
			return (Criteria) this;
		}

		public Criteria andMemberDayLoginLessThan(Integer value) {
			addCriterion("member_day_login <", value, "memberDayLogin");
			return (Criteria) this;
		}

		public Criteria andMemberDayLoginLessThanOrEqualTo(Integer value) {
			addCriterion("member_day_login <=", value, "memberDayLogin");
			return (Criteria) this;
		}

		public Criteria andMemberDayLoginIn(List<Integer> values) {
			addCriterion("member_day_login in", values, "memberDayLogin");
			return (Criteria) this;
		}

		public Criteria andMemberDayLoginNotIn(List<Integer> values) {
			addCriterion("member_day_login not in", values, "memberDayLogin");
			return (Criteria) this;
		}

		public Criteria andMemberDayLoginBetween(Integer value1, Integer value2) {
			addCriterion("member_day_login between", value1, value2, "memberDayLogin");
			return (Criteria) this;
		}

		public Criteria andMemberDayLoginNotBetween(Integer value1, Integer value2) {
			addCriterion("member_day_login not between", value1, value2, "memberDayLogin");
			return (Criteria) this;
		}

		public Criteria andMemberRegisterIsNull() {
			addCriterion("member_register is null");
			return (Criteria) this;
		}

		public Criteria andMemberRegisterIsNotNull() {
			addCriterion("member_register is not null");
			return (Criteria) this;
		}

		public Criteria andMemberRegisterEqualTo(Integer value) {
			addCriterion("member_register =", value, "memberRegister");
			return (Criteria) this;
		}

		public Criteria andMemberRegisterNotEqualTo(Integer value) {
			addCriterion("member_register <>", value, "memberRegister");
			return (Criteria) this;
		}

		public Criteria andMemberRegisterGreaterThan(Integer value) {
			addCriterion("member_register >", value, "memberRegister");
			return (Criteria) this;
		}

		public Criteria andMemberRegisterGreaterThanOrEqualTo(Integer value) {
			addCriterion("member_register >=", value, "memberRegister");
			return (Criteria) this;
		}

		public Criteria andMemberRegisterLessThan(Integer value) {
			addCriterion("member_register <", value, "memberRegister");
			return (Criteria) this;
		}

		public Criteria andMemberRegisterLessThanOrEqualTo(Integer value) {
			addCriterion("member_register <=", value, "memberRegister");
			return (Criteria) this;
		}

		public Criteria andMemberRegisterIn(List<Integer> values) {
			addCriterion("member_register in", values, "memberRegister");
			return (Criteria) this;
		}

		public Criteria andMemberRegisterNotIn(List<Integer> values) {
			addCriterion("member_register not in", values, "memberRegister");
			return (Criteria) this;
		}

		public Criteria andMemberRegisterBetween(Integer value1, Integer value2) {
			addCriterion("member_register between", value1, value2, "memberRegister");
			return (Criteria) this;
		}

		public Criteria andMemberRegisterNotBetween(Integer value1, Integer value2) {
			addCriterion("member_register not between", value1, value2, "memberRegister");
			return (Criteria) this;
		}

		public Criteria andMetaAuthorIsNull() {
			addCriterion("meta_author is null");
			return (Criteria) this;
		}

		public Criteria andMetaAuthorIsNotNull() {
			addCriterion("meta_author is not null");
			return (Criteria) this;
		}

		public Criteria andMetaAuthorEqualTo(String value) {
			addCriterion("meta_author =", value, "metaAuthor");
			return (Criteria) this;
		}

		public Criteria andMetaAuthorNotEqualTo(String value) {
			addCriterion("meta_author <>", value, "metaAuthor");
			return (Criteria) this;
		}

		public Criteria andMetaAuthorGreaterThan(String value) {
			addCriterion("meta_author >", value, "metaAuthor");
			return (Criteria) this;
		}

		public Criteria andMetaAuthorGreaterThanOrEqualTo(String value) {
			addCriterion("meta_author >=", value, "metaAuthor");
			return (Criteria) this;
		}

		public Criteria andMetaAuthorLessThan(String value) {
			addCriterion("meta_author <", value, "metaAuthor");
			return (Criteria) this;
		}

		public Criteria andMetaAuthorLessThanOrEqualTo(String value) {
			addCriterion("meta_author <=", value, "metaAuthor");
			return (Criteria) this;
		}

		public Criteria andMetaAuthorLike(String value) {
			addCriterion("meta_author like", value, "metaAuthor");
			return (Criteria) this;
		}

		public Criteria andMetaAuthorNotLike(String value) {
			addCriterion("meta_author not like", value, "metaAuthor");
			return (Criteria) this;
		}

		public Criteria andMetaAuthorIn(List<String> values) {
			addCriterion("meta_author in", values, "metaAuthor");
			return (Criteria) this;
		}

		public Criteria andMetaAuthorNotIn(List<String> values) {
			addCriterion("meta_author not in", values, "metaAuthor");
			return (Criteria) this;
		}

		public Criteria andMetaAuthorBetween(String value1, String value2) {
			addCriterion("meta_author between", value1, value2, "metaAuthor");
			return (Criteria) this;
		}

		public Criteria andMetaAuthorNotBetween(String value1, String value2) {
			addCriterion("meta_author not between", value1, value2, "metaAuthor");
			return (Criteria) this;
		}

		public Criteria andMetaGeneratorIsNull() {
			addCriterion("meta_generator is null");
			return (Criteria) this;
		}

		public Criteria andMetaGeneratorIsNotNull() {
			addCriterion("meta_generator is not null");
			return (Criteria) this;
		}

		public Criteria andMetaGeneratorEqualTo(String value) {
			addCriterion("meta_generator =", value, "metaGenerator");
			return (Criteria) this;
		}

		public Criteria andMetaGeneratorNotEqualTo(String value) {
			addCriterion("meta_generator <>", value, "metaGenerator");
			return (Criteria) this;
		}

		public Criteria andMetaGeneratorGreaterThan(String value) {
			addCriterion("meta_generator >", value, "metaGenerator");
			return (Criteria) this;
		}

		public Criteria andMetaGeneratorGreaterThanOrEqualTo(String value) {
			addCriterion("meta_generator >=", value, "metaGenerator");
			return (Criteria) this;
		}

		public Criteria andMetaGeneratorLessThan(String value) {
			addCriterion("meta_generator <", value, "metaGenerator");
			return (Criteria) this;
		}

		public Criteria andMetaGeneratorLessThanOrEqualTo(String value) {
			addCriterion("meta_generator <=", value, "metaGenerator");
			return (Criteria) this;
		}

		public Criteria andMetaGeneratorLike(String value) {
			addCriterion("meta_generator like", value, "metaGenerator");
			return (Criteria) this;
		}

		public Criteria andMetaGeneratorNotLike(String value) {
			addCriterion("meta_generator not like", value, "metaGenerator");
			return (Criteria) this;
		}

		public Criteria andMetaGeneratorIn(List<String> values) {
			addCriterion("meta_generator in", values, "metaGenerator");
			return (Criteria) this;
		}

		public Criteria andMetaGeneratorNotIn(List<String> values) {
			addCriterion("meta_generator not in", values, "metaGenerator");
			return (Criteria) this;
		}

		public Criteria andMetaGeneratorBetween(String value1, String value2) {
			addCriterion("meta_generator between", value1, value2, "metaGenerator");
			return (Criteria) this;
		}

		public Criteria andMetaGeneratorNotBetween(String value1, String value2) {
			addCriterion("meta_generator not between", value1, value2, "metaGenerator");
			return (Criteria) this;
		}

		public Criteria andMiddleHeightIsNull() {
			addCriterion("middle_height is null");
			return (Criteria) this;
		}

		public Criteria andMiddleHeightIsNotNull() {
			addCriterion("middle_height is not null");
			return (Criteria) this;
		}

		public Criteria andMiddleHeightEqualTo(Integer value) {
			addCriterion("middle_height =", value, "middleHeight");
			return (Criteria) this;
		}

		public Criteria andMiddleHeightNotEqualTo(Integer value) {
			addCriterion("middle_height <>", value, "middleHeight");
			return (Criteria) this;
		}

		public Criteria andMiddleHeightGreaterThan(Integer value) {
			addCriterion("middle_height >", value, "middleHeight");
			return (Criteria) this;
		}

		public Criteria andMiddleHeightGreaterThanOrEqualTo(Integer value) {
			addCriterion("middle_height >=", value, "middleHeight");
			return (Criteria) this;
		}

		public Criteria andMiddleHeightLessThan(Integer value) {
			addCriterion("middle_height <", value, "middleHeight");
			return (Criteria) this;
		}

		public Criteria andMiddleHeightLessThanOrEqualTo(Integer value) {
			addCriterion("middle_height <=", value, "middleHeight");
			return (Criteria) this;
		}

		public Criteria andMiddleHeightIn(List<Integer> values) {
			addCriterion("middle_height in", values, "middleHeight");
			return (Criteria) this;
		}

		public Criteria andMiddleHeightNotIn(List<Integer> values) {
			addCriterion("middle_height not in", values, "middleHeight");
			return (Criteria) this;
		}

		public Criteria andMiddleHeightBetween(Integer value1, Integer value2) {
			addCriterion("middle_height between", value1, value2, "middleHeight");
			return (Criteria) this;
		}

		public Criteria andMiddleHeightNotBetween(Integer value1, Integer value2) {
			addCriterion("middle_height not between", value1, value2, "middleHeight");
			return (Criteria) this;
		}

		public Criteria andMiddleWidthIsNull() {
			addCriterion("middle_width is null");
			return (Criteria) this;
		}

		public Criteria andMiddleWidthIsNotNull() {
			addCriterion("middle_width is not null");
			return (Criteria) this;
		}

		public Criteria andMiddleWidthEqualTo(Integer value) {
			addCriterion("middle_width =", value, "middleWidth");
			return (Criteria) this;
		}

		public Criteria andMiddleWidthNotEqualTo(Integer value) {
			addCriterion("middle_width <>", value, "middleWidth");
			return (Criteria) this;
		}

		public Criteria andMiddleWidthGreaterThan(Integer value) {
			addCriterion("middle_width >", value, "middleWidth");
			return (Criteria) this;
		}

		public Criteria andMiddleWidthGreaterThanOrEqualTo(Integer value) {
			addCriterion("middle_width >=", value, "middleWidth");
			return (Criteria) this;
		}

		public Criteria andMiddleWidthLessThan(Integer value) {
			addCriterion("middle_width <", value, "middleWidth");
			return (Criteria) this;
		}

		public Criteria andMiddleWidthLessThanOrEqualTo(Integer value) {
			addCriterion("middle_width <=", value, "middleWidth");
			return (Criteria) this;
		}

		public Criteria andMiddleWidthIn(List<Integer> values) {
			addCriterion("middle_width in", values, "middleWidth");
			return (Criteria) this;
		}

		public Criteria andMiddleWidthNotIn(List<Integer> values) {
			addCriterion("middle_width not in", values, "middleWidth");
			return (Criteria) this;
		}

		public Criteria andMiddleWidthBetween(Integer value1, Integer value2) {
			addCriterion("middle_width between", value1, value2, "middleWidth");
			return (Criteria) this;
		}

		public Criteria andMiddleWidthNotBetween(Integer value1, Integer value2) {
			addCriterion("middle_width not between", value1, value2, "middleWidth");
			return (Criteria) this;
		}

		public Criteria andOfcardIsNull() {
			addCriterion("ofcard is null");
			return (Criteria) this;
		}

		public Criteria andOfcardIsNotNull() {
			addCriterion("ofcard is not null");
			return (Criteria) this;
		}

		public Criteria andOfcardEqualTo(Boolean value) {
			addCriterion("ofcard =", value, "ofcard");
			return (Criteria) this;
		}

		public Criteria andOfcardNotEqualTo(Boolean value) {
			addCriterion("ofcard <>", value, "ofcard");
			return (Criteria) this;
		}

		public Criteria andOfcardGreaterThan(Boolean value) {
			addCriterion("ofcard >", value, "ofcard");
			return (Criteria) this;
		}

		public Criteria andOfcardGreaterThanOrEqualTo(Boolean value) {
			addCriterion("ofcard >=", value, "ofcard");
			return (Criteria) this;
		}

		public Criteria andOfcardLessThan(Boolean value) {
			addCriterion("ofcard <", value, "ofcard");
			return (Criteria) this;
		}

		public Criteria andOfcardLessThanOrEqualTo(Boolean value) {
			addCriterion("ofcard <=", value, "ofcard");
			return (Criteria) this;
		}

		public Criteria andOfcardIn(List<Boolean> values) {
			addCriterion("ofcard in", values, "ofcard");
			return (Criteria) this;
		}

		public Criteria andOfcardNotIn(List<Boolean> values) {
			addCriterion("ofcard not in", values, "ofcard");
			return (Criteria) this;
		}

		public Criteria andOfcardBetween(Boolean value1, Boolean value2) {
			addCriterion("ofcard between", value1, value2, "ofcard");
			return (Criteria) this;
		}

		public Criteria andOfcardNotBetween(Boolean value1, Boolean value2) {
			addCriterion("ofcard not between", value1, value2, "ofcard");
			return (Criteria) this;
		}

		public Criteria andOfcardMobileProfitIsNull() {
			addCriterion("ofcard_mobile_profit is null");
			return (Criteria) this;
		}

		public Criteria andOfcardMobileProfitIsNotNull() {
			addCriterion("ofcard_mobile_profit is not null");
			return (Criteria) this;
		}

		public Criteria andOfcardMobileProfitEqualTo(BigDecimal value) {
			addCriterion("ofcard_mobile_profit =", value, "ofcardMobileProfit");
			return (Criteria) this;
		}

		public Criteria andOfcardMobileProfitNotEqualTo(BigDecimal value) {
			addCriterion("ofcard_mobile_profit <>", value, "ofcardMobileProfit");
			return (Criteria) this;
		}

		public Criteria andOfcardMobileProfitGreaterThan(BigDecimal value) {
			addCriterion("ofcard_mobile_profit >", value, "ofcardMobileProfit");
			return (Criteria) this;
		}

		public Criteria andOfcardMobileProfitGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("ofcard_mobile_profit >=", value, "ofcardMobileProfit");
			return (Criteria) this;
		}

		public Criteria andOfcardMobileProfitLessThan(BigDecimal value) {
			addCriterion("ofcard_mobile_profit <", value, "ofcardMobileProfit");
			return (Criteria) this;
		}

		public Criteria andOfcardMobileProfitLessThanOrEqualTo(BigDecimal value) {
			addCriterion("ofcard_mobile_profit <=", value, "ofcardMobileProfit");
			return (Criteria) this;
		}

		public Criteria andOfcardMobileProfitIn(List<BigDecimal> values) {
			addCriterion("ofcard_mobile_profit in", values, "ofcardMobileProfit");
			return (Criteria) this;
		}

		public Criteria andOfcardMobileProfitNotIn(List<BigDecimal> values) {
			addCriterion("ofcard_mobile_profit not in", values, "ofcardMobileProfit");
			return (Criteria) this;
		}

		public Criteria andOfcardMobileProfitBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ofcard_mobile_profit between", value1, value2, "ofcardMobileProfit");
			return (Criteria) this;
		}

		public Criteria andOfcardMobileProfitNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ofcard_mobile_profit not between", value1, value2, "ofcardMobileProfit");
			return (Criteria) this;
		}

		public Criteria andOfcardUseridIsNull() {
			addCriterion("ofcard_userid is null");
			return (Criteria) this;
		}

		public Criteria andOfcardUseridIsNotNull() {
			addCriterion("ofcard_userid is not null");
			return (Criteria) this;
		}

		public Criteria andOfcardUseridEqualTo(String value) {
			addCriterion("ofcard_userid =", value, "ofcardUserid");
			return (Criteria) this;
		}

		public Criteria andOfcardUseridNotEqualTo(String value) {
			addCriterion("ofcard_userid <>", value, "ofcardUserid");
			return (Criteria) this;
		}

		public Criteria andOfcardUseridGreaterThan(String value) {
			addCriterion("ofcard_userid >", value, "ofcardUserid");
			return (Criteria) this;
		}

		public Criteria andOfcardUseridGreaterThanOrEqualTo(String value) {
			addCriterion("ofcard_userid >=", value, "ofcardUserid");
			return (Criteria) this;
		}

		public Criteria andOfcardUseridLessThan(String value) {
			addCriterion("ofcard_userid <", value, "ofcardUserid");
			return (Criteria) this;
		}

		public Criteria andOfcardUseridLessThanOrEqualTo(String value) {
			addCriterion("ofcard_userid <=", value, "ofcardUserid");
			return (Criteria) this;
		}

		public Criteria andOfcardUseridLike(String value) {
			addCriterion("ofcard_userid like", value, "ofcardUserid");
			return (Criteria) this;
		}

		public Criteria andOfcardUseridNotLike(String value) {
			addCriterion("ofcard_userid not like", value, "ofcardUserid");
			return (Criteria) this;
		}

		public Criteria andOfcardUseridIn(List<String> values) {
			addCriterion("ofcard_userid in", values, "ofcardUserid");
			return (Criteria) this;
		}

		public Criteria andOfcardUseridNotIn(List<String> values) {
			addCriterion("ofcard_userid not in", values, "ofcardUserid");
			return (Criteria) this;
		}

		public Criteria andOfcardUseridBetween(String value1, String value2) {
			addCriterion("ofcard_userid between", value1, value2, "ofcardUserid");
			return (Criteria) this;
		}

		public Criteria andOfcardUseridNotBetween(String value1, String value2) {
			addCriterion("ofcard_userid not between", value1, value2, "ofcardUserid");
			return (Criteria) this;
		}

		public Criteria andOfcardUserpwsIsNull() {
			addCriterion("ofcard_userpws is null");
			return (Criteria) this;
		}

		public Criteria andOfcardUserpwsIsNotNull() {
			addCriterion("ofcard_userpws is not null");
			return (Criteria) this;
		}

		public Criteria andOfcardUserpwsEqualTo(String value) {
			addCriterion("ofcard_userpws =", value, "ofcardUserpws");
			return (Criteria) this;
		}

		public Criteria andOfcardUserpwsNotEqualTo(String value) {
			addCriterion("ofcard_userpws <>", value, "ofcardUserpws");
			return (Criteria) this;
		}

		public Criteria andOfcardUserpwsGreaterThan(String value) {
			addCriterion("ofcard_userpws >", value, "ofcardUserpws");
			return (Criteria) this;
		}

		public Criteria andOfcardUserpwsGreaterThanOrEqualTo(String value) {
			addCriterion("ofcard_userpws >=", value, "ofcardUserpws");
			return (Criteria) this;
		}

		public Criteria andOfcardUserpwsLessThan(String value) {
			addCriterion("ofcard_userpws <", value, "ofcardUserpws");
			return (Criteria) this;
		}

		public Criteria andOfcardUserpwsLessThanOrEqualTo(String value) {
			addCriterion("ofcard_userpws <=", value, "ofcardUserpws");
			return (Criteria) this;
		}

		public Criteria andOfcardUserpwsLike(String value) {
			addCriterion("ofcard_userpws like", value, "ofcardUserpws");
			return (Criteria) this;
		}

		public Criteria andOfcardUserpwsNotLike(String value) {
			addCriterion("ofcard_userpws not like", value, "ofcardUserpws");
			return (Criteria) this;
		}

		public Criteria andOfcardUserpwsIn(List<String> values) {
			addCriterion("ofcard_userpws in", values, "ofcardUserpws");
			return (Criteria) this;
		}

		public Criteria andOfcardUserpwsNotIn(List<String> values) {
			addCriterion("ofcard_userpws not in", values, "ofcardUserpws");
			return (Criteria) this;
		}

		public Criteria andOfcardUserpwsBetween(String value1, String value2) {
			addCriterion("ofcard_userpws between", value1, value2, "ofcardUserpws");
			return (Criteria) this;
		}

		public Criteria andOfcardUserpwsNotBetween(String value1, String value2) {
			addCriterion("ofcard_userpws not between", value1, value2, "ofcardUserpws");
			return (Criteria) this;
		}

		public Criteria andPayoffAllAmountIsNull() {
			addCriterion("payoff_all_amount is null");
			return (Criteria) this;
		}

		public Criteria andPayoffAllAmountIsNotNull() {
			addCriterion("payoff_all_amount is not null");
			return (Criteria) this;
		}

		public Criteria andPayoffAllAmountEqualTo(BigDecimal value) {
			addCriterion("payoff_all_amount =", value, "payoffAllAmount");
			return (Criteria) this;
		}

		public Criteria andPayoffAllAmountNotEqualTo(BigDecimal value) {
			addCriterion("payoff_all_amount <>", value, "payoffAllAmount");
			return (Criteria) this;
		}

		public Criteria andPayoffAllAmountGreaterThan(BigDecimal value) {
			addCriterion("payoff_all_amount >", value, "payoffAllAmount");
			return (Criteria) this;
		}

		public Criteria andPayoffAllAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("payoff_all_amount >=", value, "payoffAllAmount");
			return (Criteria) this;
		}

		public Criteria andPayoffAllAmountLessThan(BigDecimal value) {
			addCriterion("payoff_all_amount <", value, "payoffAllAmount");
			return (Criteria) this;
		}

		public Criteria andPayoffAllAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("payoff_all_amount <=", value, "payoffAllAmount");
			return (Criteria) this;
		}

		public Criteria andPayoffAllAmountIn(List<BigDecimal> values) {
			addCriterion("payoff_all_amount in", values, "payoffAllAmount");
			return (Criteria) this;
		}

		public Criteria andPayoffAllAmountNotIn(List<BigDecimal> values) {
			addCriterion("payoff_all_amount not in", values, "payoffAllAmount");
			return (Criteria) this;
		}

		public Criteria andPayoffAllAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("payoff_all_amount between", value1, value2, "payoffAllAmount");
			return (Criteria) this;
		}

		public Criteria andPayoffAllAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("payoff_all_amount not between", value1, value2, "payoffAllAmount");
			return (Criteria) this;
		}

		public Criteria andPayoffAllAmountRealityIsNull() {
			addCriterion("payoff_all_amount_reality is null");
			return (Criteria) this;
		}

		public Criteria andPayoffAllAmountRealityIsNotNull() {
			addCriterion("payoff_all_amount_reality is not null");
			return (Criteria) this;
		}

		public Criteria andPayoffAllAmountRealityEqualTo(BigDecimal value) {
			addCriterion("payoff_all_amount_reality =", value, "payoffAllAmountReality");
			return (Criteria) this;
		}

		public Criteria andPayoffAllAmountRealityNotEqualTo(BigDecimal value) {
			addCriterion("payoff_all_amount_reality <>", value, "payoffAllAmountReality");
			return (Criteria) this;
		}

		public Criteria andPayoffAllAmountRealityGreaterThan(BigDecimal value) {
			addCriterion("payoff_all_amount_reality >", value, "payoffAllAmountReality");
			return (Criteria) this;
		}

		public Criteria andPayoffAllAmountRealityGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("payoff_all_amount_reality >=", value, "payoffAllAmountReality");
			return (Criteria) this;
		}

		public Criteria andPayoffAllAmountRealityLessThan(BigDecimal value) {
			addCriterion("payoff_all_amount_reality <", value, "payoffAllAmountReality");
			return (Criteria) this;
		}

		public Criteria andPayoffAllAmountRealityLessThanOrEqualTo(BigDecimal value) {
			addCriterion("payoff_all_amount_reality <=", value, "payoffAllAmountReality");
			return (Criteria) this;
		}

		public Criteria andPayoffAllAmountRealityIn(List<BigDecimal> values) {
			addCriterion("payoff_all_amount_reality in", values, "payoffAllAmountReality");
			return (Criteria) this;
		}

		public Criteria andPayoffAllAmountRealityNotIn(List<BigDecimal> values) {
			addCriterion("payoff_all_amount_reality not in", values, "payoffAllAmountReality");
			return (Criteria) this;
		}

		public Criteria andPayoffAllAmountRealityBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("payoff_all_amount_reality between", value1, value2, "payoffAllAmountReality");
			return (Criteria) this;
		}

		public Criteria andPayoffAllAmountRealityNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("payoff_all_amount_reality not between", value1, value2, "payoffAllAmountReality");
			return (Criteria) this;
		}

		public Criteria andPayoffAllCommissionIsNull() {
			addCriterion("payoff_all_commission is null");
			return (Criteria) this;
		}

		public Criteria andPayoffAllCommissionIsNotNull() {
			addCriterion("payoff_all_commission is not null");
			return (Criteria) this;
		}

		public Criteria andPayoffAllCommissionEqualTo(BigDecimal value) {
			addCriterion("payoff_all_commission =", value, "payoffAllCommission");
			return (Criteria) this;
		}

		public Criteria andPayoffAllCommissionNotEqualTo(BigDecimal value) {
			addCriterion("payoff_all_commission <>", value, "payoffAllCommission");
			return (Criteria) this;
		}

		public Criteria andPayoffAllCommissionGreaterThan(BigDecimal value) {
			addCriterion("payoff_all_commission >", value, "payoffAllCommission");
			return (Criteria) this;
		}

		public Criteria andPayoffAllCommissionGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("payoff_all_commission >=", value, "payoffAllCommission");
			return (Criteria) this;
		}

		public Criteria andPayoffAllCommissionLessThan(BigDecimal value) {
			addCriterion("payoff_all_commission <", value, "payoffAllCommission");
			return (Criteria) this;
		}

		public Criteria andPayoffAllCommissionLessThanOrEqualTo(BigDecimal value) {
			addCriterion("payoff_all_commission <=", value, "payoffAllCommission");
			return (Criteria) this;
		}

		public Criteria andPayoffAllCommissionIn(List<BigDecimal> values) {
			addCriterion("payoff_all_commission in", values, "payoffAllCommission");
			return (Criteria) this;
		}

		public Criteria andPayoffAllCommissionNotIn(List<BigDecimal> values) {
			addCriterion("payoff_all_commission not in", values, "payoffAllCommission");
			return (Criteria) this;
		}

		public Criteria andPayoffAllCommissionBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("payoff_all_commission between", value1, value2, "payoffAllCommission");
			return (Criteria) this;
		}

		public Criteria andPayoffAllCommissionNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("payoff_all_commission not between", value1, value2, "payoffAllCommission");
			return (Criteria) this;
		}

		public Criteria andPayoffAllSaleIsNull() {
			addCriterion("payoff_all_sale is null");
			return (Criteria) this;
		}

		public Criteria andPayoffAllSaleIsNotNull() {
			addCriterion("payoff_all_sale is not null");
			return (Criteria) this;
		}

		public Criteria andPayoffAllSaleEqualTo(BigDecimal value) {
			addCriterion("payoff_all_sale =", value, "payoffAllSale");
			return (Criteria) this;
		}

		public Criteria andPayoffAllSaleNotEqualTo(BigDecimal value) {
			addCriterion("payoff_all_sale <>", value, "payoffAllSale");
			return (Criteria) this;
		}

		public Criteria andPayoffAllSaleGreaterThan(BigDecimal value) {
			addCriterion("payoff_all_sale >", value, "payoffAllSale");
			return (Criteria) this;
		}

		public Criteria andPayoffAllSaleGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("payoff_all_sale >=", value, "payoffAllSale");
			return (Criteria) this;
		}

		public Criteria andPayoffAllSaleLessThan(BigDecimal value) {
			addCriterion("payoff_all_sale <", value, "payoffAllSale");
			return (Criteria) this;
		}

		public Criteria andPayoffAllSaleLessThanOrEqualTo(BigDecimal value) {
			addCriterion("payoff_all_sale <=", value, "payoffAllSale");
			return (Criteria) this;
		}

		public Criteria andPayoffAllSaleIn(List<BigDecimal> values) {
			addCriterion("payoff_all_sale in", values, "payoffAllSale");
			return (Criteria) this;
		}

		public Criteria andPayoffAllSaleNotIn(List<BigDecimal> values) {
			addCriterion("payoff_all_sale not in", values, "payoffAllSale");
			return (Criteria) this;
		}

		public Criteria andPayoffAllSaleBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("payoff_all_sale between", value1, value2, "payoffAllSale");
			return (Criteria) this;
		}

		public Criteria andPayoffAllSaleNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("payoff_all_sale not between", value1, value2, "payoffAllSale");
			return (Criteria) this;
		}

		public Criteria andPayoffCountIsNull() {
			addCriterion("payoff_count is null");
			return (Criteria) this;
		}

		public Criteria andPayoffCountIsNotNull() {
			addCriterion("payoff_count is not null");
			return (Criteria) this;
		}

		public Criteria andPayoffCountEqualTo(Integer value) {
			addCriterion("payoff_count =", value, "payoffCount");
			return (Criteria) this;
		}

		public Criteria andPayoffCountNotEqualTo(Integer value) {
			addCriterion("payoff_count <>", value, "payoffCount");
			return (Criteria) this;
		}

		public Criteria andPayoffCountGreaterThan(Integer value) {
			addCriterion("payoff_count >", value, "payoffCount");
			return (Criteria) this;
		}

		public Criteria andPayoffCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("payoff_count >=", value, "payoffCount");
			return (Criteria) this;
		}

		public Criteria andPayoffCountLessThan(Integer value) {
			addCriterion("payoff_count <", value, "payoffCount");
			return (Criteria) this;
		}

		public Criteria andPayoffCountLessThanOrEqualTo(Integer value) {
			addCriterion("payoff_count <=", value, "payoffCount");
			return (Criteria) this;
		}

		public Criteria andPayoffCountIn(List<Integer> values) {
			addCriterion("payoff_count in", values, "payoffCount");
			return (Criteria) this;
		}

		public Criteria andPayoffCountNotIn(List<Integer> values) {
			addCriterion("payoff_count not in", values, "payoffCount");
			return (Criteria) this;
		}

		public Criteria andPayoffCountBetween(Integer value1, Integer value2) {
			addCriterion("payoff_count between", value1, value2, "payoffCount");
			return (Criteria) this;
		}

		public Criteria andPayoffCountNotBetween(Integer value1, Integer value2) {
			addCriterion("payoff_count not between", value1, value2, "payoffCount");
			return (Criteria) this;
		}

		public Criteria andPayoffDateIsNull() {
			addCriterion("payoff_date is null");
			return (Criteria) this;
		}

		public Criteria andPayoffDateIsNotNull() {
			addCriterion("payoff_date is not null");
			return (Criteria) this;
		}

		public Criteria andPayoffDateEqualTo(Date value) {
			addCriterion("payoff_date =", value, "payoffDate");
			return (Criteria) this;
		}

		public Criteria andPayoffDateNotEqualTo(Date value) {
			addCriterion("payoff_date <>", value, "payoffDate");
			return (Criteria) this;
		}

		public Criteria andPayoffDateGreaterThan(Date value) {
			addCriterion("payoff_date >", value, "payoffDate");
			return (Criteria) this;
		}

		public Criteria andPayoffDateGreaterThanOrEqualTo(Date value) {
			addCriterion("payoff_date >=", value, "payoffDate");
			return (Criteria) this;
		}

		public Criteria andPayoffDateLessThan(Date value) {
			addCriterion("payoff_date <", value, "payoffDate");
			return (Criteria) this;
		}

		public Criteria andPayoffDateLessThanOrEqualTo(Date value) {
			addCriterion("payoff_date <=", value, "payoffDate");
			return (Criteria) this;
		}

		public Criteria andPayoffDateIn(List<Date> values) {
			addCriterion("payoff_date in", values, "payoffDate");
			return (Criteria) this;
		}

		public Criteria andPayoffDateNotIn(List<Date> values) {
			addCriterion("payoff_date not in", values, "payoffDate");
			return (Criteria) this;
		}

		public Criteria andPayoffDateBetween(Date value1, Date value2) {
			addCriterion("payoff_date between", value1, value2, "payoffDate");
			return (Criteria) this;
		}

		public Criteria andPayoffDateNotBetween(Date value1, Date value2) {
			addCriterion("payoff_date not between", value1, value2, "payoffDate");
			return (Criteria) this;
		}

		public Criteria andPayoffMagTypeIsNull() {
			addCriterion("payoff_mag_type is null");
			return (Criteria) this;
		}

		public Criteria andPayoffMagTypeIsNotNull() {
			addCriterion("payoff_mag_type is not null");
			return (Criteria) this;
		}

		public Criteria andPayoffMagTypeEqualTo(Integer value) {
			addCriterion("payoff_mag_type =", value, "payoffMagType");
			return (Criteria) this;
		}

		public Criteria andPayoffMagTypeNotEqualTo(Integer value) {
			addCriterion("payoff_mag_type <>", value, "payoffMagType");
			return (Criteria) this;
		}

		public Criteria andPayoffMagTypeGreaterThan(Integer value) {
			addCriterion("payoff_mag_type >", value, "payoffMagType");
			return (Criteria) this;
		}

		public Criteria andPayoffMagTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("payoff_mag_type >=", value, "payoffMagType");
			return (Criteria) this;
		}

		public Criteria andPayoffMagTypeLessThan(Integer value) {
			addCriterion("payoff_mag_type <", value, "payoffMagType");
			return (Criteria) this;
		}

		public Criteria andPayoffMagTypeLessThanOrEqualTo(Integer value) {
			addCriterion("payoff_mag_type <=", value, "payoffMagType");
			return (Criteria) this;
		}

		public Criteria andPayoffMagTypeIn(List<Integer> values) {
			addCriterion("payoff_mag_type in", values, "payoffMagType");
			return (Criteria) this;
		}

		public Criteria andPayoffMagTypeNotIn(List<Integer> values) {
			addCriterion("payoff_mag_type not in", values, "payoffMagType");
			return (Criteria) this;
		}

		public Criteria andPayoffMagTypeBetween(Integer value1, Integer value2) {
			addCriterion("payoff_mag_type between", value1, value2, "payoffMagType");
			return (Criteria) this;
		}

		public Criteria andPayoffMagTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("payoff_mag_type not between", value1, value2, "payoffMagType");
			return (Criteria) this;
		}

		public Criteria andPoweredbyIsNull() {
			addCriterion("poweredby is null");
			return (Criteria) this;
		}

		public Criteria andPoweredbyIsNotNull() {
			addCriterion("poweredby is not null");
			return (Criteria) this;
		}

		public Criteria andPoweredbyEqualTo(String value) {
			addCriterion("poweredby =", value, "poweredby");
			return (Criteria) this;
		}

		public Criteria andPoweredbyNotEqualTo(String value) {
			addCriterion("poweredby <>", value, "poweredby");
			return (Criteria) this;
		}

		public Criteria andPoweredbyGreaterThan(String value) {
			addCriterion("poweredby >", value, "poweredby");
			return (Criteria) this;
		}

		public Criteria andPoweredbyGreaterThanOrEqualTo(String value) {
			addCriterion("poweredby >=", value, "poweredby");
			return (Criteria) this;
		}

		public Criteria andPoweredbyLessThan(String value) {
			addCriterion("poweredby <", value, "poweredby");
			return (Criteria) this;
		}

		public Criteria andPoweredbyLessThanOrEqualTo(String value) {
			addCriterion("poweredby <=", value, "poweredby");
			return (Criteria) this;
		}

		public Criteria andPoweredbyLike(String value) {
			addCriterion("poweredby like", value, "poweredby");
			return (Criteria) this;
		}

		public Criteria andPoweredbyNotLike(String value) {
			addCriterion("poweredby not like", value, "poweredby");
			return (Criteria) this;
		}

		public Criteria andPoweredbyIn(List<String> values) {
			addCriterion("poweredby in", values, "poweredby");
			return (Criteria) this;
		}

		public Criteria andPoweredbyNotIn(List<String> values) {
			addCriterion("poweredby not in", values, "poweredby");
			return (Criteria) this;
		}

		public Criteria andPoweredbyBetween(String value1, String value2) {
			addCriterion("poweredby between", value1, value2, "poweredby");
			return (Criteria) this;
		}

		public Criteria andPoweredbyNotBetween(String value1, String value2) {
			addCriterion("poweredby not between", value1, value2, "poweredby");
			return (Criteria) this;
		}

		public Criteria andPublishPostLimitIsNull() {
			addCriterion("publish_post_limit is null");
			return (Criteria) this;
		}

		public Criteria andPublishPostLimitIsNotNull() {
			addCriterion("publish_post_limit is not null");
			return (Criteria) this;
		}

		public Criteria andPublishPostLimitEqualTo(Integer value) {
			addCriterion("publish_post_limit =", value, "publishPostLimit");
			return (Criteria) this;
		}

		public Criteria andPublishPostLimitNotEqualTo(Integer value) {
			addCriterion("publish_post_limit <>", value, "publishPostLimit");
			return (Criteria) this;
		}

		public Criteria andPublishPostLimitGreaterThan(Integer value) {
			addCriterion("publish_post_limit >", value, "publishPostLimit");
			return (Criteria) this;
		}

		public Criteria andPublishPostLimitGreaterThanOrEqualTo(Integer value) {
			addCriterion("publish_post_limit >=", value, "publishPostLimit");
			return (Criteria) this;
		}

		public Criteria andPublishPostLimitLessThan(Integer value) {
			addCriterion("publish_post_limit <", value, "publishPostLimit");
			return (Criteria) this;
		}

		public Criteria andPublishPostLimitLessThanOrEqualTo(Integer value) {
			addCriterion("publish_post_limit <=", value, "publishPostLimit");
			return (Criteria) this;
		}

		public Criteria andPublishPostLimitIn(List<Integer> values) {
			addCriterion("publish_post_limit in", values, "publishPostLimit");
			return (Criteria) this;
		}

		public Criteria andPublishPostLimitNotIn(List<Integer> values) {
			addCriterion("publish_post_limit not in", values, "publishPostLimit");
			return (Criteria) this;
		}

		public Criteria andPublishPostLimitBetween(Integer value1, Integer value2) {
			addCriterion("publish_post_limit between", value1, value2, "publishPostLimit");
			return (Criteria) this;
		}

		public Criteria andPublishPostLimitNotBetween(Integer value1, Integer value2) {
			addCriterion("publish_post_limit not between", value1, value2, "publishPostLimit");
			return (Criteria) this;
		}

		public Criteria andPublishSellerLimitIsNull() {
			addCriterion("publish_seller_limit is null");
			return (Criteria) this;
		}

		public Criteria andPublishSellerLimitIsNotNull() {
			addCriterion("publish_seller_limit is not null");
			return (Criteria) this;
		}

		public Criteria andPublishSellerLimitEqualTo(Integer value) {
			addCriterion("publish_seller_limit =", value, "publishSellerLimit");
			return (Criteria) this;
		}

		public Criteria andPublishSellerLimitNotEqualTo(Integer value) {
			addCriterion("publish_seller_limit <>", value, "publishSellerLimit");
			return (Criteria) this;
		}

		public Criteria andPublishSellerLimitGreaterThan(Integer value) {
			addCriterion("publish_seller_limit >", value, "publishSellerLimit");
			return (Criteria) this;
		}

		public Criteria andPublishSellerLimitGreaterThanOrEqualTo(Integer value) {
			addCriterion("publish_seller_limit >=", value, "publishSellerLimit");
			return (Criteria) this;
		}

		public Criteria andPublishSellerLimitLessThan(Integer value) {
			addCriterion("publish_seller_limit <", value, "publishSellerLimit");
			return (Criteria) this;
		}

		public Criteria andPublishSellerLimitLessThanOrEqualTo(Integer value) {
			addCriterion("publish_seller_limit <=", value, "publishSellerLimit");
			return (Criteria) this;
		}

		public Criteria andPublishSellerLimitIn(List<Integer> values) {
			addCriterion("publish_seller_limit in", values, "publishSellerLimit");
			return (Criteria) this;
		}

		public Criteria andPublishSellerLimitNotIn(List<Integer> values) {
			addCriterion("publish_seller_limit not in", values, "publishSellerLimit");
			return (Criteria) this;
		}

		public Criteria andPublishSellerLimitBetween(Integer value1, Integer value2) {
			addCriterion("publish_seller_limit between", value1, value2, "publishSellerLimit");
			return (Criteria) this;
		}

		public Criteria andPublishSellerLimitNotBetween(Integer value1, Integer value2) {
			addCriterion("publish_seller_limit not between", value1, value2, "publishSellerLimit");
			return (Criteria) this;
		}

		public Criteria andQqLoginIsNull() {
			addCriterion("qq_login is null");
			return (Criteria) this;
		}

		public Criteria andQqLoginIsNotNull() {
			addCriterion("qq_login is not null");
			return (Criteria) this;
		}

		public Criteria andQqLoginEqualTo(Boolean value) {
			addCriterion("qq_login =", value, "qqLogin");
			return (Criteria) this;
		}

		public Criteria andQqLoginNotEqualTo(Boolean value) {
			addCriterion("qq_login <>", value, "qqLogin");
			return (Criteria) this;
		}

		public Criteria andQqLoginGreaterThan(Boolean value) {
			addCriterion("qq_login >", value, "qqLogin");
			return (Criteria) this;
		}

		public Criteria andQqLoginGreaterThanOrEqualTo(Boolean value) {
			addCriterion("qq_login >=", value, "qqLogin");
			return (Criteria) this;
		}

		public Criteria andQqLoginLessThan(Boolean value) {
			addCriterion("qq_login <", value, "qqLogin");
			return (Criteria) this;
		}

		public Criteria andQqLoginLessThanOrEqualTo(Boolean value) {
			addCriterion("qq_login <=", value, "qqLogin");
			return (Criteria) this;
		}

		public Criteria andQqLoginIn(List<Boolean> values) {
			addCriterion("qq_login in", values, "qqLogin");
			return (Criteria) this;
		}

		public Criteria andQqLoginNotIn(List<Boolean> values) {
			addCriterion("qq_login not in", values, "qqLogin");
			return (Criteria) this;
		}

		public Criteria andQqLoginBetween(Boolean value1, Boolean value2) {
			addCriterion("qq_login between", value1, value2, "qqLogin");
			return (Criteria) this;
		}

		public Criteria andQqLoginNotBetween(Boolean value1, Boolean value2) {
			addCriterion("qq_login not between", value1, value2, "qqLogin");
			return (Criteria) this;
		}

		public Criteria andQqLoginIdIsNull() {
			addCriterion("qq_login_id is null");
			return (Criteria) this;
		}

		public Criteria andQqLoginIdIsNotNull() {
			addCriterion("qq_login_id is not null");
			return (Criteria) this;
		}

		public Criteria andQqLoginIdEqualTo(String value) {
			addCriterion("qq_login_id =", value, "qqLoginId");
			return (Criteria) this;
		}

		public Criteria andQqLoginIdNotEqualTo(String value) {
			addCriterion("qq_login_id <>", value, "qqLoginId");
			return (Criteria) this;
		}

		public Criteria andQqLoginIdGreaterThan(String value) {
			addCriterion("qq_login_id >", value, "qqLoginId");
			return (Criteria) this;
		}

		public Criteria andQqLoginIdGreaterThanOrEqualTo(String value) {
			addCriterion("qq_login_id >=", value, "qqLoginId");
			return (Criteria) this;
		}

		public Criteria andQqLoginIdLessThan(String value) {
			addCriterion("qq_login_id <", value, "qqLoginId");
			return (Criteria) this;
		}

		public Criteria andQqLoginIdLessThanOrEqualTo(String value) {
			addCriterion("qq_login_id <=", value, "qqLoginId");
			return (Criteria) this;
		}

		public Criteria andQqLoginIdLike(String value) {
			addCriterion("qq_login_id like", value, "qqLoginId");
			return (Criteria) this;
		}

		public Criteria andQqLoginIdNotLike(String value) {
			addCriterion("qq_login_id not like", value, "qqLoginId");
			return (Criteria) this;
		}

		public Criteria andQqLoginIdIn(List<String> values) {
			addCriterion("qq_login_id in", values, "qqLoginId");
			return (Criteria) this;
		}

		public Criteria andQqLoginIdNotIn(List<String> values) {
			addCriterion("qq_login_id not in", values, "qqLoginId");
			return (Criteria) this;
		}

		public Criteria andQqLoginIdBetween(String value1, String value2) {
			addCriterion("qq_login_id between", value1, value2, "qqLoginId");
			return (Criteria) this;
		}

		public Criteria andQqLoginIdNotBetween(String value1, String value2) {
			addCriterion("qq_login_id not between", value1, value2, "qqLoginId");
			return (Criteria) this;
		}

		public Criteria andQqLoginKeyIsNull() {
			addCriterion("qq_login_key is null");
			return (Criteria) this;
		}

		public Criteria andQqLoginKeyIsNotNull() {
			addCriterion("qq_login_key is not null");
			return (Criteria) this;
		}

		public Criteria andQqLoginKeyEqualTo(String value) {
			addCriterion("qq_login_key =", value, "qqLoginKey");
			return (Criteria) this;
		}

		public Criteria andQqLoginKeyNotEqualTo(String value) {
			addCriterion("qq_login_key <>", value, "qqLoginKey");
			return (Criteria) this;
		}

		public Criteria andQqLoginKeyGreaterThan(String value) {
			addCriterion("qq_login_key >", value, "qqLoginKey");
			return (Criteria) this;
		}

		public Criteria andQqLoginKeyGreaterThanOrEqualTo(String value) {
			addCriterion("qq_login_key >=", value, "qqLoginKey");
			return (Criteria) this;
		}

		public Criteria andQqLoginKeyLessThan(String value) {
			addCriterion("qq_login_key <", value, "qqLoginKey");
			return (Criteria) this;
		}

		public Criteria andQqLoginKeyLessThanOrEqualTo(String value) {
			addCriterion("qq_login_key <=", value, "qqLoginKey");
			return (Criteria) this;
		}

		public Criteria andQqLoginKeyLike(String value) {
			addCriterion("qq_login_key like", value, "qqLoginKey");
			return (Criteria) this;
		}

		public Criteria andQqLoginKeyNotLike(String value) {
			addCriterion("qq_login_key not like", value, "qqLoginKey");
			return (Criteria) this;
		}

		public Criteria andQqLoginKeyIn(List<String> values) {
			addCriterion("qq_login_key in", values, "qqLoginKey");
			return (Criteria) this;
		}

		public Criteria andQqLoginKeyNotIn(List<String> values) {
			addCriterion("qq_login_key not in", values, "qqLoginKey");
			return (Criteria) this;
		}

		public Criteria andQqLoginKeyBetween(String value1, String value2) {
			addCriterion("qq_login_key between", value1, value2, "qqLoginKey");
			return (Criteria) this;
		}

		public Criteria andQqLoginKeyNotBetween(String value1, String value2) {
			addCriterion("qq_login_key not between", value1, value2, "qqLoginKey");
			return (Criteria) this;
		}

		public Criteria andQrLoginIsNull() {
			addCriterion("qr_login is null");
			return (Criteria) this;
		}

		public Criteria andQrLoginIsNotNull() {
			addCriterion("qr_login is not null");
			return (Criteria) this;
		}

		public Criteria andQrLoginEqualTo(Integer value) {
			addCriterion("qr_login =", value, "qrLogin");
			return (Criteria) this;
		}

		public Criteria andQrLoginNotEqualTo(Integer value) {
			addCriterion("qr_login <>", value, "qrLogin");
			return (Criteria) this;
		}

		public Criteria andQrLoginGreaterThan(Integer value) {
			addCriterion("qr_login >", value, "qrLogin");
			return (Criteria) this;
		}

		public Criteria andQrLoginGreaterThanOrEqualTo(Integer value) {
			addCriterion("qr_login >=", value, "qrLogin");
			return (Criteria) this;
		}

		public Criteria andQrLoginLessThan(Integer value) {
			addCriterion("qr_login <", value, "qrLogin");
			return (Criteria) this;
		}

		public Criteria andQrLoginLessThanOrEqualTo(Integer value) {
			addCriterion("qr_login <=", value, "qrLogin");
			return (Criteria) this;
		}

		public Criteria andQrLoginIn(List<Integer> values) {
			addCriterion("qr_login in", values, "qrLogin");
			return (Criteria) this;
		}

		public Criteria andQrLoginNotIn(List<Integer> values) {
			addCriterion("qr_login not in", values, "qrLogin");
			return (Criteria) this;
		}

		public Criteria andQrLoginBetween(Integer value1, Integer value2) {
			addCriterion("qr_login between", value1, value2, "qrLogin");
			return (Criteria) this;
		}

		public Criteria andQrLoginNotBetween(Integer value1, Integer value2) {
			addCriterion("qr_login not between", value1, value2, "qrLogin");
			return (Criteria) this;
		}

		public Criteria andSecondDomainOpenIsNull() {
			addCriterion("second_domain_open is null");
			return (Criteria) this;
		}

		public Criteria andSecondDomainOpenIsNotNull() {
			addCriterion("second_domain_open is not null");
			return (Criteria) this;
		}

		public Criteria andSecondDomainOpenEqualTo(Boolean value) {
			addCriterion("second_domain_open =", value, "secondDomainOpen");
			return (Criteria) this;
		}

		public Criteria andSecondDomainOpenNotEqualTo(Boolean value) {
			addCriterion("second_domain_open <>", value, "secondDomainOpen");
			return (Criteria) this;
		}

		public Criteria andSecondDomainOpenGreaterThan(Boolean value) {
			addCriterion("second_domain_open >", value, "secondDomainOpen");
			return (Criteria) this;
		}

		public Criteria andSecondDomainOpenGreaterThanOrEqualTo(Boolean value) {
			addCriterion("second_domain_open >=", value, "secondDomainOpen");
			return (Criteria) this;
		}

		public Criteria andSecondDomainOpenLessThan(Boolean value) {
			addCriterion("second_domain_open <", value, "secondDomainOpen");
			return (Criteria) this;
		}

		public Criteria andSecondDomainOpenLessThanOrEqualTo(Boolean value) {
			addCriterion("second_domain_open <=", value, "secondDomainOpen");
			return (Criteria) this;
		}

		public Criteria andSecondDomainOpenIn(List<Boolean> values) {
			addCriterion("second_domain_open in", values, "secondDomainOpen");
			return (Criteria) this;
		}

		public Criteria andSecondDomainOpenNotIn(List<Boolean> values) {
			addCriterion("second_domain_open not in", values, "secondDomainOpen");
			return (Criteria) this;
		}

		public Criteria andSecondDomainOpenBetween(Boolean value1, Boolean value2) {
			addCriterion("second_domain_open between", value1, value2, "secondDomainOpen");
			return (Criteria) this;
		}

		public Criteria andSecondDomainOpenNotBetween(Boolean value1, Boolean value2) {
			addCriterion("second_domain_open not between", value1, value2, "secondDomainOpen");
			return (Criteria) this;
		}

		public Criteria andSecretKeyIsNull() {
			addCriterion("secret_key is null");
			return (Criteria) this;
		}

		public Criteria andSecretKeyIsNotNull() {
			addCriterion("secret_key is not null");
			return (Criteria) this;
		}

		public Criteria andSecretKeyEqualTo(String value) {
			addCriterion("secret_key =", value, "secretKey");
			return (Criteria) this;
		}

		public Criteria andSecretKeyNotEqualTo(String value) {
			addCriterion("secret_key <>", value, "secretKey");
			return (Criteria) this;
		}

		public Criteria andSecretKeyGreaterThan(String value) {
			addCriterion("secret_key >", value, "secretKey");
			return (Criteria) this;
		}

		public Criteria andSecretKeyGreaterThanOrEqualTo(String value) {
			addCriterion("secret_key >=", value, "secretKey");
			return (Criteria) this;
		}

		public Criteria andSecretKeyLessThan(String value) {
			addCriterion("secret_key <", value, "secretKey");
			return (Criteria) this;
		}

		public Criteria andSecretKeyLessThanOrEqualTo(String value) {
			addCriterion("secret_key <=", value, "secretKey");
			return (Criteria) this;
		}

		public Criteria andSecretKeyLike(String value) {
			addCriterion("secret_key like", value, "secretKey");
			return (Criteria) this;
		}

		public Criteria andSecretKeyNotLike(String value) {
			addCriterion("secret_key not like", value, "secretKey");
			return (Criteria) this;
		}

		public Criteria andSecretKeyIn(List<String> values) {
			addCriterion("secret_key in", values, "secretKey");
			return (Criteria) this;
		}

		public Criteria andSecretKeyNotIn(List<String> values) {
			addCriterion("secret_key not in", values, "secretKey");
			return (Criteria) this;
		}

		public Criteria andSecretKeyBetween(String value1, String value2) {
			addCriterion("secret_key between", value1, value2, "secretKey");
			return (Criteria) this;
		}

		public Criteria andSecretKeyNotBetween(String value1, String value2) {
			addCriterion("secret_key not between", value1, value2, "secretKey");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeConsultIsNull() {
			addCriterion("security_code_consult is null");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeConsultIsNotNull() {
			addCriterion("security_code_consult is not null");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeConsultEqualTo(Boolean value) {
			addCriterion("security_code_consult =", value, "securityCodeConsult");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeConsultNotEqualTo(Boolean value) {
			addCriterion("security_code_consult <>", value, "securityCodeConsult");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeConsultGreaterThan(Boolean value) {
			addCriterion("security_code_consult >", value, "securityCodeConsult");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeConsultGreaterThanOrEqualTo(Boolean value) {
			addCriterion("security_code_consult >=", value, "securityCodeConsult");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeConsultLessThan(Boolean value) {
			addCriterion("security_code_consult <", value, "securityCodeConsult");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeConsultLessThanOrEqualTo(Boolean value) {
			addCriterion("security_code_consult <=", value, "securityCodeConsult");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeConsultIn(List<Boolean> values) {
			addCriterion("security_code_consult in", values, "securityCodeConsult");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeConsultNotIn(List<Boolean> values) {
			addCriterion("security_code_consult not in", values, "securityCodeConsult");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeConsultBetween(Boolean value1, Boolean value2) {
			addCriterion("security_code_consult between", value1, value2, "securityCodeConsult");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeConsultNotBetween(Boolean value1, Boolean value2) {
			addCriterion("security_code_consult not between", value1, value2, "securityCodeConsult");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeLoginIsNull() {
			addCriterion("security_code_login is null");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeLoginIsNotNull() {
			addCriterion("security_code_login is not null");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeLoginEqualTo(Boolean value) {
			addCriterion("security_code_login =", value, "securityCodeLogin");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeLoginNotEqualTo(Boolean value) {
			addCriterion("security_code_login <>", value, "securityCodeLogin");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeLoginGreaterThan(Boolean value) {
			addCriterion("security_code_login >", value, "securityCodeLogin");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeLoginGreaterThanOrEqualTo(Boolean value) {
			addCriterion("security_code_login >=", value, "securityCodeLogin");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeLoginLessThan(Boolean value) {
			addCriterion("security_code_login <", value, "securityCodeLogin");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeLoginLessThanOrEqualTo(Boolean value) {
			addCriterion("security_code_login <=", value, "securityCodeLogin");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeLoginIn(List<Boolean> values) {
			addCriterion("security_code_login in", values, "securityCodeLogin");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeLoginNotIn(List<Boolean> values) {
			addCriterion("security_code_login not in", values, "securityCodeLogin");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeLoginBetween(Boolean value1, Boolean value2) {
			addCriterion("security_code_login between", value1, value2, "securityCodeLogin");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeLoginNotBetween(Boolean value1, Boolean value2) {
			addCriterion("security_code_login not between", value1, value2, "securityCodeLogin");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeRegisterIsNull() {
			addCriterion("security_code_register is null");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeRegisterIsNotNull() {
			addCriterion("security_code_register is not null");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeRegisterEqualTo(Boolean value) {
			addCriterion("security_code_register =", value, "securityCodeRegister");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeRegisterNotEqualTo(Boolean value) {
			addCriterion("security_code_register <>", value, "securityCodeRegister");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeRegisterGreaterThan(Boolean value) {
			addCriterion("security_code_register >", value, "securityCodeRegister");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeRegisterGreaterThanOrEqualTo(Boolean value) {
			addCriterion("security_code_register >=", value, "securityCodeRegister");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeRegisterLessThan(Boolean value) {
			addCriterion("security_code_register <", value, "securityCodeRegister");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeRegisterLessThanOrEqualTo(Boolean value) {
			addCriterion("security_code_register <=", value, "securityCodeRegister");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeRegisterIn(List<Boolean> values) {
			addCriterion("security_code_register in", values, "securityCodeRegister");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeRegisterNotIn(List<Boolean> values) {
			addCriterion("security_code_register not in", values, "securityCodeRegister");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeRegisterBetween(Boolean value1, Boolean value2) {
			addCriterion("security_code_register between", value1, value2, "securityCodeRegister");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeRegisterNotBetween(Boolean value1, Boolean value2) {
			addCriterion("security_code_register not between", value1, value2, "securityCodeRegister");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeTypeIsNull() {
			addCriterion("security_code_type is null");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeTypeIsNotNull() {
			addCriterion("security_code_type is not null");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeTypeEqualTo(String value) {
			addCriterion("security_code_type =", value, "securityCodeType");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeTypeNotEqualTo(String value) {
			addCriterion("security_code_type <>", value, "securityCodeType");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeTypeGreaterThan(String value) {
			addCriterion("security_code_type >", value, "securityCodeType");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeTypeGreaterThanOrEqualTo(String value) {
			addCriterion("security_code_type >=", value, "securityCodeType");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeTypeLessThan(String value) {
			addCriterion("security_code_type <", value, "securityCodeType");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeTypeLessThanOrEqualTo(String value) {
			addCriterion("security_code_type <=", value, "securityCodeType");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeTypeLike(String value) {
			addCriterion("security_code_type like", value, "securityCodeType");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeTypeNotLike(String value) {
			addCriterion("security_code_type not like", value, "securityCodeType");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeTypeIn(List<String> values) {
			addCriterion("security_code_type in", values, "securityCodeType");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeTypeNotIn(List<String> values) {
			addCriterion("security_code_type not in", values, "securityCodeType");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeTypeBetween(String value1, String value2) {
			addCriterion("security_code_type between", value1, value2, "securityCodeType");
			return (Criteria) this;
		}

		public Criteria andSecurityCodeTypeNotBetween(String value1, String value2) {
			addCriterion("security_code_type not between", value1, value2, "securityCodeType");
			return (Criteria) this;
		}

		public Criteria andSinaLoginIsNull() {
			addCriterion("sina_login is null");
			return (Criteria) this;
		}

		public Criteria andSinaLoginIsNotNull() {
			addCriterion("sina_login is not null");
			return (Criteria) this;
		}

		public Criteria andSinaLoginEqualTo(Boolean value) {
			addCriterion("sina_login =", value, "sinaLogin");
			return (Criteria) this;
		}

		public Criteria andSinaLoginNotEqualTo(Boolean value) {
			addCriterion("sina_login <>", value, "sinaLogin");
			return (Criteria) this;
		}

		public Criteria andSinaLoginGreaterThan(Boolean value) {
			addCriterion("sina_login >", value, "sinaLogin");
			return (Criteria) this;
		}

		public Criteria andSinaLoginGreaterThanOrEqualTo(Boolean value) {
			addCriterion("sina_login >=", value, "sinaLogin");
			return (Criteria) this;
		}

		public Criteria andSinaLoginLessThan(Boolean value) {
			addCriterion("sina_login <", value, "sinaLogin");
			return (Criteria) this;
		}

		public Criteria andSinaLoginLessThanOrEqualTo(Boolean value) {
			addCriterion("sina_login <=", value, "sinaLogin");
			return (Criteria) this;
		}

		public Criteria andSinaLoginIn(List<Boolean> values) {
			addCriterion("sina_login in", values, "sinaLogin");
			return (Criteria) this;
		}

		public Criteria andSinaLoginNotIn(List<Boolean> values) {
			addCriterion("sina_login not in", values, "sinaLogin");
			return (Criteria) this;
		}

		public Criteria andSinaLoginBetween(Boolean value1, Boolean value2) {
			addCriterion("sina_login between", value1, value2, "sinaLogin");
			return (Criteria) this;
		}

		public Criteria andSinaLoginNotBetween(Boolean value1, Boolean value2) {
			addCriterion("sina_login not between", value1, value2, "sinaLogin");
			return (Criteria) this;
		}

		public Criteria andSinaLoginIdIsNull() {
			addCriterion("sina_login_id is null");
			return (Criteria) this;
		}

		public Criteria andSinaLoginIdIsNotNull() {
			addCriterion("sina_login_id is not null");
			return (Criteria) this;
		}

		public Criteria andSinaLoginIdEqualTo(String value) {
			addCriterion("sina_login_id =", value, "sinaLoginId");
			return (Criteria) this;
		}

		public Criteria andSinaLoginIdNotEqualTo(String value) {
			addCriterion("sina_login_id <>", value, "sinaLoginId");
			return (Criteria) this;
		}

		public Criteria andSinaLoginIdGreaterThan(String value) {
			addCriterion("sina_login_id >", value, "sinaLoginId");
			return (Criteria) this;
		}

		public Criteria andSinaLoginIdGreaterThanOrEqualTo(String value) {
			addCriterion("sina_login_id >=", value, "sinaLoginId");
			return (Criteria) this;
		}

		public Criteria andSinaLoginIdLessThan(String value) {
			addCriterion("sina_login_id <", value, "sinaLoginId");
			return (Criteria) this;
		}

		public Criteria andSinaLoginIdLessThanOrEqualTo(String value) {
			addCriterion("sina_login_id <=", value, "sinaLoginId");
			return (Criteria) this;
		}

		public Criteria andSinaLoginIdLike(String value) {
			addCriterion("sina_login_id like", value, "sinaLoginId");
			return (Criteria) this;
		}

		public Criteria andSinaLoginIdNotLike(String value) {
			addCriterion("sina_login_id not like", value, "sinaLoginId");
			return (Criteria) this;
		}

		public Criteria andSinaLoginIdIn(List<String> values) {
			addCriterion("sina_login_id in", values, "sinaLoginId");
			return (Criteria) this;
		}

		public Criteria andSinaLoginIdNotIn(List<String> values) {
			addCriterion("sina_login_id not in", values, "sinaLoginId");
			return (Criteria) this;
		}

		public Criteria andSinaLoginIdBetween(String value1, String value2) {
			addCriterion("sina_login_id between", value1, value2, "sinaLoginId");
			return (Criteria) this;
		}

		public Criteria andSinaLoginIdNotBetween(String value1, String value2) {
			addCriterion("sina_login_id not between", value1, value2, "sinaLoginId");
			return (Criteria) this;
		}

		public Criteria andSinaLoginKeyIsNull() {
			addCriterion("sina_login_key is null");
			return (Criteria) this;
		}

		public Criteria andSinaLoginKeyIsNotNull() {
			addCriterion("sina_login_key is not null");
			return (Criteria) this;
		}

		public Criteria andSinaLoginKeyEqualTo(String value) {
			addCriterion("sina_login_key =", value, "sinaLoginKey");
			return (Criteria) this;
		}

		public Criteria andSinaLoginKeyNotEqualTo(String value) {
			addCriterion("sina_login_key <>", value, "sinaLoginKey");
			return (Criteria) this;
		}

		public Criteria andSinaLoginKeyGreaterThan(String value) {
			addCriterion("sina_login_key >", value, "sinaLoginKey");
			return (Criteria) this;
		}

		public Criteria andSinaLoginKeyGreaterThanOrEqualTo(String value) {
			addCriterion("sina_login_key >=", value, "sinaLoginKey");
			return (Criteria) this;
		}

		public Criteria andSinaLoginKeyLessThan(String value) {
			addCriterion("sina_login_key <", value, "sinaLoginKey");
			return (Criteria) this;
		}

		public Criteria andSinaLoginKeyLessThanOrEqualTo(String value) {
			addCriterion("sina_login_key <=", value, "sinaLoginKey");
			return (Criteria) this;
		}

		public Criteria andSinaLoginKeyLike(String value) {
			addCriterion("sina_login_key like", value, "sinaLoginKey");
			return (Criteria) this;
		}

		public Criteria andSinaLoginKeyNotLike(String value) {
			addCriterion("sina_login_key not like", value, "sinaLoginKey");
			return (Criteria) this;
		}

		public Criteria andSinaLoginKeyIn(List<String> values) {
			addCriterion("sina_login_key in", values, "sinaLoginKey");
			return (Criteria) this;
		}

		public Criteria andSinaLoginKeyNotIn(List<String> values) {
			addCriterion("sina_login_key not in", values, "sinaLoginKey");
			return (Criteria) this;
		}

		public Criteria andSinaLoginKeyBetween(String value1, String value2) {
			addCriterion("sina_login_key between", value1, value2, "sinaLoginKey");
			return (Criteria) this;
		}

		public Criteria andSinaLoginKeyNotBetween(String value1, String value2) {
			addCriterion("sina_login_key not between", value1, value2, "sinaLoginKey");
			return (Criteria) this;
		}

		public Criteria andSmallHeightIsNull() {
			addCriterion("small_height is null");
			return (Criteria) this;
		}

		public Criteria andSmallHeightIsNotNull() {
			addCriterion("small_height is not null");
			return (Criteria) this;
		}

		public Criteria andSmallHeightEqualTo(Integer value) {
			addCriterion("small_height =", value, "smallHeight");
			return (Criteria) this;
		}

		public Criteria andSmallHeightNotEqualTo(Integer value) {
			addCriterion("small_height <>", value, "smallHeight");
			return (Criteria) this;
		}

		public Criteria andSmallHeightGreaterThan(Integer value) {
			addCriterion("small_height >", value, "smallHeight");
			return (Criteria) this;
		}

		public Criteria andSmallHeightGreaterThanOrEqualTo(Integer value) {
			addCriterion("small_height >=", value, "smallHeight");
			return (Criteria) this;
		}

		public Criteria andSmallHeightLessThan(Integer value) {
			addCriterion("small_height <", value, "smallHeight");
			return (Criteria) this;
		}

		public Criteria andSmallHeightLessThanOrEqualTo(Integer value) {
			addCriterion("small_height <=", value, "smallHeight");
			return (Criteria) this;
		}

		public Criteria andSmallHeightIn(List<Integer> values) {
			addCriterion("small_height in", values, "smallHeight");
			return (Criteria) this;
		}

		public Criteria andSmallHeightNotIn(List<Integer> values) {
			addCriterion("small_height not in", values, "smallHeight");
			return (Criteria) this;
		}

		public Criteria andSmallHeightBetween(Integer value1, Integer value2) {
			addCriterion("small_height between", value1, value2, "smallHeight");
			return (Criteria) this;
		}

		public Criteria andSmallHeightNotBetween(Integer value1, Integer value2) {
			addCriterion("small_height not between", value1, value2, "smallHeight");
			return (Criteria) this;
		}

		public Criteria andSmallWidthIsNull() {
			addCriterion("small_width is null");
			return (Criteria) this;
		}

		public Criteria andSmallWidthIsNotNull() {
			addCriterion("small_width is not null");
			return (Criteria) this;
		}

		public Criteria andSmallWidthEqualTo(Integer value) {
			addCriterion("small_width =", value, "smallWidth");
			return (Criteria) this;
		}

		public Criteria andSmallWidthNotEqualTo(Integer value) {
			addCriterion("small_width <>", value, "smallWidth");
			return (Criteria) this;
		}

		public Criteria andSmallWidthGreaterThan(Integer value) {
			addCriterion("small_width >", value, "smallWidth");
			return (Criteria) this;
		}

		public Criteria andSmallWidthGreaterThanOrEqualTo(Integer value) {
			addCriterion("small_width >=", value, "smallWidth");
			return (Criteria) this;
		}

		public Criteria andSmallWidthLessThan(Integer value) {
			addCriterion("small_width <", value, "smallWidth");
			return (Criteria) this;
		}

		public Criteria andSmallWidthLessThanOrEqualTo(Integer value) {
			addCriterion("small_width <=", value, "smallWidth");
			return (Criteria) this;
		}

		public Criteria andSmallWidthIn(List<Integer> values) {
			addCriterion("small_width in", values, "smallWidth");
			return (Criteria) this;
		}

		public Criteria andSmallWidthNotIn(List<Integer> values) {
			addCriterion("small_width not in", values, "smallWidth");
			return (Criteria) this;
		}

		public Criteria andSmallWidthBetween(Integer value1, Integer value2) {
			addCriterion("small_width between", value1, value2, "smallWidth");
			return (Criteria) this;
		}

		public Criteria andSmallWidthNotBetween(Integer value1, Integer value2) {
			addCriterion("small_width not between", value1, value2, "smallWidth");
			return (Criteria) this;
		}

		public Criteria andSmsEnbaleIsNull() {
			addCriterion("sms_enbale is null");
			return (Criteria) this;
		}

		public Criteria andSmsEnbaleIsNotNull() {
			addCriterion("sms_enbale is not null");
			return (Criteria) this;
		}

		public Criteria andSmsEnbaleEqualTo(Boolean value) {
			addCriterion("sms_enbale =", value, "smsEnbale");
			return (Criteria) this;
		}

		public Criteria andSmsEnbaleNotEqualTo(Boolean value) {
			addCriterion("sms_enbale <>", value, "smsEnbale");
			return (Criteria) this;
		}

		public Criteria andSmsEnbaleGreaterThan(Boolean value) {
			addCriterion("sms_enbale >", value, "smsEnbale");
			return (Criteria) this;
		}

		public Criteria andSmsEnbaleGreaterThanOrEqualTo(Boolean value) {
			addCriterion("sms_enbale >=", value, "smsEnbale");
			return (Criteria) this;
		}

		public Criteria andSmsEnbaleLessThan(Boolean value) {
			addCriterion("sms_enbale <", value, "smsEnbale");
			return (Criteria) this;
		}

		public Criteria andSmsEnbaleLessThanOrEqualTo(Boolean value) {
			addCriterion("sms_enbale <=", value, "smsEnbale");
			return (Criteria) this;
		}

		public Criteria andSmsEnbaleIn(List<Boolean> values) {
			addCriterion("sms_enbale in", values, "smsEnbale");
			return (Criteria) this;
		}

		public Criteria andSmsEnbaleNotIn(List<Boolean> values) {
			addCriterion("sms_enbale not in", values, "smsEnbale");
			return (Criteria) this;
		}

		public Criteria andSmsEnbaleBetween(Boolean value1, Boolean value2) {
			addCriterion("sms_enbale between", value1, value2, "smsEnbale");
			return (Criteria) this;
		}

		public Criteria andSmsEnbaleNotBetween(Boolean value1, Boolean value2) {
			addCriterion("sms_enbale not between", value1, value2, "smsEnbale");
			return (Criteria) this;
		}

		public Criteria andSmsPasswordIsNull() {
			addCriterion("sms_password is null");
			return (Criteria) this;
		}

		public Criteria andSmsPasswordIsNotNull() {
			addCriterion("sms_password is not null");
			return (Criteria) this;
		}

		public Criteria andSmsPasswordEqualTo(String value) {
			addCriterion("sms_password =", value, "smsPassword");
			return (Criteria) this;
		}

		public Criteria andSmsPasswordNotEqualTo(String value) {
			addCriterion("sms_password <>", value, "smsPassword");
			return (Criteria) this;
		}

		public Criteria andSmsPasswordGreaterThan(String value) {
			addCriterion("sms_password >", value, "smsPassword");
			return (Criteria) this;
		}

		public Criteria andSmsPasswordGreaterThanOrEqualTo(String value) {
			addCriterion("sms_password >=", value, "smsPassword");
			return (Criteria) this;
		}

		public Criteria andSmsPasswordLessThan(String value) {
			addCriterion("sms_password <", value, "smsPassword");
			return (Criteria) this;
		}

		public Criteria andSmsPasswordLessThanOrEqualTo(String value) {
			addCriterion("sms_password <=", value, "smsPassword");
			return (Criteria) this;
		}

		public Criteria andSmsPasswordLike(String value) {
			addCriterion("sms_password like", value, "smsPassword");
			return (Criteria) this;
		}

		public Criteria andSmsPasswordNotLike(String value) {
			addCriterion("sms_password not like", value, "smsPassword");
			return (Criteria) this;
		}

		public Criteria andSmsPasswordIn(List<String> values) {
			addCriterion("sms_password in", values, "smsPassword");
			return (Criteria) this;
		}

		public Criteria andSmsPasswordNotIn(List<String> values) {
			addCriterion("sms_password not in", values, "smsPassword");
			return (Criteria) this;
		}

		public Criteria andSmsPasswordBetween(String value1, String value2) {
			addCriterion("sms_password between", value1, value2, "smsPassword");
			return (Criteria) this;
		}

		public Criteria andSmsPasswordNotBetween(String value1, String value2) {
			addCriterion("sms_password not between", value1, value2, "smsPassword");
			return (Criteria) this;
		}

		public Criteria andSmsTestIsNull() {
			addCriterion("sms_test is null");
			return (Criteria) this;
		}

		public Criteria andSmsTestIsNotNull() {
			addCriterion("sms_test is not null");
			return (Criteria) this;
		}

		public Criteria andSmsTestEqualTo(String value) {
			addCriterion("sms_test =", value, "smsTest");
			return (Criteria) this;
		}

		public Criteria andSmsTestNotEqualTo(String value) {
			addCriterion("sms_test <>", value, "smsTest");
			return (Criteria) this;
		}

		public Criteria andSmsTestGreaterThan(String value) {
			addCriterion("sms_test >", value, "smsTest");
			return (Criteria) this;
		}

		public Criteria andSmsTestGreaterThanOrEqualTo(String value) {
			addCriterion("sms_test >=", value, "smsTest");
			return (Criteria) this;
		}

		public Criteria andSmsTestLessThan(String value) {
			addCriterion("sms_test <", value, "smsTest");
			return (Criteria) this;
		}

		public Criteria andSmsTestLessThanOrEqualTo(String value) {
			addCriterion("sms_test <=", value, "smsTest");
			return (Criteria) this;
		}

		public Criteria andSmsTestLike(String value) {
			addCriterion("sms_test like", value, "smsTest");
			return (Criteria) this;
		}

		public Criteria andSmsTestNotLike(String value) {
			addCriterion("sms_test not like", value, "smsTest");
			return (Criteria) this;
		}

		public Criteria andSmsTestIn(List<String> values) {
			addCriterion("sms_test in", values, "smsTest");
			return (Criteria) this;
		}

		public Criteria andSmsTestNotIn(List<String> values) {
			addCriterion("sms_test not in", values, "smsTest");
			return (Criteria) this;
		}

		public Criteria andSmsTestBetween(String value1, String value2) {
			addCriterion("sms_test between", value1, value2, "smsTest");
			return (Criteria) this;
		}

		public Criteria andSmsTestNotBetween(String value1, String value2) {
			addCriterion("sms_test not between", value1, value2, "smsTest");
			return (Criteria) this;
		}

		public Criteria andSmsUrlIsNull() {
			addCriterion("sms_URL is null");
			return (Criteria) this;
		}

		public Criteria andSmsUrlIsNotNull() {
			addCriterion("sms_URL is not null");
			return (Criteria) this;
		}

		public Criteria andSmsUrlEqualTo(String value) {
			addCriterion("sms_URL =", value, "smsUrl");
			return (Criteria) this;
		}

		public Criteria andSmsUrlNotEqualTo(String value) {
			addCriterion("sms_URL <>", value, "smsUrl");
			return (Criteria) this;
		}

		public Criteria andSmsUrlGreaterThan(String value) {
			addCriterion("sms_URL >", value, "smsUrl");
			return (Criteria) this;
		}

		public Criteria andSmsUrlGreaterThanOrEqualTo(String value) {
			addCriterion("sms_URL >=", value, "smsUrl");
			return (Criteria) this;
		}

		public Criteria andSmsUrlLessThan(String value) {
			addCriterion("sms_URL <", value, "smsUrl");
			return (Criteria) this;
		}

		public Criteria andSmsUrlLessThanOrEqualTo(String value) {
			addCriterion("sms_URL <=", value, "smsUrl");
			return (Criteria) this;
		}

		public Criteria andSmsUrlLike(String value) {
			addCriterion("sms_URL like", value, "smsUrl");
			return (Criteria) this;
		}

		public Criteria andSmsUrlNotLike(String value) {
			addCriterion("sms_URL not like", value, "smsUrl");
			return (Criteria) this;
		}

		public Criteria andSmsUrlIn(List<String> values) {
			addCriterion("sms_URL in", values, "smsUrl");
			return (Criteria) this;
		}

		public Criteria andSmsUrlNotIn(List<String> values) {
			addCriterion("sms_URL not in", values, "smsUrl");
			return (Criteria) this;
		}

		public Criteria andSmsUrlBetween(String value1, String value2) {
			addCriterion("sms_URL between", value1, value2, "smsUrl");
			return (Criteria) this;
		}

		public Criteria andSmsUrlNotBetween(String value1, String value2) {
			addCriterion("sms_URL not between", value1, value2, "smsUrl");
			return (Criteria) this;
		}

		public Criteria andSmsUserNameIsNull() {
			addCriterion("sms_user_name is null");
			return (Criteria) this;
		}

		public Criteria andSmsUserNameIsNotNull() {
			addCriterion("sms_user_name is not null");
			return (Criteria) this;
		}

		public Criteria andSmsUserNameEqualTo(String value) {
			addCriterion("sms_user_name =", value, "smsUserName");
			return (Criteria) this;
		}

		public Criteria andSmsUserNameNotEqualTo(String value) {
			addCriterion("sms_user_name <>", value, "smsUserName");
			return (Criteria) this;
		}

		public Criteria andSmsUserNameGreaterThan(String value) {
			addCriterion("sms_user_name >", value, "smsUserName");
			return (Criteria) this;
		}

		public Criteria andSmsUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("sms_user_name >=", value, "smsUserName");
			return (Criteria) this;
		}

		public Criteria andSmsUserNameLessThan(String value) {
			addCriterion("sms_user_name <", value, "smsUserName");
			return (Criteria) this;
		}

		public Criteria andSmsUserNameLessThanOrEqualTo(String value) {
			addCriterion("sms_user_name <=", value, "smsUserName");
			return (Criteria) this;
		}

		public Criteria andSmsUserNameLike(String value) {
			addCriterion("sms_user_name like", value, "smsUserName");
			return (Criteria) this;
		}

		public Criteria andSmsUserNameNotLike(String value) {
			addCriterion("sms_user_name not like", value, "smsUserName");
			return (Criteria) this;
		}

		public Criteria andSmsUserNameIn(List<String> values) {
			addCriterion("sms_user_name in", values, "smsUserName");
			return (Criteria) this;
		}

		public Criteria andSmsUserNameNotIn(List<String> values) {
			addCriterion("sms_user_name not in", values, "smsUserName");
			return (Criteria) this;
		}

		public Criteria andSmsUserNameBetween(String value1, String value2) {
			addCriterion("sms_user_name between", value1, value2, "smsUserName");
			return (Criteria) this;
		}

		public Criteria andSmsUserNameNotBetween(String value1, String value2) {
			addCriterion("sms_user_name not between", value1, value2, "smsUserName");
			return (Criteria) this;
		}

		public Criteria andSmsBuyIsNull() {
			addCriterion("sms_buy is null");
			return (Criteria) this;
		}

		public Criteria andSmsBuyIsNotNull() {
			addCriterion("sms_buy is not null");
			return (Criteria) this;
		}

		public Criteria andSmsBuyEqualTo(Integer value) {
			addCriterion("sms_buy =", value, "smsBuy");
			return (Criteria) this;
		}

		public Criteria andSmsBuyNotEqualTo(Integer value) {
			addCriterion("sms_buy <>", value, "smsBuy");
			return (Criteria) this;
		}

		public Criteria andSmsBuyGreaterThan(Integer value) {
			addCriterion("sms_buy >", value, "smsBuy");
			return (Criteria) this;
		}

		public Criteria andSmsBuyGreaterThanOrEqualTo(Integer value) {
			addCriterion("sms_buy >=", value, "smsBuy");
			return (Criteria) this;
		}

		public Criteria andSmsBuyLessThan(Integer value) {
			addCriterion("sms_buy <", value, "smsBuy");
			return (Criteria) this;
		}

		public Criteria andSmsBuyLessThanOrEqualTo(Integer value) {
			addCriterion("sms_buy <=", value, "smsBuy");
			return (Criteria) this;
		}

		public Criteria andSmsBuyIn(List<Integer> values) {
			addCriterion("sms_buy in", values, "smsBuy");
			return (Criteria) this;
		}

		public Criteria andSmsBuyNotIn(List<Integer> values) {
			addCriterion("sms_buy not in", values, "smsBuy");
			return (Criteria) this;
		}

		public Criteria andSmsBuyBetween(Integer value1, Integer value2) {
			addCriterion("sms_buy between", value1, value2, "smsBuy");
			return (Criteria) this;
		}

		public Criteria andSmsBuyNotBetween(Integer value1, Integer value2) {
			addCriterion("sms_buy not between", value1, value2, "smsBuy");
			return (Criteria) this;
		}

		public Criteria andSmsBuyCostIsNull() {
			addCriterion("sms_buy_cost is null");
			return (Criteria) this;
		}

		public Criteria andSmsBuyCostIsNotNull() {
			addCriterion("sms_buy_cost is not null");
			return (Criteria) this;
		}

		public Criteria andSmsBuyCostEqualTo(Integer value) {
			addCriterion("sms_buy_cost =", value, "smsBuyCost");
			return (Criteria) this;
		}

		public Criteria andSmsBuyCostNotEqualTo(Integer value) {
			addCriterion("sms_buy_cost <>", value, "smsBuyCost");
			return (Criteria) this;
		}

		public Criteria andSmsBuyCostGreaterThan(Integer value) {
			addCriterion("sms_buy_cost >", value, "smsBuyCost");
			return (Criteria) this;
		}

		public Criteria andSmsBuyCostGreaterThanOrEqualTo(Integer value) {
			addCriterion("sms_buy_cost >=", value, "smsBuyCost");
			return (Criteria) this;
		}

		public Criteria andSmsBuyCostLessThan(Integer value) {
			addCriterion("sms_buy_cost <", value, "smsBuyCost");
			return (Criteria) this;
		}

		public Criteria andSmsBuyCostLessThanOrEqualTo(Integer value) {
			addCriterion("sms_buy_cost <=", value, "smsBuyCost");
			return (Criteria) this;
		}

		public Criteria andSmsBuyCostIn(List<Integer> values) {
			addCriterion("sms_buy_cost in", values, "smsBuyCost");
			return (Criteria) this;
		}

		public Criteria andSmsBuyCostNotIn(List<Integer> values) {
			addCriterion("sms_buy_cost not in", values, "smsBuyCost");
			return (Criteria) this;
		}

		public Criteria andSmsBuyCostBetween(Integer value1, Integer value2) {
			addCriterion("sms_buy_cost between", value1, value2, "smsBuyCost");
			return (Criteria) this;
		}

		public Criteria andSmsBuyCostNotBetween(Integer value1, Integer value2) {
			addCriterion("sms_buy_cost not between", value1, value2, "smsBuyCost");
			return (Criteria) this;
		}

		public Criteria andSmsQueueIsNull() {
			addCriterion("sms_queue is null");
			return (Criteria) this;
		}

		public Criteria andSmsQueueIsNotNull() {
			addCriterion("sms_queue is not null");
			return (Criteria) this;
		}

		public Criteria andSmsQueueEqualTo(Integer value) {
			addCriterion("sms_queue =", value, "smsQueue");
			return (Criteria) this;
		}

		public Criteria andSmsQueueNotEqualTo(Integer value) {
			addCriterion("sms_queue <>", value, "smsQueue");
			return (Criteria) this;
		}

		public Criteria andSmsQueueGreaterThan(Integer value) {
			addCriterion("sms_queue >", value, "smsQueue");
			return (Criteria) this;
		}

		public Criteria andSmsQueueGreaterThanOrEqualTo(Integer value) {
			addCriterion("sms_queue >=", value, "smsQueue");
			return (Criteria) this;
		}

		public Criteria andSmsQueueLessThan(Integer value) {
			addCriterion("sms_queue <", value, "smsQueue");
			return (Criteria) this;
		}

		public Criteria andSmsQueueLessThanOrEqualTo(Integer value) {
			addCriterion("sms_queue <=", value, "smsQueue");
			return (Criteria) this;
		}

		public Criteria andSmsQueueIn(List<Integer> values) {
			addCriterion("sms_queue in", values, "smsQueue");
			return (Criteria) this;
		}

		public Criteria andSmsQueueNotIn(List<Integer> values) {
			addCriterion("sms_queue not in", values, "smsQueue");
			return (Criteria) this;
		}

		public Criteria andSmsQueueBetween(Integer value1, Integer value2) {
			addCriterion("sms_queue between", value1, value2, "smsQueue");
			return (Criteria) this;
		}

		public Criteria andSmsQueueNotBetween(Integer value1, Integer value2) {
			addCriterion("sms_queue not between", value1, value2, "smsQueue");
			return (Criteria) this;
		}

		public Criteria andStoreAllowIsNull() {
			addCriterion("store_allow is null");
			return (Criteria) this;
		}

		public Criteria andStoreAllowIsNotNull() {
			addCriterion("store_allow is not null");
			return (Criteria) this;
		}

		public Criteria andStoreAllowEqualTo(Boolean value) {
			addCriterion("store_allow =", value, "storeAllow");
			return (Criteria) this;
		}

		public Criteria andStoreAllowNotEqualTo(Boolean value) {
			addCriterion("store_allow <>", value, "storeAllow");
			return (Criteria) this;
		}

		public Criteria andStoreAllowGreaterThan(Boolean value) {
			addCriterion("store_allow >", value, "storeAllow");
			return (Criteria) this;
		}

		public Criteria andStoreAllowGreaterThanOrEqualTo(Boolean value) {
			addCriterion("store_allow >=", value, "storeAllow");
			return (Criteria) this;
		}

		public Criteria andStoreAllowLessThan(Boolean value) {
			addCriterion("store_allow <", value, "storeAllow");
			return (Criteria) this;
		}

		public Criteria andStoreAllowLessThanOrEqualTo(Boolean value) {
			addCriterion("store_allow <=", value, "storeAllow");
			return (Criteria) this;
		}

		public Criteria andStoreAllowIn(List<Boolean> values) {
			addCriterion("store_allow in", values, "storeAllow");
			return (Criteria) this;
		}

		public Criteria andStoreAllowNotIn(List<Boolean> values) {
			addCriterion("store_allow not in", values, "storeAllow");
			return (Criteria) this;
		}

		public Criteria andStoreAllowBetween(Boolean value1, Boolean value2) {
			addCriterion("store_allow between", value1, value2, "storeAllow");
			return (Criteria) this;
		}

		public Criteria andStoreAllowNotBetween(Boolean value1, Boolean value2) {
			addCriterion("store_allow not between", value1, value2, "storeAllow");
			return (Criteria) this;
		}

		public Criteria andSysLanguageIsNull() {
			addCriterion("sys_language is null");
			return (Criteria) this;
		}

		public Criteria andSysLanguageIsNotNull() {
			addCriterion("sys_language is not null");
			return (Criteria) this;
		}

		public Criteria andSysLanguageEqualTo(String value) {
			addCriterion("sys_language =", value, "sysLanguage");
			return (Criteria) this;
		}

		public Criteria andSysLanguageNotEqualTo(String value) {
			addCriterion("sys_language <>", value, "sysLanguage");
			return (Criteria) this;
		}

		public Criteria andSysLanguageGreaterThan(String value) {
			addCriterion("sys_language >", value, "sysLanguage");
			return (Criteria) this;
		}

		public Criteria andSysLanguageGreaterThanOrEqualTo(String value) {
			addCriterion("sys_language >=", value, "sysLanguage");
			return (Criteria) this;
		}

		public Criteria andSysLanguageLessThan(String value) {
			addCriterion("sys_language <", value, "sysLanguage");
			return (Criteria) this;
		}

		public Criteria andSysLanguageLessThanOrEqualTo(String value) {
			addCriterion("sys_language <=", value, "sysLanguage");
			return (Criteria) this;
		}

		public Criteria andSysLanguageLike(String value) {
			addCriterion("sys_language like", value, "sysLanguage");
			return (Criteria) this;
		}

		public Criteria andSysLanguageNotLike(String value) {
			addCriterion("sys_language not like", value, "sysLanguage");
			return (Criteria) this;
		}

		public Criteria andSysLanguageIn(List<String> values) {
			addCriterion("sys_language in", values, "sysLanguage");
			return (Criteria) this;
		}

		public Criteria andSysLanguageNotIn(List<String> values) {
			addCriterion("sys_language not in", values, "sysLanguage");
			return (Criteria) this;
		}

		public Criteria andSysLanguageBetween(String value1, String value2) {
			addCriterion("sys_language between", value1, value2, "sysLanguage");
			return (Criteria) this;
		}

		public Criteria andSysLanguageNotBetween(String value1, String value2) {
			addCriterion("sys_language not between", value1, value2, "sysLanguage");
			return (Criteria) this;
		}

		public Criteria andTitleIsNull() {
			addCriterion("title is null");
			return (Criteria) this;
		}

		public Criteria andTitleIsNotNull() {
			addCriterion("title is not null");
			return (Criteria) this;
		}

		public Criteria andTitleEqualTo(String value) {
			addCriterion("title =", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotEqualTo(String value) {
			addCriterion("title <>", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThan(String value) {
			addCriterion("title >", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThanOrEqualTo(String value) {
			addCriterion("title >=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThan(String value) {
			addCriterion("title <", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThanOrEqualTo(String value) {
			addCriterion("title <=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLike(String value) {
			addCriterion("title like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotLike(String value) {
			addCriterion("title not like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleIn(List<String> values) {
			addCriterion("title in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotIn(List<String> values) {
			addCriterion("title not in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleBetween(String value1, String value2) {
			addCriterion("title between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotBetween(String value1, String value2) {
			addCriterion("title not between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andUploadFilePathIsNull() {
			addCriterion("upload_file_path is null");
			return (Criteria) this;
		}

		public Criteria andUploadFilePathIsNotNull() {
			addCriterion("upload_file_path is not null");
			return (Criteria) this;
		}

		public Criteria andUploadFilePathEqualTo(String value) {
			addCriterion("upload_file_path =", value, "uploadFilePath");
			return (Criteria) this;
		}

		public Criteria andUploadFilePathNotEqualTo(String value) {
			addCriterion("upload_file_path <>", value, "uploadFilePath");
			return (Criteria) this;
		}

		public Criteria andUploadFilePathGreaterThan(String value) {
			addCriterion("upload_file_path >", value, "uploadFilePath");
			return (Criteria) this;
		}

		public Criteria andUploadFilePathGreaterThanOrEqualTo(String value) {
			addCriterion("upload_file_path >=", value, "uploadFilePath");
			return (Criteria) this;
		}

		public Criteria andUploadFilePathLessThan(String value) {
			addCriterion("upload_file_path <", value, "uploadFilePath");
			return (Criteria) this;
		}

		public Criteria andUploadFilePathLessThanOrEqualTo(String value) {
			addCriterion("upload_file_path <=", value, "uploadFilePath");
			return (Criteria) this;
		}

		public Criteria andUploadFilePathLike(String value) {
			addCriterion("upload_file_path like", value, "uploadFilePath");
			return (Criteria) this;
		}

		public Criteria andUploadFilePathNotLike(String value) {
			addCriterion("upload_file_path not like", value, "uploadFilePath");
			return (Criteria) this;
		}

		public Criteria andUploadFilePathIn(List<String> values) {
			addCriterion("upload_file_path in", values, "uploadFilePath");
			return (Criteria) this;
		}

		public Criteria andUploadFilePathNotIn(List<String> values) {
			addCriterion("upload_file_path not in", values, "uploadFilePath");
			return (Criteria) this;
		}

		public Criteria andUploadFilePathBetween(String value1, String value2) {
			addCriterion("upload_file_path between", value1, value2, "uploadFilePath");
			return (Criteria) this;
		}

		public Criteria andUploadFilePathNotBetween(String value1, String value2) {
			addCriterion("upload_file_path not between", value1, value2, "uploadFilePath");
			return (Criteria) this;
		}

		public Criteria andVisitorConsultIsNull() {
			addCriterion("visitor_consult is null");
			return (Criteria) this;
		}

		public Criteria andVisitorConsultIsNotNull() {
			addCriterion("visitor_consult is not null");
			return (Criteria) this;
		}

		public Criteria andVisitorConsultEqualTo(Boolean value) {
			addCriterion("visitor_consult =", value, "visitorConsult");
			return (Criteria) this;
		}

		public Criteria andVisitorConsultNotEqualTo(Boolean value) {
			addCriterion("visitor_consult <>", value, "visitorConsult");
			return (Criteria) this;
		}

		public Criteria andVisitorConsultGreaterThan(Boolean value) {
			addCriterion("visitor_consult >", value, "visitorConsult");
			return (Criteria) this;
		}

		public Criteria andVisitorConsultGreaterThanOrEqualTo(Boolean value) {
			addCriterion("visitor_consult >=", value, "visitorConsult");
			return (Criteria) this;
		}

		public Criteria andVisitorConsultLessThan(Boolean value) {
			addCriterion("visitor_consult <", value, "visitorConsult");
			return (Criteria) this;
		}

		public Criteria andVisitorConsultLessThanOrEqualTo(Boolean value) {
			addCriterion("visitor_consult <=", value, "visitorConsult");
			return (Criteria) this;
		}

		public Criteria andVisitorConsultIn(List<Boolean> values) {
			addCriterion("visitor_consult in", values, "visitorConsult");
			return (Criteria) this;
		}

		public Criteria andVisitorConsultNotIn(List<Boolean> values) {
			addCriterion("visitor_consult not in", values, "visitorConsult");
			return (Criteria) this;
		}

		public Criteria andVisitorConsultBetween(Boolean value1, Boolean value2) {
			addCriterion("visitor_consult between", value1, value2, "visitorConsult");
			return (Criteria) this;
		}

		public Criteria andVisitorConsultNotBetween(Boolean value1, Boolean value2) {
			addCriterion("visitor_consult not between", value1, value2, "visitorConsult");
			return (Criteria) this;
		}

		public Criteria andVoucherIsNull() {
			addCriterion("voucher is null");
			return (Criteria) this;
		}

		public Criteria andVoucherIsNotNull() {
			addCriterion("voucher is not null");
			return (Criteria) this;
		}

		public Criteria andVoucherEqualTo(Boolean value) {
			addCriterion("voucher =", value, "voucher");
			return (Criteria) this;
		}

		public Criteria andVoucherNotEqualTo(Boolean value) {
			addCriterion("voucher <>", value, "voucher");
			return (Criteria) this;
		}

		public Criteria andVoucherGreaterThan(Boolean value) {
			addCriterion("voucher >", value, "voucher");
			return (Criteria) this;
		}

		public Criteria andVoucherGreaterThanOrEqualTo(Boolean value) {
			addCriterion("voucher >=", value, "voucher");
			return (Criteria) this;
		}

		public Criteria andVoucherLessThan(Boolean value) {
			addCriterion("voucher <", value, "voucher");
			return (Criteria) this;
		}

		public Criteria andVoucherLessThanOrEqualTo(Boolean value) {
			addCriterion("voucher <=", value, "voucher");
			return (Criteria) this;
		}

		public Criteria andVoucherIn(List<Boolean> values) {
			addCriterion("voucher in", values, "voucher");
			return (Criteria) this;
		}

		public Criteria andVoucherNotIn(List<Boolean> values) {
			addCriterion("voucher not in", values, "voucher");
			return (Criteria) this;
		}

		public Criteria andVoucherBetween(Boolean value1, Boolean value2) {
			addCriterion("voucher between", value1, value2, "voucher");
			return (Criteria) this;
		}

		public Criteria andVoucherNotBetween(Boolean value1, Boolean value2) {
			addCriterion("voucher not between", value1, value2, "voucher");
			return (Criteria) this;
		}

		public Criteria andWebsiteCssIsNull() {
			addCriterion("website_css is null");
			return (Criteria) this;
		}

		public Criteria andWebsiteCssIsNotNull() {
			addCriterion("website_css is not null");
			return (Criteria) this;
		}

		public Criteria andWebsiteCssEqualTo(String value) {
			addCriterion("website_css =", value, "websiteCss");
			return (Criteria) this;
		}

		public Criteria andWebsiteCssNotEqualTo(String value) {
			addCriterion("website_css <>", value, "websiteCss");
			return (Criteria) this;
		}

		public Criteria andWebsiteCssGreaterThan(String value) {
			addCriterion("website_css >", value, "websiteCss");
			return (Criteria) this;
		}

		public Criteria andWebsiteCssGreaterThanOrEqualTo(String value) {
			addCriterion("website_css >=", value, "websiteCss");
			return (Criteria) this;
		}

		public Criteria andWebsiteCssLessThan(String value) {
			addCriterion("website_css <", value, "websiteCss");
			return (Criteria) this;
		}

		public Criteria andWebsiteCssLessThanOrEqualTo(String value) {
			addCriterion("website_css <=", value, "websiteCss");
			return (Criteria) this;
		}

		public Criteria andWebsiteCssLike(String value) {
			addCriterion("website_css like", value, "websiteCss");
			return (Criteria) this;
		}

		public Criteria andWebsiteCssNotLike(String value) {
			addCriterion("website_css not like", value, "websiteCss");
			return (Criteria) this;
		}

		public Criteria andWebsiteCssIn(List<String> values) {
			addCriterion("website_css in", values, "websiteCss");
			return (Criteria) this;
		}

		public Criteria andWebsiteCssNotIn(List<String> values) {
			addCriterion("website_css not in", values, "websiteCss");
			return (Criteria) this;
		}

		public Criteria andWebsiteCssBetween(String value1, String value2) {
			addCriterion("website_css between", value1, value2, "websiteCss");
			return (Criteria) this;
		}

		public Criteria andWebsiteCssNotBetween(String value1, String value2) {
			addCriterion("website_css not between", value1, value2, "websiteCss");
			return (Criteria) this;
		}

		public Criteria andWebsiteNameIsNull() {
			addCriterion("website_name is null");
			return (Criteria) this;
		}

		public Criteria andWebsiteNameIsNotNull() {
			addCriterion("website_name is not null");
			return (Criteria) this;
		}

		public Criteria andWebsiteNameEqualTo(String value) {
			addCriterion("website_name =", value, "websiteName");
			return (Criteria) this;
		}

		public Criteria andWebsiteNameNotEqualTo(String value) {
			addCriterion("website_name <>", value, "websiteName");
			return (Criteria) this;
		}

		public Criteria andWebsiteNameGreaterThan(String value) {
			addCriterion("website_name >", value, "websiteName");
			return (Criteria) this;
		}

		public Criteria andWebsiteNameGreaterThanOrEqualTo(String value) {
			addCriterion("website_name >=", value, "websiteName");
			return (Criteria) this;
		}

		public Criteria andWebsiteNameLessThan(String value) {
			addCriterion("website_name <", value, "websiteName");
			return (Criteria) this;
		}

		public Criteria andWebsiteNameLessThanOrEqualTo(String value) {
			addCriterion("website_name <=", value, "websiteName");
			return (Criteria) this;
		}

		public Criteria andWebsiteNameLike(String value) {
			addCriterion("website_name like", value, "websiteName");
			return (Criteria) this;
		}

		public Criteria andWebsiteNameNotLike(String value) {
			addCriterion("website_name not like", value, "websiteName");
			return (Criteria) this;
		}

		public Criteria andWebsiteNameIn(List<String> values) {
			addCriterion("website_name in", values, "websiteName");
			return (Criteria) this;
		}

		public Criteria andWebsiteNameNotIn(List<String> values) {
			addCriterion("website_name not in", values, "websiteName");
			return (Criteria) this;
		}

		public Criteria andWebsiteNameBetween(String value1, String value2) {
			addCriterion("website_name between", value1, value2, "websiteName");
			return (Criteria) this;
		}

		public Criteria andWebsiteNameNotBetween(String value1, String value2) {
			addCriterion("website_name not between", value1, value2, "websiteName");
			return (Criteria) this;
		}

		public Criteria andWebsiteStateIsNull() {
			addCriterion("website_state is null");
			return (Criteria) this;
		}

		public Criteria andWebsiteStateIsNotNull() {
			addCriterion("website_state is not null");
			return (Criteria) this;
		}

		public Criteria andWebsiteStateEqualTo(Boolean value) {
			addCriterion("website_state =", value, "websiteState");
			return (Criteria) this;
		}

		public Criteria andWebsiteStateNotEqualTo(Boolean value) {
			addCriterion("website_state <>", value, "websiteState");
			return (Criteria) this;
		}

		public Criteria andWebsiteStateGreaterThan(Boolean value) {
			addCriterion("website_state >", value, "websiteState");
			return (Criteria) this;
		}

		public Criteria andWebsiteStateGreaterThanOrEqualTo(Boolean value) {
			addCriterion("website_state >=", value, "websiteState");
			return (Criteria) this;
		}

		public Criteria andWebsiteStateLessThan(Boolean value) {
			addCriterion("website_state <", value, "websiteState");
			return (Criteria) this;
		}

		public Criteria andWebsiteStateLessThanOrEqualTo(Boolean value) {
			addCriterion("website_state <=", value, "websiteState");
			return (Criteria) this;
		}

		public Criteria andWebsiteStateIn(List<Boolean> values) {
			addCriterion("website_state in", values, "websiteState");
			return (Criteria) this;
		}

		public Criteria andWebsiteStateNotIn(List<Boolean> values) {
			addCriterion("website_state not in", values, "websiteState");
			return (Criteria) this;
		}

		public Criteria andWebsiteStateBetween(Boolean value1, Boolean value2) {
			addCriterion("website_state between", value1, value2, "websiteState");
			return (Criteria) this;
		}

		public Criteria andWebsiteStateNotBetween(Boolean value1, Boolean value2) {
			addCriterion("website_state not between", value1, value2, "websiteState");
			return (Criteria) this;
		}

		public Criteria andWeixinAccountIsNull() {
			addCriterion("weixin_account is null");
			return (Criteria) this;
		}

		public Criteria andWeixinAccountIsNotNull() {
			addCriterion("weixin_account is not null");
			return (Criteria) this;
		}

		public Criteria andWeixinAccountEqualTo(String value) {
			addCriterion("weixin_account =", value, "weixinAccount");
			return (Criteria) this;
		}

		public Criteria andWeixinAccountNotEqualTo(String value) {
			addCriterion("weixin_account <>", value, "weixinAccount");
			return (Criteria) this;
		}

		public Criteria andWeixinAccountGreaterThan(String value) {
			addCriterion("weixin_account >", value, "weixinAccount");
			return (Criteria) this;
		}

		public Criteria andWeixinAccountGreaterThanOrEqualTo(String value) {
			addCriterion("weixin_account >=", value, "weixinAccount");
			return (Criteria) this;
		}

		public Criteria andWeixinAccountLessThan(String value) {
			addCriterion("weixin_account <", value, "weixinAccount");
			return (Criteria) this;
		}

		public Criteria andWeixinAccountLessThanOrEqualTo(String value) {
			addCriterion("weixin_account <=", value, "weixinAccount");
			return (Criteria) this;
		}

		public Criteria andWeixinAccountLike(String value) {
			addCriterion("weixin_account like", value, "weixinAccount");
			return (Criteria) this;
		}

		public Criteria andWeixinAccountNotLike(String value) {
			addCriterion("weixin_account not like", value, "weixinAccount");
			return (Criteria) this;
		}

		public Criteria andWeixinAccountIn(List<String> values) {
			addCriterion("weixin_account in", values, "weixinAccount");
			return (Criteria) this;
		}

		public Criteria andWeixinAccountNotIn(List<String> values) {
			addCriterion("weixin_account not in", values, "weixinAccount");
			return (Criteria) this;
		}

		public Criteria andWeixinAccountBetween(String value1, String value2) {
			addCriterion("weixin_account between", value1, value2, "weixinAccount");
			return (Criteria) this;
		}

		public Criteria andWeixinAccountNotBetween(String value1, String value2) {
			addCriterion("weixin_account not between", value1, value2, "weixinAccount");
			return (Criteria) this;
		}

		public Criteria andWeixinAppIdIsNull() {
			addCriterion("weixin_app_id is null");
			return (Criteria) this;
		}

		public Criteria andWeixinAppIdIsNotNull() {
			addCriterion("weixin_app_id is not null");
			return (Criteria) this;
		}

		public Criteria andWeixinAppIdEqualTo(String value) {
			addCriterion("weixin_app_id =", value, "weixinAppId");
			return (Criteria) this;
		}

		public Criteria andWeixinAppIdNotEqualTo(String value) {
			addCriterion("weixin_app_id <>", value, "weixinAppId");
			return (Criteria) this;
		}

		public Criteria andWeixinAppIdGreaterThan(String value) {
			addCriterion("weixin_app_id >", value, "weixinAppId");
			return (Criteria) this;
		}

		public Criteria andWeixinAppIdGreaterThanOrEqualTo(String value) {
			addCriterion("weixin_app_id >=", value, "weixinAppId");
			return (Criteria) this;
		}

		public Criteria andWeixinAppIdLessThan(String value) {
			addCriterion("weixin_app_id <", value, "weixinAppId");
			return (Criteria) this;
		}

		public Criteria andWeixinAppIdLessThanOrEqualTo(String value) {
			addCriterion("weixin_app_id <=", value, "weixinAppId");
			return (Criteria) this;
		}

		public Criteria andWeixinAppIdLike(String value) {
			addCriterion("weixin_app_id like", value, "weixinAppId");
			return (Criteria) this;
		}

		public Criteria andWeixinAppIdNotLike(String value) {
			addCriterion("weixin_app_id not like", value, "weixinAppId");
			return (Criteria) this;
		}

		public Criteria andWeixinAppIdIn(List<String> values) {
			addCriterion("weixin_app_id in", values, "weixinAppId");
			return (Criteria) this;
		}

		public Criteria andWeixinAppIdNotIn(List<String> values) {
			addCriterion("weixin_app_id not in", values, "weixinAppId");
			return (Criteria) this;
		}

		public Criteria andWeixinAppIdBetween(String value1, String value2) {
			addCriterion("weixin_app_id between", value1, value2, "weixinAppId");
			return (Criteria) this;
		}

		public Criteria andWeixinAppIdNotBetween(String value1, String value2) {
			addCriterion("weixin_app_id not between", value1, value2, "weixinAppId");
			return (Criteria) this;
		}

		public Criteria andWeixinAppSecretIsNull() {
			addCriterion("weixin_app_secret is null");
			return (Criteria) this;
		}

		public Criteria andWeixinAppSecretIsNotNull() {
			addCriterion("weixin_app_secret is not null");
			return (Criteria) this;
		}

		public Criteria andWeixinAppSecretEqualTo(String value) {
			addCriterion("weixin_app_secret =", value, "weixinAppSecret");
			return (Criteria) this;
		}

		public Criteria andWeixinAppSecretNotEqualTo(String value) {
			addCriterion("weixin_app_secret <>", value, "weixinAppSecret");
			return (Criteria) this;
		}

		public Criteria andWeixinAppSecretGreaterThan(String value) {
			addCriterion("weixin_app_secret >", value, "weixinAppSecret");
			return (Criteria) this;
		}

		public Criteria andWeixinAppSecretGreaterThanOrEqualTo(String value) {
			addCriterion("weixin_app_secret >=", value, "weixinAppSecret");
			return (Criteria) this;
		}

		public Criteria andWeixinAppSecretLessThan(String value) {
			addCriterion("weixin_app_secret <", value, "weixinAppSecret");
			return (Criteria) this;
		}

		public Criteria andWeixinAppSecretLessThanOrEqualTo(String value) {
			addCriterion("weixin_app_secret <=", value, "weixinAppSecret");
			return (Criteria) this;
		}

		public Criteria andWeixinAppSecretLike(String value) {
			addCriterion("weixin_app_secret like", value, "weixinAppSecret");
			return (Criteria) this;
		}

		public Criteria andWeixinAppSecretNotLike(String value) {
			addCriterion("weixin_app_secret not like", value, "weixinAppSecret");
			return (Criteria) this;
		}

		public Criteria andWeixinAppSecretIn(List<String> values) {
			addCriterion("weixin_app_secret in", values, "weixinAppSecret");
			return (Criteria) this;
		}

		public Criteria andWeixinAppSecretNotIn(List<String> values) {
			addCriterion("weixin_app_secret not in", values, "weixinAppSecret");
			return (Criteria) this;
		}

		public Criteria andWeixinAppSecretBetween(String value1, String value2) {
			addCriterion("weixin_app_secret between", value1, value2, "weixinAppSecret");
			return (Criteria) this;
		}

		public Criteria andWeixinAppSecretNotBetween(String value1, String value2) {
			addCriterion("weixin_app_secret not between", value1, value2, "weixinAppSecret");
			return (Criteria) this;
		}

		public Criteria andWeixinStoreIsNull() {
			addCriterion("weixin_store is null");
			return (Criteria) this;
		}

		public Criteria andWeixinStoreIsNotNull() {
			addCriterion("weixin_store is not null");
			return (Criteria) this;
		}

		public Criteria andWeixinStoreEqualTo(Integer value) {
			addCriterion("weixin_store =", value, "weixinStore");
			return (Criteria) this;
		}

		public Criteria andWeixinStoreNotEqualTo(Integer value) {
			addCriterion("weixin_store <>", value, "weixinStore");
			return (Criteria) this;
		}

		public Criteria andWeixinStoreGreaterThan(Integer value) {
			addCriterion("weixin_store >", value, "weixinStore");
			return (Criteria) this;
		}

		public Criteria andWeixinStoreGreaterThanOrEqualTo(Integer value) {
			addCriterion("weixin_store >=", value, "weixinStore");
			return (Criteria) this;
		}

		public Criteria andWeixinStoreLessThan(Integer value) {
			addCriterion("weixin_store <", value, "weixinStore");
			return (Criteria) this;
		}

		public Criteria andWeixinStoreLessThanOrEqualTo(Integer value) {
			addCriterion("weixin_store <=", value, "weixinStore");
			return (Criteria) this;
		}

		public Criteria andWeixinStoreIn(List<Integer> values) {
			addCriterion("weixin_store in", values, "weixinStore");
			return (Criteria) this;
		}

		public Criteria andWeixinStoreNotIn(List<Integer> values) {
			addCriterion("weixin_store not in", values, "weixinStore");
			return (Criteria) this;
		}

		public Criteria andWeixinStoreBetween(Integer value1, Integer value2) {
			addCriterion("weixin_store between", value1, value2, "weixinStore");
			return (Criteria) this;
		}

		public Criteria andWeixinStoreNotBetween(Integer value1, Integer value2) {
			addCriterion("weixin_store not between", value1, value2, "weixinStore");
			return (Criteria) this;
		}

		public Criteria andWeixinTokenIsNull() {
			addCriterion("weixin_token is null");
			return (Criteria) this;
		}

		public Criteria andWeixinTokenIsNotNull() {
			addCriterion("weixin_token is not null");
			return (Criteria) this;
		}

		public Criteria andWeixinTokenEqualTo(String value) {
			addCriterion("weixin_token =", value, "weixinToken");
			return (Criteria) this;
		}

		public Criteria andWeixinTokenNotEqualTo(String value) {
			addCriterion("weixin_token <>", value, "weixinToken");
			return (Criteria) this;
		}

		public Criteria andWeixinTokenGreaterThan(String value) {
			addCriterion("weixin_token >", value, "weixinToken");
			return (Criteria) this;
		}

		public Criteria andWeixinTokenGreaterThanOrEqualTo(String value) {
			addCriterion("weixin_token >=", value, "weixinToken");
			return (Criteria) this;
		}

		public Criteria andWeixinTokenLessThan(String value) {
			addCriterion("weixin_token <", value, "weixinToken");
			return (Criteria) this;
		}

		public Criteria andWeixinTokenLessThanOrEqualTo(String value) {
			addCriterion("weixin_token <=", value, "weixinToken");
			return (Criteria) this;
		}

		public Criteria andWeixinTokenLike(String value) {
			addCriterion("weixin_token like", value, "weixinToken");
			return (Criteria) this;
		}

		public Criteria andWeixinTokenNotLike(String value) {
			addCriterion("weixin_token not like", value, "weixinToken");
			return (Criteria) this;
		}

		public Criteria andWeixinTokenIn(List<String> values) {
			addCriterion("weixin_token in", values, "weixinToken");
			return (Criteria) this;
		}

		public Criteria andWeixinTokenNotIn(List<String> values) {
			addCriterion("weixin_token not in", values, "weixinToken");
			return (Criteria) this;
		}

		public Criteria andWeixinTokenBetween(String value1, String value2) {
			addCriterion("weixin_token between", value1, value2, "weixinToken");
			return (Criteria) this;
		}

		public Criteria andWeixinTokenNotBetween(String value1, String value2) {
			addCriterion("weixin_token not between", value1, value2, "weixinToken");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeIsNull() {
			addCriterion("whether_free is null");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeIsNotNull() {
			addCriterion("whether_free is not null");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeEqualTo(Integer value) {
			addCriterion("whether_free =", value, "whetherFree");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeNotEqualTo(Integer value) {
			addCriterion("whether_free <>", value, "whetherFree");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeGreaterThan(Integer value) {
			addCriterion("whether_free >", value, "whetherFree");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeGreaterThanOrEqualTo(Integer value) {
			addCriterion("whether_free >=", value, "whetherFree");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeLessThan(Integer value) {
			addCriterion("whether_free <", value, "whetherFree");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeLessThanOrEqualTo(Integer value) {
			addCriterion("whether_free <=", value, "whetherFree");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeIn(List<Integer> values) {
			addCriterion("whether_free in", values, "whetherFree");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeNotIn(List<Integer> values) {
			addCriterion("whether_free not in", values, "whetherFree");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeBetween(Integer value1, Integer value2) {
			addCriterion("whether_free between", value1, value2, "whetherFree");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeNotBetween(Integer value1, Integer value2) {
			addCriterion("whether_free not between", value1, value2, "whetherFree");
			return (Criteria) this;
		}

		public Criteria andZtcGoodsViewIsNull() {
			addCriterion("ztc_goods_view is null");
			return (Criteria) this;
		}

		public Criteria andZtcGoodsViewIsNotNull() {
			addCriterion("ztc_goods_view is not null");
			return (Criteria) this;
		}

		public Criteria andZtcGoodsViewEqualTo(Integer value) {
			addCriterion("ztc_goods_view =", value, "ztcGoodsView");
			return (Criteria) this;
		}

		public Criteria andZtcGoodsViewNotEqualTo(Integer value) {
			addCriterion("ztc_goods_view <>", value, "ztcGoodsView");
			return (Criteria) this;
		}

		public Criteria andZtcGoodsViewGreaterThan(Integer value) {
			addCriterion("ztc_goods_view >", value, "ztcGoodsView");
			return (Criteria) this;
		}

		public Criteria andZtcGoodsViewGreaterThanOrEqualTo(Integer value) {
			addCriterion("ztc_goods_view >=", value, "ztcGoodsView");
			return (Criteria) this;
		}

		public Criteria andZtcGoodsViewLessThan(Integer value) {
			addCriterion("ztc_goods_view <", value, "ztcGoodsView");
			return (Criteria) this;
		}

		public Criteria andZtcGoodsViewLessThanOrEqualTo(Integer value) {
			addCriterion("ztc_goods_view <=", value, "ztcGoodsView");
			return (Criteria) this;
		}

		public Criteria andZtcGoodsViewIn(List<Integer> values) {
			addCriterion("ztc_goods_view in", values, "ztcGoodsView");
			return (Criteria) this;
		}

		public Criteria andZtcGoodsViewNotIn(List<Integer> values) {
			addCriterion("ztc_goods_view not in", values, "ztcGoodsView");
			return (Criteria) this;
		}

		public Criteria andZtcGoodsViewBetween(Integer value1, Integer value2) {
			addCriterion("ztc_goods_view between", value1, value2, "ztcGoodsView");
			return (Criteria) this;
		}

		public Criteria andZtcGoodsViewNotBetween(Integer value1, Integer value2) {
			addCriterion("ztc_goods_view not between", value1, value2, "ztcGoodsView");
			return (Criteria) this;
		}

		public Criteria andZtcPriceIsNull() {
			addCriterion("ztc_price is null");
			return (Criteria) this;
		}

		public Criteria andZtcPriceIsNotNull() {
			addCriterion("ztc_price is not null");
			return (Criteria) this;
		}

		public Criteria andZtcPriceEqualTo(Integer value) {
			addCriterion("ztc_price =", value, "ztcPrice");
			return (Criteria) this;
		}

		public Criteria andZtcPriceNotEqualTo(Integer value) {
			addCriterion("ztc_price <>", value, "ztcPrice");
			return (Criteria) this;
		}

		public Criteria andZtcPriceGreaterThan(Integer value) {
			addCriterion("ztc_price >", value, "ztcPrice");
			return (Criteria) this;
		}

		public Criteria andZtcPriceGreaterThanOrEqualTo(Integer value) {
			addCriterion("ztc_price >=", value, "ztcPrice");
			return (Criteria) this;
		}

		public Criteria andZtcPriceLessThan(Integer value) {
			addCriterion("ztc_price <", value, "ztcPrice");
			return (Criteria) this;
		}

		public Criteria andZtcPriceLessThanOrEqualTo(Integer value) {
			addCriterion("ztc_price <=", value, "ztcPrice");
			return (Criteria) this;
		}

		public Criteria andZtcPriceIn(List<Integer> values) {
			addCriterion("ztc_price in", values, "ztcPrice");
			return (Criteria) this;
		}

		public Criteria andZtcPriceNotIn(List<Integer> values) {
			addCriterion("ztc_price not in", values, "ztcPrice");
			return (Criteria) this;
		}

		public Criteria andZtcPriceBetween(Integer value1, Integer value2) {
			addCriterion("ztc_price between", value1, value2, "ztcPrice");
			return (Criteria) this;
		}

		public Criteria andZtcPriceNotBetween(Integer value1, Integer value2) {
			addCriterion("ztc_price not between", value1, value2, "ztcPrice");
			return (Criteria) this;
		}

		public Criteria andZtcStatusIsNull() {
			addCriterion("ztc_status is null");
			return (Criteria) this;
		}

		public Criteria andZtcStatusIsNotNull() {
			addCriterion("ztc_status is not null");
			return (Criteria) this;
		}

		public Criteria andZtcStatusEqualTo(Boolean value) {
			addCriterion("ztc_status =", value, "ztcStatus");
			return (Criteria) this;
		}

		public Criteria andZtcStatusNotEqualTo(Boolean value) {
			addCriterion("ztc_status <>", value, "ztcStatus");
			return (Criteria) this;
		}

		public Criteria andZtcStatusGreaterThan(Boolean value) {
			addCriterion("ztc_status >", value, "ztcStatus");
			return (Criteria) this;
		}

		public Criteria andZtcStatusGreaterThanOrEqualTo(Boolean value) {
			addCriterion("ztc_status >=", value, "ztcStatus");
			return (Criteria) this;
		}

		public Criteria andZtcStatusLessThan(Boolean value) {
			addCriterion("ztc_status <", value, "ztcStatus");
			return (Criteria) this;
		}

		public Criteria andZtcStatusLessThanOrEqualTo(Boolean value) {
			addCriterion("ztc_status <=", value, "ztcStatus");
			return (Criteria) this;
		}

		public Criteria andZtcStatusIn(List<Boolean> values) {
			addCriterion("ztc_status in", values, "ztcStatus");
			return (Criteria) this;
		}

		public Criteria andZtcStatusNotIn(List<Boolean> values) {
			addCriterion("ztc_status not in", values, "ztcStatus");
			return (Criteria) this;
		}

		public Criteria andZtcStatusBetween(Boolean value1, Boolean value2) {
			addCriterion("ztc_status between", value1, value2, "ztcStatus");
			return (Criteria) this;
		}

		public Criteria andZtcStatusNotBetween(Boolean value1, Boolean value2) {
			addCriterion("ztc_status not between", value1, value2, "ztcStatus");
			return (Criteria) this;
		}

		public Criteria andAdminLoginLogoIdIsNull() {
			addCriterion("admin_login_logo_id is null");
			return (Criteria) this;
		}

		public Criteria andAdminLoginLogoIdIsNotNull() {
			addCriterion("admin_login_logo_id is not null");
			return (Criteria) this;
		}

		public Criteria andAdminLoginLogoIdEqualTo(Long value) {
			addCriterion("admin_login_logo_id =", value, "adminLoginLogoId");
			return (Criteria) this;
		}

		public Criteria andAdminLoginLogoIdNotEqualTo(Long value) {
			addCriterion("admin_login_logo_id <>", value, "adminLoginLogoId");
			return (Criteria) this;
		}

		public Criteria andAdminLoginLogoIdGreaterThan(Long value) {
			addCriterion("admin_login_logo_id >", value, "adminLoginLogoId");
			return (Criteria) this;
		}

		public Criteria andAdminLoginLogoIdGreaterThanOrEqualTo(Long value) {
			addCriterion("admin_login_logo_id >=", value, "adminLoginLogoId");
			return (Criteria) this;
		}

		public Criteria andAdminLoginLogoIdLessThan(Long value) {
			addCriterion("admin_login_logo_id <", value, "adminLoginLogoId");
			return (Criteria) this;
		}

		public Criteria andAdminLoginLogoIdLessThanOrEqualTo(Long value) {
			addCriterion("admin_login_logo_id <=", value, "adminLoginLogoId");
			return (Criteria) this;
		}

		public Criteria andAdminLoginLogoIdIn(List<Long> values) {
			addCriterion("admin_login_logo_id in", values, "adminLoginLogoId");
			return (Criteria) this;
		}

		public Criteria andAdminLoginLogoIdNotIn(List<Long> values) {
			addCriterion("admin_login_logo_id not in", values, "adminLoginLogoId");
			return (Criteria) this;
		}

		public Criteria andAdminLoginLogoIdBetween(Long value1, Long value2) {
			addCriterion("admin_login_logo_id between", value1, value2, "adminLoginLogoId");
			return (Criteria) this;
		}

		public Criteria andAdminLoginLogoIdNotBetween(Long value1, Long value2) {
			addCriterion("admin_login_logo_id not between", value1, value2, "adminLoginLogoId");
			return (Criteria) this;
		}

		public Criteria andAdminManageLogoIdIsNull() {
			addCriterion("admin_manage_logo_id is null");
			return (Criteria) this;
		}

		public Criteria andAdminManageLogoIdIsNotNull() {
			addCriterion("admin_manage_logo_id is not null");
			return (Criteria) this;
		}

		public Criteria andAdminManageLogoIdEqualTo(Long value) {
			addCriterion("admin_manage_logo_id =", value, "adminManageLogoId");
			return (Criteria) this;
		}

		public Criteria andAdminManageLogoIdNotEqualTo(Long value) {
			addCriterion("admin_manage_logo_id <>", value, "adminManageLogoId");
			return (Criteria) this;
		}

		public Criteria andAdminManageLogoIdGreaterThan(Long value) {
			addCriterion("admin_manage_logo_id >", value, "adminManageLogoId");
			return (Criteria) this;
		}

		public Criteria andAdminManageLogoIdGreaterThanOrEqualTo(Long value) {
			addCriterion("admin_manage_logo_id >=", value, "adminManageLogoId");
			return (Criteria) this;
		}

		public Criteria andAdminManageLogoIdLessThan(Long value) {
			addCriterion("admin_manage_logo_id <", value, "adminManageLogoId");
			return (Criteria) this;
		}

		public Criteria andAdminManageLogoIdLessThanOrEqualTo(Long value) {
			addCriterion("admin_manage_logo_id <=", value, "adminManageLogoId");
			return (Criteria) this;
		}

		public Criteria andAdminManageLogoIdIn(List<Long> values) {
			addCriterion("admin_manage_logo_id in", values, "adminManageLogoId");
			return (Criteria) this;
		}

		public Criteria andAdminManageLogoIdNotIn(List<Long> values) {
			addCriterion("admin_manage_logo_id not in", values, "adminManageLogoId");
			return (Criteria) this;
		}

		public Criteria andAdminManageLogoIdBetween(Long value1, Long value2) {
			addCriterion("admin_manage_logo_id between", value1, value2, "adminManageLogoId");
			return (Criteria) this;
		}

		public Criteria andAdminManageLogoIdNotBetween(Long value1, Long value2) {
			addCriterion("admin_manage_logo_id not between", value1, value2, "adminManageLogoId");
			return (Criteria) this;
		}

		public Criteria andGoodsImageIdIsNull() {
			addCriterion("goods_image_id is null");
			return (Criteria) this;
		}

		public Criteria andGoodsImageIdIsNotNull() {
			addCriterion("goods_image_id is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsImageIdEqualTo(Long value) {
			addCriterion("goods_image_id =", value, "goodsImageId");
			return (Criteria) this;
		}

		public Criteria andGoodsImageIdNotEqualTo(Long value) {
			addCriterion("goods_image_id <>", value, "goodsImageId");
			return (Criteria) this;
		}

		public Criteria andGoodsImageIdGreaterThan(Long value) {
			addCriterion("goods_image_id >", value, "goodsImageId");
			return (Criteria) this;
		}

		public Criteria andGoodsImageIdGreaterThanOrEqualTo(Long value) {
			addCriterion("goods_image_id >=", value, "goodsImageId");
			return (Criteria) this;
		}

		public Criteria andGoodsImageIdLessThan(Long value) {
			addCriterion("goods_image_id <", value, "goodsImageId");
			return (Criteria) this;
		}

		public Criteria andGoodsImageIdLessThanOrEqualTo(Long value) {
			addCriterion("goods_image_id <=", value, "goodsImageId");
			return (Criteria) this;
		}

		public Criteria andGoodsImageIdIn(List<Long> values) {
			addCriterion("goods_image_id in", values, "goodsImageId");
			return (Criteria) this;
		}

		public Criteria andGoodsImageIdNotIn(List<Long> values) {
			addCriterion("goods_image_id not in", values, "goodsImageId");
			return (Criteria) this;
		}

		public Criteria andGoodsImageIdBetween(Long value1, Long value2) {
			addCriterion("goods_image_id between", value1, value2, "goodsImageId");
			return (Criteria) this;
		}

		public Criteria andGoodsImageIdNotBetween(Long value1, Long value2) {
			addCriterion("goods_image_id not between", value1, value2, "goodsImageId");
			return (Criteria) this;
		}

		public Criteria andMemberIconIdIsNull() {
			addCriterion("member_icon_id is null");
			return (Criteria) this;
		}

		public Criteria andMemberIconIdIsNotNull() {
			addCriterion("member_icon_id is not null");
			return (Criteria) this;
		}

		public Criteria andMemberIconIdEqualTo(Long value) {
			addCriterion("member_icon_id =", value, "memberIconId");
			return (Criteria) this;
		}

		public Criteria andMemberIconIdNotEqualTo(Long value) {
			addCriterion("member_icon_id <>", value, "memberIconId");
			return (Criteria) this;
		}

		public Criteria andMemberIconIdGreaterThan(Long value) {
			addCriterion("member_icon_id >", value, "memberIconId");
			return (Criteria) this;
		}

		public Criteria andMemberIconIdGreaterThanOrEqualTo(Long value) {
			addCriterion("member_icon_id >=", value, "memberIconId");
			return (Criteria) this;
		}

		public Criteria andMemberIconIdLessThan(Long value) {
			addCriterion("member_icon_id <", value, "memberIconId");
			return (Criteria) this;
		}

		public Criteria andMemberIconIdLessThanOrEqualTo(Long value) {
			addCriterion("member_icon_id <=", value, "memberIconId");
			return (Criteria) this;
		}

		public Criteria andMemberIconIdIn(List<Long> values) {
			addCriterion("member_icon_id in", values, "memberIconId");
			return (Criteria) this;
		}

		public Criteria andMemberIconIdNotIn(List<Long> values) {
			addCriterion("member_icon_id not in", values, "memberIconId");
			return (Criteria) this;
		}

		public Criteria andMemberIconIdBetween(Long value1, Long value2) {
			addCriterion("member_icon_id between", value1, value2, "memberIconId");
			return (Criteria) this;
		}

		public Criteria andMemberIconIdNotBetween(Long value1, Long value2) {
			addCriterion("member_icon_id not between", value1, value2, "memberIconId");
			return (Criteria) this;
		}

		public Criteria andQrLogoIdIsNull() {
			addCriterion("qr_logo_id is null");
			return (Criteria) this;
		}

		public Criteria andQrLogoIdIsNotNull() {
			addCriterion("qr_logo_id is not null");
			return (Criteria) this;
		}

		public Criteria andQrLogoIdEqualTo(Long value) {
			addCriterion("qr_logo_id =", value, "qrLogoId");
			return (Criteria) this;
		}

		public Criteria andQrLogoIdNotEqualTo(Long value) {
			addCriterion("qr_logo_id <>", value, "qrLogoId");
			return (Criteria) this;
		}

		public Criteria andQrLogoIdGreaterThan(Long value) {
			addCriterion("qr_logo_id >", value, "qrLogoId");
			return (Criteria) this;
		}

		public Criteria andQrLogoIdGreaterThanOrEqualTo(Long value) {
			addCriterion("qr_logo_id >=", value, "qrLogoId");
			return (Criteria) this;
		}

		public Criteria andQrLogoIdLessThan(Long value) {
			addCriterion("qr_logo_id <", value, "qrLogoId");
			return (Criteria) this;
		}

		public Criteria andQrLogoIdLessThanOrEqualTo(Long value) {
			addCriterion("qr_logo_id <=", value, "qrLogoId");
			return (Criteria) this;
		}

		public Criteria andQrLogoIdIn(List<Long> values) {
			addCriterion("qr_logo_id in", values, "qrLogoId");
			return (Criteria) this;
		}

		public Criteria andQrLogoIdNotIn(List<Long> values) {
			addCriterion("qr_logo_id not in", values, "qrLogoId");
			return (Criteria) this;
		}

		public Criteria andQrLogoIdBetween(Long value1, Long value2) {
			addCriterion("qr_logo_id between", value1, value2, "qrLogoId");
			return (Criteria) this;
		}

		public Criteria andQrLogoIdNotBetween(Long value1, Long value2) {
			addCriterion("qr_logo_id not between", value1, value2, "qrLogoId");
			return (Criteria) this;
		}

		public Criteria andStoreImageIdIsNull() {
			addCriterion("store_image_id is null");
			return (Criteria) this;
		}

		public Criteria andStoreImageIdIsNotNull() {
			addCriterion("store_image_id is not null");
			return (Criteria) this;
		}

		public Criteria andStoreImageIdEqualTo(Long value) {
			addCriterion("store_image_id =", value, "storeImageId");
			return (Criteria) this;
		}

		public Criteria andStoreImageIdNotEqualTo(Long value) {
			addCriterion("store_image_id <>", value, "storeImageId");
			return (Criteria) this;
		}

		public Criteria andStoreImageIdGreaterThan(Long value) {
			addCriterion("store_image_id >", value, "storeImageId");
			return (Criteria) this;
		}

		public Criteria andStoreImageIdGreaterThanOrEqualTo(Long value) {
			addCriterion("store_image_id >=", value, "storeImageId");
			return (Criteria) this;
		}

		public Criteria andStoreImageIdLessThan(Long value) {
			addCriterion("store_image_id <", value, "storeImageId");
			return (Criteria) this;
		}

		public Criteria andStoreImageIdLessThanOrEqualTo(Long value) {
			addCriterion("store_image_id <=", value, "storeImageId");
			return (Criteria) this;
		}

		public Criteria andStoreImageIdIn(List<Long> values) {
			addCriterion("store_image_id in", values, "storeImageId");
			return (Criteria) this;
		}

		public Criteria andStoreImageIdNotIn(List<Long> values) {
			addCriterion("store_image_id not in", values, "storeImageId");
			return (Criteria) this;
		}

		public Criteria andStoreImageIdBetween(Long value1, Long value2) {
			addCriterion("store_image_id between", value1, value2, "storeImageId");
			return (Criteria) this;
		}

		public Criteria andStoreImageIdNotBetween(Long value1, Long value2) {
			addCriterion("store_image_id not between", value1, value2, "storeImageId");
			return (Criteria) this;
		}

		public Criteria andStoreWeixinLogoIdIsNull() {
			addCriterion("store_weixin_logo_id is null");
			return (Criteria) this;
		}

		public Criteria andStoreWeixinLogoIdIsNotNull() {
			addCriterion("store_weixin_logo_id is not null");
			return (Criteria) this;
		}

		public Criteria andStoreWeixinLogoIdEqualTo(Long value) {
			addCriterion("store_weixin_logo_id =", value, "storeWeixinLogoId");
			return (Criteria) this;
		}

		public Criteria andStoreWeixinLogoIdNotEqualTo(Long value) {
			addCriterion("store_weixin_logo_id <>", value, "storeWeixinLogoId");
			return (Criteria) this;
		}

		public Criteria andStoreWeixinLogoIdGreaterThan(Long value) {
			addCriterion("store_weixin_logo_id >", value, "storeWeixinLogoId");
			return (Criteria) this;
		}

		public Criteria andStoreWeixinLogoIdGreaterThanOrEqualTo(Long value) {
			addCriterion("store_weixin_logo_id >=", value, "storeWeixinLogoId");
			return (Criteria) this;
		}

		public Criteria andStoreWeixinLogoIdLessThan(Long value) {
			addCriterion("store_weixin_logo_id <", value, "storeWeixinLogoId");
			return (Criteria) this;
		}

		public Criteria andStoreWeixinLogoIdLessThanOrEqualTo(Long value) {
			addCriterion("store_weixin_logo_id <=", value, "storeWeixinLogoId");
			return (Criteria) this;
		}

		public Criteria andStoreWeixinLogoIdIn(List<Long> values) {
			addCriterion("store_weixin_logo_id in", values, "storeWeixinLogoId");
			return (Criteria) this;
		}

		public Criteria andStoreWeixinLogoIdNotIn(List<Long> values) {
			addCriterion("store_weixin_logo_id not in", values, "storeWeixinLogoId");
			return (Criteria) this;
		}

		public Criteria andStoreWeixinLogoIdBetween(Long value1, Long value2) {
			addCriterion("store_weixin_logo_id between", value1, value2, "storeWeixinLogoId");
			return (Criteria) this;
		}

		public Criteria andStoreWeixinLogoIdNotBetween(Long value1, Long value2) {
			addCriterion("store_weixin_logo_id not between", value1, value2, "storeWeixinLogoId");
			return (Criteria) this;
		}

		public Criteria andWebsiteLogoIdIsNull() {
			addCriterion("website_logo_id is null");
			return (Criteria) this;
		}

		public Criteria andWebsiteLogoIdIsNotNull() {
			addCriterion("website_logo_id is not null");
			return (Criteria) this;
		}

		public Criteria andWebsiteLogoIdEqualTo(Long value) {
			addCriterion("website_logo_id =", value, "websiteLogoId");
			return (Criteria) this;
		}

		public Criteria andWebsiteLogoIdNotEqualTo(Long value) {
			addCriterion("website_logo_id <>", value, "websiteLogoId");
			return (Criteria) this;
		}

		public Criteria andWebsiteLogoIdGreaterThan(Long value) {
			addCriterion("website_logo_id >", value, "websiteLogoId");
			return (Criteria) this;
		}

		public Criteria andWebsiteLogoIdGreaterThanOrEqualTo(Long value) {
			addCriterion("website_logo_id >=", value, "websiteLogoId");
			return (Criteria) this;
		}

		public Criteria andWebsiteLogoIdLessThan(Long value) {
			addCriterion("website_logo_id <", value, "websiteLogoId");
			return (Criteria) this;
		}

		public Criteria andWebsiteLogoIdLessThanOrEqualTo(Long value) {
			addCriterion("website_logo_id <=", value, "websiteLogoId");
			return (Criteria) this;
		}

		public Criteria andWebsiteLogoIdIn(List<Long> values) {
			addCriterion("website_logo_id in", values, "websiteLogoId");
			return (Criteria) this;
		}

		public Criteria andWebsiteLogoIdNotIn(List<Long> values) {
			addCriterion("website_logo_id not in", values, "websiteLogoId");
			return (Criteria) this;
		}

		public Criteria andWebsiteLogoIdBetween(Long value1, Long value2) {
			addCriterion("website_logo_id between", value1, value2, "websiteLogoId");
			return (Criteria) this;
		}

		public Criteria andWebsiteLogoIdNotBetween(Long value1, Long value2) {
			addCriterion("website_logo_id not between", value1, value2, "websiteLogoId");
			return (Criteria) this;
		}

		public Criteria andWeixinQrImgIdIsNull() {
			addCriterion("weixin_qr_img_id is null");
			return (Criteria) this;
		}

		public Criteria andWeixinQrImgIdIsNotNull() {
			addCriterion("weixin_qr_img_id is not null");
			return (Criteria) this;
		}

		public Criteria andWeixinQrImgIdEqualTo(Long value) {
			addCriterion("weixin_qr_img_id =", value, "weixinQrImgId");
			return (Criteria) this;
		}

		public Criteria andWeixinQrImgIdNotEqualTo(Long value) {
			addCriterion("weixin_qr_img_id <>", value, "weixinQrImgId");
			return (Criteria) this;
		}

		public Criteria andWeixinQrImgIdGreaterThan(Long value) {
			addCriterion("weixin_qr_img_id >", value, "weixinQrImgId");
			return (Criteria) this;
		}

		public Criteria andWeixinQrImgIdGreaterThanOrEqualTo(Long value) {
			addCriterion("weixin_qr_img_id >=", value, "weixinQrImgId");
			return (Criteria) this;
		}

		public Criteria andWeixinQrImgIdLessThan(Long value) {
			addCriterion("weixin_qr_img_id <", value, "weixinQrImgId");
			return (Criteria) this;
		}

		public Criteria andWeixinQrImgIdLessThanOrEqualTo(Long value) {
			addCriterion("weixin_qr_img_id <=", value, "weixinQrImgId");
			return (Criteria) this;
		}

		public Criteria andWeixinQrImgIdIn(List<Long> values) {
			addCriterion("weixin_qr_img_id in", values, "weixinQrImgId");
			return (Criteria) this;
		}

		public Criteria andWeixinQrImgIdNotIn(List<Long> values) {
			addCriterion("weixin_qr_img_id not in", values, "weixinQrImgId");
			return (Criteria) this;
		}

		public Criteria andWeixinQrImgIdBetween(Long value1, Long value2) {
			addCriterion("weixin_qr_img_id between", value1, value2, "weixinQrImgId");
			return (Criteria) this;
		}

		public Criteria andWeixinQrImgIdNotBetween(Long value1, Long value2) {
			addCriterion("weixin_qr_img_id not between", value1, value2, "weixinQrImgId");
			return (Criteria) this;
		}

		public Criteria andWelcomeImgIdIsNull() {
			addCriterion("welcome_img_id is null");
			return (Criteria) this;
		}

		public Criteria andWelcomeImgIdIsNotNull() {
			addCriterion("welcome_img_id is not null");
			return (Criteria) this;
		}

		public Criteria andWelcomeImgIdEqualTo(Long value) {
			addCriterion("welcome_img_id =", value, "welcomeImgId");
			return (Criteria) this;
		}

		public Criteria andWelcomeImgIdNotEqualTo(Long value) {
			addCriterion("welcome_img_id <>", value, "welcomeImgId");
			return (Criteria) this;
		}

		public Criteria andWelcomeImgIdGreaterThan(Long value) {
			addCriterion("welcome_img_id >", value, "welcomeImgId");
			return (Criteria) this;
		}

		public Criteria andWelcomeImgIdGreaterThanOrEqualTo(Long value) {
			addCriterion("welcome_img_id >=", value, "welcomeImgId");
			return (Criteria) this;
		}

		public Criteria andWelcomeImgIdLessThan(Long value) {
			addCriterion("welcome_img_id <", value, "welcomeImgId");
			return (Criteria) this;
		}

		public Criteria andWelcomeImgIdLessThanOrEqualTo(Long value) {
			addCriterion("welcome_img_id <=", value, "welcomeImgId");
			return (Criteria) this;
		}

		public Criteria andWelcomeImgIdIn(List<Long> values) {
			addCriterion("welcome_img_id in", values, "welcomeImgId");
			return (Criteria) this;
		}

		public Criteria andWelcomeImgIdNotIn(List<Long> values) {
			addCriterion("welcome_img_id not in", values, "welcomeImgId");
			return (Criteria) this;
		}

		public Criteria andWelcomeImgIdBetween(Long value1, Long value2) {
			addCriterion("welcome_img_id between", value1, value2, "welcomeImgId");
			return (Criteria) this;
		}

		public Criteria andWelcomeImgIdNotBetween(Long value1, Long value2) {
			addCriterion("welcome_img_id not between", value1, value2, "welcomeImgId");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}