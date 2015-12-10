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
    
    <title>My JSP 'user_add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
    	<form action="UserAction!add" method="post">
   			<table border="1" style="border-collapse: collapse;" align="center">
   				<tr align="center">
   					<td colspan="2"><b>用户注册</b></td>
   				</tr>
   				<tr>
   					<td>用户名：</td>
   					<td><input name="user.uname" value=""/></td>
   				</tr>
   				<tr>
   					<td>密码：</td>
   					<td><input name="user.pwd" type="password" value=""/></td>
   				</tr>
   				<tr>
	    			<td>用户类型</td>
	    			<td>
	    				<select name="user.type">
							<s:iterator  var="temp"  value="#application.userType" > 
								<option value="<s:property value="#temp.key" />" >
									<s:property value="#temp.value" />
								</option>
							</s:iterator>
						</select>
	    			</td>
    			</tr>
    			<tr>
    				<td colspan="2" align="right">
    					<input type="submit" value="注册"/>
    				</td>
    			</tr>
   			</table>
    	</form>
  </body>
</html>
