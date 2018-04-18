package com.sinco.carnation.o2o.model;

import com.sinco.carnation.o2o.bo.GroupOrderBO;
import com.sinco.mybatis.dal.core.AbstractExample;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GroupOrderExample extends AbstractExample<GroupOrderBO> {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected String limit;

	public GroupOrderExample() {
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

		public Criteria andFinishTimeIsNull() {
			addCriterion("finish_time is null");
			return (Criteria) this;
		}

		public Criteria andFinishTimeIsNotNull() {
			addCriterion("finish_time is not null");
			return (Criteria) this;
		}

		public Criteria andFinishTimeEqualTo(Date value) {
			addCriterion("finish_time =", value, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeNotEqualTo(Date value) {
			addCriterion("finish_time <>", value, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeGreaterThan(Date value) {
			addCriterion("finish_time >", value, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("finish_time >=", value, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeLessThan(Date value) {
			addCriterion("finish_time <", value, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeLessThanOrEqualTo(Date value) {
			addCriterion("finish_time <=", value, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeIn(List<Date> values) {
			addCriterion("finish_time in", values, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeNotIn(List<Date> values) {
			addCriterion("finish_time not in", values, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeBetween(Date value1, Date value2) {
			addCriterion("finish_time between", value1, value2, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeNotBetween(Date value1, Date value2) {
			addCriterion("finish_time not between", value1, value2, "finishTime");
			return (Criteria) this;
		}

		public Criteria andGoodsAmountIsNull() {
			addCriterion("goods_amount is null");
			return (Criteria) this;
		}

		public Criteria andGoodsAmountIsNotNull() {
			addCriterion("goods_amount is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsAmountEqualTo(BigDecimal value) {
			addCriterion("goods_amount =", value, "goodsAmount");
			return (Criteria) this;
		}

		public Criteria andGoodsAmountNotEqualTo(BigDecimal value) {
			addCriterion("goods_amount <>", value, "goodsAmount");
			return (Criteria) this;
		}

		public Criteria andGoodsAmountGreaterThan(BigDecimal value) {
			addCriterion("goods_amount >", value, "goodsAmount");
			return (Criteria) this;
		}

		public Criteria andGoodsAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("goods_amount >=", value, "goodsAmount");
			return (Criteria) this;
		}

		public Criteria andGoodsAmountLessThan(BigDecimal value) {
			addCriterion("goods_amount <", value, "goodsAmount");
			return (Criteria) this;
		}

		public Criteria andGoodsAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("goods_amount <=", value, "goodsAmount");
			return (Criteria) this;
		}

		public Criteria andGoodsAmountIn(List<BigDecimal> values) {
			addCriterion("goods_amount in", values, "goodsAmount");
			return (Criteria) this;
		}

		public Criteria andGoodsAmountNotIn(List<BigDecimal> values) {
			addCriterion("goods_amount not in", values, "goodsAmount");
			return (Criteria) this;
		}

		public Criteria andGoodsAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("goods_amount between", value1, value2, "goodsAmount");
			return (Criteria) this;
		}

		public Criteria andGoodsAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("goods_amount not between", value1, value2, "goodsAmount");
			return (Criteria) this;
		}

		public Criteria andOrderFormIsNull() {
			addCriterion("order_form is null");
			return (Criteria) this;
		}

		public Criteria andOrderFormIsNotNull() {
			addCriterion("order_form is not null");
			return (Criteria) this;
		}

		public Criteria andOrderFormEqualTo(Integer value) {
			addCriterion("order_form =", value, "orderForm");
			return (Criteria) this;
		}

		public Criteria andOrderFormNotEqualTo(Integer value) {
			addCriterion("order_form <>", value, "orderForm");
			return (Criteria) this;
		}

		public Criteria andOrderFormGreaterThan(Integer value) {
			addCriterion("order_form >", value, "orderForm");
			return (Criteria) this;
		}

		public Criteria andOrderFormGreaterThanOrEqualTo(Integer value) {
			addCriterion("order_form >=", value, "orderForm");
			return (Criteria) this;
		}

		public Criteria andOrderFormLessThan(Integer value) {
			addCriterion("order_form <", value, "orderForm");
			return (Criteria) this;
		}

		public Criteria andOrderFormLessThanOrEqualTo(Integer value) {
			addCriterion("order_form <=", value, "orderForm");
			return (Criteria) this;
		}

		public Criteria andOrderFormIn(List<Integer> values) {
			addCriterion("order_form in", values, "orderForm");
			return (Criteria) this;
		}

		public Criteria andOrderFormNotIn(List<Integer> values) {
			addCriterion("order_form not in", values, "orderForm");
			return (Criteria) this;
		}

		public Criteria andOrderFormBetween(Integer value1, Integer value2) {
			addCriterion("order_form between", value1, value2, "orderForm");
			return (Criteria) this;
		}

		public Criteria andOrderFormNotBetween(Integer value1, Integer value2) {
			addCriterion("order_form not between", value1, value2, "orderForm");
			return (Criteria) this;
		}

		public Criteria andOrderIdIsNull() {
			addCriterion("order_id is null");
			return (Criteria) this;
		}

		public Criteria andOrderIdIsNotNull() {
			addCriterion("order_id is not null");
			return (Criteria) this;
		}

		public Criteria andOrderIdEqualTo(String value) {
			addCriterion("order_id =", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotEqualTo(String value) {
			addCriterion("order_id <>", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdGreaterThan(String value) {
			addCriterion("order_id >", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
			addCriterion("order_id >=", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdLessThan(String value) {
			addCriterion("order_id <", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdLessThanOrEqualTo(String value) {
			addCriterion("order_id <=", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdLike(String value) {
			addCriterion("order_id like", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotLike(String value) {
			addCriterion("order_id not like", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdIn(List<String> values) {
			addCriterion("order_id in", values, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotIn(List<String> values) {
			addCriterion("order_id not in", values, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdBetween(String value1, String value2) {
			addCriterion("order_id between", value1, value2, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotBetween(String value1, String value2) {
			addCriterion("order_id not between", value1, value2, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderStatusIsNull() {
			addCriterion("order_status is null");
			return (Criteria) this;
		}

		public Criteria andOrderStatusIsNotNull() {
			addCriterion("order_status is not null");
			return (Criteria) this;
		}

		public Criteria andOrderStatusEqualTo(Integer value) {
			addCriterion("order_status =", value, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusNotEqualTo(Integer value) {
			addCriterion("order_status <>", value, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusGreaterThan(Integer value) {
			addCriterion("order_status >", value, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("order_status >=", value, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusLessThan(Integer value) {
			addCriterion("order_status <", value, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusLessThanOrEqualTo(Integer value) {
			addCriterion("order_status <=", value, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusIn(List<Integer> values) {
			addCriterion("order_status in", values, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusNotIn(List<Integer> values) {
			addCriterion("order_status not in", values, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusBetween(Integer value1, Integer value2) {
			addCriterion("order_status between", value1, value2, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("order_status not between", value1, value2, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderReturnCountIsNull() {
			addCriterion("order_return_count is null");
			return (Criteria) this;
		}

		public Criteria andOrderReturnCountIsNotNull() {
			addCriterion("order_return_count is not null");
			return (Criteria) this;
		}

		public Criteria andOrderReturnCountEqualTo(Integer value) {
			addCriterion("order_return_count =", value, "orderReturnCount");
			return (Criteria) this;
		}

		public Criteria andOrderReturnCountNotEqualTo(Integer value) {
			addCriterion("order_return_count <>", value, "orderReturnCount");
			return (Criteria) this;
		}

		public Criteria andOrderReturnCountGreaterThan(Integer value) {
			addCriterion("order_return_count >", value, "orderReturnCount");
			return (Criteria) this;
		}

		public Criteria andOrderReturnCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("order_return_count >=", value, "orderReturnCount");
			return (Criteria) this;
		}

		public Criteria andOrderReturnCountLessThan(Integer value) {
			addCriterion("order_return_count <", value, "orderReturnCount");
			return (Criteria) this;
		}

		public Criteria andOrderReturnCountLessThanOrEqualTo(Integer value) {
			addCriterion("order_return_count <=", value, "orderReturnCount");
			return (Criteria) this;
		}

		public Criteria andOrderReturnCountIn(List<Integer> values) {
			addCriterion("order_return_count in", values, "orderReturnCount");
			return (Criteria) this;
		}

		public Criteria andOrderReturnCountNotIn(List<Integer> values) {
			addCriterion("order_return_count not in", values, "orderReturnCount");
			return (Criteria) this;
		}

		public Criteria andOrderReturnCountBetween(Integer value1, Integer value2) {
			addCriterion("order_return_count between", value1, value2, "orderReturnCount");
			return (Criteria) this;
		}

		public Criteria andOrderReturnCountNotBetween(Integer value1, Integer value2) {
			addCriterion("order_return_count not between", value1, value2, "orderReturnCount");
			return (Criteria) this;
		}

		public Criteria andOrderTypeIsNull() {
			addCriterion("order_type is null");
			return (Criteria) this;
		}

		public Criteria andOrderTypeIsNotNull() {
			addCriterion("order_type is not null");
			return (Criteria) this;
		}

		public Criteria andOrderTypeEqualTo(Integer value) {
			addCriterion("order_type =", value, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeNotEqualTo(Integer value) {
			addCriterion("order_type <>", value, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeGreaterThan(Integer value) {
			addCriterion("order_type >", value, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("order_type >=", value, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeLessThan(Integer value) {
			addCriterion("order_type <", value, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeLessThanOrEqualTo(Integer value) {
			addCriterion("order_type <=", value, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeIn(List<Integer> values) {
			addCriterion("order_type in", values, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeNotIn(List<Integer> values) {
			addCriterion("order_type not in", values, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeBetween(Integer value1, Integer value2) {
			addCriterion("order_type between", value1, value2, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("order_type not between", value1, value2, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderSourceIsNull() {
			addCriterion("order_source is null");
			return (Criteria) this;
		}

		public Criteria andOrderSourceIsNotNull() {
			addCriterion("order_source is not null");
			return (Criteria) this;
		}

		public Criteria andOrderSourceEqualTo(String value) {
			addCriterion("order_source =", value, "orderSource");
			return (Criteria) this;
		}

		public Criteria andOrderSourceNotEqualTo(String value) {
			addCriterion("order_source <>", value, "orderSource");
			return (Criteria) this;
		}

		public Criteria andOrderSourceGreaterThan(String value) {
			addCriterion("order_source >", value, "orderSource");
			return (Criteria) this;
		}

		public Criteria andOrderSourceGreaterThanOrEqualTo(String value) {
			addCriterion("order_source >=", value, "orderSource");
			return (Criteria) this;
		}

		public Criteria andOrderSourceLessThan(String value) {
			addCriterion("order_source <", value, "orderSource");
			return (Criteria) this;
		}

		public Criteria andOrderSourceLessThanOrEqualTo(String value) {
			addCriterion("order_source <=", value, "orderSource");
			return (Criteria) this;
		}

		public Criteria andOrderSourceLike(String value) {
			addCriterion("order_source like", value, "orderSource");
			return (Criteria) this;
		}

		public Criteria andOrderSourceNotLike(String value) {
			addCriterion("order_source not like", value, "orderSource");
			return (Criteria) this;
		}

		public Criteria andOrderSourceIn(List<String> values) {
			addCriterion("order_source in", values, "orderSource");
			return (Criteria) this;
		}

		public Criteria andOrderSourceNotIn(List<String> values) {
			addCriterion("order_source not in", values, "orderSource");
			return (Criteria) this;
		}

		public Criteria andOrderSourceBetween(String value1, String value2) {
			addCriterion("order_source between", value1, value2, "orderSource");
			return (Criteria) this;
		}

		public Criteria andOrderSourceNotBetween(String value1, String value2) {
			addCriterion("order_source not between", value1, value2, "orderSource");
			return (Criteria) this;
		}

		public Criteria andOutOrderIdIsNull() {
			addCriterion("out_order_id is null");
			return (Criteria) this;
		}

		public Criteria andOutOrderIdIsNotNull() {
			addCriterion("out_order_id is not null");
			return (Criteria) this;
		}

		public Criteria andOutOrderIdEqualTo(String value) {
			addCriterion("out_order_id =", value, "outOrderId");
			return (Criteria) this;
		}

		public Criteria andOutOrderIdNotEqualTo(String value) {
			addCriterion("out_order_id <>", value, "outOrderId");
			return (Criteria) this;
		}

		public Criteria andOutOrderIdGreaterThan(String value) {
			addCriterion("out_order_id >", value, "outOrderId");
			return (Criteria) this;
		}

		public Criteria andOutOrderIdGreaterThanOrEqualTo(String value) {
			addCriterion("out_order_id >=", value, "outOrderId");
			return (Criteria) this;
		}

		public Criteria andOutOrderIdLessThan(String value) {
			addCriterion("out_order_id <", value, "outOrderId");
			return (Criteria) this;
		}

		public Criteria andOutOrderIdLessThanOrEqualTo(String value) {
			addCriterion("out_order_id <=", value, "outOrderId");
			return (Criteria) this;
		}

		public Criteria andOutOrderIdLike(String value) {
			addCriterion("out_order_id like", value, "outOrderId");
			return (Criteria) this;
		}

		public Criteria andOutOrderIdNotLike(String value) {
			addCriterion("out_order_id not like", value, "outOrderId");
			return (Criteria) this;
		}

		public Criteria andOutOrderIdIn(List<String> values) {
			addCriterion("out_order_id in", values, "outOrderId");
			return (Criteria) this;
		}

		public Criteria andOutOrderIdNotIn(List<String> values) {
			addCriterion("out_order_id not in", values, "outOrderId");
			return (Criteria) this;
		}

		public Criteria andOutOrderIdBetween(String value1, String value2) {
			addCriterion("out_order_id between", value1, value2, "outOrderId");
			return (Criteria) this;
		}

		public Criteria andOutOrderIdNotBetween(String value1, String value2) {
			addCriterion("out_order_id not between", value1, value2, "outOrderId");
			return (Criteria) this;
		}

		public Criteria andReturnShipTimeIsNull() {
			addCriterion("return_ship_time is null");
			return (Criteria) this;
		}

		public Criteria andReturnShipTimeIsNotNull() {
			addCriterion("return_ship_time is not null");
			return (Criteria) this;
		}

		public Criteria andReturnShipTimeEqualTo(Date value) {
			addCriterion("return_ship_time =", value, "returnShipTime");
			return (Criteria) this;
		}

		public Criteria andReturnShipTimeNotEqualTo(Date value) {
			addCriterion("return_ship_time <>", value, "returnShipTime");
			return (Criteria) this;
		}

		public Criteria andReturnShipTimeGreaterThan(Date value) {
			addCriterion("return_ship_time >", value, "returnShipTime");
			return (Criteria) this;
		}

		public Criteria andReturnShipTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("return_ship_time >=", value, "returnShipTime");
			return (Criteria) this;
		}

		public Criteria andReturnShipTimeLessThan(Date value) {
			addCriterion("return_ship_time <", value, "returnShipTime");
			return (Criteria) this;
		}

		public Criteria andReturnShipTimeLessThanOrEqualTo(Date value) {
			addCriterion("return_ship_time <=", value, "returnShipTime");
			return (Criteria) this;
		}

		public Criteria andReturnShipTimeIn(List<Date> values) {
			addCriterion("return_ship_time in", values, "returnShipTime");
			return (Criteria) this;
		}

		public Criteria andReturnShipTimeNotIn(List<Date> values) {
			addCriterion("return_ship_time not in", values, "returnShipTime");
			return (Criteria) this;
		}

		public Criteria andReturnShipTimeBetween(Date value1, Date value2) {
			addCriterion("return_ship_time between", value1, value2, "returnShipTime");
			return (Criteria) this;
		}

		public Criteria andReturnShipTimeNotBetween(Date value1, Date value2) {
			addCriterion("return_ship_time not between", value1, value2, "returnShipTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeIsNull() {
			addCriterion("pay_time is null");
			return (Criteria) this;
		}

		public Criteria andPayTimeIsNotNull() {
			addCriterion("pay_time is not null");
			return (Criteria) this;
		}

		public Criteria andPayTimeEqualTo(Date value) {
			addCriterion("pay_time =", value, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeNotEqualTo(Date value) {
			addCriterion("pay_time <>", value, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeGreaterThan(Date value) {
			addCriterion("pay_time >", value, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("pay_time >=", value, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeLessThan(Date value) {
			addCriterion("pay_time <", value, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeLessThanOrEqualTo(Date value) {
			addCriterion("pay_time <=", value, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeIn(List<Date> values) {
			addCriterion("pay_time in", values, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeNotIn(List<Date> values) {
			addCriterion("pay_time not in", values, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeBetween(Date value1, Date value2) {
			addCriterion("pay_time between", value1, value2, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeNotBetween(Date value1, Date value2) {
			addCriterion("pay_time not between", value1, value2, "payTime");
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

		public Criteria andTotalPriceIsNull() {
			addCriterion("total_price is null");
			return (Criteria) this;
		}

		public Criteria andTotalPriceIsNotNull() {
			addCriterion("total_price is not null");
			return (Criteria) this;
		}

		public Criteria andTotalPriceEqualTo(BigDecimal value) {
			addCriterion("total_price =", value, "totalPrice");
			return (Criteria) this;
		}

		public Criteria andTotalPriceNotEqualTo(BigDecimal value) {
			addCriterion("total_price <>", value, "totalPrice");
			return (Criteria) this;
		}

		public Criteria andTotalPriceGreaterThan(BigDecimal value) {
			addCriterion("total_price >", value, "totalPrice");
			return (Criteria) this;
		}

		public Criteria andTotalPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("total_price >=", value, "totalPrice");
			return (Criteria) this;
		}

		public Criteria andTotalPriceLessThan(BigDecimal value) {
			addCriterion("total_price <", value, "totalPrice");
			return (Criteria) this;
		}

		public Criteria andTotalPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("total_price <=", value, "totalPrice");
			return (Criteria) this;
		}

		public Criteria andTotalPriceIn(List<BigDecimal> values) {
			addCriterion("total_price in", values, "totalPrice");
			return (Criteria) this;
		}

		public Criteria andTotalPriceNotIn(List<BigDecimal> values) {
			addCriterion("total_price not in", values, "totalPrice");
			return (Criteria) this;
		}

		public Criteria andTotalPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("total_price between", value1, value2, "totalPrice");
			return (Criteria) this;
		}

		public Criteria andTotalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("total_price not between", value1, value2, "totalPrice");
			return (Criteria) this;
		}

		public Criteria andTradeNoIsNull() {
			addCriterion("trade_no is null");
			return (Criteria) this;
		}

		public Criteria andTradeNoIsNotNull() {
			addCriterion("trade_no is not null");
			return (Criteria) this;
		}

		public Criteria andTradeNoEqualTo(String value) {
			addCriterion("trade_no =", value, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoNotEqualTo(String value) {
			addCriterion("trade_no <>", value, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoGreaterThan(String value) {
			addCriterion("trade_no >", value, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoGreaterThanOrEqualTo(String value) {
			addCriterion("trade_no >=", value, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoLessThan(String value) {
			addCriterion("trade_no <", value, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoLessThanOrEqualTo(String value) {
			addCriterion("trade_no <=", value, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoLike(String value) {
			addCriterion("trade_no like", value, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoNotLike(String value) {
			addCriterion("trade_no not like", value, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoIn(List<String> values) {
			addCriterion("trade_no in", values, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoNotIn(List<String> values) {
			addCriterion("trade_no not in", values, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoBetween(String value1, String value2) {
			addCriterion("trade_no between", value1, value2, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andTradeNoNotBetween(String value1, String value2) {
			addCriterion("trade_no not between", value1, value2, "tradeNo");
			return (Criteria) this;
		}

		public Criteria andIsSysUserIsNull() {
			addCriterion("is_sys_user is null");
			return (Criteria) this;
		}

		public Criteria andIsSysUserIsNotNull() {
			addCriterion("is_sys_user is not null");
			return (Criteria) this;
		}

		public Criteria andIsSysUserEqualTo(Boolean value) {
			addCriterion("is_sys_user =", value, "isSysUser");
			return (Criteria) this;
		}

		public Criteria andIsSysUserNotEqualTo(Boolean value) {
			addCriterion("is_sys_user <>", value, "isSysUser");
			return (Criteria) this;
		}

		public Criteria andIsSysUserGreaterThan(Boolean value) {
			addCriterion("is_sys_user >", value, "isSysUser");
			return (Criteria) this;
		}

		public Criteria andIsSysUserGreaterThanOrEqualTo(Boolean value) {
			addCriterion("is_sys_user >=", value, "isSysUser");
			return (Criteria) this;
		}

		public Criteria andIsSysUserLessThan(Boolean value) {
			addCriterion("is_sys_user <", value, "isSysUser");
			return (Criteria) this;
		}

		public Criteria andIsSysUserLessThanOrEqualTo(Boolean value) {
			addCriterion("is_sys_user <=", value, "isSysUser");
			return (Criteria) this;
		}

		public Criteria andIsSysUserIn(List<Boolean> values) {
			addCriterion("is_sys_user in", values, "isSysUser");
			return (Criteria) this;
		}

		public Criteria andIsSysUserNotIn(List<Boolean> values) {
			addCriterion("is_sys_user not in", values, "isSysUser");
			return (Criteria) this;
		}

		public Criteria andIsSysUserBetween(Boolean value1, Boolean value2) {
			addCriterion("is_sys_user between", value1, value2, "isSysUser");
			return (Criteria) this;
		}

		public Criteria andIsSysUserNotBetween(Boolean value1, Boolean value2) {
			addCriterion("is_sys_user not between", value1, value2, "isSysUser");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNull() {
			addCriterion("user_id is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("user_id is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(Long value) {
			addCriterion("user_id =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(Long value) {
			addCriterion("user_id <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(Long value) {
			addCriterion("user_id >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("user_id >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(Long value) {
			addCriterion("user_id <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(Long value) {
			addCriterion("user_id <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<Long> values) {
			addCriterion("user_id in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<Long> values) {
			addCriterion("user_id not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(Long value1, Long value2) {
			addCriterion("user_id between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(Long value1, Long value2) {
			addCriterion("user_id not between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andPaymentMarkIsNull() {
			addCriterion("payment_mark is null");
			return (Criteria) this;
		}

		public Criteria andPaymentMarkIsNotNull() {
			addCriterion("payment_mark is not null");
			return (Criteria) this;
		}

		public Criteria andPaymentMarkEqualTo(String value) {
			addCriterion("payment_mark =", value, "paymentMark");
			return (Criteria) this;
		}

		public Criteria andPaymentMarkNotEqualTo(String value) {
			addCriterion("payment_mark <>", value, "paymentMark");
			return (Criteria) this;
		}

		public Criteria andPaymentMarkGreaterThan(String value) {
			addCriterion("payment_mark >", value, "paymentMark");
			return (Criteria) this;
		}

		public Criteria andPaymentMarkGreaterThanOrEqualTo(String value) {
			addCriterion("payment_mark >=", value, "paymentMark");
			return (Criteria) this;
		}

		public Criteria andPaymentMarkLessThan(String value) {
			addCriterion("payment_mark <", value, "paymentMark");
			return (Criteria) this;
		}

		public Criteria andPaymentMarkLessThanOrEqualTo(String value) {
			addCriterion("payment_mark <=", value, "paymentMark");
			return (Criteria) this;
		}

		public Criteria andPaymentMarkLike(String value) {
			addCriterion("payment_mark like", value, "paymentMark");
			return (Criteria) this;
		}

		public Criteria andPaymentMarkNotLike(String value) {
			addCriterion("payment_mark not like", value, "paymentMark");
			return (Criteria) this;
		}

		public Criteria andPaymentMarkIn(List<String> values) {
			addCriterion("payment_mark in", values, "paymentMark");
			return (Criteria) this;
		}

		public Criteria andPaymentMarkNotIn(List<String> values) {
			addCriterion("payment_mark not in", values, "paymentMark");
			return (Criteria) this;
		}

		public Criteria andPaymentMarkBetween(String value1, String value2) {
			addCriterion("payment_mark between", value1, value2, "paymentMark");
			return (Criteria) this;
		}

		public Criteria andPaymentMarkNotBetween(String value1, String value2) {
			addCriterion("payment_mark not between", value1, value2, "paymentMark");
			return (Criteria) this;
		}

		public Criteria andIsMobileIsNull() {
			addCriterion("is_mobile is null");
			return (Criteria) this;
		}

		public Criteria andIsMobileIsNotNull() {
			addCriterion("is_mobile is not null");
			return (Criteria) this;
		}

		public Criteria andIsMobileEqualTo(Boolean value) {
			addCriterion("is_mobile =", value, "isMobile");
			return (Criteria) this;
		}

		public Criteria andIsMobileNotEqualTo(Boolean value) {
			addCriterion("is_mobile <>", value, "isMobile");
			return (Criteria) this;
		}

		public Criteria andIsMobileGreaterThan(Boolean value) {
			addCriterion("is_mobile >", value, "isMobile");
			return (Criteria) this;
		}

		public Criteria andIsMobileGreaterThanOrEqualTo(Boolean value) {
			addCriterion("is_mobile >=", value, "isMobile");
			return (Criteria) this;
		}

		public Criteria andIsMobileLessThan(Boolean value) {
			addCriterion("is_mobile <", value, "isMobile");
			return (Criteria) this;
		}

		public Criteria andIsMobileLessThanOrEqualTo(Boolean value) {
			addCriterion("is_mobile <=", value, "isMobile");
			return (Criteria) this;
		}

		public Criteria andIsMobileIn(List<Boolean> values) {
			addCriterion("is_mobile in", values, "isMobile");
			return (Criteria) this;
		}

		public Criteria andIsMobileNotIn(List<Boolean> values) {
			addCriterion("is_mobile not in", values, "isMobile");
			return (Criteria) this;
		}

		public Criteria andIsMobileBetween(Boolean value1, Boolean value2) {
			addCriterion("is_mobile between", value1, value2, "isMobile");
			return (Criteria) this;
		}

		public Criteria andIsMobileNotBetween(Boolean value1, Boolean value2) {
			addCriterion("is_mobile not between", value1, value2, "isMobile");
			return (Criteria) this;
		}

		public Criteria andUserNicknameIsNull() {
			addCriterion("user_nickname is null");
			return (Criteria) this;
		}

		public Criteria andUserNicknameIsNotNull() {
			addCriterion("user_nickname is not null");
			return (Criteria) this;
		}

		public Criteria andUserNicknameEqualTo(String value) {
			addCriterion("user_nickname =", value, "userNickname");
			return (Criteria) this;
		}

		public Criteria andUserNicknameNotEqualTo(String value) {
			addCriterion("user_nickname <>", value, "userNickname");
			return (Criteria) this;
		}

		public Criteria andUserNicknameGreaterThan(String value) {
			addCriterion("user_nickname >", value, "userNickname");
			return (Criteria) this;
		}

		public Criteria andUserNicknameGreaterThanOrEqualTo(String value) {
			addCriterion("user_nickname >=", value, "userNickname");
			return (Criteria) this;
		}

		public Criteria andUserNicknameLessThan(String value) {
			addCriterion("user_nickname <", value, "userNickname");
			return (Criteria) this;
		}

		public Criteria andUserNicknameLessThanOrEqualTo(String value) {
			addCriterion("user_nickname <=", value, "userNickname");
			return (Criteria) this;
		}

		public Criteria andUserNicknameLike(String value) {
			addCriterion("user_nickname like", value, "userNickname");
			return (Criteria) this;
		}

		public Criteria andUserNicknameNotLike(String value) {
			addCriterion("user_nickname not like", value, "userNickname");
			return (Criteria) this;
		}

		public Criteria andUserNicknameIn(List<String> values) {
			addCriterion("user_nickname in", values, "userNickname");
			return (Criteria) this;
		}

		public Criteria andUserNicknameNotIn(List<String> values) {
			addCriterion("user_nickname not in", values, "userNickname");
			return (Criteria) this;
		}

		public Criteria andUserNicknameBetween(String value1, String value2) {
			addCriterion("user_nickname between", value1, value2, "userNickname");
			return (Criteria) this;
		}

		public Criteria andUserNicknameNotBetween(String value1, String value2) {
			addCriterion("user_nickname not between", value1, value2, "userNickname");
			return (Criteria) this;
		}

		public Criteria andLocalReturnStatusIsNull() {
			addCriterion("local_return_status is null");
			return (Criteria) this;
		}

		public Criteria andLocalReturnStatusIsNotNull() {
			addCriterion("local_return_status is not null");
			return (Criteria) this;
		}

		public Criteria andLocalReturnStatusEqualTo(Integer value) {
			addCriterion("local_return_status =", value, "localReturnStatus");
			return (Criteria) this;
		}

		public Criteria andLocalReturnStatusNotEqualTo(Integer value) {
			addCriterion("local_return_status <>", value, "localReturnStatus");
			return (Criteria) this;
		}

		public Criteria andLocalReturnStatusGreaterThan(Integer value) {
			addCriterion("local_return_status >", value, "localReturnStatus");
			return (Criteria) this;
		}

		public Criteria andLocalReturnStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("local_return_status >=", value, "localReturnStatus");
			return (Criteria) this;
		}

		public Criteria andLocalReturnStatusLessThan(Integer value) {
			addCriterion("local_return_status <", value, "localReturnStatus");
			return (Criteria) this;
		}

		public Criteria andLocalReturnStatusLessThanOrEqualTo(Integer value) {
			addCriterion("local_return_status <=", value, "localReturnStatus");
			return (Criteria) this;
		}

		public Criteria andLocalReturnStatusIn(List<Integer> values) {
			addCriterion("local_return_status in", values, "localReturnStatus");
			return (Criteria) this;
		}

		public Criteria andLocalReturnStatusNotIn(List<Integer> values) {
			addCriterion("local_return_status not in", values, "localReturnStatus");
			return (Criteria) this;
		}

		public Criteria andLocalReturnStatusBetween(Integer value1, Integer value2) {
			addCriterion("local_return_status between", value1, value2, "localReturnStatus");
			return (Criteria) this;
		}

		public Criteria andLocalReturnStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("local_return_status not between", value1, value2, "localReturnStatus");
			return (Criteria) this;
		}

		public Criteria andLocalGroupNameIsNull() {
			addCriterion("local_group_name is null");
			return (Criteria) this;
		}

		public Criteria andLocalGroupNameIsNotNull() {
			addCriterion("local_group_name is not null");
			return (Criteria) this;
		}

		public Criteria andLocalGroupNameEqualTo(String value) {
			addCriterion("local_group_name =", value, "localGroupName");
			return (Criteria) this;
		}

		public Criteria andLocalGroupNameNotEqualTo(String value) {
			addCriterion("local_group_name <>", value, "localGroupName");
			return (Criteria) this;
		}

		public Criteria andLocalGroupNameGreaterThan(String value) {
			addCriterion("local_group_name >", value, "localGroupName");
			return (Criteria) this;
		}

		public Criteria andLocalGroupNameGreaterThanOrEqualTo(String value) {
			addCriterion("local_group_name >=", value, "localGroupName");
			return (Criteria) this;
		}

		public Criteria andLocalGroupNameLessThan(String value) {
			addCriterion("local_group_name <", value, "localGroupName");
			return (Criteria) this;
		}

		public Criteria andLocalGroupNameLessThanOrEqualTo(String value) {
			addCriterion("local_group_name <=", value, "localGroupName");
			return (Criteria) this;
		}

		public Criteria andLocalGroupNameLike(String value) {
			addCriterion("local_group_name like", value, "localGroupName");
			return (Criteria) this;
		}

		public Criteria andLocalGroupNameNotLike(String value) {
			addCriterion("local_group_name not like", value, "localGroupName");
			return (Criteria) this;
		}

		public Criteria andLocalGroupNameIn(List<String> values) {
			addCriterion("local_group_name in", values, "localGroupName");
			return (Criteria) this;
		}

		public Criteria andLocalGroupNameNotIn(List<String> values) {
			addCriterion("local_group_name not in", values, "localGroupName");
			return (Criteria) this;
		}

		public Criteria andLocalGroupNameBetween(String value1, String value2) {
			addCriterion("local_group_name between", value1, value2, "localGroupName");
			return (Criteria) this;
		}

		public Criteria andLocalGroupNameNotBetween(String value1, String value2) {
			addCriterion("local_group_name not between", value1, value2, "localGroupName");
			return (Criteria) this;
		}

		public Criteria andCashIdIsNull() {
			addCriterion("cash_id is null");
			return (Criteria) this;
		}

		public Criteria andCashIdIsNotNull() {
			addCriterion("cash_id is not null");
			return (Criteria) this;
		}

		public Criteria andCashIdEqualTo(Long value) {
			addCriterion("cash_id =", value, "cashId");
			return (Criteria) this;
		}

		public Criteria andCashIdNotEqualTo(Long value) {
			addCriterion("cash_id <>", value, "cashId");
			return (Criteria) this;
		}

		public Criteria andCashIdGreaterThan(Long value) {
			addCriterion("cash_id >", value, "cashId");
			return (Criteria) this;
		}

		public Criteria andCashIdGreaterThanOrEqualTo(Long value) {
			addCriterion("cash_id >=", value, "cashId");
			return (Criteria) this;
		}

		public Criteria andCashIdLessThan(Long value) {
			addCriterion("cash_id <", value, "cashId");
			return (Criteria) this;
		}

		public Criteria andCashIdLessThanOrEqualTo(Long value) {
			addCriterion("cash_id <=", value, "cashId");
			return (Criteria) this;
		}

		public Criteria andCashIdIn(List<Long> values) {
			addCriterion("cash_id in", values, "cashId");
			return (Criteria) this;
		}

		public Criteria andCashIdNotIn(List<Long> values) {
			addCriterion("cash_id not in", values, "cashId");
			return (Criteria) this;
		}

		public Criteria andCashIdBetween(Long value1, Long value2) {
			addCriterion("cash_id between", value1, value2, "cashId");
			return (Criteria) this;
		}

		public Criteria andCashIdNotBetween(Long value1, Long value2) {
			addCriterion("cash_id not between", value1, value2, "cashId");
			return (Criteria) this;
		}

		public Criteria andProportionIsNull() {
			addCriterion("proportion is null");
			return (Criteria) this;
		}

		public Criteria andProportionIsNotNull() {
			addCriterion("proportion is not null");
			return (Criteria) this;
		}

		public Criteria andProportionEqualTo(BigDecimal value) {
			addCriterion("proportion =", value, "proportion");
			return (Criteria) this;
		}

		public Criteria andProportionNotEqualTo(BigDecimal value) {
			addCriterion("proportion <>", value, "proportion");
			return (Criteria) this;
		}

		public Criteria andProportionGreaterThan(BigDecimal value) {
			addCriterion("proportion >", value, "proportion");
			return (Criteria) this;
		}

		public Criteria andProportionGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("proportion >=", value, "proportion");
			return (Criteria) this;
		}

		public Criteria andProportionLessThan(BigDecimal value) {
			addCriterion("proportion <", value, "proportion");
			return (Criteria) this;
		}

		public Criteria andProportionLessThanOrEqualTo(BigDecimal value) {
			addCriterion("proportion <=", value, "proportion");
			return (Criteria) this;
		}

		public Criteria andProportionIn(List<BigDecimal> values) {
			addCriterion("proportion in", values, "proportion");
			return (Criteria) this;
		}

		public Criteria andProportionNotIn(List<BigDecimal> values) {
			addCriterion("proportion not in", values, "proportion");
			return (Criteria) this;
		}

		public Criteria andProportionBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("proportion between", value1, value2, "proportion");
			return (Criteria) this;
		}

		public Criteria andProportionNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("proportion not between", value1, value2, "proportion");
			return (Criteria) this;
		}

		public Criteria andOriginalPriceIsNull() {
			addCriterion("original_price is null");
			return (Criteria) this;
		}

		public Criteria andOriginalPriceIsNotNull() {
			addCriterion("original_price is not null");
			return (Criteria) this;
		}

		public Criteria andOriginalPriceEqualTo(BigDecimal value) {
			addCriterion("original_price =", value, "originalPrice");
			return (Criteria) this;
		}

		public Criteria andOriginalPriceNotEqualTo(BigDecimal value) {
			addCriterion("original_price <>", value, "originalPrice");
			return (Criteria) this;
		}

		public Criteria andOriginalPriceGreaterThan(BigDecimal value) {
			addCriterion("original_price >", value, "originalPrice");
			return (Criteria) this;
		}

		public Criteria andOriginalPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("original_price >=", value, "originalPrice");
			return (Criteria) this;
		}

		public Criteria andOriginalPriceLessThan(BigDecimal value) {
			addCriterion("original_price <", value, "originalPrice");
			return (Criteria) this;
		}

		public Criteria andOriginalPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("original_price <=", value, "originalPrice");
			return (Criteria) this;
		}

		public Criteria andOriginalPriceIn(List<BigDecimal> values) {
			addCriterion("original_price in", values, "originalPrice");
			return (Criteria) this;
		}

		public Criteria andOriginalPriceNotIn(List<BigDecimal> values) {
			addCriterion("original_price not in", values, "originalPrice");
			return (Criteria) this;
		}

		public Criteria andOriginalPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("original_price between", value1, value2, "originalPrice");
			return (Criteria) this;
		}

		public Criteria andOriginalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("original_price not between", value1, value2, "originalPrice");
			return (Criteria) this;
		}

		public Criteria andGroupRebateAmountIsNull() {
			addCriterion("group_rebate_amount is null");
			return (Criteria) this;
		}

		public Criteria andGroupRebateAmountIsNotNull() {
			addCriterion("group_rebate_amount is not null");
			return (Criteria) this;
		}

		public Criteria andGroupRebateAmountEqualTo(BigDecimal value) {
			addCriterion("group_rebate_amount =", value, "groupRebateAmount");
			return (Criteria) this;
		}

		public Criteria andGroupRebateAmountNotEqualTo(BigDecimal value) {
			addCriterion("group_rebate_amount <>", value, "groupRebateAmount");
			return (Criteria) this;
		}

		public Criteria andGroupRebateAmountGreaterThan(BigDecimal value) {
			addCriterion("group_rebate_amount >", value, "groupRebateAmount");
			return (Criteria) this;
		}

		public Criteria andGroupRebateAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("group_rebate_amount >=", value, "groupRebateAmount");
			return (Criteria) this;
		}

		public Criteria andGroupRebateAmountLessThan(BigDecimal value) {
			addCriterion("group_rebate_amount <", value, "groupRebateAmount");
			return (Criteria) this;
		}

		public Criteria andGroupRebateAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("group_rebate_amount <=", value, "groupRebateAmount");
			return (Criteria) this;
		}

		public Criteria andGroupRebateAmountIn(List<BigDecimal> values) {
			addCriterion("group_rebate_amount in", values, "groupRebateAmount");
			return (Criteria) this;
		}

		public Criteria andGroupRebateAmountNotIn(List<BigDecimal> values) {
			addCriterion("group_rebate_amount not in", values, "groupRebateAmount");
			return (Criteria) this;
		}

		public Criteria andGroupRebateAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("group_rebate_amount between", value1, value2, "groupRebateAmount");
			return (Criteria) this;
		}

		public Criteria andGroupRebateAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("group_rebate_amount not between", value1, value2, "groupRebateAmount");
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