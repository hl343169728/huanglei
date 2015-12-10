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
	
	<SCRIPT type="text/javascript">
		//布置作业函数 
		function setHomework(){
			window.location = "jsp/homework/homework_add.jsp";
		};
	</SCRIPT>

  </head>
  
  <body>
    	欢迎<s:property value="#session.user.uname"/>老师登录<br/><hr/>
    	<div align="center">
    		<font style="color: blue" size="6"><b>欢迎进入教师操作系统</b></font>
    	</div><br/>
    	<div align="center">
    		<input type="button" value="返回" onclick="javascript:history.back();"/>&nbsp;&nbsp;
    		<input type="button" value="布置作业" onclick="setHomework();"/>&nbsp;&nbsp;
    	</div>
  </body>
</html>
