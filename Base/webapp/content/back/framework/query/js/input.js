$(function() {
			Input.init();
		});
var Input = {
	init : function() {
		$('#tabParent').tabs({ 
		　　width: $("#tabParent").parent().width(), 
		　　height: "auto" 
		}); 
		$("#commitBt").click(Input.commit);
	},
	commit : function() {
		var commitBean = Input.check();
		if(commitBean!=null){
			
		}
	},
	check : function() {
		var obj = null;
		var info = window.frames['info'].document;

		var name = $("#name", info).val();

		if (Check.isEmpty(name)) {
			WEB.error('名称不能为空');
			return null;
		}
		if (!Check.checkLength(name, 100)) {
			WEB.error('名称长度不可超过100个字符');
			return null;
		}
		var pageSize = $("#pageSize", info).val();
		if(!Check.isEmpty(pageSize)&&!Check.checkIntPo(pageSize)){
        		 WEB.error('分页条数必须是正整数');
				return null;
        	}
		var sql = $("#sql", info).val();

		if (Check.isEmpty(sql)) {
			WEB.error('sql不能为空');
			return null;
		}
		var remark = $("#remark", info).val();
		if (!Check.isEmpty(remark)) {
			if (!Check.checkLength(remark, 1000)) {
				WEB.error('名称长度不可超过1000个字符');
				return null;
			}
		}
		
	
		
		var field = window.frames['field'].document;

		var fieldsMap =window.frames['field'].Field.getFieldMap();
		if (fieldsMap.isEmpty()) {
			    WEB.error('请配置列表信息');
				return null;
		}
		//校验标题必须填写
		var fieldArray = [];
		for ( var key in fieldsMap.entrySet) {
        	var fieldBean =  fieldsMap.get(key); 
        	var title = fieldBean.title;
        	var width = fieldBean.width;
        	var subLength = fieldBean.subLength;
        	if(Check.isEmpty(title)){
        		 WEB.error('标题不能为空');
				return null;
        	}
        	if(!Check.checkLength(title,100)){
        		 WEB.error('标题不能超过100个字符');
				return null;
        	}
        	if(!Check.isEmpty(width)&&!Check.checkIntPo(width)){
        		 WEB.error('标题宽度必须是正整数');
				return null;
        	}
        	if(!Check.isEmpty(subLength)&&!Check.checkIntPo(subLength)){
        		 WEB.error('截取长度必须是正整数');
				return null;
        	}
        	fieldArray.push(fieldBean)
        };
        //外部JS
        var js = window.frames['js'].document;
        var jsArray = window.frames['field'].Js.getJs();
		obj = {};
		obj.name = name;
		obj.remark = remark;
		obj.sql = sql;
		obj.pageSize = pageSize;
		obj.singleSelect =  $("#singleSelect").val();
		obj.isToolbar = $("#isToolbar").val();
		obj.fieldStr = JSON.stringify(fieldArray);//列表字段信息，字符串
		obj.jsStr = JSON.stringify(jsArray);//js
		
		return obj;
	}

};