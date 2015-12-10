<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<%@ include file="../../jsp/globalresults/commons.jsp" %>
	
	<script type="text/javascript">
	//自定义的校验器 
	$(function(){
			$.extend($.fn.validatebox.defaults.rules,{ //验证框 
				checkNumber:{
					validator:function(value,param){
						return value.length>=param[0]&&value.length<=param[1];
						}
					,
					message:''
				}
			});
		//日期框
		$('#preTrainDate').datebox({
			currentText : '今天', 			//为当前日期按钮显示的文本 
			closeText : '关闭',  			//关闭按钮显示的文本 
			disabled : false,	  			//如果为true，则禁用输入框 
			required : true,	  			//定义输入框是否为必填项 
			missingMessage : '该项必填！',	//当文本框为空的时候显示的文本
			formatter : formatDate			//formatDate (utils.js)
		});
		//提交表单 
		$('#btn').click(function(){
			//return boolean
			if($('#myform').form('validate')){//固定的写法
				$('#myform').get(0).submit(); //JQuery对象转为dom对象的方式提交 
			}else{
				//失败
				$.messager.alert('提示信息 ','提交失败  ','error');
			}
		});
	});	
	
	function check(){
			$.ajax({
				url:'StudentAction!checkStudentQQ',			   		//发送请求的地址 
				type:'post',									    //请求方式 ，默认为GET方式 
				async:false,     								    //默认情况下为异步请求，在这里为同步请求   
				timeout:2000,									    //设置请求超时时间 
				dataType:'text',								    //预期服务器返回的数据类型 
				data:{qq:$('#stuQQ').val()},    					//发送到服务器的数据 
				success:function(result){							//请求成功后回调函数 
					if(result == "1"){
						$.messager.confirm('信息提示','该QQ已存在！','error');
					}
				}                          
			});
	}
	</script>
  </head>
  
  <body>
   <div id="p" class="easyui-panel" title="修改意向学员信息" icon="icon-save"
		collapsible="true"  maximizable="true" 
		style="width: 1000px; height: 400px; padding: 10px; background: #fafafa;">
		<form id="myform" action="StudentAction!updateStudent" method="post">
			<input id="id" name="id" type="hidden" value="${student.id}"/>
			<table>
				<tr>
					<td>姓名：</td>
					<td><input name="student.sname" value="${student.sname}" /></td>
				</tr>
				<tr>
					<td>QQ：</td>
					<td>
					<!-- required:表示该项是否为必填项
						 missingMessage:表示当文本框为空是的提示信息
						 validType:定义字段的验证类型
						 invalidMessage:表示当文本框内容不合法时提示的文本信息
					 -->
						<input id="stuQQ" name="student.qq" onblur="check()" class="easyui-validatebox" required="true" missingMessage="该项必填!" value="${student.qq}"/>
					</td>
				</tr>
				<tr>
					<td>手机号码：</td>
					<td><input name="student.phone" value="${student.phone}"/></td>
				</tr>
				
				<tr>
					<td>毕业院校：</td>
					<td><input name="student.university" value="${student.university}"/></td>
				</tr>
				<tr>
					<td>专业：</td>
					<td><input name="student.department" value="${student.department}"/></td>
				</tr>
				<tr>
					<td>年级：</td>
					<td><input name="student.grade" class="easyui-validatebox" required="true" missingMessage="该项必填!" validType="" invalidMessage="必须为四位数字" value="${student.grade}"/></td>
				</tr>
				<tr>
					<td>学历：</td>
					<td>
						<input type="radio" name="student.diploma" value="高中" ${student.diploma eq "高中"?"checked":"" } }/>高中&nbsp;&nbsp;
						<input type="radio" name="student.diploma" value="专科" ${student.diploma eq "专科"?"checked":"" } }/>专科&nbsp;&nbsp;
						<input type="radio" name="student.diploma" value="本科" ${student.diploma eq "本科"?"checked":"" } }/>本科&nbsp;&nbsp;
						<input type="radio" name="student.diploma" value="硕士" ${student.diploma eq "硕士"?"checked":"" } }/>硕士&nbsp;&nbsp;
					</td>
				</tr>
				<tr>
					<td>是否在读：</td>
					<td>
						<input name="student.state" type="radio" value="是" ${student.state eq "是"?"checked":"" }/>是&nbsp;&nbsp;
						<input name="student.state" type="radio" value="否" ${student.state eq "否"?"checked":"" }/>否&nbsp;&nbsp;
					</td>
				</tr>						
				<tr>
					<td>欲参加培训时间：</td>
					<td><input id="preTrainDate" name="student.preTrainDate" value="${student.preTrainDate}"/></td>
				</tr>						
				<tr>
					<td>学费支付类型：</td>
					<td>
						<input name="student.payType" type="radio" value="先就业后付款" ${student.payType eq "先就业后付款"?"checked":"" }/>先就业后付款&nbsp;&nbsp;
						<input name="student.payType" type="radio" value="学期内付清" ${student.payType eq "学期内付清"?"checked":"" }/>学期内付清&nbsp;&nbsp;						
					</td>
				</tr>						
				<tr>
					<td>如何知道尚学堂：</td>
					<td>
						<input name="student.howKnow" type="radio" value="视频"        ${student.howKnow eq "视频"?"checked":"" }/>视频&nbsp;&nbsp;
						<input name="student.howKnow" type="radio" value="朋友推荐" 	   ${student.howKnow eq "朋友推荐"?"checked":"" }/>朋友推荐&nbsp;&nbsp;
						<input name="student.howKnow" type="radio" value="在校学员推荐" ${student.howKnow eq "在校学员推荐"?"checked":"" }/>在校学员推荐&nbsp;&nbsp;
						<input name="student.howKnow" type="radio" value="网上文章"     ${student.howKnow eq "网上文章"?"checked":"" }/>网上文章&nbsp;&nbsp;
						<input name="student.howKnow" type="radio" value="北风网"       ${student.howKnow eq "北风网"?"checked":"" }/>北风网&nbsp;&nbsp;
						其他：<input name="student.howKnow" type="text" value=""/>
					</td>
				</tr>
				<tr>
					<td>欲参加班级类型：</td>
					<td>
						<input name="student.classType" type="radio" value="业余班" ${student.classType eq "业余班"?"checked":""}/>业余班&nbsp;&nbsp;
						<input name="student.classType" type="radio" value="脱产班" ${student.classType eq "脱产班"?"checked":""}/>脱产班&nbsp;&nbsp;
						<input name="student.classType" type="radio" value="基地班" ${student.classType eq "基地班"?"checked":""}/>基地班&nbsp;&nbsp;
						<input name="student.classType" type="radio" value="网络班" ${student.classType eq "网络版"?"checked":""}/>网络班&nbsp;&nbsp;
						<input name="student.classType" type="radio" value="远程同步班" ${student.classType eq "远程同步班"?"checked":""}/>远程同步班&nbsp;&nbsp;
					</td>
				</tr>
				<tr>
					<td>其他信息：</td>
					<td><textarea name="student.description" rows="5" cols="60">${student.description}</textarea></td>
				</tr>						
				<tr>
					<td>
						<a id="btn" class="easyui-linkbutton" iconCls="icon-ok" type="button" href="javascript:void(0);">提交修改</a>
					</td>
					<td>
						<a class="easyui-linkbutton" iconCls="icon-back" type="button" href="javascript:history.back();">返回</a>
					</td>
				</tr>						
			</table>
		</form>
	</div>
  </body>
</html>