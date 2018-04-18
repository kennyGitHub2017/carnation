package com.sinco.carnation.market.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RedPackageGetRecordExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public RedPackageGetRecordExample() {
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

		public Criteria andPackageIdIsNull() {
			addCriterion("package_id is null");
			return (Criteria) this;
		}

		public Criteria andPackageIdIsNotNull() {
			addCriterion("package_id is not null");
			return (Criteria) this;
		}

		public Criteria andPackageIdEqualTo(Long value) {
			addCriterion("package_id =", value, "packageId");
			return (Criteria) this;
		}

		public Criteria andPackageIdNotEqualTo(Long value) {
			addCriterion("package_id <>", value, "packageId");
			return (Criteria) this;
		}

		public Criteria andPackageIdGreaterThan(Long value) {
			addCriterion("package_id >", value, "packageId");
			return (Criteria) this;
		}

		public Criteria andPackageIdGreaterThanOrEqualTo(Long value) {
			addCriterion("package_id >=", value, "packageId");
			return (Criteria) this;
		}

		public Criteria andPackageIdLessThan(Long value) {
			addCriterion("package_id <", value, "packageId");
			return (Criteria) this;
		}

		public Criteria andPackageIdLessThanOrEqualTo(Long value) {
			addCriterion("package_id <=", value, "packageId");
			return (Criteria) this;
		}

		public Criteria andPackageIdIn(List<Long> values) {
			addCriterion("package_id in", values, "packageId");
			return (Criteria) this;
		}

		public Criteria andPackageIdNotIn(List<Long> values) {
			addCriterion("package_id not in", values, "packageId");
			return (Criteria) this;
		}

		public Criteria andPackageIdBetween(Long value1, Long value2) {
			addCriterion("package_id between", value1, value2, "packageId");
			return (Criteria) this;
		}

		public Criteria andPackageIdNotBetween(Long value1, Long value2) {
			addCriterion("package_id not between", value1, value2, "packageId");
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

		public Criteria andMoneyIsNull() {
			addCriterion("money is null");
			return (Criteria) this;
		}

		public Criteria andMoneyIsNotNull() {
			addCriterion("money is not null");
			return (Criteria) this;
		}

		public Criteria andMoneyEqualTo(BigDecimal value) {
			addCriterion("money =", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyNotEqualTo(BigDecimal value) {
			addCriterion("money <>", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyGreaterThan(BigDecimal value) {
			addCriterion("money >", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("money >=", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyLessThan(BigDecimal value) {
			addCriterion("money <", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("money <=", value, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyIn(List<BigDecimal> values) {
			addCriterion("money in", values, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyNotIn(List<BigDecimal> values) {
			addCriterion("money not in", values, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("money between", value1, value2, "money");
			return (Criteria) this;
		}

		public Criteria andMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("money not between", value1, value2, "money");
			return (Criteria) this;
		}

		public Criteria andCookIdIsNull() {
			addCriterion("cook_id is null");
			return (Criteria) this;
		}

		public Criteria andCookIdIsNotNull() {
			addCriterion("cook_id is not null");
			return (Criteria) this;
		}

		public Criteria andCookIdEqualTo(String value) {
			addCriterion("cook_id =", value, "cookId");
			return (Criteria) this;
		}

		public Criteria andCookIdNotEqualTo(String value) {
			addCriterion("cook_id <>", value, "cookId");
			return (Criteria) this;
		}

		public Criteria andCookIdGreaterThan(String value) {
			addCriterion("cook_id >", value, "cookId");
			return (Criteria) this;
		}

		public Criteria andCookIdGreaterThanOrEqualTo(String value) {
			addCriterion("cook_id >=", value, "cookId");
			return (Criteria) this;
		}

		public Criteria andCookIdLessThan(String value) {
			addCriterion("cook_id <", value, "cookId");
			return (Criteria) this;
		}

		public Criteria andCookIdLessThanOrEqualTo(String value) {
			addCriterion("cook_id <=", value, "cookId");
			return (Criteria) this;
		}

		public Criteria andCookIdLike(String value) {
			addCriterion("cook_id like", value, "cookId");
			return (Criteria) this;
		}

		public Criteria andCookIdNotLike(String value) {
			addCriterion("cook_id not like", value, "cookId");
			return (Criteria) this;
		}

		public Criteria andCookIdIn(List<String> values) {
			addCriterion("cook_id in", values, "cookId");
			return (Criteria) this;
		}

		public Criteria andCookIdNotIn(List<String> values) {
			addCriterion("cook_id not in", values, "cookId");
			return (Criteria) this;
		}

		public Criteria andCookIdBetween(String value1, String value2) {
			addCriterion("cook_id between", value1, value2, "cookId");
			return (Criteria) this;
		}

		public Criteria andCookIdNotBetween(String value1, String value2) {
			addCriterion("cook_id not between", value1, value2, "cookId");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNull() {
			addCriterion("user_id is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("user_id is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(Long value) {
			addCriterion("user_id =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(Long value) {
			addCriterion("user_id <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(Long value) {
			addCriterion("user_id >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("user_id >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(Long value) {
			addCriterion("user_id <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(Long value) {
			addCriterion("user_id <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<Long> values) {
			addCriterion("user_id in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<Long> values) {
			addCriterion("user_id not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(Long value1, Long value2) {
			addCriterion("user_id between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(Long value1, Long value2) {
			addCriterion("user_id not between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andIpIsNull() {
			addCriterion("ip is null");
			return (Criteria) this;
		}

		public Criteria andIpIsNotNull() {
			addCriterion("ip is not null");
			return (Criteria) this;
		}

		public Criteria andIpEqualTo(String value) {
			addCriterion("ip =", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotEqualTo(String value) {
			addCriterion("ip <>", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpGreaterThan(String value) {
			addCriterion("ip >", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpGreaterThanOrEqualTo(String value) {
			addCriterion("ip >=", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpLessThan(String value) {
			addCriterion("ip <", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpLessThanOrEqualTo(String value) {
			addCriterion("ip <=", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpLike(String value) {
			addCriterion("ip like", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotLike(String value) {
			addCriterion("ip not like", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpIn(List<String> values) {
			addCriterion("ip in", values, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotIn(List<String> values) {
			addCriterion("ip not in", values, "ip");
			return (Criteria) this;
		}

		public Criteria andIpBetween(String value1, String value2) {
			addCriterion("ip between", value1, value2, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotBetween(String value1, String value2) {
			addCriterion("ip not between", value1, value2, "ip");
			return (Criteria) this;
		}

		public Criteria andStatusIsNull() {
			addCriterion("status is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("status is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(Byte value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(Byte value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(Byte value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(Byte value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(Byte value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<Byte> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<Byte> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(Byte value1, Byte value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("status not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeIsNull() {
			addCriterion("created_time is null");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeIsNotNull() {
			addCriterion("created_time is not null");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeEqualTo(Date value) {
			addCriterion("created_time =", value, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeNotEqualTo(Date value) {
			addCriterion("created_time <>", value, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeGreaterThan(Date value) {
			addCriterion("created_time >", value, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("created_time >=", value, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeLessThan(Date value) {
			addCriterion("created_time <", value, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
			addCriterion("created_time <=", value, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeIn(List<Date> values) {
			addCriterion("created_time in", values, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeNotIn(List<Date> values) {
			addCriterion("created_time not in", values, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeBetween(Date value1, Date value2) {
			addCriterion("created_time between", value1, value2, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
			addCriterion("created_time not between", value1, value2, "createdTime");
			return (Criteria) this;
		}

		public Criteria andOpenTimeIsNull() {
			addCriterion("open_time is null");
			return (Criteria) this;
		}

		public Criteria andOpenTimeIsNotNull() {
			addCriterion("open_time is not null");
			return (Criteria) this;
		}

		public Criteria andOpenTimeEqualTo(Date value) {
			addCriterion("open_time =", value, "openTime");
			return (Criteria) this;
		}

		public Criteria andOpenTimeNotEqualTo(Date value) {
			addCriterion("open_time <>", value, "openTime");
			return (Criteria) this;
		}

		public Criteria andOpenTimeGreaterThan(Date value) {
			addCriterion("open_time >", value, "openTime");
			return (Criteria) this;
		}

		public Criteria andOpenTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("open_time >=", value, "openTime");
			return (Criteria) this;
		}

		public Criteria andOpenTimeLessThan(Date value) {
			addCriterion("open_time <", value, "openTime");
			return (Criteria) this;
		}

		public Criteria andOpenTimeLessThanOrEqualTo(Date value) {
			addCriterion("open_time <=", value, "openTime");
			return (Criteria) this;
		}

		public Criteria andOpenTimeIn(List<Date> values) {
			addCriterion("open_time in", values, "openTime");
			return (Criteria) this;
		}

		public Criteria andOpenTimeNotIn(List<Date> values) {
			addCriterion("open_time not in", values, "openTime");
			return (Criteria) this;
		}

		public Criteria andOpenTimeBetween(Date value1, Date value2) {
			addCriterion("open_time between", value1, value2, "openTime");
			return (Criteria) this;
		}

		public Criteria andOpenTimeNotBetween(Date value1, Date value2) {
			addCriterion("open_time not between", value1, value2, "openTime");
			return (Criteria) this;
		}

		public Criteria andGetTimeIsNull() {
			addCriterion("get_time is null");
			return (Criteria) this;
		}

		public Criteria andGetTimeIsNotNull() {
			addCriterion("get_time is not null");
			return (Criteria) this;
		}

		public Criteria andGetTimeEqualTo(Date value) {
			addCriterion("get_time =", value, "getTime");
			return (Criteria) this;
		}

		public Criteria andGetTimeNotEqualTo(Date value) {
			addCriterion("get_time <>", value, "getTime");
			return (Criteria) this;
		}

		public Criteria andGetTimeGreaterThan(Date value) {
			addCriterion("get_time >", value, "getTime");
			return (Criteria) this;
		}

		public Criteria andGetTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("get_time >=", value, "getTime");
			return (Criteria) this;
		}

		public Criteria andGetTimeLessThan(Date value) {
			addCriterion("get_time <", value, "getTime");
			return (Criteria) this;
		}

		public Criteria andGetTimeLessThanOrEqualTo(Date value) {
			addCriterion("get_time <=", value, "getTime");
			return (Criteria) this;
		}

		public Criteria andGetTimeIn(List<Date> values) {
			addCriterion("get_time in", values, "getTime");
			return (Criteria) this;
		}

		public Criteria andGetTimeNotIn(List<Date> values) {
			addCriterion("get_time not in", values, "getTime");
			return (Criteria) this;
		}

		public Criteria andGetTimeBetween(Date value1, Date value2) {
			addCriterion("get_time between", value1, value2, "getTime");
			return (Criteria) this;
		}

		public Criteria andGetTimeNotBetween(Date value1, Date value2) {
			addCriterion("get_time not between", value1, value2, "getTime");
			return (Criteria) this;
		}

		public Criteria andOffTimeIsNull() {
			addCriterion("off_time is null");
			return (Criteria) this;
		}

		public Criteria andOffTimeIsNotNull() {
			addCriterion("off_time is not null");
			return (Criteria) this;
		}

		public Criteria andOffTimeEqualTo(Date value) {
			addCriterion("off_time =", value, "offTime");
			return (Criteria) this;
		}

		public Criteria andOffTimeNotEqualTo(Date value) {
			addCriterion("off_time <>", value, "offTime");
			return (Criteria) this;
		}

		public Criteria andOffTimeGreaterThan(Date value) {
			addCriterion("off_time >", value, "offTime");
			return (Criteria) this;
		}

		public Criteria andOffTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("off_time >=", value, "offTime");
			return (Criteria) this;
		}

		public Criteria andOffTimeLessThan(Date value) {
			addCriterion("off_time <", value, "offTime");
			return (Criteria) this;
		}

		public Criteria andOffTimeLessThanOrEqualTo(Date value) {
			addCriterion("off_time <=", value, "offTime");
			return (Criteria) this;
		}

		public Criteria andOffTimeIn(List<Date> values) {
			addCriterion("off_time in", values, "offTime");
			return (Criteria) this;
		}

		public Criteria andOffTimeNotIn(List<Date> values) {
			addCriterion("off_time not in", values, "offTime");
			return (Criteria) this;
		}

		public Criteria andOffTimeBetween(Date value1, Date value2) {
			addCriterion("off_time between", value1, value2, "offTime");
			return (Criteria) this;
		}

		public Criteria andOffTimeNotBetween(Date value1, Date value2) {
			addCriterion("off_time not between", value1, value2, "offTime");
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

		public Criteria andDeleteStatusEqualTo(Byte value) {
			addCriterion("delete_status =", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotEqualTo(Byte value) {
			addCriterion("delete_status <>", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThan(Byte value) {
			addCriterion("delete_status >", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("delete_status >=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThan(Byte value) {
			addCriterion("delete_status <", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThanOrEqualTo(Byte value) {
			addCriterion("delete_status <=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusIn(List<Byte> values) {
			addCriterion("delete_status in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotIn(List<Byte> values) {
			addCriterion("delete_status not in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusBetween(Byte value1, Byte value2) {
			addCriterion("delete_status between", value1, value2, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("delete_status not between", value1, value2, "deleteStatus");
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