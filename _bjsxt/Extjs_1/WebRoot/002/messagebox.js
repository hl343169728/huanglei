// Ext code 


Ext.onReady(function(){

  	/**
	 *	参数说明：
	 *  title：提示框的标题 
	 *  msg：显示的信息内容 
	 *  fn：  回调函数(可选)
	 *  scope：回调函数的作用域(可选) 
	 */
   /*  
	Ext.Msg.alert('提示','确定',callback);	
	function callback(id){
			alert('id:' + id);
	};
	*/
	/*
	Ext.Msg.confirm('提示','确认?',callback);
	function callback(id){
		alert('按钮id：'+id);
	}
	*/
  	/**
	 *	参数说明：
	 *	注意第五个参数为Boolean[Number multiline]值: false表示显示单行文本,true为显示多行文本
	 */
	/*
	Ext.Msg.prompt('提示','请输入内容：' , callback , this , false , '我是内容');
	function callback(id,msg){
		alert('按钮id：'+ id + '\n' + '输入内容为：' + msg);
	}
  	*/
	
	/**
	 * 	参数说明：
	 * 	wait(String msg , String title , Object config);
	 *  最后一个参数表示用于配置进度条的对象信息,为可选参数
	 */ 
	/*
	Ext.Msg.wait('请稍等...' , '提示信息' , { 
		text: '我是进度条上的文字！'
	});
	*/
	
	/**
	 * Ext.MessageBox.show
	 */	
	/*
	var config = {
		title: '提示' , 
		msg: '我是内容',
		modal: true ,
		width: 400 ,
		closable: false ,
		prompt: true ,
		multiline : true ,
		value : '请输入内容：' , 
		fn : callback , 
		buttons : Ext.Msg.YESNOCANCEL ,
		icon: Ext.Msg.QUESTION
	};
	// cancel
	Ext.Msg.msgButtons[3].setText('Cancel按钮');
	// ok 
	Ext.Msg.msgButtons[0].setText('OK按钮');
	// yes 
	Ext.Msg.msgButtons[1].setText('Yes按钮');
	// no 
	Ext.Msg.msgButtons[2].setText('No按钮');

	Ext.Msg.show(config);
	
	
	function callback(id ,msg){
		alert('按钮id:'+ id + '\n' + '内容：'+ msg);
	};
	*/
	
	
	/**
	 * 自定义进度条 
	 * config 配置进度条基本信息 
	 * task 设置任务对象 当执行100次后结束任务
	 * 
	 */
	
	var config = {
		title : '提示' , 
		msg : '动态更新的进度条和文字' , 
		modal : true ,
		width : 300 ,
		progress : true 
	};
	
	var msgBox = Ext.Msg.show(config);
	
	var count = 0 ; 		//滚动条被刷新的次数
	var percentage = 0 ; 	//进度条的百分比 
	var progressText = '' ; //进度条信息
	
	
	var task = {
		run:function(){
			count ++ ;
			percentage = count /100 ;  
			progressText = '当前完成' + Ext.Number.toFixed(percentage*100,0) + '%';		//Ext.Number.toFixed(value , pri)
			//更新进度条的提示对话框 
			msgBox.updateProgress(
				percentage , 
				progressText , 
				'当前时间：'+ Ext.util.Format.date(new Date() , 'Y-m-d g:i:s A')
			);
			//刷新100次后关闭提示信息对话框
			if(count > 100){
				Ext.TaskManager.stop(task);
				msgBox.hide();
			}
		},
		interval: 100
	}
	

	Ext.TaskManager.start(task);
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
});

