<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
	<script type="text/javascript">
		//添加学员
		function addStudent(){
			window.location = "jsp/student/student_add.jsp";
		};

		//批量选取
		function selectAll(){
			var selall = document.getElementById('selAll');
			var ids    = document.getElementsByName('ids');
			if(selall.checked){
				for(var i=0;i<ids.length;i++){
					ids[i].checked = 1;
				}
			}else{
				for(var i=0;i<ids.length;i++){
					ids[i].checked = 0;
				}
			}
		};
	</script>

  </head>
  
  <body>
  <div>
  	<input type="button" value="添加学员" onclick="addStudent();"/>
  </div>
	  <form action="" method="post">
	  	<table border="1" width="80%" style="border-collapse: collapse;">
	    	<tr align="center">
	    		<td><input id="selAll" type="checkbox" onclick="selectAll();"/></td>
	    		<td>序号</td>
	    		<td>姓名</td>
	    		<td>联系方法</td>
	    		<td>年龄</td>
	    		<td>行号</td>
	    		<td>列号</td>
	    		<td>图像</td>
	    		<td>操作</td>
	    	</tr>
	    	<c:forEach var="temp" varStatus="vs" items="${list}">
	    	 	<tr align="center">
	    	 		<td><input id="ids" name="ids" type="checkbox" value="${temp.id}"/></td>
	    	 		<td>${vs.index+1 }</td>
	    	 		<td>${temp.sname }</td>
	    	 		<td>${temp.phone }</td>
	    	 		<td>${temp.age }</td>
	    	 		<td>${temp.srow }</td>
	    	 		<td>${temp.scol }</td>
	    	 		<td>
	    	 		
	    	 			<img src="${temp.imagePath}" />
	    	 		</td>
	    	 		<td>
	    	 			<a href=StudentAction!preUpdate?id=${temp.id}>修改</a> | <a href=StudentAction!del?id=${temp.id}>删除</a>
	    	 		</td>
	    	 	</tr>
	    	</c:forEach>
	    </table>
	  </form>
  </body>
</html>
