<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'employee_leave.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@ include file="../../jsp/globalresults/commons.jsp" %>
	
	<script type="text/javascript">
		$(function(){	
			var param = '${param.id}'; 
			
			//日期控件
			$('#cizhiTime , #lizhiTime').datebox({
				currentText : '今天',
				closeText : '关闭',
				disabled : false,
				required : true,
				missingMessage : '该项必填！',
				formatter : formatDate			//formatDate (utils.js)
			});

			$('#btn').click(function(){
				if($('#myform').form('validate')){
					$('#myform').get(0).submit();
				} else {
					$.messager.alert('提示信息' ,'提交失败' ,'error');
				}
			});
		});
	</script>
  </head>
  
  <body>
	<div id="p" class="easyui-panel" title="辞职申请" icon="icon-save"
				collapsible="true"  maximizable="true" 
				style="width: 1000px; height: 400px; padding: 10px; background: #fafafa;">
			<form id="myform" action="EmployeeAction!leave" method="post">
					<input type="hidden" name="id" value="${employee.id}" />
					<table>
						<tr align="center">
							<td colspan="2">员工【${employee.ename}】辞职登记</td>
						</tr>					
						<tr align="center">
							<td>辞职日期:</td>
							<td><input id="cizhiTime" name="employee.cizhiTime"></td>
						</tr>
						<tr align="center">
							<td>离职日期:</td>
							<td><input id="lizhiTime" name="employee.lizhiTime"></td>
						</tr>	
						<tr align="center">
							<td>辞职原因:</td>
							<td><textarea id="cizhiReason" name="employee.cizhiReason" cols="50" rows="5"></textarea></td>
						</tr>	
						<tr align="center">
							<td colspan="2">
								<a class="easyui-linkbutton" id="btn" iconCls="icon-ok" type="button"  href="javascript:void(0)" >提交申请</a>
								<a class="easyui-linkbutton" iconCls="icon-back" type="button"  href="javascript:history.back()" >返回</a>
							</td>
						</tr>																	
					</table>
			</form>	
	</div>
  </body>
</html>
