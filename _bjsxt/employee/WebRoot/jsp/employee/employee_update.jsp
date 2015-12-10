<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'employee_update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript">

	</script>
	
  </head>
  
  <body>
    <form action="EmployeeAction!update" method="post">
    	<input name="id" type="hidden" value="${employee.id}"/>
    	<table align="center">
    		<tr>
    			<td>姓名：</td>
    			<td><input name="employee.name" value="${employee.name}"/></td>
    		</tr>
    		<tr>
    			<td>年龄：</td>
    			<td><input name="employee.age" value="${employee.age}"/></td>
    		</tr>
    		<tr>
    			<td>地址：</td>
    			<td><input name="employee.address" value="${employee.address}"/></td>
    		</tr>
    		<tr>
    			<td>联系方式：</td>
    			<td><input name="employee.phone" value="${employee.phone}"/></td>
    		</tr>
    		<tr>
    			<td><input type="submit" value="修改"/></td>
    			<td><input type="button" value="返回" onclick="javascript:history.back();"/></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>