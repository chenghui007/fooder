package com.food.entity;

import java.util.ArrayList;
import java.util.List;

public class TblDishesInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public TblDishesInfoExample() {
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

        public Criteria andDishierNameIsNull() {
            addCriterion("dishier_name is null");
            return (Criteria) this;
        }

        public Criteria andDishierNameIsNotNull() {
            addCriterion("dishier_name is not null");
            return (Criteria) this;
        }

        public Criteria andDishierNameEqualTo(String value) {
            addCriterion("dishier_name =", value, "dishierName");
            return (Criteria) this;
        }

        public Criteria andDishierNameNotEqualTo(String value) {
            addCriterion("dishier_name <>", value, "dishierName");
            return (Criteria) this;
        }

        public Criteria andDishierNameGreaterThan(String value) {
            addCriterion("dishier_name >", value, "dishierName");
            return (Criteria) this;
        }

        public Criteria andDishierNameGreaterThanOrEqualTo(String value) {
            addCriterion("dishier_name >=", value, "dishierName");
            return (Criteria) this;
        }

        public Criteria andDishierNameLessThan(String value) {
            addCriterion("dishier_name <", value, "dishierName");
            return (Criteria) this;
        }

        public Criteria andDishierNameLessThanOrEqualTo(String value) {
            addCriterion("dishier_name <=", value, "dishierName");
            return (Criteria) this;
        }

        public Criteria andDishierNameLike(String value) {
            addCriterion("dishier_name like", value, "dishierName");
            return (Criteria) this;
        }

        public Criteria andDishierNameNotLike(String value) {
            addCriterion("dishier_name not like", value, "dishierName");
            return (Criteria) this;
        }

        public Criteria andDishierNameIn(List<String> values) {
            addCriterion("dishier_name in", values, "dishierName");
            return (Criteria) this;
        }

        public Criteria andDishierNameNotIn(List<String> values) {
            addCriterion("dishier_name not in", values, "dishierName");
            return (Criteria) this;
        }

        public Criteria andDishierNameBetween(String value1, String value2) {
            addCriterion("dishier_name between", value1, value2, "dishierName");
            return (Criteria) this;
        }

        public Criteria andDishierNameNotBetween(String value1, String value2) {
            addCriterion("dishier_name not between", value1, value2, "dishierName");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Integer value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Integer value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Integer value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Integer value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Integer value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Integer> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Integer> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Integer value1, Integer value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andMakeTimeIsNull() {
            addCriterion("make_time is null");
            return (Criteria) this;
        }

        public Criteria andMakeTimeIsNotNull() {
            addCriterion("make_time is not null");
            return (Criteria) this;
        }

        public Criteria andMakeTimeEqualTo(Integer value) {
            addCriterion("make_time =", value, "makeTime");
            return (Criteria) this;
        }

        public Criteria andMakeTimeNotEqualTo(Integer value) {
            addCriterion("make_time <>", value, "makeTime");
            return (Criteria) this;
        }

        public Criteria andMakeTimeGreaterThan(Integer value) {
            addCriterion("make_time >", value, "makeTime");
            return (Criteria) this;
        }

        public Criteria andMakeTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("make_time >=", value, "makeTime");
            return (Criteria) this;
        }

        public Criteria andMakeTimeLessThan(Integer value) {
            addCriterion("make_time <", value, "makeTime");
            return (Criteria) this;
        }

        public Criteria andMakeTimeLessThanOrEqualTo(Integer value) {
            addCriterion("make_time <=", value, "makeTime");
            return (Criteria) this;
        }

        public Criteria andMakeTimeIn(List<Integer> values) {
            addCriterion("make_time in", values, "makeTime");
            return (Criteria) this;
        }

        public Criteria andMakeTimeNotIn(List<Integer> values) {
            addCriterion("make_time not in", values, "makeTime");
            return (Criteria) this;
        }

        public Criteria andMakeTimeBetween(Integer value1, Integer value2) {
            addCriterion("make_time between", value1, value2, "makeTime");
            return (Criteria) this;
        }

        public Criteria andMakeTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("make_time not between", value1, value2, "makeTime");
            return (Criteria) this;
        }

        public Criteria andDisherImageIsNull() {
            addCriterion("disher_image is null");
            return (Criteria) this;
        }

        public Criteria andDisherImageIsNotNull() {
            addCriterion("disher_image is not null");
            return (Criteria) this;
        }

        public Criteria andDisherImageEqualTo(String value) {
            addCriterion("disher_image =", value, "disherImage");
            return (Criteria) this;
        }

        public Criteria andDisherImageNotEqualTo(String value) {
            addCriterion("disher_image <>", value, "disherImage");
            return (Criteria) this;
        }

        public Criteria andDisherImageGreaterThan(String value) {
            addCriterion("disher_image >", value, "disherImage");
            return (Criteria) this;
        }

        public Criteria andDisherImageGreaterThanOrEqualTo(String value) {
            addCriterion("disher_image >=", value, "disherImage");
            return (Criteria) this;
        }

        public Criteria andDisherImageLessThan(String value) {
            addCriterion("disher_image <", value, "disherImage");
            return (Criteria) this;
        }

        public Criteria andDisherImageLessThanOrEqualTo(String value) {
            addCriterion("disher_image <=", value, "disherImage");
            return (Criteria) this;
        }

        public Criteria andDisherImageLike(String value) {
            addCriterion("disher_image like", value, "disherImage");
            return (Criteria) this;
        }

        public Criteria andDisherImageNotLike(String value) {
            addCriterion("disher_image not like", value, "disherImage");
            return (Criteria) this;
        }

        public Criteria andDisherImageIn(List<String> values) {
            addCriterion("disher_image in", values, "disherImage");
            return (Criteria) this;
        }

        public Criteria andDisherImageNotIn(List<String> values) {
            addCriterion("disher_image not in", values, "disherImage");
            return (Criteria) this;
        }

        public Criteria andDisherImageBetween(String value1, String value2) {
            addCriterion("disher_image between", value1, value2, "disherImage");
            return (Criteria) this;
        }

        public Criteria andDisherImageNotBetween(String value1, String value2) {
            addCriterion("disher_image not between", value1, value2, "disherImage");
            return (Criteria) this;
        }

        public Criteria andDisherDescIsNull() {
            addCriterion("disher_desc is null");
            return (Criteria) this;
        }

        public Criteria andDisherDescIsNotNull() {
            addCriterion("disher_desc is not null");
            return (Criteria) this;
        }

        public Criteria andDisherDescEqualTo(String value) {
            addCriterion("disher_desc =", value, "disherDesc");
            return (Criteria) this;
        }

        public Criteria andDisherDescNotEqualTo(String value) {
            addCriterion("disher_desc <>", value, "disherDesc");
            return (Criteria) this;
        }

        public Criteria andDisherDescGreaterThan(String value) {
            addCriterion("disher_desc >", value, "disherDesc");
            return (Criteria) this;
        }

        public Criteria andDisherDescGreaterThanOrEqualTo(String value) {
            addCriterion("disher_desc >=", value, "disherDesc");
            return (Criteria) this;
        }

        public Criteria andDisherDescLessThan(String value) {
            addCriterion("disher_desc <", value, "disherDesc");
            return (Criteria) this;
        }

        public Criteria andDisherDescLessThanOrEqualTo(String value) {
            addCriterion("disher_desc <=", value, "disherDesc");
            return (Criteria) this;
        }

        public Criteria andDisherDescLike(String value) {
            addCriterion("disher_desc like", value, "disherDesc");
            return (Criteria) this;
        }

        public Criteria andDisherDescNotLike(String value) {
            addCriterion("disher_desc not like", value, "disherDesc");
            return (Criteria) this;
        }

        public Criteria andDisherDescIn(List<String> values) {
            addCriterion("disher_desc in", values, "disherDesc");
            return (Criteria) this;
        }

        public Criteria andDisherDescNotIn(List<String> values) {
            addCriterion("disher_desc not in", values, "disherDesc");
            return (Criteria) this;
        }

        public Criteria andDisherDescBetween(String value1, String value2) {
            addCriterion("disher_desc between", value1, value2, "disherDesc");
            return (Criteria) this;
        }

        public Criteria andDisherDescNotBetween(String value1, String value2) {
            addCriterion("disher_desc not between", value1, value2, "disherDesc");
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