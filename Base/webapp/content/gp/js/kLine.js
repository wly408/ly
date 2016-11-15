$(function() {
			InfoBean.loadKLineData();
		});
var InfoBean = {

	setOption : function(option, divId) {
//		alert(JSON.stringify(option));
		//$("#option").val(JSON.stringify(option));
		var myChart = echarts.init(document.getElementById(divId));
		myChart.setOption(option);
	},
	createDiv:function(i){
		var tr = "<tr><td>";
		tr+='<div id="chart_'+i+'" style="height: 300px;width: 100%"></div>';
		tr+="</td></tr>";
		
		$("#chartTable").append(tr);
		return "chart_"+i;
	},
	loadKLineData : function() {
		
		var url = WEB.ROOT + "/gp/info/getKLineData.ajax?codes="+InfoBean.testCode();
		WEB.ajax({
					// type : 'POST',
					// contentType : 'application/json',
					// dataType : 'json',
					"url" : url,
					"suc" : function(data) {
						var optionList = data.data == null ? [] : data.data;
						if (optionList != null) {
							for (var i = 0; i < optionList.length; i++) {

								InfoBean.setOption(InfoBean.getRealOption(optionList[i]),InfoBean.createDiv(i));
							}
						}

					}

				});
	},
	getRealOption : function(dataOption) {
		
		var option = {};
		$.extend(option,dataOption);
		//option = dataOption;
		option.title.left = 70;
		
		option.grid = {
			left : '5%',
			right : '5%',
			bottom : '19%'
		};
		option.tooltip={
	        trigger: 'axis',
	        axisPointer: {
	            type: 'line'
	        }
	    },
		// alert(JSON.stringify(dataOption.xAxis));
		option.xAxis = {
			type : 'category',
			data : dataOption.xAxis[0].data
		};
		var maxAndMin = InfoBean.getMaxAndMin(dataOption.series[0].data);
		
		var min = 0;
		option.yAxis = {
			scale : true,
			splitArea : {
				show : false
			},
			   axisLabel:{
                 //X轴刻度配置
                 interval:0 //0：表示全部显示不间隔；auto:表示自动根据刻度个数和宽度自动设置间隔个数
            },
            //splitNumber:0.001,
            max:parseInt(maxAndMin[0])+1,
            min:parseInt(maxAndMin[1])-1
		};
		option.dataZoom = [{
					type : 'inside',
					start : 0,
					end : 100
				}, {
					show : true,
					type : 'slider',
					y : '90%',
					start : 0,
					end : 100
				}];
		
		option.series=[];
		option.legend.x="center";
		option.legend.y="top";
		//"x": "center",
        //"y": "bottom",
		
		var daySerie = {
            name: '日K',
            type: 'candlestick',
            data: dataOption.series[0].data
				};
		option.series.push(daySerie);
		
		return option;
	},
	testCode:function(){
		var codes = "600243,600381,600444,600099,600981";
		return codes;	
	},
	getMaxAndMin:function(datas){
		//alert(JSON.stringify(datas));
		var max = 0;
		var min = 99999999;
		for(var i=0,leng=datas.length;i<leng;i++){
			var values = datas[i].value;
			for(var j=0,leng2=values.length;j<leng2;j++){
				if(parseFloat(values[j])>max){
					max = values[j];
				}
				if(parseFloat(values[j])<min){
					min = values[j];
				}
			}
		}
		return [max,min];
	}

};