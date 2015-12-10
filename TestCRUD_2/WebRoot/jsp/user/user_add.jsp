<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">   
    <title>My JSP 'MyJsp.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
		<form action="UserServlet" method="post">
		
			<input type="hidden" name="method" value="save" />
			
			<table>
					<tr>
						<td>用户名：</td>
						<td><input type="text" name="username" value="" /></td>
					</tr>	
					<tr>
						<td>密码：</td>
						<td><input type="password" name="password" value="" /></td>
					</tr>	
					<tr>
						<td>性别：</td>
						<td>
							<input type="radio" checked="checked" name="sex" value="1" />男&nbsp;&nbsp;&nbsp;
							<input type="radio" name="sex" value="2" />女
						</td>
					</tr>	
					<tr>
						<td>年龄：</td>
						<td><input type="text" name="age" value="" /></td>
					</tr>	
					<tr>
						<td>所属城市：</td>
						<td>
							<select name="address">
								<option value="0">--请选择--</option>
								<option value="1">北京</option>
								<option value="2">上海</option>
								<option value="3">广州</option>
								<option value="4">深圳</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>联系方式：</td>
						<td><input type="text" name="tell" value="" /></td>
					</tr>	
					<tr>
						<td>个人描述：</td>
						<td><textarea name="description" rows="5" cols="50"></textarea></td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="提交" >
						</td>
						<td>
							<input type="button" value="返回" onclick="javascript:history.back();">
						</td>
					</tr>																									
			</table>
		
		</form>	
  </body>
</html>
