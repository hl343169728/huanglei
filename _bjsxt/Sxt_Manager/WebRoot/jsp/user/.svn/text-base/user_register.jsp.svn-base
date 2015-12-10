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
				$('#sel_1').combobox({
					onChange: function(newValue , oldValue){ $('#sel_2').combobox('reload' , 'EmployeeAction!getEmployeeByOrgId?orgId='+$('#sel_1').combobox('getValue'));}
				});	
				$('#btn').click(function(){	
					$.post('UserAction!createAccount' , {empId:$('#sel_2').combobox('getValue')} , function(data){
						var result = eval(data);
						if(result.constructor == Array){
							$.messager.alert('创建账号成功!' , '生成账号为:' +result[0].uname +'<br/>' + '密码为:' + result[0].pwd );
						} else {
							$.messager.alert('创建账号失败!' , '该账号已经生成!' , 'error');
						}
					});
				});
			});
	</script>
  </head>
  
  <body>
    		<div id="p" class="easyui-panel" title="用户账号新增" icon="icon-save"
			collapsible="true"  maximizable="true" 
			style="width: 1000px; height: 400px; padding: 10px; background: #fafafa;">
					
					选择组织机构：<input id="sel_1" class="easyui-combobox" url="OrgAction!getLeafOrg" valueField="id" textField="oname" listWidth="auto" />
							
					选择员工：<input id="sel_2" class="easyui-combobox" valueField="id" textField="ename" listWidth="auto" />	<br/>
					<input type="button" id="btn" value="生成账号" /> 			
			
			</div>
  </body>
</html>
