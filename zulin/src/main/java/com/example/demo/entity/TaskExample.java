package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class TaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskExample() {
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

        public Criteria andTaskidIsNull() {
            addCriterion("taskId is null");
            return (Criteria) this;
        }

        public Criteria andTaskidIsNotNull() {
            addCriterion("taskId is not null");
            return (Criteria) this;
        }

        public Criteria andTaskidEqualTo(Integer value) {
            addCriterion("taskId =", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotEqualTo(Integer value) {
            addCriterion("taskId <>", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidGreaterThan(Integer value) {
            addCriterion("taskId >", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidGreaterThanOrEqualTo(Integer value) {
            addCriterion("taskId >=", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidLessThan(Integer value) {
            addCriterion("taskId <", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidLessThanOrEqualTo(Integer value) {
            addCriterion("taskId <=", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidIn(List<Integer> values) {
            addCriterion("taskId in", values, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotIn(List<Integer> values) {
            addCriterion("taskId not in", values, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidBetween(Integer value1, Integer value2) {
            addCriterion("taskId between", value1, value2, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotBetween(Integer value1, Integer value2) {
            addCriterion("taskId not between", value1, value2, "taskid");
            return (Criteria) this;
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

        public Criteria andDeadlineIsNull() {
            addCriterion("deadLine is null");
            return (Criteria) this;
        }

        public Criteria andDeadlineIsNotNull() {
            addCriterion("deadLine is not null");
            return (Criteria) this;
        }

        public Criteria andDeadlineEqualTo(String value) {
            addCriterion("deadLine =", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotEqualTo(String value) {
            addCriterion("deadLine <>", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThan(String value) {
            addCriterion("deadLine >", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThanOrEqualTo(String value) {
            addCriterion("deadLine >=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThan(String value) {
            addCriterion("deadLine <", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThanOrEqualTo(String value) {
            addCriterion("deadLine <=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLike(String value) {
            addCriterion("deadLine like", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotLike(String value) {
            addCriterion("deadLine not like", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineIn(List<String> values) {
            addCriterion("deadLine in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotIn(List<String> values) {
            addCriterion("deadLine not in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineBetween(String value1, String value2) {
            addCriterion("deadLine between", value1, value2, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotBetween(String value1, String value2) {
            addCriterion("deadLine not between", value1, value2, "deadline");
            return (Criteria) this;
        }

        public Criteria andSublineIsNull() {
            addCriterion("subLine is null");
            return (Criteria) this;
        }

        public Criteria andSublineIsNotNull() {
            addCriterion("subLine is not null");
            return (Criteria) this;
        }

        public Criteria andSublineEqualTo(String value) {
            addCriterion("subLine =", value, "subline");
            return (Criteria) this;
        }

        public Criteria andSublineNotEqualTo(String value) {
            addCriterion("subLine <>", value, "subline");
            return (Criteria) this;
        }

        public Criteria andSublineGreaterThan(String value) {
            addCriterion("subLine >", value, "subline");
            return (Criteria) this;
        }

        public Criteria andSublineGreaterThanOrEqualTo(String value) {
            addCriterion("subLine >=", value, "subline");
            return (Criteria) this;
        }

        public Criteria andSublineLessThan(String value) {
            addCriterion("subLine <", value, "subline");
            return (Criteria) this;
        }

        public Criteria andSublineLessThanOrEqualTo(String value) {
            addCriterion("subLine <=", value, "subline");
            return (Criteria) this;
        }

        public Criteria andSublineLike(String value) {
            addCriterion("subLine like", value, "subline");
            return (Criteria) this;
        }

        public Criteria andSublineNotLike(String value) {
            addCriterion("subLine not like", value, "subline");
            return (Criteria) this;
        }

        public Criteria andSublineIn(List<String> values) {
            addCriterion("subLine in", values, "subline");
            return (Criteria) this;
        }

        public Criteria andSublineNotIn(List<String> values) {
            addCriterion("subLine not in", values, "subline");
            return (Criteria) this;
        }

        public Criteria andSublineBetween(String value1, String value2) {
            addCriterion("subLine between", value1, value2, "subline");
            return (Criteria) this;
        }

        public Criteria andSublineNotBetween(String value1, String value2) {
            addCriterion("subLine not between", value1, value2, "subline");
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