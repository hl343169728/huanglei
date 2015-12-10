<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.bjsxt.model.User" %>
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
	
  </head>
  <%
  	User user = (User)request.getAttribute("user");	
  %>
  <body>
 	<form action="UserServlet" method="post">
 		<input type="hidden" name="method" value="update" />
 		<input type="hidden" name="id" value="<%=user.getId() %>"/>
 		<table>
 			<tr>
 				<td>用户名：</td>
 				<td><input type="text" name="username" value="<%=user.getName() %>" /></td>
 			</tr>
 			<tr>
 				<td>密码：</td>
 				<td><input type="password" name="password" value="<%=user.getPassword() %>" /></td>
 			</tr>
 			<tr>
 				<td>性别：</td>
 				<td><input type="radio" name="sex" value="<%="1".equals(user.getSex())?"checked":"" %>" />男&nbsp;&nbsp;&nbsp;
 					<input type="radio" name="sex" value="<%="2".equals(user.getSex())?"checked":"" %>" />女
 				</td>
 			</tr>
 			<tr>
 				<td>年龄：</td>
 				<td><input type="texy" name="age" value="<%=user.getAge() %>" /></td>
 			</tr>
 			<tr>
 				<td>所属城市：</td>
 				<td>
 					<select name="address">
 						<option value="0">--请选择--</option>
 						<option value="<%="1".equals(user.getAddress())?"checked":"" %>">北京</option>
 						<option value="<%="2".equals(user.getAddress())?"checked":"" %>">天津</option>
 						<option value="<%="3".equals(user.getAddress())?"checked":"" %>">上海</option>
 						<option value="<%="4".equals(user.getAddress())?"checked":"" %>">重庆</option>
 					</select>
 				</td>
 			</tr>
 			<tr>
 				<td>联系方式：</td>
 				<td><input type="text" name="tell" value="<%=user.getTell() %>" /></td>
 			</tr>
 			<tr>
 				<td>个人描述：</td>
 				<td><input type="text" name="description" value="<%=user.getDescription() %>" /></td>
 			</tr>
 			<tr>
 				<td>
 					<input type="submit" value="修改" />
 				</td>
 				<td>
 					<input type="button" value="返回" oncClick="javascript:history.back();" />
 				</td>
 			</tr>
 		</table>
 	</form>
  </body>
</html>
