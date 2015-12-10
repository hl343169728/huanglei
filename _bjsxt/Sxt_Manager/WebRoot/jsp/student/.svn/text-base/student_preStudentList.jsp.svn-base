<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'student_preStudentList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@ include file="../../jsp/globalresults/commons.jsp" %>

	<script type="text/javascript">
		$(function(){
			//数据表 
			$('#t_preStu').datagrid({
					title: '预备学员列表' ,   						//表格标题 
					iconCls : 'icon-ok'  ,							//标题图标 
					width:1000,										//表格的宽度
					height:450,										//表格的高度  
					nowrap: true ,									//是否在一行显示数据 
					striped: true , 								//是否使用蓝白相间的斑马条纹 
					url: 'StudentAction!getPreStudentList', 	    //发送Ajax异步请求 从服务器端取数据 （从远程请求数据的地址）  
					remoteSort: false ,                     		//是否从服务器给数据排序  
					rownumbers:	true,								//是否设置行号 ，默认显示  
					fitColumns:true,                       		 	//自动填充 
					pagination:true,                        		//是否要分页 
					pageSize:10,                            		//每页的数据个数
					pageList:[5,10,15,20],							//每页显示数据量的几种方式  
					loadMsg:'数据加载中...',							//数据加载时的提示信息 
					//idField:  									//数据表格的主键 
					//数组 ，固定在左侧 
					frozenColumns:[[						
	            			{field:'ck',checkbox:true}		//指定复选框模式
					]],
					//数组： 表格的列的配置对象 
					columns:[[
						{field:'classNumber',  	title:'班级'  ,  			width:100 ,align:'center'  }, 
						{field:'payType', 		title:'学费支付类型' ,  		width:100, align:'center'  },
						{field:'liveFlag',		title:'是否需要安排住宿' ,	width:100, align:'center'  },
						{field:'computerFlag',	title:'是否需要提供电脑' ,	width:100, align:'center'  },	
						{field:'description',   title:'备注' ,				width:150, align:'center'  },
						{field:'operation',		title:'操作' ,				width:150, align:'center'  , 
							formatter : function(value , record , index){
								return "<a href='javascript:void(0);' onclick=changeToRealStudent("+record.id+")>转为正式学员</a>" ;  	    									
							}
						}  
					]]
			});
			displayMsg($('#t_preStu')); 
		});
		//分页 
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
		};

		//转为正式的学员 
		function changeToRealStudent(id){
			$.messager.confirm('提示信息','确认转为正式学员?',function(r){
				if(r){
					window.location ="StudentAction!changeToRealStudent?id="+id;
				}
			});
		};
	</script>
  </head>
  
  <body>
   	<table id="t_preStu"></table>
  </body>
</html>
