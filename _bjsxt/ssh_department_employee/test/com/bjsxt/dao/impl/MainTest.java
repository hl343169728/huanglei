package com.bjsxt.dao.impl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class MainTest extends TestCase{
	public static Test suite(){
		TestSuite suite = new TestSuite();
		suite.addTestSuite(DepartmentDaoImplTest.class);
		suite.addTestSuite(MathUtilTest.class);
		return suite;
	}
}
