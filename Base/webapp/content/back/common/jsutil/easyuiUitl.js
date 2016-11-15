var EasyuiUtil = {

	/**
	 * var config={ tabsId:'', tabName:'', url:'', closable:true, selected:true };
	 * 
	 * @param {}
	 *            parentId
	 * @param {}
	 *            tabName
	 * @param {}
	 *            url
	 */
	addTab : function(config) {
		var url =  config.url;
		var height = "100%";
		
		if(new BrowerType().isChrome){
//			height = "75%";
		}
		//已经存在则选中
		if($("#"+config.tabsId).tabs('exists',config.tabName)){
			$("#"+config.tabsId).tabs('select',config.tabName);
			return false;
		}
//		height = 10000;
//		alert(WEB.getMaxWindowHeight());
		var content = '<iframe scrolling="auto" frameborder="0"  src="' + url
				+ '" style="width:100%;height:'+height+';" ></iframe>';//
				
		$('#' + config.tabsId).tabs('add', {
			title : config.tabName,
			content : content,

			closable : config.closable == undefined ? true : config.closable,
			selected : config.selected == undefined ? true : config.selected
				// fit:true
				// width : $('#' + config.tabsId).parent().width(),
				// height : $('#' + config.tabsId).parent().height()
			});

		// var tab = $('#tt').tabs('getSelected');
		// $("#"+config.tabsId).tabs('update', {
		// tab: tab,
		// options: {
		// title:config.tabName,
		// content: '<iframe scrolling="auto" frameborder="0" src="'+url+'"
		// style="width:100%;height:100%;"></iframe>',
		// closable: true,
		// selected:true
		// }
		// });
//			$("#"+config.tabsId).tabs({ 
//　　　　width:$("#"+config.tabsId).parent().width(), 
//　　　　height:$("#"+config.tabsId).parent().height() 
//　　}); 
//		$("#"+config.tabsId).tabs({ 
//		　　width: $("#"+config.tabsId).parent().width()+20, 
//		　　height: $("#"+config.tabsId).parent().height()
//		}); 

	},
	grid:function(config){
		var gridId = config.id;
		var title = config.title?config.title:'列表';
		var pageSize = config.pageSize?config.pageSize:10;//分页条数
		var pageList = config.pageList?config.pageList : [10, 20, 30, 40];// 可以选择的分页集合
		var singleSelect = config.singleSelect?config.singleSelect:false;// 为true时只能选择单行
		var toolbar = config.toolbar?config.toolbar:[];//工具栏
		if(config.toolbar==null){
			toolbar = null;
		}
		
		var url = config.url;
		var pagination = config.pagination!=undefined?config.pagination:true;
		var rownumbers = config.rownumbers?config.rownumbers:true;
		var columns = config.columns;
		var frozenColumns = config.frozenColumns?config.frozenColumns:[[{
						field : 'ck',
						checkbox : true
					}]];
		
		
		
		
		
		$('#'+gridId).datagrid({
			title : title,
			iconCls : 'icon-ok',
			pageSize : pageSize,// 默认选择的分页是每页5行数据
			pageList : pageList,// 可以选择的分页集合
			fitColumns : true,// 使列自动展开/收缩到合适的数据表格宽度。
//			 height:"100%",
//			height:WEB.getMaxWindowHeight()-200,
//			height:150,
			nowrap : true,// 设置为true，当数据长度超出列宽时将会自动截取
			striped : true,// 设置为true将交替显示行背景。
			// collapsible : true,// 显示可折叠按钮
			//toolbar : "#tb",// 在添加 增添、删除、修改操作的按钮要用到这个
			url : url,// url调用Action方法
			loadMsg : '数据装载中......',
			fit: true, 
			singleSelect : singleSelect,// 为true时只能选择单行
			fitColumns : true,// 允许表格自动缩放，以适应父容器
			// sortName : 'xh',//当数据表格初始化时以哪一列来排序
			// sortOrder : 'desc',//定义排序顺序，可以是'asc'或者'desc'（正序或者倒序）。
			remoteSort : false,
			frozenColumns : frozenColumns,
			pagination : pagination,// 分页
			rownumbers : rownumbers,
			toolbar : toolbar,
			columns : columns
			

				// 行数
			});
		
	
	}

};
$.fn.serializeObject=function(){  
    var a,o,h,i,e;  
    a=this.serializeArray();  
    o={};  
    h=o.hasOwnProperty;  
    for(i=0;i<a.length;i++){  
        e=a[i];  
        if(!h.call(o,e.name)){  
            o[e.name]=e.value;  
        }  
    }  
    return o;  
}; 
$.extend($.fn.datagrid.methods, {  
    addToolbarItem: function(jq, items){  
        return jq.each(function(){  
            var toolbar = $(this).parent().prev("div.datagrid-toolbar");
            for(var i = 0;i<items.length;i++){
                var item = items[i];
                if(item === "-"){
                    toolbar.append('<div class="datagrid-btn-separator"></div>');
                }else{
                    var btn=$("<a href=\"javascript:void(0)\"></a>");
                    btn[0].onclick=eval(item.handler||function(){});
                    btn.css("float","left").appendTo(toolbar).linkbutton($.extend({},item,{plain:true}));
                }
            }
            toolbar = null;
        });  
    },
    removeToolbarItem: function(jq, param){  
        return jq.each(function(){  
            var btns = $(this).parent().prev("div.datagrid-toolbar").children("a");
            var cbtn = null;
            if(typeof param == "number"){
                cbtn = btns.eq(param);
            }else if(typeof param == "string"){
                var text = null;
                btns.each(function(){
                    text = $(this).data().linkbutton.options.text;
                    if(text == param){
                        cbtn = $(this);
                        text = null;
                        return;
                    }
                });
            } 
            if(cbtn){
                var prev = cbtn.prev()[0];
                var next = cbtn.next()[0];
                if(prev && next && prev.nodeName == "DIV" && prev.nodeName == next.nodeName){
                    $(prev).remove();
                }else if(next && next.nodeName == "DIV"){
                    $(next).remove();
                }else if(prev && prev.nodeName == "DIV"){
                    $(prev).remove();
                }
                cbtn.remove();    
                cbtn= null;
            }                        
        });  
    }                 
});
