package com.hz.yisheng.demo.pattern;

import com.hz.yisheng.demo.pattern.facade.Facade;
import com.hz.yisheng.demo.pattern.facade.SubSystemA;
import com.hz.yisheng.demo.pattern.facade.SubSystemB;
import com.hz.yisheng.demo.pattern.facade.SubSystemC;

/**
 * 外观模式客户端
 * 
 * 1.定义 
 *		外观模式也称为门面模式，英文名称是Facade，为子系统的一组接口提供一个一致的界面，Facade模式定义了一个高层接口，这个接口使得这个子系统更加容易使用
 * 2.适用场景 
 *		1）假如您是中间件厂商，负责提供产品。那么客户使用产品的时候可以开发一个Facade类，由Facade类来对您的产品(可视为子系统)的基础功能进行特定的封装，这样客户端代码只需要跟Facade打交道就可以了，实现了解耦和简化子系统使用的双重功效
 * 3.优点 
 *		1）它对客户屏蔽了子系统细节，减少了客户需要处理的对象的数目，使得子系统使用起来更加方便。 
 *		2）实现了子系统与客户之间的解耦，这样子系统变化只会影响到Facade，而不会影响到客户端。 
 *		3）Facade也可以使用在子系统内部的层与层之间。 
 *		4）Facade并不会限制客户端使用子系统，客户端也可以绕过Facade，直接访问子系统。
 * 
 * @author a
 *
 */
public class FacadeTest {

	public static void main(String[] args) {
		// 直接访问子系统
		SubSystemA subA = new SubSystemA();
		subA.method();
		SubSystemB subB = new SubSystemB();
		subB.method();
		SubSystemC subC = new SubSystemC();
		subC.method();
		System.out.println("----------------------");
		// 使用外观模式
		Facade facade = new Facade();
		facade.method();
	}
}
