package com.sinco.carnation.user.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RebateRateExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public RebateRateExample() {
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

		public Criteria andCodeIsNull() {
			addCriterion("code is null");
			return (Criteria) this;
		}

		public Criteria andCodeIsNotNull() {
			addCriterion("code is not null");
			return (Criteria) this;
		}

		public Criteria andCodeEqualTo(String value) {
			addCriterion("code =", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotEqualTo(String value) {
			addCriterion("code <>", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThan(String value) {
			addCriterion("code >", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThanOrEqualTo(String value) {
			addCriterion("code >=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThan(String value) {
			addCriterion("code <", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThanOrEqualTo(String value) {
			addCriterion("code <=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLike(String value) {
			addCriterion("code like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotLike(String value) {
			addCriterion("code not like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeIn(List<String> values) {
			addCriterion("code in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotIn(List<String> values) {
			addCriterion("code not in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeBetween(String value1, String value2) {
			addCriterion("code between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotBetween(String value1, String value2) {
			addCriterion("code not between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andDescriptionIsNull() {
			addCriterion("description is null");
			return (Criteria) this;
		}

		public Criteria andDescriptionIsNotNull() {
			addCriterion("description is not null");
			return (Criteria) this;
		}

		public Criteria andDescriptionEqualTo(String value) {
			addCriterion("description =", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotEqualTo(String value) {
			addCriterion("description <>", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionGreaterThan(String value) {
			addCriterion("description >", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
			addCriterion("description >=", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLessThan(String value) {
			addCriterion("description <", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLessThanOrEqualTo(String value) {
			addCriterion("description <=", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLike(String value) {
			addCriterion("description like", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotLike(String value) {
			addCriterion("description not like", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionIn(List<String> values) {
			addCriterion("description in", values, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotIn(List<String> values) {
			addCriterion("description not in", values, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionBetween(String value1, String value2) {
			addCriterion("description between", value1, value2, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotBetween(String value1, String value2) {
			addCriterion("description not between", value1, value2, "description");
			return (Criteria) this;
		}

		public Criteria andOwnRateIsNull() {
			addCriterion("own_rate is null");
			return (Criteria) this;
		}

		public Criteria andOwnRateIsNotNull() {
			addCriterion("own_rate is not null");
			return (Criteria) this;
		}

		public Criteria andOwnRateEqualTo(BigDecimal value) {
			addCriterion("own_rate =", value, "ownRate");
			return (Criteria) this;
		}

		public Criteria andOwnRateNotEqualTo(BigDecimal value) {
			addCriterion("own_rate <>", value, "ownRate");
			return (Criteria) this;
		}

		public Criteria andOwnRateGreaterThan(BigDecimal value) {
			addCriterion("own_rate >", value, "ownRate");
			return (Criteria) this;
		}

		public Criteria andOwnRateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("own_rate >=", value, "ownRate");
			return (Criteria) this;
		}

		public Criteria andOwnRateLessThan(BigDecimal value) {
			addCriterion("own_rate <", value, "ownRate");
			return (Criteria) this;
		}

		public Criteria andOwnRateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("own_rate <=", value, "ownRate");
			return (Criteria) this;
		}

		public Criteria andOwnRateIn(List<BigDecimal> values) {
			addCriterion("own_rate in", values, "ownRate");
			return (Criteria) this;
		}

		public Criteria andOwnRateNotIn(List<BigDecimal> values) {
			addCriterion("own_rate not in", values, "ownRate");
			return (Criteria) this;
		}

		public Criteria andOwnRateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("own_rate between", value1, value2, "ownRate");
			return (Criteria) this;
		}

		public Criteria andOwnRateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("own_rate not between", value1, value2, "ownRate");
			return (Criteria) this;
		}

		public Criteria andReferenceRateIsNull() {
			addCriterion("reference_rate is null");
			return (Criteria) this;
		}

		public Criteria andReferenceRateIsNotNull() {
			addCriterion("reference_rate is not null");
			return (Criteria) this;
		}

		public Criteria andReferenceRateEqualTo(BigDecimal value) {
			addCriterion("reference_rate =", value, "referenceRate");
			return (Criteria) this;
		}

		public Criteria andReferenceRateNotEqualTo(BigDecimal value) {
			addCriterion("reference_rate <>", value, "referenceRate");
			return (Criteria) this;
		}

		public Criteria andReferenceRateGreaterThan(BigDecimal value) {
			addCriterion("reference_rate >", value, "referenceRate");
			return (Criteria) this;
		}

		public Criteria andReferenceRateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("reference_rate >=", value, "referenceRate");
			return (Criteria) this;
		}

		public Criteria andReferenceRateLessThan(BigDecimal value) {
			addCriterion("reference_rate <", value, "referenceRate");
			return (Criteria) this;
		}

		public Criteria andReferenceRateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("reference_rate <=", value, "referenceRate");
			return (Criteria) this;
		}

		public Criteria andReferenceRateIn(List<BigDecimal> values) {
			addCriterion("reference_rate in", values, "referenceRate");
			return (Criteria) this;
		}

		public Criteria andReferenceRateNotIn(List<BigDecimal> values) {
			addCriterion("reference_rate not in", values, "referenceRate");
			return (Criteria) this;
		}

		public Criteria andReferenceRateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("reference_rate between", value1, value2, "referenceRate");
			return (Criteria) this;
		}

		public Criteria andReferenceRateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("reference_rate not between", value1, value2, "referenceRate");
			return (Criteria) this;
		}

		public Criteria andOwnSellerRateIsNull() {
			addCriterion("own_seller_rate is null");
			return (Criteria) this;
		}

		public Criteria andOwnSellerRateIsNotNull() {
			addCriterion("own_seller_rate is not null");
			return (Criteria) this;
		}

		public Criteria andOwnSellerRateEqualTo(BigDecimal value) {
			addCriterion("own_seller_rate =", value, "ownSellerRate");
			return (Criteria) this;
		}

		public Criteria andOwnSellerRateNotEqualTo(BigDecimal value) {
			addCriterion("own_seller_rate <>", value, "ownSellerRate");
			return (Criteria) this;
		}

		public Criteria andOwnSellerRateGreaterThan(BigDecimal value) {
			addCriterion("own_seller_rate >", value, "ownSellerRate");
			return (Criteria) this;
		}

		public Criteria andOwnSellerRateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("own_seller_rate >=", value, "ownSellerRate");
			return (Criteria) this;
		}

		public Criteria andOwnSellerRateLessThan(BigDecimal value) {
			addCriterion("own_seller_rate <", value, "ownSellerRate");
			return (Criteria) this;
		}

		public Criteria andOwnSellerRateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("own_seller_rate <=", value, "ownSellerRate");
			return (Criteria) this;
		}

		public Criteria andOwnSellerRateIn(List<BigDecimal> values) {
			addCriterion("own_seller_rate in", values, "ownSellerRate");
			return (Criteria) this;
		}

		public Criteria andOwnSellerRateNotIn(List<BigDecimal> values) {
			addCriterion("own_seller_rate not in", values, "ownSellerRate");
			return (Criteria) this;
		}

		public Criteria andOwnSellerRateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("own_seller_rate between", value1, value2, "ownSellerRate");
			return (Criteria) this;
		}

		public Criteria andOwnSellerRateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("own_seller_rate not between", value1, value2, "ownSellerRate");
			return (Criteria) this;
		}

		public Criteria andOwnSellerReferenceRateIsNull() {
			addCriterion("own_seller_reference_rate is null");
			return (Criteria) this;
		}

		public Criteria andOwnSellerReferenceRateIsNotNull() {
			addCriterion("own_seller_reference_rate is not null");
			return (Criteria) this;
		}

		public Criteria andOwnSellerReferenceRateEqualTo(BigDecimal value) {
			addCriterion("own_seller_reference_rate =", value, "ownSellerReferenceRate");
			return (Criteria) this;
		}

		public Criteria andOwnSellerReferenceRateNotEqualTo(BigDecimal value) {
			addCriterion("own_seller_reference_rate <>", value, "ownSellerReferenceRate");
			return (Criteria) this;
		}

		public Criteria andOwnSellerReferenceRateGreaterThan(BigDecimal value) {
			addCriterion("own_seller_reference_rate >", value, "ownSellerReferenceRate");
			return (Criteria) this;
		}

		public Criteria andOwnSellerReferenceRateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("own_seller_reference_rate >=", value, "ownSellerReferenceRate");
			return (Criteria) this;
		}

		public Criteria andOwnSellerReferenceRateLessThan(BigDecimal value) {
			addCriterion("own_seller_reference_rate <", value, "ownSellerReferenceRate");
			return (Criteria) this;
		}

		public Criteria andOwnSellerReferenceRateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("own_seller_reference_rate <=", value, "ownSellerReferenceRate");
			return (Criteria) this;
		}

		public Criteria andOwnSellerReferenceRateIn(List<BigDecimal> values) {
			addCriterion("own_seller_reference_rate in", values, "ownSellerReferenceRate");
			return (Criteria) this;
		}

		public Criteria andOwnSellerReferenceRateNotIn(List<BigDecimal> values) {
			addCriterion("own_seller_reference_rate not in", values, "ownSellerReferenceRate");
			return (Criteria) this;
		}

		public Criteria andOwnSellerReferenceRateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("own_seller_reference_rate between", value1, value2, "ownSellerReferenceRate");
			return (Criteria) this;
		}

		public Criteria andOwnSellerReferenceRateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("own_seller_reference_rate not between", value1, value2, "ownSellerReferenceRate");
			return (Criteria) this;
		}

		public Criteria andOwnRegionalRateIsNull() {
			addCriterion("own_regional_rate is null");
			return (Criteria) this;
		}

		public Criteria andOwnRegionalRateIsNotNull() {
			addCriterion("own_regional_rate is not null");
			return (Criteria) this;
		}

		public Criteria andOwnRegionalRateEqualTo(BigDecimal value) {
			addCriterion("own_regional_rate =", value, "ownRegionalRate");
			return (Criteria) this;
		}

		public Criteria andOwnRegionalRateNotEqualTo(BigDecimal value) {
			addCriterion("own_regional_rate <>", value, "ownRegionalRate");
			return (Criteria) this;
		}

		public Criteria andOwnRegionalRateGreaterThan(BigDecimal value) {
			addCriterion("own_regional_rate >", value, "ownRegionalRate");
			return (Criteria) this;
		}

		public Criteria andOwnRegionalRateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("own_regional_rate >=", value, "ownRegionalRate");
			return (Criteria) this;
		}

		public Criteria andOwnRegionalRateLessThan(BigDecimal value) {
			addCriterion("own_regional_rate <", value, "ownRegionalRate");
			return (Criteria) this;
		}

		public Criteria andOwnRegionalRateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("own_regional_rate <=", value, "ownRegionalRate");
			return (Criteria) this;
		}

		public Criteria andOwnRegionalRateIn(List<BigDecimal> values) {
			addCriterion("own_regional_rate in", values, "ownRegionalRate");
			return (Criteria) this;
		}

		public Criteria andOwnRegionalRateNotIn(List<BigDecimal> values) {
			addCriterion("own_regional_rate not in", values, "ownRegionalRate");
			return (Criteria) this;
		}

		public Criteria andOwnRegionalRateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("own_regional_rate between", value1, value2, "ownRegionalRate");
			return (Criteria) this;
		}

		public Criteria andOwnRegionalRateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("own_regional_rate not between", value1, value2, "ownRegionalRate");
			return (Criteria) this;
		}

		public Criteria andOwnRegionalReferenceRateIsNull() {
			addCriterion("own_regional_reference_rate is null");
			return (Criteria) this;
		}

		public Criteria andOwnRegionalReferenceRateIsNotNull() {
			addCriterion("own_regional_reference_rate is not null");
			return (Criteria) this;
		}

		public Criteria andOwnRegionalReferenceRateEqualTo(BigDecimal value) {
			addCriterion("own_regional_reference_rate =", value, "ownRegionalReferenceRate");
			return (Criteria) this;
		}

		public Criteria andOwnRegionalReferenceRateNotEqualTo(BigDecimal value) {
			addCriterion("own_regional_reference_rate <>", value, "ownRegionalReferenceRate");
			return (Criteria) this;
		}

		public Criteria andOwnRegionalReferenceRateGreaterThan(BigDecimal value) {
			addCriterion("own_regional_reference_rate >", value, "ownRegionalReferenceRate");
			return (Criteria) this;
		}

		public Criteria andOwnRegionalReferenceRateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("own_regional_reference_rate >=", value, "ownRegionalReferenceRate");
			return (Criteria) this;
		}

		public Criteria andOwnRegionalReferenceRateLessThan(BigDecimal value) {
			addCriterion("own_regional_reference_rate <", value, "ownRegionalReferenceRate");
			return (Criteria) this;
		}

		public Criteria andOwnRegionalReferenceRateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("own_regional_reference_rate <=", value, "ownRegionalReferenceRate");
			return (Criteria) this;
		}

		public Criteria andOwnRegionalReferenceRateIn(List<BigDecimal> values) {
			addCriterion("own_regional_reference_rate in", values, "ownRegionalReferenceRate");
			return (Criteria) this;
		}

		public Criteria andOwnRegionalReferenceRateNotIn(List<BigDecimal> values) {
			addCriterion("own_regional_reference_rate not in", values, "ownRegionalReferenceRate");
			return (Criteria) this;
		}

		public Criteria andOwnRegionalReferenceRateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("own_regional_reference_rate between", value1, value2, "ownRegionalReferenceRate");
			return (Criteria) this;
		}

		public Criteria andOwnRegionalReferenceRateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("own_regional_reference_rate not between", value1, value2,
					"ownRegionalReferenceRate");
			return (Criteria) this;
		}

		public Criteria andOwnDistrictRateIsNull() {
			addCriterion("own_district_rate is null");
			return (Criteria) this;
		}

		public Criteria andOwnDistrictRateIsNotNull() {
			addCriterion("own_district_rate is not null");
			return (Criteria) this;
		}

		public Criteria andOwnDistrictRateEqualTo(BigDecimal value) {
			addCriterion("own_district_rate =", value, "ownDistrictRate");
			return (Criteria) this;
		}

		public Criteria andOwnDistrictRateNotEqualTo(BigDecimal value) {
			addCriterion("own_district_rate <>", value, "ownDistrictRate");
			return (Criteria) this;
		}

		public Criteria andOwnDistrictRateGreaterThan(BigDecimal value) {
			addCriterion("own_district_rate >", value, "ownDistrictRate");
			return (Criteria) this;
		}

		public Criteria andOwnDistrictRateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("own_district_rate >=", value, "ownDistrictRate");
			return (Criteria) this;
		}

		public Criteria andOwnDistrictRateLessThan(BigDecimal value) {
			addCriterion("own_district_rate <", value, "ownDistrictRate");
			return (Criteria) this;
		}

		public Criteria andOwnDistrictRateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("own_district_rate <=", value, "ownDistrictRate");
			return (Criteria) this;
		}

		public Criteria andOwnDistrictRateIn(List<BigDecimal> values) {
			addCriterion("own_district_rate in", values, "ownDistrictRate");
			return (Criteria) this;
		}

		public Criteria andOwnDistrictRateNotIn(List<BigDecimal> values) {
			addCriterion("own_district_rate not in", values, "ownDistrictRate");
			return (Criteria) this;
		}

		public Criteria andOwnDistrictRateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("own_district_rate between", value1, value2, "ownDistrictRate");
			return (Criteria) this;
		}

		public Criteria andOwnDistrictRateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("own_district_rate not between", value1, value2, "ownDistrictRate");
			return (Criteria) this;
		}

		public Criteria andOwnCityRateIsNull() {
			addCriterion("own_city_rate is null");
			return (Criteria) this;
		}

		public Criteria andOwnCityRateIsNotNull() {
			addCriterion("own_city_rate is not null");
			return (Criteria) this;
		}

		public Criteria andOwnCityRateEqualTo(BigDecimal value) {
			addCriterion("own_city_rate =", value, "ownCityRate");
			return (Criteria) this;
		}

		public Criteria andOwnCityRateNotEqualTo(BigDecimal value) {
			addCriterion("own_city_rate <>", value, "ownCityRate");
			return (Criteria) this;
		}

		public Criteria andOwnCityRateGreaterThan(BigDecimal value) {
			addCriterion("own_city_rate >", value, "ownCityRate");
			return (Criteria) this;
		}

		public Criteria andOwnCityRateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("own_city_rate >=", value, "ownCityRate");
			return (Criteria) this;
		}

		public Criteria andOwnCityRateLessThan(BigDecimal value) {
			addCriterion("own_city_rate <", value, "ownCityRate");
			return (Criteria) this;
		}

		public Criteria andOwnCityRateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("own_city_rate <=", value, "ownCityRate");
			return (Criteria) this;
		}

		public Criteria andOwnCityRateIn(List<BigDecimal> values) {
			addCriterion("own_city_rate in", values, "ownCityRate");
			return (Criteria) this;
		}

		public Criteria andOwnCityRateNotIn(List<BigDecimal> values) {
			addCriterion("own_city_rate not in", values, "ownCityRate");
			return (Criteria) this;
		}

		public Criteria andOwnCityRateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("own_city_rate between", value1, value2, "ownCityRate");
			return (Criteria) this;
		}

		public Criteria andOwnCityRateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("own_city_rate not between", value1, value2, "ownCityRate");
			return (Criteria) this;
		}

		public Criteria andBuySellerReferenceRateIsNull() {
			addCriterion("buy_seller_reference_rate is null");
			return (Criteria) this;
		}

		public Criteria andBuySellerReferenceRateIsNotNull() {
			addCriterion("buy_seller_reference_rate is not null");
			return (Criteria) this;
		}

		public Criteria andBuySellerReferenceRateEqualTo(BigDecimal value) {
			addCriterion("buy_seller_reference_rate =", value, "buySellerReferenceRate");
			return (Criteria) this;
		}

		public Criteria andBuySellerReferenceRateNotEqualTo(BigDecimal value) {
			addCriterion("buy_seller_reference_rate <>", value, "buySellerReferenceRate");
			return (Criteria) this;
		}

		public Criteria andBuySellerReferenceRateGreaterThan(BigDecimal value) {
			addCriterion("buy_seller_reference_rate >", value, "buySellerReferenceRate");
			return (Criteria) this;
		}

		public Criteria andBuySellerReferenceRateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("buy_seller_reference_rate >=", value, "buySellerReferenceRate");
			return (Criteria) this;
		}

		public Criteria andBuySellerReferenceRateLessThan(BigDecimal value) {
			addCriterion("buy_seller_reference_rate <", value, "buySellerReferenceRate");
			return (Criteria) this;
		}

		public Criteria andBuySellerReferenceRateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("buy_seller_reference_rate <=", value, "buySellerReferenceRate");
			return (Criteria) this;
		}

		public Criteria andBuySellerReferenceRateIn(List<BigDecimal> values) {
			addCriterion("buy_seller_reference_rate in", values, "buySellerReferenceRate");
			return (Criteria) this;
		}

		public Criteria andBuySellerReferenceRateNotIn(List<BigDecimal> values) {
			addCriterion("buy_seller_reference_rate not in", values, "buySellerReferenceRate");
			return (Criteria) this;
		}

		public Criteria andBuySellerReferenceRateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("buy_seller_reference_rate between", value1, value2, "buySellerReferenceRate");
			return (Criteria) this;
		}

		public Criteria andBuySellerReferenceRateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("buy_seller_reference_rate not between", value1, value2, "buySellerReferenceRate");
			return (Criteria) this;
		}

		public Criteria andBuyRegionalRateIsNull() {
			addCriterion("buy_regional_rate is null");
			return (Criteria) this;
		}

		public Criteria andBuyRegionalRateIsNotNull() {
			addCriterion("buy_regional_rate is not null");
			return (Criteria) this;
		}

		public Criteria andBuyRegionalRateEqualTo(BigDecimal value) {
			addCriterion("buy_regional_rate =", value, "buyRegionalRate");
			return (Criteria) this;
		}

		public Criteria andBuyRegionalRateNotEqualTo(BigDecimal value) {
			addCriterion("buy_regional_rate <>", value, "buyRegionalRate");
			return (Criteria) this;
		}

		public Criteria andBuyRegionalRateGreaterThan(BigDecimal value) {
			addCriterion("buy_regional_rate >", value, "buyRegionalRate");
			return (Criteria) this;
		}

		public Criteria andBuyRegionalRateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("buy_regional_rate >=", value, "buyRegionalRate");
			return (Criteria) this;
		}

		public Criteria andBuyRegionalRateLessThan(BigDecimal value) {
			addCriterion("buy_regional_rate <", value, "buyRegionalRate");
			return (Criteria) this;
		}

		public Criteria andBuyRegionalRateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("buy_regional_rate <=", value, "buyRegionalRate");
			return (Criteria) this;
		}

		public Criteria andBuyRegionalRateIn(List<BigDecimal> values) {
			addCriterion("buy_regional_rate in", values, "buyRegionalRate");
			return (Criteria) this;
		}

		public Criteria andBuyRegionalRateNotIn(List<BigDecimal> values) {
			addCriterion("buy_regional_rate not in", values, "buyRegionalRate");
			return (Criteria) this;
		}

		public Criteria andBuyRegionalRateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("buy_regional_rate between", value1, value2, "buyRegionalRate");
			return (Criteria) this;
		}

		public Criteria andBuyRegionalRateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("buy_regional_rate not between", value1, value2, "buyRegionalRate");
			return (Criteria) this;
		}

		public Criteria andBuyDistrictRateIsNull() {
			addCriterion("buy_district_rate is null");
			return (Criteria) this;
		}

		public Criteria andBuyDistrictRateIsNotNull() {
			addCriterion("buy_district_rate is not null");
			return (Criteria) this;
		}

		public Criteria andBuyDistrictRateEqualTo(BigDecimal value) {
			addCriterion("buy_district_rate =", value, "buyDistrictRate");
			return (Criteria) this;
		}

		public Criteria andBuyDistrictRateNotEqualTo(BigDecimal value) {
			addCriterion("buy_district_rate <>", value, "buyDistrictRate");
			return (Criteria) this;
		}

		public Criteria andBuyDistrictRateGreaterThan(BigDecimal value) {
			addCriterion("buy_district_rate >", value, "buyDistrictRate");
			return (Criteria) this;
		}

		public Criteria andBuyDistrictRateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("buy_district_rate >=", value, "buyDistrictRate");
			return (Criteria) this;
		}

		public Criteria andBuyDistrictRateLessThan(BigDecimal value) {
			addCriterion("buy_district_rate <", value, "buyDistrictRate");
			return (Criteria) this;
		}

		public Criteria andBuyDistrictRateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("buy_district_rate <=", value, "buyDistrictRate");
			return (Criteria) this;
		}

		public Criteria andBuyDistrictRateIn(List<BigDecimal> values) {
			addCriterion("buy_district_rate in", values, "buyDistrictRate");
			return (Criteria) this;
		}

		public Criteria andBuyDistrictRateNotIn(List<BigDecimal> values) {
			addCriterion("buy_district_rate not in", values, "buyDistrictRate");
			return (Criteria) this;
		}

		public Criteria andBuyDistrictRateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("buy_district_rate between", value1, value2, "buyDistrictRate");
			return (Criteria) this;
		}

		public Criteria andBuyDistrictRateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("buy_district_rate not between", value1, value2, "buyDistrictRate");
			return (Criteria) this;
		}

		public Criteria andBuyCityRateIsNull() {
			addCriterion("buy_city_rate is null");
			return (Criteria) this;
		}

		public Criteria andBuyCityRateIsNotNull() {
			addCriterion("buy_city_rate is not null");
			return (Criteria) this;
		}

		public Criteria andBuyCityRateEqualTo(BigDecimal value) {
			addCriterion("buy_city_rate =", value, "buyCityRate");
			return (Criteria) this;
		}

		public Criteria andBuyCityRateNotEqualTo(BigDecimal value) {
			addCriterion("buy_city_rate <>", value, "buyCityRate");
			return (Criteria) this;
		}

		public Criteria andBuyCityRateGreaterThan(BigDecimal value) {
			addCriterion("buy_city_rate >", value, "buyCityRate");
			return (Criteria) this;
		}

		public Criteria andBuyCityRateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("buy_city_rate >=", value, "buyCityRate");
			return (Criteria) this;
		}

		public Criteria andBuyCityRateLessThan(BigDecimal value) {
			addCriterion("buy_city_rate <", value, "buyCityRate");
			return (Criteria) this;
		}

		public Criteria andBuyCityRateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("buy_city_rate <=", value, "buyCityRate");
			return (Criteria) this;
		}

		public Criteria andBuyCityRateIn(List<BigDecimal> values) {
			addCriterion("buy_city_rate in", values, "buyCityRate");
			return (Criteria) this;
		}

		public Criteria andBuyCityRateNotIn(List<BigDecimal> values) {
			addCriterion("buy_city_rate not in", values, "buyCityRate");
			return (Criteria) this;
		}

		public Criteria andBuyCityRateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("buy_city_rate between", value1, value2, "buyCityRate");
			return (Criteria) this;
		}

		public Criteria andBuyCityRateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("buy_city_rate not between", value1, value2, "buyCityRate");
			return (Criteria) this;
		}

		public Criteria andShopRateIsNull() {
			addCriterion("shop_rate is null");
			return (Criteria) this;
		}

		public Criteria andShopRateIsNotNull() {
			addCriterion("shop_rate is not null");
			return (Criteria) this;
		}

		public Criteria andShopRateEqualTo(BigDecimal value) {
			addCriterion("shop_rate =", value, "shopRate");
			return (Criteria) this;
		}

		public Criteria andShopRateNotEqualTo(BigDecimal value) {
			addCriterion("shop_rate <>", value, "shopRate");
			return (Criteria) this;
		}

		public Criteria andShopRateGreaterThan(BigDecimal value) {
			addCriterion("shop_rate >", value, "shopRate");
			return (Criteria) this;
		}

		public Criteria andShopRateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("shop_rate >=", value, "shopRate");
			return (Criteria) this;
		}

		public Criteria andShopRateLessThan(BigDecimal value) {
			addCriterion("shop_rate <", value, "shopRate");
			return (Criteria) this;
		}

		public Criteria andShopRateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("shop_rate <=", value, "shopRate");
			return (Criteria) this;
		}

		public Criteria andShopRateIn(List<BigDecimal> values) {
			addCriterion("shop_rate in", values, "shopRate");
			return (Criteria) this;
		}

		public Criteria andShopRateNotIn(List<BigDecimal> values) {
			addCriterion("shop_rate not in", values, "shopRate");
			return (Criteria) this;
		}

		public Criteria andShopRateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("shop_rate between", value1, value2, "shopRate");
			return (Criteria) this;
		}

		public Criteria andShopRateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("shop_rate not between", value1, value2, "shopRate");
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