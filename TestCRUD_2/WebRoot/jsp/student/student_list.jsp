<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.bjsxt.model.Student"%>
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
		function addStudent(){
			window.location = "jsp/student/student_add.jsp";
		}

		function deleteStudent(id){
			if(confirm("确认删除吗？")){
				window.location = "StudentServlet?method=delete&id="+id;
				return true;
			}else{
				return false;
			}
		}
	</script>

  </head>
  
  <body>
 	<div>
 		<input type="button" value="添加学员" onclick="addStudent();" />
 	</div>
 	<table border="1" width="90%" style="border-collapse:collapse">
 		<tr>
 			<th>序号</th>
 			<th>姓名</th>
 			<th>学号</th>
 			<th>生日</th>
 			<th>性别</th>
 			<th>爱好</th>
 			<th>毕业院校</th>
 			<th>民族</th>
 			<th>星座</th>
 			<th>操作</th>
 		</tr>
 		<%
 			//遍历出数据库中学员的列表信息
 			List<Student> sList = (List<Student>)request.getAttribute("sList");
 			for(int i=0;i<sList.size();i++){
 				Student s = sList.get(i);
 		%>
 		<tr align="center">
 			<td><%= i+1 %>            					</td>
 			<td><%=s.getName() %>						</td>
 			<td><%=s.getCardId() %>						</td>
 			<td><%=s.getBirthday() %>					</td>
 			<td><%="1".equals(s.getSex())?"男":"女" %>	</td>
 			<td><%=s.getFavorite() %>					</td>
 			<td><%=s.getUniversity() %>					</td>
 			<td><%=s.getNationality() %>				</td>
 			<td><%=s.getConstellation() %>				</td>
 			<td>
	   			<a href="StudentServlet?method=preUpdate&id=<%=s.getId()%>">修改</a> | 
	   			<a href="javascript:void(0);" onclick="deleteStudent('<%=s.getId()%>');">删除</a>
		   	</td>
 		</tr>
 		<%
 			}
 		%>
 	</table>
  </body>
</html>
