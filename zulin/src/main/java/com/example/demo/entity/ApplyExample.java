package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class ApplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApplyExample() {
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

        public Criteria andApplyidIsNull() {
            addCriterion("applyId is null");
            return (Criteria) this;
        }

        public Criteria andApplyidIsNotNull() {
            addCriterion("applyId is not null");
            return (Criteria) this;
        }

        public Criteria andApplyidEqualTo(Integer value) {
            addCriterion("applyId =", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidNotEqualTo(Integer value) {
            addCriterion("applyId <>", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidGreaterThan(Integer value) {
            addCriterion("applyId >", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("applyId >=", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidLessThan(Integer value) {
            addCriterion("applyId <", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidLessThanOrEqualTo(Integer value) {
            addCriterion("applyId <=", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidIn(List<Integer> values) {
            addCriterion("applyId in", values, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidNotIn(List<Integer> values) {
            addCriterion("applyId not in", values, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidBetween(Integer value1, Integer value2) {
            addCriterion("applyId between", value1, value2, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidNotBetween(Integer value1, Integer value2) {
            addCriterion("applyId not between", value1, value2, "applyid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
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

        public Criteria andSubtimeIsNull() {
            addCriterion("subTime is null");
            return (Criteria) this;
        }

        public Criteria andSubtimeIsNotNull() {
            addCriterion("subTime is not null");
            return (Criteria) this;
        }

        public Criteria andSubtimeEqualTo(String value) {
            addCriterion("subTime =", value, "subtime");
            return (Criteria) this;
        }

        public Criteria andSubtimeNotEqualTo(String value) {
            addCriterion("subTime <>", value, "subtime");
            return (Criteria) this;
        }

        public Criteria andSubtimeGreaterThan(String value) {
            addCriterion("subTime >", value, "subtime");
            return (Criteria) this;
        }

        public Criteria andSubtimeGreaterThanOrEqualTo(String value) {
            addCriterion("subTime >=", value, "subtime");
            return (Criteria) this;
        }

        public Criteria andSubtimeLessThan(String value) {
            addCriterion("subTime <", value, "subtime");
            return (Criteria) this;
        }

        public Criteria andSubtimeLessThanOrEqualTo(String value) {
            addCriterion("subTime <=", value, "subtime");
            return (Criteria) this;
        }

        public Criteria andSubtimeLike(String value) {
            addCriterion("subTime like", value, "subtime");
            return (Criteria) this;
        }

        public Criteria andSubtimeNotLike(String value) {
            addCriterion("subTime not like", value, "subtime");
            return (Criteria) this;
        }

        public Criteria andSubtimeIn(List<String> values) {
            addCriterion("subTime in", values, "subtime");
            return (Criteria) this;
        }

        public Criteria andSubtimeNotIn(List<String> values) {
            addCriterion("subTime not in", values, "subtime");
            return (Criteria) this;
        }

        public Criteria andSubtimeBetween(String value1, String value2) {
            addCriterion("subTime between", value1, value2, "subtime");
            return (Criteria) this;
        }

        public Criteria andSubtimeNotBetween(String value1, String value2) {
            addCriterion("subTime not between", value1, value2, "subtime");
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

        public Criteria andAcceptorIsNull() {
            addCriterion("acceptor is null");
            return (Criteria) this;
        }

        public Criteria andAcceptorIsNotNull() {
            addCriterion("acceptor is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptorEqualTo(Integer value) {
            addCriterion("acceptor =", value, "acceptor");
            return (Criteria) this;
        }

        public Criteria andAcceptorNotEqualTo(Integer value) {
            addCriterion("acceptor <>", value, "acceptor");
            return (Criteria) this;
        }

        public Criteria andAcceptorGreaterThan(Integer value) {
            addCriterion("acceptor >", value, "acceptor");
            return (Criteria) this;
        }

        public Criteria andAcceptorGreaterThanOrEqualTo(Integer value) {
            addCriterion("acceptor >=", value, "acceptor");
            return (Criteria) this;
        }

        public Criteria andAcceptorLessThan(Integer value) {
            addCriterion("acceptor <", value, "acceptor");
            return (Criteria) this;
        }

        public Criteria andAcceptorLessThanOrEqualTo(Integer value) {
            addCriterion("acceptor <=", value, "acceptor");
            return (Criteria) this;
        }

        public Criteria andAcceptorIn(List<Integer> values) {
            addCriterion("acceptor in", values, "acceptor");
            return (Criteria) this;
        }

        public Criteria andAcceptorNotIn(List<Integer> values) {
            addCriterion("acceptor not in", values, "acceptor");
            return (Criteria) this;
        }

        public Criteria andAcceptorBetween(Integer value1, Integer value2) {
            addCriterion("acceptor between", value1, value2, "acceptor");
            return (Criteria) this;
        }

        public Criteria andAcceptorNotBetween(Integer value1, Integer value2) {
            addCriterion("acceptor not between", value1, value2, "acceptor");
            return (Criteria) this;
        }

        public Criteria andIsacceptIsNull() {
            addCriterion("isAccept is null");
            return (Criteria) this;
        }

        public Criteria andIsacceptIsNotNull() {
            addCriterion("isAccept is not null");
            return (Criteria) this;
        }

        public Criteria andIsacceptEqualTo(Integer value) {
            addCriterion("isAccept =", value, "isaccept");
            return (Criteria) this;
        }

        public Criteria andIsacceptNotEqualTo(Integer value) {
            addCriterion("isAccept <>", value, "isaccept");
            return (Criteria) this;
        }

        public Criteria andIsacceptGreaterThan(Integer value) {
            addCriterion("isAccept >", value, "isaccept");
            return (Criteria) this;
        }

        public Criteria andIsacceptGreaterThanOrEqualTo(Integer value) {
            addCriterion("isAccept >=", value, "isaccept");
            return (Criteria) this;
        }

        public Criteria andIsacceptLessThan(Integer value) {
            addCriterion("isAccept <", value, "isaccept");
            return (Criteria) this;
        }

        public Criteria andIsacceptLessThanOrEqualTo(Integer value) {
            addCriterion("isAccept <=", value, "isaccept");
            return (Criteria) this;
        }

        public Criteria andIsacceptIn(List<Integer> values) {
            addCriterion("isAccept in", values, "isaccept");
            return (Criteria) this;
        }

        public Criteria andIsacceptNotIn(List<Integer> values) {
            addCriterion("isAccept not in", values, "isaccept");
            return (Criteria) this;
        }

        public Criteria andIsacceptBetween(Integer value1, Integer value2) {
            addCriterion("isAccept between", value1, value2, "isaccept");
            return (Criteria) this;
        }

        public Criteria andIsacceptNotBetween(Integer value1, Integer value2) {
            addCriterion("isAccept not between", value1, value2, "isaccept");
            return (Criteria) this;
        }

        public Criteria andApplytypeIsNull() {
            addCriterion("applyType is null");
            return (Criteria) this;
        }

        public Criteria andApplytypeIsNotNull() {
            addCriterion("applyType is not null");
            return (Criteria) this;
        }

        public Criteria andApplytypeEqualTo(Integer value) {
            addCriterion("applyType =", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeNotEqualTo(Integer value) {
            addCriterion("applyType <>", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeGreaterThan(Integer value) {
            addCriterion("applyType >", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("applyType >=", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeLessThan(Integer value) {
            addCriterion("applyType <", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeLessThanOrEqualTo(Integer value) {
            addCriterion("applyType <=", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeIn(List<Integer> values) {
            addCriterion("applyType in", values, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeNotIn(List<Integer> values) {
            addCriterion("applyType not in", values, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeBetween(Integer value1, Integer value2) {
            addCriterion("applyType between", value1, value2, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeNotBetween(Integer value1, Integer value2) {
            addCriterion("applyType not between", value1, value2, "applytype");
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