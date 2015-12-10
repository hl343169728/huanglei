<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script>
    <link rel="stylesheet" href="js/jquery/ztree/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="js/jquery/ztree/jquery-ztree-2.0.js"></script>
	<SCRIPT LANGUAGE="JavaScript">
		//定义两个全局的变量 
		var zTree1;
		var setting;

		setting = {
			checkable: true,
			checkStyle: "radio",
			checkRadioType: "all",
			callback: {
				beforeClick:	zTreeBeforeClick,
				beforeChange:	zTreeBeforeChange,
				click:	zTreeOnClick,
				change:	zTreeOnChange
			}
		};

		$(document).ready(function(){
				$.post('OrgAction!getOrgZtree',{orgId:parent.orgId} , function(data){
						var result = eval(data);
						setting.checkRadioType = 'all';                  //圆选按钮 
						zTree1 = $("#treeDemo").zTree(setting, result);
						$("#onClickNode").html("<br/>");
						$("#onChangeNode").html("<br/>");
						getCheckedNodesLength();
				});
		});
	
		function getTime() {
			var now= new Date();
			var hour=now.getHours();
			var minute=now.getMinutes();
			var second=now.getSeconds();
			return (hour+":"+minute+":"+second);	
		}
	
		function zTreeBeforeClick(treeId, treeNode) {
			var r = $("#beforeClickTrue").attr("checked");
			//if (!r) alert("beforeClick return false!!");
			return r;
		}
	
		function zTreeBeforeChange(treeId, treeNode) {
			var r = $("#beforeChangeTrue").attr("checked");
			//if (!r) alert("beforeChange return false!!");
			return r;
		}	
	
		function zTreeOnClick(event, treeId, treeNode) {
			$("#onClickNode").html( "[" + getTime() + "]  treeId=" + treeId + ";<br/>&nbsp;tId=" + treeNode.tId + "; Name=" + treeNode.name + " (节点Index = " + zTree1.getNodeIndex(treeNode) + ")");
		}
	
		function zTreeOnChange(event, treeId, treeNode) {
			$("#onChangeNode").html( "[" + getTime() + "]  treeId=" + treeId + ";<br/>&nbsp;tId=" + treeNode.tId + "; Name=" + treeNode.name + "; Checked=" + treeNode.checkedNew);
			getCheckedNodesLength();
			//调用父窗口中方法 
			//isParent  :表示是否为父节点 
			if(!treeNode.isParent){
				parent.callback(treeNode.id,treeNode.name,treeNode.checkedNew);
			}else{
				treeNode.checkedNew = false;
			}
		}
	
		function getRadioType() {
			//var level = $("#level").attr("checked")? "level":"";
			var all = $("#all").attr("checked")? "all":"";
			return all;
		}
	
		function getCheckedNodesLength() {
			var tmp = zTree1.getCheckedNodes(true);
			$("#checkedNum").html(tmp.length);
		}
		
  </SCRIPT>
 </HEAD>
  
  <body>
   		<ul id="treeDemo" class="tree"></ul>
  </body>
</html>
