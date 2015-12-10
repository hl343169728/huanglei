// Ext code 

Ext.onReady(function(){

	/**
	 *	进度条组件  
	 *	手工模式 ， 自动模式
	 * 	updateProgress( float value , String text , Boolean animate)
	 *  注：第三个参数为是否使用动画效果,默认为false 
	 */
	
	//手工模式：
	/*
 	var config = {
		width : 300 , 
		renderTo : 'pb' 
	};
	var ProgressBar = new Ext.ProgressBar(config); 
	*/
	
	/*
	var ProgressBar =  Ext.create('Ext.ProgressBar',{
		width : 300 , 
		renderTo : 'pb' 
	});
	
	var count = 0 ; 
	var percentage = 0 ; 
	var progressText = '' ;
	
	Ext.TaskManager.start({
		run:function(){
			count++ ; 
			if(count>= 100){
				ProgressBar.hide();
			}
			//计算进度
			percentage = count/100 ; 
			progressText = Ext.Number.toFixed(percentage*100,0) + '%';
			//更新进度条信息
			ProgressBar.updateProgress(percentage , progressText , true );
		},
		interval: 100 , 	//间隔
		repeat:100			//执行次数
	});
	*/
	
	//自动模式：
	
	
	var config = {
		text: 'loading...' , 
		width: 300 , 
		renderTo: 'pb'
	};
	var ProgressBar = new Ext.ProgressBar(config);
	ProgressBar.wait({
		 duration: '10000' ,	//进度条持续更新10秒钟 
		 interval: '100' ,		//每100毫秒更新1次
		 increment:100 ,		//进度条分10次更新完毕
		 text: 'waiting' , 		//进度条上的文字 
		 scope: this ,			//回调函数的执行范围 
		 fn: function(){
		 	alert('执行完毕');
		 }
	});
	
	
	
	
});