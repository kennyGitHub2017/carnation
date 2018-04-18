package com.sinco.carnation.user.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhysicalResultExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public PhysicalResultExample() {
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

		public Criteria andItemCodeIsNull() {
			addCriterion("item_code is null");
			return (Criteria) this;
		}

		public Criteria andItemCodeIsNotNull() {
			addCriterion("item_code is not null");
			return (Criteria) this;
		}

		public Criteria andItemCodeEqualTo(String value) {
			addCriterion("item_code =", value, "itemCode");
			return (Criteria) this;
		}

		public Criteria andItemCodeNotEqualTo(String value) {
			addCriterion("item_code <>", value, "itemCode");
			return (Criteria) this;
		}

		public Criteria andItemCodeGreaterThan(String value) {
			addCriterion("item_code >", value, "itemCode");
			return (Criteria) this;
		}

		public Criteria andItemCodeGreaterThanOrEqualTo(String value) {
			addCriterion("item_code >=", value, "itemCode");
			return (Criteria) this;
		}

		public Criteria andItemCodeLessThan(String value) {
			addCriterion("item_code <", value, "itemCode");
			return (Criteria) this;
		}

		public Criteria andItemCodeLessThanOrEqualTo(String value) {
			addCriterion("item_code <=", value, "itemCode");
			return (Criteria) this;
		}

		public Criteria andItemCodeLike(String value) {
			addCriterion("item_code like", value, "itemCode");
			return (Criteria) this;
		}

		public Criteria andItemCodeNotLike(String value) {
			addCriterion("item_code not like", value, "itemCode");
			return (Criteria) this;
		}

		public Criteria andItemCodeIn(List<String> values) {
			addCriterion("item_code in", values, "itemCode");
			return (Criteria) this;
		}

		public Criteria andItemCodeNotIn(List<String> values) {
			addCriterion("item_code not in", values, "itemCode");
			return (Criteria) this;
		}

		public Criteria andItemCodeBetween(String value1, String value2) {
			addCriterion("item_code between", value1, value2, "itemCode");
			return (Criteria) this;
		}

		public Criteria andItemCodeNotBetween(String value1, String value2) {
			addCriterion("item_code not between", value1, value2, "itemCode");
			return (Criteria) this;
		}

		public Criteria andRangeMinIsNull() {
			addCriterion("range_min is null");
			return (Criteria) this;
		}

		public Criteria andRangeMinIsNotNull() {
			addCriterion("range_min is not null");
			return (Criteria) this;
		}

		public Criteria andRangeMinEqualTo(Float value) {
			addCriterion("range_min =", value, "rangeMin");
			return (Criteria) this;
		}

		public Criteria andRangeMinNotEqualTo(Float value) {
			addCriterion("range_min <>", value, "rangeMin");
			return (Criteria) this;
		}

		public Criteria andRangeMinGreaterThan(Float value) {
			addCriterion("range_min >", value, "rangeMin");
			return (Criteria) this;
		}

		public Criteria andRangeMinGreaterThanOrEqualTo(Float value) {
			addCriterion("range_min >=", value, "rangeMin");
			return (Criteria) this;
		}

		public Criteria andRangeMinLessThan(Float value) {
			addCriterion("range_min <", value, "rangeMin");
			return (Criteria) this;
		}

		public Criteria andRangeMinLessThanOrEqualTo(Float value) {
			addCriterion("range_min <=", value, "rangeMin");
			return (Criteria) this;
		}

		public Criteria andRangeMinIn(List<Float> values) {
			addCriterion("range_min in", values, "rangeMin");
			return (Criteria) this;
		}

		public Criteria andRangeMinNotIn(List<Float> values) {
			addCriterion("range_min not in", values, "rangeMin");
			return (Criteria) this;
		}

		public Criteria andRangeMinBetween(Float value1, Float value2) {
			addCriterion("range_min between", value1, value2, "rangeMin");
			return (Criteria) this;
		}

		public Criteria andRangeMinNotBetween(Float value1, Float value2) {
			addCriterion("range_min not between", value1, value2, "rangeMin");
			return (Criteria) this;
		}

		public Criteria andRangeMaxIsNull() {
			addCriterion("range_max is null");
			return (Criteria) this;
		}

		public Criteria andRangeMaxIsNotNull() {
			addCriterion("range_max is not null");
			return (Criteria) this;
		}

		public Criteria andRangeMaxEqualTo(Float value) {
			addCriterion("range_max =", value, "rangeMax");
			return (Criteria) this;
		}

		public Criteria andRangeMaxNotEqualTo(Float value) {
			addCriterion("range_max <>", value, "rangeMax");
			return (Criteria) this;
		}

		public Criteria andRangeMaxGreaterThan(Float value) {
			addCriterion("range_max >", value, "rangeMax");
			return (Criteria) this;
		}

		public Criteria andRangeMaxGreaterThanOrEqualTo(Float value) {
			addCriterion("range_max >=", value, "rangeMax");
			return (Criteria) this;
		}

		public Criteria andRangeMaxLessThan(Float value) {
			addCriterion("range_max <", value, "rangeMax");
			return (Criteria) this;
		}

		public Criteria andRangeMaxLessThanOrEqualTo(Float value) {
			addCriterion("range_max <=", value, "rangeMax");
			return (Criteria) this;
		}

		public Criteria andRangeMaxIn(List<Float> values) {
			addCriterion("range_max in", values, "rangeMax");
			return (Criteria) this;
		}

		public Criteria andRangeMaxNotIn(List<Float> values) {
			addCriterion("range_max not in", values, "rangeMax");
			return (Criteria) this;
		}

		public Criteria andRangeMaxBetween(Float value1, Float value2) {
			addCriterion("range_max between", value1, value2, "rangeMax");
			return (Criteria) this;
		}

		public Criteria andRangeMaxNotBetween(Float value1, Float value2) {
			addCriterion("range_max not between", value1, value2, "rangeMax");
			return (Criteria) this;
		}

		public Criteria andCheckResultIsNull() {
			addCriterion("check_result is null");
			return (Criteria) this;
		}

		public Criteria andCheckResultIsNotNull() {
			addCriterion("check_result is not null");
			return (Criteria) this;
		}

		public Criteria andCheckResultEqualTo(String value) {
			addCriterion("check_result =", value, "checkResult");
			return (Criteria) this;
		}

		public Criteria andCheckResultNotEqualTo(String value) {
			addCriterion("check_result <>", value, "checkResult");
			return (Criteria) this;
		}

		public Criteria andCheckResultGreaterThan(String value) {
			addCriterion("check_result >", value, "checkResult");
			return (Criteria) this;
		}

		public Criteria andCheckResultGreaterThanOrEqualTo(String value) {
			addCriterion("check_result >=", value, "checkResult");
			return (Criteria) this;
		}

		public Criteria andCheckResultLessThan(String value) {
			addCriterion("check_result <", value, "checkResult");
			return (Criteria) this;
		}

		public Criteria andCheckResultLessThanOrEqualTo(String value) {
			addCriterion("check_result <=", value, "checkResult");
			return (Criteria) this;
		}

		public Criteria andCheckResultLike(String value) {
			addCriterion("check_result like", value, "checkResult");
			return (Criteria) this;
		}

		public Criteria andCheckResultNotLike(String value) {
			addCriterion("check_result not like", value, "checkResult");
			return (Criteria) this;
		}

		public Criteria andCheckResultIn(List<String> values) {
			addCriterion("check_result in", values, "checkResult");
			return (Criteria) this;
		}

		public Criteria andCheckResultNotIn(List<String> values) {
			addCriterion("check_result not in", values, "checkResult");
			return (Criteria) this;
		}

		public Criteria andCheckResultBetween(String value1, String value2) {
			addCriterion("check_result between", value1, value2, "checkResult");
			return (Criteria) this;
		}

		public Criteria andCheckResultNotBetween(String value1, String value2) {
			addCriterion("check_result not between", value1, value2, "checkResult");
			return (Criteria) this;
		}

		public Criteria andDescIsNull() {
			addCriterion("desc is null");
			return (Criteria) this;
		}

		public Criteria andDescIsNotNull() {
			addCriterion("desc is not null");
			return (Criteria) this;
		}

		public Criteria andDescEqualTo(String value) {
			addCriterion("desc =", value, "desc");
			return (Criteria) this;
		}

		public Criteria andDescNotEqualTo(String value) {
			addCriterion("desc <>", value, "desc");
			return (Criteria) this;
		}

		public Criteria andDescGreaterThan(String value) {
			addCriterion("desc >", value, "desc");
			return (Criteria) this;
		}

		public Criteria andDescGreaterThanOrEqualTo(String value) {
			addCriterion("desc >=", value, "desc");
			return (Criteria) this;
		}

		public Criteria andDescLessThan(String value) {
			addCriterion("desc <", value, "desc");
			return (Criteria) this;
		}

		public Criteria andDescLessThanOrEqualTo(String value) {
			addCriterion("desc <=", value, "desc");
			return (Criteria) this;
		}

		public Criteria andDescLike(String value) {
			addCriterion("desc like", value, "desc");
			return (Criteria) this;
		}

		public Criteria andDescNotLike(String value) {
			addCriterion("desc not like", value, "desc");
			return (Criteria) this;
		}

		public Criteria andDescIn(List<String> values) {
			addCriterion("desc in", values, "desc");
			return (Criteria) this;
		}

		public Criteria andDescNotIn(List<String> values) {
			addCriterion("desc not in", values, "desc");
			return (Criteria) this;
		}

		public Criteria andDescBetween(String value1, String value2) {
			addCriterion("desc between", value1, value2, "desc");
			return (Criteria) this;
		}

		public Criteria andDescNotBetween(String value1, String value2) {
			addCriterion("desc not between", value1, value2, "desc");
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

		public Criteria andRangeMiddleIsNull() {
			addCriterion("range_middle is null");
			return (Criteria) this;
		}

		public Criteria andRangeMiddleIsNotNull() {
			addCriterion("range_middle is not null");
			return (Criteria) this;
		}

		public Criteria andRangeMiddleEqualTo(Float value) {
			addCriterion("range_middle =", value, "rangeMiddle");
			return (Criteria) this;
		}

		public Criteria andRangeMiddleNotEqualTo(Float value) {
			addCriterion("range_middle <>", value, "rangeMiddle");
			return (Criteria) this;
		}

		public Criteria andRangeMiddleGreaterThan(Float value) {
			addCriterion("range_middle >", value, "rangeMiddle");
			return (Criteria) this;
		}

		public Criteria andRangeMiddleGreaterThanOrEqualTo(Float value) {
			addCriterion("range_middle >=", value, "rangeMiddle");
			return (Criteria) this;
		}

		public Criteria andRangeMiddleLessThan(Float value) {
			addCriterion("range_middle <", value, "rangeMiddle");
			return (Criteria) this;
		}

		public Criteria andRangeMiddleLessThanOrEqualTo(Float value) {
			addCriterion("range_middle <=", value, "rangeMiddle");
			return (Criteria) this;
		}

		public Criteria andRangeMiddleIn(List<Float> values) {
			addCriterion("range_middle in", values, "rangeMiddle");
			return (Criteria) this;
		}

		public Criteria andRangeMiddleNotIn(List<Float> values) {
			addCriterion("range_middle not in", values, "rangeMiddle");
			return (Criteria) this;
		}

		public Criteria andRangeMiddleBetween(Float value1, Float value2) {
			addCriterion("range_middle between", value1, value2, "rangeMiddle");
			return (Criteria) this;
		}

		public Criteria andRangeMiddleNotBetween(Float value1, Float value2) {
			addCriterion("range_middle not between", value1, value2, "rangeMiddle");
			return (Criteria) this;
		}

		public Criteria andTerminalTypeIsNull() {
			addCriterion("terminal_type is null");
			return (Criteria) this;
		}

		public Criteria andTerminalTypeIsNotNull() {
			addCriterion("terminal_type is not null");
			return (Criteria) this;
		}

		public Criteria andTerminalTypeEqualTo(Byte value) {
			addCriterion("terminal_type =", value, "terminalType");
			return (Criteria) this;
		}

		public Criteria andTerminalTypeNotEqualTo(Byte value) {
			addCriterion("terminal_type <>", value, "terminalType");
			return (Criteria) this;
		}

		public Criteria andTerminalTypeGreaterThan(Byte value) {
			addCriterion("terminal_type >", value, "terminalType");
			return (Criteria) this;
		}

		public Criteria andTerminalTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("terminal_type >=", value, "terminalType");
			return (Criteria) this;
		}

		public Criteria andTerminalTypeLessThan(Byte value) {
			addCriterion("terminal_type <", value, "terminalType");
			return (Criteria) this;
		}

		public Criteria andTerminalTypeLessThanOrEqualTo(Byte value) {
			addCriterion("terminal_type <=", value, "terminalType");
			return (Criteria) this;
		}

		public Criteria andTerminalTypeIn(List<Byte> values) {
			addCriterion("terminal_type in", values, "terminalType");
			return (Criteria) this;
		}

		public Criteria andTerminalTypeNotIn(List<Byte> values) {
			addCriterion("terminal_type not in", values, "terminalType");
			return (Criteria) this;
		}

		public Criteria andTerminalTypeBetween(Byte value1, Byte value2) {
			addCriterion("terminal_type between", value1, value2, "terminalType");
			return (Criteria) this;
		}

		public Criteria andTerminalTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("terminal_type not between", value1, value2, "terminalType");
			return (Criteria) this;
		}

		public Criteria andValuationIdIsNull() {
			addCriterion("valuation_id is null");
			return (Criteria) this;
		}

		public Criteria andValuationIdIsNotNull() {
			addCriterion("valuation_id is not null");
			return (Criteria) this;
		}

		public Criteria andValuationIdEqualTo(Long value) {
			addCriterion("valuation_id =", value, "valuationId");
			return (Criteria) this;
		}

		public Criteria andValuationIdNotEqualTo(Long value) {
			addCriterion("valuation_id <>", value, "valuationId");
			return (Criteria) this;
		}

		public Criteria andValuationIdGreaterThan(Long value) {
			addCriterion("valuation_id >", value, "valuationId");
			return (Criteria) this;
		}

		public Criteria andValuationIdGreaterThanOrEqualTo(Long value) {
			addCriterion("valuation_id >=", value, "valuationId");
			return (Criteria) this;
		}

		public Criteria andValuationIdLessThan(Long value) {
			addCriterion("valuation_id <", value, "valuationId");
			return (Criteria) this;
		}

		public Criteria andValuationIdLessThanOrEqualTo(Long value) {
			addCriterion("valuation_id <=", value, "valuationId");
			return (Criteria) this;
		}

		public Criteria andValuationIdIn(List<Long> values) {
			addCriterion("valuation_id in", values, "valuationId");
			return (Criteria) this;
		}

		public Criteria andValuationIdNotIn(List<Long> values) {
			addCriterion("valuation_id not in", values, "valuationId");
			return (Criteria) this;
		}

		public Criteria andValuationIdBetween(Long value1, Long value2) {
			addCriterion("valuation_id between", value1, value2, "valuationId");
			return (Criteria) this;
		}

		public Criteria andValuationIdNotBetween(Long value1, Long value2) {
			addCriterion("valuation_id not between", value1, value2, "valuationId");
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