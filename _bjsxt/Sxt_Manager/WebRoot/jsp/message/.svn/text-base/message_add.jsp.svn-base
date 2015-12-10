<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'message_add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@ include file="../../jsp/globalresults/commons.jsp" %>
	<script type="text/javascript" src="js/ueditor/editor_config.js"></script>
	<script type="text/javascript" src="js/ueditor/editor.js"></script>
	<link rel="stylesheet" href="js/ueditor/themes/default/ueditor.css" />
	
	<script type="text/javascript">
	
				$(function(){
					$('#btn').click(function(){
							$('#div1').dialog('open');
					});
				});
				
			
				function callback(nodeName){
						$('#receiverNames').val(nodeName);
				}
				
				
				
				function checkForm(){
					var flag = false ;		//标识变量 
					
					if($('#myform').form('validate')){
						$.ajax({
							url: 'MessageAction!checkReceiverNames' , 
							type: 'post' , 
							timeout : 2000 , 
							dataType : 'text' , 
							async : false ,			// 必须要设置 是同步
							data : {receiverNames : $('#receiverNames').val()} , 
							success : function(result){
								if(result == "1"){
									flag = true ;
								} else {
									$.messager.alert('提示信息' , result + '：账号不存在!' , 'error');
								}
							}
						});
					} else {
						$.messager.alert('提示信息' , '提交失败!' , 'error');
					}
					return flag ; 
					
				}
				
				setInterval(changeButtonName , 2);		// 当页面加载的时候  每个2毫秒去 循环调用一个函数 
				function changeButtonName(){
					var  name = '${senderName}';
					if($('#receiverNames').val() == name && name){
						 $('#sub').val('回复');
					} else {
						  $('#sub').val('发送'); 
					}
				}
	</script>
  </head>
  
  <body>
  		<div id="p" class="easyui-panel" title="写信" icon="icon-add"
			collapsible="true"  maximizable="true" 
			style="width: 1000px; height: 400px; padding: 10px; background: #fafafa;">
  			<form id="myform" action="MessageAction!saveMessage" onsubmit="return checkForm();" method="post">
  					<table>
  							<tr>
  								<td>标题:</td>
  								<td><input type="text" size="40" class="easyui-validatebox"  required="true" missingMessage="该项必填！"   name="title" value="${message.title}" /></td>
  								<td>收信人:</td>
  								<td><input type="text" size="40" id="receiverNames" class="easyui-validatebox"  required="true" missingMessage="该项必填！" name="receiverNames" value="${senderName}" /></td>
  								<td><input id="btn" type="button" value="选择" /></td>
	  							<div id="div1" iconCls="icon-ok" draggable="false" class="easyui-dialog"  title="设置机构" style="padding: 10px;width: 500;height:400;" 
					 			 closed="true" maximizable="false" minimizable="false" collapsible="false">
					 			 <iframe  style='overflow:scroll;overflow-x:hidden' width="100%" scrolling="yes" height=85% frameborder="0"  src="jsp/message/message_ztree.jsp" ></iframe>
					 			</div>									
  							</tr>
  							<tr>
  								<td>内容:</td>
  								<td colspan="4">
  									<textarea id="ueditor" name="content" rows="" cols="">${message.content}</textarea>
  								</td>
  							</tr>  
  							<tr>
  								<td colspan="5" align="center">
										<input id="sub" type="submit" value="发送" />
										<c:if test="${message.title ne null}">
												<input type="button" onclick="history.back();" value="返回" />
										</c:if>
  								</td>
  							</tr>   												
  					</table>
  			
  			</form>

  		</div>
  		
  	<script type="text/javascript">
	    var editor = new UE.ui.Editor();
	    editor.render('ueditor');
	</script>
  </body>
</html>
