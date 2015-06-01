package com.hz.yisheng.demo.pattern;

import com.hz.yisheng.demo.pattern.component.AppenderFood;
import com.hz.yisheng.demo.pattern.component.Caraway;
import com.hz.yisheng.demo.pattern.component.Egg;
import com.hz.yisheng.demo.pattern.component.EggCake;

/**
 * 装饰者模式客户端
 * 
 * 	1.定义 
 *		装饰者模式也成为包装器Wrapper模式，它可以动态的给一个对象添加一些额外的职责，就增加功能而言，装饰者模式相比生成子类更加灵活。 
 *	2.应用场景 
 *		1）希望给某个对象增加功能，而不是给某个类增加功能时。 
 *		2）需要增加由一些基本功能的排列组合而产生的非常大量的功能，会造成子类呈爆炸性增长，从而使继承关系变的不现实时。 
 *	3.应用举例 
 *		1）Java I/O类库。Java I/O使用了装饰者模式，您还可以自定义装饰者来修饰Java I/O类。 
 *		2） 如果您开了一个咖啡店，咖啡里面可以添加各种各样的辅料，这些辅料可以作为装饰者。 或者如果您卖鸡蛋灌饼，顾客可以根据自己的口味选择添加不同的辅料，也可以使用装饰者模式。这两个例子有点不搭啊。
 * 	4.模式要点 
 *		1）装饰者和被装饰对象都属于同一类型。此模式中Decorator和ConcreteComponent都继承自Component是为了保证都是同一个对象，而不是为了重写基类的行为。 
 *		2）可以用一个或多个装饰者包装一个对象。 
 *		3） 装饰者可以在所委托被装饰者的行为之前或之后，加上自己的行为，以达到特定的目的。 
 *		4）装饰者不一定是功能，也可以是一个行为，例如每点击一次博客，给计数器+1。 
 *	5.装饰者模式的缺点 
 *		1）装饰者类会产生很多小对象。 
 *		2）因为所有对象都是继承于Component，所以如果Component内部结构发生改变，则不可避免地影响所有子类(装饰者和被装饰者)。 
 *	6.相关模式 
 *		1）适配器模式：装饰者模式仅改变对象的职责而不改变它的接口，适配器模式给对象一个全新的接口。 
 *		2）策略模式：装饰者模式用于改变对象的外表，而策略模式用于改变对象的内核。
 *
 * @author a
 *
 */
public class ComponentTest {

	public static void main(String[] args) {
		AppenderFood food = new EggCake();
		for (int i=0;i<10;i++) {
			food = new Egg(food);
		}
		food = new Caraway(food);
		food.append();
	}
}
