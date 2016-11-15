package com.ly.common.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ly.common.service.interfaces.IJdbcDao;

@Repository("jdbcDao")
class JdbcDaoImpl implements IJdbcDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public <E> List<E> jdbcFindList(String sql, List<Object> params,
			Class<E> elementType) {
		
		if(params==null){
			params = new ArrayList<Object>();
		}
		RowMapper<E> rowMapper = BeanPropertyRowMapper.newInstance(elementType);

		return this.jdbcTemplate.query(sql, params.toArray(), rowMapper);
	}

	@Override
	public int jdbcGetSize(String sql, List<Object> params) {
		sql = getTotalCountSql(sql);
		Object[] objs = null;
		if(params!=null){
			objs = params.toArray();
		}
		Map<String, Object> count = this.jdbcTemplate.queryForMap(sql,
				objs);
		if (count != null && !count.isEmpty()) {
			return Integer.parseInt(count.get("value").toString());
		}
		return 0;
	}

	/**
	 * 构造总条数SQL语句。
	 * 
	 * @param sql
	 *            原始SQL语句
	 * @return 总条数SQL语句
	 */
	private String getTotalCountSql(final String sql) {
		final StringBuffer buffer = new StringBuffer();
		buffer.append("select count(*) as value from (").append(sql)
				.append(") act");
		return buffer.toString();
	}

	@Override
	public boolean excute(String sql, List<Object> params) {
		Object[] paramArray = new Object[] {};
		if (params != null && !params.isEmpty()) {
			paramArray = params.toArray();
		}
		return this.jdbcTemplate.update(sql, paramArray) > 0;
	}
	

	@Override
	public int getCout(String sql, List<Object> params) {
		Map<String, Object> count = this.jdbcTemplate.queryForMap(sql,
				params.toArray());
		if (count != null && !count.isEmpty()) {
			return Integer.parseInt(count.get("value").toString());
		}
		return 0;
	}



	@Override
	public List<Map<String, Object>> jdbcQueryForList(String sql) {
		
		return this.jdbcTemplate.queryForList(sql);
	}

	@Override
	public void excuteBatch(String sql, List<Object[]> params) {
		this.jdbcTemplate.batchUpdate(sql, params);
	}

	@Override
	public List<Map<String, Object>> jdbcQueryForList(String sql,
			List<Object> params) {
		Object[] objs = null;
		if(params!=null){
			objs = params.toArray();
		}
		return this.jdbcTemplate.queryForList(sql, objs);
	}
}
