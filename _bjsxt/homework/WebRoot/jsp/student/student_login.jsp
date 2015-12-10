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
    
    <title>My JSP 'student_login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  	<font style="color:red" size="6">
  		<s:property value="#request.error"/>
  	</font>
    <form action="StudentAction!login" method="post">
    	<table align="center" border="1" style="border-collapse: collapse;">
    		<tr>
    			<td>用户名：</td>
    			<td><input name="student.sname" value=""/></td>
    		</tr>
    		<tr>
    			<td>密码：</td>
    			<td><input name="student.pwd" value=""/></td>
    		</tr>
    		<tr>
    			<td colspan="2"><input type="submit" value="登录"/></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
