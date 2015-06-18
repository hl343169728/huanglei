function add_win() {

	var add_winForm = new Ext.form.FormPanel({
		width : 360,
		height : 120,
		plain : true,
		layout : "form",
		defaultType : "textfield",
		labelWidth : 75,
		baseCls : "x-plain",
		// 锚点布局-
		buttonAlign : "center",
		bodyStyle : "padding:0 0 0 0",
		items : [ {
			fieldLabel : "属性名称",
			width : 160,
			id : "prname",
			name : "prname",
			maxLength : 20,
			maxLengthText : '属性名称长度不能超过20位！',
			allowBlank : false,
			blankText : "请填写属性名称！"
		} ]
	});

	var syswin = new Ext.Window({
		title : "新建属性",
		width : 360,
		height : 120,
		plain : true,
		iconCls : "addicon",
		// 不可以随意改变大小
		resizable : false,
		// 是否可以拖动
		draggable : true,
		collapsible : true, // 允许缩放条
		closeAction : 'close',
		closable : true,
		// 弹出模态窗体
		modal : 'true',
		buttonAlign : "center",
		bodyStyle : "padding:10px 0 0 10px",
		items : [ add_winForm ],
		buttons : [ {
			text : "保 存",
			minWidth : 70,
			handler : function() {
				if (add_winForm.getForm().isValid()) {
					add_winForm.getForm().submit({
						url : '../ajax/s/s_operate.aspx',
						waitTitle : '请稍等...',
						waitMsg : '正在提交信息...',
						params : {
							t : "add"
						},
						success : function(fp, o) {
							if (o.result.success == true) {
								syswin.close();
								// Store1.reload();
							} else {
								msg('信息提示', '添加时出现异常！');
							}
						},
						failure : function() {
							msg('信息提示', '添加失败！');
						}
					});

				}
			}
		}, {
			text : "关 闭",
			minWidth : 70,
			handler : function() {
				syswin.close();
			}
		} ]

	});

	syswin.show();
}