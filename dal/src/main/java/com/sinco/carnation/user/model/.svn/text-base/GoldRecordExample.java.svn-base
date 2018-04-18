package com.sinco.carnation.user.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoldRecordExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public GoldRecordExample() {
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

		public Criteria andGoldAdminTimeIsNull() {
			addCriterion("gold_admin_time is null");
			return (Criteria) this;
		}

		public Criteria andGoldAdminTimeIsNotNull() {
			addCriterion("gold_admin_time is not null");
			return (Criteria) this;
		}

		public Criteria andGoldAdminTimeEqualTo(Date value) {
			addCriterion("gold_admin_time =", value, "goldAdminTime");
			return (Criteria) this;
		}

		public Criteria andGoldAdminTimeNotEqualTo(Date value) {
			addCriterion("gold_admin_time <>", value, "goldAdminTime");
			return (Criteria) this;
		}

		public Criteria andGoldAdminTimeGreaterThan(Date value) {
			addCriterion("gold_admin_time >", value, "goldAdminTime");
			return (Criteria) this;
		}

		public Criteria andGoldAdminTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("gold_admin_time >=", value, "goldAdminTime");
			return (Criteria) this;
		}

		public Criteria andGoldAdminTimeLessThan(Date value) {
			addCriterion("gold_admin_time <", value, "goldAdminTime");
			return (Criteria) this;
		}

		public Criteria andGoldAdminTimeLessThanOrEqualTo(Date value) {
			addCriterion("gold_admin_time <=", value, "goldAdminTime");
			return (Criteria) this;
		}

		public Criteria andGoldAdminTimeIn(List<Date> values) {
			addCriterion("gold_admin_time in", values, "goldAdminTime");
			return (Criteria) this;
		}

		public Criteria andGoldAdminTimeNotIn(List<Date> values) {
			addCriterion("gold_admin_time not in", values, "goldAdminTime");
			return (Criteria) this;
		}

		public Criteria andGoldAdminTimeBetween(Date value1, Date value2) {
			addCriterion("gold_admin_time between", value1, value2, "goldAdminTime");
			return (Criteria) this;
		}

		public Criteria andGoldAdminTimeNotBetween(Date value1, Date value2) {
			addCriterion("gold_admin_time not between", value1, value2, "goldAdminTime");
			return (Criteria) this;
		}

		public Criteria andGoldCountIsNull() {
			addCriterion("gold_count is null");
			return (Criteria) this;
		}

		public Criteria andGoldCountIsNotNull() {
			addCriterion("gold_count is not null");
			return (Criteria) this;
		}

		public Criteria andGoldCountEqualTo(Integer value) {
			addCriterion("gold_count =", value, "goldCount");
			return (Criteria) this;
		}

		public Criteria andGoldCountNotEqualTo(Integer value) {
			addCriterion("gold_count <>", value, "goldCount");
			return (Criteria) this;
		}

		public Criteria andGoldCountGreaterThan(Integer value) {
			addCriterion("gold_count >", value, "goldCount");
			return (Criteria) this;
		}

		public Criteria andGoldCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("gold_count >=", value, "goldCount");
			return (Criteria) this;
		}

		public Criteria andGoldCountLessThan(Integer value) {
			addCriterion("gold_count <", value, "goldCount");
			return (Criteria) this;
		}

		public Criteria andGoldCountLessThanOrEqualTo(Integer value) {
			addCriterion("gold_count <=", value, "goldCount");
			return (Criteria) this;
		}

		public Criteria andGoldCountIn(List<Integer> values) {
			addCriterion("gold_count in", values, "goldCount");
			return (Criteria) this;
		}

		public Criteria andGoldCountNotIn(List<Integer> values) {
			addCriterion("gold_count not in", values, "goldCount");
			return (Criteria) this;
		}

		public Criteria andGoldCountBetween(Integer value1, Integer value2) {
			addCriterion("gold_count between", value1, value2, "goldCount");
			return (Criteria) this;
		}

		public Criteria andGoldCountNotBetween(Integer value1, Integer value2) {
			addCriterion("gold_count not between", value1, value2, "goldCount");
			return (Criteria) this;
		}

		public Criteria andGoldMoneyIsNull() {
			addCriterion("gold_money is null");
			return (Criteria) this;
		}

		public Criteria andGoldMoneyIsNotNull() {
			addCriterion("gold_money is not null");
			return (Criteria) this;
		}

		public Criteria andGoldMoneyEqualTo(Integer value) {
			addCriterion("gold_money =", value, "goldMoney");
			return (Criteria) this;
		}

		public Criteria andGoldMoneyNotEqualTo(Integer value) {
			addCriterion("gold_money <>", value, "goldMoney");
			return (Criteria) this;
		}

		public Criteria andGoldMoneyGreaterThan(Integer value) {
			addCriterion("gold_money >", value, "goldMoney");
			return (Criteria) this;
		}

		public Criteria andGoldMoneyGreaterThanOrEqualTo(Integer value) {
			addCriterion("gold_money >=", value, "goldMoney");
			return (Criteria) this;
		}

		public Criteria andGoldMoneyLessThan(Integer value) {
			addCriterion("gold_money <", value, "goldMoney");
			return (Criteria) this;
		}

		public Criteria andGoldMoneyLessThanOrEqualTo(Integer value) {
			addCriterion("gold_money <=", value, "goldMoney");
			return (Criteria) this;
		}

		public Criteria andGoldMoneyIn(List<Integer> values) {
			addCriterion("gold_money in", values, "goldMoney");
			return (Criteria) this;
		}

		public Criteria andGoldMoneyNotIn(List<Integer> values) {
			addCriterion("gold_money not in", values, "goldMoney");
			return (Criteria) this;
		}

		public Criteria andGoldMoneyBetween(Integer value1, Integer value2) {
			addCriterion("gold_money between", value1, value2, "goldMoney");
			return (Criteria) this;
		}

		public Criteria andGoldMoneyNotBetween(Integer value1, Integer value2) {
			addCriterion("gold_money not between", value1, value2, "goldMoney");
			return (Criteria) this;
		}

		public Criteria andGoldPayStatusIsNull() {
			addCriterion("gold_pay_status is null");
			return (Criteria) this;
		}

		public Criteria andGoldPayStatusIsNotNull() {
			addCriterion("gold_pay_status is not null");
			return (Criteria) this;
		}

		public Criteria andGoldPayStatusEqualTo(Integer value) {
			addCriterion("gold_pay_status =", value, "goldPayStatus");
			return (Criteria) this;
		}

		public Criteria andGoldPayStatusNotEqualTo(Integer value) {
			addCriterion("gold_pay_status <>", value, "goldPayStatus");
			return (Criteria) this;
		}

		public Criteria andGoldPayStatusGreaterThan(Integer value) {
			addCriterion("gold_pay_status >", value, "goldPayStatus");
			return (Criteria) this;
		}

		public Criteria andGoldPayStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("gold_pay_status >=", value, "goldPayStatus");
			return (Criteria) this;
		}

		public Criteria andGoldPayStatusLessThan(Integer value) {
			addCriterion("gold_pay_status <", value, "goldPayStatus");
			return (Criteria) this;
		}

		public Criteria andGoldPayStatusLessThanOrEqualTo(Integer value) {
			addCriterion("gold_pay_status <=", value, "goldPayStatus");
			return (Criteria) this;
		}

		public Criteria andGoldPayStatusIn(List<Integer> values) {
			addCriterion("gold_pay_status in", values, "goldPayStatus");
			return (Criteria) this;
		}

		public Criteria andGoldPayStatusNotIn(List<Integer> values) {
			addCriterion("gold_pay_status not in", values, "goldPayStatus");
			return (Criteria) this;
		}

		public Criteria andGoldPayStatusBetween(Integer value1, Integer value2) {
			addCriterion("gold_pay_status between", value1, value2, "goldPayStatus");
			return (Criteria) this;
		}

		public Criteria andGoldPayStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("gold_pay_status not between", value1, value2, "goldPayStatus");
			return (Criteria) this;
		}

		public Criteria andGoldPaymentIsNull() {
			addCriterion("gold_payment is null");
			return (Criteria) this;
		}

		public Criteria andGoldPaymentIsNotNull() {
			addCriterion("gold_payment is not null");
			return (Criteria) this;
		}

		public Criteria andGoldPaymentEqualTo(String value) {
			addCriterion("gold_payment =", value, "goldPayment");
			return (Criteria) this;
		}

		public Criteria andGoldPaymentNotEqualTo(String value) {
			addCriterion("gold_payment <>", value, "goldPayment");
			return (Criteria) this;
		}

		public Criteria andGoldPaymentGreaterThan(String value) {
			addCriterion("gold_payment >", value, "goldPayment");
			return (Criteria) this;
		}

		public Criteria andGoldPaymentGreaterThanOrEqualTo(String value) {
			addCriterion("gold_payment >=", value, "goldPayment");
			return (Criteria) this;
		}

		public Criteria andGoldPaymentLessThan(String value) {
			addCriterion("gold_payment <", value, "goldPayment");
			return (Criteria) this;
		}

		public Criteria andGoldPaymentLessThanOrEqualTo(String value) {
			addCriterion("gold_payment <=", value, "goldPayment");
			return (Criteria) this;
		}

		public Criteria andGoldPaymentLike(String value) {
			addCriterion("gold_payment like", value, "goldPayment");
			return (Criteria) this;
		}

		public Criteria andGoldPaymentNotLike(String value) {
			addCriterion("gold_payment not like", value, "goldPayment");
			return (Criteria) this;
		}

		public Criteria andGoldPaymentIn(List<String> values) {
			addCriterion("gold_payment in", values, "goldPayment");
			return (Criteria) this;
		}

		public Criteria andGoldPaymentNotIn(List<String> values) {
			addCriterion("gold_payment not in", values, "goldPayment");
			return (Criteria) this;
		}

		public Criteria andGoldPaymentBetween(String value1, String value2) {
			addCriterion("gold_payment between", value1, value2, "goldPayment");
			return (Criteria) this;
		}

		public Criteria andGoldPaymentNotBetween(String value1, String value2) {
			addCriterion("gold_payment not between", value1, value2, "goldPayment");
			return (Criteria) this;
		}

		public Criteria andGoldSnIsNull() {
			addCriterion("gold_sn is null");
			return (Criteria) this;
		}

		public Criteria andGoldSnIsNotNull() {
			addCriterion("gold_sn is not null");
			return (Criteria) this;
		}

		public Criteria andGoldSnEqualTo(String value) {
			addCriterion("gold_sn =", value, "goldSn");
			return (Criteria) this;
		}

		public Criteria andGoldSnNotEqualTo(String value) {
			addCriterion("gold_sn <>", value, "goldSn");
			return (Criteria) this;
		}

		public Criteria andGoldSnGreaterThan(String value) {
			addCriterion("gold_sn >", value, "goldSn");
			return (Criteria) this;
		}

		public Criteria andGoldSnGreaterThanOrEqualTo(String value) {
			addCriterion("gold_sn >=", value, "goldSn");
			return (Criteria) this;
		}

		public Criteria andGoldSnLessThan(String value) {
			addCriterion("gold_sn <", value, "goldSn");
			return (Criteria) this;
		}

		public Criteria andGoldSnLessThanOrEqualTo(String value) {
			addCriterion("gold_sn <=", value, "goldSn");
			return (Criteria) this;
		}

		public Criteria andGoldSnLike(String value) {
			addCriterion("gold_sn like", value, "goldSn");
			return (Criteria) this;
		}

		public Criteria andGoldSnNotLike(String value) {
			addCriterion("gold_sn not like", value, "goldSn");
			return (Criteria) this;
		}

		public Criteria andGoldSnIn(List<String> values) {
			addCriterion("gold_sn in", values, "goldSn");
			return (Criteria) this;
		}

		public Criteria andGoldSnNotIn(List<String> values) {
			addCriterion("gold_sn not in", values, "goldSn");
			return (Criteria) this;
		}

		public Criteria andGoldSnBetween(String value1, String value2) {
			addCriterion("gold_sn between", value1, value2, "goldSn");
			return (Criteria) this;
		}

		public Criteria andGoldSnNotBetween(String value1, String value2) {
			addCriterion("gold_sn not between", value1, value2, "goldSn");
			return (Criteria) this;
		}

		public Criteria andGoldStatusIsNull() {
			addCriterion("gold_status is null");
			return (Criteria) this;
		}

		public Criteria andGoldStatusIsNotNull() {
			addCriterion("gold_status is not null");
			return (Criteria) this;
		}

		public Criteria andGoldStatusEqualTo(Integer value) {
			addCriterion("gold_status =", value, "goldStatus");
			return (Criteria) this;
		}

		public Criteria andGoldStatusNotEqualTo(Integer value) {
			addCriterion("gold_status <>", value, "goldStatus");
			return (Criteria) this;
		}

		public Criteria andGoldStatusGreaterThan(Integer value) {
			addCriterion("gold_status >", value, "goldStatus");
			return (Criteria) this;
		}

		public Criteria andGoldStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("gold_status >=", value, "goldStatus");
			return (Criteria) this;
		}

		public Criteria andGoldStatusLessThan(Integer value) {
			addCriterion("gold_status <", value, "goldStatus");
			return (Criteria) this;
		}

		public Criteria andGoldStatusLessThanOrEqualTo(Integer value) {
			addCriterion("gold_status <=", value, "goldStatus");
			return (Criteria) this;
		}

		public Criteria andGoldStatusIn(List<Integer> values) {
			addCriterion("gold_status in", values, "goldStatus");
			return (Criteria) this;
		}

		public Criteria andGoldStatusNotIn(List<Integer> values) {
			addCriterion("gold_status not in", values, "goldStatus");
			return (Criteria) this;
		}

		public Criteria andGoldStatusBetween(Integer value1, Integer value2) {
			addCriterion("gold_status between", value1, value2, "goldStatus");
			return (Criteria) this;
		}

		public Criteria andGoldStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("gold_status not between", value1, value2, "goldStatus");
			return (Criteria) this;
		}

		public Criteria andGoldAdminIdIsNull() {
			addCriterion("gold_admin_id is null");
			return (Criteria) this;
		}

		public Criteria andGoldAdminIdIsNotNull() {
			addCriterion("gold_admin_id is not null");
			return (Criteria) this;
		}

		public Criteria andGoldAdminIdEqualTo(Long value) {
			addCriterion("gold_admin_id =", value, "goldAdminId");
			return (Criteria) this;
		}

		public Criteria andGoldAdminIdNotEqualTo(Long value) {
			addCriterion("gold_admin_id <>", value, "goldAdminId");
			return (Criteria) this;
		}

		public Criteria andGoldAdminIdGreaterThan(Long value) {
			addCriterion("gold_admin_id >", value, "goldAdminId");
			return (Criteria) this;
		}

		public Criteria andGoldAdminIdGreaterThanOrEqualTo(Long value) {
			addCriterion("gold_admin_id >=", value, "goldAdminId");
			return (Criteria) this;
		}

		public Criteria andGoldAdminIdLessThan(Long value) {
			addCriterion("gold_admin_id <", value, "goldAdminId");
			return (Criteria) this;
		}

		public Criteria andGoldAdminIdLessThanOrEqualTo(Long value) {
			addCriterion("gold_admin_id <=", value, "goldAdminId");
			return (Criteria) this;
		}

		public Criteria andGoldAdminIdIn(List<Long> values) {
			addCriterion("gold_admin_id in", values, "goldAdminId");
			return (Criteria) this;
		}

		public Criteria andGoldAdminIdNotIn(List<Long> values) {
			addCriterion("gold_admin_id not in", values, "goldAdminId");
			return (Criteria) this;
		}

		public Criteria andGoldAdminIdBetween(Long value1, Long value2) {
			addCriterion("gold_admin_id between", value1, value2, "goldAdminId");
			return (Criteria) this;
		}

		public Criteria andGoldAdminIdNotBetween(Long value1, Long value2) {
			addCriterion("gold_admin_id not between", value1, value2, "goldAdminId");
			return (Criteria) this;
		}

		public Criteria andGoldUserIdIsNull() {
			addCriterion("gold_user_id is null");
			return (Criteria) this;
		}

		public Criteria andGoldUserIdIsNotNull() {
			addCriterion("gold_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andGoldUserIdEqualTo(Long value) {
			addCriterion("gold_user_id =", value, "goldUserId");
			return (Criteria) this;
		}

		public Criteria andGoldUserIdNotEqualTo(Long value) {
			addCriterion("gold_user_id <>", value, "goldUserId");
			return (Criteria) this;
		}

		public Criteria andGoldUserIdGreaterThan(Long value) {
			addCriterion("gold_user_id >", value, "goldUserId");
			return (Criteria) this;
		}

		public Criteria andGoldUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("gold_user_id >=", value, "goldUserId");
			return (Criteria) this;
		}

		public Criteria andGoldUserIdLessThan(Long value) {
			addCriterion("gold_user_id <", value, "goldUserId");
			return (Criteria) this;
		}

		public Criteria andGoldUserIdLessThanOrEqualTo(Long value) {
			addCriterion("gold_user_id <=", value, "goldUserId");
			return (Criteria) this;
		}

		public Criteria andGoldUserIdIn(List<Long> values) {
			addCriterion("gold_user_id in", values, "goldUserId");
			return (Criteria) this;
		}

		public Criteria andGoldUserIdNotIn(List<Long> values) {
			addCriterion("gold_user_id not in", values, "goldUserId");
			return (Criteria) this;
		}

		public Criteria andGoldUserIdBetween(Long value1, Long value2) {
			addCriterion("gold_user_id between", value1, value2, "goldUserId");
			return (Criteria) this;
		}

		public Criteria andGoldUserIdNotBetween(Long value1, Long value2) {
			addCriterion("gold_user_id not between", value1, value2, "goldUserId");
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