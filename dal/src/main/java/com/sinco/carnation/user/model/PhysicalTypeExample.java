package com.sinco.carnation.user.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhysicalTypeExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public PhysicalTypeExample() {
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

		public Criteria andTypeNameIsNull() {
			addCriterion("type_name is null");
			return (Criteria) this;
		}

		public Criteria andTypeNameIsNotNull() {
			addCriterion("type_name is not null");
			return (Criteria) this;
		}

		public Criteria andTypeNameEqualTo(String value) {
			addCriterion("type_name =", value, "typeName");
			return (Criteria) this;
		}

		public Criteria andTypeNameNotEqualTo(String value) {
			addCriterion("type_name <>", value, "typeName");
			return (Criteria) this;
		}

		public Criteria andTypeNameGreaterThan(String value) {
			addCriterion("type_name >", value, "typeName");
			return (Criteria) this;
		}

		public Criteria andTypeNameGreaterThanOrEqualTo(String value) {
			addCriterion("type_name >=", value, "typeName");
			return (Criteria) this;
		}

		public Criteria andTypeNameLessThan(String value) {
			addCriterion("type_name <", value, "typeName");
			return (Criteria) this;
		}

		public Criteria andTypeNameLessThanOrEqualTo(String value) {
			addCriterion("type_name <=", value, "typeName");
			return (Criteria) this;
		}

		public Criteria andTypeNameLike(String value) {
			addCriterion("type_name like", value, "typeName");
			return (Criteria) this;
		}

		public Criteria andTypeNameNotLike(String value) {
			addCriterion("type_name not like", value, "typeName");
			return (Criteria) this;
		}

		public Criteria andTypeNameIn(List<String> values) {
			addCriterion("type_name in", values, "typeName");
			return (Criteria) this;
		}

		public Criteria andTypeNameNotIn(List<String> values) {
			addCriterion("type_name not in", values, "typeName");
			return (Criteria) this;
		}

		public Criteria andTypeNameBetween(String value1, String value2) {
			addCriterion("type_name between", value1, value2, "typeName");
			return (Criteria) this;
		}

		public Criteria andTypeNameNotBetween(String value1, String value2) {
			addCriterion("type_name not between", value1, value2, "typeName");
			return (Criteria) this;
		}

		public Criteria andTypeCompanyIsNull() {
			addCriterion("type_company is null");
			return (Criteria) this;
		}

		public Criteria andTypeCompanyIsNotNull() {
			addCriterion("type_company is not null");
			return (Criteria) this;
		}

		public Criteria andTypeCompanyEqualTo(String value) {
			addCriterion("type_company =", value, "typeCompany");
			return (Criteria) this;
		}

		public Criteria andTypeCompanyNotEqualTo(String value) {
			addCriterion("type_company <>", value, "typeCompany");
			return (Criteria) this;
		}

		public Criteria andTypeCompanyGreaterThan(String value) {
			addCriterion("type_company >", value, "typeCompany");
			return (Criteria) this;
		}

		public Criteria andTypeCompanyGreaterThanOrEqualTo(String value) {
			addCriterion("type_company >=", value, "typeCompany");
			return (Criteria) this;
		}

		public Criteria andTypeCompanyLessThan(String value) {
			addCriterion("type_company <", value, "typeCompany");
			return (Criteria) this;
		}

		public Criteria andTypeCompanyLessThanOrEqualTo(String value) {
			addCriterion("type_company <=", value, "typeCompany");
			return (Criteria) this;
		}

		public Criteria andTypeCompanyLike(String value) {
			addCriterion("type_company like", value, "typeCompany");
			return (Criteria) this;
		}

		public Criteria andTypeCompanyNotLike(String value) {
			addCriterion("type_company not like", value, "typeCompany");
			return (Criteria) this;
		}

		public Criteria andTypeCompanyIn(List<String> values) {
			addCriterion("type_company in", values, "typeCompany");
			return (Criteria) this;
		}

		public Criteria andTypeCompanyNotIn(List<String> values) {
			addCriterion("type_company not in", values, "typeCompany");
			return (Criteria) this;
		}

		public Criteria andTypeCompanyBetween(String value1, String value2) {
			addCriterion("type_company between", value1, value2, "typeCompany");
			return (Criteria) this;
		}

		public Criteria andTypeCompanyNotBetween(String value1, String value2) {
			addCriterion("type_company not between", value1, value2, "typeCompany");
			return (Criteria) this;
		}

		public Criteria andSortIndexIsNull() {
			addCriterion("sort_index is null");
			return (Criteria) this;
		}

		public Criteria andSortIndexIsNotNull() {
			addCriterion("sort_index is not null");
			return (Criteria) this;
		}

		public Criteria andSortIndexEqualTo(Integer value) {
			addCriterion("sort_index =", value, "sortIndex");
			return (Criteria) this;
		}

		public Criteria andSortIndexNotEqualTo(Integer value) {
			addCriterion("sort_index <>", value, "sortIndex");
			return (Criteria) this;
		}

		public Criteria andSortIndexGreaterThan(Integer value) {
			addCriterion("sort_index >", value, "sortIndex");
			return (Criteria) this;
		}

		public Criteria andSortIndexGreaterThanOrEqualTo(Integer value) {
			addCriterion("sort_index >=", value, "sortIndex");
			return (Criteria) this;
		}

		public Criteria andSortIndexLessThan(Integer value) {
			addCriterion("sort_index <", value, "sortIndex");
			return (Criteria) this;
		}

		public Criteria andSortIndexLessThanOrEqualTo(Integer value) {
			addCriterion("sort_index <=", value, "sortIndex");
			return (Criteria) this;
		}

		public Criteria andSortIndexIn(List<Integer> values) {
			addCriterion("sort_index in", values, "sortIndex");
			return (Criteria) this;
		}

		public Criteria andSortIndexNotIn(List<Integer> values) {
			addCriterion("sort_index not in", values, "sortIndex");
			return (Criteria) this;
		}

		public Criteria andSortIndexBetween(Integer value1, Integer value2) {
			addCriterion("sort_index between", value1, value2, "sortIndex");
			return (Criteria) this;
		}

		public Criteria andSortIndexNotBetween(Integer value1, Integer value2) {
			addCriterion("sort_index not between", value1, value2, "sortIndex");
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