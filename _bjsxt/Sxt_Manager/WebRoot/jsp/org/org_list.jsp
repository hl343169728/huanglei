<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'org_orgList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@ include file="../../jsp/globalresults/commons.jsp" %>
	<script>
		$(function(){
			var parent_id ; //父节点的id 
			$('#t_org').treegrid({
				title:'组织机构列表', 
				iconCls:'icon-ok',
				width:1000,
				height:400,
				nowrap: false,
				rownumbers: true,
				animate:true,
				collapsible:true,
				url:'OrgAction!getOrgList',			
				idField:'oname',			// 必须有 
				treeField:'oname',			// treegrid的主键 必须有	
				fitColumns:true ,
				frozenColumns:[[
								{field:'oname',title:'机构名称',width:200 ,
					                formatter:function(value){
					                	return '<span style="color:red">'+value+'</span>';
					                }
				                }
				]],
				columns:[[
					{field:'descript',title:'机构描述',width:120,rowspan:2  } ,
					{field:'principal',title:'机构负责人',width:120,rowspan:2  } 
				]],
				onContextMenu: function(e,row){
					//alert(row.oname);
					e.preventDefault();
					$(this).treegrid('unselectAll');
					$(this).treegrid('select', row.oname);
					$('#mm').menu('show', {
						left: e.pageX,
						top: e.pageY
					});
				}
			});				
		
		});


		
		function append(){
			var data = [{
				oname: '新组织机构', 
				descript: '',
				principal: ''
			}];
			var node = $('#t_org').treegrid('getSelected');
			
			
			parent_id = node.id ;
			//alert(parent_id);
			//追加到指定父节点   第一个参数表示 追加的父节点的主键  第二个参数表示所追加的节点元素们 
			$('#t_org').treegrid('append', {
				parent: (node?node.oname:null), //如果节点存在 取到 该节点的名称 不存在 返回null  
				data: data
			});
			//与后台进行同步
			$.post('OrgAction!saveOrg' ,{parentId:parent_id},function(data){
				$('#t_org').treegrid('reload');		//reload 重新加载  
			});
			
		}
		
		function remove(){
			var node = $('#t_org').treegrid('getSelected');
			if (node){
				var arr = $('#t_org').treegrid('getChildren',node.oname); 
				if(arr == ''){
					$.messager.confirm('提示' ,'确认删除?' , function(r){
						if(r){
							$.post('OrgAction!deleteOrg' , {id:node.id} , function(data){}); // 后台数据库真正的发请求 删除
							$('#t_org').treegrid('remove', node.oname);	//前台内存  remove 
						}
					})
				} else {
					$.messager.alert('提示','该机构还有下级机构,请先删除下级机构!', 'error');
				}				
			}
		} 
	
		function update(){
				var node = $('#t_org').treegrid('getSelected');
				window.location = "OrgAction!preUpdateOrg?id="+node.id; 
		}
		

	</script>
  </head>
  
<body>
	<table id="t_org" ></table>
	<div id="mm" class="easyui-menu" style="width:120px;">
		<div onclick="append()">新增组织机构</div>
		<div onclick="update()">修改组织机构</div>
		<div onclick="remove()">删除组织机构</div>
	</div>
</body>
</html>
