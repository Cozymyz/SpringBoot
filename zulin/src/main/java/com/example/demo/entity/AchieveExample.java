package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class AchieveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AchieveExample() {
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

        public Criteria andAchieveidIsNull() {
            addCriterion("achieveId is null");
            return (Criteria) this;
        }

        public Criteria andAchieveidIsNotNull() {
            addCriterion("achieveId is not null");
            return (Criteria) this;
        }

        public Criteria andAchieveidEqualTo(Integer value) {
            addCriterion("achieveId =", value, "achieveid");
            return (Criteria) this;
        }

        public Criteria andAchieveidNotEqualTo(Integer value) {
            addCriterion("achieveId <>", value, "achieveid");
            return (Criteria) this;
        }

        public Criteria andAchieveidGreaterThan(Integer value) {
            addCriterion("achieveId >", value, "achieveid");
            return (Criteria) this;
        }

        public Criteria andAchieveidGreaterThanOrEqualTo(Integer value) {
            addCriterion("achieveId >=", value, "achieveid");
            return (Criteria) this;
        }

        public Criteria andAchieveidLessThan(Integer value) {
            addCriterion("achieveId <", value, "achieveid");
            return (Criteria) this;
        }

        public Criteria andAchieveidLessThanOrEqualTo(Integer value) {
            addCriterion("achieveId <=", value, "achieveid");
            return (Criteria) this;
        }

        public Criteria andAchieveidIn(List<Integer> values) {
            addCriterion("achieveId in", values, "achieveid");
            return (Criteria) this;
        }

        public Criteria andAchieveidNotIn(List<Integer> values) {
            addCriterion("achieveId not in", values, "achieveid");
            return (Criteria) this;
        }

        public Criteria andAchieveidBetween(Integer value1, Integer value2) {
            addCriterion("achieveId between", value1, value2, "achieveid");
            return (Criteria) this;
        }

        public Criteria andAchieveidNotBetween(Integer value1, Integer value2) {
            addCriterion("achieveId not between", value1, value2, "achieveid");
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

        public Criteria andEstimateIsNull() {
            addCriterion("estimate is null");
            return (Criteria) this;
        }

        public Criteria andEstimateIsNotNull() {
            addCriterion("estimate is not null");
            return (Criteria) this;
        }

        public Criteria andEstimateEqualTo(String value) {
            addCriterion("estimate =", value, "estimate");
            return (Criteria) this;
        }

        public Criteria andEstimateNotEqualTo(String value) {
            addCriterion("estimate <>", value, "estimate");
            return (Criteria) this;
        }

        public Criteria andEstimateGreaterThan(String value) {
            addCriterion("estimate >", value, "estimate");
            return (Criteria) this;
        }

        public Criteria andEstimateGreaterThanOrEqualTo(String value) {
            addCriterion("estimate >=", value, "estimate");
            return (Criteria) this;
        }

        public Criteria andEstimateLessThan(String value) {
            addCriterion("estimate <", value, "estimate");
            return (Criteria) this;
        }

        public Criteria andEstimateLessThanOrEqualTo(String value) {
            addCriterion("estimate <=", value, "estimate");
            return (Criteria) this;
        }

        public Criteria andEstimateLike(String value) {
            addCriterion("estimate like", value, "estimate");
            return (Criteria) this;
        }

        public Criteria andEstimateNotLike(String value) {
            addCriterion("estimate not like", value, "estimate");
            return (Criteria) this;
        }

        public Criteria andEstimateIn(List<String> values) {
            addCriterion("estimate in", values, "estimate");
            return (Criteria) this;
        }

        public Criteria andEstimateNotIn(List<String> values) {
            addCriterion("estimate not in", values, "estimate");
            return (Criteria) this;
        }

        public Criteria andEstimateBetween(String value1, String value2) {
            addCriterion("estimate between", value1, value2, "estimate");
            return (Criteria) this;
        }

        public Criteria andEstimateNotBetween(String value1, String value2) {
            addCriterion("estimate not between", value1, value2, "estimate");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("startTime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("startTime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(String value) {
            addCriterion("startTime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(String value) {
            addCriterion("startTime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(String value) {
            addCriterion("startTime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(String value) {
            addCriterion("startTime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(String value) {
            addCriterion("startTime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(String value) {
            addCriterion("startTime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLike(String value) {
            addCriterion("startTime like", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotLike(String value) {
            addCriterion("startTime not like", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<String> values) {
            addCriterion("startTime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<String> values) {
            addCriterion("startTime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(String value1, String value2) {
            addCriterion("startTime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(String value1, String value2) {
            addCriterion("startTime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endTime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endTime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(String value) {
            addCriterion("endTime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(String value) {
            addCriterion("endTime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(String value) {
            addCriterion("endTime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(String value) {
            addCriterion("endTime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(String value) {
            addCriterion("endTime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(String value) {
            addCriterion("endTime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLike(String value) {
            addCriterion("endTime like", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotLike(String value) {
            addCriterion("endTime not like", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<String> values) {
            addCriterion("endTime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<String> values) {
            addCriterion("endTime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(String value1, String value2) {
            addCriterion("endTime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(String value1, String value2) {
            addCriterion("endTime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andInfoIsNull() {
            addCriterion("info is null");
            return (Criteria) this;
        }

        public Criteria andInfoIsNotNull() {
            addCriterion("info is not null");
            return (Criteria) this;
        }

        public Criteria andInfoEqualTo(String value) {
            addCriterion("info =", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotEqualTo(String value) {
            addCriterion("info <>", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoGreaterThan(String value) {
            addCriterion("info >", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoGreaterThanOrEqualTo(String value) {
            addCriterion("info >=", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLessThan(String value) {
            addCriterion("info <", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLessThanOrEqualTo(String value) {
            addCriterion("info <=", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLike(String value) {
            addCriterion("info like", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotLike(String value) {
            addCriterion("info not like", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoIn(List<String> values) {
            addCriterion("info in", values, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotIn(List<String> values) {
            addCriterion("info not in", values, "info");
            return (Criteria) this;
        }

        public Criteria andInfoBetween(String value1, String value2) {
            addCriterion("info between", value1, value2, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotBetween(String value1, String value2) {
            addCriterion("info not between", value1, value2, "info");
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