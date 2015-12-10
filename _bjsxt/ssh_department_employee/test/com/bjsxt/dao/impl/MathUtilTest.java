package com.bjsxt.dao.impl;

import junit.framework.Assert;
import junit.framework.TestCase;

public class MathUtilTest extends TestCase{
	public void testAdd(){
		int a = 1;
		int b = 2;
		int c = 3;						//预期值
		int real = MathUtil.add(a, b);	//实际值
		//如果预期值与实际值不想等，就会报Failures
		Assert.assertEquals(c, real);
	}
}
