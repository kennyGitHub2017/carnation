package com.sinco.carnation.shop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EcCommonExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public EcCommonExample() {
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

		public Criteria andEccCodeIsNull() {
			addCriterion("ecc_code is null");
			return (Criteria) this;
		}

		public Criteria andEccCodeIsNotNull() {
			addCriterion("ecc_code is not null");
			return (Criteria) this;
		}

		public Criteria andEccCodeEqualTo(String value) {
			addCriterion("ecc_code =", value, "eccCode");
			return (Criteria) this;
		}

		public Criteria andEccCodeNotEqualTo(String value) {
			addCriterion("ecc_code <>", value, "eccCode");
			return (Criteria) this;
		}

		public Criteria andEccCodeGreaterThan(String value) {
			addCriterion("ecc_code >", value, "eccCode");
			return (Criteria) this;
		}

		public Criteria andEccCodeGreaterThanOrEqualTo(String value) {
			addCriterion("ecc_code >=", value, "eccCode");
			return (Criteria) this;
		}

		public Criteria andEccCodeLessThan(String value) {
			addCriterion("ecc_code <", value, "eccCode");
			return (Criteria) this;
		}

		public Criteria andEccCodeLessThanOrEqualTo(String value) {
			addCriterion("ecc_code <=", value, "eccCode");
			return (Criteria) this;
		}

		public Criteria andEccCodeLike(String value) {
			addCriterion("ecc_code like", value, "eccCode");
			return (Criteria) this;
		}

		public Criteria andEccCodeNotLike(String value) {
			addCriterion("ecc_code not like", value, "eccCode");
			return (Criteria) this;
		}

		public Criteria andEccCodeIn(List<String> values) {
			addCriterion("ecc_code in", values, "eccCode");
			return (Criteria) this;
		}

		public Criteria andEccCodeNotIn(List<String> values) {
			addCriterion("ecc_code not in", values, "eccCode");
			return (Criteria) this;
		}

		public Criteria andEccCodeBetween(String value1, String value2) {
			addCriterion("ecc_code between", value1, value2, "eccCode");
			return (Criteria) this;
		}

		public Criteria andEccCodeNotBetween(String value1, String value2) {
			addCriterion("ecc_code not between", value1, value2, "eccCode");
			return (Criteria) this;
		}

		public Criteria andEccDefaultIsNull() {
			addCriterion("ecc_default is null");
			return (Criteria) this;
		}

		public Criteria andEccDefaultIsNotNull() {
			addCriterion("ecc_default is not null");
			return (Criteria) this;
		}

		public Criteria andEccDefaultEqualTo(Integer value) {
			addCriterion("ecc_default =", value, "eccDefault");
			return (Criteria) this;
		}

		public Criteria andEccDefaultNotEqualTo(Integer value) {
			addCriterion("ecc_default <>", value, "eccDefault");
			return (Criteria) this;
		}

		public Criteria andEccDefaultGreaterThan(Integer value) {
			addCriterion("ecc_default >", value, "eccDefault");
			return (Criteria) this;
		}

		public Criteria andEccDefaultGreaterThanOrEqualTo(Integer value) {
			addCriterion("ecc_default >=", value, "eccDefault");
			return (Criteria) this;
		}

		public Criteria andEccDefaultLessThan(Integer value) {
			addCriterion("ecc_default <", value, "eccDefault");
			return (Criteria) this;
		}

		public Criteria andEccDefaultLessThanOrEqualTo(Integer value) {
			addCriterion("ecc_default <=", value, "eccDefault");
			return (Criteria) this;
		}

		public Criteria andEccDefaultIn(List<Integer> values) {
			addCriterion("ecc_default in", values, "eccDefault");
			return (Criteria) this;
		}

		public Criteria andEccDefaultNotIn(List<Integer> values) {
			addCriterion("ecc_default not in", values, "eccDefault");
			return (Criteria) this;
		}

		public Criteria andEccDefaultBetween(Integer value1, Integer value2) {
			addCriterion("ecc_default between", value1, value2, "eccDefault");
			return (Criteria) this;
		}

		public Criteria andEccDefaultNotBetween(Integer value1, Integer value2) {
			addCriterion("ecc_default not between", value1, value2, "eccDefault");
			return (Criteria) this;
		}

		public Criteria andEccEcIdIsNull() {
			addCriterion("ecc_ec_id is null");
			return (Criteria) this;
		}

		public Criteria andEccEcIdIsNotNull() {
			addCriterion("ecc_ec_id is not null");
			return (Criteria) this;
		}

		public Criteria andEccEcIdEqualTo(Long value) {
			addCriterion("ecc_ec_id =", value, "eccEcId");
			return (Criteria) this;
		}

		public Criteria andEccEcIdNotEqualTo(Long value) {
			addCriterion("ecc_ec_id <>", value, "eccEcId");
			return (Criteria) this;
		}

		public Criteria andEccEcIdGreaterThan(Long value) {
			addCriterion("ecc_ec_id >", value, "eccEcId");
			return (Criteria) this;
		}

		public Criteria andEccEcIdGreaterThanOrEqualTo(Long value) {
			addCriterion("ecc_ec_id >=", value, "eccEcId");
			return (Criteria) this;
		}

		public Criteria andEccEcIdLessThan(Long value) {
			addCriterion("ecc_ec_id <", value, "eccEcId");
			return (Criteria) this;
		}

		public Criteria andEccEcIdLessThanOrEqualTo(Long value) {
			addCriterion("ecc_ec_id <=", value, "eccEcId");
			return (Criteria) this;
		}

		public Criteria andEccEcIdIn(List<Long> values) {
			addCriterion("ecc_ec_id in", values, "eccEcId");
			return (Criteria) this;
		}

		public Criteria andEccEcIdNotIn(List<Long> values) {
			addCriterion("ecc_ec_id not in", values, "eccEcId");
			return (Criteria) this;
		}

		public Criteria andEccEcIdBetween(Long value1, Long value2) {
			addCriterion("ecc_ec_id between", value1, value2, "eccEcId");
			return (Criteria) this;
		}

		public Criteria andEccEcIdNotBetween(Long value1, Long value2) {
			addCriterion("ecc_ec_id not between", value1, value2, "eccEcId");
			return (Criteria) this;
		}

		public Criteria andEccEcTypeIsNull() {
			addCriterion("ecc_ec_type is null");
			return (Criteria) this;
		}

		public Criteria andEccEcTypeIsNotNull() {
			addCriterion("ecc_ec_type is not null");
			return (Criteria) this;
		}

		public Criteria andEccEcTypeEqualTo(String value) {
			addCriterion("ecc_ec_type =", value, "eccEcType");
			return (Criteria) this;
		}

		public Criteria andEccEcTypeNotEqualTo(String value) {
			addCriterion("ecc_ec_type <>", value, "eccEcType");
			return (Criteria) this;
		}

		public Criteria andEccEcTypeGreaterThan(String value) {
			addCriterion("ecc_ec_type >", value, "eccEcType");
			return (Criteria) this;
		}

		public Criteria andEccEcTypeGreaterThanOrEqualTo(String value) {
			addCriterion("ecc_ec_type >=", value, "eccEcType");
			return (Criteria) this;
		}

		public Criteria andEccEcTypeLessThan(String value) {
			addCriterion("ecc_ec_type <", value, "eccEcType");
			return (Criteria) this;
		}

		public Criteria andEccEcTypeLessThanOrEqualTo(String value) {
			addCriterion("ecc_ec_type <=", value, "eccEcType");
			return (Criteria) this;
		}

		public Criteria andEccEcTypeLike(String value) {
			addCriterion("ecc_ec_type like", value, "eccEcType");
			return (Criteria) this;
		}

		public Criteria andEccEcTypeNotLike(String value) {
			addCriterion("ecc_ec_type not like", value, "eccEcType");
			return (Criteria) this;
		}

		public Criteria andEccEcTypeIn(List<String> values) {
			addCriterion("ecc_ec_type in", values, "eccEcType");
			return (Criteria) this;
		}

		public Criteria andEccEcTypeNotIn(List<String> values) {
			addCriterion("ecc_ec_type not in", values, "eccEcType");
			return (Criteria) this;
		}

		public Criteria andEccEcTypeBetween(String value1, String value2) {
			addCriterion("ecc_ec_type between", value1, value2, "eccEcType");
			return (Criteria) this;
		}

		public Criteria andEccEcTypeNotBetween(String value1, String value2) {
			addCriterion("ecc_ec_type not between", value1, value2, "eccEcType");
			return (Criteria) this;
		}

		public Criteria andEccFromTypeIsNull() {
			addCriterion("ecc_from_type is null");
			return (Criteria) this;
		}

		public Criteria andEccFromTypeIsNotNull() {
			addCriterion("ecc_from_type is not null");
			return (Criteria) this;
		}

		public Criteria andEccFromTypeEqualTo(Integer value) {
			addCriterion("ecc_from_type =", value, "eccFromType");
			return (Criteria) this;
		}

		public Criteria andEccFromTypeNotEqualTo(Integer value) {
			addCriterion("ecc_from_type <>", value, "eccFromType");
			return (Criteria) this;
		}

		public Criteria andEccFromTypeGreaterThan(Integer value) {
			addCriterion("ecc_from_type >", value, "eccFromType");
			return (Criteria) this;
		}

		public Criteria andEccFromTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("ecc_from_type >=", value, "eccFromType");
			return (Criteria) this;
		}

		public Criteria andEccFromTypeLessThan(Integer value) {
			addCriterion("ecc_from_type <", value, "eccFromType");
			return (Criteria) this;
		}

		public Criteria andEccFromTypeLessThanOrEqualTo(Integer value) {
			addCriterion("ecc_from_type <=", value, "eccFromType");
			return (Criteria) this;
		}

		public Criteria andEccFromTypeIn(List<Integer> values) {
			addCriterion("ecc_from_type in", values, "eccFromType");
			return (Criteria) this;
		}

		public Criteria andEccFromTypeNotIn(List<Integer> values) {
			addCriterion("ecc_from_type not in", values, "eccFromType");
			return (Criteria) this;
		}

		public Criteria andEccFromTypeBetween(Integer value1, Integer value2) {
			addCriterion("ecc_from_type between", value1, value2, "eccFromType");
			return (Criteria) this;
		}

		public Criteria andEccFromTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("ecc_from_type not between", value1, value2, "eccFromType");
			return (Criteria) this;
		}

		public Criteria andEccNameIsNull() {
			addCriterion("ecc_name is null");
			return (Criteria) this;
		}

		public Criteria andEccNameIsNotNull() {
			addCriterion("ecc_name is not null");
			return (Criteria) this;
		}

		public Criteria andEccNameEqualTo(String value) {
			addCriterion("ecc_name =", value, "eccName");
			return (Criteria) this;
		}

		public Criteria andEccNameNotEqualTo(String value) {
			addCriterion("ecc_name <>", value, "eccName");
			return (Criteria) this;
		}

		public Criteria andEccNameGreaterThan(String value) {
			addCriterion("ecc_name >", value, "eccName");
			return (Criteria) this;
		}

		public Criteria andEccNameGreaterThanOrEqualTo(String value) {
			addCriterion("ecc_name >=", value, "eccName");
			return (Criteria) this;
		}

		public Criteria andEccNameLessThan(String value) {
			addCriterion("ecc_name <", value, "eccName");
			return (Criteria) this;
		}

		public Criteria andEccNameLessThanOrEqualTo(String value) {
			addCriterion("ecc_name <=", value, "eccName");
			return (Criteria) this;
		}

		public Criteria andEccNameLike(String value) {
			addCriterion("ecc_name like", value, "eccName");
			return (Criteria) this;
		}

		public Criteria andEccNameNotLike(String value) {
			addCriterion("ecc_name not like", value, "eccName");
			return (Criteria) this;
		}

		public Criteria andEccNameIn(List<String> values) {
			addCriterion("ecc_name in", values, "eccName");
			return (Criteria) this;
		}

		public Criteria andEccNameNotIn(List<String> values) {
			addCriterion("ecc_name not in", values, "eccName");
			return (Criteria) this;
		}

		public Criteria andEccNameBetween(String value1, String value2) {
			addCriterion("ecc_name between", value1, value2, "eccName");
			return (Criteria) this;
		}

		public Criteria andEccNameNotBetween(String value1, String value2) {
			addCriterion("ecc_name not between", value1, value2, "eccName");
			return (Criteria) this;
		}

		public Criteria andEccStoreIdIsNull() {
			addCriterion("ecc_store_id is null");
			return (Criteria) this;
		}

		public Criteria andEccStoreIdIsNotNull() {
			addCriterion("ecc_store_id is not null");
			return (Criteria) this;
		}

		public Criteria andEccStoreIdEqualTo(Long value) {
			addCriterion("ecc_store_id =", value, "eccStoreId");
			return (Criteria) this;
		}

		public Criteria andEccStoreIdNotEqualTo(Long value) {
			addCriterion("ecc_store_id <>", value, "eccStoreId");
			return (Criteria) this;
		}

		public Criteria andEccStoreIdGreaterThan(Long value) {
			addCriterion("ecc_store_id >", value, "eccStoreId");
			return (Criteria) this;
		}

		public Criteria andEccStoreIdGreaterThanOrEqualTo(Long value) {
			addCriterion("ecc_store_id >=", value, "eccStoreId");
			return (Criteria) this;
		}

		public Criteria andEccStoreIdLessThan(Long value) {
			addCriterion("ecc_store_id <", value, "eccStoreId");
			return (Criteria) this;
		}

		public Criteria andEccStoreIdLessThanOrEqualTo(Long value) {
			addCriterion("ecc_store_id <=", value, "eccStoreId");
			return (Criteria) this;
		}

		public Criteria andEccStoreIdIn(List<Long> values) {
			addCriterion("ecc_store_id in", values, "eccStoreId");
			return (Criteria) this;
		}

		public Criteria andEccStoreIdNotIn(List<Long> values) {
			addCriterion("ecc_store_id not in", values, "eccStoreId");
			return (Criteria) this;
		}

		public Criteria andEccStoreIdBetween(Long value1, Long value2) {
			addCriterion("ecc_store_id between", value1, value2, "eccStoreId");
			return (Criteria) this;
		}

		public Criteria andEccStoreIdNotBetween(Long value1, Long value2) {
			addCriterion("ecc_store_id not between", value1, value2, "eccStoreId");
			return (Criteria) this;
		}

		public Criteria andEccTemplateHeighIsNull() {
			addCriterion("ecc_template_heigh is null");
			return (Criteria) this;
		}

		public Criteria andEccTemplateHeighIsNotNull() {
			addCriterion("ecc_template_heigh is not null");
			return (Criteria) this;
		}

		public Criteria andEccTemplateHeighEqualTo(Integer value) {
			addCriterion("ecc_template_heigh =", value, "eccTemplateHeigh");
			return (Criteria) this;
		}

		public Criteria andEccTemplateHeighNotEqualTo(Integer value) {
			addCriterion("ecc_template_heigh <>", value, "eccTemplateHeigh");
			return (Criteria) this;
		}

		public Criteria andEccTemplateHeighGreaterThan(Integer value) {
			addCriterion("ecc_template_heigh >", value, "eccTemplateHeigh");
			return (Criteria) this;
		}

		public Criteria andEccTemplateHeighGreaterThanOrEqualTo(Integer value) {
			addCriterion("ecc_template_heigh >=", value, "eccTemplateHeigh");
			return (Criteria) this;
		}

		public Criteria andEccTemplateHeighLessThan(Integer value) {
			addCriterion("ecc_template_heigh <", value, "eccTemplateHeigh");
			return (Criteria) this;
		}

		public Criteria andEccTemplateHeighLessThanOrEqualTo(Integer value) {
			addCriterion("ecc_template_heigh <=", value, "eccTemplateHeigh");
			return (Criteria) this;
		}

		public Criteria andEccTemplateHeighIn(List<Integer> values) {
			addCriterion("ecc_template_heigh in", values, "eccTemplateHeigh");
			return (Criteria) this;
		}

		public Criteria andEccTemplateHeighNotIn(List<Integer> values) {
			addCriterion("ecc_template_heigh not in", values, "eccTemplateHeigh");
			return (Criteria) this;
		}

		public Criteria andEccTemplateHeighBetween(Integer value1, Integer value2) {
			addCriterion("ecc_template_heigh between", value1, value2, "eccTemplateHeigh");
			return (Criteria) this;
		}

		public Criteria andEccTemplateHeighNotBetween(Integer value1, Integer value2) {
			addCriterion("ecc_template_heigh not between", value1, value2, "eccTemplateHeigh");
			return (Criteria) this;
		}

		public Criteria andEccTemplateWidthIsNull() {
			addCriterion("ecc_template_width is null");
			return (Criteria) this;
		}

		public Criteria andEccTemplateWidthIsNotNull() {
			addCriterion("ecc_template_width is not null");
			return (Criteria) this;
		}

		public Criteria andEccTemplateWidthEqualTo(Integer value) {
			addCriterion("ecc_template_width =", value, "eccTemplateWidth");
			return (Criteria) this;
		}

		public Criteria andEccTemplateWidthNotEqualTo(Integer value) {
			addCriterion("ecc_template_width <>", value, "eccTemplateWidth");
			return (Criteria) this;
		}

		public Criteria andEccTemplateWidthGreaterThan(Integer value) {
			addCriterion("ecc_template_width >", value, "eccTemplateWidth");
			return (Criteria) this;
		}

		public Criteria andEccTemplateWidthGreaterThanOrEqualTo(Integer value) {
			addCriterion("ecc_template_width >=", value, "eccTemplateWidth");
			return (Criteria) this;
		}

		public Criteria andEccTemplateWidthLessThan(Integer value) {
			addCriterion("ecc_template_width <", value, "eccTemplateWidth");
			return (Criteria) this;
		}

		public Criteria andEccTemplateWidthLessThanOrEqualTo(Integer value) {
			addCriterion("ecc_template_width <=", value, "eccTemplateWidth");
			return (Criteria) this;
		}

		public Criteria andEccTemplateWidthIn(List<Integer> values) {
			addCriterion("ecc_template_width in", values, "eccTemplateWidth");
			return (Criteria) this;
		}

		public Criteria andEccTemplateWidthNotIn(List<Integer> values) {
			addCriterion("ecc_template_width not in", values, "eccTemplateWidth");
			return (Criteria) this;
		}

		public Criteria andEccTemplateWidthBetween(Integer value1, Integer value2) {
			addCriterion("ecc_template_width between", value1, value2, "eccTemplateWidth");
			return (Criteria) this;
		}

		public Criteria andEccTemplateWidthNotBetween(Integer value1, Integer value2) {
			addCriterion("ecc_template_width not between", value1, value2, "eccTemplateWidth");
			return (Criteria) this;
		}

		public Criteria andEccTypeIsNull() {
			addCriterion("ecc_type is null");
			return (Criteria) this;
		}

		public Criteria andEccTypeIsNotNull() {
			addCriterion("ecc_type is not null");
			return (Criteria) this;
		}

		public Criteria andEccTypeEqualTo(Integer value) {
			addCriterion("ecc_type =", value, "eccType");
			return (Criteria) this;
		}

		public Criteria andEccTypeNotEqualTo(Integer value) {
			addCriterion("ecc_type <>", value, "eccType");
			return (Criteria) this;
		}

		public Criteria andEccTypeGreaterThan(Integer value) {
			addCriterion("ecc_type >", value, "eccType");
			return (Criteria) this;
		}

		public Criteria andEccTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("ecc_type >=", value, "eccType");
			return (Criteria) this;
		}

		public Criteria andEccTypeLessThan(Integer value) {
			addCriterion("ecc_type <", value, "eccType");
			return (Criteria) this;
		}

		public Criteria andEccTypeLessThanOrEqualTo(Integer value) {
			addCriterion("ecc_type <=", value, "eccType");
			return (Criteria) this;
		}

		public Criteria andEccTypeIn(List<Integer> values) {
			addCriterion("ecc_type in", values, "eccType");
			return (Criteria) this;
		}

		public Criteria andEccTypeNotIn(List<Integer> values) {
			addCriterion("ecc_type not in", values, "eccType");
			return (Criteria) this;
		}

		public Criteria andEccTypeBetween(Integer value1, Integer value2) {
			addCriterion("ecc_type between", value1, value2, "eccType");
			return (Criteria) this;
		}

		public Criteria andEccTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("ecc_type not between", value1, value2, "eccType");
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