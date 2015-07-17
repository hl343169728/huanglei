package com.hz.yisheng.demo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CollectionDemo {

	public static void main(String[] args) {
		
		diffAddAndSet();
		indexOfAndLastIndexOf();
		addAll();
		mapGet();
		gather();
		getPeopleInfo();
		getInfo();
		generalFor();
		listIterator();
	}
	
	/**
	 * add(int index, Object obj) 与 set(int index, Object obj)的不同
	 */
	private static void diffAddAndSet(){
		String a = "A",b = "B",c = "C",d = "D",e = "E";
		List<String> list = new LinkedList<String>();
		list.add(a);
		list.add(d);
		list.add(e);
		Iterator<String> iter = list.iterator();
		System.out.println("修改前集合中的元素是：");
		while(iter.hasNext()) {
			System.out.print(iter.next() + ",");
		}
		list.set(1, b);
		list.set(2, c);
		Iterator<String> iter2 = list.iterator();
		System.out.println();
		System.out.println("修改后集合中的元素是：");
		while(iter2.hasNext()) {
			System.out.print(iter2.next() + ",");
		}
		System.out.println();
	}
	
	/**
	 * indexOf(Object obj) 与 lastIndexOf(Object obj)的不同
	 */
	private static void indexOfAndLastIndexOf(){
		String a = "A", b = "B", c = "C", d = "D", apple = "apple";
		List<String> list = new ArrayList<String>();
		list.add(a);
		list.add(apple);
		list.add(b);
		list.add(apple);
		list.add(c);
		list.add(apple);
		list.add(d);
		System.out.println(list);
		System.out.println("apple 第一次出现的位置：" + list.indexOf(apple));
		System.out.println("apple 最后一次出现的位置：" + list.lastIndexOf(apple));
		System.out.println("b 第一次出现的位置：" + list.indexOf(b));
		System.out.println("b 最后一次出现的位置：" + list.lastIndexOf(b));
	}
	
	/**
	 * Set接口方法addAll(Collection col)去重
	 */
	public static void addAll() {
		List<String> list = new ArrayList<String>();
		list.add("apple");
		list.add("pear");
		list.add("apple");
		list.add("banana");
		Set<String> set = new HashSet<String>();
		set.addAll(list);
		System.out.println(set.size());
		System.out.println(set.isEmpty());
		Iterator<String> iter = set.iterator();
		System.out.println("集合中的元素是：");
		while(iter.hasNext()) {
			System.out.print(iter.next() + "\t");
		}
		System.out.println();
		set.clear();
		System.out.println(set.isEmpty());
	}
	
	/**
	 * Map方法get
	 */
	private static void mapGet() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "张三");
		map.put(2, "李四");
		map.put(3, "王五");
		for (int i = 1; i <= map.size(); i++) {
			System.out.println("第" + i + "个元素是：" + map.get(i));
		}
	}
	
	/**
	 * ArrayList
	 */
	private static void gather() {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		int i = (int) (Math.random() * (list.size() - 1));
		System.out.println("随机获取数组中的元素：" + list.get(i));
		list.remove(2);
		System.out.println("将索引是'2'的元素从数组中移除之后，数组中的元素是：");
		for (int j = 0; j < list.size(); j++) {
			System.out.print(list.get(j) + "\t");
		}
		System.out.println();
	}
	
	private static void getPeopleInfo() {
		Set<People> set = new HashSet<People>();
		set.add(new People("张三", 201501));
		set.add(new People("李四", 201502));
		set.add(new People("王五", 201503));
		Iterator<People> iter = set.iterator();
		System.out.println("集合中的元素是：");
		while(iter.hasNext()) {
			People p = iter.next();
			System.out.println(p.getId() + "-" + p.getName());
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void getInfo() {
		Map map = new HashMap();
		People p1 =  new People("张三", 201501);
		People p2 =  new People("王五", 201503);
		People p3 =  new People("李四", 201502);
		map.put(p1.getId(), p1.getName());
		map.put(p2.getId(), p2.getName());
		map.put(p3.getId(), p3.getName());
		Set set = map.keySet();
		Iterator iter = set.iterator();
		System.out.println("HashMap类实现的Map集合，无序");
		while(iter.hasNext()) {
			Integer i = (Integer) iter.next();
			String name = (String) map.get(i);
			System.out.println(i + "-" + name);
		}
		
		TreeMap treeMap = new TreeMap();
		treeMap.putAll(map);
		Iterator iter2 = treeMap.keySet().iterator();
		System.out.println("TreeMap类实现的Map集合，键对象升序");
		while(iter2.hasNext()) {
			Integer i = (Integer) iter2.next();
			String name = (String) map.get(i);
			System.out.println(i + "-" + name);
		}
	}
	
	/**
	 * 获取列表中的奇数
	 */
	private static void generalFor() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		System.out.println("列表中的元素：" + list);
		System.out.println("列表中奇数序号的元素：");
		for (int i = 1; i < list.size(); i += 2) {
			System.out.print(list.get(i) + "\t");
		}
		System.out.println();
	}
	
	/**
	 * ListIterator 实现逆序遍历列表中的元素
	 */
	private static void listIterator() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		System.out.println("列表中的元素：" + list);
		ListIterator<Integer>  listIter = list.listIterator();
		for(listIter = list.listIterator();listIter.hasNext();) {
			listIter.next();
		}
		for(;listIter.hasPrevious();) {
			System.out.print(listIter.previous() + " ");
		}
		System.out.println();
	}	
	
}

class People{
	private String name;
	private Integer id;
	
	public People(String name, Integer id){
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
