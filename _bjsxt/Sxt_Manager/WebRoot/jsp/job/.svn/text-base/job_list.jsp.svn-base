<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'job_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@ include file="../../jsp/globalresults/commons.jsp" %>
	<script type="text/javascript">
	$(function(){
		var parent_id ;
		$('#t_job').treegrid({
			title:'职位列表', 
			iconCls:'icon-ok',
			width:1000,
			height:400,
			nowrap: false,
			rownumbers: true,
			animate:true,
			collapsible:true,
			url:'JobAction!getJobList',	 		 //JobAction!getJobList
			idField:'jname',
			treeField:'jname',
			fitColumns:true ,
			frozenColumns:[[
							{field:'jname',title:'职位名称',width:200 ,editor:'text', 
				                formatter:function(value){
				                	return '<span style="color:red">'+value+'</span>';
				                }
			                }
			]],
			columns:[[
				{field:'descript',title:'职位描述',width:120,rowspan:2  } , 
				{field:'oname' ,title:'所属机构',width:120,rowspan:2    } ,   
				{field:'employeeIds',title:'人员列表',width:120,rowspan:2 , formatter:function(value , record , index){
						return '<a href=JobAction!getEmpList?employeeIds='+value+' >查看详细</a>'; 
					}
				} 
			]],
			onContextMenu: function(e,row){
				e.preventDefault();
				$(this).treegrid('unselectAll');
				$(this).treegrid('select', row.jname);
				$('#mm').menu('show', {
					left: e.pageX,
					top: e.pageY
				});
			}
		});				
	
	});



	function append(){
		var data = [{
			jname: '新职位', 
			descript: ''
		}];
		var node = $('#t_job').treegrid('getSelected');
		parent_id = node.id ;
		//alert(parent_id);
		//追加到指定父节点  
		$('#t_job').treegrid('append', {
			parent: (node?node.jname:null),
			data: data
		});
		//与后台进行同步
		$.post('JobAction!saveJob' ,{parentId:parent_id},function(data){
			$('#t_job').treegrid('reload');
		});
	}

	function remove(){
		var node = $('#t_job').treegrid('getSelected');
		if (node){
			var arr = $('#t_job').treegrid('getChildren',node.jname); 
			if(arr == ''){
				$.messager.confirm('提示' ,'确认删除?' , function(r){
					if(r){
						$.post('JobAction!deleteJob' , {id:node.id} , function(data){});
						$('#t_job').treegrid('remove', node.jname);
					}
				})
			} else {
				$.messager.alert('提示','该职位还有下级职位,请先删除下级职位!', 'error'); 
			}				
		}
	} 		
	function update(){
				var node = $('#t_job').treegrid('getSelected');
				window.location = "JobAction!preUpdateJob?id="+node.id;
	}
	
	</script>
  </head>
  
  <body>
	<table id="t_job" ></table>
	<div id="mm" class="easyui-menu" style="width:120px;">
		<div onclick="append()">新增职位</div>
		<div onclick="update()">修改职位</div>
		<div onclick="remove()">删除职位</div>
	</div>
  </body>
</html>
