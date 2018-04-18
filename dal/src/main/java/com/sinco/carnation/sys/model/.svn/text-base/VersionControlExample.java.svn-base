package com.sinco.carnation.sys.model;

import com.sinco.carnation.sys.bo.VersionControlBO;
import com.sinco.mybatis.dal.core.AbstractExample;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VersionControlExample extends AbstractExample<VersionControlBO> {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected String limit;

	public VersionControlExample() {
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

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public void setLimit(int count) {
		this.limit = String.valueOf(count);
	}

	public void setLimit(int offset, int rows) {
		this.limit = new StringBuilder().append(String.valueOf(offset)).append(",")
				.append(String.valueOf(rows)).toString();
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

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
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

		public Criteria andVcTypeIsNull() {
			addCriterion("vc_type is null");
			return (Criteria) this;
		}

		public Criteria andVcTypeIsNotNull() {
			addCriterion("vc_type is not null");
			return (Criteria) this;
		}

		public Criteria andVcTypeEqualTo(Integer value) {
			addCriterion("vc_type =", value, "vcType");
			return (Criteria) this;
		}

		public Criteria andVcTypeNotEqualTo(Integer value) {
			addCriterion("vc_type <>", value, "vcType");
			return (Criteria) this;
		}

		public Criteria andVcTypeGreaterThan(Integer value) {
			addCriterion("vc_type >", value, "vcType");
			return (Criteria) this;
		}

		public Criteria andVcTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("vc_type >=", value, "vcType");
			return (Criteria) this;
		}

		public Criteria andVcTypeLessThan(Integer value) {
			addCriterion("vc_type <", value, "vcType");
			return (Criteria) this;
		}

		public Criteria andVcTypeLessThanOrEqualTo(Integer value) {
			addCriterion("vc_type <=", value, "vcType");
			return (Criteria) this;
		}

		public Criteria andVcTypeIn(List<Integer> values) {
			addCriterion("vc_type in", values, "vcType");
			return (Criteria) this;
		}

		public Criteria andVcTypeNotIn(List<Integer> values) {
			addCriterion("vc_type not in", values, "vcType");
			return (Criteria) this;
		}

		public Criteria andVcTypeBetween(Integer value1, Integer value2) {
			addCriterion("vc_type between", value1, value2, "vcType");
			return (Criteria) this;
		}

		public Criteria andVcTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("vc_type not between", value1, value2, "vcType");
			return (Criteria) this;
		}

		public Criteria andVcNumberIsNull() {
			addCriterion("vc_number is null");
			return (Criteria) this;
		}

		public Criteria andVcNumberIsNotNull() {
			addCriterion("vc_number is not null");
			return (Criteria) this;
		}

		public Criteria andVcNumberEqualTo(String value) {
			addCriterion("vc_number =", value, "vcNumber");
			return (Criteria) this;
		}

		public Criteria andVcNumberNotEqualTo(String value) {
			addCriterion("vc_number <>", value, "vcNumber");
			return (Criteria) this;
		}

		public Criteria andVcNumberGreaterThan(String value) {
			addCriterion("vc_number >", value, "vcNumber");
			return (Criteria) this;
		}

		public Criteria andVcNumberGreaterThanOrEqualTo(String value) {
			addCriterion("vc_number >=", value, "vcNumber");
			return (Criteria) this;
		}

		public Criteria andVcNumberLessThan(String value) {
			addCriterion("vc_number <", value, "vcNumber");
			return (Criteria) this;
		}

		public Criteria andVcNumberLessThanOrEqualTo(String value) {
			addCriterion("vc_number <=", value, "vcNumber");
			return (Criteria) this;
		}

		public Criteria andVcNumberLike(String value) {
			addCriterion("vc_number like", value, "vcNumber");
			return (Criteria) this;
		}

		public Criteria andVcNumberNotLike(String value) {
			addCriterion("vc_number not like", value, "vcNumber");
			return (Criteria) this;
		}

		public Criteria andVcNumberIn(List<String> values) {
			addCriterion("vc_number in", values, "vcNumber");
			return (Criteria) this;
		}

		public Criteria andVcNumberNotIn(List<String> values) {
			addCriterion("vc_number not in", values, "vcNumber");
			return (Criteria) this;
		}

		public Criteria andVcNumberBetween(String value1, String value2) {
			addCriterion("vc_number between", value1, value2, "vcNumber");
			return (Criteria) this;
		}

		public Criteria andVcNumberNotBetween(String value1, String value2) {
			addCriterion("vc_number not between", value1, value2, "vcNumber");
			return (Criteria) this;
		}

		public Criteria andVcDescribeIsNull() {
			addCriterion("vc_describe is null");
			return (Criteria) this;
		}

		public Criteria andVcDescribeIsNotNull() {
			addCriterion("vc_describe is not null");
			return (Criteria) this;
		}

		public Criteria andVcDescribeEqualTo(String value) {
			addCriterion("vc_describe =", value, "vcDescribe");
			return (Criteria) this;
		}

		public Criteria andVcDescribeNotEqualTo(String value) {
			addCriterion("vc_describe <>", value, "vcDescribe");
			return (Criteria) this;
		}

		public Criteria andVcDescribeGreaterThan(String value) {
			addCriterion("vc_describe >", value, "vcDescribe");
			return (Criteria) this;
		}

		public Criteria andVcDescribeGreaterThanOrEqualTo(String value) {
			addCriterion("vc_describe >=", value, "vcDescribe");
			return (Criteria) this;
		}

		public Criteria andVcDescribeLessThan(String value) {
			addCriterion("vc_describe <", value, "vcDescribe");
			return (Criteria) this;
		}

		public Criteria andVcDescribeLessThanOrEqualTo(String value) {
			addCriterion("vc_describe <=", value, "vcDescribe");
			return (Criteria) this;
		}

		public Criteria andVcDescribeLike(String value) {
			addCriterion("vc_describe like", value, "vcDescribe");
			return (Criteria) this;
		}

		public Criteria andVcDescribeNotLike(String value) {
			addCriterion("vc_describe not like", value, "vcDescribe");
			return (Criteria) this;
		}

		public Criteria andVcDescribeIn(List<String> values) {
			addCriterion("vc_describe in", values, "vcDescribe");
			return (Criteria) this;
		}

		public Criteria andVcDescribeNotIn(List<String> values) {
			addCriterion("vc_describe not in", values, "vcDescribe");
			return (Criteria) this;
		}

		public Criteria andVcDescribeBetween(String value1, String value2) {
			addCriterion("vc_describe between", value1, value2, "vcDescribe");
			return (Criteria) this;
		}

		public Criteria andVcDescribeNotBetween(String value1, String value2) {
			addCriterion("vc_describe not between", value1, value2, "vcDescribe");
			return (Criteria) this;
		}

		public Criteria andIfOpenIsNull() {
			addCriterion("if_open is null");
			return (Criteria) this;
		}

		public Criteria andIfOpenIsNotNull() {
			addCriterion("if_open is not null");
			return (Criteria) this;
		}

		public Criteria andIfOpenEqualTo(Boolean value) {
			addCriterion("if_open =", value, "ifOpen");
			return (Criteria) this;
		}

		public Criteria andIfOpenNotEqualTo(Boolean value) {
			addCriterion("if_open <>", value, "ifOpen");
			return (Criteria) this;
		}

		public Criteria andIfOpenGreaterThan(Boolean value) {
			addCriterion("if_open >", value, "ifOpen");
			return (Criteria) this;
		}

		public Criteria andIfOpenGreaterThanOrEqualTo(Boolean value) {
			addCriterion("if_open >=", value, "ifOpen");
			return (Criteria) this;
		}

		public Criteria andIfOpenLessThan(Boolean value) {
			addCriterion("if_open <", value, "ifOpen");
			return (Criteria) this;
		}

		public Criteria andIfOpenLessThanOrEqualTo(Boolean value) {
			addCriterion("if_open <=", value, "ifOpen");
			return (Criteria) this;
		}

		public Criteria andIfOpenIn(List<Boolean> values) {
			addCriterion("if_open in", values, "ifOpen");
			return (Criteria) this;
		}

		public Criteria andIfOpenNotIn(List<Boolean> values) {
			addCriterion("if_open not in", values, "ifOpen");
			return (Criteria) this;
		}

		public Criteria andIfOpenBetween(Boolean value1, Boolean value2) {
			addCriterion("if_open between", value1, value2, "ifOpen");
			return (Criteria) this;
		}

		public Criteria andIfOpenNotBetween(Boolean value1, Boolean value2) {
			addCriterion("if_open not between", value1, value2, "ifOpen");
			return (Criteria) this;
		}

		public Criteria andIfMandatoryIsNull() {
			addCriterion("if_mandatory is null");
			return (Criteria) this;
		}

		public Criteria andIfMandatoryIsNotNull() {
			addCriterion("if_mandatory is not null");
			return (Criteria) this;
		}

		public Criteria andIfMandatoryEqualTo(Boolean value) {
			addCriterion("if_mandatory =", value, "ifMandatory");
			return (Criteria) this;
		}

		public Criteria andIfMandatoryNotEqualTo(Boolean value) {
			addCriterion("if_mandatory <>", value, "ifMandatory");
			return (Criteria) this;
		}

		public Criteria andIfMandatoryGreaterThan(Boolean value) {
			addCriterion("if_mandatory >", value, "ifMandatory");
			return (Criteria) this;
		}

		public Criteria andIfMandatoryGreaterThanOrEqualTo(Boolean value) {
			addCriterion("if_mandatory >=", value, "ifMandatory");
			return (Criteria) this;
		}

		public Criteria andIfMandatoryLessThan(Boolean value) {
			addCriterion("if_mandatory <", value, "ifMandatory");
			return (Criteria) this;
		}

		public Criteria andIfMandatoryLessThanOrEqualTo(Boolean value) {
			addCriterion("if_mandatory <=", value, "ifMandatory");
			return (Criteria) this;
		}

		public Criteria andIfMandatoryIn(List<Boolean> values) {
			addCriterion("if_mandatory in", values, "ifMandatory");
			return (Criteria) this;
		}

		public Criteria andIfMandatoryNotIn(List<Boolean> values) {
			addCriterion("if_mandatory not in", values, "ifMandatory");
			return (Criteria) this;
		}

		public Criteria andIfMandatoryBetween(Boolean value1, Boolean value2) {
			addCriterion("if_mandatory between", value1, value2, "ifMandatory");
			return (Criteria) this;
		}

		public Criteria andIfMandatoryNotBetween(Boolean value1, Boolean value2) {
			addCriterion("if_mandatory not between", value1, value2, "ifMandatory");
			return (Criteria) this;
		}

		public Criteria andDownloadsIsNull() {
			addCriterion("downloads is null");
			return (Criteria) this;
		}

		public Criteria andDownloadsIsNotNull() {
			addCriterion("downloads is not null");
			return (Criteria) this;
		}

		public Criteria andDownloadsEqualTo(Integer value) {
			addCriterion("downloads =", value, "downloads");
			return (Criteria) this;
		}

		public Criteria andDownloadsNotEqualTo(Integer value) {
			addCriterion("downloads <>", value, "downloads");
			return (Criteria) this;
		}

		public Criteria andDownloadsGreaterThan(Integer value) {
			addCriterion("downloads >", value, "downloads");
			return (Criteria) this;
		}

		public Criteria andDownloadsGreaterThanOrEqualTo(Integer value) {
			addCriterion("downloads >=", value, "downloads");
			return (Criteria) this;
		}

		public Criteria andDownloadsLessThan(Integer value) {
			addCriterion("downloads <", value, "downloads");
			return (Criteria) this;
		}

		public Criteria andDownloadsLessThanOrEqualTo(Integer value) {
			addCriterion("downloads <=", value, "downloads");
			return (Criteria) this;
		}

		public Criteria andDownloadsIn(List<Integer> values) {
			addCriterion("downloads in", values, "downloads");
			return (Criteria) this;
		}

		public Criteria andDownloadsNotIn(List<Integer> values) {
			addCriterion("downloads not in", values, "downloads");
			return (Criteria) this;
		}

		public Criteria andDownloadsBetween(Integer value1, Integer value2) {
			addCriterion("downloads between", value1, value2, "downloads");
			return (Criteria) this;
		}

		public Criteria andDownloadsNotBetween(Integer value1, Integer value2) {
			addCriterion("downloads not between", value1, value2, "downloads");
			return (Criteria) this;
		}

		public Criteria andDownloadUrlIsNull() {
			addCriterion("download_url is null");
			return (Criteria) this;
		}

		public Criteria andDownloadUrlIsNotNull() {
			addCriterion("download_url is not null");
			return (Criteria) this;
		}

		public Criteria andDownloadUrlEqualTo(String value) {
			addCriterion("download_url =", value, "downloadUrl");
			return (Criteria) this;
		}

		public Criteria andDownloadUrlNotEqualTo(String value) {
			addCriterion("download_url <>", value, "downloadUrl");
			return (Criteria) this;
		}

		public Criteria andDownloadUrlGreaterThan(String value) {
			addCriterion("download_url >", value, "downloadUrl");
			return (Criteria) this;
		}

		public Criteria andDownloadUrlGreaterThanOrEqualTo(String value) {
			addCriterion("download_url >=", value, "downloadUrl");
			return (Criteria) this;
		}

		public Criteria andDownloadUrlLessThan(String value) {
			addCriterion("download_url <", value, "downloadUrl");
			return (Criteria) this;
		}

		public Criteria andDownloadUrlLessThanOrEqualTo(String value) {
			addCriterion("download_url <=", value, "downloadUrl");
			return (Criteria) this;
		}

		public Criteria andDownloadUrlLike(String value) {
			addCriterion("download_url like", value, "downloadUrl");
			return (Criteria) this;
		}

		public Criteria andDownloadUrlNotLike(String value) {
			addCriterion("download_url not like", value, "downloadUrl");
			return (Criteria) this;
		}

		public Criteria andDownloadUrlIn(List<String> values) {
			addCriterion("download_url in", values, "downloadUrl");
			return (Criteria) this;
		}

		public Criteria andDownloadUrlNotIn(List<String> values) {
			addCriterion("download_url not in", values, "downloadUrl");
			return (Criteria) this;
		}

		public Criteria andDownloadUrlBetween(String value1, String value2) {
			addCriterion("download_url between", value1, value2, "downloadUrl");
			return (Criteria) this;
		}

		public Criteria andDownloadUrlNotBetween(String value1, String value2) {
			addCriterion("download_url not between", value1, value2, "downloadUrl");
			return (Criteria) this;
		}

		public Criteria andVcStateIsNull() {
			addCriterion("vc_state is null");
			return (Criteria) this;
		}

		public Criteria andVcStateIsNotNull() {
			addCriterion("vc_state is not null");
			return (Criteria) this;
		}

		public Criteria andVcStateEqualTo(Boolean value) {
			addCriterion("vc_state =", value, "vcState");
			return (Criteria) this;
		}

		public Criteria andVcStateNotEqualTo(Boolean value) {
			addCriterion("vc_state <>", value, "vcState");
			return (Criteria) this;
		}

		public Criteria andVcStateGreaterThan(Boolean value) {
			addCriterion("vc_state >", value, "vcState");
			return (Criteria) this;
		}

		public Criteria andVcStateGreaterThanOrEqualTo(Boolean value) {
			addCriterion("vc_state >=", value, "vcState");
			return (Criteria) this;
		}

		public Criteria andVcStateLessThan(Boolean value) {
			addCriterion("vc_state <", value, "vcState");
			return (Criteria) this;
		}

		public Criteria andVcStateLessThanOrEqualTo(Boolean value) {
			addCriterion("vc_state <=", value, "vcState");
			return (Criteria) this;
		}

		public Criteria andVcStateIn(List<Boolean> values) {
			addCriterion("vc_state in", values, "vcState");
			return (Criteria) this;
		}

		public Criteria andVcStateNotIn(List<Boolean> values) {
			addCriterion("vc_state not in", values, "vcState");
			return (Criteria) this;
		}

		public Criteria andVcStateBetween(Boolean value1, Boolean value2) {
			addCriterion("vc_state between", value1, value2, "vcState");
			return (Criteria) this;
		}

		public Criteria andVcStateNotBetween(Boolean value1, Boolean value2) {
			addCriterion("vc_state not between", value1, value2, "vcState");
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