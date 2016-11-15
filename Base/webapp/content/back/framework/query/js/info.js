var FieldBean = function(){
	this.width = "";
	this.field="";
	this.title="";
	this.subLength="";
	this.hidden = false;
	
};
var Info = function() {
	var fieldsMap = new Map();

	var init = function() {
		$("#do").click(doSql);
	};
	var Field = function(){
		return window.parent.window.frames['field'].Field;
	}; 
	var doSql = function() {
		if ($.trim($("#sql").val()) == '') {
			WEB.error('请填写SQL');
			return false;
		}
		
		var url = WEB.ROOT + "/back/query/doSql.ajax";
		WEB.ajax({
					data : JSON.stringify({
						'sql' : $("#sql").val()
					}),
					url : url,
					suc:function(data){
						
						if(data.rs=='1'){
						
							var tmps = data.data;
							for(var i=0;i<tmps.length;i++){
								var bean = new FieldBean();
								bean.field = tmps[i].columnName;
								fieldsMap.put(tmps[i].columnName,bean);
							}
							Field().initFields(fieldsMap)
						}else{
							WEB.alert(data.msg);
						}
						
					}
				});
	};

	init();

	return {
		/**
		 * 获取字段信息
		 */
		getFields : function() {
			return fields;
		}
	};
}();