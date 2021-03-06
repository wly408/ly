package com.ly.back.framework.mybatis.mapper.sys;

import com.ly.back.framework.mybatis.model.sys.SysQueryParamQueryType;
import com.ly.back.framework.mybatis.model.sys.SysQueryParamQueryTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysQueryParamQueryTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM_QUERY_TYPE
     *
     * @mbggenerated
     */
    int countByExample(SysQueryParamQueryTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM_QUERY_TYPE
     *
     * @mbggenerated
     */
    int deleteByExample(SysQueryParamQueryTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM_QUERY_TYPE
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM_QUERY_TYPE
     *
     * @mbggenerated
     */
    int insert(SysQueryParamQueryType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM_QUERY_TYPE
     *
     * @mbggenerated
     */
    int insertSelective(SysQueryParamQueryType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM_QUERY_TYPE
     *
     * @mbggenerated
     */
    List<SysQueryParamQueryType> selectByExampleWithRowbounds(SysQueryParamQueryTypeExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM_QUERY_TYPE
     *
     * @mbggenerated
     */
    List<SysQueryParamQueryType> selectByExample(SysQueryParamQueryTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM_QUERY_TYPE
     *
     * @mbggenerated
     */
    SysQueryParamQueryType selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM_QUERY_TYPE
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysQueryParamQueryType record, @Param("example") SysQueryParamQueryTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM_QUERY_TYPE
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysQueryParamQueryType record, @Param("example") SysQueryParamQueryTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM_QUERY_TYPE
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysQueryParamQueryType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM_QUERY_TYPE
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysQueryParamQueryType record);
}