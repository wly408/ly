var WEB = {

	ROOT : BASE_APP_ROOT,
	/**
	 * AJAX请求 config{ url:'', suc:suc, error:error, data:data, issyn:issyn }
	 */
	ajax : function(config) {

		config = config ? config : {};
		var url = config.url;
		var suc = config.suc;
		var error = config.error;
		var data = config.data;
		var issyn = config.issyn;

		var dataType = config.dataType ? config.dataType : "json";
		var contentType = config.contentType
				? config.contentType
				: "application/json";

		WEB.loading({
					message : "正在处理中,请稍后..."
				});
		$.ajax({
					url : url,
					dataType : dataType,
					contentType : contentType,
					data : data,
					type : "POST",
					async : !issyn,// 同步执行
					success : function(rs) {
						WEB.unLoading();
						if (suc) {
							suc(rs);
						}

					},
					error : function(rs) {
						WEB.unLoading();
						if (error) {
							error(rs);
						} else {
							WEB.error("请求异常");
						}

					}
				});
	},
	/**
	 * 代替alert
	 * 
	 * @param {}
	 *            msg
	 */
	alert : function(msg) {
		$.messager.alert("操作提示", msg);
	},
	error : function(msg) {
		$.messager.alert("操作提示", msg, 'error');
	},
	confirm : function(msg, sucFun, canFun) {
		$.messager.confirm("提示", msg, function(data) {
					if (data) {
						if (sucFun) {
							sucFun();
						}

					} else {
						if (canFun) {
							canFun();
						}
					}
				});
	},
	loading : function(p) {
		var opt = $.extend({
					el : window,
					message : "正在获取数据..."
				}, p);

		$(opt.el).block({
					message : "<div class='loadLevel'>" + opt.message
							+ "</div>",
					overlayCSS : {
						border : "medium none",
						width : "100%",
						height : "100%",
						top : "0pt",
						left : "0pt",
						backgroundColor : "#000",
						opacity : 0.3,
						cursor : "wait",
						position : "fixed"
					}
				});
	},
	unLoading : function(p) {
		var opt = $.extend({
					el : window
				}, p);
		$(opt.el).unblock();
	},
	getMaxWindowHeight : function() {
		var winobj = window; // WEB.getWINObj();
		// if(winobj == null){
		// winobj = window;
		// }

		var clientHeight = winobj.document.body.clientHeight;// 其它浏览器默认值
		if (navigator.userAgent.indexOf("MSIE 6.0") != -1) {
			clientHeight = winobj.document.body.clientHeight;
		} else if (navigator.userAgent.indexOf("MSIE") != -1) {
			// IE7 IE8
			clientHeight = winobj.document.documentElement.offsetHeight
		}

		if (navigator.userAgent.indexOf("Chrome") != -1) {
			clientHeight = winobj.document.body.scrollHeight;
		}

		if (navigator.userAgent.indexOf("Firefox") != -1) {
			clientHeight = winobj.document.documentElement.scrollHeight;
		}

		return clientHeight;
	},

	iFrameHeight : function() {

		var ifm = document.getElementById("iframepage");

		var subWeb = document.frames
				? document.frames["iframepage"].document
				: ifm.contentDocument;

		if (ifm != null && subWeb != null) {

			ifm.height = subWeb.body.scrollHeight;

		}

	},
	/**
	 * 打开窗口
	 * 
	 * @param {}
	 *            option
	 */
	openWin : function(option) {
		
		// 获取窗口对象
		var winobj = WEB.getWINObj();

		if (winobj != null) {
			/*
			 * var maxHeight=WEB.getMaxWindowHeight(); var maxWidth=
			 * WEB.getMaxWindowWidth();
			 * 
			 * //处理高度，如果高度为full，或者指定的高度超过最大高度
			 * if(typeof(option.height)!="undefined" && (
			 * (option.height+"").toLowerCase() =="full" ||
			 * option.height>=maxHeight )){ option.top=0;
			 * option.height=maxHeight; }
			 * 
			 * //处理宽度 if(typeof(option.width)!="undefined" && (
			 * (option.width+"").toLowerCase() =="full" ||
			 * option.width>=maxWidth )){ option.left=0; option.width=maxWidth; }
			 */
			// alert(winobj);
			winobj.WIN.open(option);
		}

		// 用普通窗口打开
		else {
			if (option && option.url) {
				// alert(WEB.WEBROOT+option.url);
				var width = option.width || 800;
				var height = option.height || 500;
				window.open(WEB.ROOT + "/" + option.url, "_blank", "width="
								+ width + ",height=" + height + ";resizable=y");
			} else {
				alert("url参数不能为空");
			}
		}

	},
	getWINObj : function() {
		try {

			return window.parent.parent.parent.parent;
		} catch (e) {
			try {

				return window.parent.parent.parent;
			} catch (e) {
				try {

					return window.parent.parent;
				} catch (e) {
					try {

						return window.parent;
					} catch (e) {
						try {

							return window;
						} catch (e) {

						}
					}
				}
			}
		}
		/*
		 * if (window.WIN) {
		 * 
		 * return window; } else if (window.parent && window.parent.WIN) {
		 * 
		 * return window.parent; } else if (window.parent.parent &&
		 * window.parent.parent.WIN) {
		 * 
		 * return window.parent.parent; } else if (window.parent.parent.parent &&
		 * window.parent.parent.parent.WIN) { return
		 * window.parent.parent.parent; } else if
		 * (window.parent.parent.parent.parent &&
		 * window.parent.parent.parent.parent.WIN) { return
		 * window.parent.parent.parent.parent; } else { return null; }
		 */
	},
	setWinParam : function(url, name, value) {
		var index = url.indexOf("?");
		value = !value ? "" : encodeURIComponent(value);
		url += (index > -1 ? "&" : "?") + name + "=" + value;
		return url;

	},
	getWinParam:function(name){
		name = name.replace(/[\[]/, "\\\[").replace(/[\]]/, "\\\]");
		var regexS = "[\\?&]" + name + "=([^&#]*)";
		var regex = new RegExp(regexS);
		var results = regex.exec(window.location.href);
		
		if (results == null){
			return "";
		}else{
			return decodeURIComponent(results[1]);
		}
	},
	close:function(id,param){
		var winobj = WEB.getWINObj();

		if (winobj != null) {
			
			winobj.WIN.close(id,param);
		}
	},
	select:function(option){
		var id = option.id;
		var isAll = option.isAll;
		var defVal = option.defVal;
		var suc = option.suc;
		var error = option.error;
		
		var init = function(){
			WEB.ajax({
				url:url,
				suc:function(rs){
					$("#"+id).html("");
					if(rs&&rs!=null&&rs.length>0){
						var html = "";
						for(var i=0;i<rs.length;i++){
							var option = rs[i];
						}
						
					}
					
					if(suc){
						suc(rs);
					}
				},
				error:error
			});
		
		}();
	
	}

};