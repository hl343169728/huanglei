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
    
    <title>My JSP 'user_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<SCRIPT type="text/javascript">
		//添加用户的函数 
		function addUser(){
			window.location = "jsp/user/user_add.jsp";
		};

		//删除用户的函数 
		function delUser(id){
			if(confirm("确认删除吗？")){
				window.location = "userAction!del?id="+id;
				return true;
			}else{
				return false;
			}
		};
	</SCRIPT>

  </head>
  
  <body>
  		<s:action name="userAction!list" namespace="/" var="a"></s:action>
  		<div align="center">
  			<font color="red" size=6><b>用户信息列表</b></font>
  		</div><br/>
  		<div style="width:46%" align="center">
  			<input type="button" value="添加用户" onclick="addUser();"/>
  		</div>
    	<table border="1" style="border-collapse: collapse;" width="60%" align="center">
    		<tr align="center">
    			<th>选择</th>
    			<th>姓名</th>
    			<th>联系方式</th>
    			<th>家庭住址</th>
    			<th>存款</th>
    			<th>具体操作</th>
    		</tr>
    		<s:iterator var="temp" value="#a.list">
    			<tr align="center">
    				<td>
    					<input name="ids" type="checkbox" value="" />
    				</td>
    				<td> <s:property value="#temp.name"/> </td>
    				<td> <s:property value="#temp.phone"/> </td>
    				<td> <s:property value="#temp.address"/> </td>
    				<td> <s:property value="#temp.money"/> </td>
    				<td>
    					<a href=userAction!preUpdate?id=${temp.id}>修改</a> |
    					<a href="javascript:void(0);" onclick="delUser(<s:property value="#temp.id"/>);">删除</a>
    				</td>
    			</tr>
    		</s:iterator>
    	</table>
  </body>
</html>
