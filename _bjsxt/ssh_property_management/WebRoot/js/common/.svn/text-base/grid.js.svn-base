/**
 * @VeryNice
 * @description : 本类是用于创建自定义datagrid 公共方法的抽取  
 * @param
 * @method 
 * 
 * 
 * @author .Best_oiYc
 * @version 1.0
 */
function GridConfig(){
		
		
		var _$table = undefined; 			//表格对象
		var _title = '' ;					//表格标题
		var _width = 1000 ; 				//表格宽度
		var _height = 450 ; 				//表格高度
		var _striped = false ; 				//表格是否使用斑马线条纹 默认false
		var _collapsible = false ; 			//表格是否使用滑动 默认false
		var _url = '' ; 					//远程加载表格数据地址
		var _loadMsg = '' ; 				//加载时等待信息
		var _sortName = false ;				//排序字段
		var _sortOrder = false ; 			//排序方式
		var _arr = [];						//列模式子集合
		var _columns = [[]];				//列模式总集合
		var _frozenColumns = false ;		//是否采用复选框模式
		var _toolbar = [] ; 				//工具栏
		var _pagination = false ; 			//是否采用分页 默认false
		var _rownumbers = false ; 			//是否使用行号 默认false
		var _CRUD_TYPE = true ;				//增删改查类型
		var _fitColumns = false ;			//是否自动填充容器
		var _iconCls = '';					//列表图标  edit_oiYc 1.01
		
		if(_CRUD_TYPE){
			_CRUD_TYPE = ['_save' , '_update' , '_delete' , '_search'];
		}


	
		/**
		 * 设置列模式
		 * @param {json object} columns
		 */
		this.setColumn = function (title , field ,width , rowspan , align , sortable , formatter){
			this.title = title ; 
			this.field = field ;
			this.width = width;
			this.rowspan = rowspan ;
			this.align = align ;
			this.sortable = sortable ; 
			this.formatter = formatter ;
			//设置数组内容
			_arr.push({'title': this.title, 'field': this.field, 'width': this.width,'rowspan': this.rowspan,'align': this.align,'sortable': this.sortable,'formatter': this.formatter});
			//return this;
		}					

		
		/**
		 * 设置工具栏信息
		 * @param {string , string , string} toolbar
		 */	
		this.setToolbar = function(text  , handlerType  ,handlerUrl){
			if(arguments.length != 3){
				return false ;
			}
			var j ;
			this.text = text ;
			this.iconCls = '' ; 
			this.handlerType = handlerType ; 
			this.handlerUrl  = handlerUrl;
			if(this.handlerType){
				//根据按钮类型对于icon的选取操作
				if('save' == this.handlerType){
					this.iconCls = 'icon-add';
				} else if('update' == this.handlerType){
					this.iconCls = 'icon-edit';				
				} else if('delete' == this.handlerType){
					this.iconCls = 'icon-remove';
				} else if('search' == this.handlerType){
					this.iconCls = 'icon-search'
				}
				//根据按钮类型调用指定crud方法 并传入远程地址
				_handler = function(){
	                for (j = _CRUD_TYPE.length; j--;) {
	                   	if(('_'+handlerType) == _CRUD_TYPE[j]){
	                   			eval(_CRUD_TYPE[j]+"('"+handlerUrl+"');");
	                   	} 
	                }				
				}	
				
			}
			//设置按钮
			_toolbar.push({'text': this.text, 'iconCls': this.iconCls ,'handler': _handler});
			//设置竖线
			_toolbar.push('-');
			//return this  ; 
		}
		
		
		/**
		 * 内置Map方法 , 用于盛装键值对
		 */
		 var Map = function(){
		    var Entry = function(key, value){  
		        this.key = key;  
		        this.value = value;  
		    };  
		    this.entries = new Array();  
		    this.put = function(key, value){  
		        for (var i = 0; i < this.entries.length; i++) {  
		            if (this.entries[i].key === key) {  
		                return false;  
		            }  
		        }  
		        this.entries.push(new Entry(key, value));  
		        return true;  
		    };  
		    this.get = function(key){  
		        for (var i = 0; i < this.entries.length; i++) {  
		            if (this.entries[i].key === key) {  
		                return this.entries[i].value;  
		            }  
		        }  
		        return null;  
		    }; 
			this.getArray = function(){
				return this.entries;
			}				
	    }
		
		/**
		 *		1.单独对分页组件进行配置 
		 */
		var _displayMsg = function(){	//$('#t_user')
			var pager = _$table.datagrid('getPager');
			pager.pagination({
				loading:false,
				showPageList:true,
				showRefresh:true,
				beforePageText:'第',
				afterPageText:'页,共{pages}页',
				displayMsg:'当前显示记录数:第{from}到{to}条记录,共{total}条记录'
			});
		}
		
		/**
		 * 保存方法
		 * @param {} reloadURL
		 */
		var _save = function(reloadURL){
				window.location.href = reloadURL;
		}
		
		
		/**
		 * 		2.批量删除方法
		 */
		var _delete = function(reloadURL){
				var selectArray = _$table.datagrid('getSelections');
				//拼接字符串删除所选中的(提取多个id拼接到后台循环delete) 
				var idstr='';
				for( var i =0; i< selectArray.length;i++){
					idstr += selectArray[i].id+',';
				}	
				// 1,2,3
				idstr = idstr.substring(0,idstr.length-1);
				if(idstr !=''){
					$.messager.confirm('warning','确认删除么?',function(flag){
						if(flag){
		        			$.post(reloadURL,{ids:idstr},function(data){
		        				_$table.datagrid('reload');
			        		});
						}
					});
				} else{
					$.messager.alert('warning','请选择一行数据','warning');
				}
		}
		
		/**
		 *		3.更新方法 
		 */
		var _update = function (reloadURL){
				var data = _$table.datagrid('getSelected'); //取得选择的数据 
				if(data){
					window.location = reloadURL+"?id="+data.id;
				} else {
					$.messager.alert('提示','请选择一条数据' ,'warning');
				}
		}


	
		this.createDateGrid = function(){
					//设置二维数组 列模式
					_columns[0] = _arr;
					//创建数据表格
					_$table.datagrid({
						title : _title  , 
						iconCls:_iconCls == ''?'icon-ok':_iconCls,			// edit _oiYc 1.01
						width:_width,
						height:_height,
						pageSize:10,
						pageList:[5,10,15,20],
						fitColumns:true ,
						fitColumns:_fitColumns,				//是否填充容器
						nowrap:false,						//是否在一行显示数据
						striped: _striped,					//是否显示斑马线
						collapsible:_collapsible ,			//是否要滑动效果
						url:_url,							//远程加载数据的地址
						loadMsg:_loadMsg,					//加载信息时的等待提示信息
						sortName:_sortName,					//定义排序列
						sortOrder:_sortOrder,				//定义排序方式
						remoteSort:false,					//本地排序 
						frozenColumns:_frozenColumns == false ? null :[			 //定义复选框				
							[						
								{field:'ids',checkbox:_frozenColumns}
					    	]
					    ],
						columns:_columns,					//列模式
							toolbar:_toolbar.length==0?'':_toolbar,
							pagination:_pagination,		// 是否要分页
							rownumbers:_rownumbers,		// 是否显示行号
							onRefresh:function(pageNumber,pageSize){
									_$table.datagrid({
									url:_url+'?page='+pageNumber+'&rows='+pageSize  ,
									loadMsg:'更新数据中......'
									});
							},
							onSelectPage:function(pageNumber,pageSize){
								$('#t_user').datagrid({
									//_$table.datagrid('getSelecttions')
								url:'User_getList.action?page='+pageNumber+'&rows='+pageSize ,
								loadMsg:'更新数据中......'
							});
						}
				});	
				_displayMsg();						
		}
		
		
		/*****************************************getters and setters method***************************************/
		
		
		/**
		 * 获取表格对象方法
		 * @return $()
		 */
		this.get$table = function(){
			return _$table;						
		}
		/**
		 * 设置表格对象方法
		 * @param $table
		 * @type $()
		 */
		this.set$table = function($table){
			_$table = $table;						
		}
		
		/**					
		 * 获得表格标题
		 * @return string
		 */
		this.getTitle = function(){
			return _title ;
		}
		
		/**
		 * 设置表格标题
		 * @param {string} title
		 */
		this.setTitle = function(title){
			_title = title ; 						
		}

		/**
		 * 获取表格宽度
		 * @return int
		 */
		this.getWidth = function(){
			return _width ;						
		}
		
		/**					
		 * 设置表格宽度
		 * @param {int} width
		 */
		this.setWidth = function(width){
			_width = width;
		}

		/**
		 * 获取表格高度
		 * @return int
		 */
		this.getHeight = function(){
			return _height;						
		}
		
		/**
		 * 设置表格高度
		 * @param {Oint} height
		 */
		this.setHeight = function(height){
			_height = height;
		}

		/**					
		 * 获取是否使用斑马线条纹
		 * @return boolean
		 */
		this.getStriped = function(){
			return _striped;
		}
		
		/**
		 * 设置是否使用斑马线条纹
		 * @param {boolean} striped
		 */
		this.setStriped = function(striped){
			_striped = striped;
		}

		/**					
		 * 获取是否使用滑动效果
		 * @return boolean
		 */
		this.getCollapsible = function(){
			return _collapsible;
		}
		
		/**
		 * 设置是否使用滑动效果
		 * @param {boolean} striped
		 */
		this.setCollapsible = function(collapsible){
			_collapsible = collapsible;
		}					

		/**					
		 * 获取远程加载表格数据地址
		 * @return string
		 */
		this.getUrl = function(){
			return _url;
		}
		
		/**
		 * 设置远程加载表格数据地址
		 * @param {string} url
		 */
		this.setUrl = function(url){
			_url = url;
		}					

		/**					
		 * 获取加载时等待信息
		 * @return string
		 */
		this.getLoadMsg = function(){
			return _loadMsg;
		}
		
		/**
		 * 设置加载时等待信息
		 * @param {string} loadMsg
		 */
		this.setLoadMsg = function(loadMsg){
			_loadMsg = loadMsg;
		}					
		
		/**					
		 * 获取排序字段
		 * @return boolean
		 */
		this.getSortName = function(){
			return _sortName;
		}
		
		/**
		 * 设置排序字段
		 * @param {boolean} sortName
		 */
		this.setSortName = function(sortName){
			_sortName = sortName;
		}					
		
		/**					
		 * 获取排序方式
		 * @return boolean
		 */
		this.getSortOrder = function(){
			return _sortOrder;
		}
		
		/**
		 * 设置排序方式
		 * @param {boolean} sortOrder
		 */
		this.setSortOrder = function(sortOrder){
			_sortOrder = sortOrder;
		}					
		
		/**					
		 * 获取是否采用复选框模式
		 * @return boolean
		 */
		this.getFrozenColumns = function(){
			return _frozenColumns;
		}
		
		/**
		 * 设置是否采用复选框模式
		 * @param {boolean} frozenColumns
		 */
		this.setFrozenColumns = function(frozenColumns){
			_frozenColumns = frozenColumns;
		}					

				/**					
		 * 获取是否采用分页
		 * @return boolean
		 */
		this.getPagination = function(){
			return _pagination;
		}
		
		/**
		 * 设置是否采用分页
		 * @param {boolean} pagination
		 */
		this.setPagination = function(pagination){
			_pagination = pagination;
		}					
		
		/**					
		 * 获取使用行号
		 * @return boolean
		 */
		this.getRownumbers = function(){
			return _rownumbers;
		}
		
		/**
		 * 设置是否使用行号 默认false
		 * @param {boolean} rownumbers
		 */
		this.setRownumbers = function(rownumbers){
			_rownumbers = rownumbers;
		}
		
		
		this.getFitColumns = function(){
			return _fitColumns;
		}
		
		/**
		 * 设置是否填充容器 默认false
		 * @param {boolean} rownumbers
		 */
		this.setFitColumns = function(fitColumns){
			_fitColumns = fitColumns;
		}	
		
		this.getIconCls = function(){
			return _iconCls;
		}
		
		/**
		 * 设置是否使用自定义列表图标
		 * @param {String} iconCls
		 */
		this.setIconCls = function(iconCls){
			_iconCls = iconCls;
		}
		
}















			