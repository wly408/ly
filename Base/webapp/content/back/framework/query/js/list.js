var List = function() {
	var init = function() {
		getFileds();
//		$("#listTd").height(350);
		//计算高度
		var info = getQueryInfo();
		var isToolbar = info.isToolbar;
		var toolbar = null;
		if('1'==isToolbar){
			toolbar = [];
		}
		var config = {};
		var singleSelect = info.singleSelect;
		if('0'==singleSelect){
			config.frozenColumns = [];
		}else{
			config.singleSelect="1"==singleSelect?true:false;
		}
		//分页
		var pageSize = info.pageSize;
		if(Check.isEmpty(pageSize)){
			config.pagination=false;
		}else{
			config.pageSize=pageSize;
		}
		
		config.id = "grid";
		config.toolbar = toolbar;
		config.columns = columns;
		config.url = WEB.ROOT + "/back/query/queryList.ajax?queryId="
				+ $("#queryId").val();
		//alert(JSON.stringify(config));
		EasyuiUtil.grid(config);
	};
	var query = function() {

	};
	var reset = function() {

	};

	var getQueryInfo = function() {
		var info = {};
		var url = WEB.ROOT + "/back/query/getQueryInfo.ajax?queryId="
				+ $("#queryId").val();
		WEB.ajax({
					url : url,
					issyn : true,
					suc : function(data) {
						if (data.rs == '1') {
							info = data.data;
						} else {
							WEB.error(data.msg);
						}

					}
				});
		return info;

	};

	var columns = [];
	var getFileds = function() {
		var url = WEB.ROOT + "/back/query/getFields.ajax?queryId="
				+ $("#queryId").val();
		WEB.ajax({

			url : url,
			issyn : true,
			suc : function(data) {
				if (data.rs == '1') {
					var len = data.data.length;
					for (var i = 0; i < len; i++) {
						data.data[i].hidden = data.data[i].hidden == '1';
						var subLength = data.data[i].subLength;
						if (subLength != null && $.trim(subLength) != ''
								&& parseInt(subLength) > 0) {
							data.data[i].formatter = function(value, row, index) {
								var title = value;
								var valueTmp = value;
								if (value.length > parseInt(subLength)) {
									valueTmp = value.substring(0,
											parseInt(subLength));
								}
								return "<span title='" + title + "'>"
										+ valueTmp + "</span>"

							}

						}
					}

					columns.push(data.data);

				} else {
					WEB.alert(data.msg);
				}
			}
		});
	};
	init();

	return {
		addBt : function(bt) {

			// 新增按钮
			// $('#grid').datagrid({
			// toolbar:bts
			// });
			$('#grid').datagrid("addToolbarItem", [bt])

		},
		dbClickRow : function() {

		},
		getSelectedRows : function() {

		}
	};
}();