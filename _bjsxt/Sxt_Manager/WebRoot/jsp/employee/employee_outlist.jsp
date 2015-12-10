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
				
				$('#t_emp').datagrid({
						title: '辞职员工列表' ,  
						iconCls : 'icon-ok'  ,
						width:900,
						height:450,
						nowrap: true ,
						striped: true , //是否使用蓝白相间的斑马条纹 
						url: 'EmployeeAction!getEmployeeList?flag=2',	//发送Ajax异步请求 从服务器端数据 
						remoteSort: false ,
						rownumbers:	true,						//默认设置行号 
						loadMsg: '数据装载中...' ,				//数据加载时的提示信息
						//idField:  							//数据表格的主键 
						singleSelect: true ,					//单选模式
						fitColumns: true ,						//自动填充
						pagination:true,						//是否要分页
						pageSize:10,
						pageList:[5,10,15,20],
						columns:[[
							{field:'ename',		title:'姓名'  , 		width:80 , align:'center'  },
							{field:'sex',  		title:'性别'  , 		width:50 , align:'center' , 
								formatter: function(value ,recored , index){
									if(value == "1"){
										return "<span style='color:red;'>男</span>"; 
									} else{
										return "<span style='color:green;'>女</span>";  
									}	
								}
							},
							{field:'ruzhiTime',	 title:'入职日期' ,	width:100, align:'center'  },
							{field:'oname',		 title:'所属机构' ,	width:100, align:'center'  },
							{field:'jobNames' , title:'职位' , 		width:150 ,align:'center'  },
							{field:'cizhiTime',	 title:'辞职日期' ,	width:100, align:'center' , sortable:true },
							{field:'cizhiReason',title:'辞职原因' ,	width:100, align:'center'  }, 
							{field:'baseSalary', title:'基本工资' ,	width:100, align:'center'  }
						]]
				});
				displayMsg($('#t_emp'));
				
			});

			
			
			
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
		
		
		
		function isleave(id){
			
			$.messager.confirm("提示信息","确认申请离职?",
			           function(r){
								if(r){
									window.location = "EmployeeAction!preLeave?id="+id;
								}
                       }
			);
		
		}
	
	</script>
  </head>
  <body>
 		<table id="t_emp"></table>
  </body>
</html>
