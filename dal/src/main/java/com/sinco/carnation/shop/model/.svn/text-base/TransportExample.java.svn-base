package com.sinco.carnation.shop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransportExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public TransportExample() {
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

		public Criteria andTransEmsIsNull() {
			addCriterion("trans_ems is null");
			return (Criteria) this;
		}

		public Criteria andTransEmsIsNotNull() {
			addCriterion("trans_ems is not null");
			return (Criteria) this;
		}

		public Criteria andTransEmsEqualTo(Boolean value) {
			addCriterion("trans_ems =", value, "transEms");
			return (Criteria) this;
		}

		public Criteria andTransEmsNotEqualTo(Boolean value) {
			addCriterion("trans_ems <>", value, "transEms");
			return (Criteria) this;
		}

		public Criteria andTransEmsGreaterThan(Boolean value) {
			addCriterion("trans_ems >", value, "transEms");
			return (Criteria) this;
		}

		public Criteria andTransEmsGreaterThanOrEqualTo(Boolean value) {
			addCriterion("trans_ems >=", value, "transEms");
			return (Criteria) this;
		}

		public Criteria andTransEmsLessThan(Boolean value) {
			addCriterion("trans_ems <", value, "transEms");
			return (Criteria) this;
		}

		public Criteria andTransEmsLessThanOrEqualTo(Boolean value) {
			addCriterion("trans_ems <=", value, "transEms");
			return (Criteria) this;
		}

		public Criteria andTransEmsIn(List<Boolean> values) {
			addCriterion("trans_ems in", values, "transEms");
			return (Criteria) this;
		}

		public Criteria andTransEmsNotIn(List<Boolean> values) {
			addCriterion("trans_ems not in", values, "transEms");
			return (Criteria) this;
		}

		public Criteria andTransEmsBetween(Boolean value1, Boolean value2) {
			addCriterion("trans_ems between", value1, value2, "transEms");
			return (Criteria) this;
		}

		public Criteria andTransEmsNotBetween(Boolean value1, Boolean value2) {
			addCriterion("trans_ems not between", value1, value2, "transEms");
			return (Criteria) this;
		}

		public Criteria andTransExpressIsNull() {
			addCriterion("trans_express is null");
			return (Criteria) this;
		}

		public Criteria andTransExpressIsNotNull() {
			addCriterion("trans_express is not null");
			return (Criteria) this;
		}

		public Criteria andTransExpressEqualTo(Boolean value) {
			addCriterion("trans_express =", value, "transExpress");
			return (Criteria) this;
		}

		public Criteria andTransExpressNotEqualTo(Boolean value) {
			addCriterion("trans_express <>", value, "transExpress");
			return (Criteria) this;
		}

		public Criteria andTransExpressGreaterThan(Boolean value) {
			addCriterion("trans_express >", value, "transExpress");
			return (Criteria) this;
		}

		public Criteria andTransExpressGreaterThanOrEqualTo(Boolean value) {
			addCriterion("trans_express >=", value, "transExpress");
			return (Criteria) this;
		}

		public Criteria andTransExpressLessThan(Boolean value) {
			addCriterion("trans_express <", value, "transExpress");
			return (Criteria) this;
		}

		public Criteria andTransExpressLessThanOrEqualTo(Boolean value) {
			addCriterion("trans_express <=", value, "transExpress");
			return (Criteria) this;
		}

		public Criteria andTransExpressIn(List<Boolean> values) {
			addCriterion("trans_express in", values, "transExpress");
			return (Criteria) this;
		}

		public Criteria andTransExpressNotIn(List<Boolean> values) {
			addCriterion("trans_express not in", values, "transExpress");
			return (Criteria) this;
		}

		public Criteria andTransExpressBetween(Boolean value1, Boolean value2) {
			addCriterion("trans_express between", value1, value2, "transExpress");
			return (Criteria) this;
		}

		public Criteria andTransExpressNotBetween(Boolean value1, Boolean value2) {
			addCriterion("trans_express not between", value1, value2, "transExpress");
			return (Criteria) this;
		}

		public Criteria andTransMailIsNull() {
			addCriterion("trans_mail is null");
			return (Criteria) this;
		}

		public Criteria andTransMailIsNotNull() {
			addCriterion("trans_mail is not null");
			return (Criteria) this;
		}

		public Criteria andTransMailEqualTo(Boolean value) {
			addCriterion("trans_mail =", value, "transMail");
			return (Criteria) this;
		}

		public Criteria andTransMailNotEqualTo(Boolean value) {
			addCriterion("trans_mail <>", value, "transMail");
			return (Criteria) this;
		}

		public Criteria andTransMailGreaterThan(Boolean value) {
			addCriterion("trans_mail >", value, "transMail");
			return (Criteria) this;
		}

		public Criteria andTransMailGreaterThanOrEqualTo(Boolean value) {
			addCriterion("trans_mail >=", value, "transMail");
			return (Criteria) this;
		}

		public Criteria andTransMailLessThan(Boolean value) {
			addCriterion("trans_mail <", value, "transMail");
			return (Criteria) this;
		}

		public Criteria andTransMailLessThanOrEqualTo(Boolean value) {
			addCriterion("trans_mail <=", value, "transMail");
			return (Criteria) this;
		}

		public Criteria andTransMailIn(List<Boolean> values) {
			addCriterion("trans_mail in", values, "transMail");
			return (Criteria) this;
		}

		public Criteria andTransMailNotIn(List<Boolean> values) {
			addCriterion("trans_mail not in", values, "transMail");
			return (Criteria) this;
		}

		public Criteria andTransMailBetween(Boolean value1, Boolean value2) {
			addCriterion("trans_mail between", value1, value2, "transMail");
			return (Criteria) this;
		}

		public Criteria andTransMailNotBetween(Boolean value1, Boolean value2) {
			addCriterion("trans_mail not between", value1, value2, "transMail");
			return (Criteria) this;
		}

		public Criteria andTransNameIsNull() {
			addCriterion("trans_name is null");
			return (Criteria) this;
		}

		public Criteria andTransNameIsNotNull() {
			addCriterion("trans_name is not null");
			return (Criteria) this;
		}

		public Criteria andTransNameEqualTo(String value) {
			addCriterion("trans_name =", value, "transName");
			return (Criteria) this;
		}

		public Criteria andTransNameNotEqualTo(String value) {
			addCriterion("trans_name <>", value, "transName");
			return (Criteria) this;
		}

		public Criteria andTransNameGreaterThan(String value) {
			addCriterion("trans_name >", value, "transName");
			return (Criteria) this;
		}

		public Criteria andTransNameGreaterThanOrEqualTo(String value) {
			addCriterion("trans_name >=", value, "transName");
			return (Criteria) this;
		}

		public Criteria andTransNameLessThan(String value) {
			addCriterion("trans_name <", value, "transName");
			return (Criteria) this;
		}

		public Criteria andTransNameLessThanOrEqualTo(String value) {
			addCriterion("trans_name <=", value, "transName");
			return (Criteria) this;
		}

		public Criteria andTransNameLike(String value) {
			addCriterion("trans_name like", value, "transName");
			return (Criteria) this;
		}

		public Criteria andTransNameNotLike(String value) {
			addCriterion("trans_name not like", value, "transName");
			return (Criteria) this;
		}

		public Criteria andTransNameIn(List<String> values) {
			addCriterion("trans_name in", values, "transName");
			return (Criteria) this;
		}

		public Criteria andTransNameNotIn(List<String> values) {
			addCriterion("trans_name not in", values, "transName");
			return (Criteria) this;
		}

		public Criteria andTransNameBetween(String value1, String value2) {
			addCriterion("trans_name between", value1, value2, "transName");
			return (Criteria) this;
		}

		public Criteria andTransNameNotBetween(String value1, String value2) {
			addCriterion("trans_name not between", value1, value2, "transName");
			return (Criteria) this;
		}

		public Criteria andTransTimeIsNull() {
			addCriterion("trans_time is null");
			return (Criteria) this;
		}

		public Criteria andTransTimeIsNotNull() {
			addCriterion("trans_time is not null");
			return (Criteria) this;
		}

		public Criteria andTransTimeEqualTo(Integer value) {
			addCriterion("trans_time =", value, "transTime");
			return (Criteria) this;
		}

		public Criteria andTransTimeNotEqualTo(Integer value) {
			addCriterion("trans_time <>", value, "transTime");
			return (Criteria) this;
		}

		public Criteria andTransTimeGreaterThan(Integer value) {
			addCriterion("trans_time >", value, "transTime");
			return (Criteria) this;
		}

		public Criteria andTransTimeGreaterThanOrEqualTo(Integer value) {
			addCriterion("trans_time >=", value, "transTime");
			return (Criteria) this;
		}

		public Criteria andTransTimeLessThan(Integer value) {
			addCriterion("trans_time <", value, "transTime");
			return (Criteria) this;
		}

		public Criteria andTransTimeLessThanOrEqualTo(Integer value) {
			addCriterion("trans_time <=", value, "transTime");
			return (Criteria) this;
		}

		public Criteria andTransTimeIn(List<Integer> values) {
			addCriterion("trans_time in", values, "transTime");
			return (Criteria) this;
		}

		public Criteria andTransTimeNotIn(List<Integer> values) {
			addCriterion("trans_time not in", values, "transTime");
			return (Criteria) this;
		}

		public Criteria andTransTimeBetween(Integer value1, Integer value2) {
			addCriterion("trans_time between", value1, value2, "transTime");
			return (Criteria) this;
		}

		public Criteria andTransTimeNotBetween(Integer value1, Integer value2) {
			addCriterion("trans_time not between", value1, value2, "transTime");
			return (Criteria) this;
		}

		public Criteria andTransTypeIsNull() {
			addCriterion("trans_type is null");
			return (Criteria) this;
		}

		public Criteria andTransTypeIsNotNull() {
			addCriterion("trans_type is not null");
			return (Criteria) this;
		}

		public Criteria andTransTypeEqualTo(Integer value) {
			addCriterion("trans_type =", value, "transType");
			return (Criteria) this;
		}

		public Criteria andTransTypeNotEqualTo(Integer value) {
			addCriterion("trans_type <>", value, "transType");
			return (Criteria) this;
		}

		public Criteria andTransTypeGreaterThan(Integer value) {
			addCriterion("trans_type >", value, "transType");
			return (Criteria) this;
		}

		public Criteria andTransTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("trans_type >=", value, "transType");
			return (Criteria) this;
		}

		public Criteria andTransTypeLessThan(Integer value) {
			addCriterion("trans_type <", value, "transType");
			return (Criteria) this;
		}

		public Criteria andTransTypeLessThanOrEqualTo(Integer value) {
			addCriterion("trans_type <=", value, "transType");
			return (Criteria) this;
		}

		public Criteria andTransTypeIn(List<Integer> values) {
			addCriterion("trans_type in", values, "transType");
			return (Criteria) this;
		}

		public Criteria andTransTypeNotIn(List<Integer> values) {
			addCriterion("trans_type not in", values, "transType");
			return (Criteria) this;
		}

		public Criteria andTransTypeBetween(Integer value1, Integer value2) {
			addCriterion("trans_type between", value1, value2, "transType");
			return (Criteria) this;
		}

		public Criteria andTransTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("trans_type not between", value1, value2, "transType");
			return (Criteria) this;
		}

		public Criteria andTransUserIsNull() {
			addCriterion("trans_user is null");
			return (Criteria) this;
		}

		public Criteria andTransUserIsNotNull() {
			addCriterion("trans_user is not null");
			return (Criteria) this;
		}

		public Criteria andTransUserEqualTo(Integer value) {
			addCriterion("trans_user =", value, "transUser");
			return (Criteria) this;
		}

		public Criteria andTransUserNotEqualTo(Integer value) {
			addCriterion("trans_user <>", value, "transUser");
			return (Criteria) this;
		}

		public Criteria andTransUserGreaterThan(Integer value) {
			addCriterion("trans_user >", value, "transUser");
			return (Criteria) this;
		}

		public Criteria andTransUserGreaterThanOrEqualTo(Integer value) {
			addCriterion("trans_user >=", value, "transUser");
			return (Criteria) this;
		}

		public Criteria andTransUserLessThan(Integer value) {
			addCriterion("trans_user <", value, "transUser");
			return (Criteria) this;
		}

		public Criteria andTransUserLessThanOrEqualTo(Integer value) {
			addCriterion("trans_user <=", value, "transUser");
			return (Criteria) this;
		}

		public Criteria andTransUserIn(List<Integer> values) {
			addCriterion("trans_user in", values, "transUser");
			return (Criteria) this;
		}

		public Criteria andTransUserNotIn(List<Integer> values) {
			addCriterion("trans_user not in", values, "transUser");
			return (Criteria) this;
		}

		public Criteria andTransUserBetween(Integer value1, Integer value2) {
			addCriterion("trans_user between", value1, value2, "transUser");
			return (Criteria) this;
		}

		public Criteria andTransUserNotBetween(Integer value1, Integer value2) {
			addCriterion("trans_user not between", value1, value2, "transUser");
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