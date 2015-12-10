Ext.onReady(function(){
	new Ext.Viewport({
		layout:'fit',     	  //设置布局
		items:[{			  //其属性为数组,可以在里面定义当前控件的子控件
			xtype:'panel',    //指定该位置使用什么组件，如果没有此属性那么就得用一个变量去指向一个组件，然后将其加入到父组件中，又或者使用一堆new关键字或Ext.create方法创建组件。
			title:'欢迎来到Ext的世界！',  //标题
			html:"<h1 style='text-align:center;font-size:60px;'>HELLO WORLD</h1>"
		}]
	});
});