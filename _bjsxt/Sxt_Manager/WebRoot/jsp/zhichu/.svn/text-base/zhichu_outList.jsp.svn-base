<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'zhichu_outList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@ include file="../../jsp/globalresults/commons.jsp" %>
	
	<script type="text/javascript">
	$(function(){
		//数据表 
		$('#t_out').datagrid({
				title: '支出信息列表' ,   						//表格标题  
				iconCls : 'icon-ok'  ,							//标题图标 
				width:1000,										//表格的宽度
				height:450,										//表格的高度  
				nowrap: true ,									//是否在一行显示数据 
				striped: true , 								//是否使用蓝白相间的斑马条纹 
				url: 'ZhichuAction!getZhichuList', 				//发送Ajax异步请求 从服务器端取数据 （从远程请求数据的地址）  
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
					{field:'jine',			title:'金额'  , 			width:80 , align:'center'  },
					{field:'type',			title:'分类'  , 			width:200 , align:'center' ,
						formatter : function(value , record , index){
							if(value == "1"){
								return "<span>办公耗材</span>";
							}else if(value == "2"){
								return "<span>电费</span>";
							}else if(value == "3"){
								return "<span>水费</span>";
							}else if(value == "4"){
								return "<span>退住宿费</span>";
							}else if(value == "5"){
								return "<span>退电脑押金</span>";
							}else if(value == "6"){
								return "<span>退学费</span>";
							}else if(value == "7"){
								return "<span>学校返点</span>";
							}else if(value == "8"){
								return "<span>出差费用</span>";
							}else if(value == "9"){
								return "<span>工资</span>";
							}else if(value == "10"){
								return "<span>固定资产</span>";
							}else if(value == "11"){
								return "<span>通讯费用</span>";
							}else if(value == "12"){
								return "<span>网络宣传</span>";
							}else if(value == "13"){
								return "<span>校园宣传</span>";
							}else if(value == "14"){
								return "<span>交通费用</span>";
							}else if(value == "15"){
								return "<span>请客聚会</span>";
							}else if(value == "16"){
								return "<span>学员推荐费用</span>";
							}else{
								return "<span>其他</span>";
							}
						}
					}, 
					{field:'sname',  	    title:'学生'  ,  		width:80 ,align:'center'   },
					{field:'zhichuTime', 	title:'支出日期' ,  		width:100, align:'center'  }, 
					{field:'baoxiaoName', 	title:'报销人' ,  		width:100, align:'center'  }, 
					{field:'shenheState',	title:'状态' ,			width:100, align:'center'  }, 
					{field:'operation',		title:'操作' ,			width:100, align:'center'  , 
						formatter : function(value , record , index){
							if(record.shenheState == "未审核"){
								return "<a href='javascript:void(0);' onclick=preUpdate("+record.id+"); >修改</a> | <a href='javascript:void(0);' onclick=deleteZhichu("+record.id+")>删除</a> " ;
							}
						}
					}
				]]
		});
		displayMsg($('#t_out'));
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

	//修改函数
	function preUpdate(id){
		$.messager.confirm('提示信息','确认修改吗?',function(r){
			window.location = "ZhichuAction!preUpdate?id="+id; 
		});
	};

	//删除函数
	function deleteZhichu(id){
		$.messager.confirm('提示信息','确认删除吗?',function(r){
			window.location = "ZhichuAction!deleteZhichu?id="+id;
		});
	};
	</script>
  </head>
  
  <body>
   	<table id="t_out"></table>
  </body>
</html>
