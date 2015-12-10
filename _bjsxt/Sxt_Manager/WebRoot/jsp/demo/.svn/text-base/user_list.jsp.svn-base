<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_list.jsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@ include file="../../jsp/globalresults/commons.jsp" %>
	<script type="text/javascript" src="js/common/grid.js"></script>
	<script type="text/javascript">
		$(function(){

			var config = new GridConfig();
			config.set$table($('#t_user'));
			config.setTitle('用户列表');
			config.setStriped(true);
			config.setCollapsible(true);
			config.setUrl('User_getList.action');
			config.setLoadMsg('数据装载中...');
			config.setFrozenColumns(true);
			config.setPagination(true);
			config.setRownumbers(true);
			//title , field ,width , rowspan , align , sortable , formatter
			config.setColumn('姓名','name','100',2,'center',true);
			config.setColumn('年龄','age','100',2,'center',true);
			config.setColumn('出生日期','birthday','100',2,'center',true);
			config.setColumn('性别','sex','100',2,'center',true , function(value , record){
				if(value == '1'){
					return '<span style="color:red">男</span>';
				} else {
					return '<span style="color:green">女</span>'; 
				}
			});
			config.setColumn('电话','tell','150',2,'center');
			config.setColumn('所属岗位','role_id','100',2,'center',true , function(value , record){
				if(value == null) {
					return '<span style="color:red">未指定</span>';
				} else{
					var str = '';
					if(value == '1'){
						str = '管理员';
					}
					return str ;
				}  
			});
			//text , handlerType  ,handlerUrl
			config.setToolbar('用户新增' , 'save'   , 'jsp/user/user_save.jsp');
			config.setToolbar('用户修改' , 'update' , 'User_preUpdate.action');
			config.setToolbar('用户删除' , 'delete' , 'User_getList.action');
			config.createDateGrid();
		});

	
	</script>
  </head> 
  <body>
  	<table id="t_user"></table>
  </body>
</html>
