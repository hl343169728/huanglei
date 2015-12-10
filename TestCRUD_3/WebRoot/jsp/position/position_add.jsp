<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'position_add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript"  src="js/fckeditor/fckeditor.js"></script>
	<script type="text/javascript">
			window.onload = function(){
				var fck = new FCKeditor('description');
				fck.BasePath = "js/fckeditor/"; //一定要指定 ,并以'/'结尾 
				fck.Height = 300 ; 
				fck.Width  = 500 ;
				fck.ToolbarSet="MyTemplate";		//指定一种模版形式
				fck.ReplaceTextarea();
			}
	</script>
  </head>
  
  <body>
	<form action="PositionServlet" method="post">
		<input type="hidden" name="method" value="save"/>
			<table>
				<tr>
					<td>岗位名称：</td>
					<td><input type="text" name="name" value="" /></td>
				</tr>
				<tr>
					<td>岗位等级：</td>
					<td>
						<select name="level">
							<option value="0">--请选择--</option>
							<option value="1">高级</option>
							<option value="2">中级</option>
							<option value="3">普通</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>岗位描述：</td>
					<td>
						<textarea name="description"></textarea>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="提交信息" /></td>
					<td><input type="button" value="返回" onclick="javascript:history.back();"/></td>
				</tr>
			</table>
	</form>
  </body>
</html>
