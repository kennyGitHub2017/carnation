package com.sinco.carnation.store.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StoreExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public StoreExample() {
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
			addCriterion("add_Time is null");
			return (Criteria) this;
		}

		public Criteria andAddTimeIsNotNull() {
			addCriterion("add_Time is not null");
			return (Criteria) this;
		}

		public Criteria andAddTimeEqualTo(Date value) {
			addCriterion("add_Time =", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeNotEqualTo(Date value) {
			addCriterion("add_Time <>", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeGreaterThan(Date value) {
			addCriterion("add_Time >", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("add_Time >=", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeLessThan(Date value) {
			addCriterion("add_Time <", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeLessThanOrEqualTo(Date value) {
			addCriterion("add_Time <=", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeIn(List<Date> values) {
			addCriterion("add_Time in", values, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeNotIn(List<Date> values) {
			addCriterion("add_Time not in", values, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeBetween(Date value1, Date value2) {
			addCriterion("add_Time between", value1, value2, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeNotBetween(Date value1, Date value2) {
			addCriterion("add_Time not between", value1, value2, "addTime");
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

		public Criteria andBankAccountNameIsNull() {
			addCriterion("bank_account_name is null");
			return (Criteria) this;
		}

		public Criteria andBankAccountNameIsNotNull() {
			addCriterion("bank_account_name is not null");
			return (Criteria) this;
		}

		public Criteria andBankAccountNameEqualTo(String value) {
			addCriterion("bank_account_name =", value, "bankAccountName");
			return (Criteria) this;
		}

		public Criteria andBankAccountNameNotEqualTo(String value) {
			addCriterion("bank_account_name <>", value, "bankAccountName");
			return (Criteria) this;
		}

		public Criteria andBankAccountNameGreaterThan(String value) {
			addCriterion("bank_account_name >", value, "bankAccountName");
			return (Criteria) this;
		}

		public Criteria andBankAccountNameGreaterThanOrEqualTo(String value) {
			addCriterion("bank_account_name >=", value, "bankAccountName");
			return (Criteria) this;
		}

		public Criteria andBankAccountNameLessThan(String value) {
			addCriterion("bank_account_name <", value, "bankAccountName");
			return (Criteria) this;
		}

		public Criteria andBankAccountNameLessThanOrEqualTo(String value) {
			addCriterion("bank_account_name <=", value, "bankAccountName");
			return (Criteria) this;
		}

		public Criteria andBankAccountNameLike(String value) {
			addCriterion("bank_account_name like", value, "bankAccountName");
			return (Criteria) this;
		}

		public Criteria andBankAccountNameNotLike(String value) {
			addCriterion("bank_account_name not like", value, "bankAccountName");
			return (Criteria) this;
		}

		public Criteria andBankAccountNameIn(List<String> values) {
			addCriterion("bank_account_name in", values, "bankAccountName");
			return (Criteria) this;
		}

		public Criteria andBankAccountNameNotIn(List<String> values) {
			addCriterion("bank_account_name not in", values, "bankAccountName");
			return (Criteria) this;
		}

		public Criteria andBankAccountNameBetween(String value1, String value2) {
			addCriterion("bank_account_name between", value1, value2, "bankAccountName");
			return (Criteria) this;
		}

		public Criteria andBankAccountNameNotBetween(String value1, String value2) {
			addCriterion("bank_account_name not between", value1, value2, "bankAccountName");
			return (Criteria) this;
		}

		public Criteria andBankCAccountIsNull() {
			addCriterion("bank_c_account is null");
			return (Criteria) this;
		}

		public Criteria andBankCAccountIsNotNull() {
			addCriterion("bank_c_account is not null");
			return (Criteria) this;
		}

		public Criteria andBankCAccountEqualTo(String value) {
			addCriterion("bank_c_account =", value, "bankCAccount");
			return (Criteria) this;
		}

		public Criteria andBankCAccountNotEqualTo(String value) {
			addCriterion("bank_c_account <>", value, "bankCAccount");
			return (Criteria) this;
		}

		public Criteria andBankCAccountGreaterThan(String value) {
			addCriterion("bank_c_account >", value, "bankCAccount");
			return (Criteria) this;
		}

		public Criteria andBankCAccountGreaterThanOrEqualTo(String value) {
			addCriterion("bank_c_account >=", value, "bankCAccount");
			return (Criteria) this;
		}

		public Criteria andBankCAccountLessThan(String value) {
			addCriterion("bank_c_account <", value, "bankCAccount");
			return (Criteria) this;
		}

		public Criteria andBankCAccountLessThanOrEqualTo(String value) {
			addCriterion("bank_c_account <=", value, "bankCAccount");
			return (Criteria) this;
		}

		public Criteria andBankCAccountLike(String value) {
			addCriterion("bank_c_account like", value, "bankCAccount");
			return (Criteria) this;
		}

		public Criteria andBankCAccountNotLike(String value) {
			addCriterion("bank_c_account not like", value, "bankCAccount");
			return (Criteria) this;
		}

		public Criteria andBankCAccountIn(List<String> values) {
			addCriterion("bank_c_account in", values, "bankCAccount");
			return (Criteria) this;
		}

		public Criteria andBankCAccountNotIn(List<String> values) {
			addCriterion("bank_c_account not in", values, "bankCAccount");
			return (Criteria) this;
		}

		public Criteria andBankCAccountBetween(String value1, String value2) {
			addCriterion("bank_c_account between", value1, value2, "bankCAccount");
			return (Criteria) this;
		}

		public Criteria andBankCAccountNotBetween(String value1, String value2) {
			addCriterion("bank_c_account not between", value1, value2, "bankCAccount");
			return (Criteria) this;
		}

		public Criteria andBankLineNumIsNull() {
			addCriterion("bank_line_num is null");
			return (Criteria) this;
		}

		public Criteria andBankLineNumIsNotNull() {
			addCriterion("bank_line_num is not null");
			return (Criteria) this;
		}

		public Criteria andBankLineNumEqualTo(String value) {
			addCriterion("bank_line_num =", value, "bankLineNum");
			return (Criteria) this;
		}

		public Criteria andBankLineNumNotEqualTo(String value) {
			addCriterion("bank_line_num <>", value, "bankLineNum");
			return (Criteria) this;
		}

		public Criteria andBankLineNumGreaterThan(String value) {
			addCriterion("bank_line_num >", value, "bankLineNum");
			return (Criteria) this;
		}

		public Criteria andBankLineNumGreaterThanOrEqualTo(String value) {
			addCriterion("bank_line_num >=", value, "bankLineNum");
			return (Criteria) this;
		}

		public Criteria andBankLineNumLessThan(String value) {
			addCriterion("bank_line_num <", value, "bankLineNum");
			return (Criteria) this;
		}

		public Criteria andBankLineNumLessThanOrEqualTo(String value) {
			addCriterion("bank_line_num <=", value, "bankLineNum");
			return (Criteria) this;
		}

		public Criteria andBankLineNumLike(String value) {
			addCriterion("bank_line_num like", value, "bankLineNum");
			return (Criteria) this;
		}

		public Criteria andBankLineNumNotLike(String value) {
			addCriterion("bank_line_num not like", value, "bankLineNum");
			return (Criteria) this;
		}

		public Criteria andBankLineNumIn(List<String> values) {
			addCriterion("bank_line_num in", values, "bankLineNum");
			return (Criteria) this;
		}

		public Criteria andBankLineNumNotIn(List<String> values) {
			addCriterion("bank_line_num not in", values, "bankLineNum");
			return (Criteria) this;
		}

		public Criteria andBankLineNumBetween(String value1, String value2) {
			addCriterion("bank_line_num between", value1, value2, "bankLineNum");
			return (Criteria) this;
		}

		public Criteria andBankLineNumNotBetween(String value1, String value2) {
			addCriterion("bank_line_num not between", value1, value2, "bankLineNum");
			return (Criteria) this;
		}

		public Criteria andBankNameIsNull() {
			addCriterion("bank_name is null");
			return (Criteria) this;
		}

		public Criteria andBankNameIsNotNull() {
			addCriterion("bank_name is not null");
			return (Criteria) this;
		}

		public Criteria andBankNameEqualTo(String value) {
			addCriterion("bank_name =", value, "bankName");
			return (Criteria) this;
		}

		public Criteria andBankNameNotEqualTo(String value) {
			addCriterion("bank_name <>", value, "bankName");
			return (Criteria) this;
		}

		public Criteria andBankNameGreaterThan(String value) {
			addCriterion("bank_name >", value, "bankName");
			return (Criteria) this;
		}

		public Criteria andBankNameGreaterThanOrEqualTo(String value) {
			addCriterion("bank_name >=", value, "bankName");
			return (Criteria) this;
		}

		public Criteria andBankNameLessThan(String value) {
			addCriterion("bank_name <", value, "bankName");
			return (Criteria) this;
		}

		public Criteria andBankNameLessThanOrEqualTo(String value) {
			addCriterion("bank_name <=", value, "bankName");
			return (Criteria) this;
		}

		public Criteria andBankNameLike(String value) {
			addCriterion("bank_name like", value, "bankName");
			return (Criteria) this;
		}

		public Criteria andBankNameNotLike(String value) {
			addCriterion("bank_name not like", value, "bankName");
			return (Criteria) this;
		}

		public Criteria andBankNameIn(List<String> values) {
			addCriterion("bank_name in", values, "bankName");
			return (Criteria) this;
		}

		public Criteria andBankNameNotIn(List<String> values) {
			addCriterion("bank_name not in", values, "bankName");
			return (Criteria) this;
		}

		public Criteria andBankNameBetween(String value1, String value2) {
			addCriterion("bank_name between", value1, value2, "bankName");
			return (Criteria) this;
		}

		public Criteria andBankNameNotBetween(String value1, String value2) {
			addCriterion("bank_name not between", value1, value2, "bankName");
			return (Criteria) this;
		}

		public Criteria andBuygiftMealEndTimeIsNull() {
			addCriterion("buygift_meal_end_Time is null");
			return (Criteria) this;
		}

		public Criteria andBuygiftMealEndTimeIsNotNull() {
			addCriterion("buygift_meal_end_Time is not null");
			return (Criteria) this;
		}

		public Criteria andBuygiftMealEndTimeEqualTo(Date value) {
			addCriterion("buygift_meal_end_Time =", value, "buygiftMealEndTime");
			return (Criteria) this;
		}

		public Criteria andBuygiftMealEndTimeNotEqualTo(Date value) {
			addCriterion("buygift_meal_end_Time <>", value, "buygiftMealEndTime");
			return (Criteria) this;
		}

		public Criteria andBuygiftMealEndTimeGreaterThan(Date value) {
			addCriterion("buygift_meal_end_Time >", value, "buygiftMealEndTime");
			return (Criteria) this;
		}

		public Criteria andBuygiftMealEndTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("buygift_meal_end_Time >=", value, "buygiftMealEndTime");
			return (Criteria) this;
		}

		public Criteria andBuygiftMealEndTimeLessThan(Date value) {
			addCriterion("buygift_meal_end_Time <", value, "buygiftMealEndTime");
			return (Criteria) this;
		}

		public Criteria andBuygiftMealEndTimeLessThanOrEqualTo(Date value) {
			addCriterion("buygift_meal_end_Time <=", value, "buygiftMealEndTime");
			return (Criteria) this;
		}

		public Criteria andBuygiftMealEndTimeIn(List<Date> values) {
			addCriterion("buygift_meal_end_Time in", values, "buygiftMealEndTime");
			return (Criteria) this;
		}

		public Criteria andBuygiftMealEndTimeNotIn(List<Date> values) {
			addCriterion("buygift_meal_end_Time not in", values, "buygiftMealEndTime");
			return (Criteria) this;
		}

		public Criteria andBuygiftMealEndTimeBetween(Date value1, Date value2) {
			addCriterion("buygift_meal_end_Time between", value1, value2, "buygiftMealEndTime");
			return (Criteria) this;
		}

		public Criteria andBuygiftMealEndTimeNotBetween(Date value1, Date value2) {
			addCriterion("buygift_meal_end_Time not between", value1, value2, "buygiftMealEndTime");
			return (Criteria) this;
		}

		public Criteria andCombinEndTimeIsNull() {
			addCriterion("combin_end_time is null");
			return (Criteria) this;
		}

		public Criteria andCombinEndTimeIsNotNull() {
			addCriterion("combin_end_time is not null");
			return (Criteria) this;
		}

		public Criteria andCombinEndTimeEqualTo(Date value) {
			addCriterion("combin_end_time =", value, "combinEndTime");
			return (Criteria) this;
		}

		public Criteria andCombinEndTimeNotEqualTo(Date value) {
			addCriterion("combin_end_time <>", value, "combinEndTime");
			return (Criteria) this;
		}

		public Criteria andCombinEndTimeGreaterThan(Date value) {
			addCriterion("combin_end_time >", value, "combinEndTime");
			return (Criteria) this;
		}

		public Criteria andCombinEndTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("combin_end_time >=", value, "combinEndTime");
			return (Criteria) this;
		}

		public Criteria andCombinEndTimeLessThan(Date value) {
			addCriterion("combin_end_time <", value, "combinEndTime");
			return (Criteria) this;
		}

		public Criteria andCombinEndTimeLessThanOrEqualTo(Date value) {
			addCriterion("combin_end_time <=", value, "combinEndTime");
			return (Criteria) this;
		}

		public Criteria andCombinEndTimeIn(List<Date> values) {
			addCriterion("combin_end_time in", values, "combinEndTime");
			return (Criteria) this;
		}

		public Criteria andCombinEndTimeNotIn(List<Date> values) {
			addCriterion("combin_end_time not in", values, "combinEndTime");
			return (Criteria) this;
		}

		public Criteria andCombinEndTimeBetween(Date value1, Date value2) {
			addCriterion("combin_end_time between", value1, value2, "combinEndTime");
			return (Criteria) this;
		}

		public Criteria andCombinEndTimeNotBetween(Date value1, Date value2) {
			addCriterion("combin_end_time not between", value1, value2, "combinEndTime");
			return (Criteria) this;
		}

		public Criteria andDomainModifyCountIsNull() {
			addCriterion("domain_modify_count is null");
			return (Criteria) this;
		}

		public Criteria andDomainModifyCountIsNotNull() {
			addCriterion("domain_modify_count is not null");
			return (Criteria) this;
		}

		public Criteria andDomainModifyCountEqualTo(Integer value) {
			addCriterion("domain_modify_count =", value, "domainModifyCount");
			return (Criteria) this;
		}

		public Criteria andDomainModifyCountNotEqualTo(Integer value) {
			addCriterion("domain_modify_count <>", value, "domainModifyCount");
			return (Criteria) this;
		}

		public Criteria andDomainModifyCountGreaterThan(Integer value) {
			addCriterion("domain_modify_count >", value, "domainModifyCount");
			return (Criteria) this;
		}

		public Criteria andDomainModifyCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("domain_modify_count >=", value, "domainModifyCount");
			return (Criteria) this;
		}

		public Criteria andDomainModifyCountLessThan(Integer value) {
			addCriterion("domain_modify_count <", value, "domainModifyCount");
			return (Criteria) this;
		}

		public Criteria andDomainModifyCountLessThanOrEqualTo(Integer value) {
			addCriterion("domain_modify_count <=", value, "domainModifyCount");
			return (Criteria) this;
		}

		public Criteria andDomainModifyCountIn(List<Integer> values) {
			addCriterion("domain_modify_count in", values, "domainModifyCount");
			return (Criteria) this;
		}

		public Criteria andDomainModifyCountNotIn(List<Integer> values) {
			addCriterion("domain_modify_count not in", values, "domainModifyCount");
			return (Criteria) this;
		}

		public Criteria andDomainModifyCountBetween(Integer value1, Integer value2) {
			addCriterion("domain_modify_count between", value1, value2, "domainModifyCount");
			return (Criteria) this;
		}

		public Criteria andDomainModifyCountNotBetween(Integer value1, Integer value2) {
			addCriterion("domain_modify_count not between", value1, value2, "domainModifyCount");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMealEndTimeIsNull() {
			addCriterion("enoughreduce_meal_end_Time is null");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMealEndTimeIsNotNull() {
			addCriterion("enoughreduce_meal_end_Time is not null");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMealEndTimeEqualTo(Date value) {
			addCriterion("enoughreduce_meal_end_Time =", value, "enoughreduceMealEndTime");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMealEndTimeNotEqualTo(Date value) {
			addCriterion("enoughreduce_meal_end_Time <>", value, "enoughreduceMealEndTime");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMealEndTimeGreaterThan(Date value) {
			addCriterion("enoughreduce_meal_end_Time >", value, "enoughreduceMealEndTime");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMealEndTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("enoughreduce_meal_end_Time >=", value, "enoughreduceMealEndTime");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMealEndTimeLessThan(Date value) {
			addCriterion("enoughreduce_meal_end_Time <", value, "enoughreduceMealEndTime");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMealEndTimeLessThanOrEqualTo(Date value) {
			addCriterion("enoughreduce_meal_end_Time <=", value, "enoughreduceMealEndTime");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMealEndTimeIn(List<Date> values) {
			addCriterion("enoughreduce_meal_end_Time in", values, "enoughreduceMealEndTime");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMealEndTimeNotIn(List<Date> values) {
			addCriterion("enoughreduce_meal_end_Time not in", values, "enoughreduceMealEndTime");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMealEndTimeBetween(Date value1, Date value2) {
			addCriterion("enoughreduce_meal_end_Time between", value1, value2, "enoughreduceMealEndTime");
			return (Criteria) this;
		}

		public Criteria andEnoughreduceMealEndTimeNotBetween(Date value1, Date value2) {
			addCriterion("enoughreduce_meal_end_Time not between", value1, value2, "enoughreduceMealEndTime");
			return (Criteria) this;
		}

		public Criteria andFavoriteCountIsNull() {
			addCriterion("favorite_count is null");
			return (Criteria) this;
		}

		public Criteria andFavoriteCountIsNotNull() {
			addCriterion("favorite_count is not null");
			return (Criteria) this;
		}

		public Criteria andFavoriteCountEqualTo(Integer value) {
			addCriterion("favorite_count =", value, "favoriteCount");
			return (Criteria) this;
		}

		public Criteria andFavoriteCountNotEqualTo(Integer value) {
			addCriterion("favorite_count <>", value, "favoriteCount");
			return (Criteria) this;
		}

		public Criteria andFavoriteCountGreaterThan(Integer value) {
			addCriterion("favorite_count >", value, "favoriteCount");
			return (Criteria) this;
		}

		public Criteria andFavoriteCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("favorite_count >=", value, "favoriteCount");
			return (Criteria) this;
		}

		public Criteria andFavoriteCountLessThan(Integer value) {
			addCriterion("favorite_count <", value, "favoriteCount");
			return (Criteria) this;
		}

		public Criteria andFavoriteCountLessThanOrEqualTo(Integer value) {
			addCriterion("favorite_count <=", value, "favoriteCount");
			return (Criteria) this;
		}

		public Criteria andFavoriteCountIn(List<Integer> values) {
			addCriterion("favorite_count in", values, "favoriteCount");
			return (Criteria) this;
		}

		public Criteria andFavoriteCountNotIn(List<Integer> values) {
			addCriterion("favorite_count not in", values, "favoriteCount");
			return (Criteria) this;
		}

		public Criteria andFavoriteCountBetween(Integer value1, Integer value2) {
			addCriterion("favorite_count between", value1, value2, "favoriteCount");
			return (Criteria) this;
		}

		public Criteria andFavoriteCountNotBetween(Integer value1, Integer value2) {
			addCriterion("favorite_count not between", value1, value2, "favoriteCount");
			return (Criteria) this;
		}

		public Criteria andGcMainIdIsNull() {
			addCriterion("gc_main_id is null");
			return (Criteria) this;
		}

		public Criteria andGcMainIdIsNotNull() {
			addCriterion("gc_main_id is not null");
			return (Criteria) this;
		}

		public Criteria andGcMainIdEqualTo(Long value) {
			addCriterion("gc_main_id =", value, "gcMainId");
			return (Criteria) this;
		}

		public Criteria andGcMainIdNotEqualTo(Long value) {
			addCriterion("gc_main_id <>", value, "gcMainId");
			return (Criteria) this;
		}

		public Criteria andGcMainIdGreaterThan(Long value) {
			addCriterion("gc_main_id >", value, "gcMainId");
			return (Criteria) this;
		}

		public Criteria andGcMainIdGreaterThanOrEqualTo(Long value) {
			addCriterion("gc_main_id >=", value, "gcMainId");
			return (Criteria) this;
		}

		public Criteria andGcMainIdLessThan(Long value) {
			addCriterion("gc_main_id <", value, "gcMainId");
			return (Criteria) this;
		}

		public Criteria andGcMainIdLessThanOrEqualTo(Long value) {
			addCriterion("gc_main_id <=", value, "gcMainId");
			return (Criteria) this;
		}

		public Criteria andGcMainIdIn(List<Long> values) {
			addCriterion("gc_main_id in", values, "gcMainId");
			return (Criteria) this;
		}

		public Criteria andGcMainIdNotIn(List<Long> values) {
			addCriterion("gc_main_id not in", values, "gcMainId");
			return (Criteria) this;
		}

		public Criteria andGcMainIdBetween(Long value1, Long value2) {
			addCriterion("gc_main_id between", value1, value2, "gcMainId");
			return (Criteria) this;
		}

		public Criteria andGcMainIdNotBetween(Long value1, Long value2) {
			addCriterion("gc_main_id not between", value1, value2, "gcMainId");
			return (Criteria) this;
		}

		public Criteria andGroupMealEndTimeIsNull() {
			addCriterion("group_meal_end_Time is null");
			return (Criteria) this;
		}

		public Criteria andGroupMealEndTimeIsNotNull() {
			addCriterion("group_meal_end_Time is not null");
			return (Criteria) this;
		}

		public Criteria andGroupMealEndTimeEqualTo(Date value) {
			addCriterion("group_meal_end_Time =", value, "groupMealEndTime");
			return (Criteria) this;
		}

		public Criteria andGroupMealEndTimeNotEqualTo(Date value) {
			addCriterion("group_meal_end_Time <>", value, "groupMealEndTime");
			return (Criteria) this;
		}

		public Criteria andGroupMealEndTimeGreaterThan(Date value) {
			addCriterion("group_meal_end_Time >", value, "groupMealEndTime");
			return (Criteria) this;
		}

		public Criteria andGroupMealEndTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("group_meal_end_Time >=", value, "groupMealEndTime");
			return (Criteria) this;
		}

		public Criteria andGroupMealEndTimeLessThan(Date value) {
			addCriterion("group_meal_end_Time <", value, "groupMealEndTime");
			return (Criteria) this;
		}

		public Criteria andGroupMealEndTimeLessThanOrEqualTo(Date value) {
			addCriterion("group_meal_end_Time <=", value, "groupMealEndTime");
			return (Criteria) this;
		}

		public Criteria andGroupMealEndTimeIn(List<Date> values) {
			addCriterion("group_meal_end_Time in", values, "groupMealEndTime");
			return (Criteria) this;
		}

		public Criteria andGroupMealEndTimeNotIn(List<Date> values) {
			addCriterion("group_meal_end_Time not in", values, "groupMealEndTime");
			return (Criteria) this;
		}

		public Criteria andGroupMealEndTimeBetween(Date value1, Date value2) {
			addCriterion("group_meal_end_Time between", value1, value2, "groupMealEndTime");
			return (Criteria) this;
		}

		public Criteria andGroupMealEndTimeNotBetween(Date value1, Date value2) {
			addCriterion("group_meal_end_Time not between", value1, value2, "groupMealEndTime");
			return (Criteria) this;
		}

		public Criteria andOrganizationCodeIsNull() {
			addCriterion("organization_code is null");
			return (Criteria) this;
		}

		public Criteria andOrganizationCodeIsNotNull() {
			addCriterion("organization_code is not null");
			return (Criteria) this;
		}

		public Criteria andOrganizationCodeEqualTo(String value) {
			addCriterion("organization_code =", value, "organizationCode");
			return (Criteria) this;
		}

		public Criteria andOrganizationCodeNotEqualTo(String value) {
			addCriterion("organization_code <>", value, "organizationCode");
			return (Criteria) this;
		}

		public Criteria andOrganizationCodeGreaterThan(String value) {
			addCriterion("organization_code >", value, "organizationCode");
			return (Criteria) this;
		}

		public Criteria andOrganizationCodeGreaterThanOrEqualTo(String value) {
			addCriterion("organization_code >=", value, "organizationCode");
			return (Criteria) this;
		}

		public Criteria andOrganizationCodeLessThan(String value) {
			addCriterion("organization_code <", value, "organizationCode");
			return (Criteria) this;
		}

		public Criteria andOrganizationCodeLessThanOrEqualTo(String value) {
			addCriterion("organization_code <=", value, "organizationCode");
			return (Criteria) this;
		}

		public Criteria andOrganizationCodeLike(String value) {
			addCriterion("organization_code like", value, "organizationCode");
			return (Criteria) this;
		}

		public Criteria andOrganizationCodeNotLike(String value) {
			addCriterion("organization_code not like", value, "organizationCode");
			return (Criteria) this;
		}

		public Criteria andOrganizationCodeIn(List<String> values) {
			addCriterion("organization_code in", values, "organizationCode");
			return (Criteria) this;
		}

		public Criteria andOrganizationCodeNotIn(List<String> values) {
			addCriterion("organization_code not in", values, "organizationCode");
			return (Criteria) this;
		}

		public Criteria andOrganizationCodeBetween(String value1, String value2) {
			addCriterion("organization_code between", value1, value2, "organizationCode");
			return (Criteria) this;
		}

		public Criteria andOrganizationCodeNotBetween(String value1, String value2) {
			addCriterion("organization_code not between", value1, value2, "organizationCode");
			return (Criteria) this;
		}

		public Criteria andSendEmailCountIsNull() {
			addCriterion("send_email_count is null");
			return (Criteria) this;
		}

		public Criteria andSendEmailCountIsNotNull() {
			addCriterion("send_email_count is not null");
			return (Criteria) this;
		}

		public Criteria andSendEmailCountEqualTo(Integer value) {
			addCriterion("send_email_count =", value, "sendEmailCount");
			return (Criteria) this;
		}

		public Criteria andSendEmailCountNotEqualTo(Integer value) {
			addCriterion("send_email_count <>", value, "sendEmailCount");
			return (Criteria) this;
		}

		public Criteria andSendEmailCountGreaterThan(Integer value) {
			addCriterion("send_email_count >", value, "sendEmailCount");
			return (Criteria) this;
		}

		public Criteria andSendEmailCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("send_email_count >=", value, "sendEmailCount");
			return (Criteria) this;
		}

		public Criteria andSendEmailCountLessThan(Integer value) {
			addCriterion("send_email_count <", value, "sendEmailCount");
			return (Criteria) this;
		}

		public Criteria andSendEmailCountLessThanOrEqualTo(Integer value) {
			addCriterion("send_email_count <=", value, "sendEmailCount");
			return (Criteria) this;
		}

		public Criteria andSendEmailCountIn(List<Integer> values) {
			addCriterion("send_email_count in", values, "sendEmailCount");
			return (Criteria) this;
		}

		public Criteria andSendEmailCountNotIn(List<Integer> values) {
			addCriterion("send_email_count not in", values, "sendEmailCount");
			return (Criteria) this;
		}

		public Criteria andSendEmailCountBetween(Integer value1, Integer value2) {
			addCriterion("send_email_count between", value1, value2, "sendEmailCount");
			return (Criteria) this;
		}

		public Criteria andSendEmailCountNotBetween(Integer value1, Integer value2) {
			addCriterion("send_email_count not between", value1, value2, "sendEmailCount");
			return (Criteria) this;
		}

		public Criteria andSendSmsCountIsNull() {
			addCriterion("send_sms_count is null");
			return (Criteria) this;
		}

		public Criteria andSendSmsCountIsNotNull() {
			addCriterion("send_sms_count is not null");
			return (Criteria) this;
		}

		public Criteria andSendSmsCountEqualTo(Integer value) {
			addCriterion("send_sms_count =", value, "sendSmsCount");
			return (Criteria) this;
		}

		public Criteria andSendSmsCountNotEqualTo(Integer value) {
			addCriterion("send_sms_count <>", value, "sendSmsCount");
			return (Criteria) this;
		}

		public Criteria andSendSmsCountGreaterThan(Integer value) {
			addCriterion("send_sms_count >", value, "sendSmsCount");
			return (Criteria) this;
		}

		public Criteria andSendSmsCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("send_sms_count >=", value, "sendSmsCount");
			return (Criteria) this;
		}

		public Criteria andSendSmsCountLessThan(Integer value) {
			addCriterion("send_sms_count <", value, "sendSmsCount");
			return (Criteria) this;
		}

		public Criteria andSendSmsCountLessThanOrEqualTo(Integer value) {
			addCriterion("send_sms_count <=", value, "sendSmsCount");
			return (Criteria) this;
		}

		public Criteria andSendSmsCountIn(List<Integer> values) {
			addCriterion("send_sms_count in", values, "sendSmsCount");
			return (Criteria) this;
		}

		public Criteria andSendSmsCountNotIn(List<Integer> values) {
			addCriterion("send_sms_count not in", values, "sendSmsCount");
			return (Criteria) this;
		}

		public Criteria andSendSmsCountBetween(Integer value1, Integer value2) {
			addCriterion("send_sms_count between", value1, value2, "sendSmsCount");
			return (Criteria) this;
		}

		public Criteria andSendSmsCountNotBetween(Integer value1, Integer value2) {
			addCriterion("send_sms_count not between", value1, value2, "sendSmsCount");
			return (Criteria) this;
		}

		public Criteria andStoreAddressIsNull() {
			addCriterion("store_address is null");
			return (Criteria) this;
		}

		public Criteria andStoreAddressIsNotNull() {
			addCriterion("store_address is not null");
			return (Criteria) this;
		}

		public Criteria andStoreAddressEqualTo(String value) {
			addCriterion("store_address =", value, "storeAddress");
			return (Criteria) this;
		}

		public Criteria andStoreAddressNotEqualTo(String value) {
			addCriterion("store_address <>", value, "storeAddress");
			return (Criteria) this;
		}

		public Criteria andStoreAddressGreaterThan(String value) {
			addCriterion("store_address >", value, "storeAddress");
			return (Criteria) this;
		}

		public Criteria andStoreAddressGreaterThanOrEqualTo(String value) {
			addCriterion("store_address >=", value, "storeAddress");
			return (Criteria) this;
		}

		public Criteria andStoreAddressLessThan(String value) {
			addCriterion("store_address <", value, "storeAddress");
			return (Criteria) this;
		}

		public Criteria andStoreAddressLessThanOrEqualTo(String value) {
			addCriterion("store_address <=", value, "storeAddress");
			return (Criteria) this;
		}

		public Criteria andStoreAddressLike(String value) {
			addCriterion("store_address like", value, "storeAddress");
			return (Criteria) this;
		}

		public Criteria andStoreAddressNotLike(String value) {
			addCriterion("store_address not like", value, "storeAddress");
			return (Criteria) this;
		}

		public Criteria andStoreAddressIn(List<String> values) {
			addCriterion("store_address in", values, "storeAddress");
			return (Criteria) this;
		}

		public Criteria andStoreAddressNotIn(List<String> values) {
			addCriterion("store_address not in", values, "storeAddress");
			return (Criteria) this;
		}

		public Criteria andStoreAddressBetween(String value1, String value2) {
			addCriterion("store_address between", value1, value2, "storeAddress");
			return (Criteria) this;
		}

		public Criteria andStoreAddressNotBetween(String value1, String value2) {
			addCriterion("store_address not between", value1, value2, "storeAddress");
			return (Criteria) this;
		}

		public Criteria andStoreCommissionAmountIsNull() {
			addCriterion("store_commission_amount is null");
			return (Criteria) this;
		}

		public Criteria andStoreCommissionAmountIsNotNull() {
			addCriterion("store_commission_amount is not null");
			return (Criteria) this;
		}

		public Criteria andStoreCommissionAmountEqualTo(BigDecimal value) {
			addCriterion("store_commission_amount =", value, "storeCommissionAmount");
			return (Criteria) this;
		}

		public Criteria andStoreCommissionAmountNotEqualTo(BigDecimal value) {
			addCriterion("store_commission_amount <>", value, "storeCommissionAmount");
			return (Criteria) this;
		}

		public Criteria andStoreCommissionAmountGreaterThan(BigDecimal value) {
			addCriterion("store_commission_amount >", value, "storeCommissionAmount");
			return (Criteria) this;
		}

		public Criteria andStoreCommissionAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("store_commission_amount >=", value, "storeCommissionAmount");
			return (Criteria) this;
		}

		public Criteria andStoreCommissionAmountLessThan(BigDecimal value) {
			addCriterion("store_commission_amount <", value, "storeCommissionAmount");
			return (Criteria) this;
		}

		public Criteria andStoreCommissionAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("store_commission_amount <=", value, "storeCommissionAmount");
			return (Criteria) this;
		}

		public Criteria andStoreCommissionAmountIn(List<BigDecimal> values) {
			addCriterion("store_commission_amount in", values, "storeCommissionAmount");
			return (Criteria) this;
		}

		public Criteria andStoreCommissionAmountNotIn(List<BigDecimal> values) {
			addCriterion("store_commission_amount not in", values, "storeCommissionAmount");
			return (Criteria) this;
		}

		public Criteria andStoreCommissionAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("store_commission_amount between", value1, value2, "storeCommissionAmount");
			return (Criteria) this;
		}

		public Criteria andStoreCommissionAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("store_commission_amount not between", value1, value2, "storeCommissionAmount");
			return (Criteria) this;
		}

		public Criteria andStoreCreditIsNull() {
			addCriterion("store_credit is null");
			return (Criteria) this;
		}

		public Criteria andStoreCreditIsNotNull() {
			addCriterion("store_credit is not null");
			return (Criteria) this;
		}

		public Criteria andStoreCreditEqualTo(Integer value) {
			addCriterion("store_credit =", value, "storeCredit");
			return (Criteria) this;
		}

		public Criteria andStoreCreditNotEqualTo(Integer value) {
			addCriterion("store_credit <>", value, "storeCredit");
			return (Criteria) this;
		}

		public Criteria andStoreCreditGreaterThan(Integer value) {
			addCriterion("store_credit >", value, "storeCredit");
			return (Criteria) this;
		}

		public Criteria andStoreCreditGreaterThanOrEqualTo(Integer value) {
			addCriterion("store_credit >=", value, "storeCredit");
			return (Criteria) this;
		}

		public Criteria andStoreCreditLessThan(Integer value) {
			addCriterion("store_credit <", value, "storeCredit");
			return (Criteria) this;
		}

		public Criteria andStoreCreditLessThanOrEqualTo(Integer value) {
			addCriterion("store_credit <=", value, "storeCredit");
			return (Criteria) this;
		}

		public Criteria andStoreCreditIn(List<Integer> values) {
			addCriterion("store_credit in", values, "storeCredit");
			return (Criteria) this;
		}

		public Criteria andStoreCreditNotIn(List<Integer> values) {
			addCriterion("store_credit not in", values, "storeCredit");
			return (Criteria) this;
		}

		public Criteria andStoreCreditBetween(Integer value1, Integer value2) {
			addCriterion("store_credit between", value1, value2, "storeCredit");
			return (Criteria) this;
		}

		public Criteria andStoreCreditNotBetween(Integer value1, Integer value2) {
			addCriterion("store_credit not between", value1, value2, "storeCredit");
			return (Criteria) this;
		}

		public Criteria andStoreDecorateOldThemeIsNull() {
			addCriterion("store_decorate_old_theme is null");
			return (Criteria) this;
		}

		public Criteria andStoreDecorateOldThemeIsNotNull() {
			addCriterion("store_decorate_old_theme is not null");
			return (Criteria) this;
		}

		public Criteria andStoreDecorateOldThemeEqualTo(String value) {
			addCriterion("store_decorate_old_theme =", value, "storeDecorateOldTheme");
			return (Criteria) this;
		}

		public Criteria andStoreDecorateOldThemeNotEqualTo(String value) {
			addCriterion("store_decorate_old_theme <>", value, "storeDecorateOldTheme");
			return (Criteria) this;
		}

		public Criteria andStoreDecorateOldThemeGreaterThan(String value) {
			addCriterion("store_decorate_old_theme >", value, "storeDecorateOldTheme");
			return (Criteria) this;
		}

		public Criteria andStoreDecorateOldThemeGreaterThanOrEqualTo(String value) {
			addCriterion("store_decorate_old_theme >=", value, "storeDecorateOldTheme");
			return (Criteria) this;
		}

		public Criteria andStoreDecorateOldThemeLessThan(String value) {
			addCriterion("store_decorate_old_theme <", value, "storeDecorateOldTheme");
			return (Criteria) this;
		}

		public Criteria andStoreDecorateOldThemeLessThanOrEqualTo(String value) {
			addCriterion("store_decorate_old_theme <=", value, "storeDecorateOldTheme");
			return (Criteria) this;
		}

		public Criteria andStoreDecorateOldThemeLike(String value) {
			addCriterion("store_decorate_old_theme like", value, "storeDecorateOldTheme");
			return (Criteria) this;
		}

		public Criteria andStoreDecorateOldThemeNotLike(String value) {
			addCriterion("store_decorate_old_theme not like", value, "storeDecorateOldTheme");
			return (Criteria) this;
		}

		public Criteria andStoreDecorateOldThemeIn(List<String> values) {
			addCriterion("store_decorate_old_theme in", values, "storeDecorateOldTheme");
			return (Criteria) this;
		}

		public Criteria andStoreDecorateOldThemeNotIn(List<String> values) {
			addCriterion("store_decorate_old_theme not in", values, "storeDecorateOldTheme");
			return (Criteria) this;
		}

		public Criteria andStoreDecorateOldThemeBetween(String value1, String value2) {
			addCriterion("store_decorate_old_theme between", value1, value2, "storeDecorateOldTheme");
			return (Criteria) this;
		}

		public Criteria andStoreDecorateOldThemeNotBetween(String value1, String value2) {
			addCriterion("store_decorate_old_theme not between", value1, value2, "storeDecorateOldTheme");
			return (Criteria) this;
		}

		public Criteria andStoreDecorateThemeIsNull() {
			addCriterion("store_decorate_theme is null");
			return (Criteria) this;
		}

		public Criteria andStoreDecorateThemeIsNotNull() {
			addCriterion("store_decorate_theme is not null");
			return (Criteria) this;
		}

		public Criteria andStoreDecorateThemeEqualTo(String value) {
			addCriterion("store_decorate_theme =", value, "storeDecorateTheme");
			return (Criteria) this;
		}

		public Criteria andStoreDecorateThemeNotEqualTo(String value) {
			addCriterion("store_decorate_theme <>", value, "storeDecorateTheme");
			return (Criteria) this;
		}

		public Criteria andStoreDecorateThemeGreaterThan(String value) {
			addCriterion("store_decorate_theme >", value, "storeDecorateTheme");
			return (Criteria) this;
		}

		public Criteria andStoreDecorateThemeGreaterThanOrEqualTo(String value) {
			addCriterion("store_decorate_theme >=", value, "storeDecorateTheme");
			return (Criteria) this;
		}

		public Criteria andStoreDecorateThemeLessThan(String value) {
			addCriterion("store_decorate_theme <", value, "storeDecorateTheme");
			return (Criteria) this;
		}

		public Criteria andStoreDecorateThemeLessThanOrEqualTo(String value) {
			addCriterion("store_decorate_theme <=", value, "storeDecorateTheme");
			return (Criteria) this;
		}

		public Criteria andStoreDecorateThemeLike(String value) {
			addCriterion("store_decorate_theme like", value, "storeDecorateTheme");
			return (Criteria) this;
		}

		public Criteria andStoreDecorateThemeNotLike(String value) {
			addCriterion("store_decorate_theme not like", value, "storeDecorateTheme");
			return (Criteria) this;
		}

		public Criteria andStoreDecorateThemeIn(List<String> values) {
			addCriterion("store_decorate_theme in", values, "storeDecorateTheme");
			return (Criteria) this;
		}

		public Criteria andStoreDecorateThemeNotIn(List<String> values) {
			addCriterion("store_decorate_theme not in", values, "storeDecorateTheme");
			return (Criteria) this;
		}

		public Criteria andStoreDecorateThemeBetween(String value1, String value2) {
			addCriterion("store_decorate_theme between", value1, value2, "storeDecorateTheme");
			return (Criteria) this;
		}

		public Criteria andStoreDecorateThemeNotBetween(String value1, String value2) {
			addCriterion("store_decorate_theme not between", value1, value2, "storeDecorateTheme");
			return (Criteria) this;
		}

		public Criteria andStoreEmailCountIsNull() {
			addCriterion("store_email_count is null");
			return (Criteria) this;
		}

		public Criteria andStoreEmailCountIsNotNull() {
			addCriterion("store_email_count is not null");
			return (Criteria) this;
		}

		public Criteria andStoreEmailCountEqualTo(Integer value) {
			addCriterion("store_email_count =", value, "storeEmailCount");
			return (Criteria) this;
		}

		public Criteria andStoreEmailCountNotEqualTo(Integer value) {
			addCriterion("store_email_count <>", value, "storeEmailCount");
			return (Criteria) this;
		}

		public Criteria andStoreEmailCountGreaterThan(Integer value) {
			addCriterion("store_email_count >", value, "storeEmailCount");
			return (Criteria) this;
		}

		public Criteria andStoreEmailCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("store_email_count >=", value, "storeEmailCount");
			return (Criteria) this;
		}

		public Criteria andStoreEmailCountLessThan(Integer value) {
			addCriterion("store_email_count <", value, "storeEmailCount");
			return (Criteria) this;
		}

		public Criteria andStoreEmailCountLessThanOrEqualTo(Integer value) {
			addCriterion("store_email_count <=", value, "storeEmailCount");
			return (Criteria) this;
		}

		public Criteria andStoreEmailCountIn(List<Integer> values) {
			addCriterion("store_email_count in", values, "storeEmailCount");
			return (Criteria) this;
		}

		public Criteria andStoreEmailCountNotIn(List<Integer> values) {
			addCriterion("store_email_count not in", values, "storeEmailCount");
			return (Criteria) this;
		}

		public Criteria andStoreEmailCountBetween(Integer value1, Integer value2) {
			addCriterion("store_email_count between", value1, value2, "storeEmailCount");
			return (Criteria) this;
		}

		public Criteria andStoreEmailCountNotBetween(Integer value1, Integer value2) {
			addCriterion("store_email_count not between", value1, value2, "storeEmailCount");
			return (Criteria) this;
		}

		public Criteria andStoreMsnIsNull() {
			addCriterion("store_msn is null");
			return (Criteria) this;
		}

		public Criteria andStoreMsnIsNotNull() {
			addCriterion("store_msn is not null");
			return (Criteria) this;
		}

		public Criteria andStoreMsnEqualTo(String value) {
			addCriterion("store_msn =", value, "storeMsn");
			return (Criteria) this;
		}

		public Criteria andStoreMsnNotEqualTo(String value) {
			addCriterion("store_msn <>", value, "storeMsn");
			return (Criteria) this;
		}

		public Criteria andStoreMsnGreaterThan(String value) {
			addCriterion("store_msn >", value, "storeMsn");
			return (Criteria) this;
		}

		public Criteria andStoreMsnGreaterThanOrEqualTo(String value) {
			addCriterion("store_msn >=", value, "storeMsn");
			return (Criteria) this;
		}

		public Criteria andStoreMsnLessThan(String value) {
			addCriterion("store_msn <", value, "storeMsn");
			return (Criteria) this;
		}

		public Criteria andStoreMsnLessThanOrEqualTo(String value) {
			addCriterion("store_msn <=", value, "storeMsn");
			return (Criteria) this;
		}

		public Criteria andStoreMsnLike(String value) {
			addCriterion("store_msn like", value, "storeMsn");
			return (Criteria) this;
		}

		public Criteria andStoreMsnNotLike(String value) {
			addCriterion("store_msn not like", value, "storeMsn");
			return (Criteria) this;
		}

		public Criteria andStoreMsnIn(List<String> values) {
			addCriterion("store_msn in", values, "storeMsn");
			return (Criteria) this;
		}

		public Criteria andStoreMsnNotIn(List<String> values) {
			addCriterion("store_msn not in", values, "storeMsn");
			return (Criteria) this;
		}

		public Criteria andStoreMsnBetween(String value1, String value2) {
			addCriterion("store_msn between", value1, value2, "storeMsn");
			return (Criteria) this;
		}

		public Criteria andStoreMsnNotBetween(String value1, String value2) {
			addCriterion("store_msn not between", value1, value2, "storeMsn");
			return (Criteria) this;
		}

		public Criteria andStoreNameIsNull() {
			addCriterion("store_name is null");
			return (Criteria) this;
		}

		public Criteria andStoreNameIsNotNull() {
			addCriterion("store_name is not null");
			return (Criteria) this;
		}

		public Criteria andStoreNameEqualTo(String value) {
			addCriterion("store_name =", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameNotEqualTo(String value) {
			addCriterion("store_name <>", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameGreaterThan(String value) {
			addCriterion("store_name >", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameGreaterThanOrEqualTo(String value) {
			addCriterion("store_name >=", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameLessThan(String value) {
			addCriterion("store_name <", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameLessThanOrEqualTo(String value) {
			addCriterion("store_name <=", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameLike(String value) {
			addCriterion("store_name like", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameNotLike(String value) {
			addCriterion("store_name not like", value, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameIn(List<String> values) {
			addCriterion("store_name in", values, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameNotIn(List<String> values) {
			addCriterion("store_name not in", values, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameBetween(String value1, String value2) {
			addCriterion("store_name between", value1, value2, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreNameNotBetween(String value1, String value2) {
			addCriterion("store_name not between", value1, value2, "storeName");
			return (Criteria) this;
		}

		public Criteria andStoreOwerIsNull() {
			addCriterion("store_ower is null");
			return (Criteria) this;
		}

		public Criteria andStoreOwerIsNotNull() {
			addCriterion("store_ower is not null");
			return (Criteria) this;
		}

		public Criteria andStoreOwerEqualTo(String value) {
			addCriterion("store_ower =", value, "storeOwer");
			return (Criteria) this;
		}

		public Criteria andStoreOwerNotEqualTo(String value) {
			addCriterion("store_ower <>", value, "storeOwer");
			return (Criteria) this;
		}

		public Criteria andStoreOwerGreaterThan(String value) {
			addCriterion("store_ower >", value, "storeOwer");
			return (Criteria) this;
		}

		public Criteria andStoreOwerGreaterThanOrEqualTo(String value) {
			addCriterion("store_ower >=", value, "storeOwer");
			return (Criteria) this;
		}

		public Criteria andStoreOwerLessThan(String value) {
			addCriterion("store_ower <", value, "storeOwer");
			return (Criteria) this;
		}

		public Criteria andStoreOwerLessThanOrEqualTo(String value) {
			addCriterion("store_ower <=", value, "storeOwer");
			return (Criteria) this;
		}

		public Criteria andStoreOwerLike(String value) {
			addCriterion("store_ower like", value, "storeOwer");
			return (Criteria) this;
		}

		public Criteria andStoreOwerNotLike(String value) {
			addCriterion("store_ower not like", value, "storeOwer");
			return (Criteria) this;
		}

		public Criteria andStoreOwerIn(List<String> values) {
			addCriterion("store_ower in", values, "storeOwer");
			return (Criteria) this;
		}

		public Criteria andStoreOwerNotIn(List<String> values) {
			addCriterion("store_ower not in", values, "storeOwer");
			return (Criteria) this;
		}

		public Criteria andStoreOwerBetween(String value1, String value2) {
			addCriterion("store_ower between", value1, value2, "storeOwer");
			return (Criteria) this;
		}

		public Criteria andStoreOwerNotBetween(String value1, String value2) {
			addCriterion("store_ower not between", value1, value2, "storeOwer");
			return (Criteria) this;
		}

		public Criteria andStoreOwerCardIsNull() {
			addCriterion("store_ower_card is null");
			return (Criteria) this;
		}

		public Criteria andStoreOwerCardIsNotNull() {
			addCriterion("store_ower_card is not null");
			return (Criteria) this;
		}

		public Criteria andStoreOwerCardEqualTo(String value) {
			addCriterion("store_ower_card =", value, "storeOwerCard");
			return (Criteria) this;
		}

		public Criteria andStoreOwerCardNotEqualTo(String value) {
			addCriterion("store_ower_card <>", value, "storeOwerCard");
			return (Criteria) this;
		}

		public Criteria andStoreOwerCardGreaterThan(String value) {
			addCriterion("store_ower_card >", value, "storeOwerCard");
			return (Criteria) this;
		}

		public Criteria andStoreOwerCardGreaterThanOrEqualTo(String value) {
			addCriterion("store_ower_card >=", value, "storeOwerCard");
			return (Criteria) this;
		}

		public Criteria andStoreOwerCardLessThan(String value) {
			addCriterion("store_ower_card <", value, "storeOwerCard");
			return (Criteria) this;
		}

		public Criteria andStoreOwerCardLessThanOrEqualTo(String value) {
			addCriterion("store_ower_card <=", value, "storeOwerCard");
			return (Criteria) this;
		}

		public Criteria andStoreOwerCardLike(String value) {
			addCriterion("store_ower_card like", value, "storeOwerCard");
			return (Criteria) this;
		}

		public Criteria andStoreOwerCardNotLike(String value) {
			addCriterion("store_ower_card not like", value, "storeOwerCard");
			return (Criteria) this;
		}

		public Criteria andStoreOwerCardIn(List<String> values) {
			addCriterion("store_ower_card in", values, "storeOwerCard");
			return (Criteria) this;
		}

		public Criteria andStoreOwerCardNotIn(List<String> values) {
			addCriterion("store_ower_card not in", values, "storeOwerCard");
			return (Criteria) this;
		}

		public Criteria andStoreOwerCardBetween(String value1, String value2) {
			addCriterion("store_ower_card between", value1, value2, "storeOwerCard");
			return (Criteria) this;
		}

		public Criteria andStoreOwerCardNotBetween(String value1, String value2) {
			addCriterion("store_ower_card not between", value1, value2, "storeOwerCard");
			return (Criteria) this;
		}

		public Criteria andStorePayoffAmountIsNull() {
			addCriterion("store_payoff_amount is null");
			return (Criteria) this;
		}

		public Criteria andStorePayoffAmountIsNotNull() {
			addCriterion("store_payoff_amount is not null");
			return (Criteria) this;
		}

		public Criteria andStorePayoffAmountEqualTo(BigDecimal value) {
			addCriterion("store_payoff_amount =", value, "storePayoffAmount");
			return (Criteria) this;
		}

		public Criteria andStorePayoffAmountNotEqualTo(BigDecimal value) {
			addCriterion("store_payoff_amount <>", value, "storePayoffAmount");
			return (Criteria) this;
		}

		public Criteria andStorePayoffAmountGreaterThan(BigDecimal value) {
			addCriterion("store_payoff_amount >", value, "storePayoffAmount");
			return (Criteria) this;
		}

		public Criteria andStorePayoffAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("store_payoff_amount >=", value, "storePayoffAmount");
			return (Criteria) this;
		}

		public Criteria andStorePayoffAmountLessThan(BigDecimal value) {
			addCriterion("store_payoff_amount <", value, "storePayoffAmount");
			return (Criteria) this;
		}

		public Criteria andStorePayoffAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("store_payoff_amount <=", value, "storePayoffAmount");
			return (Criteria) this;
		}

		public Criteria andStorePayoffAmountIn(List<BigDecimal> values) {
			addCriterion("store_payoff_amount in", values, "storePayoffAmount");
			return (Criteria) this;
		}

		public Criteria andStorePayoffAmountNotIn(List<BigDecimal> values) {
			addCriterion("store_payoff_amount not in", values, "storePayoffAmount");
			return (Criteria) this;
		}

		public Criteria andStorePayoffAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("store_payoff_amount between", value1, value2, "storePayoffAmount");
			return (Criteria) this;
		}

		public Criteria andStorePayoffAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("store_payoff_amount not between", value1, value2, "storePayoffAmount");
			return (Criteria) this;
		}

		public Criteria andStoreQqIsNull() {
			addCriterion("store_qq is null");
			return (Criteria) this;
		}

		public Criteria andStoreQqIsNotNull() {
			addCriterion("store_qq is not null");
			return (Criteria) this;
		}

		public Criteria andStoreQqEqualTo(String value) {
			addCriterion("store_qq =", value, "storeQq");
			return (Criteria) this;
		}

		public Criteria andStoreQqNotEqualTo(String value) {
			addCriterion("store_qq <>", value, "storeQq");
			return (Criteria) this;
		}

		public Criteria andStoreQqGreaterThan(String value) {
			addCriterion("store_qq >", value, "storeQq");
			return (Criteria) this;
		}

		public Criteria andStoreQqGreaterThanOrEqualTo(String value) {
			addCriterion("store_qq >=", value, "storeQq");
			return (Criteria) this;
		}

		public Criteria andStoreQqLessThan(String value) {
			addCriterion("store_qq <", value, "storeQq");
			return (Criteria) this;
		}

		public Criteria andStoreQqLessThanOrEqualTo(String value) {
			addCriterion("store_qq <=", value, "storeQq");
			return (Criteria) this;
		}

		public Criteria andStoreQqLike(String value) {
			addCriterion("store_qq like", value, "storeQq");
			return (Criteria) this;
		}

		public Criteria andStoreQqNotLike(String value) {
			addCriterion("store_qq not like", value, "storeQq");
			return (Criteria) this;
		}

		public Criteria andStoreQqIn(List<String> values) {
			addCriterion("store_qq in", values, "storeQq");
			return (Criteria) this;
		}

		public Criteria andStoreQqNotIn(List<String> values) {
			addCriterion("store_qq not in", values, "storeQq");
			return (Criteria) this;
		}

		public Criteria andStoreQqBetween(String value1, String value2) {
			addCriterion("store_qq between", value1, value2, "storeQq");
			return (Criteria) this;
		}

		public Criteria andStoreQqNotBetween(String value1, String value2) {
			addCriterion("store_qq not between", value1, value2, "storeQq");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendIsNull() {
			addCriterion("store_recommend is null");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendIsNotNull() {
			addCriterion("store_recommend is not null");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendEqualTo(Boolean value) {
			addCriterion("store_recommend =", value, "storeRecommend");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendNotEqualTo(Boolean value) {
			addCriterion("store_recommend <>", value, "storeRecommend");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendGreaterThan(Boolean value) {
			addCriterion("store_recommend >", value, "storeRecommend");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendGreaterThanOrEqualTo(Boolean value) {
			addCriterion("store_recommend >=", value, "storeRecommend");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendLessThan(Boolean value) {
			addCriterion("store_recommend <", value, "storeRecommend");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendLessThanOrEqualTo(Boolean value) {
			addCriterion("store_recommend <=", value, "storeRecommend");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendIn(List<Boolean> values) {
			addCriterion("store_recommend in", values, "storeRecommend");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendNotIn(List<Boolean> values) {
			addCriterion("store_recommend not in", values, "storeRecommend");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendBetween(Boolean value1, Boolean value2) {
			addCriterion("store_recommend between", value1, value2, "storeRecommend");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendNotBetween(Boolean value1, Boolean value2) {
			addCriterion("store_recommend not between", value1, value2, "storeRecommend");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendTimeIsNull() {
			addCriterion("store_recommend_time is null");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendTimeIsNotNull() {
			addCriterion("store_recommend_time is not null");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendTimeEqualTo(Date value) {
			addCriterion("store_recommend_time =", value, "storeRecommendTime");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendTimeNotEqualTo(Date value) {
			addCriterion("store_recommend_time <>", value, "storeRecommendTime");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendTimeGreaterThan(Date value) {
			addCriterion("store_recommend_time >", value, "storeRecommendTime");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("store_recommend_time >=", value, "storeRecommendTime");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendTimeLessThan(Date value) {
			addCriterion("store_recommend_time <", value, "storeRecommendTime");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendTimeLessThanOrEqualTo(Date value) {
			addCriterion("store_recommend_time <=", value, "storeRecommendTime");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendTimeIn(List<Date> values) {
			addCriterion("store_recommend_time in", values, "storeRecommendTime");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendTimeNotIn(List<Date> values) {
			addCriterion("store_recommend_time not in", values, "storeRecommendTime");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendTimeBetween(Date value1, Date value2) {
			addCriterion("store_recommend_time between", value1, value2, "storeRecommendTime");
			return (Criteria) this;
		}

		public Criteria andStoreRecommendTimeNotBetween(Date value1, Date value2) {
			addCriterion("store_recommend_time not between", value1, value2, "storeRecommendTime");
			return (Criteria) this;
		}

		public Criteria andStoreSaleAmountIsNull() {
			addCriterion("store_sale_amount is null");
			return (Criteria) this;
		}

		public Criteria andStoreSaleAmountIsNotNull() {
			addCriterion("store_sale_amount is not null");
			return (Criteria) this;
		}

		public Criteria andStoreSaleAmountEqualTo(BigDecimal value) {
			addCriterion("store_sale_amount =", value, "storeSaleAmount");
			return (Criteria) this;
		}

		public Criteria andStoreSaleAmountNotEqualTo(BigDecimal value) {
			addCriterion("store_sale_amount <>", value, "storeSaleAmount");
			return (Criteria) this;
		}

		public Criteria andStoreSaleAmountGreaterThan(BigDecimal value) {
			addCriterion("store_sale_amount >", value, "storeSaleAmount");
			return (Criteria) this;
		}

		public Criteria andStoreSaleAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("store_sale_amount >=", value, "storeSaleAmount");
			return (Criteria) this;
		}

		public Criteria andStoreSaleAmountLessThan(BigDecimal value) {
			addCriterion("store_sale_amount <", value, "storeSaleAmount");
			return (Criteria) this;
		}

		public Criteria andStoreSaleAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("store_sale_amount <=", value, "storeSaleAmount");
			return (Criteria) this;
		}

		public Criteria andStoreSaleAmountIn(List<BigDecimal> values) {
			addCriterion("store_sale_amount in", values, "storeSaleAmount");
			return (Criteria) this;
		}

		public Criteria andStoreSaleAmountNotIn(List<BigDecimal> values) {
			addCriterion("store_sale_amount not in", values, "storeSaleAmount");
			return (Criteria) this;
		}

		public Criteria andStoreSaleAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("store_sale_amount between", value1, value2, "storeSaleAmount");
			return (Criteria) this;
		}

		public Criteria andStoreSaleAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("store_sale_amount not between", value1, value2, "storeSaleAmount");
			return (Criteria) this;
		}

		public Criteria andStoreSecondDomainIsNull() {
			addCriterion("store_second_domain is null");
			return (Criteria) this;
		}

		public Criteria andStoreSecondDomainIsNotNull() {
			addCriterion("store_second_domain is not null");
			return (Criteria) this;
		}

		public Criteria andStoreSecondDomainEqualTo(String value) {
			addCriterion("store_second_domain =", value, "storeSecondDomain");
			return (Criteria) this;
		}

		public Criteria andStoreSecondDomainNotEqualTo(String value) {
			addCriterion("store_second_domain <>", value, "storeSecondDomain");
			return (Criteria) this;
		}

		public Criteria andStoreSecondDomainGreaterThan(String value) {
			addCriterion("store_second_domain >", value, "storeSecondDomain");
			return (Criteria) this;
		}

		public Criteria andStoreSecondDomainGreaterThanOrEqualTo(String value) {
			addCriterion("store_second_domain >=", value, "storeSecondDomain");
			return (Criteria) this;
		}

		public Criteria andStoreSecondDomainLessThan(String value) {
			addCriterion("store_second_domain <", value, "storeSecondDomain");
			return (Criteria) this;
		}

		public Criteria andStoreSecondDomainLessThanOrEqualTo(String value) {
			addCriterion("store_second_domain <=", value, "storeSecondDomain");
			return (Criteria) this;
		}

		public Criteria andStoreSecondDomainLike(String value) {
			addCriterion("store_second_domain like", value, "storeSecondDomain");
			return (Criteria) this;
		}

		public Criteria andStoreSecondDomainNotLike(String value) {
			addCriterion("store_second_domain not like", value, "storeSecondDomain");
			return (Criteria) this;
		}

		public Criteria andStoreSecondDomainIn(List<String> values) {
			addCriterion("store_second_domain in", values, "storeSecondDomain");
			return (Criteria) this;
		}

		public Criteria andStoreSecondDomainNotIn(List<String> values) {
			addCriterion("store_second_domain not in", values, "storeSecondDomain");
			return (Criteria) this;
		}

		public Criteria andStoreSecondDomainBetween(String value1, String value2) {
			addCriterion("store_second_domain between", value1, value2, "storeSecondDomain");
			return (Criteria) this;
		}

		public Criteria andStoreSecondDomainNotBetween(String value1, String value2) {
			addCriterion("store_second_domain not between", value1, value2, "storeSecondDomain");
			return (Criteria) this;
		}

		public Criteria andStoreSmsCountIsNull() {
			addCriterion("store_sms_count is null");
			return (Criteria) this;
		}

		public Criteria andStoreSmsCountIsNotNull() {
			addCriterion("store_sms_count is not null");
			return (Criteria) this;
		}

		public Criteria andStoreSmsCountEqualTo(Integer value) {
			addCriterion("store_sms_count =", value, "storeSmsCount");
			return (Criteria) this;
		}

		public Criteria andStoreSmsCountNotEqualTo(Integer value) {
			addCriterion("store_sms_count <>", value, "storeSmsCount");
			return (Criteria) this;
		}

		public Criteria andStoreSmsCountGreaterThan(Integer value) {
			addCriterion("store_sms_count >", value, "storeSmsCount");
			return (Criteria) this;
		}

		public Criteria andStoreSmsCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("store_sms_count >=", value, "storeSmsCount");
			return (Criteria) this;
		}

		public Criteria andStoreSmsCountLessThan(Integer value) {
			addCriterion("store_sms_count <", value, "storeSmsCount");
			return (Criteria) this;
		}

		public Criteria andStoreSmsCountLessThanOrEqualTo(Integer value) {
			addCriterion("store_sms_count <=", value, "storeSmsCount");
			return (Criteria) this;
		}

		public Criteria andStoreSmsCountIn(List<Integer> values) {
			addCriterion("store_sms_count in", values, "storeSmsCount");
			return (Criteria) this;
		}

		public Criteria andStoreSmsCountNotIn(List<Integer> values) {
			addCriterion("store_sms_count not in", values, "storeSmsCount");
			return (Criteria) this;
		}

		public Criteria andStoreSmsCountBetween(Integer value1, Integer value2) {
			addCriterion("store_sms_count between", value1, value2, "storeSmsCount");
			return (Criteria) this;
		}

		public Criteria andStoreSmsCountNotBetween(Integer value1, Integer value2) {
			addCriterion("store_sms_count not between", value1, value2, "storeSmsCount");
			return (Criteria) this;
		}

		public Criteria andStoreStartTimeIsNull() {
			addCriterion("store_start_time is null");
			return (Criteria) this;
		}

		public Criteria andStoreStartTimeIsNotNull() {
			addCriterion("store_start_time is not null");
			return (Criteria) this;
		}

		public Criteria andStoreStartTimeEqualTo(Date value) {
			addCriterion("store_start_time =", value, "storeStartTime");
			return (Criteria) this;
		}

		public Criteria andStoreStartTimeNotEqualTo(Date value) {
			addCriterion("store_start_time <>", value, "storeStartTime");
			return (Criteria) this;
		}

		public Criteria andStoreStartTimeGreaterThan(Date value) {
			addCriterion("store_start_time >", value, "storeStartTime");
			return (Criteria) this;
		}

		public Criteria andStoreStartTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("store_start_time >=", value, "storeStartTime");
			return (Criteria) this;
		}

		public Criteria andStoreStartTimeLessThan(Date value) {
			addCriterion("store_start_time <", value, "storeStartTime");
			return (Criteria) this;
		}

		public Criteria andStoreStartTimeLessThanOrEqualTo(Date value) {
			addCriterion("store_start_time <=", value, "storeStartTime");
			return (Criteria) this;
		}

		public Criteria andStoreStartTimeIn(List<Date> values) {
			addCriterion("store_start_time in", values, "storeStartTime");
			return (Criteria) this;
		}

		public Criteria andStoreStartTimeNotIn(List<Date> values) {
			addCriterion("store_start_time not in", values, "storeStartTime");
			return (Criteria) this;
		}

		public Criteria andStoreStartTimeBetween(Date value1, Date value2) {
			addCriterion("store_start_time between", value1, value2, "storeStartTime");
			return (Criteria) this;
		}

		public Criteria andStoreStartTimeNotBetween(Date value1, Date value2) {
			addCriterion("store_start_time not between", value1, value2, "storeStartTime");
			return (Criteria) this;
		}

		public Criteria andStoreStatusIsNull() {
			addCriterion("store_status is null");
			return (Criteria) this;
		}

		public Criteria andStoreStatusIsNotNull() {
			addCriterion("store_status is not null");
			return (Criteria) this;
		}

		public Criteria andStoreStatusEqualTo(Integer value) {
			addCriterion("store_status =", value, "storeStatus");
			return (Criteria) this;
		}

		public Criteria andStoreStatusNotEqualTo(Integer value) {
			addCriterion("store_status <>", value, "storeStatus");
			return (Criteria) this;
		}

		public Criteria andStoreStatusGreaterThan(Integer value) {
			addCriterion("store_status >", value, "storeStatus");
			return (Criteria) this;
		}

		public Criteria andStoreStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("store_status >=", value, "storeStatus");
			return (Criteria) this;
		}

		public Criteria andStoreStatusLessThan(Integer value) {
			addCriterion("store_status <", value, "storeStatus");
			return (Criteria) this;
		}

		public Criteria andStoreStatusLessThanOrEqualTo(Integer value) {
			addCriterion("store_status <=", value, "storeStatus");
			return (Criteria) this;
		}

		public Criteria andStoreStatusIn(List<Integer> values) {
			addCriterion("store_status in", values, "storeStatus");
			return (Criteria) this;
		}

		public Criteria andStoreStatusNotIn(List<Integer> values) {
			addCriterion("store_status not in", values, "storeStatus");
			return (Criteria) this;
		}

		public Criteria andStoreStatusBetween(Integer value1, Integer value2) {
			addCriterion("store_status between", value1, value2, "storeStatus");
			return (Criteria) this;
		}

		public Criteria andStoreStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("store_status not between", value1, value2, "storeStatus");
			return (Criteria) this;
		}

		public Criteria andStoreTelephoneIsNull() {
			addCriterion("store_telephone is null");
			return (Criteria) this;
		}

		public Criteria andStoreTelephoneIsNotNull() {
			addCriterion("store_telephone is not null");
			return (Criteria) this;
		}

		public Criteria andStoreTelephoneEqualTo(String value) {
			addCriterion("store_telephone =", value, "storeTelephone");
			return (Criteria) this;
		}

		public Criteria andStoreTelephoneNotEqualTo(String value) {
			addCriterion("store_telephone <>", value, "storeTelephone");
			return (Criteria) this;
		}

		public Criteria andStoreTelephoneGreaterThan(String value) {
			addCriterion("store_telephone >", value, "storeTelephone");
			return (Criteria) this;
		}

		public Criteria andStoreTelephoneGreaterThanOrEqualTo(String value) {
			addCriterion("store_telephone >=", value, "storeTelephone");
			return (Criteria) this;
		}

		public Criteria andStoreTelephoneLessThan(String value) {
			addCriterion("store_telephone <", value, "storeTelephone");
			return (Criteria) this;
		}

		public Criteria andStoreTelephoneLessThanOrEqualTo(String value) {
			addCriterion("store_telephone <=", value, "storeTelephone");
			return (Criteria) this;
		}

		public Criteria andStoreTelephoneLike(String value) {
			addCriterion("store_telephone like", value, "storeTelephone");
			return (Criteria) this;
		}

		public Criteria andStoreTelephoneNotLike(String value) {
			addCriterion("store_telephone not like", value, "storeTelephone");
			return (Criteria) this;
		}

		public Criteria andStoreTelephoneIn(List<String> values) {
			addCriterion("store_telephone in", values, "storeTelephone");
			return (Criteria) this;
		}

		public Criteria andStoreTelephoneNotIn(List<String> values) {
			addCriterion("store_telephone not in", values, "storeTelephone");
			return (Criteria) this;
		}

		public Criteria andStoreTelephoneBetween(String value1, String value2) {
			addCriterion("store_telephone between", value1, value2, "storeTelephone");
			return (Criteria) this;
		}

		public Criteria andStoreTelephoneNotBetween(String value1, String value2) {
			addCriterion("store_telephone not between", value1, value2, "storeTelephone");
			return (Criteria) this;
		}

		public Criteria andStoreWwIsNull() {
			addCriterion("store_ww is null");
			return (Criteria) this;
		}

		public Criteria andStoreWwIsNotNull() {
			addCriterion("store_ww is not null");
			return (Criteria) this;
		}

		public Criteria andStoreWwEqualTo(String value) {
			addCriterion("store_ww =", value, "storeWw");
			return (Criteria) this;
		}

		public Criteria andStoreWwNotEqualTo(String value) {
			addCriterion("store_ww <>", value, "storeWw");
			return (Criteria) this;
		}

		public Criteria andStoreWwGreaterThan(String value) {
			addCriterion("store_ww >", value, "storeWw");
			return (Criteria) this;
		}

		public Criteria andStoreWwGreaterThanOrEqualTo(String value) {
			addCriterion("store_ww >=", value, "storeWw");
			return (Criteria) this;
		}

		public Criteria andStoreWwLessThan(String value) {
			addCriterion("store_ww <", value, "storeWw");
			return (Criteria) this;
		}

		public Criteria andStoreWwLessThanOrEqualTo(String value) {
			addCriterion("store_ww <=", value, "storeWw");
			return (Criteria) this;
		}

		public Criteria andStoreWwLike(String value) {
			addCriterion("store_ww like", value, "storeWw");
			return (Criteria) this;
		}

		public Criteria andStoreWwNotLike(String value) {
			addCriterion("store_ww not like", value, "storeWw");
			return (Criteria) this;
		}

		public Criteria andStoreWwIn(List<String> values) {
			addCriterion("store_ww in", values, "storeWw");
			return (Criteria) this;
		}

		public Criteria andStoreWwNotIn(List<String> values) {
			addCriterion("store_ww not in", values, "storeWw");
			return (Criteria) this;
		}

		public Criteria andStoreWwBetween(String value1, String value2) {
			addCriterion("store_ww between", value1, value2, "storeWw");
			return (Criteria) this;
		}

		public Criteria andStoreWwNotBetween(String value1, String value2) {
			addCriterion("store_ww not between", value1, value2, "storeWw");
			return (Criteria) this;
		}

		public Criteria andStoreZipIsNull() {
			addCriterion("store_zip is null");
			return (Criteria) this;
		}

		public Criteria andStoreZipIsNotNull() {
			addCriterion("store_zip is not null");
			return (Criteria) this;
		}

		public Criteria andStoreZipEqualTo(String value) {
			addCriterion("store_zip =", value, "storeZip");
			return (Criteria) this;
		}

		public Criteria andStoreZipNotEqualTo(String value) {
			addCriterion("store_zip <>", value, "storeZip");
			return (Criteria) this;
		}

		public Criteria andStoreZipGreaterThan(String value) {
			addCriterion("store_zip >", value, "storeZip");
			return (Criteria) this;
		}

		public Criteria andStoreZipGreaterThanOrEqualTo(String value) {
			addCriterion("store_zip >=", value, "storeZip");
			return (Criteria) this;
		}

		public Criteria andStoreZipLessThan(String value) {
			addCriterion("store_zip <", value, "storeZip");
			return (Criteria) this;
		}

		public Criteria andStoreZipLessThanOrEqualTo(String value) {
			addCriterion("store_zip <=", value, "storeZip");
			return (Criteria) this;
		}

		public Criteria andStoreZipLike(String value) {
			addCriterion("store_zip like", value, "storeZip");
			return (Criteria) this;
		}

		public Criteria andStoreZipNotLike(String value) {
			addCriterion("store_zip not like", value, "storeZip");
			return (Criteria) this;
		}

		public Criteria andStoreZipIn(List<String> values) {
			addCriterion("store_zip in", values, "storeZip");
			return (Criteria) this;
		}

		public Criteria andStoreZipNotIn(List<String> values) {
			addCriterion("store_zip not in", values, "storeZip");
			return (Criteria) this;
		}

		public Criteria andStoreZipBetween(String value1, String value2) {
			addCriterion("store_zip between", value1, value2, "storeZip");
			return (Criteria) this;
		}

		public Criteria andStoreZipNotBetween(String value1, String value2) {
			addCriterion("store_zip not between", value1, value2, "storeZip");
			return (Criteria) this;
		}

		public Criteria andValidityIsNull() {
			addCriterion("validity is null");
			return (Criteria) this;
		}

		public Criteria andValidityIsNotNull() {
			addCriterion("validity is not null");
			return (Criteria) this;
		}

		public Criteria andValidityEqualTo(Date value) {
			addCriterion("validity =", value, "validity");
			return (Criteria) this;
		}

		public Criteria andValidityNotEqualTo(Date value) {
			addCriterion("validity <>", value, "validity");
			return (Criteria) this;
		}

		public Criteria andValidityGreaterThan(Date value) {
			addCriterion("validity >", value, "validity");
			return (Criteria) this;
		}

		public Criteria andValidityGreaterThanOrEqualTo(Date value) {
			addCriterion("validity >=", value, "validity");
			return (Criteria) this;
		}

		public Criteria andValidityLessThan(Date value) {
			addCriterion("validity <", value, "validity");
			return (Criteria) this;
		}

		public Criteria andValidityLessThanOrEqualTo(Date value) {
			addCriterion("validity <=", value, "validity");
			return (Criteria) this;
		}

		public Criteria andValidityIn(List<Date> values) {
			addCriterion("validity in", values, "validity");
			return (Criteria) this;
		}

		public Criteria andValidityNotIn(List<Date> values) {
			addCriterion("validity not in", values, "validity");
			return (Criteria) this;
		}

		public Criteria andValidityBetween(Date value1, Date value2) {
			addCriterion("validity between", value1, value2, "validity");
			return (Criteria) this;
		}

		public Criteria andValidityNotBetween(Date value1, Date value2) {
			addCriterion("validity not between", value1, value2, "validity");
			return (Criteria) this;
		}

		public Criteria andAreaIdIsNull() {
			addCriterion("area_id is null");
			return (Criteria) this;
		}

		public Criteria andAreaIdIsNotNull() {
			addCriterion("area_id is not null");
			return (Criteria) this;
		}

		public Criteria andAreaIdEqualTo(Long value) {
			addCriterion("area_id =", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdNotEqualTo(Long value) {
			addCriterion("area_id <>", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdGreaterThan(Long value) {
			addCriterion("area_id >", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdGreaterThanOrEqualTo(Long value) {
			addCriterion("area_id >=", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdLessThan(Long value) {
			addCriterion("area_id <", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdLessThanOrEqualTo(Long value) {
			addCriterion("area_id <=", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdIn(List<Long> values) {
			addCriterion("area_id in", values, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdNotIn(List<Long> values) {
			addCriterion("area_id not in", values, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdBetween(Long value1, Long value2) {
			addCriterion("area_id between", value1, value2, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdNotBetween(Long value1, Long value2) {
			addCriterion("area_id not between", value1, value2, "areaId");
			return (Criteria) this;
		}

		public Criteria andBankAreaIdIsNull() {
			addCriterion("bank_area_id is null");
			return (Criteria) this;
		}

		public Criteria andBankAreaIdIsNotNull() {
			addCriterion("bank_area_id is not null");
			return (Criteria) this;
		}

		public Criteria andBankAreaIdEqualTo(Long value) {
			addCriterion("bank_area_id =", value, "bankAreaId");
			return (Criteria) this;
		}

		public Criteria andBankAreaIdNotEqualTo(Long value) {
			addCriterion("bank_area_id <>", value, "bankAreaId");
			return (Criteria) this;
		}

		public Criteria andBankAreaIdGreaterThan(Long value) {
			addCriterion("bank_area_id >", value, "bankAreaId");
			return (Criteria) this;
		}

		public Criteria andBankAreaIdGreaterThanOrEqualTo(Long value) {
			addCriterion("bank_area_id >=", value, "bankAreaId");
			return (Criteria) this;
		}

		public Criteria andBankAreaIdLessThan(Long value) {
			addCriterion("bank_area_id <", value, "bankAreaId");
			return (Criteria) this;
		}

		public Criteria andBankAreaIdLessThanOrEqualTo(Long value) {
			addCriterion("bank_area_id <=", value, "bankAreaId");
			return (Criteria) this;
		}

		public Criteria andBankAreaIdIn(List<Long> values) {
			addCriterion("bank_area_id in", values, "bankAreaId");
			return (Criteria) this;
		}

		public Criteria andBankAreaIdNotIn(List<Long> values) {
			addCriterion("bank_area_id not in", values, "bankAreaId");
			return (Criteria) this;
		}

		public Criteria andBankAreaIdBetween(Long value1, Long value2) {
			addCriterion("bank_area_id between", value1, value2, "bankAreaId");
			return (Criteria) this;
		}

		public Criteria andBankAreaIdNotBetween(Long value1, Long value2) {
			addCriterion("bank_area_id not between", value1, value2, "bankAreaId");
			return (Criteria) this;
		}

		public Criteria andBankPermitImagePathIsNull() {
			addCriterion("bank_permit_image_path is null");
			return (Criteria) this;
		}

		public Criteria andBankPermitImagePathIsNotNull() {
			addCriterion("bank_permit_image_path is not null");
			return (Criteria) this;
		}

		public Criteria andBankPermitImagePathEqualTo(String value) {
			addCriterion("bank_permit_image_path =", value, "bankPermitImagePath");
			return (Criteria) this;
		}

		public Criteria andBankPermitImagePathNotEqualTo(String value) {
			addCriterion("bank_permit_image_path <>", value, "bankPermitImagePath");
			return (Criteria) this;
		}

		public Criteria andBankPermitImagePathGreaterThan(String value) {
			addCriterion("bank_permit_image_path >", value, "bankPermitImagePath");
			return (Criteria) this;
		}

		public Criteria andBankPermitImagePathGreaterThanOrEqualTo(String value) {
			addCriterion("bank_permit_image_path >=", value, "bankPermitImagePath");
			return (Criteria) this;
		}

		public Criteria andBankPermitImagePathLessThan(String value) {
			addCriterion("bank_permit_image_path <", value, "bankPermitImagePath");
			return (Criteria) this;
		}

		public Criteria andBankPermitImagePathLessThanOrEqualTo(String value) {
			addCriterion("bank_permit_image_path <=", value, "bankPermitImagePath");
			return (Criteria) this;
		}

		public Criteria andBankPermitImagePathLike(String value) {
			addCriterion("bank_permit_image_path like", value, "bankPermitImagePath");
			return (Criteria) this;
		}

		public Criteria andBankPermitImagePathNotLike(String value) {
			addCriterion("bank_permit_image_path not like", value, "bankPermitImagePath");
			return (Criteria) this;
		}

		public Criteria andBankPermitImagePathIn(List<String> values) {
			addCriterion("bank_permit_image_path in", values, "bankPermitImagePath");
			return (Criteria) this;
		}

		public Criteria andBankPermitImagePathNotIn(List<String> values) {
			addCriterion("bank_permit_image_path not in", values, "bankPermitImagePath");
			return (Criteria) this;
		}

		public Criteria andBankPermitImagePathBetween(String value1, String value2) {
			addCriterion("bank_permit_image_path between", value1, value2, "bankPermitImagePath");
			return (Criteria) this;
		}

		public Criteria andBankPermitImagePathNotBetween(String value1, String value2) {
			addCriterion("bank_permit_image_path not between", value1, value2, "bankPermitImagePath");
			return (Criteria) this;
		}

		public Criteria andCardIdIsNull() {
			addCriterion("card_id is null");
			return (Criteria) this;
		}

		public Criteria andCardIdIsNotNull() {
			addCriterion("card_id is not null");
			return (Criteria) this;
		}

		public Criteria andCardIdEqualTo(Long value) {
			addCriterion("card_id =", value, "cardId");
			return (Criteria) this;
		}

		public Criteria andCardIdNotEqualTo(Long value) {
			addCriterion("card_id <>", value, "cardId");
			return (Criteria) this;
		}

		public Criteria andCardIdGreaterThan(Long value) {
			addCriterion("card_id >", value, "cardId");
			return (Criteria) this;
		}

		public Criteria andCardIdGreaterThanOrEqualTo(Long value) {
			addCriterion("card_id >=", value, "cardId");
			return (Criteria) this;
		}

		public Criteria andCardIdLessThan(Long value) {
			addCriterion("card_id <", value, "cardId");
			return (Criteria) this;
		}

		public Criteria andCardIdLessThanOrEqualTo(Long value) {
			addCriterion("card_id <=", value, "cardId");
			return (Criteria) this;
		}

		public Criteria andCardIdIn(List<Long> values) {
			addCriterion("card_id in", values, "cardId");
			return (Criteria) this;
		}

		public Criteria andCardIdNotIn(List<Long> values) {
			addCriterion("card_id not in", values, "cardId");
			return (Criteria) this;
		}

		public Criteria andCardIdBetween(Long value1, Long value2) {
			addCriterion("card_id between", value1, value2, "cardId");
			return (Criteria) this;
		}

		public Criteria andCardIdNotBetween(Long value1, Long value2) {
			addCriterion("card_id not between", value1, value2, "cardId");
			return (Criteria) this;
		}

		public Criteria andGradeIdIsNull() {
			addCriterion("grade_id is null");
			return (Criteria) this;
		}

		public Criteria andGradeIdIsNotNull() {
			addCriterion("grade_id is not null");
			return (Criteria) this;
		}

		public Criteria andGradeIdEqualTo(Long value) {
			addCriterion("grade_id =", value, "gradeId");
			return (Criteria) this;
		}

		public Criteria andGradeIdNotEqualTo(Long value) {
			addCriterion("grade_id <>", value, "gradeId");
			return (Criteria) this;
		}

		public Criteria andGradeIdGreaterThan(Long value) {
			addCriterion("grade_id >", value, "gradeId");
			return (Criteria) this;
		}

		public Criteria andGradeIdGreaterThanOrEqualTo(Long value) {
			addCriterion("grade_id >=", value, "gradeId");
			return (Criteria) this;
		}

		public Criteria andGradeIdLessThan(Long value) {
			addCriterion("grade_id <", value, "gradeId");
			return (Criteria) this;
		}

		public Criteria andGradeIdLessThanOrEqualTo(Long value) {
			addCriterion("grade_id <=", value, "gradeId");
			return (Criteria) this;
		}

		public Criteria andGradeIdIn(List<Long> values) {
			addCriterion("grade_id in", values, "gradeId");
			return (Criteria) this;
		}

		public Criteria andGradeIdNotIn(List<Long> values) {
			addCriterion("grade_id not in", values, "gradeId");
			return (Criteria) this;
		}

		public Criteria andGradeIdBetween(Long value1, Long value2) {
			addCriterion("grade_id between", value1, value2, "gradeId");
			return (Criteria) this;
		}

		public Criteria andGradeIdNotBetween(Long value1, Long value2) {
			addCriterion("grade_id not between", value1, value2, "gradeId");
			return (Criteria) this;
		}

		public Criteria andStoreBannerPathIsNull() {
			addCriterion("store_banner_path is null");
			return (Criteria) this;
		}

		public Criteria andStoreBannerPathIsNotNull() {
			addCriterion("store_banner_path is not null");
			return (Criteria) this;
		}

		public Criteria andStoreBannerPathEqualTo(String value) {
			addCriterion("store_banner_path =", value, "storeBannerPath");
			return (Criteria) this;
		}

		public Criteria andStoreBannerPathNotEqualTo(String value) {
			addCriterion("store_banner_path <>", value, "storeBannerPath");
			return (Criteria) this;
		}

		public Criteria andStoreBannerPathGreaterThan(String value) {
			addCriterion("store_banner_path >", value, "storeBannerPath");
			return (Criteria) this;
		}

		public Criteria andStoreBannerPathGreaterThanOrEqualTo(String value) {
			addCriterion("store_banner_path >=", value, "storeBannerPath");
			return (Criteria) this;
		}

		public Criteria andStoreBannerPathLessThan(String value) {
			addCriterion("store_banner_path <", value, "storeBannerPath");
			return (Criteria) this;
		}

		public Criteria andStoreBannerPathLessThanOrEqualTo(String value) {
			addCriterion("store_banner_path <=", value, "storeBannerPath");
			return (Criteria) this;
		}

		public Criteria andStoreBannerPathLike(String value) {
			addCriterion("store_banner_path like", value, "storeBannerPath");
			return (Criteria) this;
		}

		public Criteria andStoreBannerPathNotLike(String value) {
			addCriterion("store_banner_path not like", value, "storeBannerPath");
			return (Criteria) this;
		}

		public Criteria andStoreBannerPathIn(List<String> values) {
			addCriterion("store_banner_path in", values, "storeBannerPath");
			return (Criteria) this;
		}

		public Criteria andStoreBannerPathNotIn(List<String> values) {
			addCriterion("store_banner_path not in", values, "storeBannerPath");
			return (Criteria) this;
		}

		public Criteria andStoreBannerPathBetween(String value1, String value2) {
			addCriterion("store_banner_path between", value1, value2, "storeBannerPath");
			return (Criteria) this;
		}

		public Criteria andStoreBannerPathNotBetween(String value1, String value2) {
			addCriterion("store_banner_path not between", value1, value2, "storeBannerPath");
			return (Criteria) this;
		}

		public Criteria andStoreLicensePathIsNull() {
			addCriterion("store_license_path is null");
			return (Criteria) this;
		}

		public Criteria andStoreLicensePathIsNotNull() {
			addCriterion("store_license_path is not null");
			return (Criteria) this;
		}

		public Criteria andStoreLicensePathEqualTo(String value) {
			addCriterion("store_license_path =", value, "storeLicensePath");
			return (Criteria) this;
		}

		public Criteria andStoreLicensePathNotEqualTo(String value) {
			addCriterion("store_license_path <>", value, "storeLicensePath");
			return (Criteria) this;
		}

		public Criteria andStoreLicensePathGreaterThan(String value) {
			addCriterion("store_license_path >", value, "storeLicensePath");
			return (Criteria) this;
		}

		public Criteria andStoreLicensePathGreaterThanOrEqualTo(String value) {
			addCriterion("store_license_path >=", value, "storeLicensePath");
			return (Criteria) this;
		}

		public Criteria andStoreLicensePathLessThan(String value) {
			addCriterion("store_license_path <", value, "storeLicensePath");
			return (Criteria) this;
		}

		public Criteria andStoreLicensePathLessThanOrEqualTo(String value) {
			addCriterion("store_license_path <=", value, "storeLicensePath");
			return (Criteria) this;
		}

		public Criteria andStoreLicensePathLike(String value) {
			addCriterion("store_license_path like", value, "storeLicensePath");
			return (Criteria) this;
		}

		public Criteria andStoreLicensePathNotLike(String value) {
			addCriterion("store_license_path not like", value, "storeLicensePath");
			return (Criteria) this;
		}

		public Criteria andStoreLicensePathIn(List<String> values) {
			addCriterion("store_license_path in", values, "storeLicensePath");
			return (Criteria) this;
		}

		public Criteria andStoreLicensePathNotIn(List<String> values) {
			addCriterion("store_license_path not in", values, "storeLicensePath");
			return (Criteria) this;
		}

		public Criteria andStoreLicensePathBetween(String value1, String value2) {
			addCriterion("store_license_path between", value1, value2, "storeLicensePath");
			return (Criteria) this;
		}

		public Criteria andStoreLicensePathNotBetween(String value1, String value2) {
			addCriterion("store_license_path not between", value1, value2, "storeLicensePath");
			return (Criteria) this;
		}

		public Criteria andStoreLogoPathIsNull() {
			addCriterion("store_logo_path is null");
			return (Criteria) this;
		}

		public Criteria andStoreLogoPathIsNotNull() {
			addCriterion("store_logo_path is not null");
			return (Criteria) this;
		}

		public Criteria andStoreLogoPathEqualTo(String value) {
			addCriterion("store_logo_path =", value, "storeLogoPath");
			return (Criteria) this;
		}

		public Criteria andStoreLogoPathNotEqualTo(String value) {
			addCriterion("store_logo_path <>", value, "storeLogoPath");
			return (Criteria) this;
		}

		public Criteria andStoreLogoPathGreaterThan(String value) {
			addCriterion("store_logo_path >", value, "storeLogoPath");
			return (Criteria) this;
		}

		public Criteria andStoreLogoPathGreaterThanOrEqualTo(String value) {
			addCriterion("store_logo_path >=", value, "storeLogoPath");
			return (Criteria) this;
		}

		public Criteria andStoreLogoPathLessThan(String value) {
			addCriterion("store_logo_path <", value, "storeLogoPath");
			return (Criteria) this;
		}

		public Criteria andStoreLogoPathLessThanOrEqualTo(String value) {
			addCriterion("store_logo_path <=", value, "storeLogoPath");
			return (Criteria) this;
		}

		public Criteria andStoreLogoPathLike(String value) {
			addCriterion("store_logo_path like", value, "storeLogoPath");
			return (Criteria) this;
		}

		public Criteria andStoreLogoPathNotLike(String value) {
			addCriterion("store_logo_path not like", value, "storeLogoPath");
			return (Criteria) this;
		}

		public Criteria andStoreLogoPathIn(List<String> values) {
			addCriterion("store_logo_path in", values, "storeLogoPath");
			return (Criteria) this;
		}

		public Criteria andStoreLogoPathNotIn(List<String> values) {
			addCriterion("store_logo_path not in", values, "storeLogoPath");
			return (Criteria) this;
		}

		public Criteria andStoreLogoPathBetween(String value1, String value2) {
			addCriterion("store_logo_path between", value1, value2, "storeLogoPath");
			return (Criteria) this;
		}

		public Criteria andStoreLogoPathNotBetween(String value1, String value2) {
			addCriterion("store_logo_path not between", value1, value2, "storeLogoPath");
			return (Criteria) this;
		}

		public Criteria andIsShopIsNull() {
			addCriterion("is_shop is null");
			return (Criteria) this;
		}

		public Criteria andIsShopIsNotNull() {
			addCriterion("is_shop is not null");
			return (Criteria) this;
		}

		public Criteria andIsShopEqualTo(Boolean value) {
			addCriterion("is_shop =", value, "isShop");
			return (Criteria) this;
		}

		public Criteria andIsShopNotEqualTo(Boolean value) {
			addCriterion("is_shop <>", value, "isShop");
			return (Criteria) this;
		}

		public Criteria andIsShopGreaterThan(Boolean value) {
			addCriterion("is_shop >", value, "isShop");
			return (Criteria) this;
		}

		public Criteria andIsShopGreaterThanOrEqualTo(Boolean value) {
			addCriterion("is_shop >=", value, "isShop");
			return (Criteria) this;
		}

		public Criteria andIsShopLessThan(Boolean value) {
			addCriterion("is_shop <", value, "isShop");
			return (Criteria) this;
		}

		public Criteria andIsShopLessThanOrEqualTo(Boolean value) {
			addCriterion("is_shop <=", value, "isShop");
			return (Criteria) this;
		}

		public Criteria andIsShopIn(List<Boolean> values) {
			addCriterion("is_shop in", values, "isShop");
			return (Criteria) this;
		}

		public Criteria andIsShopNotIn(List<Boolean> values) {
			addCriterion("is_shop not in", values, "isShop");
			return (Criteria) this;
		}

		public Criteria andIsShopBetween(Boolean value1, Boolean value2) {
			addCriterion("is_shop between", value1, value2, "isShop");
			return (Criteria) this;
		}

		public Criteria andIsShopNotBetween(Boolean value1, Boolean value2) {
			addCriterion("is_shop not between", value1, value2, "isShop");
			return (Criteria) this;
		}

		public Criteria andIsO2oIsNull() {
			addCriterion("is_o2o is null");
			return (Criteria) this;
		}

		public Criteria andIsO2oIsNotNull() {
			addCriterion("is_o2o is not null");
			return (Criteria) this;
		}

		public Criteria andIsO2oEqualTo(Boolean value) {
			addCriterion("is_o2o =", value, "isO2o");
			return (Criteria) this;
		}

		public Criteria andIsO2oNotEqualTo(Boolean value) {
			addCriterion("is_o2o <>", value, "isO2o");
			return (Criteria) this;
		}

		public Criteria andIsO2oGreaterThan(Boolean value) {
			addCriterion("is_o2o >", value, "isO2o");
			return (Criteria) this;
		}

		public Criteria andIsO2oGreaterThanOrEqualTo(Boolean value) {
			addCriterion("is_o2o >=", value, "isO2o");
			return (Criteria) this;
		}

		public Criteria andIsO2oLessThan(Boolean value) {
			addCriterion("is_o2o <", value, "isO2o");
			return (Criteria) this;
		}

		public Criteria andIsO2oLessThanOrEqualTo(Boolean value) {
			addCriterion("is_o2o <=", value, "isO2o");
			return (Criteria) this;
		}

		public Criteria andIsO2oIn(List<Boolean> values) {
			addCriterion("is_o2o in", values, "isO2o");
			return (Criteria) this;
		}

		public Criteria andIsO2oNotIn(List<Boolean> values) {
			addCriterion("is_o2o not in", values, "isO2o");
			return (Criteria) this;
		}

		public Criteria andIsO2oBetween(Boolean value1, Boolean value2) {
			addCriterion("is_o2o between", value1, value2, "isO2o");
			return (Criteria) this;
		}

		public Criteria andIsO2oNotBetween(Boolean value1, Boolean value2) {
			addCriterion("is_o2o not between", value1, value2, "isO2o");
			return (Criteria) this;
		}

		public Criteria andStoreLatIsNull() {
			addCriterion("store_lat is null");
			return (Criteria) this;
		}

		public Criteria andStoreLatIsNotNull() {
			addCriterion("store_lat is not null");
			return (Criteria) this;
		}

		public Criteria andStoreLatEqualTo(BigDecimal value) {
			addCriterion("store_lat =", value, "storeLat");
			return (Criteria) this;
		}

		public Criteria andStoreLatNotEqualTo(BigDecimal value) {
			addCriterion("store_lat <>", value, "storeLat");
			return (Criteria) this;
		}

		public Criteria andStoreLatGreaterThan(BigDecimal value) {
			addCriterion("store_lat >", value, "storeLat");
			return (Criteria) this;
		}

		public Criteria andStoreLatGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("store_lat >=", value, "storeLat");
			return (Criteria) this;
		}

		public Criteria andStoreLatLessThan(BigDecimal value) {
			addCriterion("store_lat <", value, "storeLat");
			return (Criteria) this;
		}

		public Criteria andStoreLatLessThanOrEqualTo(BigDecimal value) {
			addCriterion("store_lat <=", value, "storeLat");
			return (Criteria) this;
		}

		public Criteria andStoreLatIn(List<BigDecimal> values) {
			addCriterion("store_lat in", values, "storeLat");
			return (Criteria) this;
		}

		public Criteria andStoreLatNotIn(List<BigDecimal> values) {
			addCriterion("store_lat not in", values, "storeLat");
			return (Criteria) this;
		}

		public Criteria andStoreLatBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("store_lat between", value1, value2, "storeLat");
			return (Criteria) this;
		}

		public Criteria andStoreLatNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("store_lat not between", value1, value2, "storeLat");
			return (Criteria) this;
		}

		public Criteria andStoreLonIsNull() {
			addCriterion("store_lon is null");
			return (Criteria) this;
		}

		public Criteria andStoreLonIsNotNull() {
			addCriterion("store_lon is not null");
			return (Criteria) this;
		}

		public Criteria andStoreLonEqualTo(BigDecimal value) {
			addCriterion("store_lon =", value, "storeLon");
			return (Criteria) this;
		}

		public Criteria andStoreLonNotEqualTo(BigDecimal value) {
			addCriterion("store_lon <>", value, "storeLon");
			return (Criteria) this;
		}

		public Criteria andStoreLonGreaterThan(BigDecimal value) {
			addCriterion("store_lon >", value, "storeLon");
			return (Criteria) this;
		}

		public Criteria andStoreLonGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("store_lon >=", value, "storeLon");
			return (Criteria) this;
		}

		public Criteria andStoreLonLessThan(BigDecimal value) {
			addCriterion("store_lon <", value, "storeLon");
			return (Criteria) this;
		}

		public Criteria andStoreLonLessThanOrEqualTo(BigDecimal value) {
			addCriterion("store_lon <=", value, "storeLon");
			return (Criteria) this;
		}

		public Criteria andStoreLonIn(List<BigDecimal> values) {
			addCriterion("store_lon in", values, "storeLon");
			return (Criteria) this;
		}

		public Criteria andStoreLonNotIn(List<BigDecimal> values) {
			addCriterion("store_lon not in", values, "storeLon");
			return (Criteria) this;
		}

		public Criteria andStoreLonBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("store_lon between", value1, value2, "storeLon");
			return (Criteria) this;
		}

		public Criteria andStoreLonNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("store_lon not between", value1, value2, "storeLon");
			return (Criteria) this;
		}

		public Criteria andInvitationCodeIsNull() {
			addCriterion("invitation_code is null");
			return (Criteria) this;
		}

		public Criteria andInvitationCodeIsNotNull() {
			addCriterion("invitation_code is not null");
			return (Criteria) this;
		}

		public Criteria andInvitationCodeEqualTo(String value) {
			addCriterion("invitation_code =", value, "invitationCode");
			return (Criteria) this;
		}

		public Criteria andInvitationCodeNotEqualTo(String value) {
			addCriterion("invitation_code <>", value, "invitationCode");
			return (Criteria) this;
		}

		public Criteria andInvitationCodeGreaterThan(String value) {
			addCriterion("invitation_code >", value, "invitationCode");
			return (Criteria) this;
		}

		public Criteria andInvitationCodeGreaterThanOrEqualTo(String value) {
			addCriterion("invitation_code >=", value, "invitationCode");
			return (Criteria) this;
		}

		public Criteria andInvitationCodeLessThan(String value) {
			addCriterion("invitation_code <", value, "invitationCode");
			return (Criteria) this;
		}

		public Criteria andInvitationCodeLessThanOrEqualTo(String value) {
			addCriterion("invitation_code <=", value, "invitationCode");
			return (Criteria) this;
		}

		public Criteria andInvitationCodeLike(String value) {
			addCriterion("invitation_code like", value, "invitationCode");
			return (Criteria) this;
		}

		public Criteria andInvitationCodeNotLike(String value) {
			addCriterion("invitation_code not like", value, "invitationCode");
			return (Criteria) this;
		}

		public Criteria andInvitationCodeIn(List<String> values) {
			addCriterion("invitation_code in", values, "invitationCode");
			return (Criteria) this;
		}

		public Criteria andInvitationCodeNotIn(List<String> values) {
			addCriterion("invitation_code not in", values, "invitationCode");
			return (Criteria) this;
		}

		public Criteria andInvitationCodeBetween(String value1, String value2) {
			addCriterion("invitation_code between", value1, value2, "invitationCode");
			return (Criteria) this;
		}

		public Criteria andInvitationCodeNotBetween(String value1, String value2) {
			addCriterion("invitation_code not between", value1, value2, "invitationCode");
			return (Criteria) this;
		}

		public Criteria andCouponPayAmountIsNull() {
			addCriterion("coupon_pay_amount is null");
			return (Criteria) this;
		}

		public Criteria andCouponPayAmountIsNotNull() {
			addCriterion("coupon_pay_amount is not null");
			return (Criteria) this;
		}

		public Criteria andCouponPayAmountEqualTo(BigDecimal value) {
			addCriterion("coupon_pay_amount =", value, "couponPayAmount");
			return (Criteria) this;
		}

		public Criteria andCouponPayAmountNotEqualTo(BigDecimal value) {
			addCriterion("coupon_pay_amount <>", value, "couponPayAmount");
			return (Criteria) this;
		}

		public Criteria andCouponPayAmountGreaterThan(BigDecimal value) {
			addCriterion("coupon_pay_amount >", value, "couponPayAmount");
			return (Criteria) this;
		}

		public Criteria andCouponPayAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("coupon_pay_amount >=", value, "couponPayAmount");
			return (Criteria) this;
		}

		public Criteria andCouponPayAmountLessThan(BigDecimal value) {
			addCriterion("coupon_pay_amount <", value, "couponPayAmount");
			return (Criteria) this;
		}

		public Criteria andCouponPayAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("coupon_pay_amount <=", value, "couponPayAmount");
			return (Criteria) this;
		}

		public Criteria andCouponPayAmountIn(List<BigDecimal> values) {
			addCriterion("coupon_pay_amount in", values, "couponPayAmount");
			return (Criteria) this;
		}

		public Criteria andCouponPayAmountNotIn(List<BigDecimal> values) {
			addCriterion("coupon_pay_amount not in", values, "couponPayAmount");
			return (Criteria) this;
		}

		public Criteria andCouponPayAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("coupon_pay_amount between", value1, value2, "couponPayAmount");
			return (Criteria) this;
		}

		public Criteria andCouponPayAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("coupon_pay_amount not between", value1, value2, "couponPayAmount");
			return (Criteria) this;
		}

		public Criteria andChargePayAmountIsNull() {
			addCriterion("charge_pay_amount is null");
			return (Criteria) this;
		}

		public Criteria andChargePayAmountIsNotNull() {
			addCriterion("charge_pay_amount is not null");
			return (Criteria) this;
		}

		public Criteria andChargePayAmountEqualTo(BigDecimal value) {
			addCriterion("charge_pay_amount =", value, "chargePayAmount");
			return (Criteria) this;
		}

		public Criteria andChargePayAmountNotEqualTo(BigDecimal value) {
			addCriterion("charge_pay_amount <>", value, "chargePayAmount");
			return (Criteria) this;
		}

		public Criteria andChargePayAmountGreaterThan(BigDecimal value) {
			addCriterion("charge_pay_amount >", value, "chargePayAmount");
			return (Criteria) this;
		}

		public Criteria andChargePayAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("charge_pay_amount >=", value, "chargePayAmount");
			return (Criteria) this;
		}

		public Criteria andChargePayAmountLessThan(BigDecimal value) {
			addCriterion("charge_pay_amount <", value, "chargePayAmount");
			return (Criteria) this;
		}

		public Criteria andChargePayAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("charge_pay_amount <=", value, "chargePayAmount");
			return (Criteria) this;
		}

		public Criteria andChargePayAmountIn(List<BigDecimal> values) {
			addCriterion("charge_pay_amount in", values, "chargePayAmount");
			return (Criteria) this;
		}

		public Criteria andChargePayAmountNotIn(List<BigDecimal> values) {
			addCriterion("charge_pay_amount not in", values, "chargePayAmount");
			return (Criteria) this;
		}

		public Criteria andChargePayAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("charge_pay_amount between", value1, value2, "chargePayAmount");
			return (Criteria) this;
		}

		public Criteria andChargePayAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("charge_pay_amount not between", value1, value2, "chargePayAmount");
			return (Criteria) this;
		}

		public Criteria andRebateAmountIsNull() {
			addCriterion("rebate_amount is null");
			return (Criteria) this;
		}

		public Criteria andRebateAmountIsNotNull() {
			addCriterion("rebate_amount is not null");
			return (Criteria) this;
		}

		public Criteria andRebateAmountEqualTo(BigDecimal value) {
			addCriterion("rebate_amount =", value, "rebateAmount");
			return (Criteria) this;
		}

		public Criteria andRebateAmountNotEqualTo(BigDecimal value) {
			addCriterion("rebate_amount <>", value, "rebateAmount");
			return (Criteria) this;
		}

		public Criteria andRebateAmountGreaterThan(BigDecimal value) {
			addCriterion("rebate_amount >", value, "rebateAmount");
			return (Criteria) this;
		}

		public Criteria andRebateAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_amount >=", value, "rebateAmount");
			return (Criteria) this;
		}

		public Criteria andRebateAmountLessThan(BigDecimal value) {
			addCriterion("rebate_amount <", value, "rebateAmount");
			return (Criteria) this;
		}

		public Criteria andRebateAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("rebate_amount <=", value, "rebateAmount");
			return (Criteria) this;
		}

		public Criteria andRebateAmountIn(List<BigDecimal> values) {
			addCriterion("rebate_amount in", values, "rebateAmount");
			return (Criteria) this;
		}

		public Criteria andRebateAmountNotIn(List<BigDecimal> values) {
			addCriterion("rebate_amount not in", values, "rebateAmount");
			return (Criteria) this;
		}

		public Criteria andRebateAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_amount between", value1, value2, "rebateAmount");
			return (Criteria) this;
		}

		public Criteria andRebateAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rebate_amount not between", value1, value2, "rebateAmount");
			return (Criteria) this;
		}

		public Criteria andCommissionRebateIsNull() {
			addCriterion("commission_rebate is null");
			return (Criteria) this;
		}

		public Criteria andCommissionRebateIsNotNull() {
			addCriterion("commission_rebate is not null");
			return (Criteria) this;
		}

		public Criteria andCommissionRebateEqualTo(BigDecimal value) {
			addCriterion("commission_rebate =", value, "commissionRebate");
			return (Criteria) this;
		}

		public Criteria andCommissionRebateNotEqualTo(BigDecimal value) {
			addCriterion("commission_rebate <>", value, "commissionRebate");
			return (Criteria) this;
		}

		public Criteria andCommissionRebateGreaterThan(BigDecimal value) {
			addCriterion("commission_rebate >", value, "commissionRebate");
			return (Criteria) this;
		}

		public Criteria andCommissionRebateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("commission_rebate >=", value, "commissionRebate");
			return (Criteria) this;
		}

		public Criteria andCommissionRebateLessThan(BigDecimal value) {
			addCriterion("commission_rebate <", value, "commissionRebate");
			return (Criteria) this;
		}

		public Criteria andCommissionRebateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("commission_rebate <=", value, "commissionRebate");
			return (Criteria) this;
		}

		public Criteria andCommissionRebateIn(List<BigDecimal> values) {
			addCriterion("commission_rebate in", values, "commissionRebate");
			return (Criteria) this;
		}

		public Criteria andCommissionRebateNotIn(List<BigDecimal> values) {
			addCriterion("commission_rebate not in", values, "commissionRebate");
			return (Criteria) this;
		}

		public Criteria andCommissionRebateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("commission_rebate between", value1, value2, "commissionRebate");
			return (Criteria) this;
		}

		public Criteria andCommissionRebateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("commission_rebate not between", value1, value2, "commissionRebate");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdIsNull() {
			addCriterion("create_user_id is null");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdIsNotNull() {
			addCriterion("create_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdEqualTo(Long value) {
			addCriterion("create_user_id =", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdNotEqualTo(Long value) {
			addCriterion("create_user_id <>", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdGreaterThan(Long value) {
			addCriterion("create_user_id >", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("create_user_id >=", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdLessThan(Long value) {
			addCriterion("create_user_id <", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdLessThanOrEqualTo(Long value) {
			addCriterion("create_user_id <=", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdIn(List<Long> values) {
			addCriterion("create_user_id in", values, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdNotIn(List<Long> values) {
			addCriterion("create_user_id not in", values, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdBetween(Long value1, Long value2) {
			addCriterion("create_user_id between", value1, value2, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdNotBetween(Long value1, Long value2) {
			addCriterion("create_user_id not between", value1, value2, "createUserId");
			return (Criteria) this;
		}

		public Criteria andEepayMidIsNull() {
			addCriterion("eepay_mid is null");
			return (Criteria) this;
		}

		public Criteria andEepayMidIsNotNull() {
			addCriterion("eepay_mid is not null");
			return (Criteria) this;
		}

		public Criteria andEepayMidEqualTo(String value) {
			addCriterion("eepay_mid =", value, "eepayMid");
			return (Criteria) this;
		}

		public Criteria andEepayMidNotEqualTo(String value) {
			addCriterion("eepay_mid <>", value, "eepayMid");
			return (Criteria) this;
		}

		public Criteria andEepayMidGreaterThan(String value) {
			addCriterion("eepay_mid >", value, "eepayMid");
			return (Criteria) this;
		}

		public Criteria andEepayMidGreaterThanOrEqualTo(String value) {
			addCriterion("eepay_mid >=", value, "eepayMid");
			return (Criteria) this;
		}

		public Criteria andEepayMidLessThan(String value) {
			addCriterion("eepay_mid <", value, "eepayMid");
			return (Criteria) this;
		}

		public Criteria andEepayMidLessThanOrEqualTo(String value) {
			addCriterion("eepay_mid <=", value, "eepayMid");
			return (Criteria) this;
		}

		public Criteria andEepayMidLike(String value) {
			addCriterion("eepay_mid like", value, "eepayMid");
			return (Criteria) this;
		}

		public Criteria andEepayMidNotLike(String value) {
			addCriterion("eepay_mid not like", value, "eepayMid");
			return (Criteria) this;
		}

		public Criteria andEepayMidIn(List<String> values) {
			addCriterion("eepay_mid in", values, "eepayMid");
			return (Criteria) this;
		}

		public Criteria andEepayMidNotIn(List<String> values) {
			addCriterion("eepay_mid not in", values, "eepayMid");
			return (Criteria) this;
		}

		public Criteria andEepayMidBetween(String value1, String value2) {
			addCriterion("eepay_mid between", value1, value2, "eepayMid");
			return (Criteria) this;
		}

		public Criteria andEepayMidNotBetween(String value1, String value2) {
			addCriterion("eepay_mid not between", value1, value2, "eepayMid");
			return (Criteria) this;
		}

		public Criteria andEepayKeyIsNull() {
			addCriterion("eepay_key is null");
			return (Criteria) this;
		}

		public Criteria andEepayKeyIsNotNull() {
			addCriterion("eepay_key is not null");
			return (Criteria) this;
		}

		public Criteria andEepayKeyEqualTo(String value) {
			addCriterion("eepay_key =", value, "eepayKey");
			return (Criteria) this;
		}

		public Criteria andEepayKeyNotEqualTo(String value) {
			addCriterion("eepay_key <>", value, "eepayKey");
			return (Criteria) this;
		}

		public Criteria andEepayKeyGreaterThan(String value) {
			addCriterion("eepay_key >", value, "eepayKey");
			return (Criteria) this;
		}

		public Criteria andEepayKeyGreaterThanOrEqualTo(String value) {
			addCriterion("eepay_key >=", value, "eepayKey");
			return (Criteria) this;
		}

		public Criteria andEepayKeyLessThan(String value) {
			addCriterion("eepay_key <", value, "eepayKey");
			return (Criteria) this;
		}

		public Criteria andEepayKeyLessThanOrEqualTo(String value) {
			addCriterion("eepay_key <=", value, "eepayKey");
			return (Criteria) this;
		}

		public Criteria andEepayKeyLike(String value) {
			addCriterion("eepay_key like", value, "eepayKey");
			return (Criteria) this;
		}

		public Criteria andEepayKeyNotLike(String value) {
			addCriterion("eepay_key not like", value, "eepayKey");
			return (Criteria) this;
		}

		public Criteria andEepayKeyIn(List<String> values) {
			addCriterion("eepay_key in", values, "eepayKey");
			return (Criteria) this;
		}

		public Criteria andEepayKeyNotIn(List<String> values) {
			addCriterion("eepay_key not in", values, "eepayKey");
			return (Criteria) this;
		}

		public Criteria andEepayKeyBetween(String value1, String value2) {
			addCriterion("eepay_key between", value1, value2, "eepayKey");
			return (Criteria) this;
		}

		public Criteria andEepayKeyNotBetween(String value1, String value2) {
			addCriterion("eepay_key not between", value1, value2, "eepayKey");
			return (Criteria) this;
		}

		public Criteria andIsEepayIsNull() {
			addCriterion("is_eepay is null");
			return (Criteria) this;
		}

		public Criteria andIsEepayIsNotNull() {
			addCriterion("is_eepay is not null");
			return (Criteria) this;
		}

		public Criteria andIsEepayEqualTo(Boolean value) {
			addCriterion("is_eepay =", value, "isEepay");
			return (Criteria) this;
		}

		public Criteria andIsEepayNotEqualTo(Boolean value) {
			addCriterion("is_eepay <>", value, "isEepay");
			return (Criteria) this;
		}

		public Criteria andIsEepayGreaterThan(Boolean value) {
			addCriterion("is_eepay >", value, "isEepay");
			return (Criteria) this;
		}

		public Criteria andIsEepayGreaterThanOrEqualTo(Boolean value) {
			addCriterion("is_eepay >=", value, "isEepay");
			return (Criteria) this;
		}

		public Criteria andIsEepayLessThan(Boolean value) {
			addCriterion("is_eepay <", value, "isEepay");
			return (Criteria) this;
		}

		public Criteria andIsEepayLessThanOrEqualTo(Boolean value) {
			addCriterion("is_eepay <=", value, "isEepay");
			return (Criteria) this;
		}

		public Criteria andIsEepayIn(List<Boolean> values) {
			addCriterion("is_eepay in", values, "isEepay");
			return (Criteria) this;
		}

		public Criteria andIsEepayNotIn(List<Boolean> values) {
			addCriterion("is_eepay not in", values, "isEepay");
			return (Criteria) this;
		}

		public Criteria andIsEepayBetween(Boolean value1, Boolean value2) {
			addCriterion("is_eepay between", value1, value2, "isEepay");
			return (Criteria) this;
		}

		public Criteria andIsEepayNotBetween(Boolean value1, Boolean value2) {
			addCriterion("is_eepay not between", value1, value2, "isEepay");
			return (Criteria) this;
		}

		public Criteria andGroupMainIdIsNull() {
			addCriterion("group_main_id is null");
			return (Criteria) this;
		}

		public Criteria andGroupMainIdIsNotNull() {
			addCriterion("group_main_id is not null");
			return (Criteria) this;
		}

		public Criteria andGroupMainIdEqualTo(Long value) {
			addCriterion("group_main_id =", value, "groupMainId");
			return (Criteria) this;
		}

		public Criteria andGroupMainIdNotEqualTo(Long value) {
			addCriterion("group_main_id <>", value, "groupMainId");
			return (Criteria) this;
		}

		public Criteria andGroupMainIdGreaterThan(Long value) {
			addCriterion("group_main_id >", value, "groupMainId");
			return (Criteria) this;
		}

		public Criteria andGroupMainIdGreaterThanOrEqualTo(Long value) {
			addCriterion("group_main_id >=", value, "groupMainId");
			return (Criteria) this;
		}

		public Criteria andGroupMainIdLessThan(Long value) {
			addCriterion("group_main_id <", value, "groupMainId");
			return (Criteria) this;
		}

		public Criteria andGroupMainIdLessThanOrEqualTo(Long value) {
			addCriterion("group_main_id <=", value, "groupMainId");
			return (Criteria) this;
		}

		public Criteria andGroupMainIdIn(List<Long> values) {
			addCriterion("group_main_id in", values, "groupMainId");
			return (Criteria) this;
		}

		public Criteria andGroupMainIdNotIn(List<Long> values) {
			addCriterion("group_main_id not in", values, "groupMainId");
			return (Criteria) this;
		}

		public Criteria andGroupMainIdBetween(Long value1, Long value2) {
			addCriterion("group_main_id between", value1, value2, "groupMainId");
			return (Criteria) this;
		}

		public Criteria andGroupMainIdNotBetween(Long value1, Long value2) {
			addCriterion("group_main_id not between", value1, value2, "groupMainId");
			return (Criteria) this;
		}

		public Criteria andGroupDetailInfoIsNull() {
			addCriterion("group_detail_info is null");
			return (Criteria) this;
		}

		public Criteria andGroupDetailInfoIsNotNull() {
			addCriterion("group_detail_info is not null");
			return (Criteria) this;
		}

		public Criteria andGroupDetailInfoEqualTo(String value) {
			addCriterion("group_detail_info =", value, "groupDetailInfo");
			return (Criteria) this;
		}

		public Criteria andGroupDetailInfoNotEqualTo(String value) {
			addCriterion("group_detail_info <>", value, "groupDetailInfo");
			return (Criteria) this;
		}

		public Criteria andGroupDetailInfoGreaterThan(String value) {
			addCriterion("group_detail_info >", value, "groupDetailInfo");
			return (Criteria) this;
		}

		public Criteria andGroupDetailInfoGreaterThanOrEqualTo(String value) {
			addCriterion("group_detail_info >=", value, "groupDetailInfo");
			return (Criteria) this;
		}

		public Criteria andGroupDetailInfoLessThan(String value) {
			addCriterion("group_detail_info <", value, "groupDetailInfo");
			return (Criteria) this;
		}

		public Criteria andGroupDetailInfoLessThanOrEqualTo(String value) {
			addCriterion("group_detail_info <=", value, "groupDetailInfo");
			return (Criteria) this;
		}

		public Criteria andGroupDetailInfoLike(String value) {
			addCriterion("group_detail_info like", value, "groupDetailInfo");
			return (Criteria) this;
		}

		public Criteria andGroupDetailInfoNotLike(String value) {
			addCriterion("group_detail_info not like", value, "groupDetailInfo");
			return (Criteria) this;
		}

		public Criteria andGroupDetailInfoIn(List<String> values) {
			addCriterion("group_detail_info in", values, "groupDetailInfo");
			return (Criteria) this;
		}

		public Criteria andGroupDetailInfoNotIn(List<String> values) {
			addCriterion("group_detail_info not in", values, "groupDetailInfo");
			return (Criteria) this;
		}

		public Criteria andGroupDetailInfoBetween(String value1, String value2) {
			addCriterion("group_detail_info between", value1, value2, "groupDetailInfo");
			return (Criteria) this;
		}

		public Criteria andGroupDetailInfoNotBetween(String value1, String value2) {
			addCriterion("group_detail_info not between", value1, value2, "groupDetailInfo");
			return (Criteria) this;
		}

		public Criteria andGroupDiscountIsNull() {
			addCriterion("group_discount is null");
			return (Criteria) this;
		}

		public Criteria andGroupDiscountIsNotNull() {
			addCriterion("group_discount is not null");
			return (Criteria) this;
		}

		public Criteria andGroupDiscountEqualTo(Integer value) {
			addCriterion("group_discount =", value, "groupDiscount");
			return (Criteria) this;
		}

		public Criteria andGroupDiscountNotEqualTo(Integer value) {
			addCriterion("group_discount <>", value, "groupDiscount");
			return (Criteria) this;
		}

		public Criteria andGroupDiscountGreaterThan(Integer value) {
			addCriterion("group_discount >", value, "groupDiscount");
			return (Criteria) this;
		}

		public Criteria andGroupDiscountGreaterThanOrEqualTo(Integer value) {
			addCriterion("group_discount >=", value, "groupDiscount");
			return (Criteria) this;
		}

		public Criteria andGroupDiscountLessThan(Integer value) {
			addCriterion("group_discount <", value, "groupDiscount");
			return (Criteria) this;
		}

		public Criteria andGroupDiscountLessThanOrEqualTo(Integer value) {
			addCriterion("group_discount <=", value, "groupDiscount");
			return (Criteria) this;
		}

		public Criteria andGroupDiscountIn(List<Integer> values) {
			addCriterion("group_discount in", values, "groupDiscount");
			return (Criteria) this;
		}

		public Criteria andGroupDiscountNotIn(List<Integer> values) {
			addCriterion("group_discount not in", values, "groupDiscount");
			return (Criteria) this;
		}

		public Criteria andGroupDiscountBetween(Integer value1, Integer value2) {
			addCriterion("group_discount between", value1, value2, "groupDiscount");
			return (Criteria) this;
		}

		public Criteria andGroupDiscountNotBetween(Integer value1, Integer value2) {
			addCriterion("group_discount not between", value1, value2, "groupDiscount");
			return (Criteria) this;
		}

		public Criteria andLicenseCMobileIsNull() {
			addCriterion("license_c_mobile is null");
			return (Criteria) this;
		}

		public Criteria andLicenseCMobileIsNotNull() {
			addCriterion("license_c_mobile is not null");
			return (Criteria) this;
		}

		public Criteria andLicenseCMobileEqualTo(String value) {
			addCriterion("license_c_mobile =", value, "licenseCMobile");
			return (Criteria) this;
		}

		public Criteria andLicenseCMobileNotEqualTo(String value) {
			addCriterion("license_c_mobile <>", value, "licenseCMobile");
			return (Criteria) this;
		}

		public Criteria andLicenseCMobileGreaterThan(String value) {
			addCriterion("license_c_mobile >", value, "licenseCMobile");
			return (Criteria) this;
		}

		public Criteria andLicenseCMobileGreaterThanOrEqualTo(String value) {
			addCriterion("license_c_mobile >=", value, "licenseCMobile");
			return (Criteria) this;
		}

		public Criteria andLicenseCMobileLessThan(String value) {
			addCriterion("license_c_mobile <", value, "licenseCMobile");
			return (Criteria) this;
		}

		public Criteria andLicenseCMobileLessThanOrEqualTo(String value) {
			addCriterion("license_c_mobile <=", value, "licenseCMobile");
			return (Criteria) this;
		}

		public Criteria andLicenseCMobileLike(String value) {
			addCriterion("license_c_mobile like", value, "licenseCMobile");
			return (Criteria) this;
		}

		public Criteria andLicenseCMobileNotLike(String value) {
			addCriterion("license_c_mobile not like", value, "licenseCMobile");
			return (Criteria) this;
		}

		public Criteria andLicenseCMobileIn(List<String> values) {
			addCriterion("license_c_mobile in", values, "licenseCMobile");
			return (Criteria) this;
		}

		public Criteria andLicenseCMobileNotIn(List<String> values) {
			addCriterion("license_c_mobile not in", values, "licenseCMobile");
			return (Criteria) this;
		}

		public Criteria andLicenseCMobileBetween(String value1, String value2) {
			addCriterion("license_c_mobile between", value1, value2, "licenseCMobile");
			return (Criteria) this;
		}

		public Criteria andLicenseCMobileNotBetween(String value1, String value2) {
			addCriterion("license_c_mobile not between", value1, value2, "licenseCMobile");
			return (Criteria) this;
		}

		public Criteria andLicenseCNameIsNull() {
			addCriterion("license_c_name is null");
			return (Criteria) this;
		}

		public Criteria andLicenseCNameIsNotNull() {
			addCriterion("license_c_name is not null");
			return (Criteria) this;
		}

		public Criteria andLicenseCNameEqualTo(String value) {
			addCriterion("license_c_name =", value, "licenseCName");
			return (Criteria) this;
		}

		public Criteria andLicenseCNameNotEqualTo(String value) {
			addCriterion("license_c_name <>", value, "licenseCName");
			return (Criteria) this;
		}

		public Criteria andLicenseCNameGreaterThan(String value) {
			addCriterion("license_c_name >", value, "licenseCName");
			return (Criteria) this;
		}

		public Criteria andLicenseCNameGreaterThanOrEqualTo(String value) {
			addCriterion("license_c_name >=", value, "licenseCName");
			return (Criteria) this;
		}

		public Criteria andLicenseCNameLessThan(String value) {
			addCriterion("license_c_name <", value, "licenseCName");
			return (Criteria) this;
		}

		public Criteria andLicenseCNameLessThanOrEqualTo(String value) {
			addCriterion("license_c_name <=", value, "licenseCName");
			return (Criteria) this;
		}

		public Criteria andLicenseCNameLike(String value) {
			addCriterion("license_c_name like", value, "licenseCName");
			return (Criteria) this;
		}

		public Criteria andLicenseCNameNotLike(String value) {
			addCriterion("license_c_name not like", value, "licenseCName");
			return (Criteria) this;
		}

		public Criteria andLicenseCNameIn(List<String> values) {
			addCriterion("license_c_name in", values, "licenseCName");
			return (Criteria) this;
		}

		public Criteria andLicenseCNameNotIn(List<String> values) {
			addCriterion("license_c_name not in", values, "licenseCName");
			return (Criteria) this;
		}

		public Criteria andLicenseCNameBetween(String value1, String value2) {
			addCriterion("license_c_name between", value1, value2, "licenseCName");
			return (Criteria) this;
		}

		public Criteria andLicenseCNameNotBetween(String value1, String value2) {
			addCriterion("license_c_name not between", value1, value2, "licenseCName");
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