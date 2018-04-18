package com.sinco.carnation.sys.model;

import com.sinco.carnation.sys.bo.BindingHistoryBO;
import com.sinco.mybatis.dal.core.AbstractExample;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BindingHistoryExample extends AbstractExample<BindingHistoryBO> {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected String limit;

	public BindingHistoryExample() {
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

		public Criteria andOldUidIsNull() {
			addCriterion("old_uid is null");
			return (Criteria) this;
		}

		public Criteria andOldUidIsNotNull() {
			addCriterion("old_uid is not null");
			return (Criteria) this;
		}

		public Criteria andOldUidEqualTo(Long value) {
			addCriterion("old_uid =", value, "oldUid");
			return (Criteria) this;
		}

		public Criteria andOldUidNotEqualTo(Long value) {
			addCriterion("old_uid <>", value, "oldUid");
			return (Criteria) this;
		}

		public Criteria andOldUidGreaterThan(Long value) {
			addCriterion("old_uid >", value, "oldUid");
			return (Criteria) this;
		}

		public Criteria andOldUidGreaterThanOrEqualTo(Long value) {
			addCriterion("old_uid >=", value, "oldUid");
			return (Criteria) this;
		}

		public Criteria andOldUidLessThan(Long value) {
			addCriterion("old_uid <", value, "oldUid");
			return (Criteria) this;
		}

		public Criteria andOldUidLessThanOrEqualTo(Long value) {
			addCriterion("old_uid <=", value, "oldUid");
			return (Criteria) this;
		}

		public Criteria andOldUidIn(List<Long> values) {
			addCriterion("old_uid in", values, "oldUid");
			return (Criteria) this;
		}

		public Criteria andOldUidNotIn(List<Long> values) {
			addCriterion("old_uid not in", values, "oldUid");
			return (Criteria) this;
		}

		public Criteria andOldUidBetween(Long value1, Long value2) {
			addCriterion("old_uid between", value1, value2, "oldUid");
			return (Criteria) this;
		}

		public Criteria andOldUidNotBetween(Long value1, Long value2) {
			addCriterion("old_uid not between", value1, value2, "oldUid");
			return (Criteria) this;
		}

		public Criteria andNewUidIsNull() {
			addCriterion("new_uid is null");
			return (Criteria) this;
		}

		public Criteria andNewUidIsNotNull() {
			addCriterion("new_uid is not null");
			return (Criteria) this;
		}

		public Criteria andNewUidEqualTo(Long value) {
			addCriterion("new_uid =", value, "newUid");
			return (Criteria) this;
		}

		public Criteria andNewUidNotEqualTo(Long value) {
			addCriterion("new_uid <>", value, "newUid");
			return (Criteria) this;
		}

		public Criteria andNewUidGreaterThan(Long value) {
			addCriterion("new_uid >", value, "newUid");
			return (Criteria) this;
		}

		public Criteria andNewUidGreaterThanOrEqualTo(Long value) {
			addCriterion("new_uid >=", value, "newUid");
			return (Criteria) this;
		}

		public Criteria andNewUidLessThan(Long value) {
			addCriterion("new_uid <", value, "newUid");
			return (Criteria) this;
		}

		public Criteria andNewUidLessThanOrEqualTo(Long value) {
			addCriterion("new_uid <=", value, "newUid");
			return (Criteria) this;
		}

		public Criteria andNewUidIn(List<Long> values) {
			addCriterion("new_uid in", values, "newUid");
			return (Criteria) this;
		}

		public Criteria andNewUidNotIn(List<Long> values) {
			addCriterion("new_uid not in", values, "newUid");
			return (Criteria) this;
		}

		public Criteria andNewUidBetween(Long value1, Long value2) {
			addCriterion("new_uid between", value1, value2, "newUid");
			return (Criteria) this;
		}

		public Criteria andNewUidNotBetween(Long value1, Long value2) {
			addCriterion("new_uid not between", value1, value2, "newUid");
			return (Criteria) this;
		}

		public Criteria andAddtimeIsNull() {
			addCriterion("addtime is null");
			return (Criteria) this;
		}

		public Criteria andAddtimeIsNotNull() {
			addCriterion("addtime is not null");
			return (Criteria) this;
		}

		public Criteria andAddtimeEqualTo(Date value) {
			addCriterion("addtime =", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeNotEqualTo(Date value) {
			addCriterion("addtime <>", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeGreaterThan(Date value) {
			addCriterion("addtime >", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeGreaterThanOrEqualTo(Date value) {
			addCriterion("addtime >=", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeLessThan(Date value) {
			addCriterion("addtime <", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeLessThanOrEqualTo(Date value) {
			addCriterion("addtime <=", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeIn(List<Date> values) {
			addCriterion("addtime in", values, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeNotIn(List<Date> values) {
			addCriterion("addtime not in", values, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeBetween(Date value1, Date value2) {
			addCriterion("addtime between", value1, value2, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeNotBetween(Date value1, Date value2) {
			addCriterion("addtime not between", value1, value2, "addtime");
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