package com.sinco.carnation.juanpi.model;

import com.sinco.carnation.juanpi.bo.JuanpiOrderGoodsBO;
import com.sinco.mybatis.dal.core.AbstractExample;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JuanpiOrderGoodsExample extends AbstractExample<JuanpiOrderGoodsBO> {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String limit;

    public JuanpiOrderGoodsExample() {
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
        this.limit = new StringBuilder().append(String.valueOf(offset)).append(",").append(String.valueOf(rows)).toString();
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

        public Criteria andGoodsidIsNull() {
            addCriterion("goodsid is null");
            return (Criteria) this;
        }

        public Criteria andGoodsidIsNotNull() {
            addCriterion("goodsid is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsidEqualTo(Long value) {
            addCriterion("goodsid =", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotEqualTo(Long value) {
            addCriterion("goodsid <>", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidGreaterThan(Long value) {
            addCriterion("goodsid >", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidGreaterThanOrEqualTo(Long value) {
            addCriterion("goodsid >=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLessThan(Long value) {
            addCriterion("goodsid <", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLessThanOrEqualTo(Long value) {
            addCriterion("goodsid <=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidIn(List<Long> values) {
            addCriterion("goodsid in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotIn(List<Long> values) {
            addCriterion("goodsid not in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidBetween(Long value1, Long value2) {
            addCriterion("goodsid between", value1, value2, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotBetween(Long value1, Long value2) {
            addCriterion("goodsid not between", value1, value2, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodstitleIsNull() {
            addCriterion("goodstitle is null");
            return (Criteria) this;
        }

        public Criteria andGoodstitleIsNotNull() {
            addCriterion("goodstitle is not null");
            return (Criteria) this;
        }

        public Criteria andGoodstitleEqualTo(String value) {
            addCriterion("goodstitle =", value, "goodstitle");
            return (Criteria) this;
        }

        public Criteria andGoodstitleNotEqualTo(String value) {
            addCriterion("goodstitle <>", value, "goodstitle");
            return (Criteria) this;
        }

        public Criteria andGoodstitleGreaterThan(String value) {
            addCriterion("goodstitle >", value, "goodstitle");
            return (Criteria) this;
        }

        public Criteria andGoodstitleGreaterThanOrEqualTo(String value) {
            addCriterion("goodstitle >=", value, "goodstitle");
            return (Criteria) this;
        }

        public Criteria andGoodstitleLessThan(String value) {
            addCriterion("goodstitle <", value, "goodstitle");
            return (Criteria) this;
        }

        public Criteria andGoodstitleLessThanOrEqualTo(String value) {
            addCriterion("goodstitle <=", value, "goodstitle");
            return (Criteria) this;
        }

        public Criteria andGoodstitleLike(String value) {
            addCriterion("goodstitle like", value, "goodstitle");
            return (Criteria) this;
        }

        public Criteria andGoodstitleNotLike(String value) {
            addCriterion("goodstitle not like", value, "goodstitle");
            return (Criteria) this;
        }

        public Criteria andGoodstitleIn(List<String> values) {
            addCriterion("goodstitle in", values, "goodstitle");
            return (Criteria) this;
        }

        public Criteria andGoodstitleNotIn(List<String> values) {
            addCriterion("goodstitle not in", values, "goodstitle");
            return (Criteria) this;
        }

        public Criteria andGoodstitleBetween(String value1, String value2) {
            addCriterion("goodstitle between", value1, value2, "goodstitle");
            return (Criteria) this;
        }

        public Criteria andGoodstitleNotBetween(String value1, String value2) {
            addCriterion("goodstitle not between", value1, value2, "goodstitle");
            return (Criteria) this;
        }

        public Criteria andGoodsnumberIsNull() {
            addCriterion("goodsnumber is null");
            return (Criteria) this;
        }

        public Criteria andGoodsnumberIsNotNull() {
            addCriterion("goodsnumber is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsnumberEqualTo(Long value) {
            addCriterion("goodsnumber =", value, "goodsnumber");
            return (Criteria) this;
        }

        public Criteria andGoodsnumberNotEqualTo(Long value) {
            addCriterion("goodsnumber <>", value, "goodsnumber");
            return (Criteria) this;
        }

        public Criteria andGoodsnumberGreaterThan(Long value) {
            addCriterion("goodsnumber >", value, "goodsnumber");
            return (Criteria) this;
        }

        public Criteria andGoodsnumberGreaterThanOrEqualTo(Long value) {
            addCriterion("goodsnumber >=", value, "goodsnumber");
            return (Criteria) this;
        }

        public Criteria andGoodsnumberLessThan(Long value) {
            addCriterion("goodsnumber <", value, "goodsnumber");
            return (Criteria) this;
        }

        public Criteria andGoodsnumberLessThanOrEqualTo(Long value) {
            addCriterion("goodsnumber <=", value, "goodsnumber");
            return (Criteria) this;
        }

        public Criteria andGoodsnumberIn(List<Long> values) {
            addCriterion("goodsnumber in", values, "goodsnumber");
            return (Criteria) this;
        }

        public Criteria andGoodsnumberNotIn(List<Long> values) {
            addCriterion("goodsnumber not in", values, "goodsnumber");
            return (Criteria) this;
        }

        public Criteria andGoodsnumberBetween(Long value1, Long value2) {
            addCriterion("goodsnumber between", value1, value2, "goodsnumber");
            return (Criteria) this;
        }

        public Criteria andGoodsnumberNotBetween(Long value1, Long value2) {
            addCriterion("goodsnumber not between", value1, value2, "goodsnumber");
            return (Criteria) this;
        }

        public Criteria andGoodsmoneyIsNull() {
            addCriterion("goodsmoney is null");
            return (Criteria) this;
        }

        public Criteria andGoodsmoneyIsNotNull() {
            addCriterion("goodsmoney is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsmoneyEqualTo(BigDecimal value) {
            addCriterion("goodsmoney =", value, "goodsmoney");
            return (Criteria) this;
        }

        public Criteria andGoodsmoneyNotEqualTo(BigDecimal value) {
            addCriterion("goodsmoney <>", value, "goodsmoney");
            return (Criteria) this;
        }

        public Criteria andGoodsmoneyGreaterThan(BigDecimal value) {
            addCriterion("goodsmoney >", value, "goodsmoney");
            return (Criteria) this;
        }

        public Criteria andGoodsmoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("goodsmoney >=", value, "goodsmoney");
            return (Criteria) this;
        }

        public Criteria andGoodsmoneyLessThan(BigDecimal value) {
            addCriterion("goodsmoney <", value, "goodsmoney");
            return (Criteria) this;
        }

        public Criteria andGoodsmoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("goodsmoney <=", value, "goodsmoney");
            return (Criteria) this;
        }

        public Criteria andGoodsmoneyIn(List<BigDecimal> values) {
            addCriterion("goodsmoney in", values, "goodsmoney");
            return (Criteria) this;
        }

        public Criteria andGoodsmoneyNotIn(List<BigDecimal> values) {
            addCriterion("goodsmoney not in", values, "goodsmoney");
            return (Criteria) this;
        }

        public Criteria andGoodsmoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goodsmoney between", value1, value2, "goodsmoney");
            return (Criteria) this;
        }

        public Criteria andGoodsmoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goodsmoney not between", value1, value2, "goodsmoney");
            return (Criteria) this;
        }

        public Criteria andBrokerageratiocaleIsNull() {
            addCriterion("brokerageratiocale is null");
            return (Criteria) this;
        }

        public Criteria andBrokerageratiocaleIsNotNull() {
            addCriterion("brokerageratiocale is not null");
            return (Criteria) this;
        }

        public Criteria andBrokerageratiocaleEqualTo(BigDecimal value) {
            addCriterion("brokerageratiocale =", value, "brokerageratiocale");
            return (Criteria) this;
        }

        public Criteria andBrokerageratiocaleNotEqualTo(BigDecimal value) {
            addCriterion("brokerageratiocale <>", value, "brokerageratiocale");
            return (Criteria) this;
        }

        public Criteria andBrokerageratiocaleGreaterThan(BigDecimal value) {
            addCriterion("brokerageratiocale >", value, "brokerageratiocale");
            return (Criteria) this;
        }

        public Criteria andBrokerageratiocaleGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("brokerageratiocale >=", value, "brokerageratiocale");
            return (Criteria) this;
        }

        public Criteria andBrokerageratiocaleLessThan(BigDecimal value) {
            addCriterion("brokerageratiocale <", value, "brokerageratiocale");
            return (Criteria) this;
        }

        public Criteria andBrokerageratiocaleLessThanOrEqualTo(BigDecimal value) {
            addCriterion("brokerageratiocale <=", value, "brokerageratiocale");
            return (Criteria) this;
        }

        public Criteria andBrokerageratiocaleIn(List<BigDecimal> values) {
            addCriterion("brokerageratiocale in", values, "brokerageratiocale");
            return (Criteria) this;
        }

        public Criteria andBrokerageratiocaleNotIn(List<BigDecimal> values) {
            addCriterion("brokerageratiocale not in", values, "brokerageratiocale");
            return (Criteria) this;
        }

        public Criteria andBrokerageratiocaleBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("brokerageratiocale between", value1, value2, "brokerageratiocale");
            return (Criteria) this;
        }

        public Criteria andBrokerageratiocaleNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("brokerageratiocale not between", value1, value2, "brokerageratiocale");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNull() {
            addCriterion("commission is null");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNotNull() {
            addCriterion("commission is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionEqualTo(BigDecimal value) {
            addCriterion("commission =", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotEqualTo(BigDecimal value) {
            addCriterion("commission <>", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThan(BigDecimal value) {
            addCriterion("commission >", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("commission >=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThan(BigDecimal value) {
            addCriterion("commission <", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("commission <=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionIn(List<BigDecimal> values) {
            addCriterion("commission in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotIn(List<BigDecimal> values) {
            addCriterion("commission not in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission not between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andYunCommissionIsNull() {
            addCriterion("yun_commission is null");
            return (Criteria) this;
        }

        public Criteria andYunCommissionIsNotNull() {
            addCriterion("yun_commission is not null");
            return (Criteria) this;
        }

        public Criteria andYunCommissionEqualTo(BigDecimal value) {
            addCriterion("yun_commission =", value, "yunCommission");
            return (Criteria) this;
        }

        public Criteria andYunCommissionNotEqualTo(BigDecimal value) {
            addCriterion("yun_commission <>", value, "yunCommission");
            return (Criteria) this;
        }

        public Criteria andYunCommissionGreaterThan(BigDecimal value) {
            addCriterion("yun_commission >", value, "yunCommission");
            return (Criteria) this;
        }

        public Criteria andYunCommissionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("yun_commission >=", value, "yunCommission");
            return (Criteria) this;
        }

        public Criteria andYunCommissionLessThan(BigDecimal value) {
            addCriterion("yun_commission <", value, "yunCommission");
            return (Criteria) this;
        }

        public Criteria andYunCommissionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("yun_commission <=", value, "yunCommission");
            return (Criteria) this;
        }

        public Criteria andYunCommissionIn(List<BigDecimal> values) {
            addCriterion("yun_commission in", values, "yunCommission");
            return (Criteria) this;
        }

        public Criteria andYunCommissionNotIn(List<BigDecimal> values) {
            addCriterion("yun_commission not in", values, "yunCommission");
            return (Criteria) this;
        }

        public Criteria andYunCommissionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("yun_commission between", value1, value2, "yunCommission");
            return (Criteria) this;
        }

        public Criteria andYunCommissionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("yun_commission not between", value1, value2, "yunCommission");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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