<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/content/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<%@ include file="/content/back/common/base.jsp"%>
<script type="text/javascript"
	src="${ctx}/content/back/framework/query/js/param-input.js?date=<%=new java.util.Date() %>"></script>
</head>
<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		class="xbox">
		<tr>
			<td class="label" nowrap>对应字段:</td>
			<td class="content"><select id="paramField" style="width: 170px"></select></td>
			<td class="label" nowrap>查询类型:</td>
			<td class="content"><select id="queryType" style="width: 170px"></select></td>
		</tr>
		<tr>
			<td class="label" nowrap>页面元素类型:</td>
			<td class="content"><select id="formType" style="width: 170px"></select>
			</td>
			<td class="label" nowrap>默认值:</td>
			<td class="content"><input type="text"
				id="paramDef" /></td>
		</tr>
		<tr>
			<td class="label" nowrap>值来源SQL:</td>
			<td class="content" colspan="3"><textarea rows="5" cols="62" id="paramInputSql"></textarea>
			</td>
		</tr>
		<tr>

			<td class="label" nowrap>是否必填:</td>
			<td class="content" colspan="3">是<input type="radio" value="1"
				name="required" /> 否<input type="radio" value="0" name="required"
				checked="checked" />
			</td>
		</tr>
		<tr>
			<td class="label" nowrap>备注:</td>
			<td class="content" colspan="3"><textarea rows="5" cols="62"></textarea></td>

		</tr>
		<tr>

		</tr>
	</table>

	<div class="op">
		<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
			href="javascript:void(0)" id="commitBt">确定</a> <a
			class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
			href="javascript:void(0)" onclick="javascript:WEB.close()">取消</a>
	</div>




</body>
</html>