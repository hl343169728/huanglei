<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

		<%
			String url = request.getParameter("url");
			if(url.indexOf("?")==-1){
				url += "?pageNum=";
				request.setAttribute("url",url);
			}else{
				url += "&pageNum=";
				request.setAttribute("url",url);
			}
		%>

总记录数：<s:property value="#a.pageInfo.totalRecord" />条  | 总页数 ：共<s:property value="#a.pageInfo.pageCount" />页 
		<hr/>
		<s:if test="#a.pageInfo.pageNum<2">
			<font size=8 color=red >首页</font> 
		</s:if>
		<s:else>
			<a href="${request.url}${i-1}" ><font size=6 >上一页</font> </a>
		</s:else>
		
		<s:iterator  var="i"  begin="#a.pageInfo.pageBegin"  end="#a.pageInfo.pageEnd" >
			<s:if test="#a.pageInfo.pageNum==#i">
				<font size=8 color=red >${i}</font> 
			</s:if>
			<s:else>
				<a href="${request.url}${i}" ><font size=6 >${i}</font> </a>
			</s:else>
		</s:iterator>
		<!-- 当前页等于总页数的时候 -->
		<s:if test="#a.pageInfo.pageNum==#a.pageInfo.pageCount">
			<font size=6>尾页</font>
		</s:if>
		<s:elseif test="#a.pageInfo.pageNum<=1">
			<a href="${request.url}2" ><font size=6 >下一页</font> </a>
		</s:elseif>
		<s:else>
			<a href="${request.url}${i+1}" ><font size=6 >下一页</font> </a>
		</s:else>
		<form action="${param.url}" method="post">
			<input name="pageNum"  size="2" /><input type="submit"  value="go"  />
		</form>
