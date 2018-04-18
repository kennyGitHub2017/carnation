package com.sinco.carnation.shop.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EvaluateExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public EvaluateExample() {
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

		public Criteria andDeleteStatusEqualTo(Integer value) {
			addCriterion("delete_status =", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotEqualTo(Integer value) {
			addCriterion("delete_status <>", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThan(Integer value) {
			addCriterion("delete_status >", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("delete_status >=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThan(Integer value) {
			addCriterion("delete_status <", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusLessThanOrEqualTo(Integer value) {
			addCriterion("delete_status <=", value, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusIn(List<Integer> values) {
			addCriterion("delete_status in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotIn(List<Integer> values) {
			addCriterion("delete_status not in", values, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusBetween(Integer value1, Integer value2) {
			addCriterion("delete_status between", value1, value2, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDeleteStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("delete_status not between", value1, value2, "deleteStatus");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateIsNull() {
			addCriterion("description_evaluate is null");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateIsNotNull() {
			addCriterion("description_evaluate is not null");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateEqualTo(BigDecimal value) {
			addCriterion("description_evaluate =", value, "descriptionEvaluate");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateNotEqualTo(BigDecimal value) {
			addCriterion("description_evaluate <>", value, "descriptionEvaluate");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateGreaterThan(BigDecimal value) {
			addCriterion("description_evaluate >", value, "descriptionEvaluate");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("description_evaluate >=", value, "descriptionEvaluate");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateLessThan(BigDecimal value) {
			addCriterion("description_evaluate <", value, "descriptionEvaluate");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("description_evaluate <=", value, "descriptionEvaluate");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateIn(List<BigDecimal> values) {
			addCriterion("description_evaluate in", values, "descriptionEvaluate");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateNotIn(List<BigDecimal> values) {
			addCriterion("description_evaluate not in", values, "descriptionEvaluate");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("description_evaluate between", value1, value2, "descriptionEvaluate");
			return (Criteria) this;
		}

		public Criteria andDescriptionEvaluateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("description_evaluate not between", value1, value2, "descriptionEvaluate");
			return (Criteria) this;
		}

		public Criteria andEvaluateBuyerValIsNull() {
			addCriterion("evaluate_buyer_val is null");
			return (Criteria) this;
		}

		public Criteria andEvaluateBuyerValIsNotNull() {
			addCriterion("evaluate_buyer_val is not null");
			return (Criteria) this;
		}

		public Criteria andEvaluateBuyerValEqualTo(Integer value) {
			addCriterion("evaluate_buyer_val =", value, "evaluateBuyerVal");
			return (Criteria) this;
		}

		public Criteria andEvaluateBuyerValNotEqualTo(Integer value) {
			addCriterion("evaluate_buyer_val <>", value, "evaluateBuyerVal");
			return (Criteria) this;
		}

		public Criteria andEvaluateBuyerValGreaterThan(Integer value) {
			addCriterion("evaluate_buyer_val >", value, "evaluateBuyerVal");
			return (Criteria) this;
		}

		public Criteria andEvaluateBuyerValGreaterThanOrEqualTo(Integer value) {
			addCriterion("evaluate_buyer_val >=", value, "evaluateBuyerVal");
			return (Criteria) this;
		}

		public Criteria andEvaluateBuyerValLessThan(Integer value) {
			addCriterion("evaluate_buyer_val <", value, "evaluateBuyerVal");
			return (Criteria) this;
		}

		public Criteria andEvaluateBuyerValLessThanOrEqualTo(Integer value) {
			addCriterion("evaluate_buyer_val <=", value, "evaluateBuyerVal");
			return (Criteria) this;
		}

		public Criteria andEvaluateBuyerValIn(List<Integer> values) {
			addCriterion("evaluate_buyer_val in", values, "evaluateBuyerVal");
			return (Criteria) this;
		}

		public Criteria andEvaluateBuyerValNotIn(List<Integer> values) {
			addCriterion("evaluate_buyer_val not in", values, "evaluateBuyerVal");
			return (Criteria) this;
		}

		public Criteria andEvaluateBuyerValBetween(Integer value1, Integer value2) {
			addCriterion("evaluate_buyer_val between", value1, value2, "evaluateBuyerVal");
			return (Criteria) this;
		}

		public Criteria andEvaluateBuyerValNotBetween(Integer value1, Integer value2) {
			addCriterion("evaluate_buyer_val not between", value1, value2, "evaluateBuyerVal");
			return (Criteria) this;
		}

		public Criteria andEvaluatePhotosIsNull() {
			addCriterion("evaluate_photos is null");
			return (Criteria) this;
		}

		public Criteria andEvaluatePhotosIsNotNull() {
			addCriterion("evaluate_photos is not null");
			return (Criteria) this;
		}

		public Criteria andEvaluatePhotosEqualTo(String value) {
			addCriterion("evaluate_photos =", value, "evaluatePhotos");
			return (Criteria) this;
		}

		public Criteria andEvaluatePhotosNotEqualTo(String value) {
			addCriterion("evaluate_photos <>", value, "evaluatePhotos");
			return (Criteria) this;
		}

		public Criteria andEvaluatePhotosGreaterThan(String value) {
			addCriterion("evaluate_photos >", value, "evaluatePhotos");
			return (Criteria) this;
		}

		public Criteria andEvaluatePhotosGreaterThanOrEqualTo(String value) {
			addCriterion("evaluate_photos >=", value, "evaluatePhotos");
			return (Criteria) this;
		}

		public Criteria andEvaluatePhotosLessThan(String value) {
			addCriterion("evaluate_photos <", value, "evaluatePhotos");
			return (Criteria) this;
		}

		public Criteria andEvaluatePhotosLessThanOrEqualTo(String value) {
			addCriterion("evaluate_photos <=", value, "evaluatePhotos");
			return (Criteria) this;
		}

		public Criteria andEvaluatePhotosLike(String value) {
			addCriterion("evaluate_photos like", value, "evaluatePhotos");
			return (Criteria) this;
		}

		public Criteria andEvaluatePhotosNotLike(String value) {
			addCriterion("evaluate_photos not like", value, "evaluatePhotos");
			return (Criteria) this;
		}

		public Criteria andEvaluatePhotosIn(List<String> values) {
			addCriterion("evaluate_photos in", values, "evaluatePhotos");
			return (Criteria) this;
		}

		public Criteria andEvaluatePhotosNotIn(List<String> values) {
			addCriterion("evaluate_photos not in", values, "evaluatePhotos");
			return (Criteria) this;
		}

		public Criteria andEvaluatePhotosBetween(String value1, String value2) {
			addCriterion("evaluate_photos between", value1, value2, "evaluatePhotos");
			return (Criteria) this;
		}

		public Criteria andEvaluatePhotosNotBetween(String value1, String value2) {
			addCriterion("evaluate_photos not between", value1, value2, "evaluatePhotos");
			return (Criteria) this;
		}

		public Criteria andEvaluateStatusIsNull() {
			addCriterion("evaluate_status is null");
			return (Criteria) this;
		}

		public Criteria andEvaluateStatusIsNotNull() {
			addCriterion("evaluate_status is not null");
			return (Criteria) this;
		}

		public Criteria andEvaluateStatusEqualTo(Integer value) {
			addCriterion("evaluate_status =", value, "evaluateStatus");
			return (Criteria) this;
		}

		public Criteria andEvaluateStatusNotEqualTo(Integer value) {
			addCriterion("evaluate_status <>", value, "evaluateStatus");
			return (Criteria) this;
		}

		public Criteria andEvaluateStatusGreaterThan(Integer value) {
			addCriterion("evaluate_status >", value, "evaluateStatus");
			return (Criteria) this;
		}

		public Criteria andEvaluateStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("evaluate_status >=", value, "evaluateStatus");
			return (Criteria) this;
		}

		public Criteria andEvaluateStatusLessThan(Integer value) {
			addCriterion("evaluate_status <", value, "evaluateStatus");
			return (Criteria) this;
		}

		public Criteria andEvaluateStatusLessThanOrEqualTo(Integer value) {
			addCriterion("evaluate_status <=", value, "evaluateStatus");
			return (Criteria) this;
		}

		public Criteria andEvaluateStatusIn(List<Integer> values) {
			addCriterion("evaluate_status in", values, "evaluateStatus");
			return (Criteria) this;
		}

		public Criteria andEvaluateStatusNotIn(List<Integer> values) {
			addCriterion("evaluate_status not in", values, "evaluateStatus");
			return (Criteria) this;
		}

		public Criteria andEvaluateStatusBetween(Integer value1, Integer value2) {
			addCriterion("evaluate_status between", value1, value2, "evaluateStatus");
			return (Criteria) this;
		}

		public Criteria andEvaluateStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("evaluate_status not between", value1, value2, "evaluateStatus");
			return (Criteria) this;
		}

		public Criteria andEvaluateTypeIsNull() {
			addCriterion("evaluate_type is null");
			return (Criteria) this;
		}

		public Criteria andEvaluateTypeIsNotNull() {
			addCriterion("evaluate_type is not null");
			return (Criteria) this;
		}

		public Criteria andEvaluateTypeEqualTo(String value) {
			addCriterion("evaluate_type =", value, "evaluateType");
			return (Criteria) this;
		}

		public Criteria andEvaluateTypeNotEqualTo(String value) {
			addCriterion("evaluate_type <>", value, "evaluateType");
			return (Criteria) this;
		}

		public Criteria andEvaluateTypeGreaterThan(String value) {
			addCriterion("evaluate_type >", value, "evaluateType");
			return (Criteria) this;
		}

		public Criteria andEvaluateTypeGreaterThanOrEqualTo(String value) {
			addCriterion("evaluate_type >=", value, "evaluateType");
			return (Criteria) this;
		}

		public Criteria andEvaluateTypeLessThan(String value) {
			addCriterion("evaluate_type <", value, "evaluateType");
			return (Criteria) this;
		}

		public Criteria andEvaluateTypeLessThanOrEqualTo(String value) {
			addCriterion("evaluate_type <=", value, "evaluateType");
			return (Criteria) this;
		}

		public Criteria andEvaluateTypeLike(String value) {
			addCriterion("evaluate_type like", value, "evaluateType");
			return (Criteria) this;
		}

		public Criteria andEvaluateTypeNotLike(String value) {
			addCriterion("evaluate_type not like", value, "evaluateType");
			return (Criteria) this;
		}

		public Criteria andEvaluateTypeIn(List<String> values) {
			addCriterion("evaluate_type in", values, "evaluateType");
			return (Criteria) this;
		}

		public Criteria andEvaluateTypeNotIn(List<String> values) {
			addCriterion("evaluate_type not in", values, "evaluateType");
			return (Criteria) this;
		}

		public Criteria andEvaluateTypeBetween(String value1, String value2) {
			addCriterion("evaluate_type between", value1, value2, "evaluateType");
			return (Criteria) this;
		}

		public Criteria andEvaluateTypeNotBetween(String value1, String value2) {
			addCriterion("evaluate_type not between", value1, value2, "evaluateType");
			return (Criteria) this;
		}

		public Criteria andGoodsNumIsNull() {
			addCriterion("goods_num is null");
			return (Criteria) this;
		}

		public Criteria andGoodsNumIsNotNull() {
			addCriterion("goods_num is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsNumEqualTo(Integer value) {
			addCriterion("goods_num =", value, "goodsNum");
			return (Criteria) this;
		}

		public Criteria andGoodsNumNotEqualTo(Integer value) {
			addCriterion("goods_num <>", value, "goodsNum");
			return (Criteria) this;
		}

		public Criteria andGoodsNumGreaterThan(Integer value) {
			addCriterion("goods_num >", value, "goodsNum");
			return (Criteria) this;
		}

		public Criteria andGoodsNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("goods_num >=", value, "goodsNum");
			return (Criteria) this;
		}

		public Criteria andGoodsNumLessThan(Integer value) {
			addCriterion("goods_num <", value, "goodsNum");
			return (Criteria) this;
		}

		public Criteria andGoodsNumLessThanOrEqualTo(Integer value) {
			addCriterion("goods_num <=", value, "goodsNum");
			return (Criteria) this;
		}

		public Criteria andGoodsNumIn(List<Integer> values) {
			addCriterion("goods_num in", values, "goodsNum");
			return (Criteria) this;
		}

		public Criteria andGoodsNumNotIn(List<Integer> values) {
			addCriterion("goods_num not in", values, "goodsNum");
			return (Criteria) this;
		}

		public Criteria andGoodsNumBetween(Integer value1, Integer value2) {
			addCriterion("goods_num between", value1, value2, "goodsNum");
			return (Criteria) this;
		}

		public Criteria andGoodsNumNotBetween(Integer value1, Integer value2) {
			addCriterion("goods_num not between", value1, value2, "goodsNum");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceIsNull() {
			addCriterion("goods_price is null");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceIsNotNull() {
			addCriterion("goods_price is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceEqualTo(String value) {
			addCriterion("goods_price =", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceNotEqualTo(String value) {
			addCriterion("goods_price <>", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceGreaterThan(String value) {
			addCriterion("goods_price >", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceGreaterThanOrEqualTo(String value) {
			addCriterion("goods_price >=", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceLessThan(String value) {
			addCriterion("goods_price <", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceLessThanOrEqualTo(String value) {
			addCriterion("goods_price <=", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceLike(String value) {
			addCriterion("goods_price like", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceNotLike(String value) {
			addCriterion("goods_price not like", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceIn(List<String> values) {
			addCriterion("goods_price in", values, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceNotIn(List<String> values) {
			addCriterion("goods_price not in", values, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceBetween(String value1, String value2) {
			addCriterion("goods_price between", value1, value2, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceNotBetween(String value1, String value2) {
			addCriterion("goods_price not between", value1, value2, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andServiceEvaluateIsNull() {
			addCriterion("service_evaluate is null");
			return (Criteria) this;
		}

		public Criteria andServiceEvaluateIsNotNull() {
			addCriterion("service_evaluate is not null");
			return (Criteria) this;
		}

		public Criteria andServiceEvaluateEqualTo(BigDecimal value) {
			addCriterion("service_evaluate =", value, "serviceEvaluate");
			return (Criteria) this;
		}

		public Criteria andServiceEvaluateNotEqualTo(BigDecimal value) {
			addCriterion("service_evaluate <>", value, "serviceEvaluate");
			return (Criteria) this;
		}

		public Criteria andServiceEvaluateGreaterThan(BigDecimal value) {
			addCriterion("service_evaluate >", value, "serviceEvaluate");
			return (Criteria) this;
		}

		public Criteria andServiceEvaluateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("service_evaluate >=", value, "serviceEvaluate");
			return (Criteria) this;
		}

		public Criteria andServiceEvaluateLessThan(BigDecimal value) {
			addCriterion("service_evaluate <", value, "serviceEvaluate");
			return (Criteria) this;
		}

		public Criteria andServiceEvaluateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("service_evaluate <=", value, "serviceEvaluate");
			return (Criteria) this;
		}

		public Criteria andServiceEvaluateIn(List<BigDecimal> values) {
			addCriterion("service_evaluate in", values, "serviceEvaluate");
			return (Criteria) this;
		}

		public Criteria andServiceEvaluateNotIn(List<BigDecimal> values) {
			addCriterion("service_evaluate not in", values, "serviceEvaluate");
			return (Criteria) this;
		}

		public Criteria andServiceEvaluateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("service_evaluate between", value1, value2, "serviceEvaluate");
			return (Criteria) this;
		}

		public Criteria andServiceEvaluateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("service_evaluate not between", value1, value2, "serviceEvaluate");
			return (Criteria) this;
		}

		public Criteria andShipEvaluateIsNull() {
			addCriterion("ship_evaluate is null");
			return (Criteria) this;
		}

		public Criteria andShipEvaluateIsNotNull() {
			addCriterion("ship_evaluate is not null");
			return (Criteria) this;
		}

		public Criteria andShipEvaluateEqualTo(BigDecimal value) {
			addCriterion("ship_evaluate =", value, "shipEvaluate");
			return (Criteria) this;
		}

		public Criteria andShipEvaluateNotEqualTo(BigDecimal value) {
			addCriterion("ship_evaluate <>", value, "shipEvaluate");
			return (Criteria) this;
		}

		public Criteria andShipEvaluateGreaterThan(BigDecimal value) {
			addCriterion("ship_evaluate >", value, "shipEvaluate");
			return (Criteria) this;
		}

		public Criteria andShipEvaluateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("ship_evaluate >=", value, "shipEvaluate");
			return (Criteria) this;
		}

		public Criteria andShipEvaluateLessThan(BigDecimal value) {
			addCriterion("ship_evaluate <", value, "shipEvaluate");
			return (Criteria) this;
		}

		public Criteria andShipEvaluateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("ship_evaluate <=", value, "shipEvaluate");
			return (Criteria) this;
		}

		public Criteria andShipEvaluateIn(List<BigDecimal> values) {
			addCriterion("ship_evaluate in", values, "shipEvaluate");
			return (Criteria) this;
		}

		public Criteria andShipEvaluateNotIn(List<BigDecimal> values) {
			addCriterion("ship_evaluate not in", values, "shipEvaluate");
			return (Criteria) this;
		}

		public Criteria andShipEvaluateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ship_evaluate between", value1, value2, "shipEvaluate");
			return (Criteria) this;
		}

		public Criteria andShipEvaluateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ship_evaluate not between", value1, value2, "shipEvaluate");
			return (Criteria) this;
		}

		public Criteria andEvaluateGoodsIdIsNull() {
			addCriterion("evaluate_goods_id is null");
			return (Criteria) this;
		}

		public Criteria andEvaluateGoodsIdIsNotNull() {
			addCriterion("evaluate_goods_id is not null");
			return (Criteria) this;
		}

		public Criteria andEvaluateGoodsIdEqualTo(Long value) {
			addCriterion("evaluate_goods_id =", value, "evaluateGoodsId");
			return (Criteria) this;
		}

		public Criteria andEvaluateGoodsIdNotEqualTo(Long value) {
			addCriterion("evaluate_goods_id <>", value, "evaluateGoodsId");
			return (Criteria) this;
		}

		public Criteria andEvaluateGoodsIdGreaterThan(Long value) {
			addCriterion("evaluate_goods_id >", value, "evaluateGoodsId");
			return (Criteria) this;
		}

		public Criteria andEvaluateGoodsIdGreaterThanOrEqualTo(Long value) {
			addCriterion("evaluate_goods_id >=", value, "evaluateGoodsId");
			return (Criteria) this;
		}

		public Criteria andEvaluateGoodsIdLessThan(Long value) {
			addCriterion("evaluate_goods_id <", value, "evaluateGoodsId");
			return (Criteria) this;
		}

		public Criteria andEvaluateGoodsIdLessThanOrEqualTo(Long value) {
			addCriterion("evaluate_goods_id <=", value, "evaluateGoodsId");
			return (Criteria) this;
		}

		public Criteria andEvaluateGoodsIdIn(List<Long> values) {
			addCriterion("evaluate_goods_id in", values, "evaluateGoodsId");
			return (Criteria) this;
		}

		public Criteria andEvaluateGoodsIdNotIn(List<Long> values) {
			addCriterion("evaluate_goods_id not in", values, "evaluateGoodsId");
			return (Criteria) this;
		}

		public Criteria andEvaluateGoodsIdBetween(Long value1, Long value2) {
			addCriterion("evaluate_goods_id between", value1, value2, "evaluateGoodsId");
			return (Criteria) this;
		}

		public Criteria andEvaluateGoodsIdNotBetween(Long value1, Long value2) {
			addCriterion("evaluate_goods_id not between", value1, value2, "evaluateGoodsId");
			return (Criteria) this;
		}

		public Criteria andEvaluateUserIdIsNull() {
			addCriterion("evaluate_user_id is null");
			return (Criteria) this;
		}

		public Criteria andEvaluateUserIdIsNotNull() {
			addCriterion("evaluate_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andEvaluateUserIdEqualTo(Long value) {
			addCriterion("evaluate_user_id =", value, "evaluateUserId");
			return (Criteria) this;
		}

		public Criteria andEvaluateUserIdNotEqualTo(Long value) {
			addCriterion("evaluate_user_id <>", value, "evaluateUserId");
			return (Criteria) this;
		}

		public Criteria andEvaluateUserIdGreaterThan(Long value) {
			addCriterion("evaluate_user_id >", value, "evaluateUserId");
			return (Criteria) this;
		}

		public Criteria andEvaluateUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("evaluate_user_id >=", value, "evaluateUserId");
			return (Criteria) this;
		}

		public Criteria andEvaluateUserIdLessThan(Long value) {
			addCriterion("evaluate_user_id <", value, "evaluateUserId");
			return (Criteria) this;
		}

		public Criteria andEvaluateUserIdLessThanOrEqualTo(Long value) {
			addCriterion("evaluate_user_id <=", value, "evaluateUserId");
			return (Criteria) this;
		}

		public Criteria andEvaluateUserIdIn(List<Long> values) {
			addCriterion("evaluate_user_id in", values, "evaluateUserId");
			return (Criteria) this;
		}

		public Criteria andEvaluateUserIdNotIn(List<Long> values) {
			addCriterion("evaluate_user_id not in", values, "evaluateUserId");
			return (Criteria) this;
		}

		public Criteria andEvaluateUserIdBetween(Long value1, Long value2) {
			addCriterion("evaluate_user_id between", value1, value2, "evaluateUserId");
			return (Criteria) this;
		}

		public Criteria andEvaluateUserIdNotBetween(Long value1, Long value2) {
			addCriterion("evaluate_user_id not between", value1, value2, "evaluateUserId");
			return (Criteria) this;
		}

		public Criteria andOfIdIsNull() {
			addCriterion("of_id is null");
			return (Criteria) this;
		}

		public Criteria andOfIdIsNotNull() {
			addCriterion("of_id is not null");
			return (Criteria) this;
		}

		public Criteria andOfIdEqualTo(Long value) {
			addCriterion("of_id =", value, "ofId");
			return (Criteria) this;
		}

		public Criteria andOfIdNotEqualTo(Long value) {
			addCriterion("of_id <>", value, "ofId");
			return (Criteria) this;
		}

		public Criteria andOfIdGreaterThan(Long value) {
			addCriterion("of_id >", value, "ofId");
			return (Criteria) this;
		}

		public Criteria andOfIdGreaterThanOrEqualTo(Long value) {
			addCriterion("of_id >=", value, "ofId");
			return (Criteria) this;
		}

		public Criteria andOfIdLessThan(Long value) {
			addCriterion("of_id <", value, "ofId");
			return (Criteria) this;
		}

		public Criteria andOfIdLessThanOrEqualTo(Long value) {
			addCriterion("of_id <=", value, "ofId");
			return (Criteria) this;
		}

		public Criteria andOfIdIn(List<Long> values) {
			addCriterion("of_id in", values, "ofId");
			return (Criteria) this;
		}

		public Criteria andOfIdNotIn(List<Long> values) {
			addCriterion("of_id not in", values, "ofId");
			return (Criteria) this;
		}

		public Criteria andOfIdBetween(Long value1, Long value2) {
			addCriterion("of_id between", value1, value2, "ofId");
			return (Criteria) this;
		}

		public Criteria andOfIdNotBetween(Long value1, Long value2) {
			addCriterion("of_id not between", value1, value2, "ofId");
			return (Criteria) this;
		}

		public Criteria andReplyStatusIsNull() {
			addCriterion("reply_status is null");
			return (Criteria) this;
		}

		public Criteria andReplyStatusIsNotNull() {
			addCriterion("reply_status is not null");
			return (Criteria) this;
		}

		public Criteria andReplyStatusEqualTo(Integer value) {
			addCriterion("reply_status =", value, "replyStatus");
			return (Criteria) this;
		}

		public Criteria andReplyStatusNotEqualTo(Integer value) {
			addCriterion("reply_status <>", value, "replyStatus");
			return (Criteria) this;
		}

		public Criteria andReplyStatusGreaterThan(Integer value) {
			addCriterion("reply_status >", value, "replyStatus");
			return (Criteria) this;
		}

		public Criteria andReplyStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("reply_status >=", value, "replyStatus");
			return (Criteria) this;
		}

		public Criteria andReplyStatusLessThan(Integer value) {
			addCriterion("reply_status <", value, "replyStatus");
			return (Criteria) this;
		}

		public Criteria andReplyStatusLessThanOrEqualTo(Integer value) {
			addCriterion("reply_status <=", value, "replyStatus");
			return (Criteria) this;
		}

		public Criteria andReplyStatusIn(List<Integer> values) {
			addCriterion("reply_status in", values, "replyStatus");
			return (Criteria) this;
		}

		public Criteria andReplyStatusNotIn(List<Integer> values) {
			addCriterion("reply_status not in", values, "replyStatus");
			return (Criteria) this;
		}

		public Criteria andReplyStatusBetween(Integer value1, Integer value2) {
			addCriterion("reply_status between", value1, value2, "replyStatus");
			return (Criteria) this;
		}

		public Criteria andReplyStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("reply_status not between", value1, value2, "replyStatus");
			return (Criteria) this;
		}

		public Criteria andAddevaStatusIsNull() {
			addCriterion("addeva_status is null");
			return (Criteria) this;
		}

		public Criteria andAddevaStatusIsNotNull() {
			addCriterion("addeva_status is not null");
			return (Criteria) this;
		}

		public Criteria andAddevaStatusEqualTo(Integer value) {
			addCriterion("addeva_status =", value, "addevaStatus");
			return (Criteria) this;
		}

		public Criteria andAddevaStatusNotEqualTo(Integer value) {
			addCriterion("addeva_status <>", value, "addevaStatus");
			return (Criteria) this;
		}

		public Criteria andAddevaStatusGreaterThan(Integer value) {
			addCriterion("addeva_status >", value, "addevaStatus");
			return (Criteria) this;
		}

		public Criteria andAddevaStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("addeva_status >=", value, "addevaStatus");
			return (Criteria) this;
		}

		public Criteria andAddevaStatusLessThan(Integer value) {
			addCriterion("addeva_status <", value, "addevaStatus");
			return (Criteria) this;
		}

		public Criteria andAddevaStatusLessThanOrEqualTo(Integer value) {
			addCriterion("addeva_status <=", value, "addevaStatus");
			return (Criteria) this;
		}

		public Criteria andAddevaStatusIn(List<Integer> values) {
			addCriterion("addeva_status in", values, "addevaStatus");
			return (Criteria) this;
		}

		public Criteria andAddevaStatusNotIn(List<Integer> values) {
			addCriterion("addeva_status not in", values, "addevaStatus");
			return (Criteria) this;
		}

		public Criteria andAddevaStatusBetween(Integer value1, Integer value2) {
			addCriterion("addeva_status between", value1, value2, "addevaStatus");
			return (Criteria) this;
		}

		public Criteria andAddevaStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("addeva_status not between", value1, value2, "addevaStatus");
			return (Criteria) this;
		}

		public Criteria andAddevaTimeIsNull() {
			addCriterion("addeva_time is null");
			return (Criteria) this;
		}

		public Criteria andAddevaTimeIsNotNull() {
			addCriterion("addeva_time is not null");
			return (Criteria) this;
		}

		public Criteria andAddevaTimeEqualTo(Date value) {
			addCriterion("addeva_time =", value, "addevaTime");
			return (Criteria) this;
		}

		public Criteria andAddevaTimeNotEqualTo(Date value) {
			addCriterion("addeva_time <>", value, "addevaTime");
			return (Criteria) this;
		}

		public Criteria andAddevaTimeGreaterThan(Date value) {
			addCriterion("addeva_time >", value, "addevaTime");
			return (Criteria) this;
		}

		public Criteria andAddevaTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("addeva_time >=", value, "addevaTime");
			return (Criteria) this;
		}

		public Criteria andAddevaTimeLessThan(Date value) {
			addCriterion("addeva_time <", value, "addevaTime");
			return (Criteria) this;
		}

		public Criteria andAddevaTimeLessThanOrEqualTo(Date value) {
			addCriterion("addeva_time <=", value, "addevaTime");
			return (Criteria) this;
		}

		public Criteria andAddevaTimeIn(List<Date> values) {
			addCriterion("addeva_time in", values, "addevaTime");
			return (Criteria) this;
		}

		public Criteria andAddevaTimeNotIn(List<Date> values) {
			addCriterion("addeva_time not in", values, "addevaTime");
			return (Criteria) this;
		}

		public Criteria andAddevaTimeBetween(Date value1, Date value2) {
			addCriterion("addeva_time between", value1, value2, "addevaTime");
			return (Criteria) this;
		}

		public Criteria andAddevaTimeNotBetween(Date value1, Date value2) {
			addCriterion("addeva_time not between", value1, value2, "addevaTime");
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