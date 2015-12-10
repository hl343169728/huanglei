<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'talk2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type='text/javascript' src='/dwr_base/dwr/interface/talk2.js'></script>
    <script type='text/javascript' src='/dwr_base/dwr/engine.js'></script>
    
    
    <!-- 长连接  ：
    	高并发的时候，依然有问题，但信息的实时性非常高
     -->
    <script type="text/javascript">
    	function send(){
			var wd = document.getElementById("wd");
			talk2.sendMsg(wd.value);
        };

        function list(result){
			var dv = document.getElementById("dv");
			dv.innerHTML = "";
			for(var i=0;i<result.length;i++){
				dv.innerHTML += result[i] + "<br/>"; 
			}
        };
    </script>

  </head>
  
  <body onload="dwr.engine.setActiveReverseAjax(true);">
   		<input type="text" id="wd"/><button onclick="send();">发送</button>
   		<div id="dv"></div>
  </body>
</html>
