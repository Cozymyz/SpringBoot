package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class WorkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkExample() {
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

        public Criteria andUseidIsNull() {
            addCriterion("useId is null");
            return (Criteria) this;
        }

        public Criteria andUseidIsNotNull() {
            addCriterion("useId is not null");
            return (Criteria) this;
        }

        public Criteria andUseidEqualTo(Integer value) {
            addCriterion("useId =", value, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidNotEqualTo(Integer value) {
            addCriterion("useId <>", value, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidGreaterThan(Integer value) {
            addCriterion("useId >", value, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidGreaterThanOrEqualTo(Integer value) {
            addCriterion("useId >=", value, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidLessThan(Integer value) {
            addCriterion("useId <", value, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidLessThanOrEqualTo(Integer value) {
            addCriterion("useId <=", value, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidIn(List<Integer> values) {
            addCriterion("useId in", values, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidNotIn(List<Integer> values) {
            addCriterion("useId not in", values, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidBetween(Integer value1, Integer value2) {
            addCriterion("useId between", value1, value2, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidNotBetween(Integer value1, Integer value2) {
            addCriterion("useId not between", value1, value2, "useid");
            return (Criteria) this;
        }

        public Criteria andCompanyidIsNull() {
            addCriterion("companyId is null");
            return (Criteria) this;
        }

        public Criteria andCompanyidIsNotNull() {
            addCriterion("companyId is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyidEqualTo(Integer value) {
            addCriterion("companyId =", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotEqualTo(Integer value) {
            addCriterion("companyId <>", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidGreaterThan(Integer value) {
            addCriterion("companyId >", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("companyId >=", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidLessThan(Integer value) {
            addCriterion("companyId <", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidLessThanOrEqualTo(Integer value) {
            addCriterion("companyId <=", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidIn(List<Integer> values) {
            addCriterion("companyId in", values, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotIn(List<Integer> values) {
            addCriterion("companyId not in", values, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidBetween(Integer value1, Integer value2) {
            addCriterion("companyId between", value1, value2, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotBetween(Integer value1, Integer value2) {
            addCriterion("companyId not between", value1, value2, "companyid");
            return (Criteria) this;
        }

        public Criteria andHridIsNull() {
            addCriterion("hrId is null");
            return (Criteria) this;
        }

        public Criteria andHridIsNotNull() {
            addCriterion("hrId is not null");
            return (Criteria) this;
        }

        public Criteria andHridEqualTo(Integer value) {
            addCriterion("hrId =", value, "hrid");
            return (Criteria) this;
        }

        public Criteria andHridNotEqualTo(Integer value) {
            addCriterion("hrId <>", value, "hrid");
            return (Criteria) this;
        }

        public Criteria andHridGreaterThan(Integer value) {
            addCriterion("hrId >", value, "hrid");
            return (Criteria) this;
        }

        public Criteria andHridGreaterThanOrEqualTo(Integer value) {
            addCriterion("hrId >=", value, "hrid");
            return (Criteria) this;
        }

        public Criteria andHridLessThan(Integer value) {
            addCriterion("hrId <", value, "hrid");
            return (Criteria) this;
        }

        public Criteria andHridLessThanOrEqualTo(Integer value) {
            addCriterion("hrId <=", value, "hrid");
            return (Criteria) this;
        }

        public Criteria andHridIn(List<Integer> values) {
            addCriterion("hrId in", values, "hrid");
            return (Criteria) this;
        }

        public Criteria andHridNotIn(List<Integer> values) {
            addCriterion("hrId not in", values, "hrid");
            return (Criteria) this;
        }

        public Criteria andHridBetween(Integer value1, Integer value2) {
            addCriterion("hrId between", value1, value2, "hrid");
            return (Criteria) this;
        }

        public Criteria andHridNotBetween(Integer value1, Integer value2) {
            addCriterion("hrId not between", value1, value2, "hrid");
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

        public Criteria andEvaluationIsNull() {
            addCriterion("evaluation is null");
            return (Criteria) this;
        }

        public Criteria andEvaluationIsNotNull() {
            addCriterion("evaluation is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluationEqualTo(String value) {
            addCriterion("evaluation =", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationNotEqualTo(String value) {
            addCriterion("evaluation <>", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationGreaterThan(String value) {
            addCriterion("evaluation >", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationGreaterThanOrEqualTo(String value) {
            addCriterion("evaluation >=", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationLessThan(String value) {
            addCriterion("evaluation <", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationLessThanOrEqualTo(String value) {
            addCriterion("evaluation <=", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationLike(String value) {
            addCriterion("evaluation like", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationNotLike(String value) {
            addCriterion("evaluation not like", value, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationIn(List<String> values) {
            addCriterion("evaluation in", values, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationNotIn(List<String> values) {
            addCriterion("evaluation not in", values, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationBetween(String value1, String value2) {
            addCriterion("evaluation between", value1, value2, "evaluation");
            return (Criteria) this;
        }

        public Criteria andEvaluationNotBetween(String value1, String value2) {
            addCriterion("evaluation not between", value1, value2, "evaluation");
            return (Criteria) this;
        }

        public Criteria andIsendIsNull() {
            addCriterion("isEnd is null");
            return (Criteria) this;
        }

        public Criteria andIsendIsNotNull() {
            addCriterion("isEnd is not null");
            return (Criteria) this;
        }

        public Criteria andIsendEqualTo(Integer value) {
            addCriterion("isEnd =", value, "isend");
            return (Criteria) this;
        }

        public Criteria andIsendNotEqualTo(Integer value) {
            addCriterion("isEnd <>", value, "isend");
            return (Criteria) this;
        }

        public Criteria andIsendGreaterThan(Integer value) {
            addCriterion("isEnd >", value, "isend");
            return (Criteria) this;
        }

        public Criteria andIsendGreaterThanOrEqualTo(Integer value) {
            addCriterion("isEnd >=", value, "isend");
            return (Criteria) this;
        }

        public Criteria andIsendLessThan(Integer value) {
            addCriterion("isEnd <", value, "isend");
            return (Criteria) this;
        }

        public Criteria andIsendLessThanOrEqualTo(Integer value) {
            addCriterion("isEnd <=", value, "isend");
            return (Criteria) this;
        }

        public Criteria andIsendIn(List<Integer> values) {
            addCriterion("isEnd in", values, "isend");
            return (Criteria) this;
        }

        public Criteria andIsendNotIn(List<Integer> values) {
            addCriterion("isEnd not in", values, "isend");
            return (Criteria) this;
        }

        public Criteria andIsendBetween(Integer value1, Integer value2) {
            addCriterion("isEnd between", value1, value2, "isend");
            return (Criteria) this;
        }

        public Criteria andIsendNotBetween(Integer value1, Integer value2) {
            addCriterion("isEnd not between", value1, value2, "isend");
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