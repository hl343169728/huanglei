/**
 * 注意：当floating:true时x,y项才有用，当frame:true时园角边框出现同时内容背景面板改变颜色
 * title:标题
 * width:宽度
 * height:高度
 * x:面板在网页x坐标
 * y:面板在网页Y左边
 * html:面板内容
 * frame:ture 园角边框
 * draggable:true  是否可以拖动面板  但是不可以定位
 * titleCollapse:true  点击标题栏收缩面板
 * collapsible:true  显示收缩按钮
 * renderto:id1  在id1上显示面板
 * ApplyTo:id1  在id1后面显示面板
 * autoLoad:url   自动加载url页面内容到面板
 * autoScroll:ture  自动出现滚动条
 * autoShow:ture  显示x-hidden
 * tbar:顶部栏
 * bbar:顶部栏
 * buttons:按钮集
 * buttonAlign:按钮对其
 */
function panel1() {
	var json = {
		Name : "陈建强",
		Sex : "男",
		Age : 26,
		Married : false,
		Marks : [ {
			name : "语文",
			Mark : 90
		}, {
			name : "数学",
			Mark : 98
		} ],
		Address : {
			City : "武汉",
			Street : "光谷大道"
		}
	}
	var MyPanel = new Ext.Panel({
		title : "面板应用",
		collapsible : true,
		titleCollapse : true,
		renderTo : Ext.getBody(),
		x : 500,
		y : 50,
		width : 300,
		height : 200,
		frame : true,
		floating : true,// 当设置floating为true时x,y项才有效
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
		html : "<font color='red'>用户名：" + json.Name + "</font>" + '<br>' + "年龄：" + json.Age + "<br>数学成绩：" + json.Marks[1].Mark + "<br>所在地址：" + json.Address.City + json.Address.Street
	});
}

function panel2() {
	var json = {
		Name : "陈建强",
		Sex : "男",
		Age : 26,
		Married : false,
		Marks : [ {
			name : "语文",
			Mark : 90
		}, {
			name : "数学",
			Mark : 98
		} ],
		Address : {
			City : "武汉",
			Street : "光谷大道"
		}
	}
	var MyJson = {
		title : "面板应用",
		width : 400,
		height : 300,
		x : 500,
		y : 50,
		floating : true,
		// applyTo : id1,
		// frame:true,
		draggable : true,
		titleCollapse : true,// 只有当设置了collapsible:true是此属性才有意义
		collapsible : true,
		bbar : [ {
			text : '状态栏'
		}, {
			text : '状态栏2'
		} ],
		tbar : [ {
			text : '工具栏'
		} ],
		tools : [ {
			id : 'toggle'
		}, {
			id : 'close'
		}, {
			id : 'maximize'
		}, {
			id : 'save'
		}, {
			id : 'refresh'
		} ],
		bodystyle : 'background-color:#FFBFEE',
		buttons : [ new Ext.Button({
			text : '底部'
		}) ],
		bodyBorder : true,
		// contentEl:id2,
		autoLoad : 'MyPages/Data5.html',// <a href="MyPages/Data5.aspx">MyPages/Data5.aspx</a>

		html : "<font color='red'>用户名：" + json.Name + "</font>" + '<br>' + "年龄：" + json.Age + "<br>数学成绩：" + json.Marks[1].Mark+ "<br>所在地址：" + json.Address.City + json.Address.Street
	};
	var MyPanel = new Ext.Panel(MyJson).show();
}

function panel3() {
	var Mypanel = new Ext.Panel({
		title : 'Extjs面板应用',
		html : '面板内容',
		floating : true,
		x : 450,
		y : 50,
		// modal:true,
		width : 450,
		height : 350,
		renderTo : Ext.getBody(),
		frame : true,
		collapsible : true,
		titleCollapse : true,
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
		autoLoad : 'MyPages/Data5.html',// 加载了外部资源后html属性内容无效了
		// contentEl : id2,// 加载的内部资源时html属性内容有效
		tbar : [ {
			text : "打开",
			handler : Read1
		}, {
			text : "保存"
		}, {
			text : "关闭"
		} ],
		bbar : [ {
			text : "状态1"
		}, {
			text : "状态2"
		}, {
			text : "状态3"
		} ],
		buttons : [ {
			text : "按钮1",
			handler : Read1
		}, {
			text : "按钮2"
		} ],
		// buttonsAlign:'right',
		tools : [ {
			id : 'save'
		}, {
			id : 'help',
			handler : function() {
				alert("你需要我的帮助");
			}
		} ]
	});
}