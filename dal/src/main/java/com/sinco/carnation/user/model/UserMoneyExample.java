package com.sinco.carnation.user.model;

import com.sinco.carnation.user.bo.UserMoneyBO;
import com.sinco.mybatis.dal.core.AbstractExample;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UserMoneyExample extends AbstractExample<UserMoneyBO> {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String limit;

    public UserMoneyExample() {
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

        public Criteria andAvailableBalanceIsNull() {
            addCriterion("available_balance is null");
            return (Criteria) this;
        }

        public Criteria andAvailableBalanceIsNotNull() {
            addCriterion("available_balance is not null");
            return (Criteria) this;
        }

        public Criteria andAvailableBalanceEqualTo(BigDecimal value) {
            addCriterion("available_balance =", value, "availableBalance");
            return (Criteria) this;
        }

        public Criteria andAvailableBalanceNotEqualTo(BigDecimal value) {
            addCriterion("available_balance <>", value, "availableBalance");
            return (Criteria) this;
        }

        public Criteria andAvailableBalanceGreaterThan(BigDecimal value) {
            addCriterion("available_balance >", value, "availableBalance");
            return (Criteria) this;
        }

        public Criteria andAvailableBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("available_balance >=", value, "availableBalance");
            return (Criteria) this;
        }

        public Criteria andAvailableBalanceLessThan(BigDecimal value) {
            addCriterion("available_balance <", value, "availableBalance");
            return (Criteria) this;
        }

        public Criteria andAvailableBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("available_balance <=", value, "availableBalance");
            return (Criteria) this;
        }

        public Criteria andAvailableBalanceIn(List<BigDecimal> values) {
            addCriterion("available_balance in", values, "availableBalance");
            return (Criteria) this;
        }

        public Criteria andAvailableBalanceNotIn(List<BigDecimal> values) {
            addCriterion("available_balance not in", values, "availableBalance");
            return (Criteria) this;
        }

        public Criteria andAvailableBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("available_balance between", value1, value2, "availableBalance");
            return (Criteria) this;
        }

        public Criteria andAvailableBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("available_balance not between", value1, value2, "availableBalance");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andRecordBalanceIsNull() {
            addCriterion("record_balance is null");
            return (Criteria) this;
        }

        public Criteria andRecordBalanceIsNotNull() {
            addCriterion("record_balance is not null");
            return (Criteria) this;
        }

        public Criteria andRecordBalanceEqualTo(BigDecimal value) {
            addCriterion("record_balance =", value, "recordBalance");
            return (Criteria) this;
        }

        public Criteria andRecordBalanceNotEqualTo(BigDecimal value) {
            addCriterion("record_balance <>", value, "recordBalance");
            return (Criteria) this;
        }

        public Criteria andRecordBalanceGreaterThan(BigDecimal value) {
            addCriterion("record_balance >", value, "recordBalance");
            return (Criteria) this;
        }

        public Criteria andRecordBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("record_balance >=", value, "recordBalance");
            return (Criteria) this;
        }

        public Criteria andRecordBalanceLessThan(BigDecimal value) {
            addCriterion("record_balance <", value, "recordBalance");
            return (Criteria) this;
        }

        public Criteria andRecordBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("record_balance <=", value, "recordBalance");
            return (Criteria) this;
        }

        public Criteria andRecordBalanceIn(List<BigDecimal> values) {
            addCriterion("record_balance in", values, "recordBalance");
            return (Criteria) this;
        }

        public Criteria andRecordBalanceNotIn(List<BigDecimal> values) {
            addCriterion("record_balance not in", values, "recordBalance");
            return (Criteria) this;
        }

        public Criteria andRecordBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("record_balance between", value1, value2, "recordBalance");
            return (Criteria) this;
        }

        public Criteria andRecordBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("record_balance not between", value1, value2, "recordBalance");
            return (Criteria) this;
        }

        public Criteria andO2oBalanceIsNull() {
            addCriterion("o2o_balance is null");
            return (Criteria) this;
        }

        public Criteria andO2oBalanceIsNotNull() {
            addCriterion("o2o_balance is not null");
            return (Criteria) this;
        }

        public Criteria andO2oBalanceEqualTo(BigDecimal value) {
            addCriterion("o2o_balance =", value, "o2oBalance");
            return (Criteria) this;
        }

        public Criteria andO2oBalanceNotEqualTo(BigDecimal value) {
            addCriterion("o2o_balance <>", value, "o2oBalance");
            return (Criteria) this;
        }

        public Criteria andO2oBalanceGreaterThan(BigDecimal value) {
            addCriterion("o2o_balance >", value, "o2oBalance");
            return (Criteria) this;
        }

        public Criteria andO2oBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("o2o_balance >=", value, "o2oBalance");
            return (Criteria) this;
        }

        public Criteria andO2oBalanceLessThan(BigDecimal value) {
            addCriterion("o2o_balance <", value, "o2oBalance");
            return (Criteria) this;
        }

        public Criteria andO2oBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("o2o_balance <=", value, "o2oBalance");
            return (Criteria) this;
        }

        public Criteria andO2oBalanceIn(List<BigDecimal> values) {
            addCriterion("o2o_balance in", values, "o2oBalance");
            return (Criteria) this;
        }

        public Criteria andO2oBalanceNotIn(List<BigDecimal> values) {
            addCriterion("o2o_balance not in", values, "o2oBalance");
            return (Criteria) this;
        }

        public Criteria andO2oBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("o2o_balance between", value1, value2, "o2oBalance");
            return (Criteria) this;
        }

        public Criteria andO2oBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("o2o_balance not between", value1, value2, "o2oBalance");
            return (Criteria) this;
        }

        public Criteria andO2oPasswordIsNull() {
            addCriterion("o2o_password is null");
            return (Criteria) this;
        }

        public Criteria andO2oPasswordIsNotNull() {
            addCriterion("o2o_password is not null");
            return (Criteria) this;
        }

        public Criteria andO2oPasswordEqualTo(String value) {
            addCriterion("o2o_password =", value, "o2oPassword");
            return (Criteria) this;
        }

        public Criteria andO2oPasswordNotEqualTo(String value) {
            addCriterion("o2o_password <>", value, "o2oPassword");
            return (Criteria) this;
        }

        public Criteria andO2oPasswordGreaterThan(String value) {
            addCriterion("o2o_password >", value, "o2oPassword");
            return (Criteria) this;
        }

        public Criteria andO2oPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("o2o_password >=", value, "o2oPassword");
            return (Criteria) this;
        }

        public Criteria andO2oPasswordLessThan(String value) {
            addCriterion("o2o_password <", value, "o2oPassword");
            return (Criteria) this;
        }

        public Criteria andO2oPasswordLessThanOrEqualTo(String value) {
            addCriterion("o2o_password <=", value, "o2oPassword");
            return (Criteria) this;
        }

        public Criteria andO2oPasswordLike(String value) {
            addCriterion("o2o_password like", value, "o2oPassword");
            return (Criteria) this;
        }

        public Criteria andO2oPasswordNotLike(String value) {
            addCriterion("o2o_password not like", value, "o2oPassword");
            return (Criteria) this;
        }

        public Criteria andO2oPasswordIn(List<String> values) {
            addCriterion("o2o_password in", values, "o2oPassword");
            return (Criteria) this;
        }

        public Criteria andO2oPasswordNotIn(List<String> values) {
            addCriterion("o2o_password not in", values, "o2oPassword");
            return (Criteria) this;
        }

        public Criteria andO2oPasswordBetween(String value1, String value2) {
            addCriterion("o2o_password between", value1, value2, "o2oPassword");
            return (Criteria) this;
        }

        public Criteria andO2oPasswordNotBetween(String value1, String value2) {
            addCriterion("o2o_password not between", value1, value2, "o2oPassword");
            return (Criteria) this;
        }

        public Criteria andO2oRecordBalanceIsNull() {
            addCriterion("o2o_record_balance is null");
            return (Criteria) this;
        }

        public Criteria andO2oRecordBalanceIsNotNull() {
            addCriterion("o2o_record_balance is not null");
            return (Criteria) this;
        }

        public Criteria andO2oRecordBalanceEqualTo(BigDecimal value) {
            addCriterion("o2o_record_balance =", value, "o2oRecordBalance");
            return (Criteria) this;
        }

        public Criteria andO2oRecordBalanceNotEqualTo(BigDecimal value) {
            addCriterion("o2o_record_balance <>", value, "o2oRecordBalance");
            return (Criteria) this;
        }

        public Criteria andO2oRecordBalanceGreaterThan(BigDecimal value) {
            addCriterion("o2o_record_balance >", value, "o2oRecordBalance");
            return (Criteria) this;
        }

        public Criteria andO2oRecordBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("o2o_record_balance >=", value, "o2oRecordBalance");
            return (Criteria) this;
        }

        public Criteria andO2oRecordBalanceLessThan(BigDecimal value) {
            addCriterion("o2o_record_balance <", value, "o2oRecordBalance");
            return (Criteria) this;
        }

        public Criteria andO2oRecordBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("o2o_record_balance <=", value, "o2oRecordBalance");
            return (Criteria) this;
        }

        public Criteria andO2oRecordBalanceIn(List<BigDecimal> values) {
            addCriterion("o2o_record_balance in", values, "o2oRecordBalance");
            return (Criteria) this;
        }

        public Criteria andO2oRecordBalanceNotIn(List<BigDecimal> values) {
            addCriterion("o2o_record_balance not in", values, "o2oRecordBalance");
            return (Criteria) this;
        }

        public Criteria andO2oRecordBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("o2o_record_balance between", value1, value2, "o2oRecordBalance");
            return (Criteria) this;
        }

        public Criteria andO2oRecordBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("o2o_record_balance not between", value1, value2, "o2oRecordBalance");
            return (Criteria) this;
        }

        public Criteria andB2cBalanceIsNull() {
            addCriterion("b2c_balance is null");
            return (Criteria) this;
        }

        public Criteria andB2cBalanceIsNotNull() {
            addCriterion("b2c_balance is not null");
            return (Criteria) this;
        }

        public Criteria andB2cBalanceEqualTo(BigDecimal value) {
            addCriterion("b2c_balance =", value, "b2cBalance");
            return (Criteria) this;
        }

        public Criteria andB2cBalanceNotEqualTo(BigDecimal value) {
            addCriterion("b2c_balance <>", value, "b2cBalance");
            return (Criteria) this;
        }

        public Criteria andB2cBalanceGreaterThan(BigDecimal value) {
            addCriterion("b2c_balance >", value, "b2cBalance");
            return (Criteria) this;
        }

        public Criteria andB2cBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("b2c_balance >=", value, "b2cBalance");
            return (Criteria) this;
        }

        public Criteria andB2cBalanceLessThan(BigDecimal value) {
            addCriterion("b2c_balance <", value, "b2cBalance");
            return (Criteria) this;
        }

        public Criteria andB2cBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("b2c_balance <=", value, "b2cBalance");
            return (Criteria) this;
        }

        public Criteria andB2cBalanceIn(List<BigDecimal> values) {
            addCriterion("b2c_balance in", values, "b2cBalance");
            return (Criteria) this;
        }

        public Criteria andB2cBalanceNotIn(List<BigDecimal> values) {
            addCriterion("b2c_balance not in", values, "b2cBalance");
            return (Criteria) this;
        }

        public Criteria andB2cBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("b2c_balance between", value1, value2, "b2cBalance");
            return (Criteria) this;
        }

        public Criteria andB2cBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("b2c_balance not between", value1, value2, "b2cBalance");
            return (Criteria) this;
        }

        public Criteria andB2cPasswordIsNull() {
            addCriterion("b2c_password is null");
            return (Criteria) this;
        }

        public Criteria andB2cPasswordIsNotNull() {
            addCriterion("b2c_password is not null");
            return (Criteria) this;
        }

        public Criteria andB2cPasswordEqualTo(String value) {
            addCriterion("b2c_password =", value, "b2cPassword");
            return (Criteria) this;
        }

        public Criteria andB2cPasswordNotEqualTo(String value) {
            addCriterion("b2c_password <>", value, "b2cPassword");
            return (Criteria) this;
        }

        public Criteria andB2cPasswordGreaterThan(String value) {
            addCriterion("b2c_password >", value, "b2cPassword");
            return (Criteria) this;
        }

        public Criteria andB2cPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("b2c_password >=", value, "b2cPassword");
            return (Criteria) this;
        }

        public Criteria andB2cPasswordLessThan(String value) {
            addCriterion("b2c_password <", value, "b2cPassword");
            return (Criteria) this;
        }

        public Criteria andB2cPasswordLessThanOrEqualTo(String value) {
            addCriterion("b2c_password <=", value, "b2cPassword");
            return (Criteria) this;
        }

        public Criteria andB2cPasswordLike(String value) {
            addCriterion("b2c_password like", value, "b2cPassword");
            return (Criteria) this;
        }

        public Criteria andB2cPasswordNotLike(String value) {
            addCriterion("b2c_password not like", value, "b2cPassword");
            return (Criteria) this;
        }

        public Criteria andB2cPasswordIn(List<String> values) {
            addCriterion("b2c_password in", values, "b2cPassword");
            return (Criteria) this;
        }

        public Criteria andB2cPasswordNotIn(List<String> values) {
            addCriterion("b2c_password not in", values, "b2cPassword");
            return (Criteria) this;
        }

        public Criteria andB2cPasswordBetween(String value1, String value2) {
            addCriterion("b2c_password between", value1, value2, "b2cPassword");
            return (Criteria) this;
        }

        public Criteria andB2cPasswordNotBetween(String value1, String value2) {
            addCriterion("b2c_password not between", value1, value2, "b2cPassword");
            return (Criteria) this;
        }

        public Criteria andB2cRecordBalanceIsNull() {
            addCriterion("b2c_record_balance is null");
            return (Criteria) this;
        }

        public Criteria andB2cRecordBalanceIsNotNull() {
            addCriterion("b2c_record_balance is not null");
            return (Criteria) this;
        }

        public Criteria andB2cRecordBalanceEqualTo(BigDecimal value) {
            addCriterion("b2c_record_balance =", value, "b2cRecordBalance");
            return (Criteria) this;
        }

        public Criteria andB2cRecordBalanceNotEqualTo(BigDecimal value) {
            addCriterion("b2c_record_balance <>", value, "b2cRecordBalance");
            return (Criteria) this;
        }

        public Criteria andB2cRecordBalanceGreaterThan(BigDecimal value) {
            addCriterion("b2c_record_balance >", value, "b2cRecordBalance");
            return (Criteria) this;
        }

        public Criteria andB2cRecordBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("b2c_record_balance >=", value, "b2cRecordBalance");
            return (Criteria) this;
        }

        public Criteria andB2cRecordBalanceLessThan(BigDecimal value) {
            addCriterion("b2c_record_balance <", value, "b2cRecordBalance");
            return (Criteria) this;
        }

        public Criteria andB2cRecordBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("b2c_record_balance <=", value, "b2cRecordBalance");
            return (Criteria) this;
        }

        public Criteria andB2cRecordBalanceIn(List<BigDecimal> values) {
            addCriterion("b2c_record_balance in", values, "b2cRecordBalance");
            return (Criteria) this;
        }

        public Criteria andB2cRecordBalanceNotIn(List<BigDecimal> values) {
            addCriterion("b2c_record_balance not in", values, "b2cRecordBalance");
            return (Criteria) this;
        }

        public Criteria andB2cRecordBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("b2c_record_balance between", value1, value2, "b2cRecordBalance");
            return (Criteria) this;
        }

        public Criteria andB2cRecordBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("b2c_record_balance not between", value1, value2, "b2cRecordBalance");
            return (Criteria) this;
        }

        public Criteria andYysBalanceIsNull() {
            addCriterion("yys_balance is null");
            return (Criteria) this;
        }

        public Criteria andYysBalanceIsNotNull() {
            addCriterion("yys_balance is not null");
            return (Criteria) this;
        }

        public Criteria andYysBalanceEqualTo(BigDecimal value) {
            addCriterion("yys_balance =", value, "yysBalance");
            return (Criteria) this;
        }

        public Criteria andYysBalanceNotEqualTo(BigDecimal value) {
            addCriterion("yys_balance <>", value, "yysBalance");
            return (Criteria) this;
        }

        public Criteria andYysBalanceGreaterThan(BigDecimal value) {
            addCriterion("yys_balance >", value, "yysBalance");
            return (Criteria) this;
        }

        public Criteria andYysBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("yys_balance >=", value, "yysBalance");
            return (Criteria) this;
        }

        public Criteria andYysBalanceLessThan(BigDecimal value) {
            addCriterion("yys_balance <", value, "yysBalance");
            return (Criteria) this;
        }

        public Criteria andYysBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("yys_balance <=", value, "yysBalance");
            return (Criteria) this;
        }

        public Criteria andYysBalanceIn(List<BigDecimal> values) {
            addCriterion("yys_balance in", values, "yysBalance");
            return (Criteria) this;
        }

        public Criteria andYysBalanceNotIn(List<BigDecimal> values) {
            addCriterion("yys_balance not in", values, "yysBalance");
            return (Criteria) this;
        }

        public Criteria andYysBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("yys_balance between", value1, value2, "yysBalance");
            return (Criteria) this;
        }

        public Criteria andYysBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("yys_balance not between", value1, value2, "yysBalance");
            return (Criteria) this;
        }

        public Criteria andYysPasswordIsNull() {
            addCriterion("yys_password is null");
            return (Criteria) this;
        }

        public Criteria andYysPasswordIsNotNull() {
            addCriterion("yys_password is not null");
            return (Criteria) this;
        }

        public Criteria andYysPasswordEqualTo(String value) {
            addCriterion("yys_password =", value, "yysPassword");
            return (Criteria) this;
        }

        public Criteria andYysPasswordNotEqualTo(String value) {
            addCriterion("yys_password <>", value, "yysPassword");
            return (Criteria) this;
        }

        public Criteria andYysPasswordGreaterThan(String value) {
            addCriterion("yys_password >", value, "yysPassword");
            return (Criteria) this;
        }

        public Criteria andYysPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("yys_password >=", value, "yysPassword");
            return (Criteria) this;
        }

        public Criteria andYysPasswordLessThan(String value) {
            addCriterion("yys_password <", value, "yysPassword");
            return (Criteria) this;
        }

        public Criteria andYysPasswordLessThanOrEqualTo(String value) {
            addCriterion("yys_password <=", value, "yysPassword");
            return (Criteria) this;
        }

        public Criteria andYysPasswordLike(String value) {
            addCriterion("yys_password like", value, "yysPassword");
            return (Criteria) this;
        }

        public Criteria andYysPasswordNotLike(String value) {
            addCriterion("yys_password not like", value, "yysPassword");
            return (Criteria) this;
        }

        public Criteria andYysPasswordIn(List<String> values) {
            addCriterion("yys_password in", values, "yysPassword");
            return (Criteria) this;
        }

        public Criteria andYysPasswordNotIn(List<String> values) {
            addCriterion("yys_password not in", values, "yysPassword");
            return (Criteria) this;
        }

        public Criteria andYysPasswordBetween(String value1, String value2) {
            addCriterion("yys_password between", value1, value2, "yysPassword");
            return (Criteria) this;
        }

        public Criteria andYysPasswordNotBetween(String value1, String value2) {
            addCriterion("yys_password not between", value1, value2, "yysPassword");
            return (Criteria) this;
        }

        public Criteria andYysRecordBalanceIsNull() {
            addCriterion("yys_record_balance is null");
            return (Criteria) this;
        }

        public Criteria andYysRecordBalanceIsNotNull() {
            addCriterion("yys_record_balance is not null");
            return (Criteria) this;
        }

        public Criteria andYysRecordBalanceEqualTo(BigDecimal value) {
            addCriterion("yys_record_balance =", value, "yysRecordBalance");
            return (Criteria) this;
        }

        public Criteria andYysRecordBalanceNotEqualTo(BigDecimal value) {
            addCriterion("yys_record_balance <>", value, "yysRecordBalance");
            return (Criteria) this;
        }

        public Criteria andYysRecordBalanceGreaterThan(BigDecimal value) {
            addCriterion("yys_record_balance >", value, "yysRecordBalance");
            return (Criteria) this;
        }

        public Criteria andYysRecordBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("yys_record_balance >=", value, "yysRecordBalance");
            return (Criteria) this;
        }

        public Criteria andYysRecordBalanceLessThan(BigDecimal value) {
            addCriterion("yys_record_balance <", value, "yysRecordBalance");
            return (Criteria) this;
        }

        public Criteria andYysRecordBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("yys_record_balance <=", value, "yysRecordBalance");
            return (Criteria) this;
        }

        public Criteria andYysRecordBalanceIn(List<BigDecimal> values) {
            addCriterion("yys_record_balance in", values, "yysRecordBalance");
            return (Criteria) this;
        }

        public Criteria andYysRecordBalanceNotIn(List<BigDecimal> values) {
            addCriterion("yys_record_balance not in", values, "yysRecordBalance");
            return (Criteria) this;
        }

        public Criteria andYysRecordBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("yys_record_balance between", value1, value2, "yysRecordBalance");
            return (Criteria) this;
        }

        public Criteria andYysRecordBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("yys_record_balance not between", value1, value2, "yysRecordBalance");
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