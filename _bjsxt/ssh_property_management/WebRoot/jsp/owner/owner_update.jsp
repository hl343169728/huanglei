<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'owner_update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@ include file="../../jsp/globalresults/commons.jsp" %>
	
	<script type="text/javascript">
		$(function(){
			//日期控件
			$('#inTime, #outTime').datebox({
				currentText : '今天',
				closeText : '关闭',
				disabled : false,
				required : true,
				missingMessage : '该项必填！',
				formatter : formatDate			//formatDate (utils.js)
			});
		});
	</script>
	
  </head>
  
  <body>
  		<br/>
  		<div align="center">
  			<font color="red" size="5"><b>业主信息修改</b></font>
  		</div><br/>
    	<form action="ownerAction!update" method="post">
    		<input name="id" type="hidden" value="${owner.id}"/>
    		<table align="center" border="1" style="border-collapse: collapse;" width="40%">
    			<tr>
    				<td>业主姓名：</td>
    				<td><input name="owner.oname" value="${owner.oname}"/></td>
    			</tr>
    			<tr>
    				<td>年龄：</td>
    				<td><input name="owner.age" value="${owner.age}"/></td>
    			</tr>
    			<tr>
    				<td>性别：</td>
    				<td>
    					<input name="owner.sex" type="radio" value="1" ${owner.sex eq "1"?"checked":"" }/>男&nbsp;&nbsp;
    					<input name="owner.sex" type="radio" value="0" ${owner.sex eq "0"?"checked":"" }/>女
    				</td>
    			</tr>
    			<tr>
    				<td>Email:</td>
    				<td><input name="owner.email" value="${owner.email}"/></td>
    			</tr>
    			<tr>
    				<td>身份证号：</td>
    				<td><input name="owner.cardid" value="${owner.email}"/></td>
    			</tr>
    			<tr>
    				<td>联系方式：</td>
    				<td><input name="owner.phone" value="${owner.phone}"/></td>
    			</tr>
    			<tr>
    				<td>联系地址：</td>
    				<td><input name="owner.address" value="${owner.address}"/></td>
    			</tr>
    			<tr>
    				<td>迁入日期：</td>
    				<td><input id="inTime" name="owner.inTime" value="${owner.inTime}"/></td>
    			</tr>
    			<tr>
    				<td>迁出日期：</td>
    				<td><input id="outTime" name="owner.outTime" value="${owner.outTime}"/></td>
    			</tr>
    			<tr>
    				<td>备注：</td>
    				<td>
    					<textarea name="owner.remark" rows="3" cols="40">${owner.remark}</textarea>
    				</td>
    			</tr>
    			<tr>
    				<td colspan="2">
    					<input type="submit" value="修改信息"/>
    					<input type="button" value="返回" onclick="javascript:history.back();"/>
    				</td>
    			</tr>
    		</table>
    	</form>
  </body>
</html>
