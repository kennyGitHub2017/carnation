package com.sinco.carnation.user.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserFootPointExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public UserFootPointExample() {
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

		public Criteria andAddtimeIsNull() {
			addCriterion("addTime is null");
			return (Criteria) this;
		}

		public Criteria andAddtimeIsNotNull() {
			addCriterion("addTime is not null");
			return (Criteria) this;
		}

		public Criteria andAddtimeEqualTo(Date value) {
			addCriterion("addTime =", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeNotEqualTo(Date value) {
			addCriterion("addTime <>", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeGreaterThan(Date value) {
			addCriterion("addTime >", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeGreaterThanOrEqualTo(Date value) {
			addCriterion("addTime >=", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeLessThan(Date value) {
			addCriterion("addTime <", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeLessThanOrEqualTo(Date value) {
			addCriterion("addTime <=", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeIn(List<Date> values) {
			addCriterion("addTime in", values, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeNotIn(List<Date> values) {
			addCriterion("addTime not in", values, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeBetween(Date value1, Date value2) {
			addCriterion("addTime between", value1, value2, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeNotBetween(Date value1, Date value2) {
			addCriterion("addTime not between", value1, value2, "addtime");
			return (Criteria) this;
		}

		public Criteria andDeletestatusIsNull() {
			addCriterion("deleteStatus is null");
			return (Criteria) this;
		}

		public Criteria andDeletestatusIsNotNull() {
			addCriterion("deleteStatus is not null");
			return (Criteria) this;
		}

		public Criteria andDeletestatusEqualTo(Integer value) {
			addCriterion("deleteStatus =", value, "deletestatus");
			return (Criteria) this;
		}

		public Criteria andDeletestatusNotEqualTo(Integer value) {
			addCriterion("deleteStatus <>", value, "deletestatus");
			return (Criteria) this;
		}

		public Criteria andDeletestatusGreaterThan(Integer value) {
			addCriterion("deleteStatus >", value, "deletestatus");
			return (Criteria) this;
		}

		public Criteria andDeletestatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("deleteStatus >=", value, "deletestatus");
			return (Criteria) this;
		}

		public Criteria andDeletestatusLessThan(Integer value) {
			addCriterion("deleteStatus <", value, "deletestatus");
			return (Criteria) this;
		}

		public Criteria andDeletestatusLessThanOrEqualTo(Integer value) {
			addCriterion("deleteStatus <=", value, "deletestatus");
			return (Criteria) this;
		}

		public Criteria andDeletestatusIn(List<Integer> values) {
			addCriterion("deleteStatus in", values, "deletestatus");
			return (Criteria) this;
		}

		public Criteria andDeletestatusNotIn(List<Integer> values) {
			addCriterion("deleteStatus not in", values, "deletestatus");
			return (Criteria) this;
		}

		public Criteria andDeletestatusBetween(Integer value1, Integer value2) {
			addCriterion("deleteStatus between", value1, value2, "deletestatus");
			return (Criteria) this;
		}

		public Criteria andDeletestatusNotBetween(Integer value1, Integer value2) {
			addCriterion("deleteStatus not between", value1, value2, "deletestatus");
			return (Criteria) this;
		}

		public Criteria andFpDateIsNull() {
			addCriterion("fp_date is null");
			return (Criteria) this;
		}

		public Criteria andFpDateIsNotNull() {
			addCriterion("fp_date is not null");
			return (Criteria) this;
		}

		public Criteria andFpDateEqualTo(Date value) {
			addCriterionForJDBCDate("fp_date =", value, "fpDate");
			return (Criteria) this;
		}

		public Criteria andFpDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("fp_date <>", value, "fpDate");
			return (Criteria) this;
		}

		public Criteria andFpDateGreaterThan(Date value) {
			addCriterionForJDBCDate("fp_date >", value, "fpDate");
			return (Criteria) this;
		}

		public Criteria andFpDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("fp_date >=", value, "fpDate");
			return (Criteria) this;
		}

		public Criteria andFpDateLessThan(Date value) {
			addCriterionForJDBCDate("fp_date <", value, "fpDate");
			return (Criteria) this;
		}

		public Criteria andFpDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("fp_date <=", value, "fpDate");
			return (Criteria) this;
		}

		public Criteria andFpDateIn(List<Date> values) {
			addCriterionForJDBCDate("fp_date in", values, "fpDate");
			return (Criteria) this;
		}

		public Criteria andFpDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("fp_date not in", values, "fpDate");
			return (Criteria) this;
		}

		public Criteria andFpDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("fp_date between", value1, value2, "fpDate");
			return (Criteria) this;
		}

		public Criteria andFpDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("fp_date not between", value1, value2, "fpDate");
			return (Criteria) this;
		}

		public Criteria andFpGoodsCountIsNull() {
			addCriterion("fp_goods_count is null");
			return (Criteria) this;
		}

		public Criteria andFpGoodsCountIsNotNull() {
			addCriterion("fp_goods_count is not null");
			return (Criteria) this;
		}

		public Criteria andFpGoodsCountEqualTo(Integer value) {
			addCriterion("fp_goods_count =", value, "fpGoodsCount");
			return (Criteria) this;
		}

		public Criteria andFpGoodsCountNotEqualTo(Integer value) {
			addCriterion("fp_goods_count <>", value, "fpGoodsCount");
			return (Criteria) this;
		}

		public Criteria andFpGoodsCountGreaterThan(Integer value) {
			addCriterion("fp_goods_count >", value, "fpGoodsCount");
			return (Criteria) this;
		}

		public Criteria andFpGoodsCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("fp_goods_count >=", value, "fpGoodsCount");
			return (Criteria) this;
		}

		public Criteria andFpGoodsCountLessThan(Integer value) {
			addCriterion("fp_goods_count <", value, "fpGoodsCount");
			return (Criteria) this;
		}

		public Criteria andFpGoodsCountLessThanOrEqualTo(Integer value) {
			addCriterion("fp_goods_count <=", value, "fpGoodsCount");
			return (Criteria) this;
		}

		public Criteria andFpGoodsCountIn(List<Integer> values) {
			addCriterion("fp_goods_count in", values, "fpGoodsCount");
			return (Criteria) this;
		}

		public Criteria andFpGoodsCountNotIn(List<Integer> values) {
			addCriterion("fp_goods_count not in", values, "fpGoodsCount");
			return (Criteria) this;
		}

		public Criteria andFpGoodsCountBetween(Integer value1, Integer value2) {
			addCriterion("fp_goods_count between", value1, value2, "fpGoodsCount");
			return (Criteria) this;
		}

		public Criteria andFpGoodsCountNotBetween(Integer value1, Integer value2) {
			addCriterion("fp_goods_count not between", value1, value2, "fpGoodsCount");
			return (Criteria) this;
		}

		public Criteria andFpUserIdIsNull() {
			addCriterion("fp_user_id is null");
			return (Criteria) this;
		}

		public Criteria andFpUserIdIsNotNull() {
			addCriterion("fp_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andFpUserIdEqualTo(Long value) {
			addCriterion("fp_user_id =", value, "fpUserId");
			return (Criteria) this;
		}

		public Criteria andFpUserIdNotEqualTo(Long value) {
			addCriterion("fp_user_id <>", value, "fpUserId");
			return (Criteria) this;
		}

		public Criteria andFpUserIdGreaterThan(Long value) {
			addCriterion("fp_user_id >", value, "fpUserId");
			return (Criteria) this;
		}

		public Criteria andFpUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("fp_user_id >=", value, "fpUserId");
			return (Criteria) this;
		}

		public Criteria andFpUserIdLessThan(Long value) {
			addCriterion("fp_user_id <", value, "fpUserId");
			return (Criteria) this;
		}

		public Criteria andFpUserIdLessThanOrEqualTo(Long value) {
			addCriterion("fp_user_id <=", value, "fpUserId");
			return (Criteria) this;
		}

		public Criteria andFpUserIdIn(List<Long> values) {
			addCriterion("fp_user_id in", values, "fpUserId");
			return (Criteria) this;
		}

		public Criteria andFpUserIdNotIn(List<Long> values) {
			addCriterion("fp_user_id not in", values, "fpUserId");
			return (Criteria) this;
		}

		public Criteria andFpUserIdBetween(Long value1, Long value2) {
			addCriterion("fp_user_id between", value1, value2, "fpUserId");
			return (Criteria) this;
		}

		public Criteria andFpUserIdNotBetween(Long value1, Long value2) {
			addCriterion("fp_user_id not between", value1, value2, "fpUserId");
			return (Criteria) this;
		}

		public Criteria andFpUserNameIsNull() {
			addCriterion("fp_user_name is null");
			return (Criteria) this;
		}

		public Criteria andFpUserNameIsNotNull() {
			addCriterion("fp_user_name is not null");
			return (Criteria) this;
		}

		public Criteria andFpUserNameEqualTo(String value) {
			addCriterion("fp_user_name =", value, "fpUserName");
			return (Criteria) this;
		}

		public Criteria andFpUserNameNotEqualTo(String value) {
			addCriterion("fp_user_name <>", value, "fpUserName");
			return (Criteria) this;
		}

		public Criteria andFpUserNameGreaterThan(String value) {
			addCriterion("fp_user_name >", value, "fpUserName");
			return (Criteria) this;
		}

		public Criteria andFpUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("fp_user_name >=", value, "fpUserName");
			return (Criteria) this;
		}

		public Criteria andFpUserNameLessThan(String value) {
			addCriterion("fp_user_name <", value, "fpUserName");
			return (Criteria) this;
		}

		public Criteria andFpUserNameLessThanOrEqualTo(String value) {
			addCriterion("fp_user_name <=", value, "fpUserName");
			return (Criteria) this;
		}

		public Criteria andFpUserNameLike(String value) {
			addCriterion("fp_user_name like", value, "fpUserName");
			return (Criteria) this;
		}

		public Criteria andFpUserNameNotLike(String value) {
			addCriterion("fp_user_name not like", value, "fpUserName");
			return (Criteria) this;
		}

		public Criteria andFpUserNameIn(List<String> values) {
			addCriterion("fp_user_name in", values, "fpUserName");
			return (Criteria) this;
		}

		public Criteria andFpUserNameNotIn(List<String> values) {
			addCriterion("fp_user_name not in", values, "fpUserName");
			return (Criteria) this;
		}

		public Criteria andFpUserNameBetween(String value1, String value2) {
			addCriterion("fp_user_name between", value1, value2, "fpUserName");
			return (Criteria) this;
		}

		public Criteria andFpUserNameNotBetween(String value1, String value2) {
			addCriterion("fp_user_name not between", value1, value2, "fpUserName");
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