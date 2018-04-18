package com.sinco.carnation.o2o.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GroupFloorExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public GroupFloorExample() {
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

		public Criteria andGoodsCountIsNull() {
			addCriterion("goods_count is null");
			return (Criteria) this;
		}

		public Criteria andGoodsCountIsNotNull() {
			addCriterion("goods_count is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsCountEqualTo(Integer value) {
			addCriterion("goods_count =", value, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGoodsCountNotEqualTo(Integer value) {
			addCriterion("goods_count <>", value, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGoodsCountGreaterThan(Integer value) {
			addCriterion("goods_count >", value, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGoodsCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("goods_count >=", value, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGoodsCountLessThan(Integer value) {
			addCriterion("goods_count <", value, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGoodsCountLessThanOrEqualTo(Integer value) {
			addCriterion("goods_count <=", value, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGoodsCountIn(List<Integer> values) {
			addCriterion("goods_count in", values, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGoodsCountNotIn(List<Integer> values) {
			addCriterion("goods_count not in", values, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGoodsCountBetween(Integer value1, Integer value2) {
			addCriterion("goods_count between", value1, value2, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGoodsCountNotBetween(Integer value1, Integer value2) {
			addCriterion("goods_count not between", value1, value2, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGfNameIsNull() {
			addCriterion("gf_name is null");
			return (Criteria) this;
		}

		public Criteria andGfNameIsNotNull() {
			addCriterion("gf_name is not null");
			return (Criteria) this;
		}

		public Criteria andGfNameEqualTo(String value) {
			addCriterion("gf_name =", value, "gfName");
			return (Criteria) this;
		}

		public Criteria andGfNameNotEqualTo(String value) {
			addCriterion("gf_name <>", value, "gfName");
			return (Criteria) this;
		}

		public Criteria andGfNameGreaterThan(String value) {
			addCriterion("gf_name >", value, "gfName");
			return (Criteria) this;
		}

		public Criteria andGfNameGreaterThanOrEqualTo(String value) {
			addCriterion("gf_name >=", value, "gfName");
			return (Criteria) this;
		}

		public Criteria andGfNameLessThan(String value) {
			addCriterion("gf_name <", value, "gfName");
			return (Criteria) this;
		}

		public Criteria andGfNameLessThanOrEqualTo(String value) {
			addCriterion("gf_name <=", value, "gfName");
			return (Criteria) this;
		}

		public Criteria andGfNameLike(String value) {
			addCriterion("gf_name like", value, "gfName");
			return (Criteria) this;
		}

		public Criteria andGfNameNotLike(String value) {
			addCriterion("gf_name not like", value, "gfName");
			return (Criteria) this;
		}

		public Criteria andGfNameIn(List<String> values) {
			addCriterion("gf_name in", values, "gfName");
			return (Criteria) this;
		}

		public Criteria andGfNameNotIn(List<String> values) {
			addCriterion("gf_name not in", values, "gfName");
			return (Criteria) this;
		}

		public Criteria andGfNameBetween(String value1, String value2) {
			addCriterion("gf_name between", value1, value2, "gfName");
			return (Criteria) this;
		}

		public Criteria andGfNameNotBetween(String value1, String value2) {
			addCriterion("gf_name not between", value1, value2, "gfName");
			return (Criteria) this;
		}

		public Criteria andGfSequenceIsNull() {
			addCriterion("gf_sequence is null");
			return (Criteria) this;
		}

		public Criteria andGfSequenceIsNotNull() {
			addCriterion("gf_sequence is not null");
			return (Criteria) this;
		}

		public Criteria andGfSequenceEqualTo(Integer value) {
			addCriterion("gf_sequence =", value, "gfSequence");
			return (Criteria) this;
		}

		public Criteria andGfSequenceNotEqualTo(Integer value) {
			addCriterion("gf_sequence <>", value, "gfSequence");
			return (Criteria) this;
		}

		public Criteria andGfSequenceGreaterThan(Integer value) {
			addCriterion("gf_sequence >", value, "gfSequence");
			return (Criteria) this;
		}

		public Criteria andGfSequenceGreaterThanOrEqualTo(Integer value) {
			addCriterion("gf_sequence >=", value, "gfSequence");
			return (Criteria) this;
		}

		public Criteria andGfSequenceLessThan(Integer value) {
			addCriterion("gf_sequence <", value, "gfSequence");
			return (Criteria) this;
		}

		public Criteria andGfSequenceLessThanOrEqualTo(Integer value) {
			addCriterion("gf_sequence <=", value, "gfSequence");
			return (Criteria) this;
		}

		public Criteria andGfSequenceIn(List<Integer> values) {
			addCriterion("gf_sequence in", values, "gfSequence");
			return (Criteria) this;
		}

		public Criteria andGfSequenceNotIn(List<Integer> values) {
			addCriterion("gf_sequence not in", values, "gfSequence");
			return (Criteria) this;
		}

		public Criteria andGfSequenceBetween(Integer value1, Integer value2) {
			addCriterion("gf_sequence between", value1, value2, "gfSequence");
			return (Criteria) this;
		}

		public Criteria andGfSequenceNotBetween(Integer value1, Integer value2) {
			addCriterion("gf_sequence not between", value1, value2, "gfSequence");
			return (Criteria) this;
		}

		public Criteria andIconPathIsNull() {
			addCriterion("icon_path is null");
			return (Criteria) this;
		}

		public Criteria andIconPathIsNotNull() {
			addCriterion("icon_path is not null");
			return (Criteria) this;
		}

		public Criteria andIconPathEqualTo(String value) {
			addCriterion("icon_path =", value, "iconPath");
			return (Criteria) this;
		}

		public Criteria andIconPathNotEqualTo(String value) {
			addCriterion("icon_path <>", value, "iconPath");
			return (Criteria) this;
		}

		public Criteria andIconPathGreaterThan(String value) {
			addCriterion("icon_path >", value, "iconPath");
			return (Criteria) this;
		}

		public Criteria andIconPathGreaterThanOrEqualTo(String value) {
			addCriterion("icon_path >=", value, "iconPath");
			return (Criteria) this;
		}

		public Criteria andIconPathLessThan(String value) {
			addCriterion("icon_path <", value, "iconPath");
			return (Criteria) this;
		}

		public Criteria andIconPathLessThanOrEqualTo(String value) {
			addCriterion("icon_path <=", value, "iconPath");
			return (Criteria) this;
		}

		public Criteria andIconPathLike(String value) {
			addCriterion("icon_path like", value, "iconPath");
			return (Criteria) this;
		}

		public Criteria andIconPathNotLike(String value) {
			addCriterion("icon_path not like", value, "iconPath");
			return (Criteria) this;
		}

		public Criteria andIconPathIn(List<String> values) {
			addCriterion("icon_path in", values, "iconPath");
			return (Criteria) this;
		}

		public Criteria andIconPathNotIn(List<String> values) {
			addCriterion("icon_path not in", values, "iconPath");
			return (Criteria) this;
		}

		public Criteria andIconPathBetween(String value1, String value2) {
			addCriterion("icon_path between", value1, value2, "iconPath");
			return (Criteria) this;
		}

		public Criteria andIconPathNotBetween(String value1, String value2) {
			addCriterion("icon_path not between", value1, value2, "iconPath");
			return (Criteria) this;
		}

		public Criteria andClassIdIsNull() {
			addCriterion("class_id is null");
			return (Criteria) this;
		}

		public Criteria andClassIdIsNotNull() {
			addCriterion("class_id is not null");
			return (Criteria) this;
		}

		public Criteria andClassIdEqualTo(Long value) {
			addCriterion("class_id =", value, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdNotEqualTo(Long value) {
			addCriterion("class_id <>", value, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdGreaterThan(Long value) {
			addCriterion("class_id >", value, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdGreaterThanOrEqualTo(Long value) {
			addCriterion("class_id >=", value, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdLessThan(Long value) {
			addCriterion("class_id <", value, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdLessThanOrEqualTo(Long value) {
			addCriterion("class_id <=", value, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdIn(List<Long> values) {
			addCriterion("class_id in", values, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdNotIn(List<Long> values) {
			addCriterion("class_id not in", values, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdBetween(Long value1, Long value2) {
			addCriterion("class_id between", value1, value2, "classId");
			return (Criteria) this;
		}

		public Criteria andClassIdNotBetween(Long value1, Long value2) {
			addCriterion("class_id not between", value1, value2, "classId");
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