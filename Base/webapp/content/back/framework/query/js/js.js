var Js = function() {
	var data = new Map();
	var init = function() {
		var config = {};
		config.id = "dg";
		config.title = "外部JS列表";
		config.toolbar = [];
		config.pagination = false;// 不进行分页
		config.frozenColumns = [];
		config.columns = [[{
			field : 'jsPath',
			title : 'JS路径',
			width : 130,

			formatter : function(value, row, index) {

				return '<input id="jsPath_' + row.id
						+ '" type="text" style="width: 300px" value="' + value
						+ '"/> ';
			}

		}, {
			field : 'remark',
			title : '说明',
			width : 100,

			formatter : function(value, row, index) {

				return '<input id="remark_' + row.id
						+ '" type="text" style="width: 300px" value="' + value
						+ '"/> ';
			}
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
							text : '新增',
							iconCls : 'icon-add',
							handler : function() {
								addRow();
							}

						}]);
	};
	var addRow = function() {
		var size = data.size();// map的长度
		var id = size == 0 ? 1 : size + 1;
		var row = {
			id : id,
			jsPath : '',
			remark : '',
			op : ''
		};

		$('#dg').datagrid('appendRow', row);
		$("a[class='easyui-linkbutton']").linkbutton();
		data.put(id, row);

	};
	init();
	return {
		getJs:function(){
			var jsPaths = $("input[id^='jsPath_']");

				for (var i = 0; i < jsPaths.length; i++) {
					var idTemp = $(jsPaths[i]).attr('id');
					idTemp = idTemp.substring(idTemp.indexOf("_") + 1);

				if (data.containsKey(idTemp)) {
					data.get(idTemp).jsPath = $(jsPaths[i]).val();
					data.get(idTemp).remark = $("remark_"+idTemp).val();
					
				}
			}
			var dataArray = [];// 将map转array
				for (var key in data.entrySet) {
					dataArray.push(data.get(key));
				}
			return dataArray;
			
		},
		remove : function(index) {

			$('#dg').datagrid('deleteRow', index);
			
			Js.reloadData();

		},
		sort : function(index, type) {
			//重新赋值
			var jsPaths = $("input[id^='jsPath_']");

				for (var i = 0; i < jsPaths.length; i++) {
					var idTemp = $(jsPaths[i]).attr('id');
					idTemp = idTemp.substring(idTemp.indexOf("_") + 1);
	
					if (data.containsKey(idTemp)) {
						data.get(idTemp).jsPath = $(jsPaths[i]).val();
						data.get(idTemp).remark = $("remark_"+idTemp).val();
					}
				}
			index = index + "";
			
			var row = data.get((parseInt(index)+1)+"");
	
			if (type == 1) {
				if (index == 0) {
					return;
				}
				
				var nextId = (parseInt(index)+1- 1) + "";
				// 将两个元素对调
				var nextRow = data.get(nextId);
				data.put((parseInt(index)+1)+"", nextRow);
				data.put(nextId+"", row);
				
				// 刷新DATA
				var count = 1;
				var newData = new Map();
				for (var key in data.entrySet) {
					var id = count++;
					data.get(key).id = id;
					newData.put(id, data.get(key));
				}
				
			
				data = newData;
				var dataArray = [];// 将map转array
				for (var key in newData.entrySet) {
					dataArray.push(newData.get(key));
				}
			
				$('#dg').datagrid("loadData", dataArray);
				$("a[class='easyui-linkbutton']").linkbutton();

			}else {
				if (index == data.size()-1) {
					return;
				}
				var nextId = (parseInt(index)+1+1) + "";
				// 将两个元素对调
				var nextRow = data.get(nextId);
				data.put((parseInt(index)+1)+"", nextRow);
				data.put(nextId+"", row);
				
				// 刷新DATA
				var count = 1;
				var newData = new Map();
				for (var key in data.entrySet) {
					var id = count++;
					data.get(key).id = id;
					newData.put(id, data.get(key));
				}
				
			
				data = newData;
				var dataArray = [];// 将map转array
				for (var key in newData.entrySet) {
					dataArray.push(newData.get(key));
				}
			
				$('#dg').datagrid("loadData", dataArray);
				$("a[class='easyui-linkbutton']").linkbutton();
			}
		},
		
		reloadData : function() {
			var jsPaths = $("input[id^='jsPath_']");

			for (var i = 0; i < jsPaths.length; i++) {
				var id = $(jsPaths[i]).attr('id');
				id = id.substring(id.indexOf("_") + 1);

				if (data.containsKey(id)) {
					data.get(id).jsPath = $(jsPaths[i]).val();
					data.get(id).remark = $("remark_"+id).val();
				}
			}
			// 不存在，则remove
			for (var key in data.entrySet) {
				var isExit = false;
				for (var i = 0; i < jsPaths.length; i++) {
					var id = $(jsPaths[i]).attr('id');
					id = id.substring(id.indexOf("_") + 1);
					if (key == id) {
						isExit = true;
						break;
					}
				}
				if (!isExit) {
					data.remove(key);
				}
			}
			// 刷新DATA
			var count = 1;
			var newData = new Map();
			for (var key in data.entrySet) {
				var id = count++;
					data.get(key).id = id;
					newData.put(id, data.get(key));
			}
			data = newData;
			var dataArray = [];// 将map转array
			for (var key in newData.entrySet) {
				dataArray.push(newData.get(key));
			}

			$('#dg').datagrid("loadData", dataArray);
			$("a[class='easyui-linkbutton']").linkbutton();
		}
	};
}();