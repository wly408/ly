$(function() {
			InfoBean.init();
		});
var InfoBean = {
	init:function(){
		InfoBean.initField();
		new Select({id:"formType",isAll:false,type:"SYS_QUERY_FORM_TYPE"});
		new Select({id:"queryType",isAll:false,type:"SYS_QUERY_QUERY_TYPE"});
		
		$("#commitBt").click(InfoBean.commit);
	},
	initField:function(){
		var sql = WEB.getWinParam("sql");
	
		
		var url = WEB.ROOT + "/back/query/doSql.ajax";
		WEB.ajax({
					data : JSON.stringify({
						'sql' : sql
					}),
					url : url,
					suc:function(data){
						
						if(data.rs=='1'){
						
							var tmps = data.data;
							var html = "";
							for(var i=0;i<tmps.length;i++){
								html+="<option value='"+tmps[i].columnName+"'>"+tmps[i].columnName+"</option>";
							}
							$("#paramField").html(html);
						}else{
							WEB.error(data.msg);
						}
						
					}
				});
	
	},
	commit:function(){
		var obj = {};
		obj.paramField = $("#paramField").val();
		obj.queryType = $("#queryType").val();
		obj.formType = $("#formType").val();
		obj.paramDef = $("#paramDef").val();
		obj.paramInputSql = $("#paramInputSql").val();
	
		WEB.close('',obj);
	}

};