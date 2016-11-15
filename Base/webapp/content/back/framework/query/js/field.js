var Field = function() {
	var fieldsMap = new Map();// 用map记录数据

	var init = function() {
			
		// $('#dg').datagrid();
		$("#emptyBt").click(function(){
			fieldsMap = new Map();
			initGrid();
		});
	};
	var reshMap = function() {
		var trs = $('#dg tr').eq(0).nextAll();
		var tempMap = new Map();
		for(var i=0;i<trs.length;i++){
			var bean = {};
			 var field = $(trs[i]).find('td').eq(0).find('select').eq(0).val();
			 var title =  $(trs[i]).find('td').eq(1).find('input').eq(0).val();
			 var width =  $(trs[i]).find('td').eq(2).find('input').eq(0).val();
			 var subLength = $(trs[i]).find('td').eq(3).find('input').eq(0).val();
			 var hidden = $(trs[i]).find('td').eq(4).find('select').eq(0).val();
			 bean.field = field;
			 bean.title = title;
			 bean.width = width;
			
			 bean.subLength = subLength;
			 bean.hidden = hidden;
			 tempMap.put(field,bean);
		}

		fieldsMap = tempMap;
	};
	var initGrid = function() {
		
		
		$('#dg tr').eq(0).nextAll().remove();
		var html = "";
		for (var key in fieldsMap.entrySet) {
			var bean = fieldsMap.get(key);

			html += '<tr id="'+key+'">';
			html += '<td>';
			html += '<select>';
			for (var key2 in fieldsMap.entrySet) {
				html += '<option ' + (key == key2 ? 'selected="selected"' : '')
						+ '>' + fieldsMap.get(key2).field + '</option>'
			}
			html += '</select>';
			html += '</td>';
			html += '<td>';
			html += '<input type="text" value="'+bean.title+'"/>';
			html += '</td>';
			html += '<td>';
			html += '<input type="text" value="'+bean.width+'" style="width:80px"/>';
			html += '</td>';
			html += '<td>';
			html += '<input type="text" value="'+bean.subLength+'" style="width:80px"/>';
			html += '</td>';
			html += '<td>';
			
			if(bean.hidden=='1'){
				html += '<select ><option value="1" >是</option><option value="0">否</option></select>';	
			}else{
				html += '<select ><option value="0">否</option><option value="1" >是</option></select>';	
			}
			
			html += '</td>';
			html += '<td>';
			html += "<a onclick='Field.delTr(this)' name=\"button_"+key+"\" style=\"vertical-align: middle;\" href=\"javascript:void(0)\" >删除</a>";
			html += "<a onclick='Field.sort(this,1)' title='向上' name=\"button_"+key+"\" style=\"vertical-align: middle;\" href=\"javascript:void(0)\" >↑</a>";
			html += "<a onclick='Field.sort(this,2)' title='向下' name=\"button_"+key+"\" style=\"vertical-align: middle;\" href=\"javascript:void(0)\" >↓</a>";
			html += '</td>';

			html += '</tr>';

		}
		
		

		$("#dg").append(html);
		var bts = $('a[name^="button_"]');
		for(var i=0;i<bts.length;i++){
			$(bts[i]).linkbutton();
		}
		

	};
	init();
	return {
//		getField : function() {
//			return this;
//		},
		getFieldMap : function() {
			reshMap();
			return fieldsMap;
		},
		initFields : function(fieldsTempMap) {
			// 执行前先获取已经配置好的数据，缓存到fieldMap里
			reshMap();
			// 已经存在的，不进行重新设置
			for (var key in fieldsTempMap.entrySet) {
				var bean = fieldsTempMap.get(key);
				if (!fieldsMap.containsKey(key)) {
					fieldsMap.put(key, bean);
				}
			}
			for (var key in fieldsMap.entrySet) {
				if (!fieldsTempMap.containsKey(key)) {
					fieldsMap.remove();
				}
			}

			initGrid();
		},
		delTr:function(a){
			$(a).parent().parent().remove();
			reshMap();
		},
		sort:function(a,type){
			var tr = $(a).parent().parent();
			var selectArray = $("#dg tr:not(:first)");
			var trIndex = -1;
			for(var i=0;i<selectArray.length;i++){
				if($(tr).attr("id")==$(selectArray[i]).attr("id")){
					trIndex = i;
					break;
				}
			}
			if(type==1){//向上
				if(trIndex==0){
					return false;
				}
				$(selectArray[trIndex-1]).before($(tr));
			}else{
				if(trIndex==selectArray.length-1){
					return false;
				}
				$(selectArray[trIndex+1]).after($(tr));
				
			}
			
		}
	};
}();
