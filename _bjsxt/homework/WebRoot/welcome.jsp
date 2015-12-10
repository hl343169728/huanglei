<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'welcome.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript">
		//查看作业信息函数
		function checkHomework(){
			window.location = "";
		};

		//布置作业 
		function setHomework(){
			window.location = "jsp/homework/homework_add.jsp";
		};
	</script>

  </head>
  
  <body>
    	欢迎您登录----<s:property value="#session.user.uname"/><br/><hr/>
    	<input type="button" value="查看作业情况" onclick="checkHomework();"/>&nbsp;&nbsp;
    	<input type="button" value="布置作业" onclick="setHomework();"/>
  </body> 
</html>
