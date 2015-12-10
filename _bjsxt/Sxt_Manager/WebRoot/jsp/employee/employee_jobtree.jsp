<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="js/jquery/ztree/zTreeStyle/zTreeStyle.css" type="text/css"> 
	<script type="text/javascript" src="js/jquery/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/jquery/ztree/jquery-ztree-2.0.js"></script>
	<script type="text/javascript">
	var zTree1;
	var setting;

		setting = {
			checkType: { "Y":"", "N":""} ,	//设置该tree完全不影响父子关系 
			checkable: true,
			checkRadioType: "all",  //all 代表选择范围 所有的树内单选  level 某一个树下单选
			callback: {
				change:	zTreeOnChange
			}
		};
		
	$(document).ready(function(){

		var callbackNode = parent.jobNodeIds;
		$.post('EmployeeAction!getJobTree' , {jobNodeIds:callbackNode} , function(data){
				var zz = eval(data);
				setting.checkRadioType = 'all';
				zTree1 = $("#treeDemo").zTree(setting, zz);
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
		//子窗体  调用父窗体的函数  并传递子窗体的参数
		var nodes = zTree1.getCheckedNodes(); 
		var strId = '' ; 
		var strName = '';
		for(var i = 0 ; i <nodes.length ; i++ ){
						strId += nodes[i].id + ',';
						strName += nodes[i].name + ',';
		}
		var m = new map();
		m.nodeId = strId.substring(0 , strId.length -1);
		m.nodeName = strName.substring(0 , strName.length - 1);
		parent.getMap(m);
		

		
	}


	function map(nodeId , nodeName){
			this.nodeId = nodeId;
			this.nodeName = nodeName;

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
	
	
	
	
	</script>
  </head>
  
  <body>
						<div class="zTreeDemoBackground">
							<ul id="treeDemo" class="tree"></ul>
						</div>	
  </body>
</html>

