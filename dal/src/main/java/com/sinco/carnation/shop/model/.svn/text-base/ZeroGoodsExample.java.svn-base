package com.sinco.carnation.shop.model;

import com.sinco.carnation.shop.bo.ZeroGoodsBO;
import com.sinco.mybatis.dal.core.AbstractExample;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZeroGoodsExample extends AbstractExample<ZeroGoodsBO> {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected String limit;

	public ZeroGoodsExample() {
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

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public void setLimit(int count) {
		this.limit = String.valueOf(count);
	}

	public void setLimit(int offset, int rows) {
		this.limit = new StringBuilder().append(String.valueOf(offset)).append(",")
				.append(String.valueOf(rows)).toString();
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

		public Criteria andGoodsPriceIsNull() {
			addCriterion("goods_price is null");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceIsNotNull() {
			addCriterion("goods_price is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceEqualTo(BigDecimal value) {
			addCriterion("goods_price =", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceNotEqualTo(BigDecimal value) {
			addCriterion("goods_price <>", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceGreaterThan(BigDecimal value) {
			addCriterion("goods_price >", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("goods_price >=", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceLessThan(BigDecimal value) {
			addCriterion("goods_price <", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("goods_price <=", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceIn(List<BigDecimal> values) {
			addCriterion("goods_price in", values, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceNotIn(List<BigDecimal> values) {
			addCriterion("goods_price not in", values, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("goods_price between", value1, value2, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("goods_price not between", value1, value2, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andShipFeeIsNull() {
			addCriterion("ship_fee is null");
			return (Criteria) this;
		}

		public Criteria andShipFeeIsNotNull() {
			addCriterion("ship_fee is not null");
			return (Criteria) this;
		}

		public Criteria andShipFeeEqualTo(BigDecimal value) {
			addCriterion("ship_fee =", value, "shipFee");
			return (Criteria) this;
		}

		public Criteria andShipFeeNotEqualTo(BigDecimal value) {
			addCriterion("ship_fee <>", value, "shipFee");
			return (Criteria) this;
		}

		public Criteria andShipFeeGreaterThan(BigDecimal value) {
			addCriterion("ship_fee >", value, "shipFee");
			return (Criteria) this;
		}

		public Criteria andShipFeeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("ship_fee >=", value, "shipFee");
			return (Criteria) this;
		}

		public Criteria andShipFeeLessThan(BigDecimal value) {
			addCriterion("ship_fee <", value, "shipFee");
			return (Criteria) this;
		}

		public Criteria andShipFeeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("ship_fee <=", value, "shipFee");
			return (Criteria) this;
		}

		public Criteria andShipFeeIn(List<BigDecimal> values) {
			addCriterion("ship_fee in", values, "shipFee");
			return (Criteria) this;
		}

		public Criteria andShipFeeNotIn(List<BigDecimal> values) {
			addCriterion("ship_fee not in", values, "shipFee");
			return (Criteria) this;
		}

		public Criteria andShipFeeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ship_fee between", value1, value2, "shipFee");
			return (Criteria) this;
		}

		public Criteria andShipFeeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ship_fee not between", value1, value2, "shipFee");
			return (Criteria) this;
		}

		public Criteria andGoodsInventoryIsNull() {
			addCriterion("goods_inventory is null");
			return (Criteria) this;
		}

		public Criteria andGoodsInventoryIsNotNull() {
			addCriterion("goods_inventory is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsInventoryEqualTo(Integer value) {
			addCriterion("goods_inventory =", value, "goodsInventory");
			return (Criteria) this;
		}

		public Criteria andGoodsInventoryNotEqualTo(Integer value) {
			addCriterion("goods_inventory <>", value, "goodsInventory");
			return (Criteria) this;
		}

		public Criteria andGoodsInventoryGreaterThan(Integer value) {
			addCriterion("goods_inventory >", value, "goodsInventory");
			return (Criteria) this;
		}

		public Criteria andGoodsInventoryGreaterThanOrEqualTo(Integer value) {
			addCriterion("goods_inventory >=", value, "goodsInventory");
			return (Criteria) this;
		}

		public Criteria andGoodsInventoryLessThan(Integer value) {
			addCriterion("goods_inventory <", value, "goodsInventory");
			return (Criteria) this;
		}

		public Criteria andGoodsInventoryLessThanOrEqualTo(Integer value) {
			addCriterion("goods_inventory <=", value, "goodsInventory");
			return (Criteria) this;
		}

		public Criteria andGoodsInventoryIn(List<Integer> values) {
			addCriterion("goods_inventory in", values, "goodsInventory");
			return (Criteria) this;
		}

		public Criteria andGoodsInventoryNotIn(List<Integer> values) {
			addCriterion("goods_inventory not in", values, "goodsInventory");
			return (Criteria) this;
		}

		public Criteria andGoodsInventoryBetween(Integer value1, Integer value2) {
			addCriterion("goods_inventory between", value1, value2, "goodsInventory");
			return (Criteria) this;
		}

		public Criteria andGoodsInventoryNotBetween(Integer value1, Integer value2) {
			addCriterion("goods_inventory not between", value1, value2, "goodsInventory");
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

		public Criteria andGoodsStatusIsNull() {
			addCriterion("goods_status is null");
			return (Criteria) this;
		}

		public Criteria andGoodsStatusIsNotNull() {
			addCriterion("goods_status is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsStatusEqualTo(Boolean value) {
			addCriterion("goods_status =", value, "goodsStatus");
			return (Criteria) this;
		}

		public Criteria andGoodsStatusNotEqualTo(Boolean value) {
			addCriterion("goods_status <>", value, "goodsStatus");
			return (Criteria) this;
		}

		public Criteria andGoodsStatusGreaterThan(Boolean value) {
			addCriterion("goods_status >", value, "goodsStatus");
			return (Criteria) this;
		}

		public Criteria andGoodsStatusGreaterThanOrEqualTo(Boolean value) {
			addCriterion("goods_status >=", value, "goodsStatus");
			return (Criteria) this;
		}

		public Criteria andGoodsStatusLessThan(Boolean value) {
			addCriterion("goods_status <", value, "goodsStatus");
			return (Criteria) this;
		}

		public Criteria andGoodsStatusLessThanOrEqualTo(Boolean value) {
			addCriterion("goods_status <=", value, "goodsStatus");
			return (Criteria) this;
		}

		public Criteria andGoodsStatusIn(List<Boolean> values) {
			addCriterion("goods_status in", values, "goodsStatus");
			return (Criteria) this;
		}

		public Criteria andGoodsStatusNotIn(List<Boolean> values) {
			addCriterion("goods_status not in", values, "goodsStatus");
			return (Criteria) this;
		}

		public Criteria andGoodsStatusBetween(Boolean value1, Boolean value2) {
			addCriterion("goods_status between", value1, value2, "goodsStatus");
			return (Criteria) this;
		}

		public Criteria andGoodsStatusNotBetween(Boolean value1, Boolean value2) {
			addCriterion("goods_status not between", value1, value2, "goodsStatus");
			return (Criteria) this;
		}

		public Criteria andCreatTimeIsNull() {
			addCriterion("creat_time is null");
			return (Criteria) this;
		}

		public Criteria andCreatTimeIsNotNull() {
			addCriterion("creat_time is not null");
			return (Criteria) this;
		}

		public Criteria andCreatTimeEqualTo(Date value) {
			addCriterion("creat_time =", value, "creatTime");
			return (Criteria) this;
		}

		public Criteria andCreatTimeNotEqualTo(Date value) {
			addCriterion("creat_time <>", value, "creatTime");
			return (Criteria) this;
		}

		public Criteria andCreatTimeGreaterThan(Date value) {
			addCriterion("creat_time >", value, "creatTime");
			return (Criteria) this;
		}

		public Criteria andCreatTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("creat_time >=", value, "creatTime");
			return (Criteria) this;
		}

		public Criteria andCreatTimeLessThan(Date value) {
			addCriterion("creat_time <", value, "creatTime");
			return (Criteria) this;
		}

		public Criteria andCreatTimeLessThanOrEqualTo(Date value) {
			addCriterion("creat_time <=", value, "creatTime");
			return (Criteria) this;
		}

		public Criteria andCreatTimeIn(List<Date> values) {
			addCriterion("creat_time in", values, "creatTime");
			return (Criteria) this;
		}

		public Criteria andCreatTimeNotIn(List<Date> values) {
			addCriterion("creat_time not in", values, "creatTime");
			return (Criteria) this;
		}

		public Criteria andCreatTimeBetween(Date value1, Date value2) {
			addCriterion("creat_time between", value1, value2, "creatTime");
			return (Criteria) this;
		}

		public Criteria andCreatTimeNotBetween(Date value1, Date value2) {
			addCriterion("creat_time not between", value1, value2, "creatTime");
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