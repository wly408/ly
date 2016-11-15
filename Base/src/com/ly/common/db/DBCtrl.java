package com.ly.common.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author wly
 *
 */
public class DBCtrl {
	

	public static void closeCon(Connection con,Statement st,ResultSet rs) throws SQLException{
		if(rs!=null)
		{
			rs.close();
		}
		if(st!=null)
		{
			st.close();
		}
		if(con!=null)
		{
			con.close();
		}
	}
	
	public static void closeCon(Connection con,CallableStatement ctmt,ResultSet rs) throws SQLException
	{
		if(rs!=null)
		{
			rs.close();
		}
		if(ctmt!=null)
		{
			ctmt.close();
		}
		if(con!=null)
		{
			con.close();
		}
	}
	public static final String getSimplSql(String sql){ 
		
		sql = sql.toUpperCase();
		//判断是否有两个where ,如果只有一个,则直接截取到where 1=2
//		String temp = sql;
//		int index = temp.indexOf("WHERE");
//		if(index<0){
//			return sql+" WHERE 1=2";
//		}
//		int index2 = temp.lastIndexOf("WHERE");
//		if(index2==index){
//			return sql.substring(0,index2)+" WHERE 1=2";
//		}
//		index = sql.indexOf("?");
//		if(index<0){
//			return "SELECT * FROM ("+sql+") WHERE 1=2";
//		}
		//下面是变量绑定的情况
//		String[] array = sql.split("?");
		sql = sql.replace("?", "'1'");
		sql = "SELECT * FROM ("+sql+") WHERE 1=2";
		
		return sql;
	}
	public static void main(String[] args) {
		System.out.println(getSimplSql("select * FROM  SYS_QUERY A INNER JOIN SYS_QUERY_JS B ON A.ID=B.QUERY_ID AND A.ID IN (SELECT T.QUERY_ID FROM SYS_QUERY_PARAM T WHERE T.QUERY_ID=?) AND A.NAME=? AND A.CREATE_TIME=TO_DATE(?,'YYYY')"));
	}
	
}
