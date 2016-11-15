<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/content/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<%@ include file="/content/back/common/base.jsp"%>

<script type="text/javascript"
	src="${ctx}/content/gp/js/gplist.js?date=<%= new java.util.Date() %>"></script>
</head>
<body class="easyui-layout" data-options="fit:true">
	<div data-options="region:'center',split:true,fit:true">
	
		<table id="grid" data-options="fit:true" >
			<!-- 
		 <thead>
            <tr>
                <th data-options="field:'studentid',width:100,align:'center'">学生学号</th>
                <th data-options="field:'name',width:100,align:'center'">姓名</th>
                <th data-options="field:'gender',width:100,align:'center'">性别</th>
                <th data-options="field:'age',width:100,align:'center'">年龄</th>
            </tr>
        </thead> -->
		</table>
	
</div>

</body>

</html>