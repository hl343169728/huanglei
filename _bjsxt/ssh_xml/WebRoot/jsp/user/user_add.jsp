<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  <br/>
  	<div align="center">
  		<font style="color:red" size=5><b>用户信息录入界面</b></font>
  	</div><br/>
    <form action="userAction!save" method="post">
    	<table align="center" style="border-collapse: collapse;" border="1">
    		<tr>
    			<td>姓名：</td>
    			<td><input name="user.name" value=""/></td>
    		</tr>
    		<tr>
    			<td>联系方式：</td>
    			<td><input name="user.phone" value=""/></td>
    		</tr>
    		<tr>
    			<td>家庭住址：</td>
    			<td><input name="user.address" value=""/></td>
    		</tr>
    		<tr>
    			<td colspan="2"><input type="submit" value="提交"/></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
