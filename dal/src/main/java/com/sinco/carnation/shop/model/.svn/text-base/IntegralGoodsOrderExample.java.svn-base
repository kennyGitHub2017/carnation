package com.sinco.carnation.shop.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class IntegralGoodsOrderExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public IntegralGoodsOrderExample() {
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

		protected void addCriterionForJDBCDate(String condition, Date value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()), property);
		}

		protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()),
					property);
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

		public Criteria andIgoOrderSnIsNull() {
			addCriterion("igo_order_sn is null");
			return (Criteria) this;
		}

		public Criteria andIgoOrderSnIsNotNull() {
			addCriterion("igo_order_sn is not null");
			return (Criteria) this;
		}

		public Criteria andIgoOrderSnEqualTo(String value) {
			addCriterion("igo_order_sn =", value, "igoOrderSn");
			return (Criteria) this;
		}

		public Criteria andIgoOrderSnNotEqualTo(String value) {
			addCriterion("igo_order_sn <>", value, "igoOrderSn");
			return (Criteria) this;
		}

		public Criteria andIgoOrderSnGreaterThan(String value) {
			addCriterion("igo_order_sn >", value, "igoOrderSn");
			return (Criteria) this;
		}

		public Criteria andIgoOrderSnGreaterThanOrEqualTo(String value) {
			addCriterion("igo_order_sn >=", value, "igoOrderSn");
			return (Criteria) this;
		}

		public Criteria andIgoOrderSnLessThan(String value) {
			addCriterion("igo_order_sn <", value, "igoOrderSn");
			return (Criteria) this;
		}

		public Criteria andIgoOrderSnLessThanOrEqualTo(String value) {
			addCriterion("igo_order_sn <=", value, "igoOrderSn");
			return (Criteria) this;
		}

		public Criteria andIgoOrderSnLike(String value) {
			addCriterion("igo_order_sn like", value, "igoOrderSn");
			return (Criteria) this;
		}

		public Criteria andIgoOrderSnNotLike(String value) {
			addCriterion("igo_order_sn not like", value, "igoOrderSn");
			return (Criteria) this;
		}

		public Criteria andIgoOrderSnIn(List<String> values) {
			addCriterion("igo_order_sn in", values, "igoOrderSn");
			return (Criteria) this;
		}

		public Criteria andIgoOrderSnNotIn(List<String> values) {
			addCriterion("igo_order_sn not in", values, "igoOrderSn");
			return (Criteria) this;
		}

		public Criteria andIgoOrderSnBetween(String value1, String value2) {
			addCriterion("igo_order_sn between", value1, value2, "igoOrderSn");
			return (Criteria) this;
		}

		public Criteria andIgoOrderSnNotBetween(String value1, String value2) {
			addCriterion("igo_order_sn not between", value1, value2, "igoOrderSn");
			return (Criteria) this;
		}

		public Criteria andIgoPayTimeIsNull() {
			addCriterion("igo_pay_time is null");
			return (Criteria) this;
		}

		public Criteria andIgoPayTimeIsNotNull() {
			addCriterion("igo_pay_time is not null");
			return (Criteria) this;
		}

		public Criteria andIgoPayTimeEqualTo(Date value) {
			addCriterion("igo_pay_time =", value, "igoPayTime");
			return (Criteria) this;
		}

		public Criteria andIgoPayTimeNotEqualTo(Date value) {
			addCriterion("igo_pay_time <>", value, "igoPayTime");
			return (Criteria) this;
		}

		public Criteria andIgoPayTimeGreaterThan(Date value) {
			addCriterion("igo_pay_time >", value, "igoPayTime");
			return (Criteria) this;
		}

		public Criteria andIgoPayTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("igo_pay_time >=", value, "igoPayTime");
			return (Criteria) this;
		}

		public Criteria andIgoPayTimeLessThan(Date value) {
			addCriterion("igo_pay_time <", value, "igoPayTime");
			return (Criteria) this;
		}

		public Criteria andIgoPayTimeLessThanOrEqualTo(Date value) {
			addCriterion("igo_pay_time <=", value, "igoPayTime");
			return (Criteria) this;
		}

		public Criteria andIgoPayTimeIn(List<Date> values) {
			addCriterion("igo_pay_time in", values, "igoPayTime");
			return (Criteria) this;
		}

		public Criteria andIgoPayTimeNotIn(List<Date> values) {
			addCriterion("igo_pay_time not in", values, "igoPayTime");
			return (Criteria) this;
		}

		public Criteria andIgoPayTimeBetween(Date value1, Date value2) {
			addCriterion("igo_pay_time between", value1, value2, "igoPayTime");
			return (Criteria) this;
		}

		public Criteria andIgoPayTimeNotBetween(Date value1, Date value2) {
			addCriterion("igo_pay_time not between", value1, value2, "igoPayTime");
			return (Criteria) this;
		}

		public Criteria andIgoPaymentIsNull() {
			addCriterion("igo_payment is null");
			return (Criteria) this;
		}

		public Criteria andIgoPaymentIsNotNull() {
			addCriterion("igo_payment is not null");
			return (Criteria) this;
		}

		public Criteria andIgoPaymentEqualTo(String value) {
			addCriterion("igo_payment =", value, "igoPayment");
			return (Criteria) this;
		}

		public Criteria andIgoPaymentNotEqualTo(String value) {
			addCriterion("igo_payment <>", value, "igoPayment");
			return (Criteria) this;
		}

		public Criteria andIgoPaymentGreaterThan(String value) {
			addCriterion("igo_payment >", value, "igoPayment");
			return (Criteria) this;
		}

		public Criteria andIgoPaymentGreaterThanOrEqualTo(String value) {
			addCriterion("igo_payment >=", value, "igoPayment");
			return (Criteria) this;
		}

		public Criteria andIgoPaymentLessThan(String value) {
			addCriterion("igo_payment <", value, "igoPayment");
			return (Criteria) this;
		}

		public Criteria andIgoPaymentLessThanOrEqualTo(String value) {
			addCriterion("igo_payment <=", value, "igoPayment");
			return (Criteria) this;
		}

		public Criteria andIgoPaymentLike(String value) {
			addCriterion("igo_payment like", value, "igoPayment");
			return (Criteria) this;
		}

		public Criteria andIgoPaymentNotLike(String value) {
			addCriterion("igo_payment not like", value, "igoPayment");
			return (Criteria) this;
		}

		public Criteria andIgoPaymentIn(List<String> values) {
			addCriterion("igo_payment in", values, "igoPayment");
			return (Criteria) this;
		}

		public Criteria andIgoPaymentNotIn(List<String> values) {
			addCriterion("igo_payment not in", values, "igoPayment");
			return (Criteria) this;
		}

		public Criteria andIgoPaymentBetween(String value1, String value2) {
			addCriterion("igo_payment between", value1, value2, "igoPayment");
			return (Criteria) this;
		}

		public Criteria andIgoPaymentNotBetween(String value1, String value2) {
			addCriterion("igo_payment not between", value1, value2, "igoPayment");
			return (Criteria) this;
		}

		public Criteria andIgoShipCodeIsNull() {
			addCriterion("igo_ship_code is null");
			return (Criteria) this;
		}

		public Criteria andIgoShipCodeIsNotNull() {
			addCriterion("igo_ship_code is not null");
			return (Criteria) this;
		}

		public Criteria andIgoShipCodeEqualTo(String value) {
			addCriterion("igo_ship_code =", value, "igoShipCode");
			return (Criteria) this;
		}

		public Criteria andIgoShipCodeNotEqualTo(String value) {
			addCriterion("igo_ship_code <>", value, "igoShipCode");
			return (Criteria) this;
		}

		public Criteria andIgoShipCodeGreaterThan(String value) {
			addCriterion("igo_ship_code >", value, "igoShipCode");
			return (Criteria) this;
		}

		public Criteria andIgoShipCodeGreaterThanOrEqualTo(String value) {
			addCriterion("igo_ship_code >=", value, "igoShipCode");
			return (Criteria) this;
		}

		public Criteria andIgoShipCodeLessThan(String value) {
			addCriterion("igo_ship_code <", value, "igoShipCode");
			return (Criteria) this;
		}

		public Criteria andIgoShipCodeLessThanOrEqualTo(String value) {
			addCriterion("igo_ship_code <=", value, "igoShipCode");
			return (Criteria) this;
		}

		public Criteria andIgoShipCodeLike(String value) {
			addCriterion("igo_ship_code like", value, "igoShipCode");
			return (Criteria) this;
		}

		public Criteria andIgoShipCodeNotLike(String value) {
			addCriterion("igo_ship_code not like", value, "igoShipCode");
			return (Criteria) this;
		}

		public Criteria andIgoShipCodeIn(List<String> values) {
			addCriterion("igo_ship_code in", values, "igoShipCode");
			return (Criteria) this;
		}

		public Criteria andIgoShipCodeNotIn(List<String> values) {
			addCriterion("igo_ship_code not in", values, "igoShipCode");
			return (Criteria) this;
		}

		public Criteria andIgoShipCodeBetween(String value1, String value2) {
			addCriterion("igo_ship_code between", value1, value2, "igoShipCode");
			return (Criteria) this;
		}

		public Criteria andIgoShipCodeNotBetween(String value1, String value2) {
			addCriterion("igo_ship_code not between", value1, value2, "igoShipCode");
			return (Criteria) this;
		}

		public Criteria andIgoShipTimeIsNull() {
			addCriterion("igo_ship_time is null");
			return (Criteria) this;
		}

		public Criteria andIgoShipTimeIsNotNull() {
			addCriterion("igo_ship_time is not null");
			return (Criteria) this;
		}

		public Criteria andIgoShipTimeEqualTo(Date value) {
			addCriterionForJDBCDate("igo_ship_time =", value, "igoShipTime");
			return (Criteria) this;
		}

		public Criteria andIgoShipTimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("igo_ship_time <>", value, "igoShipTime");
			return (Criteria) this;
		}

		public Criteria andIgoShipTimeGreaterThan(Date value) {
			addCriterionForJDBCDate("igo_ship_time >", value, "igoShipTime");
			return (Criteria) this;
		}

		public Criteria andIgoShipTimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("igo_ship_time >=", value, "igoShipTime");
			return (Criteria) this;
		}

		public Criteria andIgoShipTimeLessThan(Date value) {
			addCriterionForJDBCDate("igo_ship_time <", value, "igoShipTime");
			return (Criteria) this;
		}

		public Criteria andIgoShipTimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("igo_ship_time <=", value, "igoShipTime");
			return (Criteria) this;
		}

		public Criteria andIgoShipTimeIn(List<Date> values) {
			addCriterionForJDBCDate("igo_ship_time in", values, "igoShipTime");
			return (Criteria) this;
		}

		public Criteria andIgoShipTimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("igo_ship_time not in", values, "igoShipTime");
			return (Criteria) this;
		}

		public Criteria andIgoShipTimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("igo_ship_time between", value1, value2, "igoShipTime");
			return (Criteria) this;
		}

		public Criteria andIgoShipTimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("igo_ship_time not between", value1, value2, "igoShipTime");
			return (Criteria) this;
		}

		public Criteria andIgoStatusIsNull() {
			addCriterion("igo_status is null");
			return (Criteria) this;
		}

		public Criteria andIgoStatusIsNotNull() {
			addCriterion("igo_status is not null");
			return (Criteria) this;
		}

		public Criteria andIgoStatusEqualTo(Integer value) {
			addCriterion("igo_status =", value, "igoStatus");
			return (Criteria) this;
		}

		public Criteria andIgoStatusNotEqualTo(Integer value) {
			addCriterion("igo_status <>", value, "igoStatus");
			return (Criteria) this;
		}

		public Criteria andIgoStatusGreaterThan(Integer value) {
			addCriterion("igo_status >", value, "igoStatus");
			return (Criteria) this;
		}

		public Criteria andIgoStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("igo_status >=", value, "igoStatus");
			return (Criteria) this;
		}

		public Criteria andIgoStatusLessThan(Integer value) {
			addCriterion("igo_status <", value, "igoStatus");
			return (Criteria) this;
		}

		public Criteria andIgoStatusLessThanOrEqualTo(Integer value) {
			addCriterion("igo_status <=", value, "igoStatus");
			return (Criteria) this;
		}

		public Criteria andIgoStatusIn(List<Integer> values) {
			addCriterion("igo_status in", values, "igoStatus");
			return (Criteria) this;
		}

		public Criteria andIgoStatusNotIn(List<Integer> values) {
			addCriterion("igo_status not in", values, "igoStatus");
			return (Criteria) this;
		}

		public Criteria andIgoStatusBetween(Integer value1, Integer value2) {
			addCriterion("igo_status between", value1, value2, "igoStatus");
			return (Criteria) this;
		}

		public Criteria andIgoStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("igo_status not between", value1, value2, "igoStatus");
			return (Criteria) this;
		}

		public Criteria andIgoTotalIntegralIsNull() {
			addCriterion("igo_total_integral is null");
			return (Criteria) this;
		}

		public Criteria andIgoTotalIntegralIsNotNull() {
			addCriterion("igo_total_integral is not null");
			return (Criteria) this;
		}

		public Criteria andIgoTotalIntegralEqualTo(Integer value) {
			addCriterion("igo_total_integral =", value, "igoTotalIntegral");
			return (Criteria) this;
		}

		public Criteria andIgoTotalIntegralNotEqualTo(Integer value) {
			addCriterion("igo_total_integral <>", value, "igoTotalIntegral");
			return (Criteria) this;
		}

		public Criteria andIgoTotalIntegralGreaterThan(Integer value) {
			addCriterion("igo_total_integral >", value, "igoTotalIntegral");
			return (Criteria) this;
		}

		public Criteria andIgoTotalIntegralGreaterThanOrEqualTo(Integer value) {
			addCriterion("igo_total_integral >=", value, "igoTotalIntegral");
			return (Criteria) this;
		}

		public Criteria andIgoTotalIntegralLessThan(Integer value) {
			addCriterion("igo_total_integral <", value, "igoTotalIntegral");
			return (Criteria) this;
		}

		public Criteria andIgoTotalIntegralLessThanOrEqualTo(Integer value) {
			addCriterion("igo_total_integral <=", value, "igoTotalIntegral");
			return (Criteria) this;
		}

		public Criteria andIgoTotalIntegralIn(List<Integer> values) {
			addCriterion("igo_total_integral in", values, "igoTotalIntegral");
			return (Criteria) this;
		}

		public Criteria andIgoTotalIntegralNotIn(List<Integer> values) {
			addCriterion("igo_total_integral not in", values, "igoTotalIntegral");
			return (Criteria) this;
		}

		public Criteria andIgoTotalIntegralBetween(Integer value1, Integer value2) {
			addCriterion("igo_total_integral between", value1, value2, "igoTotalIntegral");
			return (Criteria) this;
		}

		public Criteria andIgoTotalIntegralNotBetween(Integer value1, Integer value2) {
			addCriterion("igo_total_integral not between", value1, value2, "igoTotalIntegral");
			return (Criteria) this;
		}

		public Criteria andIgoTransFeeIsNull() {
			addCriterion("igo_trans_fee is null");
			return (Criteria) this;
		}

		public Criteria andIgoTransFeeIsNotNull() {
			addCriterion("igo_trans_fee is not null");
			return (Criteria) this;
		}

		public Criteria andIgoTransFeeEqualTo(BigDecimal value) {
			addCriterion("igo_trans_fee =", value, "igoTransFee");
			return (Criteria) this;
		}

		public Criteria andIgoTransFeeNotEqualTo(BigDecimal value) {
			addCriterion("igo_trans_fee <>", value, "igoTransFee");
			return (Criteria) this;
		}

		public Criteria andIgoTransFeeGreaterThan(BigDecimal value) {
			addCriterion("igo_trans_fee >", value, "igoTransFee");
			return (Criteria) this;
		}

		public Criteria andIgoTransFeeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("igo_trans_fee >=", value, "igoTransFee");
			return (Criteria) this;
		}

		public Criteria andIgoTransFeeLessThan(BigDecimal value) {
			addCriterion("igo_trans_fee <", value, "igoTransFee");
			return (Criteria) this;
		}

		public Criteria andIgoTransFeeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("igo_trans_fee <=", value, "igoTransFee");
			return (Criteria) this;
		}

		public Criteria andIgoTransFeeIn(List<BigDecimal> values) {
			addCriterion("igo_trans_fee in", values, "igoTransFee");
			return (Criteria) this;
		}

		public Criteria andIgoTransFeeNotIn(List<BigDecimal> values) {
			addCriterion("igo_trans_fee not in", values, "igoTransFee");
			return (Criteria) this;
		}

		public Criteria andIgoTransFeeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("igo_trans_fee between", value1, value2, "igoTransFee");
			return (Criteria) this;
		}

		public Criteria andIgoTransFeeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("igo_trans_fee not between", value1, value2, "igoTransFee");
			return (Criteria) this;
		}

		public Criteria andReceiverNameIsNull() {
			addCriterion("receiver_Name is null");
			return (Criteria) this;
		}

		public Criteria andReceiverNameIsNotNull() {
			addCriterion("receiver_Name is not null");
			return (Criteria) this;
		}

		public Criteria andReceiverNameEqualTo(String value) {
			addCriterion("receiver_Name =", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameNotEqualTo(String value) {
			addCriterion("receiver_Name <>", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameGreaterThan(String value) {
			addCriterion("receiver_Name >", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameGreaterThanOrEqualTo(String value) {
			addCriterion("receiver_Name >=", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameLessThan(String value) {
			addCriterion("receiver_Name <", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameLessThanOrEqualTo(String value) {
			addCriterion("receiver_Name <=", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameLike(String value) {
			addCriterion("receiver_Name like", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameNotLike(String value) {
			addCriterion("receiver_Name not like", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameIn(List<String> values) {
			addCriterion("receiver_Name in", values, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameNotIn(List<String> values) {
			addCriterion("receiver_Name not in", values, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameBetween(String value1, String value2) {
			addCriterion("receiver_Name between", value1, value2, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameNotBetween(String value1, String value2) {
			addCriterion("receiver_Name not between", value1, value2, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaIsNull() {
			addCriterion("receiver_area is null");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaIsNotNull() {
			addCriterion("receiver_area is not null");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaEqualTo(String value) {
			addCriterion("receiver_area =", value, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaNotEqualTo(String value) {
			addCriterion("receiver_area <>", value, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaGreaterThan(String value) {
			addCriterion("receiver_area >", value, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaGreaterThanOrEqualTo(String value) {
			addCriterion("receiver_area >=", value, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaLessThan(String value) {
			addCriterion("receiver_area <", value, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaLessThanOrEqualTo(String value) {
			addCriterion("receiver_area <=", value, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaLike(String value) {
			addCriterion("receiver_area like", value, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaNotLike(String value) {
			addCriterion("receiver_area not like", value, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaIn(List<String> values) {
			addCriterion("receiver_area in", values, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaNotIn(List<String> values) {
			addCriterion("receiver_area not in", values, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaBetween(String value1, String value2) {
			addCriterion("receiver_area between", value1, value2, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaNotBetween(String value1, String value2) {
			addCriterion("receiver_area not between", value1, value2, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoIsNull() {
			addCriterion("receiver_area_info is null");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoIsNotNull() {
			addCriterion("receiver_area_info is not null");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoEqualTo(String value) {
			addCriterion("receiver_area_info =", value, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoNotEqualTo(String value) {
			addCriterion("receiver_area_info <>", value, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoGreaterThan(String value) {
			addCriterion("receiver_area_info >", value, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoGreaterThanOrEqualTo(String value) {
			addCriterion("receiver_area_info >=", value, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoLessThan(String value) {
			addCriterion("receiver_area_info <", value, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoLessThanOrEqualTo(String value) {
			addCriterion("receiver_area_info <=", value, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoLike(String value) {
			addCriterion("receiver_area_info like", value, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoNotLike(String value) {
			addCriterion("receiver_area_info not like", value, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoIn(List<String> values) {
			addCriterion("receiver_area_info in", values, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoNotIn(List<String> values) {
			addCriterion("receiver_area_info not in", values, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoBetween(String value1, String value2) {
			addCriterion("receiver_area_info between", value1, value2, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoNotBetween(String value1, String value2) {
			addCriterion("receiver_area_info not between", value1, value2, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileIsNull() {
			addCriterion("receiver_mobile is null");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileIsNotNull() {
			addCriterion("receiver_mobile is not null");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileEqualTo(String value) {
			addCriterion("receiver_mobile =", value, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileNotEqualTo(String value) {
			addCriterion("receiver_mobile <>", value, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileGreaterThan(String value) {
			addCriterion("receiver_mobile >", value, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileGreaterThanOrEqualTo(String value) {
			addCriterion("receiver_mobile >=", value, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileLessThan(String value) {
			addCriterion("receiver_mobile <", value, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileLessThanOrEqualTo(String value) {
			addCriterion("receiver_mobile <=", value, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileLike(String value) {
			addCriterion("receiver_mobile like", value, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileNotLike(String value) {
			addCriterion("receiver_mobile not like", value, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileIn(List<String> values) {
			addCriterion("receiver_mobile in", values, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileNotIn(List<String> values) {
			addCriterion("receiver_mobile not in", values, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileBetween(String value1, String value2) {
			addCriterion("receiver_mobile between", value1, value2, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileNotBetween(String value1, String value2) {
			addCriterion("receiver_mobile not between", value1, value2, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneIsNull() {
			addCriterion("receiver_telephone is null");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneIsNotNull() {
			addCriterion("receiver_telephone is not null");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneEqualTo(String value) {
			addCriterion("receiver_telephone =", value, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneNotEqualTo(String value) {
			addCriterion("receiver_telephone <>", value, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneGreaterThan(String value) {
			addCriterion("receiver_telephone >", value, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneGreaterThanOrEqualTo(String value) {
			addCriterion("receiver_telephone >=", value, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneLessThan(String value) {
			addCriterion("receiver_telephone <", value, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneLessThanOrEqualTo(String value) {
			addCriterion("receiver_telephone <=", value, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneLike(String value) {
			addCriterion("receiver_telephone like", value, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneNotLike(String value) {
			addCriterion("receiver_telephone not like", value, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneIn(List<String> values) {
			addCriterion("receiver_telephone in", values, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneNotIn(List<String> values) {
			addCriterion("receiver_telephone not in", values, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneBetween(String value1, String value2) {
			addCriterion("receiver_telephone between", value1, value2, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneNotBetween(String value1, String value2) {
			addCriterion("receiver_telephone not between", value1, value2, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverZipIsNull() {
			addCriterion("receiver_zip is null");
			return (Criteria) this;
		}

		public Criteria andReceiverZipIsNotNull() {
			addCriterion("receiver_zip is not null");
			return (Criteria) this;
		}

		public Criteria andReceiverZipEqualTo(String value) {
			addCriterion("receiver_zip =", value, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipNotEqualTo(String value) {
			addCriterion("receiver_zip <>", value, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipGreaterThan(String value) {
			addCriterion("receiver_zip >", value, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipGreaterThanOrEqualTo(String value) {
			addCriterion("receiver_zip >=", value, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipLessThan(String value) {
			addCriterion("receiver_zip <", value, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipLessThanOrEqualTo(String value) {
			addCriterion("receiver_zip <=", value, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipLike(String value) {
			addCriterion("receiver_zip like", value, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipNotLike(String value) {
			addCriterion("receiver_zip not like", value, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipIn(List<String> values) {
			addCriterion("receiver_zip in", values, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipNotIn(List<String> values) {
			addCriterion("receiver_zip not in", values, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipBetween(String value1, String value2) {
			addCriterion("receiver_zip between", value1, value2, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipNotBetween(String value1, String value2) {
			addCriterion("receiver_zip not between", value1, value2, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andIgoUserIdIsNull() {
			addCriterion("igo_user_id is null");
			return (Criteria) this;
		}

		public Criteria andIgoUserIdIsNotNull() {
			addCriterion("igo_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andIgoUserIdEqualTo(Long value) {
			addCriterion("igo_user_id =", value, "igoUserId");
			return (Criteria) this;
		}

		public Criteria andIgoUserIdNotEqualTo(Long value) {
			addCriterion("igo_user_id <>", value, "igoUserId");
			return (Criteria) this;
		}

		public Criteria andIgoUserIdGreaterThan(Long value) {
			addCriterion("igo_user_id >", value, "igoUserId");
			return (Criteria) this;
		}

		public Criteria andIgoUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("igo_user_id >=", value, "igoUserId");
			return (Criteria) this;
		}

		public Criteria andIgoUserIdLessThan(Long value) {
			addCriterion("igo_user_id <", value, "igoUserId");
			return (Criteria) this;
		}

		public Criteria andIgoUserIdLessThanOrEqualTo(Long value) {
			addCriterion("igo_user_id <=", value, "igoUserId");
			return (Criteria) this;
		}

		public Criteria andIgoUserIdIn(List<Long> values) {
			addCriterion("igo_user_id in", values, "igoUserId");
			return (Criteria) this;
		}

		public Criteria andIgoUserIdNotIn(List<Long> values) {
			addCriterion("igo_user_id not in", values, "igoUserId");
			return (Criteria) this;
		}

		public Criteria andIgoUserIdBetween(Long value1, Long value2) {
			addCriterion("igo_user_id between", value1, value2, "igoUserId");
			return (Criteria) this;
		}

		public Criteria andIgoUserIdNotBetween(Long value1, Long value2) {
			addCriterion("igo_user_id not between", value1, value2, "igoUserId");
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