package com.sinco.carnation.shop.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderFormExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public OrderFormExample() {
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

		public Criteria andAutoConfirmEmailIsNull() {
			addCriterion("auto_confirm_email is null");
			return (Criteria) this;
		}

		public Criteria andAutoConfirmEmailIsNotNull() {
			addCriterion("auto_confirm_email is not null");
			return (Criteria) this;
		}

		public Criteria andAutoConfirmEmailEqualTo(Boolean value) {
			addCriterion("auto_confirm_email =", value, "autoConfirmEmail");
			return (Criteria) this;
		}

		public Criteria andAutoConfirmEmailNotEqualTo(Boolean value) {
			addCriterion("auto_confirm_email <>", value, "autoConfirmEmail");
			return (Criteria) this;
		}

		public Criteria andAutoConfirmEmailGreaterThan(Boolean value) {
			addCriterion("auto_confirm_email >", value, "autoConfirmEmail");
			return (Criteria) this;
		}

		public Criteria andAutoConfirmEmailGreaterThanOrEqualTo(Boolean value) {
			addCriterion("auto_confirm_email >=", value, "autoConfirmEmail");
			return (Criteria) this;
		}

		public Criteria andAutoConfirmEmailLessThan(Boolean value) {
			addCriterion("auto_confirm_email <", value, "autoConfirmEmail");
			return (Criteria) this;
		}

		public Criteria andAutoConfirmEmailLessThanOrEqualTo(Boolean value) {
			addCriterion("auto_confirm_email <=", value, "autoConfirmEmail");
			return (Criteria) this;
		}

		public Criteria andAutoConfirmEmailIn(List<Boolean> values) {
			addCriterion("auto_confirm_email in", values, "autoConfirmEmail");
			return (Criteria) this;
		}

		public Criteria andAutoConfirmEmailNotIn(List<Boolean> values) {
			addCriterion("auto_confirm_email not in", values, "autoConfirmEmail");
			return (Criteria) this;
		}

		public Criteria andAutoConfirmEmailBetween(Boolean value1, Boolean value2) {
			addCriterion("auto_confirm_email between", value1, value2, "autoConfirmEmail");
			return (Criteria) this;
		}

		public Criteria andAutoConfirmEmailNotBetween(Boolean value1, Boolean value2) {
			addCriterion("auto_confirm_email not between", value1, value2, "autoConfirmEmail");
			return (Criteria) this;
		}

		public Criteria andAutoConfirmSmsIsNull() {
			addCriterion("auto_confirm_sms is null");
			return (Criteria) this;
		}

		public Criteria andAutoConfirmSmsIsNotNull() {
			addCriterion("auto_confirm_sms is not null");
			return (Criteria) this;
		}

		public Criteria andAutoConfirmSmsEqualTo(Boolean value) {
			addCriterion("auto_confirm_sms =", value, "autoConfirmSms");
			return (Criteria) this;
		}

		public Criteria andAutoConfirmSmsNotEqualTo(Boolean value) {
			addCriterion("auto_confirm_sms <>", value, "autoConfirmSms");
			return (Criteria) this;
		}

		public Criteria andAutoConfirmSmsGreaterThan(Boolean value) {
			addCriterion("auto_confirm_sms >", value, "autoConfirmSms");
			return (Criteria) this;
		}

		public Criteria andAutoConfirmSmsGreaterThanOrEqualTo(Boolean value) {
			addCriterion("auto_confirm_sms >=", value, "autoConfirmSms");
			return (Criteria) this;
		}

		public Criteria andAutoConfirmSmsLessThan(Boolean value) {
			addCriterion("auto_confirm_sms <", value, "autoConfirmSms");
			return (Criteria) this;
		}

		public Criteria andAutoConfirmSmsLessThanOrEqualTo(Boolean value) {
			addCriterion("auto_confirm_sms <=", value, "autoConfirmSms");
			return (Criteria) this;
		}

		public Criteria andAutoConfirmSmsIn(List<Boolean> values) {
			addCriterion("auto_confirm_sms in", values, "autoConfirmSms");
			return (Criteria) this;
		}

		public Criteria andAutoConfirmSmsNotIn(List<Boolean> values) {
			addCriterion("auto_confirm_sms not in", values, "autoConfirmSms");
			return (Criteria) this;
		}

		public Criteria andAutoConfirmSmsBetween(Boolean value1, Boolean value2) {
			addCriterion("auto_confirm_sms between", value1, value2, "autoConfirmSms");
			return (Criteria) this;
		}

		public Criteria andAutoConfirmSmsNotBetween(Boolean value1, Boolean value2) {
			addCriterion("auto_confirm_sms not between", value1, value2, "autoConfirmSms");
			return (Criteria) this;
		}

		public Criteria andCommissionAmountIsNull() {
			addCriterion("commission_amount is null");
			return (Criteria) this;
		}

		public Criteria andCommissionAmountIsNotNull() {
			addCriterion("commission_amount is not null");
			return (Criteria) this;
		}

		public Criteria andCommissionAmountEqualTo(BigDecimal value) {
			addCriterion("commission_amount =", value, "commissionAmount");
			return (Criteria) this;
		}

		public Criteria andCommissionAmountNotEqualTo(BigDecimal value) {
			addCriterion("commission_amount <>", value, "commissionAmount");
			return (Criteria) this;
		}

		public Criteria andCommissionAmountGreaterThan(BigDecimal value) {
			addCriterion("commission_amount >", value, "commissionAmount");
			return (Criteria) this;
		}

		public Criteria andCommissionAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("commission_amount >=", value, "commissionAmount");
			return (Criteria) this;
		}

		public Criteria andCommissionAmountLessThan(BigDecimal value) {
			addCriterion("commission_amount <", value, "commissionAmount");
			return (Criteria) this;
		}

		public Criteria andCommissionAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("commission_amount <=", value, "commissionAmount");
			return (Criteria) this;
		}

		public Criteria andCommissionAmountIn(List<BigDecimal> values) {
			addCriterion("commission_amount in", values, "commissionAmount");
			return (Criteria) this;
		}

		public Criteria andCommissionAmountNotIn(List<BigDecimal> values) {
			addCriterion("commission_amount not in", values, "commissionAmount");
			return (Criteria) this;
		}

		public Criteria andCommissionAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("commission_amount between", value1, value2, "commissionAmount");
			return (Criteria) this;
		}

		public Criteria andCommissionAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("commission_amount not between", value1, value2, "commissionAmount");
			return (Criteria) this;
		}

		public Criteria andConfirmTimeIsNull() {
			addCriterion("confirm_time is null");
			return (Criteria) this;
		}

		public Criteria andConfirmTimeIsNotNull() {
			addCriterion("confirm_time is not null");
			return (Criteria) this;
		}

		public Criteria andConfirmTimeEqualTo(Date value) {
			addCriterion("confirm_time =", value, "confirmTime");
			return (Criteria) this;
		}

		public Criteria andConfirmTimeNotEqualTo(Date value) {
			addCriterion("confirm_time <>", value, "confirmTime");
			return (Criteria) this;
		}

		public Criteria andConfirmTimeGreaterThan(Date value) {
			addCriterion("confirm_time >", value, "confirmTime");
			return (Criteria) this;
		}

		public Criteria andConfirmTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("confirm_time >=", value, "confirmTime");
			return (Criteria) this;
		}

		public Criteria andConfirmTimeLessThan(Date value) {
			addCriterion("confirm_time <", value, "confirmTime");
			return (Criteria) this;
		}

		public Criteria andConfirmTimeLessThanOrEqualTo(Date value) {
			addCriterion("confirm_time <=", value, "confirmTime");
			return (Criteria) this;
		}

		public Criteria andConfirmTimeIn(List<Date> values) {
			addCriterion("confirm_time in", values, "confirmTime");
			return (Criteria) this;
		}

		public Criteria andConfirmTimeNotIn(List<Date> values) {
			addCriterion("confirm_time not in", values, "confirmTime");
			return (Criteria) this;
		}

		public Criteria andConfirmTimeBetween(Date value1, Date value2) {
			addCriterion("confirm_time between", value1, value2, "confirmTime");
			return (Criteria) this;
		}

		public Criteria andConfirmTimeNotBetween(Date value1, Date value2) {
			addCriterion("confirm_time not between", value1, value2, "confirmTime");
			return (Criteria) this;
		}

		public Criteria andDeliveryAddressIdIsNull() {
			addCriterion("delivery_address_id is null");
			return (Criteria) this;
		}

		public Criteria andDeliveryAddressIdIsNotNull() {
			addCriterion("delivery_address_id is not null");
			return (Criteria) this;
		}

		public Criteria andDeliveryAddressIdEqualTo(Long value) {
			addCriterion("delivery_address_id =", value, "deliveryAddressId");
			return (Criteria) this;
		}

		public Criteria andDeliveryAddressIdNotEqualTo(Long value) {
			addCriterion("delivery_address_id <>", value, "deliveryAddressId");
			return (Criteria) this;
		}

		public Criteria andDeliveryAddressIdGreaterThan(Long value) {
			addCriterion("delivery_address_id >", value, "deliveryAddressId");
			return (Criteria) this;
		}

		public Criteria andDeliveryAddressIdGreaterThanOrEqualTo(Long value) {
			addCriterion("delivery_address_id >=", value, "deliveryAddressId");
			return (Criteria) this;
		}

		public Criteria andDeliveryAddressIdLessThan(Long value) {
			addCriterion("delivery_address_id <", value, "deliveryAddressId");
			return (Criteria) this;
		}

		public Criteria andDeliveryAddressIdLessThanOrEqualTo(Long value) {
			addCriterion("delivery_address_id <=", value, "deliveryAddressId");
			return (Criteria) this;
		}

		public Criteria andDeliveryAddressIdIn(List<Long> values) {
			addCriterion("delivery_address_id in", values, "deliveryAddressId");
			return (Criteria) this;
		}

		public Criteria andDeliveryAddressIdNotIn(List<Long> values) {
			addCriterion("delivery_address_id not in", values, "deliveryAddressId");
			return (Criteria) this;
		}

		public Criteria andDeliveryAddressIdBetween(Long value1, Long value2) {
			addCriterion("delivery_address_id between", value1, value2, "deliveryAddressId");
			return (Criteria) this;
		}

		public Criteria andDeliveryAddressIdNotBetween(Long value1, Long value2) {
			addCriterion("delivery_address_id not between", value1, value2, "deliveryAddressId");
			return (Criteria) this;
		}

		public Criteria andDeliveryTimeIsNull() {
			addCriterion("delivery_time is null");
			return (Criteria) this;
		}

		public Criteria andDeliveryTimeIsNotNull() {
			addCriterion("delivery_time is not null");
			return (Criteria) this;
		}

		public Criteria andDeliveryTimeEqualTo(String value) {
			addCriterion("delivery_time =", value, "deliveryTime");
			return (Criteria) this;
		}

		public Criteria andDeliveryTimeNotEqualTo(String value) {
			addCriterion("delivery_time <>", value, "deliveryTime");
			return (Criteria) this;
		}

		public Criteria andDeliveryTimeGreaterThan(String value) {
			addCriterion("delivery_time >", value, "deliveryTime");
			return (Criteria) this;
		}

		public Criteria andDeliveryTimeGreaterThanOrEqualTo(String value) {
			addCriterion("delivery_time >=", value, "deliveryTime");
			return (Criteria) this;
		}

		public Criteria andDeliveryTimeLessThan(String value) {
			addCriterion("delivery_time <", value, "deliveryTime");
			return (Criteria) this;
		}

		public Criteria andDeliveryTimeLessThanOrEqualTo(String value) {
			addCriterion("delivery_time <=", value, "deliveryTime");
			return (Criteria) this;
		}

		public Criteria andDeliveryTimeLike(String value) {
			addCriterion("delivery_time like", value, "deliveryTime");
			return (Criteria) this;
		}

		public Criteria andDeliveryTimeNotLike(String value) {
			addCriterion("delivery_time not like", value, "deliveryTime");
			return (Criteria) this;
		}

		public Criteria andDeliveryTimeIn(List<String> values) {
			addCriterion("delivery_time in", values, "deliveryTime");
			return (Criteria) this;
		}

		public Criteria andDeliveryTimeNotIn(List<String> values) {
			addCriterion("delivery_time not in", values, "deliveryTime");
			return (Criteria) this;
		}

		public Criteria andDeliveryTimeBetween(String value1, String value2) {
			addCriterion("delivery_time between", value1, value2, "deliveryTime");
			return (Criteria) this;
		}

		public Criteria andDeliveryTimeNotBetween(String value1, String value2) {
			addCriterion("delivery_time not between", value1, value2, "deliveryTime");
			return (Criteria) this;
		}

		public Criteria andDeliveryTypeIsNull() {
			addCriterion("delivery_type is null");
			return (Criteria) this;
		}

		public Criteria andDeliveryTypeIsNotNull() {
			addCriterion("delivery_type is not null");
			return (Criteria) this;
		}

		public Criteria andDeliveryTypeEqualTo(Integer value) {
			addCriterion("delivery_type =", value, "deliveryType");
			return (Criteria) this;
		}

		public Criteria andDeliveryTypeNotEqualTo(Integer value) {
			addCriterion("delivery_type <>", value, "deliveryType");
			return (Criteria) this;
		}

		public Criteria andDeliveryTypeGreaterThan(Integer value) {
			addCriterion("delivery_type >", value, "deliveryType");
			return (Criteria) this;
		}

		public Criteria andDeliveryTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("delivery_type >=", value, "deliveryType");
			return (Criteria) this;
		}

		public Criteria andDeliveryTypeLessThan(Integer value) {
			addCriterion("delivery_type <", value, "deliveryType");
			return (Criteria) this;
		}

		public Criteria andDeliveryTypeLessThanOrEqualTo(Integer value) {
			addCriterion("delivery_type <=", value, "deliveryType");
			return (Criteria) this;
		}

		public Criteria andDeliveryTypeIn(List<Integer> values) {
			addCriterion("delivery_type in", values, "deliveryType");
			return (Criteria) this;
		}

		public Criteria andDeliveryTypeNotIn(List<Integer> values) {
			addCriterion("delivery_type not in", values, "deliveryType");
			return (Criteria) this;
		}

		public Criteria andDeliveryTypeBetween(Integer value1, Integer value2) {
			addCriterion("delivery_type between", value1, value2, "deliveryType");
			return (Criteria) this;
		}

		public Criteria andDeliveryTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("delivery_type not between", value1, value2, "deliveryType");
			return (Criteria) this;
		}

		public Criteria andEnoughReduceAmountIsNull() {
			addCriterion("enough_reduce_amount is null");
			return (Criteria) this;
		}

		public Criteria andEnoughReduceAmountIsNotNull() {
			addCriterion("enough_reduce_amount is not null");
			return (Criteria) this;
		}

		public Criteria andEnoughReduceAmountEqualTo(BigDecimal value) {
			addCriterion("enough_reduce_amount =", value, "enoughReduceAmount");
			return (Criteria) this;
		}

		public Criteria andEnoughReduceAmountNotEqualTo(BigDecimal value) {
			addCriterion("enough_reduce_amount <>", value, "enoughReduceAmount");
			return (Criteria) this;
		}

		public Criteria andEnoughReduceAmountGreaterThan(BigDecimal value) {
			addCriterion("enough_reduce_amount >", value, "enoughReduceAmount");
			return (Criteria) this;
		}

		public Criteria andEnoughReduceAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("enough_reduce_amount >=", value, "enoughReduceAmount");
			return (Criteria) this;
		}

		public Criteria andEnoughReduceAmountLessThan(BigDecimal value) {
			addCriterion("enough_reduce_amount <", value, "enoughReduceAmount");
			return (Criteria) this;
		}

		public Criteria andEnoughReduceAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("enough_reduce_amount <=", value, "enoughReduceAmount");
			return (Criteria) this;
		}

		public Criteria andEnoughReduceAmountIn(List<BigDecimal> values) {
			addCriterion("enough_reduce_amount in", values, "enoughReduceAmount");
			return (Criteria) this;
		}

		public Criteria andEnoughReduceAmountNotIn(List<BigDecimal> values) {
			addCriterion("enough_reduce_amount not in", values, "enoughReduceAmount");
			return (Criteria) this;
		}

		public Criteria andEnoughReduceAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("enough_reduce_amount between", value1, value2, "enoughReduceAmount");
			return (Criteria) this;
		}

		public Criteria andEnoughReduceAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("enough_reduce_amount not between", value1, value2, "enoughReduceAmount");
			return (Criteria) this;
		}

		public Criteria andEvaUserIdIsNull() {
			addCriterion("eva_user_id is null");
			return (Criteria) this;
		}

		public Criteria andEvaUserIdIsNotNull() {
			addCriterion("eva_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andEvaUserIdEqualTo(Long value) {
			addCriterion("eva_user_id =", value, "evaUserId");
			return (Criteria) this;
		}

		public Criteria andEvaUserIdNotEqualTo(Long value) {
			addCriterion("eva_user_id <>", value, "evaUserId");
			return (Criteria) this;
		}

		public Criteria andEvaUserIdGreaterThan(Long value) {
			addCriterion("eva_user_id >", value, "evaUserId");
			return (Criteria) this;
		}

		public Criteria andEvaUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("eva_user_id >=", value, "evaUserId");
			return (Criteria) this;
		}

		public Criteria andEvaUserIdLessThan(Long value) {
			addCriterion("eva_user_id <", value, "evaUserId");
			return (Criteria) this;
		}

		public Criteria andEvaUserIdLessThanOrEqualTo(Long value) {
			addCriterion("eva_user_id <=", value, "evaUserId");
			return (Criteria) this;
		}

		public Criteria andEvaUserIdIn(List<Long> values) {
			addCriterion("eva_user_id in", values, "evaUserId");
			return (Criteria) this;
		}

		public Criteria andEvaUserIdNotIn(List<Long> values) {
			addCriterion("eva_user_id not in", values, "evaUserId");
			return (Criteria) this;
		}

		public Criteria andEvaUserIdBetween(Long value1, Long value2) {
			addCriterion("eva_user_id between", value1, value2, "evaUserId");
			return (Criteria) this;
		}

		public Criteria andEvaUserIdNotBetween(Long value1, Long value2) {
			addCriterion("eva_user_id not between", value1, value2, "evaUserId");
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

		public Criteria andInvoiceIsNull() {
			addCriterion("invoice is null");
			return (Criteria) this;
		}

		public Criteria andInvoiceIsNotNull() {
			addCriterion("invoice is not null");
			return (Criteria) this;
		}

		public Criteria andInvoiceEqualTo(String value) {
			addCriterion("invoice =", value, "invoice");
			return (Criteria) this;
		}

		public Criteria andInvoiceNotEqualTo(String value) {
			addCriterion("invoice <>", value, "invoice");
			return (Criteria) this;
		}

		public Criteria andInvoiceGreaterThan(String value) {
			addCriterion("invoice >", value, "invoice");
			return (Criteria) this;
		}

		public Criteria andInvoiceGreaterThanOrEqualTo(String value) {
			addCriterion("invoice >=", value, "invoice");
			return (Criteria) this;
		}

		public Criteria andInvoiceLessThan(String value) {
			addCriterion("invoice <", value, "invoice");
			return (Criteria) this;
		}

		public Criteria andInvoiceLessThanOrEqualTo(String value) {
			addCriterion("invoice <=", value, "invoice");
			return (Criteria) this;
		}

		public Criteria andInvoiceLike(String value) {
			addCriterion("invoice like", value, "invoice");
			return (Criteria) this;
		}

		public Criteria andInvoiceNotLike(String value) {
			addCriterion("invoice not like", value, "invoice");
			return (Criteria) this;
		}

		public Criteria andInvoiceIn(List<String> values) {
			addCriterion("invoice in", values, "invoice");
			return (Criteria) this;
		}

		public Criteria andInvoiceNotIn(List<String> values) {
			addCriterion("invoice not in", values, "invoice");
			return (Criteria) this;
		}

		public Criteria andInvoiceBetween(String value1, String value2) {
			addCriterion("invoice between", value1, value2, "invoice");
			return (Criteria) this;
		}

		public Criteria andInvoiceNotBetween(String value1, String value2) {
			addCriterion("invoice not between", value1, value2, "invoice");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeIsNull() {
			addCriterion("invoice_type is null");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeIsNotNull() {
			addCriterion("invoice_type is not null");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeEqualTo(Integer value) {
			addCriterion("invoice_type =", value, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeNotEqualTo(Integer value) {
			addCriterion("invoice_type <>", value, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeGreaterThan(Integer value) {
			addCriterion("invoice_type >", value, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("invoice_type >=", value, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeLessThan(Integer value) {
			addCriterion("invoice_type <", value, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeLessThanOrEqualTo(Integer value) {
			addCriterion("invoice_type <=", value, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeIn(List<Integer> values) {
			addCriterion("invoice_type in", values, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeNotIn(List<Integer> values) {
			addCriterion("invoice_type not in", values, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeBetween(Integer value1, Integer value2) {
			addCriterion("invoice_type between", value1, value2, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andInvoiceTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("invoice_type not between", value1, value2, "invoiceType");
			return (Criteria) this;
		}

		public Criteria andOperationPriceCountIsNull() {
			addCriterion("operation_price_count is null");
			return (Criteria) this;
		}

		public Criteria andOperationPriceCountIsNotNull() {
			addCriterion("operation_price_count is not null");
			return (Criteria) this;
		}

		public Criteria andOperationPriceCountEqualTo(Integer value) {
			addCriterion("operation_price_count =", value, "operationPriceCount");
			return (Criteria) this;
		}

		public Criteria andOperationPriceCountNotEqualTo(Integer value) {
			addCriterion("operation_price_count <>", value, "operationPriceCount");
			return (Criteria) this;
		}

		public Criteria andOperationPriceCountGreaterThan(Integer value) {
			addCriterion("operation_price_count >", value, "operationPriceCount");
			return (Criteria) this;
		}

		public Criteria andOperationPriceCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("operation_price_count >=", value, "operationPriceCount");
			return (Criteria) this;
		}

		public Criteria andOperationPriceCountLessThan(Integer value) {
			addCriterion("operation_price_count <", value, "operationPriceCount");
			return (Criteria) this;
		}

		public Criteria andOperationPriceCountLessThanOrEqualTo(Integer value) {
			addCriterion("operation_price_count <=", value, "operationPriceCount");
			return (Criteria) this;
		}

		public Criteria andOperationPriceCountIn(List<Integer> values) {
			addCriterion("operation_price_count in", values, "operationPriceCount");
			return (Criteria) this;
		}

		public Criteria andOperationPriceCountNotIn(List<Integer> values) {
			addCriterion("operation_price_count not in", values, "operationPriceCount");
			return (Criteria) this;
		}

		public Criteria andOperationPriceCountBetween(Integer value1, Integer value2) {
			addCriterion("operation_price_count between", value1, value2, "operationPriceCount");
			return (Criteria) this;
		}

		public Criteria andOperationPriceCountNotBetween(Integer value1, Integer value2) {
			addCriterion("operation_price_count not between", value1, value2, "operationPriceCount");
			return (Criteria) this;
		}

		public Criteria andOrderCatIsNull() {
			addCriterion("order_cat is null");
			return (Criteria) this;
		}

		public Criteria andOrderCatIsNotNull() {
			addCriterion("order_cat is not null");
			return (Criteria) this;
		}

		public Criteria andOrderCatEqualTo(Integer value) {
			addCriterion("order_cat =", value, "orderCat");
			return (Criteria) this;
		}

		public Criteria andOrderCatNotEqualTo(Integer value) {
			addCriterion("order_cat <>", value, "orderCat");
			return (Criteria) this;
		}

		public Criteria andOrderCatGreaterThan(Integer value) {
			addCriterion("order_cat >", value, "orderCat");
			return (Criteria) this;
		}

		public Criteria andOrderCatGreaterThanOrEqualTo(Integer value) {
			addCriterion("order_cat >=", value, "orderCat");
			return (Criteria) this;
		}

		public Criteria andOrderCatLessThan(Integer value) {
			addCriterion("order_cat <", value, "orderCat");
			return (Criteria) this;
		}

		public Criteria andOrderCatLessThanOrEqualTo(Integer value) {
			addCriterion("order_cat <=", value, "orderCat");
			return (Criteria) this;
		}

		public Criteria andOrderCatIn(List<Integer> values) {
			addCriterion("order_cat in", values, "orderCat");
			return (Criteria) this;
		}

		public Criteria andOrderCatNotIn(List<Integer> values) {
			addCriterion("order_cat not in", values, "orderCat");
			return (Criteria) this;
		}

		public Criteria andOrderCatBetween(Integer value1, Integer value2) {
			addCriterion("order_cat between", value1, value2, "orderCat");
			return (Criteria) this;
		}

		public Criteria andOrderCatNotBetween(Integer value1, Integer value2) {
			addCriterion("order_cat not between", value1, value2, "orderCat");
			return (Criteria) this;
		}

		public Criteria andOrderConfirmDelayIsNull() {
			addCriterion("order_confirm_delay is null");
			return (Criteria) this;
		}

		public Criteria andOrderConfirmDelayIsNotNull() {
			addCriterion("order_confirm_delay is not null");
			return (Criteria) this;
		}

		public Criteria andOrderConfirmDelayEqualTo(Integer value) {
			addCriterion("order_confirm_delay =", value, "orderConfirmDelay");
			return (Criteria) this;
		}

		public Criteria andOrderConfirmDelayNotEqualTo(Integer value) {
			addCriterion("order_confirm_delay <>", value, "orderConfirmDelay");
			return (Criteria) this;
		}

		public Criteria andOrderConfirmDelayGreaterThan(Integer value) {
			addCriterion("order_confirm_delay >", value, "orderConfirmDelay");
			return (Criteria) this;
		}

		public Criteria andOrderConfirmDelayGreaterThanOrEqualTo(Integer value) {
			addCriterion("order_confirm_delay >=", value, "orderConfirmDelay");
			return (Criteria) this;
		}

		public Criteria andOrderConfirmDelayLessThan(Integer value) {
			addCriterion("order_confirm_delay <", value, "orderConfirmDelay");
			return (Criteria) this;
		}

		public Criteria andOrderConfirmDelayLessThanOrEqualTo(Integer value) {
			addCriterion("order_confirm_delay <=", value, "orderConfirmDelay");
			return (Criteria) this;
		}

		public Criteria andOrderConfirmDelayIn(List<Integer> values) {
			addCriterion("order_confirm_delay in", values, "orderConfirmDelay");
			return (Criteria) this;
		}

		public Criteria andOrderConfirmDelayNotIn(List<Integer> values) {
			addCriterion("order_confirm_delay not in", values, "orderConfirmDelay");
			return (Criteria) this;
		}

		public Criteria andOrderConfirmDelayBetween(Integer value1, Integer value2) {
			addCriterion("order_confirm_delay between", value1, value2, "orderConfirmDelay");
			return (Criteria) this;
		}

		public Criteria andOrderConfirmDelayNotBetween(Integer value1, Integer value2) {
			addCriterion("order_confirm_delay not between", value1, value2, "orderConfirmDelay");
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

		public Criteria andOrderMainIsNull() {
			addCriterion("order_main is null");
			return (Criteria) this;
		}

		public Criteria andOrderMainIsNotNull() {
			addCriterion("order_main is not null");
			return (Criteria) this;
		}

		public Criteria andOrderMainEqualTo(Integer value) {
			addCriterion("order_main =", value, "orderMain");
			return (Criteria) this;
		}

		public Criteria andOrderMainNotEqualTo(Integer value) {
			addCriterion("order_main <>", value, "orderMain");
			return (Criteria) this;
		}

		public Criteria andOrderMainGreaterThan(Integer value) {
			addCriterion("order_main >", value, "orderMain");
			return (Criteria) this;
		}

		public Criteria andOrderMainGreaterThanOrEqualTo(Integer value) {
			addCriterion("order_main >=", value, "orderMain");
			return (Criteria) this;
		}

		public Criteria andOrderMainLessThan(Integer value) {
			addCriterion("order_main <", value, "orderMain");
			return (Criteria) this;
		}

		public Criteria andOrderMainLessThanOrEqualTo(Integer value) {
			addCriterion("order_main <=", value, "orderMain");
			return (Criteria) this;
		}

		public Criteria andOrderMainIn(List<Integer> values) {
			addCriterion("order_main in", values, "orderMain");
			return (Criteria) this;
		}

		public Criteria andOrderMainNotIn(List<Integer> values) {
			addCriterion("order_main not in", values, "orderMain");
			return (Criteria) this;
		}

		public Criteria andOrderMainBetween(Integer value1, Integer value2) {
			addCriterion("order_main between", value1, value2, "orderMain");
			return (Criteria) this;
		}

		public Criteria andOrderMainNotBetween(Integer value1, Integer value2) {
			addCriterion("order_main not between", value1, value2, "orderMain");
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

		public Criteria andOrderTypeIsNull() {
			addCriterion("order_type is null");
			return (Criteria) this;
		}

		public Criteria andOrderTypeIsNotNull() {
			addCriterion("order_type is not null");
			return (Criteria) this;
		}

		public Criteria andOrderTypeEqualTo(String value) {
			addCriterion("order_type =", value, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeNotEqualTo(String value) {
			addCriterion("order_type <>", value, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeGreaterThan(String value) {
			addCriterion("order_type >", value, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeGreaterThanOrEqualTo(String value) {
			addCriterion("order_type >=", value, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeLessThan(String value) {
			addCriterion("order_type <", value, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeLessThanOrEqualTo(String value) {
			addCriterion("order_type <=", value, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeLike(String value) {
			addCriterion("order_type like", value, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeNotLike(String value) {
			addCriterion("order_type not like", value, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeIn(List<String> values) {
			addCriterion("order_type in", values, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeNotIn(List<String> values) {
			addCriterion("order_type not in", values, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeBetween(String value1, String value2) {
			addCriterion("order_type between", value1, value2, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeNotBetween(String value1, String value2) {
			addCriterion("order_type not between", value1, value2, "orderType");
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

		public Criteria andOutPriceIsNull() {
			addCriterion("out_price is null");
			return (Criteria) this;
		}

		public Criteria andOutPriceIsNotNull() {
			addCriterion("out_price is not null");
			return (Criteria) this;
		}

		public Criteria andOutPriceEqualTo(BigDecimal value) {
			addCriterion("out_price =", value, "outPrice");
			return (Criteria) this;
		}

		public Criteria andOutPriceNotEqualTo(BigDecimal value) {
			addCriterion("out_price <>", value, "outPrice");
			return (Criteria) this;
		}

		public Criteria andOutPriceGreaterThan(BigDecimal value) {
			addCriterion("out_price >", value, "outPrice");
			return (Criteria) this;
		}

		public Criteria andOutPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("out_price >=", value, "outPrice");
			return (Criteria) this;
		}

		public Criteria andOutPriceLessThan(BigDecimal value) {
			addCriterion("out_price <", value, "outPrice");
			return (Criteria) this;
		}

		public Criteria andOutPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("out_price <=", value, "outPrice");
			return (Criteria) this;
		}

		public Criteria andOutPriceIn(List<BigDecimal> values) {
			addCriterion("out_price in", values, "outPrice");
			return (Criteria) this;
		}

		public Criteria andOutPriceNotIn(List<BigDecimal> values) {
			addCriterion("out_price not in", values, "outPrice");
			return (Criteria) this;
		}

		public Criteria andOutPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("out_price between", value1, value2, "outPrice");
			return (Criteria) this;
		}

		public Criteria andOutPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("out_price not between", value1, value2, "outPrice");
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

		public Criteria andPayTypeIsNull() {
			addCriterion("pay_type is null");
			return (Criteria) this;
		}

		public Criteria andPayTypeIsNotNull() {
			addCriterion("pay_type is not null");
			return (Criteria) this;
		}

		public Criteria andPayTypeEqualTo(String value) {
			addCriterion("pay_type =", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeNotEqualTo(String value) {
			addCriterion("pay_type <>", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeGreaterThan(String value) {
			addCriterion("pay_type >", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeGreaterThanOrEqualTo(String value) {
			addCriterion("pay_type >=", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeLessThan(String value) {
			addCriterion("pay_type <", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeLessThanOrEqualTo(String value) {
			addCriterion("pay_type <=", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeLike(String value) {
			addCriterion("pay_type like", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeNotLike(String value) {
			addCriterion("pay_type not like", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeIn(List<String> values) {
			addCriterion("pay_type in", values, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeNotIn(List<String> values) {
			addCriterion("pay_type not in", values, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeBetween(String value1, String value2) {
			addCriterion("pay_type between", value1, value2, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeNotBetween(String value1, String value2) {
			addCriterion("pay_type not between", value1, value2, "payType");
			return (Criteria) this;
		}

		public Criteria andRcAmountIsNull() {
			addCriterion("rc_amount is null");
			return (Criteria) this;
		}

		public Criteria andRcAmountIsNotNull() {
			addCriterion("rc_amount is not null");
			return (Criteria) this;
		}

		public Criteria andRcAmountEqualTo(Integer value) {
			addCriterion("rc_amount =", value, "rcAmount");
			return (Criteria) this;
		}

		public Criteria andRcAmountNotEqualTo(Integer value) {
			addCriterion("rc_amount <>", value, "rcAmount");
			return (Criteria) this;
		}

		public Criteria andRcAmountGreaterThan(Integer value) {
			addCriterion("rc_amount >", value, "rcAmount");
			return (Criteria) this;
		}

		public Criteria andRcAmountGreaterThanOrEqualTo(Integer value) {
			addCriterion("rc_amount >=", value, "rcAmount");
			return (Criteria) this;
		}

		public Criteria andRcAmountLessThan(Integer value) {
			addCriterion("rc_amount <", value, "rcAmount");
			return (Criteria) this;
		}

		public Criteria andRcAmountLessThanOrEqualTo(Integer value) {
			addCriterion("rc_amount <=", value, "rcAmount");
			return (Criteria) this;
		}

		public Criteria andRcAmountIn(List<Integer> values) {
			addCriterion("rc_amount in", values, "rcAmount");
			return (Criteria) this;
		}

		public Criteria andRcAmountNotIn(List<Integer> values) {
			addCriterion("rc_amount not in", values, "rcAmount");
			return (Criteria) this;
		}

		public Criteria andRcAmountBetween(Integer value1, Integer value2) {
			addCriterion("rc_amount between", value1, value2, "rcAmount");
			return (Criteria) this;
		}

		public Criteria andRcAmountNotBetween(Integer value1, Integer value2) {
			addCriterion("rc_amount not between", value1, value2, "rcAmount");
			return (Criteria) this;
		}

		public Criteria andRcMobileIsNull() {
			addCriterion("rc_mobile is null");
			return (Criteria) this;
		}

		public Criteria andRcMobileIsNotNull() {
			addCriterion("rc_mobile is not null");
			return (Criteria) this;
		}

		public Criteria andRcMobileEqualTo(String value) {
			addCriterion("rc_mobile =", value, "rcMobile");
			return (Criteria) this;
		}

		public Criteria andRcMobileNotEqualTo(String value) {
			addCriterion("rc_mobile <>", value, "rcMobile");
			return (Criteria) this;
		}

		public Criteria andRcMobileGreaterThan(String value) {
			addCriterion("rc_mobile >", value, "rcMobile");
			return (Criteria) this;
		}

		public Criteria andRcMobileGreaterThanOrEqualTo(String value) {
			addCriterion("rc_mobile >=", value, "rcMobile");
			return (Criteria) this;
		}

		public Criteria andRcMobileLessThan(String value) {
			addCriterion("rc_mobile <", value, "rcMobile");
			return (Criteria) this;
		}

		public Criteria andRcMobileLessThanOrEqualTo(String value) {
			addCriterion("rc_mobile <=", value, "rcMobile");
			return (Criteria) this;
		}

		public Criteria andRcMobileLike(String value) {
			addCriterion("rc_mobile like", value, "rcMobile");
			return (Criteria) this;
		}

		public Criteria andRcMobileNotLike(String value) {
			addCriterion("rc_mobile not like", value, "rcMobile");
			return (Criteria) this;
		}

		public Criteria andRcMobileIn(List<String> values) {
			addCriterion("rc_mobile in", values, "rcMobile");
			return (Criteria) this;
		}

		public Criteria andRcMobileNotIn(List<String> values) {
			addCriterion("rc_mobile not in", values, "rcMobile");
			return (Criteria) this;
		}

		public Criteria andRcMobileBetween(String value1, String value2) {
			addCriterion("rc_mobile between", value1, value2, "rcMobile");
			return (Criteria) this;
		}

		public Criteria andRcMobileNotBetween(String value1, String value2) {
			addCriterion("rc_mobile not between", value1, value2, "rcMobile");
			return (Criteria) this;
		}

		public Criteria andRcPriceIsNull() {
			addCriterion("rc_price is null");
			return (Criteria) this;
		}

		public Criteria andRcPriceIsNotNull() {
			addCriterion("rc_price is not null");
			return (Criteria) this;
		}

		public Criteria andRcPriceEqualTo(BigDecimal value) {
			addCriterion("rc_price =", value, "rcPrice");
			return (Criteria) this;
		}

		public Criteria andRcPriceNotEqualTo(BigDecimal value) {
			addCriterion("rc_price <>", value, "rcPrice");
			return (Criteria) this;
		}

		public Criteria andRcPriceGreaterThan(BigDecimal value) {
			addCriterion("rc_price >", value, "rcPrice");
			return (Criteria) this;
		}

		public Criteria andRcPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("rc_price >=", value, "rcPrice");
			return (Criteria) this;
		}

		public Criteria andRcPriceLessThan(BigDecimal value) {
			addCriterion("rc_price <", value, "rcPrice");
			return (Criteria) this;
		}

		public Criteria andRcPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("rc_price <=", value, "rcPrice");
			return (Criteria) this;
		}

		public Criteria andRcPriceIn(List<BigDecimal> values) {
			addCriterion("rc_price in", values, "rcPrice");
			return (Criteria) this;
		}

		public Criteria andRcPriceNotIn(List<BigDecimal> values) {
			addCriterion("rc_price not in", values, "rcPrice");
			return (Criteria) this;
		}

		public Criteria andRcPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rc_price between", value1, value2, "rcPrice");
			return (Criteria) this;
		}

		public Criteria andRcPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("rc_price not between", value1, value2, "rcPrice");
			return (Criteria) this;
		}

		public Criteria andRcTypeIsNull() {
			addCriterion("rc_type is null");
			return (Criteria) this;
		}

		public Criteria andRcTypeIsNotNull() {
			addCriterion("rc_type is not null");
			return (Criteria) this;
		}

		public Criteria andRcTypeEqualTo(String value) {
			addCriterion("rc_type =", value, "rcType");
			return (Criteria) this;
		}

		public Criteria andRcTypeNotEqualTo(String value) {
			addCriterion("rc_type <>", value, "rcType");
			return (Criteria) this;
		}

		public Criteria andRcTypeGreaterThan(String value) {
			addCriterion("rc_type >", value, "rcType");
			return (Criteria) this;
		}

		public Criteria andRcTypeGreaterThanOrEqualTo(String value) {
			addCriterion("rc_type >=", value, "rcType");
			return (Criteria) this;
		}

		public Criteria andRcTypeLessThan(String value) {
			addCriterion("rc_type <", value, "rcType");
			return (Criteria) this;
		}

		public Criteria andRcTypeLessThanOrEqualTo(String value) {
			addCriterion("rc_type <=", value, "rcType");
			return (Criteria) this;
		}

		public Criteria andRcTypeLike(String value) {
			addCriterion("rc_type like", value, "rcType");
			return (Criteria) this;
		}

		public Criteria andRcTypeNotLike(String value) {
			addCriterion("rc_type not like", value, "rcType");
			return (Criteria) this;
		}

		public Criteria andRcTypeIn(List<String> values) {
			addCriterion("rc_type in", values, "rcType");
			return (Criteria) this;
		}

		public Criteria andRcTypeNotIn(List<String> values) {
			addCriterion("rc_type not in", values, "rcType");
			return (Criteria) this;
		}

		public Criteria andRcTypeBetween(String value1, String value2) {
			addCriterion("rc_type between", value1, value2, "rcType");
			return (Criteria) this;
		}

		public Criteria andRcTypeNotBetween(String value1, String value2) {
			addCriterion("rc_type not between", value1, value2, "rcType");
			return (Criteria) this;
		}

		public Criteria andReceiverNameIsNull() {
			addCriterion("receiver_name is null");
			return (Criteria) this;
		}

		public Criteria andReceiverNameIsNotNull() {
			addCriterion("receiver_name is not null");
			return (Criteria) this;
		}

		public Criteria andReceiverNameEqualTo(String value) {
			addCriterion("receiver_name =", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameNotEqualTo(String value) {
			addCriterion("receiver_name <>", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameGreaterThan(String value) {
			addCriterion("receiver_name >", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameGreaterThanOrEqualTo(String value) {
			addCriterion("receiver_name >=", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameLessThan(String value) {
			addCriterion("receiver_name <", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameLessThanOrEqualTo(String value) {
			addCriterion("receiver_name <=", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameLike(String value) {
			addCriterion("receiver_name like", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameNotLike(String value) {
			addCriterion("receiver_name not like", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameIn(List<String> values) {
			addCriterion("receiver_name in", values, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameNotIn(List<String> values) {
			addCriterion("receiver_name not in", values, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameBetween(String value1, String value2) {
			addCriterion("receiver_name between", value1, value2, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameNotBetween(String value1, String value2) {
			addCriterion("receiver_name not between", value1, value2, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaIsNull() {
			addCriterion("receiver_area is null");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaIsNotNull() {
			addCriterion("receiver_area is not null");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaEqualTo(String value) {
			addCriterion("receiver_area =", value, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaNotEqualTo(String value) {
			addCriterion("receiver_area <>", value, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaGreaterThan(String value) {
			addCriterion("receiver_area >", value, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaGreaterThanOrEqualTo(String value) {
			addCriterion("receiver_area >=", value, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaLessThan(String value) {
			addCriterion("receiver_area <", value, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaLessThanOrEqualTo(String value) {
			addCriterion("receiver_area <=", value, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaLike(String value) {
			addCriterion("receiver_area like", value, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaNotLike(String value) {
			addCriterion("receiver_area not like", value, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaIn(List<String> values) {
			addCriterion("receiver_area in", values, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaNotIn(List<String> values) {
			addCriterion("receiver_area not in", values, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaBetween(String value1, String value2) {
			addCriterion("receiver_area between", value1, value2, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaNotBetween(String value1, String value2) {
			addCriterion("receiver_area not between", value1, value2, "receiverArea");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoIsNull() {
			addCriterion("receiver_area_info is null");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoIsNotNull() {
			addCriterion("receiver_area_info is not null");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoEqualTo(String value) {
			addCriterion("receiver_area_info =", value, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoNotEqualTo(String value) {
			addCriterion("receiver_area_info <>", value, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoGreaterThan(String value) {
			addCriterion("receiver_area_info >", value, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoGreaterThanOrEqualTo(String value) {
			addCriterion("receiver_area_info >=", value, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoLessThan(String value) {
			addCriterion("receiver_area_info <", value, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoLessThanOrEqualTo(String value) {
			addCriterion("receiver_area_info <=", value, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoLike(String value) {
			addCriterion("receiver_area_info like", value, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoNotLike(String value) {
			addCriterion("receiver_area_info not like", value, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoIn(List<String> values) {
			addCriterion("receiver_area_info in", values, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoNotIn(List<String> values) {
			addCriterion("receiver_area_info not in", values, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoBetween(String value1, String value2) {
			addCriterion("receiver_area_info between", value1, value2, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverAreaInfoNotBetween(String value1, String value2) {
			addCriterion("receiver_area_info not between", value1, value2, "receiverAreaInfo");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileIsNull() {
			addCriterion("receiver_mobile is null");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileIsNotNull() {
			addCriterion("receiver_mobile is not null");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileEqualTo(String value) {
			addCriterion("receiver_mobile =", value, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileNotEqualTo(String value) {
			addCriterion("receiver_mobile <>", value, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileGreaterThan(String value) {
			addCriterion("receiver_mobile >", value, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileGreaterThanOrEqualTo(String value) {
			addCriterion("receiver_mobile >=", value, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileLessThan(String value) {
			addCriterion("receiver_mobile <", value, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileLessThanOrEqualTo(String value) {
			addCriterion("receiver_mobile <=", value, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileLike(String value) {
			addCriterion("receiver_mobile like", value, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileNotLike(String value) {
			addCriterion("receiver_mobile not like", value, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileIn(List<String> values) {
			addCriterion("receiver_mobile in", values, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileNotIn(List<String> values) {
			addCriterion("receiver_mobile not in", values, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileBetween(String value1, String value2) {
			addCriterion("receiver_mobile between", value1, value2, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverMobileNotBetween(String value1, String value2) {
			addCriterion("receiver_mobile not between", value1, value2, "receiverMobile");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneIsNull() {
			addCriterion("receiver_telephone is null");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneIsNotNull() {
			addCriterion("receiver_telephone is not null");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneEqualTo(String value) {
			addCriterion("receiver_telephone =", value, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneNotEqualTo(String value) {
			addCriterion("receiver_telephone <>", value, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneGreaterThan(String value) {
			addCriterion("receiver_telephone >", value, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneGreaterThanOrEqualTo(String value) {
			addCriterion("receiver_telephone >=", value, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneLessThan(String value) {
			addCriterion("receiver_telephone <", value, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneLessThanOrEqualTo(String value) {
			addCriterion("receiver_telephone <=", value, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneLike(String value) {
			addCriterion("receiver_telephone like", value, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneNotLike(String value) {
			addCriterion("receiver_telephone not like", value, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneIn(List<String> values) {
			addCriterion("receiver_telephone in", values, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneNotIn(List<String> values) {
			addCriterion("receiver_telephone not in", values, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneBetween(String value1, String value2) {
			addCriterion("receiver_telephone between", value1, value2, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverTelephoneNotBetween(String value1, String value2) {
			addCriterion("receiver_telephone not between", value1, value2, "receiverTelephone");
			return (Criteria) this;
		}

		public Criteria andReceiverZipIsNull() {
			addCriterion("receiver_zip is null");
			return (Criteria) this;
		}

		public Criteria andReceiverZipIsNotNull() {
			addCriterion("receiver_zip is not null");
			return (Criteria) this;
		}

		public Criteria andReceiverZipEqualTo(String value) {
			addCriterion("receiver_zip =", value, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipNotEqualTo(String value) {
			addCriterion("receiver_zip <>", value, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipGreaterThan(String value) {
			addCriterion("receiver_zip >", value, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipGreaterThanOrEqualTo(String value) {
			addCriterion("receiver_zip >=", value, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipLessThan(String value) {
			addCriterion("receiver_zip <", value, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipLessThanOrEqualTo(String value) {
			addCriterion("receiver_zip <=", value, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipLike(String value) {
			addCriterion("receiver_zip like", value, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipNotLike(String value) {
			addCriterion("receiver_zip not like", value, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipIn(List<String> values) {
			addCriterion("receiver_zip in", values, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipNotIn(List<String> values) {
			addCriterion("receiver_zip not in", values, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipBetween(String value1, String value2) {
			addCriterion("receiver_zip between", value1, value2, "receiverZip");
			return (Criteria) this;
		}

		public Criteria andReceiverZipNotBetween(String value1, String value2) {
			addCriterion("receiver_zip not between", value1, value2, "receiverZip");
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

		public Criteria andShipCodeIsNull() {
			addCriterion("ship_code is null");
			return (Criteria) this;
		}

		public Criteria andShipCodeIsNotNull() {
			addCriterion("ship_code is not null");
			return (Criteria) this;
		}

		public Criteria andShipCodeEqualTo(String value) {
			addCriterion("ship_code =", value, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeNotEqualTo(String value) {
			addCriterion("ship_code <>", value, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeGreaterThan(String value) {
			addCriterion("ship_code >", value, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeGreaterThanOrEqualTo(String value) {
			addCriterion("ship_code >=", value, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeLessThan(String value) {
			addCriterion("ship_code <", value, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeLessThanOrEqualTo(String value) {
			addCriterion("ship_code <=", value, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeLike(String value) {
			addCriterion("ship_code like", value, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeNotLike(String value) {
			addCriterion("ship_code not like", value, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeIn(List<String> values) {
			addCriterion("ship_code in", values, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeNotIn(List<String> values) {
			addCriterion("ship_code not in", values, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeBetween(String value1, String value2) {
			addCriterion("ship_code between", value1, value2, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipCodeNotBetween(String value1, String value2) {
			addCriterion("ship_code not between", value1, value2, "shipCode");
			return (Criteria) this;
		}

		public Criteria andShipTimeIsNull() {
			addCriterion("ship_time is null");
			return (Criteria) this;
		}

		public Criteria andShipTimeIsNotNull() {
			addCriterion("ship_time is not null");
			return (Criteria) this;
		}

		public Criteria andShipTimeEqualTo(Date value) {
			addCriterion("ship_time =", value, "shipTime");
			return (Criteria) this;
		}

		public Criteria andShipTimeNotEqualTo(Date value) {
			addCriterion("ship_time <>", value, "shipTime");
			return (Criteria) this;
		}

		public Criteria andShipTimeGreaterThan(Date value) {
			addCriterion("ship_time >", value, "shipTime");
			return (Criteria) this;
		}

		public Criteria andShipTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("ship_time >=", value, "shipTime");
			return (Criteria) this;
		}

		public Criteria andShipTimeLessThan(Date value) {
			addCriterion("ship_time <", value, "shipTime");
			return (Criteria) this;
		}

		public Criteria andShipTimeLessThanOrEqualTo(Date value) {
			addCriterion("ship_time <=", value, "shipTime");
			return (Criteria) this;
		}

		public Criteria andShipTimeIn(List<Date> values) {
			addCriterion("ship_time in", values, "shipTime");
			return (Criteria) this;
		}

		public Criteria andShipTimeNotIn(List<Date> values) {
			addCriterion("ship_time not in", values, "shipTime");
			return (Criteria) this;
		}

		public Criteria andShipTimeBetween(Date value1, Date value2) {
			addCriterion("ship_time between", value1, value2, "shipTime");
			return (Criteria) this;
		}

		public Criteria andShipTimeNotBetween(Date value1, Date value2) {
			addCriterion("ship_time not between", value1, value2, "shipTime");
			return (Criteria) this;
		}

		public Criteria andShipAddrIdIsNull() {
			addCriterion("ship_addr_id is null");
			return (Criteria) this;
		}

		public Criteria andShipAddrIdIsNotNull() {
			addCriterion("ship_addr_id is not null");
			return (Criteria) this;
		}

		public Criteria andShipAddrIdEqualTo(Long value) {
			addCriterion("ship_addr_id =", value, "shipAddrId");
			return (Criteria) this;
		}

		public Criteria andShipAddrIdNotEqualTo(Long value) {
			addCriterion("ship_addr_id <>", value, "shipAddrId");
			return (Criteria) this;
		}

		public Criteria andShipAddrIdGreaterThan(Long value) {
			addCriterion("ship_addr_id >", value, "shipAddrId");
			return (Criteria) this;
		}

		public Criteria andShipAddrIdGreaterThanOrEqualTo(Long value) {
			addCriterion("ship_addr_id >=", value, "shipAddrId");
			return (Criteria) this;
		}

		public Criteria andShipAddrIdLessThan(Long value) {
			addCriterion("ship_addr_id <", value, "shipAddrId");
			return (Criteria) this;
		}

		public Criteria andShipAddrIdLessThanOrEqualTo(Long value) {
			addCriterion("ship_addr_id <=", value, "shipAddrId");
			return (Criteria) this;
		}

		public Criteria andShipAddrIdIn(List<Long> values) {
			addCriterion("ship_addr_id in", values, "shipAddrId");
			return (Criteria) this;
		}

		public Criteria andShipAddrIdNotIn(List<Long> values) {
			addCriterion("ship_addr_id not in", values, "shipAddrId");
			return (Criteria) this;
		}

		public Criteria andShipAddrIdBetween(Long value1, Long value2) {
			addCriterion("ship_addr_id between", value1, value2, "shipAddrId");
			return (Criteria) this;
		}

		public Criteria andShipAddrIdNotBetween(Long value1, Long value2) {
			addCriterion("ship_addr_id not between", value1, value2, "shipAddrId");
			return (Criteria) this;
		}

		public Criteria andShipPriceIsNull() {
			addCriterion("ship_price is null");
			return (Criteria) this;
		}

		public Criteria andShipPriceIsNotNull() {
			addCriterion("ship_price is not null");
			return (Criteria) this;
		}

		public Criteria andShipPriceEqualTo(BigDecimal value) {
			addCriterion("ship_price =", value, "shipPrice");
			return (Criteria) this;
		}

		public Criteria andShipPriceNotEqualTo(BigDecimal value) {
			addCriterion("ship_price <>", value, "shipPrice");
			return (Criteria) this;
		}

		public Criteria andShipPriceGreaterThan(BigDecimal value) {
			addCriterion("ship_price >", value, "shipPrice");
			return (Criteria) this;
		}

		public Criteria andShipPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("ship_price >=", value, "shipPrice");
			return (Criteria) this;
		}

		public Criteria andShipPriceLessThan(BigDecimal value) {
			addCriterion("ship_price <", value, "shipPrice");
			return (Criteria) this;
		}

		public Criteria andShipPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("ship_price <=", value, "shipPrice");
			return (Criteria) this;
		}

		public Criteria andShipPriceIn(List<BigDecimal> values) {
			addCriterion("ship_price in", values, "shipPrice");
			return (Criteria) this;
		}

		public Criteria andShipPriceNotIn(List<BigDecimal> values) {
			addCriterion("ship_price not in", values, "shipPrice");
			return (Criteria) this;
		}

		public Criteria andShipPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ship_price between", value1, value2, "shipPrice");
			return (Criteria) this;
		}

		public Criteria andShipPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ship_price not between", value1, value2, "shipPrice");
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

		public Criteria andTransportIsNull() {
			addCriterion("transport is null");
			return (Criteria) this;
		}

		public Criteria andTransportIsNotNull() {
			addCriterion("transport is not null");
			return (Criteria) this;
		}

		public Criteria andTransportEqualTo(String value) {
			addCriterion("transport =", value, "transport");
			return (Criteria) this;
		}

		public Criteria andTransportNotEqualTo(String value) {
			addCriterion("transport <>", value, "transport");
			return (Criteria) this;
		}

		public Criteria andTransportGreaterThan(String value) {
			addCriterion("transport >", value, "transport");
			return (Criteria) this;
		}

		public Criteria andTransportGreaterThanOrEqualTo(String value) {
			addCriterion("transport >=", value, "transport");
			return (Criteria) this;
		}

		public Criteria andTransportLessThan(String value) {
			addCriterion("transport <", value, "transport");
			return (Criteria) this;
		}

		public Criteria andTransportLessThanOrEqualTo(String value) {
			addCriterion("transport <=", value, "transport");
			return (Criteria) this;
		}

		public Criteria andTransportLike(String value) {
			addCriterion("transport like", value, "transport");
			return (Criteria) this;
		}

		public Criteria andTransportNotLike(String value) {
			addCriterion("transport not like", value, "transport");
			return (Criteria) this;
		}

		public Criteria andTransportIn(List<String> values) {
			addCriterion("transport in", values, "transport");
			return (Criteria) this;
		}

		public Criteria andTransportNotIn(List<String> values) {
			addCriterion("transport not in", values, "transport");
			return (Criteria) this;
		}

		public Criteria andTransportBetween(String value1, String value2) {
			addCriterion("transport between", value1, value2, "transport");
			return (Criteria) this;
		}

		public Criteria andTransportNotBetween(String value1, String value2) {
			addCriterion("transport not between", value1, value2, "transport");
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

		public Criteria andUserIdEqualTo(String value) {
			addCriterion("user_id =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(String value) {
			addCriterion("user_id <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(String value) {
			addCriterion("user_id >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(String value) {
			addCriterion("user_id >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(String value) {
			addCriterion("user_id <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(String value) {
			addCriterion("user_id <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLike(String value) {
			addCriterion("user_id like", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotLike(String value) {
			addCriterion("user_id not like", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<String> values) {
			addCriterion("user_id in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<String> values) {
			addCriterion("user_id not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(String value1, String value2) {
			addCriterion("user_id between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(String value1, String value2) {
			addCriterion("user_id not between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserNameIsNull() {
			addCriterion("user_name is null");
			return (Criteria) this;
		}

		public Criteria andUserNameIsNotNull() {
			addCriterion("user_name is not null");
			return (Criteria) this;
		}

		public Criteria andUserNameEqualTo(String value) {
			addCriterion("user_name =", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotEqualTo(String value) {
			addCriterion("user_name <>", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThan(String value) {
			addCriterion("user_name >", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("user_name >=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThan(String value) {
			addCriterion("user_name <", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThanOrEqualTo(String value) {
			addCriterion("user_name <=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLike(String value) {
			addCriterion("user_name like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotLike(String value) {
			addCriterion("user_name not like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameIn(List<String> values) {
			addCriterion("user_name in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotIn(List<String> values) {
			addCriterion("user_name not in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameBetween(String value1, String value2) {
			addCriterion("user_name between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotBetween(String value1, String value2) {
			addCriterion("user_name not between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andWhetherGiftIsNull() {
			addCriterion("whether_gift is null");
			return (Criteria) this;
		}

		public Criteria andWhetherGiftIsNotNull() {
			addCriterion("whether_gift is not null");
			return (Criteria) this;
		}

		public Criteria andWhetherGiftEqualTo(Integer value) {
			addCriterion("whether_gift =", value, "whetherGift");
			return (Criteria) this;
		}

		public Criteria andWhetherGiftNotEqualTo(Integer value) {
			addCriterion("whether_gift <>", value, "whetherGift");
			return (Criteria) this;
		}

		public Criteria andWhetherGiftGreaterThan(Integer value) {
			addCriterion("whether_gift >", value, "whetherGift");
			return (Criteria) this;
		}

		public Criteria andWhetherGiftGreaterThanOrEqualTo(Integer value) {
			addCriterion("whether_gift >=", value, "whetherGift");
			return (Criteria) this;
		}

		public Criteria andWhetherGiftLessThan(Integer value) {
			addCriterion("whether_gift <", value, "whetherGift");
			return (Criteria) this;
		}

		public Criteria andWhetherGiftLessThanOrEqualTo(Integer value) {
			addCriterion("whether_gift <=", value, "whetherGift");
			return (Criteria) this;
		}

		public Criteria andWhetherGiftIn(List<Integer> values) {
			addCriterion("whether_gift in", values, "whetherGift");
			return (Criteria) this;
		}

		public Criteria andWhetherGiftNotIn(List<Integer> values) {
			addCriterion("whether_gift not in", values, "whetherGift");
			return (Criteria) this;
		}

		public Criteria andWhetherGiftBetween(Integer value1, Integer value2) {
			addCriterion("whether_gift between", value1, value2, "whetherGift");
			return (Criteria) this;
		}

		public Criteria andWhetherGiftNotBetween(Integer value1, Integer value2) {
			addCriterion("whether_gift not between", value1, value2, "whetherGift");
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