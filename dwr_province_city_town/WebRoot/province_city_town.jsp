<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'province_city_town.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type='text/javascript' src='/dwr_province_city_town/dwr/interface/province.js'></script>
    <script type='text/javascript' src='/dwr_province_city_town/dwr/engine.js'></script>
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
    
    <script type="text/javascript">
    	//当页面被加载的时候，就会执行 
    	window.onload = function(){
			var sel_1 = document.getElementById("sel_1");
			province.findProvince(function(result){
				for(var i=0;i<result.length;i++){
					sel_1.innerHTML += "<option value="+result[i].areaCode+">"+result[i].areaName+"</option>";
				}
			});
        };

        //由省份的AreaCode获取当前省份的城市区域
        function getCity(value){
			var sel_2 = document.getElementById("sel_2");
			sel_2.options.length = 0;
			//$("#sel_2").children().remove();
			province.findCity(value,function(result){
				for(var i=0;i<result.length;i++){
					sel_2.innerHTML += "<option value="+result[i].areaCode+">"+result[i].areaName+"</option>";
				}
			});
        }

        //由选中的城市获取其下所有的县镇 
        function getTown(value){
			var sel_3 = document.getElementById("sel_3");
			sel_3.options.length = 0;                     //清空以前的记录
			province.findTown(value,function(result){
				for(var i=0;i<result.length;i++){
					sel_3.innerHTML += "<option value="+result[i].areaCode+">"+result[i].areaName+"</option>"; 
				}
			});
        }
    </script>

  </head>
  
  <body>
    	省：<select id="sel_1" onchange="getCity(this.value);"><option value="0">--请选择--</option></select>
    	区：<select id="sel_2" onchange="getTown(this.value);"><option value="0">--请选择--</option></select>
    	县：<select id="sel_3"><option value="0">--请选择--</option></select>
  </body>
</html>
