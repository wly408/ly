var Select = function(option){
	var id = option.id;
	var isAll = option.isAll;
	var defVal = option.defVal;
	var suc = option.suc;
	var type = option.type;
	
	var init = function(){
		var url = WEB.ROOT+"/back/simplData/getSimplData.ajax?type="+type;
		
		WEB.ajax({
			url:url,
			suc:function(data){
				if(data.rs==1){
					var html = "";
					if(isAll){
						html+="<option value='0' title='请选择'>请选择</option>";
					}
					
					for(var i=0,length=data.data.length;i<length;i++){
						var option = data.data[i];
						var value = option.value;
						var name = option.name;
						var title = option.title;
						html+="<option value='"+value+"' ";
						if($.trim(title)!=''){
							html+=" title='"+title+"'";
						}
						
						html+=">"+name+"</option>";
					}
					
					$("#"+id).html(html);
					if(defVal){
						$("#"+id).val(defVal);
					}
					if(suc){
						suc(data);
					}
				}else{
					WEB.error(data.msg);
				}
				
			}
		});
	
	}();
	
};