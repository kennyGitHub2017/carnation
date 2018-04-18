package com.sinco.carnation.goldEgg.model;

import com.sinco.carnation.goldEgg.bo.GlodEggItemBO;
import com.sinco.mybatis.dal.core.AbstractExample;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GlodEggItemExample extends AbstractExample<GlodEggItemBO> {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected String limit;

	public GlodEggItemExample() {
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

		public Criteria andCurrentGetCountIsNull() {
			addCriterion("current_get_count is null");
			return (Criteria) this;
		}

		public Criteria andCurrentGetCountIsNotNull() {
			addCriterion("current_get_count is not null");
			return (Criteria) this;
		}

		public Criteria andCurrentGetCountEqualTo(Long value) {
			addCriterion("current_get_count =", value, "currentGetCount");
			return (Criteria) this;
		}

		public Criteria andCurrentGetCountNotEqualTo(Long value) {
			addCriterion("current_get_count <>", value, "currentGetCount");
			return (Criteria) this;
		}

		public Criteria andCurrentGetCountGreaterThan(Long value) {
			addCriterion("current_get_count >", value, "currentGetCount");
			return (Criteria) this;
		}

		public Criteria andCurrentGetCountGreaterThanOrEqualTo(Long value) {
			addCriterion("current_get_count >=", value, "currentGetCount");
			return (Criteria) this;
		}

		public Criteria andCurrentGetCountLessThan(Long value) {
			addCriterion("current_get_count <", value, "currentGetCount");
			return (Criteria) this;
		}

		public Criteria andCurrentGetCountLessThanOrEqualTo(Long value) {
			addCriterion("current_get_count <=", value, "currentGetCount");
			return (Criteria) this;
		}

		public Criteria andCurrentGetCountIn(List<Long> values) {
			addCriterion("current_get_count in", values, "currentGetCount");
			return (Criteria) this;
		}

		public Criteria andCurrentGetCountNotIn(List<Long> values) {
			addCriterion("current_get_count not in", values, "currentGetCount");
			return (Criteria) this;
		}

		public Criteria andCurrentGetCountBetween(Long value1, Long value2) {
			addCriterion("current_get_count between", value1, value2, "currentGetCount");
			return (Criteria) this;
		}

		public Criteria andCurrentGetCountNotBetween(Long value1, Long value2) {
			addCriterion("current_get_count not between", value1, value2, "currentGetCount");
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

		public Criteria andGlodEggIdIsNull() {
			addCriterion("glod_egg_id is null");
			return (Criteria) this;
		}

		public Criteria andGlodEggIdIsNotNull() {
			addCriterion("glod_egg_id is not null");
			return (Criteria) this;
		}

		public Criteria andGlodEggIdEqualTo(Long value) {
			addCriterion("glod_egg_id =", value, "glodEggId");
			return (Criteria) this;
		}

		public Criteria andGlodEggIdNotEqualTo(Long value) {
			addCriterion("glod_egg_id <>", value, "glodEggId");
			return (Criteria) this;
		}

		public Criteria andGlodEggIdGreaterThan(Long value) {
			addCriterion("glod_egg_id >", value, "glodEggId");
			return (Criteria) this;
		}

		public Criteria andGlodEggIdGreaterThanOrEqualTo(Long value) {
			addCriterion("glod_egg_id >=", value, "glodEggId");
			return (Criteria) this;
		}

		public Criteria andGlodEggIdLessThan(Long value) {
			addCriterion("glod_egg_id <", value, "glodEggId");
			return (Criteria) this;
		}

		public Criteria andGlodEggIdLessThanOrEqualTo(Long value) {
			addCriterion("glod_egg_id <=", value, "glodEggId");
			return (Criteria) this;
		}

		public Criteria andGlodEggIdIn(List<Long> values) {
			addCriterion("glod_egg_id in", values, "glodEggId");
			return (Criteria) this;
		}

		public Criteria andGlodEggIdNotIn(List<Long> values) {
			addCriterion("glod_egg_id not in", values, "glodEggId");
			return (Criteria) this;
		}

		public Criteria andGlodEggIdBetween(Long value1, Long value2) {
			addCriterion("glod_egg_id between", value1, value2, "glodEggId");
			return (Criteria) this;
		}

		public Criteria andGlodEggIdNotBetween(Long value1, Long value2) {
			addCriterion("glod_egg_id not between", value1, value2, "glodEggId");
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