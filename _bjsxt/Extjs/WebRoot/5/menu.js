Ext.onReady(function(){
	/**
	 * 简单的菜单栏实现
	 */
	
	//创建工具栏
	var toolbar = new Ext.toolbar.Toolbar({
		renderTo:'toolbar',
		width:300
	});
	//创建菜单栏
	var fileMenu = new Ext.menu.Menu({
		shadow:'frame',//设置菜单四边都有阴影
		plain:true,//移除左侧的竖线
		items:[
		       {text:'新建', handler:onMenuItem},
		       {text:'打开', handler:onMenuItem},
		       {text:'保存', handler:onMenuItem}
		]
	});
	var editMenu = new Ext.menu.Menu({
		shadow:'drop',//设置菜单在右、下两条边有阴影
		//allowOtherMenus:true,//允许多个菜单同时显示
		items:[
		       {text:'复制', handler:onMenuItem},
		       {text:'粘贴', handler:onMenuItem},
		       {text:'剪切', handler:onMenuItem}
		]
	});
	//把菜单添加到工具栏中
	toolbar.add({text:'文件', menu:fileMenu},{text:'编辑', menu:editMenu});
	function onMenuItem(item){
		alert(item.text);			//取得菜单单项的text属性
	};
	
	
	
	/**
	 * 向菜单中添加组件
	 */
	/*
	//创建工具栏
	var toolbar = new Ext.toolbar.Toolbar({
		renderTo:'toolbar',
		width:300
	});
	//创建菜单栏
	var fileMenu = new Ext.menu.Menu({
		plain: true,
		items:[
		       {xtype:'textfield', hideLabel:true,width:100},
		       //添加颜色组件
		       {text:'颜色选择', menu:Ext.create('Ext.menu.ColorPicker',{})},
		       //添加日期组件
		       {xtype:'datepicker'}
		]
	});
	toolbar.add({text:'文件',menu:fileMenu});
	*/
});