<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'owner_add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
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
  			<font color="red" size="5"><b>业主信息登记</b></font>
  		</div><br/>
    	<form action="ownerAction!add" method="post">
    		<table align="center" border="1" style="border-collapse: collapse;" width="40%">
    			<tr>
    				<td>业主姓名：</td>
    				<td><input name="owner.oname" value=""/></td>
    			</tr>
    			<tr>
    				<td>年龄：</td>
    				<td><input name="owner.age" value=""/></td>
    			</tr>
    			<tr>
    				<td>性别：</td>
    				<td>
    					<input name="owner.sex" type="radio" value="1" checked="checked"/>男&nbsp;&nbsp;
    					<input name="owner.sex" type="radio" value="0"/>女
    				</td>
    			</tr>
    			<tr>
    				<td>Email:</td>
    				<td><input name="owner.email" value=""/></td>
    			</tr>
    			<tr>
    				<td>身份证号：</td>
    				<td><input name="owner.cardid" value=""/></td>
    			</tr>
    			<tr>
    				<td>联系方式：</td>
    				<td><input name="owner.phone" value=""/></td>
    			</tr>
    			<tr>
    				<td>联系地址：</td>
    				<td><input name="owner.address" value=""/></td>
    			</tr>
    			<tr>
    				<td>迁入日期：</td>
    				<td><input id="inTime" name="owner.inTime" value=""/></td>
    			</tr>
    			<tr>
    				<td>迁出日期：</td>
    				<td><input id="outTime" name="owner.outTime" value=""/></td>
    			</tr>
    			<tr>
    				<td>备注：</td>
    				<td>
    					<textarea name="owner.remark" rows="3" cols="40"></textarea>
    				</td>
    			</tr>
    			<tr>
    				<td colspan="2">
    					<input type="submit" value="提交信息"/>
    				</td>
    			</tr>
    		</table>
    	</form>
  </body>
</html>
