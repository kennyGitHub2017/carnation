package com.sinco.carnation.shop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CombinplanExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public CombinplanExample() {
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

		public Criteria andBeginTimeIsNull() {
			addCriterion("begin_time is null");
			return (Criteria) this;
		}

		public Criteria andBeginTimeIsNotNull() {
			addCriterion("begin_time is not null");
			return (Criteria) this;
		}

		public Criteria andBeginTimeEqualTo(Date value) {
			addCriterion("begin_time =", value, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeNotEqualTo(Date value) {
			addCriterion("begin_time <>", value, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeGreaterThan(Date value) {
			addCriterion("begin_time >", value, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("begin_time >=", value, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeLessThan(Date value) {
			addCriterion("begin_time <", value, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeLessThanOrEqualTo(Date value) {
			addCriterion("begin_time <=", value, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeIn(List<Date> values) {
			addCriterion("begin_time in", values, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeNotIn(List<Date> values) {
			addCriterion("begin_time not in", values, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeBetween(Date value1, Date value2) {
			addCriterion("begin_time between", value1, value2, "beginTime");
			return (Criteria) this;
		}

		public Criteria andBeginTimeNotBetween(Date value1, Date value2) {
			addCriterion("begin_time not between", value1, value2, "beginTime");
			return (Criteria) this;
		}

		public Criteria andCombinFormIsNull() {
			addCriterion("combin_form is null");
			return (Criteria) this;
		}

		public Criteria andCombinFormIsNotNull() {
			addCriterion("combin_form is not null");
			return (Criteria) this;
		}

		public Criteria andCombinFormEqualTo(Integer value) {
			addCriterion("combin_form =", value, "combinForm");
			return (Criteria) this;
		}

		public Criteria andCombinFormNotEqualTo(Integer value) {
			addCriterion("combin_form <>", value, "combinForm");
			return (Criteria) this;
		}

		public Criteria andCombinFormGreaterThan(Integer value) {
			addCriterion("combin_form >", value, "combinForm");
			return (Criteria) this;
		}

		public Criteria andCombinFormGreaterThanOrEqualTo(Integer value) {
			addCriterion("combin_form >=", value, "combinForm");
			return (Criteria) this;
		}

		public Criteria andCombinFormLessThan(Integer value) {
			addCriterion("combin_form <", value, "combinForm");
			return (Criteria) this;
		}

		public Criteria andCombinFormLessThanOrEqualTo(Integer value) {
			addCriterion("combin_form <=", value, "combinForm");
			return (Criteria) this;
		}

		public Criteria andCombinFormIn(List<Integer> values) {
			addCriterion("combin_form in", values, "combinForm");
			return (Criteria) this;
		}

		public Criteria andCombinFormNotIn(List<Integer> values) {
			addCriterion("combin_form not in", values, "combinForm");
			return (Criteria) this;
		}

		public Criteria andCombinFormBetween(Integer value1, Integer value2) {
			addCriterion("combin_form between", value1, value2, "combinForm");
			return (Criteria) this;
		}

		public Criteria andCombinFormNotBetween(Integer value1, Integer value2) {
			addCriterion("combin_form not between", value1, value2, "combinForm");
			return (Criteria) this;
		}

		public Criteria andCombinRefuseMsgIsNull() {
			addCriterion("combin_refuse_msg is null");
			return (Criteria) this;
		}

		public Criteria andCombinRefuseMsgIsNotNull() {
			addCriterion("combin_refuse_msg is not null");
			return (Criteria) this;
		}

		public Criteria andCombinRefuseMsgEqualTo(String value) {
			addCriterion("combin_refuse_msg =", value, "combinRefuseMsg");
			return (Criteria) this;
		}

		public Criteria andCombinRefuseMsgNotEqualTo(String value) {
			addCriterion("combin_refuse_msg <>", value, "combinRefuseMsg");
			return (Criteria) this;
		}

		public Criteria andCombinRefuseMsgGreaterThan(String value) {
			addCriterion("combin_refuse_msg >", value, "combinRefuseMsg");
			return (Criteria) this;
		}

		public Criteria andCombinRefuseMsgGreaterThanOrEqualTo(String value) {
			addCriterion("combin_refuse_msg >=", value, "combinRefuseMsg");
			return (Criteria) this;
		}

		public Criteria andCombinRefuseMsgLessThan(String value) {
			addCriterion("combin_refuse_msg <", value, "combinRefuseMsg");
			return (Criteria) this;
		}

		public Criteria andCombinRefuseMsgLessThanOrEqualTo(String value) {
			addCriterion("combin_refuse_msg <=", value, "combinRefuseMsg");
			return (Criteria) this;
		}

		public Criteria andCombinRefuseMsgLike(String value) {
			addCriterion("combin_refuse_msg like", value, "combinRefuseMsg");
			return (Criteria) this;
		}

		public Criteria andCombinRefuseMsgNotLike(String value) {
			addCriterion("combin_refuse_msg not like", value, "combinRefuseMsg");
			return (Criteria) this;
		}

		public Criteria andCombinRefuseMsgIn(List<String> values) {
			addCriterion("combin_refuse_msg in", values, "combinRefuseMsg");
			return (Criteria) this;
		}

		public Criteria andCombinRefuseMsgNotIn(List<String> values) {
			addCriterion("combin_refuse_msg not in", values, "combinRefuseMsg");
			return (Criteria) this;
		}

		public Criteria andCombinRefuseMsgBetween(String value1, String value2) {
			addCriterion("combin_refuse_msg between", value1, value2, "combinRefuseMsg");
			return (Criteria) this;
		}

		public Criteria andCombinRefuseMsgNotBetween(String value1, String value2) {
			addCriterion("combin_refuse_msg not between", value1, value2, "combinRefuseMsg");
			return (Criteria) this;
		}

		public Criteria andCombinStatusIsNull() {
			addCriterion("combin_status is null");
			return (Criteria) this;
		}

		public Criteria andCombinStatusIsNotNull() {
			addCriterion("combin_status is not null");
			return (Criteria) this;
		}

		public Criteria andCombinStatusEqualTo(Integer value) {
			addCriterion("combin_status =", value, "combinStatus");
			return (Criteria) this;
		}

		public Criteria andCombinStatusNotEqualTo(Integer value) {
			addCriterion("combin_status <>", value, "combinStatus");
			return (Criteria) this;
		}

		public Criteria andCombinStatusGreaterThan(Integer value) {
			addCriterion("combin_status >", value, "combinStatus");
			return (Criteria) this;
		}

		public Criteria andCombinStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("combin_status >=", value, "combinStatus");
			return (Criteria) this;
		}

		public Criteria andCombinStatusLessThan(Integer value) {
			addCriterion("combin_status <", value, "combinStatus");
			return (Criteria) this;
		}

		public Criteria andCombinStatusLessThanOrEqualTo(Integer value) {
			addCriterion("combin_status <=", value, "combinStatus");
			return (Criteria) this;
		}

		public Criteria andCombinStatusIn(List<Integer> values) {
			addCriterion("combin_status in", values, "combinStatus");
			return (Criteria) this;
		}

		public Criteria andCombinStatusNotIn(List<Integer> values) {
			addCriterion("combin_status not in", values, "combinStatus");
			return (Criteria) this;
		}

		public Criteria andCombinStatusBetween(Integer value1, Integer value2) {
			addCriterion("combin_status between", value1, value2, "combinStatus");
			return (Criteria) this;
		}

		public Criteria andCombinStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("combin_status not between", value1, value2, "combinStatus");
			return (Criteria) this;
		}

		public Criteria andCombinTypeIsNull() {
			addCriterion("combin_type is null");
			return (Criteria) this;
		}

		public Criteria andCombinTypeIsNotNull() {
			addCriterion("combin_type is not null");
			return (Criteria) this;
		}

		public Criteria andCombinTypeEqualTo(Integer value) {
			addCriterion("combin_type =", value, "combinType");
			return (Criteria) this;
		}

		public Criteria andCombinTypeNotEqualTo(Integer value) {
			addCriterion("combin_type <>", value, "combinType");
			return (Criteria) this;
		}

		public Criteria andCombinTypeGreaterThan(Integer value) {
			addCriterion("combin_type >", value, "combinType");
			return (Criteria) this;
		}

		public Criteria andCombinTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("combin_type >=", value, "combinType");
			return (Criteria) this;
		}

		public Criteria andCombinTypeLessThan(Integer value) {
			addCriterion("combin_type <", value, "combinType");
			return (Criteria) this;
		}

		public Criteria andCombinTypeLessThanOrEqualTo(Integer value) {
			addCriterion("combin_type <=", value, "combinType");
			return (Criteria) this;
		}

		public Criteria andCombinTypeIn(List<Integer> values) {
			addCriterion("combin_type in", values, "combinType");
			return (Criteria) this;
		}

		public Criteria andCombinTypeNotIn(List<Integer> values) {
			addCriterion("combin_type not in", values, "combinType");
			return (Criteria) this;
		}

		public Criteria andCombinTypeBetween(Integer value1, Integer value2) {
			addCriterion("combin_type between", value1, value2, "combinType");
			return (Criteria) this;
		}

		public Criteria andCombinTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("combin_type not between", value1, value2, "combinType");
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

		public Criteria andMainGoodsIdIsNull() {
			addCriterion("main_goods_id is null");
			return (Criteria) this;
		}

		public Criteria andMainGoodsIdIsNotNull() {
			addCriterion("main_goods_id is not null");
			return (Criteria) this;
		}

		public Criteria andMainGoodsIdEqualTo(Long value) {
			addCriterion("main_goods_id =", value, "mainGoodsId");
			return (Criteria) this;
		}

		public Criteria andMainGoodsIdNotEqualTo(Long value) {
			addCriterion("main_goods_id <>", value, "mainGoodsId");
			return (Criteria) this;
		}

		public Criteria andMainGoodsIdGreaterThan(Long value) {
			addCriterion("main_goods_id >", value, "mainGoodsId");
			return (Criteria) this;
		}

		public Criteria andMainGoodsIdGreaterThanOrEqualTo(Long value) {
			addCriterion("main_goods_id >=", value, "mainGoodsId");
			return (Criteria) this;
		}

		public Criteria andMainGoodsIdLessThan(Long value) {
			addCriterion("main_goods_id <", value, "mainGoodsId");
			return (Criteria) this;
		}

		public Criteria andMainGoodsIdLessThanOrEqualTo(Long value) {
			addCriterion("main_goods_id <=", value, "mainGoodsId");
			return (Criteria) this;
		}

		public Criteria andMainGoodsIdIn(List<Long> values) {
			addCriterion("main_goods_id in", values, "mainGoodsId");
			return (Criteria) this;
		}

		public Criteria andMainGoodsIdNotIn(List<Long> values) {
			addCriterion("main_goods_id not in", values, "mainGoodsId");
			return (Criteria) this;
		}

		public Criteria andMainGoodsIdBetween(Long value1, Long value2) {
			addCriterion("main_goods_id between", value1, value2, "mainGoodsId");
			return (Criteria) this;
		}

		public Criteria andMainGoodsIdNotBetween(Long value1, Long value2) {
			addCriterion("main_goods_id not between", value1, value2, "mainGoodsId");
			return (Criteria) this;
		}

		public Criteria andMainGoodsNameIsNull() {
			addCriterion("main_goods_name is null");
			return (Criteria) this;
		}

		public Criteria andMainGoodsNameIsNotNull() {
			addCriterion("main_goods_name is not null");
			return (Criteria) this;
		}

		public Criteria andMainGoodsNameEqualTo(String value) {
			addCriterion("main_goods_name =", value, "mainGoodsName");
			return (Criteria) this;
		}

		public Criteria andMainGoodsNameNotEqualTo(String value) {
			addCriterion("main_goods_name <>", value, "mainGoodsName");
			return (Criteria) this;
		}

		public Criteria andMainGoodsNameGreaterThan(String value) {
			addCriterion("main_goods_name >", value, "mainGoodsName");
			return (Criteria) this;
		}

		public Criteria andMainGoodsNameGreaterThanOrEqualTo(String value) {
			addCriterion("main_goods_name >=", value, "mainGoodsName");
			return (Criteria) this;
		}

		public Criteria andMainGoodsNameLessThan(String value) {
			addCriterion("main_goods_name <", value, "mainGoodsName");
			return (Criteria) this;
		}

		public Criteria andMainGoodsNameLessThanOrEqualTo(String value) {
			addCriterion("main_goods_name <=", value, "mainGoodsName");
			return (Criteria) this;
		}

		public Criteria andMainGoodsNameLike(String value) {
			addCriterion("main_goods_name like", value, "mainGoodsName");
			return (Criteria) this;
		}

		public Criteria andMainGoodsNameNotLike(String value) {
			addCriterion("main_goods_name not like", value, "mainGoodsName");
			return (Criteria) this;
		}

		public Criteria andMainGoodsNameIn(List<String> values) {
			addCriterion("main_goods_name in", values, "mainGoodsName");
			return (Criteria) this;
		}

		public Criteria andMainGoodsNameNotIn(List<String> values) {
			addCriterion("main_goods_name not in", values, "mainGoodsName");
			return (Criteria) this;
		}

		public Criteria andMainGoodsNameBetween(String value1, String value2) {
			addCriterion("main_goods_name between", value1, value2, "mainGoodsName");
			return (Criteria) this;
		}

		public Criteria andMainGoodsNameNotBetween(String value1, String value2) {
			addCriterion("main_goods_name not between", value1, value2, "mainGoodsName");
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

		public Criteria andStoreIdEqualTo(Long value) {
			addCriterion("store_id =", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdNotEqualTo(Long value) {
			addCriterion("store_id <>", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdGreaterThan(Long value) {
			addCriterion("store_id >", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
			addCriterion("store_id >=", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdLessThan(Long value) {
			addCriterion("store_id <", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdLessThanOrEqualTo(Long value) {
			addCriterion("store_id <=", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdIn(List<Long> values) {
			addCriterion("store_id in", values, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdNotIn(List<Long> values) {
			addCriterion("store_id not in", values, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdBetween(Long value1, Long value2) {
			addCriterion("store_id between", value1, value2, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdNotBetween(Long value1, Long value2) {
			addCriterion("store_id not between", value1, value2, "storeId");
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