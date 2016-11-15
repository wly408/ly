package com.ly.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ly.common.service.interfaces.IJdbcDao;

public abstract class BaseSV {
	
	@Autowired
	private IJdbcDao jdbcDao;

	public IJdbcDao getJdbcDao() {
		return jdbcDao;
	}

}
