package com.sinco.carnation.user.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManagerExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public ManagerExample() {
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

		public Criteria andUidIsNull() {
			addCriterion("uid is null");
			return (Criteria) this;
		}

		public Criteria andUidIsNotNull() {
			addCriterion("uid is not null");
			return (Criteria) this;
		}

		public Criteria andUidEqualTo(Long value) {
			addCriterion("uid =", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidNotEqualTo(Long value) {
			addCriterion("uid <>", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidGreaterThan(Long value) {
			addCriterion("uid >", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidGreaterThanOrEqualTo(Long value) {
			addCriterion("uid >=", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidLessThan(Long value) {
			addCriterion("uid <", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidLessThanOrEqualTo(Long value) {
			addCriterion("uid <=", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidIn(List<Long> values) {
			addCriterion("uid in", values, "uid");
			return (Criteria) this;
		}

		public Criteria andUidNotIn(List<Long> values) {
			addCriterion("uid not in", values, "uid");
			return (Criteria) this;
		}

		public Criteria andUidBetween(Long value1, Long value2) {
			addCriterion("uid between", value1, value2, "uid");
			return (Criteria) this;
		}

		public Criteria andUidNotBetween(Long value1, Long value2) {
			addCriterion("uid not between", value1, value2, "uid");
			return (Criteria) this;
		}

		public Criteria andNoIsNull() {
			addCriterion("no is null");
			return (Criteria) this;
		}

		public Criteria andNoIsNotNull() {
			addCriterion("no is not null");
			return (Criteria) this;
		}

		public Criteria andNoEqualTo(String value) {
			addCriterion("no =", value, "no");
			return (Criteria) this;
		}

		public Criteria andNoNotEqualTo(String value) {
			addCriterion("no <>", value, "no");
			return (Criteria) this;
		}

		public Criteria andNoGreaterThan(String value) {
			addCriterion("no >", value, "no");
			return (Criteria) this;
		}

		public Criteria andNoGreaterThanOrEqualTo(String value) {
			addCriterion("no >=", value, "no");
			return (Criteria) this;
		}

		public Criteria andNoLessThan(String value) {
			addCriterion("no <", value, "no");
			return (Criteria) this;
		}

		public Criteria andNoLessThanOrEqualTo(String value) {
			addCriterion("no <=", value, "no");
			return (Criteria) this;
		}

		public Criteria andNoLike(String value) {
			addCriterion("no like", value, "no");
			return (Criteria) this;
		}

		public Criteria andNoNotLike(String value) {
			addCriterion("no not like", value, "no");
			return (Criteria) this;
		}

		public Criteria andNoIn(List<String> values) {
			addCriterion("no in", values, "no");
			return (Criteria) this;
		}

		public Criteria andNoNotIn(List<String> values) {
			addCriterion("no not in", values, "no");
			return (Criteria) this;
		}

		public Criteria andNoBetween(String value1, String value2) {
			addCriterion("no between", value1, value2, "no");
			return (Criteria) this;
		}

		public Criteria andNoNotBetween(String value1, String value2) {
			addCriterion("no not between", value1, value2, "no");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("name is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("name is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("name =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("name <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("name >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("name >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("name <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("name <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("name like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("name not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("name in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("name not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("name between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("name not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andEmailIsNull() {
			addCriterion("email is null");
			return (Criteria) this;
		}

		public Criteria andEmailIsNotNull() {
			addCriterion("email is not null");
			return (Criteria) this;
		}

		public Criteria andEmailEqualTo(String value) {
			addCriterion("email =", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotEqualTo(String value) {
			addCriterion("email <>", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThan(String value) {
			addCriterion("email >", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThanOrEqualTo(String value) {
			addCriterion("email >=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThan(String value) {
			addCriterion("email <", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThanOrEqualTo(String value) {
			addCriterion("email <=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLike(String value) {
			addCriterion("email like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotLike(String value) {
			addCriterion("email not like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailIn(List<String> values) {
			addCriterion("email in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotIn(List<String> values) {
			addCriterion("email not in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailBetween(String value1, String value2) {
			addCriterion("email between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotBetween(String value1, String value2) {
			addCriterion("email not between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andPhoneIsNull() {
			addCriterion("phone is null");
			return (Criteria) this;
		}

		public Criteria andPhoneIsNotNull() {
			addCriterion("phone is not null");
			return (Criteria) this;
		}

		public Criteria andPhoneEqualTo(String value) {
			addCriterion("phone =", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotEqualTo(String value) {
			addCriterion("phone <>", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneGreaterThan(String value) {
			addCriterion("phone >", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("phone >=", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneLessThan(String value) {
			addCriterion("phone <", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneLessThanOrEqualTo(String value) {
			addCriterion("phone <=", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneLike(String value) {
			addCriterion("phone like", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotLike(String value) {
			addCriterion("phone not like", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneIn(List<String> values) {
			addCriterion("phone in", values, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotIn(List<String> values) {
			addCriterion("phone not in", values, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneBetween(String value1, String value2) {
			addCriterion("phone between", value1, value2, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotBetween(String value1, String value2) {
			addCriterion("phone not between", value1, value2, "phone");
			return (Criteria) this;
		}

		public Criteria andMobileIsNull() {
			addCriterion("mobile is null");
			return (Criteria) this;
		}

		public Criteria andMobileIsNotNull() {
			addCriterion("mobile is not null");
			return (Criteria) this;
		}

		public Criteria andMobileEqualTo(String value) {
			addCriterion("mobile =", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotEqualTo(String value) {
			addCriterion("mobile <>", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileGreaterThan(String value) {
			addCriterion("mobile >", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileGreaterThanOrEqualTo(String value) {
			addCriterion("mobile >=", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLessThan(String value) {
			addCriterion("mobile <", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLessThanOrEqualTo(String value) {
			addCriterion("mobile <=", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLike(String value) {
			addCriterion("mobile like", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotLike(String value) {
			addCriterion("mobile not like", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileIn(List<String> values) {
			addCriterion("mobile in", values, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotIn(List<String> values) {
			addCriterion("mobile not in", values, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileBetween(String value1, String value2) {
			addCriterion("mobile between", value1, value2, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotBetween(String value1, String value2) {
			addCriterion("mobile not between", value1, value2, "mobile");
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

		public Criteria andCreateByEqualTo(String value) {
			addCriterion("create_by =", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByNotEqualTo(String value) {
			addCriterion("create_by <>", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByGreaterThan(String value) {
			addCriterion("create_by >", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByGreaterThanOrEqualTo(String value) {
			addCriterion("create_by >=", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByLessThan(String value) {
			addCriterion("create_by <", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByLessThanOrEqualTo(String value) {
			addCriterion("create_by <=", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByLike(String value) {
			addCriterion("create_by like", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByNotLike(String value) {
			addCriterion("create_by not like", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByIn(List<String> values) {
			addCriterion("create_by in", values, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByNotIn(List<String> values) {
			addCriterion("create_by not in", values, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByBetween(String value1, String value2) {
			addCriterion("create_by between", value1, value2, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByNotBetween(String value1, String value2) {
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

		public Criteria andUpdateByIsNull() {
			addCriterion("update_by is null");
			return (Criteria) this;
		}

		public Criteria andUpdateByIsNotNull() {
			addCriterion("update_by is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateByEqualTo(String value) {
			addCriterion("update_by =", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByNotEqualTo(String value) {
			addCriterion("update_by <>", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByGreaterThan(String value) {
			addCriterion("update_by >", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
			addCriterion("update_by >=", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByLessThan(String value) {
			addCriterion("update_by <", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByLessThanOrEqualTo(String value) {
			addCriterion("update_by <=", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByLike(String value) {
			addCriterion("update_by like", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByNotLike(String value) {
			addCriterion("update_by not like", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByIn(List<String> values) {
			addCriterion("update_by in", values, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByNotIn(List<String> values) {
			addCriterion("update_by not in", values, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByBetween(String value1, String value2) {
			addCriterion("update_by between", value1, value2, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByNotBetween(String value1, String value2) {
			addCriterion("update_by not between", value1, value2, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNull() {
			addCriterion("update_time is null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNotNull() {
			addCriterion("update_time is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeEqualTo(Date value) {
			addCriterion("update_time =", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotEqualTo(Date value) {
			addCriterion("update_time <>", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThan(Date value) {
			addCriterion("update_time >", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("update_time >=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThan(Date value) {
			addCriterion("update_time <", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
			addCriterion("update_time <=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIn(List<Date> values) {
			addCriterion("update_time in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotIn(List<Date> values) {
			addCriterion("update_time not in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeBetween(Date value1, Date value2) {
			addCriterion("update_time between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
			addCriterion("update_time not between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andRemarksIsNull() {
			addCriterion("remarks is null");
			return (Criteria) this;
		}

		public Criteria andRemarksIsNotNull() {
			addCriterion("remarks is not null");
			return (Criteria) this;
		}

		public Criteria andRemarksEqualTo(String value) {
			addCriterion("remarks =", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksNotEqualTo(String value) {
			addCriterion("remarks <>", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksGreaterThan(String value) {
			addCriterion("remarks >", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksGreaterThanOrEqualTo(String value) {
			addCriterion("remarks >=", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksLessThan(String value) {
			addCriterion("remarks <", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksLessThanOrEqualTo(String value) {
			addCriterion("remarks <=", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksLike(String value) {
			addCriterion("remarks like", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksNotLike(String value) {
			addCriterion("remarks not like", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksIn(List<String> values) {
			addCriterion("remarks in", values, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksNotIn(List<String> values) {
			addCriterion("remarks not in", values, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksBetween(String value1, String value2) {
			addCriterion("remarks between", value1, value2, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksNotBetween(String value1, String value2) {
			addCriterion("remarks not between", value1, value2, "remarks");
			return (Criteria) this;
		}

		public Criteria andIsDeletedIsNull() {
			addCriterion("is_deleted is null");
			return (Criteria) this;
		}

		public Criteria andIsDeletedIsNotNull() {
			addCriterion("is_deleted is not null");
			return (Criteria) this;
		}

		public Criteria andIsDeletedEqualTo(Boolean value) {
			addCriterion("is_deleted =", value, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedNotEqualTo(Boolean value) {
			addCriterion("is_deleted <>", value, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedGreaterThan(Boolean value) {
			addCriterion("is_deleted >", value, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedGreaterThanOrEqualTo(Boolean value) {
			addCriterion("is_deleted >=", value, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedLessThan(Boolean value) {
			addCriterion("is_deleted <", value, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedLessThanOrEqualTo(Boolean value) {
			addCriterion("is_deleted <=", value, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedIn(List<Boolean> values) {
			addCriterion("is_deleted in", values, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedNotIn(List<Boolean> values) {
			addCriterion("is_deleted not in", values, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedBetween(Boolean value1, Boolean value2) {
			addCriterion("is_deleted between", value1, value2, "isDeleted");
			return (Criteria) this;
		}

		public Criteria andIsDeletedNotBetween(Boolean value1, Boolean value2) {
			addCriterion("is_deleted not between", value1, value2, "isDeleted");
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