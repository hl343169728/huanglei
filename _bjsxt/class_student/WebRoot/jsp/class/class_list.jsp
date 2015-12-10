<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'class_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript">
		function addClass(){
			window.location = "jsp/class/class_add.jsp";
		};
	</script>
  </head>
  
  <body>
  	<input type="button" value="添加班级" onclick="addClass();"/>
    <form action="" method="post">
    	<table border="1" style="border-collapse: collapse;" width="80%">
    		<tr align="center">
    			<td>班级名称</td>
    			<td>地址</td>
    			<td>任课老师</td>
    			<td>行数</td>
    			<td>列数</td>
    			<td>操作</td>
    		</tr>
    		<s:iterator var="temp" value="list">
    			<tr align="center">
    				<td><s:property value="#temp.cname"/></td>
    				<td><s:property value="#temp.address"/></td>
    				<td><s:property value="#temp.teacher"/></td>
    				<td><s:property value="#temp.crow"/></td>
    				<td><s:property value="#temp.ccol"/></td>
    				<td>
    					<a href=ClzAction!detail?classId=${temp.id }>班级详情</a>
    				</td>
    			</tr>
    		</s:iterator>
    	</table>
    	<input type="button" value="返回" onclick="javascript:history.back();"/>
    </form>
  </body>
</html>
