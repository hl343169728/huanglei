<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'student_add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  	
  	<form action="StudentServlet" method="post">
  	
  		<input type="hidden" name="method" value="save" />
  		
  		<table>
  			<tr>
  				<td>姓名：</td>
  				<td><input type="text" name="studentname" value="" /></td>
  			</tr>
  			<tr>
  				<td>学号：</td>
  				<td><input type="text" name="cardId" value="" /></td>
  			</tr>
  			<tr>
  				<td>生日：</td>
  				<td><input type="text" name="birthday" value="" /></td>
  			</tr>
  			<tr>
  				<td>性别：</td>
  				<td>
  					<input type="radio" checked="checked" name="sex" value="1" />男&nbsp;&nbsp;&nbsp;
  					<input type="radio" name="sex" value="2" />女
  				</td>	
  			</tr>
  			<tr>
  				<td>爱好：</td>
  				<td>
  					<input type="checkbox" name="favorite" value="1" />学java&nbsp;&nbsp;
  					<input type="checkbox" name="favorite" value="2" />敲java代码&nbsp;&nbsp;
  					<input type="checkbox" name="favorite" value="3" />看java视频&nbsp;&nbsp;
  					<input type="checkbox" name="favorite" value="4" />看java书
  				</td>
  			</tr>
  			<tr>
  				<td>毕业院校：</td>
  				<td><input type="text" name="university" value="" /></td>
  			</tr>
  			<tr>
  				<td>民族：</td>
  				<td><input type="text" name="nationality" value="" /></td>
  			</tr>
  			<tr>
  				<td>星座：</td>
  				<td>
  					<select name="constellation">
  						<option value="0">--请选择--</option>
  						<option value="双鱼座">双鱼座</option>
  						<option value="金牛座">金牛座</option>
  						<option value="天蝎座">天蝎座</option>
  						<option value="狮子座">狮子座</option>
  						<option value="处女座">处女座</option>
  						<option value="白羊座">白羊座</option>
  						<option value="双子座">双子座</option>
  						<option value="射手座">射手座</option>
  						<option value="巨蟹座">巨蟹座</option>
  						<option value="天秤座">天秤座</option>
  						<option value="摩羯座">摩羯座</option>
  						<option value="水瓶座">水瓶座</option>
  					</select>
  				</td>
  			</tr>
  			<tr>
	  			<td>
	  				<input type="submit" value="提交" />
	  			</td>
	  			<td>
	  				<input type="button" value="返回" onclick="javascript:history.back();"/>
	  			</td>
  			</tr>
  		</table>
  	
  	</form>
  	
  <body>
    
  </body>
</html>
