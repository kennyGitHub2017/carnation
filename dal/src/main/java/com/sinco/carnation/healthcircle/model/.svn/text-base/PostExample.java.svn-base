package com.sinco.carnation.healthcircle.model;

import com.sinco.carnation.healthcircle.bo.PostBO;
import com.sinco.mybatis.dal.core.AbstractExample;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostExample extends AbstractExample<PostBO> {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected String limit;

	public PostExample() {
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

		public Criteria andDeleteStatusEqualTo(String value) {
			addCriterion("delete_status =", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotEqualTo(String value) {
			addCriterion("delete_status <>", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThan(String value) {
			addCriterion("delete_status >", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThanOrEqualTo(String value) {
			addCriterion("delete_status >=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThan(String value) {
			addCriterion("delete_status <", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThanOrEqualTo(String value) {
			addCriterion("delete_status <=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLike(String value) {
			addCriterion("delete_status like", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotLike(String value) {
			addCriterion("delete_status not like", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusIn(List<String> values) {
			addCriterion("delete_status in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotIn(List<String> values) {
			addCriterion("delete_status not in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusBetween(String value1, String value2) {
			addCriterion("delete_status between", value1, value2, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotBetween(String value1, String value2) {
			addCriterion("delete_status not between", value1, value2, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andTitleIsNull() {
			addCriterion("title is null");
			return (Criteria) this;
		}

		public Criteria andTitleIsNotNull() {
			addCriterion("title is not null");
			return (Criteria) this;
		}

		public Criteria andTitleEqualTo(String value) {
			addCriterion("title =", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotEqualTo(String value) {
			addCriterion("title <>", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThan(String value) {
			addCriterion("title >", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThanOrEqualTo(String value) {
			addCriterion("title >=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThan(String value) {
			addCriterion("title <", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThanOrEqualTo(String value) {
			addCriterion("title <=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLike(String value) {
			addCriterion("title like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotLike(String value) {
			addCriterion("title not like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleIn(List<String> values) {
			addCriterion("title in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotIn(List<String> values) {
			addCriterion("title not in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleBetween(String value1, String value2) {
			addCriterion("title between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotBetween(String value1, String value2) {
			addCriterion("title not between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andPraiseNumIsNull() {
			addCriterion("praise_num is null");
			return (Criteria) this;
		}

		public Criteria andPraiseNumIsNotNull() {
			addCriterion("praise_num is not null");
			return (Criteria) this;
		}

		public Criteria andPraiseNumEqualTo(Integer value) {
			addCriterion("praise_num =", value, "praiseNum");
			return (Criteria) this;
		}

		public Criteria andPraiseNumNotEqualTo(Integer value) {
			addCriterion("praise_num <>", value, "praiseNum");
			return (Criteria) this;
		}

		public Criteria andPraiseNumGreaterThan(Integer value) {
			addCriterion("praise_num >", value, "praiseNum");
			return (Criteria) this;
		}

		public Criteria andPraiseNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("praise_num >=", value, "praiseNum");
			return (Criteria) this;
		}

		public Criteria andPraiseNumLessThan(Integer value) {
			addCriterion("praise_num <", value, "praiseNum");
			return (Criteria) this;
		}

		public Criteria andPraiseNumLessThanOrEqualTo(Integer value) {
			addCriterion("praise_num <=", value, "praiseNum");
			return (Criteria) this;
		}

		public Criteria andPraiseNumIn(List<Integer> values) {
			addCriterion("praise_num in", values, "praiseNum");
			return (Criteria) this;
		}

		public Criteria andPraiseNumNotIn(List<Integer> values) {
			addCriterion("praise_num not in", values, "praiseNum");
			return (Criteria) this;
		}

		public Criteria andPraiseNumBetween(Integer value1, Integer value2) {
			addCriterion("praise_num between", value1, value2, "praiseNum");
			return (Criteria) this;
		}

		public Criteria andPraiseNumNotBetween(Integer value1, Integer value2) {
			addCriterion("praise_num not between", value1, value2, "praiseNum");
			return (Criteria) this;
		}

		public Criteria andEvaluateNumIsNull() {
			addCriterion("evaluate_num is null");
			return (Criteria) this;
		}

		public Criteria andEvaluateNumIsNotNull() {
			addCriterion("evaluate_num is not null");
			return (Criteria) this;
		}

		public Criteria andEvaluateNumEqualTo(Integer value) {
			addCriterion("evaluate_num =", value, "evaluateNum");
			return (Criteria) this;
		}

		public Criteria andEvaluateNumNotEqualTo(Integer value) {
			addCriterion("evaluate_num <>", value, "evaluateNum");
			return (Criteria) this;
		}

		public Criteria andEvaluateNumGreaterThan(Integer value) {
			addCriterion("evaluate_num >", value, "evaluateNum");
			return (Criteria) this;
		}

		public Criteria andEvaluateNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("evaluate_num >=", value, "evaluateNum");
			return (Criteria) this;
		}

		public Criteria andEvaluateNumLessThan(Integer value) {
			addCriterion("evaluate_num <", value, "evaluateNum");
			return (Criteria) this;
		}

		public Criteria andEvaluateNumLessThanOrEqualTo(Integer value) {
			addCriterion("evaluate_num <=", value, "evaluateNum");
			return (Criteria) this;
		}

		public Criteria andEvaluateNumIn(List<Integer> values) {
			addCriterion("evaluate_num in", values, "evaluateNum");
			return (Criteria) this;
		}

		public Criteria andEvaluateNumNotIn(List<Integer> values) {
			addCriterion("evaluate_num not in", values, "evaluateNum");
			return (Criteria) this;
		}

		public Criteria andEvaluateNumBetween(Integer value1, Integer value2) {
			addCriterion("evaluate_num between", value1, value2, "evaluateNum");
			return (Criteria) this;
		}

		public Criteria andEvaluateNumNotBetween(Integer value1, Integer value2) {
			addCriterion("evaluate_num not between", value1, value2, "evaluateNum");
			return (Criteria) this;
		}

		public Criteria andAccessoryIdIsNull() {
			addCriterion("accessory_id is null");
			return (Criteria) this;
		}

		public Criteria andAccessoryIdIsNotNull() {
			addCriterion("accessory_id is not null");
			return (Criteria) this;
		}

		public Criteria andAccessoryIdEqualTo(Long value) {
			addCriterion("accessory_id =", value, "accessoryId");
			return (Criteria) this;
		}

		public Criteria andAccessoryIdNotEqualTo(Long value) {
			addCriterion("accessory_id <>", value, "accessoryId");
			return (Criteria) this;
		}

		public Criteria andAccessoryIdGreaterThan(Long value) {
			addCriterion("accessory_id >", value, "accessoryId");
			return (Criteria) this;
		}

		public Criteria andAccessoryIdGreaterThanOrEqualTo(Long value) {
			addCriterion("accessory_id >=", value, "accessoryId");
			return (Criteria) this;
		}

		public Criteria andAccessoryIdLessThan(Long value) {
			addCriterion("accessory_id <", value, "accessoryId");
			return (Criteria) this;
		}

		public Criteria andAccessoryIdLessThanOrEqualTo(Long value) {
			addCriterion("accessory_id <=", value, "accessoryId");
			return (Criteria) this;
		}

		public Criteria andAccessoryIdIn(List<Long> values) {
			addCriterion("accessory_id in", values, "accessoryId");
			return (Criteria) this;
		}

		public Criteria andAccessoryIdNotIn(List<Long> values) {
			addCriterion("accessory_id not in", values, "accessoryId");
			return (Criteria) this;
		}

		public Criteria andAccessoryIdBetween(Long value1, Long value2) {
			addCriterion("accessory_id between", value1, value2, "accessoryId");
			return (Criteria) this;
		}

		public Criteria andAccessoryIdNotBetween(Long value1, Long value2) {
			addCriterion("accessory_id not between", value1, value2, "accessoryId");
			return (Criteria) this;
		}

		public Criteria andReadNumIsNull() {
			addCriterion("read_num is null");
			return (Criteria) this;
		}

		public Criteria andReadNumIsNotNull() {
			addCriterion("read_num is not null");
			return (Criteria) this;
		}

		public Criteria andReadNumEqualTo(Integer value) {
			addCriterion("read_num =", value, "readNum");
			return (Criteria) this;
		}

		public Criteria andReadNumNotEqualTo(Integer value) {
			addCriterion("read_num <>", value, "readNum");
			return (Criteria) this;
		}

		public Criteria andReadNumGreaterThan(Integer value) {
			addCriterion("read_num >", value, "readNum");
			return (Criteria) this;
		}

		public Criteria andReadNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("read_num >=", value, "readNum");
			return (Criteria) this;
		}

		public Criteria andReadNumLessThan(Integer value) {
			addCriterion("read_num <", value, "readNum");
			return (Criteria) this;
		}

		public Criteria andReadNumLessThanOrEqualTo(Integer value) {
			addCriterion("read_num <=", value, "readNum");
			return (Criteria) this;
		}

		public Criteria andReadNumIn(List<Integer> values) {
			addCriterion("read_num in", values, "readNum");
			return (Criteria) this;
		}

		public Criteria andReadNumNotIn(List<Integer> values) {
			addCriterion("read_num not in", values, "readNum");
			return (Criteria) this;
		}

		public Criteria andReadNumBetween(Integer value1, Integer value2) {
			addCriterion("read_num between", value1, value2, "readNum");
			return (Criteria) this;
		}

		public Criteria andReadNumNotBetween(Integer value1, Integer value2) {
			addCriterion("read_num not between", value1, value2, "readNum");
			return (Criteria) this;
		}

		public Criteria andLocationIsNull() {
			addCriterion("location is null");
			return (Criteria) this;
		}

		public Criteria andLocationIsNotNull() {
			addCriterion("location is not null");
			return (Criteria) this;
		}

		public Criteria andLocationEqualTo(String value) {
			addCriterion("location =", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationNotEqualTo(String value) {
			addCriterion("location <>", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationGreaterThan(String value) {
			addCriterion("location >", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationGreaterThanOrEqualTo(String value) {
			addCriterion("location >=", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationLessThan(String value) {
			addCriterion("location <", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationLessThanOrEqualTo(String value) {
			addCriterion("location <=", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationLike(String value) {
			addCriterion("location like", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationNotLike(String value) {
			addCriterion("location not like", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationIn(List<String> values) {
			addCriterion("location in", values, "location");
			return (Criteria) this;
		}

		public Criteria andLocationNotIn(List<String> values) {
			addCriterion("location not in", values, "location");
			return (Criteria) this;
		}

		public Criteria andLocationBetween(String value1, String value2) {
			addCriterion("location between", value1, value2, "location");
			return (Criteria) this;
		}

		public Criteria andLocationNotBetween(String value1, String value2) {
			addCriterion("location not between", value1, value2, "location");
			return (Criteria) this;
		}

		public Criteria andLableIdIsNull() {
			addCriterion("lable_id is null");
			return (Criteria) this;
		}

		public Criteria andLableIdIsNotNull() {
			addCriterion("lable_id is not null");
			return (Criteria) this;
		}

		public Criteria andLableIdEqualTo(Long value) {
			addCriterion("lable_id =", value, "lableId");
			return (Criteria) this;
		}

		public Criteria andLableIdNotEqualTo(Long value) {
			addCriterion("lable_id <>", value, "lableId");
			return (Criteria) this;
		}

		public Criteria andLableIdGreaterThan(Long value) {
			addCriterion("lable_id >", value, "lableId");
			return (Criteria) this;
		}

		public Criteria andLableIdGreaterThanOrEqualTo(Long value) {
			addCriterion("lable_id >=", value, "lableId");
			return (Criteria) this;
		}

		public Criteria andLableIdLessThan(Long value) {
			addCriterion("lable_id <", value, "lableId");
			return (Criteria) this;
		}

		public Criteria andLableIdLessThanOrEqualTo(Long value) {
			addCriterion("lable_id <=", value, "lableId");
			return (Criteria) this;
		}

		public Criteria andLableIdIn(List<Long> values) {
			addCriterion("lable_id in", values, "lableId");
			return (Criteria) this;
		}

		public Criteria andLableIdNotIn(List<Long> values) {
			addCriterion("lable_id not in", values, "lableId");
			return (Criteria) this;
		}

		public Criteria andLableIdBetween(Long value1, Long value2) {
			addCriterion("lable_id between", value1, value2, "lableId");
			return (Criteria) this;
		}

		public Criteria andLableIdNotBetween(Long value1, Long value2) {
			addCriterion("lable_id not between", value1, value2, "lableId");
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