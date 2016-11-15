package com.ly.common.service.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public interface IJdbcDao {
	
	public JdbcTemplate getJdbcTemplate();
	/**
	 * 获取当前的总条数。
	 * 
	 * @param sql
	 *            原始SQL语句
	 * @param params
	 *            参数列表
	 * @return 条数
	 */
	public abstract int jdbcGetSize(final String sql, final List<Object> params);

	/**
	 * 查询列表数据。
	 * 
	 * @param <E>
	 *            数据对象
	 * @param sql
	 *            查询语句
	 * @param params
	 *            查询参数
	 * @param elementType
	 *            对象类型
	 * @return 列表数据
	 */
	public abstract <E> List<E> jdbcFindList(String sql, List<Object> params,
			Class<E> elementType);
	/**
	 * 统计
	 * @param sql
	 * @param params
	 * @return
	 */
	public int getCout(final String sql, final List<Object> params);
	
	public abstract boolean excute(String sql, List<Object> params);
	
	
	
	
	public List<Map<String, Object>> jdbcQueryForList(String sql);
	public List<Map<String, Object>> jdbcQueryForList(String sql,List<Object> params);

	public void excuteBatch(String sql,List<Object[]> params);

}
