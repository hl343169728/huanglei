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
    
    <title>My JSP 'student_welcome.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
    	欢迎<s:property value="#session.user.uname"/>同学登录<br/><hr/>
    	<div align="center">
    		<font style="color: blue" size="6"><b>欢迎进入学生操作系统</b></font>
    	</div>
     	<div align="center">
    		<input type="button" value="返回" onclick="javascript:history.back();"/>
    		<input type="button" value="查看作业情况" onclick=""/>
    	</div>
  </body>
</html>
