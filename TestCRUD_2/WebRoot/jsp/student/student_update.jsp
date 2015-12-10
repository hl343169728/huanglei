<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.bjsxt.model.Student" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'student_update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  	<%
  		Student s = (Student)request.getAttribute("s");
  	%>
  <body>
	<form action="StudentServlet" method="post">
	
		<input type="hidden" name="method" value="update" />
		<input type="hidden" name="id" value="<%=s.getId() %>"/>
		
		<table>
			<tr>
				<td>姓名：</td>
				<td><input type="text" name="studentname" value="<%=s.getName() %>" /></td>
			</tr>
			<tr>
				<td>学号：</td>
				<td><input type="text" name="cardId" value="<%=s.getCardId() %>" /></td>
			</tr>
			<tr>
				<td>生日：</td>
				<td><input type="text" name="birthday" value="<%=s.getBirthday() %>" /></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td>
					<input type="radio" name="sex" value="1" <%="1".equals(s.getSex())?"checked":"" %> />男&nbsp;&nbsp;&nbsp;
					<input type="radio" name="sex" value="2" <%="2".equals(s.getSex())?"checked":"" %> />女
				</td>
			</tr>
			<tr>
				<td>爱好：</td>
				<td>
					<input type="checkbox" name="favorite" value="1" <%="1".equals(s.getFavorite())?"checked":"" %>/>学java&nbsp;&nbsp;
					<input type="checkbox" name="favorite" value="2" <%="2".equals(s.getFavorite())?"checked":"" %>/>敲java代码&nbsp;&nbsp;
					<input type="checkbox" name="favorite" value="3" <%="3".equals(s.getFavorite())?"checked":"" %>/>看java视频&nbsp;&nbsp;
					<input type="checkbox" name="favorite" value="4" <%="4".equals(s.getFavorite())?"checked":"" %>/>看java书
				</td>
			</tr>
			<tr>
				<td>毕业院校：</td>
				<td><input type="text" name="university" value="<%=s.getUniversity() %>" /></td>
			</tr>
			<tr>
				<td>民族：</td>
				<td><input type="text" name="nationality" value="<%=s.getNationality() %>" /></td>
			</tr>
			<tr>
				<td>星座：</td>
				<td>
					<select name="constellation">
						<option value="0">--请选择--</option>
						<option value="双鱼座" <%="双鱼座".equals(s.getConstellation())?"selected":"" %>>双鱼座</option>
						<option value="金牛座" <%="金牛座".equals(s.getConstellation())?"selected":"" %>>金牛座</option>
						<option value="天蝎座" <%="天蝎座".equals(s.getConstellation())?"selected":"" %>>天蝎座</option>
						<option value="狮子座" <%="狮子座".equals(s.getConstellation())?"selected":"" %>>狮子座</option>
						<option value="处女座" <%="处女座".equals(s.getConstellation())?"selected":"" %>>处女座</option>
						<option value="白羊座" <%="白羊座".equals(s.getConstellation())?"selected":"" %>>白羊座</option>
						<option value="双子座" <%="双子座".equals(s.getConstellation())?"selected":"" %>>双子座</option>
						<option value="射手座" <%="射手座".equals(s.getConstellation())?"selected":"" %>>射手座</option>
						<option value="巨蟹座" <%="巨蟹座".equals(s.getConstellation())?"selected":"" %>>巨蟹座</option>
						<option value="天秤座" <%="天秤座".equals(s.getConstellation())?"selected":"" %>>天秤座</option>
						<option value="摩羯座" <%="摩羯座".equals(s.getConstellation())?"selected":"" %>>摩羯座</option>
						<option value="水瓶座" <%="水瓶座".equals(s.getConstellation())?"selected":"" %>>水瓶座</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="修改" />
				</td>
				<td>
					<input type="button" value="返回" onclick="javascript:history.back();" />
				</td>
			</tr>
		</table>
	</form>
  </body>
</html>
