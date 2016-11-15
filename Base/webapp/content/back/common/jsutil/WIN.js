var WIN = {
	id : "1",
	title : "操作",
	collapsible : true,// 定义是否显示折叠按钮。
	minimizable : true,// 定义是否显示最小化按钮。
	maximizable : true,// 定义是否显示最大化按钮。
	closable : true,// 定义是否显示关闭按钮。
	closed : false,// 定义是否关闭了窗口。

	zIndex : 9000,// 从其开始增加的窗口的 z-index 。
	draggable : true,// 定义是否窗口能被拖拽。
	resizable : true,// 定义是否窗口可以调整尺寸。
	shadow : true,// 如果设为 true， 当窗口能够显示阴影的时候将会显示阴影。
	inline : false,// 定义如何放置窗口， true 就放在它的父容器里， false 就浮在所有元素的顶部。
	modal : true,// 定义窗口是不是模态窗口。
	param:false,
	url : "",
	width : 750,
	height : 400

};
/**
 * 打开一个窗口
 * 
 * @param {}
 *            option
 */
WIN.open = function(option) {
	
	var ID_SUB = "globalModalWindow";
	var IFRAME_SUB = "globalModalFrm";
	var collapsible = option.collapsible || this.collapsible;
	var minimizable = option.minimizable || this.minimizable;
	var maximizable = option.maximizable || this.maximizable;
	var closable = option.closable || this.closable;
	var closed = option.closed || this.closed;
	var zIndex = option.zIndex || this.zIndex;
	var draggable = option.draggable || this.draggable;
	var resizable = option.resizable || this.resizable;
	var shadow = option.shadow || this.shadow;
	var inline = option.inline || this.inline;
	var modal = option.modal || this.modal;
	var url = option.url || this.url;
	var objId = option.id || this.id
	
	var title = option.title?option.title:'操作';
	
	var left = option.left?option.left:this.left;
	//alert(option.left);alert(left);
	var top = option.top?option.top:this.top;
	var width = option.width || this.width;
	var height = option.height || this.height;

	if (url == "") {
		WEB.alert("url参数不能为空");
		return;
	}
//	var param = null;
	$('#' + ID_SUB + objId).window({
				title : title,
				collapsible : collapsible,// 定义是否显示折叠按钮。
				minimizable : false,// 定义是否显示最小化按钮。
				maximizable : maximizable,// 定义是否显示最大化按钮。
				closable : closable,// 定义是否显示关闭按钮。
				closed : closed,// 定义是否关闭了窗口。
				zIndex : zIndex,// 从其开始增加的窗口的 z-index 。
				draggable : draggable,// 定义是否窗口能被拖拽。
				resizable : resizable,// 定义是否窗口可以调整尺寸。
				shadow : shadow,// 如果设为 true， 当窗口能够显示阴影的时候将会显示阴影。
				inline : inline,// 定义如何放置窗口， true 就放在它的父容器里， false 就浮在所有元素的顶部。
				modal : modal,// 定义窗口是不是模态窗口。
				width : width,
				height : height,
				left:left,
				top:top,
				onClose : function(datas) {
					if (option.onClose) {
						
						option.onClose(WIN.param);
    					this.param = false;

					}
				},
				onBeforeClose : function() {
					$('#' + ID_SUB + objId).attr({
								src : "about:blank"
							});
					//param = $('#' + ID_SUB + objId).attr('param');
					if (option.onBeforeClose) {
						option.onBeforeClose();
					}
				}

			});
	$('#'+IFRAME_SUB + objId).attr({
				src : url
			});
};
WIN.close = function(id,param){
	//var ID_SUB = "globalModalWindow";
	
	//$('#' + ID_SUB + objId).window('close');
	
	
//	if(id==undefined){
		//默认关闭最后一个
		var windows = $('div[id^="globalModalWindow"]');
		var max = -1;
		for(var i=0;i<windows.length;i++){
			var divId = $(windows[i]).attr('id');
			if(!$(windows[i]).is(":hidden")){
				var tempId = divId.substring(divId.indexOf("globalModalWindow")+("globalModalWindow").length);
				if(parseInt(tempId)>max){
					max = parseInt(tempId);
				}				
			}
		}
		id = max;
//	}
		WIN.param=param;
	$("#globalModalFrm"+id).attr({src:"about:blank"});
	//$("#globalModalFrm"+id).attr("param",param);
	
	$('#globalModalWindow'+id).window('close',param);
}