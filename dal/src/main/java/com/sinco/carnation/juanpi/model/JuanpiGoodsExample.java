package com.sinco.carnation.juanpi.model;

import com.sinco.carnation.juanpi.bo.JuanpiGoodsBO;
import com.sinco.mybatis.dal.core.AbstractExample;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JuanpiGoodsExample extends AbstractExample<JuanpiGoodsBO> {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String limit;

    public JuanpiGoodsExample() {
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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

        public Criteria andGoodsTitleIsNull() {
            addCriterion("goods_title is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleIsNotNull() {
            addCriterion("goods_title is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleEqualTo(String value) {
            addCriterion("goods_title =", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleNotEqualTo(String value) {
            addCriterion("goods_title <>", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleGreaterThan(String value) {
            addCriterion("goods_title >", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleGreaterThanOrEqualTo(String value) {
            addCriterion("goods_title >=", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleLessThan(String value) {
            addCriterion("goods_title <", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleLessThanOrEqualTo(String value) {
            addCriterion("goods_title <=", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleLike(String value) {
            addCriterion("goods_title like", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleNotLike(String value) {
            addCriterion("goods_title not like", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleIn(List<String> values) {
            addCriterion("goods_title in", values, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleNotIn(List<String> values) {
            addCriterion("goods_title not in", values, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleBetween(String value1, String value2) {
            addCriterion("goods_title between", value1, value2, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleNotBetween(String value1, String value2) {
            addCriterion("goods_title not between", value1, value2, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andImageUrlIsNull() {
            addCriterion("image_url is null");
            return (Criteria) this;
        }

        public Criteria andImageUrlIsNotNull() {
            addCriterion("image_url is not null");
            return (Criteria) this;
        }

        public Criteria andImageUrlEqualTo(String value) {
            addCriterion("image_url =", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotEqualTo(String value) {
            addCriterion("image_url <>", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlGreaterThan(String value) {
            addCriterion("image_url >", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("image_url >=", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLessThan(String value) {
            addCriterion("image_url <", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLessThanOrEqualTo(String value) {
            addCriterion("image_url <=", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLike(String value) {
            addCriterion("image_url like", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotLike(String value) {
            addCriterion("image_url not like", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlIn(List<String> values) {
            addCriterion("image_url in", values, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotIn(List<String> values) {
            addCriterion("image_url not in", values, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlBetween(String value1, String value2) {
            addCriterion("image_url between", value1, value2, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotBetween(String value1, String value2) {
            addCriterion("image_url not between", value1, value2, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsCpriceIsNull() {
            addCriterion("goods_cprice is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCpriceIsNotNull() {
            addCriterion("goods_cprice is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCpriceEqualTo(BigDecimal value) {
            addCriterion("goods_cprice =", value, "goodsCprice");
            return (Criteria) this;
        }

        public Criteria andGoodsCpriceNotEqualTo(BigDecimal value) {
            addCriterion("goods_cprice <>", value, "goodsCprice");
            return (Criteria) this;
        }

        public Criteria andGoodsCpriceGreaterThan(BigDecimal value) {
            addCriterion("goods_cprice >", value, "goodsCprice");
            return (Criteria) this;
        }

        public Criteria andGoodsCpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_cprice >=", value, "goodsCprice");
            return (Criteria) this;
        }

        public Criteria andGoodsCpriceLessThan(BigDecimal value) {
            addCriterion("goods_cprice <", value, "goodsCprice");
            return (Criteria) this;
        }

        public Criteria andGoodsCpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_cprice <=", value, "goodsCprice");
            return (Criteria) this;
        }

        public Criteria andGoodsCpriceIn(List<BigDecimal> values) {
            addCriterion("goods_cprice in", values, "goodsCprice");
            return (Criteria) this;
        }

        public Criteria andGoodsCpriceNotIn(List<BigDecimal> values) {
            addCriterion("goods_cprice not in", values, "goodsCprice");
            return (Criteria) this;
        }

        public Criteria andGoodsCpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_cprice between", value1, value2, "goodsCprice");
            return (Criteria) this;
        }

        public Criteria andGoodsCpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_cprice not between", value1, value2, "goodsCprice");
            return (Criteria) this;
        }

        public Criteria andTuanCpriceIsNull() {
            addCriterion("tuan_cprice is null");
            return (Criteria) this;
        }

        public Criteria andTuanCpriceIsNotNull() {
            addCriterion("tuan_cprice is not null");
            return (Criteria) this;
        }

        public Criteria andTuanCpriceEqualTo(BigDecimal value) {
            addCriterion("tuan_cprice =", value, "tuanCprice");
            return (Criteria) this;
        }

        public Criteria andTuanCpriceNotEqualTo(BigDecimal value) {
            addCriterion("tuan_cprice <>", value, "tuanCprice");
            return (Criteria) this;
        }

        public Criteria andTuanCpriceGreaterThan(BigDecimal value) {
            addCriterion("tuan_cprice >", value, "tuanCprice");
            return (Criteria) this;
        }

        public Criteria andTuanCpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tuan_cprice >=", value, "tuanCprice");
            return (Criteria) this;
        }

        public Criteria andTuanCpriceLessThan(BigDecimal value) {
            addCriterion("tuan_cprice <", value, "tuanCprice");
            return (Criteria) this;
        }

        public Criteria andTuanCpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tuan_cprice <=", value, "tuanCprice");
            return (Criteria) this;
        }

        public Criteria andTuanCpriceIn(List<BigDecimal> values) {
            addCriterion("tuan_cprice in", values, "tuanCprice");
            return (Criteria) this;
        }

        public Criteria andTuanCpriceNotIn(List<BigDecimal> values) {
            addCriterion("tuan_cprice not in", values, "tuanCprice");
            return (Criteria) this;
        }

        public Criteria andTuanCpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tuan_cprice between", value1, value2, "tuanCprice");
            return (Criteria) this;
        }

        public Criteria andTuanCpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tuan_cprice not between", value1, value2, "tuanCprice");
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

        public Criteria andTargetUrlPcIsNull() {
            addCriterion("target_url_pc is null");
            return (Criteria) this;
        }

        public Criteria andTargetUrlPcIsNotNull() {
            addCriterion("target_url_pc is not null");
            return (Criteria) this;
        }

        public Criteria andTargetUrlPcEqualTo(String value) {
            addCriterion("target_url_pc =", value, "targetUrlPc");
            return (Criteria) this;
        }

        public Criteria andTargetUrlPcNotEqualTo(String value) {
            addCriterion("target_url_pc <>", value, "targetUrlPc");
            return (Criteria) this;
        }

        public Criteria andTargetUrlPcGreaterThan(String value) {
            addCriterion("target_url_pc >", value, "targetUrlPc");
            return (Criteria) this;
        }

        public Criteria andTargetUrlPcGreaterThanOrEqualTo(String value) {
            addCriterion("target_url_pc >=", value, "targetUrlPc");
            return (Criteria) this;
        }

        public Criteria andTargetUrlPcLessThan(String value) {
            addCriterion("target_url_pc <", value, "targetUrlPc");
            return (Criteria) this;
        }

        public Criteria andTargetUrlPcLessThanOrEqualTo(String value) {
            addCriterion("target_url_pc <=", value, "targetUrlPc");
            return (Criteria) this;
        }

        public Criteria andTargetUrlPcLike(String value) {
            addCriterion("target_url_pc like", value, "targetUrlPc");
            return (Criteria) this;
        }

        public Criteria andTargetUrlPcNotLike(String value) {
            addCriterion("target_url_pc not like", value, "targetUrlPc");
            return (Criteria) this;
        }

        public Criteria andTargetUrlPcIn(List<String> values) {
            addCriterion("target_url_pc in", values, "targetUrlPc");
            return (Criteria) this;
        }

        public Criteria andTargetUrlPcNotIn(List<String> values) {
            addCriterion("target_url_pc not in", values, "targetUrlPc");
            return (Criteria) this;
        }

        public Criteria andTargetUrlPcBetween(String value1, String value2) {
            addCriterion("target_url_pc between", value1, value2, "targetUrlPc");
            return (Criteria) this;
        }

        public Criteria andTargetUrlPcNotBetween(String value1, String value2) {
            addCriterion("target_url_pc not between", value1, value2, "targetUrlPc");
            return (Criteria) this;
        }

        public Criteria andTargetUrlMIsNull() {
            addCriterion("target_url_m is null");
            return (Criteria) this;
        }

        public Criteria andTargetUrlMIsNotNull() {
            addCriterion("target_url_m is not null");
            return (Criteria) this;
        }

        public Criteria andTargetUrlMEqualTo(String value) {
            addCriterion("target_url_m =", value, "targetUrlM");
            return (Criteria) this;
        }

        public Criteria andTargetUrlMNotEqualTo(String value) {
            addCriterion("target_url_m <>", value, "targetUrlM");
            return (Criteria) this;
        }

        public Criteria andTargetUrlMGreaterThan(String value) {
            addCriterion("target_url_m >", value, "targetUrlM");
            return (Criteria) this;
        }

        public Criteria andTargetUrlMGreaterThanOrEqualTo(String value) {
            addCriterion("target_url_m >=", value, "targetUrlM");
            return (Criteria) this;
        }

        public Criteria andTargetUrlMLessThan(String value) {
            addCriterion("target_url_m <", value, "targetUrlM");
            return (Criteria) this;
        }

        public Criteria andTargetUrlMLessThanOrEqualTo(String value) {
            addCriterion("target_url_m <=", value, "targetUrlM");
            return (Criteria) this;
        }

        public Criteria andTargetUrlMLike(String value) {
            addCriterion("target_url_m like", value, "targetUrlM");
            return (Criteria) this;
        }

        public Criteria andTargetUrlMNotLike(String value) {
            addCriterion("target_url_m not like", value, "targetUrlM");
            return (Criteria) this;
        }

        public Criteria andTargetUrlMIn(List<String> values) {
            addCriterion("target_url_m in", values, "targetUrlM");
            return (Criteria) this;
        }

        public Criteria andTargetUrlMNotIn(List<String> values) {
            addCriterion("target_url_m not in", values, "targetUrlM");
            return (Criteria) this;
        }

        public Criteria andTargetUrlMBetween(String value1, String value2) {
            addCriterion("target_url_m between", value1, value2, "targetUrlM");
            return (Criteria) this;
        }

        public Criteria andTargetUrlMNotBetween(String value1, String value2) {
            addCriterion("target_url_m not between", value1, value2, "targetUrlM");
            return (Criteria) this;
        }

        public Criteria andGoodsOnShelfIsNull() {
            addCriterion("goods_on_shelf is null");
            return (Criteria) this;
        }

        public Criteria andGoodsOnShelfIsNotNull() {
            addCriterion("goods_on_shelf is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsOnShelfEqualTo(Date value) {
            addCriterion("goods_on_shelf =", value, "goodsOnShelf");
            return (Criteria) this;
        }

        public Criteria andGoodsOnShelfNotEqualTo(Date value) {
            addCriterion("goods_on_shelf <>", value, "goodsOnShelf");
            return (Criteria) this;
        }

        public Criteria andGoodsOnShelfGreaterThan(Date value) {
            addCriterion("goods_on_shelf >", value, "goodsOnShelf");
            return (Criteria) this;
        }

        public Criteria andGoodsOnShelfGreaterThanOrEqualTo(Date value) {
            addCriterion("goods_on_shelf >=", value, "goodsOnShelf");
            return (Criteria) this;
        }

        public Criteria andGoodsOnShelfLessThan(Date value) {
            addCriterion("goods_on_shelf <", value, "goodsOnShelf");
            return (Criteria) this;
        }

        public Criteria andGoodsOnShelfLessThanOrEqualTo(Date value) {
            addCriterion("goods_on_shelf <=", value, "goodsOnShelf");
            return (Criteria) this;
        }

        public Criteria andGoodsOnShelfIn(List<Date> values) {
            addCriterion("goods_on_shelf in", values, "goodsOnShelf");
            return (Criteria) this;
        }

        public Criteria andGoodsOnShelfNotIn(List<Date> values) {
            addCriterion("goods_on_shelf not in", values, "goodsOnShelf");
            return (Criteria) this;
        }

        public Criteria andGoodsOnShelfBetween(Date value1, Date value2) {
            addCriterion("goods_on_shelf between", value1, value2, "goodsOnShelf");
            return (Criteria) this;
        }

        public Criteria andGoodsOnShelfNotBetween(Date value1, Date value2) {
            addCriterion("goods_on_shelf not between", value1, value2, "goodsOnShelf");
            return (Criteria) this;
        }

        public Criteria andGoodsOffShelfIsNull() {
            addCriterion("goods_off_shelf is null");
            return (Criteria) this;
        }

        public Criteria andGoodsOffShelfIsNotNull() {
            addCriterion("goods_off_shelf is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsOffShelfEqualTo(Date value) {
            addCriterion("goods_off_shelf =", value, "goodsOffShelf");
            return (Criteria) this;
        }

        public Criteria andGoodsOffShelfNotEqualTo(Date value) {
            addCriterion("goods_off_shelf <>", value, "goodsOffShelf");
            return (Criteria) this;
        }

        public Criteria andGoodsOffShelfGreaterThan(Date value) {
            addCriterion("goods_off_shelf >", value, "goodsOffShelf");
            return (Criteria) this;
        }

        public Criteria andGoodsOffShelfGreaterThanOrEqualTo(Date value) {
            addCriterion("goods_off_shelf >=", value, "goodsOffShelf");
            return (Criteria) this;
        }

        public Criteria andGoodsOffShelfLessThan(Date value) {
            addCriterion("goods_off_shelf <", value, "goodsOffShelf");
            return (Criteria) this;
        }

        public Criteria andGoodsOffShelfLessThanOrEqualTo(Date value) {
            addCriterion("goods_off_shelf <=", value, "goodsOffShelf");
            return (Criteria) this;
        }

        public Criteria andGoodsOffShelfIn(List<Date> values) {
            addCriterion("goods_off_shelf in", values, "goodsOffShelf");
            return (Criteria) this;
        }

        public Criteria andGoodsOffShelfNotIn(List<Date> values) {
            addCriterion("goods_off_shelf not in", values, "goodsOffShelf");
            return (Criteria) this;
        }

        public Criteria andGoodsOffShelfBetween(Date value1, Date value2) {
            addCriterion("goods_off_shelf between", value1, value2, "goodsOffShelf");
            return (Criteria) this;
        }

        public Criteria andGoodsOffShelfNotBetween(Date value1, Date value2) {
            addCriterion("goods_off_shelf not between", value1, value2, "goodsOffShelf");
            return (Criteria) this;
        }

        public Criteria andFreeDeliveryIsNull() {
            addCriterion("free_delivery is null");
            return (Criteria) this;
        }

        public Criteria andFreeDeliveryIsNotNull() {
            addCriterion("free_delivery is not null");
            return (Criteria) this;
        }

        public Criteria andFreeDeliveryEqualTo(Integer value) {
            addCriterion("free_delivery =", value, "freeDelivery");
            return (Criteria) this;
        }

        public Criteria andFreeDeliveryNotEqualTo(Integer value) {
            addCriterion("free_delivery <>", value, "freeDelivery");
            return (Criteria) this;
        }

        public Criteria andFreeDeliveryGreaterThan(Integer value) {
            addCriterion("free_delivery >", value, "freeDelivery");
            return (Criteria) this;
        }

        public Criteria andFreeDeliveryGreaterThanOrEqualTo(Integer value) {
            addCriterion("free_delivery >=", value, "freeDelivery");
            return (Criteria) this;
        }

        public Criteria andFreeDeliveryLessThan(Integer value) {
            addCriterion("free_delivery <", value, "freeDelivery");
            return (Criteria) this;
        }

        public Criteria andFreeDeliveryLessThanOrEqualTo(Integer value) {
            addCriterion("free_delivery <=", value, "freeDelivery");
            return (Criteria) this;
        }

        public Criteria andFreeDeliveryIn(List<Integer> values) {
            addCriterion("free_delivery in", values, "freeDelivery");
            return (Criteria) this;
        }

        public Criteria andFreeDeliveryNotIn(List<Integer> values) {
            addCriterion("free_delivery not in", values, "freeDelivery");
            return (Criteria) this;
        }

        public Criteria andFreeDeliveryBetween(Integer value1, Integer value2) {
            addCriterion("free_delivery between", value1, value2, "freeDelivery");
            return (Criteria) this;
        }

        public Criteria andFreeDeliveryNotBetween(Integer value1, Integer value2) {
            addCriterion("free_delivery not between", value1, value2, "freeDelivery");
            return (Criteria) this;
        }

        public Criteria andCateNameIsNull() {
            addCriterion("cate_name is null");
            return (Criteria) this;
        }

        public Criteria andCateNameIsNotNull() {
            addCriterion("cate_name is not null");
            return (Criteria) this;
        }

        public Criteria andCateNameEqualTo(String value) {
            addCriterion("cate_name =", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameNotEqualTo(String value) {
            addCriterion("cate_name <>", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameGreaterThan(String value) {
            addCriterion("cate_name >", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameGreaterThanOrEqualTo(String value) {
            addCriterion("cate_name >=", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameLessThan(String value) {
            addCriterion("cate_name <", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameLessThanOrEqualTo(String value) {
            addCriterion("cate_name <=", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameLike(String value) {
            addCriterion("cate_name like", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameNotLike(String value) {
            addCriterion("cate_name not like", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameIn(List<String> values) {
            addCriterion("cate_name in", values, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameNotIn(List<String> values) {
            addCriterion("cate_name not in", values, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameBetween(String value1, String value2) {
            addCriterion("cate_name between", value1, value2, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameNotBetween(String value1, String value2) {
            addCriterion("cate_name not between", value1, value2, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateIdIsNull() {
            addCriterion("cate_id is null");
            return (Criteria) this;
        }

        public Criteria andCateIdIsNotNull() {
            addCriterion("cate_id is not null");
            return (Criteria) this;
        }

        public Criteria andCateIdEqualTo(Long value) {
            addCriterion("cate_id =", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdNotEqualTo(Long value) {
            addCriterion("cate_id <>", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdGreaterThan(Long value) {
            addCriterion("cate_id >", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cate_id >=", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdLessThan(Long value) {
            addCriterion("cate_id <", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdLessThanOrEqualTo(Long value) {
            addCriterion("cate_id <=", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdIn(List<Long> values) {
            addCriterion("cate_id in", values, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdNotIn(List<Long> values) {
            addCriterion("cate_id not in", values, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdBetween(Long value1, Long value2) {
            addCriterion("cate_id between", value1, value2, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdNotBetween(Long value1, Long value2) {
            addCriterion("cate_id not between", value1, value2, "cateId");
            return (Criteria) this;
        }

        public Criteria andCate2NameIsNull() {
            addCriterion("cate2_name is null");
            return (Criteria) this;
        }

        public Criteria andCate2NameIsNotNull() {
            addCriterion("cate2_name is not null");
            return (Criteria) this;
        }

        public Criteria andCate2NameEqualTo(String value) {
            addCriterion("cate2_name =", value, "cate2Name");
            return (Criteria) this;
        }

        public Criteria andCate2NameNotEqualTo(String value) {
            addCriterion("cate2_name <>", value, "cate2Name");
            return (Criteria) this;
        }

        public Criteria andCate2NameGreaterThan(String value) {
            addCriterion("cate2_name >", value, "cate2Name");
            return (Criteria) this;
        }

        public Criteria andCate2NameGreaterThanOrEqualTo(String value) {
            addCriterion("cate2_name >=", value, "cate2Name");
            return (Criteria) this;
        }

        public Criteria andCate2NameLessThan(String value) {
            addCriterion("cate2_name <", value, "cate2Name");
            return (Criteria) this;
        }

        public Criteria andCate2NameLessThanOrEqualTo(String value) {
            addCriterion("cate2_name <=", value, "cate2Name");
            return (Criteria) this;
        }

        public Criteria andCate2NameLike(String value) {
            addCriterion("cate2_name like", value, "cate2Name");
            return (Criteria) this;
        }

        public Criteria andCate2NameNotLike(String value) {
            addCriterion("cate2_name not like", value, "cate2Name");
            return (Criteria) this;
        }

        public Criteria andCate2NameIn(List<String> values) {
            addCriterion("cate2_name in", values, "cate2Name");
            return (Criteria) this;
        }

        public Criteria andCate2NameNotIn(List<String> values) {
            addCriterion("cate2_name not in", values, "cate2Name");
            return (Criteria) this;
        }

        public Criteria andCate2NameBetween(String value1, String value2) {
            addCriterion("cate2_name between", value1, value2, "cate2Name");
            return (Criteria) this;
        }

        public Criteria andCate2NameNotBetween(String value1, String value2) {
            addCriterion("cate2_name not between", value1, value2, "cate2Name");
            return (Criteria) this;
        }

        public Criteria andCate2IdIsNull() {
            addCriterion("cate2_id is null");
            return (Criteria) this;
        }

        public Criteria andCate2IdIsNotNull() {
            addCriterion("cate2_id is not null");
            return (Criteria) this;
        }

        public Criteria andCate2IdEqualTo(Long value) {
            addCriterion("cate2_id =", value, "cate2Id");
            return (Criteria) this;
        }

        public Criteria andCate2IdNotEqualTo(Long value) {
            addCriterion("cate2_id <>", value, "cate2Id");
            return (Criteria) this;
        }

        public Criteria andCate2IdGreaterThan(Long value) {
            addCriterion("cate2_id >", value, "cate2Id");
            return (Criteria) this;
        }

        public Criteria andCate2IdGreaterThanOrEqualTo(Long value) {
            addCriterion("cate2_id >=", value, "cate2Id");
            return (Criteria) this;
        }

        public Criteria andCate2IdLessThan(Long value) {
            addCriterion("cate2_id <", value, "cate2Id");
            return (Criteria) this;
        }

        public Criteria andCate2IdLessThanOrEqualTo(Long value) {
            addCriterion("cate2_id <=", value, "cate2Id");
            return (Criteria) this;
        }

        public Criteria andCate2IdIn(List<Long> values) {
            addCriterion("cate2_id in", values, "cate2Id");
            return (Criteria) this;
        }

        public Criteria andCate2IdNotIn(List<Long> values) {
            addCriterion("cate2_id not in", values, "cate2Id");
            return (Criteria) this;
        }

        public Criteria andCate2IdBetween(Long value1, Long value2) {
            addCriterion("cate2_id between", value1, value2, "cate2Id");
            return (Criteria) this;
        }

        public Criteria andCate2IdNotBetween(Long value1, Long value2) {
            addCriterion("cate2_id not between", value1, value2, "cate2Id");
            return (Criteria) this;
        }

        public Criteria andCate3NameIsNull() {
            addCriterion("cate3_name is null");
            return (Criteria) this;
        }

        public Criteria andCate3NameIsNotNull() {
            addCriterion("cate3_name is not null");
            return (Criteria) this;
        }

        public Criteria andCate3NameEqualTo(String value) {
            addCriterion("cate3_name =", value, "cate3Name");
            return (Criteria) this;
        }

        public Criteria andCate3NameNotEqualTo(String value) {
            addCriterion("cate3_name <>", value, "cate3Name");
            return (Criteria) this;
        }

        public Criteria andCate3NameGreaterThan(String value) {
            addCriterion("cate3_name >", value, "cate3Name");
            return (Criteria) this;
        }

        public Criteria andCate3NameGreaterThanOrEqualTo(String value) {
            addCriterion("cate3_name >=", value, "cate3Name");
            return (Criteria) this;
        }

        public Criteria andCate3NameLessThan(String value) {
            addCriterion("cate3_name <", value, "cate3Name");
            return (Criteria) this;
        }

        public Criteria andCate3NameLessThanOrEqualTo(String value) {
            addCriterion("cate3_name <=", value, "cate3Name");
            return (Criteria) this;
        }

        public Criteria andCate3NameLike(String value) {
            addCriterion("cate3_name like", value, "cate3Name");
            return (Criteria) this;
        }

        public Criteria andCate3NameNotLike(String value) {
            addCriterion("cate3_name not like", value, "cate3Name");
            return (Criteria) this;
        }

        public Criteria andCate3NameIn(List<String> values) {
            addCriterion("cate3_name in", values, "cate3Name");
            return (Criteria) this;
        }

        public Criteria andCate3NameNotIn(List<String> values) {
            addCriterion("cate3_name not in", values, "cate3Name");
            return (Criteria) this;
        }

        public Criteria andCate3NameBetween(String value1, String value2) {
            addCriterion("cate3_name between", value1, value2, "cate3Name");
            return (Criteria) this;
        }

        public Criteria andCate3NameNotBetween(String value1, String value2) {
            addCriterion("cate3_name not between", value1, value2, "cate3Name");
            return (Criteria) this;
        }

        public Criteria andCate3IdIsNull() {
            addCriterion("cate3_id is null");
            return (Criteria) this;
        }

        public Criteria andCate3IdIsNotNull() {
            addCriterion("cate3_id is not null");
            return (Criteria) this;
        }

        public Criteria andCate3IdEqualTo(Long value) {
            addCriterion("cate3_id =", value, "cate3Id");
            return (Criteria) this;
        }

        public Criteria andCate3IdNotEqualTo(Long value) {
            addCriterion("cate3_id <>", value, "cate3Id");
            return (Criteria) this;
        }

        public Criteria andCate3IdGreaterThan(Long value) {
            addCriterion("cate3_id >", value, "cate3Id");
            return (Criteria) this;
        }

        public Criteria andCate3IdGreaterThanOrEqualTo(Long value) {
            addCriterion("cate3_id >=", value, "cate3Id");
            return (Criteria) this;
        }

        public Criteria andCate3IdLessThan(Long value) {
            addCriterion("cate3_id <", value, "cate3Id");
            return (Criteria) this;
        }

        public Criteria andCate3IdLessThanOrEqualTo(Long value) {
            addCriterion("cate3_id <=", value, "cate3Id");
            return (Criteria) this;
        }

        public Criteria andCate3IdIn(List<Long> values) {
            addCriterion("cate3_id in", values, "cate3Id");
            return (Criteria) this;
        }

        public Criteria andCate3IdNotIn(List<Long> values) {
            addCriterion("cate3_id not in", values, "cate3Id");
            return (Criteria) this;
        }

        public Criteria andCate3IdBetween(Long value1, Long value2) {
            addCriterion("cate3_id between", value1, value2, "cate3Id");
            return (Criteria) this;
        }

        public Criteria andCate3IdNotBetween(Long value1, Long value2) {
            addCriterion("cate3_id not between", value1, value2, "cate3Id");
            return (Criteria) this;
        }

        public Criteria andIsTuangouIsNull() {
            addCriterion("is_tuangou is null");
            return (Criteria) this;
        }

        public Criteria andIsTuangouIsNotNull() {
            addCriterion("is_tuangou is not null");
            return (Criteria) this;
        }

        public Criteria andIsTuangouEqualTo(Integer value) {
            addCriterion("is_tuangou =", value, "isTuangou");
            return (Criteria) this;
        }

        public Criteria andIsTuangouNotEqualTo(Integer value) {
            addCriterion("is_tuangou <>", value, "isTuangou");
            return (Criteria) this;
        }

        public Criteria andIsTuangouGreaterThan(Integer value) {
            addCriterion("is_tuangou >", value, "isTuangou");
            return (Criteria) this;
        }

        public Criteria andIsTuangouGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_tuangou >=", value, "isTuangou");
            return (Criteria) this;
        }

        public Criteria andIsTuangouLessThan(Integer value) {
            addCriterion("is_tuangou <", value, "isTuangou");
            return (Criteria) this;
        }

        public Criteria andIsTuangouLessThanOrEqualTo(Integer value) {
            addCriterion("is_tuangou <=", value, "isTuangou");
            return (Criteria) this;
        }

        public Criteria andIsTuangouIn(List<Integer> values) {
            addCriterion("is_tuangou in", values, "isTuangou");
            return (Criteria) this;
        }

        public Criteria andIsTuangouNotIn(List<Integer> values) {
            addCriterion("is_tuangou not in", values, "isTuangou");
            return (Criteria) this;
        }

        public Criteria andIsTuangouBetween(Integer value1, Integer value2) {
            addCriterion("is_tuangou between", value1, value2, "isTuangou");
            return (Criteria) this;
        }

        public Criteria andIsTuangouNotBetween(Integer value1, Integer value2) {
            addCriterion("is_tuangou not between", value1, value2, "isTuangou");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNull() {
            addCriterion("is_show is null");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNotNull() {
            addCriterion("is_show is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowEqualTo(Integer value) {
            addCriterion("is_show =", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotEqualTo(Integer value) {
            addCriterion("is_show <>", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThan(Integer value) {
            addCriterion("is_show >", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_show >=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThan(Integer value) {
            addCriterion("is_show <", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThanOrEqualTo(Integer value) {
            addCriterion("is_show <=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowIn(List<Integer> values) {
            addCriterion("is_show in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotIn(List<Integer> values) {
            addCriterion("is_show not in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowBetween(Integer value1, Integer value2) {
            addCriterion("is_show between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotBetween(Integer value1, Integer value2) {
            addCriterion("is_show not between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andSalesIsNull() {
            addCriterion("sales is null");
            return (Criteria) this;
        }

        public Criteria andSalesIsNotNull() {
            addCriterion("sales is not null");
            return (Criteria) this;
        }

        public Criteria andSalesEqualTo(Long value) {
            addCriterion("sales =", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesNotEqualTo(Long value) {
            addCriterion("sales <>", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesGreaterThan(Long value) {
            addCriterion("sales >", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesGreaterThanOrEqualTo(Long value) {
            addCriterion("sales >=", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesLessThan(Long value) {
            addCriterion("sales <", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesLessThanOrEqualTo(Long value) {
            addCriterion("sales <=", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesIn(List<Long> values) {
            addCriterion("sales in", values, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesNotIn(List<Long> values) {
            addCriterion("sales not in", values, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesBetween(Long value1, Long value2) {
            addCriterion("sales between", value1, value2, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesNotBetween(Long value1, Long value2) {
            addCriterion("sales not between", value1, value2, "sales");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNull() {
            addCriterion("class_id is null");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNotNull() {
            addCriterion("class_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassIdEqualTo(Long value) {
            addCriterion("class_id =", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotEqualTo(Long value) {
            addCriterion("class_id <>", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThan(Long value) {
            addCriterion("class_id >", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThanOrEqualTo(Long value) {
            addCriterion("class_id >=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThan(Long value) {
            addCriterion("class_id <", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThanOrEqualTo(Long value) {
            addCriterion("class_id <=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdIn(List<Long> values) {
            addCriterion("class_id in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotIn(List<Long> values) {
            addCriterion("class_id not in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdBetween(Long value1, Long value2) {
            addCriterion("class_id between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotBetween(Long value1, Long value2) {
            addCriterion("class_id not between", value1, value2, "classId");
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