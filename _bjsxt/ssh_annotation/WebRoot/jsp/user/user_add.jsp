<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript">
		function checkName(){
			var request;
			if(window.XMLHttpRequest){
				request = new XMLHttpRequest();
			}else{
				request =new ActiveXObject("Msxml2.XMLHTTP");
			}
			var username = document.getElementById("username");
			request.open("post","userAction!checkName?username="+username.value,true);
			request.onreadystatechange = function(){					
				if(request.readyState == 4){
					if(request.status == 200){
						var result = request.responseText;	//得到服务器端返回的数据 
						eval("var obj = "+result);
						var span = document.getElementById("msg");
						if(obj.flag == "true"){
							span.innerHTML == "可用使用！";
						}else{
							span.innerHTML == "该用户名已存在，请重新输入！"; 
						}
					}
				}
			}
			request.send();
		}
	</script>

  </head>
  
  <body>
  		<div align="center">
  			<font color="red" size=6><b>用户登记界面</b></font>
  		</div><br/>
    	<form action="userAction!save" method="post">
    		<table border="1" style="border-collapse: collapse;" align="center">
    			<tr>
    				<td>姓名：</td>
    				<td>
    					<input id="username" name="user.name" value=""/>
    					<span id="msg"></span>
    					<input type="button" value="验证" onclick="checkName();"/>
    				</td>
    			</tr>
    			<tr>
    				<td>联系方式：</td>
    				<td><input name="user.phone" value=""/></td>
    			</tr>
    			<tr>
    				<td>家庭住址：</td>
    				<td><input name="user.address" value=""/></td>
    			</tr>
    			<tr>
    				<td>存款：</td>
    				<td><input name="user.money" value=""/></td>
    			</tr>
    			<tr>
    				<td colspan="2"><input type="submit" value="提交"/></td>
    			</tr>
    		</table>
    	</form>
  </body>
</html>
