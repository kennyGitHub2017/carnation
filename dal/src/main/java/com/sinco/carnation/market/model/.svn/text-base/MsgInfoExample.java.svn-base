package com.sinco.carnation.market.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MsgInfoExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public MsgInfoExample() {
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

		public Criteria andTitleIsNull() {
			addCriterion("title is null");
			return (Criteria) this;
		}

		public Criteria andTitleIsNotNull() {
			addCriterion("title is not null");
			return (Criteria) this;
		}

		public Criteria andTitleEqualTo(String value) {
			addCriterion("title =", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotEqualTo(String value) {
			addCriterion("title <>", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThan(String value) {
			addCriterion("title >", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThanOrEqualTo(String value) {
			addCriterion("title >=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThan(String value) {
			addCriterion("title <", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThanOrEqualTo(String value) {
			addCriterion("title <=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLike(String value) {
			addCriterion("title like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotLike(String value) {
			addCriterion("title not like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleIn(List<String> values) {
			addCriterion("title in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotIn(List<String> values) {
			addCriterion("title not in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleBetween(String value1, String value2) {
			addCriterion("title between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotBetween(String value1, String value2) {
			addCriterion("title not between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andNoticeTitleIsNull() {
			addCriterion("notice_title is null");
			return (Criteria) this;
		}

		public Criteria andNoticeTitleIsNotNull() {
			addCriterion("notice_title is not null");
			return (Criteria) this;
		}

		public Criteria andNoticeTitleEqualTo(String value) {
			addCriterion("notice_title =", value, "noticeTitle");
			return (Criteria) this;
		}

		public Criteria andNoticeTitleNotEqualTo(String value) {
			addCriterion("notice_title <>", value, "noticeTitle");
			return (Criteria) this;
		}

		public Criteria andNoticeTitleGreaterThan(String value) {
			addCriterion("notice_title >", value, "noticeTitle");
			return (Criteria) this;
		}

		public Criteria andNoticeTitleGreaterThanOrEqualTo(String value) {
			addCriterion("notice_title >=", value, "noticeTitle");
			return (Criteria) this;
		}

		public Criteria andNoticeTitleLessThan(String value) {
			addCriterion("notice_title <", value, "noticeTitle");
			return (Criteria) this;
		}

		public Criteria andNoticeTitleLessThanOrEqualTo(String value) {
			addCriterion("notice_title <=", value, "noticeTitle");
			return (Criteria) this;
		}

		public Criteria andNoticeTitleLike(String value) {
			addCriterion("notice_title like", value, "noticeTitle");
			return (Criteria) this;
		}

		public Criteria andNoticeTitleNotLike(String value) {
			addCriterion("notice_title not like", value, "noticeTitle");
			return (Criteria) this;
		}

		public Criteria andNoticeTitleIn(List<String> values) {
			addCriterion("notice_title in", values, "noticeTitle");
			return (Criteria) this;
		}

		public Criteria andNoticeTitleNotIn(List<String> values) {
			addCriterion("notice_title not in", values, "noticeTitle");
			return (Criteria) this;
		}

		public Criteria andNoticeTitleBetween(String value1, String value2) {
			addCriterion("notice_title between", value1, value2, "noticeTitle");
			return (Criteria) this;
		}

		public Criteria andNoticeTitleNotBetween(String value1, String value2) {
			addCriterion("notice_title not between", value1, value2, "noticeTitle");
			return (Criteria) this;
		}

		public Criteria andReceiveTypeIsNull() {
			addCriterion("receive_type is null");
			return (Criteria) this;
		}

		public Criteria andReceiveTypeIsNotNull() {
			addCriterion("receive_type is not null");
			return (Criteria) this;
		}

		public Criteria andReceiveTypeEqualTo(Byte value) {
			addCriterion("receive_type =", value, "receiveType");
			return (Criteria) this;
		}

		public Criteria andReceiveTypeNotEqualTo(Byte value) {
			addCriterion("receive_type <>", value, "receiveType");
			return (Criteria) this;
		}

		public Criteria andReceiveTypeGreaterThan(Byte value) {
			addCriterion("receive_type >", value, "receiveType");
			return (Criteria) this;
		}

		public Criteria andReceiveTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("receive_type >=", value, "receiveType");
			return (Criteria) this;
		}

		public Criteria andReceiveTypeLessThan(Byte value) {
			addCriterion("receive_type <", value, "receiveType");
			return (Criteria) this;
		}

		public Criteria andReceiveTypeLessThanOrEqualTo(Byte value) {
			addCriterion("receive_type <=", value, "receiveType");
			return (Criteria) this;
		}

		public Criteria andReceiveTypeIn(List<Byte> values) {
			addCriterion("receive_type in", values, "receiveType");
			return (Criteria) this;
		}

		public Criteria andReceiveTypeNotIn(List<Byte> values) {
			addCriterion("receive_type not in", values, "receiveType");
			return (Criteria) this;
		}

		public Criteria andReceiveTypeBetween(Byte value1, Byte value2) {
			addCriterion("receive_type between", value1, value2, "receiveType");
			return (Criteria) this;
		}

		public Criteria andReceiveTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("receive_type not between", value1, value2, "receiveType");
			return (Criteria) this;
		}

		public Criteria andLinkUrlIsNull() {
			addCriterion("link_url is null");
			return (Criteria) this;
		}

		public Criteria andLinkUrlIsNotNull() {
			addCriterion("link_url is not null");
			return (Criteria) this;
		}

		public Criteria andLinkUrlEqualTo(String value) {
			addCriterion("link_url =", value, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlNotEqualTo(String value) {
			addCriterion("link_url <>", value, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlGreaterThan(String value) {
			addCriterion("link_url >", value, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlGreaterThanOrEqualTo(String value) {
			addCriterion("link_url >=", value, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlLessThan(String value) {
			addCriterion("link_url <", value, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlLessThanOrEqualTo(String value) {
			addCriterion("link_url <=", value, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlLike(String value) {
			addCriterion("link_url like", value, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlNotLike(String value) {
			addCriterion("link_url not like", value, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlIn(List<String> values) {
			addCriterion("link_url in", values, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlNotIn(List<String> values) {
			addCriterion("link_url not in", values, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlBetween(String value1, String value2) {
			addCriterion("link_url between", value1, value2, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlNotBetween(String value1, String value2) {
			addCriterion("link_url not between", value1, value2, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andReceiveLocationIsNull() {
			addCriterion("receive_location is null");
			return (Criteria) this;
		}

		public Criteria andReceiveLocationIsNotNull() {
			addCriterion("receive_location is not null");
			return (Criteria) this;
		}

		public Criteria andReceiveLocationEqualTo(Long value) {
			addCriterion("receive_location =", value, "receiveLocation");
			return (Criteria) this;
		}

		public Criteria andReceiveLocationNotEqualTo(Long value) {
			addCriterion("receive_location <>", value, "receiveLocation");
			return (Criteria) this;
		}

		public Criteria andReceiveLocationGreaterThan(Long value) {
			addCriterion("receive_location >", value, "receiveLocation");
			return (Criteria) this;
		}

		public Criteria andReceiveLocationGreaterThanOrEqualTo(Long value) {
			addCriterion("receive_location >=", value, "receiveLocation");
			return (Criteria) this;
		}

		public Criteria andReceiveLocationLessThan(Long value) {
			addCriterion("receive_location <", value, "receiveLocation");
			return (Criteria) this;
		}

		public Criteria andReceiveLocationLessThanOrEqualTo(Long value) {
			addCriterion("receive_location <=", value, "receiveLocation");
			return (Criteria) this;
		}

		public Criteria andReceiveLocationIn(List<Long> values) {
			addCriterion("receive_location in", values, "receiveLocation");
			return (Criteria) this;
		}

		public Criteria andReceiveLocationNotIn(List<Long> values) {
			addCriterion("receive_location not in", values, "receiveLocation");
			return (Criteria) this;
		}

		public Criteria andReceiveLocationBetween(Long value1, Long value2) {
			addCriterion("receive_location between", value1, value2, "receiveLocation");
			return (Criteria) this;
		}

		public Criteria andReceiveLocationNotBetween(Long value1, Long value2) {
			addCriterion("receive_location not between", value1, value2, "receiveLocation");
			return (Criteria) this;
		}

		public Criteria andPriorityIsNull() {
			addCriterion("priority is null");
			return (Criteria) this;
		}

		public Criteria andPriorityIsNotNull() {
			addCriterion("priority is not null");
			return (Criteria) this;
		}

		public Criteria andPriorityEqualTo(Integer value) {
			addCriterion("priority =", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityNotEqualTo(Integer value) {
			addCriterion("priority <>", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityGreaterThan(Integer value) {
			addCriterion("priority >", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityGreaterThanOrEqualTo(Integer value) {
			addCriterion("priority >=", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityLessThan(Integer value) {
			addCriterion("priority <", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityLessThanOrEqualTo(Integer value) {
			addCriterion("priority <=", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityIn(List<Integer> values) {
			addCriterion("priority in", values, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityNotIn(List<Integer> values) {
			addCriterion("priority not in", values, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityBetween(Integer value1, Integer value2) {
			addCriterion("priority between", value1, value2, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityNotBetween(Integer value1, Integer value2) {
			addCriterion("priority not between", value1, value2, "priority");
			return (Criteria) this;
		}

		public Criteria andTopIndexIsNull() {
			addCriterion("top_index is null");
			return (Criteria) this;
		}

		public Criteria andTopIndexIsNotNull() {
			addCriterion("top_index is not null");
			return (Criteria) this;
		}

		public Criteria andTopIndexEqualTo(Integer value) {
			addCriterion("top_index =", value, "topIndex");
			return (Criteria) this;
		}

		public Criteria andTopIndexNotEqualTo(Integer value) {
			addCriterion("top_index <>", value, "topIndex");
			return (Criteria) this;
		}

		public Criteria andTopIndexGreaterThan(Integer value) {
			addCriterion("top_index >", value, "topIndex");
			return (Criteria) this;
		}

		public Criteria andTopIndexGreaterThanOrEqualTo(Integer value) {
			addCriterion("top_index >=", value, "topIndex");
			return (Criteria) this;
		}

		public Criteria andTopIndexLessThan(Integer value) {
			addCriterion("top_index <", value, "topIndex");
			return (Criteria) this;
		}

		public Criteria andTopIndexLessThanOrEqualTo(Integer value) {
			addCriterion("top_index <=", value, "topIndex");
			return (Criteria) this;
		}

		public Criteria andTopIndexIn(List<Integer> values) {
			addCriterion("top_index in", values, "topIndex");
			return (Criteria) this;
		}

		public Criteria andTopIndexNotIn(List<Integer> values) {
			addCriterion("top_index not in", values, "topIndex");
			return (Criteria) this;
		}

		public Criteria andTopIndexBetween(Integer value1, Integer value2) {
			addCriterion("top_index between", value1, value2, "topIndex");
			return (Criteria) this;
		}

		public Criteria andTopIndexNotBetween(Integer value1, Integer value2) {
			addCriterion("top_index not between", value1, value2, "topIndex");
			return (Criteria) this;
		}

		public Criteria andSendCountIsNull() {
			addCriterion("send_count is null");
			return (Criteria) this;
		}

		public Criteria andSendCountIsNotNull() {
			addCriterion("send_count is not null");
			return (Criteria) this;
		}

		public Criteria andSendCountEqualTo(Byte value) {
			addCriterion("send_count =", value, "sendCount");
			return (Criteria) this;
		}

		public Criteria andSendCountNotEqualTo(Byte value) {
			addCriterion("send_count <>", value, "sendCount");
			return (Criteria) this;
		}

		public Criteria andSendCountGreaterThan(Byte value) {
			addCriterion("send_count >", value, "sendCount");
			return (Criteria) this;
		}

		public Criteria andSendCountGreaterThanOrEqualTo(Byte value) {
			addCriterion("send_count >=", value, "sendCount");
			return (Criteria) this;
		}

		public Criteria andSendCountLessThan(Byte value) {
			addCriterion("send_count <", value, "sendCount");
			return (Criteria) this;
		}

		public Criteria andSendCountLessThanOrEqualTo(Byte value) {
			addCriterion("send_count <=", value, "sendCount");
			return (Criteria) this;
		}

		public Criteria andSendCountIn(List<Byte> values) {
			addCriterion("send_count in", values, "sendCount");
			return (Criteria) this;
		}

		public Criteria andSendCountNotIn(List<Byte> values) {
			addCriterion("send_count not in", values, "sendCount");
			return (Criteria) this;
		}

		public Criteria andSendCountBetween(Byte value1, Byte value2) {
			addCriterion("send_count between", value1, value2, "sendCount");
			return (Criteria) this;
		}

		public Criteria andSendCountNotBetween(Byte value1, Byte value2) {
			addCriterion("send_count not between", value1, value2, "sendCount");
			return (Criteria) this;
		}

		public Criteria andSendStatusIsNull() {
			addCriterion("send_status is null");
			return (Criteria) this;
		}

		public Criteria andSendStatusIsNotNull() {
			addCriterion("send_status is not null");
			return (Criteria) this;
		}

		public Criteria andSendStatusEqualTo(Long value) {
			addCriterion("send_status =", value, "sendStatus");
			return (Criteria) this;
		}

		public Criteria andSendStatusNotEqualTo(Long value) {
			addCriterion("send_status <>", value, "sendStatus");
			return (Criteria) this;
		}

		public Criteria andSendStatusGreaterThan(Long value) {
			addCriterion("send_status >", value, "sendStatus");
			return (Criteria) this;
		}

		public Criteria andSendStatusGreaterThanOrEqualTo(Long value) {
			addCriterion("send_status >=", value, "sendStatus");
			return (Criteria) this;
		}

		public Criteria andSendStatusLessThan(Long value) {
			addCriterion("send_status <", value, "sendStatus");
			return (Criteria) this;
		}

		public Criteria andSendStatusLessThanOrEqualTo(Long value) {
			addCriterion("send_status <=", value, "sendStatus");
			return (Criteria) this;
		}

		public Criteria andSendStatusIn(List<Long> values) {
			addCriterion("send_status in", values, "sendStatus");
			return (Criteria) this;
		}

		public Criteria andSendStatusNotIn(List<Long> values) {
			addCriterion("send_status not in", values, "sendStatus");
			return (Criteria) this;
		}

		public Criteria andSendStatusBetween(Long value1, Long value2) {
			addCriterion("send_status between", value1, value2, "sendStatus");
			return (Criteria) this;
		}

		public Criteria andSendStatusNotBetween(Long value1, Long value2) {
			addCriterion("send_status not between", value1, value2, "sendStatus");
			return (Criteria) this;
		}

		public Criteria andSendTimeIsNull() {
			addCriterion("send_time is null");
			return (Criteria) this;
		}

		public Criteria andSendTimeIsNotNull() {
			addCriterion("send_time is not null");
			return (Criteria) this;
		}

		public Criteria andSendTimeEqualTo(Date value) {
			addCriterion("send_time =", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeNotEqualTo(Date value) {
			addCriterion("send_time <>", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeGreaterThan(Date value) {
			addCriterion("send_time >", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("send_time >=", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeLessThan(Date value) {
			addCriterion("send_time <", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeLessThanOrEqualTo(Date value) {
			addCriterion("send_time <=", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeIn(List<Date> values) {
			addCriterion("send_time in", values, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeNotIn(List<Date> values) {
			addCriterion("send_time not in", values, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeBetween(Date value1, Date value2) {
			addCriterion("send_time between", value1, value2, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeNotBetween(Date value1, Date value2) {
			addCriterion("send_time not between", value1, value2, "sendTime");
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