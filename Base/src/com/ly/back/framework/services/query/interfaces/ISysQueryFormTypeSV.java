package com.ly.back.framework.services.query.interfaces;

import java.util.List;

import com.ly.back.framework.mybatis.model.sys.SysQueryFormType;

public interface ISysQueryFormTypeSV {

	List<SysQueryFormType> getFormTypes();

}
