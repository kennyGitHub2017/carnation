package com.sinco.carnation.sns.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TipsExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public TipsExample() {
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

		public Criteria andTargetIdIsNull() {
			addCriterion("target_id is null");
			return (Criteria) this;
		}

		public Criteria andTargetIdIsNotNull() {
			addCriterion("target_id is not null");
			return (Criteria) this;
		}

		public Criteria andTargetIdEqualTo(Long value) {
			addCriterion("target_id =", value, "targetId");
			return (Criteria) this;
		}

		public Criteria andTargetIdNotEqualTo(Long value) {
			addCriterion("target_id <>", value, "targetId");
			return (Criteria) this;
		}

		public Criteria andTargetIdGreaterThan(Long value) {
			addCriterion("target_id >", value, "targetId");
			return (Criteria) this;
		}

		public Criteria andTargetIdGreaterThanOrEqualTo(Long value) {
			addCriterion("target_id >=", value, "targetId");
			return (Criteria) this;
		}

		public Criteria andTargetIdLessThan(Long value) {
			addCriterion("target_id <", value, "targetId");
			return (Criteria) this;
		}

		public Criteria andTargetIdLessThanOrEqualTo(Long value) {
			addCriterion("target_id <=", value, "targetId");
			return (Criteria) this;
		}

		public Criteria andTargetIdIn(List<Long> values) {
			addCriterion("target_id in", values, "targetId");
			return (Criteria) this;
		}

		public Criteria andTargetIdNotIn(List<Long> values) {
			addCriterion("target_id not in", values, "targetId");
			return (Criteria) this;
		}

		public Criteria andTargetIdBetween(Long value1, Long value2) {
			addCriterion("target_id between", value1, value2, "targetId");
			return (Criteria) this;
		}

		public Criteria andTargetIdNotBetween(Long value1, Long value2) {
			addCriterion("target_id not between", value1, value2, "targetId");
			return (Criteria) this;
		}

		public Criteria andTipsTypeIsNull() {
			addCriterion("tips_type is null");
			return (Criteria) this;
		}

		public Criteria andTipsTypeIsNotNull() {
			addCriterion("tips_type is not null");
			return (Criteria) this;
		}

		public Criteria andTipsTypeEqualTo(String value) {
			addCriterion("tips_type =", value, "tipsType");
			return (Criteria) this;
		}

		public Criteria andTipsTypeNotEqualTo(String value) {
			addCriterion("tips_type <>", value, "tipsType");
			return (Criteria) this;
		}

		public Criteria andTipsTypeGreaterThan(String value) {
			addCriterion("tips_type >", value, "tipsType");
			return (Criteria) this;
		}

		public Criteria andTipsTypeGreaterThanOrEqualTo(String value) {
			addCriterion("tips_type >=", value, "tipsType");
			return (Criteria) this;
		}

		public Criteria andTipsTypeLessThan(String value) {
			addCriterion("tips_type <", value, "tipsType");
			return (Criteria) this;
		}

		public Criteria andTipsTypeLessThanOrEqualTo(String value) {
			addCriterion("tips_type <=", value, "tipsType");
			return (Criteria) this;
		}

		public Criteria andTipsTypeLike(String value) {
			addCriterion("tips_type like", value, "tipsType");
			return (Criteria) this;
		}

		public Criteria andTipsTypeNotLike(String value) {
			addCriterion("tips_type not like", value, "tipsType");
			return (Criteria) this;
		}

		public Criteria andTipsTypeIn(List<String> values) {
			addCriterion("tips_type in", values, "tipsType");
			return (Criteria) this;
		}

		public Criteria andTipsTypeNotIn(List<String> values) {
			addCriterion("tips_type not in", values, "tipsType");
			return (Criteria) this;
		}

		public Criteria andTipsTypeBetween(String value1, String value2) {
			addCriterion("tips_type between", value1, value2, "tipsType");
			return (Criteria) this;
		}

		public Criteria andTipsTypeNotBetween(String value1, String value2) {
			addCriterion("tips_type not between", value1, value2, "tipsType");
			return (Criteria) this;
		}

		public Criteria andFromUserIdIsNull() {
			addCriterion("from_user_id is null");
			return (Criteria) this;
		}

		public Criteria andFromUserIdIsNotNull() {
			addCriterion("from_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andFromUserIdEqualTo(Long value) {
			addCriterion("from_user_id =", value, "fromUserId");
			return (Criteria) this;
		}

		public Criteria andFromUserIdNotEqualTo(Long value) {
			addCriterion("from_user_id <>", value, "fromUserId");
			return (Criteria) this;
		}

		public Criteria andFromUserIdGreaterThan(Long value) {
			addCriterion("from_user_id >", value, "fromUserId");
			return (Criteria) this;
		}

		public Criteria andFromUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("from_user_id >=", value, "fromUserId");
			return (Criteria) this;
		}

		public Criteria andFromUserIdLessThan(Long value) {
			addCriterion("from_user_id <", value, "fromUserId");
			return (Criteria) this;
		}

		public Criteria andFromUserIdLessThanOrEqualTo(Long value) {
			addCriterion("from_user_id <=", value, "fromUserId");
			return (Criteria) this;
		}

		public Criteria andFromUserIdIn(List<Long> values) {
			addCriterion("from_user_id in", values, "fromUserId");
			return (Criteria) this;
		}

		public Criteria andFromUserIdNotIn(List<Long> values) {
			addCriterion("from_user_id not in", values, "fromUserId");
			return (Criteria) this;
		}

		public Criteria andFromUserIdBetween(Long value1, Long value2) {
			addCriterion("from_user_id between", value1, value2, "fromUserId");
			return (Criteria) this;
		}

		public Criteria andFromUserIdNotBetween(Long value1, Long value2) {
			addCriterion("from_user_id not between", value1, value2, "fromUserId");
			return (Criteria) this;
		}

		public Criteria andFromIpIsNull() {
			addCriterion("from_ip is null");
			return (Criteria) this;
		}

		public Criteria andFromIpIsNotNull() {
			addCriterion("from_ip is not null");
			return (Criteria) this;
		}

		public Criteria andFromIpEqualTo(String value) {
			addCriterion("from_ip =", value, "fromIp");
			return (Criteria) this;
		}

		public Criteria andFromIpNotEqualTo(String value) {
			addCriterion("from_ip <>", value, "fromIp");
			return (Criteria) this;
		}

		public Criteria andFromIpGreaterThan(String value) {
			addCriterion("from_ip >", value, "fromIp");
			return (Criteria) this;
		}

		public Criteria andFromIpGreaterThanOrEqualTo(String value) {
			addCriterion("from_ip >=", value, "fromIp");
			return (Criteria) this;
		}

		public Criteria andFromIpLessThan(String value) {
			addCriterion("from_ip <", value, "fromIp");
			return (Criteria) this;
		}

		public Criteria andFromIpLessThanOrEqualTo(String value) {
			addCriterion("from_ip <=", value, "fromIp");
			return (Criteria) this;
		}

		public Criteria andFromIpLike(String value) {
			addCriterion("from_ip like", value, "fromIp");
			return (Criteria) this;
		}

		public Criteria andFromIpNotLike(String value) {
			addCriterion("from_ip not like", value, "fromIp");
			return (Criteria) this;
		}

		public Criteria andFromIpIn(List<String> values) {
			addCriterion("from_ip in", values, "fromIp");
			return (Criteria) this;
		}

		public Criteria andFromIpNotIn(List<String> values) {
			addCriterion("from_ip not in", values, "fromIp");
			return (Criteria) this;
		}

		public Criteria andFromIpBetween(String value1, String value2) {
			addCriterion("from_ip between", value1, value2, "fromIp");
			return (Criteria) this;
		}

		public Criteria andFromIpNotBetween(String value1, String value2) {
			addCriterion("from_ip not between", value1, value2, "fromIp");
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