<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'student_update.jsp' starting page</title>
    
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
    	<form action="StudentAction!update" method="post">
    		<input name="id" type="hidden" value="${student.id }"/>
    		<table>
    			<tr>
    				<td>姓名：</td>
    				<td><input name="student.sname" value="${student.sname}"/></td>
    			</tr>
    			<tr>
    				<td>联系方式：</td>
    				<td><input name="student.phone" value="${student.phone}"/></td>
    			</tr>
    			<tr>
    				<td>年龄：</td>
    				<td><input name="student.age" value="${student.age}"/></td>
    			</tr>
    			<tr>
    				<td>上传图片:</td>
    				<td><input name="student.path" type="file" value="${student.path}"/></td>
    			</tr>
    			<tr>
    				<td>学生行号：</td>
    				<td><input name="student.srow" value="${student.srow}"/></td>
    			</tr>
    			<tr>
    				<td>学生列号：</td>
    				<td><input name="student.scol" value="${student.scol}"/></td>
    			</tr>
    			<tr>
    				<td>班级：</td>
    				<td><input name="student.cid" value="${student.cid}"/></td>
    			</tr>
    			<tr>
    				<td><input type="submit" value="修改"/></td>
    				<td><input type="button" value="返回" onclick="javascript:history.back();"/></td>
    			</tr>
    		</table>
    	</form>
  </body>
</html>
