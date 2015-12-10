<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<SCRIPT type="text/javascript">
		//添加用户函数 
		function addUser(){
			window.location = "jsp/user/user_add.jsp";
		};
	</SCRIPT>

  </head>
  
  <body>
    	<form action="UserAction!login" method="post">
    		<div>
    			<font style="color:red" align="center">
	  				<s:property value="#request.error"/>
	  			</font>
    		</div>
    		<div align="center">
    			<font style="color: blue" size="5"><b>用户登录界面</b></font>
    		</div>
    		<table align="center" border="1" style="border-collapse: collapse;">
    			<tr>
    				<td>用户名：</td>
    				<td><input name="uname" value=""/></td>
    			</tr>
    			<tr>
    				<td>密码：</td>
    				<td><input name="pwd" value=""/></td>
    			</tr>
    			<tr>
	    			<td>用户类型</td>
	    			<td>
	    				<select name="type">
							<s:iterator  var="temp"  value="#application.userType" > 
								<option value="<s:property value="#temp.key" />" >
									<s:property value="#temp.value" />
								</option>
							</s:iterator>
						</select>
	    			</td>
    			</tr>
    			<tr>
    				<td colspan="2">
    					<input type="button" value="注册" onclick="window.location.href='jsp/user/user_add.jsp'"/>
    					<input type="submit" value="登录"/>
    				</td>
    			</tr>
    		</table>
    	</form>
  </body>
</html>
