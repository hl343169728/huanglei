<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'student_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	
	<script type="text/javascript">
		//添加学生函数 
		function addStudent(url){
			window.location = url;
		}

		//多选  
		function selectAll(flag,nodeName){
			var ids = document.getElementsByName(nodeName);
			if(flag){
				for(var i in ids){
					ids[i].checked = "checked";
				}
			}else{
				for(var i in ids){
					ids[i].checked = "";
				}
			}
		}

		//修改学生信息的函数 ，要获取学员的id 
		function preUpdate(myform,action){
			var ss = document.getElementsByName('ids');
			var id = [];
			for(var i in ss){
				if(ss[i].checked){
					id.push(ss[i].value);
				}
			}
			if(id.length == 0){
				alert("至少选择一个！");
				return ;
			}else if(id.length > 1){
				alert("至多选择一个！");  
				return ;
			}else{
				var inp = document.createElement("input");
				inp.type="hidden";
				inp.value=id[0];
				inp.name="id";
				myform.appendChild(inp);
				myform.action = action;
				myform.submit();
			}
		}

		//删除函数 ,获取要删除的所有学员 
		function del(myform,action){
			if(confirm("确认删除?")){
				var ids = document.getElementsByName("ids");
				var count = 0;
				for(var i in ids){
					if(ids[i].checked){
						count++;
						var inp = document.createElement("input");
						inp.type="hidden";
						inp.value=ids[i].value;
						inp.name="ids"; 
						myform.appendChild(inp);
					}
				}
				if(count >0){
					myform.action = action ;
					myform.submit();
				}else{
					alert("至少选择一个！");
					return ;
				}
			}
		}
	</script>

  </head>
  
  <body>
  		<br/>
    	<div align="center">
    		<font color="red" size=6><b>学员信息列表</b></font>
    	</div><br/>
    	<s:action name="studentAction!list" namespace="/" var="a"></s:action>
    	<div align="center">
	    	<fieldset>
	    		<legend onclick="$('#dv').toggle(1000);" align="top">查询面板</legend>
	    		<div id="dv">
    				<form action="studentAction!list" method="post">
    					姓名：<input name="sname" value=""/>
    						  <input type="submit" value="查询"/>
    				</form>
	    		</div>
	    	</fieldset>
    	</div>
    	<br/>
    	<table border="1" style="border-collapse: collapse;" align="center" width="60%">
    		<tr align="center">
    			<th>
    				<input type="checkbox" onchange="selectAll(this.checked,'ids')"/>全选
    			</th>
    			<th>姓名</th>
    			<th>所在院校</th>
    			<th>家庭住址</th>
    		</tr>
    		<s:iterator var="temp" value="#a.pageInfo.list">
    			<tr align="center">
    				<td>
    					<input name="ids" type="checkbox" value="${temp.id}"/>
    				</td>
    				<td>${temp.sname}</td>
    				<td>${temp.school}</td>
    				<td>${temp.address}</td>
    			</tr>
    		</s:iterator>
    	</table>
    	<br/>
    	<div align="center">
	    	<form action="" method="post">
	    		<input type="button" value="添加学员" onclick="addStudent('jsp/student/student_add.jsp');"/>
	    		<input type="button" value="修改学员信息" onclick="preUpdate(this.form,'studentAction!preUpdate')"/>
	    		<input type="button" value="删除学员" onclick="del(this.form,'studentAction!del')"/>
	    	</form>
    	</div>
  </body>
</html>
