package com.sinco.carnation.sys.model;

import com.sinco.carnation.sys.bo.RelationMessageBO;
import com.sinco.mybatis.dal.core.AbstractExample;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RelationMessageExample extends AbstractExample<RelationMessageBO> {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected String limit;

	public RelationMessageExample() {
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

		public Criteria andForUserIdIsNull() {
			addCriterion("for_user_id is null");
			return (Criteria) this;
		}

		public Criteria andForUserIdIsNotNull() {
			addCriterion("for_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andForUserIdEqualTo(Long value) {
			addCriterion("for_user_id =", value, "forUserId");
			return (Criteria) this;
		}

		public Criteria andForUserIdNotEqualTo(Long value) {
			addCriterion("for_user_id <>", value, "forUserId");
			return (Criteria) this;
		}

		public Criteria andForUserIdGreaterThan(Long value) {
			addCriterion("for_user_id >", value, "forUserId");
			return (Criteria) this;
		}

		public Criteria andForUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("for_user_id >=", value, "forUserId");
			return (Criteria) this;
		}

		public Criteria andForUserIdLessThan(Long value) {
			addCriterion("for_user_id <", value, "forUserId");
			return (Criteria) this;
		}

		public Criteria andForUserIdLessThanOrEqualTo(Long value) {
			addCriterion("for_user_id <=", value, "forUserId");
			return (Criteria) this;
		}

		public Criteria andForUserIdIn(List<Long> values) {
			addCriterion("for_user_id in", values, "forUserId");
			return (Criteria) this;
		}

		public Criteria andForUserIdNotIn(List<Long> values) {
			addCriterion("for_user_id not in", values, "forUserId");
			return (Criteria) this;
		}

		public Criteria andForUserIdBetween(Long value1, Long value2) {
			addCriterion("for_user_id between", value1, value2, "forUserId");
			return (Criteria) this;
		}

		public Criteria andForUserIdNotBetween(Long value1, Long value2) {
			addCriterion("for_user_id not between", value1, value2, "forUserId");
			return (Criteria) this;
		}

		public Criteria andToUserIdIsNull() {
			addCriterion("to_user_id is null");
			return (Criteria) this;
		}

		public Criteria andToUserIdIsNotNull() {
			addCriterion("to_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andToUserIdEqualTo(Long value) {
			addCriterion("to_user_id =", value, "toUserId");
			return (Criteria) this;
		}

		public Criteria andToUserIdNotEqualTo(Long value) {
			addCriterion("to_user_id <>", value, "toUserId");
			return (Criteria) this;
		}

		public Criteria andToUserIdGreaterThan(Long value) {
			addCriterion("to_user_id >", value, "toUserId");
			return (Criteria) this;
		}

		public Criteria andToUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("to_user_id >=", value, "toUserId");
			return (Criteria) this;
		}

		public Criteria andToUserIdLessThan(Long value) {
			addCriterion("to_user_id <", value, "toUserId");
			return (Criteria) this;
		}

		public Criteria andToUserIdLessThanOrEqualTo(Long value) {
			addCriterion("to_user_id <=", value, "toUserId");
			return (Criteria) this;
		}

		public Criteria andToUserIdIn(List<Long> values) {
			addCriterion("to_user_id in", values, "toUserId");
			return (Criteria) this;
		}

		public Criteria andToUserIdNotIn(List<Long> values) {
			addCriterion("to_user_id not in", values, "toUserId");
			return (Criteria) this;
		}

		public Criteria andToUserIdBetween(Long value1, Long value2) {
			addCriterion("to_user_id between", value1, value2, "toUserId");
			return (Criteria) this;
		}

		public Criteria andToUserIdNotBetween(Long value1, Long value2) {
			addCriterion("to_user_id not between", value1, value2, "toUserId");
			return (Criteria) this;
		}

		public Criteria andCreatTimeIsNull() {
			addCriterion("creat_time is null");
			return (Criteria) this;
		}

		public Criteria andCreatTimeIsNotNull() {
			addCriterion("creat_time is not null");
			return (Criteria) this;
		}

		public Criteria andCreatTimeEqualTo(Date value) {
			addCriterion("creat_time =", value, "creatTime");
			return (Criteria) this;
		}

		public Criteria andCreatTimeNotEqualTo(Date value) {
			addCriterion("creat_time <>", value, "creatTime");
			return (Criteria) this;
		}

		public Criteria andCreatTimeGreaterThan(Date value) {
			addCriterion("creat_time >", value, "creatTime");
			return (Criteria) this;
		}

		public Criteria andCreatTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("creat_time >=", value, "creatTime");
			return (Criteria) this;
		}

		public Criteria andCreatTimeLessThan(Date value) {
			addCriterion("creat_time <", value, "creatTime");
			return (Criteria) this;
		}

		public Criteria andCreatTimeLessThanOrEqualTo(Date value) {
			addCriterion("creat_time <=", value, "creatTime");
			return (Criteria) this;
		}

		public Criteria andCreatTimeIn(List<Date> values) {
			addCriterion("creat_time in", values, "creatTime");
			return (Criteria) this;
		}

		public Criteria andCreatTimeNotIn(List<Date> values) {
			addCriterion("creat_time not in", values, "creatTime");
			return (Criteria) this;
		}

		public Criteria andCreatTimeBetween(Date value1, Date value2) {
			addCriterion("creat_time between", value1, value2, "creatTime");
			return (Criteria) this;
		}

		public Criteria andCreatTimeNotBetween(Date value1, Date value2) {
			addCriterion("creat_time not between", value1, value2, "creatTime");
			return (Criteria) this;
		}

		public Criteria andRmTypeIsNull() {
			addCriterion("rm_type is null");
			return (Criteria) this;
		}

		public Criteria andRmTypeIsNotNull() {
			addCriterion("rm_type is not null");
			return (Criteria) this;
		}

		public Criteria andRmTypeEqualTo(Integer value) {
			addCriterion("rm_type =", value, "rmType");
			return (Criteria) this;
		}

		public Criteria andRmTypeNotEqualTo(Integer value) {
			addCriterion("rm_type <>", value, "rmType");
			return (Criteria) this;
		}

		public Criteria andRmTypeGreaterThan(Integer value) {
			addCriterion("rm_type >", value, "rmType");
			return (Criteria) this;
		}

		public Criteria andRmTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("rm_type >=", value, "rmType");
			return (Criteria) this;
		}

		public Criteria andRmTypeLessThan(Integer value) {
			addCriterion("rm_type <", value, "rmType");
			return (Criteria) this;
		}

		public Criteria andRmTypeLessThanOrEqualTo(Integer value) {
			addCriterion("rm_type <=", value, "rmType");
			return (Criteria) this;
		}

		public Criteria andRmTypeIn(List<Integer> values) {
			addCriterion("rm_type in", values, "rmType");
			return (Criteria) this;
		}

		public Criteria andRmTypeNotIn(List<Integer> values) {
			addCriterion("rm_type not in", values, "rmType");
			return (Criteria) this;
		}

		public Criteria andRmTypeBetween(Integer value1, Integer value2) {
			addCriterion("rm_type between", value1, value2, "rmType");
			return (Criteria) this;
		}

		public Criteria andRmTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("rm_type not between", value1, value2, "rmType");
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