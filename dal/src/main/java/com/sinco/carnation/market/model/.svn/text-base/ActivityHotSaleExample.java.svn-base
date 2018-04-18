package com.sinco.carnation.market.model;

import com.sinco.carnation.market.bo.ActivityHotSaleBO;
import com.sinco.mybatis.dal.core.AbstractExample;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityHotSaleExample extends AbstractExample<ActivityHotSaleBO> {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String limit;

    public ActivityHotSaleExample() {
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

        public Criteria andHotNameIsNull() {
            addCriterion("hot_name is null");
            return (Criteria) this;
        }

        public Criteria andHotNameIsNotNull() {
            addCriterion("hot_name is not null");
            return (Criteria) this;
        }

        public Criteria andHotNameEqualTo(String value) {
            addCriterion("hot_name =", value, "hotName");
            return (Criteria) this;
        }

        public Criteria andHotNameNotEqualTo(String value) {
            addCriterion("hot_name <>", value, "hotName");
            return (Criteria) this;
        }

        public Criteria andHotNameGreaterThan(String value) {
            addCriterion("hot_name >", value, "hotName");
            return (Criteria) this;
        }

        public Criteria andHotNameGreaterThanOrEqualTo(String value) {
            addCriterion("hot_name >=", value, "hotName");
            return (Criteria) this;
        }

        public Criteria andHotNameLessThan(String value) {
            addCriterion("hot_name <", value, "hotName");
            return (Criteria) this;
        }

        public Criteria andHotNameLessThanOrEqualTo(String value) {
            addCriterion("hot_name <=", value, "hotName");
            return (Criteria) this;
        }

        public Criteria andHotNameLike(String value) {
            addCriterion("hot_name like", value, "hotName");
            return (Criteria) this;
        }

        public Criteria andHotNameNotLike(String value) {
            addCriterion("hot_name not like", value, "hotName");
            return (Criteria) this;
        }

        public Criteria andHotNameIn(List<String> values) {
            addCriterion("hot_name in", values, "hotName");
            return (Criteria) this;
        }

        public Criteria andHotNameNotIn(List<String> values) {
            addCriterion("hot_name not in", values, "hotName");
            return (Criteria) this;
        }

        public Criteria andHotNameBetween(String value1, String value2) {
            addCriterion("hot_name between", value1, value2, "hotName");
            return (Criteria) this;
        }

        public Criteria andHotNameNotBetween(String value1, String value2) {
            addCriterion("hot_name not between", value1, value2, "hotName");
            return (Criteria) this;
        }

        public Criteria andFirstImageIsNull() {
            addCriterion("first_image is null");
            return (Criteria) this;
        }

        public Criteria andFirstImageIsNotNull() {
            addCriterion("first_image is not null");
            return (Criteria) this;
        }

        public Criteria andFirstImageEqualTo(String value) {
            addCriterion("first_image =", value, "firstImage");
            return (Criteria) this;
        }

        public Criteria andFirstImageNotEqualTo(String value) {
            addCriterion("first_image <>", value, "firstImage");
            return (Criteria) this;
        }

        public Criteria andFirstImageGreaterThan(String value) {
            addCriterion("first_image >", value, "firstImage");
            return (Criteria) this;
        }

        public Criteria andFirstImageGreaterThanOrEqualTo(String value) {
            addCriterion("first_image >=", value, "firstImage");
            return (Criteria) this;
        }

        public Criteria andFirstImageLessThan(String value) {
            addCriterion("first_image <", value, "firstImage");
            return (Criteria) this;
        }

        public Criteria andFirstImageLessThanOrEqualTo(String value) {
            addCriterion("first_image <=", value, "firstImage");
            return (Criteria) this;
        }

        public Criteria andFirstImageLike(String value) {
            addCriterion("first_image like", value, "firstImage");
            return (Criteria) this;
        }

        public Criteria andFirstImageNotLike(String value) {
            addCriterion("first_image not like", value, "firstImage");
            return (Criteria) this;
        }

        public Criteria andFirstImageIn(List<String> values) {
            addCriterion("first_image in", values, "firstImage");
            return (Criteria) this;
        }

        public Criteria andFirstImageNotIn(List<String> values) {
            addCriterion("first_image not in", values, "firstImage");
            return (Criteria) this;
        }

        public Criteria andFirstImageBetween(String value1, String value2) {
            addCriterion("first_image between", value1, value2, "firstImage");
            return (Criteria) this;
        }

        public Criteria andFirstImageNotBetween(String value1, String value2) {
            addCriterion("first_image not between", value1, value2, "firstImage");
            return (Criteria) this;
        }

        public Criteria andHeadImageIsNull() {
            addCriterion("head_image is null");
            return (Criteria) this;
        }

        public Criteria andHeadImageIsNotNull() {
            addCriterion("head_image is not null");
            return (Criteria) this;
        }

        public Criteria andHeadImageEqualTo(String value) {
            addCriterion("head_image =", value, "headImage");
            return (Criteria) this;
        }

        public Criteria andHeadImageNotEqualTo(String value) {
            addCriterion("head_image <>", value, "headImage");
            return (Criteria) this;
        }

        public Criteria andHeadImageGreaterThan(String value) {
            addCriterion("head_image >", value, "headImage");
            return (Criteria) this;
        }

        public Criteria andHeadImageGreaterThanOrEqualTo(String value) {
            addCriterion("head_image >=", value, "headImage");
            return (Criteria) this;
        }

        public Criteria andHeadImageLessThan(String value) {
            addCriterion("head_image <", value, "headImage");
            return (Criteria) this;
        }

        public Criteria andHeadImageLessThanOrEqualTo(String value) {
            addCriterion("head_image <=", value, "headImage");
            return (Criteria) this;
        }

        public Criteria andHeadImageLike(String value) {
            addCriterion("head_image like", value, "headImage");
            return (Criteria) this;
        }

        public Criteria andHeadImageNotLike(String value) {
            addCriterion("head_image not like", value, "headImage");
            return (Criteria) this;
        }

        public Criteria andHeadImageIn(List<String> values) {
            addCriterion("head_image in", values, "headImage");
            return (Criteria) this;
        }

        public Criteria andHeadImageNotIn(List<String> values) {
            addCriterion("head_image not in", values, "headImage");
            return (Criteria) this;
        }

        public Criteria andHeadImageBetween(String value1, String value2) {
            addCriterion("head_image between", value1, value2, "headImage");
            return (Criteria) this;
        }

        public Criteria andHeadImageNotBetween(String value1, String value2) {
            addCriterion("head_image not between", value1, value2, "headImage");
            return (Criteria) this;
        }

        public Criteria andFootImageIsNull() {
            addCriterion("foot_image is null");
            return (Criteria) this;
        }

        public Criteria andFootImageIsNotNull() {
            addCriterion("foot_image is not null");
            return (Criteria) this;
        }

        public Criteria andFootImageEqualTo(String value) {
            addCriterion("foot_image =", value, "footImage");
            return (Criteria) this;
        }

        public Criteria andFootImageNotEqualTo(String value) {
            addCriterion("foot_image <>", value, "footImage");
            return (Criteria) this;
        }

        public Criteria andFootImageGreaterThan(String value) {
            addCriterion("foot_image >", value, "footImage");
            return (Criteria) this;
        }

        public Criteria andFootImageGreaterThanOrEqualTo(String value) {
            addCriterion("foot_image >=", value, "footImage");
            return (Criteria) this;
        }

        public Criteria andFootImageLessThan(String value) {
            addCriterion("foot_image <", value, "footImage");
            return (Criteria) this;
        }

        public Criteria andFootImageLessThanOrEqualTo(String value) {
            addCriterion("foot_image <=", value, "footImage");
            return (Criteria) this;
        }

        public Criteria andFootImageLike(String value) {
            addCriterion("foot_image like", value, "footImage");
            return (Criteria) this;
        }

        public Criteria andFootImageNotLike(String value) {
            addCriterion("foot_image not like", value, "footImage");
            return (Criteria) this;
        }

        public Criteria andFootImageIn(List<String> values) {
            addCriterion("foot_image in", values, "footImage");
            return (Criteria) this;
        }

        public Criteria andFootImageNotIn(List<String> values) {
            addCriterion("foot_image not in", values, "footImage");
            return (Criteria) this;
        }

        public Criteria andFootImageBetween(String value1, String value2) {
            addCriterion("foot_image between", value1, value2, "footImage");
            return (Criteria) this;
        }

        public Criteria andFootImageNotBetween(String value1, String value2) {
            addCriterion("foot_image not between", value1, value2, "footImage");
            return (Criteria) this;
        }

        public Criteria andVcodeIsNull() {
            addCriterion("vcode is null");
            return (Criteria) this;
        }

        public Criteria andVcodeIsNotNull() {
            addCriterion("vcode is not null");
            return (Criteria) this;
        }

        public Criteria andVcodeEqualTo(String value) {
            addCriterion("vcode =", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeNotEqualTo(String value) {
            addCriterion("vcode <>", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeGreaterThan(String value) {
            addCriterion("vcode >", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeGreaterThanOrEqualTo(String value) {
            addCriterion("vcode >=", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeLessThan(String value) {
            addCriterion("vcode <", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeLessThanOrEqualTo(String value) {
            addCriterion("vcode <=", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeLike(String value) {
            addCriterion("vcode like", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeNotLike(String value) {
            addCriterion("vcode not like", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeIn(List<String> values) {
            addCriterion("vcode in", values, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeNotIn(List<String> values) {
            addCriterion("vcode not in", values, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeBetween(String value1, String value2) {
            addCriterion("vcode between", value1, value2, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeNotBetween(String value1, String value2) {
            addCriterion("vcode not between", value1, value2, "vcode");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andIsEnabledIsNull() {
            addCriterion("is_enabled is null");
            return (Criteria) this;
        }

        public Criteria andIsEnabledIsNotNull() {
            addCriterion("is_enabled is not null");
            return (Criteria) this;
        }

        public Criteria andIsEnabledEqualTo(Byte value) {
            addCriterion("is_enabled =", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledNotEqualTo(Byte value) {
            addCriterion("is_enabled <>", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledGreaterThan(Byte value) {
            addCriterion("is_enabled >", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_enabled >=", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledLessThan(Byte value) {
            addCriterion("is_enabled <", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledLessThanOrEqualTo(Byte value) {
            addCriterion("is_enabled <=", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledIn(List<Byte> values) {
            addCriterion("is_enabled in", values, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledNotIn(List<Byte> values) {
            addCriterion("is_enabled not in", values, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledBetween(Byte value1, Byte value2) {
            addCriterion("is_enabled between", value1, value2, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledNotBetween(Byte value1, Byte value2) {
            addCriterion("is_enabled not between", value1, value2, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(Long value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(Long value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(Long value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(Long value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(Long value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(Long value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<Long> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<Long> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(Long value1, Long value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(Long value1, Long value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
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

        public Criteria andModifyByIsNull() {
            addCriterion("modify_by is null");
            return (Criteria) this;
        }

        public Criteria andModifyByIsNotNull() {
            addCriterion("modify_by is not null");
            return (Criteria) this;
        }

        public Criteria andModifyByEqualTo(Long value) {
            addCriterion("modify_by =", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByNotEqualTo(Long value) {
            addCriterion("modify_by <>", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByGreaterThan(Long value) {
            addCriterion("modify_by >", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByGreaterThanOrEqualTo(Long value) {
            addCriterion("modify_by >=", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByLessThan(Long value) {
            addCriterion("modify_by <", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByLessThanOrEqualTo(Long value) {
            addCriterion("modify_by <=", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByIn(List<Long> values) {
            addCriterion("modify_by in", values, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByNotIn(List<Long> values) {
            addCriterion("modify_by not in", values, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByBetween(Long value1, Long value2) {
            addCriterion("modify_by between", value1, value2, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByNotBetween(Long value1, Long value2) {
            addCriterion("modify_by not between", value1, value2, "modifyBy");
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

        public Criteria andDeleteStatusIsNull() {
            addCriterion("delete_status is null");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusIsNotNull() {
            addCriterion("delete_status is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusEqualTo(Byte value) {
            addCriterion("delete_status =", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotEqualTo(Byte value) {
            addCriterion("delete_status <>", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusGreaterThan(Byte value) {
            addCriterion("delete_status >", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("delete_status >=", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusLessThan(Byte value) {
            addCriterion("delete_status <", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusLessThanOrEqualTo(Byte value) {
            addCriterion("delete_status <=", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusIn(List<Byte> values) {
            addCriterion("delete_status in", values, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotIn(List<Byte> values) {
            addCriterion("delete_status not in", values, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusBetween(Byte value1, Byte value2) {
            addCriterion("delete_status between", value1, value2, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("delete_status not between", value1, value2, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andActTypeIsNull() {
            addCriterion("act_type is null");
            return (Criteria) this;
        }

        public Criteria andActTypeIsNotNull() {
            addCriterion("act_type is not null");
            return (Criteria) this;
        }

        public Criteria andActTypeEqualTo(String value) {
            addCriterion("act_type =", value, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeNotEqualTo(String value) {
            addCriterion("act_type <>", value, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeGreaterThan(String value) {
            addCriterion("act_type >", value, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeGreaterThanOrEqualTo(String value) {
            addCriterion("act_type >=", value, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeLessThan(String value) {
            addCriterion("act_type <", value, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeLessThanOrEqualTo(String value) {
            addCriterion("act_type <=", value, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeLike(String value) {
            addCriterion("act_type like", value, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeNotLike(String value) {
            addCriterion("act_type not like", value, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeIn(List<String> values) {
            addCriterion("act_type in", values, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeNotIn(List<String> values) {
            addCriterion("act_type not in", values, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeBetween(String value1, String value2) {
            addCriterion("act_type between", value1, value2, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeNotBetween(String value1, String value2) {
            addCriterion("act_type not between", value1, value2, "actType");
            return (Criteria) this;
        }

        public Criteria andBackgroundcolorIsNull() {
            addCriterion("backgroundcolor is null");
            return (Criteria) this;
        }

        public Criteria andBackgroundcolorIsNotNull() {
            addCriterion("backgroundcolor is not null");
            return (Criteria) this;
        }

        public Criteria andBackgroundcolorEqualTo(String value) {
            addCriterion("backgroundcolor =", value, "backgroundcolor");
            return (Criteria) this;
        }

        public Criteria andBackgroundcolorNotEqualTo(String value) {
            addCriterion("backgroundcolor <>", value, "backgroundcolor");
            return (Criteria) this;
        }

        public Criteria andBackgroundcolorGreaterThan(String value) {
            addCriterion("backgroundcolor >", value, "backgroundcolor");
            return (Criteria) this;
        }

        public Criteria andBackgroundcolorGreaterThanOrEqualTo(String value) {
            addCriterion("backgroundcolor >=", value, "backgroundcolor");
            return (Criteria) this;
        }

        public Criteria andBackgroundcolorLessThan(String value) {
            addCriterion("backgroundcolor <", value, "backgroundcolor");
            return (Criteria) this;
        }

        public Criteria andBackgroundcolorLessThanOrEqualTo(String value) {
            addCriterion("backgroundcolor <=", value, "backgroundcolor");
            return (Criteria) this;
        }

        public Criteria andBackgroundcolorLike(String value) {
            addCriterion("backgroundcolor like", value, "backgroundcolor");
            return (Criteria) this;
        }

        public Criteria andBackgroundcolorNotLike(String value) {
            addCriterion("backgroundcolor not like", value, "backgroundcolor");
            return (Criteria) this;
        }

        public Criteria andBackgroundcolorIn(List<String> values) {
            addCriterion("backgroundcolor in", values, "backgroundcolor");
            return (Criteria) this;
        }

        public Criteria andBackgroundcolorNotIn(List<String> values) {
            addCriterion("backgroundcolor not in", values, "backgroundcolor");
            return (Criteria) this;
        }

        public Criteria andBackgroundcolorBetween(String value1, String value2) {
            addCriterion("backgroundcolor between", value1, value2, "backgroundcolor");
            return (Criteria) this;
        }

        public Criteria andBackgroundcolorNotBetween(String value1, String value2) {
            addCriterion("backgroundcolor not between", value1, value2, "backgroundcolor");
            return (Criteria) this;
        }

        public Criteria andAdsUrlIsNull() {
            addCriterion("ads_url is null");
            return (Criteria) this;
        }

        public Criteria andAdsUrlIsNotNull() {
            addCriterion("ads_url is not null");
            return (Criteria) this;
        }

        public Criteria andAdsUrlEqualTo(String value) {
            addCriterion("ads_url =", value, "adsUrl");
            return (Criteria) this;
        }

        public Criteria andAdsUrlNotEqualTo(String value) {
            addCriterion("ads_url <>", value, "adsUrl");
            return (Criteria) this;
        }

        public Criteria andAdsUrlGreaterThan(String value) {
            addCriterion("ads_url >", value, "adsUrl");
            return (Criteria) this;
        }

        public Criteria andAdsUrlGreaterThanOrEqualTo(String value) {
            addCriterion("ads_url >=", value, "adsUrl");
            return (Criteria) this;
        }

        public Criteria andAdsUrlLessThan(String value) {
            addCriterion("ads_url <", value, "adsUrl");
            return (Criteria) this;
        }

        public Criteria andAdsUrlLessThanOrEqualTo(String value) {
            addCriterion("ads_url <=", value, "adsUrl");
            return (Criteria) this;
        }

        public Criteria andAdsUrlLike(String value) {
            addCriterion("ads_url like", value, "adsUrl");
            return (Criteria) this;
        }

        public Criteria andAdsUrlNotLike(String value) {
            addCriterion("ads_url not like", value, "adsUrl");
            return (Criteria) this;
        }

        public Criteria andAdsUrlIn(List<String> values) {
            addCriterion("ads_url in", values, "adsUrl");
            return (Criteria) this;
        }

        public Criteria andAdsUrlNotIn(List<String> values) {
            addCriterion("ads_url not in", values, "adsUrl");
            return (Criteria) this;
        }

        public Criteria andAdsUrlBetween(String value1, String value2) {
            addCriterion("ads_url between", value1, value2, "adsUrl");
            return (Criteria) this;
        }

        public Criteria andAdsUrlNotBetween(String value1, String value2) {
            addCriterion("ads_url not between", value1, value2, "adsUrl");
            return (Criteria) this;
        }

        public Criteria andImageSizeIsNull() {
            addCriterion("image_size is null");
            return (Criteria) this;
        }

        public Criteria andImageSizeIsNotNull() {
            addCriterion("image_size is not null");
            return (Criteria) this;
        }

        public Criteria andImageSizeEqualTo(Long value) {
            addCriterion("image_size =", value, "imageSize");
            return (Criteria) this;
        }

        public Criteria andImageSizeNotEqualTo(Long value) {
            addCriterion("image_size <>", value, "imageSize");
            return (Criteria) this;
        }

        public Criteria andImageSizeGreaterThan(Long value) {
            addCriterion("image_size >", value, "imageSize");
            return (Criteria) this;
        }

        public Criteria andImageSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("image_size >=", value, "imageSize");
            return (Criteria) this;
        }

        public Criteria andImageSizeLessThan(Long value) {
            addCriterion("image_size <", value, "imageSize");
            return (Criteria) this;
        }

        public Criteria andImageSizeLessThanOrEqualTo(Long value) {
            addCriterion("image_size <=", value, "imageSize");
            return (Criteria) this;
        }

        public Criteria andImageSizeIn(List<Long> values) {
            addCriterion("image_size in", values, "imageSize");
            return (Criteria) this;
        }

        public Criteria andImageSizeNotIn(List<Long> values) {
            addCriterion("image_size not in", values, "imageSize");
            return (Criteria) this;
        }

        public Criteria andImageSizeBetween(Long value1, Long value2) {
            addCriterion("image_size between", value1, value2, "imageSize");
            return (Criteria) this;
        }

        public Criteria andImageSizeNotBetween(Long value1, Long value2) {
            addCriterion("image_size not between", value1, value2, "imageSize");
            return (Criteria) this;
        }

        public Criteria andUpdateMarkIsNull() {
            addCriterion("update_mark is null");
            return (Criteria) this;
        }

        public Criteria andUpdateMarkIsNotNull() {
            addCriterion("update_mark is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateMarkEqualTo(Integer value) {
            addCriterion("update_mark =", value, "updateMark");
            return (Criteria) this;
        }

        public Criteria andUpdateMarkNotEqualTo(Integer value) {
            addCriterion("update_mark <>", value, "updateMark");
            return (Criteria) this;
        }

        public Criteria andUpdateMarkGreaterThan(Integer value) {
            addCriterion("update_mark >", value, "updateMark");
            return (Criteria) this;
        }

        public Criteria andUpdateMarkGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_mark >=", value, "updateMark");
            return (Criteria) this;
        }

        public Criteria andUpdateMarkLessThan(Integer value) {
            addCriterion("update_mark <", value, "updateMark");
            return (Criteria) this;
        }

        public Criteria andUpdateMarkLessThanOrEqualTo(Integer value) {
            addCriterion("update_mark <=", value, "updateMark");
            return (Criteria) this;
        }

        public Criteria andUpdateMarkIn(List<Integer> values) {
            addCriterion("update_mark in", values, "updateMark");
            return (Criteria) this;
        }

        public Criteria andUpdateMarkNotIn(List<Integer> values) {
            addCriterion("update_mark not in", values, "updateMark");
            return (Criteria) this;
        }

        public Criteria andUpdateMarkBetween(Integer value1, Integer value2) {
            addCriterion("update_mark between", value1, value2, "updateMark");
            return (Criteria) this;
        }

        public Criteria andUpdateMarkNotBetween(Integer value1, Integer value2) {
            addCriterion("update_mark not between", value1, value2, "updateMark");
            return (Criteria) this;
        }
        
        public Criteria andAlterPicIsNull() {
            addCriterion("alter_pic is null");
            return (Criteria) this;
        }

        public Criteria andAlterPicIsNotNull() {
            addCriterion("alter_pic is not null");
            return (Criteria) this;
        }

        public Criteria andAlterPicEqualTo(String value) {
            addCriterion("alter_pic =", value, "alterPic");
            return (Criteria) this;
        }

        public Criteria andAlterPicNotEqualTo(String value) {
            addCriterion("alter_pic <>", value, "alterPic");
            return (Criteria) this;
        }

        public Criteria andAlterPicGreaterThan(String value) {
            addCriterion("alter_pic >", value, "alterPic");
            return (Criteria) this;
        }

        public Criteria andAlterPicGreaterThanOrEqualTo(String value) {
            addCriterion("alter_pic >=", value, "alterPic");
            return (Criteria) this;
        }

        public Criteria andAlterPicLessThan(String value) {
            addCriterion("alter_pic <", value, "alterPic");
            return (Criteria) this;
        }

        public Criteria andAlterPicLessThanOrEqualTo(String value) {
            addCriterion("alter_pic <=", value, "alterPic");
            return (Criteria) this;
        }

        public Criteria andAlterPicLike(String value) {
            addCriterion("alter_pic like", value, "alterPic");
            return (Criteria) this;
        }

        public Criteria andAlterPicNotLike(String value) {
            addCriterion("alter_pic not like", value, "alterPic");
            return (Criteria) this;
        }

        public Criteria andAlterPicIn(List<String> values) {
            addCriterion("alter_pic in", values, "alterPic");
            return (Criteria) this;
        }

        public Criteria andAlterPicNotIn(List<String> values) {
            addCriterion("alter_pic not in", values, "alterPic");
            return (Criteria) this;
        }

        public Criteria andAlterPicBetween(String value1, String value2) {
            addCriterion("alter_pic between", value1, value2, "alterPic");
            return (Criteria) this;
        }

        public Criteria andAlterPicNotBetween(String value1, String value2) {
            addCriterion("alter_pic not between", value1, value2, "alterPic");
            return (Criteria) this;
        }

        public Criteria andFirstOpenIsNull() {
            addCriterion("first_open is null");
            return (Criteria) this;
        }

        public Criteria andFirstOpenIsNotNull() {
            addCriterion("first_open is not null");
            return (Criteria) this;
        }

        public Criteria andFirstOpenEqualTo(Boolean value) {
            addCriterion("first_open =", value, "firstOpen");
            return (Criteria) this;
        }

        public Criteria andFirstOpenNotEqualTo(Boolean value) {
            addCriterion("first_open <>", value, "firstOpen");
            return (Criteria) this;
        }

        public Criteria andFirstOpenGreaterThan(Boolean value) {
            addCriterion("first_open >", value, "firstOpen");
            return (Criteria) this;
        }

        public Criteria andFirstOpenGreaterThanOrEqualTo(Boolean value) {
            addCriterion("first_open >=", value, "firstOpen");
            return (Criteria) this;
        }

        public Criteria andFirstOpenLessThan(Boolean value) {
            addCriterion("first_open <", value, "firstOpen");
            return (Criteria) this;
        }

        public Criteria andFirstOpenLessThanOrEqualTo(Boolean value) {
            addCriterion("first_open <=", value, "firstOpen");
            return (Criteria) this;
        }

        public Criteria andFirstOpenIn(List<Boolean> values) {
            addCriterion("first_open in", values, "firstOpen");
            return (Criteria) this;
        }

        public Criteria andFirstOpenNotIn(List<Boolean> values) {
            addCriterion("first_open not in", values, "firstOpen");
            return (Criteria) this;
        }

        public Criteria andFirstOpenBetween(Boolean value1, Boolean value2) {
            addCriterion("first_open between", value1, value2, "firstOpen");
            return (Criteria) this;
        }

        public Criteria andFirstOpenNotBetween(Boolean value1, Boolean value2) {
            addCriterion("first_open not between", value1, value2, "firstOpen");
            return (Criteria) this;
        }

        public Criteria andCustomOpenIsNull() {
            addCriterion("custom_open is null");
            return (Criteria) this;
        }

        public Criteria andCustomOpenIsNotNull() {
            addCriterion("custom_open is not null");
            return (Criteria) this;
        }

        public Criteria andCustomOpenEqualTo(Boolean value) {
            addCriterion("custom_open =", value, "customOpen");
            return (Criteria) this;
        }

        public Criteria andCustomOpenNotEqualTo(Boolean value) {
            addCriterion("custom_open <>", value, "customOpen");
            return (Criteria) this;
        }

        public Criteria andCustomOpenGreaterThan(Boolean value) {
            addCriterion("custom_open >", value, "customOpen");
            return (Criteria) this;
        }

        public Criteria andCustomOpenGreaterThanOrEqualTo(Boolean value) {
            addCriterion("custom_open >=", value, "customOpen");
            return (Criteria) this;
        }

        public Criteria andCustomOpenLessThan(Boolean value) {
            addCriterion("custom_open <", value, "customOpen");
            return (Criteria) this;
        }

        public Criteria andCustomOpenLessThanOrEqualTo(Boolean value) {
            addCriterion("custom_open <=", value, "customOpen");
            return (Criteria) this;
        }

        public Criteria andCustomOpenIn(List<Boolean> values) {
            addCriterion("custom_open in", values, "customOpen");
            return (Criteria) this;
        }

        public Criteria andCustomOpenNotIn(List<Boolean> values) {
            addCriterion("custom_open not in", values, "customOpen");
            return (Criteria) this;
        }

        public Criteria andCustomOpenBetween(Boolean value1, Boolean value2) {
            addCriterion("custom_open between", value1, value2, "customOpen");
            return (Criteria) this;
        }

        public Criteria andCustomOpenNotBetween(Boolean value1, Boolean value2) {
            addCriterion("custom_open not between", value1, value2, "customOpen");
            return (Criteria) this;
        }

        public Criteria andFloatPicIsNull() {
            addCriterion("float_pic is null");
            return (Criteria) this;
        }

        public Criteria andFloatPicIsNotNull() {
            addCriterion("float_pic is not null");
            return (Criteria) this;
        }

        public Criteria andFloatPicEqualTo(String value) {
            addCriterion("float_pic =", value, "floatPic");
            return (Criteria) this;
        }

        public Criteria andFloatPicNotEqualTo(String value) {
            addCriterion("float_pic <>", value, "floatPic");
            return (Criteria) this;
        }

        public Criteria andFloatPicGreaterThan(String value) {
            addCriterion("float_pic >", value, "floatPic");
            return (Criteria) this;
        }

        public Criteria andFloatPicGreaterThanOrEqualTo(String value) {
            addCriterion("float_pic >=", value, "floatPic");
            return (Criteria) this;
        }

        public Criteria andFloatPicLessThan(String value) {
            addCriterion("float_pic <", value, "floatPic");
            return (Criteria) this;
        }

        public Criteria andFloatPicLessThanOrEqualTo(String value) {
            addCriterion("float_pic <=", value, "floatPic");
            return (Criteria) this;
        }

        public Criteria andFloatPicLike(String value) {
            addCriterion("float_pic like", value, "floatPic");
            return (Criteria) this;
        }

        public Criteria andFloatPicNotLike(String value) {
            addCriterion("float_pic not like", value, "floatPic");
            return (Criteria) this;
        }

        public Criteria andFloatPicIn(List<String> values) {
            addCriterion("float_pic in", values, "floatPic");
            return (Criteria) this;
        }

        public Criteria andFloatPicNotIn(List<String> values) {
            addCriterion("float_pic not in", values, "floatPic");
            return (Criteria) this;
        }

        public Criteria andFloatPicBetween(String value1, String value2) {
            addCriterion("float_pic between", value1, value2, "floatPic");
            return (Criteria) this;
        }

        public Criteria andFloatPicNotBetween(String value1, String value2) {
            addCriterion("float_pic not between", value1, value2, "floatPic");
            return (Criteria) this;
        }

        public Criteria andFloatPicShowIsNull() {
            addCriterion("float_pic_show is null");
            return (Criteria) this;
        }

        public Criteria andFloatPicShowIsNotNull() {
            addCriterion("float_pic_show is not null");
            return (Criteria) this;
        }

        public Criteria andFloatPicShowEqualTo(Boolean value) {
            addCriterion("float_pic_show =", value, "floatPicShow");
            return (Criteria) this;
        }

        public Criteria andFloatPicShowNotEqualTo(Boolean value) {
            addCriterion("float_pic_show <>", value, "floatPicShow");
            return (Criteria) this;
        }

        public Criteria andFloatPicShowGreaterThan(Boolean value) {
            addCriterion("float_pic_show >", value, "floatPicShow");
            return (Criteria) this;
        }

        public Criteria andFloatPicShowGreaterThanOrEqualTo(Boolean value) {
            addCriterion("float_pic_show >=", value, "floatPicShow");
            return (Criteria) this;
        }

        public Criteria andFloatPicShowLessThan(Boolean value) {
            addCriterion("float_pic_show <", value, "floatPicShow");
            return (Criteria) this;
        }

        public Criteria andFloatPicShowLessThanOrEqualTo(Boolean value) {
            addCriterion("float_pic_show <=", value, "floatPicShow");
            return (Criteria) this;
        }

        public Criteria andFloatPicShowIn(List<Boolean> values) {
            addCriterion("float_pic_show in", values, "floatPicShow");
            return (Criteria) this;
        }

        public Criteria andFloatPicShowNotIn(List<Boolean> values) {
            addCriterion("float_pic_show not in", values, "floatPicShow");
            return (Criteria) this;
        }

        public Criteria andFloatPicShowBetween(Boolean value1, Boolean value2) {
            addCriterion("float_pic_show between", value1, value2, "floatPicShow");
            return (Criteria) this;
        }

        public Criteria andFloatPicShowNotBetween(Boolean value1, Boolean value2) {
            addCriterion("float_pic_show not between", value1, value2, "floatPicShow");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeIsNull() {
            addCriterion("open_start_time is null");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeIsNotNull() {
            addCriterion("open_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeEqualTo(Integer value) {
            addCriterion("open_start_time =", value, "openStartTime");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeNotEqualTo(Integer value) {
            addCriterion("open_start_time <>", value, "openStartTime");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeGreaterThan(Integer value) {
            addCriterion("open_start_time >", value, "openStartTime");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("open_start_time >=", value, "openStartTime");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeLessThan(Integer value) {
            addCriterion("open_start_time <", value, "openStartTime");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeLessThanOrEqualTo(Integer value) {
            addCriterion("open_start_time <=", value, "openStartTime");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeIn(List<Integer> values) {
            addCriterion("open_start_time in", values, "openStartTime");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeNotIn(List<Integer> values) {
            addCriterion("open_start_time not in", values, "openStartTime");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeBetween(Integer value1, Integer value2) {
            addCriterion("open_start_time between", value1, value2, "openStartTime");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("open_start_time not between", value1, value2, "openStartTime");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeIsNull() {
            addCriterion("open_end_time is null");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeIsNotNull() {
            addCriterion("open_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeEqualTo(Integer value) {
            addCriterion("open_end_time =", value, "openEndTime");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeNotEqualTo(Integer value) {
            addCriterion("open_end_time <>", value, "openEndTime");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeGreaterThan(Integer value) {
            addCriterion("open_end_time >", value, "openEndTime");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("open_end_time >=", value, "openEndTime");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeLessThan(Integer value) {
            addCriterion("open_end_time <", value, "openEndTime");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeLessThanOrEqualTo(Integer value) {
            addCriterion("open_end_time <=", value, "openEndTime");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeIn(List<Integer> values) {
            addCriterion("open_end_time in", values, "openEndTime");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeNotIn(List<Integer> values) {
            addCriterion("open_end_time not in", values, "openEndTime");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeBetween(Integer value1, Integer value2) {
            addCriterion("open_end_time between", value1, value2, "openEndTime");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("open_end_time not between", value1, value2, "openEndTime");
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