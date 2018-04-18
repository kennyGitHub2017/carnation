package com.sinco.carnation.store.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComsumeExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public ComsumeExample() {
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

		public Criteria andCouponPayAmountIsNull() {
			addCriterion("coupon_pay_amount is null");
			return (Criteria) this;
		}

		public Criteria andCouponPayAmountIsNotNull() {
			addCriterion("coupon_pay_amount is not null");
			return (Criteria) this;
		}

		public Criteria andCouponPayAmountEqualTo(BigDecimal value) {
			addCriterion("coupon_pay_amount =", value, "couponPayAmount");
			return (Criteria) this;
		}

		public Criteria andCouponPayAmountNotEqualTo(BigDecimal value) {
			addCriterion("coupon_pay_amount <>", value, "couponPayAmount");
			return (Criteria) this;
		}

		public Criteria andCouponPayAmountGreaterThan(BigDecimal value) {
			addCriterion("coupon_pay_amount >", value, "couponPayAmount");
			return (Criteria) this;
		}

		public Criteria andCouponPayAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("coupon_pay_amount >=", value, "couponPayAmount");
			return (Criteria) this;
		}

		public Criteria andCouponPayAmountLessThan(BigDecimal value) {
			addCriterion("coupon_pay_amount <", value, "couponPayAmount");
			return (Criteria) this;
		}

		public Criteria andCouponPayAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("coupon_pay_amount <=", value, "couponPayAmount");
			return (Criteria) this;
		}

		public Criteria andCouponPayAmountIn(List<BigDecimal> values) {
			addCriterion("coupon_pay_amount in", values, "couponPayAmount");
			return (Criteria) this;
		}

		public Criteria andCouponPayAmountNotIn(List<BigDecimal> values) {
			addCriterion("coupon_pay_amount not in", values, "couponPayAmount");
			return (Criteria) this;
		}

		public Criteria andCouponPayAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("coupon_pay_amount between", value1, value2, "couponPayAmount");
			return (Criteria) this;
		}

		public Criteria andCouponPayAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("coupon_pay_amount not between", value1, value2, "couponPayAmount");
			return (Criteria) this;
		}

		public Criteria andChargePayAmountIsNull() {
			addCriterion("charge_pay_amount is null");
			return (Criteria) this;
		}

		public Criteria andChargePayAmountIsNotNull() {
			addCriterion("charge_pay_amount is not null");
			return (Criteria) this;
		}

		public Criteria andChargePayAmountEqualTo(BigDecimal value) {
			addCriterion("charge_pay_amount =", value, "chargePayAmount");
			return (Criteria) this;
		}

		public Criteria andChargePayAmountNotEqualTo(BigDecimal value) {
			addCriterion("charge_pay_amount <>", value, "chargePayAmount");
			return (Criteria) this;
		}

		public Criteria andChargePayAmountGreaterThan(BigDecimal value) {
			addCriterion("charge_pay_amount >", value, "chargePayAmount");
			return (Criteria) this;
		}

		public Criteria andChargePayAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("charge_pay_amount >=", value, "chargePayAmount");
			return (Criteria) this;
		}

		public Criteria andChargePayAmountLessThan(BigDecimal value) {
			addCriterion("charge_pay_amount <", value, "chargePayAmount");
			return (Criteria) this;
		}

		public Criteria andChargePayAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("charge_pay_amount <=", value, "chargePayAmount");
			return (Criteria) this;
		}

		public Criteria andChargePayAmountIn(List<BigDecimal> values) {
			addCriterion("charge_pay_amount in", values, "chargePayAmount");
			return (Criteria) this;
		}

		public Criteria andChargePayAmountNotIn(List<BigDecimal> values) {
			addCriterion("charge_pay_amount not in", values, "chargePayAmount");
			return (Criteria) this;
		}

		public Criteria andChargePayAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("charge_pay_amount between", value1, value2, "chargePayAmount");
			return (Criteria) this;
		}

		public Criteria andChargePayAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("charge_pay_amount not between", value1, value2, "chargePayAmount");
			return (Criteria) this;
		}

		public Criteria andRebateAmountIsNull() {
			addCriterion("rebate_amount is null");
			return (Criteria) this;
		}

		public Criteria andRebateAmountIsNotNull() {
			addCriterion("rebate_amount is not null");
			return (Criteria) this;
		}

		public Criteria andRebateAmountEqualTo(BigDecimal value) {
			addCriterion("rebate_amount =", value, "rebateAmount");
			return (Criteria) this;
		}

		public Criteria andRebateAmountNotEqualTo(BigDecimal value) {
			addCriterion("rebate_amount <>", value, "rebateAmount");
			return (Criteria) this;
		}

		public Criteria andRebateAmountGreaterThan(BigDecimal value) {
			addCriterion("rebate_amount >", value, "rebateAmount");
			return (Criteria) this;
		}

		public Criteria andRebateAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_amount >=", value, "rebateAmount");
			return (Criteria) this;
		}

		public Criteria andRebateAmountLessThan(BigDecimal value) {
			addCriterion("rebate_amount <", value, "rebateAmount");
			return (Criteria) this;
		}

		public Criteria andRebateAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_amount <=", value, "rebateAmount");
			return (Criteria) this;
		}

		public Criteria andRebateAmountIn(List<BigDecimal> values) {
			addCriterion("rebate_amount in", values, "rebateAmount");
			return (Criteria) this;
		}

		public Criteria andRebateAmountNotIn(List<BigDecimal> values) {
			addCriterion("rebate_amount not in", values, "rebateAmount");
			return (Criteria) this;
		}

		public Criteria andRebateAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_amount between", value1, value2, "rebateAmount");
			return (Criteria) this;
		}

		public Criteria andRebateAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_amount not between", value1, value2, "rebateAmount");
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

		public Criteria andStoreIdIsNull() {
			addCriterion("store_id is null");
			return (Criteria) this;
		}

		public Criteria andStoreIdIsNotNull() {
			addCriterion("store_id is not null");
			return (Criteria) this;
		}

		public Criteria andStoreIdEqualTo(Long value) {
			addCriterion("store_id =", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdNotEqualTo(Long value) {
			addCriterion("store_id <>", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdGreaterThan(Long value) {
			addCriterion("store_id >", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
			addCriterion("store_id >=", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdLessThan(Long value) {
			addCriterion("store_id <", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdLessThanOrEqualTo(Long value) {
			addCriterion("store_id <=", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdIn(List<Long> values) {
			addCriterion("store_id in", values, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdNotIn(List<Long> values) {
			addCriterion("store_id not in", values, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdBetween(Long value1, Long value2) {
			addCriterion("store_id between", value1, value2, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdNotBetween(Long value1, Long value2) {
			addCriterion("store_id not between", value1, value2, "storeId");
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