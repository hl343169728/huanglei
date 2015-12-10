Ext.onReady(function(){
	/**
	 * 简单工具实例
	 */
	/*
	//创建工具栏
	var toolbar = new Ext.toolbar.Toolbar({
		renderTo:'toolbar',
		width:300
	});
	//向工具栏中添加按钮
	/**
	 * text:按钮显示的文字
	 * handler:一个函数，在按钮被单机之后被调用
	 * iconCls:一个样式类，提供了按钮显示的图标
	 */
	/*
	toolbar.add([
	             {text:'新建', handler:onBtnClick, iconCls:'newIcon'},
	             {text:'打开', handler:onBtnClick, iconCls:'openIcon'},
	             {text:'保存', handler:onBtnClick, iconCls:'saveIcon'} 
	]);
	//回调函数
	function callback(){
		alert(btn.text);
	}
	//在按钮被点击后触发的函数
	function onBtnClick(btn){
		alert(btn.text);
	}
	//启用按钮
	Ext.get('enabledBtn').on('click' , function(){
		toolbar.enable();
	});
	//禁用按钮
	Ext.get('disabledBtn').on('click' , function(){
		toolbar.disable();
	});
	*/
	
	/**
	 * 使用add方法加入多个不同的元素
	 */
	/*
	var toolbar = new Ext.toolbar.Toolbar({
		renderTo:'toolbar',
		width:500
	});
	toolbar.add(
			{text:'新建',xtype:'button'},
			{text:'打开'},
			{text:'编辑'},
			{text:'保存'},
			//加入分割符
			'-',
			//加入表单元素
			{
				xtype: 'textfield' , 
				hideLabel: true , 
				width: 150
			}, 
			//加入一个充满工具栏的空白元素
			'->',
			//加入一个Element元素
			'<a href=#>我是超链接</a>',
			'加入一个静态文本'
	);
	*/
	
	/**
	 * 启用和禁用工具栏提示
	 */
	
	var toolbar = new Ext.toolbar.Toolbar({
		renderTo:'toolbar',
		width:300,
		items:[
		       {text:'新建', handler:onBtnClick},
		       {text:'打开', handler:onBtnClick},
		       {text:'保存', handler:onBtnClick}
		]
	});
	//触发函数
	function onBtnClick(btn){
		alert(btn.text);
	};
	//启用
	Ext.get('enabledBtn').on('click',function(){
		toolbar.enable();
	});
	//禁用
	Ext.get('disabledBtn').on('click',function(){
		toolbar.disable();
	});
});