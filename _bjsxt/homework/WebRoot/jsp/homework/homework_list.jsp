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
    
    <title>My JSP 'homework_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript"  src="js/jquery-1.7.2.min.js"></script>
	
	<script type="text/javascript">
		//window.location = "jsp/student/student_list.jsp";
		//var myform = document.getElementById('myform');
		//myform.action = "StudentAction!list";
		//myform.submit();
		$(function(){
			$('#btn').click(function(){
				if($('#myform').form('validate')){
					$('#myform').attr('action','StudentAction!list');
					$('#myform').get(0).submit();
				}
			});
		});
		
	</script>

  </head>
  
  <body>
  		<div align="center">
  			<font size="5"><b>作业列表</b></font>
  		</div><br/>
  		<form id="myform" method="post">
	  		<table border="1" style="border-collapse: collapse;" width="50%" align="center">
	    		<tr align="center">
	    			<td>序号</td>
	    			<td>作业题目</td>
	    			<td>作业内容</td>
	    			<td>布置时间</td>
	    			<td>给学生布置作业</td>
	    		</tr>
	    		<c:forEach var="temp" varStatus="vs" items="${list}">
	    			<tr align="center">
	    				<td>${vs.index+1}</td>
	    				<td>${temp.title}</td>
	    				<td>${temp.content}</td>
	    				<td>${temp.time}</td>
	    				<td>
	    					<input id="btn" type="button" value="本班学生" "/>
	    				</td>
	    			</tr>
	    		</c:forEach>
	    	</table>
  		</form>
  </body>
</html>
