<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'employee_add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
  
  <body>
    <form action="EmployeeAction!save" method="post">
    	<table align="center">
    		<tr>
    			<td>姓名：</td>
    			<td><input name="employee.name" value=""/></td>
    		</tr>
    		<tr>
    			<td>年龄：</td>
    			<td><input name="employee.age" value=""/></td>
    		</tr>
    		<tr>
    			<td>地址：</td>
    			<td><input name="employee.address" value=""/></td>
    		</tr>
    		<tr>
    			<td>联系方式：</td>
    			<td><input name="employee.phone" value=""/></td>
    		</tr>
    		<tr>
    			<td colspan="2"><input type="submit" value="提交"/></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
