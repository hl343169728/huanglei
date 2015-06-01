package com.hz.yisheng.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.primitives.Ints;

/**
 * Guava（瓜娃）
 * 
 * @author a
 *
 */
public class GuavaTest {

	public static void main(String[] args) {

		Map<String, Map<Long, List<String>>> map = new HashMap<String, Map<Long, List<String>>>();

		Map<String, Map<Long, List<String>>> newMap = Maps.newHashMap();

		List<String> newList = new ArrayList<String>();
		newList.add("1");
		newList.add("2");
		newList.add("3");

		ImmutableList<String> immuList = ImmutableList.of("1", "2", "3");
		ImmutableMap<String, String> immuMap = ImmutableMap.of("key1", "value1", "key2", "value2");
		
		multiMap();
		System.out.println("-------------------------");
		map();
		System.out.println("-------------------------");
		joiner();
		System.out.println("-------------------------");
		split();
		System.out.println("-------------------------");
		splitString();
		System.out.println("-------------------------");
		compareInt();
		System.out.println("-------------------------");
		ints();
		System.out.println("-------------------------");
//		validate();
		System.out.println("-------------------------");
		functions();
		System.out.println("-------------------------");
		functions2();
	}
	
	public static void functions2() {
		Function<String, Boolean> isPalindrome = new Function<String, Boolean>() {
			public Boolean apply(String from) {
				Preconditions.checkNotNull(from);
				return new StringBuilder(from).reverse().toString().equals(from);
			}
		};
		
		List<String> from = Lists.newArrayList("rotor", "radar", "hannah", "level", "bobox");
		List<Boolean> to  = Lists.transform(from, isPalindrome);
		for(int i=0; i<from.size(); i++) {
			System.out.printf("%s is%sa palindrome\n", from.get(i), to.get(i)?" ":" not ");
		}
		System.out.printf("\n now replace hannah with megan...\n\n"); 
		from.set(2, "megan");  
		for (int i = 0; i < from.size(); i++) {  
			System.out.printf("%s is%sa palindrome\n", from.get(i), to.get(i)?" ":" not ");  
		}  

	}
	
	/**
	 * Functions(闭包功能) 计算字符串长度
	 */
	public static void functions() {
		Function<String, Integer> strlen = new Function<String, Integer>() {
			public Integer apply(String from) {
				Preconditions.checkNotNull(from);
				return from.length();
			}
		};
		
		List<String> from = Lists.newArrayList("abc", "def", "jijkl");
		List<Integer> to  = Lists.transform(from, strlen);
		for (int i=0; i<from.size(); i++) {
			System.out.printf("%s has length %d\n", from.get(i), to.get(i));
		}
	}
	
	/**
	 * 验证
	 */
	public static void validate() {
		int count = -1;
//		if (count < 0) {
//			throw new IllegalArgumentException("must be positive:" + count);
//		}
		
		Preconditions.checkArgument(count > 0, "must be positive: %s", count);
	}
	
	/**
	 * Ints的一些用法
	 */
	public static void ints() {
		int[] array = {1,2,3,4,5};
		int a = 1;
		// 是否包含
		boolean contains = Ints.contains(array, a);
		System.out.println(contains);// true
		// 指定字符在数组中的位置
		int indexOf = Ints.indexOf(array, a);
		System.out.println(indexOf);// 0
		// 数组中最大的数
		int max = Ints.max(array);
		System.out.println(max);// 5
		// 数组中最小的数
		int min = Ints.min(array);
		System.out.println(min);// 1
		int[] concat = Ints.concat(array);
		System.out.println(Arrays.toString(concat));
	}
	
	/**
	 * 基本类型比较
	 */
	public static void compareInt() {
		int a = 1;
		int b = 2;
		int compare = Ints.compare(a, b);
		System.out.println(compare);
	}
	
	/**
	 * 对字符串进行切分
	 */
	public static void splitString(){
		String str = "foo , what,,,more,";
		Iterable<String> iter = Splitter.on(",").omitEmptyStrings().trimResults().split(str);
		Iterator<String> it = iter.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	/**
	 * split分隔
	 */
	public static void split() {
		int[] numbers = {1,2,3,4,5};
		String numbersAsString = Joiner.on(";").join(Ints.asList(numbers));
		Iterable<String> iter = Splitter.on(",").split(numbersAsString);
		Iterator<String> it = iter.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	/**
	 * 拼接成字符串
	 */
	public static void joiner() {
		int[] numbers = {1,2,3,4,5};
		String numbersAsString = Joiner.on(",").join(Ints.asList(numbers));
		// 另一种写法
		String numbersAsString2 = Ints.join(";", numbers);
		System.out.println(numbersAsString);
		System.out.println(numbersAsString2);
	}
	
	/**
	 * Map值过滤
	 */
	public static void map(){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("张三", 20);
		map.put("李四", 21);
		map.put("王五", 22);
		
		// 所有年龄大于20岁的人员  
		Map<String, Integer> filterMap = Maps.filterValues(map, new Predicate<Integer>() {
			public boolean apply(Integer value){
				return value > 20;
			}
		});
		
		System.out.println(filterMap);
 	}
	
	/**
	 * multiMap
	 */
	public static void multiMap(){
		Multimap<String, String> multiMap = ArrayListMultimap.create();
		// Adding some key/value  
		multiMap.put("Fruits", "Banana");
		multiMap.put("Fruits", "Apple");
		multiMap.put("Fruits", "Pear");
		multiMap.put("Vegetables", "Carrot");
		
		// Getting the size  
		int size = multiMap.size();
		System.out.println(size);// 4  
		
		Collection<String> fruits = multiMap.get("Fruits");
		System.out.println(fruits);// [Bannana, Apple, Pear]  
		
		Collection<String> vegetables = multiMap.get("Vegetables");
		System.out.println(vegetables);// [Carrot]  
		
		// 循环输出  
		for(String value: multiMap.values()) {
			System.out.println(value);
		}
		
		// 移走某个值  
		multiMap.remove("Fruits", "Banana");
		System.out.println(multiMap.get("Fruits"));// [Apple, Pear] 
		
		//移走某个KEY的所有对应value  
		multiMap.removeAll("Fruits");
		System.out.println(multiMap.get("Fruits"));// [] (Empty Collection!)  
	}
	
}
