<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'talk.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type='text/javascript' src='/dwr_base/dwr/interface/talk.js'></script>
    <script type='text/javascript' src='/dwr_base/dwr/engine.js'></script>
    
    <!-- 轮询： 
    	太浪费资源，而且信息的实时性也不高
     -->
    <script type="text/javascript">
    	setInterval(function(){
			var  dv = document.getElementById("dv");
			talk.sendMsg("", function(list){
				dv.innerHTML="";
				for ( var i = 0; i < list.length; i++) {
						dv.innerHTML+=list[i]+"<br/>";
					}
				});
			},3000);
		
		function  test(){
			var  wd = document.getElementById("wd");
			var  dv = document.getElementById("dv");
			talk.sendMsg(wd.value, function(list){
				dv.innerHTML="";
				for ( var i = 0; i < list.length; i++) {
					dv.innerHTML+=list[i]+"<br/>";
				}
			});
		}
    </script>

  </head>
  
  <body>
    	<input type="text" id="wd"/><button onclick="test();">发送</button>
    	<div id="dv"></div>
  </body>
</html>
