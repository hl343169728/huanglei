Ext.onReady(function(){
	/**
	 * 参数说明
	 * title：提示框的标题
	 * msg:显示的信息内容
	 * fn:回调函数（可选）
	 * scope:回调函数的作用域（可选）
	 */
	
	/*
	 * 警告框
	Ext.Msg.alert('提示','确认？',callback);
	function callback(id){
		alert('按钮id：'+id);
	}
	*/
	
	/*
	 * 确认框
	Ext.Msg.confirm('提示信息','确认？',callback);
	function callback(id){
		alert('按钮id:'+id);
	}
	*/
	
	/*
	 * 第一个参数：标题
	 * 第二个参数：输入框标题
	 * 第三个参数：回调函数
	 * 第四个参数：指当前的对象
	 * 第五个参数为Boolean类型的值：false表示显示单行文本 ，true表示显示多行文本
	 * 第六个参数：指输入框的默认输入
	 */
	/*
	 * 输入框
	Ext.Msg.prompt('提示信息','请输入内容：',callback,this,true,'我是内容');
	function callback(id,msg){
		alert('按钮id:'+id+'\n'+'输入的内容为：'+msg);
	}
	*/
	
	/**
	 * 参数说明：
	 * wait(String msg,String title,Object config)
	 * 最后一个参数表示用于装配进度条的对象信息，为可选参数
	 */
	/*
	 * 等待框
	Ext.Msg.wait('请稍等...','提示信息',{text:'我是进度条上的文字！'});
	*/
	
	/**
	 * Ext.MessageBox.show
	 */
	/*
	var config = {
			title:'提示',  				//提示框标题
			msg:'我是内容',				//输入框的小标题
			modal:true,
			width:400,					//宽度
			closable:false,				//是否能收起
			prompt:true,				//输入框
			multiline:true,				//是否允许多行输入
			value:'请输入内容：',		//输入框中的默认值
			fn:callback,				//回调函数
			buttons:Ext.Msg.YESNOCANCEL,//按钮
			icon:Ext.Msg.QUESTION
	};
	Ext.Msg.show(config);
	
	function callback(id,msg){
		alert('按钮id:'+id+'\n'+'内容：'+msg);
	}
	*/
	
	/**
	 * 自定义进度条
	 * config 配置进度条的基本信息
	 * task 设置任务对象 ，当执行100次后结束任务
	 */
	var config = {
			title:'提示信息',
			msg:'动态更新的进度条和文字',
			modal:true,
			width:300,
			progress:true
	};
	var msgBox = Ext.Msg.show(config);
	var count  = 0;				//滚动条被刷新的次数
	var percentage = 0;			//进度条的百分比
	var progressText = '';		//进度条的信息
	
	var task = {
		run:function(){
			count ++ ;
			percentage = count/100;
			progressText = '当前完成'+Ext.Number.toFixed(percentage*100,0)+'%'; //Ext.Number.toFixed(value , pri) 前一个参数百分比，后一个参数小数点后几位
			msgBox.updateProgress(
					percentage,
					progressText,
					'当前时间'+Ext.util.Format.date(new Date(),'Y-m-d g:i:s A')
			);
			if(count>100){
				Ext.TaskManager.stop(task);//关闭任务
				msgBox.hide();//隐藏
			}
		},
		interval:100
	};
	Ext.TaskManager.start(task); //启动任务
});