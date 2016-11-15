<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/content/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<%@ include file="/content/back/common/base.jsp"%>
<script type="text/javascript"
	src="${ctx}/content/common/lib/echarts3/echarts.js?date=<%= new java.util.Date() %>"></script>
<script type="text/javascript"
	src="${ctx}/content/gp/js/kLine.js?date=<%= new java.util.Date() %>"></script>
</head>
<body>
	<textarea rows="20" cols="60" id="option" style="display: none"></textarea>
	<table id="chartTable" style="width: 100%;">
		<!-- 
			<tr>
				<td>
					<div id="testDiv" style="height: 300px;width: 100%"></div>
				</td>
		</tr> -->
	</table>

</body>

</html>