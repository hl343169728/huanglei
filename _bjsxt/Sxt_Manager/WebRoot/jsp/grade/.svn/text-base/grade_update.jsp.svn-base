<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'grade_update.jsp' starting page</title>
    
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
				checkName:{
					validator:function(value,param){
						return value.length>=param[0]&& value.length<=param[1];
						}
					,
					message:''
				}
			});
			//日期框
			$('#startTime , #endTime').datebox({
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
						$('#myform').attr('action','GradeAction!updateGrade');
						$('#teacherId').val($('#sel').combobox('getValue'));
						$('#myform').get(0).submit(); //JQuery对象转为dom对象的方式提交 
					}else{
						$.messager.alert('提示信息 ','提交失败  ','error'); 
					}
			});
			$('#sel').combobox('setValue',${id});
		});
	</script>
  </head>
  <body>
  	<!--title:标题 
  		maximizable:最大化
  		icon:图标
  		
  	 -->
	<div id="p" class="easyui-panel" title="修改班级" icon="icon-save" collapsible="true"  maximizable="true" 
			style="width: 1000px; height: 400px; padding: 10px; background: #fafafa;">
		<form id="myform" action="" method="post">
			<input id="id" name="id" type="hidden" value="${grade.id }"/>
			<input id="teacherId" name="teacherId" type="hidden" value="0"/>
			<table>
				<tr>
					<td>班级编号：</td>
					<td><input id="classNumber" name="grade.classNumber" class="easyui-validatebox" required="true" missingMessage="该项必填!" validType="" invalidMessage="城市编号-时间-教学地点" value="${grade.classNumber }" /></td>
				</tr>
				<tr>
					<td>开班日期：</td>
					<td><input id="startTime" name="grade.startTime" value="${grade.startTime}"/></td> 
				</tr>
				
				<tr>
					<td>结课日期：</td>
					<td><input id="endTime" name="grade.endTime" value="${grade.endTime}"/></td>
				</tr>
				<tr>
					<td>班级类型：</td>
					<td>
						<input name="grade.type" type="radio" value="业余班"  ${grade.type eq "业余班"?"checked":"" }/>业余班&nbsp;&nbsp;
						<input name="grade.type" type="radio" value="脱产班"  ${grade.type eq "脱产班"?"checked":"" }/>脱产班&nbsp;&nbsp;
						<input name="grade.type" type="radio" value="基地班"  ${grade.type eq "基地班"?"checked":"" }/>基地班&nbsp;&nbsp;
						<input name="grade.type" type="radio" value="网络版"  ${grade.type eq "网络版"?"checked":"" }/>网络版&nbsp;&nbsp;
						<input name="grade.type" type="radio" value="远程同步班"  ${grade.type eq "远程同步班"?"checked":"" }/>远程同步班&nbsp;&nbsp;
					</td>
				</tr>
				<tr>
					<td>总学费：</td>
					<td><input name="grade.totalFee" value="${grade.totalFee}"/></td>
				</tr>
				<tr>
					<td>一次性付清学费：</td>
					<td><input name="grade.payFee" value="${grade.payFee}"/></td>
				</tr>
				<tr>
					<td>首付款：</td>
					<td><input name="grade.prePayFee" value="${grade.prePayFee}"/></td>
				</tr>
				<tr>
					<td>班主任：</td>
					<td>
						<input id="sel" class="easyui-combobox" url="EmployeeAction!getTeacherName" valueField="id" textField="ename" listWidth="auto" value="${employeeName}"/>
					</td>
				</tr>										
				<tr>
					<td>
						<a id="btn" class="easyui-linkbutton" iconCls="icon-ok" href="javascript:void(0);">修改班级</a>
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
