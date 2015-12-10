<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.bjsxt.model.User"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript">
		function addUser(){
			window.location = "jsp/user/user_add.jsp";	
		}

		function deleteUser(id){
			if(confirm("确认删除吗？")){
				window.location = "UserServlet?method=delete&id="+id;
				return true;
			}else{
				return false;
			}
		}
	</script>

  </head>
  
  <body>
   		<div>
   			<input type="button" value="新增用户" onClick="addUser();" />
   		</div>
   		<table border="1" width="90%" style="border-collapse:collapse;">
   			<tr algin="center">
   				<th>序号</th>
   				<th>姓名</th>
   				<th>性别</th>
   				<th>年龄</th>
   				<th>地址</th>
   				<th>联系方式</th>
   				<th>个人描述</th>
   				<th>操作</th>
   			</tr>
   			<%--
   			 <%
		  		List<User> userList = (List<User>)request.getAttribute("userList");
		   		for(int i = 0 ;  i <userList.size();i++ ){
		   				User user = userList.get(i);
   			 %>
		   	<tr align="center" >
		   		<td><%=i+1 %></td>
		   		<td><%=user.getName() %></td>
		   		<td><%="1".equals(user.getSex())?"男":"女" %></td>
		   		<td><%=user.getAge() %></td>
		   		<td><%=user.getAddress() %></td>
		   		<td><%=user.getTell() %></td>
		   		<td><%=user.getDescription() %></td>
		   		<td>
		   			<a href="UserServlet?method=preUpdate&id=<%=user.getId() %>">修改</a> | 
		   			<a href="javascript:void(0);" onClick="deleteUser('<%=user.getId() %>');">删除</a>
		   		</td>
		   	</tr> 				
			   <%		
			   		}
			   %> 
			 --%>
 			 <c:forEach var="user" varStatus="vs" items="${list}">
 			 	 <tr align="center">
	 			 	<td>${vs.index+1 }</td>
	 			 	<td>${user.name }</td>
	 			 	<td>
	 			 		<c:if test="${user.sex}" var="test" scope="request">
	 			 			<p>男</p>
	 			 		</c:if>
	 			 		<c:if test="${!test}">
	 			 			<p>女</p>
	 			 		</c:if>
	 			 	</td>
	 			 	<td>${user.age }</td>
	 			 	<td>${user.address }</td>
	 			 	<td>${user.tell }</td>
	 			 	<td>${user.description }</td>
	 			 	<td>
	 			 		<a href="UserServlet?method=preUpdate&id=${user.id }">修改</a>|
	 			 		<a href="javascript:void(0);" onClick="deleteUser(${user.id});">删除</a>
	 			 	</td>
 				 </tr>
 			 </c:forEach> 
 			
   		</table>
  </body>
</html>
