$(function() {

			InfoBean.init();
		});
var InfoBean = {
	menus : [],
	init : function() {
		// 获取数据
		InfoBean.menus = InfoBean.getMenus("");
		
		InfoBean.readerMenu();

		// $(window).resize(function() {
		// $('#tabParent').tabs({
		// width : $("#tabParent").parent().width(),
		// height :$("#tabParent").parent().height()
		// });
		// });

	},
	readerMenu : function() {
		var pmenus = InfoBean.getSMenus("-1");

		for (var i = 0; i < pmenus.length; i++) {
			var subMenuHtml = "";
			var smenus = InfoBean.getSMenus(pmenus[i].menuId);
			for (var j = 0; j < smenus.length; j++) {
				subMenuHtml += '<p onclick="InfoBean.openMenu(\''
						+ smenus[j].menuId + '\',\'' + '' + smenus[j].menuName
						+ '\',\'' + WEB.ROOT + smenus[j].menuUrl + '\')"><a>'
						+ smenus[j].menuName + '</a></p>';
				// subMenuHtml += '<p onclick="InfoBean.openMenu()"><a>'
				// + smenus[j].menuName + '</a></p>';
			}

			$('#menuDiv').accordion('add', {
						title : pmenus[i].menuName,
						selected : i == 0,
						content : subMenuHtml,
						style:'padding:10px;overflow:auto;'
						
						// iconCls: "icon-ok"
					});
		}

	},
	openMenu : function(menuId, menuName, menuUrl) {
	
		EasyuiUtil.addTab({
					"tabsId" : "tabParent",
					"tabName" : menuName,
					url : menuUrl
				});
		//tabParent
//		$('#tabParent').tabs({
//								width : $("#tabParent").parent().width(),
//								height : $("#tabParent").parent().height()-10
//					});
//		$(window).resize(function() {
//					$('#tabParent').tabs({
//								width : $("#tabParent").parent().width(),
//								height : $("#tabParent").parent().height()
//							});
//				});

	},
	getSMenus : function(parentMenuId) {
		var menus = [];
		for (var i = 0; i < InfoBean.menus.length; i++) {
			if (InfoBean.menus[i].parentMenuId == parentMenuId) {
				menus.push(InfoBean.menus[i]);
			}
		}
		return menus;
	},
	getMenus : function(parentMenuId) {
		var url = WEB.ROOT + "/back/index/getMenus.ajax";
		var menus = [];
		
		var data = {
			parentMenuId : parentMenuId
		};
		// $.toJSON(
		WEB.ajax({
					type : 'POST',
					contentType : 'application/json',
					dataType : 'json',
					"url" : url,
					"suc" : function(data) {
						menus = data.data==null?[]:data.data;
						
					},
					"issyn" : true,
					"data" : JSON.stringify(data)
				});
		return menus;
	}

};