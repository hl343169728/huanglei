<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'org_update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@ include file="../../jsp/globalresults/commons.jsp" %>
  	<script type="text/javascript">
  			
  	
  	
  			var pid = ${parentId};
  			
  			
  			//alert(pid);
  			var id  = ${org.id};
  		
  			function showDialog(){
  					if(pid != 0){
  						$('#div1').dialog('open');
  					}
  			}
  			
  			
  			// 节点id  节点的名称  是否被选中
  			function callback(nodeId , nodeName , isChecked){
  					if(isChecked){
  							$('#text').html(nodeName);
  							pid = nodeId;
  					} else {
  							$('#text').html('请选择所属机构!');
  							pid = '不能提交'; 		//细节问题 
  					}
  				
  			}
  			
  		
  			$(function(){
  						
  				$('#btn').click(function(){
  					
  					if($('#myform').form('validate')){
  							if(pid == '不能提交'){
  								$.messager.alert('提示信息','请选择父机构!' ,'error');
  								return ;
  							}
  							$('#myform').attr('action' , 'OrgAction!updateOrg?parentId=' + pid);
  							$('#myform').get(0).submit();
  					} else {
  						
  						
  					}
  					
  				});
  				
  				
  			});
  	
  	</script>
  </head>
   
  <body>
  
  			<div id="p" class="easyui-panel" title="组织机构修改" icon="icon-save"
			collapsible="true"  maximizable="true" 
			style="width: 1000px; height: 400px; padding: 10px; background: #fafafa;">
			<form id="myform" action="" method="post">
					<input type="hidden" name="id" value="${org.id}" />
					<table>
						<tr>
							<td>组织机构名称：</td>
							<td><input name="oname" class="easyui-validatebox"  required="true" missingMessage="该项必填！"  value="${org.oname}" /></td>
						</tr>
						<tr>
							<td>组织机构负责人:</td>
							<td>
								<input name="principal" class="easyui-validatebox"  required="true" missingMessage="该项必填！"  value="${org.principal}" />	
							</td>
						</tr>	
						<tr>
							<td>父机构:</td>
							<td>
							<c:if test="">
							
							</c:if>
							<a id="text"  onclick="showDialog()" >${parentName eq null ?"无父机构":parentName}</a>
							<div id="div1" iconCls="icon-ok" draggable="false" class="easyui-dialog"  title="设置机构" style="padding: 10px;width: 500;height:400;" 
				 			 closed="true" maximizable="false" minimizable="false" collapsible="false">
				 			 <iframe  style='overflow:scroll;overflow-x:hidden' width="100%" scrolling="yes" height=85% frameborder="0"  src="jsp/org/org_ztree.jsp" ></iframe>
				 			 </div>
									
							</td> 
						</tr>											
						<tr>
							<td>组织机构描述：</td>
							<td><textarea id="birthday" name="descript" rows="5" class="easyui-validatebox"  required="true" missingMessage="该项必填！" cols="30" />${org.descript}</textarea>
						</tr>

						<tr align="center">
							<td colspan="2">
								<a class="easyui-linkbutton" id="btn" iconCls="icon-ok" type="button"  href="javascript:void(0)" >修改信息</a>
								<a class="easyui-linkbutton"  iconCls="icon-back" type="button"  href="javascript:history.back()" >返回</a>
							</td>
						</tr>																							
					</table>
			</form>
		</div>
  </body>
</html>
