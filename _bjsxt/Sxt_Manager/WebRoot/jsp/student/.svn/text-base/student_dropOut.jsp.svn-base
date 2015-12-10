<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'student_dropOut.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@ include file="../../jsp/globalresults/commons.jsp" %>

	<script type="text/javascript">
	$(function(){
		$('#btn').click(function(){
			if($('#myform').form('validate')){
				$('#myform').get(0).submit();
			}else{
				$.messager.confirm('提示信息','提交失败！','error');
			}
		});
	});
	</script>
  </head>
  
  <body>
   	 <div id="p" class="easyui-panel" title="学员退学信息表" icon="icon-save"
		collapsible="true"  maximizable="true" 
		style="width: 1000px; height: 400px; padding: 10px; background: #fafafa;">
		<form  id="myform"  action="StudentAction!dropOut" method="post">
			<input type="hidden" id="id" name="id" value="${student.id }"/>
			<table>
				<tr align="center">
					<td colspan="4">学员【${student.sname}】退学</td>
				</tr>
				<tr>
					<td>实缴学费：</td>
					<td><input name="student.prePayFee" value="${prePayFee}"/></td>
					<td>应缴学费：</td>
					<td>${student.fee }</td>
				</tr>
				<tr>
					<td>应退学费：</td>
					<td><input name="student.feeQuit" value=""/></td>
				</tr>
				<tr>
					<td>退学理由：</td>
					<td>
						<textarea name="student.leaveReason" rows="5" cols="30"></textarea>
					</td>
				</tr>
				<tr>
					<td>
						<a id="btn" class="easyui-linkbutton" iconCls="icon-ok" type="button" href="javascript:void(0);">退学</a>
					</td>
					<td>
						<a class="easyui-linkbutton" iconCls="icon-back" type="button" href="javascript:history.back();">返回</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
  </body>
</html>
