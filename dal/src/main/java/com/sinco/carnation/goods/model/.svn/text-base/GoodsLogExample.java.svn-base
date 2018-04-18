package com.sinco.carnation.goods.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsLogExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public GoodsLogExample() {
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

		public Criteria andAddtimeIsNull() {
			addCriterion("addTime is null");
			return (Criteria) this;
		}

		public Criteria andAddtimeIsNotNull() {
			addCriterion("addTime is not null");
			return (Criteria) this;
		}

		public Criteria andAddtimeEqualTo(Date value) {
			addCriterion("addTime =", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeNotEqualTo(Date value) {
			addCriterion("addTime <>", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeGreaterThan(Date value) {
			addCriterion("addTime >", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeGreaterThanOrEqualTo(Date value) {
			addCriterion("addTime >=", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeLessThan(Date value) {
			addCriterion("addTime <", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeLessThanOrEqualTo(Date value) {
			addCriterion("addTime <=", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeIn(List<Date> values) {
			addCriterion("addTime in", values, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeNotIn(List<Date> values) {
			addCriterion("addTime not in", values, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeBetween(Date value1, Date value2) {
			addCriterion("addTime between", value1, value2, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeNotBetween(Date value1, Date value2) {
			addCriterion("addTime not between", value1, value2, "addtime");
			return (Criteria) this;
		}

		public Criteria andDeletestatusIsNull() {
			addCriterion("deleteStatus is null");
			return (Criteria) this;
		}

		public Criteria andDeletestatusIsNotNull() {
			addCriterion("deleteStatus is not null");
			return (Criteria) this;
		}

		public Criteria andDeletestatusEqualTo(Integer value) {
			addCriterion("deleteStatus =", value, "deletestatus");
			return (Criteria) this;
		}

		public Criteria andDeletestatusNotEqualTo(Integer value) {
			addCriterion("deleteStatus <>", value, "deletestatus");
			return (Criteria) this;
		}

		public Criteria andDeletestatusGreaterThan(Integer value) {
			addCriterion("deleteStatus >", value, "deletestatus");
			return (Criteria) this;
		}

		public Criteria andDeletestatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("deleteStatus >=", value, "deletestatus");
			return (Criteria) this;
		}

		public Criteria andDeletestatusLessThan(Integer value) {
			addCriterion("deleteStatus <", value, "deletestatus");
			return (Criteria) this;
		}

		public Criteria andDeletestatusLessThanOrEqualTo(Integer value) {
			addCriterion("deleteStatus <=", value, "deletestatus");
			return (Criteria) this;
		}

		public Criteria andDeletestatusIn(List<Integer> values) {
			addCriterion("deleteStatus in", values, "deletestatus");
			return (Criteria) this;
		}

		public Criteria andDeletestatusNotIn(List<Integer> values) {
			addCriterion("deleteStatus not in", values, "deletestatus");
			return (Criteria) this;
		}

		public Criteria andDeletestatusBetween(Integer value1, Integer value2) {
			addCriterion("deleteStatus between", value1, value2, "deletestatus");
			return (Criteria) this;
		}

		public Criteria andDeletestatusNotBetween(Integer value1, Integer value2) {
			addCriterion("deleteStatus not between", value1, value2, "deletestatus");
			return (Criteria) this;
		}

		public Criteria andGcIdIsNull() {
			addCriterion("gc_id is null");
			return (Criteria) this;
		}

		public Criteria andGcIdIsNotNull() {
			addCriterion("gc_id is not null");
			return (Criteria) this;
		}

		public Criteria andGcIdEqualTo(Long value) {
			addCriterion("gc_id =", value, "gcId");
			return (Criteria) this;
		}

		public Criteria andGcIdNotEqualTo(Long value) {
			addCriterion("gc_id <>", value, "gcId");
			return (Criteria) this;
		}

		public Criteria andGcIdGreaterThan(Long value) {
			addCriterion("gc_id >", value, "gcId");
			return (Criteria) this;
		}

		public Criteria andGcIdGreaterThanOrEqualTo(Long value) {
			addCriterion("gc_id >=", value, "gcId");
			return (Criteria) this;
		}

		public Criteria andGcIdLessThan(Long value) {
			addCriterion("gc_id <", value, "gcId");
			return (Criteria) this;
		}

		public Criteria andGcIdLessThanOrEqualTo(Long value) {
			addCriterion("gc_id <=", value, "gcId");
			return (Criteria) this;
		}

		public Criteria andGcIdIn(List<Long> values) {
			addCriterion("gc_id in", values, "gcId");
			return (Criteria) this;
		}

		public Criteria andGcIdNotIn(List<Long> values) {
			addCriterion("gc_id not in", values, "gcId");
			return (Criteria) this;
		}

		public Criteria andGcIdBetween(Long value1, Long value2) {
			addCriterion("gc_id between", value1, value2, "gcId");
			return (Criteria) this;
		}

		public Criteria andGcIdNotBetween(Long value1, Long value2) {
			addCriterion("gc_id not between", value1, value2, "gcId");
			return (Criteria) this;
		}

		public Criteria andGoodsBrandIdIsNull() {
			addCriterion("goods_brand_id is null");
			return (Criteria) this;
		}

		public Criteria andGoodsBrandIdIsNotNull() {
			addCriterion("goods_brand_id is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsBrandIdEqualTo(Long value) {
			addCriterion("goods_brand_id =", value, "goodsBrandId");
			return (Criteria) this;
		}

		public Criteria andGoodsBrandIdNotEqualTo(Long value) {
			addCriterion("goods_brand_id <>", value, "goodsBrandId");
			return (Criteria) this;
		}

		public Criteria andGoodsBrandIdGreaterThan(Long value) {
			addCriterion("goods_brand_id >", value, "goodsBrandId");
			return (Criteria) this;
		}

		public Criteria andGoodsBrandIdGreaterThanOrEqualTo(Long value) {
			addCriterion("goods_brand_id >=", value, "goodsBrandId");
			return (Criteria) this;
		}

		public Criteria andGoodsBrandIdLessThan(Long value) {
			addCriterion("goods_brand_id <", value, "goodsBrandId");
			return (Criteria) this;
		}

		public Criteria andGoodsBrandIdLessThanOrEqualTo(Long value) {
			addCriterion("goods_brand_id <=", value, "goodsBrandId");
			return (Criteria) this;
		}

		public Criteria andGoodsBrandIdIn(List<Long> values) {
			addCriterion("goods_brand_id in", values, "goodsBrandId");
			return (Criteria) this;
		}

		public Criteria andGoodsBrandIdNotIn(List<Long> values) {
			addCriterion("goods_brand_id not in", values, "goodsBrandId");
			return (Criteria) this;
		}

		public Criteria andGoodsBrandIdBetween(Long value1, Long value2) {
			addCriterion("goods_brand_id between", value1, value2, "goodsBrandId");
			return (Criteria) this;
		}

		public Criteria andGoodsBrandIdNotBetween(Long value1, Long value2) {
			addCriterion("goods_brand_id not between", value1, value2, "goodsBrandId");
			return (Criteria) this;
		}

		public Criteria andGoodsClickIsNull() {
			addCriterion("goods_click is null");
			return (Criteria) this;
		}

		public Criteria andGoodsClickIsNotNull() {
			addCriterion("goods_click is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsClickEqualTo(Integer value) {
			addCriterion("goods_click =", value, "goodsClick");
			return (Criteria) this;
		}

		public Criteria andGoodsClickNotEqualTo(Integer value) {
			addCriterion("goods_click <>", value, "goodsClick");
			return (Criteria) this;
		}

		public Criteria andGoodsClickGreaterThan(Integer value) {
			addCriterion("goods_click >", value, "goodsClick");
			return (Criteria) this;
		}

		public Criteria andGoodsClickGreaterThanOrEqualTo(Integer value) {
			addCriterion("goods_click >=", value, "goodsClick");
			return (Criteria) this;
		}

		public Criteria andGoodsClickLessThan(Integer value) {
			addCriterion("goods_click <", value, "goodsClick");
			return (Criteria) this;
		}

		public Criteria andGoodsClickLessThanOrEqualTo(Integer value) {
			addCriterion("goods_click <=", value, "goodsClick");
			return (Criteria) this;
		}

		public Criteria andGoodsClickIn(List<Integer> values) {
			addCriterion("goods_click in", values, "goodsClick");
			return (Criteria) this;
		}

		public Criteria andGoodsClickNotIn(List<Integer> values) {
			addCriterion("goods_click not in", values, "goodsClick");
			return (Criteria) this;
		}

		public Criteria andGoodsClickBetween(Integer value1, Integer value2) {
			addCriterion("goods_click between", value1, value2, "goodsClick");
			return (Criteria) this;
		}

		public Criteria andGoodsClickNotBetween(Integer value1, Integer value2) {
			addCriterion("goods_click not between", value1, value2, "goodsClick");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectIsNull() {
			addCriterion("goods_collect is null");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectIsNotNull() {
			addCriterion("goods_collect is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectEqualTo(Integer value) {
			addCriterion("goods_collect =", value, "goodsCollect");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectNotEqualTo(Integer value) {
			addCriterion("goods_collect <>", value, "goodsCollect");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectGreaterThan(Integer value) {
			addCriterion("goods_collect >", value, "goodsCollect");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectGreaterThanOrEqualTo(Integer value) {
			addCriterion("goods_collect >=", value, "goodsCollect");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectLessThan(Integer value) {
			addCriterion("goods_collect <", value, "goodsCollect");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectLessThanOrEqualTo(Integer value) {
			addCriterion("goods_collect <=", value, "goodsCollect");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectIn(List<Integer> values) {
			addCriterion("goods_collect in", values, "goodsCollect");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectNotIn(List<Integer> values) {
			addCriterion("goods_collect not in", values, "goodsCollect");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectBetween(Integer value1, Integer value2) {
			addCriterion("goods_collect between", value1, value2, "goodsCollect");
			return (Criteria) this;
		}

		public Criteria andGoodsCollectNotBetween(Integer value1, Integer value2) {
			addCriterion("goods_collect not between", value1, value2, "goodsCollect");
			return (Criteria) this;
		}

		public Criteria andGoodsIdIsNull() {
			addCriterion("goods_id is null");
			return (Criteria) this;
		}

		public Criteria andGoodsIdIsNotNull() {
			addCriterion("goods_id is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsIdEqualTo(Long value) {
			addCriterion("goods_id =", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdNotEqualTo(Long value) {
			addCriterion("goods_id <>", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdGreaterThan(Long value) {
			addCriterion("goods_id >", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
			addCriterion("goods_id >=", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdLessThan(Long value) {
			addCriterion("goods_id <", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
			addCriterion("goods_id <=", value, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdIn(List<Long> values) {
			addCriterion("goods_id in", values, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdNotIn(List<Long> values) {
			addCriterion("goods_id not in", values, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdBetween(Long value1, Long value2) {
			addCriterion("goods_id between", value1, value2, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
			addCriterion("goods_id not between", value1, value2, "goodsId");
			return (Criteria) this;
		}

		public Criteria andGoodsNameIsNull() {
			addCriterion("goods_name is null");
			return (Criteria) this;
		}

		public Criteria andGoodsNameIsNotNull() {
			addCriterion("goods_name is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsNameEqualTo(String value) {
			addCriterion("goods_name =", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameNotEqualTo(String value) {
			addCriterion("goods_name <>", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameGreaterThan(String value) {
			addCriterion("goods_name >", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
			addCriterion("goods_name >=", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameLessThan(String value) {
			addCriterion("goods_name <", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameLessThanOrEqualTo(String value) {
			addCriterion("goods_name <=", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameLike(String value) {
			addCriterion("goods_name like", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameNotLike(String value) {
			addCriterion("goods_name not like", value, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameIn(List<String> values) {
			addCriterion("goods_name in", values, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameNotIn(List<String> values) {
			addCriterion("goods_name not in", values, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameBetween(String value1, String value2) {
			addCriterion("goods_name between", value1, value2, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsNameNotBetween(String value1, String value2) {
			addCriterion("goods_name not between", value1, value2, "goodsName");
			return (Criteria) this;
		}

		public Criteria andGoodsSalenumIsNull() {
			addCriterion("goods_salenum is null");
			return (Criteria) this;
		}

		public Criteria andGoodsSalenumIsNotNull() {
			addCriterion("goods_salenum is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsSalenumEqualTo(Integer value) {
			addCriterion("goods_salenum =", value, "goodsSalenum");
			return (Criteria) this;
		}

		public Criteria andGoodsSalenumNotEqualTo(Integer value) {
			addCriterion("goods_salenum <>", value, "goodsSalenum");
			return (Criteria) this;
		}

		public Criteria andGoodsSalenumGreaterThan(Integer value) {
			addCriterion("goods_salenum >", value, "goodsSalenum");
			return (Criteria) this;
		}

		public Criteria andGoodsSalenumGreaterThanOrEqualTo(Integer value) {
			addCriterion("goods_salenum >=", value, "goodsSalenum");
			return (Criteria) this;
		}

		public Criteria andGoodsSalenumLessThan(Integer value) {
			addCriterion("goods_salenum <", value, "goodsSalenum");
			return (Criteria) this;
		}

		public Criteria andGoodsSalenumLessThanOrEqualTo(Integer value) {
			addCriterion("goods_salenum <=", value, "goodsSalenum");
			return (Criteria) this;
		}

		public Criteria andGoodsSalenumIn(List<Integer> values) {
			addCriterion("goods_salenum in", values, "goodsSalenum");
			return (Criteria) this;
		}

		public Criteria andGoodsSalenumNotIn(List<Integer> values) {
			addCriterion("goods_salenum not in", values, "goodsSalenum");
			return (Criteria) this;
		}

		public Criteria andGoodsSalenumBetween(Integer value1, Integer value2) {
			addCriterion("goods_salenum between", value1, value2, "goodsSalenum");
			return (Criteria) this;
		}

		public Criteria andGoodsSalenumNotBetween(Integer value1, Integer value2) {
			addCriterion("goods_salenum not between", value1, value2, "goodsSalenum");
			return (Criteria) this;
		}

		public Criteria andImgIdIsNull() {
			addCriterion("img_id is null");
			return (Criteria) this;
		}

		public Criteria andImgIdIsNotNull() {
			addCriterion("img_id is not null");
			return (Criteria) this;
		}

		public Criteria andImgIdEqualTo(Long value) {
			addCriterion("img_id =", value, "imgId");
			return (Criteria) this;
		}

		public Criteria andImgIdNotEqualTo(Long value) {
			addCriterion("img_id <>", value, "imgId");
			return (Criteria) this;
		}

		public Criteria andImgIdGreaterThan(Long value) {
			addCriterion("img_id >", value, "imgId");
			return (Criteria) this;
		}

		public Criteria andImgIdGreaterThanOrEqualTo(Long value) {
			addCriterion("img_id >=", value, "imgId");
			return (Criteria) this;
		}

		public Criteria andImgIdLessThan(Long value) {
			addCriterion("img_id <", value, "imgId");
			return (Criteria) this;
		}

		public Criteria andImgIdLessThanOrEqualTo(Long value) {
			addCriterion("img_id <=", value, "imgId");
			return (Criteria) this;
		}

		public Criteria andImgIdIn(List<Long> values) {
			addCriterion("img_id in", values, "imgId");
			return (Criteria) this;
		}

		public Criteria andImgIdNotIn(List<Long> values) {
			addCriterion("img_id not in", values, "imgId");
			return (Criteria) this;
		}

		public Criteria andImgIdBetween(Long value1, Long value2) {
			addCriterion("img_id between", value1, value2, "imgId");
			return (Criteria) this;
		}

		public Criteria andImgIdNotBetween(Long value1, Long value2) {
			addCriterion("img_id not between", value1, value2, "imgId");
			return (Criteria) this;
		}

		public Criteria andLogFormIsNull() {
			addCriterion("log_form is null");
			return (Criteria) this;
		}

		public Criteria andLogFormIsNotNull() {
			addCriterion("log_form is not null");
			return (Criteria) this;
		}

		public Criteria andLogFormEqualTo(Integer value) {
			addCriterion("log_form =", value, "logForm");
			return (Criteria) this;
		}

		public Criteria andLogFormNotEqualTo(Integer value) {
			addCriterion("log_form <>", value, "logForm");
			return (Criteria) this;
		}

		public Criteria andLogFormGreaterThan(Integer value) {
			addCriterion("log_form >", value, "logForm");
			return (Criteria) this;
		}

		public Criteria andLogFormGreaterThanOrEqualTo(Integer value) {
			addCriterion("log_form >=", value, "logForm");
			return (Criteria) this;
		}

		public Criteria andLogFormLessThan(Integer value) {
			addCriterion("log_form <", value, "logForm");
			return (Criteria) this;
		}

		public Criteria andLogFormLessThanOrEqualTo(Integer value) {
			addCriterion("log_form <=", value, "logForm");
			return (Criteria) this;
		}

		public Criteria andLogFormIn(List<Integer> values) {
			addCriterion("log_form in", values, "logForm");
			return (Criteria) this;
		}

		public Criteria andLogFormNotIn(List<Integer> values) {
			addCriterion("log_form not in", values, "logForm");
			return (Criteria) this;
		}

		public Criteria andLogFormBetween(Integer value1, Integer value2) {
			addCriterion("log_form between", value1, value2, "logForm");
			return (Criteria) this;
		}

		public Criteria andLogFormNotBetween(Integer value1, Integer value2) {
			addCriterion("log_form not between", value1, value2, "logForm");
			return (Criteria) this;
		}

		public Criteria andPreferentialIsNull() {
			addCriterion("preferential is null");
			return (Criteria) this;
		}

		public Criteria andPreferentialIsNotNull() {
			addCriterion("preferential is not null");
			return (Criteria) this;
		}

		public Criteria andPreferentialEqualTo(String value) {
			addCriterion("preferential =", value, "preferential");
			return (Criteria) this;
		}

		public Criteria andPreferentialNotEqualTo(String value) {
			addCriterion("preferential <>", value, "preferential");
			return (Criteria) this;
		}

		public Criteria andPreferentialGreaterThan(String value) {
			addCriterion("preferential >", value, "preferential");
			return (Criteria) this;
		}

		public Criteria andPreferentialGreaterThanOrEqualTo(String value) {
			addCriterion("preferential >=", value, "preferential");
			return (Criteria) this;
		}

		public Criteria andPreferentialLessThan(String value) {
			addCriterion("preferential <", value, "preferential");
			return (Criteria) this;
		}

		public Criteria andPreferentialLessThanOrEqualTo(String value) {
			addCriterion("preferential <=", value, "preferential");
			return (Criteria) this;
		}

		public Criteria andPreferentialLike(String value) {
			addCriterion("preferential like", value, "preferential");
			return (Criteria) this;
		}

		public Criteria andPreferentialNotLike(String value) {
			addCriterion("preferential not like", value, "preferential");
			return (Criteria) this;
		}

		public Criteria andPreferentialIn(List<String> values) {
			addCriterion("preferential in", values, "preferential");
			return (Criteria) this;
		}

		public Criteria andPreferentialNotIn(List<String> values) {
			addCriterion("preferential not in", values, "preferential");
			return (Criteria) this;
		}

		public Criteria andPreferentialBetween(String value1, String value2) {
			addCriterion("preferential between", value1, value2, "preferential");
			return (Criteria) this;
		}

		public Criteria andPreferentialNotBetween(String value1, String value2) {
			addCriterion("preferential not between", value1, value2, "preferential");
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

		public Criteria andPriceEqualTo(BigDecimal value) {
			addCriterion("price =", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotEqualTo(BigDecimal value) {
			addCriterion("price <>", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceGreaterThan(BigDecimal value) {
			addCriterion("price >", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("price >=", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceLessThan(BigDecimal value) {
			addCriterion("price <", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("price <=", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceIn(List<BigDecimal> values) {
			addCriterion("price in", values, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotIn(List<BigDecimal> values) {
			addCriterion("price not in", values, "price");
			return (Criteria) this;
		}

		public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("price between", value1, value2, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("price not between", value1, value2, "price");
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