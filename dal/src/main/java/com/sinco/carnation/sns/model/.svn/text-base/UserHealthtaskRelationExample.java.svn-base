package com.sinco.carnation.sns.model;

import com.sinco.carnation.sns.bo.UserHealthtaskRelationBO;
import com.sinco.mybatis.dal.core.AbstractExample;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserHealthtaskRelationExample extends AbstractExample<UserHealthtaskRelationBO> {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected String limit;

	public UserHealthtaskRelationExample() {
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

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public void setLimit(int count) {
		this.limit = String.valueOf(count);
	}

	public void setLimit(int offset, int rows) {
		this.limit = new StringBuilder().append(String.valueOf(offset)).append(",")
				.append(String.valueOf(rows)).toString();
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

		public Criteria andUserIdIsNull() {
			addCriterion("user_id is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("user_id is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(Long value) {
			addCriterion("user_id =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(Long value) {
			addCriterion("user_id <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(Long value) {
			addCriterion("user_id >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("user_id >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(Long value) {
			addCriterion("user_id <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(Long value) {
			addCriterion("user_id <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<Long> values) {
			addCriterion("user_id in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<Long> values) {
			addCriterion("user_id not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(Long value1, Long value2) {
			addCriterion("user_id between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(Long value1, Long value2) {
			addCriterion("user_id not between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserHealthtaskIdIsNull() {
			addCriterion("user_healthTask_id is null");
			return (Criteria) this;
		}

		public Criteria andUserHealthtaskIdIsNotNull() {
			addCriterion("user_healthTask_id is not null");
			return (Criteria) this;
		}

		public Criteria andUserHealthtaskIdEqualTo(Long value) {
			addCriterion("user_healthTask_id =", value, "userHealthtaskId");
			return (Criteria) this;
		}

		public Criteria andUserHealthtaskIdNotEqualTo(Long value) {
			addCriterion("user_healthTask_id <>", value, "userHealthtaskId");
			return (Criteria) this;
		}

		public Criteria andUserHealthtaskIdGreaterThan(Long value) {
			addCriterion("user_healthTask_id >", value, "userHealthtaskId");
			return (Criteria) this;
		}

		public Criteria andUserHealthtaskIdGreaterThanOrEqualTo(Long value) {
			addCriterion("user_healthTask_id >=", value, "userHealthtaskId");
			return (Criteria) this;
		}

		public Criteria andUserHealthtaskIdLessThan(Long value) {
			addCriterion("user_healthTask_id <", value, "userHealthtaskId");
			return (Criteria) this;
		}

		public Criteria andUserHealthtaskIdLessThanOrEqualTo(Long value) {
			addCriterion("user_healthTask_id <=", value, "userHealthtaskId");
			return (Criteria) this;
		}

		public Criteria andUserHealthtaskIdIn(List<Long> values) {
			addCriterion("user_healthTask_id in", values, "userHealthtaskId");
			return (Criteria) this;
		}

		public Criteria andUserHealthtaskIdNotIn(List<Long> values) {
			addCriterion("user_healthTask_id not in", values, "userHealthtaskId");
			return (Criteria) this;
		}

		public Criteria andUserHealthtaskIdBetween(Long value1, Long value2) {
			addCriterion("user_healthTask_id between", value1, value2, "userHealthtaskId");
			return (Criteria) this;
		}

		public Criteria andUserHealthtaskIdNotBetween(Long value1, Long value2) {
			addCriterion("user_healthTask_id not between", value1, value2, "userHealthtaskId");
			return (Criteria) this;
		}

		public Criteria andJoinTimeIsNull() {
			addCriterion("join_time is null");
			return (Criteria) this;
		}

		public Criteria andJoinTimeIsNotNull() {
			addCriterion("join_time is not null");
			return (Criteria) this;
		}

		public Criteria andJoinTimeEqualTo(Date value) {
			addCriterion("join_time =", value, "joinTime");
			return (Criteria) this;
		}

		public Criteria andJoinTimeNotEqualTo(Date value) {
			addCriterion("join_time <>", value, "joinTime");
			return (Criteria) this;
		}

		public Criteria andJoinTimeGreaterThan(Date value) {
			addCriterion("join_time >", value, "joinTime");
			return (Criteria) this;
		}

		public Criteria andJoinTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("join_time >=", value, "joinTime");
			return (Criteria) this;
		}

		public Criteria andJoinTimeLessThan(Date value) {
			addCriterion("join_time <", value, "joinTime");
			return (Criteria) this;
		}

		public Criteria andJoinTimeLessThanOrEqualTo(Date value) {
			addCriterion("join_time <=", value, "joinTime");
			return (Criteria) this;
		}

		public Criteria andJoinTimeIn(List<Date> values) {
			addCriterion("join_time in", values, "joinTime");
			return (Criteria) this;
		}

		public Criteria andJoinTimeNotIn(List<Date> values) {
			addCriterion("join_time not in", values, "joinTime");
			return (Criteria) this;
		}

		public Criteria andJoinTimeBetween(Date value1, Date value2) {
			addCriterion("join_time between", value1, value2, "joinTime");
			return (Criteria) this;
		}

		public Criteria andJoinTimeNotBetween(Date value1, Date value2) {
			addCriterion("join_time not between", value1, value2, "joinTime");
			return (Criteria) this;
		}

		public Criteria andIsDeletedIsNull() {
			addCriterion("is_deleted is null");
			return (Criteria) this;
		}

		public Criteria andIsDeletedIsNotNull() {
			addCriterion("is_deleted is not null");
			return (Criteria) this;
		}

		public Criteria andIsDeletedEqualTo(Long value) {
			addCriterion("is_deleted =", value, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedNotEqualTo(Long value) {
			addCriterion("is_deleted <>", value, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedGreaterThan(Long value) {
			addCriterion("is_deleted >", value, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedGreaterThanOrEqualTo(Long value) {
			addCriterion("is_deleted >=", value, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedLessThan(Long value) {
			addCriterion("is_deleted <", value, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedLessThanOrEqualTo(Long value) {
			addCriterion("is_deleted <=", value, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedIn(List<Long> values) {
			addCriterion("is_deleted in", values, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedNotIn(List<Long> values) {
			addCriterion("is_deleted not in", values, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedBetween(Long value1, Long value2) {
			addCriterion("is_deleted between", value1, value2, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedNotBetween(Long value1, Long value2) {
			addCriterion("is_deleted not between", value1, value2, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andDoDaysIsNull() {
			addCriterion("do_days is null");
			return (Criteria) this;
		}

		public Criteria andDoDaysIsNotNull() {
			addCriterion("do_days is not null");
			return (Criteria) this;
		}

		public Criteria andDoDaysEqualTo(Long value) {
			addCriterion("do_days =", value, "doDays");
			return (Criteria) this;
		}

		public Criteria andDoDaysNotEqualTo(Long value) {
			addCriterion("do_days <>", value, "doDays");
			return (Criteria) this;
		}

		public Criteria andDoDaysGreaterThan(Long value) {
			addCriterion("do_days >", value, "doDays");
			return (Criteria) this;
		}

		public Criteria andDoDaysGreaterThanOrEqualTo(Long value) {
			addCriterion("do_days >=", value, "doDays");
			return (Criteria) this;
		}

		public Criteria andDoDaysLessThan(Long value) {
			addCriterion("do_days <", value, "doDays");
			return (Criteria) this;
		}

		public Criteria andDoDaysLessThanOrEqualTo(Long value) {
			addCriterion("do_days <=", value, "doDays");
			return (Criteria) this;
		}

		public Criteria andDoDaysIn(List<Long> values) {
			addCriterion("do_days in", values, "doDays");
			return (Criteria) this;
		}

		public Criteria andDoDaysNotIn(List<Long> values) {
			addCriterion("do_days not in", values, "doDays");
			return (Criteria) this;
		}

		public Criteria andDoDaysBetween(Long value1, Long value2) {
			addCriterion("do_days between", value1, value2, "doDays");
			return (Criteria) this;
		}

		public Criteria andDoDaysNotBetween(Long value1, Long value2) {
			addCriterion("do_days not between", value1, value2, "doDays");
			return (Criteria) this;
		}

		public Criteria andFinishTimeIsNull() {
			addCriterion("finish_time is null");
			return (Criteria) this;
		}

		public Criteria andFinishTimeIsNotNull() {
			addCriterion("finish_time is not null");
			return (Criteria) this;
		}

		public Criteria andFinishTimeEqualTo(String value) {
			addCriterion("finish_time =", value, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeNotEqualTo(String value) {
			addCriterion("finish_time <>", value, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeGreaterThan(String value) {
			addCriterion("finish_time >", value, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeGreaterThanOrEqualTo(String value) {
			addCriterion("finish_time >=", value, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeLessThan(String value) {
			addCriterion("finish_time <", value, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeLessThanOrEqualTo(String value) {
			addCriterion("finish_time <=", value, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeLike(String value) {
			addCriterion("finish_time like", value, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeNotLike(String value) {
			addCriterion("finish_time not like", value, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeIn(List<String> values) {
			addCriterion("finish_time in", values, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeNotIn(List<String> values) {
			addCriterion("finish_time not in", values, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeBetween(String value1, String value2) {
			addCriterion("finish_time between", value1, value2, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeNotBetween(String value1, String value2) {
			addCriterion("finish_time not between", value1, value2, "finishTime");
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