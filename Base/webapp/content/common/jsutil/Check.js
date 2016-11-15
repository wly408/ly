var Check = function(){
	return{
		/**
		 * 校验是否为空
		 */
		isEmpty:function(text){
			if(!text||text==undefined||$.trim(text)==''){
				return true;
			}
			return false;
		},
		/**
		 * 校验长度
		 */
		checkLength:function(text,maxLength){
			if(!text||text==undefined||$.trim(text)==''){
				return true;
			}
			if(text.length>maxLength){
				return false;
			}
			return true;
		},
		/**
		 * 校验是否是整型
		 */
		checkInt:function(text){
			if(Check.isEmpty(text)){
				return false;
			}
			if(text==parseInt(text,10)+""){
				return true;
			}
			return false;
		},
		/**
		 * 是否为正正数
		 */
		checkIntPo:function(text){
			
			return Check.checkInt(text)&&parseInt(text,10)>0;
		}
	
	};
	
}();