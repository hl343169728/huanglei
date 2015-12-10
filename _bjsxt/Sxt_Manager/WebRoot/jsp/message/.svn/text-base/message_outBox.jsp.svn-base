<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'message_outBox.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@ include file="../../jsp/globalresults/commons.jsp" %>
	<script type="text/javascript">
			$(function(){
				
				$('#t_out').datagrid({
						title: '发件箱列表' ,  
						iconCls : 'icon-ok'  ,
						width:900,
						height:450,
						nowrap: true ,
						striped: true , //是否使用蓝白相间的斑马条纹 
						url: 'MessageAction!outList?flag=1',	
						remoteSort: false ,
						rownumbers:	true,						//默认设置行号 
						loadMsg: '数据装载中...' ,				//数据加载时的提示信息
						//idField:  							//数据表格的主键 
						singleSelect: true ,					//单选模式
						fitColumns: true ,						//自动填充
						pagination:true,						//是否要分页
						pageSize:10,
						pageList:[5,10,15,20],
						/*
						frozenColumns:[[						
	                			{field:'ck',checkbox:true}		//指定复选框模式
						]],*/
						columns:[[
							{field:'title',		title:'标题'  , 		width:80 , align:'center'  },
							{field:'createTime',title:'发件日期'  , 	width:50 , align:'center'  },
							{field:'receiverNames',	title:'收件人' ,	width:100, align:'center'  },
							{field:'operation',	title:'操作' ,		width:100, align:'center'  , 
								formatter : function(value , record , index){
									return '<a  href=javascript:void(0); onclick=addDust('+record.id+') >加入垃圾箱</a>' ;  	  									
								}
							}
						]] 
				});
				displayMsg($('#t_out'));
				
			});

			
			
			
		function displayMsg($table){	
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
		//加入垃圾箱
		function addDust(id){
			$.messager.confirm('提示信息' , '确认加入垃圾箱?' , function(r){
				
				if(r){
					window.location = 'MessageAction!addDust?messageid=' + id ;
				}
			});
		}
	
	</script>
  </head>
  
  <body>
  		<table id="t_out"></table>
  </body>
</html>
