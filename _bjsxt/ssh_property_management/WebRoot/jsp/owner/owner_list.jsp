<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'owner_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript">
		//添加业主
		function addOwner(){
			window.location = "jsp/owner/owner_add.jsp";
		};

		//删除指定的业主
		function delOwner(id){
			if(confirm("确认删除吗？")){
				window.location = "ownerAction!del?id="+id;
				return true;
			}else{
				return false;
			}
		};
	</script>

  </head>
  
  <body>
  		<br/>
  		<s:action name="ownerAction!list" namespace="/" var="a"></s:action>
  		<div align="center">
  			<font color="red" size=5><b>业主的基本信息</b></font>
  		</div><br/>
  		<div align="center" style="width:30%">
  			<input type="button" value="添加住户信息" onclick="addOwner();"/>
  		</div>
    	<table border="1" style="border-collapse: collapse;" align="center" width="80%">
    		<tr align="center">
    			<th>序号</th>
    			<th>业主姓名</th>
    			<th>年龄</th>
    			<th>性别</th>
    			<th>联系方式</th>
    			<th>联系地址</th>
    			<th>具体操作</th>
    		</tr>
    		<c:forEach var="temp" varStatus="vs" items="${a.list}">
    			<tr align="center">
    				<td>${vs.index+1}</td>
    				<td>${temp.oname}</td>
    				<td>${temp.age}</td>
    				<td>
    					<c:choose>
    						<c:when test="${temp.sex eq '1'}">
    							<span>男</span>
    						</c:when>
    						<c:otherwise>
    							<span>女</span>
    						</c:otherwise>
    					</c:choose>
					</td>
    				<td>${temp.phone}</td>
    				<td>${temp.address}</td>
    				<td>
    					<a href=ownerAction!detail?id=${temp.id}>详情</a> |
    					<a href=ownerAction!preUpdate?id=${temp.id}>修改</a> |
    					<a href="javascript:void(0);" onclick="delOwner(${temp.id});">删除</a>
    				</td>
    			</tr>
    		</c:forEach>
    	</table>
  </body>
</html>
