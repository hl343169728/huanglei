<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@ include file="../../jsp/globalresults/commons.jsp" %>
	

	
	<script type="text/javascript">
			$(function(){
					
				$('#btn').click(function(){
					
						if($('#password').val() == '${sessionScope.loginUser.pwd}'){
								$('#pwddiv').dialog('open');
						} else {
							
							$.messager.alert("提示","密码输入错误!",'error');
						}			
				});
				
				$('#sub').click(function(){
					
					if($('#pwd1').val() == $('#pwd2').val()){
							$('#myform').get(0).submit();
					} else {
							$.messager.alert("提示","两次密码输入不一致,请重新输入!",'error'); 
					}
					
				});
				
				
			});
	
	
	</script>
  </head>
  
  <body>
    		<div id="p" class="easyui-panel" title="用户密码修改" icon="icon-save"
			collapsible="true"  maximizable="true" 
			style="width: 1000px; height: 400px; padding: 10px; background: #fafafa;">
					
					请输入旧密码：<input id="password" type="password" name="password" value="" /> <br/>
								 <input id="btn" type="button"  value="确定" />
			   <div id="pwddiv" class="easyui-dialog" title="密码修改" icon="icon-save"
					collapsible="true"  maximizable="true"  closed="true"
					style="width: 300px; height: 300px; padding: 10px; background: #fafafa;">
					
					<form id="myform" action="UserAction!updatePassword" method="post" >
							<table>
								<tr>
									<td>新密码：</td>
									<td><input type="password" id="pwd1" name="pwd1" value="" /></td>
								</tr>
								<tr>
									<td>确认密码：</td>
									<td><input type="password" id="pwd2" name="pwd2" value="" /></td>
								</tr>
								<tr align="center">
									<td colspan="2" >
											<a class="easyui-linkbutton" iconCls="icon-ok" id="sub" />确认修改</a>
									</td>
								</tr>																
							</table>
					</form>
				</div>
			
			</div>
  </body>
</html>
