package com.sinco.carnation.shop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EnoughReduceExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public EnoughReduceExample() {
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

		protected void addCriterionForJDBCDate(String condition, Date value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()), property);
		}

		protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()),
					property);
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

		public Criteria andErTypeIsNull() {
			addCriterion("er_type is null");
			return (Criteria) this;
		}

		public Criteria andErTypeIsNotNull() {
			addCriterion("er_type is not null");
			return (Criteria) this;
		}

		public Criteria andErTypeEqualTo(Integer value) {
			addCriterion("er_type =", value, "erType");
			return (Criteria) this;
		}

		public Criteria andErTypeNotEqualTo(Integer value) {
			addCriterion("er_type <>", value, "erType");
			return (Criteria) this;
		}

		public Criteria andErTypeGreaterThan(Integer value) {
			addCriterion("er_type >", value, "erType");
			return (Criteria) this;
		}

		public Criteria andErTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("er_type >=", value, "erType");
			return (Criteria) this;
		}

		public Criteria andErTypeLessThan(Integer value) {
			addCriterion("er_type <", value, "erType");
			return (Criteria) this;
		}

		public Criteria andErTypeLessThanOrEqualTo(Integer value) {
			addCriterion("er_type <=", value, "erType");
			return (Criteria) this;
		}

		public Criteria andErTypeIn(List<Integer> values) {
			addCriterion("er_type in", values, "erType");
			return (Criteria) this;
		}

		public Criteria andErTypeNotIn(List<Integer> values) {
			addCriterion("er_type not in", values, "erType");
			return (Criteria) this;
		}

		public Criteria andErTypeBetween(Integer value1, Integer value2) {
			addCriterion("er_type between", value1, value2, "erType");
			return (Criteria) this;
		}

		public Criteria andErTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("er_type not between", value1, value2, "erType");
			return (Criteria) this;
		}

		public Criteria andErbeginTimeIsNull() {
			addCriterion("erbegin_time is null");
			return (Criteria) this;
		}

		public Criteria andErbeginTimeIsNotNull() {
			addCriterion("erbegin_time is not null");
			return (Criteria) this;
		}

		public Criteria andErbeginTimeEqualTo(Date value) {
			addCriterionForJDBCDate("erbegin_time =", value, "erbeginTime");
			return (Criteria) this;
		}

		public Criteria andErbeginTimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("erbegin_time <>", value, "erbeginTime");
			return (Criteria) this;
		}

		public Criteria andErbeginTimeGreaterThan(Date value) {
			addCriterionForJDBCDate("erbegin_time >", value, "erbeginTime");
			return (Criteria) this;
		}

		public Criteria andErbeginTimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("erbegin_time >=", value, "erbeginTime");
			return (Criteria) this;
		}

		public Criteria andErbeginTimeLessThan(Date value) {
			addCriterionForJDBCDate("erbegin_time <", value, "erbeginTime");
			return (Criteria) this;
		}

		public Criteria andErbeginTimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("erbegin_time <=", value, "erbeginTime");
			return (Criteria) this;
		}

		public Criteria andErbeginTimeIn(List<Date> values) {
			addCriterionForJDBCDate("erbegin_time in", values, "erbeginTime");
			return (Criteria) this;
		}

		public Criteria andErbeginTimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("erbegin_time not in", values, "erbeginTime");
			return (Criteria) this;
		}

		public Criteria andErbeginTimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("erbegin_time between", value1, value2, "erbeginTime");
			return (Criteria) this;
		}

		public Criteria andErbeginTimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("erbegin_time not between", value1, value2, "erbeginTime");
			return (Criteria) this;
		}

		public Criteria andErendTimeIsNull() {
			addCriterion("erend_time is null");
			return (Criteria) this;
		}

		public Criteria andErendTimeIsNotNull() {
			addCriterion("erend_time is not null");
			return (Criteria) this;
		}

		public Criteria andErendTimeEqualTo(Date value) {
			addCriterionForJDBCDate("erend_time =", value, "erendTime");
			return (Criteria) this;
		}

		public Criteria andErendTimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("erend_time <>", value, "erendTime");
			return (Criteria) this;
		}

		public Criteria andErendTimeGreaterThan(Date value) {
			addCriterionForJDBCDate("erend_time >", value, "erendTime");
			return (Criteria) this;
		}

		public Criteria andErendTimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("erend_time >=", value, "erendTime");
			return (Criteria) this;
		}

		public Criteria andErendTimeLessThan(Date value) {
			addCriterionForJDBCDate("erend_time <", value, "erendTime");
			return (Criteria) this;
		}

		public Criteria andErendTimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("erend_time <=", value, "erendTime");
			return (Criteria) this;
		}

		public Criteria andErendTimeIn(List<Date> values) {
			addCriterionForJDBCDate("erend_time in", values, "erendTime");
			return (Criteria) this;
		}

		public Criteria andErendTimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("erend_time not in", values, "erendTime");
			return (Criteria) this;
		}

		public Criteria andErendTimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("erend_time between", value1, value2, "erendTime");
			return (Criteria) this;
		}

		public Criteria andErendTimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("erend_time not between", value1, value2, "erendTime");
			return (Criteria) this;
		}

		public Criteria andErsequenceIsNull() {
			addCriterion("ersequence is null");
			return (Criteria) this;
		}

		public Criteria andErsequenceIsNotNull() {
			addCriterion("ersequence is not null");
			return (Criteria) this;
		}

		public Criteria andErsequenceEqualTo(Integer value) {
			addCriterion("ersequence =", value, "ersequence");
			return (Criteria) this;
		}

		public Criteria andErsequenceNotEqualTo(Integer value) {
			addCriterion("ersequence <>", value, "ersequence");
			return (Criteria) this;
		}

		public Criteria andErsequenceGreaterThan(Integer value) {
			addCriterion("ersequence >", value, "ersequence");
			return (Criteria) this;
		}

		public Criteria andErsequenceGreaterThanOrEqualTo(Integer value) {
			addCriterion("ersequence >=", value, "ersequence");
			return (Criteria) this;
		}

		public Criteria andErsequenceLessThan(Integer value) {
			addCriterion("ersequence <", value, "ersequence");
			return (Criteria) this;
		}

		public Criteria andErsequenceLessThanOrEqualTo(Integer value) {
			addCriterion("ersequence <=", value, "ersequence");
			return (Criteria) this;
		}

		public Criteria andErsequenceIn(List<Integer> values) {
			addCriterion("ersequence in", values, "ersequence");
			return (Criteria) this;
		}

		public Criteria andErsequenceNotIn(List<Integer> values) {
			addCriterion("ersequence not in", values, "ersequence");
			return (Criteria) this;
		}

		public Criteria andErsequenceBetween(Integer value1, Integer value2) {
			addCriterion("ersequence between", value1, value2, "ersequence");
			return (Criteria) this;
		}

		public Criteria andErsequenceNotBetween(Integer value1, Integer value2) {
			addCriterion("ersequence not between", value1, value2, "ersequence");
			return (Criteria) this;
		}

		public Criteria andErstatusIsNull() {
			addCriterion("erstatus is null");
			return (Criteria) this;
		}

		public Criteria andErstatusIsNotNull() {
			addCriterion("erstatus is not null");
			return (Criteria) this;
		}

		public Criteria andErstatusEqualTo(Integer value) {
			addCriterion("erstatus =", value, "erstatus");
			return (Criteria) this;
		}

		public Criteria andErstatusNotEqualTo(Integer value) {
			addCriterion("erstatus <>", value, "erstatus");
			return (Criteria) this;
		}

		public Criteria andErstatusGreaterThan(Integer value) {
			addCriterion("erstatus >", value, "erstatus");
			return (Criteria) this;
		}

		public Criteria andErstatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("erstatus >=", value, "erstatus");
			return (Criteria) this;
		}

		public Criteria andErstatusLessThan(Integer value) {
			addCriterion("erstatus <", value, "erstatus");
			return (Criteria) this;
		}

		public Criteria andErstatusLessThanOrEqualTo(Integer value) {
			addCriterion("erstatus <=", value, "erstatus");
			return (Criteria) this;
		}

		public Criteria andErstatusIn(List<Integer> values) {
			addCriterion("erstatus in", values, "erstatus");
			return (Criteria) this;
		}

		public Criteria andErstatusNotIn(List<Integer> values) {
			addCriterion("erstatus not in", values, "erstatus");
			return (Criteria) this;
		}

		public Criteria andErstatusBetween(Integer value1, Integer value2) {
			addCriterion("erstatus between", value1, value2, "erstatus");
			return (Criteria) this;
		}

		public Criteria andErstatusNotBetween(Integer value1, Integer value2) {
			addCriterion("erstatus not between", value1, value2, "erstatus");
			return (Criteria) this;
		}

		public Criteria andErtagIsNull() {
			addCriterion("ertag is null");
			return (Criteria) this;
		}

		public Criteria andErtagIsNotNull() {
			addCriterion("ertag is not null");
			return (Criteria) this;
		}

		public Criteria andErtagEqualTo(String value) {
			addCriterion("ertag =", value, "ertag");
			return (Criteria) this;
		}

		public Criteria andErtagNotEqualTo(String value) {
			addCriterion("ertag <>", value, "ertag");
			return (Criteria) this;
		}

		public Criteria andErtagGreaterThan(String value) {
			addCriterion("ertag >", value, "ertag");
			return (Criteria) this;
		}

		public Criteria andErtagGreaterThanOrEqualTo(String value) {
			addCriterion("ertag >=", value, "ertag");
			return (Criteria) this;
		}

		public Criteria andErtagLessThan(String value) {
			addCriterion("ertag <", value, "ertag");
			return (Criteria) this;
		}

		public Criteria andErtagLessThanOrEqualTo(String value) {
			addCriterion("ertag <=", value, "ertag");
			return (Criteria) this;
		}

		public Criteria andErtagLike(String value) {
			addCriterion("ertag like", value, "ertag");
			return (Criteria) this;
		}

		public Criteria andErtagNotLike(String value) {
			addCriterion("ertag not like", value, "ertag");
			return (Criteria) this;
		}

		public Criteria andErtagIn(List<String> values) {
			addCriterion("ertag in", values, "ertag");
			return (Criteria) this;
		}

		public Criteria andErtagNotIn(List<String> values) {
			addCriterion("ertag not in", values, "ertag");
			return (Criteria) this;
		}

		public Criteria andErtagBetween(String value1, String value2) {
			addCriterion("ertag between", value1, value2, "ertag");
			return (Criteria) this;
		}

		public Criteria andErtagNotBetween(String value1, String value2) {
			addCriterion("ertag not between", value1, value2, "ertag");
			return (Criteria) this;
		}

		public Criteria andErTitleIsNull() {
			addCriterion("er_title is null");
			return (Criteria) this;
		}

		public Criteria andErTitleIsNotNull() {
			addCriterion("er_title is not null");
			return (Criteria) this;
		}

		public Criteria andErTitleEqualTo(String value) {
			addCriterion("er_title =", value, "erTitle");
			return (Criteria) this;
		}

		public Criteria andErTitleNotEqualTo(String value) {
			addCriterion("er_title <>", value, "erTitle");
			return (Criteria) this;
		}

		public Criteria andErTitleGreaterThan(String value) {
			addCriterion("er_title >", value, "erTitle");
			return (Criteria) this;
		}

		public Criteria andErTitleGreaterThanOrEqualTo(String value) {
			addCriterion("er_title >=", value, "erTitle");
			return (Criteria) this;
		}

		public Criteria andErTitleLessThan(String value) {
			addCriterion("er_title <", value, "erTitle");
			return (Criteria) this;
		}

		public Criteria andErTitleLessThanOrEqualTo(String value) {
			addCriterion("er_title <=", value, "erTitle");
			return (Criteria) this;
		}

		public Criteria andErTitleLike(String value) {
			addCriterion("er_title like", value, "erTitle");
			return (Criteria) this;
		}

		public Criteria andErTitleNotLike(String value) {
			addCriterion("er_title not like", value, "erTitle");
			return (Criteria) this;
		}

		public Criteria andErTitleIn(List<String> values) {
			addCriterion("er_title in", values, "erTitle");
			return (Criteria) this;
		}

		public Criteria andErTitleNotIn(List<String> values) {
			addCriterion("er_title not in", values, "erTitle");
			return (Criteria) this;
		}

		public Criteria andErTitleBetween(String value1, String value2) {
			addCriterion("er_title between", value1, value2, "erTitle");
			return (Criteria) this;
		}

		public Criteria andErTitleNotBetween(String value1, String value2) {
			addCriterion("er_title not between", value1, value2, "erTitle");
			return (Criteria) this;
		}

		public Criteria andStoreIdIsNull() {
			addCriterion("store_id is null");
			return (Criteria) this;
		}

		public Criteria andStoreIdIsNotNull() {
			addCriterion("store_id is not null");
			return (Criteria) this;
		}

		public Criteria andStoreIdEqualTo(String value) {
			addCriterion("store_id =", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdNotEqualTo(String value) {
			addCriterion("store_id <>", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdGreaterThan(String value) {
			addCriterion("store_id >", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdGreaterThanOrEqualTo(String value) {
			addCriterion("store_id >=", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdLessThan(String value) {
			addCriterion("store_id <", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdLessThanOrEqualTo(String value) {
			addCriterion("store_id <=", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdLike(String value) {
			addCriterion("store_id like", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdNotLike(String value) {
			addCriterion("store_id not like", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdIn(List<String> values) {
			addCriterion("store_id in", values, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdNotIn(List<String> values) {
			addCriterion("store_id not in", values, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdBetween(String value1, String value2) {
			addCriterion("store_id between", value1, value2, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdNotBetween(String value1, String value2) {
			addCriterion("store_id not between", value1, value2, "storeId");
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