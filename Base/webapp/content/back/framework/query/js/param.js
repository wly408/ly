var Param = function(){
	var init = function(){
		var config = {};
		config.id = "dg";
		config.title = "参数列表";
		config.pagination = false;// 不进行分页
		config.frozenColumns = [];
		config.toolbar = [];
		config.columns = [[{
			field : 'name',
			title : '参数名称',
			width : 80

		}, {
			field : 'formType',
			title : '表单元素',
			width : 80
		},{
			field : 'queryType',
			title : '查询类型',
			width : 80

		},{
			field : 'paramDef',
			title : '默认值',
			width : 80

		}, {
			field : 'op',
			title : '操作',
			width : 80,
			editor : {
				type : 'text'
			},
			formatter : function(value, row, index) {
				
				var str = '<a href="javascript:void(0)" onclick="Js.remove('
						+ index + ')"  class="easyui-linkbutton" >删除</a>';
				str += '<a href="javascript:void(0)" onclick="Js.sort('
						+ index + ',1)"  class="easyui-linkbutton" >↑</a>';
				str += '<a href="javascript:void(0)" onclick="Js.sort(' + index
						+ ',2)"  class="easyui-linkbutton" >↓</a>';

				return str;
			}
		}]];
		EasyuiUtil.grid(config);
		$('#dg').datagrid("addToolbarItem", [{
							text : '每行元素个数:<input type="text" />'
							//iconCls : 'icon-add'
						}]);
		$('#dg').datagrid("addToolbarItem", [{
							text : '新增参数',
							iconCls : 'icon-add',
							handler : function() {
								toInput();
							}

						}]);
	};
	//进入新增参数界面
	var toInput = function(obj){
		
		var url = WEB.ROOT + "/back/query/param/paramInput.html";
		var title = obj?'修改参数':'新增参数';
		var info = window.parent.frames['info'].document;
		var sql = $("#sql", info).val();

		if (Check.isEmpty(sql)) {
			WEB.error('请选填写SQL');
			return ;
		}
		url = WEB.setWinParam(url,"sql",sql);
	
		WEB.openWin({
			id:2,
			title:title,
			width:600,
			height:380,
			url:url,
			onClose:function(obj){
				alert(obj);
			}
		});
		
	};
	init();
	
	return {
		getParams:function(){
			
		}
	};
}();