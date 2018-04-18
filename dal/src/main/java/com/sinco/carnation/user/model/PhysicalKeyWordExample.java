package com.sinco.carnation.user.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhysicalKeyWordExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public PhysicalKeyWordExample() {
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

		public Criteria andNameIsNull() {
			addCriterion("name is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("name is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("name =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("name <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("name >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("name >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("name <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("name <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("name like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("name not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("name in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("name not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("name between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("name not between", value1, value2, "name");
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

		public Criteria andTypeEqualTo(Integer value) {
			addCriterion("type =", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotEqualTo(Integer value) {
			addCriterion("type <>", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThan(Integer value) {
			addCriterion("type >", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("type >=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThan(Integer value) {
			addCriterion("type <", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThanOrEqualTo(Integer value) {
			addCriterion("type <=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeIn(List<Integer> values) {
			addCriterion("type in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotIn(List<Integer> values) {
			addCriterion("type not in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeBetween(Integer value1, Integer value2) {
			addCriterion("type between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("type not between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andIsTopIsNull() {
			addCriterion("is_top is null");
			return (Criteria) this;
		}

		public Criteria andIsTopIsNotNull() {
			addCriterion("is_top is not null");
			return (Criteria) this;
		}

		public Criteria andIsTopEqualTo(Integer value) {
			addCriterion("is_top =", value, "isTop");
			return (Criteria) this;
		}

		public Criteria andIsTopNotEqualTo(Integer value) {
			addCriterion("is_top <>", value, "isTop");
			return (Criteria) this;
		}

		public Criteria andIsTopGreaterThan(Integer value) {
			addCriterion("is_top >", value, "isTop");
			return (Criteria) this;
		}

		public Criteria andIsTopGreaterThanOrEqualTo(Integer value) {
			addCriterion("is_top >=", value, "isTop");
			return (Criteria) this;
		}

		public Criteria andIsTopLessThan(Integer value) {
			addCriterion("is_top <", value, "isTop");
			return (Criteria) this;
		}

		public Criteria andIsTopLessThanOrEqualTo(Integer value) {
			addCriterion("is_top <=", value, "isTop");
			return (Criteria) this;
		}

		public Criteria andIsTopIn(List<Integer> values) {
			addCriterion("is_top in", values, "isTop");
			return (Criteria) this;
		}

		public Criteria andIsTopNotIn(List<Integer> values) {
			addCriterion("is_top not in", values, "isTop");
			return (Criteria) this;
		}

		public Criteria andIsTopBetween(Integer value1, Integer value2) {
			addCriterion("is_top between", value1, value2, "isTop");
			return (Criteria) this;
		}

		public Criteria andIsTopNotBetween(Integer value1, Integer value2) {
			addCriterion("is_top not between", value1, value2, "isTop");
			return (Criteria) this;
		}

		public Criteria andIsSystemIsNull() {
			addCriterion("is_system is null");
			return (Criteria) this;
		}

		public Criteria andIsSystemIsNotNull() {
			addCriterion("is_system is not null");
			return (Criteria) this;
		}

		public Criteria andIsSystemEqualTo(Integer value) {
			addCriterion("is_system =", value, "isSystem");
			return (Criteria) this;
		}

		public Criteria andIsSystemNotEqualTo(Integer value) {
			addCriterion("is_system <>", value, "isSystem");
			return (Criteria) this;
		}

		public Criteria andIsSystemGreaterThan(Integer value) {
			addCriterion("is_system >", value, "isSystem");
			return (Criteria) this;
		}

		public Criteria andIsSystemGreaterThanOrEqualTo(Integer value) {
			addCriterion("is_system >=", value, "isSystem");
			return (Criteria) this;
		}

		public Criteria andIsSystemLessThan(Integer value) {
			addCriterion("is_system <", value, "isSystem");
			return (Criteria) this;
		}

		public Criteria andIsSystemLessThanOrEqualTo(Integer value) {
			addCriterion("is_system <=", value, "isSystem");
			return (Criteria) this;
		}

		public Criteria andIsSystemIn(List<Integer> values) {
			addCriterion("is_system in", values, "isSystem");
			return (Criteria) this;
		}

		public Criteria andIsSystemNotIn(List<Integer> values) {
			addCriterion("is_system not in", values, "isSystem");
			return (Criteria) this;
		}

		public Criteria andIsSystemBetween(Integer value1, Integer value2) {
			addCriterion("is_system between", value1, value2, "isSystem");
			return (Criteria) this;
		}

		public Criteria andIsSystemNotBetween(Integer value1, Integer value2) {
			addCriterion("is_system not between", value1, value2, "isSystem");
			return (Criteria) this;
		}

		public Criteria andIsEnabledIsNull() {
			addCriterion("is_enabled is null");
			return (Criteria) this;
		}

		public Criteria andIsEnabledIsNotNull() {
			addCriterion("is_enabled is not null");
			return (Criteria) this;
		}

		public Criteria andIsEnabledEqualTo(Integer value) {
			addCriterion("is_enabled =", value, "isEnabled");
			return (Criteria) this;
		}

		public Criteria andIsEnabledNotEqualTo(Integer value) {
			addCriterion("is_enabled <>", value, "isEnabled");
			return (Criteria) this;
		}

		public Criteria andIsEnabledGreaterThan(Integer value) {
			addCriterion("is_enabled >", value, "isEnabled");
			return (Criteria) this;
		}

		public Criteria andIsEnabledGreaterThanOrEqualTo(Integer value) {
			addCriterion("is_enabled >=", value, "isEnabled");
			return (Criteria) this;
		}

		public Criteria andIsEnabledLessThan(Integer value) {
			addCriterion("is_enabled <", value, "isEnabled");
			return (Criteria) this;
		}

		public Criteria andIsEnabledLessThanOrEqualTo(Integer value) {
			addCriterion("is_enabled <=", value, "isEnabled");
			return (Criteria) this;
		}

		public Criteria andIsEnabledIn(List<Integer> values) {
			addCriterion("is_enabled in", values, "isEnabled");
			return (Criteria) this;
		}

		public Criteria andIsEnabledNotIn(List<Integer> values) {
			addCriterion("is_enabled not in", values, "isEnabled");
			return (Criteria) this;
		}

		public Criteria andIsEnabledBetween(Integer value1, Integer value2) {
			addCriterion("is_enabled between", value1, value2, "isEnabled");
			return (Criteria) this;
		}

		public Criteria andIsEnabledNotBetween(Integer value1, Integer value2) {
			addCriterion("is_enabled not between", value1, value2, "isEnabled");
			return (Criteria) this;
		}

		public Criteria andPriorityIsNull() {
			addCriterion("priority is null");
			return (Criteria) this;
		}

		public Criteria andPriorityIsNotNull() {
			addCriterion("priority is not null");
			return (Criteria) this;
		}

		public Criteria andPriorityEqualTo(Integer value) {
			addCriterion("priority =", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityNotEqualTo(Integer value) {
			addCriterion("priority <>", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityGreaterThan(Integer value) {
			addCriterion("priority >", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityGreaterThanOrEqualTo(Integer value) {
			addCriterion("priority >=", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityLessThan(Integer value) {
			addCriterion("priority <", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityLessThanOrEqualTo(Integer value) {
			addCriterion("priority <=", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityIn(List<Integer> values) {
			addCriterion("priority in", values, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityNotIn(List<Integer> values) {
			addCriterion("priority not in", values, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityBetween(Integer value1, Integer value2) {
			addCriterion("priority between", value1, value2, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityNotBetween(Integer value1, Integer value2) {
			addCriterion("priority not between", value1, value2, "priority");
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

		public Criteria andDeleteStatusEqualTo(Byte value) {
			addCriterion("delete_status =", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotEqualTo(Byte value) {
			addCriterion("delete_status <>", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThan(Byte value) {
			addCriterion("delete_status >", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("delete_status >=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThan(Byte value) {
			addCriterion("delete_status <", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThanOrEqualTo(Byte value) {
			addCriterion("delete_status <=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusIn(List<Byte> values) {
			addCriterion("delete_status in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotIn(List<Byte> values) {
			addCriterion("delete_status not in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusBetween(Byte value1, Byte value2) {
			addCriterion("delete_status between", value1, value2, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("delete_status not between", value1, value2, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andCreateByIsNull() {
			addCriterion("create_by is null");
			return (Criteria) this;
		}

		public Criteria andCreateByIsNotNull() {
			addCriterion("create_by is not null");
			return (Criteria) this;
		}

		public Criteria andCreateByEqualTo(Long value) {
			addCriterion("create_by =", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByNotEqualTo(Long value) {
			addCriterion("create_by <>", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByGreaterThan(Long value) {
			addCriterion("create_by >", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByGreaterThanOrEqualTo(Long value) {
			addCriterion("create_by >=", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByLessThan(Long value) {
			addCriterion("create_by <", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByLessThanOrEqualTo(Long value) {
			addCriterion("create_by <=", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByIn(List<Long> values) {
			addCriterion("create_by in", values, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByNotIn(List<Long> values) {
			addCriterion("create_by not in", values, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByBetween(Long value1, Long value2) {
			addCriterion("create_by between", value1, value2, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByNotBetween(Long value1, Long value2) {
			addCriterion("create_by not between", value1, value2, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNull() {
			addCriterion("create_time is null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNotNull() {
			addCriterion("create_time is not null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeEqualTo(Date value) {
			addCriterion("create_time =", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotEqualTo(Date value) {
			addCriterion("create_time <>", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThan(Date value) {
			addCriterion("create_time >", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("create_time >=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThan(Date value) {
			addCriterion("create_time <", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
			addCriterion("create_time <=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIn(List<Date> values) {
			addCriterion("create_time in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotIn(List<Date> values) {
			addCriterion("create_time not in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeBetween(Date value1, Date value2) {
			addCriterion("create_time between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
			addCriterion("create_time not between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andModifyByIsNull() {
			addCriterion("modify_by is null");
			return (Criteria) this;
		}

		public Criteria andModifyByIsNotNull() {
			addCriterion("modify_by is not null");
			return (Criteria) this;
		}

		public Criteria andModifyByEqualTo(Long value) {
			addCriterion("modify_by =", value, "modifyBy");
			return (Criteria) this;
		}

		public Criteria andModifyByNotEqualTo(Long value) {
			addCriterion("modify_by <>", value, "modifyBy");
			return (Criteria) this;
		}

		public Criteria andModifyByGreaterThan(Long value) {
			addCriterion("modify_by >", value, "modifyBy");
			return (Criteria) this;
		}

		public Criteria andModifyByGreaterThanOrEqualTo(Long value) {
			addCriterion("modify_by >=", value, "modifyBy");
			return (Criteria) this;
		}

		public Criteria andModifyByLessThan(Long value) {
			addCriterion("modify_by <", value, "modifyBy");
			return (Criteria) this;
		}

		public Criteria andModifyByLessThanOrEqualTo(Long value) {
			addCriterion("modify_by <=", value, "modifyBy");
			return (Criteria) this;
		}

		public Criteria andModifyByIn(List<Long> values) {
			addCriterion("modify_by in", values, "modifyBy");
			return (Criteria) this;
		}

		public Criteria andModifyByNotIn(List<Long> values) {
			addCriterion("modify_by not in", values, "modifyBy");
			return (Criteria) this;
		}

		public Criteria andModifyByBetween(Long value1, Long value2) {
			addCriterion("modify_by between", value1, value2, "modifyBy");
			return (Criteria) this;
		}

		public Criteria andModifyByNotBetween(Long value1, Long value2) {
			addCriterion("modify_by not between", value1, value2, "modifyBy");
			return (Criteria) this;
		}

		public Criteria andModifyTimeIsNull() {
			addCriterion("modify_time is null");
			return (Criteria) this;
		}

		public Criteria andModifyTimeIsNotNull() {
			addCriterion("modify_time is not null");
			return (Criteria) this;
		}

		public Criteria andModifyTimeEqualTo(Date value) {
			addCriterion("modify_time =", value, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeNotEqualTo(Date value) {
			addCriterion("modify_time <>", value, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeGreaterThan(Date value) {
			addCriterion("modify_time >", value, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("modify_time >=", value, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeLessThan(Date value) {
			addCriterion("modify_time <", value, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
			addCriterion("modify_time <=", value, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeIn(List<Date> values) {
			addCriterion("modify_time in", values, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeNotIn(List<Date> values) {
			addCriterion("modify_time not in", values, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeBetween(Date value1, Date value2) {
			addCriterion("modify_time between", value1, value2, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
			addCriterion("modify_time not between", value1, value2, "modifyTime");
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