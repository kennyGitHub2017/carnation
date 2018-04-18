package com.sinco.carnation.shop.model;

import com.sinco.carnation.shop.bo.ShopBonusRepeatLogBO;
import com.sinco.mybatis.dal.core.AbstractExample;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopBonusRepeatLogExample extends AbstractExample<ShopBonusRepeatLogBO> {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected String limit;

	public ShopBonusRepeatLogExample() {
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

		public Criteria andUidIsNull() {
			addCriterion("uid is null");
			return (Criteria) this;
		}

		public Criteria andUidIsNotNull() {
			addCriterion("uid is not null");
			return (Criteria) this;
		}

		public Criteria andUidEqualTo(Long value) {
			addCriterion("uid =", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidNotEqualTo(Long value) {
			addCriterion("uid <>", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidGreaterThan(Long value) {
			addCriterion("uid >", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidGreaterThanOrEqualTo(Long value) {
			addCriterion("uid >=", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidLessThan(Long value) {
			addCriterion("uid <", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidLessThanOrEqualTo(Long value) {
			addCriterion("uid <=", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidIn(List<Long> values) {
			addCriterion("uid in", values, "uid");
			return (Criteria) this;
		}

		public Criteria andUidNotIn(List<Long> values) {
			addCriterion("uid not in", values, "uid");
			return (Criteria) this;
		}

		public Criteria andUidBetween(Long value1, Long value2) {
			addCriterion("uid between", value1, value2, "uid");
			return (Criteria) this;
		}

		public Criteria andUidNotBetween(Long value1, Long value2) {
			addCriterion("uid not between", value1, value2, "uid");
			return (Criteria) this;
		}

		public Criteria andUserAliasIsNull() {
			addCriterion("user_alias is null");
			return (Criteria) this;
		}

		public Criteria andUserAliasIsNotNull() {
			addCriterion("user_alias is not null");
			return (Criteria) this;
		}

		public Criteria andUserAliasEqualTo(String value) {
			addCriterion("user_alias =", value, "userAlias");
			return (Criteria) this;
		}

		public Criteria andUserAliasNotEqualTo(String value) {
			addCriterion("user_alias <>", value, "userAlias");
			return (Criteria) this;
		}

		public Criteria andUserAliasGreaterThan(String value) {
			addCriterion("user_alias >", value, "userAlias");
			return (Criteria) this;
		}

		public Criteria andUserAliasGreaterThanOrEqualTo(String value) {
			addCriterion("user_alias >=", value, "userAlias");
			return (Criteria) this;
		}

		public Criteria andUserAliasLessThan(String value) {
			addCriterion("user_alias <", value, "userAlias");
			return (Criteria) this;
		}

		public Criteria andUserAliasLessThanOrEqualTo(String value) {
			addCriterion("user_alias <=", value, "userAlias");
			return (Criteria) this;
		}

		public Criteria andUserAliasLike(String value) {
			addCriterion("user_alias like", value, "userAlias");
			return (Criteria) this;
		}

		public Criteria andUserAliasNotLike(String value) {
			addCriterion("user_alias not like", value, "userAlias");
			return (Criteria) this;
		}

		public Criteria andUserAliasIn(List<String> values) {
			addCriterion("user_alias in", values, "userAlias");
			return (Criteria) this;
		}

		public Criteria andUserAliasNotIn(List<String> values) {
			addCriterion("user_alias not in", values, "userAlias");
			return (Criteria) this;
		}

		public Criteria andUserAliasBetween(String value1, String value2) {
			addCriterion("user_alias between", value1, value2, "userAlias");
			return (Criteria) this;
		}

		public Criteria andUserAliasNotBetween(String value1, String value2) {
			addCriterion("user_alias not between", value1, value2, "userAlias");
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

		public Criteria andOrderIdEqualTo(Long value) {
			addCriterion("order_id =", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotEqualTo(Long value) {
			addCriterion("order_id <>", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdGreaterThan(Long value) {
			addCriterion("order_id >", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
			addCriterion("order_id >=", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdLessThan(Long value) {
			addCriterion("order_id <", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdLessThanOrEqualTo(Long value) {
			addCriterion("order_id <=", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdIn(List<Long> values) {
			addCriterion("order_id in", values, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotIn(List<Long> values) {
			addCriterion("order_id not in", values, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdBetween(Long value1, Long value2) {
			addCriterion("order_id between", value1, value2, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotBetween(Long value1, Long value2) {
			addCriterion("order_id not between", value1, value2, "orderId");
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

		public Criteria andUsedBonusPriceIsNull() {
			addCriterion("used_bonus_price is null");
			return (Criteria) this;
		}

		public Criteria andUsedBonusPriceIsNotNull() {
			addCriterion("used_bonus_price is not null");
			return (Criteria) this;
		}

		public Criteria andUsedBonusPriceEqualTo(BigDecimal value) {
			addCriterion("used_bonus_price =", value, "usedBonusPrice");
			return (Criteria) this;
		}

		public Criteria andUsedBonusPriceNotEqualTo(BigDecimal value) {
			addCriterion("used_bonus_price <>", value, "usedBonusPrice");
			return (Criteria) this;
		}

		public Criteria andUsedBonusPriceGreaterThan(BigDecimal value) {
			addCriterion("used_bonus_price >", value, "usedBonusPrice");
			return (Criteria) this;
		}

		public Criteria andUsedBonusPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("used_bonus_price >=", value, "usedBonusPrice");
			return (Criteria) this;
		}

		public Criteria andUsedBonusPriceLessThan(BigDecimal value) {
			addCriterion("used_bonus_price <", value, "usedBonusPrice");
			return (Criteria) this;
		}

		public Criteria andUsedBonusPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("used_bonus_price <=", value, "usedBonusPrice");
			return (Criteria) this;
		}

		public Criteria andUsedBonusPriceIn(List<BigDecimal> values) {
			addCriterion("used_bonus_price in", values, "usedBonusPrice");
			return (Criteria) this;
		}

		public Criteria andUsedBonusPriceNotIn(List<BigDecimal> values) {
			addCriterion("used_bonus_price not in", values, "usedBonusPrice");
			return (Criteria) this;
		}

		public Criteria andUsedBonusPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("used_bonus_price between", value1, value2, "usedBonusPrice");
			return (Criteria) this;
		}

		public Criteria andUsedBonusPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("used_bonus_price not between", value1, value2, "usedBonusPrice");
			return (Criteria) this;
		}

		public Criteria andTypeIsNull() {
			addCriterion("TYPE is null");
			return (Criteria) this;
		}

		public Criteria andTypeIsNotNull() {
			addCriterion("TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andTypeEqualTo(Integer value) {
			addCriterion("TYPE =", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotEqualTo(Integer value) {
			addCriterion("TYPE <>", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThan(Integer value) {
			addCriterion("TYPE >", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("TYPE >=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThan(Integer value) {
			addCriterion("TYPE <", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThanOrEqualTo(Integer value) {
			addCriterion("TYPE <=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeIn(List<Integer> values) {
			addCriterion("TYPE in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotIn(List<Integer> values) {
			addCriterion("TYPE not in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeBetween(Integer value1, Integer value2) {
			addCriterion("TYPE between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("TYPE not between", value1, value2, "type");
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

		public Criteria andPayTypeEqualTo(Integer value) {
			addCriterion("pay_type =", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeNotEqualTo(Integer value) {
			addCriterion("pay_type <>", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeGreaterThan(Integer value) {
			addCriterion("pay_type >", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("pay_type >=", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeLessThan(Integer value) {
			addCriterion("pay_type <", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeLessThanOrEqualTo(Integer value) {
			addCriterion("pay_type <=", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeIn(List<Integer> values) {
			addCriterion("pay_type in", values, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeNotIn(List<Integer> values) {
			addCriterion("pay_type not in", values, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeBetween(Integer value1, Integer value2) {
			addCriterion("pay_type between", value1, value2, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("pay_type not between", value1, value2, "payType");
			return (Criteria) this;
		}

		public Criteria andUsedRepeatMoneyIsNull() {
			addCriterion("used_repeat_money is null");
			return (Criteria) this;
		}

		public Criteria andUsedRepeatMoneyIsNotNull() {
			addCriterion("used_repeat_money is not null");
			return (Criteria) this;
		}

		public Criteria andUsedRepeatMoneyEqualTo(BigDecimal value) {
			addCriterion("used_repeat_money =", value, "usedRepeatMoney");
			return (Criteria) this;
		}

		public Criteria andUsedRepeatMoneyNotEqualTo(BigDecimal value) {
			addCriterion("used_repeat_money <>", value, "usedRepeatMoney");
			return (Criteria) this;
		}

		public Criteria andUsedRepeatMoneyGreaterThan(BigDecimal value) {
			addCriterion("used_repeat_money >", value, "usedRepeatMoney");
			return (Criteria) this;
		}

		public Criteria andUsedRepeatMoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("used_repeat_money >=", value, "usedRepeatMoney");
			return (Criteria) this;
		}

		public Criteria andUsedRepeatMoneyLessThan(BigDecimal value) {
			addCriterion("used_repeat_money <", value, "usedRepeatMoney");
			return (Criteria) this;
		}

		public Criteria andUsedRepeatMoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("used_repeat_money <=", value, "usedRepeatMoney");
			return (Criteria) this;
		}

		public Criteria andUsedRepeatMoneyIn(List<BigDecimal> values) {
			addCriterion("used_repeat_money in", values, "usedRepeatMoney");
			return (Criteria) this;
		}

		public Criteria andUsedRepeatMoneyNotIn(List<BigDecimal> values) {
			addCriterion("used_repeat_money not in", values, "usedRepeatMoney");
			return (Criteria) this;
		}

		public Criteria andUsedRepeatMoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("used_repeat_money between", value1, value2, "usedRepeatMoney");
			return (Criteria) this;
		}

		public Criteria andUsedRepeatMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("used_repeat_money not between", value1, value2, "usedRepeatMoney");
			return (Criteria) this;
		}

		public Criteria andDateTimeIsNull() {
			addCriterion("date_time is null");
			return (Criteria) this;
		}

		public Criteria andDateTimeIsNotNull() {
			addCriterion("date_time is not null");
			return (Criteria) this;
		}

		public Criteria andDateTimeEqualTo(Date value) {
			addCriterion("date_time =", value, "dateTime");
			return (Criteria) this;
		}

		public Criteria andDateTimeNotEqualTo(Date value) {
			addCriterion("date_time <>", value, "dateTime");
			return (Criteria) this;
		}

		public Criteria andDateTimeGreaterThan(Date value) {
			addCriterion("date_time >", value, "dateTime");
			return (Criteria) this;
		}

		public Criteria andDateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("date_time >=", value, "dateTime");
			return (Criteria) this;
		}

		public Criteria andDateTimeLessThan(Date value) {
			addCriterion("date_time <", value, "dateTime");
			return (Criteria) this;
		}

		public Criteria andDateTimeLessThanOrEqualTo(Date value) {
			addCriterion("date_time <=", value, "dateTime");
			return (Criteria) this;
		}

		public Criteria andDateTimeIn(List<Date> values) {
			addCriterion("date_time in", values, "dateTime");
			return (Criteria) this;
		}

		public Criteria andDateTimeNotIn(List<Date> values) {
			addCriterion("date_time not in", values, "dateTime");
			return (Criteria) this;
		}

		public Criteria andDateTimeBetween(Date value1, Date value2) {
			addCriterion("date_time between", value1, value2, "dateTime");
			return (Criteria) this;
		}

		public Criteria andDateTimeNotBetween(Date value1, Date value2) {
			addCriterion("date_time not between", value1, value2, "dateTime");
			return (Criteria) this;
		}

		public Criteria andReturnTracNoIsNull() {
			addCriterion("return_trac_no is null");
			return (Criteria) this;
		}

		public Criteria andReturnTracNoIsNotNull() {
			addCriterion("return_trac_no is not null");
			return (Criteria) this;
		}

		public Criteria andReturnTracNoEqualTo(String value) {
			addCriterion("return_trac_no =", value, "returnTracNo");
			return (Criteria) this;
		}

		public Criteria andReturnTracNoNotEqualTo(String value) {
			addCriterion("return_trac_no <>", value, "returnTracNo");
			return (Criteria) this;
		}

		public Criteria andReturnTracNoGreaterThan(String value) {
			addCriterion("return_trac_no >", value, "returnTracNo");
			return (Criteria) this;
		}

		public Criteria andReturnTracNoGreaterThanOrEqualTo(String value) {
			addCriterion("return_trac_no >=", value, "returnTracNo");
			return (Criteria) this;
		}

		public Criteria andReturnTracNoLessThan(String value) {
			addCriterion("return_trac_no <", value, "returnTracNo");
			return (Criteria) this;
		}

		public Criteria andReturnTracNoLessThanOrEqualTo(String value) {
			addCriterion("return_trac_no <=", value, "returnTracNo");
			return (Criteria) this;
		}

		public Criteria andReturnTracNoLike(String value) {
			addCriterion("return_trac_no like", value, "returnTracNo");
			return (Criteria) this;
		}

		public Criteria andReturnTracNoNotLike(String value) {
			addCriterion("return_trac_no not like", value, "returnTracNo");
			return (Criteria) this;
		}

		public Criteria andReturnTracNoIn(List<String> values) {
			addCriterion("return_trac_no in", values, "returnTracNo");
			return (Criteria) this;
		}

		public Criteria andReturnTracNoNotIn(List<String> values) {
			addCriterion("return_trac_no not in", values, "returnTracNo");
			return (Criteria) this;
		}

		public Criteria andReturnTracNoBetween(String value1, String value2) {
			addCriterion("return_trac_no between", value1, value2, "returnTracNo");
			return (Criteria) this;
		}

		public Criteria andReturnTracNoNotBetween(String value1, String value2) {
			addCriterion("return_trac_no not between", value1, value2, "returnTracNo");
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