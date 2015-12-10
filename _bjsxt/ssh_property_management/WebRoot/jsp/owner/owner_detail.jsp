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
    
    <title>My JSP 'owner_detail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  	<br/>
    	<div align="center">
    		<font color="red" size=5><b>业主【${owner.oname}】详情</b></font>
    	</div><br/>
    	<form action="" method="post">
    		<table border="1" style="border-collapse: collapse;" width="50%" align="center">
	    		<tr>
	    			<td><b>姓名：</b></td><td align="center">${owner.oname}</td>
	    			<td><b>年龄：</b></td><td align="center">${owner.age}</td>
	    			<td><b>性别：</b></td>
	    			<td align="center">
	    				<c:choose>
	    					<c:when test="${owner.sex eq '1'}">
	    						<span>男</span>
	    					</c:when>
	    					<c:otherwise>
	    						<span>女</span>
	    					</c:otherwise>
	    				</c:choose>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td><b>身份证号：</b></td><td colspan="3">${owner.cardid}</td>
	    			<td><b>联系电话：</b></td><td>${owner.phone}</td>
	    		</tr>
	    		<tr>
	    			<td><b>工作单位：</b></td><td colspan="3"></td>
	    			<td><b>邮政编码：</b></td><td></td>
	    		</tr>
	    		<tr>
	    			<td><b>Email:</b></td><td colspan="5">${owner.email}</td>
	    		</tr>
	    		<tr>
	    			<td><b>联系地址：</b></td><td colspan="5">${owner.address}</td>
	    		</tr>
	    		<tr>
	    			<td><b>办理迁入日期：</b></td><td colspan="5">${owner.inTime}</td>
	    		</tr>
	    		<tr>
	    			<td><b>迁出日期：</b></td><td colspan="5">${owner.outTime}</td>
	    		</tr>
	    		<tr>
	    			<td><b>备注：</b></td>
	    			<td colspan="5">
	    				<textarea rows="3" cols="55">${owner.remark}</textarea>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td colspan="6" align="right"><input type="button" value="返回" onclick="javascript:history.back();"/></td>
	    		</tr>
    		</table>
    	</form>
  </body>
</html>
