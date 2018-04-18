package com.sinco.carnation.sns.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CheckResultItemExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public CheckResultItemExample() {
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

		public Criteria andItemNameIsNull() {
			addCriterion("item_name is null");
			return (Criteria) this;
		}

		public Criteria andItemNameIsNotNull() {
			addCriterion("item_name is not null");
			return (Criteria) this;
		}

		public Criteria andItemNameEqualTo(String value) {
			addCriterion("item_name =", value, "itemName");
			return (Criteria) this;
		}

		public Criteria andItemNameNotEqualTo(String value) {
			addCriterion("item_name <>", value, "itemName");
			return (Criteria) this;
		}

		public Criteria andItemNameGreaterThan(String value) {
			addCriterion("item_name >", value, "itemName");
			return (Criteria) this;
		}

		public Criteria andItemNameGreaterThanOrEqualTo(String value) {
			addCriterion("item_name >=", value, "itemName");
			return (Criteria) this;
		}

		public Criteria andItemNameLessThan(String value) {
			addCriterion("item_name <", value, "itemName");
			return (Criteria) this;
		}

		public Criteria andItemNameLessThanOrEqualTo(String value) {
			addCriterion("item_name <=", value, "itemName");
			return (Criteria) this;
		}

		public Criteria andItemNameLike(String value) {
			addCriterion("item_name like", value, "itemName");
			return (Criteria) this;
		}

		public Criteria andItemNameNotLike(String value) {
			addCriterion("item_name not like", value, "itemName");
			return (Criteria) this;
		}

		public Criteria andItemNameIn(List<String> values) {
			addCriterion("item_name in", values, "itemName");
			return (Criteria) this;
		}

		public Criteria andItemNameNotIn(List<String> values) {
			addCriterion("item_name not in", values, "itemName");
			return (Criteria) this;
		}

		public Criteria andItemNameBetween(String value1, String value2) {
			addCriterion("item_name between", value1, value2, "itemName");
			return (Criteria) this;
		}

		public Criteria andItemNameNotBetween(String value1, String value2) {
			addCriterion("item_name not between", value1, value2, "itemName");
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
			addCriterionForJDBCDate("create_time =", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("create_time <>", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThan(Date value) {
			addCriterionForJDBCDate("create_time >", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("create_time >=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThan(Date value) {
			addCriterionForJDBCDate("create_time <", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("create_time <=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIn(List<Date> values) {
			addCriterionForJDBCDate("create_time in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("create_time not in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("create_time between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("create_time not between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andGroupIdIsNull() {
			addCriterion("group_id is null");
			return (Criteria) this;
		}

		public Criteria andGroupIdIsNotNull() {
			addCriterion("group_id is not null");
			return (Criteria) this;
		}

		public Criteria andGroupIdEqualTo(Long value) {
			addCriterion("group_id =", value, "groupId");
			return (Criteria) this;
		}

		public Criteria andGroupIdNotEqualTo(Long value) {
			addCriterion("group_id <>", value, "groupId");
			return (Criteria) this;
		}

		public Criteria andGroupIdGreaterThan(Long value) {
			addCriterion("group_id >", value, "groupId");
			return (Criteria) this;
		}

		public Criteria andGroupIdGreaterThanOrEqualTo(Long value) {
			addCriterion("group_id >=", value, "groupId");
			return (Criteria) this;
		}

		public Criteria andGroupIdLessThan(Long value) {
			addCriterion("group_id <", value, "groupId");
			return (Criteria) this;
		}

		public Criteria andGroupIdLessThanOrEqualTo(Long value) {
			addCriterion("group_id <=", value, "groupId");
			return (Criteria) this;
		}

		public Criteria andGroupIdIn(List<Long> values) {
			addCriterion("group_id in", values, "groupId");
			return (Criteria) this;
		}

		public Criteria andGroupIdNotIn(List<Long> values) {
			addCriterion("group_id not in", values, "groupId");
			return (Criteria) this;
		}

		public Criteria andGroupIdBetween(Long value1, Long value2) {
			addCriterion("group_id between", value1, value2, "groupId");
			return (Criteria) this;
		}

		public Criteria andGroupIdNotBetween(Long value1, Long value2) {
			addCriterion("group_id not between", value1, value2, "groupId");
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

		public Criteria andUsingIsNull() {
			addCriterion("using is null");
			return (Criteria) this;
		}

		public Criteria andUsingIsNotNull() {
			addCriterion("using is not null");
			return (Criteria) this;
		}

		public Criteria andUsingEqualTo(Integer value) {
			addCriterion("using =", value, "using");
			return (Criteria) this;
		}

		public Criteria andUsingNotEqualTo(Integer value) {
			addCriterion("using <>", value, "using");
			return (Criteria) this;
		}

		public Criteria andUsingGreaterThan(Integer value) {
			addCriterion("using >", value, "using");
			return (Criteria) this;
		}

		public Criteria andUsingGreaterThanOrEqualTo(Integer value) {
			addCriterion("using >=", value, "using");
			return (Criteria) this;
		}

		public Criteria andUsingLessThan(Integer value) {
			addCriterion("using <", value, "using");
			return (Criteria) this;
		}

		public Criteria andUsingLessThanOrEqualTo(Integer value) {
			addCriterion("using <=", value, "using");
			return (Criteria) this;
		}

		public Criteria andUsingIn(List<Integer> values) {
			addCriterion("using in", values, "using");
			return (Criteria) this;
		}

		public Criteria andUsingNotIn(List<Integer> values) {
			addCriterion("using not in", values, "using");
			return (Criteria) this;
		}

		public Criteria andUsingBetween(Integer value1, Integer value2) {
			addCriterion("using between", value1, value2, "using");
			return (Criteria) this;
		}

		public Criteria andUsingNotBetween(Integer value1, Integer value2) {
			addCriterion("using not between", value1, value2, "using");
			return (Criteria) this;
		}

		public Criteria andSeqencIsNull() {
			addCriterion("seqenc is null");
			return (Criteria) this;
		}

		public Criteria andSeqencIsNotNull() {
			addCriterion("seqenc is not null");
			return (Criteria) this;
		}

		public Criteria andSeqencEqualTo(Integer value) {
			addCriterion("seqenc =", value, "seqenc");
			return (Criteria) this;
		}

		public Criteria andSeqencNotEqualTo(Integer value) {
			addCriterion("seqenc <>", value, "seqenc");
			return (Criteria) this;
		}

		public Criteria andSeqencGreaterThan(Integer value) {
			addCriterion("seqenc >", value, "seqenc");
			return (Criteria) this;
		}

		public Criteria andSeqencGreaterThanOrEqualTo(Integer value) {
			addCriterion("seqenc >=", value, "seqenc");
			return (Criteria) this;
		}

		public Criteria andSeqencLessThan(Integer value) {
			addCriterion("seqenc <", value, "seqenc");
			return (Criteria) this;
		}

		public Criteria andSeqencLessThanOrEqualTo(Integer value) {
			addCriterion("seqenc <=", value, "seqenc");
			return (Criteria) this;
		}

		public Criteria andSeqencIn(List<Integer> values) {
			addCriterion("seqenc in", values, "seqenc");
			return (Criteria) this;
		}

		public Criteria andSeqencNotIn(List<Integer> values) {
			addCriterion("seqenc not in", values, "seqenc");
			return (Criteria) this;
		}

		public Criteria andSeqencBetween(Integer value1, Integer value2) {
			addCriterion("seqenc between", value1, value2, "seqenc");
			return (Criteria) this;
		}

		public Criteria andSeqencNotBetween(Integer value1, Integer value2) {
			addCriterion("seqenc not between", value1, value2, "seqenc");
			return (Criteria) this;
		}

		public Criteria andMinValueIsNull() {
			addCriterion("min_value is null");
			return (Criteria) this;
		}

		public Criteria andMinValueIsNotNull() {
			addCriterion("min_value is not null");
			return (Criteria) this;
		}

		public Criteria andMinValueEqualTo(String value) {
			addCriterion("min_value =", value, "minValue");
			return (Criteria) this;
		}

		public Criteria andMinValueNotEqualTo(String value) {
			addCriterion("min_value <>", value, "minValue");
			return (Criteria) this;
		}

		public Criteria andMinValueGreaterThan(String value) {
			addCriterion("min_value >", value, "minValue");
			return (Criteria) this;
		}

		public Criteria andMinValueGreaterThanOrEqualTo(String value) {
			addCriterion("min_value >=", value, "minValue");
			return (Criteria) this;
		}

		public Criteria andMinValueLessThan(String value) {
			addCriterion("min_value <", value, "minValue");
			return (Criteria) this;
		}

		public Criteria andMinValueLessThanOrEqualTo(String value) {
			addCriterion("min_value <=", value, "minValue");
			return (Criteria) this;
		}

		public Criteria andMinValueLike(String value) {
			addCriterion("min_value like", value, "minValue");
			return (Criteria) this;
		}

		public Criteria andMinValueNotLike(String value) {
			addCriterion("min_value not like", value, "minValue");
			return (Criteria) this;
		}

		public Criteria andMinValueIn(List<String> values) {
			addCriterion("min_value in", values, "minValue");
			return (Criteria) this;
		}

		public Criteria andMinValueNotIn(List<String> values) {
			addCriterion("min_value not in", values, "minValue");
			return (Criteria) this;
		}

		public Criteria andMinValueBetween(String value1, String value2) {
			addCriterion("min_value between", value1, value2, "minValue");
			return (Criteria) this;
		}

		public Criteria andMinValueNotBetween(String value1, String value2) {
			addCriterion("min_value not between", value1, value2, "minValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueIsNull() {
			addCriterion("max_value is null");
			return (Criteria) this;
		}

		public Criteria andMaxValueIsNotNull() {
			addCriterion("max_value is not null");
			return (Criteria) this;
		}

		public Criteria andMaxValueEqualTo(String value) {
			addCriterion("max_value =", value, "maxValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueNotEqualTo(String value) {
			addCriterion("max_value <>", value, "maxValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueGreaterThan(String value) {
			addCriterion("max_value >", value, "maxValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueGreaterThanOrEqualTo(String value) {
			addCriterion("max_value >=", value, "maxValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueLessThan(String value) {
			addCriterion("max_value <", value, "maxValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueLessThanOrEqualTo(String value) {
			addCriterion("max_value <=", value, "maxValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueLike(String value) {
			addCriterion("max_value like", value, "maxValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueNotLike(String value) {
			addCriterion("max_value not like", value, "maxValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueIn(List<String> values) {
			addCriterion("max_value in", values, "maxValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueNotIn(List<String> values) {
			addCriterion("max_value not in", values, "maxValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueBetween(String value1, String value2) {
			addCriterion("max_value between", value1, value2, "maxValue");
			return (Criteria) this;
		}

		public Criteria andMaxValueNotBetween(String value1, String value2) {
			addCriterion("max_value not between", value1, value2, "maxValue");
			return (Criteria) this;
		}

		public Criteria andUnitIsNull() {
			addCriterion("unit is null");
			return (Criteria) this;
		}

		public Criteria andUnitIsNotNull() {
			addCriterion("unit is not null");
			return (Criteria) this;
		}

		public Criteria andUnitEqualTo(String value) {
			addCriterion("unit =", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitNotEqualTo(String value) {
			addCriterion("unit <>", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitGreaterThan(String value) {
			addCriterion("unit >", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitGreaterThanOrEqualTo(String value) {
			addCriterion("unit >=", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitLessThan(String value) {
			addCriterion("unit <", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitLessThanOrEqualTo(String value) {
			addCriterion("unit <=", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitLike(String value) {
			addCriterion("unit like", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitNotLike(String value) {
			addCriterion("unit not like", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitIn(List<String> values) {
			addCriterion("unit in", values, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitNotIn(List<String> values) {
			addCriterion("unit not in", values, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitBetween(String value1, String value2) {
			addCriterion("unit between", value1, value2, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitNotBetween(String value1, String value2) {
			addCriterion("unit not between", value1, value2, "unit");
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