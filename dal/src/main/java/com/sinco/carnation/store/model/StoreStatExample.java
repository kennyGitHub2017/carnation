package com.sinco.carnation.store.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StoreStatExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public StoreStatExample() {
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

		public Criteria andAllCommissionAmountIsNull() {
			addCriterion("all_commission_amount is null");
			return (Criteria) this;
		}

		public Criteria andAllCommissionAmountIsNotNull() {
			addCriterion("all_commission_amount is not null");
			return (Criteria) this;
		}

		public Criteria andAllCommissionAmountEqualTo(Integer value) {
			addCriterion("all_commission_amount =", value, "allCommissionAmount");
			return (Criteria) this;
		}

		public Criteria andAllCommissionAmountNotEqualTo(Integer value) {
			addCriterion("all_commission_amount <>", value, "allCommissionAmount");
			return (Criteria) this;
		}

		public Criteria andAllCommissionAmountGreaterThan(Integer value) {
			addCriterion("all_commission_amount >", value, "allCommissionAmount");
			return (Criteria) this;
		}

		public Criteria andAllCommissionAmountGreaterThanOrEqualTo(Integer value) {
			addCriterion("all_commission_amount >=", value, "allCommissionAmount");
			return (Criteria) this;
		}

		public Criteria andAllCommissionAmountLessThan(Integer value) {
			addCriterion("all_commission_amount <", value, "allCommissionAmount");
			return (Criteria) this;
		}

		public Criteria andAllCommissionAmountLessThanOrEqualTo(Integer value) {
			addCriterion("all_commission_amount <=", value, "allCommissionAmount");
			return (Criteria) this;
		}

		public Criteria andAllCommissionAmountIn(List<Integer> values) {
			addCriterion("all_commission_amount in", values, "allCommissionAmount");
			return (Criteria) this;
		}

		public Criteria andAllCommissionAmountNotIn(List<Integer> values) {
			addCriterion("all_commission_amount not in", values, "allCommissionAmount");
			return (Criteria) this;
		}

		public Criteria andAllCommissionAmountBetween(Integer value1, Integer value2) {
			addCriterion("all_commission_amount between", value1, value2, "allCommissionAmount");
			return (Criteria) this;
		}

		public Criteria andAllCommissionAmountNotBetween(Integer value1, Integer value2) {
			addCriterion("all_commission_amount not between", value1, value2, "allCommissionAmount");
			return (Criteria) this;
		}

		public Criteria andAllGoodsIsNull() {
			addCriterion("all_goods is null");
			return (Criteria) this;
		}

		public Criteria andAllGoodsIsNotNull() {
			addCriterion("all_goods is not null");
			return (Criteria) this;
		}

		public Criteria andAllGoodsEqualTo(Integer value) {
			addCriterion("all_goods =", value, "allGoods");
			return (Criteria) this;
		}

		public Criteria andAllGoodsNotEqualTo(Integer value) {
			addCriterion("all_goods <>", value, "allGoods");
			return (Criteria) this;
		}

		public Criteria andAllGoodsGreaterThan(Integer value) {
			addCriterion("all_goods >", value, "allGoods");
			return (Criteria) this;
		}

		public Criteria andAllGoodsGreaterThanOrEqualTo(Integer value) {
			addCriterion("all_goods >=", value, "allGoods");
			return (Criteria) this;
		}

		public Criteria andAllGoodsLessThan(Integer value) {
			addCriterion("all_goods <", value, "allGoods");
			return (Criteria) this;
		}

		public Criteria andAllGoodsLessThanOrEqualTo(Integer value) {
			addCriterion("all_goods <=", value, "allGoods");
			return (Criteria) this;
		}

		public Criteria andAllGoodsIn(List<Integer> values) {
			addCriterion("all_goods in", values, "allGoods");
			return (Criteria) this;
		}

		public Criteria andAllGoodsNotIn(List<Integer> values) {
			addCriterion("all_goods not in", values, "allGoods");
			return (Criteria) this;
		}

		public Criteria andAllGoodsBetween(Integer value1, Integer value2) {
			addCriterion("all_goods between", value1, value2, "allGoods");
			return (Criteria) this;
		}

		public Criteria andAllGoodsNotBetween(Integer value1, Integer value2) {
			addCriterion("all_goods not between", value1, value2, "allGoods");
			return (Criteria) this;
		}

		public Criteria andAllPayoffAmountIsNull() {
			addCriterion("all_payoff_amount is null");
			return (Criteria) this;
		}

		public Criteria andAllPayoffAmountIsNotNull() {
			addCriterion("all_payoff_amount is not null");
			return (Criteria) this;
		}

		public Criteria andAllPayoffAmountEqualTo(Integer value) {
			addCriterion("all_payoff_amount =", value, "allPayoffAmount");
			return (Criteria) this;
		}

		public Criteria andAllPayoffAmountNotEqualTo(Integer value) {
			addCriterion("all_payoff_amount <>", value, "allPayoffAmount");
			return (Criteria) this;
		}

		public Criteria andAllPayoffAmountGreaterThan(Integer value) {
			addCriterion("all_payoff_amount >", value, "allPayoffAmount");
			return (Criteria) this;
		}

		public Criteria andAllPayoffAmountGreaterThanOrEqualTo(Integer value) {
			addCriterion("all_payoff_amount >=", value, "allPayoffAmount");
			return (Criteria) this;
		}

		public Criteria andAllPayoffAmountLessThan(Integer value) {
			addCriterion("all_payoff_amount <", value, "allPayoffAmount");
			return (Criteria) this;
		}

		public Criteria andAllPayoffAmountLessThanOrEqualTo(Integer value) {
			addCriterion("all_payoff_amount <=", value, "allPayoffAmount");
			return (Criteria) this;
		}

		public Criteria andAllPayoffAmountIn(List<Integer> values) {
			addCriterion("all_payoff_amount in", values, "allPayoffAmount");
			return (Criteria) this;
		}

		public Criteria andAllPayoffAmountNotIn(List<Integer> values) {
			addCriterion("all_payoff_amount not in", values, "allPayoffAmount");
			return (Criteria) this;
		}

		public Criteria andAllPayoffAmountBetween(Integer value1, Integer value2) {
			addCriterion("all_payoff_amount between", value1, value2, "allPayoffAmount");
			return (Criteria) this;
		}

		public Criteria andAllPayoffAmountNotBetween(Integer value1, Integer value2) {
			addCriterion("all_payoff_amount not between", value1, value2, "allPayoffAmount");
			return (Criteria) this;
		}

		public Criteria andAllPayoffAmountRealityIsNull() {
			addCriterion("all_payoff_amount_reality is null");
			return (Criteria) this;
		}

		public Criteria andAllPayoffAmountRealityIsNotNull() {
			addCriterion("all_payoff_amount_reality is not null");
			return (Criteria) this;
		}

		public Criteria andAllPayoffAmountRealityEqualTo(Integer value) {
			addCriterion("all_payoff_amount_reality =", value, "allPayoffAmountReality");
			return (Criteria) this;
		}

		public Criteria andAllPayoffAmountRealityNotEqualTo(Integer value) {
			addCriterion("all_payoff_amount_reality <>", value, "allPayoffAmountReality");
			return (Criteria) this;
		}

		public Criteria andAllPayoffAmountRealityGreaterThan(Integer value) {
			addCriterion("all_payoff_amount_reality >", value, "allPayoffAmountReality");
			return (Criteria) this;
		}

		public Criteria andAllPayoffAmountRealityGreaterThanOrEqualTo(Integer value) {
			addCriterion("all_payoff_amount_reality >=", value, "allPayoffAmountReality");
			return (Criteria) this;
		}

		public Criteria andAllPayoffAmountRealityLessThan(Integer value) {
			addCriterion("all_payoff_amount_reality <", value, "allPayoffAmountReality");
			return (Criteria) this;
		}

		public Criteria andAllPayoffAmountRealityLessThanOrEqualTo(Integer value) {
			addCriterion("all_payoff_amount_reality <=", value, "allPayoffAmountReality");
			return (Criteria) this;
		}

		public Criteria andAllPayoffAmountRealityIn(List<Integer> values) {
			addCriterion("all_payoff_amount_reality in", values, "allPayoffAmountReality");
			return (Criteria) this;
		}

		public Criteria andAllPayoffAmountRealityNotIn(List<Integer> values) {
			addCriterion("all_payoff_amount_reality not in", values, "allPayoffAmountReality");
			return (Criteria) this;
		}

		public Criteria andAllPayoffAmountRealityBetween(Integer value1, Integer value2) {
			addCriterion("all_payoff_amount_reality between", value1, value2, "allPayoffAmountReality");
			return (Criteria) this;
		}

		public Criteria andAllPayoffAmountRealityNotBetween(Integer value1, Integer value2) {
			addCriterion("all_payoff_amount_reality not between", value1, value2, "allPayoffAmountReality");
			return (Criteria) this;
		}

		public Criteria andAllSaleAmountIsNull() {
			addCriterion("all_sale_amount is null");
			return (Criteria) this;
		}

		public Criteria andAllSaleAmountIsNotNull() {
			addCriterion("all_sale_amount is not null");
			return (Criteria) this;
		}

		public Criteria andAllSaleAmountEqualTo(Integer value) {
			addCriterion("all_sale_amount =", value, "allSaleAmount");
			return (Criteria) this;
		}

		public Criteria andAllSaleAmountNotEqualTo(Integer value) {
			addCriterion("all_sale_amount <>", value, "allSaleAmount");
			return (Criteria) this;
		}

		public Criteria andAllSaleAmountGreaterThan(Integer value) {
			addCriterion("all_sale_amount >", value, "allSaleAmount");
			return (Criteria) this;
		}

		public Criteria andAllSaleAmountGreaterThanOrEqualTo(Integer value) {
			addCriterion("all_sale_amount >=", value, "allSaleAmount");
			return (Criteria) this;
		}

		public Criteria andAllSaleAmountLessThan(Integer value) {
			addCriterion("all_sale_amount <", value, "allSaleAmount");
			return (Criteria) this;
		}

		public Criteria andAllSaleAmountLessThanOrEqualTo(Integer value) {
			addCriterion("all_sale_amount <=", value, "allSaleAmount");
			return (Criteria) this;
		}

		public Criteria andAllSaleAmountIn(List<Integer> values) {
			addCriterion("all_sale_amount in", values, "allSaleAmount");
			return (Criteria) this;
		}

		public Criteria andAllSaleAmountNotIn(List<Integer> values) {
			addCriterion("all_sale_amount not in", values, "allSaleAmount");
			return (Criteria) this;
		}

		public Criteria andAllSaleAmountBetween(Integer value1, Integer value2) {
			addCriterion("all_sale_amount between", value1, value2, "allSaleAmount");
			return (Criteria) this;
		}

		public Criteria andAllSaleAmountNotBetween(Integer value1, Integer value2) {
			addCriterion("all_sale_amount not between", value1, value2, "allSaleAmount");
			return (Criteria) this;
		}

		public Criteria andAllStoreIsNull() {
			addCriterion("all_store is null");
			return (Criteria) this;
		}

		public Criteria andAllStoreIsNotNull() {
			addCriterion("all_store is not null");
			return (Criteria) this;
		}

		public Criteria andAllStoreEqualTo(Integer value) {
			addCriterion("all_store =", value, "allStore");
			return (Criteria) this;
		}

		public Criteria andAllStoreNotEqualTo(Integer value) {
			addCriterion("all_store <>", value, "allStore");
			return (Criteria) this;
		}

		public Criteria andAllStoreGreaterThan(Integer value) {
			addCriterion("all_store >", value, "allStore");
			return (Criteria) this;
		}

		public Criteria andAllStoreGreaterThanOrEqualTo(Integer value) {
			addCriterion("all_store >=", value, "allStore");
			return (Criteria) this;
		}

		public Criteria andAllStoreLessThan(Integer value) {
			addCriterion("all_store <", value, "allStore");
			return (Criteria) this;
		}

		public Criteria andAllStoreLessThanOrEqualTo(Integer value) {
			addCriterion("all_store <=", value, "allStore");
			return (Criteria) this;
		}

		public Criteria andAllStoreIn(List<Integer> values) {
			addCriterion("all_store in", values, "allStore");
			return (Criteria) this;
		}

		public Criteria andAllStoreNotIn(List<Integer> values) {
			addCriterion("all_store not in", values, "allStore");
			return (Criteria) this;
		}

		public Criteria andAllStoreBetween(Integer value1, Integer value2) {
			addCriterion("all_store between", value1, value2, "allStore");
			return (Criteria) this;
		}

		public Criteria andAllStoreNotBetween(Integer value1, Integer value2) {
			addCriterion("all_store not between", value1, value2, "allStore");
			return (Criteria) this;
		}

		public Criteria andAllUserIsNull() {
			addCriterion("all_user is null");
			return (Criteria) this;
		}

		public Criteria andAllUserIsNotNull() {
			addCriterion("all_user is not null");
			return (Criteria) this;
		}

		public Criteria andAllUserEqualTo(Integer value) {
			addCriterion("all_user =", value, "allUser");
			return (Criteria) this;
		}

		public Criteria andAllUserNotEqualTo(Integer value) {
			addCriterion("all_user <>", value, "allUser");
			return (Criteria) this;
		}

		public Criteria andAllUserGreaterThan(Integer value) {
			addCriterion("all_user >", value, "allUser");
			return (Criteria) this;
		}

		public Criteria andAllUserGreaterThanOrEqualTo(Integer value) {
			addCriterion("all_user >=", value, "allUser");
			return (Criteria) this;
		}

		public Criteria andAllUserLessThan(Integer value) {
			addCriterion("all_user <", value, "allUser");
			return (Criteria) this;
		}

		public Criteria andAllUserLessThanOrEqualTo(Integer value) {
			addCriterion("all_user <=", value, "allUser");
			return (Criteria) this;
		}

		public Criteria andAllUserIn(List<Integer> values) {
			addCriterion("all_user in", values, "allUser");
			return (Criteria) this;
		}

		public Criteria andAllUserNotIn(List<Integer> values) {
			addCriterion("all_user not in", values, "allUser");
			return (Criteria) this;
		}

		public Criteria andAllUserBetween(Integer value1, Integer value2) {
			addCriterion("all_user between", value1, value2, "allUser");
			return (Criteria) this;
		}

		public Criteria andAllUserNotBetween(Integer value1, Integer value2) {
			addCriterion("all_user not between", value1, value2, "allUser");
			return (Criteria) this;
		}

		public Criteria andAllUserBalanceIsNull() {
			addCriterion("all_user_balance is null");
			return (Criteria) this;
		}

		public Criteria andAllUserBalanceIsNotNull() {
			addCriterion("all_user_balance is not null");
			return (Criteria) this;
		}

		public Criteria andAllUserBalanceEqualTo(BigDecimal value) {
			addCriterion("all_user_balance =", value, "allUserBalance");
			return (Criteria) this;
		}

		public Criteria andAllUserBalanceNotEqualTo(BigDecimal value) {
			addCriterion("all_user_balance <>", value, "allUserBalance");
			return (Criteria) this;
		}

		public Criteria andAllUserBalanceGreaterThan(BigDecimal value) {
			addCriterion("all_user_balance >", value, "allUserBalance");
			return (Criteria) this;
		}

		public Criteria andAllUserBalanceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("all_user_balance >=", value, "allUserBalance");
			return (Criteria) this;
		}

		public Criteria andAllUserBalanceLessThan(BigDecimal value) {
			addCriterion("all_user_balance <", value, "allUserBalance");
			return (Criteria) this;
		}

		public Criteria andAllUserBalanceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("all_user_balance <=", value, "allUserBalance");
			return (Criteria) this;
		}

		public Criteria andAllUserBalanceIn(List<BigDecimal> values) {
			addCriterion("all_user_balance in", values, "allUserBalance");
			return (Criteria) this;
		}

		public Criteria andAllUserBalanceNotIn(List<BigDecimal> values) {
			addCriterion("all_user_balance not in", values, "allUserBalance");
			return (Criteria) this;
		}

		public Criteria andAllUserBalanceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("all_user_balance between", value1, value2, "allUserBalance");
			return (Criteria) this;
		}

		public Criteria andAllUserBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("all_user_balance not between", value1, value2, "allUserBalance");
			return (Criteria) this;
		}

		public Criteria andDeliveryAuditCountIsNull() {
			addCriterion("delivery_audit_count is null");
			return (Criteria) this;
		}

		public Criteria andDeliveryAuditCountIsNotNull() {
			addCriterion("delivery_audit_count is not null");
			return (Criteria) this;
		}

		public Criteria andDeliveryAuditCountEqualTo(Integer value) {
			addCriterion("delivery_audit_count =", value, "deliveryAuditCount");
			return (Criteria) this;
		}

		public Criteria andDeliveryAuditCountNotEqualTo(Integer value) {
			addCriterion("delivery_audit_count <>", value, "deliveryAuditCount");
			return (Criteria) this;
		}

		public Criteria andDeliveryAuditCountGreaterThan(Integer value) {
			addCriterion("delivery_audit_count >", value, "deliveryAuditCount");
			return (Criteria) this;
		}

		public Criteria andDeliveryAuditCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("delivery_audit_count >=", value, "deliveryAuditCount");
			return (Criteria) this;
		}

		public Criteria andDeliveryAuditCountLessThan(Integer value) {
			addCriterion("delivery_audit_count <", value, "deliveryAuditCount");
			return (Criteria) this;
		}

		public Criteria andDeliveryAuditCountLessThanOrEqualTo(Integer value) {
			addCriterion("delivery_audit_count <=", value, "deliveryAuditCount");
			return (Criteria) this;
		}

		public Criteria andDeliveryAuditCountIn(List<Integer> values) {
			addCriterion("delivery_audit_count in", values, "deliveryAuditCount");
			return (Criteria) this;
		}

		public Criteria andDeliveryAuditCountNotIn(List<Integer> values) {
			addCriterion("delivery_audit_count not in", values, "deliveryAuditCount");
			return (Criteria) this;
		}

		public Criteria andDeliveryAuditCountBetween(Integer value1, Integer value2) {
			addCriterion("delivery_audit_count between", value1, value2, "deliveryAuditCount");
			return (Criteria) this;
		}

		public Criteria andDeliveryAuditCountNotBetween(Integer value1, Integer value2) {
			addCriterion("delivery_audit_count not between", value1, value2, "deliveryAuditCount");
			return (Criteria) this;
		}

		public Criteria andGoodsAuditIsNull() {
			addCriterion("goods_audit is null");
			return (Criteria) this;
		}

		public Criteria andGoodsAuditIsNotNull() {
			addCriterion("goods_audit is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsAuditEqualTo(Integer value) {
			addCriterion("goods_audit =", value, "goodsAudit");
			return (Criteria) this;
		}

		public Criteria andGoodsAuditNotEqualTo(Integer value) {
			addCriterion("goods_audit <>", value, "goodsAudit");
			return (Criteria) this;
		}

		public Criteria andGoodsAuditGreaterThan(Integer value) {
			addCriterion("goods_audit >", value, "goodsAudit");
			return (Criteria) this;
		}

		public Criteria andGoodsAuditGreaterThanOrEqualTo(Integer value) {
			addCriterion("goods_audit >=", value, "goodsAudit");
			return (Criteria) this;
		}

		public Criteria andGoodsAuditLessThan(Integer value) {
			addCriterion("goods_audit <", value, "goodsAudit");
			return (Criteria) this;
		}

		public Criteria andGoodsAuditLessThanOrEqualTo(Integer value) {
			addCriterion("goods_audit <=", value, "goodsAudit");
			return (Criteria) this;
		}

		public Criteria andGoodsAuditIn(List<Integer> values) {
			addCriterion("goods_audit in", values, "goodsAudit");
			return (Criteria) this;
		}

		public Criteria andGoodsAuditNotIn(List<Integer> values) {
			addCriterion("goods_audit not in", values, "goodsAudit");
			return (Criteria) this;
		}

		public Criteria andGoodsAuditBetween(Integer value1, Integer value2) {
			addCriterion("goods_audit between", value1, value2, "goodsAudit");
			return (Criteria) this;
		}

		public Criteria andGoodsAuditNotBetween(Integer value1, Integer value2) {
			addCriterion("goods_audit not between", value1, value2, "goodsAudit");
			return (Criteria) this;
		}

		public Criteria andInformationAuditCountIsNull() {
			addCriterion("information_audit_count is null");
			return (Criteria) this;
		}

		public Criteria andInformationAuditCountIsNotNull() {
			addCriterion("information_audit_count is not null");
			return (Criteria) this;
		}

		public Criteria andInformationAuditCountEqualTo(Integer value) {
			addCriterion("information_audit_count =", value, "informationAuditCount");
			return (Criteria) this;
		}

		public Criteria andInformationAuditCountNotEqualTo(Integer value) {
			addCriterion("information_audit_count <>", value, "informationAuditCount");
			return (Criteria) this;
		}

		public Criteria andInformationAuditCountGreaterThan(Integer value) {
			addCriterion("information_audit_count >", value, "informationAuditCount");
			return (Criteria) this;
		}

		public Criteria andInformationAuditCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("information_audit_count >=", value, "informationAuditCount");
			return (Criteria) this;
		}

		public Criteria andInformationAuditCountLessThan(Integer value) {
			addCriterion("information_audit_count <", value, "informationAuditCount");
			return (Criteria) this;
		}

		public Criteria andInformationAuditCountLessThanOrEqualTo(Integer value) {
			addCriterion("information_audit_count <=", value, "informationAuditCount");
			return (Criteria) this;
		}

		public Criteria andInformationAuditCountIn(List<Integer> values) {
			addCriterion("information_audit_count in", values, "informationAuditCount");
			return (Criteria) this;
		}

		public Criteria andInformationAuditCountNotIn(List<Integer> values) {
			addCriterion("information_audit_count not in", values, "informationAuditCount");
			return (Criteria) this;
		}

		public Criteria andInformationAuditCountBetween(Integer value1, Integer value2) {
			addCriterion("information_audit_count between", value1, value2, "informationAuditCount");
			return (Criteria) this;
		}

		public Criteria andInformationAuditCountNotBetween(Integer value1, Integer value2) {
			addCriterion("information_audit_count not between", value1, value2, "informationAuditCount");
			return (Criteria) this;
		}

		public Criteria andNextTimeIsNull() {
			addCriterion("next_time is null");
			return (Criteria) this;
		}

		public Criteria andNextTimeIsNotNull() {
			addCriterion("next_time is not null");
			return (Criteria) this;
		}

		public Criteria andNextTimeEqualTo(Date value) {
			addCriterion("next_time =", value, "nextTime");
			return (Criteria) this;
		}

		public Criteria andNextTimeNotEqualTo(Date value) {
			addCriterion("next_time <>", value, "nextTime");
			return (Criteria) this;
		}

		public Criteria andNextTimeGreaterThan(Date value) {
			addCriterion("next_time >", value, "nextTime");
			return (Criteria) this;
		}

		public Criteria andNextTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("next_time >=", value, "nextTime");
			return (Criteria) this;
		}

		public Criteria andNextTimeLessThan(Date value) {
			addCriterion("next_time <", value, "nextTime");
			return (Criteria) this;
		}

		public Criteria andNextTimeLessThanOrEqualTo(Date value) {
			addCriterion("next_time <=", value, "nextTime");
			return (Criteria) this;
		}

		public Criteria andNextTimeIn(List<Date> values) {
			addCriterion("next_time in", values, "nextTime");
			return (Criteria) this;
		}

		public Criteria andNextTimeNotIn(List<Date> values) {
			addCriterion("next_time not in", values, "nextTime");
			return (Criteria) this;
		}

		public Criteria andNextTimeBetween(Date value1, Date value2) {
			addCriterion("next_time between", value1, value2, "nextTime");
			return (Criteria) this;
		}

		public Criteria andNextTimeNotBetween(Date value1, Date value2) {
			addCriterion("next_time not between", value1, value2, "nextTime");
			return (Criteria) this;
		}

		public Criteria andNotGrouplifeRefundIsNull() {
			addCriterion("not_grouplife_refund is null");
			return (Criteria) this;
		}

		public Criteria andNotGrouplifeRefundIsNotNull() {
			addCriterion("not_grouplife_refund is not null");
			return (Criteria) this;
		}

		public Criteria andNotGrouplifeRefundEqualTo(Integer value) {
			addCriterion("not_grouplife_refund =", value, "notGrouplifeRefund");
			return (Criteria) this;
		}

		public Criteria andNotGrouplifeRefundNotEqualTo(Integer value) {
			addCriterion("not_grouplife_refund <>", value, "notGrouplifeRefund");
			return (Criteria) this;
		}

		public Criteria andNotGrouplifeRefundGreaterThan(Integer value) {
			addCriterion("not_grouplife_refund >", value, "notGrouplifeRefund");
			return (Criteria) this;
		}

		public Criteria andNotGrouplifeRefundGreaterThanOrEqualTo(Integer value) {
			addCriterion("not_grouplife_refund >=", value, "notGrouplifeRefund");
			return (Criteria) this;
		}

		public Criteria andNotGrouplifeRefundLessThan(Integer value) {
			addCriterion("not_grouplife_refund <", value, "notGrouplifeRefund");
			return (Criteria) this;
		}

		public Criteria andNotGrouplifeRefundLessThanOrEqualTo(Integer value) {
			addCriterion("not_grouplife_refund <=", value, "notGrouplifeRefund");
			return (Criteria) this;
		}

		public Criteria andNotGrouplifeRefundIn(List<Integer> values) {
			addCriterion("not_grouplife_refund in", values, "notGrouplifeRefund");
			return (Criteria) this;
		}

		public Criteria andNotGrouplifeRefundNotIn(List<Integer> values) {
			addCriterion("not_grouplife_refund not in", values, "notGrouplifeRefund");
			return (Criteria) this;
		}

		public Criteria andNotGrouplifeRefundBetween(Integer value1, Integer value2) {
			addCriterion("not_grouplife_refund between", value1, value2, "notGrouplifeRefund");
			return (Criteria) this;
		}

		public Criteria andNotGrouplifeRefundNotBetween(Integer value1, Integer value2) {
			addCriterion("not_grouplife_refund not between", value1, value2, "notGrouplifeRefund");
			return (Criteria) this;
		}

		public Criteria andNotPayoffNumIsNull() {
			addCriterion("not_payoff_num is null");
			return (Criteria) this;
		}

		public Criteria andNotPayoffNumIsNotNull() {
			addCriterion("not_payoff_num is not null");
			return (Criteria) this;
		}

		public Criteria andNotPayoffNumEqualTo(Integer value) {
			addCriterion("not_payoff_num =", value, "notPayoffNum");
			return (Criteria) this;
		}

		public Criteria andNotPayoffNumNotEqualTo(Integer value) {
			addCriterion("not_payoff_num <>", value, "notPayoffNum");
			return (Criteria) this;
		}

		public Criteria andNotPayoffNumGreaterThan(Integer value) {
			addCriterion("not_payoff_num >", value, "notPayoffNum");
			return (Criteria) this;
		}

		public Criteria andNotPayoffNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("not_payoff_num >=", value, "notPayoffNum");
			return (Criteria) this;
		}

		public Criteria andNotPayoffNumLessThan(Integer value) {
			addCriterion("not_payoff_num <", value, "notPayoffNum");
			return (Criteria) this;
		}

		public Criteria andNotPayoffNumLessThanOrEqualTo(Integer value) {
			addCriterion("not_payoff_num <=", value, "notPayoffNum");
			return (Criteria) this;
		}

		public Criteria andNotPayoffNumIn(List<Integer> values) {
			addCriterion("not_payoff_num in", values, "notPayoffNum");
			return (Criteria) this;
		}

		public Criteria andNotPayoffNumNotIn(List<Integer> values) {
			addCriterion("not_payoff_num not in", values, "notPayoffNum");
			return (Criteria) this;
		}

		public Criteria andNotPayoffNumBetween(Integer value1, Integer value2) {
			addCriterion("not_payoff_num between", value1, value2, "notPayoffNum");
			return (Criteria) this;
		}

		public Criteria andNotPayoffNumNotBetween(Integer value1, Integer value2) {
			addCriterion("not_payoff_num not between", value1, value2, "notPayoffNum");
			return (Criteria) this;
		}

		public Criteria andNotRefundIsNull() {
			addCriterion("not_refund is null");
			return (Criteria) this;
		}

		public Criteria andNotRefundIsNotNull() {
			addCriterion("not_refund is not null");
			return (Criteria) this;
		}

		public Criteria andNotRefundEqualTo(Integer value) {
			addCriterion("not_refund =", value, "notRefund");
			return (Criteria) this;
		}

		public Criteria andNotRefundNotEqualTo(Integer value) {
			addCriterion("not_refund <>", value, "notRefund");
			return (Criteria) this;
		}

		public Criteria andNotRefundGreaterThan(Integer value) {
			addCriterion("not_refund >", value, "notRefund");
			return (Criteria) this;
		}

		public Criteria andNotRefundGreaterThanOrEqualTo(Integer value) {
			addCriterion("not_refund >=", value, "notRefund");
			return (Criteria) this;
		}

		public Criteria andNotRefundLessThan(Integer value) {
			addCriterion("not_refund <", value, "notRefund");
			return (Criteria) this;
		}

		public Criteria andNotRefundLessThanOrEqualTo(Integer value) {
			addCriterion("not_refund <=", value, "notRefund");
			return (Criteria) this;
		}

		public Criteria andNotRefundIn(List<Integer> values) {
			addCriterion("not_refund in", values, "notRefund");
			return (Criteria) this;
		}

		public Criteria andNotRefundNotIn(List<Integer> values) {
			addCriterion("not_refund not in", values, "notRefund");
			return (Criteria) this;
		}

		public Criteria andNotRefundBetween(Integer value1, Integer value2) {
			addCriterion("not_refund between", value1, value2, "notRefund");
			return (Criteria) this;
		}

		public Criteria andNotRefundNotBetween(Integer value1, Integer value2) {
			addCriterion("not_refund not between", value1, value2, "notRefund");
			return (Criteria) this;
		}

		public Criteria andOrderAmountIsNull() {
			addCriterion("order_amount is null");
			return (Criteria) this;
		}

		public Criteria andOrderAmountIsNotNull() {
			addCriterion("order_amount is not null");
			return (Criteria) this;
		}

		public Criteria andOrderAmountEqualTo(BigDecimal value) {
			addCriterion("order_amount =", value, "orderAmount");
			return (Criteria) this;
		}

		public Criteria andOrderAmountNotEqualTo(BigDecimal value) {
			addCriterion("order_amount <>", value, "orderAmount");
			return (Criteria) this;
		}

		public Criteria andOrderAmountGreaterThan(BigDecimal value) {
			addCriterion("order_amount >", value, "orderAmount");
			return (Criteria) this;
		}

		public Criteria andOrderAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("order_amount >=", value, "orderAmount");
			return (Criteria) this;
		}

		public Criteria andOrderAmountLessThan(BigDecimal value) {
			addCriterion("order_amount <", value, "orderAmount");
			return (Criteria) this;
		}

		public Criteria andOrderAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("order_amount <=", value, "orderAmount");
			return (Criteria) this;
		}

		public Criteria andOrderAmountIn(List<BigDecimal> values) {
			addCriterion("order_amount in", values, "orderAmount");
			return (Criteria) this;
		}

		public Criteria andOrderAmountNotIn(List<BigDecimal> values) {
			addCriterion("order_amount not in", values, "orderAmount");
			return (Criteria) this;
		}

		public Criteria andOrderAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("order_amount between", value1, value2, "orderAmount");
			return (Criteria) this;
		}

		public Criteria andOrderAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("order_amount not between", value1, value2, "orderAmount");
			return (Criteria) this;
		}

		public Criteria andSelfActivityGoodsIsNull() {
			addCriterion("self_activity_goods is null");
			return (Criteria) this;
		}

		public Criteria andSelfActivityGoodsIsNotNull() {
			addCriterion("self_activity_goods is not null");
			return (Criteria) this;
		}

		public Criteria andSelfActivityGoodsEqualTo(Integer value) {
			addCriterion("self_activity_goods =", value, "selfActivityGoods");
			return (Criteria) this;
		}

		public Criteria andSelfActivityGoodsNotEqualTo(Integer value) {
			addCriterion("self_activity_goods <>", value, "selfActivityGoods");
			return (Criteria) this;
		}

		public Criteria andSelfActivityGoodsGreaterThan(Integer value) {
			addCriterion("self_activity_goods >", value, "selfActivityGoods");
			return (Criteria) this;
		}

		public Criteria andSelfActivityGoodsGreaterThanOrEqualTo(Integer value) {
			addCriterion("self_activity_goods >=", value, "selfActivityGoods");
			return (Criteria) this;
		}

		public Criteria andSelfActivityGoodsLessThan(Integer value) {
			addCriterion("self_activity_goods <", value, "selfActivityGoods");
			return (Criteria) this;
		}

		public Criteria andSelfActivityGoodsLessThanOrEqualTo(Integer value) {
			addCriterion("self_activity_goods <=", value, "selfActivityGoods");
			return (Criteria) this;
		}

		public Criteria andSelfActivityGoodsIn(List<Integer> values) {
			addCriterion("self_activity_goods in", values, "selfActivityGoods");
			return (Criteria) this;
		}

		public Criteria andSelfActivityGoodsNotIn(List<Integer> values) {
			addCriterion("self_activity_goods not in", values, "selfActivityGoods");
			return (Criteria) this;
		}

		public Criteria andSelfActivityGoodsBetween(Integer value1, Integer value2) {
			addCriterion("self_activity_goods between", value1, value2, "selfActivityGoods");
			return (Criteria) this;
		}

		public Criteria andSelfActivityGoodsNotBetween(Integer value1, Integer value2) {
			addCriterion("self_activity_goods not between", value1, value2, "selfActivityGoods");
			return (Criteria) this;
		}

		public Criteria andSelfAllOrderIsNull() {
			addCriterion("self_all_order is null");
			return (Criteria) this;
		}

		public Criteria andSelfAllOrderIsNotNull() {
			addCriterion("self_all_order is not null");
			return (Criteria) this;
		}

		public Criteria andSelfAllOrderEqualTo(Integer value) {
			addCriterion("self_all_order =", value, "selfAllOrder");
			return (Criteria) this;
		}

		public Criteria andSelfAllOrderNotEqualTo(Integer value) {
			addCriterion("self_all_order <>", value, "selfAllOrder");
			return (Criteria) this;
		}

		public Criteria andSelfAllOrderGreaterThan(Integer value) {
			addCriterion("self_all_order >", value, "selfAllOrder");
			return (Criteria) this;
		}

		public Criteria andSelfAllOrderGreaterThanOrEqualTo(Integer value) {
			addCriterion("self_all_order >=", value, "selfAllOrder");
			return (Criteria) this;
		}

		public Criteria andSelfAllOrderLessThan(Integer value) {
			addCriterion("self_all_order <", value, "selfAllOrder");
			return (Criteria) this;
		}

		public Criteria andSelfAllOrderLessThanOrEqualTo(Integer value) {
			addCriterion("self_all_order <=", value, "selfAllOrder");
			return (Criteria) this;
		}

		public Criteria andSelfAllOrderIn(List<Integer> values) {
			addCriterion("self_all_order in", values, "selfAllOrder");
			return (Criteria) this;
		}

		public Criteria andSelfAllOrderNotIn(List<Integer> values) {
			addCriterion("self_all_order not in", values, "selfAllOrder");
			return (Criteria) this;
		}

		public Criteria andSelfAllOrderBetween(Integer value1, Integer value2) {
			addCriterion("self_all_order between", value1, value2, "selfAllOrder");
			return (Criteria) this;
		}

		public Criteria andSelfAllOrderNotBetween(Integer value1, Integer value2) {
			addCriterion("self_all_order not between", value1, value2, "selfAllOrder");
			return (Criteria) this;
		}

		public Criteria andSelfFreeGoodsIsNull() {
			addCriterion("self_free_goods is null");
			return (Criteria) this;
		}

		public Criteria andSelfFreeGoodsIsNotNull() {
			addCriterion("self_free_goods is not null");
			return (Criteria) this;
		}

		public Criteria andSelfFreeGoodsEqualTo(Integer value) {
			addCriterion("self_free_goods =", value, "selfFreeGoods");
			return (Criteria) this;
		}

		public Criteria andSelfFreeGoodsNotEqualTo(Integer value) {
			addCriterion("self_free_goods <>", value, "selfFreeGoods");
			return (Criteria) this;
		}

		public Criteria andSelfFreeGoodsGreaterThan(Integer value) {
			addCriterion("self_free_goods >", value, "selfFreeGoods");
			return (Criteria) this;
		}

		public Criteria andSelfFreeGoodsGreaterThanOrEqualTo(Integer value) {
			addCriterion("self_free_goods >=", value, "selfFreeGoods");
			return (Criteria) this;
		}

		public Criteria andSelfFreeGoodsLessThan(Integer value) {
			addCriterion("self_free_goods <", value, "selfFreeGoods");
			return (Criteria) this;
		}

		public Criteria andSelfFreeGoodsLessThanOrEqualTo(Integer value) {
			addCriterion("self_free_goods <=", value, "selfFreeGoods");
			return (Criteria) this;
		}

		public Criteria andSelfFreeGoodsIn(List<Integer> values) {
			addCriterion("self_free_goods in", values, "selfFreeGoods");
			return (Criteria) this;
		}

		public Criteria andSelfFreeGoodsNotIn(List<Integer> values) {
			addCriterion("self_free_goods not in", values, "selfFreeGoods");
			return (Criteria) this;
		}

		public Criteria andSelfFreeGoodsBetween(Integer value1, Integer value2) {
			addCriterion("self_free_goods between", value1, value2, "selfFreeGoods");
			return (Criteria) this;
		}

		public Criteria andSelfFreeGoodsNotBetween(Integer value1, Integer value2) {
			addCriterion("self_free_goods not between", value1, value2, "selfFreeGoods");
			return (Criteria) this;
		}

		public Criteria andSelfGoodsIsNull() {
			addCriterion("self_goods is null");
			return (Criteria) this;
		}

		public Criteria andSelfGoodsIsNotNull() {
			addCriterion("self_goods is not null");
			return (Criteria) this;
		}

		public Criteria andSelfGoodsEqualTo(Integer value) {
			addCriterion("self_goods =", value, "selfGoods");
			return (Criteria) this;
		}

		public Criteria andSelfGoodsNotEqualTo(Integer value) {
			addCriterion("self_goods <>", value, "selfGoods");
			return (Criteria) this;
		}

		public Criteria andSelfGoodsGreaterThan(Integer value) {
			addCriterion("self_goods >", value, "selfGoods");
			return (Criteria) this;
		}

		public Criteria andSelfGoodsGreaterThanOrEqualTo(Integer value) {
			addCriterion("self_goods >=", value, "selfGoods");
			return (Criteria) this;
		}

		public Criteria andSelfGoodsLessThan(Integer value) {
			addCriterion("self_goods <", value, "selfGoods");
			return (Criteria) this;
		}

		public Criteria andSelfGoodsLessThanOrEqualTo(Integer value) {
			addCriterion("self_goods <=", value, "selfGoods");
			return (Criteria) this;
		}

		public Criteria andSelfGoodsIn(List<Integer> values) {
			addCriterion("self_goods in", values, "selfGoods");
			return (Criteria) this;
		}

		public Criteria andSelfGoodsNotIn(List<Integer> values) {
			addCriterion("self_goods not in", values, "selfGoods");
			return (Criteria) this;
		}

		public Criteria andSelfGoodsBetween(Integer value1, Integer value2) {
			addCriterion("self_goods between", value1, value2, "selfGoods");
			return (Criteria) this;
		}

		public Criteria andSelfGoodsNotBetween(Integer value1, Integer value2) {
			addCriterion("self_goods not between", value1, value2, "selfGoods");
			return (Criteria) this;
		}

		public Criteria andSelfGoodsConsultIsNull() {
			addCriterion("self_goods_consult is null");
			return (Criteria) this;
		}

		public Criteria andSelfGoodsConsultIsNotNull() {
			addCriterion("self_goods_consult is not null");
			return (Criteria) this;
		}

		public Criteria andSelfGoodsConsultEqualTo(Integer value) {
			addCriterion("self_goods_consult =", value, "selfGoodsConsult");
			return (Criteria) this;
		}

		public Criteria andSelfGoodsConsultNotEqualTo(Integer value) {
			addCriterion("self_goods_consult <>", value, "selfGoodsConsult");
			return (Criteria) this;
		}

		public Criteria andSelfGoodsConsultGreaterThan(Integer value) {
			addCriterion("self_goods_consult >", value, "selfGoodsConsult");
			return (Criteria) this;
		}

		public Criteria andSelfGoodsConsultGreaterThanOrEqualTo(Integer value) {
			addCriterion("self_goods_consult >=", value, "selfGoodsConsult");
			return (Criteria) this;
		}

		public Criteria andSelfGoodsConsultLessThan(Integer value) {
			addCriterion("self_goods_consult <", value, "selfGoodsConsult");
			return (Criteria) this;
		}

		public Criteria andSelfGoodsConsultLessThanOrEqualTo(Integer value) {
			addCriterion("self_goods_consult <=", value, "selfGoodsConsult");
			return (Criteria) this;
		}

		public Criteria andSelfGoodsConsultIn(List<Integer> values) {
			addCriterion("self_goods_consult in", values, "selfGoodsConsult");
			return (Criteria) this;
		}

		public Criteria andSelfGoodsConsultNotIn(List<Integer> values) {
			addCriterion("self_goods_consult not in", values, "selfGoodsConsult");
			return (Criteria) this;
		}

		public Criteria andSelfGoodsConsultBetween(Integer value1, Integer value2) {
			addCriterion("self_goods_consult between", value1, value2, "selfGoodsConsult");
			return (Criteria) this;
		}

		public Criteria andSelfGoodsConsultNotBetween(Integer value1, Integer value2) {
			addCriterion("self_goods_consult not between", value1, value2, "selfGoodsConsult");
			return (Criteria) this;
		}

		public Criteria andSelfGroupGoodsIsNull() {
			addCriterion("self_group_goods is null");
			return (Criteria) this;
		}

		public Criteria andSelfGroupGoodsIsNotNull() {
			addCriterion("self_group_goods is not null");
			return (Criteria) this;
		}

		public Criteria andSelfGroupGoodsEqualTo(Integer value) {
			addCriterion("self_group_goods =", value, "selfGroupGoods");
			return (Criteria) this;
		}

		public Criteria andSelfGroupGoodsNotEqualTo(Integer value) {
			addCriterion("self_group_goods <>", value, "selfGroupGoods");
			return (Criteria) this;
		}

		public Criteria andSelfGroupGoodsGreaterThan(Integer value) {
			addCriterion("self_group_goods >", value, "selfGroupGoods");
			return (Criteria) this;
		}

		public Criteria andSelfGroupGoodsGreaterThanOrEqualTo(Integer value) {
			addCriterion("self_group_goods >=", value, "selfGroupGoods");
			return (Criteria) this;
		}

		public Criteria andSelfGroupGoodsLessThan(Integer value) {
			addCriterion("self_group_goods <", value, "selfGroupGoods");
			return (Criteria) this;
		}

		public Criteria andSelfGroupGoodsLessThanOrEqualTo(Integer value) {
			addCriterion("self_group_goods <=", value, "selfGroupGoods");
			return (Criteria) this;
		}

		public Criteria andSelfGroupGoodsIn(List<Integer> values) {
			addCriterion("self_group_goods in", values, "selfGroupGoods");
			return (Criteria) this;
		}

		public Criteria andSelfGroupGoodsNotIn(List<Integer> values) {
			addCriterion("self_group_goods not in", values, "selfGroupGoods");
			return (Criteria) this;
		}

		public Criteria andSelfGroupGoodsBetween(Integer value1, Integer value2) {
			addCriterion("self_group_goods between", value1, value2, "selfGroupGoods");
			return (Criteria) this;
		}

		public Criteria andSelfGroupGoodsNotBetween(Integer value1, Integer value2) {
			addCriterion("self_group_goods not between", value1, value2, "selfGroupGoods");
			return (Criteria) this;
		}

		public Criteria andSelfGroupLifeIsNull() {
			addCriterion("self_group_life is null");
			return (Criteria) this;
		}

		public Criteria andSelfGroupLifeIsNotNull() {
			addCriterion("self_group_life is not null");
			return (Criteria) this;
		}

		public Criteria andSelfGroupLifeEqualTo(Integer value) {
			addCriterion("self_group_life =", value, "selfGroupLife");
			return (Criteria) this;
		}

		public Criteria andSelfGroupLifeNotEqualTo(Integer value) {
			addCriterion("self_group_life <>", value, "selfGroupLife");
			return (Criteria) this;
		}

		public Criteria andSelfGroupLifeGreaterThan(Integer value) {
			addCriterion("self_group_life >", value, "selfGroupLife");
			return (Criteria) this;
		}

		public Criteria andSelfGroupLifeGreaterThanOrEqualTo(Integer value) {
			addCriterion("self_group_life >=", value, "selfGroupLife");
			return (Criteria) this;
		}

		public Criteria andSelfGroupLifeLessThan(Integer value) {
			addCriterion("self_group_life <", value, "selfGroupLife");
			return (Criteria) this;
		}

		public Criteria andSelfGroupLifeLessThanOrEqualTo(Integer value) {
			addCriterion("self_group_life <=", value, "selfGroupLife");
			return (Criteria) this;
		}

		public Criteria andSelfGroupLifeIn(List<Integer> values) {
			addCriterion("self_group_life in", values, "selfGroupLife");
			return (Criteria) this;
		}

		public Criteria andSelfGroupLifeNotIn(List<Integer> values) {
			addCriterion("self_group_life not in", values, "selfGroupLife");
			return (Criteria) this;
		}

		public Criteria andSelfGroupLifeBetween(Integer value1, Integer value2) {
			addCriterion("self_group_life between", value1, value2, "selfGroupLife");
			return (Criteria) this;
		}

		public Criteria andSelfGroupLifeNotBetween(Integer value1, Integer value2) {
			addCriterion("self_group_life not between", value1, value2, "selfGroupLife");
			return (Criteria) this;
		}

		public Criteria andSelfGrouplifeRefundIsNull() {
			addCriterion("self_grouplife_refund is null");
			return (Criteria) this;
		}

		public Criteria andSelfGrouplifeRefundIsNotNull() {
			addCriterion("self_grouplife_refund is not null");
			return (Criteria) this;
		}

		public Criteria andSelfGrouplifeRefundEqualTo(Integer value) {
			addCriterion("self_grouplife_refund =", value, "selfGrouplifeRefund");
			return (Criteria) this;
		}

		public Criteria andSelfGrouplifeRefundNotEqualTo(Integer value) {
			addCriterion("self_grouplife_refund <>", value, "selfGrouplifeRefund");
			return (Criteria) this;
		}

		public Criteria andSelfGrouplifeRefundGreaterThan(Integer value) {
			addCriterion("self_grouplife_refund >", value, "selfGrouplifeRefund");
			return (Criteria) this;
		}

		public Criteria andSelfGrouplifeRefundGreaterThanOrEqualTo(Integer value) {
			addCriterion("self_grouplife_refund >=", value, "selfGrouplifeRefund");
			return (Criteria) this;
		}

		public Criteria andSelfGrouplifeRefundLessThan(Integer value) {
			addCriterion("self_grouplife_refund <", value, "selfGrouplifeRefund");
			return (Criteria) this;
		}

		public Criteria andSelfGrouplifeRefundLessThanOrEqualTo(Integer value) {
			addCriterion("self_grouplife_refund <=", value, "selfGrouplifeRefund");
			return (Criteria) this;
		}

		public Criteria andSelfGrouplifeRefundIn(List<Integer> values) {
			addCriterion("self_grouplife_refund in", values, "selfGrouplifeRefund");
			return (Criteria) this;
		}

		public Criteria andSelfGrouplifeRefundNotIn(List<Integer> values) {
			addCriterion("self_grouplife_refund not in", values, "selfGrouplifeRefund");
			return (Criteria) this;
		}

		public Criteria andSelfGrouplifeRefundBetween(Integer value1, Integer value2) {
			addCriterion("self_grouplife_refund between", value1, value2, "selfGrouplifeRefund");
			return (Criteria) this;
		}

		public Criteria andSelfGrouplifeRefundNotBetween(Integer value1, Integer value2) {
			addCriterion("self_grouplife_refund not between", value1, value2, "selfGrouplifeRefund");
			return (Criteria) this;
		}

		public Criteria andSelfOrderEvaluateIsNull() {
			addCriterion("self_order_evaluate is null");
			return (Criteria) this;
		}

		public Criteria andSelfOrderEvaluateIsNotNull() {
			addCriterion("self_order_evaluate is not null");
			return (Criteria) this;
		}

		public Criteria andSelfOrderEvaluateEqualTo(Integer value) {
			addCriterion("self_order_evaluate =", value, "selfOrderEvaluate");
			return (Criteria) this;
		}

		public Criteria andSelfOrderEvaluateNotEqualTo(Integer value) {
			addCriterion("self_order_evaluate <>", value, "selfOrderEvaluate");
			return (Criteria) this;
		}

		public Criteria andSelfOrderEvaluateGreaterThan(Integer value) {
			addCriterion("self_order_evaluate >", value, "selfOrderEvaluate");
			return (Criteria) this;
		}

		public Criteria andSelfOrderEvaluateGreaterThanOrEqualTo(Integer value) {
			addCriterion("self_order_evaluate >=", value, "selfOrderEvaluate");
			return (Criteria) this;
		}

		public Criteria andSelfOrderEvaluateLessThan(Integer value) {
			addCriterion("self_order_evaluate <", value, "selfOrderEvaluate");
			return (Criteria) this;
		}

		public Criteria andSelfOrderEvaluateLessThanOrEqualTo(Integer value) {
			addCriterion("self_order_evaluate <=", value, "selfOrderEvaluate");
			return (Criteria) this;
		}

		public Criteria andSelfOrderEvaluateIn(List<Integer> values) {
			addCriterion("self_order_evaluate in", values, "selfOrderEvaluate");
			return (Criteria) this;
		}

		public Criteria andSelfOrderEvaluateNotIn(List<Integer> values) {
			addCriterion("self_order_evaluate not in", values, "selfOrderEvaluate");
			return (Criteria) this;
		}

		public Criteria andSelfOrderEvaluateBetween(Integer value1, Integer value2) {
			addCriterion("self_order_evaluate between", value1, value2, "selfOrderEvaluate");
			return (Criteria) this;
		}

		public Criteria andSelfOrderEvaluateNotBetween(Integer value1, Integer value2) {
			addCriterion("self_order_evaluate not between", value1, value2, "selfOrderEvaluate");
			return (Criteria) this;
		}

		public Criteria andSelfOrderPayIsNull() {
			addCriterion("self_order_pay is null");
			return (Criteria) this;
		}

		public Criteria andSelfOrderPayIsNotNull() {
			addCriterion("self_order_pay is not null");
			return (Criteria) this;
		}

		public Criteria andSelfOrderPayEqualTo(Integer value) {
			addCriterion("self_order_pay =", value, "selfOrderPay");
			return (Criteria) this;
		}

		public Criteria andSelfOrderPayNotEqualTo(Integer value) {
			addCriterion("self_order_pay <>", value, "selfOrderPay");
			return (Criteria) this;
		}

		public Criteria andSelfOrderPayGreaterThan(Integer value) {
			addCriterion("self_order_pay >", value, "selfOrderPay");
			return (Criteria) this;
		}

		public Criteria andSelfOrderPayGreaterThanOrEqualTo(Integer value) {
			addCriterion("self_order_pay >=", value, "selfOrderPay");
			return (Criteria) this;
		}

		public Criteria andSelfOrderPayLessThan(Integer value) {
			addCriterion("self_order_pay <", value, "selfOrderPay");
			return (Criteria) this;
		}

		public Criteria andSelfOrderPayLessThanOrEqualTo(Integer value) {
			addCriterion("self_order_pay <=", value, "selfOrderPay");
			return (Criteria) this;
		}

		public Criteria andSelfOrderPayIn(List<Integer> values) {
			addCriterion("self_order_pay in", values, "selfOrderPay");
			return (Criteria) this;
		}

		public Criteria andSelfOrderPayNotIn(List<Integer> values) {
			addCriterion("self_order_pay not in", values, "selfOrderPay");
			return (Criteria) this;
		}

		public Criteria andSelfOrderPayBetween(Integer value1, Integer value2) {
			addCriterion("self_order_pay between", value1, value2, "selfOrderPay");
			return (Criteria) this;
		}

		public Criteria andSelfOrderPayNotBetween(Integer value1, Integer value2) {
			addCriterion("self_order_pay not between", value1, value2, "selfOrderPay");
			return (Criteria) this;
		}

		public Criteria andSelfOrderShippingIsNull() {
			addCriterion("self_order_shipping is null");
			return (Criteria) this;
		}

		public Criteria andSelfOrderShippingIsNotNull() {
			addCriterion("self_order_shipping is not null");
			return (Criteria) this;
		}

		public Criteria andSelfOrderShippingEqualTo(Integer value) {
			addCriterion("self_order_shipping =", value, "selfOrderShipping");
			return (Criteria) this;
		}

		public Criteria andSelfOrderShippingNotEqualTo(Integer value) {
			addCriterion("self_order_shipping <>", value, "selfOrderShipping");
			return (Criteria) this;
		}

		public Criteria andSelfOrderShippingGreaterThan(Integer value) {
			addCriterion("self_order_shipping >", value, "selfOrderShipping");
			return (Criteria) this;
		}

		public Criteria andSelfOrderShippingGreaterThanOrEqualTo(Integer value) {
			addCriterion("self_order_shipping >=", value, "selfOrderShipping");
			return (Criteria) this;
		}

		public Criteria andSelfOrderShippingLessThan(Integer value) {
			addCriterion("self_order_shipping <", value, "selfOrderShipping");
			return (Criteria) this;
		}

		public Criteria andSelfOrderShippingLessThanOrEqualTo(Integer value) {
			addCriterion("self_order_shipping <=", value, "selfOrderShipping");
			return (Criteria) this;
		}

		public Criteria andSelfOrderShippingIn(List<Integer> values) {
			addCriterion("self_order_shipping in", values, "selfOrderShipping");
			return (Criteria) this;
		}

		public Criteria andSelfOrderShippingNotIn(List<Integer> values) {
			addCriterion("self_order_shipping not in", values, "selfOrderShipping");
			return (Criteria) this;
		}

		public Criteria andSelfOrderShippingBetween(Integer value1, Integer value2) {
			addCriterion("self_order_shipping between", value1, value2, "selfOrderShipping");
			return (Criteria) this;
		}

		public Criteria andSelfOrderShippingNotBetween(Integer value1, Integer value2) {
			addCriterion("self_order_shipping not between", value1, value2, "selfOrderShipping");
			return (Criteria) this;
		}

		public Criteria andSelfReturnApplyIsNull() {
			addCriterion("self_return_apply is null");
			return (Criteria) this;
		}

		public Criteria andSelfReturnApplyIsNotNull() {
			addCriterion("self_return_apply is not null");
			return (Criteria) this;
		}

		public Criteria andSelfReturnApplyEqualTo(Integer value) {
			addCriterion("self_return_apply =", value, "selfReturnApply");
			return (Criteria) this;
		}

		public Criteria andSelfReturnApplyNotEqualTo(Integer value) {
			addCriterion("self_return_apply <>", value, "selfReturnApply");
			return (Criteria) this;
		}

		public Criteria andSelfReturnApplyGreaterThan(Integer value) {
			addCriterion("self_return_apply >", value, "selfReturnApply");
			return (Criteria) this;
		}

		public Criteria andSelfReturnApplyGreaterThanOrEqualTo(Integer value) {
			addCriterion("self_return_apply >=", value, "selfReturnApply");
			return (Criteria) this;
		}

		public Criteria andSelfReturnApplyLessThan(Integer value) {
			addCriterion("self_return_apply <", value, "selfReturnApply");
			return (Criteria) this;
		}

		public Criteria andSelfReturnApplyLessThanOrEqualTo(Integer value) {
			addCriterion("self_return_apply <=", value, "selfReturnApply");
			return (Criteria) this;
		}

		public Criteria andSelfReturnApplyIn(List<Integer> values) {
			addCriterion("self_return_apply in", values, "selfReturnApply");
			return (Criteria) this;
		}

		public Criteria andSelfReturnApplyNotIn(List<Integer> values) {
			addCriterion("self_return_apply not in", values, "selfReturnApply");
			return (Criteria) this;
		}

		public Criteria andSelfReturnApplyBetween(Integer value1, Integer value2) {
			addCriterion("self_return_apply between", value1, value2, "selfReturnApply");
			return (Criteria) this;
		}

		public Criteria andSelfReturnApplyNotBetween(Integer value1, Integer value2) {
			addCriterion("self_return_apply not between", value1, value2, "selfReturnApply");
			return (Criteria) this;
		}

		public Criteria andSelfStorageGoodsIsNull() {
			addCriterion("self_storage_goods is null");
			return (Criteria) this;
		}

		public Criteria andSelfStorageGoodsIsNotNull() {
			addCriterion("self_storage_goods is not null");
			return (Criteria) this;
		}

		public Criteria andSelfStorageGoodsEqualTo(Integer value) {
			addCriterion("self_storage_goods =", value, "selfStorageGoods");
			return (Criteria) this;
		}

		public Criteria andSelfStorageGoodsNotEqualTo(Integer value) {
			addCriterion("self_storage_goods <>", value, "selfStorageGoods");
			return (Criteria) this;
		}

		public Criteria andSelfStorageGoodsGreaterThan(Integer value) {
			addCriterion("self_storage_goods >", value, "selfStorageGoods");
			return (Criteria) this;
		}

		public Criteria andSelfStorageGoodsGreaterThanOrEqualTo(Integer value) {
			addCriterion("self_storage_goods >=", value, "selfStorageGoods");
			return (Criteria) this;
		}

		public Criteria andSelfStorageGoodsLessThan(Integer value) {
			addCriterion("self_storage_goods <", value, "selfStorageGoods");
			return (Criteria) this;
		}

		public Criteria andSelfStorageGoodsLessThanOrEqualTo(Integer value) {
			addCriterion("self_storage_goods <=", value, "selfStorageGoods");
			return (Criteria) this;
		}

		public Criteria andSelfStorageGoodsIn(List<Integer> values) {
			addCriterion("self_storage_goods in", values, "selfStorageGoods");
			return (Criteria) this;
		}

		public Criteria andSelfStorageGoodsNotIn(List<Integer> values) {
			addCriterion("self_storage_goods not in", values, "selfStorageGoods");
			return (Criteria) this;
		}

		public Criteria andSelfStorageGoodsBetween(Integer value1, Integer value2) {
			addCriterion("self_storage_goods between", value1, value2, "selfStorageGoods");
			return (Criteria) this;
		}

		public Criteria andSelfStorageGoodsNotBetween(Integer value1, Integer value2) {
			addCriterion("self_storage_goods not between", value1, value2, "selfStorageGoods");
			return (Criteria) this;
		}

		public Criteria andStoreAuditIsNull() {
			addCriterion("store_audit is null");
			return (Criteria) this;
		}

		public Criteria andStoreAuditIsNotNull() {
			addCriterion("store_audit is not null");
			return (Criteria) this;
		}

		public Criteria andStoreAuditEqualTo(Integer value) {
			addCriterion("store_audit =", value, "storeAudit");
			return (Criteria) this;
		}

		public Criteria andStoreAuditNotEqualTo(Integer value) {
			addCriterion("store_audit <>", value, "storeAudit");
			return (Criteria) this;
		}

		public Criteria andStoreAuditGreaterThan(Integer value) {
			addCriterion("store_audit >", value, "storeAudit");
			return (Criteria) this;
		}

		public Criteria andStoreAuditGreaterThanOrEqualTo(Integer value) {
			addCriterion("store_audit >=", value, "storeAudit");
			return (Criteria) this;
		}

		public Criteria andStoreAuditLessThan(Integer value) {
			addCriterion("store_audit <", value, "storeAudit");
			return (Criteria) this;
		}

		public Criteria andStoreAuditLessThanOrEqualTo(Integer value) {
			addCriterion("store_audit <=", value, "storeAudit");
			return (Criteria) this;
		}

		public Criteria andStoreAuditIn(List<Integer> values) {
			addCriterion("store_audit in", values, "storeAudit");
			return (Criteria) this;
		}

		public Criteria andStoreAuditNotIn(List<Integer> values) {
			addCriterion("store_audit not in", values, "storeAudit");
			return (Criteria) this;
		}

		public Criteria andStoreAuditBetween(Integer value1, Integer value2) {
			addCriterion("store_audit between", value1, value2, "storeAudit");
			return (Criteria) this;
		}

		public Criteria andStoreAuditNotBetween(Integer value1, Integer value2) {
			addCriterion("store_audit not between", value1, value2, "storeAudit");
			return (Criteria) this;
		}

		public Criteria andWeekCircleIsNull() {
			addCriterion("week_circle is null");
			return (Criteria) this;
		}

		public Criteria andWeekCircleIsNotNull() {
			addCriterion("week_circle is not null");
			return (Criteria) this;
		}

		public Criteria andWeekCircleEqualTo(Integer value) {
			addCriterion("week_circle =", value, "weekCircle");
			return (Criteria) this;
		}

		public Criteria andWeekCircleNotEqualTo(Integer value) {
			addCriterion("week_circle <>", value, "weekCircle");
			return (Criteria) this;
		}

		public Criteria andWeekCircleGreaterThan(Integer value) {
			addCriterion("week_circle >", value, "weekCircle");
			return (Criteria) this;
		}

		public Criteria andWeekCircleGreaterThanOrEqualTo(Integer value) {
			addCriterion("week_circle >=", value, "weekCircle");
			return (Criteria) this;
		}

		public Criteria andWeekCircleLessThan(Integer value) {
			addCriterion("week_circle <", value, "weekCircle");
			return (Criteria) this;
		}

		public Criteria andWeekCircleLessThanOrEqualTo(Integer value) {
			addCriterion("week_circle <=", value, "weekCircle");
			return (Criteria) this;
		}

		public Criteria andWeekCircleIn(List<Integer> values) {
			addCriterion("week_circle in", values, "weekCircle");
			return (Criteria) this;
		}

		public Criteria andWeekCircleNotIn(List<Integer> values) {
			addCriterion("week_circle not in", values, "weekCircle");
			return (Criteria) this;
		}

		public Criteria andWeekCircleBetween(Integer value1, Integer value2) {
			addCriterion("week_circle between", value1, value2, "weekCircle");
			return (Criteria) this;
		}

		public Criteria andWeekCircleNotBetween(Integer value1, Integer value2) {
			addCriterion("week_circle not between", value1, value2, "weekCircle");
			return (Criteria) this;
		}

		public Criteria andWeekComplaintIsNull() {
			addCriterion("week_complaint is null");
			return (Criteria) this;
		}

		public Criteria andWeekComplaintIsNotNull() {
			addCriterion("week_complaint is not null");
			return (Criteria) this;
		}

		public Criteria andWeekComplaintEqualTo(Integer value) {
			addCriterion("week_complaint =", value, "weekComplaint");
			return (Criteria) this;
		}

		public Criteria andWeekComplaintNotEqualTo(Integer value) {
			addCriterion("week_complaint <>", value, "weekComplaint");
			return (Criteria) this;
		}

		public Criteria andWeekComplaintGreaterThan(Integer value) {
			addCriterion("week_complaint >", value, "weekComplaint");
			return (Criteria) this;
		}

		public Criteria andWeekComplaintGreaterThanOrEqualTo(Integer value) {
			addCriterion("week_complaint >=", value, "weekComplaint");
			return (Criteria) this;
		}

		public Criteria andWeekComplaintLessThan(Integer value) {
			addCriterion("week_complaint <", value, "weekComplaint");
			return (Criteria) this;
		}

		public Criteria andWeekComplaintLessThanOrEqualTo(Integer value) {
			addCriterion("week_complaint <=", value, "weekComplaint");
			return (Criteria) this;
		}

		public Criteria andWeekComplaintIn(List<Integer> values) {
			addCriterion("week_complaint in", values, "weekComplaint");
			return (Criteria) this;
		}

		public Criteria andWeekComplaintNotIn(List<Integer> values) {
			addCriterion("week_complaint not in", values, "weekComplaint");
			return (Criteria) this;
		}

		public Criteria andWeekComplaintBetween(Integer value1, Integer value2) {
			addCriterion("week_complaint between", value1, value2, "weekComplaint");
			return (Criteria) this;
		}

		public Criteria andWeekComplaintNotBetween(Integer value1, Integer value2) {
			addCriterion("week_complaint not between", value1, value2, "weekComplaint");
			return (Criteria) this;
		}

		public Criteria andWeekDeliveryIsNull() {
			addCriterion("week_delivery is null");
			return (Criteria) this;
		}

		public Criteria andWeekDeliveryIsNotNull() {
			addCriterion("week_delivery is not null");
			return (Criteria) this;
		}

		public Criteria andWeekDeliveryEqualTo(Integer value) {
			addCriterion("week_delivery =", value, "weekDelivery");
			return (Criteria) this;
		}

		public Criteria andWeekDeliveryNotEqualTo(Integer value) {
			addCriterion("week_delivery <>", value, "weekDelivery");
			return (Criteria) this;
		}

		public Criteria andWeekDeliveryGreaterThan(Integer value) {
			addCriterion("week_delivery >", value, "weekDelivery");
			return (Criteria) this;
		}

		public Criteria andWeekDeliveryGreaterThanOrEqualTo(Integer value) {
			addCriterion("week_delivery >=", value, "weekDelivery");
			return (Criteria) this;
		}

		public Criteria andWeekDeliveryLessThan(Integer value) {
			addCriterion("week_delivery <", value, "weekDelivery");
			return (Criteria) this;
		}

		public Criteria andWeekDeliveryLessThanOrEqualTo(Integer value) {
			addCriterion("week_delivery <=", value, "weekDelivery");
			return (Criteria) this;
		}

		public Criteria andWeekDeliveryIn(List<Integer> values) {
			addCriterion("week_delivery in", values, "weekDelivery");
			return (Criteria) this;
		}

		public Criteria andWeekDeliveryNotIn(List<Integer> values) {
			addCriterion("week_delivery not in", values, "weekDelivery");
			return (Criteria) this;
		}

		public Criteria andWeekDeliveryBetween(Integer value1, Integer value2) {
			addCriterion("week_delivery between", value1, value2, "weekDelivery");
			return (Criteria) this;
		}

		public Criteria andWeekDeliveryNotBetween(Integer value1, Integer value2) {
			addCriterion("week_delivery not between", value1, value2, "weekDelivery");
			return (Criteria) this;
		}

		public Criteria andWeekGoodsIsNull() {
			addCriterion("week_goods is null");
			return (Criteria) this;
		}

		public Criteria andWeekGoodsIsNotNull() {
			addCriterion("week_goods is not null");
			return (Criteria) this;
		}

		public Criteria andWeekGoodsEqualTo(Integer value) {
			addCriterion("week_goods =", value, "weekGoods");
			return (Criteria) this;
		}

		public Criteria andWeekGoodsNotEqualTo(Integer value) {
			addCriterion("week_goods <>", value, "weekGoods");
			return (Criteria) this;
		}

		public Criteria andWeekGoodsGreaterThan(Integer value) {
			addCriterion("week_goods >", value, "weekGoods");
			return (Criteria) this;
		}

		public Criteria andWeekGoodsGreaterThanOrEqualTo(Integer value) {
			addCriterion("week_goods >=", value, "weekGoods");
			return (Criteria) this;
		}

		public Criteria andWeekGoodsLessThan(Integer value) {
			addCriterion("week_goods <", value, "weekGoods");
			return (Criteria) this;
		}

		public Criteria andWeekGoodsLessThanOrEqualTo(Integer value) {
			addCriterion("week_goods <=", value, "weekGoods");
			return (Criteria) this;
		}

		public Criteria andWeekGoodsIn(List<Integer> values) {
			addCriterion("week_goods in", values, "weekGoods");
			return (Criteria) this;
		}

		public Criteria andWeekGoodsNotIn(List<Integer> values) {
			addCriterion("week_goods not in", values, "weekGoods");
			return (Criteria) this;
		}

		public Criteria andWeekGoodsBetween(Integer value1, Integer value2) {
			addCriterion("week_goods between", value1, value2, "weekGoods");
			return (Criteria) this;
		}

		public Criteria andWeekGoodsNotBetween(Integer value1, Integer value2) {
			addCriterion("week_goods not between", value1, value2, "weekGoods");
			return (Criteria) this;
		}

		public Criteria andWeekGoodsGroupIsNull() {
			addCriterion("week_goods_group is null");
			return (Criteria) this;
		}

		public Criteria andWeekGoodsGroupIsNotNull() {
			addCriterion("week_goods_group is not null");
			return (Criteria) this;
		}

		public Criteria andWeekGoodsGroupEqualTo(Integer value) {
			addCriterion("week_goods_group =", value, "weekGoodsGroup");
			return (Criteria) this;
		}

		public Criteria andWeekGoodsGroupNotEqualTo(Integer value) {
			addCriterion("week_goods_group <>", value, "weekGoodsGroup");
			return (Criteria) this;
		}

		public Criteria andWeekGoodsGroupGreaterThan(Integer value) {
			addCriterion("week_goods_group >", value, "weekGoodsGroup");
			return (Criteria) this;
		}

		public Criteria andWeekGoodsGroupGreaterThanOrEqualTo(Integer value) {
			addCriterion("week_goods_group >=", value, "weekGoodsGroup");
			return (Criteria) this;
		}

		public Criteria andWeekGoodsGroupLessThan(Integer value) {
			addCriterion("week_goods_group <", value, "weekGoodsGroup");
			return (Criteria) this;
		}

		public Criteria andWeekGoodsGroupLessThanOrEqualTo(Integer value) {
			addCriterion("week_goods_group <=", value, "weekGoodsGroup");
			return (Criteria) this;
		}

		public Criteria andWeekGoodsGroupIn(List<Integer> values) {
			addCriterion("week_goods_group in", values, "weekGoodsGroup");
			return (Criteria) this;
		}

		public Criteria andWeekGoodsGroupNotIn(List<Integer> values) {
			addCriterion("week_goods_group not in", values, "weekGoodsGroup");
			return (Criteria) this;
		}

		public Criteria andWeekGoodsGroupBetween(Integer value1, Integer value2) {
			addCriterion("week_goods_group between", value1, value2, "weekGoodsGroup");
			return (Criteria) this;
		}

		public Criteria andWeekGoodsGroupNotBetween(Integer value1, Integer value2) {
			addCriterion("week_goods_group not between", value1, value2, "weekGoodsGroup");
			return (Criteria) this;
		}

		public Criteria andWeekInformationIsNull() {
			addCriterion("week_information is null");
			return (Criteria) this;
		}

		public Criteria andWeekInformationIsNotNull() {
			addCriterion("week_information is not null");
			return (Criteria) this;
		}

		public Criteria andWeekInformationEqualTo(Integer value) {
			addCriterion("week_information =", value, "weekInformation");
			return (Criteria) this;
		}

		public Criteria andWeekInformationNotEqualTo(Integer value) {
			addCriterion("week_information <>", value, "weekInformation");
			return (Criteria) this;
		}

		public Criteria andWeekInformationGreaterThan(Integer value) {
			addCriterion("week_information >", value, "weekInformation");
			return (Criteria) this;
		}

		public Criteria andWeekInformationGreaterThanOrEqualTo(Integer value) {
			addCriterion("week_information >=", value, "weekInformation");
			return (Criteria) this;
		}

		public Criteria andWeekInformationLessThan(Integer value) {
			addCriterion("week_information <", value, "weekInformation");
			return (Criteria) this;
		}

		public Criteria andWeekInformationLessThanOrEqualTo(Integer value) {
			addCriterion("week_information <=", value, "weekInformation");
			return (Criteria) this;
		}

		public Criteria andWeekInformationIn(List<Integer> values) {
			addCriterion("week_information in", values, "weekInformation");
			return (Criteria) this;
		}

		public Criteria andWeekInformationNotIn(List<Integer> values) {
			addCriterion("week_information not in", values, "weekInformation");
			return (Criteria) this;
		}

		public Criteria andWeekInformationBetween(Integer value1, Integer value2) {
			addCriterion("week_information between", value1, value2, "weekInformation");
			return (Criteria) this;
		}

		public Criteria andWeekInformationNotBetween(Integer value1, Integer value2) {
			addCriterion("week_information not between", value1, value2, "weekInformation");
			return (Criteria) this;
		}

		public Criteria andWeekInvitationIsNull() {
			addCriterion("week_invitation is null");
			return (Criteria) this;
		}

		public Criteria andWeekInvitationIsNotNull() {
			addCriterion("week_invitation is not null");
			return (Criteria) this;
		}

		public Criteria andWeekInvitationEqualTo(Integer value) {
			addCriterion("week_invitation =", value, "weekInvitation");
			return (Criteria) this;
		}

		public Criteria andWeekInvitationNotEqualTo(Integer value) {
			addCriterion("week_invitation <>", value, "weekInvitation");
			return (Criteria) this;
		}

		public Criteria andWeekInvitationGreaterThan(Integer value) {
			addCriterion("week_invitation >", value, "weekInvitation");
			return (Criteria) this;
		}

		public Criteria andWeekInvitationGreaterThanOrEqualTo(Integer value) {
			addCriterion("week_invitation >=", value, "weekInvitation");
			return (Criteria) this;
		}

		public Criteria andWeekInvitationLessThan(Integer value) {
			addCriterion("week_invitation <", value, "weekInvitation");
			return (Criteria) this;
		}

		public Criteria andWeekInvitationLessThanOrEqualTo(Integer value) {
			addCriterion("week_invitation <=", value, "weekInvitation");
			return (Criteria) this;
		}

		public Criteria andWeekInvitationIn(List<Integer> values) {
			addCriterion("week_invitation in", values, "weekInvitation");
			return (Criteria) this;
		}

		public Criteria andWeekInvitationNotIn(List<Integer> values) {
			addCriterion("week_invitation not in", values, "weekInvitation");
			return (Criteria) this;
		}

		public Criteria andWeekInvitationBetween(Integer value1, Integer value2) {
			addCriterion("week_invitation between", value1, value2, "weekInvitation");
			return (Criteria) this;
		}

		public Criteria andWeekInvitationNotBetween(Integer value1, Integer value2) {
			addCriterion("week_invitation not between", value1, value2, "weekInvitation");
			return (Criteria) this;
		}

		public Criteria andWeekLifeGroupIsNull() {
			addCriterion("week_life_group is null");
			return (Criteria) this;
		}

		public Criteria andWeekLifeGroupIsNotNull() {
			addCriterion("week_life_group is not null");
			return (Criteria) this;
		}

		public Criteria andWeekLifeGroupEqualTo(Integer value) {
			addCriterion("week_life_group =", value, "weekLifeGroup");
			return (Criteria) this;
		}

		public Criteria andWeekLifeGroupNotEqualTo(Integer value) {
			addCriterion("week_life_group <>", value, "weekLifeGroup");
			return (Criteria) this;
		}

		public Criteria andWeekLifeGroupGreaterThan(Integer value) {
			addCriterion("week_life_group >", value, "weekLifeGroup");
			return (Criteria) this;
		}

		public Criteria andWeekLifeGroupGreaterThanOrEqualTo(Integer value) {
			addCriterion("week_life_group >=", value, "weekLifeGroup");
			return (Criteria) this;
		}

		public Criteria andWeekLifeGroupLessThan(Integer value) {
			addCriterion("week_life_group <", value, "weekLifeGroup");
			return (Criteria) this;
		}

		public Criteria andWeekLifeGroupLessThanOrEqualTo(Integer value) {
			addCriterion("week_life_group <=", value, "weekLifeGroup");
			return (Criteria) this;
		}

		public Criteria andWeekLifeGroupIn(List<Integer> values) {
			addCriterion("week_life_group in", values, "weekLifeGroup");
			return (Criteria) this;
		}

		public Criteria andWeekLifeGroupNotIn(List<Integer> values) {
			addCriterion("week_life_group not in", values, "weekLifeGroup");
			return (Criteria) this;
		}

		public Criteria andWeekLifeGroupBetween(Integer value1, Integer value2) {
			addCriterion("week_life_group between", value1, value2, "weekLifeGroup");
			return (Criteria) this;
		}

		public Criteria andWeekLifeGroupNotBetween(Integer value1, Integer value2) {
			addCriterion("week_life_group not between", value1, value2, "weekLifeGroup");
			return (Criteria) this;
		}

		public Criteria andWeekLiveUserIsNull() {
			addCriterion("week_live_user is null");
			return (Criteria) this;
		}

		public Criteria andWeekLiveUserIsNotNull() {
			addCriterion("week_live_user is not null");
			return (Criteria) this;
		}

		public Criteria andWeekLiveUserEqualTo(Integer value) {
			addCriterion("week_live_user =", value, "weekLiveUser");
			return (Criteria) this;
		}

		public Criteria andWeekLiveUserNotEqualTo(Integer value) {
			addCriterion("week_live_user <>", value, "weekLiveUser");
			return (Criteria) this;
		}

		public Criteria andWeekLiveUserGreaterThan(Integer value) {
			addCriterion("week_live_user >", value, "weekLiveUser");
			return (Criteria) this;
		}

		public Criteria andWeekLiveUserGreaterThanOrEqualTo(Integer value) {
			addCriterion("week_live_user >=", value, "weekLiveUser");
			return (Criteria) this;
		}

		public Criteria andWeekLiveUserLessThan(Integer value) {
			addCriterion("week_live_user <", value, "weekLiveUser");
			return (Criteria) this;
		}

		public Criteria andWeekLiveUserLessThanOrEqualTo(Integer value) {
			addCriterion("week_live_user <=", value, "weekLiveUser");
			return (Criteria) this;
		}

		public Criteria andWeekLiveUserIn(List<Integer> values) {
			addCriterion("week_live_user in", values, "weekLiveUser");
			return (Criteria) this;
		}

		public Criteria andWeekLiveUserNotIn(List<Integer> values) {
			addCriterion("week_live_user not in", values, "weekLiveUser");
			return (Criteria) this;
		}

		public Criteria andWeekLiveUserBetween(Integer value1, Integer value2) {
			addCriterion("week_live_user between", value1, value2, "weekLiveUser");
			return (Criteria) this;
		}

		public Criteria andWeekLiveUserNotBetween(Integer value1, Integer value2) {
			addCriterion("week_live_user not between", value1, value2, "weekLiveUser");
			return (Criteria) this;
		}

		public Criteria andWeekOrderIsNull() {
			addCriterion("week_order is null");
			return (Criteria) this;
		}

		public Criteria andWeekOrderIsNotNull() {
			addCriterion("week_order is not null");
			return (Criteria) this;
		}

		public Criteria andWeekOrderEqualTo(Integer value) {
			addCriterion("week_order =", value, "weekOrder");
			return (Criteria) this;
		}

		public Criteria andWeekOrderNotEqualTo(Integer value) {
			addCriterion("week_order <>", value, "weekOrder");
			return (Criteria) this;
		}

		public Criteria andWeekOrderGreaterThan(Integer value) {
			addCriterion("week_order >", value, "weekOrder");
			return (Criteria) this;
		}

		public Criteria andWeekOrderGreaterThanOrEqualTo(Integer value) {
			addCriterion("week_order >=", value, "weekOrder");
			return (Criteria) this;
		}

		public Criteria andWeekOrderLessThan(Integer value) {
			addCriterion("week_order <", value, "weekOrder");
			return (Criteria) this;
		}

		public Criteria andWeekOrderLessThanOrEqualTo(Integer value) {
			addCriterion("week_order <=", value, "weekOrder");
			return (Criteria) this;
		}

		public Criteria andWeekOrderIn(List<Integer> values) {
			addCriterion("week_order in", values, "weekOrder");
			return (Criteria) this;
		}

		public Criteria andWeekOrderNotIn(List<Integer> values) {
			addCriterion("week_order not in", values, "weekOrder");
			return (Criteria) this;
		}

		public Criteria andWeekOrderBetween(Integer value1, Integer value2) {
			addCriterion("week_order between", value1, value2, "weekOrder");
			return (Criteria) this;
		}

		public Criteria andWeekOrderNotBetween(Integer value1, Integer value2) {
			addCriterion("week_order not between", value1, value2, "weekOrder");
			return (Criteria) this;
		}

		public Criteria andWeekStoreIsNull() {
			addCriterion("week_store is null");
			return (Criteria) this;
		}

		public Criteria andWeekStoreIsNotNull() {
			addCriterion("week_store is not null");
			return (Criteria) this;
		}

		public Criteria andWeekStoreEqualTo(Integer value) {
			addCriterion("week_store =", value, "weekStore");
			return (Criteria) this;
		}

		public Criteria andWeekStoreNotEqualTo(Integer value) {
			addCriterion("week_store <>", value, "weekStore");
			return (Criteria) this;
		}

		public Criteria andWeekStoreGreaterThan(Integer value) {
			addCriterion("week_store >", value, "weekStore");
			return (Criteria) this;
		}

		public Criteria andWeekStoreGreaterThanOrEqualTo(Integer value) {
			addCriterion("week_store >=", value, "weekStore");
			return (Criteria) this;
		}

		public Criteria andWeekStoreLessThan(Integer value) {
			addCriterion("week_store <", value, "weekStore");
			return (Criteria) this;
		}

		public Criteria andWeekStoreLessThanOrEqualTo(Integer value) {
			addCriterion("week_store <=", value, "weekStore");
			return (Criteria) this;
		}

		public Criteria andWeekStoreIn(List<Integer> values) {
			addCriterion("week_store in", values, "weekStore");
			return (Criteria) this;
		}

		public Criteria andWeekStoreNotIn(List<Integer> values) {
			addCriterion("week_store not in", values, "weekStore");
			return (Criteria) this;
		}

		public Criteria andWeekStoreBetween(Integer value1, Integer value2) {
			addCriterion("week_store between", value1, value2, "weekStore");
			return (Criteria) this;
		}

		public Criteria andWeekStoreNotBetween(Integer value1, Integer value2) {
			addCriterion("week_store not between", value1, value2, "weekStore");
			return (Criteria) this;
		}

		public Criteria andWeekUserIsNull() {
			addCriterion("week_user is null");
			return (Criteria) this;
		}

		public Criteria andWeekUserIsNotNull() {
			addCriterion("week_user is not null");
			return (Criteria) this;
		}

		public Criteria andWeekUserEqualTo(Integer value) {
			addCriterion("week_user =", value, "weekUser");
			return (Criteria) this;
		}

		public Criteria andWeekUserNotEqualTo(Integer value) {
			addCriterion("week_user <>", value, "weekUser");
			return (Criteria) this;
		}

		public Criteria andWeekUserGreaterThan(Integer value) {
			addCriterion("week_user >", value, "weekUser");
			return (Criteria) this;
		}

		public Criteria andWeekUserGreaterThanOrEqualTo(Integer value) {
			addCriterion("week_user >=", value, "weekUser");
			return (Criteria) this;
		}

		public Criteria andWeekUserLessThan(Integer value) {
			addCriterion("week_user <", value, "weekUser");
			return (Criteria) this;
		}

		public Criteria andWeekUserLessThanOrEqualTo(Integer value) {
			addCriterion("week_user <=", value, "weekUser");
			return (Criteria) this;
		}

		public Criteria andWeekUserIn(List<Integer> values) {
			addCriterion("week_user in", values, "weekUser");
			return (Criteria) this;
		}

		public Criteria andWeekUserNotIn(List<Integer> values) {
			addCriterion("week_user not in", values, "weekUser");
			return (Criteria) this;
		}

		public Criteria andWeekUserBetween(Integer value1, Integer value2) {
			addCriterion("week_user between", value1, value2, "weekUser");
			return (Criteria) this;
		}

		public Criteria andWeekUserNotBetween(Integer value1, Integer value2) {
			addCriterion("week_user not between", value1, value2, "weekUser");
			return (Criteria) this;
		}

		public Criteria andWeekZtcIsNull() {
			addCriterion("week_ztc is null");
			return (Criteria) this;
		}

		public Criteria andWeekZtcIsNotNull() {
			addCriterion("week_ztc is not null");
			return (Criteria) this;
		}

		public Criteria andWeekZtcEqualTo(Integer value) {
			addCriterion("week_ztc =", value, "weekZtc");
			return (Criteria) this;
		}

		public Criteria andWeekZtcNotEqualTo(Integer value) {
			addCriterion("week_ztc <>", value, "weekZtc");
			return (Criteria) this;
		}

		public Criteria andWeekZtcGreaterThan(Integer value) {
			addCriterion("week_ztc >", value, "weekZtc");
			return (Criteria) this;
		}

		public Criteria andWeekZtcGreaterThanOrEqualTo(Integer value) {
			addCriterion("week_ztc >=", value, "weekZtc");
			return (Criteria) this;
		}

		public Criteria andWeekZtcLessThan(Integer value) {
			addCriterion("week_ztc <", value, "weekZtc");
			return (Criteria) this;
		}

		public Criteria andWeekZtcLessThanOrEqualTo(Integer value) {
			addCriterion("week_ztc <=", value, "weekZtc");
			return (Criteria) this;
		}

		public Criteria andWeekZtcIn(List<Integer> values) {
			addCriterion("week_ztc in", values, "weekZtc");
			return (Criteria) this;
		}

		public Criteria andWeekZtcNotIn(List<Integer> values) {
			addCriterion("week_ztc not in", values, "weekZtc");
			return (Criteria) this;
		}

		public Criteria andWeekZtcBetween(Integer value1, Integer value2) {
			addCriterion("week_ztc between", value1, value2, "weekZtc");
			return (Criteria) this;
		}

		public Criteria andWeekZtcNotBetween(Integer value1, Integer value2) {
			addCriterion("week_ztc not between", value1, value2, "weekZtc");
			return (Criteria) this;
		}

		public Criteria andZtcAuditCountIsNull() {
			addCriterion("ztc_audit_count is null");
			return (Criteria) this;
		}

		public Criteria andZtcAuditCountIsNotNull() {
			addCriterion("ztc_audit_count is not null");
			return (Criteria) this;
		}

		public Criteria andZtcAuditCountEqualTo(Integer value) {
			addCriterion("ztc_audit_count =", value, "ztcAuditCount");
			return (Criteria) this;
		}

		public Criteria andZtcAuditCountNotEqualTo(Integer value) {
			addCriterion("ztc_audit_count <>", value, "ztcAuditCount");
			return (Criteria) this;
		}

		public Criteria andZtcAuditCountGreaterThan(Integer value) {
			addCriterion("ztc_audit_count >", value, "ztcAuditCount");
			return (Criteria) this;
		}

		public Criteria andZtcAuditCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("ztc_audit_count >=", value, "ztcAuditCount");
			return (Criteria) this;
		}

		public Criteria andZtcAuditCountLessThan(Integer value) {
			addCriterion("ztc_audit_count <", value, "ztcAuditCount");
			return (Criteria) this;
		}

		public Criteria andZtcAuditCountLessThanOrEqualTo(Integer value) {
			addCriterion("ztc_audit_count <=", value, "ztcAuditCount");
			return (Criteria) this;
		}

		public Criteria andZtcAuditCountIn(List<Integer> values) {
			addCriterion("ztc_audit_count in", values, "ztcAuditCount");
			return (Criteria) this;
		}

		public Criteria andZtcAuditCountNotIn(List<Integer> values) {
			addCriterion("ztc_audit_count not in", values, "ztcAuditCount");
			return (Criteria) this;
		}

		public Criteria andZtcAuditCountBetween(Integer value1, Integer value2) {
			addCriterion("ztc_audit_count between", value1, value2, "ztcAuditCount");
			return (Criteria) this;
		}

		public Criteria andZtcAuditCountNotBetween(Integer value1, Integer value2) {
			addCriterion("ztc_audit_count not between", value1, value2, "ztcAuditCount");
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