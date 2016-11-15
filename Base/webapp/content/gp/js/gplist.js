$(function() {
			InfoBean.init();
		});
var InfoBean = {
	init : function() {
		InfoBean.initGrid();
	},
	columns:[[{
						field : 'code',
						title : '代码',
						width : 80
					}, {
						field : 'shortName',
						title : '股票名称',
						width : 120
					}, {
						field : 'stype',
						title : '标识类型',
						width : 80,
						align : 'right'
					}, {
						field : 'remark',
						title : '备注',
						width : 120,
						align : 'right'
					}, {
						field : 'createTime',
						title : '创建时间',
						width : 80,
						align : 'center'
					}]],
	
	toolbar : [{
				text : '股票基本数据采集',
				iconCls : 'icon-add',
				handler : function() {
					InfoBean.collInfoData();
				}

			},'-', {
				text : '股票日明细数据采集',
				iconCls : 'icon-add',
				handler : function() {
					InfoBean.collDetailData();
				}

			},'-', {
				text : 'K线',
				iconCls : 'icon-add',
				handler : function() {
					InfoBean.kLine();
				}

			}, '-', {
				text : '修改',
				iconCls : 'icon-edit',
				handler : function() {

				}
			}, '-', {
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {

				}
			}],
			initGrid : function() {
		var url = WEB.ROOT + "/gp/info/queryList.ajax";
		
		var config = {};
		config.id="grid";
		config.url = url;
		$.extend(config,InfoBean);//将InfoBean覆盖到config
		EasyuiUtil.grid(config);
		$('#grid').datagrid('getPager'); 

	},
	toAdd : function() {
		var url = WEB.ROOT + "/sysUser/toAdd.action";
		WEB.openWin({
					id : 1,
					width : 600,
					height : 300,
					url : url
				});
	},
	kLine:function(){
		var url = WEB.ROOT + "/gp/info//kLine.html";
		WEB.openWin({
					id : 1,
					width : $(window.parent).width(),
					height : $(window.parent).height(),
					left:0,
					top:0,
					url : url
				});
	},
	collInfoData : function() {
		var url = WEB.ROOT + "/gp/info/collInfoData.ajax";
		
		WEB.ajax({
					type : 'POST',
			
					"url" : url,
					"suc" : function(data) {
						WEB.alert(data.msg);
						 $('#grid').datagrid('reload');  
					},
					"issyn" : false
				});
	},
	collDetailData : function() {
		var url = WEB.ROOT + "/gp/info/collDetailData.ajax";
		
		WEB.ajax({
					type : 'POST',
			
					"url" : url,
					"suc" : function(data) {
						WEB.alert(data.msg);
						 $('#grid').datagrid('reload');  
					},
					"issyn" : false
				});
	}

};