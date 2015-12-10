<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'shouru_update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@ include file="../../jsp/globalresults/commons.jsp" %>
	<script type="text/javascript">
		//自定义的校验器 
		$(function(){
			$.extend($.fn.validatebox.defaults.rules,{ //验证框 
				check:{
					validator:function(value,param){
						return value.length>=param[0] && value.length<=param[1];
						}
					,
					message:''
				}
			});

			//组合框 
			$('#sel_1').combobox({
				onChange: function(newValue , oldValue){ 
					$('#sel_2').combobox('reload' , 'StudentAction!getStudentByGradeId?gradeId='+$('#sel_1').combobox('getValue'));
				}
			});	
			
			//日期框
			$('#shouruTime').datebox({
				currentText : '今天', 			//为当前日期按钮显示的文本 
				closeText : '关闭',  			//关闭按钮显示的文本 
				disabled : false,	  			//如果为true，则禁用输入框 
				required : true,	  			//定义输入框是否为必填项 
				missingMessage : '该项必填！',	//当文本框为空的时候显示的文本
				formatter : formatDate			//formatDate (utils.js)
			});
			
			//提交表单 
			$('#btn').click(function(){
				if($('#myform').form('validate')){//固定的写法
					//$('#myform').attr('action','ShouruAction!updateShouru');
					//$('#studentId').val($('#sel_2').combobox('getValue'));
					$('#myform').get(0).submit(); //JQuery对象转为dom对象的方式提交 
				}else{
					$.messager.alert('提示信息 ','提交失败  ','error');
				}
			});
			//$('#sel_2').combobox('setValue',${id});
		});	
	</script>
	
  </head>
  
  <body>
    <div id="p" class="easyui-panel" title="修改财政收入" icon="icon-save"
		collapsible="true"  maximizable="true" 
		style="width: 1000px; height: 500px; padding: 10px; background: #fafafa;">
			<form id="myform" action="ShouruAction!updateShouru" method="post">
				<input name="id" type="hidden" value="${shouru.id }"/>
				<input id="studentId" name="studentId" type="hidden" value="0"/>
				<table>
					<tr>
						<td>选择学生：</td>
						<td>
							<input id="sel_1" name="" class="easyui-combobox" url="GradeAction!getClassNumber" valueField="id" textField="classNumber" listWidth="auto" value=""/>
							<input id="sel_2" name="shouru.studentId" class="easyui-combobox" valueField="id" textField="sname" listWidth="auto" value="${shouru.studentId}"/>
						</td>
						<td>
							<input id="btn_1" type="button" value="查看选中学生详情"/>
							<input id="btn_2" type="button" value="修改选中学生信息"/>
						</td>
					</tr>
					<tr>
						
					</tr>
					<tr>
						<td>今日缴纳金额：</td>
						<td><input id="jine" name="shouru.jine" class="easyui-validatebox" required="true" missingMessage="该项必填!" validType="" invalidMessage="必须为数字" value="${shouru.jine}"/></td>
					</tr>
					<tr>
						<td>收入日期：</td>
						<td><input id="shouruTime" name="shouru.shouruTime"  value="${shouru.shouruTime}"/></td>
					</tr>
					<tr>
						<td>描述：</td>
						<td>
							<textarea id="descrpt" name="shouru.descrpt" rows="5" cols="60">${shouru.descrpt}</textarea>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<a id="btn" class="easyui-linkbutton" iconCls="icon-ok" type="button" href="javascript:void(0);">提交修改</a>
							<a class="easyui-linkbutton" iconCls="icon-back" type="button" href="javascript:history.back();">返回</a>							
						</td>
					</tr>
				</table>
			</form>
	</div>	
  </body>
</html>
