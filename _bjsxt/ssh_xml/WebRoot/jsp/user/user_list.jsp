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
    
    <title>My JSP 'user_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	
	<SCRIPT type="text/javascript">
		//删除用户的函数
		function deleteUser(id){
			if(confirm("确认删除吗？")){
				window.location = "userAction!del?id="+id;
			}	
		};

		//添加用户的函数 
		function addUser(){
			window.location = "jsp/user/user_add.jsp";
		};
	</SCRIPT>

  </head>
  
  <body>
    	<s:action name="userAction!list" namespace="/" var="a"></s:action>
    	<div align="center">
    		<font style="color:red" size=5><b>用户信息列表</b></font>
    	</div><br/>
    	<fieldset>
  			<legend onclick="$('#dv').toggle(1000);">查询面板</legend>
  			<div id="dv">
  				<form action="userAction!list" method="post">
  					姓名：<input name="name" value=""/><br/>
  					<input type="submit" value="查询"/>
  				</form>
  			</div>
  		</fieldset><hr/>
    	<div align="center" style="width:46%">
    		<input type="button" value="添加用户" onclick="addUser();"/>
    	</div>
    	<table align="center" style="border-collapse: collapse;" border="1" width="60%">
    		<tr align="center">
    			<td>序号</td>
    			<td>姓名</td>
    			<td>联系方式</td>
    			<td>家庭住址</td>
    			<td>具体操作</td>
    		</tr>
    		<s:iterator var="temp" value="#a.pageInfo.list">
    			<tr align="center">
    				<td><s:property value="#temp.id"/></td>
    				<td><s:property value="#temp.name"/></td>
    				<td><s:property value="#temp.phone"/></td>
    				<td><s:property value="#temp.address"/></td>
    				<td>
    					<a href=userAction!preUpdate?id=${temp.id}>修改</a> |
    					<a href="javascript:void(0);" onclick="deleteUser(${temp.id})">删除</a>
    				</td>
    			</tr>
    		</s:iterator>
    	</table>
    	<hr/>
    	<jsp:include page="../../util/pageUtil.jsp">
    		<jsp:param value="userAction!list?name=${name}" name="url"/>
    	</jsp:include>
    	<hr/>
  </body>
</html>
