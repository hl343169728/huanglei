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
					title : '用户列表'  , 
					iconCls:'icon-ok',
					width:900,
					height:470,
					pageSize:10,
					pageList:[5,10,15,20],
					nowrap:false,				//是否在一行显示数据
					striped: true,				//是否显示斑马线
					collapsible:true,			//是否要滑动效果
					url:'User_getList.action',	//远程加载数据的地址
					loadMsg:'数据装载中......',	//加载信息时的等待提示信息
					//sortName:'age',			//定义排序列
					//sortOrder:'desc',			//定义排序方式
					remoteSort:false,			
					frozenColumns:[
						[			//定义复选框
							{field:'ids',checkbox:true}
				    	]
				    ],
					columns:[[					//定义字段列
						//{title:'序号',field:'id',width:'60',rowspan:2,align:'left'},
						{title:'姓名',field:'name',width:'100',rowspan:2,align:'center', sortable: true},
						{title:'年龄',field:'age',width:'100',rowspan:2,align:'center'},
						{title:'出生日期',field:'birthday',width:'100',rowspan:2,align:'center', sortable: true}, 
						{title:'性别',field:'sex',width:'100',rowspan:2,align:'center', sortable: true ,
							formatter: function(value , record){
								if(value == '1'){
									return '<span style="color:red">男</span>';
								} else {
									return '<span style="color:green">女</span>'; 
								}
							}
						},
						{title:'电话',field:'tell',width:'150',rowspan:2,align:'center'},
						{title:'所属岗位',field:'role_id',width:'100',rowspan:2,align:'center' ,
							formatter: function(value , record){
								//alert(value);
								if(value == '' || value == null) {
									return '<span style="color:red">未指定</span>';
								} else{
									var str = '';
									if(value == '1'){
										str = '管理员';
									}
									return str ;
								}  
							}
						}
					]],
					toolbar:[					// 工具栏
								{
									 text:'添加用户',
									 iconCls:'icon-add',
									 //触发事件 ：将用于添加的div显示
									 handler:function(){
												window.location.href = 'jsp/user/user_save.jsp';		  
									 }
								},
								'-',
								{
									  text:'修改用户',
									  iconCls:'icon-edit',
									  handler:function(){
												update($('#t_user') ,'User_preUpdate.action' );
									  }
								},
								'-',
								{
									  text:'删除用户',
									  iconCls:'icon-remove',
									  handler:function(){
												batchDelele($('#t_user') , 'User_getList.action');
									  }
								},
								'-',
								{
									  text:'查询',
									  iconCls:'icon-search',
									  handler:function(){
									  	//$('#query').window('open');
									  }
								}
						],
						pagination:true,		// 是否要分页
						rownumbers:true,		// 是否显示行号
						onRefresh:function(pageNumber,pageSize){
								$('#t_user').datagrid({
								url:'User_getList.action?page='+pageNumber+'&rows='+pageSize,
								loadMsg:'更新数据中......'
								});
						}
			});	
			displayMsg($('#t_user'));
		});

	
	</script>
  </head> 
  <body>
  	<table id="t_user"></table>
  </body>
</html>
