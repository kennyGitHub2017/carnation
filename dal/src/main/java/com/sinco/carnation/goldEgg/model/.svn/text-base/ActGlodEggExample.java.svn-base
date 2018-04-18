package com.sinco.carnation.goldEgg.model;

import com.sinco.carnation.goldEgg.bo.ActGlodEggBO;
import com.sinco.mybatis.dal.core.AbstractExample;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ActGlodEggExample extends AbstractExample<ActGlodEggBO> {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected String limit;

	public ActGlodEggExample() {
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

		public Criteria andTotalCountIsNull() {
			addCriterion("total_count is null");
			return (Criteria) this;
		}

		public Criteria andTotalCountIsNotNull() {
			addCriterion("total_count is not null");
			return (Criteria) this;
		}

		public Criteria andTotalCountEqualTo(Long value) {
			addCriterion("total_count =", value, "totalCount");
			return (Criteria) this;
		}

		public Criteria andTotalCountNotEqualTo(Long value) {
			addCriterion("total_count <>", value, "totalCount");
			return (Criteria) this;
		}

		public Criteria andTotalCountGreaterThan(Long value) {
			addCriterion("total_count >", value, "totalCount");
			return (Criteria) this;
		}

		public Criteria andTotalCountGreaterThanOrEqualTo(Long value) {
			addCriterion("total_count >=", value, "totalCount");
			return (Criteria) this;
		}

		public Criteria andTotalCountLessThan(Long value) {
			addCriterion("total_count <", value, "totalCount");
			return (Criteria) this;
		}

		public Criteria andTotalCountLessThanOrEqualTo(Long value) {
			addCriterion("total_count <=", value, "totalCount");
			return (Criteria) this;
		}

		public Criteria andTotalCountIn(List<Long> values) {
			addCriterion("total_count in", values, "totalCount");
			return (Criteria) this;
		}

		public Criteria andTotalCountNotIn(List<Long> values) {
			addCriterion("total_count not in", values, "totalCount");
			return (Criteria) this;
		}

		public Criteria andTotalCountBetween(Long value1, Long value2) {
			addCriterion("total_count between", value1, value2, "totalCount");
			return (Criteria) this;
		}

		public Criteria andTotalCountNotBetween(Long value1, Long value2) {
			addCriterion("total_count not between", value1, value2, "totalCount");
			return (Criteria) this;
		}

		public Criteria andTotalMoneyIsNull() {
			addCriterion("total_money is null");
			return (Criteria) this;
		}

		public Criteria andTotalMoneyIsNotNull() {
			addCriterion("total_money is not null");
			return (Criteria) this;
		}

		public Criteria andTotalMoneyEqualTo(BigDecimal value) {
			addCriterion("total_money =", value, "totalMoney");
			return (Criteria) this;
		}

		public Criteria andTotalMoneyNotEqualTo(BigDecimal value) {
			addCriterion("total_money <>", value, "totalMoney");
			return (Criteria) this;
		}

		public Criteria andTotalMoneyGreaterThan(BigDecimal value) {
			addCriterion("total_money >", value, "totalMoney");
			return (Criteria) this;
		}

		public Criteria andTotalMoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("total_money >=", value, "totalMoney");
			return (Criteria) this;
		}

		public Criteria andTotalMoneyLessThan(BigDecimal value) {
			addCriterion("total_money <", value, "totalMoney");
			return (Criteria) this;
		}

		public Criteria andTotalMoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("total_money <=", value, "totalMoney");
			return (Criteria) this;
		}

		public Criteria andTotalMoneyIn(List<BigDecimal> values) {
			addCriterion("total_money in", values, "totalMoney");
			return (Criteria) this;
		}

		public Criteria andTotalMoneyNotIn(List<BigDecimal> values) {
			addCriterion("total_money not in", values, "totalMoney");
			return (Criteria) this;
		}

		public Criteria andTotalMoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("total_money between", value1, value2, "totalMoney");
			return (Criteria) this;
		}

		public Criteria andTotalMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("total_money not between", value1, value2, "totalMoney");
			return (Criteria) this;
		}

		public Criteria andDayLimitMoneyIsNull() {
			addCriterion("day_limit_money is null");
			return (Criteria) this;
		}

		public Criteria andDayLimitMoneyIsNotNull() {
			addCriterion("day_limit_money is not null");
			return (Criteria) this;
		}

		public Criteria andDayLimitMoneyEqualTo(BigDecimal value) {
			addCriterion("day_limit_money =", value, "dayLimitMoney");
			return (Criteria) this;
		}

		public Criteria andDayLimitMoneyNotEqualTo(BigDecimal value) {
			addCriterion("day_limit_money <>", value, "dayLimitMoney");
			return (Criteria) this;
		}

		public Criteria andDayLimitMoneyGreaterThan(BigDecimal value) {
			addCriterion("day_limit_money >", value, "dayLimitMoney");
			return (Criteria) this;
		}

		public Criteria andDayLimitMoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("day_limit_money >=", value, "dayLimitMoney");
			return (Criteria) this;
		}

		public Criteria andDayLimitMoneyLessThan(BigDecimal value) {
			addCriterion("day_limit_money <", value, "dayLimitMoney");
			return (Criteria) this;
		}

		public Criteria andDayLimitMoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("day_limit_money <=", value, "dayLimitMoney");
			return (Criteria) this;
		}

		public Criteria andDayLimitMoneyIn(List<BigDecimal> values) {
			addCriterion("day_limit_money in", values, "dayLimitMoney");
			return (Criteria) this;
		}

		public Criteria andDayLimitMoneyNotIn(List<BigDecimal> values) {
			addCriterion("day_limit_money not in", values, "dayLimitMoney");
			return (Criteria) this;
		}

		public Criteria andDayLimitMoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("day_limit_money between", value1, value2, "dayLimitMoney");
			return (Criteria) this;
		}

		public Criteria andDayLimitMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("day_limit_money not between", value1, value2, "dayLimitMoney");
			return (Criteria) this;
		}

		public Criteria andCurrentGetMoneyIsNull() {
			addCriterion("current_get_money is null");
			return (Criteria) this;
		}

		public Criteria andCurrentGetMoneyIsNotNull() {
			addCriterion("current_get_money is not null");
			return (Criteria) this;
		}

		public Criteria andCurrentGetMoneyEqualTo(BigDecimal value) {
			addCriterion("current_get_money =", value, "currentGetMoney");
			return (Criteria) this;
		}

		public Criteria andCurrentGetMoneyNotEqualTo(BigDecimal value) {
			addCriterion("current_get_money <>", value, "currentGetMoney");
			return (Criteria) this;
		}

		public Criteria andCurrentGetMoneyGreaterThan(BigDecimal value) {
			addCriterion("current_get_money >", value, "currentGetMoney");
			return (Criteria) this;
		}

		public Criteria andCurrentGetMoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("current_get_money >=", value, "currentGetMoney");
			return (Criteria) this;
		}

		public Criteria andCurrentGetMoneyLessThan(BigDecimal value) {
			addCriterion("current_get_money <", value, "currentGetMoney");
			return (Criteria) this;
		}

		public Criteria andCurrentGetMoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("current_get_money <=", value, "currentGetMoney");
			return (Criteria) this;
		}

		public Criteria andCurrentGetMoneyIn(List<BigDecimal> values) {
			addCriterion("current_get_money in", values, "currentGetMoney");
			return (Criteria) this;
		}

		public Criteria andCurrentGetMoneyNotIn(List<BigDecimal> values) {
			addCriterion("current_get_money not in", values, "currentGetMoney");
			return (Criteria) this;
		}

		public Criteria andCurrentGetMoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("current_get_money between", value1, value2, "currentGetMoney");
			return (Criteria) this;
		}

		public Criteria andCurrentGetMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("current_get_money not between", value1, value2, "currentGetMoney");
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

		public Criteria andActIdIsNull() {
			addCriterion("act_id is null");
			return (Criteria) this;
		}

		public Criteria andActIdIsNotNull() {
			addCriterion("act_id is not null");
			return (Criteria) this;
		}

		public Criteria andActIdEqualTo(Long value) {
			addCriterion("act_id =", value, "actId");
			return (Criteria) this;
		}

		public Criteria andActIdNotEqualTo(Long value) {
			addCriterion("act_id <>", value, "actId");
			return (Criteria) this;
		}

		public Criteria andActIdGreaterThan(Long value) {
			addCriterion("act_id >", value, "actId");
			return (Criteria) this;
		}

		public Criteria andActIdGreaterThanOrEqualTo(Long value) {
			addCriterion("act_id >=", value, "actId");
			return (Criteria) this;
		}

		public Criteria andActIdLessThan(Long value) {
			addCriterion("act_id <", value, "actId");
			return (Criteria) this;
		}

		public Criteria andActIdLessThanOrEqualTo(Long value) {
			addCriterion("act_id <=", value, "actId");
			return (Criteria) this;
		}

		public Criteria andActIdIn(List<Long> values) {
			addCriterion("act_id in", values, "actId");
			return (Criteria) this;
		}

		public Criteria andActIdNotIn(List<Long> values) {
			addCriterion("act_id not in", values, "actId");
			return (Criteria) this;
		}

		public Criteria andActIdBetween(Long value1, Long value2) {
			addCriterion("act_id between", value1, value2, "actId");
			return (Criteria) this;
		}

		public Criteria andActIdNotBetween(Long value1, Long value2) {
			addCriterion("act_id not between", value1, value2, "actId");
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