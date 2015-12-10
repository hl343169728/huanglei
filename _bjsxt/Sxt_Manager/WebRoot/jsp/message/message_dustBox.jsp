<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'message_dustBox.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@ include file="../../jsp/globalresults/commons.jsp" %>
	
	<script type="text/javascript">
	
			$(function(){
				
					$('#t_outDustBox').datagrid({
						title: '发件箱历史记录' ,   
						iconCls : 'icon-ok'  ,
						width:900,
						height:450,
						nowrap: true ,
						striped: true , //是否使用蓝白相间的斑马条纹 
						url: 'MessageAction!outList?flag=2',	 
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
							{field:'receiverNames',	title:'收件人' ,		width:100, align:'center'  }, 
							{field:'operation',	title:'操作' ,		width:100, align:'center'  , 
								formatter : function(value , record , index){
									return '<a  href=javascript:void(0); onclick=recover('+record.id+',1) >恢复到发件箱</a> | <a  href=javascript:void(0); onclick=realdel('+record.id+',1) >删除</a>'  ;  	   									
								}
							}
						]] 
						
					});
					
					$('#t_inDustBox').datagrid({
						
						title: '收件箱历史记录' ,  
						iconCls : 'icon-ok'  ,
						width:900,
						height:450,
						nowrap: true ,
						striped: true , //是否使用蓝白相间的斑马条纹 
						url: 'MessageAction!inList?flag=2',	 
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
							{field:'createTime',title:'收件日期'  , 	width:50 , align:'center'  },
							{field:'sendName',	title:'发件人' ,		width:100, align:'center'  }, 
							{field:'operation',	title:'操作' ,		width:100, align:'center'  , 
								formatter : function(value , record , index){
									return '<a  href=javascript:void(0); onclick=recover('+record.id+',2) >恢复到收件箱</a> | <a  href=javascript:void(0); onclick=realdel('+record.id+',2) >删除</a>'  ;  	   									
								}
							}
						]] 
					});
			});
			
			//恢复信件
			function recover(id , flag){
				if(flag == 1){
					
					$.messager.confirm('提示信息' ,'确认恢复到发件箱?' , function(r){
						
						if(r){
							window.location = 'MessageAction!recoverMessage?messageid='+id;
						}
					});
				}
				if(flag == 2){
					$.messager.confirm('提示信息' ,'确认恢复到发件箱?' , function(r){
						if(r){
							window.location = 'MessageAction!recoverMessage?messagereceiverid='+id;
						}
					});
				}
			}
			
			
			// 删除垃圾箱信件 
			function realdel(id , flag){

				$.messager.confirm('提示信息', '如果删除数据将无法恢复,确认删除?' ,function(r){
					if(r){
						 window.location = 'MessageAction!deleteDustBox?id='+id + "&flag="+flag;
					}
				});

				
			}
			
			
	</script>
  </head>
  
  <body>
    <div id="tt" class="easyui-tabs" tools="#tab-tools" style="width:1000px;height:450px;">
		<div title="发件垃圾箱列表" iconCls="icon-remove" style="padding:20px;" cache="false">
				<table id="t_outDustBox"></table>
		</div>
		<div title="收件垃圾箱列表" iconCls="icon-remove" style="padding:20px;" cache="false"  >
				<table id="t_inDustBox"></table>
		</div>
    </div>
  </body>
</html>
