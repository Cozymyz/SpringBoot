package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class SigninExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SigninExample() {
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

        public Criteria andSigninidIsNull() {
            addCriterion("signinId is null");
            return (Criteria) this;
        }

        public Criteria andSigninidIsNotNull() {
            addCriterion("signinId is not null");
            return (Criteria) this;
        }

        public Criteria andSigninidEqualTo(Integer value) {
            addCriterion("signinId =", value, "signinid");
            return (Criteria) this;
        }

        public Criteria andSigninidNotEqualTo(Integer value) {
            addCriterion("signinId <>", value, "signinid");
            return (Criteria) this;
        }

        public Criteria andSigninidGreaterThan(Integer value) {
            addCriterion("signinId >", value, "signinid");
            return (Criteria) this;
        }

        public Criteria andSigninidGreaterThanOrEqualTo(Integer value) {
            addCriterion("signinId >=", value, "signinid");
            return (Criteria) this;
        }

        public Criteria andSigninidLessThan(Integer value) {
            addCriterion("signinId <", value, "signinid");
            return (Criteria) this;
        }

        public Criteria andSigninidLessThanOrEqualTo(Integer value) {
            addCriterion("signinId <=", value, "signinid");
            return (Criteria) this;
        }

        public Criteria andSigninidIn(List<Integer> values) {
            addCriterion("signinId in", values, "signinid");
            return (Criteria) this;
        }

        public Criteria andSigninidNotIn(List<Integer> values) {
            addCriterion("signinId not in", values, "signinid");
            return (Criteria) this;
        }

        public Criteria andSigninidBetween(Integer value1, Integer value2) {
            addCriterion("signinId between", value1, value2, "signinid");
            return (Criteria) this;
        }

        public Criteria andSigninidNotBetween(Integer value1, Integer value2) {
            addCriterion("signinId not between", value1, value2, "signinid");
            return (Criteria) this;
        }

        public Criteria andWorkidIsNull() {
            addCriterion("workId is null");
            return (Criteria) this;
        }

        public Criteria andWorkidIsNotNull() {
            addCriterion("workId is not null");
            return (Criteria) this;
        }

        public Criteria andWorkidEqualTo(Integer value) {
            addCriterion("workId =", value, "workid");
            return (Criteria) this;
        }

        public Criteria andWorkidNotEqualTo(Integer value) {
            addCriterion("workId <>", value, "workid");
            return (Criteria) this;
        }

        public Criteria andWorkidGreaterThan(Integer value) {
            addCriterion("workId >", value, "workid");
            return (Criteria) this;
        }

        public Criteria andWorkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("workId >=", value, "workid");
            return (Criteria) this;
        }

        public Criteria andWorkidLessThan(Integer value) {
            addCriterion("workId <", value, "workid");
            return (Criteria) this;
        }

        public Criteria andWorkidLessThanOrEqualTo(Integer value) {
            addCriterion("workId <=", value, "workid");
            return (Criteria) this;
        }

        public Criteria andWorkidIn(List<Integer> values) {
            addCriterion("workId in", values, "workid");
            return (Criteria) this;
        }

        public Criteria andWorkidNotIn(List<Integer> values) {
            addCriterion("workId not in", values, "workid");
            return (Criteria) this;
        }

        public Criteria andWorkidBetween(Integer value1, Integer value2) {
            addCriterion("workId between", value1, value2, "workid");
            return (Criteria) this;
        }

        public Criteria andWorkidNotBetween(Integer value1, Integer value2) {
            addCriterion("workId not between", value1, value2, "workid");
            return (Criteria) this;
        }

        public Criteria andDaytimeIsNull() {
            addCriterion("dayTime is null");
            return (Criteria) this;
        }

        public Criteria andDaytimeIsNotNull() {
            addCriterion("dayTime is not null");
            return (Criteria) this;
        }

        public Criteria andDaytimeEqualTo(String value) {
            addCriterion("dayTime =", value, "daytime");
            return (Criteria) this;
        }

        public Criteria andDaytimeNotEqualTo(String value) {
            addCriterion("dayTime <>", value, "daytime");
            return (Criteria) this;
        }

        public Criteria andDaytimeGreaterThan(String value) {
            addCriterion("dayTime >", value, "daytime");
            return (Criteria) this;
        }

        public Criteria andDaytimeGreaterThanOrEqualTo(String value) {
            addCriterion("dayTime >=", value, "daytime");
            return (Criteria) this;
        }

        public Criteria andDaytimeLessThan(String value) {
            addCriterion("dayTime <", value, "daytime");
            return (Criteria) this;
        }

        public Criteria andDaytimeLessThanOrEqualTo(String value) {
            addCriterion("dayTime <=", value, "daytime");
            return (Criteria) this;
        }

        public Criteria andDaytimeLike(String value) {
            addCriterion("dayTime like", value, "daytime");
            return (Criteria) this;
        }

        public Criteria andDaytimeNotLike(String value) {
            addCriterion("dayTime not like", value, "daytime");
            return (Criteria) this;
        }

        public Criteria andDaytimeIn(List<String> values) {
            addCriterion("dayTime in", values, "daytime");
            return (Criteria) this;
        }

        public Criteria andDaytimeNotIn(List<String> values) {
            addCriterion("dayTime not in", values, "daytime");
            return (Criteria) this;
        }

        public Criteria andDaytimeBetween(String value1, String value2) {
            addCriterion("dayTime between", value1, value2, "daytime");
            return (Criteria) this;
        }

        public Criteria andDaytimeNotBetween(String value1, String value2) {
            addCriterion("dayTime not between", value1, value2, "daytime");
            return (Criteria) this;
        }

        public Criteria andAttendIsNull() {
            addCriterion("attend is null");
            return (Criteria) this;
        }

        public Criteria andAttendIsNotNull() {
            addCriterion("attend is not null");
            return (Criteria) this;
        }

        public Criteria andAttendEqualTo(Integer value) {
            addCriterion("attend =", value, "attend");
            return (Criteria) this;
        }

        public Criteria andAttendNotEqualTo(Integer value) {
            addCriterion("attend <>", value, "attend");
            return (Criteria) this;
        }

        public Criteria andAttendGreaterThan(Integer value) {
            addCriterion("attend >", value, "attend");
            return (Criteria) this;
        }

        public Criteria andAttendGreaterThanOrEqualTo(Integer value) {
            addCriterion("attend >=", value, "attend");
            return (Criteria) this;
        }

        public Criteria andAttendLessThan(Integer value) {
            addCriterion("attend <", value, "attend");
            return (Criteria) this;
        }

        public Criteria andAttendLessThanOrEqualTo(Integer value) {
            addCriterion("attend <=", value, "attend");
            return (Criteria) this;
        }

        public Criteria andAttendIn(List<Integer> values) {
            addCriterion("attend in", values, "attend");
            return (Criteria) this;
        }

        public Criteria andAttendNotIn(List<Integer> values) {
            addCriterion("attend not in", values, "attend");
            return (Criteria) this;
        }

        public Criteria andAttendBetween(Integer value1, Integer value2) {
            addCriterion("attend between", value1, value2, "attend");
            return (Criteria) this;
        }

        public Criteria andAttendNotBetween(Integer value1, Integer value2) {
            addCriterion("attend not between", value1, value2, "attend");
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