<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'memo_add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@ include file="../../jsp/globalresults/commons.jsp" %>
	
	<script type="text/javascript">
	//自定义的验证框 
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
		
		//日期框
		$('#startTime,#endTime').datebox({
			currentText : '今天', 			//为当前日期按钮显示的文本 
			closeText : '关闭',  			//关闭按钮显示的文本 
			disabled : false,	  			//如果为true，则禁用输入框 
			required : true,	  			//定义输入框是否为必填项 
			missingMessage : '该项必填！',	//当文本框为空的时候显示的文本
			formatter : formatDate			//formatDate (utils.js)
		});

		//日期精确到小时 
		$(function(){
			$('#startTime , #endTime').datebox({
				formatter:function(date){
					return date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate()+' '+(new Date()).getHours();
				}
			});
		});
		
		/*提交表单 
		$('#btn').click(function(){
			if($('#myform').form('validate')){//固定的写法
				$('#myform').get(0).submit(); //JQuery对象转为dom对象的方式提交 
			}else{
				$.messager.alert('提示信息 ','提交失败  ','error');
			}
		});
		*/
	});

		//验证日期
		function check(){
			var flag = false;
			var startTime = $('#startTime').datebox('getValue'); 
			var endTime   = $('#endTime').datebox('getValue');
			if($('#myform').form('validate')){
				$.ajax({
					type : 'post',
					timeout : 2000,
					url : 'MemoAction!checkDate',
					async : false,
					data : {startTime:startTime,endTime:endTime},
					dataType : 'text',
					success : function(result){
						if(result == "1"){
							flag = true;
						}else{
							$.messager.confirm('信息提示','备忘录的结束日期必须在开始日期之后，请重新核对！','error');
							$('#endTime').datebox('clear');
						}
					}
				});
			}else{
				$.messager.confirm('信息提示','提交失败！','error');
			}
			return flag;
		};
	</script>

  </head>
  
  <body>
    <div id="p" class="easyui-panel" title="录入新的备忘录" icon="icon-save"
		collapsible="true"  maximizable="true" 
		style="width: 1000px; height: 500px; padding: 10px; background: #fafafa;">
			<form id="myform" action="MemoAction!saveMemo" method="post" onsubmit="return check();">
				<table>
					<tr>
						<td>内容：</td>
						<td>
							<textarea name="memo.content" rows="5" cols="60"></textarea>
						</td>
					</tr>
					<tr>
						<td>开始时间：</td>
						<td>
							<input id="startTime" name="memo.startTime" value=""/>
						</td>
					</tr>
					<tr>
						<td>结束时间：</td>
						<td>
							<input id="endTime" name="memo.endTime" value=""/>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input id="btn" class="easyui-linkbutton" iconCls="icon-ok" type="submit" value="提交备忘录" />
						</td>
					</tr>
				</table>
			</form>
	</div>
  </body>
</html>
