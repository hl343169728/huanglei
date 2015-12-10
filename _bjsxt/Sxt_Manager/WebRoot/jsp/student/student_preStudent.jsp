<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'student_preStudent.jsp' starting page</title>
    
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
					$('#myform').attr('action','StudentAction!preStudent?gradeId='+$('#sel').combobox('getValue'));
					//$('#gradeId').val($('#sel').combobox('getValue'));
					$('#myform').get(0).submit();
				}else{
					$.messager.confirm('提示信息','提交失败！','error');
				}
			});
			//$('#sel').combobox('setValue',${id});
		});
	</script>
  </head>
  
  <body>
   <div id="p" class="easyui-panel" title="转为预备学员" icon="icon-save"
		collapsible="true"  maximizable="true" 
		style="width: 1000px; height: 400px; padding: 10px; background: #fafafa;">
		<form id="myform" action="" method="post">
			<input name="id" type="hidden" value="${student.id }"/>
			<input id="gradeId" name="gradeId" type="hidden" value="0"/>
			<table>
				<tr align="center">
					<td colspan="2">学员【${studentName}】转为预备学员</td>
				</tr>
				<tr>
					<td>选择班级：</td>
					<td><input id="sel" class="easyui-combobox" url="GradeAction!getClassNumber" valueField="id" textField="classNumber" listWidth="auto" value="--请选择--"/></td>	
				</tr>
				<tr>
					<td>学费支付类型：</td>
					<td>
						<input id="payType" type="radio" name="student.payType" value="先就业后付款"  checked="checked"/>先就业后付款&nbsp;&nbsp;
						<input id="payType" type="radio" name="student.payType" value="学期内付清"/>学期内付清&nbsp;&nbsp;
					</td>
				</tr>
				<tr>
					<td>是否需要安排住宿：</td>
					<td>
						<input id="liveFlag" type="radio" name="student.liveFlag" value="是"/>是&nbsp;&nbsp;
						<input id="liveFlag" type="radio" name="student.liveFlag" value="否"/>否&nbsp;&nbsp;
					</td>
				</tr>
				<tr>
					<td>是否需要提供电脑：</td>
					<td>
						<input id="computerFlag" type="radio" name="student.computerFlag" value="是"/>是&nbsp;&nbsp;
						<input id="computerFlag" type="radio" name="student.computerFlag" value="否"/>否&nbsp;&nbsp;
					</td>
				</tr>
				<tr>
					<td>其他信息：</td>
					<td>
						<textarea id="description" name="student.description" rows="5" cols="30">${student.description }</textarea>
					</td>
				</tr>
				<tr>
					<td>
						<a id="btn" class="easyui-linkbutton" iconCls="icon-ok" type="button" href="javascript:void(0);">提交</a>
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
