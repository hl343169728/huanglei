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
    
    <title>My JSP 'employee_update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.2.6/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.2.6/themes/icon.css">
	<script type="text/javascript" src="js/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>

	<script type="text/javascript">
		function formatDate(v) {
			if (v instanceof Date) {
				var y = v.getFullYear();
				var m = v.getMonth() + 1;
				var d = v.getDate();
				var h = v.getHours();
				var i = v.getMinutes();
				var s = v.getSeconds();
				var ms = v.getMilliseconds();
				if (ms > 0)
					return y + '-' + m + '-' + d + ' ' + h + ':' + i + ':' + s
							+ '.' + ms;
				if (h > 0 || i > 0 || s > 0)
					return y + '-' + m + '-' + d + ' ' + h + ':' + i + ':' + s;
				return y + '-' + m + '-' + d;
			}
			return '';
		}
		
		$(function(){
			$('#birthday ,#hiredate ').datebox({
					currentText : '今天',
					closeText : '关闭',
					disabled : false,
					required : true,
					missingMessage : '该项必填' ,
					formatter : formatDate
			});
		});
	</script>

  </head>
  
  <body>
 	<form action="EmployeeServlet" method="post">
 	
 		<input type="hidden" name="method" value="update" />
 		<input type="hidden" name="id" value="${emp.id }"/>
 		
 		<table>
 			<tr>
 				<td>员工名称：</td>
 				<td><input name="name" value="${emp.name }" /></td>
 			</tr>
 			<tr>
 				<td>密码：</td>
 				<td><input type="password" name="password" value="${emp.password }" /></td>
 			</tr>
 			<tr>
 				<td>薪水：</td>
 				<td><input name="salary" value="${emp.salary}" /></td>
 			</tr>
 			<tr>
 				<td>联系方式：</td>
 				<td><input name="tell" value="${emp.tell}" /></td>
 			</tr>
 			<tr>
 				<td>出生日期：</td>
 				<td><input id="birthday" name="birthday" value="${emp.birthday}" /></td>
 			</tr>
 			<tr>
 				<td>入职日期：</td>
 				<td><input id="hiredate" name="hiredate" value="${emp.hiredate}" /></td>
 			</tr>
 			<tr>
 				<td>职称：</td>
 				<td>
 					<select name="pid">
 						<option value="0">--请选择--</option>
 						<c:forEach var="temp" items="${pList}">
 							<c:choose>
 								<c:when test="${temp.id eq emp.p_id}">
 									<option value="${temp.id }" selected="selected">${temp.name }</option>
 								</c:when>
 								<c:otherwise>
 									<option value="${temp.id }">${temp.name }</option>
 								</c:otherwise>
 							</c:choose>
 						</c:forEach>
 					</select>
 				</td>
 			</tr>
 			<tr>
 				<td><input type="submit" value="修改员工信息" /></td>
 				<td><input type="button" value="返回" onclick="javascript:history.back();"/></td>
 			</tr>
 		</table>
 	</form>
  </body>
</html>
