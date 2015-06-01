package com.hz.yisheng.demo.test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		Integer i1 = map.put("id", new Integer(1));
		Integer i2 = map.put("id", new Integer(1111));
		
		System.out.println(i1);
		System.out.println(i2);
	}
}
