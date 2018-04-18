package com.sinco.carnation.shop.model;

import com.sinco.carnation.shop.bo.PredepositCashBO;
import com.sinco.mybatis.dal.core.AbstractExample;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PredepositCashExample extends AbstractExample<PredepositCashBO> {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected String limit;

	public PredepositCashExample() {
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

		public Criteria andCashAccountIsNull() {
			addCriterion("cash_account is null");
			return (Criteria) this;
		}

		public Criteria andCashAccountIsNotNull() {
			addCriterion("cash_account is not null");
			return (Criteria) this;
		}

		public Criteria andCashAccountEqualTo(String value) {
			addCriterion("cash_account =", value, "cashAccount");
			return (Criteria) this;
		}

		public Criteria andCashAccountNotEqualTo(String value) {
			addCriterion("cash_account <>", value, "cashAccount");
			return (Criteria) this;
		}

		public Criteria andCashAccountGreaterThan(String value) {
			addCriterion("cash_account >", value, "cashAccount");
			return (Criteria) this;
		}

		public Criteria andCashAccountGreaterThanOrEqualTo(String value) {
			addCriterion("cash_account >=", value, "cashAccount");
			return (Criteria) this;
		}

		public Criteria andCashAccountLessThan(String value) {
			addCriterion("cash_account <", value, "cashAccount");
			return (Criteria) this;
		}

		public Criteria andCashAccountLessThanOrEqualTo(String value) {
			addCriterion("cash_account <=", value, "cashAccount");
			return (Criteria) this;
		}

		public Criteria andCashAccountLike(String value) {
			addCriterion("cash_account like", value, "cashAccount");
			return (Criteria) this;
		}

		public Criteria andCashAccountNotLike(String value) {
			addCriterion("cash_account not like", value, "cashAccount");
			return (Criteria) this;
		}

		public Criteria andCashAccountIn(List<String> values) {
			addCriterion("cash_account in", values, "cashAccount");
			return (Criteria) this;
		}

		public Criteria andCashAccountNotIn(List<String> values) {
			addCriterion("cash_account not in", values, "cashAccount");
			return (Criteria) this;
		}

		public Criteria andCashAccountBetween(String value1, String value2) {
			addCriterion("cash_account between", value1, value2, "cashAccount");
			return (Criteria) this;
		}

		public Criteria andCashAccountNotBetween(String value1, String value2) {
			addCriterion("cash_account not between", value1, value2, "cashAccount");
			return (Criteria) this;
		}

		public Criteria andCashAmountIsNull() {
			addCriterion("cash_amount is null");
			return (Criteria) this;
		}

		public Criteria andCashAmountIsNotNull() {
			addCriterion("cash_amount is not null");
			return (Criteria) this;
		}

		public Criteria andCashAmountEqualTo(BigDecimal value) {
			addCriterion("cash_amount =", value, "cashAmount");
			return (Criteria) this;
		}

		public Criteria andCashAmountNotEqualTo(BigDecimal value) {
			addCriterion("cash_amount <>", value, "cashAmount");
			return (Criteria) this;
		}

		public Criteria andCashAmountGreaterThan(BigDecimal value) {
			addCriterion("cash_amount >", value, "cashAmount");
			return (Criteria) this;
		}

		public Criteria andCashAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("cash_amount >=", value, "cashAmount");
			return (Criteria) this;
		}

		public Criteria andCashAmountLessThan(BigDecimal value) {
			addCriterion("cash_amount <", value, "cashAmount");
			return (Criteria) this;
		}

		public Criteria andCashAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("cash_amount <=", value, "cashAmount");
			return (Criteria) this;
		}

		public Criteria andCashAmountIn(List<BigDecimal> values) {
			addCriterion("cash_amount in", values, "cashAmount");
			return (Criteria) this;
		}

		public Criteria andCashAmountNotIn(List<BigDecimal> values) {
			addCriterion("cash_amount not in", values, "cashAmount");
			return (Criteria) this;
		}

		public Criteria andCashAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("cash_amount between", value1, value2, "cashAmount");
			return (Criteria) this;
		}

		public Criteria andCashAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("cash_amount not between", value1, value2, "cashAmount");
			return (Criteria) this;
		}

		public Criteria andCashBankIsNull() {
			addCriterion("cash_bank is null");
			return (Criteria) this;
		}

		public Criteria andCashBankIsNotNull() {
			addCriterion("cash_bank is not null");
			return (Criteria) this;
		}

		public Criteria andCashBankEqualTo(String value) {
			addCriterion("cash_bank =", value, "cashBank");
			return (Criteria) this;
		}

		public Criteria andCashBankNotEqualTo(String value) {
			addCriterion("cash_bank <>", value, "cashBank");
			return (Criteria) this;
		}

		public Criteria andCashBankGreaterThan(String value) {
			addCriterion("cash_bank >", value, "cashBank");
			return (Criteria) this;
		}

		public Criteria andCashBankGreaterThanOrEqualTo(String value) {
			addCriterion("cash_bank >=", value, "cashBank");
			return (Criteria) this;
		}

		public Criteria andCashBankLessThan(String value) {
			addCriterion("cash_bank <", value, "cashBank");
			return (Criteria) this;
		}

		public Criteria andCashBankLessThanOrEqualTo(String value) {
			addCriterion("cash_bank <=", value, "cashBank");
			return (Criteria) this;
		}

		public Criteria andCashBankLike(String value) {
			addCriterion("cash_bank like", value, "cashBank");
			return (Criteria) this;
		}

		public Criteria andCashBankNotLike(String value) {
			addCriterion("cash_bank not like", value, "cashBank");
			return (Criteria) this;
		}

		public Criteria andCashBankIn(List<String> values) {
			addCriterion("cash_bank in", values, "cashBank");
			return (Criteria) this;
		}

		public Criteria andCashBankNotIn(List<String> values) {
			addCriterion("cash_bank not in", values, "cashBank");
			return (Criteria) this;
		}

		public Criteria andCashBankBetween(String value1, String value2) {
			addCriterion("cash_bank between", value1, value2, "cashBank");
			return (Criteria) this;
		}

		public Criteria andCashBankNotBetween(String value1, String value2) {
			addCriterion("cash_bank not between", value1, value2, "cashBank");
			return (Criteria) this;
		}

		public Criteria andCashPayStatusIsNull() {
			addCriterion("cash_pay_status is null");
			return (Criteria) this;
		}

		public Criteria andCashPayStatusIsNotNull() {
			addCriterion("cash_pay_status is not null");
			return (Criteria) this;
		}

		public Criteria andCashPayStatusEqualTo(Integer value) {
			addCriterion("cash_pay_status =", value, "cashPayStatus");
			return (Criteria) this;
		}

		public Criteria andCashPayStatusNotEqualTo(Integer value) {
			addCriterion("cash_pay_status <>", value, "cashPayStatus");
			return (Criteria) this;
		}

		public Criteria andCashPayStatusGreaterThan(Integer value) {
			addCriterion("cash_pay_status >", value, "cashPayStatus");
			return (Criteria) this;
		}

		public Criteria andCashPayStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("cash_pay_status >=", value, "cashPayStatus");
			return (Criteria) this;
		}

		public Criteria andCashPayStatusLessThan(Integer value) {
			addCriterion("cash_pay_status <", value, "cashPayStatus");
			return (Criteria) this;
		}

		public Criteria andCashPayStatusLessThanOrEqualTo(Integer value) {
			addCriterion("cash_pay_status <=", value, "cashPayStatus");
			return (Criteria) this;
		}

		public Criteria andCashPayStatusIn(List<Integer> values) {
			addCriterion("cash_pay_status in", values, "cashPayStatus");
			return (Criteria) this;
		}

		public Criteria andCashPayStatusNotIn(List<Integer> values) {
			addCriterion("cash_pay_status not in", values, "cashPayStatus");
			return (Criteria) this;
		}

		public Criteria andCashPayStatusBetween(Integer value1, Integer value2) {
			addCriterion("cash_pay_status between", value1, value2, "cashPayStatus");
			return (Criteria) this;
		}

		public Criteria andCashPayStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("cash_pay_status not between", value1, value2, "cashPayStatus");
			return (Criteria) this;
		}

		public Criteria andCashPaymentIsNull() {
			addCriterion("cash_payment is null");
			return (Criteria) this;
		}

		public Criteria andCashPaymentIsNotNull() {
			addCriterion("cash_payment is not null");
			return (Criteria) this;
		}

		public Criteria andCashPaymentEqualTo(String value) {
			addCriterion("cash_payment =", value, "cashPayment");
			return (Criteria) this;
		}

		public Criteria andCashPaymentNotEqualTo(String value) {
			addCriterion("cash_payment <>", value, "cashPayment");
			return (Criteria) this;
		}

		public Criteria andCashPaymentGreaterThan(String value) {
			addCriterion("cash_payment >", value, "cashPayment");
			return (Criteria) this;
		}

		public Criteria andCashPaymentGreaterThanOrEqualTo(String value) {
			addCriterion("cash_payment >=", value, "cashPayment");
			return (Criteria) this;
		}

		public Criteria andCashPaymentLessThan(String value) {
			addCriterion("cash_payment <", value, "cashPayment");
			return (Criteria) this;
		}

		public Criteria andCashPaymentLessThanOrEqualTo(String value) {
			addCriterion("cash_payment <=", value, "cashPayment");
			return (Criteria) this;
		}

		public Criteria andCashPaymentLike(String value) {
			addCriterion("cash_payment like", value, "cashPayment");
			return (Criteria) this;
		}

		public Criteria andCashPaymentNotLike(String value) {
			addCriterion("cash_payment not like", value, "cashPayment");
			return (Criteria) this;
		}

		public Criteria andCashPaymentIn(List<String> values) {
			addCriterion("cash_payment in", values, "cashPayment");
			return (Criteria) this;
		}

		public Criteria andCashPaymentNotIn(List<String> values) {
			addCriterion("cash_payment not in", values, "cashPayment");
			return (Criteria) this;
		}

		public Criteria andCashPaymentBetween(String value1, String value2) {
			addCriterion("cash_payment between", value1, value2, "cashPayment");
			return (Criteria) this;
		}

		public Criteria andCashPaymentNotBetween(String value1, String value2) {
			addCriterion("cash_payment not between", value1, value2, "cashPayment");
			return (Criteria) this;
		}

		public Criteria andCashSnIsNull() {
			addCriterion("cash_sn is null");
			return (Criteria) this;
		}

		public Criteria andCashSnIsNotNull() {
			addCriterion("cash_sn is not null");
			return (Criteria) this;
		}

		public Criteria andCashSnEqualTo(String value) {
			addCriterion("cash_sn =", value, "cashSn");
			return (Criteria) this;
		}

		public Criteria andCashSnNotEqualTo(String value) {
			addCriterion("cash_sn <>", value, "cashSn");
			return (Criteria) this;
		}

		public Criteria andCashSnGreaterThan(String value) {
			addCriterion("cash_sn >", value, "cashSn");
			return (Criteria) this;
		}

		public Criteria andCashSnGreaterThanOrEqualTo(String value) {
			addCriterion("cash_sn >=", value, "cashSn");
			return (Criteria) this;
		}

		public Criteria andCashSnLessThan(String value) {
			addCriterion("cash_sn <", value, "cashSn");
			return (Criteria) this;
		}

		public Criteria andCashSnLessThanOrEqualTo(String value) {
			addCriterion("cash_sn <=", value, "cashSn");
			return (Criteria) this;
		}

		public Criteria andCashSnLike(String value) {
			addCriterion("cash_sn like", value, "cashSn");
			return (Criteria) this;
		}

		public Criteria andCashSnNotLike(String value) {
			addCriterion("cash_sn not like", value, "cashSn");
			return (Criteria) this;
		}

		public Criteria andCashSnIn(List<String> values) {
			addCriterion("cash_sn in", values, "cashSn");
			return (Criteria) this;
		}

		public Criteria andCashSnNotIn(List<String> values) {
			addCriterion("cash_sn not in", values, "cashSn");
			return (Criteria) this;
		}

		public Criteria andCashSnBetween(String value1, String value2) {
			addCriterion("cash_sn between", value1, value2, "cashSn");
			return (Criteria) this;
		}

		public Criteria andCashSnNotBetween(String value1, String value2) {
			addCriterion("cash_sn not between", value1, value2, "cashSn");
			return (Criteria) this;
		}

		public Criteria andCashStatusIsNull() {
			addCriterion("cash_status is null");
			return (Criteria) this;
		}

		public Criteria andCashStatusIsNotNull() {
			addCriterion("cash_status is not null");
			return (Criteria) this;
		}

		public Criteria andCashStatusEqualTo(Integer value) {
			addCriterion("cash_status =", value, "cashStatus");
			return (Criteria) this;
		}

		public Criteria andCashStatusNotEqualTo(Integer value) {
			addCriterion("cash_status <>", value, "cashStatus");
			return (Criteria) this;
		}

		public Criteria andCashStatusGreaterThan(Integer value) {
			addCriterion("cash_status >", value, "cashStatus");
			return (Criteria) this;
		}

		public Criteria andCashStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("cash_status >=", value, "cashStatus");
			return (Criteria) this;
		}

		public Criteria andCashStatusLessThan(Integer value) {
			addCriterion("cash_status <", value, "cashStatus");
			return (Criteria) this;
		}

		public Criteria andCashStatusLessThanOrEqualTo(Integer value) {
			addCriterion("cash_status <=", value, "cashStatus");
			return (Criteria) this;
		}

		public Criteria andCashStatusIn(List<Integer> values) {
			addCriterion("cash_status in", values, "cashStatus");
			return (Criteria) this;
		}

		public Criteria andCashStatusNotIn(List<Integer> values) {
			addCriterion("cash_status not in", values, "cashStatus");
			return (Criteria) this;
		}

		public Criteria andCashStatusBetween(Integer value1, Integer value2) {
			addCriterion("cash_status between", value1, value2, "cashStatus");
			return (Criteria) this;
		}

		public Criteria andCashStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("cash_status not between", value1, value2, "cashStatus");
			return (Criteria) this;
		}

		public Criteria andCashUserNameIsNull() {
			addCriterion("cash_user_name is null");
			return (Criteria) this;
		}

		public Criteria andCashUserNameIsNotNull() {
			addCriterion("cash_user_name is not null");
			return (Criteria) this;
		}

		public Criteria andCashUserNameEqualTo(String value) {
			addCriterion("cash_user_name =", value, "cashUserName");
			return (Criteria) this;
		}

		public Criteria andCashUserNameNotEqualTo(String value) {
			addCriterion("cash_user_name <>", value, "cashUserName");
			return (Criteria) this;
		}

		public Criteria andCashUserNameGreaterThan(String value) {
			addCriterion("cash_user_name >", value, "cashUserName");
			return (Criteria) this;
		}

		public Criteria andCashUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("cash_user_name >=", value, "cashUserName");
			return (Criteria) this;
		}

		public Criteria andCashUserNameLessThan(String value) {
			addCriterion("cash_user_name <", value, "cashUserName");
			return (Criteria) this;
		}

		public Criteria andCashUserNameLessThanOrEqualTo(String value) {
			addCriterion("cash_user_name <=", value, "cashUserName");
			return (Criteria) this;
		}

		public Criteria andCashUserNameLike(String value) {
			addCriterion("cash_user_name like", value, "cashUserName");
			return (Criteria) this;
		}

		public Criteria andCashUserNameNotLike(String value) {
			addCriterion("cash_user_name not like", value, "cashUserName");
			return (Criteria) this;
		}

		public Criteria andCashUserNameIn(List<String> values) {
			addCriterion("cash_user_name in", values, "cashUserName");
			return (Criteria) this;
		}

		public Criteria andCashUserNameNotIn(List<String> values) {
			addCriterion("cash_user_name not in", values, "cashUserName");
			return (Criteria) this;
		}

		public Criteria andCashUserNameBetween(String value1, String value2) {
			addCriterion("cash_user_name between", value1, value2, "cashUserName");
			return (Criteria) this;
		}

		public Criteria andCashUserNameNotBetween(String value1, String value2) {
			addCriterion("cash_user_name not between", value1, value2, "cashUserName");
			return (Criteria) this;
		}

		public Criteria andCashAdminIdIsNull() {
			addCriterion("cash_admin_id is null");
			return (Criteria) this;
		}

		public Criteria andCashAdminIdIsNotNull() {
			addCriterion("cash_admin_id is not null");
			return (Criteria) this;
		}

		public Criteria andCashAdminIdEqualTo(Long value) {
			addCriterion("cash_admin_id =", value, "cashAdminId");
			return (Criteria) this;
		}

		public Criteria andCashAdminIdNotEqualTo(Long value) {
			addCriterion("cash_admin_id <>", value, "cashAdminId");
			return (Criteria) this;
		}

		public Criteria andCashAdminIdGreaterThan(Long value) {
			addCriterion("cash_admin_id >", value, "cashAdminId");
			return (Criteria) this;
		}

		public Criteria andCashAdminIdGreaterThanOrEqualTo(Long value) {
			addCriterion("cash_admin_id >=", value, "cashAdminId");
			return (Criteria) this;
		}

		public Criteria andCashAdminIdLessThan(Long value) {
			addCriterion("cash_admin_id <", value, "cashAdminId");
			return (Criteria) this;
		}

		public Criteria andCashAdminIdLessThanOrEqualTo(Long value) {
			addCriterion("cash_admin_id <=", value, "cashAdminId");
			return (Criteria) this;
		}

		public Criteria andCashAdminIdIn(List<Long> values) {
			addCriterion("cash_admin_id in", values, "cashAdminId");
			return (Criteria) this;
		}

		public Criteria andCashAdminIdNotIn(List<Long> values) {
			addCriterion("cash_admin_id not in", values, "cashAdminId");
			return (Criteria) this;
		}

		public Criteria andCashAdminIdBetween(Long value1, Long value2) {
			addCriterion("cash_admin_id between", value1, value2, "cashAdminId");
			return (Criteria) this;
		}

		public Criteria andCashAdminIdNotBetween(Long value1, Long value2) {
			addCriterion("cash_admin_id not between", value1, value2, "cashAdminId");
			return (Criteria) this;
		}

		public Criteria andCashUserIdIsNull() {
			addCriterion("cash_user_id is null");
			return (Criteria) this;
		}

		public Criteria andCashUserIdIsNotNull() {
			addCriterion("cash_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andCashUserIdEqualTo(Long value) {
			addCriterion("cash_user_id =", value, "cashUserId");
			return (Criteria) this;
		}

		public Criteria andCashUserIdNotEqualTo(Long value) {
			addCriterion("cash_user_id <>", value, "cashUserId");
			return (Criteria) this;
		}

		public Criteria andCashUserIdGreaterThan(Long value) {
			addCriterion("cash_user_id >", value, "cashUserId");
			return (Criteria) this;
		}

		public Criteria andCashUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("cash_user_id >=", value, "cashUserId");
			return (Criteria) this;
		}

		public Criteria andCashUserIdLessThan(Long value) {
			addCriterion("cash_user_id <", value, "cashUserId");
			return (Criteria) this;
		}

		public Criteria andCashUserIdLessThanOrEqualTo(Long value) {
			addCriterion("cash_user_id <=", value, "cashUserId");
			return (Criteria) this;
		}

		public Criteria andCashUserIdIn(List<Long> values) {
			addCriterion("cash_user_id in", values, "cashUserId");
			return (Criteria) this;
		}

		public Criteria andCashUserIdNotIn(List<Long> values) {
			addCriterion("cash_user_id not in", values, "cashUserId");
			return (Criteria) this;
		}

		public Criteria andCashUserIdBetween(Long value1, Long value2) {
			addCriterion("cash_user_id between", value1, value2, "cashUserId");
			return (Criteria) this;
		}

		public Criteria andCashUserIdNotBetween(Long value1, Long value2) {
			addCriterion("cash_user_id not between", value1, value2, "cashUserId");
			return (Criteria) this;
		}

		public Criteria andCashSubbranchIsNull() {
			addCriterion("cash_subbranch is null");
			return (Criteria) this;
		}

		public Criteria andCashSubbranchIsNotNull() {
			addCriterion("cash_subbranch is not null");
			return (Criteria) this;
		}

		public Criteria andCashSubbranchEqualTo(String value) {
			addCriterion("cash_subbranch =", value, "cashSubbranch");
			return (Criteria) this;
		}

		public Criteria andCashSubbranchNotEqualTo(String value) {
			addCriterion("cash_subbranch <>", value, "cashSubbranch");
			return (Criteria) this;
		}

		public Criteria andCashSubbranchGreaterThan(String value) {
			addCriterion("cash_subbranch >", value, "cashSubbranch");
			return (Criteria) this;
		}

		public Criteria andCashSubbranchGreaterThanOrEqualTo(String value) {
			addCriterion("cash_subbranch >=", value, "cashSubbranch");
			return (Criteria) this;
		}

		public Criteria andCashSubbranchLessThan(String value) {
			addCriterion("cash_subbranch <", value, "cashSubbranch");
			return (Criteria) this;
		}

		public Criteria andCashSubbranchLessThanOrEqualTo(String value) {
			addCriterion("cash_subbranch <=", value, "cashSubbranch");
			return (Criteria) this;
		}

		public Criteria andCashSubbranchLike(String value) {
			addCriterion("cash_subbranch like", value, "cashSubbranch");
			return (Criteria) this;
		}

		public Criteria andCashSubbranchNotLike(String value) {
			addCriterion("cash_subbranch not like", value, "cashSubbranch");
			return (Criteria) this;
		}

		public Criteria andCashSubbranchIn(List<String> values) {
			addCriterion("cash_subbranch in", values, "cashSubbranch");
			return (Criteria) this;
		}

		public Criteria andCashSubbranchNotIn(List<String> values) {
			addCriterion("cash_subbranch not in", values, "cashSubbranch");
			return (Criteria) this;
		}

		public Criteria andCashSubbranchBetween(String value1, String value2) {
			addCriterion("cash_subbranch between", value1, value2, "cashSubbranch");
			return (Criteria) this;
		}

		public Criteria andCashSubbranchNotBetween(String value1, String value2) {
			addCriterion("cash_subbranch not between", value1, value2, "cashSubbranch");
			return (Criteria) this;
		}

		public Criteria andCashRelationIsNull() {
			addCriterion("cash_relation is null");
			return (Criteria) this;
		}

		public Criteria andCashRelationIsNotNull() {
			addCriterion("cash_relation is not null");
			return (Criteria) this;
		}

		public Criteria andCashRelationEqualTo(Integer value) {
			addCriterion("cash_relation =", value, "cashRelation");
			return (Criteria) this;
		}

		public Criteria andCashRelationNotEqualTo(Integer value) {
			addCriterion("cash_relation <>", value, "cashRelation");
			return (Criteria) this;
		}

		public Criteria andCashRelationGreaterThan(Integer value) {
			addCriterion("cash_relation >", value, "cashRelation");
			return (Criteria) this;
		}

		public Criteria andCashRelationGreaterThanOrEqualTo(Integer value) {
			addCriterion("cash_relation >=", value, "cashRelation");
			return (Criteria) this;
		}

		public Criteria andCashRelationLessThan(Integer value) {
			addCriterion("cash_relation <", value, "cashRelation");
			return (Criteria) this;
		}

		public Criteria andCashRelationLessThanOrEqualTo(Integer value) {
			addCriterion("cash_relation <=", value, "cashRelation");
			return (Criteria) this;
		}

		public Criteria andCashRelationIn(List<Integer> values) {
			addCriterion("cash_relation in", values, "cashRelation");
			return (Criteria) this;
		}

		public Criteria andCashRelationNotIn(List<Integer> values) {
			addCriterion("cash_relation not in", values, "cashRelation");
			return (Criteria) this;
		}

		public Criteria andCashRelationBetween(Integer value1, Integer value2) {
			addCriterion("cash_relation between", value1, value2, "cashRelation");
			return (Criteria) this;
		}

		public Criteria andCashRelationNotBetween(Integer value1, Integer value2) {
			addCriterion("cash_relation not between", value1, value2, "cashRelation");
			return (Criteria) this;
		}

		public Criteria andUserCodeIsNull() {
			addCriterion("user_code is null");
			return (Criteria) this;
		}

		public Criteria andUserCodeIsNotNull() {
			addCriterion("user_code is not null");
			return (Criteria) this;
		}

		public Criteria andUserCodeEqualTo(Integer value) {
			addCriterion("user_code =", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeNotEqualTo(Integer value) {
			addCriterion("user_code <>", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeGreaterThan(Integer value) {
			addCriterion("user_code >", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeGreaterThanOrEqualTo(Integer value) {
			addCriterion("user_code >=", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeLessThan(Integer value) {
			addCriterion("user_code <", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeLessThanOrEqualTo(Integer value) {
			addCriterion("user_code <=", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeIn(List<Integer> values) {
			addCriterion("user_code in", values, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeNotIn(List<Integer> values) {
			addCriterion("user_code not in", values, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeBetween(Integer value1, Integer value2) {
			addCriterion("user_code between", value1, value2, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeNotBetween(Integer value1, Integer value2) {
			addCriterion("user_code not between", value1, value2, "userCode");
			return (Criteria) this;
		}

		public Criteria andCashPoundageIsNull() {
			addCriterion("cash_poundage is null");
			return (Criteria) this;
		}

		public Criteria andCashPoundageIsNotNull() {
			addCriterion("cash_poundage is not null");
			return (Criteria) this;
		}

		public Criteria andCashPoundageEqualTo(BigDecimal value) {
			addCriterion("cash_poundage =", value, "cashPoundage");
			return (Criteria) this;
		}

		public Criteria andCashPoundageNotEqualTo(BigDecimal value) {
			addCriterion("cash_poundage <>", value, "cashPoundage");
			return (Criteria) this;
		}

		public Criteria andCashPoundageGreaterThan(BigDecimal value) {
			addCriterion("cash_poundage >", value, "cashPoundage");
			return (Criteria) this;
		}

		public Criteria andCashPoundageGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("cash_poundage >=", value, "cashPoundage");
			return (Criteria) this;
		}

		public Criteria andCashPoundageLessThan(BigDecimal value) {
			addCriterion("cash_poundage <", value, "cashPoundage");
			return (Criteria) this;
		}

		public Criteria andCashPoundageLessThanOrEqualTo(BigDecimal value) {
			addCriterion("cash_poundage <=", value, "cashPoundage");
			return (Criteria) this;
		}

		public Criteria andCashPoundageIn(List<BigDecimal> values) {
			addCriterion("cash_poundage in", values, "cashPoundage");
			return (Criteria) this;
		}

		public Criteria andCashPoundageNotIn(List<BigDecimal> values) {
			addCriterion("cash_poundage not in", values, "cashPoundage");
			return (Criteria) this;
		}

		public Criteria andCashPoundageBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("cash_poundage between", value1, value2, "cashPoundage");
			return (Criteria) this;
		}

		public Criteria andCashPoundageNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("cash_poundage not between", value1, value2, "cashPoundage");
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