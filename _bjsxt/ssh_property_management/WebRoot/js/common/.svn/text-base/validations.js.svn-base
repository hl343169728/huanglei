// JQuery code
/**
 *  对于表单校验的自定义公共方法
 *  @author _oiYc
 */
$(function(){
			$.extend($.fn.validatebox.defaults.rules, { 
				//两个参数之间的校验   2 < param < 10
				midLength: { 
					validator: function(value, param){ 
								return value.length >= param[0] && value.length <= param[1]; 
					}, 
					message: ''  
				}  ,
				//大于等于指定参数的校验  param >= 10
				gtLength: {
					validator: function(value, param){ 
								return value.length >= param[0]; 
					}, 
					message: '' 
			
				}  ,
				//两个参数的选择关系校验  param == 10  || param == 5
				orLength :{
					validator: function(value, param){ 
								return  value.length == param[0] || value.length == param[1]; 
					}, 
					message: ''
				} ,
				//身份证的校验 15 或18位 
				cardLength :{
					validator: function(value, param){ // [ 15 , 18] 
								return  value.length == param[0] || value.length == param[1]; 
					}, 
					message: ''
				} 
			});
});












