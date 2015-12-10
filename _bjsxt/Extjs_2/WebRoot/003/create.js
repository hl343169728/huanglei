Ext.onReady(function(){

	
	/**
	 * Ext4.0 中定义一个新类的方式 采用define 而不是Ext3版本的extend方法
	 * 对其内部代码进行了大量的重构,扩展了新的功能
	 * 参数1表示className , 
	 * 参数2表示对其内部的属性集配置,其包含有：
	 *  extend	： 用于要继承的类的名称 
	 *  config 	： 对于属性的配置
	 *  constructor	： 构造属性	, 一般用于初始化类的配置项和调用其父类的方法
	 *  alias	： 类的别名
	 *  alternateClassName	：类的备用名(用法相当于alias) 
	 *  requires： 需要使用到的类名数组	, 在动态加载时会根据该属性去加载类  
	 *  mixins	： 表示混合 , 需要用到其他类的时候可以采用混合方式 实现多继承
	 *  statics	： 定义静态方法 (不能被子类所继承)
	 *  inheritableStatics : 定义静态方法(这里定义的属性或方法可以被继承)
	 */
	/*
	
	Ext.define('Animal' , {
		//   extend : ...   Base
		statics : {
			 method1 : function(){alert(111);}
		} ,
		inheritableStatics : {
			 method2 : function(){alert(222);}
		} , 
		config : {
			 name : '' , 
			 color: '' 
		} , 
		alias : 'an' 		
		, 
		constructor : function(config){
			this.initConfig(config);
			return this;
		}
	});
	
	//var a = new Animal({name: 'z3' , color: 'blue'});
	var a = Ext.create('Animal'  , {
			name: 'z4' , 
			color : 'red'
	});
	alert(a.getName());
	alert(a.getColor());
	
	*/
	
	
	
	
 	Ext.define('Person' , {
		statics:{
			getStatic : function(){
				alert('我是静态方法');
			}
		},		
		inheritableStatics : {
			getInheritableStatic : function(){
				alert('我是静态方法,可以被继承');
			}
		},
		alias  : 'Per' ,
		config : {					// 自动的生成getters and setters
			name : 'z3' ,
			age  : 25 
		} , 
		constructor: function(config){
			this.initConfig(config);
			return this ;
		}
	});
	
/*	
 	var u = Ext.create('Person',{});			//创建一个类的实例对象
 	alert(u.setName('王5'));
	alert(u.setAge('30'));
	alert(u.getName());
	alert(u.getAge());
	Person.getStatic();
	Person.getInheritableStatic();
	*/
	
	
	
	/*
	Ext.define('Boy' , {
		extend : 'Person' , 
		config : {
			sex : '男 '
		} ,
		constructor: function(config){
			this.initConfig(config);
			return this ;
		}
	});
	
	var b = Ext.create('Boy' , {
		name : 'xiaoxiao' ,
		age  : 20 , 
		sex  : '女'
	});
	
	
	alert(b.getName());
	alert(b.getAge());
	alert(b.getSex());
	Boy.getInheritableStatic();
  	Boy.getStatic();		//没有继承此静态方法
	*/
  	
  	
  	
  	/*
  	
	Ext.define('CanSing',{
			sing: function(){
				alert('sing....');
			}
	});
	
	Ext.define('CanSay',{
			say: function(){
				alert('say....');
			}
	});
	
	Ext.define('User',{		
		mixins : {
			CanSing : 'CanSing' , 
			CanSay	: 'CanSay'
		}
	});
	
	var u = Ext.create('User',{});
	u.say();
	u.sing();

	*/
	

	
	
	
	
	
	
	
	
});