<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'student_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
   		<table border="1" style="border-collapse: collapse;" width="50%" align="center">
   			<tr align="center">
   				<td>
   					<input id="selAll" type="checkbox" onclick="selectAll();"/>
   				</td>
   				<td>序号</td>
   				<td>学生姓名</td>
   			</tr>
   			<c:forEach var="temp" varStatus="vs" items="${list}">
   				<tr align="center">
   					<td>
   						<input name="ids" type="checkbox" value="${temp.id}"/>
   					</td>
   					<td>${vs.index+1}</td>
   					<td>${temp.sname}</td>
   				</tr>
   			</c:forEach>
   			<tr align="center">
   				<td colspan="3"><input type="button" value="确认"/></td>
   			</tr>
   		</table>
  </body>
</html>
