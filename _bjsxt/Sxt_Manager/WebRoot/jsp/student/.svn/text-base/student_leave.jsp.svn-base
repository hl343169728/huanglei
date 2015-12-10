<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'student_leave.jsp' starting page</title>
    
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
			} else {
				$.messager.alert('提示信息' ,'提交失败' ,'error');
			}
		});
	});
	</script>
  </head>
  
  <body>
  	<div id="p" class="easyui-panel" title="修改意向学员为不来学员" icon="icon-save" collapsible="true"
  			maximizable="true" style="width:1000px;heigth:400px;padding:10px;background:#fafafa;">
  			<form id="myform" action="StudentAction!leave" method="post">
  				<input type="hidden" name="id" value="${student.id }"/> 
  				<table>
  					<tr align="center">
							<td colspan="2">学员【${student.sname}】不来原因</td>
					</tr>	
  					<tr>
  						<td>不来原因：</td>
  						<td>
  							<textarea id="nonArrivalReason" name="student.nonArrivalReason" rows="10" cols="50"></textarea>
  						</td>
  					</tr>
  					<tr align="center">
  						<td colspan="2">
  							<a class="easyui-linkbutton" id="btn" iconCls="icon-ok" type="button" href="javascript:void(0);">提交</a>
  							<a class="easyui-linkbutton" iconCls="icon-back" type="button" href="javascript:history.back();">返回</a>
  						</td>
  					</tr>
  				</table>
  			</form>
  	</div>
  </body>
</html>
