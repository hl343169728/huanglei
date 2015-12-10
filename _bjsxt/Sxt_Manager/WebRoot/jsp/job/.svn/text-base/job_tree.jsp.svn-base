<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'job_tree.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script>
    <link rel="stylesheet" href="js/jquery/ztree/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="js/jquery/ztree/jquery-ztree-2.0.js"></script>
  	<script type="text/javascript">


	var zTree1;
	var setting;

	setting = {
		checkable: true,
		checkStyle: "radio",
		checkRadioType: "all",
		callback: {
			beforeClick:	zTreeBeforeClick,
			beforeChange:	zTreeBeforeChange,
			click:	zTreeOnClick ,
			change:	zTreeOnChange
		}
	};

	$(document).ready(function(){
		// parent.nodeId  获取父窗体给我准备的nodeId 传递到后台 用于显示父id   
		$.post('JobAction!getZTreeJob' ,{id:parent.nodeId},function(data){
			var zNodes = eval(data);
			setting.checkRadioType = 'all';
			zTree1 = $("#treeDemo").zTree(setting, zNodes); 
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
		return r;
	}	

	function zTreeOnClick(event, treeId, treeNode) {
		$("#onClickNode").html( "[" + getTime() + "]  treeId=" + treeId + ";<br/>&nbsp;tId=" + treeNode.tId + "; Name=" + treeNode.name + " (节点Index = " + zTree1.getNodeIndex(treeNode) + ")");
	}

	function zTreeOnChange(event, treeId, treeNode) {
		$("#onChangeNode").html( "[" + getTime() + "]  treeId=" + treeId + ";<br/>&nbsp;tId=" + treeNode.tId + "; Name=" + treeNode.name + "; Checked=" + treeNode.checkedNew);
		getCheckedNodesLength();	

		//iframe回调函数  传递3个参数 nodeid  nodename  isChecked 
		parent.back_info(treeNode.id ,treeNode.name ,treeNode.checkedNew);
				
	}

	function getRadioType() {
		var level = $("#level").attr("checked")? "level":"";
		var all = $("#all").attr("checked")? "all":"";		
		return level + all;
	}


	function refreshTree() {
		setting.checkRadioType =getRadioType();
		zTree1 = $("#treeDemo").zTree(setting, zNodes);
		$("#onClickNode").html("<br/>");
		$("#onChangeNode").html("<br/>");
		getCheckedNodesLength();

	}

	function getCheckedNodesLength() {
		var tmp = zTree1.getCheckedNodes(true);
		$("#checkedNum").html(tmp.length);
	}

	
 	
  	
  	</script>
  </head>
  
  
  <body>
			<div  style="height:300;">
				<ul id="treeDemo" class="tree"></ul>
			</div>
  </body>
</html>
