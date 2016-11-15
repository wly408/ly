<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/content/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<%@ include file="/content/back/common/base.jsp"%>
<link type="text/css" rel="stylesheet"
	href="${ctx}/content/back/framework/query/css/gridtable.css"></link>
</head>
<body data-options="fit:true">
	<table id="dg" width="100%" border="0" cellspacing="0" cellpadding="0" class="gridtable">

		<tr>
			<th>字段</th>
			<th>标题</th>
			<th>宽度</th>
			<th>截取字符长度</th>
			<th>是否隐藏</th>
			
			<th>操作<a id="emptyBt" class="easyui-linkbutton" style="vertical-align: middle;" href="javascript:void(0)" >清空</a></th>
		</tr>
		

	</table>
	
</body>
</html>
<script type="text/javascript"
		src="${ctx}/content/back/framework/query/js/field.js?date=<%=new java.util.Date() %>"></script>