<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>班级详情</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript">
		
		//提问函数 
		function question(){
			var dvs = document.getElementsByTagName('div');
			var ss = [];
			for(var i = 0; i < dvs.length; i++){
				if(dvs[i].id.length != 0 && dvs[i].id.indexOf("_") != -1){
					ss.push(dvs[i].id);
					dvs[i].style.backgroundColor = "blue";
				}
			}
			if(ss.length == 0){
				alert("该班级下无人");
				return ;
			}
			var id = parseInt(Math.random()*ss.length);
			var target = document.getElementById(ss[id]);
			target.style.backgroundColor = "red";
		};

		//添加学员 
		function addStudent(cid,srow,scol){
			window.location = "jsp/student/student_add.jsp?cid="+cid+"&srow="+srow+"&scol="+scol;
		};
	</script>

</head>

<body>
	<form action="" method="post">
		<table border="1" style="border-collapse: collapse;">
			<tr>
				<td>班级名称：</td>
				<td>${clz.cname}</td>
			</tr>
			<tr>
				<td>地址：</td>
				<td>${clz.address}</td>
			</tr>
			<tr>
				<td>任课教师：</td>
				<td>${clz.teacher}</td>
			</tr>
			<tr>
				<td>行数：</td>
				<td>${clz.crow}</td>
			</tr>
			<tr>
				<td>列数：</td>
				<td>${clz.ccol}</td>
			</tr>
		</table>
	</form>
	<hr />
	<input type="button" value="提问" onclick="question();" />
	<table border="1" style="border-collapse: collapse;">
		<s:iterator var="i" begin="1" end="clz.crow">
			<tr>
				<s:iterator var="j" begin="1" end="clz.ccol">
					<td><s:if test="map[#i+'_'+#j].id != 0">
							<div id="<s:property value="#i+'_'+#j"/>" style="background-color: blue; width: 100px; height: 100px;">
								<s:property value="map[#i+'_'+#j].sname" />
								<!-- <s:property value="map[#i+'_'_#j].imagePath"/> -->
							</div>
						</s:if> <s:else>
							<div onclick="addStudent(${clz.id},${i},${j});" style="background-color: yellow; width: 100px; height: 100px;">此位置暂时无人</div>
						</s:else></td>
				</s:iterator>
			</tr>
		</s:iterator>
	</table>
</body>
</html>
