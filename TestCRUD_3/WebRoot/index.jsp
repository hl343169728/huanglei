<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
    <form action="EmployeeServlet" method="post">
    	<p style="color:red">${requestScope.error }</p>
    	<input type="hidden" name="method" value="login" />
    	<table>
	    	<tr>
	    		<td>用户名：</td>
	    		<td><input name="username" type="text" value="" /></td>
	    	</tr>
	    	<tr>
	    		<td>密码:</td>
	    		<td><input name="password" type="password" value="" /></td>
	    	</tr>
	    	<tr>
	    		<td>
		    		<input type="submit" value="登录"/>
		    		<input type="reset" value="重置" />
	    		</td>
	    	</tr>
    	</table>
    </form>
  </body>
</html>
