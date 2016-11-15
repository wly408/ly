<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/content/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<%@ include file="/content/back/common/base.jsp"%>
<!-- 不能写到base.jsp中,因为WIN是对index.jsp里的窗口进行操作的，而其他地方是引用该对象 -->
<script type="text/javascript" src="${ctx}/content/back/common/jsutil/WIN.js?date=<%=new java.util.Date() %>"></script>

<script type="text/javascript" src="${ctx}/content/back/framework/home/js/index.js?date=<%=new java.util.Date() %>"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',split:true" style="height:80px;padding:10px;">
		<p>这是头部</p>
	</div>
	<div data-options="region:'south',split:false"  style="height:80px;padding:10px;background:#efefef;">
		这是底部
	</div>
	
	<div data-options="region:'west',split:true"  title="菜单导航" style="width:280px;padding1:1px;overflow:hidden;">
		<div class="easyui-accordion" data-options="fit:true,border:false" id="menuDiv">
			<!-- 
			<div title="Title1" style="padding:10px;overflow:auto;">
				<p>菜单管理</p>
				<p>content1</p>
				<p>content1</p>
				<p>content1</p>
				<p>content1</p>
				<p>content1</p>
				<p>content1</p>
				<p>content12</p>
			</div> 
			<div title="Title2" data-options="selected:true" style="padding:10px;">
				content2
			</div>
			<div title="Title3" style="padding:10px">
			
			</div> -->
		</div>
	</div>
	<div data-options="region:'center'"  style="overflow:hidden;">
		<div id="tabParent" class="easyui-tabs" data-options="fit:true,border:false" >
			<div title="首页" style="overflow:hidden;" data-options="fit:true" > 
				<fieldset style="">欢迎您......</fieldset>
			</div>
			<!-- 
			<div title="Tab2" data-options="closable:true" style="padding:20px;">This is Tab2 width close button.</div>
			<div title="Tab3" data-options="iconCls:'icon-reload',closable:true" style="overflow:hidden;padding:5px;">
				<table id="tt2"></table> 
			</div> -->
		</div>
	</div>
	
	<div id="globalModalWindow1" class="easyui-window" title="全局操作窗口" minimizable="false" collapsible="false" closed="true"
     iconCls="icon-edit" inline="false" modal="true" shadow="false"
     style="width:500px;height:400px;padding:5px;background: #fafafa;overflow:hidden">
    <div class="easyui-layout" fit="true">
        <div region="center" border="false" style="padding:0px;background:#fff;border:0px solid #ccc;overflow:hidden">
            <iframe src="about:blank" style="width:100%;height:100%;" frameborder="0" id="globalModalFrm1"></iframe>
        </div>
    </div>
</div>

<div id="globalModalWindow2" class="easyui-window" title="全局操作窗口2" minimizable="false" collapsible="false" closed="true"
     iconCls="icon-edit" inline="false" modal="true" shadow="false"
     style="width:500px;height:400px;padding:5px;background: #fafafa;overflow:hidden">
    <div class="easyui-layout" fit="true">
        <div region="center" border="false" style="padding:0px;background:#fff;border:0px solid #ccc;overflow:hidden">
            <iframe src="about:blank" style="width:100%;height:100%;" frameborder="0" id="globalModalFrm2"></iframe>
        </div>
    </div>
</div>

<div id="globalModalWindow3" class="easyui-window" title="全局操作窗口3" minimizable="false" collapsible="false" closed="true"
     iconCls="icon-edit" inline="false" modal="true" shadow="false"
     style="width:500px;height:400px;padding:5px;background: #fafafa;overflow:hidden">
    <div class="easyui-layout" fit="true">
        <div region="center" border="false" style="padding:0px;background:#fff;border:0px solid #ccc;overflow:hidden">
            <iframe src="about:blank" style="width:100%;height:100%;" frameborder="0" id="globalModalFrm3"></iframe>
        </div>
    </div>
</div>
</body>
<script>
//$(function(){
	
//});
/*
	$(document).ready(function(){
		EasyuiUtil.addTab({"tabsId":"tabParent",
			"tabName":"新TAB"});
	});

*/
	
</script>
</html>