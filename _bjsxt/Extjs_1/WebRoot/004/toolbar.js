// Ext code 

Ext.onReady(function(){

	/**
	 * 	简单工具栏示例 
	 */
 	//创建工具栏
	/*
	var toolbar = new Ext.toolbar.Toolbar({	 
		renderTo: 'toolbar' , 
		width: 300
	});

	
	var toolbar = Ext.create('Ext.toolbar.Toolbar' , {
			renderTo: 'toolbar' , 
			width: 300
		
	});
	*/
	//向工具栏中添加按钮
	/*
	toolbar.add([
		{ text: '新建' , handler: onBtnClick ,  iconCls: 'newIcon'  },
		{ text: '打开' , handler: onBtnClick ,  iconCls: 'openIcon' },
		{ text: '保存' , handler: onBtnClick ,  iconCls: 'saveIcon' }
	]);
	
	//回调函数
	function onBtnClick(btn){
		alert(btn.text);
	}
	*/
	/**
	 * 使用add方法加入多个不同的元素 
	 */
/*
	var toolbar = new Ext.toolbar.Toolbar({
		renderTo: 'toolbar' , 
		width: 500 
	});
	
	toolbar.add(
		//加入按钮
		{text: '新建' , xtype:'button'},
		{text: '打开'},
		{text: '编辑'},
		{text: '保存'},
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
		'<a href=#>我是超链接</a>' , 
		'加入一个静态文本'
	);
*/	
	
	
	/**
	 * 	启动和禁用工具栏提示 
	 */
	/*
	var toolbar = new Ext.toolbar.Toolbar({
			renderTo: 'toolbar' , 
			width: 300 , 
			items: [
				{text: '新建' , handler: onBtnClick} ,
				{text: '打开' , handler: onBtnClick} ,
				{text: '保存' , handler: onBtnClick}
			]
	});
	
	function onBtnClick(btn){
		alert(btn.text);
	}
	
	Ext.get('enabledBtn').on('click' , function(){
		toolbar.enable();
	});
	
	Ext.get('disabledBtn').on('click' , function(){
		toolbar.disable();
	});
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
});