var Config = function(){
	var init = function(){
		//新增按钮
		List.addBt({
				text : '新增',
				iconCls : 'icon-add',
				handler : function() {
					toAdd();
				}

			});
			
		
	};
	var toAdd = function(){
		
		var url = WEB.ROOT + "/back/query/input.html";
		
		WEB.openWin({
			id:1,
			title:'新增自定义查询',
			width:900,
			height:500,
			url:url
		});
	
	}
	init();
	
	
}();