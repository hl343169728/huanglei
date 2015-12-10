<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'homework_add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript">
		//可变的与不可变的，可变的利用参数传入，不变的进行封装 
		function add(){
			var mydiv = document.getElementById('mydiv');
			
			myCreate(mydiv,{nodeName:'input',type:'file',name:'files'});
			myCreate(mydiv,{nodeName:'input',type:'button',value:'删除',onclick:function(){
				this.parentNode.removeChild(this.previousSibling);
				this.parentNode.removeChild(this.nextSibling);
				this.parentNode.removeChild(this);
			}});
			myCreate(mydiv,{nodeName:'br'});
			
			/*
			var file = document.createElement('input'); 
			var button = document.createElement('input');
			var br = document.createElement('br');
			file.type="file";
			file.name="image";
			button.type="button";
			button.value="删除";
			button.onclick = function(){
				this.parentNode.removeChild(this.previousSibling);
				this.parentNode.removeChild(this.nextSibling);
				this.parentNode.removeChild(this);
			};
			mydiv.appendChild(file);
			mydiv.appendChild(button);
			mydiv.appendChild(br);
			*/
		};

		function myCreate(parent,obj){
			if(undefined != obj.nodeName){
				var temp = document.createElement(obj.nodeName);
			}else{
				alert("nodeName参数必填！！！");
				return ;
			}
			if(undefined != obj.type){
				temp.type = obj.type;
			}
			if(undefined != obj.name){
				temp.name = obj.name;
			}
			if(undefined != obj.value){
				temp.value = obj.value;
			}
			if(undefined != obj.onclick){
				temp.onclick = obj.onclick;
			}
			parent.appendChild(temp);
		};
	</script>

  </head>
  
  <body>
    	<form action="HomeworkAction!save" method="post" enctype="multipart/form-data">
    		标题：<input name="homework.title" value=""/><br/>
    		内容：<textarea name="homework.content" rows="5" cols="30"></textarea><br/>
    		资料：<input type="button" value="添加资料" onclick="add();"/><br/>
    		<div id="mydiv"></div>
    		<input type="submit" value="提交"/>
    	</form>
  </body>
</html>
