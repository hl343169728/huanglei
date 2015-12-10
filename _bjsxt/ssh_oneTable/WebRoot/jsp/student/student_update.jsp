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
	
	<script type="text/javascript">
		function check(){
			if(confirm("确认修改?")){
				window.location = "jsp/student/student_list.jsp";
			}
		};	
	</script>

  </head>
  
  <body>
  		<div align="center">
  			<font color="red" size=5><b>修改学员信息</b></font>
  		</div>
    	<form action="studentAction!update" method="post">
    		<input name="id" type="hidden" value="${student.id}"/>
    		<table border="1" style="border-collapse: collapse;" align="center">
    			<tr>
    				<td>学员姓名：</td>
    				<td><input name="student.sname" value="${student.sname}"/></td>
    			</tr>
    			<tr>
    				<td>所在学校：</td>
    				<td><input name="student.school" value="${student.school}"/></td>
    			</tr>
    			<tr>
    				<td>家庭住址：</td>
    				<td><input name="student.address" value="${student.address}"/></td>
    			</tr>
    			<tr>
    				<td colspan="2">
    					<input type="button" value="修改信息" onclick="check();"/>
    					<input type="button" value="返回" onclick="javascript:history.back();"/>
    				</td>
    			</tr>
    		</table>
    	</form>
  </body>
</html>
