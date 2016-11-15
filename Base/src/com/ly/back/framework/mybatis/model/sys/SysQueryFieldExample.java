package com.ly.back.framework.mybatis.model.sys;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SysQueryFieldExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SYS_QUERY_FIELD
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SYS_QUERY_FIELD
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SYS_QUERY_FIELD
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_FIELD
     *
     * @mbggenerated
     */
    public SysQueryFieldExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_FIELD
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_FIELD
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_FIELD
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_FIELD
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_FIELD
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_FIELD
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_FIELD
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
     * This method corresponds to the database table SYS_QUERY_FIELD
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
     * This method corresponds to the database table SYS_QUERY_FIELD
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_FIELD
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
     * This class corresponds to the database table SYS_QUERY_FIELD
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

        public Criteria andFieldIsNull() {
            addCriterion("FIELD is null");
            return (Criteria) this;
        }

        public Criteria andFieldIsNotNull() {
            addCriterion("FIELD is not null");
            return (Criteria) this;
        }

        public Criteria andFieldEqualTo(String value) {
            addCriterion("FIELD =", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldNotEqualTo(String value) {
            addCriterion("FIELD <>", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldGreaterThan(String value) {
            addCriterion("FIELD >", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldGreaterThanOrEqualTo(String value) {
            addCriterion("FIELD >=", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldLessThan(String value) {
            addCriterion("FIELD <", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldLessThanOrEqualTo(String value) {
            addCriterion("FIELD <=", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldLike(String value) {
            addCriterion("FIELD like", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldNotLike(String value) {
            addCriterion("FIELD not like", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldIn(List<String> values) {
            addCriterion("FIELD in", values, "field");
            return (Criteria) this;
        }

        public Criteria andFieldNotIn(List<String> values) {
            addCriterion("FIELD not in", values, "field");
            return (Criteria) this;
        }

        public Criteria andFieldBetween(String value1, String value2) {
            addCriterion("FIELD between", value1, value2, "field");
            return (Criteria) this;
        }

        public Criteria andFieldNotBetween(String value1, String value2) {
            addCriterion("FIELD not between", value1, value2, "field");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andWidthIsNull() {
            addCriterion("WIDTH is null");
            return (Criteria) this;
        }

        public Criteria andWidthIsNotNull() {
            addCriterion("WIDTH is not null");
            return (Criteria) this;
        }

        public Criteria andWidthEqualTo(String value) {
            addCriterion("WIDTH =", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotEqualTo(String value) {
            addCriterion("WIDTH <>", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThan(String value) {
            addCriterion("WIDTH >", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThanOrEqualTo(String value) {
            addCriterion("WIDTH >=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThan(String value) {
            addCriterion("WIDTH <", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThanOrEqualTo(String value) {
            addCriterion("WIDTH <=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLike(String value) {
            addCriterion("WIDTH like", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotLike(String value) {
            addCriterion("WIDTH not like", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthIn(List<String> values) {
            addCriterion("WIDTH in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotIn(List<String> values) {
            addCriterion("WIDTH not in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthBetween(String value1, String value2) {
            addCriterion("WIDTH between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotBetween(String value1, String value2) {
            addCriterion("WIDTH not between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andFiledSortIsNull() {
            addCriterion("FILED_SORT is null");
            return (Criteria) this;
        }

        public Criteria andFiledSortIsNotNull() {
            addCriterion("FILED_SORT is not null");
            return (Criteria) this;
        }

        public Criteria andFiledSortEqualTo(BigDecimal value) {
            addCriterion("FILED_SORT =", value, "filedSort");
            return (Criteria) this;
        }

        public Criteria andFiledSortNotEqualTo(BigDecimal value) {
            addCriterion("FILED_SORT <>", value, "filedSort");
            return (Criteria) this;
        }

        public Criteria andFiledSortGreaterThan(BigDecimal value) {
            addCriterion("FILED_SORT >", value, "filedSort");
            return (Criteria) this;
        }

        public Criteria andFiledSortGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FILED_SORT >=", value, "filedSort");
            return (Criteria) this;
        }

        public Criteria andFiledSortLessThan(BigDecimal value) {
            addCriterion("FILED_SORT <", value, "filedSort");
            return (Criteria) this;
        }

        public Criteria andFiledSortLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FILED_SORT <=", value, "filedSort");
            return (Criteria) this;
        }

        public Criteria andFiledSortIn(List<BigDecimal> values) {
            addCriterion("FILED_SORT in", values, "filedSort");
            return (Criteria) this;
        }

        public Criteria andFiledSortNotIn(List<BigDecimal> values) {
            addCriterion("FILED_SORT not in", values, "filedSort");
            return (Criteria) this;
        }

        public Criteria andFiledSortBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FILED_SORT between", value1, value2, "filedSort");
            return (Criteria) this;
        }

        public Criteria andFiledSortNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FILED_SORT not between", value1, value2, "filedSort");
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

        public Criteria andHiddenIsNull() {
            addCriterion("HIDDEN is null");
            return (Criteria) this;
        }

        public Criteria andHiddenIsNotNull() {
            addCriterion("HIDDEN is not null");
            return (Criteria) this;
        }

        public Criteria andHiddenEqualTo(String value) {
            addCriterion("HIDDEN =", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenNotEqualTo(String value) {
            addCriterion("HIDDEN <>", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenGreaterThan(String value) {
            addCriterion("HIDDEN >", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenGreaterThanOrEqualTo(String value) {
            addCriterion("HIDDEN >=", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenLessThan(String value) {
            addCriterion("HIDDEN <", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenLessThanOrEqualTo(String value) {
            addCriterion("HIDDEN <=", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenLike(String value) {
            addCriterion("HIDDEN like", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenNotLike(String value) {
            addCriterion("HIDDEN not like", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenIn(List<String> values) {
            addCriterion("HIDDEN in", values, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenNotIn(List<String> values) {
            addCriterion("HIDDEN not in", values, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenBetween(String value1, String value2) {
            addCriterion("HIDDEN between", value1, value2, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenNotBetween(String value1, String value2) {
            addCriterion("HIDDEN not between", value1, value2, "hidden");
            return (Criteria) this;
        }

        public Criteria andIsKeyIsNull() {
            addCriterion("IS_KEY is null");
            return (Criteria) this;
        }

        public Criteria andIsKeyIsNotNull() {
            addCriterion("IS_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andIsKeyEqualTo(String value) {
            addCriterion("IS_KEY =", value, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyNotEqualTo(String value) {
            addCriterion("IS_KEY <>", value, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyGreaterThan(String value) {
            addCriterion("IS_KEY >", value, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyGreaterThanOrEqualTo(String value) {
            addCriterion("IS_KEY >=", value, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyLessThan(String value) {
            addCriterion("IS_KEY <", value, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyLessThanOrEqualTo(String value) {
            addCriterion("IS_KEY <=", value, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyLike(String value) {
            addCriterion("IS_KEY like", value, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyNotLike(String value) {
            addCriterion("IS_KEY not like", value, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyIn(List<String> values) {
            addCriterion("IS_KEY in", values, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyNotIn(List<String> values) {
            addCriterion("IS_KEY not in", values, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyBetween(String value1, String value2) {
            addCriterion("IS_KEY between", value1, value2, "isKey");
            return (Criteria) this;
        }

        public Criteria andIsKeyNotBetween(String value1, String value2) {
            addCriterion("IS_KEY not between", value1, value2, "isKey");
            return (Criteria) this;
        }

        public Criteria andSubLengthIsNull() {
            addCriterion("SUB_LENGTH is null");
            return (Criteria) this;
        }

        public Criteria andSubLengthIsNotNull() {
            addCriterion("SUB_LENGTH is not null");
            return (Criteria) this;
        }

        public Criteria andSubLengthEqualTo(Short value) {
            addCriterion("SUB_LENGTH =", value, "subLength");
            return (Criteria) this;
        }

        public Criteria andSubLengthNotEqualTo(Short value) {
            addCriterion("SUB_LENGTH <>", value, "subLength");
            return (Criteria) this;
        }

        public Criteria andSubLengthGreaterThan(Short value) {
            addCriterion("SUB_LENGTH >", value, "subLength");
            return (Criteria) this;
        }

        public Criteria andSubLengthGreaterThanOrEqualTo(Short value) {
            addCriterion("SUB_LENGTH >=", value, "subLength");
            return (Criteria) this;
        }

        public Criteria andSubLengthLessThan(Short value) {
            addCriterion("SUB_LENGTH <", value, "subLength");
            return (Criteria) this;
        }

        public Criteria andSubLengthLessThanOrEqualTo(Short value) {
            addCriterion("SUB_LENGTH <=", value, "subLength");
            return (Criteria) this;
        }

        public Criteria andSubLengthIn(List<Short> values) {
            addCriterion("SUB_LENGTH in", values, "subLength");
            return (Criteria) this;
        }

        public Criteria andSubLengthNotIn(List<Short> values) {
            addCriterion("SUB_LENGTH not in", values, "subLength");
            return (Criteria) this;
        }

        public Criteria andSubLengthBetween(Short value1, Short value2) {
            addCriterion("SUB_LENGTH between", value1, value2, "subLength");
            return (Criteria) this;
        }

        public Criteria andSubLengthNotBetween(Short value1, Short value2) {
            addCriterion("SUB_LENGTH not between", value1, value2, "subLength");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table SYS_QUERY_FIELD
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
     * This class corresponds to the database table SYS_QUERY_FIELD
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