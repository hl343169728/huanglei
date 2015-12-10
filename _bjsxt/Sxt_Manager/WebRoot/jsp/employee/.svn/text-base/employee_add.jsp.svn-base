<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'employee_add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@ include file="../../jsp/globalresults/commons.jsp" %>
	
	
	<script type="text/javascript">
		$(function(){	
			//自定义的校验器 
			$.extend($.fn.validatebox.defaults.rules, { 
					checkName: { 
							validator: function(value, param){ 
											return value.length >= param[0] && value.length <= param[1] ; 
										}
							, 
							message: '' 
					}  ,
					checkCardId : {
							validator: function(value , param){
									return value.length == param[0] || value.length == param[1] ;
							} , 
							message: ''	
					}
			});
			//日期控件
			$('#birthday , #ruzhiTime').datebox({
				currentText : '今天',
				closeText : '关闭',
				disabled : false,
				required : true,
				missingMessage : '该项必填！',
				formatter : formatDate			//formatDate (utils.js)
			});
			
			//数字的验证框
			$('#baseSalary,#phoneComm,#busComm,#baoxianComm').numberbox({min:0,max:20000,precision:0});
			
			//提交表单：
			$('#btn').click(function(){
				// return boolean 
				if($('#myform').form('validate')){
					$('#myform').get(0).submit();
				} else {
					$.messager.alert('提示信息' , '提交失败!' , 'error');
				}
			});	
		});
		
		//  dialog1
		function showDialog1(){
			$('#div1').dialog('open');
		}
		
		var orgId = $('#orgId').val();
		
	  	// 节点id  节点的名称  是否被选中
		function callback(nodeId , nodeName , isChecked){
				if(isChecked){
						$('#text').html(nodeName);
						$('#orgId').val(nodeId);
				} else {
						$('#text').html('请选择所属机构!');
						$('#orgId').val(0);
				}
		}
	  	
  		function showDialog2(){
			$('#mydiv2').dialog('open');
		}

		function closedialog2(){
			$('#mydiv2').dialog('close');
		}
		
		function getMap(map){
			if(map.nodeName == ''){
				$('#jobIds').val("");
				$('#jobNames').html('请选择所在职位');
			} else {
				$('#jobIds').val(map.nodeId);
				$('#jobNames').html('当前选择职位为:'+map.nodeName); 
			}
		}
	</script>
	
	
  </head>
  <body>
		<div id="p" class="easyui-panel" title="员工新增" icon="icon-save"
			collapsible="true"  maximizable="true" 
			style="width: 1000px; height: 400px; padding: 10px; background: #fafafa;">
			<form id="myform" action="EmployeeAction!saveEmployee" method="post">
					<input type="hidden" id="jobIds" name="employee.jobIds" value="">
					<input type="hidden" id="orgId" name="employee.orgId" value="0" />
					<table>
						<tr>
							<td>姓名：</td>
							<td><input name="employee.ename" class="easyui-validatebox"  required="true" missingMessage="该项必填！" validType="checkName[2,5]" invalidMessage="姓名必须在2到5个字符之间！" value="" /></td>
						</tr>
						<tr>
							<td>出生日期：</td>
							<td><input id="birthday" name="employee.birthday" value="" /></td>
						</tr>
						<tr>
							<td>性别：</td>
							<td>
								<input name="employee.sex" type="radio" value="1" checked="checked" />男&nbsp;&nbsp;&nbsp;
								<input name="employee.sex" type="radio" value="2" />女
							</td>
						</tr>						
						<tr>
							<td>身份证号码：</td>
							<td><input name="employee.cardId" class="easyui-validatebox" required="true" missingMessage="该项必填！" validType="checkCardId[15,18]" invalidMessage="身份证必须是15或18位！"  value="" /></td>
						</tr>
						<tr>
							<td>住址：</td>
							<td><input name="employee.address" class="easyui-validatebox" required="true" missingMessage="该项必填！" value="" /></td>
						</tr>
						<tr>
							<td>所属机构：</td>
							<td>
							<a onclick="showDialog1();" id="text">设置机构</a>
							<div id="div1" iconCls="icon-ok" draggable="false" class="easyui-dialog"  title="设置机构" style="padding: 10px;width: 500;height:400;" 
				 			 closed="true" maximizable="false" minimizable="false" collapsible="false">
				 			 <iframe  style='overflow:scroll;overflow-x:hidden' width="100%" scrolling="yes" height=85% frameborder="0"  src="jsp/employee/employee_orgztree.jsp" ></iframe>
				 			 </div>							
							</td>
						</tr>
						<tr>
							<td>所属职位：</td>
							<td><a id="jobNames" href="javascript:void(0);" onclick="showDialog2();" >请选择所在职位</a></td>
		 					<div id="mydiv2" class="easyui-dialog" title="设置机构" style="padding: 10px;width: 500;height:400;" 
						 		iconCls="icon-redo" closed="true" maximizable="false" minimizable="false" collapsible="false">
								<iframe width="100%" style='overflow:scroll;overflow-x:hidden' scrolling="yes" height=85% frameborder="0"   src="jsp/employee/employee_jobtree.jsp"></iframe>				 		
								<div align="center">
									<a id="close2" class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0)" onclick="closedialog2()" >关闭</a>				    
								</div>		
						    </div> 								
						</tr>
						<tr>
							<td>底薪：</td>
							<td><input id="baseSalary" name="employee.baseSalary" required="true" missingMessage="该项必填！" value="" /></td>
						</tr>
						<tr>
							<td>电话补助：</td>
							<td><input id="phoneComm" name="employee.phoneComm" required="true" missingMessage="该项必填！" value="" /></td>
						</tr>	
						<tr>
							<td>交通补助：</td>
							<td><input id="busComm"  name="employee.busComm" required="true" missingMessage="该项必填！" value="" /></td>
						</tr>
						<tr>
							<td>保险补助：</td>
							<td><input id="baoxianComm" name="employee.baoxianComm" required="true" missingMessage="该项必填！" value="" /></td>
						</tr>
						<tr>
							<td>入职日期：</td>
							<td><input id="ruzhiTime" name="employee.ruzhiTime" value="" /></td>
						</tr>
						<tr align="center">
							<td colspan="2"><a class="easyui-linkbutton" id="btn" iconCls="icon-ok" type="button"  href="javascript:void(0)" >新增员工</a></td>
						</tr>																							
					</table>
			</form>
		</div>
  		
 		
  </body>
</html>
