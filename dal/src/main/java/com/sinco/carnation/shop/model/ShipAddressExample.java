package com.sinco.carnation.shop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShipAddressExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public ShipAddressExample() {
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

		public Criteria andSaAddrIsNull() {
			addCriterion("sa_addr is null");
			return (Criteria) this;
		}

		public Criteria andSaAddrIsNotNull() {
			addCriterion("sa_addr is not null");
			return (Criteria) this;
		}

		public Criteria andSaAddrEqualTo(String value) {
			addCriterion("sa_addr =", value, "saAddr");
			return (Criteria) this;
		}

		public Criteria andSaAddrNotEqualTo(String value) {
			addCriterion("sa_addr <>", value, "saAddr");
			return (Criteria) this;
		}

		public Criteria andSaAddrGreaterThan(String value) {
			addCriterion("sa_addr >", value, "saAddr");
			return (Criteria) this;
		}

		public Criteria andSaAddrGreaterThanOrEqualTo(String value) {
			addCriterion("sa_addr >=", value, "saAddr");
			return (Criteria) this;
		}

		public Criteria andSaAddrLessThan(String value) {
			addCriterion("sa_addr <", value, "saAddr");
			return (Criteria) this;
		}

		public Criteria andSaAddrLessThanOrEqualTo(String value) {
			addCriterion("sa_addr <=", value, "saAddr");
			return (Criteria) this;
		}

		public Criteria andSaAddrLike(String value) {
			addCriterion("sa_addr like", value, "saAddr");
			return (Criteria) this;
		}

		public Criteria andSaAddrNotLike(String value) {
			addCriterion("sa_addr not like", value, "saAddr");
			return (Criteria) this;
		}

		public Criteria andSaAddrIn(List<String> values) {
			addCriterion("sa_addr in", values, "saAddr");
			return (Criteria) this;
		}

		public Criteria andSaAddrNotIn(List<String> values) {
			addCriterion("sa_addr not in", values, "saAddr");
			return (Criteria) this;
		}

		public Criteria andSaAddrBetween(String value1, String value2) {
			addCriterion("sa_addr between", value1, value2, "saAddr");
			return (Criteria) this;
		}

		public Criteria andSaAddrNotBetween(String value1, String value2) {
			addCriterion("sa_addr not between", value1, value2, "saAddr");
			return (Criteria) this;
		}

		public Criteria andSaAreaIdIsNull() {
			addCriterion("sa_area_id is null");
			return (Criteria) this;
		}

		public Criteria andSaAreaIdIsNotNull() {
			addCriterion("sa_area_id is not null");
			return (Criteria) this;
		}

		public Criteria andSaAreaIdEqualTo(Long value) {
			addCriterion("sa_area_id =", value, "saAreaId");
			return (Criteria) this;
		}

		public Criteria andSaAreaIdNotEqualTo(Long value) {
			addCriterion("sa_area_id <>", value, "saAreaId");
			return (Criteria) this;
		}

		public Criteria andSaAreaIdGreaterThan(Long value) {
			addCriterion("sa_area_id >", value, "saAreaId");
			return (Criteria) this;
		}

		public Criteria andSaAreaIdGreaterThanOrEqualTo(Long value) {
			addCriterion("sa_area_id >=", value, "saAreaId");
			return (Criteria) this;
		}

		public Criteria andSaAreaIdLessThan(Long value) {
			addCriterion("sa_area_id <", value, "saAreaId");
			return (Criteria) this;
		}

		public Criteria andSaAreaIdLessThanOrEqualTo(Long value) {
			addCriterion("sa_area_id <=", value, "saAreaId");
			return (Criteria) this;
		}

		public Criteria andSaAreaIdIn(List<Long> values) {
			addCriterion("sa_area_id in", values, "saAreaId");
			return (Criteria) this;
		}

		public Criteria andSaAreaIdNotIn(List<Long> values) {
			addCriterion("sa_area_id not in", values, "saAreaId");
			return (Criteria) this;
		}

		public Criteria andSaAreaIdBetween(Long value1, Long value2) {
			addCriterion("sa_area_id between", value1, value2, "saAreaId");
			return (Criteria) this;
		}

		public Criteria andSaAreaIdNotBetween(Long value1, Long value2) {
			addCriterion("sa_area_id not between", value1, value2, "saAreaId");
			return (Criteria) this;
		}

		public Criteria andSaCompanyIsNull() {
			addCriterion("sa_company is null");
			return (Criteria) this;
		}

		public Criteria andSaCompanyIsNotNull() {
			addCriterion("sa_company is not null");
			return (Criteria) this;
		}

		public Criteria andSaCompanyEqualTo(String value) {
			addCriterion("sa_company =", value, "saCompany");
			return (Criteria) this;
		}

		public Criteria andSaCompanyNotEqualTo(String value) {
			addCriterion("sa_company <>", value, "saCompany");
			return (Criteria) this;
		}

		public Criteria andSaCompanyGreaterThan(String value) {
			addCriterion("sa_company >", value, "saCompany");
			return (Criteria) this;
		}

		public Criteria andSaCompanyGreaterThanOrEqualTo(String value) {
			addCriterion("sa_company >=", value, "saCompany");
			return (Criteria) this;
		}

		public Criteria andSaCompanyLessThan(String value) {
			addCriterion("sa_company <", value, "saCompany");
			return (Criteria) this;
		}

		public Criteria andSaCompanyLessThanOrEqualTo(String value) {
			addCriterion("sa_company <=", value, "saCompany");
			return (Criteria) this;
		}

		public Criteria andSaCompanyLike(String value) {
			addCriterion("sa_company like", value, "saCompany");
			return (Criteria) this;
		}

		public Criteria andSaCompanyNotLike(String value) {
			addCriterion("sa_company not like", value, "saCompany");
			return (Criteria) this;
		}

		public Criteria andSaCompanyIn(List<String> values) {
			addCriterion("sa_company in", values, "saCompany");
			return (Criteria) this;
		}

		public Criteria andSaCompanyNotIn(List<String> values) {
			addCriterion("sa_company not in", values, "saCompany");
			return (Criteria) this;
		}

		public Criteria andSaCompanyBetween(String value1, String value2) {
			addCriterion("sa_company between", value1, value2, "saCompany");
			return (Criteria) this;
		}

		public Criteria andSaCompanyNotBetween(String value1, String value2) {
			addCriterion("sa_company not between", value1, value2, "saCompany");
			return (Criteria) this;
		}

		public Criteria andSaDefaultIsNull() {
			addCriterion("sa_default is null");
			return (Criteria) this;
		}

		public Criteria andSaDefaultIsNotNull() {
			addCriterion("sa_default is not null");
			return (Criteria) this;
		}

		public Criteria andSaDefaultEqualTo(Boolean value) {
			addCriterion("sa_default =", value, "saDefault");
			return (Criteria) this;
		}

		public Criteria andSaDefaultNotEqualTo(Boolean value) {
			addCriterion("sa_default <>", value, "saDefault");
			return (Criteria) this;
		}

		public Criteria andSaDefaultGreaterThan(Boolean value) {
			addCriterion("sa_default >", value, "saDefault");
			return (Criteria) this;
		}

		public Criteria andSaDefaultGreaterThanOrEqualTo(Boolean value) {
			addCriterion("sa_default >=", value, "saDefault");
			return (Criteria) this;
		}

		public Criteria andSaDefaultLessThan(Boolean value) {
			addCriterion("sa_default <", value, "saDefault");
			return (Criteria) this;
		}

		public Criteria andSaDefaultLessThanOrEqualTo(Boolean value) {
			addCriterion("sa_default <=", value, "saDefault");
			return (Criteria) this;
		}

		public Criteria andSaDefaultIn(List<Boolean> values) {
			addCriterion("sa_default in", values, "saDefault");
			return (Criteria) this;
		}

		public Criteria andSaDefaultNotIn(List<Boolean> values) {
			addCriterion("sa_default not in", values, "saDefault");
			return (Criteria) this;
		}

		public Criteria andSaDefaultBetween(Boolean value1, Boolean value2) {
			addCriterion("sa_default between", value1, value2, "saDefault");
			return (Criteria) this;
		}

		public Criteria andSaDefaultNotBetween(Boolean value1, Boolean value2) {
			addCriterion("sa_default not between", value1, value2, "saDefault");
			return (Criteria) this;
		}

		public Criteria andSaNameIsNull() {
			addCriterion("sa_name is null");
			return (Criteria) this;
		}

		public Criteria andSaNameIsNotNull() {
			addCriterion("sa_name is not null");
			return (Criteria) this;
		}

		public Criteria andSaNameEqualTo(String value) {
			addCriterion("sa_name =", value, "saName");
			return (Criteria) this;
		}

		public Criteria andSaNameNotEqualTo(String value) {
			addCriterion("sa_name <>", value, "saName");
			return (Criteria) this;
		}

		public Criteria andSaNameGreaterThan(String value) {
			addCriterion("sa_name >", value, "saName");
			return (Criteria) this;
		}

		public Criteria andSaNameGreaterThanOrEqualTo(String value) {
			addCriterion("sa_name >=", value, "saName");
			return (Criteria) this;
		}

		public Criteria andSaNameLessThan(String value) {
			addCriterion("sa_name <", value, "saName");
			return (Criteria) this;
		}

		public Criteria andSaNameLessThanOrEqualTo(String value) {
			addCriterion("sa_name <=", value, "saName");
			return (Criteria) this;
		}

		public Criteria andSaNameLike(String value) {
			addCriterion("sa_name like", value, "saName");
			return (Criteria) this;
		}

		public Criteria andSaNameNotLike(String value) {
			addCriterion("sa_name not like", value, "saName");
			return (Criteria) this;
		}

		public Criteria andSaNameIn(List<String> values) {
			addCriterion("sa_name in", values, "saName");
			return (Criteria) this;
		}

		public Criteria andSaNameNotIn(List<String> values) {
			addCriterion("sa_name not in", values, "saName");
			return (Criteria) this;
		}

		public Criteria andSaNameBetween(String value1, String value2) {
			addCriterion("sa_name between", value1, value2, "saName");
			return (Criteria) this;
		}

		public Criteria andSaNameNotBetween(String value1, String value2) {
			addCriterion("sa_name not between", value1, value2, "saName");
			return (Criteria) this;
		}

		public Criteria andSaSequenceIsNull() {
			addCriterion("sa_sequence is null");
			return (Criteria) this;
		}

		public Criteria andSaSequenceIsNotNull() {
			addCriterion("sa_sequence is not null");
			return (Criteria) this;
		}

		public Criteria andSaSequenceEqualTo(Integer value) {
			addCriterion("sa_sequence =", value, "saSequence");
			return (Criteria) this;
		}

		public Criteria andSaSequenceNotEqualTo(Integer value) {
			addCriterion("sa_sequence <>", value, "saSequence");
			return (Criteria) this;
		}

		public Criteria andSaSequenceGreaterThan(Integer value) {
			addCriterion("sa_sequence >", value, "saSequence");
			return (Criteria) this;
		}

		public Criteria andSaSequenceGreaterThanOrEqualTo(Integer value) {
			addCriterion("sa_sequence >=", value, "saSequence");
			return (Criteria) this;
		}

		public Criteria andSaSequenceLessThan(Integer value) {
			addCriterion("sa_sequence <", value, "saSequence");
			return (Criteria) this;
		}

		public Criteria andSaSequenceLessThanOrEqualTo(Integer value) {
			addCriterion("sa_sequence <=", value, "saSequence");
			return (Criteria) this;
		}

		public Criteria andSaSequenceIn(List<Integer> values) {
			addCriterion("sa_sequence in", values, "saSequence");
			return (Criteria) this;
		}

		public Criteria andSaSequenceNotIn(List<Integer> values) {
			addCriterion("sa_sequence not in", values, "saSequence");
			return (Criteria) this;
		}

		public Criteria andSaSequenceBetween(Integer value1, Integer value2) {
			addCriterion("sa_sequence between", value1, value2, "saSequence");
			return (Criteria) this;
		}

		public Criteria andSaSequenceNotBetween(Integer value1, Integer value2) {
			addCriterion("sa_sequence not between", value1, value2, "saSequence");
			return (Criteria) this;
		}

		public Criteria andSaTelephoneIsNull() {
			addCriterion("sa_telephone is null");
			return (Criteria) this;
		}

		public Criteria andSaTelephoneIsNotNull() {
			addCriterion("sa_telephone is not null");
			return (Criteria) this;
		}

		public Criteria andSaTelephoneEqualTo(String value) {
			addCriterion("sa_telephone =", value, "saTelephone");
			return (Criteria) this;
		}

		public Criteria andSaTelephoneNotEqualTo(String value) {
			addCriterion("sa_telephone <>", value, "saTelephone");
			return (Criteria) this;
		}

		public Criteria andSaTelephoneGreaterThan(String value) {
			addCriterion("sa_telephone >", value, "saTelephone");
			return (Criteria) this;
		}

		public Criteria andSaTelephoneGreaterThanOrEqualTo(String value) {
			addCriterion("sa_telephone >=", value, "saTelephone");
			return (Criteria) this;
		}

		public Criteria andSaTelephoneLessThan(String value) {
			addCriterion("sa_telephone <", value, "saTelephone");
			return (Criteria) this;
		}

		public Criteria andSaTelephoneLessThanOrEqualTo(String value) {
			addCriterion("sa_telephone <=", value, "saTelephone");
			return (Criteria) this;
		}

		public Criteria andSaTelephoneLike(String value) {
			addCriterion("sa_telephone like", value, "saTelephone");
			return (Criteria) this;
		}

		public Criteria andSaTelephoneNotLike(String value) {
			addCriterion("sa_telephone not like", value, "saTelephone");
			return (Criteria) this;
		}

		public Criteria andSaTelephoneIn(List<String> values) {
			addCriterion("sa_telephone in", values, "saTelephone");
			return (Criteria) this;
		}

		public Criteria andSaTelephoneNotIn(List<String> values) {
			addCriterion("sa_telephone not in", values, "saTelephone");
			return (Criteria) this;
		}

		public Criteria andSaTelephoneBetween(String value1, String value2) {
			addCriterion("sa_telephone between", value1, value2, "saTelephone");
			return (Criteria) this;
		}

		public Criteria andSaTelephoneNotBetween(String value1, String value2) {
			addCriterion("sa_telephone not between", value1, value2, "saTelephone");
			return (Criteria) this;
		}

		public Criteria andSaTypeIsNull() {
			addCriterion("sa_type is null");
			return (Criteria) this;
		}

		public Criteria andSaTypeIsNotNull() {
			addCriterion("sa_type is not null");
			return (Criteria) this;
		}

		public Criteria andSaTypeEqualTo(Integer value) {
			addCriterion("sa_type =", value, "saType");
			return (Criteria) this;
		}

		public Criteria andSaTypeNotEqualTo(Integer value) {
			addCriterion("sa_type <>", value, "saType");
			return (Criteria) this;
		}

		public Criteria andSaTypeGreaterThan(Integer value) {
			addCriterion("sa_type >", value, "saType");
			return (Criteria) this;
		}

		public Criteria andSaTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("sa_type >=", value, "saType");
			return (Criteria) this;
		}

		public Criteria andSaTypeLessThan(Integer value) {
			addCriterion("sa_type <", value, "saType");
			return (Criteria) this;
		}

		public Criteria andSaTypeLessThanOrEqualTo(Integer value) {
			addCriterion("sa_type <=", value, "saType");
			return (Criteria) this;
		}

		public Criteria andSaTypeIn(List<Integer> values) {
			addCriterion("sa_type in", values, "saType");
			return (Criteria) this;
		}

		public Criteria andSaTypeNotIn(List<Integer> values) {
			addCriterion("sa_type not in", values, "saType");
			return (Criteria) this;
		}

		public Criteria andSaTypeBetween(Integer value1, Integer value2) {
			addCriterion("sa_type between", value1, value2, "saType");
			return (Criteria) this;
		}

		public Criteria andSaTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("sa_type not between", value1, value2, "saType");
			return (Criteria) this;
		}

		public Criteria andSaUserIsNull() {
			addCriterion("sa_user is null");
			return (Criteria) this;
		}

		public Criteria andSaUserIsNotNull() {
			addCriterion("sa_user is not null");
			return (Criteria) this;
		}

		public Criteria andSaUserEqualTo(String value) {
			addCriterion("sa_user =", value, "saUser");
			return (Criteria) this;
		}

		public Criteria andSaUserNotEqualTo(String value) {
			addCriterion("sa_user <>", value, "saUser");
			return (Criteria) this;
		}

		public Criteria andSaUserGreaterThan(String value) {
			addCriterion("sa_user >", value, "saUser");
			return (Criteria) this;
		}

		public Criteria andSaUserGreaterThanOrEqualTo(String value) {
			addCriterion("sa_user >=", value, "saUser");
			return (Criteria) this;
		}

		public Criteria andSaUserLessThan(String value) {
			addCriterion("sa_user <", value, "saUser");
			return (Criteria) this;
		}

		public Criteria andSaUserLessThanOrEqualTo(String value) {
			addCriterion("sa_user <=", value, "saUser");
			return (Criteria) this;
		}

		public Criteria andSaUserLike(String value) {
			addCriterion("sa_user like", value, "saUser");
			return (Criteria) this;
		}

		public Criteria andSaUserNotLike(String value) {
			addCriterion("sa_user not like", value, "saUser");
			return (Criteria) this;
		}

		public Criteria andSaUserIn(List<String> values) {
			addCriterion("sa_user in", values, "saUser");
			return (Criteria) this;
		}

		public Criteria andSaUserNotIn(List<String> values) {
			addCriterion("sa_user not in", values, "saUser");
			return (Criteria) this;
		}

		public Criteria andSaUserBetween(String value1, String value2) {
			addCriterion("sa_user between", value1, value2, "saUser");
			return (Criteria) this;
		}

		public Criteria andSaUserNotBetween(String value1, String value2) {
			addCriterion("sa_user not between", value1, value2, "saUser");
			return (Criteria) this;
		}

		public Criteria andSaUserIdIsNull() {
			addCriterion("sa_user_id is null");
			return (Criteria) this;
		}

		public Criteria andSaUserIdIsNotNull() {
			addCriterion("sa_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andSaUserIdEqualTo(Long value) {
			addCriterion("sa_user_id =", value, "saUserId");
			return (Criteria) this;
		}

		public Criteria andSaUserIdNotEqualTo(Long value) {
			addCriterion("sa_user_id <>", value, "saUserId");
			return (Criteria) this;
		}

		public Criteria andSaUserIdGreaterThan(Long value) {
			addCriterion("sa_user_id >", value, "saUserId");
			return (Criteria) this;
		}

		public Criteria andSaUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("sa_user_id >=", value, "saUserId");
			return (Criteria) this;
		}

		public Criteria andSaUserIdLessThan(Long value) {
			addCriterion("sa_user_id <", value, "saUserId");
			return (Criteria) this;
		}

		public Criteria andSaUserIdLessThanOrEqualTo(Long value) {
			addCriterion("sa_user_id <=", value, "saUserId");
			return (Criteria) this;
		}

		public Criteria andSaUserIdIn(List<Long> values) {
			addCriterion("sa_user_id in", values, "saUserId");
			return (Criteria) this;
		}

		public Criteria andSaUserIdNotIn(List<Long> values) {
			addCriterion("sa_user_id not in", values, "saUserId");
			return (Criteria) this;
		}

		public Criteria andSaUserIdBetween(Long value1, Long value2) {
			addCriterion("sa_user_id between", value1, value2, "saUserId");
			return (Criteria) this;
		}

		public Criteria andSaUserIdNotBetween(Long value1, Long value2) {
			addCriterion("sa_user_id not between", value1, value2, "saUserId");
			return (Criteria) this;
		}

		public Criteria andSaZipIsNull() {
			addCriterion("sa_zip is null");
			return (Criteria) this;
		}

		public Criteria andSaZipIsNotNull() {
			addCriterion("sa_zip is not null");
			return (Criteria) this;
		}

		public Criteria andSaZipEqualTo(String value) {
			addCriterion("sa_zip =", value, "saZip");
			return (Criteria) this;
		}

		public Criteria andSaZipNotEqualTo(String value) {
			addCriterion("sa_zip <>", value, "saZip");
			return (Criteria) this;
		}

		public Criteria andSaZipGreaterThan(String value) {
			addCriterion("sa_zip >", value, "saZip");
			return (Criteria) this;
		}

		public Criteria andSaZipGreaterThanOrEqualTo(String value) {
			addCriterion("sa_zip >=", value, "saZip");
			return (Criteria) this;
		}

		public Criteria andSaZipLessThan(String value) {
			addCriterion("sa_zip <", value, "saZip");
			return (Criteria) this;
		}

		public Criteria andSaZipLessThanOrEqualTo(String value) {
			addCriterion("sa_zip <=", value, "saZip");
			return (Criteria) this;
		}

		public Criteria andSaZipLike(String value) {
			addCriterion("sa_zip like", value, "saZip");
			return (Criteria) this;
		}

		public Criteria andSaZipNotLike(String value) {
			addCriterion("sa_zip not like", value, "saZip");
			return (Criteria) this;
		}

		public Criteria andSaZipIn(List<String> values) {
			addCriterion("sa_zip in", values, "saZip");
			return (Criteria) this;
		}

		public Criteria andSaZipNotIn(List<String> values) {
			addCriterion("sa_zip not in", values, "saZip");
			return (Criteria) this;
		}

		public Criteria andSaZipBetween(String value1, String value2) {
			addCriterion("sa_zip between", value1, value2, "saZip");
			return (Criteria) this;
		}

		public Criteria andSaZipNotBetween(String value1, String value2) {
			addCriterion("sa_zip not between", value1, value2, "saZip");
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