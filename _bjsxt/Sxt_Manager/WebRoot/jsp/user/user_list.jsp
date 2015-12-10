<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@ include file="../../jsp/globalresults/commons.jsp" %>
	<script type="text/javascript">
			
	$(function(){
		
			$('#t_user').datagrid({
				
					title: '用户列表' , 
					iconCls: 'icon-ok' ,
					width : 1000 , 
					height: 450 , 
					nowrap: true ,
					striped: true , //是否使用蓝白相间的斑马条纹 
					url: 'UserAction!getUserList' , 
					rownumbers: true ,
					loadMsg: '数据装载中...' ,				//数据加载时的提示信息
					singleSelect: true ,					//单选模式
					fitColumns: true ,						//自动填充
					pagination:true,						//是否要分页
					pageSize:10,
					pageList:[5,10,15,20],
					columns:[[
						{field:'uname',		title:'用户名'  , 	width:80 , align:'center'  },
						{field:'empname',	title:'员工姓名' ,	width:100, align:'center'  },
						{field:'state',		title:'状态' ,		width:100, align:'center'  },
						{field:'operation',	title:'操作' ,		width:100, align:'center'  , 
							formatter : function(value , record , index){
								if(record.state == '有效'){						
									return "<a href=javascript:void(0); onclick=logout('"+record.id+"','1'); >注销</a>" ;
								} else {
									return "<a href=javascript:void(0); onclick=logout('"+record.id+"','2'); >激活账号</a>" ; 
								}
									
								 	  									
							}
						}
					]] 
			});
			displayMsg($('#t_user'));
	});
	
	function logout(id , flag){
		
		$.messager.confirm('提示信息' , "确认注销?" , function(r){
			if(r){
				 window.location = "UserAction!logoutAndStart?id=" + id + "&flag="+flag ;				
			}
		});
	}
	
	
	function displayMsg($table){	//$('#t_user')
			var pager = $table.datagrid('getPager');
			pager.pagination({
				loading:false,
				showPageList:true,
				showRefresh:true,
				beforePageText:'第',
				afterPageText:'页,共{pages}页',
				displayMsg:'当前显示记录数:{from}-{to}条记录,共{total}条记录' 
			});
	}
	</script>
  </head>
  
  <body>
  
  		<table id="t_user"></table>
  </body>
</html>
