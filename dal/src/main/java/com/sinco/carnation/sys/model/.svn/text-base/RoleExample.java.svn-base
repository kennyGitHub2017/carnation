package com.sinco.carnation.sys.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoleExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public RoleExample() {
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

		public Criteria andDisplayIsNull() {
			addCriterion("display is null");
			return (Criteria) this;
		}

		public Criteria andDisplayIsNotNull() {
			addCriterion("display is not null");
			return (Criteria) this;
		}

		public Criteria andDisplayEqualTo(Boolean value) {
			addCriterion("display =", value, "display");
			return (Criteria) this;
		}

		public Criteria andDisplayNotEqualTo(Boolean value) {
			addCriterion("display <>", value, "display");
			return (Criteria) this;
		}

		public Criteria andDisplayGreaterThan(Boolean value) {
			addCriterion("display >", value, "display");
			return (Criteria) this;
		}

		public Criteria andDisplayGreaterThanOrEqualTo(Boolean value) {
			addCriterion("display >=", value, "display");
			return (Criteria) this;
		}

		public Criteria andDisplayLessThan(Boolean value) {
			addCriterion("display <", value, "display");
			return (Criteria) this;
		}

		public Criteria andDisplayLessThanOrEqualTo(Boolean value) {
			addCriterion("display <=", value, "display");
			return (Criteria) this;
		}

		public Criteria andDisplayIn(List<Boolean> values) {
			addCriterion("display in", values, "display");
			return (Criteria) this;
		}

		public Criteria andDisplayNotIn(List<Boolean> values) {
			addCriterion("display not in", values, "display");
			return (Criteria) this;
		}

		public Criteria andDisplayBetween(Boolean value1, Boolean value2) {
			addCriterion("display between", value1, value2, "display");
			return (Criteria) this;
		}

		public Criteria andDisplayNotBetween(Boolean value1, Boolean value2) {
			addCriterion("display not between", value1, value2, "display");
			return (Criteria) this;
		}

		public Criteria andInfoIsNull() {
			addCriterion("info is null");
			return (Criteria) this;
		}

		public Criteria andInfoIsNotNull() {
			addCriterion("info is not null");
			return (Criteria) this;
		}

		public Criteria andInfoEqualTo(String value) {
			addCriterion("info =", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoNotEqualTo(String value) {
			addCriterion("info <>", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoGreaterThan(String value) {
			addCriterion("info >", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoGreaterThanOrEqualTo(String value) {
			addCriterion("info >=", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoLessThan(String value) {
			addCriterion("info <", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoLessThanOrEqualTo(String value) {
			addCriterion("info <=", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoLike(String value) {
			addCriterion("info like", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoNotLike(String value) {
			addCriterion("info not like", value, "info");
			return (Criteria) this;
		}

		public Criteria andInfoIn(List<String> values) {
			addCriterion("info in", values, "info");
			return (Criteria) this;
		}

		public Criteria andInfoNotIn(List<String> values) {
			addCriterion("info not in", values, "info");
			return (Criteria) this;
		}

		public Criteria andInfoBetween(String value1, String value2) {
			addCriterion("info between", value1, value2, "info");
			return (Criteria) this;
		}

		public Criteria andInfoNotBetween(String value1, String value2) {
			addCriterion("info not between", value1, value2, "info");
			return (Criteria) this;
		}

		public Criteria andRoleCodeIsNull() {
			addCriterion("role_code is null");
			return (Criteria) this;
		}

		public Criteria andRoleCodeIsNotNull() {
			addCriterion("role_code is not null");
			return (Criteria) this;
		}

		public Criteria andRoleCodeEqualTo(String value) {
			addCriterion("role_code =", value, "roleCode");
			return (Criteria) this;
		}

		public Criteria andRoleCodeNotEqualTo(String value) {
			addCriterion("role_code <>", value, "roleCode");
			return (Criteria) this;
		}

		public Criteria andRoleCodeGreaterThan(String value) {
			addCriterion("role_code >", value, "roleCode");
			return (Criteria) this;
		}

		public Criteria andRoleCodeGreaterThanOrEqualTo(String value) {
			addCriterion("role_code >=", value, "roleCode");
			return (Criteria) this;
		}

		public Criteria andRoleCodeLessThan(String value) {
			addCriterion("role_code <", value, "roleCode");
			return (Criteria) this;
		}

		public Criteria andRoleCodeLessThanOrEqualTo(String value) {
			addCriterion("role_code <=", value, "roleCode");
			return (Criteria) this;
		}

		public Criteria andRoleCodeLike(String value) {
			addCriterion("role_code like", value, "roleCode");
			return (Criteria) this;
		}

		public Criteria andRoleCodeNotLike(String value) {
			addCriterion("role_code not like", value, "roleCode");
			return (Criteria) this;
		}

		public Criteria andRoleCodeIn(List<String> values) {
			addCriterion("role_code in", values, "roleCode");
			return (Criteria) this;
		}

		public Criteria andRoleCodeNotIn(List<String> values) {
			addCriterion("role_code not in", values, "roleCode");
			return (Criteria) this;
		}

		public Criteria andRoleCodeBetween(String value1, String value2) {
			addCriterion("role_code between", value1, value2, "roleCode");
			return (Criteria) this;
		}

		public Criteria andRoleCodeNotBetween(String value1, String value2) {
			addCriterion("role_code not between", value1, value2, "roleCode");
			return (Criteria) this;
		}

		public Criteria andRoleNameIsNull() {
			addCriterion("role_name is null");
			return (Criteria) this;
		}

		public Criteria andRoleNameIsNotNull() {
			addCriterion("role_name is not null");
			return (Criteria) this;
		}

		public Criteria andRoleNameEqualTo(String value) {
			addCriterion("role_name =", value, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameNotEqualTo(String value) {
			addCriterion("role_name <>", value, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameGreaterThan(String value) {
			addCriterion("role_name >", value, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameGreaterThanOrEqualTo(String value) {
			addCriterion("role_name >=", value, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameLessThan(String value) {
			addCriterion("role_name <", value, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameLessThanOrEqualTo(String value) {
			addCriterion("role_name <=", value, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameLike(String value) {
			addCriterion("role_name like", value, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameNotLike(String value) {
			addCriterion("role_name not like", value, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameIn(List<String> values) {
			addCriterion("role_name in", values, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameNotIn(List<String> values) {
			addCriterion("role_name not in", values, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameBetween(String value1, String value2) {
			addCriterion("role_name between", value1, value2, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameNotBetween(String value1, String value2) {
			addCriterion("role_name not between", value1, value2, "roleName");
			return (Criteria) this;
		}

		public Criteria andSequenceIsNull() {
			addCriterion("sequence is null");
			return (Criteria) this;
		}

		public Criteria andSequenceIsNotNull() {
			addCriterion("sequence is not null");
			return (Criteria) this;
		}

		public Criteria andSequenceEqualTo(Integer value) {
			addCriterion("sequence =", value, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceNotEqualTo(Integer value) {
			addCriterion("sequence <>", value, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceGreaterThan(Integer value) {
			addCriterion("sequence >", value, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceGreaterThanOrEqualTo(Integer value) {
			addCriterion("sequence >=", value, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceLessThan(Integer value) {
			addCriterion("sequence <", value, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceLessThanOrEqualTo(Integer value) {
			addCriterion("sequence <=", value, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceIn(List<Integer> values) {
			addCriterion("sequence in", values, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceNotIn(List<Integer> values) {
			addCriterion("sequence not in", values, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceBetween(Integer value1, Integer value2) {
			addCriterion("sequence between", value1, value2, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceNotBetween(Integer value1, Integer value2) {
			addCriterion("sequence not between", value1, value2, "sequence");
			return (Criteria) this;
		}

		public Criteria andTypeIsNull() {
			addCriterion("type is null");
			return (Criteria) this;
		}

		public Criteria andTypeIsNotNull() {
			addCriterion("type is not null");
			return (Criteria) this;
		}

		public Criteria andTypeEqualTo(String value) {
			addCriterion("type =", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotEqualTo(String value) {
			addCriterion("type <>", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThan(String value) {
			addCriterion("type >", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThanOrEqualTo(String value) {
			addCriterion("type >=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThan(String value) {
			addCriterion("type <", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThanOrEqualTo(String value) {
			addCriterion("type <=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLike(String value) {
			addCriterion("type like", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotLike(String value) {
			addCriterion("type not like", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeIn(List<String> values) {
			addCriterion("type in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotIn(List<String> values) {
			addCriterion("type not in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeBetween(String value1, String value2) {
			addCriterion("type between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotBetween(String value1, String value2) {
			addCriterion("type not between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andRgIdIsNull() {
			addCriterion("rg_id is null");
			return (Criteria) this;
		}

		public Criteria andRgIdIsNotNull() {
			addCriterion("rg_id is not null");
			return (Criteria) this;
		}

		public Criteria andRgIdEqualTo(Long value) {
			addCriterion("rg_id =", value, "rgId");
			return (Criteria) this;
		}

		public Criteria andRgIdNotEqualTo(Long value) {
			addCriterion("rg_id <>", value, "rgId");
			return (Criteria) this;
		}

		public Criteria andRgIdGreaterThan(Long value) {
			addCriterion("rg_id >", value, "rgId");
			return (Criteria) this;
		}

		public Criteria andRgIdGreaterThanOrEqualTo(Long value) {
			addCriterion("rg_id >=", value, "rgId");
			return (Criteria) this;
		}

		public Criteria andRgIdLessThan(Long value) {
			addCriterion("rg_id <", value, "rgId");
			return (Criteria) this;
		}

		public Criteria andRgIdLessThanOrEqualTo(Long value) {
			addCriterion("rg_id <=", value, "rgId");
			return (Criteria) this;
		}

		public Criteria andRgIdIn(List<Long> values) {
			addCriterion("rg_id in", values, "rgId");
			return (Criteria) this;
		}

		public Criteria andRgIdNotIn(List<Long> values) {
			addCriterion("rg_id not in", values, "rgId");
			return (Criteria) this;
		}

		public Criteria andRgIdBetween(Long value1, Long value2) {
			addCriterion("rg_id between", value1, value2, "rgId");
			return (Criteria) this;
		}

		public Criteria andRgIdNotBetween(Long value1, Long value2) {
			addCriterion("rg_id not between", value1, value2, "rgId");
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