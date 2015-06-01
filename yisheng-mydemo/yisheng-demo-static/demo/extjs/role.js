function readRole() {
	// 初始化Extjs
	Ext.QuickTips.init();
	// 首先读取数据，Json格式
	var store = new Ext.data.Store({
		// 读取数据源用json方法(三种方法1.读取json用JsonReader,2读取数组使用ArrayReader3.读取XML用XmlReader)
		reader : new Ext.data.JsonReader({
			root : "Table",
			// 从数据库中读取的总记录数
			totalProperty : 'totalCount',
			// 要读取出来的字段
			fields : [ 'ID', 'RoleName', 'Remark' ]
		}),
		// 获取数据源(该方法返回一个json格式的数据源)
		proxy : new Ext.data.HttpProxy({
			url : '../../BackGround/RoleManage/Role.ashx?AutoLoad=true'
		})
	});
	// 定义GridPanel的列名称
	var cms = new Ext.grid.ColumnModel([ new Ext.grid.RowNumberer({
		header : "编号",
		width : 30,
		align : "center"
	}),// 添加一个编号
	new Ext.grid.CheckboxSelectionModel(),// 增加 CheckBox多选框列
	// header列名称，dateIndex对应数据库字段名称,sortable支持排序
	{
		header : "角色名称",
		dataIndex : "RoleName",
		sortable : true
	}, {
		header : "角色备注",
		dataIndex : "Remark",
		sortable : true
	}

	]);
	// 编辑panel，用于添加，修改
	var Edit_Panel = new Ext.FormPanel({
		labelWidth : 75,
		labelAlign : 'right',
		frame : true,
		bodyStyle : 'padding:5px 5px 0',
		width : 380,
		defaults : {
			width : 150
		},
		defaultType : 'textfield',
		items : [ {
			fieldLabel : '角色编号',
			name : 'ID',
			xtype : 'hidden'
		}, {
			// label名称
			fieldLabel : '角色名称',
			// textfield名称
			name : 'RoleName',
			// textfield正则
			allowBlank : false,// 是否允许为空！false不允许
			blankText : "不允许为空",// 提示信息
			minLength : 2,
			minLengthText : "姓名最少2个字符",
			maxLength : 4,
			maxLengthText : "姓名至多4个字符",
			regex : /^[\u4e00-\u9fa5]+$/i,// 正则表达式
			regexText : "只能为中文"
		}, {
			fieldLabel : '角色编码',
			name : 'RoleCode',
			allowBlank : false,
			blankText : "不允许为空",
			xtype : 'hidden'
		}, {
			fieldLabel : '说明',
			name : 'Remark'
		} ]
	});
	// 弹出层
	var Edit_Window = new Ext.Window({
		collapsible : true,
		maximizable : true,
		minWidth : 300,
		height : 180,
		minHeight : 200,
		width : 378,
		modal : true,
		closeAction : "hide",
		// 所谓布局就是指容器组件中子元素的分布，排列组合方式
		layout : 'form',// layout布局方式为form
		plain : true,
		title : '编辑对话框',
		bodyStyle : 'padding:5px;',
		buttonAlign : 'center',
		items : Edit_Panel,
		buttons : [
				{
					text : '保存',
					// 点击保存按钮后触发事件
					handler : function() {
						// 得到编辑模板中id为ID的控件名称的值
						var ID = Edit_Panel.getForm().findField('ID').getValue();
						// 得到编辑模板中id为RoleName的控件名称的值
						var RoleName = Edit_Panel.getForm().findField('RoleName').getValue();
						// var
						// RoleCode=Edit_Panel.getForm().findField('RoleCode').getValue();
						var Remark = Edit_Panel.getForm().findField('Remark').getValue();
						var jsonData = '';
						if (ID == '')
							// 如果ID为空的话说明是添加操作，否则是修改操作,将ID,角色名称(RoleName),角色编码(RoleCode),说明(Remark),操作类型(添加操作:AddUser,更新操作:UpdateUser)写成json的形式作为参数传到后台
							jsonData = {
								operatype : 'AddRole',
								ID : ID,
								RoleName : RoleName,
								Remark : Remark
							};
						else
							jsonData = {
								operatype : 'UpdateRole',
								ID : ID,
								RoleName : RoleName,
								Remark : Remark
							};
						Edit_Window.hide();
						CodeOperaMethod('../../WebUI/RoleManage/RoleManege.aspx', jsonData);
						// 重新加载store信息
						store.reload();
						grid.store.reload();
					}
				}, {
					text : '重置',
					handler : function() {
						Edit_Panel.getForm().reset();
					}
				} ]
	});
	
	// 后台数据交互方法
	var CodeOperaMethod = function(url, params) {
		var conn = new Ext.data.Connection();
		conn.request({
			// 请求的 Url
			url : url,
			// 传递的参数
			params : params,
			method : 'post',
			scope : this,
			// 回调函数，根据执行结果作不同的操作，如果成功提示操作成功的信息，如果失败提示失败的信息
			callback : function(options, success, response) {
				if (success) {
					Ext.MessageBox.alert("提示", "操作成功！");
					store.reload();
					grid.store.reload();
				} else {
					Ext.MessageBox.alert("提示", "所提交的操作失败！");
				}

			}
		});
	};

	// 删除方法
	function delRecord(btn, pressed) {
		// 获取ID为MenuGridPanel的控件名称得到当前选中项
		rows = Ext.getCmp("MenuGridPanel").getSelectionModel().getSelections();
		if (rows.length == 0) {
			Ext.Msg.alert("", "请至少选择一行你要删除的数据！");
			return;
		}
		Ext.MessageBox.confirm('提示', '确实要删除所选的记录吗?', showResult);
	}
	
	function showResult(btn) {
		// 确定要删除你选定项的信息
		if (btn == 'yes') {
			var row = Ext.getCmp("MenuGridPanel").getSelectionModel()
					.getSelections();
			var jsonData = "";
			for (var i = 0, len = row.length; i < len; i++) {
				// 得到当前选中项的ID集合
				var ss = row[i].get("ID");
				if (i == 0) {
					jsonData = jsonData + ss;
				} else {
					jsonData = jsonData + "," + ss;
				}
			}
			// 将要删除的信息传递到后台处理,然后重新加载grid
			var conn = new Ext.data.Connection();
			conn.request({
				url : "../../WebUI/RoleManage/RoleManege.aspx?DelRecode=",
				params : {
					strProjects : jsonData
				},
				method : 'post',
				scope : this,
				callback : function(options, success, response) {
					if (success) {
						Ext.MessageBox.alert("提示", "所选记录成功删除！");
						store.reload();
						grid.store.reload();
					} else {
						Ext.MessageBox.alert("提示", "所选记录删除失败！");
					}
				}
			})

		}
	}

	// 定义一个智能感应的ComboBox
	var cmbox = new Ext.form.ComboBox({
		id : 'cmbox',
		title : '角色名称',
		// 加载数据源
		store : store,
		// 从本地加载数据（智能感应效果）
		mode : "local",
		// 显示字段类似DropDownlist中的DataTextField
		displayField : 'RoleName',
		// 类似DropDownlist中的DataValueField
		valueField : 'ID',
		width : 160,
		// 不允许为空
		allowBlank : false,
		// 默认值
		emptyText : '请输入角色名称进行搜索...',
		// 当为空的时候提示
		blankText : '请输入角色名称...'
	});
	
	// 构建GridPanel
	var grid = new Ext.grid.GridPanel({
		id : 'MenuGridPanel',
		renderTo : "gridpanel",// 将GridPanel添加到id为gridpanel的区域
		title : '角色管理',// 网格标题
		width : '100%',
		height : 500,
		store : store,// grid数据源
		loadMask : {
			msg : '加载数据中,请等待......'
		},// 显示等待数据加载（loading）图标
		cm : cms,// 列名称
		sm : new Ext.grid.CheckboxSelectionModel(),// 要显示多选框列必加此项
		// 定义一个toolbar
		tbar : [
				{
					text : "编辑",
					cls : 'x-btn-text-icon details',
					icon : "../ext-3.1.0/blue16_042.png",
					handler : function() {
						// 重置编辑模板
						Edit_Panel.getForm().reset();
						rows = Ext.getCmp("MenuGridPanel").getSelectionModel()
								.getSelections();
						if (rows.length != 1) {
							Ext.Msg.alert("", "请你选择一行数据进行操作！");
							return;
						}
						// 打开窗体
						Edit_Window.show();
						// 将选中项的信息绑定到TextField中
						Edit_Panel.getForm().findField('ID').setValue(rows[0].get('ID'));
						// Edit_Panel.getForm().findField('RoleCode').setValue(rows[0].get('RoleCode'));
						Edit_Panel.getForm().findField('RoleName').setValue(rows[0].get('RoleName'));
						Edit_Panel.getForm().findField('Remark').setValue(rows[0].get('Remark'));
					}
				},
				{
					text : "添加",
					cls : 'x-btn-text-icon details',
					icon : "../ext-3.1.0/add_16.png",
					handler : function() {
						Edit_Panel.getForm().reset();
						Edit_Window.show();
					}
				},
				{
					text : "删除",
					cls : 'x-btn-text-icon details',
					icon : "../ext-3.1.0/blue16_016.png",
					handler : delRecord
				},
				'-',

				// 定义一个搜索框
				cmbox,
				'-',
				{

					xtype : 'button',
					cls : 'x-btn-text-icon details',
					icon : "../ext-3.1.0/blue16_068.png",
					text : "查找",
					handler : function() {
						// Ext.getCmp("searchfield").getValue()得到Textfield的值
						// 过滤条件为角色名称(RoleName)来搜索匹配的信息,
						// filter方法第一个参数:过滤的字段名称,第二个参数要匹配的信息,
						// 第三个参数true表示从开始位置开始搜索,第四个参数false表示不区分大小写
						store.filter('RoleName',
								Ext.getCmp("cmbox").getValue(), false, false);
					}
				}

		],
		bbar : new Ext.PagingToolbar({// 自带分页工具条
			pageSize : 10,
			store : store,
			displayInfo : true,
			displayMsg : '当前为第[{0}]</span>条至第[{1}]条数据，共[{2}]条数据',
			emptyMsg : "没有数据"
		})
	});
	
	// 从Json中加载数据start为0表示显示默认第一页，limit表示每页显示的数量为10
	store.load({
		params : {
			start : 0,
			limit : 10
		}
	});
}
