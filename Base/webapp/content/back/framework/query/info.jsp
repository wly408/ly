<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/content/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<%@ include file="/content/back/common/base.jsp"%>
</head>
<body>

	<div class="easyui-panel" title="" data-options="fit:true"
		style="width:600PX;padding-top: 0px">
		<div style="padding:0px 0px 0px 0px">

			<table cellpadding="5">
				<tr>
					<td>名称:</td>
					<td><input class="easyui-textbox" type="text" name="name"
						id="name" style="width: 240px"></input></td>
					<td>分页条数:</td>
					<td><input class="easyui-textbox" type="text" name="pageSize"
						id="pageSize" style="width: 240px"></input></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>SQL:</td>
					<td colspan="3"><textarea ID="sql" rows="14" cols="85"></textarea>
					</td>
					<td><a style="vertical-align: middle;"
						href="javascript:void(0)" class="easyui-linkbutton" id="do">执行</a>
					</td>
				</tr>
				<tr>
					<td>复选框:</td>
					<td><select id="singleSelect" class="easyui-combobox" name="singleSelect" editable="false"
						style="width:240px;">
							<option value="2">复选</option>
							<option value="1">单选</option>
							<option value="0">不显示</option>
					</select></td>
					<td>是否有工具栏:</td>
					<td><select id="isToolbar" class="easyui-combobox" name="isToolbar" editable="false"
						style="width:240px;">
							<option value="1">是</option>
							<option value="0">否</option>
							
					</select></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>备注:</td>
					<td colspan="4"><textarea id="remark" rows="5" cols="85"></textarea>
					</td>
				</tr>

			</table>


		</div>
	</div>
	<script type="text/javascript"
		src="${ctx}/content/back/framework/query/js/info.js?date=<%=new java.util.Date() %>"></script>
</body>
</html>