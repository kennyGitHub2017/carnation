package com.sinco.carnation.market.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActMarketCouponExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public ActMarketCouponExample() {
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

		public Criteria andVcodeIsNull() {
			addCriterion("vcode is null");
			return (Criteria) this;
		}

		public Criteria andVcodeIsNotNull() {
			addCriterion("vcode is not null");
			return (Criteria) this;
		}

		public Criteria andVcodeEqualTo(String value) {
			addCriterion("vcode =", value, "vcode");
			return (Criteria) this;
		}

		public Criteria andVcodeNotEqualTo(String value) {
			addCriterion("vcode <>", value, "vcode");
			return (Criteria) this;
		}

		public Criteria andVcodeGreaterThan(String value) {
			addCriterion("vcode >", value, "vcode");
			return (Criteria) this;
		}

		public Criteria andVcodeGreaterThanOrEqualTo(String value) {
			addCriterion("vcode >=", value, "vcode");
			return (Criteria) this;
		}

		public Criteria andVcodeLessThan(String value) {
			addCriterion("vcode <", value, "vcode");
			return (Criteria) this;
		}

		public Criteria andVcodeLessThanOrEqualTo(String value) {
			addCriterion("vcode <=", value, "vcode");
			return (Criteria) this;
		}

		public Criteria andVcodeLike(String value) {
			addCriterion("vcode like", value, "vcode");
			return (Criteria) this;
		}

		public Criteria andVcodeNotLike(String value) {
			addCriterion("vcode not like", value, "vcode");
			return (Criteria) this;
		}

		public Criteria andVcodeIn(List<String> values) {
			addCriterion("vcode in", values, "vcode");
			return (Criteria) this;
		}

		public Criteria andVcodeNotIn(List<String> values) {
			addCriterion("vcode not in", values, "vcode");
			return (Criteria) this;
		}

		public Criteria andVcodeBetween(String value1, String value2) {
			addCriterion("vcode between", value1, value2, "vcode");
			return (Criteria) this;
		}

		public Criteria andVcodeNotBetween(String value1, String value2) {
			addCriterion("vcode not between", value1, value2, "vcode");
			return (Criteria) this;
		}

		public Criteria andMinMoneyIsNull() {
			addCriterion("min_money is null");
			return (Criteria) this;
		}

		public Criteria andMinMoneyIsNotNull() {
			addCriterion("min_money is not null");
			return (Criteria) this;
		}

		public Criteria andMinMoneyEqualTo(BigDecimal value) {
			addCriterion("min_money =", value, "minMoney");
			return (Criteria) this;
		}

		public Criteria andMinMoneyNotEqualTo(BigDecimal value) {
			addCriterion("min_money <>", value, "minMoney");
			return (Criteria) this;
		}

		public Criteria andMinMoneyGreaterThan(BigDecimal value) {
			addCriterion("min_money >", value, "minMoney");
			return (Criteria) this;
		}

		public Criteria andMinMoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("min_money >=", value, "minMoney");
			return (Criteria) this;
		}

		public Criteria andMinMoneyLessThan(BigDecimal value) {
			addCriterion("min_money <", value, "minMoney");
			return (Criteria) this;
		}

		public Criteria andMinMoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("min_money <=", value, "minMoney");
			return (Criteria) this;
		}

		public Criteria andMinMoneyIn(List<BigDecimal> values) {
			addCriterion("min_money in", values, "minMoney");
			return (Criteria) this;
		}

		public Criteria andMinMoneyNotIn(List<BigDecimal> values) {
			addCriterion("min_money not in", values, "minMoney");
			return (Criteria) this;
		}

		public Criteria andMinMoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("min_money between", value1, value2, "minMoney");
			return (Criteria) this;
		}

		public Criteria andMinMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("min_money not between", value1, value2, "minMoney");
			return (Criteria) this;
		}

		public Criteria andSchemeNameIsNull() {
			addCriterion("scheme_name is null");
			return (Criteria) this;
		}

		public Criteria andSchemeNameIsNotNull() {
			addCriterion("scheme_name is not null");
			return (Criteria) this;
		}

		public Criteria andSchemeNameEqualTo(String value) {
			addCriterion("scheme_name =", value, "schemeName");
			return (Criteria) this;
		}

		public Criteria andSchemeNameNotEqualTo(String value) {
			addCriterion("scheme_name <>", value, "schemeName");
			return (Criteria) this;
		}

		public Criteria andSchemeNameGreaterThan(String value) {
			addCriterion("scheme_name >", value, "schemeName");
			return (Criteria) this;
		}

		public Criteria andSchemeNameGreaterThanOrEqualTo(String value) {
			addCriterion("scheme_name >=", value, "schemeName");
			return (Criteria) this;
		}

		public Criteria andSchemeNameLessThan(String value) {
			addCriterion("scheme_name <", value, "schemeName");
			return (Criteria) this;
		}

		public Criteria andSchemeNameLessThanOrEqualTo(String value) {
			addCriterion("scheme_name <=", value, "schemeName");
			return (Criteria) this;
		}

		public Criteria andSchemeNameLike(String value) {
			addCriterion("scheme_name like", value, "schemeName");
			return (Criteria) this;
		}

		public Criteria andSchemeNameNotLike(String value) {
			addCriterion("scheme_name not like", value, "schemeName");
			return (Criteria) this;
		}

		public Criteria andSchemeNameIn(List<String> values) {
			addCriterion("scheme_name in", values, "schemeName");
			return (Criteria) this;
		}

		public Criteria andSchemeNameNotIn(List<String> values) {
			addCriterion("scheme_name not in", values, "schemeName");
			return (Criteria) this;
		}

		public Criteria andSchemeNameBetween(String value1, String value2) {
			addCriterion("scheme_name between", value1, value2, "schemeName");
			return (Criteria) this;
		}

		public Criteria andSchemeNameNotBetween(String value1, String value2) {
			addCriterion("scheme_name not between", value1, value2, "schemeName");
			return (Criteria) this;
		}

		public Criteria andCurrentOpenCountIsNull() {
			addCriterion("current_open_count is null");
			return (Criteria) this;
		}

		public Criteria andCurrentOpenCountIsNotNull() {
			addCriterion("current_open_count is not null");
			return (Criteria) this;
		}

		public Criteria andCurrentOpenCountEqualTo(Long value) {
			addCriterion("current_open_count =", value, "currentOpenCount");
			return (Criteria) this;
		}

		public Criteria andCurrentOpenCountNotEqualTo(Long value) {
			addCriterion("current_open_count <>", value, "currentOpenCount");
			return (Criteria) this;
		}

		public Criteria andCurrentOpenCountGreaterThan(Long value) {
			addCriterion("current_open_count >", value, "currentOpenCount");
			return (Criteria) this;
		}

		public Criteria andCurrentOpenCountGreaterThanOrEqualTo(Long value) {
			addCriterion("current_open_count >=", value, "currentOpenCount");
			return (Criteria) this;
		}

		public Criteria andCurrentOpenCountLessThan(Long value) {
			addCriterion("current_open_count <", value, "currentOpenCount");
			return (Criteria) this;
		}

		public Criteria andCurrentOpenCountLessThanOrEqualTo(Long value) {
			addCriterion("current_open_count <=", value, "currentOpenCount");
			return (Criteria) this;
		}

		public Criteria andCurrentOpenCountIn(List<Long> values) {
			addCriterion("current_open_count in", values, "currentOpenCount");
			return (Criteria) this;
		}

		public Criteria andCurrentOpenCountNotIn(List<Long> values) {
			addCriterion("current_open_count not in", values, "currentOpenCount");
			return (Criteria) this;
		}

		public Criteria andCurrentOpenCountBetween(Long value1, Long value2) {
			addCriterion("current_open_count between", value1, value2, "currentOpenCount");
			return (Criteria) this;
		}

		public Criteria andCurrentOpenCountNotBetween(Long value1, Long value2) {
			addCriterion("current_open_count not between", value1, value2, "currentOpenCount");
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

		public Criteria andPreStartIsNull() {
			addCriterion("pre_start is null");
			return (Criteria) this;
		}

		public Criteria andPreStartIsNotNull() {
			addCriterion("pre_start is not null");
			return (Criteria) this;
		}

		public Criteria andPreStartEqualTo(Date value) {
			addCriterion("pre_start =", value, "preStart");
			return (Criteria) this;
		}

		public Criteria andPreStartNotEqualTo(Date value) {
			addCriterion("pre_start <>", value, "preStart");
			return (Criteria) this;
		}

		public Criteria andPreStartGreaterThan(Date value) {
			addCriterion("pre_start >", value, "preStart");
			return (Criteria) this;
		}

		public Criteria andPreStartGreaterThanOrEqualTo(Date value) {
			addCriterion("pre_start >=", value, "preStart");
			return (Criteria) this;
		}

		public Criteria andPreStartLessThan(Date value) {
			addCriterion("pre_start <", value, "preStart");
			return (Criteria) this;
		}

		public Criteria andPreStartLessThanOrEqualTo(Date value) {
			addCriterion("pre_start <=", value, "preStart");
			return (Criteria) this;
		}

		public Criteria andPreStartIn(List<Date> values) {
			addCriterion("pre_start in", values, "preStart");
			return (Criteria) this;
		}

		public Criteria andPreStartNotIn(List<Date> values) {
			addCriterion("pre_start not in", values, "preStart");
			return (Criteria) this;
		}

		public Criteria andPreStartBetween(Date value1, Date value2) {
			addCriterion("pre_start between", value1, value2, "preStart");
			return (Criteria) this;
		}

		public Criteria andPreStartNotBetween(Date value1, Date value2) {
			addCriterion("pre_start not between", value1, value2, "preStart");
			return (Criteria) this;
		}

		public Criteria andPreEndIsNull() {
			addCriterion("pre_end is null");
			return (Criteria) this;
		}

		public Criteria andPreEndIsNotNull() {
			addCriterion("pre_end is not null");
			return (Criteria) this;
		}

		public Criteria andPreEndEqualTo(Date value) {
			addCriterion("pre_end =", value, "preEnd");
			return (Criteria) this;
		}

		public Criteria andPreEndNotEqualTo(Date value) {
			addCriterion("pre_end <>", value, "preEnd");
			return (Criteria) this;
		}

		public Criteria andPreEndGreaterThan(Date value) {
			addCriterion("pre_end >", value, "preEnd");
			return (Criteria) this;
		}

		public Criteria andPreEndGreaterThanOrEqualTo(Date value) {
			addCriterion("pre_end >=", value, "preEnd");
			return (Criteria) this;
		}

		public Criteria andPreEndLessThan(Date value) {
			addCriterion("pre_end <", value, "preEnd");
			return (Criteria) this;
		}

		public Criteria andPreEndLessThanOrEqualTo(Date value) {
			addCriterion("pre_end <=", value, "preEnd");
			return (Criteria) this;
		}

		public Criteria andPreEndIn(List<Date> values) {
			addCriterion("pre_end in", values, "preEnd");
			return (Criteria) this;
		}

		public Criteria andPreEndNotIn(List<Date> values) {
			addCriterion("pre_end not in", values, "preEnd");
			return (Criteria) this;
		}

		public Criteria andPreEndBetween(Date value1, Date value2) {
			addCriterion("pre_end between", value1, value2, "preEnd");
			return (Criteria) this;
		}

		public Criteria andPreEndNotBetween(Date value1, Date value2) {
			addCriterion("pre_end not between", value1, value2, "preEnd");
			return (Criteria) this;
		}

		public Criteria andGetStartIsNull() {
			addCriterion("get_start is null");
			return (Criteria) this;
		}

		public Criteria andGetStartIsNotNull() {
			addCriterion("get_start is not null");
			return (Criteria) this;
		}

		public Criteria andGetStartEqualTo(Date value) {
			addCriterion("get_start =", value, "getStart");
			return (Criteria) this;
		}

		public Criteria andGetStartNotEqualTo(Date value) {
			addCriterion("get_start <>", value, "getStart");
			return (Criteria) this;
		}

		public Criteria andGetStartGreaterThan(Date value) {
			addCriterion("get_start >", value, "getStart");
			return (Criteria) this;
		}

		public Criteria andGetStartGreaterThanOrEqualTo(Date value) {
			addCriterion("get_start >=", value, "getStart");
			return (Criteria) this;
		}

		public Criteria andGetStartLessThan(Date value) {
			addCriterion("get_start <", value, "getStart");
			return (Criteria) this;
		}

		public Criteria andGetStartLessThanOrEqualTo(Date value) {
			addCriterion("get_start <=", value, "getStart");
			return (Criteria) this;
		}

		public Criteria andGetStartIn(List<Date> values) {
			addCriterion("get_start in", values, "getStart");
			return (Criteria) this;
		}

		public Criteria andGetStartNotIn(List<Date> values) {
			addCriterion("get_start not in", values, "getStart");
			return (Criteria) this;
		}

		public Criteria andGetStartBetween(Date value1, Date value2) {
			addCriterion("get_start between", value1, value2, "getStart");
			return (Criteria) this;
		}

		public Criteria andGetStartNotBetween(Date value1, Date value2) {
			addCriterion("get_start not between", value1, value2, "getStart");
			return (Criteria) this;
		}

		public Criteria andGetEndIsNull() {
			addCriterion("get_end is null");
			return (Criteria) this;
		}

		public Criteria andGetEndIsNotNull() {
			addCriterion("get_end is not null");
			return (Criteria) this;
		}

		public Criteria andGetEndEqualTo(Date value) {
			addCriterion("get_end =", value, "getEnd");
			return (Criteria) this;
		}

		public Criteria andGetEndNotEqualTo(Date value) {
			addCriterion("get_end <>", value, "getEnd");
			return (Criteria) this;
		}

		public Criteria andGetEndGreaterThan(Date value) {
			addCriterion("get_end >", value, "getEnd");
			return (Criteria) this;
		}

		public Criteria andGetEndGreaterThanOrEqualTo(Date value) {
			addCriterion("get_end >=", value, "getEnd");
			return (Criteria) this;
		}

		public Criteria andGetEndLessThan(Date value) {
			addCriterion("get_end <", value, "getEnd");
			return (Criteria) this;
		}

		public Criteria andGetEndLessThanOrEqualTo(Date value) {
			addCriterion("get_end <=", value, "getEnd");
			return (Criteria) this;
		}

		public Criteria andGetEndIn(List<Date> values) {
			addCriterion("get_end in", values, "getEnd");
			return (Criteria) this;
		}

		public Criteria andGetEndNotIn(List<Date> values) {
			addCriterion("get_end not in", values, "getEnd");
			return (Criteria) this;
		}

		public Criteria andGetEndBetween(Date value1, Date value2) {
			addCriterion("get_end between", value1, value2, "getEnd");
			return (Criteria) this;
		}

		public Criteria andGetEndNotBetween(Date value1, Date value2) {
			addCriterion("get_end not between", value1, value2, "getEnd");
			return (Criteria) this;
		}

		public Criteria andUseStartIsNull() {
			addCriterion("use_start is null");
			return (Criteria) this;
		}

		public Criteria andUseStartIsNotNull() {
			addCriterion("use_start is not null");
			return (Criteria) this;
		}

		public Criteria andUseStartEqualTo(Date value) {
			addCriterion("use_start =", value, "useStart");
			return (Criteria) this;
		}

		public Criteria andUseStartNotEqualTo(Date value) {
			addCriterion("use_start <>", value, "useStart");
			return (Criteria) this;
		}

		public Criteria andUseStartGreaterThan(Date value) {
			addCriterion("use_start >", value, "useStart");
			return (Criteria) this;
		}

		public Criteria andUseStartGreaterThanOrEqualTo(Date value) {
			addCriterion("use_start >=", value, "useStart");
			return (Criteria) this;
		}

		public Criteria andUseStartLessThan(Date value) {
			addCriterion("use_start <", value, "useStart");
			return (Criteria) this;
		}

		public Criteria andUseStartLessThanOrEqualTo(Date value) {
			addCriterion("use_start <=", value, "useStart");
			return (Criteria) this;
		}

		public Criteria andUseStartIn(List<Date> values) {
			addCriterion("use_start in", values, "useStart");
			return (Criteria) this;
		}

		public Criteria andUseStartNotIn(List<Date> values) {
			addCriterion("use_start not in", values, "useStart");
			return (Criteria) this;
		}

		public Criteria andUseStartBetween(Date value1, Date value2) {
			addCriterion("use_start between", value1, value2, "useStart");
			return (Criteria) this;
		}

		public Criteria andUseStartNotBetween(Date value1, Date value2) {
			addCriterion("use_start not between", value1, value2, "useStart");
			return (Criteria) this;
		}

		public Criteria andUseEndIsNull() {
			addCriterion("use_end is null");
			return (Criteria) this;
		}

		public Criteria andUseEndIsNotNull() {
			addCriterion("use_end is not null");
			return (Criteria) this;
		}

		public Criteria andUseEndEqualTo(Date value) {
			addCriterion("use_end =", value, "useEnd");
			return (Criteria) this;
		}

		public Criteria andUseEndNotEqualTo(Date value) {
			addCriterion("use_end <>", value, "useEnd");
			return (Criteria) this;
		}

		public Criteria andUseEndGreaterThan(Date value) {
			addCriterion("use_end >", value, "useEnd");
			return (Criteria) this;
		}

		public Criteria andUseEndGreaterThanOrEqualTo(Date value) {
			addCriterion("use_end >=", value, "useEnd");
			return (Criteria) this;
		}

		public Criteria andUseEndLessThan(Date value) {
			addCriterion("use_end <", value, "useEnd");
			return (Criteria) this;
		}

		public Criteria andUseEndLessThanOrEqualTo(Date value) {
			addCriterion("use_end <=", value, "useEnd");
			return (Criteria) this;
		}

		public Criteria andUseEndIn(List<Date> values) {
			addCriterion("use_end in", values, "useEnd");
			return (Criteria) this;
		}

		public Criteria andUseEndNotIn(List<Date> values) {
			addCriterion("use_end not in", values, "useEnd");
			return (Criteria) this;
		}

		public Criteria andUseEndBetween(Date value1, Date value2) {
			addCriterion("use_end between", value1, value2, "useEnd");
			return (Criteria) this;
		}

		public Criteria andUseEndNotBetween(Date value1, Date value2) {
			addCriterion("use_end not between", value1, value2, "useEnd");
			return (Criteria) this;
		}

		public Criteria andStartTimeIsNull() {
			addCriterion("start_time is null");
			return (Criteria) this;
		}

		public Criteria andStartTimeIsNotNull() {
			addCriterion("start_time is not null");
			return (Criteria) this;
		}

		public Criteria andStartTimeEqualTo(Date value) {
			addCriterion("start_time =", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeNotEqualTo(Date value) {
			addCriterion("start_time <>", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeGreaterThan(Date value) {
			addCriterion("start_time >", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("start_time >=", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeLessThan(Date value) {
			addCriterion("start_time <", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeLessThanOrEqualTo(Date value) {
			addCriterion("start_time <=", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeIn(List<Date> values) {
			addCriterion("start_time in", values, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeNotIn(List<Date> values) {
			addCriterion("start_time not in", values, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeBetween(Date value1, Date value2) {
			addCriterion("start_time between", value1, value2, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeNotBetween(Date value1, Date value2) {
			addCriterion("start_time not between", value1, value2, "startTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeIsNull() {
			addCriterion("end_time is null");
			return (Criteria) this;
		}

		public Criteria andEndTimeIsNotNull() {
			addCriterion("end_time is not null");
			return (Criteria) this;
		}

		public Criteria andEndTimeEqualTo(Date value) {
			addCriterion("end_time =", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotEqualTo(Date value) {
			addCriterion("end_time <>", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeGreaterThan(Date value) {
			addCriterion("end_time >", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("end_time >=", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeLessThan(Date value) {
			addCriterion("end_time <", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeLessThanOrEqualTo(Date value) {
			addCriterion("end_time <=", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeIn(List<Date> values) {
			addCriterion("end_time in", values, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotIn(List<Date> values) {
			addCriterion("end_time not in", values, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeBetween(Date value1, Date value2) {
			addCriterion("end_time between", value1, value2, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotBetween(Date value1, Date value2) {
			addCriterion("end_time not between", value1, value2, "endTime");
			return (Criteria) this;
		}

		public Criteria andCouponIdIsNull() {
			addCriterion("coupon_id is null");
			return (Criteria) this;
		}

		public Criteria andCouponIdIsNotNull() {
			addCriterion("coupon_id is not null");
			return (Criteria) this;
		}

		public Criteria andCouponIdEqualTo(Long value) {
			addCriterion("coupon_id =", value, "couponId");
			return (Criteria) this;
		}

		public Criteria andCouponIdNotEqualTo(Long value) {
			addCriterion("coupon_id <>", value, "couponId");
			return (Criteria) this;
		}

		public Criteria andCouponIdGreaterThan(Long value) {
			addCriterion("coupon_id >", value, "couponId");
			return (Criteria) this;
		}

		public Criteria andCouponIdGreaterThanOrEqualTo(Long value) {
			addCriterion("coupon_id >=", value, "couponId");
			return (Criteria) this;
		}

		public Criteria andCouponIdLessThan(Long value) {
			addCriterion("coupon_id <", value, "couponId");
			return (Criteria) this;
		}

		public Criteria andCouponIdLessThanOrEqualTo(Long value) {
			addCriterion("coupon_id <=", value, "couponId");
			return (Criteria) this;
		}

		public Criteria andCouponIdIn(List<Long> values) {
			addCriterion("coupon_id in", values, "couponId");
			return (Criteria) this;
		}

		public Criteria andCouponIdNotIn(List<Long> values) {
			addCriterion("coupon_id not in", values, "couponId");
			return (Criteria) this;
		}

		public Criteria andCouponIdBetween(Long value1, Long value2) {
			addCriterion("coupon_id between", value1, value2, "couponId");
			return (Criteria) this;
		}

		public Criteria andCouponIdNotBetween(Long value1, Long value2) {
			addCriterion("coupon_id not between", value1, value2, "couponId");
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

		public Criteria andGetCountIsNull() {
			addCriterion("get_count is null");
			return (Criteria) this;
		}

		public Criteria andGetCountIsNotNull() {
			addCriterion("get_count is not null");
			return (Criteria) this;
		}

		public Criteria andGetCountEqualTo(Long value) {
			addCriterion("get_count =", value, "getCount");
			return (Criteria) this;
		}

		public Criteria andGetCountNotEqualTo(Long value) {
			addCriterion("get_count <>", value, "getCount");
			return (Criteria) this;
		}

		public Criteria andGetCountGreaterThan(Long value) {
			addCriterion("get_count >", value, "getCount");
			return (Criteria) this;
		}

		public Criteria andGetCountGreaterThanOrEqualTo(Long value) {
			addCriterion("get_count >=", value, "getCount");
			return (Criteria) this;
		}

		public Criteria andGetCountLessThan(Long value) {
			addCriterion("get_count <", value, "getCount");
			return (Criteria) this;
		}

		public Criteria andGetCountLessThanOrEqualTo(Long value) {
			addCriterion("get_count <=", value, "getCount");
			return (Criteria) this;
		}

		public Criteria andGetCountIn(List<Long> values) {
			addCriterion("get_count in", values, "getCount");
			return (Criteria) this;
		}

		public Criteria andGetCountNotIn(List<Long> values) {
			addCriterion("get_count not in", values, "getCount");
			return (Criteria) this;
		}

		public Criteria andGetCountBetween(Long value1, Long value2) {
			addCriterion("get_count between", value1, value2, "getCount");
			return (Criteria) this;
		}

		public Criteria andGetCountNotBetween(Long value1, Long value2) {
			addCriterion("get_count not between", value1, value2, "getCount");
			return (Criteria) this;
		}

		public Criteria andPerLimitCountIsNull() {
			addCriterion("per_limit_count is null");
			return (Criteria) this;
		}

		public Criteria andPerLimitCountIsNotNull() {
			addCriterion("per_limit_count is not null");
			return (Criteria) this;
		}

		public Criteria andPerLimitCountEqualTo(Long value) {
			addCriterion("per_limit_count =", value, "perLimitCount");
			return (Criteria) this;
		}

		public Criteria andPerLimitCountNotEqualTo(Long value) {
			addCriterion("per_limit_count <>", value, "perLimitCount");
			return (Criteria) this;
		}

		public Criteria andPerLimitCountGreaterThan(Long value) {
			addCriterion("per_limit_count >", value, "perLimitCount");
			return (Criteria) this;
		}

		public Criteria andPerLimitCountGreaterThanOrEqualTo(Long value) {
			addCriterion("per_limit_count >=", value, "perLimitCount");
			return (Criteria) this;
		}

		public Criteria andPerLimitCountLessThan(Long value) {
			addCriterion("per_limit_count <", value, "perLimitCount");
			return (Criteria) this;
		}

		public Criteria andPerLimitCountLessThanOrEqualTo(Long value) {
			addCriterion("per_limit_count <=", value, "perLimitCount");
			return (Criteria) this;
		}

		public Criteria andPerLimitCountIn(List<Long> values) {
			addCriterion("per_limit_count in", values, "perLimitCount");
			return (Criteria) this;
		}

		public Criteria andPerLimitCountNotIn(List<Long> values) {
			addCriterion("per_limit_count not in", values, "perLimitCount");
			return (Criteria) this;
		}

		public Criteria andPerLimitCountBetween(Long value1, Long value2) {
			addCriterion("per_limit_count between", value1, value2, "perLimitCount");
			return (Criteria) this;
		}

		public Criteria andPerLimitCountNotBetween(Long value1, Long value2) {
			addCriterion("per_limit_count not between", value1, value2, "perLimitCount");
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

		public Criteria andIsEnabledIsNull() {
			addCriterion("is_enabled is null");
			return (Criteria) this;
		}

		public Criteria andIsEnabledIsNotNull() {
			addCriterion("is_enabled is not null");
			return (Criteria) this;
		}

		public Criteria andIsEnabledEqualTo(Byte value) {
			addCriterion("is_enabled =", value, "isEnabled");
			return (Criteria) this;
		}

		public Criteria andIsEnabledNotEqualTo(Byte value) {
			addCriterion("is_enabled <>", value, "isEnabled");
			return (Criteria) this;
		}

		public Criteria andIsEnabledGreaterThan(Byte value) {
			addCriterion("is_enabled >", value, "isEnabled");
			return (Criteria) this;
		}

		public Criteria andIsEnabledGreaterThanOrEqualTo(Byte value) {
			addCriterion("is_enabled >=", value, "isEnabled");
			return (Criteria) this;
		}

		public Criteria andIsEnabledLessThan(Byte value) {
			addCriterion("is_enabled <", value, "isEnabled");
			return (Criteria) this;
		}

		public Criteria andIsEnabledLessThanOrEqualTo(Byte value) {
			addCriterion("is_enabled <=", value, "isEnabled");
			return (Criteria) this;
		}

		public Criteria andIsEnabledIn(List<Byte> values) {
			addCriterion("is_enabled in", values, "isEnabled");
			return (Criteria) this;
		}

		public Criteria andIsEnabledNotIn(List<Byte> values) {
			addCriterion("is_enabled not in", values, "isEnabled");
			return (Criteria) this;
		}

		public Criteria andIsEnabledBetween(Byte value1, Byte value2) {
			addCriterion("is_enabled between", value1, value2, "isEnabled");
			return (Criteria) this;
		}

		public Criteria andIsEnabledNotBetween(Byte value1, Byte value2) {
			addCriterion("is_enabled not between", value1, value2, "isEnabled");
			return (Criteria) this;
		}

		public Criteria andLogoPathIsNull() {
			addCriterion("logo_path is null");
			return (Criteria) this;
		}

		public Criteria andLogoPathIsNotNull() {
			addCriterion("logo_path is not null");
			return (Criteria) this;
		}

		public Criteria andLogoPathEqualTo(String value) {
			addCriterion("logo_path =", value, "logoPath");
			return (Criteria) this;
		}

		public Criteria andLogoPathNotEqualTo(String value) {
			addCriterion("logo_path <>", value, "logoPath");
			return (Criteria) this;
		}

		public Criteria andLogoPathGreaterThan(String value) {
			addCriterion("logo_path >", value, "logoPath");
			return (Criteria) this;
		}

		public Criteria andLogoPathGreaterThanOrEqualTo(String value) {
			addCriterion("logo_path >=", value, "logoPath");
			return (Criteria) this;
		}

		public Criteria andLogoPathLessThan(String value) {
			addCriterion("logo_path <", value, "logoPath");
			return (Criteria) this;
		}

		public Criteria andLogoPathLessThanOrEqualTo(String value) {
			addCriterion("logo_path <=", value, "logoPath");
			return (Criteria) this;
		}

		public Criteria andLogoPathLike(String value) {
			addCriterion("logo_path like", value, "logoPath");
			return (Criteria) this;
		}

		public Criteria andLogoPathNotLike(String value) {
			addCriterion("logo_path not like", value, "logoPath");
			return (Criteria) this;
		}

		public Criteria andLogoPathIn(List<String> values) {
			addCriterion("logo_path in", values, "logoPath");
			return (Criteria) this;
		}

		public Criteria andLogoPathNotIn(List<String> values) {
			addCriterion("logo_path not in", values, "logoPath");
			return (Criteria) this;
		}

		public Criteria andLogoPathBetween(String value1, String value2) {
			addCriterion("logo_path between", value1, value2, "logoPath");
			return (Criteria) this;
		}

		public Criteria andLogoPathNotBetween(String value1, String value2) {
			addCriterion("logo_path not between", value1, value2, "logoPath");
			return (Criteria) this;
		}

		public Criteria andUserTypeIsNull() {
			addCriterion("user_type is null");
			return (Criteria) this;
		}

		public Criteria andUserTypeIsNotNull() {
			addCriterion("user_type is not null");
			return (Criteria) this;
		}

		public Criteria andUserTypeEqualTo(Byte value) {
			addCriterion("user_type =", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeNotEqualTo(Byte value) {
			addCriterion("user_type <>", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeGreaterThan(Byte value) {
			addCriterion("user_type >", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("user_type >=", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeLessThan(Byte value) {
			addCriterion("user_type <", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeLessThanOrEqualTo(Byte value) {
			addCriterion("user_type <=", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeIn(List<Byte> values) {
			addCriterion("user_type in", values, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeNotIn(List<Byte> values) {
			addCriterion("user_type not in", values, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeBetween(Byte value1, Byte value2) {
			addCriterion("user_type between", value1, value2, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("user_type not between", value1, value2, "userType");
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

		public Criteria andRateIsNull() {
			addCriterion("rate is null");
			return (Criteria) this;
		}

		public Criteria andRateIsNotNull() {
			addCriterion("rate is not null");
			return (Criteria) this;
		}

		public Criteria andRateEqualTo(Long value) {
			addCriterion("rate =", value, "rate");
			return (Criteria) this;
		}

		public Criteria andRateNotEqualTo(Long value) {
			addCriterion("rate <>", value, "rate");
			return (Criteria) this;
		}

		public Criteria andRateGreaterThan(Long value) {
			addCriterion("rate >", value, "rate");
			return (Criteria) this;
		}

		public Criteria andRateGreaterThanOrEqualTo(Long value) {
			addCriterion("rate >=", value, "rate");
			return (Criteria) this;
		}

		public Criteria andRateLessThan(Long value) {
			addCriterion("rate <", value, "rate");
			return (Criteria) this;
		}

		public Criteria andRateLessThanOrEqualTo(Long value) {
			addCriterion("rate <=", value, "rate");
			return (Criteria) this;
		}

		public Criteria andRateIn(List<Long> values) {
			addCriterion("rate in", values, "rate");
			return (Criteria) this;
		}

		public Criteria andRateNotIn(List<Long> values) {
			addCriterion("rate not in", values, "rate");
			return (Criteria) this;
		}

		public Criteria andRateBetween(Long value1, Long value2) {
			addCriterion("rate between", value1, value2, "rate");
			return (Criteria) this;
		}

		public Criteria andRateNotBetween(Long value1, Long value2) {
			addCriterion("rate not between", value1, value2, "rate");
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