package com.sinco.carnation.store.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StoreGradeExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public StoreGradeExample() {
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
			addCriterion("delete_Status is null");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusIsNotNull() {
			addCriterion("delete_Status is not null");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusEqualTo(Boolean value) {
			addCriterion("delete_Status =", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotEqualTo(Boolean value) {
			addCriterion("delete_Status <>", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThan(Boolean value) {
			addCriterion("delete_Status >", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThanOrEqualTo(Boolean value) {
			addCriterion("delete_Status >=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThan(Boolean value) {
			addCriterion("delete_Status <", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThanOrEqualTo(Boolean value) {
			addCriterion("delete_Status <=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusIn(List<Boolean> values) {
			addCriterion("delete_Status in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotIn(List<Boolean> values) {
			addCriterion("delete_Status not in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusBetween(Boolean value1, Boolean value2) {
			addCriterion("delete_Status between", value1, value2, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotBetween(Boolean value1, Boolean value2) {
			addCriterion("delete_Status not between", value1, value2, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andAcountNumIsNull() {
			addCriterion("acount_num is null");
			return (Criteria) this;
		}

		public Criteria andAcountNumIsNotNull() {
			addCriterion("acount_num is not null");
			return (Criteria) this;
		}

		public Criteria andAcountNumEqualTo(Integer value) {
			addCriterion("acount_num =", value, "acountNum");
			return (Criteria) this;
		}

		public Criteria andAcountNumNotEqualTo(Integer value) {
			addCriterion("acount_num <>", value, "acountNum");
			return (Criteria) this;
		}

		public Criteria andAcountNumGreaterThan(Integer value) {
			addCriterion("acount_num >", value, "acountNum");
			return (Criteria) this;
		}

		public Criteria andAcountNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("acount_num >=", value, "acountNum");
			return (Criteria) this;
		}

		public Criteria andAcountNumLessThan(Integer value) {
			addCriterion("acount_num <", value, "acountNum");
			return (Criteria) this;
		}

		public Criteria andAcountNumLessThanOrEqualTo(Integer value) {
			addCriterion("acount_num <=", value, "acountNum");
			return (Criteria) this;
		}

		public Criteria andAcountNumIn(List<Integer> values) {
			addCriterion("acount_num in", values, "acountNum");
			return (Criteria) this;
		}

		public Criteria andAcountNumNotIn(List<Integer> values) {
			addCriterion("acount_num not in", values, "acountNum");
			return (Criteria) this;
		}

		public Criteria andAcountNumBetween(Integer value1, Integer value2) {
			addCriterion("acount_num between", value1, value2, "acountNum");
			return (Criteria) this;
		}

		public Criteria andAcountNumNotBetween(Integer value1, Integer value2) {
			addCriterion("acount_num not between", value1, value2, "acountNum");
			return (Criteria) this;
		}

		public Criteria andAddFuncitonIsNull() {
			addCriterion("add_funciton is null");
			return (Criteria) this;
		}

		public Criteria andAddFuncitonIsNotNull() {
			addCriterion("add_funciton is not null");
			return (Criteria) this;
		}

		public Criteria andAddFuncitonEqualTo(String value) {
			addCriterion("add_funciton =", value, "addFunciton");
			return (Criteria) this;
		}

		public Criteria andAddFuncitonNotEqualTo(String value) {
			addCriterion("add_funciton <>", value, "addFunciton");
			return (Criteria) this;
		}

		public Criteria andAddFuncitonGreaterThan(String value) {
			addCriterion("add_funciton >", value, "addFunciton");
			return (Criteria) this;
		}

		public Criteria andAddFuncitonGreaterThanOrEqualTo(String value) {
			addCriterion("add_funciton >=", value, "addFunciton");
			return (Criteria) this;
		}

		public Criteria andAddFuncitonLessThan(String value) {
			addCriterion("add_funciton <", value, "addFunciton");
			return (Criteria) this;
		}

		public Criteria andAddFuncitonLessThanOrEqualTo(String value) {
			addCriterion("add_funciton <=", value, "addFunciton");
			return (Criteria) this;
		}

		public Criteria andAddFuncitonLike(String value) {
			addCriterion("add_funciton like", value, "addFunciton");
			return (Criteria) this;
		}

		public Criteria andAddFuncitonNotLike(String value) {
			addCriterion("add_funciton not like", value, "addFunciton");
			return (Criteria) this;
		}

		public Criteria andAddFuncitonIn(List<String> values) {
			addCriterion("add_funciton in", values, "addFunciton");
			return (Criteria) this;
		}

		public Criteria andAddFuncitonNotIn(List<String> values) {
			addCriterion("add_funciton not in", values, "addFunciton");
			return (Criteria) this;
		}

		public Criteria andAddFuncitonBetween(String value1, String value2) {
			addCriterion("add_funciton between", value1, value2, "addFunciton");
			return (Criteria) this;
		}

		public Criteria andAddFuncitonNotBetween(String value1, String value2) {
			addCriterion("add_funciton not between", value1, value2, "addFunciton");
			return (Criteria) this;
		}

		public Criteria andAuditIsNull() {
			addCriterion("audit is null");
			return (Criteria) this;
		}

		public Criteria andAuditIsNotNull() {
			addCriterion("audit is not null");
			return (Criteria) this;
		}

		public Criteria andAuditEqualTo(Boolean value) {
			addCriterion("audit =", value, "audit");
			return (Criteria) this;
		}

		public Criteria andAuditNotEqualTo(Boolean value) {
			addCriterion("audit <>", value, "audit");
			return (Criteria) this;
		}

		public Criteria andAuditGreaterThan(Boolean value) {
			addCriterion("audit >", value, "audit");
			return (Criteria) this;
		}

		public Criteria andAuditGreaterThanOrEqualTo(Boolean value) {
			addCriterion("audit >=", value, "audit");
			return (Criteria) this;
		}

		public Criteria andAuditLessThan(Boolean value) {
			addCriterion("audit <", value, "audit");
			return (Criteria) this;
		}

		public Criteria andAuditLessThanOrEqualTo(Boolean value) {
			addCriterion("audit <=", value, "audit");
			return (Criteria) this;
		}

		public Criteria andAuditIn(List<Boolean> values) {
			addCriterion("audit in", values, "audit");
			return (Criteria) this;
		}

		public Criteria andAuditNotIn(List<Boolean> values) {
			addCriterion("audit not in", values, "audit");
			return (Criteria) this;
		}

		public Criteria andAuditBetween(Boolean value1, Boolean value2) {
			addCriterion("audit between", value1, value2, "audit");
			return (Criteria) this;
		}

		public Criteria andAuditNotBetween(Boolean value1, Boolean value2) {
			addCriterion("audit not between", value1, value2, "audit");
			return (Criteria) this;
		}

		public Criteria andGoodsCountIsNull() {
			addCriterion("goods_count is null");
			return (Criteria) this;
		}

		public Criteria andGoodsCountIsNotNull() {
			addCriterion("goods_count is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsCountEqualTo(Integer value) {
			addCriterion("goods_count =", value, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGoodsCountNotEqualTo(Integer value) {
			addCriterion("goods_count <>", value, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGoodsCountGreaterThan(Integer value) {
			addCriterion("goods_count >", value, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGoodsCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("goods_count >=", value, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGoodsCountLessThan(Integer value) {
			addCriterion("goods_count <", value, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGoodsCountLessThanOrEqualTo(Integer value) {
			addCriterion("goods_count <=", value, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGoodsCountIn(List<Integer> values) {
			addCriterion("goods_count in", values, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGoodsCountNotIn(List<Integer> values) {
			addCriterion("goods_count not in", values, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGoodsCountBetween(Integer value1, Integer value2) {
			addCriterion("goods_count between", value1, value2, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGoodsCountNotBetween(Integer value1, Integer value2) {
			addCriterion("goods_count not between", value1, value2, "goodsCount");
			return (Criteria) this;
		}

		public Criteria andGoodsAuditIsNull() {
			addCriterion("goods_audit is null");
			return (Criteria) this;
		}

		public Criteria andGoodsAuditIsNotNull() {
			addCriterion("goods_audit is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsAuditEqualTo(Integer value) {
			addCriterion("goods_audit =", value, "goodsAudit");
			return (Criteria) this;
		}

		public Criteria andGoodsAuditNotEqualTo(Integer value) {
			addCriterion("goods_audit <>", value, "goodsAudit");
			return (Criteria) this;
		}

		public Criteria andGoodsAuditGreaterThan(Integer value) {
			addCriterion("goods_audit >", value, "goodsAudit");
			return (Criteria) this;
		}

		public Criteria andGoodsAuditGreaterThanOrEqualTo(Integer value) {
			addCriterion("goods_audit >=", value, "goodsAudit");
			return (Criteria) this;
		}

		public Criteria andGoodsAuditLessThan(Integer value) {
			addCriterion("goods_audit <", value, "goodsAudit");
			return (Criteria) this;
		}

		public Criteria andGoodsAuditLessThanOrEqualTo(Integer value) {
			addCriterion("goods_audit <=", value, "goodsAudit");
			return (Criteria) this;
		}

		public Criteria andGoodsAuditIn(List<Integer> values) {
			addCriterion("goods_audit in", values, "goodsAudit");
			return (Criteria) this;
		}

		public Criteria andGoodsAuditNotIn(List<Integer> values) {
			addCriterion("goods_audit not in", values, "goodsAudit");
			return (Criteria) this;
		}

		public Criteria andGoodsAuditBetween(Integer value1, Integer value2) {
			addCriterion("goods_audit between", value1, value2, "goodsAudit");
			return (Criteria) this;
		}

		public Criteria andGoodsAuditNotBetween(Integer value1, Integer value2) {
			addCriterion("goods_audit not between", value1, value2, "goodsAudit");
			return (Criteria) this;
		}

		public Criteria andGradeLevelIsNull() {
			addCriterion("grade_level is null");
			return (Criteria) this;
		}

		public Criteria andGradeLevelIsNotNull() {
			addCriterion("grade_level is not null");
			return (Criteria) this;
		}

		public Criteria andGradeLevelEqualTo(Integer value) {
			addCriterion("grade_level =", value, "gradeLevel");
			return (Criteria) this;
		}

		public Criteria andGradeLevelNotEqualTo(Integer value) {
			addCriterion("grade_level <>", value, "gradeLevel");
			return (Criteria) this;
		}

		public Criteria andGradeLevelGreaterThan(Integer value) {
			addCriterion("grade_level >", value, "gradeLevel");
			return (Criteria) this;
		}

		public Criteria andGradeLevelGreaterThanOrEqualTo(Integer value) {
			addCriterion("grade_level >=", value, "gradeLevel");
			return (Criteria) this;
		}

		public Criteria andGradeLevelLessThan(Integer value) {
			addCriterion("grade_level <", value, "gradeLevel");
			return (Criteria) this;
		}

		public Criteria andGradeLevelLessThanOrEqualTo(Integer value) {
			addCriterion("grade_level <=", value, "gradeLevel");
			return (Criteria) this;
		}

		public Criteria andGradeLevelIn(List<Integer> values) {
			addCriterion("grade_level in", values, "gradeLevel");
			return (Criteria) this;
		}

		public Criteria andGradeLevelNotIn(List<Integer> values) {
			addCriterion("grade_level not in", values, "gradeLevel");
			return (Criteria) this;
		}

		public Criteria andGradeLevelBetween(Integer value1, Integer value2) {
			addCriterion("grade_level between", value1, value2, "gradeLevel");
			return (Criteria) this;
		}

		public Criteria andGradeLevelNotBetween(Integer value1, Integer value2) {
			addCriterion("grade_level not between", value1, value2, "gradeLevel");
			return (Criteria) this;
		}

		public Criteria andGradeNameIsNull() {
			addCriterion("grade_name is null");
			return (Criteria) this;
		}

		public Criteria andGradeNameIsNotNull() {
			addCriterion("grade_name is not null");
			return (Criteria) this;
		}

		public Criteria andGradeNameEqualTo(String value) {
			addCriterion("grade_name =", value, "gradeName");
			return (Criteria) this;
		}

		public Criteria andGradeNameNotEqualTo(String value) {
			addCriterion("grade_name <>", value, "gradeName");
			return (Criteria) this;
		}

		public Criteria andGradeNameGreaterThan(String value) {
			addCriterion("grade_name >", value, "gradeName");
			return (Criteria) this;
		}

		public Criteria andGradeNameGreaterThanOrEqualTo(String value) {
			addCriterion("grade_name >=", value, "gradeName");
			return (Criteria) this;
		}

		public Criteria andGradeNameLessThan(String value) {
			addCriterion("grade_name <", value, "gradeName");
			return (Criteria) this;
		}

		public Criteria andGradeNameLessThanOrEqualTo(String value) {
			addCriterion("grade_name <=", value, "gradeName");
			return (Criteria) this;
		}

		public Criteria andGradeNameLike(String value) {
			addCriterion("grade_name like", value, "gradeName");
			return (Criteria) this;
		}

		public Criteria andGradeNameNotLike(String value) {
			addCriterion("grade_name not like", value, "gradeName");
			return (Criteria) this;
		}

		public Criteria andGradeNameIn(List<String> values) {
			addCriterion("grade_name in", values, "gradeName");
			return (Criteria) this;
		}

		public Criteria andGradeNameNotIn(List<String> values) {
			addCriterion("grade_name not in", values, "gradeName");
			return (Criteria) this;
		}

		public Criteria andGradeNameBetween(String value1, String value2) {
			addCriterion("grade_name between", value1, value2, "gradeName");
			return (Criteria) this;
		}

		public Criteria andGradeNameNotBetween(String value1, String value2) {
			addCriterion("grade_name not between", value1, value2, "gradeName");
			return (Criteria) this;
		}

		public Criteria andMainLimitIsNull() {
			addCriterion("main_limit is null");
			return (Criteria) this;
		}

		public Criteria andMainLimitIsNotNull() {
			addCriterion("main_limit is not null");
			return (Criteria) this;
		}

		public Criteria andMainLimitEqualTo(Integer value) {
			addCriterion("main_limit =", value, "mainLimit");
			return (Criteria) this;
		}

		public Criteria andMainLimitNotEqualTo(Integer value) {
			addCriterion("main_limit <>", value, "mainLimit");
			return (Criteria) this;
		}

		public Criteria andMainLimitGreaterThan(Integer value) {
			addCriterion("main_limit >", value, "mainLimit");
			return (Criteria) this;
		}

		public Criteria andMainLimitGreaterThanOrEqualTo(Integer value) {
			addCriterion("main_limit >=", value, "mainLimit");
			return (Criteria) this;
		}

		public Criteria andMainLimitLessThan(Integer value) {
			addCriterion("main_limit <", value, "mainLimit");
			return (Criteria) this;
		}

		public Criteria andMainLimitLessThanOrEqualTo(Integer value) {
			addCriterion("main_limit <=", value, "mainLimit");
			return (Criteria) this;
		}

		public Criteria andMainLimitIn(List<Integer> values) {
			addCriterion("main_limit in", values, "mainLimit");
			return (Criteria) this;
		}

		public Criteria andMainLimitNotIn(List<Integer> values) {
			addCriterion("main_limit not in", values, "mainLimit");
			return (Criteria) this;
		}

		public Criteria andMainLimitBetween(Integer value1, Integer value2) {
			addCriterion("main_limit between", value1, value2, "mainLimit");
			return (Criteria) this;
		}

		public Criteria andMainLimitNotBetween(Integer value1, Integer value2) {
			addCriterion("main_limit not between", value1, value2, "mainLimit");
			return (Criteria) this;
		}

		public Criteria andPriceIsNull() {
			addCriterion("price is null");
			return (Criteria) this;
		}

		public Criteria andPriceIsNotNull() {
			addCriterion("price is not null");
			return (Criteria) this;
		}

		public Criteria andPriceEqualTo(String value) {
			addCriterion("price =", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotEqualTo(String value) {
			addCriterion("price <>", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceGreaterThan(String value) {
			addCriterion("price >", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceGreaterThanOrEqualTo(String value) {
			addCriterion("price >=", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceLessThan(String value) {
			addCriterion("price <", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceLessThanOrEqualTo(String value) {
			addCriterion("price <=", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceLike(String value) {
			addCriterion("price like", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotLike(String value) {
			addCriterion("price not like", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceIn(List<String> values) {
			addCriterion("price in", values, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotIn(List<String> values) {
			addCriterion("price not in", values, "price");
			return (Criteria) this;
		}

		public Criteria andPriceBetween(String value1, String value2) {
			addCriterion("price between", value1, value2, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotBetween(String value1, String value2) {
			addCriterion("price not between", value1, value2, "price");
			return (Criteria) this;
		}

		public Criteria andSequenceIsNull() {
			addCriterion("sequence is null");
			return (Criteria) this;
		}

		public Criteria andSequenceIsNotNull() {
			addCriterion("sequence is not null");
			return (Criteria) this;
		}

		public Criteria andSequenceEqualTo(Integer value) {
			addCriterion("sequence =", value, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceNotEqualTo(Integer value) {
			addCriterion("sequence <>", value, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceGreaterThan(Integer value) {
			addCriterion("sequence >", value, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceGreaterThanOrEqualTo(Integer value) {
			addCriterion("sequence >=", value, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceLessThan(Integer value) {
			addCriterion("sequence <", value, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceLessThanOrEqualTo(Integer value) {
			addCriterion("sequence <=", value, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceIn(List<Integer> values) {
			addCriterion("sequence in", values, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceNotIn(List<Integer> values) {
			addCriterion("sequence not in", values, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceBetween(Integer value1, Integer value2) {
			addCriterion("sequence between", value1, value2, "sequence");
			return (Criteria) this;
		}

		public Criteria andSequenceNotBetween(Integer value1, Integer value2) {
			addCriterion("sequence not between", value1, value2, "sequence");
			return (Criteria) this;
		}

		public Criteria andSpaceSizeIsNull() {
			addCriterion("space_size is null");
			return (Criteria) this;
		}

		public Criteria andSpaceSizeIsNotNull() {
			addCriterion("space_size is not null");
			return (Criteria) this;
		}

		public Criteria andSpaceSizeEqualTo(Float value) {
			addCriterion("space_size =", value, "spaceSize");
			return (Criteria) this;
		}

		public Criteria andSpaceSizeNotEqualTo(Float value) {
			addCriterion("space_size <>", value, "spaceSize");
			return (Criteria) this;
		}

		public Criteria andSpaceSizeGreaterThan(Float value) {
			addCriterion("space_size >", value, "spaceSize");
			return (Criteria) this;
		}

		public Criteria andSpaceSizeGreaterThanOrEqualTo(Float value) {
			addCriterion("space_size >=", value, "spaceSize");
			return (Criteria) this;
		}

		public Criteria andSpaceSizeLessThan(Float value) {
			addCriterion("space_size <", value, "spaceSize");
			return (Criteria) this;
		}

		public Criteria andSpaceSizeLessThanOrEqualTo(Float value) {
			addCriterion("space_size <=", value, "spaceSize");
			return (Criteria) this;
		}

		public Criteria andSpaceSizeIn(List<Float> values) {
			addCriterion("space_size in", values, "spaceSize");
			return (Criteria) this;
		}

		public Criteria andSpaceSizeNotIn(List<Float> values) {
			addCriterion("space_size not in", values, "spaceSize");
			return (Criteria) this;
		}

		public Criteria andSpaceSizeBetween(Float value1, Float value2) {
			addCriterion("space_size between", value1, value2, "spaceSize");
			return (Criteria) this;
		}

		public Criteria andSpaceSizeNotBetween(Float value1, Float value2) {
			addCriterion("space_size not between", value1, value2, "spaceSize");
			return (Criteria) this;
		}

		public Criteria andSysGradeIsNull() {
			addCriterion("sys_grade is null");
			return (Criteria) this;
		}

		public Criteria andSysGradeIsNotNull() {
			addCriterion("sys_grade is not null");
			return (Criteria) this;
		}

		public Criteria andSysGradeEqualTo(Boolean value) {
			addCriterion("sys_grade =", value, "sysGrade");
			return (Criteria) this;
		}

		public Criteria andSysGradeNotEqualTo(Boolean value) {
			addCriterion("sys_grade <>", value, "sysGrade");
			return (Criteria) this;
		}

		public Criteria andSysGradeGreaterThan(Boolean value) {
			addCriterion("sys_grade >", value, "sysGrade");
			return (Criteria) this;
		}

		public Criteria andSysGradeGreaterThanOrEqualTo(Boolean value) {
			addCriterion("sys_grade >=", value, "sysGrade");
			return (Criteria) this;
		}

		public Criteria andSysGradeLessThan(Boolean value) {
			addCriterion("sys_grade <", value, "sysGrade");
			return (Criteria) this;
		}

		public Criteria andSysGradeLessThanOrEqualTo(Boolean value) {
			addCriterion("sys_grade <=", value, "sysGrade");
			return (Criteria) this;
		}

		public Criteria andSysGradeIn(List<Boolean> values) {
			addCriterion("sys_grade in", values, "sysGrade");
			return (Criteria) this;
		}

		public Criteria andSysGradeNotIn(List<Boolean> values) {
			addCriterion("sys_grade not in", values, "sysGrade");
			return (Criteria) this;
		}

		public Criteria andSysGradeBetween(Boolean value1, Boolean value2) {
			addCriterion("sys_grade between", value1, value2, "sysGrade");
			return (Criteria) this;
		}

		public Criteria andSysGradeNotBetween(Boolean value1, Boolean value2) {
			addCriterion("sys_grade not between", value1, value2, "sysGrade");
			return (Criteria) this;
		}

		public Criteria andTemplatesIsNull() {
			addCriterion("templates is null");
			return (Criteria) this;
		}

		public Criteria andTemplatesIsNotNull() {
			addCriterion("templates is not null");
			return (Criteria) this;
		}

		public Criteria andTemplatesEqualTo(String value) {
			addCriterion("templates =", value, "templates");
			return (Criteria) this;
		}

		public Criteria andTemplatesNotEqualTo(String value) {
			addCriterion("templates <>", value, "templates");
			return (Criteria) this;
		}

		public Criteria andTemplatesGreaterThan(String value) {
			addCriterion("templates >", value, "templates");
			return (Criteria) this;
		}

		public Criteria andTemplatesGreaterThanOrEqualTo(String value) {
			addCriterion("templates >=", value, "templates");
			return (Criteria) this;
		}

		public Criteria andTemplatesLessThan(String value) {
			addCriterion("templates <", value, "templates");
			return (Criteria) this;
		}

		public Criteria andTemplatesLessThanOrEqualTo(String value) {
			addCriterion("templates <=", value, "templates");
			return (Criteria) this;
		}

		public Criteria andTemplatesLike(String value) {
			addCriterion("templates like", value, "templates");
			return (Criteria) this;
		}

		public Criteria andTemplatesNotLike(String value) {
			addCriterion("templates not like", value, "templates");
			return (Criteria) this;
		}

		public Criteria andTemplatesIn(List<String> values) {
			addCriterion("templates in", values, "templates");
			return (Criteria) this;
		}

		public Criteria andTemplatesNotIn(List<String> values) {
			addCriterion("templates not in", values, "templates");
			return (Criteria) this;
		}

		public Criteria andTemplatesBetween(String value1, String value2) {
			addCriterion("templates between", value1, value2, "templates");
			return (Criteria) this;
		}

		public Criteria andTemplatesNotBetween(String value1, String value2) {
			addCriterion("templates not between", value1, value2, "templates");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeIsNull() {
			addCriterion("whether_free is null");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeIsNotNull() {
			addCriterion("whether_free is not null");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeEqualTo(Boolean value) {
			addCriterion("whether_free =", value, "whetherFree");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeNotEqualTo(Boolean value) {
			addCriterion("whether_free <>", value, "whetherFree");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeGreaterThan(Boolean value) {
			addCriterion("whether_free >", value, "whetherFree");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeGreaterThanOrEqualTo(Boolean value) {
			addCriterion("whether_free >=", value, "whetherFree");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeLessThan(Boolean value) {
			addCriterion("whether_free <", value, "whetherFree");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeLessThanOrEqualTo(Boolean value) {
			addCriterion("whether_free <=", value, "whetherFree");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeIn(List<Boolean> values) {
			addCriterion("whether_free in", values, "whetherFree");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeNotIn(List<Boolean> values) {
			addCriterion("whether_free not in", values, "whetherFree");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeBetween(Boolean value1, Boolean value2) {
			addCriterion("whether_free between", value1, value2, "whetherFree");
			return (Criteria) this;
		}

		public Criteria andWhetherFreeNotBetween(Boolean value1, Boolean value2) {
			addCriterion("whether_free not between", value1, value2, "whetherFree");
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