<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'demo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<s:head/>
	<sx:head/>
  </head>
  
  <body>
  <!-- 
  <%
  	request.setAttribute("d",new Date());
  %>
 	
    	<s:date name="#request.d" format="yyyy-MM-dd" />
    	<hr/>
    	
    	
    	<table border="1">
    		<s:iterator var="i" begin="1" end="10" status="ccc">
    			<s:if test="#ccc.isEven()">
    				<tr style="background-color:red;">
	    				<td>${i}</td>
	    				<td>${i}</td>
	    				<td>${i}</td>
    				</tr>
    			</s:if>
    			<s:else>
    				<tr>
    					<td>${i}</td>
    					<td>${i}</td>
    					<td>${i}</td>
    				</tr>
    			</s:else>
    		</s:iterator>
    	</table>
    	<hr/>
    	<table border="1">
    		<s:iterator var="i" begin="1" end="10" step="2">
    			<tr style="background-color:red;">
    				<td>${i}</td>
    				<td>${i}</td>
    				<td>${i}</td>
    			</tr>
    		</s:iterator>
    	</table>
    	<hr/>
  
   -->
  
    	<s:form>
    		<s:textfield label="用户名" name="uname"></s:textfield>
    		<s:password label="密码" name="password"></s:password>
    		<s:textfield label="邮箱" name="email"></s:textfield>
    		<s:file label="上传头像" name="logo"></s:file>
    		<s:set var="a" value="{'学java','用java','教java','发呆'}"></s:set>
    		<s:checkboxlist list="#request.a" name="favorite" label="喜欢做的事"></s:checkboxlist>
    		<s:radio list="#{'1':'男','0':'女'}" label="性别" name="gender" value="1"></s:radio>
    		<s:select list="{'上海','重庆','北京','西湖','杭州','宁波','厦门','汕头'}" label="所在地"></s:select>
    		<sx:autocompleter name="major" label="专业" list="{'计算机数学','计算机应用','计算机编程','英语专业','英语翻译'}"></sx:autocompleter>
    		<sx:datetimepicker name="birthday" label="出生日期" displayFormat="yyyy-MM-dd"></sx:datetimepicker>
    		<s:textarea label="自我介绍" name="selfInfo" rows="5" cols="30" value=""></s:textarea>
    		<s:checkbox label="已阅读协议" value="true" name="favorite" fieldValue="1"></s:checkbox>
    	</s:form>
    	<select>
    		<optgroup label="Swedish Cars">
    			<option value="volvo">Volvo</option>
    			<option value="saab">Saab</option>
    		</optgroup>
    		<optgroup label="German Cars">
    			<option value="mercedes">Mercedes</option>
    			<option value="audi">Audi</option>
    		</optgroup>
    	</select>
    	
    	<hr/>
    	
    	<sx:tree id="struts" label="框架" showRootGrid="true" showGrid="true" toggleDuration="1000">
    		<sx:treenode label="struts" id="1">
    			<sx:treenode label="ognl" id="11">
	    			<sx:treenode label="struts" id="2">
		    			<sx:treenode label="s1" id="21"></sx:treenode>
		    			<sx:treenode label="s2" id="22"></sx:treenode>
		    			<sx:treenode label="s3" id="23"></sx:treenode>
	    			</sx:treenode>
    			</sx:treenode>
    			<sx:treenode label="filter" id="12"></sx:treenode>
    			<sx:treenode label="debug" id="13"></sx:treenode>
    		</sx:treenode>
    		<sx:treenode label="spring" id="2">
    			<sx:treenode label="p1" id="11"></sx:treenode>
    			<sx:treenode label="p2" id="12"></sx:treenode>
    			<sx:treenode label="p3" id="13"></sx:treenode>
    		</sx:treenode>
    		<sx:treenode label="hibernamte" id="3">
    			<sx:treenode label="h1" id="11"></sx:treenode>
    			<sx:treenode label="h2" id="12"></sx:treenode>
    			<sx:treenode label="h3" id="13"></sx:treenode>
    		</sx:treenode>
    	</sx:tree>
  </body>
</html>
