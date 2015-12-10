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
    
    <title>My JSP 'employee_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
		//增加员工函数
		function addEmp(){
			window.location = "EmployeeServlet?method=preSave";
		}
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
		}
		//删除员工 
		function deleteEmps(myform){
			if(confirm('确认删除吗？')){
				myform.action = "EmployeeServlet?method=delete";
				myform.submit();
				return true;
			}else{
				return false;
			}
		}
	</script>

  </head>
  
  <body>
  	<form action="" method="post">
		<div>
			<input type="button"  value="新增员工" onclick="addEmp();" />
			<input type="button"  value="批量删除" onclick="deleteEmps(this.form);"  />
		</div>
		<table border="1" width="80%" style="border-collapse:collapse;">
			<tr>
				<th>
					<input id="selAll" type="checkbox" onclick="selectAll(); " />
				</th>
				<th>序号</th>
				<th>员工名称</th>
				<th>薪水</th>
				<th>联系方式</th>
				<th>出生日期</th>
				<th>入职日期</th>
				<th>职位</th>
				<th>操作</th>
			</tr>
			<c:forEach var="temp" varStatus="vs" items="${list}">
				<tr align="center">
					<td>
						<input name="ids" id="ids" type="checkbox" value="${temp.id}" />
					</td>
					<td>${vs.index+1 }</td>
					<td>${temp.empName }</td>
					<td>${temp.salary }</td>
					<td>${temp.tell }</td>
					<td>${temp.birthday }</td>
					<td>${temp.hiredate }</td>
					<td>${temp.posName }</td>
					<td><a href="EmployeeServlet?method=preUpdate&id=${temp.id }">修改</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>	
  </body>
</html>
