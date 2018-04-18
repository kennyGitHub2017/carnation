package com.sinco.carnation.user.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoldLogExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public GoldLogExample() {
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

		public Criteria andGlAdminTimeIsNull() {
			addCriterion("gl_admin_time is null");
			return (Criteria) this;
		}

		public Criteria andGlAdminTimeIsNotNull() {
			addCriterion("gl_admin_time is not null");
			return (Criteria) this;
		}

		public Criteria andGlAdminTimeEqualTo(Date value) {
			addCriterion("gl_admin_time =", value, "glAdminTime");
			return (Criteria) this;
		}

		public Criteria andGlAdminTimeNotEqualTo(Date value) {
			addCriterion("gl_admin_time <>", value, "glAdminTime");
			return (Criteria) this;
		}

		public Criteria andGlAdminTimeGreaterThan(Date value) {
			addCriterion("gl_admin_time >", value, "glAdminTime");
			return (Criteria) this;
		}

		public Criteria andGlAdminTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("gl_admin_time >=", value, "glAdminTime");
			return (Criteria) this;
		}

		public Criteria andGlAdminTimeLessThan(Date value) {
			addCriterion("gl_admin_time <", value, "glAdminTime");
			return (Criteria) this;
		}

		public Criteria andGlAdminTimeLessThanOrEqualTo(Date value) {
			addCriterion("gl_admin_time <=", value, "glAdminTime");
			return (Criteria) this;
		}

		public Criteria andGlAdminTimeIn(List<Date> values) {
			addCriterion("gl_admin_time in", values, "glAdminTime");
			return (Criteria) this;
		}

		public Criteria andGlAdminTimeNotIn(List<Date> values) {
			addCriterion("gl_admin_time not in", values, "glAdminTime");
			return (Criteria) this;
		}

		public Criteria andGlAdminTimeBetween(Date value1, Date value2) {
			addCriterion("gl_admin_time between", value1, value2, "glAdminTime");
			return (Criteria) this;
		}

		public Criteria andGlAdminTimeNotBetween(Date value1, Date value2) {
			addCriterion("gl_admin_time not between", value1, value2, "glAdminTime");
			return (Criteria) this;
		}

		public Criteria andGlCountIsNull() {
			addCriterion("gl_count is null");
			return (Criteria) this;
		}

		public Criteria andGlCountIsNotNull() {
			addCriterion("gl_count is not null");
			return (Criteria) this;
		}

		public Criteria andGlCountEqualTo(Integer value) {
			addCriterion("gl_count =", value, "glCount");
			return (Criteria) this;
		}

		public Criteria andGlCountNotEqualTo(Integer value) {
			addCriterion("gl_count <>", value, "glCount");
			return (Criteria) this;
		}

		public Criteria andGlCountGreaterThan(Integer value) {
			addCriterion("gl_count >", value, "glCount");
			return (Criteria) this;
		}

		public Criteria andGlCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("gl_count >=", value, "glCount");
			return (Criteria) this;
		}

		public Criteria andGlCountLessThan(Integer value) {
			addCriterion("gl_count <", value, "glCount");
			return (Criteria) this;
		}

		public Criteria andGlCountLessThanOrEqualTo(Integer value) {
			addCriterion("gl_count <=", value, "glCount");
			return (Criteria) this;
		}

		public Criteria andGlCountIn(List<Integer> values) {
			addCriterion("gl_count in", values, "glCount");
			return (Criteria) this;
		}

		public Criteria andGlCountNotIn(List<Integer> values) {
			addCriterion("gl_count not in", values, "glCount");
			return (Criteria) this;
		}

		public Criteria andGlCountBetween(Integer value1, Integer value2) {
			addCriterion("gl_count between", value1, value2, "glCount");
			return (Criteria) this;
		}

		public Criteria andGlCountNotBetween(Integer value1, Integer value2) {
			addCriterion("gl_count not between", value1, value2, "glCount");
			return (Criteria) this;
		}

		public Criteria andGlMoneyIsNull() {
			addCriterion("gl_money is null");
			return (Criteria) this;
		}

		public Criteria andGlMoneyIsNotNull() {
			addCriterion("gl_money is not null");
			return (Criteria) this;
		}

		public Criteria andGlMoneyEqualTo(Integer value) {
			addCriterion("gl_money =", value, "glMoney");
			return (Criteria) this;
		}

		public Criteria andGlMoneyNotEqualTo(Integer value) {
			addCriterion("gl_money <>", value, "glMoney");
			return (Criteria) this;
		}

		public Criteria andGlMoneyGreaterThan(Integer value) {
			addCriterion("gl_money >", value, "glMoney");
			return (Criteria) this;
		}

		public Criteria andGlMoneyGreaterThanOrEqualTo(Integer value) {
			addCriterion("gl_money >=", value, "glMoney");
			return (Criteria) this;
		}

		public Criteria andGlMoneyLessThan(Integer value) {
			addCriterion("gl_money <", value, "glMoney");
			return (Criteria) this;
		}

		public Criteria andGlMoneyLessThanOrEqualTo(Integer value) {
			addCriterion("gl_money <=", value, "glMoney");
			return (Criteria) this;
		}

		public Criteria andGlMoneyIn(List<Integer> values) {
			addCriterion("gl_money in", values, "glMoney");
			return (Criteria) this;
		}

		public Criteria andGlMoneyNotIn(List<Integer> values) {
			addCriterion("gl_money not in", values, "glMoney");
			return (Criteria) this;
		}

		public Criteria andGlMoneyBetween(Integer value1, Integer value2) {
			addCriterion("gl_money between", value1, value2, "glMoney");
			return (Criteria) this;
		}

		public Criteria andGlMoneyNotBetween(Integer value1, Integer value2) {
			addCriterion("gl_money not between", value1, value2, "glMoney");
			return (Criteria) this;
		}

		public Criteria andGlPaymentIsNull() {
			addCriterion("gl_payment is null");
			return (Criteria) this;
		}

		public Criteria andGlPaymentIsNotNull() {
			addCriterion("gl_payment is not null");
			return (Criteria) this;
		}

		public Criteria andGlPaymentEqualTo(String value) {
			addCriterion("gl_payment =", value, "glPayment");
			return (Criteria) this;
		}

		public Criteria andGlPaymentNotEqualTo(String value) {
			addCriterion("gl_payment <>", value, "glPayment");
			return (Criteria) this;
		}

		public Criteria andGlPaymentGreaterThan(String value) {
			addCriterion("gl_payment >", value, "glPayment");
			return (Criteria) this;
		}

		public Criteria andGlPaymentGreaterThanOrEqualTo(String value) {
			addCriterion("gl_payment >=", value, "glPayment");
			return (Criteria) this;
		}

		public Criteria andGlPaymentLessThan(String value) {
			addCriterion("gl_payment <", value, "glPayment");
			return (Criteria) this;
		}

		public Criteria andGlPaymentLessThanOrEqualTo(String value) {
			addCriterion("gl_payment <=", value, "glPayment");
			return (Criteria) this;
		}

		public Criteria andGlPaymentLike(String value) {
			addCriterion("gl_payment like", value, "glPayment");
			return (Criteria) this;
		}

		public Criteria andGlPaymentNotLike(String value) {
			addCriterion("gl_payment not like", value, "glPayment");
			return (Criteria) this;
		}

		public Criteria andGlPaymentIn(List<String> values) {
			addCriterion("gl_payment in", values, "glPayment");
			return (Criteria) this;
		}

		public Criteria andGlPaymentNotIn(List<String> values) {
			addCriterion("gl_payment not in", values, "glPayment");
			return (Criteria) this;
		}

		public Criteria andGlPaymentBetween(String value1, String value2) {
			addCriterion("gl_payment between", value1, value2, "glPayment");
			return (Criteria) this;
		}

		public Criteria andGlPaymentNotBetween(String value1, String value2) {
			addCriterion("gl_payment not between", value1, value2, "glPayment");
			return (Criteria) this;
		}

		public Criteria andGlTypeIsNull() {
			addCriterion("gl_type is null");
			return (Criteria) this;
		}

		public Criteria andGlTypeIsNotNull() {
			addCriterion("gl_type is not null");
			return (Criteria) this;
		}

		public Criteria andGlTypeEqualTo(Integer value) {
			addCriterion("gl_type =", value, "glType");
			return (Criteria) this;
		}

		public Criteria andGlTypeNotEqualTo(Integer value) {
			addCriterion("gl_type <>", value, "glType");
			return (Criteria) this;
		}

		public Criteria andGlTypeGreaterThan(Integer value) {
			addCriterion("gl_type >", value, "glType");
			return (Criteria) this;
		}

		public Criteria andGlTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("gl_type >=", value, "glType");
			return (Criteria) this;
		}

		public Criteria andGlTypeLessThan(Integer value) {
			addCriterion("gl_type <", value, "glType");
			return (Criteria) this;
		}

		public Criteria andGlTypeLessThanOrEqualTo(Integer value) {
			addCriterion("gl_type <=", value, "glType");
			return (Criteria) this;
		}

		public Criteria andGlTypeIn(List<Integer> values) {
			addCriterion("gl_type in", values, "glType");
			return (Criteria) this;
		}

		public Criteria andGlTypeNotIn(List<Integer> values) {
			addCriterion("gl_type not in", values, "glType");
			return (Criteria) this;
		}

		public Criteria andGlTypeBetween(Integer value1, Integer value2) {
			addCriterion("gl_type between", value1, value2, "glType");
			return (Criteria) this;
		}

		public Criteria andGlTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("gl_type not between", value1, value2, "glType");
			return (Criteria) this;
		}

		public Criteria andGlAdminIdIsNull() {
			addCriterion("gl_admin_id is null");
			return (Criteria) this;
		}

		public Criteria andGlAdminIdIsNotNull() {
			addCriterion("gl_admin_id is not null");
			return (Criteria) this;
		}

		public Criteria andGlAdminIdEqualTo(Long value) {
			addCriterion("gl_admin_id =", value, "glAdminId");
			return (Criteria) this;
		}

		public Criteria andGlAdminIdNotEqualTo(Long value) {
			addCriterion("gl_admin_id <>", value, "glAdminId");
			return (Criteria) this;
		}

		public Criteria andGlAdminIdGreaterThan(Long value) {
			addCriterion("gl_admin_id >", value, "glAdminId");
			return (Criteria) this;
		}

		public Criteria andGlAdminIdGreaterThanOrEqualTo(Long value) {
			addCriterion("gl_admin_id >=", value, "glAdminId");
			return (Criteria) this;
		}

		public Criteria andGlAdminIdLessThan(Long value) {
			addCriterion("gl_admin_id <", value, "glAdminId");
			return (Criteria) this;
		}

		public Criteria andGlAdminIdLessThanOrEqualTo(Long value) {
			addCriterion("gl_admin_id <=", value, "glAdminId");
			return (Criteria) this;
		}

		public Criteria andGlAdminIdIn(List<Long> values) {
			addCriterion("gl_admin_id in", values, "glAdminId");
			return (Criteria) this;
		}

		public Criteria andGlAdminIdNotIn(List<Long> values) {
			addCriterion("gl_admin_id not in", values, "glAdminId");
			return (Criteria) this;
		}

		public Criteria andGlAdminIdBetween(Long value1, Long value2) {
			addCriterion("gl_admin_id between", value1, value2, "glAdminId");
			return (Criteria) this;
		}

		public Criteria andGlAdminIdNotBetween(Long value1, Long value2) {
			addCriterion("gl_admin_id not between", value1, value2, "glAdminId");
			return (Criteria) this;
		}

		public Criteria andGlUserIdIsNull() {
			addCriterion("gl_user_id is null");
			return (Criteria) this;
		}

		public Criteria andGlUserIdIsNotNull() {
			addCriterion("gl_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andGlUserIdEqualTo(Long value) {
			addCriterion("gl_user_id =", value, "glUserId");
			return (Criteria) this;
		}

		public Criteria andGlUserIdNotEqualTo(Long value) {
			addCriterion("gl_user_id <>", value, "glUserId");
			return (Criteria) this;
		}

		public Criteria andGlUserIdGreaterThan(Long value) {
			addCriterion("gl_user_id >", value, "glUserId");
			return (Criteria) this;
		}

		public Criteria andGlUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("gl_user_id >=", value, "glUserId");
			return (Criteria) this;
		}

		public Criteria andGlUserIdLessThan(Long value) {
			addCriterion("gl_user_id <", value, "glUserId");
			return (Criteria) this;
		}

		public Criteria andGlUserIdLessThanOrEqualTo(Long value) {
			addCriterion("gl_user_id <=", value, "glUserId");
			return (Criteria) this;
		}

		public Criteria andGlUserIdIn(List<Long> values) {
			addCriterion("gl_user_id in", values, "glUserId");
			return (Criteria) this;
		}

		public Criteria andGlUserIdNotIn(List<Long> values) {
			addCriterion("gl_user_id not in", values, "glUserId");
			return (Criteria) this;
		}

		public Criteria andGlUserIdBetween(Long value1, Long value2) {
			addCriterion("gl_user_id between", value1, value2, "glUserId");
			return (Criteria) this;
		}

		public Criteria andGlUserIdNotBetween(Long value1, Long value2) {
			addCriterion("gl_user_id not between", value1, value2, "glUserId");
			return (Criteria) this;
		}

		public Criteria andGrIdIsNull() {
			addCriterion("gr_id is null");
			return (Criteria) this;
		}

		public Criteria andGrIdIsNotNull() {
			addCriterion("gr_id is not null");
			return (Criteria) this;
		}

		public Criteria andGrIdEqualTo(Long value) {
			addCriterion("gr_id =", value, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdNotEqualTo(Long value) {
			addCriterion("gr_id <>", value, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdGreaterThan(Long value) {
			addCriterion("gr_id >", value, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdGreaterThanOrEqualTo(Long value) {
			addCriterion("gr_id >=", value, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdLessThan(Long value) {
			addCriterion("gr_id <", value, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdLessThanOrEqualTo(Long value) {
			addCriterion("gr_id <=", value, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdIn(List<Long> values) {
			addCriterion("gr_id in", values, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdNotIn(List<Long> values) {
			addCriterion("gr_id not in", values, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdBetween(Long value1, Long value2) {
			addCriterion("gr_id between", value1, value2, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdNotBetween(Long value1, Long value2) {
			addCriterion("gr_id not between", value1, value2, "grId");
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