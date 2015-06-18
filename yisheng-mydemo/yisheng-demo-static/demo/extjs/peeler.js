/**
 * 皮肤应用
 */
function Read1() {
	var MyToolbar = new Ext.Toolbar({
		width : 300,
		x : 400,
		y : 100,
		floating : true,
		frame : true,
		renderTo : document.body,
		items : [ {
			text : '新建',
			handler : function() {
				alert("新建");
			},
			iconCls : 'newFile'
		}, {
			text : '打开',
			iconCls : 'openFile'
		}, {
			text : '保存',
			iconCls : 'saveFile'
		}, {
			text : '111'
		}, {
			text : '222'
		} ]
	});
}

function Read2() {
	var MyToolBar = new Ext.Toolbar({
		width : 300,
		x : 400,
		y : 100,
		floating : true,
		frame : true,
		renderTo : document.body,

		items : [ {
			text : '地图管理',
			handler : function() {
				alert("新建");
			},
			iconCls : 'newFile',
			menu : Mymenu
		}, {
			text : '地图编辑',
			iconCls : 'openFile'

		}, {
			text : '生成地图',
			iconCls : 'saveFile'
		}, {
			text : '111'
		}, {
			text : '222'
		} ]
	});
	var Mymenu = new Ext.menu.Menu({
		shadow : 'drop',

		items : [ {
			text : '地图管理'
		}, {
			text : '地图编辑'
		}, {
			text : '生成地图'
		} ]
	});
}

function makeCookie() {
	var themes = [ 
	               [ 'default', '默认' ], 
	               [ 'blue', '灰色' ], 
	               [ 'gray', '绿色' ],
	               [ 'access', '橄榄绿' ], 
	               [ 'pink', '粉色' ], 
	               [ 'purple', '紫色' ],
	               [ 'slate', '暗蓝色' ] ];
	var cbThemes = new Ext.form.ComboBox({
		id : 'cbThemes',
		store : themes,
		width : 80,
		typeAhead : true,
		triggerAction : 'all',
		emptyText : '界面主题',
		selectOnFocus : true
	});
	cbThemes
			.on({
				"select" : function(field, newValue, oldValue) {
					var css = newValue.data.value;
					// 设置cookies
					var date = new Date();
					date.setTime(date.getTime() + 30 * 24 * 3066 * 1000);
					document.getElementsByTagName("link")[1].href = "/common/extjs/resources/css/xtheme-" + css + ".css";
					document.cookie = "css=" + name + ";expires=" + date.toGMTString();// 设置cookies
				}
			});

	var win = new Ext.Window({
		title : "测试更换皮肤窗口",
		renderTo : document.body,
		width : 500,
		height : 300,
		x : 300,
		y : 100,
		bbar : [ '更换皮肤', '', cbThemes ]
	});
	win.show();

	document.body.onload = function() {
		var cookiesArr = document.cookie.split(";");
		var css;
		for (var i = 0; i < cookiesArr.length; i++) {
			var arr = cookiesArr[i].split("=");
			if (arr[0] == "css") {
				css = arr[1];
				break;
			}
		}
		document.getElementsByTagName("link")[1].href = "/common/extjs/resources/css/xtheme-" + css + ".css";
	};

}

function Read3() {
	var themes = [ 
	               [ '默认', 'ext-all.css' ], 
	               [ '紫色', 'xtheme-purple.css' ],
	               [ '橄榄色', 'xtheme-olive.css' ], 
	               [ '暗蓝色', 'xtheme-slate.css' ],
	               [ '浅灰色', 'xtheme-darkgray.css' ], 
	               [ '绿色', 'xtheme-gray.css' ],
	               [ '椒盐色', 'xtheme-galdaka.css' ], 
	               [ '粉色', 'xtheme-pink.css' ],
	               [ '靛青色', 'xtheme-indigo.css' ], 
	               [ '深夜', 'xtheme-midnight.css' ],
	               [ '银白色', 'xtheme-silverCherry.css' ] 
	             ];
	var Mystore = new Ext.data.SimpleStore({
		fields : [ 'theme', 'css' ],
		data : themes
	});
	var MyPanel = new Ext.form.FormPanel({
		title : '表单应用二',
		renderTo : Ext.getBody(),
		width : 300,
		height : 320,
		frame : true,
		labelWidth : 70,
		x : 400,
		y : 100,
		shadow : true,
		floating : true,
		draggable : {
			insertProxy : false,// 拖动时不虚线显示原始位置
			onDrag : function(e) {
				var pel = this.proxy.getEl();
				this.x = pel.getLeft(true);
				this.y = pel.getTop(true);// 获取拖动时panel的坐标
				var s = this.panel.getEl().shadow;
				if (s) {
					s.realign(this.x, this.y, pel.getWidth(), pel.getHeight());
				}
			},
			endDrag : function(e) {
				this.panel.setPosition(this.x, this.y);// 移动到最终位置
			}
		},
		labelAlign : 'center',
		labelSeparator : ':',
		items : [ {
			xtype : 'combo',
			fieldLabel : '更换皮肤',
			id : 'css',
			triggerAction : 'all',
			store : Mystore,
			displayField : 'theme',
			valueField : 'css',
			value : '默认',
			mode : 'local',
			anchor : '95%',
			handleHeight : 10,
			resizable : true,
			selectOnfocus : true,
			typeAhead : true,
			initEvents : function() {
				this.on('collapse', function() {
					Ext.util.CSS.swapStyleSheet('theme', '/common/extjs/resources/css/' + this.getValue());
				});
			}
		} ]
	});
}

function Read4() {
	var themes = [ 
	               [ '默认', 'ext-all.css' ], 
	               [ '紫色', 'xtheme-purple.css' ],
	               [ '橄榄色', 'xtheme-olive.css' ], 
	               [ '暗蓝色', 'xtheme-slate.css' ],
	               [ '浅灰色', 'xtheme-darkgray.css' ], 
	               [ '绿色', 'xtheme-gray.css' ],
	               [ '椒盐色', 'xtheme-galdaka.css' ], 
	               [ '粉色', 'xtheme-pink.css' ],
	               [ '靛青色', 'xtheme-indigo.css' ], 
	               [ '深夜', 'xtheme-midnight.css' ],
	               [ '银白色', 'xtheme-silverCherry.css' ] 
	             ];
	var Mystore = new Ext.data.SimpleStore({
		fields : [ 'theme', 'css' ],
		data : themes
	});
	var Mycombo = new Ext.form.ComboBox({
		fieldLabel : '更换皮肤',
		id : 'css',
		triggerAction : 'all',
		store : Mystore,
		displayField : 'theme',
		valueField : 'css',
		value : '默认',
		mode : 'local',
		anchor : '95%',
		handleHeight : 10,
		resizable : true,
		selectOnfocus : true,
		typeAhead : true
	});
	Mycombo.on({"select" : function() {
					var css = Mycombo.getValue();
					// 设置cookies
					var date = new Date();
					// alert(css);
					date.setTime(date.getTime() + 30 * 24 * 3066 * 1000);
					document.getElementsByTagName("link")[1].href = "/common/extjs/resources/css/" + css;
					document.cookie = "css=" + css + ";expires=" + date.toGMTString();
				}
			});
	var cookieArr = window.document.cookie.split(";");
	var css = null;
	for (var i = 0; i < cookieArr.length; i++) {
		var arr = cookieArr[i].split("=");
		if (arr[0] == "css") {
			css = arr[1];
		}
	}
	window.document.getElementsByTagName("link")[1].href = "/common/extjs/resources/css/" + css;

	var MyPanel = new Ext.form.FormPanel({
		title : '皮肤应用',
		renderTo : Ext.getBody(),
		width : 300,
		height : 150,
		frame : true,
		labelWidth : 70,
		x : 400,
		y : 100,
		shadow : true,
		floating : true,
		draggable : {
			insertProxy : false,// 拖动时不虚线显示原始位置
			onDrag : function(e) {
				var pel = this.proxy.getEl();
				this.x = pel.getLeft(true);
				this.y = pel.getTop(true);// 获取拖动时panel的坐标
				var s = this.panel.getEl().shadow;
				if (s) {
					s.realign(this.x, this.y, pel.getWidth(), pel.getHeight());
				}
			},
			endDrag : function(e) {
				this.panel.setPosition(this.x, this.y);// 移动到最终位置
			}
		},
		labelAlign : 'center',
		labelSeparator : ':',
		items : [ Mycombo ]
	});
}