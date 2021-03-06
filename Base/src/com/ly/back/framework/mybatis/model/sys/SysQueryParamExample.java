package com.ly.back.framework.mybatis.model.sys;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SysQueryParamExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SYS_QUERY_PARAM
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SYS_QUERY_PARAM
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SYS_QUERY_PARAM
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM
     *
     * @mbggenerated
     */
    public SysQueryParamExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table SYS_QUERY_PARAM
     *
     * @mbggenerated
     */
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andQueryIdIsNull() {
            addCriterion("QUERY_ID is null");
            return (Criteria) this;
        }

        public Criteria andQueryIdIsNotNull() {
            addCriterion("QUERY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andQueryIdEqualTo(String value) {
            addCriterion("QUERY_ID =", value, "queryId");
            return (Criteria) this;
        }

        public Criteria andQueryIdNotEqualTo(String value) {
            addCriterion("QUERY_ID <>", value, "queryId");
            return (Criteria) this;
        }

        public Criteria andQueryIdGreaterThan(String value) {
            addCriterion("QUERY_ID >", value, "queryId");
            return (Criteria) this;
        }

        public Criteria andQueryIdGreaterThanOrEqualTo(String value) {
            addCriterion("QUERY_ID >=", value, "queryId");
            return (Criteria) this;
        }

        public Criteria andQueryIdLessThan(String value) {
            addCriterion("QUERY_ID <", value, "queryId");
            return (Criteria) this;
        }

        public Criteria andQueryIdLessThanOrEqualTo(String value) {
            addCriterion("QUERY_ID <=", value, "queryId");
            return (Criteria) this;
        }

        public Criteria andQueryIdLike(String value) {
            addCriterion("QUERY_ID like", value, "queryId");
            return (Criteria) this;
        }

        public Criteria andQueryIdNotLike(String value) {
            addCriterion("QUERY_ID not like", value, "queryId");
            return (Criteria) this;
        }

        public Criteria andQueryIdIn(List<String> values) {
            addCriterion("QUERY_ID in", values, "queryId");
            return (Criteria) this;
        }

        public Criteria andQueryIdNotIn(List<String> values) {
            addCriterion("QUERY_ID not in", values, "queryId");
            return (Criteria) this;
        }

        public Criteria andQueryIdBetween(String value1, String value2) {
            addCriterion("QUERY_ID between", value1, value2, "queryId");
            return (Criteria) this;
        }

        public Criteria andQueryIdNotBetween(String value1, String value2) {
            addCriterion("QUERY_ID not between", value1, value2, "queryId");
            return (Criteria) this;
        }

        public Criteria andParamNameIsNull() {
            addCriterion("PARAM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andParamNameIsNotNull() {
            addCriterion("PARAM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andParamNameEqualTo(String value) {
            addCriterion("PARAM_NAME =", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotEqualTo(String value) {
            addCriterion("PARAM_NAME <>", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameGreaterThan(String value) {
            addCriterion("PARAM_NAME >", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_NAME >=", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameLessThan(String value) {
            addCriterion("PARAM_NAME <", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameLessThanOrEqualTo(String value) {
            addCriterion("PARAM_NAME <=", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameLike(String value) {
            addCriterion("PARAM_NAME like", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotLike(String value) {
            addCriterion("PARAM_NAME not like", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameIn(List<String> values) {
            addCriterion("PARAM_NAME in", values, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotIn(List<String> values) {
            addCriterion("PARAM_NAME not in", values, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameBetween(String value1, String value2) {
            addCriterion("PARAM_NAME between", value1, value2, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotBetween(String value1, String value2) {
            addCriterion("PARAM_NAME not between", value1, value2, "paramName");
            return (Criteria) this;
        }

        public Criteria andQueryTypeIsNull() {
            addCriterion("QUERY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andQueryTypeIsNotNull() {
            addCriterion("QUERY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andQueryTypeEqualTo(String value) {
            addCriterion("QUERY_TYPE =", value, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeNotEqualTo(String value) {
            addCriterion("QUERY_TYPE <>", value, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeGreaterThan(String value) {
            addCriterion("QUERY_TYPE >", value, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeGreaterThanOrEqualTo(String value) {
            addCriterion("QUERY_TYPE >=", value, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeLessThan(String value) {
            addCriterion("QUERY_TYPE <", value, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeLessThanOrEqualTo(String value) {
            addCriterion("QUERY_TYPE <=", value, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeLike(String value) {
            addCriterion("QUERY_TYPE like", value, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeNotLike(String value) {
            addCriterion("QUERY_TYPE not like", value, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeIn(List<String> values) {
            addCriterion("QUERY_TYPE in", values, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeNotIn(List<String> values) {
            addCriterion("QUERY_TYPE not in", values, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeBetween(String value1, String value2) {
            addCriterion("QUERY_TYPE between", value1, value2, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeNotBetween(String value1, String value2) {
            addCriterion("QUERY_TYPE not between", value1, value2, "queryType");
            return (Criteria) this;
        }

        public Criteria andParamDefIsNull() {
            addCriterion("PARAM_DEF is null");
            return (Criteria) this;
        }

        public Criteria andParamDefIsNotNull() {
            addCriterion("PARAM_DEF is not null");
            return (Criteria) this;
        }

        public Criteria andParamDefEqualTo(String value) {
            addCriterion("PARAM_DEF =", value, "paramDef");
            return (Criteria) this;
        }

        public Criteria andParamDefNotEqualTo(String value) {
            addCriterion("PARAM_DEF <>", value, "paramDef");
            return (Criteria) this;
        }

        public Criteria andParamDefGreaterThan(String value) {
            addCriterion("PARAM_DEF >", value, "paramDef");
            return (Criteria) this;
        }

        public Criteria andParamDefGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_DEF >=", value, "paramDef");
            return (Criteria) this;
        }

        public Criteria andParamDefLessThan(String value) {
            addCriterion("PARAM_DEF <", value, "paramDef");
            return (Criteria) this;
        }

        public Criteria andParamDefLessThanOrEqualTo(String value) {
            addCriterion("PARAM_DEF <=", value, "paramDef");
            return (Criteria) this;
        }

        public Criteria andParamDefLike(String value) {
            addCriterion("PARAM_DEF like", value, "paramDef");
            return (Criteria) this;
        }

        public Criteria andParamDefNotLike(String value) {
            addCriterion("PARAM_DEF not like", value, "paramDef");
            return (Criteria) this;
        }

        public Criteria andParamDefIn(List<String> values) {
            addCriterion("PARAM_DEF in", values, "paramDef");
            return (Criteria) this;
        }

        public Criteria andParamDefNotIn(List<String> values) {
            addCriterion("PARAM_DEF not in", values, "paramDef");
            return (Criteria) this;
        }

        public Criteria andParamDefBetween(String value1, String value2) {
            addCriterion("PARAM_DEF between", value1, value2, "paramDef");
            return (Criteria) this;
        }

        public Criteria andParamDefNotBetween(String value1, String value2) {
            addCriterion("PARAM_DEF not between", value1, value2, "paramDef");
            return (Criteria) this;
        }

        public Criteria andParamFieldIsNull() {
            addCriterion("PARAM_FIELD is null");
            return (Criteria) this;
        }

        public Criteria andParamFieldIsNotNull() {
            addCriterion("PARAM_FIELD is not null");
            return (Criteria) this;
        }

        public Criteria andParamFieldEqualTo(String value) {
            addCriterion("PARAM_FIELD =", value, "paramField");
            return (Criteria) this;
        }

        public Criteria andParamFieldNotEqualTo(String value) {
            addCriterion("PARAM_FIELD <>", value, "paramField");
            return (Criteria) this;
        }

        public Criteria andParamFieldGreaterThan(String value) {
            addCriterion("PARAM_FIELD >", value, "paramField");
            return (Criteria) this;
        }

        public Criteria andParamFieldGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_FIELD >=", value, "paramField");
            return (Criteria) this;
        }

        public Criteria andParamFieldLessThan(String value) {
            addCriterion("PARAM_FIELD <", value, "paramField");
            return (Criteria) this;
        }

        public Criteria andParamFieldLessThanOrEqualTo(String value) {
            addCriterion("PARAM_FIELD <=", value, "paramField");
            return (Criteria) this;
        }

        public Criteria andParamFieldLike(String value) {
            addCriterion("PARAM_FIELD like", value, "paramField");
            return (Criteria) this;
        }

        public Criteria andParamFieldNotLike(String value) {
            addCriterion("PARAM_FIELD not like", value, "paramField");
            return (Criteria) this;
        }

        public Criteria andParamFieldIn(List<String> values) {
            addCriterion("PARAM_FIELD in", values, "paramField");
            return (Criteria) this;
        }

        public Criteria andParamFieldNotIn(List<String> values) {
            addCriterion("PARAM_FIELD not in", values, "paramField");
            return (Criteria) this;
        }

        public Criteria andParamFieldBetween(String value1, String value2) {
            addCriterion("PARAM_FIELD between", value1, value2, "paramField");
            return (Criteria) this;
        }

        public Criteria andParamFieldNotBetween(String value1, String value2) {
            addCriterion("PARAM_FIELD not between", value1, value2, "paramField");
            return (Criteria) this;
        }

        public Criteria andParamSortIsNull() {
            addCriterion("PARAM_SORT is null");
            return (Criteria) this;
        }

        public Criteria andParamSortIsNotNull() {
            addCriterion("PARAM_SORT is not null");
            return (Criteria) this;
        }

        public Criteria andParamSortEqualTo(BigDecimal value) {
            addCriterion("PARAM_SORT =", value, "paramSort");
            return (Criteria) this;
        }

        public Criteria andParamSortNotEqualTo(BigDecimal value) {
            addCriterion("PARAM_SORT <>", value, "paramSort");
            return (Criteria) this;
        }

        public Criteria andParamSortGreaterThan(BigDecimal value) {
            addCriterion("PARAM_SORT >", value, "paramSort");
            return (Criteria) this;
        }

        public Criteria andParamSortGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PARAM_SORT >=", value, "paramSort");
            return (Criteria) this;
        }

        public Criteria andParamSortLessThan(BigDecimal value) {
            addCriterion("PARAM_SORT <", value, "paramSort");
            return (Criteria) this;
        }

        public Criteria andParamSortLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PARAM_SORT <=", value, "paramSort");
            return (Criteria) this;
        }

        public Criteria andParamSortIn(List<BigDecimal> values) {
            addCriterion("PARAM_SORT in", values, "paramSort");
            return (Criteria) this;
        }

        public Criteria andParamSortNotIn(List<BigDecimal> values) {
            addCriterion("PARAM_SORT not in", values, "paramSort");
            return (Criteria) this;
        }

        public Criteria andParamSortBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PARAM_SORT between", value1, value2, "paramSort");
            return (Criteria) this;
        }

        public Criteria andParamSortNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PARAM_SORT not between", value1, value2, "paramSort");
            return (Criteria) this;
        }

        public Criteria andParamInputSqlIsNull() {
            addCriterion("PARAM_INPUT_SQL is null");
            return (Criteria) this;
        }

        public Criteria andParamInputSqlIsNotNull() {
            addCriterion("PARAM_INPUT_SQL is not null");
            return (Criteria) this;
        }

        public Criteria andParamInputSqlEqualTo(String value) {
            addCriterion("PARAM_INPUT_SQL =", value, "paramInputSql");
            return (Criteria) this;
        }

        public Criteria andParamInputSqlNotEqualTo(String value) {
            addCriterion("PARAM_INPUT_SQL <>", value, "paramInputSql");
            return (Criteria) this;
        }

        public Criteria andParamInputSqlGreaterThan(String value) {
            addCriterion("PARAM_INPUT_SQL >", value, "paramInputSql");
            return (Criteria) this;
        }

        public Criteria andParamInputSqlGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_INPUT_SQL >=", value, "paramInputSql");
            return (Criteria) this;
        }

        public Criteria andParamInputSqlLessThan(String value) {
            addCriterion("PARAM_INPUT_SQL <", value, "paramInputSql");
            return (Criteria) this;
        }

        public Criteria andParamInputSqlLessThanOrEqualTo(String value) {
            addCriterion("PARAM_INPUT_SQL <=", value, "paramInputSql");
            return (Criteria) this;
        }

        public Criteria andParamInputSqlLike(String value) {
            addCriterion("PARAM_INPUT_SQL like", value, "paramInputSql");
            return (Criteria) this;
        }

        public Criteria andParamInputSqlNotLike(String value) {
            addCriterion("PARAM_INPUT_SQL not like", value, "paramInputSql");
            return (Criteria) this;
        }

        public Criteria andParamInputSqlIn(List<String> values) {
            addCriterion("PARAM_INPUT_SQL in", values, "paramInputSql");
            return (Criteria) this;
        }

        public Criteria andParamInputSqlNotIn(List<String> values) {
            addCriterion("PARAM_INPUT_SQL not in", values, "paramInputSql");
            return (Criteria) this;
        }

        public Criteria andParamInputSqlBetween(String value1, String value2) {
            addCriterion("PARAM_INPUT_SQL between", value1, value2, "paramInputSql");
            return (Criteria) this;
        }

        public Criteria andParamInputSqlNotBetween(String value1, String value2) {
            addCriterion("PARAM_INPUT_SQL not between", value1, value2, "paramInputSql");
            return (Criteria) this;
        }

        public Criteria andFromTypeIsNull() {
            addCriterion("FROM_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andFromTypeIsNotNull() {
            addCriterion("FROM_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFromTypeEqualTo(String value) {
            addCriterion("FROM_TYPE =", value, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeNotEqualTo(String value) {
            addCriterion("FROM_TYPE <>", value, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeGreaterThan(String value) {
            addCriterion("FROM_TYPE >", value, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeGreaterThanOrEqualTo(String value) {
            addCriterion("FROM_TYPE >=", value, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeLessThan(String value) {
            addCriterion("FROM_TYPE <", value, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeLessThanOrEqualTo(String value) {
            addCriterion("FROM_TYPE <=", value, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeLike(String value) {
            addCriterion("FROM_TYPE like", value, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeNotLike(String value) {
            addCriterion("FROM_TYPE not like", value, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeIn(List<String> values) {
            addCriterion("FROM_TYPE in", values, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeNotIn(List<String> values) {
            addCriterion("FROM_TYPE not in", values, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeBetween(String value1, String value2) {
            addCriterion("FROM_TYPE between", value1, value2, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeNotBetween(String value1, String value2) {
            addCriterion("FROM_TYPE not between", value1, value2, "fromType");
            return (Criteria) this;
        }

        public Criteria andRequiredIsNull() {
            addCriterion("REQUIRED is null");
            return (Criteria) this;
        }

        public Criteria andRequiredIsNotNull() {
            addCriterion("REQUIRED is not null");
            return (Criteria) this;
        }

        public Criteria andRequiredEqualTo(String value) {
            addCriterion("REQUIRED =", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotEqualTo(String value) {
            addCriterion("REQUIRED <>", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredGreaterThan(String value) {
            addCriterion("REQUIRED >", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredGreaterThanOrEqualTo(String value) {
            addCriterion("REQUIRED >=", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredLessThan(String value) {
            addCriterion("REQUIRED <", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredLessThanOrEqualTo(String value) {
            addCriterion("REQUIRED <=", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredLike(String value) {
            addCriterion("REQUIRED like", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotLike(String value) {
            addCriterion("REQUIRED not like", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredIn(List<String> values) {
            addCriterion("REQUIRED in", values, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotIn(List<String> values) {
            addCriterion("REQUIRED not in", values, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredBetween(String value1, String value2) {
            addCriterion("REQUIRED between", value1, value2, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotBetween(String value1, String value2) {
            addCriterion("REQUIRED not between", value1, value2, "required");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table SYS_QUERY_PARAM
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table SYS_QUERY_PARAM
     *
     * @mbggenerated
     */
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