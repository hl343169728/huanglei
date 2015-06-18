function testFunction() {
	alert('This function need to be modified.');
}

/** 进度条 */
function process() {
	Ext.onReady(Read7);
}
/** 皮肤应用 */
function skipPeeler() {
	Ext.onReady(Read4);
}
/** 表单 */
function demoForm() {
	Ext.onReady(formRead3);
}

/** 面板 */
function testPanel() {
	Ext.onReady(panel1);
}

/** JSON */
function readJson() {
	Ext.onReady(readJson);
}

/** GridPanel */
function readGridPanel() {
	Ext.onReady(readGridPanel);
}

/** 管理单元面板 */
var manageTree = new Ext.tree.TreePanel({
	autoScroll : true,
	animate : false,
	enableDD : true,
	containerScroll : true,
	rootVisible : false,
	height : 350,
	width : 195
});

/** 管理单元树根 */
var manageRoot = new Ext.tree.TreeNode({
	id : '0',
	text : '',
	leaf : false
});

/** 系统主页树根 */
var systemRoot = new Ext.tree.TreeNode({
	id : '00',
	text : '系统主页',
	leaf : false,
	cls : 'folder'
});

systemRoot.appendChild(new Ext.tree.TreeNode({
	id : '001',
	text : '用户管理',
	leaf : true,
	href : 'javascript: testFunction();'
}));

systemRoot.appendChild(new Ext.tree.TreeNode({
	id : '002',
	text : '角色管理',
	leaf : true,
	href : 'javascript: testFunction();'
}));

systemRoot.appendChild(new Ext.tree.TreeNode({
	id : '003',
	text : '菜单管理',
	leaf : true,
	href : 'javascript: testFunction();'
}));

systemRoot.appendChild(new Ext.tree.TreeNode({
	id : '004',
	text : '权限管理',
	leaf : true,
	href : 'javascript: testFunction();'
}));

systemRoot.appendChild(new Ext.tree.TreeNode({
	id : '005',
	text : '部门管理',
	leaf : true,
	href : 'javascript: testFunction();'
}));

systemRoot.appendChild(new Ext.tree.TreeNode({
	id : '006',
	text : '职务管理',
	leaf : true,
	href : 'javascript: testFunction();'
}));

systemRoot.appendChild(new Ext.tree.TreeNode({
	id : '007',
	text : '功能模块管理',
	leaf : true,
	href : 'javascript: testFunction();'
}));

manageRoot.appendChild(systemRoot);

/** ExtJS树根 */
var extJsRoot = new Ext.tree.TreeNode({
	id : '01',
	text : 'ExtJS',
	leaf : false,
	cls : 'folder'
});

extJsRoot.appendChild(new Ext.tree.TreeNode({
	id : '011',
	text : '进度条',
	leaf : true,
	href : 'javascript: process();'
}));

extJsRoot.appendChild(new Ext.tree.TreeNode({
	id : '012',
	text : '皮肤应用',
	leaf : true,
	href : 'javascript: skipPeeler();'
}));

extJsRoot.appendChild(new Ext.tree.TreeNode({
	id : '013',
	text : '表单',
	leaf : true,
	href : 'javascript: demoForm();'
}));

extJsRoot.appendChild(new Ext.tree.TreeNode({
	id : '014',
	text : '表单_1',
	leaf : true,
	href : 'javascript: add_win();'
}));

extJsRoot.appendChild(new Ext.tree.TreeNode({
	id : '015',
	text : '面板',
	leaf : true,
	href : 'javascript: testPanel();'
}));

extJsRoot.appendChild(new Ext.tree.TreeNode({
	id : '016',
	text : 'Json',
	leaf : true,
	href : 'javascript: readJson();'
}));

extJsRoot.appendChild(new Ext.tree.TreeNode({
	id : '017',
	text : 'GridPanel',
	leaf : true,
	href : 'javascript: readGridPanel();'
}));

manageRoot.appendChild(extJsRoot);

/** 客户管理树根 */
var customerRoot = new Ext.tree.TreeNode({
	id : '02',
	text : '客户管理',
	leaf : false,
	cls : 'folder'
});

customerRoot.appendChild(new Ext.tree.TreeNode({
	id : '021',
	text : '会员管理',
	leaf : true,
	href : "javascript: testFunction();"
}));

manageRoot.appendChild(customerRoot);

manageTree.setRootNode(manageRoot);

var msgTree = new Ext.tree.TreePanel({
	title : '未阅信息',
	iconCls : 'tabs',
	autoScroll : true,
	animate : false,
	enableDD : true,
	containerScroll : true,
	rootVisible : false,
	height : 300,
	width : 195
});

var msgRoot = new Ext.tree.TreeNode({
	id : '04',
	text : '',
	leaf : false
});

msgRoot.appendChild(new Ext.tree.TreeNode({
	id : '041',
	text : '代办流程',
	leaf : true,
	href : 'javascript: gotoUploadXML();'
}));

msgRoot.appendChild(new Ext.tree.TreeNode({
	id : '042',
	text : '未读消息',
	leaf : true,
	href : 'javascript: gotoUploadXML();'
}));

msgRoot.appendChild(new Ext.tree.TreeNode({
	id : '043',
	text : '今日日程',
	leaf : true,
	href : 'javascript: gotoUploadXML();'
}));

msgTree.setRootNode(msgRoot);

// 定义并构造西部面板
var westRegion = {
	region : 'west',
	id : 'west-panel',
	iconCls : 'tabs',
	title : '导航菜单',
	split : true,
	width : 200,
	minSize : 175,
	maxSize : 400,
	collapsible : true,
	margins : '0 0 0 5',
	layout : 'column',
	layoutConfig : {
		animate : true
	},
	items : [ {
		items : manageTree
	}, {
		items : msgTree
	} ]
};