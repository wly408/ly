<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/content/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<%@ include file="/content/back/common/base.jsp"%>

<script type="text/javascript"
	src="${ctx}/content/back/common/jsutil/WIN.js"></script>
	<script type="text/javascript"
	src="${ctx}/content/back/framework/query/js/input.js?date=<%=new java.util.Date() %>"></script>
</head>
<body class="easyui-layout" data-options="fit:true">
	<div data-options="region:'center',fit:true" style="overflow:hidden;">

		<div id="tabParent" class="easyui-tabs"
			data-options="fit:true,border:false">

			<div title="基本信息" data-options="closable:false" style="padding:5px;">
				<iframe width="100%" height="100%" id="info" name="info" src="${ctx}/back/query/info.html"
					style="border: 0px;"></iframe>
			</div>
			<div title="列表信息" data-options="closable:false"
				style="overflow:hidden;padding:5px;">
				<iframe width="100%" height="100%"
					src="${ctx}/back/query/field.html" name="field" id="field"
					style="border: 0px;"></iframe>
			</div>
			<div title="查询条件" data-options="closable:false"
				style="overflow:hidden;padding:5px;">
				<iframe width="100%" height="94%"
					src="${ctx}/back/query/param/param.html" name="param" id="param"
					style="border: 0px;"></iframe>
				</div>
			<div title="外部JS" data-options="closable:false"
				style="overflow:hidden;padding:5px;">
				<iframe width="100%" height="94%"
					src="${ctx}/back/query/js.html" name="js" id="js"
					style="border: 0px;"></iframe>

			</div>
			<div title="javabean属性" data-options="closable:false"
				style="overflow:hidden;padding:5px;">This is Tab4 width close
				button.</div>

		</div>
	</div>
	<div data-options="region:'south',border:false"
		style="text-align:right;padding-right: -20px;">
		<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
			href="javascript:void(0)" id="commitBt"
			style="width:80px">确定</a> <a class="easyui-linkbutton"
			data-options="iconCls:'icon-cancel'" href="javascript:void(0)"
			onclick="javascript:WIN.close('1')" style="width:80px">取消</a>
	</div>

</body>

</html>
