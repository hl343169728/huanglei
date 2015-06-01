package com.hz.yisheng.demo.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ListUtil {

	/**
	 * 去掉重复的值，并保持原先List顺序
	 * 
	 * @param list
	 * @return
	 */
	private static List<String> removeDuplicate(List<String> list) {
		Set<String> set = new HashSet<String>();
		List<String> newList = new ArrayList<String>();
		for (Iterator<String> iter = list.iterator(); iter.hasNext();) {
			String element = (String) iter.next();
			if (set.add(element)) {
				newList.add(element);
			}
		}
		return newList;
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("1");
		list.add("3");
		List<String> newList = removeDuplicate(list);
		System.err.println(newList.size());
	}
}
