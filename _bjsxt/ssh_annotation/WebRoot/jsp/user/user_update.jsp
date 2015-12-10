<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  		<div align="center">
  			<font color="red" size=6><b>用户修改界面</b></font>
  		</div><br/>
    	<form action="userAction!update" method="post">
    		<input type="hidden" name="id" value="${user.id}"/>
    		<table border="1" style="border-collapse: collapse;" align="center">
    			<tr>
    				<td>姓名：</td>
    				<td>
    					<input id="username" name="user.name" value="${user.name}"/>
    					<span id="msg"></span>
    					<input type="button" value="验证" onclick="checkName();"/>
    				</td>
    			</tr>
    			<tr>
    				<td>联系方式：</td>
    				<td><input name="user.phone" value="${user.phone}"/></td>
    			</tr>
    			<tr>
    				<td>家庭住址：</td>
    				<td><input name="user.address" value="${user.address}"/></td>
    			</tr>
    			<tr>
    				<td>存款：</td>
    				<td><input name="user.money" value="${user.money}"/></td>
    			</tr>
    			<tr>
    				<td colspan="2">
    					<input type="submit" value="修改"/>
    					<input type="button" value="返回" onclick="javascript:history.back();"/>
    				</td>
    			</tr>
    		</table>
    	</form>
  </body>
</html>