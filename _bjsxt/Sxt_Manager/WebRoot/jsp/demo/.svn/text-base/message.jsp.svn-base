<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	    <base href="<%=basePath%>">
	    
	    <title>My JSP 'message.jsp' starting page</title>
	    <meta http-equiv="X-UA-Compatible" content="IE=8">
	    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
		<script type="text/javascript">
		<!--
			//window.UEDITOR_HOME_URL = '/Manager/js/ueditor/'; 
		//-->
		</script>
		<script type="text/javascript" src="js/ueditor/editor_config.js"></script>
		<script type="text/javascript" src="js/ueditor/editor.js"></script>
		<link rel="stylesheet" href="js/ueditor/themes/default/ueditor.css" />
	    <style type="text/css">
	        textarea{
	            float: left;
	            width:200px;
	            height: 400px;
	            margin-left: 20px;
	        }
	        .clear{
	            clear: both;
	        }
	    </style>
	</head>
	<body>
	
	<form action="" method="get">
	    <script type="text/plain" id="editor" name="text" style="float:left"></script>
	    <input type="submit" name="submit" value="提交">
	</form>
	
	
	</body>
	<script type="text/javascript">
	    var editor = new UE.ui.Editor();
	    editor.render('editor');
	</script>
