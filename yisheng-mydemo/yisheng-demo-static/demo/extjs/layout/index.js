/** Open the quick tips */
Ext.QuickTips.init();
Ext.form.Field.prototype.msgTarget = 'side';

/** redefine the blank image url */
var imagePath = '/common/extjs/resources/images';

Ext.BLANK_IMAGE_URL = imagePath + '/default/s.gif';

var tools = [ {
	id : 'gear',
	handler : function() {
		Ext.Msg.alert('Message', 'This function need to be modified.');
	}
}, {
	id : 'close',
	handler : function(e, target, panel) {
		panel.ownerCt.remove(panel, true);
	}
} ];

var welcomePanel = new Ext.Panel({
	title : '首页',
	iconCls : 'tabs',
	closable : false,
	layout : 'table',
	layoutConfig : {
		columns : 3
	},
	defaults : {
		frame : true,
		width : 300,
		height : 200
	},
	items : [ {
		title : '代办适宜',
		style : 'margin: 5px;',
		tools : tools,
		iconCls : 'tabs'
	}, {
		title : '备忘录',
		tools : tools,
		style : 'margin: 5px;',
		iconCls : 'tabs'
	}, {
		title : '段消息',
		style : 'margin: 5px;',
		tools : tools,
		iconCls : 'tabs'
	}, {
		title : '日程安排',
		style : 'margin: 5px;',
		tools : tools,
		iconCls : 'tabs'
	}, {
		title : '公告',
		style : 'margin: 5px;',
		tools : tools,
		iconCls : 'tabs'
	}, {
		title : '常用网址',
		style : 'margin: 5px;',
		tools : tools,
		iconCls : 'tabs'
	}, {
		title : '论坛',
		style : 'margin: 5px;',
		tools : tools,
		iconCls : 'tabs'
	}]
});

/** 定义中心区域, 本系统的核心区域, 所有打开的Tab都将在该区域展示 */
var centerRegion = new Ext.TabPanel({
	region : 'center',
	deferredRender : false,
	activeTab : 0,
	enableTabScroll : true,
	listeners : {
		remove : function(tp, c) {
			c.hide();
		}
	},
	autoDestroy : false,
	items : [ welcomePanel ]
});

/** 这里是页面展示的开始 */
Ext.onReady(function() {
	/** 处理ie提交数据中文乱码问题 */
	Ext.lib.Ajax.defaultPostHeader += '; charset=utf-8';

	var viewport = new Ext.Viewport({
		layout : 'border',
		items : [
		/** 北面板, 定义在 north.js */
		northRegion,
		/** 南面板, 定义在 south.js */
		southRegion,
		/** 西面板, 定义在 west.js */
		westRegion,
		/** 中心面板 ******************************* */
		centerRegion ]
	});

});
