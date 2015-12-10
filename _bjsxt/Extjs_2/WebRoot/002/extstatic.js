// Ext code 		Ext.Object & Ext.Function & Ext.Array
Ext.onReady(function(){

	
	//********************** 	Ext.Object <static method>   *************************//						
	 
	/**
	 *  Ext.Object.each(object , fn , scope)
	 *  object: 	要进行枚举的对象 
	 *  fn 	  : 	key 关键字 ,  value 值  ,  myself 函数本身
	 *  scope :     为可选参数 表示为函数运行作用域  
	 */
	
/*
	var person = {
	    name: 'Jacky' ,
	    hairColor: 'black' ,
	    loves: ['food', 'sleeping', 'wife']
	};
	
	Ext.Object.each(person, function(key, value, myself) {
	    if (value.constructor == Array ) {
	    	alert(key);
	        return false; 	// stop the iteration
	    }
	} , this );
	*/	
	
	/**
	 * Ext.toQueryString(object , [recursive])	将对象转为编码的查询字符串
	 * Ext.fromQueryString(string , [recursive])将查询字符串解码转为对象
	 * object	： 	对象
	 * string	：	编码字符串
	 * recursive：	是否使用递归,默认为false (可选项)
	 */
	
/*	
	var person = {name : '张三' , age: 20 ,loves:['eat','play','sleep']};
	var str = Ext.Object.toQueryString(person,true);
	alert(str);
	var newperson = Ext.Object.fromQueryString(str,true);
	alert(newperson.name);
	alert(newperson.age);
	alert(newperson.loves[1]);
*/
	
	/**
	 * Ext.Object.merge(obj1 , obj2 , ... objn) 以递归方式合并任何数量的对象
	 */
	
	/*
	var u1 = { name : 'z3' , age : 25 , salary : 5000  , plays : 'games'} ;
	var u2 = { name : 'w5' , age : 30 , salary : 10000 , loves : 'sleep'} ;
	var u3 = { name : 'z6' , age : 40 , salary : 45000 } ;
	var uall = Ext.Object.merge(u1 , u2 , u3);
	alert(uall.name);
	alert(uall.age);
	alert(uall.salary);
	alert(uall.plays);
	alert(uall.loves);
	*/
	
	//arguments.callee
	/**
	 * Ext.Object.toQueryObjects(name , object , [recursive])将对象转为数组
	 * name		：	转为数组中的name关键字
	 * object	：	需要转换的对象
	 * recursive：	是否采用递归转换(可选项)
	 */
	
/*
 	var objects = Ext.Object.toQueryObjects('hobbies', ['reading', 'cooking', 'swimming' ]);

	// objects then equals:
	[
	    { name: 'hobbies', value: 'reading' },
	    { name: 'hobbies', value: 'cooking' },
	    { name: 'hobbies', value: 'swimming' }
	];
	
	alert(objects[0].value);
*/
	
	
	
	//********************** 	Ext.Function <static method>   *************************//
		
	/**	
	 *		Ext.Function.pass(fn ,args [scope]) 主要用于创建回调函数
	 *		
	 *		**************************************VIEW SOURCE**********************************
	 *
	 *		function  (fn, args, scope) {
	 *       	if (args) {
	 *           	args = Ext.Array.from(args);		//转为数组
	 *       	}
	 *
	 *       	return function() {
	 *           	return fn.apply(scope, args.concat(Ext.Array.toArray(arguments)));		//将可迭代的数据转为数组
	 *       	};
	 *		}	
	 *
	 *
	 *
	 */	
		
	/*
	
		function createCallbackFn (fn, args, scope) {  
	   		if (args) {
	        	args = Ext.Array.from(args);		//转为数组  ['Hello', 'World']
	        }
	      	return function() {
	            	return fn.apply(scope, args.concat(Ext.Array.toArray(arguments)));		//将可迭代的数据转为数组
	   		};
		}
		
		
		var originalFunction = function(){
			if(!originalFunction.isLock){				//first into
				alert(Ext.Array.from(arguments).join(' '));
				originalFunction.isLock = true ;		// mk lock
			}
		    if(originalFunction.isLock && arguments[arguments.length-1] == 'is ok'){
		    		alert('is ok');
		    		alert(Ext.Array.from(arguments).join(' '));
		    } 
		};	
		originalFunction.isLock = false ;				// init lock
		
		
		
		
		var callback = createCallbackFn(originalFunction, ['Hello', 'World'] ,this);	
		callback(); 			// alerts 'Hello World'
		callback('is ok');	 	// alerts 'Hello World is ok'	

	*/
	/**
	 * 		Ext.Function.alias(object,methodName) 给函数起别名
	 */

	/*
		var obj = {
			fn: function(x){
				alert(x+ '执行中...');
			}
		};	
		var method = Ext.Function.alias(obj , 'fn');
		alert(typeof method);
		method('我在');
		//obj.fn('我也在');
	*/
	/**
	 * 	Ext.Function.createInterceptor(fn , interFn , [scope , returnValue] ) 创建一个拦截函数
	 *  fn			: 	原始函数 
	 *  interFn		: 	拦截函数
	 *  scope		:	函数作用域 
	 *  returnValue	:	是拦截函数返回false时的返回值,可选参数,如果没有设置则返回null
	 *  return		:	该方法返回新建的函数
	 */
	
	/*

    var sayHiToFriend = Ext.Function.createInterceptor(function(a , b){ return a+b ;}, function(a , b){
		var flag = false , i ;
		for( i in arguments){
			if(arguments[i] && !Ext.isNumber(arguments[i])){
				return flag ;
			}
		}
		flag = true ;
	    return flag ;
	},this , 'arguments is error');
	
	alert(sayHiToFriend(1,2));  // no alert
	alert(sayHiToFriend('Brian')); // alerts "Hi, Brian"
	*/
	

	/**
	 * Ext.Function.createDelayed(fn,delay [scope,  args , appends])创建一个延时执行的回调函数
	 * fn	: 	回调函数
	 * delay:	延迟的时间(单位是微秒)
	 * scope:	作用域 
	 * arge	: 	为调用重写参数的参数数组
	 * appends：作为可选参数,为布尔值或数字, 如果为true ,则将args追加到原有参数 ,
	 * 			不是重写原有参数 ,如果为数组 ,则在数字的指定位置插入的args参数,在原有参数的基础上
	 */

/*	
 	var f = Ext.Function.createDelayed(function(){
	    alert('Anonymous');
	}, 2000);
	f();
*/
	
	/**
	 * Ext.Function.defer(fn,delay [scope,  args , appends]) 创建一个延迟执行的函数
	 * fn	: 	回调函数
	 * delay:	延迟的时间(单位是微秒)
	 * scope:	作用域 
	 * arge	: 	为调用重写参数的参数数组
	 * appends：作为可选参数,为布尔值或数字, 如果为true ,则将args追加到原有参数 ,
	 * 			不是重写原有参数 ,如果为数组 ,则在数字的指定位置插入的args参数,在原有参数的基础上
	 */
	
	/*
 	Ext.Function.defer(function(){
	    alert('Anonymous');
	}, 2000);
	*/

	
	/**
	 * Ext.Function.createSequence(origFn,newFn [scope])创建一个函数,在执行原始函数之后执行指定函数
	 * origFn	：	原始函数
	 * newFn	：	新函数
	 */
	
	/*
 	var fn = Ext.Function.createSequence(
 		function(){
 			alert(11);
 			return 'origFn';
 		} , 
 		function(){
 			alert(22);
 		} 
 		, this);
	*/
	//fn();
	//alert(fn());

	
	
	/**
	 *	  Ext.Function.createBuffered(fn,  buffer,  scope,  args)创建一个缓冲函数
	 */
	
	/*
		var d1 = Ext.Date.now();
		var buffer = Ext.Function.createBuffered(function(){alert(111);} , 2000 , this);
		
		
		buffer();		// 开始执行
		
		
		Ext.Function.defer(function(){alert('2秒啦')}, 2000);	//2秒
		
		Ext.Function.defer(buffer, 1900);		// 3.9秒
	*/
	
	//4.1版本
	/**
	 * Ext.Function.interceptBefore(object,methodName,fn, [scope])在函数的原始操作之前执行一个指定操作
	 * Ext.Function.interceptAfter(object,methodName,fn, [scope])在函数的原始操作之后执行一个指定操作
	 * object		：	为目标对象
	 * methodName	：	为要重写的方法
	 * fn			：	一个新的操作(function)
	 * scope		：	作用域	
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//***********************************************************************************************************************//
	
	/**
	 * 		Ext.Function.flexSetter(fn);封装一个只有两个参数的函数,使函数参数更具有灵活性	(此方法用的时机为何?)
	 */
/*		
 		var setValue = Ext.Function.flexSetter(function(name, value) {
			alert(name);
		    alert(value);
		    //this[name] = value;
		});
		
		// Afterwards
		// Setting a single name - value
		// setValue('name1', 'value1');
		
		// Settings multiple name - value pairs
			setValue({
			    name1: 'value1',
			    name2: 'value2',
			    name3: 'value3'
			});
*/

	/**
	 *		Ext.Function.bind(fn [scope , args appendArgs])绑定函数，保持作用域
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
});