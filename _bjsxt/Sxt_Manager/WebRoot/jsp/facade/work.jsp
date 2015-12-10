<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>尚学堂内部管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@ include file="../../jsp/globalresults/commons.jsp" %>
		<script type="text/javascript">
				$(function(){
						$('a').click(function(){
							var $myframe = $('#myframe');
							//$myframe.css('background','');
							//$myframe.attr('src' , $(this).attr('title'));
							var domframe = $myframe.get(0);
							domframe.style.background = '';
							domframe.src = $(this).attr('title');	
						});
						var p1 = $('#lay').layout('panel','west').panel({
							onCollapse:function(){
								//alert('collapse');
							}
						});
						var p2 = $('#lay').layout('panel','north').panel({
							onCollapse:function(){
								//alert('collapse');
							}
						});
				});
		</script>
	  </head>
	  
	  <body>
	   	<div id="lay" class="easyui-layout" style="padding: 50px;width: 1250px;height: 570px;">
	   		<div region="north" split="true" title="尚学堂内部管理系统" style="height:80px;"><b>欢迎您 ,${sessionScope.loginUser.uname}!!</b></div>
	   		<div region="west" title="菜单栏"   iconCls="icon-ok" split="true"  style="width:200px;">
					<ul id="tt1" class="easyui-tree" animate="true" > <!-- dnd="true" 提供是否拖拽功能 -->
						<li state="closed">
							<span>组织管理</span>
							<ul>
								<li><a title="jsp/org/org_list.jsp">组织机构列表</a></li>
							</ul>
						</li>
						<li state="closed">
							<span>职位管理</span>
							<ul>
								<li><span ><a title="jsp/job/job_list.jsp">职位列表</a></span></li>
							</ul>
						</li>
						<li state="closed">
							<span>员工管理</span>
							<ul>
								<li><a title="jsp/employee/employee_add.jsp">新增职员</a></li>
								<li><span ><a title="jsp/employee/employee_onlist.jsp">在职员工列表</a></span></li>
								<li><span ><a title="jsp/employee/employee_outlist.jsp">离职员工列表</a></span></li>
							</ul>
						</li>
						<li state="closed">
							<span>用户管理</span>
							<ul>
								<li><span ><a title="jsp/user/user_register.jsp">增加新系统账号</a></span></li>
								<li><span ><a title="jsp/user/user_updatepassword.jsp">密码修改</a></span></li>
								<li><span ><a title="jsp/user/user_list.jsp">用户列表</a></span></li>
							</ul>
						</li>
						<li state="closed">
							<span>日程管理</span>
							<ul>
								<li><span ><a title="">File 1</a></span></li>
								<li><span ><a title="">File 1</a></span></li>
								<li><span ><a title="">File 1</a></span></li>
							</ul>
						</li>
						<li state="closed">
							<span>站内交流</span>
							<ul>
								<li><span ><a title="jsp/message/message_add.jsp">写信</a></span></li>
								<li><span ><a title="jsp/message/message_inBox.jsp">收件箱</a></span></li>
								<li><span ><a title="jsp/message/message_outBox.jsp">发件箱</a></span></li>
								<li><span ><a title="jsp/message/message_dustBox.jsp">垃圾箱</a></span></li>
							</ul>
						</li>
						<li state="closed">
							<span>备忘录</span>
							<ul>
								<li><span ><a title="jsp/memo/memo_add.jsp">增加备忘录</a></span></li>
								<li><span ><a title="jsp/memo/memo_validList.jsp">有效的备忘录</a></span></li>
								<li><span ><a title="jsp/memo/memo_allList.jsp">显示所有的备忘录</a></span></li>
							</ul>
						</li>
						<li state="closed">
							<span>财务管理</span>
							<ul>
								<li><span ><a title="jsp/shouru/shouru_in.jsp">录入收入信息</a></span></li>
								<li><span ><a title="jsp/zhichu/zhichu_out.jsp">录入支出信息</a></span></li>
								<li><span ><a title="jsp/shouru/shouru_inList.jsp">查看自己录入收入信息</a></span></li>
								<li><span ><a title="jsp/zhichu/zhichu_outList.jsp">查看自己录入支出信息</a></span></li>
							</ul>
						</li>
						<li state="closed">
							<span>先就业后付款管理</span>
							<ul>
								<li><span ><a title="">File 1</a></span></li>
								<li><span ><a title="">File 1</a></span></li>
								<li><span ><a title="">File 1</a></span></li>
							</ul>
						</li>
						<li state="closed">
							<span>客户关系管理系统</span>
							<ul>
								<li><span ><a title="jsp/student/student_add.jsp">增加意向学员</a></span></li>
								<li><span ><a title="jsp/student/student_list.jsp">意向学员列表</a></span></li>
								<li><span ><a title="jsp/student/student_leaveList.jsp">不来学员列表</a></span></li>
								<li><span ><a title="jsp/student/student_preStudentList.jsp">预备学员列表</a></span></li>
								<li><span ><a title="jsp/student/student_realStudentList.jsp">正式学员列表</a></span></li>
							</ul>
						</li>
						<li state="closed">
							<span>班级管理</span>
							<ul>
								<li><span ><a title="jsp/grade/grade_add.jsp">增加班级</a></span></li>
								<li><span ><a title="jsp/grade/grade_list.jsp">班级信息列表</a></span></li>
							</ul>
						</li>
						<li state="closed">
							<span>教务系统</span>
							<ul>
								<li><span ><a title="">File 1</a></span></li>
								<li><span ><a title="">File 1</a></span></li>
								<li><span ><a title="">File 1</a></span></li>
							</ul>
						</li>
						<li state="closed">
							<span>宿舍管理</span>
							<ul>
								<li><span ><a title="">File 1</a></span></li>
								<li><span ><a title="">File 1</a></span></li>
								<li><span ><a title="">File 1</a></span></li>
							</ul>
						</li>
						<li state="closed">
							<span>就业管理</span>
							<ul>
								<li><span ><a title="">File 1</a></span></li>
								<li><span ><a title="">File 1</a></span></li>
								<li><span ><a title="">File 1</a></span></li>
							</ul>
						</li>
						<li state="closed">
							<span>老学员跟踪</span>
							<ul>
								<li><span ><a title="">File 1</a></span></li>
								<li><span ><a title="">File 1</a></span></li>
								<li><span ><a title="">File 1</a></span></li>
							</ul>
						</li>
						<li state="closed">
							<span>市场渠道管理</span>
							<ul>
								<li><span ><a title="">File 1</a></span></li>
								<li><span ><a title="">File 1</a></span></li>
								<li><span ><a title="">File 1</a></span></li>
							</ul>
						</li>
						<li state="closed">
							<span>公司运行状态统计</span>
							<ul>
								<li><span ><a title="">File 1</a></span></li>
								<li><span ><a title="">File 1</a></span></li>
								<li><span ><a title="">File 1</a></span></li>
							</ul>
						</li>
						<li state="closed">
							<span>学员学习辅助系统</span>
							<ul>
								<li><span ><a title="">File 1</a></span></li>
								<li><span ><a title="">File 1</a></span></li>
								<li><span ><a title="">File 1</a></span></li>
							</ul>
						</li>
						<li state="closed">
							<span>我的工作中心</span>
							<ul>
								<li><span ><a title="">File 1</a></span></li>
								<li><span ><a title="">File 1</a></span></li>
								<li><span ><a title="">File 1</a></span></li>
							</ul>
						</li>
						<li state="closed">
							<span>权限管理</span>
							<ul>
								<li><span ><a title="">File 1</a></span></li>
								<li><span ><a title="">File 1</a></span></li>
								<li><span ><a title="">File 1</a></span></li>
							</ul>
						</li>											
					</ul>					
	   		</div>
	   		<div id="main" region="center" title="主界面" style="padding-left: 0px;padding-top: 0px;">
	   			 <iframe id="myframe" style="background:url('images/blank.jpg');" width="100%" scrolling="no" height=100% frameborder="0"></iframe> 
	   		</div>
	   	</div>
	  </body>
	</html>