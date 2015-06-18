Ext.onReady(function() {
	new Ext.form.FormPanel({
		renderTo : Ext.getBody(),
		title : "用户信息录入",
		height : 200,
		width : 300,
		labelWidth : 60,
		labelAlign : "right",
		frame : true,
		defaults : {
			xtype : "textfield",
			width : 180
		},
		items : [ {
			name : "username",
			fieldLabel : "姓名"
		}, {
			name : "password",
			fieldLabel : "密码",
			inputType : "password"
		}, {
			name : "email",
			fieldLabel : "电子邮件"
		}, {
			xtype : "textarea",
			name : "intro",
			fieldLabel : "简介"
		} ],
		buttons : [ {
			text : "提交"
		}, {
			text : "取消"
		} ]
	});
});