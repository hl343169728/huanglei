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
    
    <title>My JSP 'position_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript">
		//增加岗位函数  
		function addPosition(){
			window.location = "jsp/position/position_add.jsp";
		}
		//删除函数 
		function deletePositions(myform){
			if(confirm('确认删除吗？')){
				myform.action = "PositionServlet?method=delete";
				myform.submit();
				return true;
			}else{
				return false;
			}
		}
		//批量选取 
		function selectAll(){
			var selall = document.getElementById('selAll');
			var ids = document.getElementsByName('ids');
			if(selall.checked){
				for(var i=0;i<ids.length;i++){
					ids[i].checked = 1;
				}
			}else{
				for(var i=0;i<ids.length;i++){
					ids[i].checked = 0;
				}
			}
		}
	</script>
  </head>
  
  <body>
    <form action="" method="post">
    	<div>
    		<input type="button" value="增加岗位" onclick="addPosition();" />
    		<input type="button" value="批量删除" onclick="deletePositions(this.form);" />
    	</div>
    	<table border="1" width="80%" style="border-collapse: collapse;">
    		<tr>
    			<th><input id="selAll" type="checkbox" onclick="selectAll();" /></th>
    			<th>序号</th>
    			<th>岗位名称</th>
    			<th>岗位等级</th>
    			<th>岗位描述</th>
    			<th>操作</th>
    		</tr>
    		<c:forEach var="temp" varStatus="vs" items="${pList}">
    			<tr align="center">
    				<td><input name="ids" id="ids" type="checkbox" value="${temp.id}" /></td>
    				<td>${vs.index+1}</td>
    				<td>${temp.name }</td>
    				<td>
    					<c:choose>
    						<c:when test="${temp.level eq '1'}">高级</c:when>
    						<c:when test="${temp.level eq '2'}">中级</c:when>
    						<c:when test="${temp.level eq '3'}">普通</c:when>
    					</c:choose>
    				</td>
    				<td>${temp.description }</td>
    				<td><a href="PositionServlet?method=preUpdate&id=${temp.id}">修改</a></td>
    			</tr>
    		</c:forEach>
    	</table>
    </form>
  </body>
</html>
