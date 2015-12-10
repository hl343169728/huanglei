<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'shouru_in.jsp' starting page</title>
    
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
					$('#myform').get(0).submit(); //JQuery对象转为dom对象的方式提交 
				}else{
					$.messager.alert('提示信息 ','提交失败  ','error');
				}
			});

			$('#btn_1').click(function(){
				$('#mydiv').css('display','block');
				$.ajax({
					type : 'post',
					timeout : 2000,
					dataType : 'text' , 
					url : 'ShouruAction!getStudentShouruMessage',
					async : false,
					data : {studentid:$('#sel_2').combobox('getValue')},
					success : function(result){
					  	var data = eval(result);
					  	var a = $('#yingjiaoxuefei').html(data[0].free);
					  	var b = $('#yijiaoxuefei').html(data[data.length-1].readlyPay);
					  	$('#qiankuan').html(data[0].free-data[data.length-1].readlyPay);
					  	for(var i = 0; i < data.length; i ++){
					  		$('#mydiv').append('<br/>'+data[i].list[0].shouruTime+':缴纳'+data[i].list[0].jine+'。录入:'+data[i].list[0].uname);
					  	}
					 }
				});
			});

			//
			$('#btn_1').click(function(){
				$('#div1').dialog('open');
			});

			//
			$('#btn_2').click(function(){
				$('#div2').dialog('open');
			});
		});	
	</script>
	
  </head>
  
  <body>
    <div id="p" class="easyui-panel" title="录入财政收入" icon="icon-save"
		collapsible="true"  maximizable="true" 
		style="width: 1000px; height: 500px; padding: 10px; background: #fafafa;">
			<form id="myform" action="ShouruAction!saveShouru" method="post">
				<table>
					<tr>
						<td>选择学生：</td>
						<td>
							<input id="sel_1" name="" class="easyui-combobox" url="GradeAction!getClassNumber" valueField="id" textField="classNumber" listWidth="auto" value="--请选择班级--"/>
							<input id="sel_2" name="shouru.studentId" class="easyui-combobox" valueField="id" textField="sname" listWidth="auto" value="--请选择学生--"/>
						</td>
						<td>
							<a id="btn_1" class="easyui-linkbutton" type="button" href="javascript:void(0);" >查看选中学生详情</a>
						</td>
						<td>
							<a id="btn_2" class="easyui-linkbutton" type="button" href="javascript:void(0);" >修改选中学生信息</a>
						</td>
					</tr>
					<tr>
						<div id="div1" iconCls="icon-ok" draggable="false" class="easyui-dialog"  title="学生详情" style="padding: 10px;width: 500;height:400;" 
				 			 closed="true" maximizable="false" minimizable="false" collapsible="false">
				 			 	<iframe width="100%" style='overflow:scroll;' scrolling="yes" height=85% frameborder="0" src=""></iframe>
				 		</div>
					</tr>
					<tr>
						<div id="div2" iconCls="icon-ok" draggable="false" class="easyui-dialog"  title="修改选中学生信息" style="padding: 10px;width: 800;height:400;" 
				 			 closed="true" maximizable="false" minimizable="false" collapsible="false">
				 			 	<iframe width="100%" style='overflow:scroll;' scrolling="yes" height=85% frameborder="0" src="jsp/student/student_update.jsp"></iframe>
				 		</div>
					</tr>
					<tr>
						<td colspan="5">
							 <div  id="mydiv"  style="width:500px;height:200px;border:1px solid #CCC;display: none;" >
							 	列出该学生支付情况和历史记录：<br/>
							 	1、应缴学费：<span id="yingjiaoxuefei"></span><br/>
							 	2、已缴学费：<span id="yijiaoxuefei"></span><br/>
							 	3、欠款：	<span id="qiankuan"></span><br/></br>
							 	缴费历史:
							 </div>
						</td>
					</tr>
					<tr>
						<td>今日缴纳金额：</td>
						<td><input id="jine" name="shouru.jine" class="easyui-validatebox" required="true" missingMessage="该项必填!" validType="" invalidMessage="必须为数字" value=""/></td>
					</tr>
					<tr>
						<td>收入日期：</td>
						<td><input id="shouruTime" name="shouru.shouruTime"  value=""/></td>
					</tr>
					<tr>
						<td>描述：</td>
						<td colspan="4">
							<textarea id="descrpt" name="shouru.descrpt" rows="5" cols="60"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<a id="btn" class="easyui-linkbutton" iconCls="icon-ok" type="button" href="javascript:void(0);">提交输入信息</a>
						</td>
					</tr>
				</table>
			</form>
	</div>	
  </body>
</html>
