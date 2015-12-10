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
		//添加员工
		function addEmployee(){
			window.location = "jsp/employee/employee_add.jsp";
		};

		//批量选取
		function selectAll(){
			var selAll = document.getElementById('selAll');
			var ids = document.getElementsByName('ids');
			if(selAll.checked){
				for(var i = 0 ;i < ids.length; i++){
					ids[i].checked = 1;
				}
			}else{
				for(var i = 0; i < ids.length; i++){
					ids[i].checked = 0;
				}
			}
		};

		//删除方法
		function deleteAll(myform){
			if(confirm('确认删除选中的信息吗？')){
				myform.action = "EmployeeAction!del";
				myform.submit();
				return true;
			}else{
				return false;
			}
		};

		//修改方法
		function update(myform){
			if(confirm("确认修改选中的对象吗？")){
				myform.action = "EmployeeAction!preUpdate";
				myform.submit();
				return true;
			}else{
				return false;
			}
		};
	</script>

  </head>
  
  <body>
	  <form action="" method="post">
	  	   <div>
			  	<input type="button" value="添加员工" onclick="addEmployee();"/>
			  	<input type="button" value="批量删除" onclick="deleteAll(this.form);";/>
		   </div>
		    <table border="1" style="border-collapse: collapse;" width="80%">
		    	<tr align="center">
		    		<td><input id="selAll" type="checkbox" onclick="selectAll();"/></td>
		    		<td>序号</td>
		    		<td>姓名</td>
		    		<td>年龄</td>
		    		<td>地址</td>
		    		<td>联系方式</td>
		    		<td>操作</td>
		    	</tr>
		    	<c:forEach var="temp" varStatus="vs" items="${list}">
		    		<tr align="center">
		    			<td><input id="ids" name="ids" type="checkbox" value="${temp.id}"/></td>
		    			<td>${vs.index+1}</td>
		    			<td>${temp.name}</td>
		    			<td>${temp.age}</td>
		    			<td>${temp.address}</td>
		    			<td>${temp.phone}</td>
		    			<td>
		    				<a href=EmployeeAction!preUpdate?id=${temp.id}>修改</a> | <a href=EmployeeAction!del?id=${temp.id}>删除</a>
		    			</td>
		    		</tr>
		    	</c:forEach>
		    </table>
		    <div>
			    <!-- <input type="button" value="修改" onclick="update(this.form);"/> -->	
		    </div>
	  </form>
  </body>
</html>
