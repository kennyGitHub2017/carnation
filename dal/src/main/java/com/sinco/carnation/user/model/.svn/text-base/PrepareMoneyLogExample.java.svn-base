package com.sinco.carnation.user.model;

import com.sinco.carnation.user.bo.PrepareMoneyLogBO;
import com.sinco.mybatis.dal.core.AbstractExample;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrepareMoneyLogExample extends AbstractExample<PrepareMoneyLogBO> {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected String limit;

	public PrepareMoneyLogExample() {
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

		public Criteria andPdLogAmountIsNull() {
			addCriterion("pd_log_amount is null");
			return (Criteria) this;
		}

		public Criteria andPdLogAmountIsNotNull() {
			addCriterion("pd_log_amount is not null");
			return (Criteria) this;
		}

		public Criteria andPdLogAmountEqualTo(BigDecimal value) {
			addCriterion("pd_log_amount =", value, "pdLogAmount");
			return (Criteria) this;
		}

		public Criteria andPdLogAmountNotEqualTo(BigDecimal value) {
			addCriterion("pd_log_amount <>", value, "pdLogAmount");
			return (Criteria) this;
		}

		public Criteria andPdLogAmountGreaterThan(BigDecimal value) {
			addCriterion("pd_log_amount >", value, "pdLogAmount");
			return (Criteria) this;
		}

		public Criteria andPdLogAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("pd_log_amount >=", value, "pdLogAmount");
			return (Criteria) this;
		}

		public Criteria andPdLogAmountLessThan(BigDecimal value) {
			addCriterion("pd_log_amount <", value, "pdLogAmount");
			return (Criteria) this;
		}

		public Criteria andPdLogAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("pd_log_amount <=", value, "pdLogAmount");
			return (Criteria) this;
		}

		public Criteria andPdLogAmountIn(List<BigDecimal> values) {
			addCriterion("pd_log_amount in", values, "pdLogAmount");
			return (Criteria) this;
		}

		public Criteria andPdLogAmountNotIn(List<BigDecimal> values) {
			addCriterion("pd_log_amount not in", values, "pdLogAmount");
			return (Criteria) this;
		}

		public Criteria andPdLogAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("pd_log_amount between", value1, value2, "pdLogAmount");
			return (Criteria) this;
		}

		public Criteria andPdLogAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("pd_log_amount not between", value1, value2, "pdLogAmount");
			return (Criteria) this;
		}

		public Criteria andPdOpTypeIsNull() {
			addCriterion("pd_op_type is null");
			return (Criteria) this;
		}

		public Criteria andPdOpTypeIsNotNull() {
			addCriterion("pd_op_type is not null");
			return (Criteria) this;
		}

		public Criteria andPdOpTypeEqualTo(String value) {
			addCriterion("pd_op_type =", value, "pdOpType");
			return (Criteria) this;
		}

		public Criteria andPdOpTypeNotEqualTo(String value) {
			addCriterion("pd_op_type <>", value, "pdOpType");
			return (Criteria) this;
		}

		public Criteria andPdOpTypeGreaterThan(String value) {
			addCriterion("pd_op_type >", value, "pdOpType");
			return (Criteria) this;
		}

		public Criteria andPdOpTypeGreaterThanOrEqualTo(String value) {
			addCriterion("pd_op_type >=", value, "pdOpType");
			return (Criteria) this;
		}

		public Criteria andPdOpTypeLessThan(String value) {
			addCriterion("pd_op_type <", value, "pdOpType");
			return (Criteria) this;
		}

		public Criteria andPdOpTypeLessThanOrEqualTo(String value) {
			addCriterion("pd_op_type <=", value, "pdOpType");
			return (Criteria) this;
		}

		public Criteria andPdOpTypeLike(String value) {
			addCriterion("pd_op_type like", value, "pdOpType");
			return (Criteria) this;
		}

		public Criteria andPdOpTypeNotLike(String value) {
			addCriterion("pd_op_type not like", value, "pdOpType");
			return (Criteria) this;
		}

		public Criteria andPdOpTypeIn(List<String> values) {
			addCriterion("pd_op_type in", values, "pdOpType");
			return (Criteria) this;
		}

		public Criteria andPdOpTypeNotIn(List<String> values) {
			addCriterion("pd_op_type not in", values, "pdOpType");
			return (Criteria) this;
		}

		public Criteria andPdOpTypeBetween(String value1, String value2) {
			addCriterion("pd_op_type between", value1, value2, "pdOpType");
			return (Criteria) this;
		}

		public Criteria andPdOpTypeNotBetween(String value1, String value2) {
			addCriterion("pd_op_type not between", value1, value2, "pdOpType");
			return (Criteria) this;
		}

		public Criteria andPdTypeIsNull() {
			addCriterion("pd_type is null");
			return (Criteria) this;
		}

		public Criteria andPdTypeIsNotNull() {
			addCriterion("pd_type is not null");
			return (Criteria) this;
		}

		public Criteria andPdTypeEqualTo(String value) {
			addCriterion("pd_type =", value, "pdType");
			return (Criteria) this;
		}

		public Criteria andPdTypeNotEqualTo(String value) {
			addCriterion("pd_type <>", value, "pdType");
			return (Criteria) this;
		}

		public Criteria andPdTypeGreaterThan(String value) {
			addCriterion("pd_type >", value, "pdType");
			return (Criteria) this;
		}

		public Criteria andPdTypeGreaterThanOrEqualTo(String value) {
			addCriterion("pd_type >=", value, "pdType");
			return (Criteria) this;
		}

		public Criteria andPdTypeLessThan(String value) {
			addCriterion("pd_type <", value, "pdType");
			return (Criteria) this;
		}

		public Criteria andPdTypeLessThanOrEqualTo(String value) {
			addCriterion("pd_type <=", value, "pdType");
			return (Criteria) this;
		}

		public Criteria andPdTypeLike(String value) {
			addCriterion("pd_type like", value, "pdType");
			return (Criteria) this;
		}

		public Criteria andPdTypeNotLike(String value) {
			addCriterion("pd_type not like", value, "pdType");
			return (Criteria) this;
		}

		public Criteria andPdTypeIn(List<String> values) {
			addCriterion("pd_type in", values, "pdType");
			return (Criteria) this;
		}

		public Criteria andPdTypeNotIn(List<String> values) {
			addCriterion("pd_type not in", values, "pdType");
			return (Criteria) this;
		}

		public Criteria andPdTypeBetween(String value1, String value2) {
			addCriterion("pd_type between", value1, value2, "pdType");
			return (Criteria) this;
		}

		public Criteria andPdTypeNotBetween(String value1, String value2) {
			addCriterion("pd_type not between", value1, value2, "pdType");
			return (Criteria) this;
		}

		public Criteria andBalanceIsNull() {
			addCriterion("balance is null");
			return (Criteria) this;
		}

		public Criteria andBalanceIsNotNull() {
			addCriterion("balance is not null");
			return (Criteria) this;
		}

		public Criteria andBalanceEqualTo(BigDecimal value) {
			addCriterion("balance =", value, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceNotEqualTo(BigDecimal value) {
			addCriterion("balance <>", value, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceGreaterThan(BigDecimal value) {
			addCriterion("balance >", value, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("balance >=", value, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceLessThan(BigDecimal value) {
			addCriterion("balance <", value, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("balance <=", value, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceIn(List<BigDecimal> values) {
			addCriterion("balance in", values, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceNotIn(List<BigDecimal> values) {
			addCriterion("balance not in", values, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("balance between", value1, value2, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("balance not between", value1, value2, "balance");
			return (Criteria) this;
		}

		public Criteria andPdLogAdminIdIsNull() {
			addCriterion("pd_log_admin_id is null");
			return (Criteria) this;
		}

		public Criteria andPdLogAdminIdIsNotNull() {
			addCriterion("pd_log_admin_id is not null");
			return (Criteria) this;
		}

		public Criteria andPdLogAdminIdEqualTo(Long value) {
			addCriterion("pd_log_admin_id =", value, "pdLogAdminId");
			return (Criteria) this;
		}

		public Criteria andPdLogAdminIdNotEqualTo(Long value) {
			addCriterion("pd_log_admin_id <>", value, "pdLogAdminId");
			return (Criteria) this;
		}

		public Criteria andPdLogAdminIdGreaterThan(Long value) {
			addCriterion("pd_log_admin_id >", value, "pdLogAdminId");
			return (Criteria) this;
		}

		public Criteria andPdLogAdminIdGreaterThanOrEqualTo(Long value) {
			addCriterion("pd_log_admin_id >=", value, "pdLogAdminId");
			return (Criteria) this;
		}

		public Criteria andPdLogAdminIdLessThan(Long value) {
			addCriterion("pd_log_admin_id <", value, "pdLogAdminId");
			return (Criteria) this;
		}

		public Criteria andPdLogAdminIdLessThanOrEqualTo(Long value) {
			addCriterion("pd_log_admin_id <=", value, "pdLogAdminId");
			return (Criteria) this;
		}

		public Criteria andPdLogAdminIdIn(List<Long> values) {
			addCriterion("pd_log_admin_id in", values, "pdLogAdminId");
			return (Criteria) this;
		}

		public Criteria andPdLogAdminIdNotIn(List<Long> values) {
			addCriterion("pd_log_admin_id not in", values, "pdLogAdminId");
			return (Criteria) this;
		}

		public Criteria andPdLogAdminIdBetween(Long value1, Long value2) {
			addCriterion("pd_log_admin_id between", value1, value2, "pdLogAdminId");
			return (Criteria) this;
		}

		public Criteria andPdLogAdminIdNotBetween(Long value1, Long value2) {
			addCriterion("pd_log_admin_id not between", value1, value2, "pdLogAdminId");
			return (Criteria) this;
		}

		public Criteria andPdLogUserIdIsNull() {
			addCriterion("pd_log_user_id is null");
			return (Criteria) this;
		}

		public Criteria andPdLogUserIdIsNotNull() {
			addCriterion("pd_log_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andPdLogUserIdEqualTo(Long value) {
			addCriterion("pd_log_user_id =", value, "pdLogUserId");
			return (Criteria) this;
		}

		public Criteria andPdLogUserIdNotEqualTo(Long value) {
			addCriterion("pd_log_user_id <>", value, "pdLogUserId");
			return (Criteria) this;
		}

		public Criteria andPdLogUserIdGreaterThan(Long value) {
			addCriterion("pd_log_user_id >", value, "pdLogUserId");
			return (Criteria) this;
		}

		public Criteria andPdLogUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("pd_log_user_id >=", value, "pdLogUserId");
			return (Criteria) this;
		}

		public Criteria andPdLogUserIdLessThan(Long value) {
			addCriterion("pd_log_user_id <", value, "pdLogUserId");
			return (Criteria) this;
		}

		public Criteria andPdLogUserIdLessThanOrEqualTo(Long value) {
			addCriterion("pd_log_user_id <=", value, "pdLogUserId");
			return (Criteria) this;
		}

		public Criteria andPdLogUserIdIn(List<Long> values) {
			addCriterion("pd_log_user_id in", values, "pdLogUserId");
			return (Criteria) this;
		}

		public Criteria andPdLogUserIdNotIn(List<Long> values) {
			addCriterion("pd_log_user_id not in", values, "pdLogUserId");
			return (Criteria) this;
		}

		public Criteria andPdLogUserIdBetween(Long value1, Long value2) {
			addCriterion("pd_log_user_id between", value1, value2, "pdLogUserId");
			return (Criteria) this;
		}

		public Criteria andPdLogUserIdNotBetween(Long value1, Long value2) {
			addCriterion("pd_log_user_id not between", value1, value2, "pdLogUserId");
			return (Criteria) this;
		}

		public Criteria andPredepositIdIsNull() {
			addCriterion("predeposit_id is null");
			return (Criteria) this;
		}

		public Criteria andPredepositIdIsNotNull() {
			addCriterion("predeposit_id is not null");
			return (Criteria) this;
		}

		public Criteria andPredepositIdEqualTo(Long value) {
			addCriterion("predeposit_id =", value, "predepositId");
			return (Criteria) this;
		}

		public Criteria andPredepositIdNotEqualTo(Long value) {
			addCriterion("predeposit_id <>", value, "predepositId");
			return (Criteria) this;
		}

		public Criteria andPredepositIdGreaterThan(Long value) {
			addCriterion("predeposit_id >", value, "predepositId");
			return (Criteria) this;
		}

		public Criteria andPredepositIdGreaterThanOrEqualTo(Long value) {
			addCriterion("predeposit_id >=", value, "predepositId");
			return (Criteria) this;
		}

		public Criteria andPredepositIdLessThan(Long value) {
			addCriterion("predeposit_id <", value, "predepositId");
			return (Criteria) this;
		}

		public Criteria andPredepositIdLessThanOrEqualTo(Long value) {
			addCriterion("predeposit_id <=", value, "predepositId");
			return (Criteria) this;
		}

		public Criteria andPredepositIdIn(List<Long> values) {
			addCriterion("predeposit_id in", values, "predepositId");
			return (Criteria) this;
		}

		public Criteria andPredepositIdNotIn(List<Long> values) {
			addCriterion("predeposit_id not in", values, "predepositId");
			return (Criteria) this;
		}

		public Criteria andPredepositIdBetween(Long value1, Long value2) {
			addCriterion("predeposit_id between", value1, value2, "predepositId");
			return (Criteria) this;
		}

		public Criteria andPredepositIdNotBetween(Long value1, Long value2) {
			addCriterion("predeposit_id not between", value1, value2, "predepositId");
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