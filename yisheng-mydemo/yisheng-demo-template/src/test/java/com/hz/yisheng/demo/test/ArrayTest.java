package com.hz.yisheng.demo.test;

import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {
		copyArr();
		System.out.println("---------------");
		outPutArr();
	}

	/**
	 * 数组声明
	 */
	@SuppressWarnings("unused")
	public static void declareArr() {
		// 1.声明的时候指定数组大小会出错
		// int[3] arr1 = new int[3];
		int[] arr1 = new int[3];
		// 2.多维数组不必须是规则矩阵形式
		int[][] arr2 = new int[1][];
		int[] arr3 = new int[4];
		arr2[0] = arr3;
	}

	/**
	 * 数组复制
	 */
	public static void copyArr() {
		int[] source = { 1, 2, 3, 4, 5 };
		int[] dest = { 6, 7, 8, 9, 10 };
		System.arraycopy(source, 2, dest, 1, 2);
		System.out.println(dest.length);
	}

	/**
	 * 数组打印
	 */
	public static void outPutArr() {
		int[][] arr = new int[1][1];
		int[] arr1 = { 1, 2 };
		arr[0] = arr1;
		System.out.println(Arrays.toString(arr[0]));
	}
}
