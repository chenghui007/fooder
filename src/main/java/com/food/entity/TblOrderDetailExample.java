package com.food.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblOrderDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public TblOrderDetailExample() {
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

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDisherNameIsNull() {
            addCriterion("disher_name is null");
            return (Criteria) this;
        }

        public Criteria andDisherNameIsNotNull() {
            addCriterion("disher_name is not null");
            return (Criteria) this;
        }

        public Criteria andDisherNameEqualTo(String value) {
            addCriterion("disher_name =", value, "disherName");
            return (Criteria) this;
        }

        public Criteria andDisherNameNotEqualTo(String value) {
            addCriterion("disher_name <>", value, "disherName");
            return (Criteria) this;
        }

        public Criteria andDisherNameGreaterThan(String value) {
            addCriterion("disher_name >", value, "disherName");
            return (Criteria) this;
        }

        public Criteria andDisherNameGreaterThanOrEqualTo(String value) {
            addCriterion("disher_name >=", value, "disherName");
            return (Criteria) this;
        }

        public Criteria andDisherNameLessThan(String value) {
            addCriterion("disher_name <", value, "disherName");
            return (Criteria) this;
        }

        public Criteria andDisherNameLessThanOrEqualTo(String value) {
            addCriterion("disher_name <=", value, "disherName");
            return (Criteria) this;
        }

        public Criteria andDisherNameLike(String value) {
            addCriterion("disher_name like", value, "disherName");
            return (Criteria) this;
        }

        public Criteria andDisherNameNotLike(String value) {
            addCriterion("disher_name not like", value, "disherName");
            return (Criteria) this;
        }

        public Criteria andDisherNameIn(List<String> values) {
            addCriterion("disher_name in", values, "disherName");
            return (Criteria) this;
        }

        public Criteria andDisherNameNotIn(List<String> values) {
            addCriterion("disher_name not in", values, "disherName");
            return (Criteria) this;
        }

        public Criteria andDisherNameBetween(String value1, String value2) {
            addCriterion("disher_name between", value1, value2, "disherName");
            return (Criteria) this;
        }

        public Criteria andDisherNameNotBetween(String value1, String value2) {
            addCriterion("disher_name not between", value1, value2, "disherName");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(String value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(String value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(String value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(String value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(String value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLike(String value) {
            addCriterion("money like", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotLike(String value) {
            addCriterion("money not like", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<String> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<String> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(String value1, String value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(String value1, String value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(String value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(String value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(String value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(String value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(String value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(String value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLike(String value) {
            addCriterion("number like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotLike(String value) {
            addCriterion("number not like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<String> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<String> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(String value1, String value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(String value1, String value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNull() {
            addCriterion("total_money is null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNotNull() {
            addCriterion("total_money is not null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyEqualTo(String value) {
            addCriterion("total_money =", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotEqualTo(String value) {
            addCriterion("total_money <>", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThan(String value) {
            addCriterion("total_money >", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("total_money >=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThan(String value) {
            addCriterion("total_money <", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThanOrEqualTo(String value) {
            addCriterion("total_money <=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLike(String value) {
            addCriterion("total_money like", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotLike(String value) {
            addCriterion("total_money not like", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIn(List<String> values) {
            addCriterion("total_money in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotIn(List<String> values) {
            addCriterion("total_money not in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyBetween(String value1, String value2) {
            addCriterion("total_money between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotBetween(String value1, String value2) {
            addCriterion("total_money not between", value1, value2, "totalMoney");
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

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andDisherIdIsNull() {
            addCriterion("disher_id is null");
            return (Criteria) this;
        }

        public Criteria andDisherIdIsNotNull() {
            addCriterion("disher_id is not null");
            return (Criteria) this;
        }

        public Criteria andDisherIdEqualTo(Integer value) {
            addCriterion("disher_id =", value, "disherId");
            return (Criteria) this;
        }

        public Criteria andDisherIdNotEqualTo(Integer value) {
            addCriterion("disher_id <>", value, "disherId");
            return (Criteria) this;
        }

        public Criteria andDisherIdGreaterThan(Integer value) {
            addCriterion("disher_id >", value, "disherId");
            return (Criteria) this;
        }

        public Criteria andDisherIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("disher_id >=", value, "disherId");
            return (Criteria) this;
        }

        public Criteria andDisherIdLessThan(Integer value) {
            addCriterion("disher_id <", value, "disherId");
            return (Criteria) this;
        }

        public Criteria andDisherIdLessThanOrEqualTo(Integer value) {
            addCriterion("disher_id <=", value, "disherId");
            return (Criteria) this;
        }

        public Criteria andDisherIdIn(List<Integer> values) {
            addCriterion("disher_id in", values, "disherId");
            return (Criteria) this;
        }

        public Criteria andDisherIdNotIn(List<Integer> values) {
            addCriterion("disher_id not in", values, "disherId");
            return (Criteria) this;
        }

        public Criteria andDisherIdBetween(Integer value1, Integer value2) {
            addCriterion("disher_id between", value1, value2, "disherId");
            return (Criteria) this;
        }

        public Criteria andDisherIdNotBetween(Integer value1, Integer value2) {
            addCriterion("disher_id not between", value1, value2, "disherId");
            return (Criteria) this;
        }

        public Criteria andDisherTypeIsNull() {
            addCriterion("disher_type is null");
            return (Criteria) this;
        }

        public Criteria andDisherTypeIsNotNull() {
            addCriterion("disher_type is not null");
            return (Criteria) this;
        }

        public Criteria andDisherTypeEqualTo(String value) {
            addCriterion("disher_type =", value, "disherType");
            return (Criteria) this;
        }

        public Criteria andDisherTypeNotEqualTo(String value) {
            addCriterion("disher_type <>", value, "disherType");
            return (Criteria) this;
        }

        public Criteria andDisherTypeGreaterThan(String value) {
            addCriterion("disher_type >", value, "disherType");
            return (Criteria) this;
        }

        public Criteria andDisherTypeGreaterThanOrEqualTo(String value) {
            addCriterion("disher_type >=", value, "disherType");
            return (Criteria) this;
        }

        public Criteria andDisherTypeLessThan(String value) {
            addCriterion("disher_type <", value, "disherType");
            return (Criteria) this;
        }

        public Criteria andDisherTypeLessThanOrEqualTo(String value) {
            addCriterion("disher_type <=", value, "disherType");
            return (Criteria) this;
        }

        public Criteria andDisherTypeLike(String value) {
            addCriterion("disher_type like", value, "disherType");
            return (Criteria) this;
        }

        public Criteria andDisherTypeNotLike(String value) {
            addCriterion("disher_type not like", value, "disherType");
            return (Criteria) this;
        }

        public Criteria andDisherTypeIn(List<String> values) {
            addCriterion("disher_type in", values, "disherType");
            return (Criteria) this;
        }

        public Criteria andDisherTypeNotIn(List<String> values) {
            addCriterion("disher_type not in", values, "disherType");
            return (Criteria) this;
        }

        public Criteria andDisherTypeBetween(String value1, String value2) {
            addCriterion("disher_type between", value1, value2, "disherType");
            return (Criteria) this;
        }

        public Criteria andDisherTypeNotBetween(String value1, String value2) {
            addCriterion("disher_type not between", value1, value2, "disherType");
            return (Criteria) this;
        }

        public Criteria andDisherTypeNameIsNull() {
            addCriterion("disher_type_name is null");
            return (Criteria) this;
        }

        public Criteria andDisherTypeNameIsNotNull() {
            addCriterion("disher_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andDisherTypeNameEqualTo(String value) {
            addCriterion("disher_type_name =", value, "disherTypeName");
            return (Criteria) this;
        }

        public Criteria andDisherTypeNameNotEqualTo(String value) {
            addCriterion("disher_type_name <>", value, "disherTypeName");
            return (Criteria) this;
        }

        public Criteria andDisherTypeNameGreaterThan(String value) {
            addCriterion("disher_type_name >", value, "disherTypeName");
            return (Criteria) this;
        }

        public Criteria andDisherTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("disher_type_name >=", value, "disherTypeName");
            return (Criteria) this;
        }

        public Criteria andDisherTypeNameLessThan(String value) {
            addCriterion("disher_type_name <", value, "disherTypeName");
            return (Criteria) this;
        }

        public Criteria andDisherTypeNameLessThanOrEqualTo(String value) {
            addCriterion("disher_type_name <=", value, "disherTypeName");
            return (Criteria) this;
        }

        public Criteria andDisherTypeNameLike(String value) {
            addCriterion("disher_type_name like", value, "disherTypeName");
            return (Criteria) this;
        }

        public Criteria andDisherTypeNameNotLike(String value) {
            addCriterion("disher_type_name not like", value, "disherTypeName");
            return (Criteria) this;
        }

        public Criteria andDisherTypeNameIn(List<String> values) {
            addCriterion("disher_type_name in", values, "disherTypeName");
            return (Criteria) this;
        }

        public Criteria andDisherTypeNameNotIn(List<String> values) {
            addCriterion("disher_type_name not in", values, "disherTypeName");
            return (Criteria) this;
        }

        public Criteria andDisherTypeNameBetween(String value1, String value2) {
            addCriterion("disher_type_name between", value1, value2, "disherTypeName");
            return (Criteria) this;
        }

        public Criteria andDisherTypeNameNotBetween(String value1, String value2) {
            addCriterion("disher_type_name not between", value1, value2, "disherTypeName");
            return (Criteria) this;
        }

        public Criteria andCustomCriteria(String value) {
            addCriterion( "("+ value +")" );
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