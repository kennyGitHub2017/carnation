package com.sinco.carnation.shop.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopQrPayOrderExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public ShopQrPayOrderExample() {
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

		public Criteria andSellerIdIsNull() {
			addCriterion("seller_id is null");
			return (Criteria) this;
		}

		public Criteria andSellerIdIsNotNull() {
			addCriterion("seller_id is not null");
			return (Criteria) this;
		}

		public Criteria andSellerIdEqualTo(Long value) {
			addCriterion("seller_id =", value, "sellerId");
			return (Criteria) this;
		}

		public Criteria andSellerIdNotEqualTo(Long value) {
			addCriterion("seller_id <>", value, "sellerId");
			return (Criteria) this;
		}

		public Criteria andSellerIdGreaterThan(Long value) {
			addCriterion("seller_id >", value, "sellerId");
			return (Criteria) this;
		}

		public Criteria andSellerIdGreaterThanOrEqualTo(Long value) {
			addCriterion("seller_id >=", value, "sellerId");
			return (Criteria) this;
		}

		public Criteria andSellerIdLessThan(Long value) {
			addCriterion("seller_id <", value, "sellerId");
			return (Criteria) this;
		}

		public Criteria andSellerIdLessThanOrEqualTo(Long value) {
			addCriterion("seller_id <=", value, "sellerId");
			return (Criteria) this;
		}

		public Criteria andSellerIdIn(List<Long> values) {
			addCriterion("seller_id in", values, "sellerId");
			return (Criteria) this;
		}

		public Criteria andSellerIdNotIn(List<Long> values) {
			addCriterion("seller_id not in", values, "sellerId");
			return (Criteria) this;
		}

		public Criteria andSellerIdBetween(Long value1, Long value2) {
			addCriterion("seller_id between", value1, value2, "sellerId");
			return (Criteria) this;
		}

		public Criteria andSellerIdNotBetween(Long value1, Long value2) {
			addCriterion("seller_id not between", value1, value2, "sellerId");
			return (Criteria) this;
		}

		public Criteria andPayOrderNoIsNull() {
			addCriterion("pay_order_no is null");
			return (Criteria) this;
		}

		public Criteria andPayOrderNoIsNotNull() {
			addCriterion("pay_order_no is not null");
			return (Criteria) this;
		}

		public Criteria andPayOrderNoEqualTo(String value) {
			addCriterion("pay_order_no =", value, "payOrderNo");
			return (Criteria) this;
		}

		public Criteria andPayOrderNoNotEqualTo(String value) {
			addCriterion("pay_order_no <>", value, "payOrderNo");
			return (Criteria) this;
		}

		public Criteria andPayOrderNoGreaterThan(String value) {
			addCriterion("pay_order_no >", value, "payOrderNo");
			return (Criteria) this;
		}

		public Criteria andPayOrderNoGreaterThanOrEqualTo(String value) {
			addCriterion("pay_order_no >=", value, "payOrderNo");
			return (Criteria) this;
		}

		public Criteria andPayOrderNoLessThan(String value) {
			addCriterion("pay_order_no <", value, "payOrderNo");
			return (Criteria) this;
		}

		public Criteria andPayOrderNoLessThanOrEqualTo(String value) {
			addCriterion("pay_order_no <=", value, "payOrderNo");
			return (Criteria) this;
		}

		public Criteria andPayOrderNoLike(String value) {
			addCriterion("pay_order_no like", value, "payOrderNo");
			return (Criteria) this;
		}

		public Criteria andPayOrderNoNotLike(String value) {
			addCriterion("pay_order_no not like", value, "payOrderNo");
			return (Criteria) this;
		}

		public Criteria andPayOrderNoIn(List<String> values) {
			addCriterion("pay_order_no in", values, "payOrderNo");
			return (Criteria) this;
		}

		public Criteria andPayOrderNoNotIn(List<String> values) {
			addCriterion("pay_order_no not in", values, "payOrderNo");
			return (Criteria) this;
		}

		public Criteria andPayOrderNoBetween(String value1, String value2) {
			addCriterion("pay_order_no between", value1, value2, "payOrderNo");
			return (Criteria) this;
		}

		public Criteria andPayOrderNoNotBetween(String value1, String value2) {
			addCriterion("pay_order_no not between", value1, value2, "payOrderNo");
			return (Criteria) this;
		}

		public Criteria andWxTransactionIdIsNull() {
			addCriterion("wx_transaction_id is null");
			return (Criteria) this;
		}

		public Criteria andWxTransactionIdIsNotNull() {
			addCriterion("wx_transaction_id is not null");
			return (Criteria) this;
		}

		public Criteria andWxTransactionIdEqualTo(String value) {
			addCriterion("wx_transaction_id =", value, "wxTransactionId");
			return (Criteria) this;
		}

		public Criteria andWxTransactionIdNotEqualTo(String value) {
			addCriterion("wx_transaction_id <>", value, "wxTransactionId");
			return (Criteria) this;
		}

		public Criteria andWxTransactionIdGreaterThan(String value) {
			addCriterion("wx_transaction_id >", value, "wxTransactionId");
			return (Criteria) this;
		}

		public Criteria andWxTransactionIdGreaterThanOrEqualTo(String value) {
			addCriterion("wx_transaction_id >=", value, "wxTransactionId");
			return (Criteria) this;
		}

		public Criteria andWxTransactionIdLessThan(String value) {
			addCriterion("wx_transaction_id <", value, "wxTransactionId");
			return (Criteria) this;
		}

		public Criteria andWxTransactionIdLessThanOrEqualTo(String value) {
			addCriterion("wx_transaction_id <=", value, "wxTransactionId");
			return (Criteria) this;
		}

		public Criteria andWxTransactionIdLike(String value) {
			addCriterion("wx_transaction_id like", value, "wxTransactionId");
			return (Criteria) this;
		}

		public Criteria andWxTransactionIdNotLike(String value) {
			addCriterion("wx_transaction_id not like", value, "wxTransactionId");
			return (Criteria) this;
		}

		public Criteria andWxTransactionIdIn(List<String> values) {
			addCriterion("wx_transaction_id in", values, "wxTransactionId");
			return (Criteria) this;
		}

		public Criteria andWxTransactionIdNotIn(List<String> values) {
			addCriterion("wx_transaction_id not in", values, "wxTransactionId");
			return (Criteria) this;
		}

		public Criteria andWxTransactionIdBetween(String value1, String value2) {
			addCriterion("wx_transaction_id between", value1, value2, "wxTransactionId");
			return (Criteria) this;
		}

		public Criteria andWxTransactionIdNotBetween(String value1, String value2) {
			addCriterion("wx_transaction_id not between", value1, value2, "wxTransactionId");
			return (Criteria) this;
		}

		public Criteria andTotalFeeIsNull() {
			addCriterion("total_fee is null");
			return (Criteria) this;
		}

		public Criteria andTotalFeeIsNotNull() {
			addCriterion("total_fee is not null");
			return (Criteria) this;
		}

		public Criteria andTotalFeeEqualTo(BigDecimal value) {
			addCriterion("total_fee =", value, "totalFee");
			return (Criteria) this;
		}

		public Criteria andTotalFeeNotEqualTo(BigDecimal value) {
			addCriterion("total_fee <>", value, "totalFee");
			return (Criteria) this;
		}

		public Criteria andTotalFeeGreaterThan(BigDecimal value) {
			addCriterion("total_fee >", value, "totalFee");
			return (Criteria) this;
		}

		public Criteria andTotalFeeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("total_fee >=", value, "totalFee");
			return (Criteria) this;
		}

		public Criteria andTotalFeeLessThan(BigDecimal value) {
			addCriterion("total_fee <", value, "totalFee");
			return (Criteria) this;
		}

		public Criteria andTotalFeeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("total_fee <=", value, "totalFee");
			return (Criteria) this;
		}

		public Criteria andTotalFeeIn(List<BigDecimal> values) {
			addCriterion("total_fee in", values, "totalFee");
			return (Criteria) this;
		}

		public Criteria andTotalFeeNotIn(List<BigDecimal> values) {
			addCriterion("total_fee not in", values, "totalFee");
			return (Criteria) this;
		}

		public Criteria andTotalFeeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("total_fee between", value1, value2, "totalFee");
			return (Criteria) this;
		}

		public Criteria andTotalFeeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("total_fee not between", value1, value2, "totalFee");
			return (Criteria) this;
		}

		public Criteria andPrepayIdIsNull() {
			addCriterion("prepay_id is null");
			return (Criteria) this;
		}

		public Criteria andPrepayIdIsNotNull() {
			addCriterion("prepay_id is not null");
			return (Criteria) this;
		}

		public Criteria andPrepayIdEqualTo(String value) {
			addCriterion("prepay_id =", value, "prepayId");
			return (Criteria) this;
		}

		public Criteria andPrepayIdNotEqualTo(String value) {
			addCriterion("prepay_id <>", value, "prepayId");
			return (Criteria) this;
		}

		public Criteria andPrepayIdGreaterThan(String value) {
			addCriterion("prepay_id >", value, "prepayId");
			return (Criteria) this;
		}

		public Criteria andPrepayIdGreaterThanOrEqualTo(String value) {
			addCriterion("prepay_id >=", value, "prepayId");
			return (Criteria) this;
		}

		public Criteria andPrepayIdLessThan(String value) {
			addCriterion("prepay_id <", value, "prepayId");
			return (Criteria) this;
		}

		public Criteria andPrepayIdLessThanOrEqualTo(String value) {
			addCriterion("prepay_id <=", value, "prepayId");
			return (Criteria) this;
		}

		public Criteria andPrepayIdLike(String value) {
			addCriterion("prepay_id like", value, "prepayId");
			return (Criteria) this;
		}

		public Criteria andPrepayIdNotLike(String value) {
			addCriterion("prepay_id not like", value, "prepayId");
			return (Criteria) this;
		}

		public Criteria andPrepayIdIn(List<String> values) {
			addCriterion("prepay_id in", values, "prepayId");
			return (Criteria) this;
		}

		public Criteria andPrepayIdNotIn(List<String> values) {
			addCriterion("prepay_id not in", values, "prepayId");
			return (Criteria) this;
		}

		public Criteria andPrepayIdBetween(String value1, String value2) {
			addCriterion("prepay_id between", value1, value2, "prepayId");
			return (Criteria) this;
		}

		public Criteria andPrepayIdNotBetween(String value1, String value2) {
			addCriterion("prepay_id not between", value1, value2, "prepayId");
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

		public Criteria andPayStatusIsNull() {
			addCriterion("pay_status is null");
			return (Criteria) this;
		}

		public Criteria andPayStatusIsNotNull() {
			addCriterion("pay_status is not null");
			return (Criteria) this;
		}

		public Criteria andPayStatusEqualTo(Byte value) {
			addCriterion("pay_status =", value, "payStatus");
			return (Criteria) this;
		}

		public Criteria andPayStatusNotEqualTo(Byte value) {
			addCriterion("pay_status <>", value, "payStatus");
			return (Criteria) this;
		}

		public Criteria andPayStatusGreaterThan(Byte value) {
			addCriterion("pay_status >", value, "payStatus");
			return (Criteria) this;
		}

		public Criteria andPayStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("pay_status >=", value, "payStatus");
			return (Criteria) this;
		}

		public Criteria andPayStatusLessThan(Byte value) {
			addCriterion("pay_status <", value, "payStatus");
			return (Criteria) this;
		}

		public Criteria andPayStatusLessThanOrEqualTo(Byte value) {
			addCriterion("pay_status <=", value, "payStatus");
			return (Criteria) this;
		}

		public Criteria andPayStatusIn(List<Byte> values) {
			addCriterion("pay_status in", values, "payStatus");
			return (Criteria) this;
		}

		public Criteria andPayStatusNotIn(List<Byte> values) {
			addCriterion("pay_status not in", values, "payStatus");
			return (Criteria) this;
		}

		public Criteria andPayStatusBetween(Byte value1, Byte value2) {
			addCriterion("pay_status between", value1, value2, "payStatus");
			return (Criteria) this;
		}

		public Criteria andPayStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("pay_status not between", value1, value2, "payStatus");
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

		public Criteria andModifyTimeIsNull() {
			addCriterion("modify_time is null");
			return (Criteria) this;
		}

		public Criteria andModifyTimeIsNotNull() {
			addCriterion("modify_time is not null");
			return (Criteria) this;
		}

		public Criteria andModifyTimeEqualTo(Date value) {
			addCriterion("modify_time =", value, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeNotEqualTo(Date value) {
			addCriterion("modify_time <>", value, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeGreaterThan(Date value) {
			addCriterion("modify_time >", value, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("modify_time >=", value, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeLessThan(Date value) {
			addCriterion("modify_time <", value, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
			addCriterion("modify_time <=", value, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeIn(List<Date> values) {
			addCriterion("modify_time in", values, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeNotIn(List<Date> values) {
			addCriterion("modify_time not in", values, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeBetween(Date value1, Date value2) {
			addCriterion("modify_time between", value1, value2, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
			addCriterion("modify_time not between", value1, value2, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andPaymentIdIsNull() {
			addCriterion("payment_id is null");
			return (Criteria) this;
		}

		public Criteria andPaymentIdIsNotNull() {
			addCriterion("payment_id is not null");
			return (Criteria) this;
		}

		public Criteria andPaymentIdEqualTo(Long value) {
			addCriterion("payment_id =", value, "paymentId");
			return (Criteria) this;
		}

		public Criteria andPaymentIdNotEqualTo(Long value) {
			addCriterion("payment_id <>", value, "paymentId");
			return (Criteria) this;
		}

		public Criteria andPaymentIdGreaterThan(Long value) {
			addCriterion("payment_id >", value, "paymentId");
			return (Criteria) this;
		}

		public Criteria andPaymentIdGreaterThanOrEqualTo(Long value) {
			addCriterion("payment_id >=", value, "paymentId");
			return (Criteria) this;
		}

		public Criteria andPaymentIdLessThan(Long value) {
			addCriterion("payment_id <", value, "paymentId");
			return (Criteria) this;
		}

		public Criteria andPaymentIdLessThanOrEqualTo(Long value) {
			addCriterion("payment_id <=", value, "paymentId");
			return (Criteria) this;
		}

		public Criteria andPaymentIdIn(List<Long> values) {
			addCriterion("payment_id in", values, "paymentId");
			return (Criteria) this;
		}

		public Criteria andPaymentIdNotIn(List<Long> values) {
			addCriterion("payment_id not in", values, "paymentId");
			return (Criteria) this;
		}

		public Criteria andPaymentIdBetween(Long value1, Long value2) {
			addCriterion("payment_id between", value1, value2, "paymentId");
			return (Criteria) this;
		}

		public Criteria andPaymentIdNotBetween(Long value1, Long value2) {
			addCriterion("payment_id not between", value1, value2, "paymentId");
			return (Criteria) this;
		}

		public Criteria andPaymentTypeIsNull() {
			addCriterion("payment_type is null");
			return (Criteria) this;
		}

		public Criteria andPaymentTypeIsNotNull() {
			addCriterion("payment_type is not null");
			return (Criteria) this;
		}

		public Criteria andPaymentTypeEqualTo(Byte value) {
			addCriterion("payment_type =", value, "paymentType");
			return (Criteria) this;
		}

		public Criteria andPaymentTypeNotEqualTo(Byte value) {
			addCriterion("payment_type <>", value, "paymentType");
			return (Criteria) this;
		}

		public Criteria andPaymentTypeGreaterThan(Byte value) {
			addCriterion("payment_type >", value, "paymentType");
			return (Criteria) this;
		}

		public Criteria andPaymentTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("payment_type >=", value, "paymentType");
			return (Criteria) this;
		}

		public Criteria andPaymentTypeLessThan(Byte value) {
			addCriterion("payment_type <", value, "paymentType");
			return (Criteria) this;
		}

		public Criteria andPaymentTypeLessThanOrEqualTo(Byte value) {
			addCriterion("payment_type <=", value, "paymentType");
			return (Criteria) this;
		}

		public Criteria andPaymentTypeIn(List<Byte> values) {
			addCriterion("payment_type in", values, "paymentType");
			return (Criteria) this;
		}

		public Criteria andPaymentTypeNotIn(List<Byte> values) {
			addCriterion("payment_type not in", values, "paymentType");
			return (Criteria) this;
		}

		public Criteria andPaymentTypeBetween(Byte value1, Byte value2) {
			addCriterion("payment_type between", value1, value2, "paymentType");
			return (Criteria) this;
		}

		public Criteria andPaymentTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("payment_type not between", value1, value2, "paymentType");
			return (Criteria) this;
		}

		public Criteria andPhoneIsNull() {
			addCriterion("phone is null");
			return (Criteria) this;
		}

		public Criteria andPhoneIsNotNull() {
			addCriterion("phone is not null");
			return (Criteria) this;
		}

		public Criteria andPhoneEqualTo(String value) {
			addCriterion("phone =", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotEqualTo(String value) {
			addCriterion("phone <>", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneGreaterThan(String value) {
			addCriterion("phone >", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("phone >=", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneLessThan(String value) {
			addCriterion("phone <", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneLessThanOrEqualTo(String value) {
			addCriterion("phone <=", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneLike(String value) {
			addCriterion("phone like", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotLike(String value) {
			addCriterion("phone not like", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneIn(List<String> values) {
			addCriterion("phone in", values, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotIn(List<String> values) {
			addCriterion("phone not in", values, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneBetween(String value1, String value2) {
			addCriterion("phone between", value1, value2, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotBetween(String value1, String value2) {
			addCriterion("phone not between", value1, value2, "phone");
			return (Criteria) this;
		}

		public Criteria andServerNameIsNull() {
			addCriterion("server_name is null");
			return (Criteria) this;
		}

		public Criteria andServerNameIsNotNull() {
			addCriterion("server_name is not null");
			return (Criteria) this;
		}

		public Criteria andServerNameEqualTo(String value) {
			addCriterion("server_name =", value, "serverName");
			return (Criteria) this;
		}

		public Criteria andServerNameNotEqualTo(String value) {
			addCriterion("server_name <>", value, "serverName");
			return (Criteria) this;
		}

		public Criteria andServerNameGreaterThan(String value) {
			addCriterion("server_name >", value, "serverName");
			return (Criteria) this;
		}

		public Criteria andServerNameGreaterThanOrEqualTo(String value) {
			addCriterion("server_name >=", value, "serverName");
			return (Criteria) this;
		}

		public Criteria andServerNameLessThan(String value) {
			addCriterion("server_name <", value, "serverName");
			return (Criteria) this;
		}

		public Criteria andServerNameLessThanOrEqualTo(String value) {
			addCriterion("server_name <=", value, "serverName");
			return (Criteria) this;
		}

		public Criteria andServerNameLike(String value) {
			addCriterion("server_name like", value, "serverName");
			return (Criteria) this;
		}

		public Criteria andServerNameNotLike(String value) {
			addCriterion("server_name not like", value, "serverName");
			return (Criteria) this;
		}

		public Criteria andServerNameIn(List<String> values) {
			addCriterion("server_name in", values, "serverName");
			return (Criteria) this;
		}

		public Criteria andServerNameNotIn(List<String> values) {
			addCriterion("server_name not in", values, "serverName");
			return (Criteria) this;
		}

		public Criteria andServerNameBetween(String value1, String value2) {
			addCriterion("server_name between", value1, value2, "serverName");
			return (Criteria) this;
		}

		public Criteria andServerNameNotBetween(String value1, String value2) {
			addCriterion("server_name not between", value1, value2, "serverName");
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