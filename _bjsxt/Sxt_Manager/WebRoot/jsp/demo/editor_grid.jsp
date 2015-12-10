<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'user_list.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@ include file="../../jsp/globalresults/commons.jsp" %>
	<script type="text/javascript">
		$(function(){
					//自定义的校验器 
				$.extend($.fn.validatebox.defaults.rules, { 
						checkName: { 
								validator: function(value, param){ 
												return value.length >= param[0] && value.length <= param[1] ; 
											}
								, 
								message: '' 
						}  ,
						checkCardId : {
								validator: function(value , param){
										return value.length == param[0] || value.length == param[1] ;
								} , 
								message: ''	
						}
				});
					
				var roleArray =[];
			
				$('#temp').datagrid({
					title : '用户列表'  , 
					iconCls:'icon-ok',
					width:900,
					height:470,
					pageSize:10,
					pageList:[5,10,15,20],
					nowrap:false,				//是否在一行显示数据
					striped: true,				//是否显示斑马线
					collapsible:true,			//是否要滑动效果
					url:'EditorAction!getList',	//远程加载数据的地址
					loadMsg:'数据装载中......',	//加载信息时的等待提示信息
					//sortName:'age',			//定义排序列
					//sortOrder:'desc',			//定义排序方式
					singleSelect: true ,		//单选模式 
					fitColumns: true ,
					/* 
					frozenColumns:[
						[			//定义复选框
							{field:'ids',checkbox:true}
				    	]
				    ],*/
					columns:[[					//定义字段列
						{title:'姓名',field:'name',width:'100',rowspan:2,align:'center', sortable: true , 
							editor:{
								type:'validatebox' ,
								options:{
									required:true ,
									missingMessage:"该项必填!" , 
									validType:"checkName[2,5]" ,
									invalidMessage:"姓名必须在2到5个字符之间!" 
								}
							}
						},
						{title:'年龄',field:'age',width:'100',rowspan:2,align:'center' ,
							editor:{
								type:'numberbox',
								options:{min:0 ,max:120,precision:0}
							}
						},
						{title:'出生日期',field:'birthday',width:'100',rowspan:2,align:'center', sortable: true ,
							editor:{
								type:'datebox',
								options:{
									currentText : '今天',
									closeText : '关闭',
									disabled : false,
									required : true,
									missingMessage : '该项必填！',
									formatter : formatDate
								}
							}	
						}, 
						{title:'性别',field:'sex',width:'100',rowspan:2,align:'center', sortable: true ,
							formatter: function(value , record){
								if(value == '1'){
									return '<span style="color:red">男</span>';
								} else {
									return '<span style="color:green">女</span>'; 
								}
							} ,
							editor:{
								type:'combobox',
								options:{
			                        valueField:'sex',  
			                        textField:'val',  
			                        data:[{sex:1 ,val:'男'} ,{sex:2,val:'女'}],  
			                        required:true  
								}
							}
						},
						{title:'所属岗位',field:'r_id',width:'100',rowspan:2,align:'center' ,
			                formatter:function(value ,record){  
							    for(var i=0; i<roleArray.length; i++){  
                        			if (roleArray[i].id == value) return roleArray[i].name;  
                    			} 
			                    return value;  
			                },  
			                editor:{  
			                    type:'combobox',  
			                    options:{  
			                        valueField:'id',  
			                        textField:'name',  
			                        url:'EditorAction!getRole',  
			                        required:true  ,
			                        onLoadSuccess : function(){
			                			roleArray = $(this).combobox('getData');
			                        }
			                    }  
			                }
						},
						{field:'action',title:'操作',width:70,align:'center',   
				            formatter:function(value,row,index){  
				                if (row.editing){  
				                    var s = '<a href="javascript:void(0);" onclick="saverow('+index+')">Save</a> ';  
				                    var c = '<a href="javascript:void(0);" onclick="cancelrow('+index+')">Cancel</a>';  
				                    return s+c;  
				                } else {  
				                    var e = '<a href="javascript:void(0);" onclick="editrow('+index+')">Edit</a> ';  
				                    var d = '<a href="javascript:void(0);" onclick="deleterow('+index+')">Delete</a>';  
				                    return e+d;  
				                }  
				            }  
      						} 
					]],
						pagination:true,		// 是否要分页
						rownumbers:true,		// 是否显示行号
						onBeforeEdit:function(index,row){  
       						row.editing = true;  
      							$('#temp').datagrid('refreshRow', index);  
   						},  
					    onAfterEdit:function(index,row){  
					        row.editing = false;  
					        $('#temp').datagrid('refreshRow', index);  
					    },  
					    onCancelEdit:function(index,row){  
					        row.editing = false;  
					        $('#temp').datagrid('refreshRow', index);  
					    },
					    onLoadSuccess:function(){
					    	
					    }
			});	
			
		});

	    function editrow(index){  
	        $('#temp').datagrid('beginEdit', index);  
	    }  
	    function deleterow(index){  
	        $.messager.confirm('Confirm','Are you sure?',function(r){  
	            if (r){  
	                $('#temp').datagrid('deleteRow', index);  
	            }  
	        });  
	    }  
	    function saverow(index){  
	        $('#temp').datagrid('endEdit', index); 
	        var record = $('#temp').datagrid('getSelected');
	        $.post('EditorAction!update' ,record , function(data){
	        	$('#temp').datagrid('reload');
	        });
	    }  
	    function cancelrow(index){  
	        $('#temp').datagrid('cancelEdit', index);  
	    }
	    
	    
	    
	    
	    function displayMsg($table){	//$('#t_user')
			var pager = $table.datagrid('getPager');
			pager.pagination({
				loading:false,
				showPageList:true,
				showRefresh:true,
				beforePageText:'第',
				afterPageText:'页,共{pages}页',
				displayMsg:'当前显示记录数:第{from}到{to}条记录,共{total}条记录'
			});
		}
	</script>
  </head> 
  <body>
  	<table id="temp"></table>
  </body>
</html>
