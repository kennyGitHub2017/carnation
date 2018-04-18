package com.sinco.carnation.goods.model;

import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.mybatis.dal.core.AbstractExample;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsClassExample extends AbstractExample<GoodsClassBO> {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String limit;

    public GoodsClassExample() {
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

        public Criteria andAppIconIsNull() {
            addCriterion("app_icon is null");
            return (Criteria) this;
        }

        public Criteria andAppIconIsNotNull() {
            addCriterion("app_icon is not null");
            return (Criteria) this;
        }

        public Criteria andAppIconEqualTo(String value) {
            addCriterion("app_icon =", value, "appIcon");
            return (Criteria) this;
        }

        public Criteria andAppIconNotEqualTo(String value) {
            addCriterion("app_icon <>", value, "appIcon");
            return (Criteria) this;
        }

        public Criteria andAppIconGreaterThan(String value) {
            addCriterion("app_icon >", value, "appIcon");
            return (Criteria) this;
        }

        public Criteria andAppIconGreaterThanOrEqualTo(String value) {
            addCriterion("app_icon >=", value, "appIcon");
            return (Criteria) this;
        }

        public Criteria andAppIconLessThan(String value) {
            addCriterion("app_icon <", value, "appIcon");
            return (Criteria) this;
        }

        public Criteria andAppIconLessThanOrEqualTo(String value) {
            addCriterion("app_icon <=", value, "appIcon");
            return (Criteria) this;
        }

        public Criteria andAppIconLike(String value) {
            addCriterion("app_icon like", value, "appIcon");
            return (Criteria) this;
        }

        public Criteria andAppIconNotLike(String value) {
            addCriterion("app_icon not like", value, "appIcon");
            return (Criteria) this;
        }

        public Criteria andAppIconIn(List<String> values) {
            addCriterion("app_icon in", values, "appIcon");
            return (Criteria) this;
        }

        public Criteria andAppIconNotIn(List<String> values) {
            addCriterion("app_icon not in", values, "appIcon");
            return (Criteria) this;
        }

        public Criteria andAppIconBetween(String value1, String value2) {
            addCriterion("app_icon between", value1, value2, "appIcon");
            return (Criteria) this;
        }

        public Criteria andAppIconNotBetween(String value1, String value2) {
            addCriterion("app_icon not between", value1, value2, "appIcon");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNull() {
            addCriterion("class_name is null");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNotNull() {
            addCriterion("class_name is not null");
            return (Criteria) this;
        }

        public Criteria andClassNameEqualTo(String value) {
            addCriterion("class_name =", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotEqualTo(String value) {
            addCriterion("class_name <>", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThan(String value) {
            addCriterion("class_name >", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("class_name >=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThan(String value) {
            addCriterion("class_name <", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThanOrEqualTo(String value) {
            addCriterion("class_name <=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLike(String value) {
            addCriterion("class_name like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotLike(String value) {
            addCriterion("class_name not like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameIn(List<String> values) {
            addCriterion("class_name in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotIn(List<String> values) {
            addCriterion("class_name not in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameBetween(String value1, String value2) {
            addCriterion("class_name between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotBetween(String value1, String value2) {
            addCriterion("class_name not between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andCommissionRateIsNull() {
            addCriterion("commission_rate is null");
            return (Criteria) this;
        }

        public Criteria andCommissionRateIsNotNull() {
            addCriterion("commission_rate is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionRateEqualTo(BigDecimal value) {
            addCriterion("commission_rate =", value, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateNotEqualTo(BigDecimal value) {
            addCriterion("commission_rate <>", value, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateGreaterThan(BigDecimal value) {
            addCriterion("commission_rate >", value, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("commission_rate >=", value, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateLessThan(BigDecimal value) {
            addCriterion("commission_rate <", value, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("commission_rate <=", value, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateIn(List<BigDecimal> values) {
            addCriterion("commission_rate in", values, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateNotIn(List<BigDecimal> values) {
            addCriterion("commission_rate not in", values, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission_rate between", value1, value2, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission_rate not between", value1, value2, "commissionRate");
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

        public Criteria andDisplayIsNull() {
            addCriterion("display is null");
            return (Criteria) this;
        }

        public Criteria andDisplayIsNotNull() {
            addCriterion("display is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayEqualTo(Boolean value) {
            addCriterion("display =", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayNotEqualTo(Boolean value) {
            addCriterion("display <>", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayGreaterThan(Boolean value) {
            addCriterion("display >", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayGreaterThanOrEqualTo(Boolean value) {
            addCriterion("display >=", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayLessThan(Boolean value) {
            addCriterion("display <", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayLessThanOrEqualTo(Boolean value) {
            addCriterion("display <=", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayIn(List<Boolean> values) {
            addCriterion("display in", values, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayNotIn(List<Boolean> values) {
            addCriterion("display not in", values, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayBetween(Boolean value1, Boolean value2) {
            addCriterion("display between", value1, value2, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayNotBetween(Boolean value1, Boolean value2) {
            addCriterion("display not between", value1, value2, "display");
            return (Criteria) this;
        }

        public Criteria andGcColorIsNull() {
            addCriterion("gc_color is null");
            return (Criteria) this;
        }

        public Criteria andGcColorIsNotNull() {
            addCriterion("gc_color is not null");
            return (Criteria) this;
        }

        public Criteria andGcColorEqualTo(String value) {
            addCriterion("gc_color =", value, "gcColor");
            return (Criteria) this;
        }

        public Criteria andGcColorNotEqualTo(String value) {
            addCriterion("gc_color <>", value, "gcColor");
            return (Criteria) this;
        }

        public Criteria andGcColorGreaterThan(String value) {
            addCriterion("gc_color >", value, "gcColor");
            return (Criteria) this;
        }

        public Criteria andGcColorGreaterThanOrEqualTo(String value) {
            addCriterion("gc_color >=", value, "gcColor");
            return (Criteria) this;
        }

        public Criteria andGcColorLessThan(String value) {
            addCriterion("gc_color <", value, "gcColor");
            return (Criteria) this;
        }

        public Criteria andGcColorLessThanOrEqualTo(String value) {
            addCriterion("gc_color <=", value, "gcColor");
            return (Criteria) this;
        }

        public Criteria andGcColorLike(String value) {
            addCriterion("gc_color like", value, "gcColor");
            return (Criteria) this;
        }

        public Criteria andGcColorNotLike(String value) {
            addCriterion("gc_color not like", value, "gcColor");
            return (Criteria) this;
        }

        public Criteria andGcColorIn(List<String> values) {
            addCriterion("gc_color in", values, "gcColor");
            return (Criteria) this;
        }

        public Criteria andGcColorNotIn(List<String> values) {
            addCriterion("gc_color not in", values, "gcColor");
            return (Criteria) this;
        }

        public Criteria andGcColorBetween(String value1, String value2) {
            addCriterion("gc_color between", value1, value2, "gcColor");
            return (Criteria) this;
        }

        public Criteria andGcColorNotBetween(String value1, String value2) {
            addCriterion("gc_color not between", value1, value2, "gcColor");
            return (Criteria) this;
        }

        public Criteria andGuaranteeIsNull() {
            addCriterion("guarantee is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeIsNotNull() {
            addCriterion("guarantee is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeEqualTo(Long value) {
            addCriterion("guarantee =", value, "guarantee");
            return (Criteria) this;
        }

        public Criteria andGuaranteeNotEqualTo(Long value) {
            addCriterion("guarantee <>", value, "guarantee");
            return (Criteria) this;
        }

        public Criteria andGuaranteeGreaterThan(Long value) {
            addCriterion("guarantee >", value, "guarantee");
            return (Criteria) this;
        }

        public Criteria andGuaranteeGreaterThanOrEqualTo(Long value) {
            addCriterion("guarantee >=", value, "guarantee");
            return (Criteria) this;
        }

        public Criteria andGuaranteeLessThan(Long value) {
            addCriterion("guarantee <", value, "guarantee");
            return (Criteria) this;
        }

        public Criteria andGuaranteeLessThanOrEqualTo(Long value) {
            addCriterion("guarantee <=", value, "guarantee");
            return (Criteria) this;
        }

        public Criteria andGuaranteeIn(List<Long> values) {
            addCriterion("guarantee in", values, "guarantee");
            return (Criteria) this;
        }

        public Criteria andGuaranteeNotIn(List<Long> values) {
            addCriterion("guarantee not in", values, "guarantee");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBetween(Long value1, Long value2) {
            addCriterion("guarantee between", value1, value2, "guarantee");
            return (Criteria) this;
        }

        public Criteria andGuaranteeNotBetween(Long value1, Long value2) {
            addCriterion("guarantee not between", value1, value2, "guarantee");
            return (Criteria) this;
        }

        public Criteria andIconSysIsNull() {
            addCriterion("icon_sys is null");
            return (Criteria) this;
        }

        public Criteria andIconSysIsNotNull() {
            addCriterion("icon_sys is not null");
            return (Criteria) this;
        }

        public Criteria andIconSysEqualTo(String value) {
            addCriterion("icon_sys =", value, "iconSys");
            return (Criteria) this;
        }

        public Criteria andIconSysNotEqualTo(String value) {
            addCriterion("icon_sys <>", value, "iconSys");
            return (Criteria) this;
        }

        public Criteria andIconSysGreaterThan(String value) {
            addCriterion("icon_sys >", value, "iconSys");
            return (Criteria) this;
        }

        public Criteria andIconSysGreaterThanOrEqualTo(String value) {
            addCriterion("icon_sys >=", value, "iconSys");
            return (Criteria) this;
        }

        public Criteria andIconSysLessThan(String value) {
            addCriterion("icon_sys <", value, "iconSys");
            return (Criteria) this;
        }

        public Criteria andIconSysLessThanOrEqualTo(String value) {
            addCriterion("icon_sys <=", value, "iconSys");
            return (Criteria) this;
        }

        public Criteria andIconSysLike(String value) {
            addCriterion("icon_sys like", value, "iconSys");
            return (Criteria) this;
        }

        public Criteria andIconSysNotLike(String value) {
            addCriterion("icon_sys not like", value, "iconSys");
            return (Criteria) this;
        }

        public Criteria andIconSysIn(List<String> values) {
            addCriterion("icon_sys in", values, "iconSys");
            return (Criteria) this;
        }

        public Criteria andIconSysNotIn(List<String> values) {
            addCriterion("icon_sys not in", values, "iconSys");
            return (Criteria) this;
        }

        public Criteria andIconSysBetween(String value1, String value2) {
            addCriterion("icon_sys between", value1, value2, "iconSys");
            return (Criteria) this;
        }

        public Criteria andIconSysNotBetween(String value1, String value2) {
            addCriterion("icon_sys not between", value1, value2, "iconSys");
            return (Criteria) this;
        }

        public Criteria andIconTypeIsNull() {
            addCriterion("icon_type is null");
            return (Criteria) this;
        }

        public Criteria andIconTypeIsNotNull() {
            addCriterion("icon_type is not null");
            return (Criteria) this;
        }

        public Criteria andIconTypeEqualTo(Integer value) {
            addCriterion("icon_type =", value, "iconType");
            return (Criteria) this;
        }

        public Criteria andIconTypeNotEqualTo(Integer value) {
            addCriterion("icon_type <>", value, "iconType");
            return (Criteria) this;
        }

        public Criteria andIconTypeGreaterThan(Integer value) {
            addCriterion("icon_type >", value, "iconType");
            return (Criteria) this;
        }

        public Criteria andIconTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("icon_type >=", value, "iconType");
            return (Criteria) this;
        }

        public Criteria andIconTypeLessThan(Integer value) {
            addCriterion("icon_type <", value, "iconType");
            return (Criteria) this;
        }

        public Criteria andIconTypeLessThanOrEqualTo(Integer value) {
            addCriterion("icon_type <=", value, "iconType");
            return (Criteria) this;
        }

        public Criteria andIconTypeIn(List<Integer> values) {
            addCriterion("icon_type in", values, "iconType");
            return (Criteria) this;
        }

        public Criteria andIconTypeNotIn(List<Integer> values) {
            addCriterion("icon_type not in", values, "iconType");
            return (Criteria) this;
        }

        public Criteria andIconTypeBetween(Integer value1, Integer value2) {
            addCriterion("icon_type between", value1, value2, "iconType");
            return (Criteria) this;
        }

        public Criteria andIconTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("icon_type not between", value1, value2, "iconType");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andRecommendIsNull() {
            addCriterion("recommend is null");
            return (Criteria) this;
        }

        public Criteria andRecommendIsNotNull() {
            addCriterion("recommend is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendEqualTo(Boolean value) {
            addCriterion("recommend =", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotEqualTo(Boolean value) {
            addCriterion("recommend <>", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendGreaterThan(Boolean value) {
            addCriterion("recommend >", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendGreaterThanOrEqualTo(Boolean value) {
            addCriterion("recommend >=", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendLessThan(Boolean value) {
            addCriterion("recommend <", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendLessThanOrEqualTo(Boolean value) {
            addCriterion("recommend <=", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendIn(List<Boolean> values) {
            addCriterion("recommend in", values, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotIn(List<Boolean> values) {
            addCriterion("recommend not in", values, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendBetween(Boolean value1, Boolean value2) {
            addCriterion("recommend between", value1, value2, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotBetween(Boolean value1, Boolean value2) {
            addCriterion("recommend not between", value1, value2, "recommend");
            return (Criteria) this;
        }

        public Criteria andSequenceIsNull() {
            addCriterion("sequence is null");
            return (Criteria) this;
        }

        public Criteria andSequenceIsNotNull() {
            addCriterion("sequence is not null");
            return (Criteria) this;
        }

        public Criteria andSequenceEqualTo(Integer value) {
            addCriterion("sequence =", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotEqualTo(Integer value) {
            addCriterion("sequence <>", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceGreaterThan(Integer value) {
            addCriterion("sequence >", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceGreaterThanOrEqualTo(Integer value) {
            addCriterion("sequence >=", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceLessThan(Integer value) {
            addCriterion("sequence <", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceLessThanOrEqualTo(Integer value) {
            addCriterion("sequence <=", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceIn(List<Integer> values) {
            addCriterion("sequence in", values, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotIn(List<Integer> values) {
            addCriterion("sequence not in", values, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceBetween(Integer value1, Integer value2) {
            addCriterion("sequence between", value1, value2, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotBetween(Integer value1, Integer value2) {
            addCriterion("sequence not between", value1, value2, "sequence");
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

        public Criteria andGoodsTypeIdIsNull() {
            addCriterion("goods_type_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdIsNotNull() {
            addCriterion("goods_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdEqualTo(Long value) {
            addCriterion("goods_type_id =", value, "goodsTypeId");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdNotEqualTo(Long value) {
            addCriterion("goods_type_id <>", value, "goodsTypeId");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdGreaterThan(Long value) {
            addCriterion("goods_type_id >", value, "goodsTypeId");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_type_id >=", value, "goodsTypeId");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdLessThan(Long value) {
            addCriterion("goods_type_id <", value, "goodsTypeId");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("goods_type_id <=", value, "goodsTypeId");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdIn(List<Long> values) {
            addCriterion("goods_type_id in", values, "goodsTypeId");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdNotIn(List<Long> values) {
            addCriterion("goods_type_id not in", values, "goodsTypeId");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdBetween(Long value1, Long value2) {
            addCriterion("goods_type_id between", value1, value2, "goodsTypeId");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("goods_type_id not between", value1, value2, "goodsTypeId");
            return (Criteria) this;
        }

        public Criteria andIconAccIdIsNull() {
            addCriterion("icon_acc_id is null");
            return (Criteria) this;
        }

        public Criteria andIconAccIdIsNotNull() {
            addCriterion("icon_acc_id is not null");
            return (Criteria) this;
        }

        public Criteria andIconAccIdEqualTo(String value) {
            addCriterion("icon_acc_id =", value, "iconAccId");
            return (Criteria) this;
        }

        public Criteria andIconAccIdNotEqualTo(String value) {
            addCriterion("icon_acc_id <>", value, "iconAccId");
            return (Criteria) this;
        }

        public Criteria andIconAccIdGreaterThan(String value) {
            addCriterion("icon_acc_id >", value, "iconAccId");
            return (Criteria) this;
        }

        public Criteria andIconAccIdGreaterThanOrEqualTo(String value) {
            addCriterion("icon_acc_id >=", value, "iconAccId");
            return (Criteria) this;
        }

        public Criteria andIconAccIdLessThan(String value) {
            addCriterion("icon_acc_id <", value, "iconAccId");
            return (Criteria) this;
        }

        public Criteria andIconAccIdLessThanOrEqualTo(String value) {
            addCriterion("icon_acc_id <=", value, "iconAccId");
            return (Criteria) this;
        }

        public Criteria andIconAccIdLike(String value) {
            addCriterion("icon_acc_id like", value, "iconAccId");
            return (Criteria) this;
        }

        public Criteria andIconAccIdNotLike(String value) {
            addCriterion("icon_acc_id not like", value, "iconAccId");
            return (Criteria) this;
        }

        public Criteria andIconAccIdIn(List<String> values) {
            addCriterion("icon_acc_id in", values, "iconAccId");
            return (Criteria) this;
        }

        public Criteria andIconAccIdNotIn(List<String> values) {
            addCriterion("icon_acc_id not in", values, "iconAccId");
            return (Criteria) this;
        }

        public Criteria andIconAccIdBetween(String value1, String value2) {
            addCriterion("icon_acc_id between", value1, value2, "iconAccId");
            return (Criteria) this;
        }

        public Criteria andIconAccIdNotBetween(String value1, String value2) {
            addCriterion("icon_acc_id not between", value1, value2, "iconAccId");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Long value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Long value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Long value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Long value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Long> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Long> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Long value1, Long value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andWxIconIsNull() {
            addCriterion("wx_icon is null");
            return (Criteria) this;
        }

        public Criteria andWxIconIsNotNull() {
            addCriterion("wx_icon is not null");
            return (Criteria) this;
        }

        public Criteria andWxIconEqualTo(String value) {
            addCriterion("wx_icon =", value, "wxIcon");
            return (Criteria) this;
        }

        public Criteria andWxIconNotEqualTo(String value) {
            addCriterion("wx_icon <>", value, "wxIcon");
            return (Criteria) this;
        }

        public Criteria andWxIconGreaterThan(String value) {
            addCriterion("wx_icon >", value, "wxIcon");
            return (Criteria) this;
        }

        public Criteria andWxIconGreaterThanOrEqualTo(String value) {
            addCriterion("wx_icon >=", value, "wxIcon");
            return (Criteria) this;
        }

        public Criteria andWxIconLessThan(String value) {
            addCriterion("wx_icon <", value, "wxIcon");
            return (Criteria) this;
        }

        public Criteria andWxIconLessThanOrEqualTo(String value) {
            addCriterion("wx_icon <=", value, "wxIcon");
            return (Criteria) this;
        }

        public Criteria andWxIconLike(String value) {
            addCriterion("wx_icon like", value, "wxIcon");
            return (Criteria) this;
        }

        public Criteria andWxIconNotLike(String value) {
            addCriterion("wx_icon not like", value, "wxIcon");
            return (Criteria) this;
        }

        public Criteria andWxIconIn(List<String> values) {
            addCriterion("wx_icon in", values, "wxIcon");
            return (Criteria) this;
        }

        public Criteria andWxIconNotIn(List<String> values) {
            addCriterion("wx_icon not in", values, "wxIcon");
            return (Criteria) this;
        }

        public Criteria andWxIconBetween(String value1, String value2) {
            addCriterion("wx_icon between", value1, value2, "wxIcon");
            return (Criteria) this;
        }

        public Criteria andWxIconNotBetween(String value1, String value2) {
            addCriterion("wx_icon not between", value1, value2, "wxIcon");
            return (Criteria) this;
        }

        public Criteria andMobileIconIsNull() {
            addCriterion("mobile_icon is null");
            return (Criteria) this;
        }

        public Criteria andMobileIconIsNotNull() {
            addCriterion("mobile_icon is not null");
            return (Criteria) this;
        }

        public Criteria andMobileIconEqualTo(String value) {
            addCriterion("mobile_icon =", value, "mobileIcon");
            return (Criteria) this;
        }

        public Criteria andMobileIconNotEqualTo(String value) {
            addCriterion("mobile_icon <>", value, "mobileIcon");
            return (Criteria) this;
        }

        public Criteria andMobileIconGreaterThan(String value) {
            addCriterion("mobile_icon >", value, "mobileIcon");
            return (Criteria) this;
        }

        public Criteria andMobileIconGreaterThanOrEqualTo(String value) {
            addCriterion("mobile_icon >=", value, "mobileIcon");
            return (Criteria) this;
        }

        public Criteria andMobileIconLessThan(String value) {
            addCriterion("mobile_icon <", value, "mobileIcon");
            return (Criteria) this;
        }

        public Criteria andMobileIconLessThanOrEqualTo(String value) {
            addCriterion("mobile_icon <=", value, "mobileIcon");
            return (Criteria) this;
        }

        public Criteria andMobileIconLike(String value) {
            addCriterion("mobile_icon like", value, "mobileIcon");
            return (Criteria) this;
        }

        public Criteria andMobileIconNotLike(String value) {
            addCriterion("mobile_icon not like", value, "mobileIcon");
            return (Criteria) this;
        }

        public Criteria andMobileIconIn(List<String> values) {
            addCriterion("mobile_icon in", values, "mobileIcon");
            return (Criteria) this;
        }

        public Criteria andMobileIconNotIn(List<String> values) {
            addCriterion("mobile_icon not in", values, "mobileIcon");
            return (Criteria) this;
        }

        public Criteria andMobileIconBetween(String value1, String value2) {
            addCriterion("mobile_icon between", value1, value2, "mobileIcon");
            return (Criteria) this;
        }

        public Criteria andMobileIconNotBetween(String value1, String value2) {
            addCriterion("mobile_icon not between", value1, value2, "mobileIcon");
            return (Criteria) this;
        }

        public Criteria andClickIconIsNull() {
            addCriterion("click_icon is null");
            return (Criteria) this;
        }

        public Criteria andClickIconIsNotNull() {
            addCriterion("click_icon is not null");
            return (Criteria) this;
        }

        public Criteria andClickIconEqualTo(String value) {
            addCriterion("click_icon =", value, "clickIcon");
            return (Criteria) this;
        }

        public Criteria andClickIconNotEqualTo(String value) {
            addCriterion("click_icon <>", value, "clickIcon");
            return (Criteria) this;
        }

        public Criteria andClickIconGreaterThan(String value) {
            addCriterion("click_icon >", value, "clickIcon");
            return (Criteria) this;
        }

        public Criteria andClickIconGreaterThanOrEqualTo(String value) {
            addCriterion("click_icon >=", value, "clickIcon");
            return (Criteria) this;
        }

        public Criteria andClickIconLessThan(String value) {
            addCriterion("click_icon <", value, "clickIcon");
            return (Criteria) this;
        }

        public Criteria andClickIconLessThanOrEqualTo(String value) {
            addCriterion("click_icon <=", value, "clickIcon");
            return (Criteria) this;
        }

        public Criteria andClickIconLike(String value) {
            addCriterion("click_icon like", value, "clickIcon");
            return (Criteria) this;
        }

        public Criteria andClickIconNotLike(String value) {
            addCriterion("click_icon not like", value, "clickIcon");
            return (Criteria) this;
        }

        public Criteria andClickIconIn(List<String> values) {
            addCriterion("click_icon in", values, "clickIcon");
            return (Criteria) this;
        }

        public Criteria andClickIconNotIn(List<String> values) {
            addCriterion("click_icon not in", values, "clickIcon");
            return (Criteria) this;
        }

        public Criteria andClickIconBetween(String value1, String value2) {
            addCriterion("click_icon between", value1, value2, "clickIcon");
            return (Criteria) this;
        }

        public Criteria andClickIconNotBetween(String value1, String value2) {
            addCriterion("click_icon not between", value1, value2, "clickIcon");
            return (Criteria) this;
        }

        public Criteria andUnclickIconIsNull() {
            addCriterion("unClick_icon is null");
            return (Criteria) this;
        }

        public Criteria andUnclickIconIsNotNull() {
            addCriterion("unClick_icon is not null");
            return (Criteria) this;
        }

        public Criteria andUnclickIconEqualTo(String value) {
            addCriterion("unClick_icon =", value, "unclickIcon");
            return (Criteria) this;
        }

        public Criteria andUnclickIconNotEqualTo(String value) {
            addCriterion("unClick_icon <>", value, "unclickIcon");
            return (Criteria) this;
        }

        public Criteria andUnclickIconGreaterThan(String value) {
            addCriterion("unClick_icon >", value, "unclickIcon");
            return (Criteria) this;
        }

        public Criteria andUnclickIconGreaterThanOrEqualTo(String value) {
            addCriterion("unClick_icon >=", value, "unclickIcon");
            return (Criteria) this;
        }

        public Criteria andUnclickIconLessThan(String value) {
            addCriterion("unClick_icon <", value, "unclickIcon");
            return (Criteria) this;
        }

        public Criteria andUnclickIconLessThanOrEqualTo(String value) {
            addCriterion("unClick_icon <=", value, "unclickIcon");
            return (Criteria) this;
        }

        public Criteria andUnclickIconLike(String value) {
            addCriterion("unClick_icon like", value, "unclickIcon");
            return (Criteria) this;
        }

        public Criteria andUnclickIconNotLike(String value) {
            addCriterion("unClick_icon not like", value, "unclickIcon");
            return (Criteria) this;
        }

        public Criteria andUnclickIconIn(List<String> values) {
            addCriterion("unClick_icon in", values, "unclickIcon");
            return (Criteria) this;
        }

        public Criteria andUnclickIconNotIn(List<String> values) {
            addCriterion("unClick_icon not in", values, "unclickIcon");
            return (Criteria) this;
        }

        public Criteria andUnclickIconBetween(String value1, String value2) {
            addCriterion("unClick_icon between", value1, value2, "unclickIcon");
            return (Criteria) this;
        }

        public Criteria andUnclickIconNotBetween(String value1, String value2) {
            addCriterion("unClick_icon not between", value1, value2, "unclickIcon");
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