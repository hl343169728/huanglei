<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>学员新增</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/jquery-1.6.1.js"></script>

<script type="text/javascript">
	$(function() {
		$.ajax({
			type : 'post',
			url : 'ClzAction!getAllClz',
			dataType : 'text',
			async : false,
			timeout : 2000,
			success : function(result) {
				var data = eval(result);
				for (var i = 0; i < data.length; i++) {
					$('#sel').append("<option value="+data[i].id+">" + data[i].cname + "</option>");
				}
			}
		});
	});
</script>
</head>

<body>
	<form action="StudentAction!save" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>姓名：</td>
				<td><input name="student.sname" value="" /></td>
			</tr>
			<tr>
				<td>联系方式：</td>
				<td><input name="student.phone" value="" /></td>
			</tr>
			<tr>
				<td>年龄：</td>
				<td><input name="student.age" value="" /></td>
			</tr>
			<tr>
				<td>上传图片:</td>
				<td><input name="image" type="file" /></td>
			</tr>
			<tr>
				<td>学生行号：</td>
				<td><input name="student.srow" value="${param.srow}" /></td>
			</tr>
			<tr>
				<td>学生列号：</td>
				<td><input name="student.scol" value="${param.scol}" /></td>
			</tr>
			<tr>
				<td>班级：</td>
				<td><select id="sel" name="student.cid" /></select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="提交" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
