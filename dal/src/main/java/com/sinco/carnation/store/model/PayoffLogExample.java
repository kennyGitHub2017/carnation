package com.sinco.carnation.store.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PayoffLogExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public PayoffLogExample() {
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

		public Criteria andDeleteStatusEqualTo(Boolean value) {
			addCriterion("delete_status =", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotEqualTo(Boolean value) {
			addCriterion("delete_status <>", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThan(Boolean value) {
			addCriterion("delete_status >", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThanOrEqualTo(Boolean value) {
			addCriterion("delete_status >=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThan(Boolean value) {
			addCriterion("delete_status <", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThanOrEqualTo(Boolean value) {
			addCriterion("delete_status <=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusIn(List<Boolean> values) {
			addCriterion("delete_status in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotIn(List<Boolean> values) {
			addCriterion("delete_status not in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusBetween(Boolean value1, Boolean value2) {
			addCriterion("delete_status between", value1, value2, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotBetween(Boolean value1, Boolean value2) {
			addCriterion("delete_status not between", value1, value2, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andApplyTimeIsNull() {
			addCriterion("apply_time is null");
			return (Criteria) this;
		}

		public Criteria andApplyTimeIsNotNull() {
			addCriterion("apply_time is not null");
			return (Criteria) this;
		}

		public Criteria andApplyTimeEqualTo(Date value) {
			addCriterion("apply_time =", value, "applyTime");
			return (Criteria) this;
		}

		public Criteria andApplyTimeNotEqualTo(Date value) {
			addCriterion("apply_time <>", value, "applyTime");
			return (Criteria) this;
		}

		public Criteria andApplyTimeGreaterThan(Date value) {
			addCriterion("apply_time >", value, "applyTime");
			return (Criteria) this;
		}

		public Criteria andApplyTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("apply_time >=", value, "applyTime");
			return (Criteria) this;
		}

		public Criteria andApplyTimeLessThan(Date value) {
			addCriterion("apply_time <", value, "applyTime");
			return (Criteria) this;
		}

		public Criteria andApplyTimeLessThanOrEqualTo(Date value) {
			addCriterion("apply_time <=", value, "applyTime");
			return (Criteria) this;
		}

		public Criteria andApplyTimeIn(List<Date> values) {
			addCriterion("apply_time in", values, "applyTime");
			return (Criteria) this;
		}

		public Criteria andApplyTimeNotIn(List<Date> values) {
			addCriterion("apply_time not in", values, "applyTime");
			return (Criteria) this;
		}

		public Criteria andApplyTimeBetween(Date value1, Date value2) {
			addCriterion("apply_time between", value1, value2, "applyTime");
			return (Criteria) this;
		}

		public Criteria andApplyTimeNotBetween(Date value1, Date value2) {
			addCriterion("apply_time not between", value1, value2, "applyTime");
			return (Criteria) this;
		}

		public Criteria andCommissionAmountIsNull() {
			addCriterion("commission_amount is null");
			return (Criteria) this;
		}

		public Criteria andCommissionAmountIsNotNull() {
			addCriterion("commission_amount is not null");
			return (Criteria) this;
		}

		public Criteria andCommissionAmountEqualTo(BigDecimal value) {
			addCriterion("commission_amount =", value, "commissionAmount");
			return (Criteria) this;
		}

		public Criteria andCommissionAmountNotEqualTo(BigDecimal value) {
			addCriterion("commission_amount <>", value, "commissionAmount");
			return (Criteria) this;
		}

		public Criteria andCommissionAmountGreaterThan(BigDecimal value) {
			addCriterion("commission_amount >", value, "commissionAmount");
			return (Criteria) this;
		}

		public Criteria andCommissionAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("commission_amount >=", value, "commissionAmount");
			return (Criteria) this;
		}

		public Criteria andCommissionAmountLessThan(BigDecimal value) {
			addCriterion("commission_amount <", value, "commissionAmount");
			return (Criteria) this;
		}

		public Criteria andCommissionAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("commission_amount <=", value, "commissionAmount");
			return (Criteria) this;
		}

		public Criteria andCommissionAmountIn(List<BigDecimal> values) {
			addCriterion("commission_amount in", values, "commissionAmount");
			return (Criteria) this;
		}

		public Criteria andCommissionAmountNotIn(List<BigDecimal> values) {
			addCriterion("commission_amount not in", values, "commissionAmount");
			return (Criteria) this;
		}

		public Criteria andCommissionAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("commission_amount between", value1, value2, "commissionAmount");
			return (Criteria) this;
		}

		public Criteria andCommissionAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("commission_amount not between", value1, value2, "commissionAmount");
			return (Criteria) this;
		}

		public Criteria andCompleteTimeIsNull() {
			addCriterion("complete_time is null");
			return (Criteria) this;
		}

		public Criteria andCompleteTimeIsNotNull() {
			addCriterion("complete_time is not null");
			return (Criteria) this;
		}

		public Criteria andCompleteTimeEqualTo(Date value) {
			addCriterion("complete_time =", value, "completeTime");
			return (Criteria) this;
		}

		public Criteria andCompleteTimeNotEqualTo(Date value) {
			addCriterion("complete_time <>", value, "completeTime");
			return (Criteria) this;
		}

		public Criteria andCompleteTimeGreaterThan(Date value) {
			addCriterion("complete_time >", value, "completeTime");
			return (Criteria) this;
		}

		public Criteria andCompleteTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("complete_time >=", value, "completeTime");
			return (Criteria) this;
		}

		public Criteria andCompleteTimeLessThan(Date value) {
			addCriterion("complete_time <", value, "completeTime");
			return (Criteria) this;
		}

		public Criteria andCompleteTimeLessThanOrEqualTo(Date value) {
			addCriterion("complete_time <=", value, "completeTime");
			return (Criteria) this;
		}

		public Criteria andCompleteTimeIn(List<Date> values) {
			addCriterion("complete_time in", values, "completeTime");
			return (Criteria) this;
		}

		public Criteria andCompleteTimeNotIn(List<Date> values) {
			addCriterion("complete_time not in", values, "completeTime");
			return (Criteria) this;
		}

		public Criteria andCompleteTimeBetween(Date value1, Date value2) {
			addCriterion("complete_time between", value1, value2, "completeTime");
			return (Criteria) this;
		}

		public Criteria andCompleteTimeNotBetween(Date value1, Date value2) {
			addCriterion("complete_time not between", value1, value2, "completeTime");
			return (Criteria) this;
		}

		public Criteria andFinanceUserNameIsNull() {
			addCriterion("finance_user_name is null");
			return (Criteria) this;
		}

		public Criteria andFinanceUserNameIsNotNull() {
			addCriterion("finance_user_name is not null");
			return (Criteria) this;
		}

		public Criteria andFinanceUserNameEqualTo(String value) {
			addCriterion("finance_user_name =", value, "financeUserName");
			return (Criteria) this;
		}

		public Criteria andFinanceUserNameNotEqualTo(String value) {
			addCriterion("finance_user_name <>", value, "financeUserName");
			return (Criteria) this;
		}

		public Criteria andFinanceUserNameGreaterThan(String value) {
			addCriterion("finance_user_name >", value, "financeUserName");
			return (Criteria) this;
		}

		public Criteria andFinanceUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("finance_user_name >=", value, "financeUserName");
			return (Criteria) this;
		}

		public Criteria andFinanceUserNameLessThan(String value) {
			addCriterion("finance_user_name <", value, "financeUserName");
			return (Criteria) this;
		}

		public Criteria andFinanceUserNameLessThanOrEqualTo(String value) {
			addCriterion("finance_user_name <=", value, "financeUserName");
			return (Criteria) this;
		}

		public Criteria andFinanceUserNameLike(String value) {
			addCriterion("finance_user_name like", value, "financeUserName");
			return (Criteria) this;
		}

		public Criteria andFinanceUserNameNotLike(String value) {
			addCriterion("finance_user_name not like", value, "financeUserName");
			return (Criteria) this;
		}

		public Criteria andFinanceUserNameIn(List<String> values) {
			addCriterion("finance_user_name in", values, "financeUserName");
			return (Criteria) this;
		}

		public Criteria andFinanceUserNameNotIn(List<String> values) {
			addCriterion("finance_user_name not in", values, "financeUserName");
			return (Criteria) this;
		}

		public Criteria andFinanceUserNameBetween(String value1, String value2) {
			addCriterion("finance_user_name between", value1, value2, "financeUserName");
			return (Criteria) this;
		}

		public Criteria andFinanceUserNameNotBetween(String value1, String value2) {
			addCriterion("finance_user_name not between", value1, value2, "financeUserName");
			return (Criteria) this;
		}

		public Criteria andOIdIsNull() {
			addCriterion("o_id is null");
			return (Criteria) this;
		}

		public Criteria andOIdIsNotNull() {
			addCriterion("o_id is not null");
			return (Criteria) this;
		}

		public Criteria andOIdEqualTo(String value) {
			addCriterion("o_id =", value, "oId");
			return (Criteria) this;
		}

		public Criteria andOIdNotEqualTo(String value) {
			addCriterion("o_id <>", value, "oId");
			return (Criteria) this;
		}

		public Criteria andOIdGreaterThan(String value) {
			addCriterion("o_id >", value, "oId");
			return (Criteria) this;
		}

		public Criteria andOIdGreaterThanOrEqualTo(String value) {
			addCriterion("o_id >=", value, "oId");
			return (Criteria) this;
		}

		public Criteria andOIdLessThan(String value) {
			addCriterion("o_id <", value, "oId");
			return (Criteria) this;
		}

		public Criteria andOIdLessThanOrEqualTo(String value) {
			addCriterion("o_id <=", value, "oId");
			return (Criteria) this;
		}

		public Criteria andOIdLike(String value) {
			addCriterion("o_id like", value, "oId");
			return (Criteria) this;
		}

		public Criteria andOIdNotLike(String value) {
			addCriterion("o_id not like", value, "oId");
			return (Criteria) this;
		}

		public Criteria andOIdIn(List<String> values) {
			addCriterion("o_id in", values, "oId");
			return (Criteria) this;
		}

		public Criteria andOIdNotIn(List<String> values) {
			addCriterion("o_id not in", values, "oId");
			return (Criteria) this;
		}

		public Criteria andOIdBetween(String value1, String value2) {
			addCriterion("o_id between", value1, value2, "oId");
			return (Criteria) this;
		}

		public Criteria andOIdNotBetween(String value1, String value2) {
			addCriterion("o_id not between", value1, value2, "oId");
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

		public Criteria andOrderIdEqualTo(String value) {
			addCriterion("order_id =", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotEqualTo(String value) {
			addCriterion("order_id <>", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdGreaterThan(String value) {
			addCriterion("order_id >", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
			addCriterion("order_id >=", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdLessThan(String value) {
			addCriterion("order_id <", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdLessThanOrEqualTo(String value) {
			addCriterion("order_id <=", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdLike(String value) {
			addCriterion("order_id like", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotLike(String value) {
			addCriterion("order_id not like", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdIn(List<String> values) {
			addCriterion("order_id in", values, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotIn(List<String> values) {
			addCriterion("order_id not in", values, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdBetween(String value1, String value2) {
			addCriterion("order_id between", value1, value2, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotBetween(String value1, String value2) {
			addCriterion("order_id not between", value1, value2, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderTotalPriceIsNull() {
			addCriterion("order_total_price is null");
			return (Criteria) this;
		}

		public Criteria andOrderTotalPriceIsNotNull() {
			addCriterion("order_total_price is not null");
			return (Criteria) this;
		}

		public Criteria andOrderTotalPriceEqualTo(BigDecimal value) {
			addCriterion("order_total_price =", value, "orderTotalPrice");
			return (Criteria) this;
		}

		public Criteria andOrderTotalPriceNotEqualTo(BigDecimal value) {
			addCriterion("order_total_price <>", value, "orderTotalPrice");
			return (Criteria) this;
		}

		public Criteria andOrderTotalPriceGreaterThan(BigDecimal value) {
			addCriterion("order_total_price >", value, "orderTotalPrice");
			return (Criteria) this;
		}

		public Criteria andOrderTotalPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("order_total_price >=", value, "orderTotalPrice");
			return (Criteria) this;
		}

		public Criteria andOrderTotalPriceLessThan(BigDecimal value) {
			addCriterion("order_total_price <", value, "orderTotalPrice");
			return (Criteria) this;
		}

		public Criteria andOrderTotalPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("order_total_price <=", value, "orderTotalPrice");
			return (Criteria) this;
		}

		public Criteria andOrderTotalPriceIn(List<BigDecimal> values) {
			addCriterion("order_total_price in", values, "orderTotalPrice");
			return (Criteria) this;
		}

		public Criteria andOrderTotalPriceNotIn(List<BigDecimal> values) {
			addCriterion("order_total_price not in", values, "orderTotalPrice");
			return (Criteria) this;
		}

		public Criteria andOrderTotalPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("order_total_price between", value1, value2, "orderTotalPrice");
			return (Criteria) this;
		}

		public Criteria andOrderTotalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("order_total_price not between", value1, value2, "orderTotalPrice");
			return (Criteria) this;
		}

		public Criteria andPayoffTypeIsNull() {
			addCriterion("payoff_type is null");
			return (Criteria) this;
		}

		public Criteria andPayoffTypeIsNotNull() {
			addCriterion("payoff_type is not null");
			return (Criteria) this;
		}

		public Criteria andPayoffTypeEqualTo(Integer value) {
			addCriterion("payoff_type =", value, "payoffType");
			return (Criteria) this;
		}

		public Criteria andPayoffTypeNotEqualTo(Integer value) {
			addCriterion("payoff_type <>", value, "payoffType");
			return (Criteria) this;
		}

		public Criteria andPayoffTypeGreaterThan(Integer value) {
			addCriterion("payoff_type >", value, "payoffType");
			return (Criteria) this;
		}

		public Criteria andPayoffTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("payoff_type >=", value, "payoffType");
			return (Criteria) this;
		}

		public Criteria andPayoffTypeLessThan(Integer value) {
			addCriterion("payoff_type <", value, "payoffType");
			return (Criteria) this;
		}

		public Criteria andPayoffTypeLessThanOrEqualTo(Integer value) {
			addCriterion("payoff_type <=", value, "payoffType");
			return (Criteria) this;
		}

		public Criteria andPayoffTypeIn(List<Integer> values) {
			addCriterion("payoff_type in", values, "payoffType");
			return (Criteria) this;
		}

		public Criteria andPayoffTypeNotIn(List<Integer> values) {
			addCriterion("payoff_type not in", values, "payoffType");
			return (Criteria) this;
		}

		public Criteria andPayoffTypeBetween(Integer value1, Integer value2) {
			addCriterion("payoff_type between", value1, value2, "payoffType");
			return (Criteria) this;
		}

		public Criteria andPayoffTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("payoff_type not between", value1, value2, "payoffType");
			return (Criteria) this;
		}

		public Criteria andPlInfoIsNull() {
			addCriterion("pl_info is null");
			return (Criteria) this;
		}

		public Criteria andPlInfoIsNotNull() {
			addCriterion("pl_info is not null");
			return (Criteria) this;
		}

		public Criteria andPlInfoEqualTo(String value) {
			addCriterion("pl_info =", value, "plInfo");
			return (Criteria) this;
		}

		public Criteria andPlInfoNotEqualTo(String value) {
			addCriterion("pl_info <>", value, "plInfo");
			return (Criteria) this;
		}

		public Criteria andPlInfoGreaterThan(String value) {
			addCriterion("pl_info >", value, "plInfo");
			return (Criteria) this;
		}

		public Criteria andPlInfoGreaterThanOrEqualTo(String value) {
			addCriterion("pl_info >=", value, "plInfo");
			return (Criteria) this;
		}

		public Criteria andPlInfoLessThan(String value) {
			addCriterion("pl_info <", value, "plInfo");
			return (Criteria) this;
		}

		public Criteria andPlInfoLessThanOrEqualTo(String value) {
			addCriterion("pl_info <=", value, "plInfo");
			return (Criteria) this;
		}

		public Criteria andPlInfoLike(String value) {
			addCriterion("pl_info like", value, "plInfo");
			return (Criteria) this;
		}

		public Criteria andPlInfoNotLike(String value) {
			addCriterion("pl_info not like", value, "plInfo");
			return (Criteria) this;
		}

		public Criteria andPlInfoIn(List<String> values) {
			addCriterion("pl_info in", values, "plInfo");
			return (Criteria) this;
		}

		public Criteria andPlInfoNotIn(List<String> values) {
			addCriterion("pl_info not in", values, "plInfo");
			return (Criteria) this;
		}

		public Criteria andPlInfoBetween(String value1, String value2) {
			addCriterion("pl_info between", value1, value2, "plInfo");
			return (Criteria) this;
		}

		public Criteria andPlInfoNotBetween(String value1, String value2) {
			addCriterion("pl_info not between", value1, value2, "plInfo");
			return (Criteria) this;
		}

		public Criteria andPlSnIsNull() {
			addCriterion("pl_sn is null");
			return (Criteria) this;
		}

		public Criteria andPlSnIsNotNull() {
			addCriterion("pl_sn is not null");
			return (Criteria) this;
		}

		public Criteria andPlSnEqualTo(String value) {
			addCriterion("pl_sn =", value, "plSn");
			return (Criteria) this;
		}

		public Criteria andPlSnNotEqualTo(String value) {
			addCriterion("pl_sn <>", value, "plSn");
			return (Criteria) this;
		}

		public Criteria andPlSnGreaterThan(String value) {
			addCriterion("pl_sn >", value, "plSn");
			return (Criteria) this;
		}

		public Criteria andPlSnGreaterThanOrEqualTo(String value) {
			addCriterion("pl_sn >=", value, "plSn");
			return (Criteria) this;
		}

		public Criteria andPlSnLessThan(String value) {
			addCriterion("pl_sn <", value, "plSn");
			return (Criteria) this;
		}

		public Criteria andPlSnLessThanOrEqualTo(String value) {
			addCriterion("pl_sn <=", value, "plSn");
			return (Criteria) this;
		}

		public Criteria andPlSnLike(String value) {
			addCriterion("pl_sn like", value, "plSn");
			return (Criteria) this;
		}

		public Criteria andPlSnNotLike(String value) {
			addCriterion("pl_sn not like", value, "plSn");
			return (Criteria) this;
		}

		public Criteria andPlSnIn(List<String> values) {
			addCriterion("pl_sn in", values, "plSn");
			return (Criteria) this;
		}

		public Criteria andPlSnNotIn(List<String> values) {
			addCriterion("pl_sn not in", values, "plSn");
			return (Criteria) this;
		}

		public Criteria andPlSnBetween(String value1, String value2) {
			addCriterion("pl_sn between", value1, value2, "plSn");
			return (Criteria) this;
		}

		public Criteria andPlSnNotBetween(String value1, String value2) {
			addCriterion("pl_sn not between", value1, value2, "plSn");
			return (Criteria) this;
		}

		public Criteria andRealityAmountIsNull() {
			addCriterion("reality_amount is null");
			return (Criteria) this;
		}

		public Criteria andRealityAmountIsNotNull() {
			addCriterion("reality_amount is not null");
			return (Criteria) this;
		}

		public Criteria andRealityAmountEqualTo(BigDecimal value) {
			addCriterion("reality_amount =", value, "realityAmount");
			return (Criteria) this;
		}

		public Criteria andRealityAmountNotEqualTo(BigDecimal value) {
			addCriterion("reality_amount <>", value, "realityAmount");
			return (Criteria) this;
		}

		public Criteria andRealityAmountGreaterThan(BigDecimal value) {
			addCriterion("reality_amount >", value, "realityAmount");
			return (Criteria) this;
		}

		public Criteria andRealityAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("reality_amount >=", value, "realityAmount");
			return (Criteria) this;
		}

		public Criteria andRealityAmountLessThan(BigDecimal value) {
			addCriterion("reality_amount <", value, "realityAmount");
			return (Criteria) this;
		}

		public Criteria andRealityAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("reality_amount <=", value, "realityAmount");
			return (Criteria) this;
		}

		public Criteria andRealityAmountIn(List<BigDecimal> values) {
			addCriterion("reality_amount in", values, "realityAmount");
			return (Criteria) this;
		}

		public Criteria andRealityAmountNotIn(List<BigDecimal> values) {
			addCriterion("reality_amount not in", values, "realityAmount");
			return (Criteria) this;
		}

		public Criteria andRealityAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("reality_amount between", value1, value2, "realityAmount");
			return (Criteria) this;
		}

		public Criteria andRealityAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("reality_amount not between", value1, value2, "realityAmount");
			return (Criteria) this;
		}

		public Criteria andRefundUserNameIsNull() {
			addCriterion("refund_user_name is null");
			return (Criteria) this;
		}

		public Criteria andRefundUserNameIsNotNull() {
			addCriterion("refund_user_name is not null");
			return (Criteria) this;
		}

		public Criteria andRefundUserNameEqualTo(String value) {
			addCriterion("refund_user_name =", value, "refundUserName");
			return (Criteria) this;
		}

		public Criteria andRefundUserNameNotEqualTo(String value) {
			addCriterion("refund_user_name <>", value, "refundUserName");
			return (Criteria) this;
		}

		public Criteria andRefundUserNameGreaterThan(String value) {
			addCriterion("refund_user_name >", value, "refundUserName");
			return (Criteria) this;
		}

		public Criteria andRefundUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("refund_user_name >=", value, "refundUserName");
			return (Criteria) this;
		}

		public Criteria andRefundUserNameLessThan(String value) {
			addCriterion("refund_user_name <", value, "refundUserName");
			return (Criteria) this;
		}

		public Criteria andRefundUserNameLessThanOrEqualTo(String value) {
			addCriterion("refund_user_name <=", value, "refundUserName");
			return (Criteria) this;
		}

		public Criteria andRefundUserNameLike(String value) {
			addCriterion("refund_user_name like", value, "refundUserName");
			return (Criteria) this;
		}

		public Criteria andRefundUserNameNotLike(String value) {
			addCriterion("refund_user_name not like", value, "refundUserName");
			return (Criteria) this;
		}

		public Criteria andRefundUserNameIn(List<String> values) {
			addCriterion("refund_user_name in", values, "refundUserName");
			return (Criteria) this;
		}

		public Criteria andRefundUserNameNotIn(List<String> values) {
			addCriterion("refund_user_name not in", values, "refundUserName");
			return (Criteria) this;
		}

		public Criteria andRefundUserNameBetween(String value1, String value2) {
			addCriterion("refund_user_name between", value1, value2, "refundUserName");
			return (Criteria) this;
		}

		public Criteria andRefundUserNameNotBetween(String value1, String value2) {
			addCriterion("refund_user_name not between", value1, value2, "refundUserName");
			return (Criteria) this;
		}

		public Criteria andRefundUserIdIsNull() {
			addCriterion("refund_user_id is null");
			return (Criteria) this;
		}

		public Criteria andRefundUserIdIsNotNull() {
			addCriterion("refund_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andRefundUserIdEqualTo(Long value) {
			addCriterion("refund_user_id =", value, "refundUserId");
			return (Criteria) this;
		}

		public Criteria andRefundUserIdNotEqualTo(Long value) {
			addCriterion("refund_user_id <>", value, "refundUserId");
			return (Criteria) this;
		}

		public Criteria andRefundUserIdGreaterThan(Long value) {
			addCriterion("refund_user_id >", value, "refundUserId");
			return (Criteria) this;
		}

		public Criteria andRefundUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("refund_user_id >=", value, "refundUserId");
			return (Criteria) this;
		}

		public Criteria andRefundUserIdLessThan(Long value) {
			addCriterion("refund_user_id <", value, "refundUserId");
			return (Criteria) this;
		}

		public Criteria andRefundUserIdLessThanOrEqualTo(Long value) {
			addCriterion("refund_user_id <=", value, "refundUserId");
			return (Criteria) this;
		}

		public Criteria andRefundUserIdIn(List<Long> values) {
			addCriterion("refund_user_id in", values, "refundUserId");
			return (Criteria) this;
		}

		public Criteria andRefundUserIdNotIn(List<Long> values) {
			addCriterion("refund_user_id not in", values, "refundUserId");
			return (Criteria) this;
		}

		public Criteria andRefundUserIdBetween(Long value1, Long value2) {
			addCriterion("refund_user_id between", value1, value2, "refundUserId");
			return (Criteria) this;
		}

		public Criteria andRefundUserIdNotBetween(Long value1, Long value2) {
			addCriterion("refund_user_id not between", value1, value2, "refundUserId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdIsNull() {
			addCriterion("return_service_id is null");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdIsNotNull() {
			addCriterion("return_service_id is not null");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdEqualTo(String value) {
			addCriterion("return_service_id =", value, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdNotEqualTo(String value) {
			addCriterion("return_service_id <>", value, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdGreaterThan(String value) {
			addCriterion("return_service_id >", value, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdGreaterThanOrEqualTo(String value) {
			addCriterion("return_service_id >=", value, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdLessThan(String value) {
			addCriterion("return_service_id <", value, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdLessThanOrEqualTo(String value) {
			addCriterion("return_service_id <=", value, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdLike(String value) {
			addCriterion("return_service_id like", value, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdNotLike(String value) {
			addCriterion("return_service_id not like", value, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdIn(List<String> values) {
			addCriterion("return_service_id in", values, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdNotIn(List<String> values) {
			addCriterion("return_service_id not in", values, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdBetween(String value1, String value2) {
			addCriterion("return_service_id between", value1, value2, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andReturnServiceIdNotBetween(String value1, String value2) {
			addCriterion("return_service_id not between", value1, value2, "returnServiceId");
			return (Criteria) this;
		}

		public Criteria andStatusIsNull() {
			addCriterion("status is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("status is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(Integer value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(Integer value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(Integer value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(Integer value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(Integer value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<Integer> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<Integer> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(Integer value1, Integer value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("status not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andTotalAmountIsNull() {
			addCriterion("total_amount is null");
			return (Criteria) this;
		}

		public Criteria andTotalAmountIsNotNull() {
			addCriterion("total_amount is not null");
			return (Criteria) this;
		}

		public Criteria andTotalAmountEqualTo(BigDecimal value) {
			addCriterion("total_amount =", value, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountNotEqualTo(BigDecimal value) {
			addCriterion("total_amount <>", value, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountGreaterThan(BigDecimal value) {
			addCriterion("total_amount >", value, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("total_amount >=", value, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountLessThan(BigDecimal value) {
			addCriterion("total_amount <", value, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("total_amount <=", value, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountIn(List<BigDecimal> values) {
			addCriterion("total_amount in", values, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountNotIn(List<BigDecimal> values) {
			addCriterion("total_amount not in", values, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("total_amount between", value1, value2, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("total_amount not between", value1, value2, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andAdminIdIsNull() {
			addCriterion("admin_id is null");
			return (Criteria) this;
		}

		public Criteria andAdminIdIsNotNull() {
			addCriterion("admin_id is not null");
			return (Criteria) this;
		}

		public Criteria andAdminIdEqualTo(Long value) {
			addCriterion("admin_id =", value, "adminId");
			return (Criteria) this;
		}

		public Criteria andAdminIdNotEqualTo(Long value) {
			addCriterion("admin_id <>", value, "adminId");
			return (Criteria) this;
		}

		public Criteria andAdminIdGreaterThan(Long value) {
			addCriterion("admin_id >", value, "adminId");
			return (Criteria) this;
		}

		public Criteria andAdminIdGreaterThanOrEqualTo(Long value) {
			addCriterion("admin_id >=", value, "adminId");
			return (Criteria) this;
		}

		public Criteria andAdminIdLessThan(Long value) {
			addCriterion("admin_id <", value, "adminId");
			return (Criteria) this;
		}

		public Criteria andAdminIdLessThanOrEqualTo(Long value) {
			addCriterion("admin_id <=", value, "adminId");
			return (Criteria) this;
		}

		public Criteria andAdminIdIn(List<Long> values) {
			addCriterion("admin_id in", values, "adminId");
			return (Criteria) this;
		}

		public Criteria andAdminIdNotIn(List<Long> values) {
			addCriterion("admin_id not in", values, "adminId");
			return (Criteria) this;
		}

		public Criteria andAdminIdBetween(Long value1, Long value2) {
			addCriterion("admin_id between", value1, value2, "adminId");
			return (Criteria) this;
		}

		public Criteria andAdminIdNotBetween(Long value1, Long value2) {
			addCriterion("admin_id not between", value1, value2, "adminId");
			return (Criteria) this;
		}

		public Criteria andSellerIdIsNull() {
			addCriterion("seller_id is null");
			return (Criteria) this;
		}

		public Criteria andSellerIdIsNotNull() {
			addCriterion("seller_id is not null");
			return (Criteria) this;
		}

		public Criteria andSellerIdEqualTo(Long value) {
			addCriterion("seller_id =", value, "sellerId");
			return (Criteria) this;
		}

		public Criteria andSellerIdNotEqualTo(Long value) {
			addCriterion("seller_id <>", value, "sellerId");
			return (Criteria) this;
		}

		public Criteria andSellerIdGreaterThan(Long value) {
			addCriterion("seller_id >", value, "sellerId");
			return (Criteria) this;
		}

		public Criteria andSellerIdGreaterThanOrEqualTo(Long value) {
			addCriterion("seller_id >=", value, "sellerId");
			return (Criteria) this;
		}

		public Criteria andSellerIdLessThan(Long value) {
			addCriterion("seller_id <", value, "sellerId");
			return (Criteria) this;
		}

		public Criteria andSellerIdLessThanOrEqualTo(Long value) {
			addCriterion("seller_id <=", value, "sellerId");
			return (Criteria) this;
		}

		public Criteria andSellerIdIn(List<Long> values) {
			addCriterion("seller_id in", values, "sellerId");
			return (Criteria) this;
		}

		public Criteria andSellerIdNotIn(List<Long> values) {
			addCriterion("seller_id not in", values, "sellerId");
			return (Criteria) this;
		}

		public Criteria andSellerIdBetween(Long value1, Long value2) {
			addCriterion("seller_id between", value1, value2, "sellerId");
			return (Criteria) this;
		}

		public Criteria andSellerIdNotBetween(Long value1, Long value2) {
			addCriterion("seller_id not between", value1, value2, "sellerId");
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