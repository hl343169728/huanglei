// Ext code  ext.js & ext-more.js
Ext.onReady(function(){

	
	//********************************* ext.js ***************************************//
	
	/**
	 * Ext.apply(target , extobj , defaults) & Ext.applyIf(target , src , defaults) 底层拷贝对象方法
	 * target	: 	目标对象
	 * extobj	:	源对象 
	 * default	:	默认值属性(不用考虑)
	 */
/*
  	var target = {} ,src = {};
	src.name= '张三' ;
	src.age = 25 ;
	src.sex = '男' ;
	target.name = '李四';
	//Ext.apply(target,src);	
	Ext.applyIf(target,src);
	Ext.Msg.alert('个人信息',target.name+'\n'+target.age+'\n'+target.sex);
*/

	
	/**
	 * Ext.extend(sub , sup , overrides) 继承 
	 * sub	：子类对象
	 * sup	：继承对象
	 * overrides   ： 	需要覆盖的属性或方法(对象集合)
	 */	
	
	/*
	
 	function Animal(name , tail){		
		this.name = name ,
		this.tail = tail 
	}
	
	Animal.prototype = {
		happy: 	function(){alert('摇尾巴')},
		run: 	function(){alert('动物在跑')}
	}
	Animal.prototype.constructor = Animal;	
	
	
	function Person(name , tail){
		Animal.call(this , name , tail);		//类继承
	}	
    
	Ext.extend(Person , Animal ,{
		happy: 	function(){alert('微笑');},
		run: 	function(){alert('人在跑')}
	});	
	
	var p = new Person('z3','没有尾巴');
	alert(p.name);
	alert(p.tail);
	p.run();
	p.happy();

	*/

	/**
	 * Ext.override(class , overrides) 覆盖方法
	 * class	： 要覆盖的类
	 * overrides： 需要覆盖的属性或方法(对象集合)
	 */
	/*
 	Ext.define('MyOver', {
	    sayHi: function() {
	        alert('Hi!');
	    },
	    sayHe: function() {
	    	alert('hello');
	    },
	    constructor: function(config){
			this.initConfig(config);
			return this;
		}
	});
	Ext.override(MyOver, {
	    sayHi: function() {
	        alert('About to say...'); //this.callOverridden();
	    } , 
	    sayHe: function(){
	    	alert('aaaaa')
	    }
	});	
	var over = new MyOver();
	over.sayHi(); 		// alerts 'About to say...'
	over.sayHe();             		// alerts 'Hi!'
	*/

	/**
	 * Ext.iterate(object,fn,scope)	对数组或对象进行迭代
	 * object	：	需要迭代的对象
	 * fn		：	进行迭代操作的函数
	 * scope	：	作用域
	 */
/*
	var obj = {name: 'xiaoxiao' , age: 20};
	//var	arr = [1,2,3,4]; 
	Ext.iterate(obj,function(item){
			alert(item);
	},this);	
	*/


	
	/**
	 * Ext.clone(item)	可以克隆数组、对象、Dom节点和日期等数据
	 * item		：	需要克隆的object
	 */
	
	
	//var obj1 = {name: 'z3' , age: 20};
	//var obj2 = Ext.clone(obj1);
	/*
	var obj1 = new Date();
	var obj2 = new Date(obj1.getTime());
	alert(obj1.getTime());
	alert(obj2.getTime());
	*/
	
	/** 
	 * namespace 命名空间 
	 * 
	 */
	
	//Ext.namespace('com.bjsxt.model' , 'com.bjsxt.core');
	/*
	com.bjsxt.model.fun = function(){
		alert('我是命名空间');
	}

	com.bjsxt.model.fun();	
	*/
	
	//********************************* ext-more.js ***************************************//
	
	/**
	 * 	
	 *		Ext.getBody(); 返回当前document对象的body元素。
	 *		Ext.getHead();返回document对象的head元素。 
	 *		Ext.getDoc();返回document对象。
	 *		Ext.getCmp(id);获取组件对象。
	 *		Ext.getDom(id);获取document对象
	 *		Ext.destroy(obj1,obj2...objn);删除对象及其事件。
	 *		Ext.destroyMembers(obj,field1,field2...fieldn);删除对象的成员。
	 *		Ext.copyTo(dest , src ,names  [uerPrototypeKeys]); 复制对象属性到目标对象
	 */


	//Ext.destroyMembers 
	/*
	var obj = {name: 'z3' , age: 20 , sex: '男'};
	Ext.destroyMembers(obj ,'age' , 'sex'); 
	
	alert(obj.name);
	alert(obj.sex);
	alert(obj.age);
	*/
	//Ext.copyTo
	
	var dest = {}, src = {name:'aa' , age: 10};
	//如果设置为true 则不论src对象里存在与否要进行增加的属性 我都会去做增加 , false 只有src里存在的成员 才会被做增加
	Ext.copyTo(dest , src , 'name,sex' , true );  
	alert(dest.name);
	alert(dest.sex);
	alert(dest.hasOwnProperty('sex'));	
	
	
});





