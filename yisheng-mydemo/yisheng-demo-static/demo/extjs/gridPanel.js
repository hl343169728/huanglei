function readGridPanel() {
	// 数据源
	var jsonstore = new Ext.data.JsonStore({
		data : [ {
			id : 1,
			name : '张三',
			sex : '0',
			birthday : '2001/01/01'
		}, {
			id : 2,
			name : '李四',
			sex : '1',
			birthday : '2002/01/01'
		}, {
			id : 3,
			name : '王五',
			sex : '0',
			birthday : '2003/01/01'
		} ],
		fields : [ 'id', 'name', 'sex', {
			name : 'birthday',
			type : 'date',
			dateformat : 'Y/m/d'
		} ]
	});
	// 复选框列
	var sm = new Ext.grid.CheckboxSelectionModel();
	// 渲染性别
	var sexrender = function(value, metaData, record, rowIndex, cloIndex, store) {
		if (value == '0') {
			metaData.attr = 'style="font-weight:bold";'
			return '男';
		} else {
			return '女';
		}
	}
	// 定义列
	var column = new Ext.grid.ColumnModel({
		columns : [ sm, {
			header : '编号',
			dataIndex : 'id',
			sortable : true
		}, {
			header : '姓名',
			dataIndex : 'name'
		}, {
			header : '性别',
			dataIndex : 'sex',
			renderer : sexrender
		}, {
			header : '出生日期',
			dataIndex : 'birthday',
			renderer : Ext.util.Format.dateRenderer('Y-m-d')
		} ]
	});
	// 添加按钮
	var tbtn = new Ext.Toolbar.Button({
		text : '查看选中项',
		listeners : {
			'click' : function() {
				var row = grid.getSelectionModel().getSelections();
				for (var i = 0; i < row.length; i++) {
					alert(row[i].get('id'));
				}
			}
		}
	});
	// 分页控件
	var pager = new Ext.PagingToolbar({
		pageSize : 2,
		store : jsonstore,
		listeners : {
			"beforechange" : function(bbar, params) {
				var grid = bbar.ownerCt;
				var store = grid.getStore();
				var start = params.start;
				var limit = params.limit;
				alert(store.getCount());
				return false;
			}
		}
	});
	// 列表
	var grid = new Ext.grid.GridPanel({
		sm : sm,
		title : 'GridPanel',
		height : 200,
		store : jsonstore,
		tbar : [ tbtn ],
		bbar : pager,
		colModel : column
	});
	// 表单
	var form = new Ext.form.FormPanel({
		frame : true,
		fileUpload : true,
		url : '/App_Ashx/Demo/Upload.ashx',
		title : '表单标题',
		style : 'margin:10px',
		items : [ grid ]
	});
	// 窗体
	var win = new Ext.Window({
		title : '窗口',
		width : 476,
		height : 374,
		resizable : true,
		modal : true,
		closable : true,
		maximizable : true,
		minimizable : true,
		buttonAlign : 'center',
		items : form
	});
	win.show();
}