<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'clz_add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
	<form action="ClzAction!save" method="post">
		<table>
			<tr>
				<td>班级名称：</td>
				<td><input name="clz.cname" value=""/></td>
			</tr>
			<tr>
				<td>地址：</td>
				<td><input name="clz.address" value=""/></td>
			</tr>
			<tr>
				<td>任课老师：</td>
				<td><input name="clz.teacher" value=""/></td>
			</tr>
			<tr>
				<td>行数：</td>
				<td><input name="clz.crow" value=""/></td>
			</tr>
			<tr>
				<td>列数：</td>
				<td><input name="clz.ccol" value=""/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="提交"/></td>
			</tr>
		</table>
	</form>
  </body> 
</html> 

