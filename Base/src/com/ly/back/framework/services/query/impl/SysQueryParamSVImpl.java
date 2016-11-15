package com.ly.back.framework.services.query.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.back.framework.mybatis.mapper.sys.SysQueryParamMapper;
import com.ly.back.framework.searchmodel.query.FieldBean;
import com.ly.back.framework.searchmodel.query.SysQueryParamSearchModel;
import com.ly.back.framework.services.query.interfaces.ISysQueryParamSV;
import com.ly.common.db.DBCtrl;
import com.ly.common.service.impl.BaseSV;
@Service("sysQueryParamSV")
public class SysQueryParamSVImpl extends BaseSV implements ISysQueryParamSV{
	@Autowired
	private SysQueryParamMapper paramMapper;

	@Override
	public List<SysQueryParamSearchModel> getParams(String queryId) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT A.*,B.NAME AS QUERY_TYPE_NAME,B.CODE AS QUERY_TYPE_CODE,");
		sql.append(" C.NAME AS FORM_TYPE_NAME FROM SYS_QUERY_PARAM A INNER");
		sql.append(" JOIN SYS_QUERY_PARAM_QUERY_TYPE B ON A.QUERY_TYPE=B.ID");
		sql.append(" INNER JOIN SYS_QUERY_FORM_TYPE C ON A.FROM_TYPE=C.ID WHERE 1=1 AND A.QUERY_ID=?");
			
		List<Object> params = new ArrayList<Object>();
		params.add(queryId);
		return this.getJdbcDao().jdbcFindList(sql.toString(), params, SysQueryParamSearchModel.class);
	}

	@Override
	public List<FieldBean> doSql(String sql) throws Exception {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<FieldBean> list = new ArrayList<FieldBean>();
		try{
			con = this.getJdbcDao().getJdbcTemplate().getDataSource().getConnection();
			st = con.createStatement();
			rs = st.executeQuery(DBCtrl.getSimplSql(sql));
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			for (int i = 1; i <=columnCount; i++) {
				FieldBean bean = new FieldBean();
				
				bean.setColumnName(metaData.getColumnName(i));
				bean.setColumnLabel(metaData.getColumnLabel(i));
				
				list.add(bean);
			}
		}finally{
			DBCtrl.closeCon(con, st, rs);
		}
		
		return list;
	}

}
