// Ext Helloworld 

	Ext.onReady(function(){
		//Ext.MessageBox.alert('my win','hi Extjs!!');
		
/*		if(Ext.BLANK_IMAGE_URL.substr(0,4) != 'data') {
			Ext.BLANK_IMAGE_URL = './images/s.gif';
		}*/
		
		
		//Ext.create('Ext.Viewport',{
		new Ext.Viewport({
			layout : 'fit' , 
			items: [{
				xtype: 'panel' , 
				title: '欢迎' ,
				html: "<h1 style='text-align:center; font-size:60px;'>HELLO WORLD</h1>"
			}]
		});	
		
	});

