package com.ly.back.framework.mybatis.mapper.sys;

import com.ly.back.framework.mybatis.model.sys.SysQueryParam;
import com.ly.back.framework.mybatis.model.sys.SysQueryParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysQueryParamMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM
     *
     * @mbggenerated
     */
    int countByExample(SysQueryParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM
     *
     * @mbggenerated
     */
    int deleteByExample(SysQueryParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM
     *
     * @mbggenerated
     */
    int insert(SysQueryParam record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM
     *
     * @mbggenerated
     */
    int insertSelective(SysQueryParam record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM
     *
     * @mbggenerated
     */
    List<SysQueryParam> selectByExampleWithRowbounds(SysQueryParamExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM
     *
     * @mbggenerated
     */
    List<SysQueryParam> selectByExample(SysQueryParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM
     *
     * @mbggenerated
     */
    SysQueryParam selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysQueryParam record, @Param("example") SysQueryParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysQueryParam record, @Param("example") SysQueryParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysQueryParam record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_QUERY_PARAM
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysQueryParam record);
}