package com.sinco.carnation.shop.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PredepositPfLogExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public PredepositPfLogExample() {
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

		public Criteria andPfLogAmountIsNull() {
			addCriterion("pf_log_amount is null");
			return (Criteria) this;
		}

		public Criteria andPfLogAmountIsNotNull() {
			addCriterion("pf_log_amount is not null");
			return (Criteria) this;
		}

		public Criteria andPfLogAmountEqualTo(BigDecimal value) {
			addCriterion("pf_log_amount =", value, "pfLogAmount");
			return (Criteria) this;
		}

		public Criteria andPfLogAmountNotEqualTo(BigDecimal value) {
			addCriterion("pf_log_amount <>", value, "pfLogAmount");
			return (Criteria) this;
		}

		public Criteria andPfLogAmountGreaterThan(BigDecimal value) {
			addCriterion("pf_log_amount >", value, "pfLogAmount");
			return (Criteria) this;
		}

		public Criteria andPfLogAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("pf_log_amount >=", value, "pfLogAmount");
			return (Criteria) this;
		}

		public Criteria andPfLogAmountLessThan(BigDecimal value) {
			addCriterion("pf_log_amount <", value, "pfLogAmount");
			return (Criteria) this;
		}

		public Criteria andPfLogAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("pf_log_amount <=", value, "pfLogAmount");
			return (Criteria) this;
		}

		public Criteria andPfLogAmountIn(List<BigDecimal> values) {
			addCriterion("pf_log_amount in", values, "pfLogAmount");
			return (Criteria) this;
		}

		public Criteria andPfLogAmountNotIn(List<BigDecimal> values) {
			addCriterion("pf_log_amount not in", values, "pfLogAmount");
			return (Criteria) this;
		}

		public Criteria andPfLogAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("pf_log_amount between", value1, value2, "pfLogAmount");
			return (Criteria) this;
		}

		public Criteria andPfLogAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("pf_log_amount not between", value1, value2, "pfLogAmount");
			return (Criteria) this;
		}

		public Criteria andPfLogUserIdIsNull() {
			addCriterion("pf_log_user_id is null");
			return (Criteria) this;
		}

		public Criteria andPfLogUserIdIsNotNull() {
			addCriterion("pf_log_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andPfLogUserIdEqualTo(Long value) {
			addCriterion("pf_log_user_id =", value, "pfLogUserId");
			return (Criteria) this;
		}

		public Criteria andPfLogUserIdNotEqualTo(Long value) {
			addCriterion("pf_log_user_id <>", value, "pfLogUserId");
			return (Criteria) this;
		}

		public Criteria andPfLogUserIdGreaterThan(Long value) {
			addCriterion("pf_log_user_id >", value, "pfLogUserId");
			return (Criteria) this;
		}

		public Criteria andPfLogUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("pf_log_user_id >=", value, "pfLogUserId");
			return (Criteria) this;
		}

		public Criteria andPfLogUserIdLessThan(Long value) {
			addCriterion("pf_log_user_id <", value, "pfLogUserId");
			return (Criteria) this;
		}

		public Criteria andPfLogUserIdLessThanOrEqualTo(Long value) {
			addCriterion("pf_log_user_id <=", value, "pfLogUserId");
			return (Criteria) this;
		}

		public Criteria andPfLogUserIdIn(List<Long> values) {
			addCriterion("pf_log_user_id in", values, "pfLogUserId");
			return (Criteria) this;
		}

		public Criteria andPfLogUserIdNotIn(List<Long> values) {
			addCriterion("pf_log_user_id not in", values, "pfLogUserId");
			return (Criteria) this;
		}

		public Criteria andPfLogUserIdBetween(Long value1, Long value2) {
			addCriterion("pf_log_user_id between", value1, value2, "pfLogUserId");
			return (Criteria) this;
		}

		public Criteria andPfLogUserIdNotBetween(Long value1, Long value2) {
			addCriterion("pf_log_user_id not between", value1, value2, "pfLogUserId");
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