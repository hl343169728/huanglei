<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'zhichu_out.jsp' starting page</title>
    
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
			$('#zhichuTime').datebox({
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
    	<div id="p" class="easyui-panel" title="录入支出信息" icon="icon-save"
		collapsible="true"  maximizable="true" 
		style="width: 1000px; height: 500px; padding: 10px; background: #fafafa;">
			<form id="myform" action="ZhichuAction!saveZhichu" method="post">
				<table>
					<tr>
						<td>金额：</td>
						<td><input name="zhichu.jine" class="easyui-validatebox" required="true" missingMessage="该项必填!" validType="" invalidMessage="必须为数字" value=""/></td>
					</tr>
					<tr>
						<td>分类：</td>
						<td><input name="zhichu.type" type="radio" value="1"/>办公耗材</td>
						<td><input name="zhichu.type" type="radio" value="2"/>电费</td>
						<td><input name="zhichu.type" type="radio" value="3"/>水费</td>
						<td><input name="zhichu.type" type="radio" value="4"/>退住宿费</td>
					</tr>
					<tr>
						<td></td>
						<td><input name="zhichu.type" type="radio" value="5"/>退电脑押金</td>
						<td><input name="zhichu.type" type="radio" value="6"/>退学费</td>
						<td><input name="zhichu.type" type="radio" value="7"/>学校返点</td>
						<td><input name="zhichu.type" type="radio" value="8"/>出差费用</td>
					</tr>	
					<tr>
						<td></td>
						<td><input name="zhichu.type" type="radio" value="9"/>工资</td>
						<td><input name="zhichu.type" type="radio" value="10"/>固定资产</td>
						<td><input name="zhichu.type" type="radio" value="11"/>通讯费用</td>
						<td><input name="zhichu.type" type="radio" value="12"/>网络宣传</td>
					</tr>
					<tr>
						<td></td>
						<td><input name="zhichu.type" type="radio" value="13"/>校园宣传</td>
						<td><input name="zhichu.type" type="radio" value="14"/>交通费用</td>
						<td><input name="zhichu.type" type="radio" value="15"/>请客聚会</td>
						<td><input name="zhichu.type" type="radio" value="16"/>学员推荐费用</td>
						<td><input name="zhichu.type" type="radio" value="17"/>其他</td>
					</tr>
									
					<tr>
						<td>简要描述：</td>
						<td colspan="6">
							<textarea name="zhichu.descrpt" rows="5" cols="60"></textarea>
						</td>
					</tr>
					<tr>
						<div id="mydiv" style="display: none;">
							<td>相关学生：</td>
							<td>
								<input id="sel_1" name="" class="easyui-combobox" url="GradeAction!getClassNumber" valueField="id" textField="classNumber" listWidth="auto" value="--请选择班级--"/>
								<input id="sel_2" name="zhichu.studentId" class="easyui-combobox" valueField="id" textField="sname" listWidth="auto" value="--请选择学生--"/>
							</td>
							<td>
								<a id="btn_1" class="easyui-linkbutton" type="button" href="javascript:void(0);" >查看选中学生详情</a>
							</td>
							<td>
								<a id="btn_2" class="easyui-linkbutton" type="button" href="javascript:void(0);" >修改选中学生信息</a>
							</td>
						</div>
					</tr>
					<tr>
						<div id="div1" iconCls="icon-ok" draggable="false" class="easyui-dialog"  title="学生详情" style="padding: 10px;width: 500;height:400;" 
				 			 closed="true" maximizable="false" minimizable="false" collapsible="false">
				 			 	<iframe width="100%" style='overflow:scroll;' scrolling="yes" height=85% frameborder="0" src="jsp/student/student_message.jsp"></iframe>
				 		</div>
					</tr>
					<tr>
						<div id="div2" iconCls="icon-ok" draggable="false" class="easyui-dialog"  title="修改选中学生信息" style="padding: 10px;width: 800;height:400;" 
				 			 closed="true" maximizable="false" minimizable="false" collapsible="false">
				 			 	<iframe width="100%" style='overflow:scroll;' scrolling="yes" height=85% frameborder="0" src="jsp/student/student_update.jsp"></iframe>
				 		</div>
					</tr>
					<tr>
						<td>报销人：</td>
						<td>
							<input name="zhichu.baoxiaoId" class="easyui-combobox" url="EmployeeAction!getBaoxiaoEmployee" valueField="id" textField="ename" listWidth="auto" value="--请选择--"/>
						</td>
					</tr>
					<tr>
						<td>支出日期：</td>
						<td><input id="zhichuTime" name="zhichu.zhichuTime" value=""/></td>
					</tr>
					<tr>
						<td>票据编号：</td>
						<td><input name="zhichu.sn" class="easyui-validatebox" required="true" missingMessage="该项必填!" value=""/></td>
					</tr>
					<tr>
						<td colspan="6">
							<a id="btn" class="easyui-linkbutton" iconCls="icon-ok" type="button" href="javascript:void(0);">提交</a>
						</td>
					</tr>
				</table>
			</form>
	</div>
  </body>
</html>
