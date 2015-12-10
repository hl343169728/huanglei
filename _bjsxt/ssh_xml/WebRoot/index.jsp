<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript">
		function testEval(){
			var a = "alert('你们好！');";
			var b = "var c=0;";
			eval(b);
			alert(c);
			alert(a);
		};

		function testEscape(){
			var str = "中国";
			var str1 = escape(str);
			var str2 = unescape(str1);
			alert(str1);
			alert(str2);
		};

		function Person(name,age){
			this.name = name;
			this.age = age;
			this.study = function(){
				alert("好好学习！");
			};
		};

		function Boy(){};
		Boy.prototype = new Person("小米","10");
		
		function test(){
			var p = new Person("小三","20");
			alert(p.name);
			p.study();
		};
		function test2(){
			var b = new Boy();
		};
	</script>

  </head>
  
  <body>
   	<input type="button" value="点击" onclick="testEval();"/>
   	<input type="button" value="testEscape" onclick="testEscape();"/>
   	<input type="button" value="继承的实现" onclick="test();"/>
  </body>
</html>
