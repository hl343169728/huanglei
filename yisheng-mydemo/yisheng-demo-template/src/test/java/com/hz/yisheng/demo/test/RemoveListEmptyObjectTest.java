package com.hz.yisheng.demo.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RemoveListEmptyObjectTest {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

		List list = new ArrayList();
		List list1 = new ArrayList();
		List list2 = new ArrayList();
		List list3 = new ArrayList();

		Object[] obj3 = new Object[] { "纳税主体2", new BigDecimal(2), new BigDecimal(2), new BigDecimal(3) };
		Object[] obj4 = new Object[] { "纳税主体2", new BigDecimal(2), new BigDecimal(2), new BigDecimal(3) };
		
		list3.add(obj3);
		list3.add(obj4);
		
		list2.add("印花税");
		list2.add(list3);
		
		list.add(list1);
		list.add(new ArrayList());
		list.add(new ArrayList());
		list.add(new ArrayList());
		list.add(list2);
		
		removeListEmptyObject(list);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List removeListEmptyObject(List list) {
		List list1 = new ArrayList();
		if (null == list || list.size() <= 0) {
			return null;
		}
		for (int i = 0; i < list.size(); i++) {
			List temp = (List) list.get(i);
			if (temp != null && temp.size() > 0) {
				list1.add(temp);
			}
			System.out.println(list1.size());
		}
		return list;
	}
}
