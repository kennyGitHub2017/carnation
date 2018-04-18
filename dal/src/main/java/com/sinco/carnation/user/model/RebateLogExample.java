package com.sinco.carnation.user.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RebateLogExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public RebateLogExample() {
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

		public Criteria andOrderIdIsNull() {
			addCriterion("order_id is null");
			return (Criteria) this;
		}

		public Criteria andOrderIdIsNotNull() {
			addCriterion("order_id is not null");
			return (Criteria) this;
		}

		public Criteria andOrderIdEqualTo(Long value) {
			addCriterion("order_id =", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotEqualTo(Long value) {
			addCriterion("order_id <>", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdGreaterThan(Long value) {
			addCriterion("order_id >", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
			addCriterion("order_id >=", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdLessThan(Long value) {
			addCriterion("order_id <", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdLessThanOrEqualTo(Long value) {
			addCriterion("order_id <=", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdIn(List<Long> values) {
			addCriterion("order_id in", values, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotIn(List<Long> values) {
			addCriterion("order_id not in", values, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdBetween(Long value1, Long value2) {
			addCriterion("order_id between", value1, value2, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotBetween(Long value1, Long value2) {
			addCriterion("order_id not between", value1, value2, "orderId");
			return (Criteria) this;
		}

		public Criteria andRebateTypeIsNull() {
			addCriterion("rebate_type is null");
			return (Criteria) this;
		}

		public Criteria andRebateTypeIsNotNull() {
			addCriterion("rebate_type is not null");
			return (Criteria) this;
		}

		public Criteria andRebateTypeEqualTo(String value) {
			addCriterion("rebate_type =", value, "rebateType");
			return (Criteria) this;
		}

		public Criteria andRebateTypeNotEqualTo(String value) {
			addCriterion("rebate_type <>", value, "rebateType");
			return (Criteria) this;
		}

		public Criteria andRebateTypeGreaterThan(String value) {
			addCriterion("rebate_type >", value, "rebateType");
			return (Criteria) this;
		}

		public Criteria andRebateTypeGreaterThanOrEqualTo(String value) {
			addCriterion("rebate_type >=", value, "rebateType");
			return (Criteria) this;
		}

		public Criteria andRebateTypeLessThan(String value) {
			addCriterion("rebate_type <", value, "rebateType");
			return (Criteria) this;
		}

		public Criteria andRebateTypeLessThanOrEqualTo(String value) {
			addCriterion("rebate_type <=", value, "rebateType");
			return (Criteria) this;
		}

		public Criteria andRebateTypeLike(String value) {
			addCriterion("rebate_type like", value, "rebateType");
			return (Criteria) this;
		}

		public Criteria andRebateTypeNotLike(String value) {
			addCriterion("rebate_type not like", value, "rebateType");
			return (Criteria) this;
		}

		public Criteria andRebateTypeIn(List<String> values) {
			addCriterion("rebate_type in", values, "rebateType");
			return (Criteria) this;
		}

		public Criteria andRebateTypeNotIn(List<String> values) {
			addCriterion("rebate_type not in", values, "rebateType");
			return (Criteria) this;
		}

		public Criteria andRebateTypeBetween(String value1, String value2) {
			addCriterion("rebate_type between", value1, value2, "rebateType");
			return (Criteria) this;
		}

		public Criteria andRebateTypeNotBetween(String value1, String value2) {
			addCriterion("rebate_type not between", value1, value2, "rebateType");
			return (Criteria) this;
		}

		public Criteria andRebateStatusIsNull() {
			addCriterion("rebate_status is null");
			return (Criteria) this;
		}

		public Criteria andRebateStatusIsNotNull() {
			addCriterion("rebate_status is not null");
			return (Criteria) this;
		}

		public Criteria andRebateStatusEqualTo(Boolean value) {
			addCriterion("rebate_status =", value, "rebateStatus");
			return (Criteria) this;
		}

		public Criteria andRebateStatusNotEqualTo(Boolean value) {
			addCriterion("rebate_status <>", value, "rebateStatus");
			return (Criteria) this;
		}

		public Criteria andRebateStatusGreaterThan(Boolean value) {
			addCriterion("rebate_status >", value, "rebateStatus");
			return (Criteria) this;
		}

		public Criteria andRebateStatusGreaterThanOrEqualTo(Boolean value) {
			addCriterion("rebate_status >=", value, "rebateStatus");
			return (Criteria) this;
		}

		public Criteria andRebateStatusLessThan(Boolean value) {
			addCriterion("rebate_status <", value, "rebateStatus");
			return (Criteria) this;
		}

		public Criteria andRebateStatusLessThanOrEqualTo(Boolean value) {
			addCriterion("rebate_status <=", value, "rebateStatus");
			return (Criteria) this;
		}

		public Criteria andRebateStatusIn(List<Boolean> values) {
			addCriterion("rebate_status in", values, "rebateStatus");
			return (Criteria) this;
		}

		public Criteria andRebateStatusNotIn(List<Boolean> values) {
			addCriterion("rebate_status not in", values, "rebateStatus");
			return (Criteria) this;
		}

		public Criteria andRebateStatusBetween(Boolean value1, Boolean value2) {
			addCriterion("rebate_status between", value1, value2, "rebateStatus");
			return (Criteria) this;
		}

		public Criteria andRebateStatusNotBetween(Boolean value1, Boolean value2) {
			addCriterion("rebate_status not between", value1, value2, "rebateStatus");
			return (Criteria) this;
		}

		public Criteria andErrorMsgIsNull() {
			addCriterion("error_msg is null");
			return (Criteria) this;
		}

		public Criteria andErrorMsgIsNotNull() {
			addCriterion("error_msg is not null");
			return (Criteria) this;
		}

		public Criteria andErrorMsgEqualTo(String value) {
			addCriterion("error_msg =", value, "errorMsg");
			return (Criteria) this;
		}

		public Criteria andErrorMsgNotEqualTo(String value) {
			addCriterion("error_msg <>", value, "errorMsg");
			return (Criteria) this;
		}

		public Criteria andErrorMsgGreaterThan(String value) {
			addCriterion("error_msg >", value, "errorMsg");
			return (Criteria) this;
		}

		public Criteria andErrorMsgGreaterThanOrEqualTo(String value) {
			addCriterion("error_msg >=", value, "errorMsg");
			return (Criteria) this;
		}

		public Criteria andErrorMsgLessThan(String value) {
			addCriterion("error_msg <", value, "errorMsg");
			return (Criteria) this;
		}

		public Criteria andErrorMsgLessThanOrEqualTo(String value) {
			addCriterion("error_msg <=", value, "errorMsg");
			return (Criteria) this;
		}

		public Criteria andErrorMsgLike(String value) {
			addCriterion("error_msg like", value, "errorMsg");
			return (Criteria) this;
		}

		public Criteria andErrorMsgNotLike(String value) {
			addCriterion("error_msg not like", value, "errorMsg");
			return (Criteria) this;
		}

		public Criteria andErrorMsgIn(List<String> values) {
			addCriterion("error_msg in", values, "errorMsg");
			return (Criteria) this;
		}

		public Criteria andErrorMsgNotIn(List<String> values) {
			addCriterion("error_msg not in", values, "errorMsg");
			return (Criteria) this;
		}

		public Criteria andErrorMsgBetween(String value1, String value2) {
			addCriterion("error_msg between", value1, value2, "errorMsg");
			return (Criteria) this;
		}

		public Criteria andErrorMsgNotBetween(String value1, String value2) {
			addCriterion("error_msg not between", value1, value2, "errorMsg");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNull() {
			addCriterion("create_time is null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNotNull() {
			addCriterion("create_time is not null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeEqualTo(Date value) {
			addCriterion("create_time =", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotEqualTo(Date value) {
			addCriterion("create_time <>", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThan(Date value) {
			addCriterion("create_time >", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("create_time >=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThan(Date value) {
			addCriterion("create_time <", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
			addCriterion("create_time <=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIn(List<Date> values) {
			addCriterion("create_time in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotIn(List<Date> values) {
			addCriterion("create_time not in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeBetween(Date value1, Date value2) {
			addCriterion("create_time between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
			addCriterion("create_time not between", value1, value2, "createTime");
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