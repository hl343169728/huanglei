package com.hz.yisheng.demo.test;

import java.util.Arrays;

public class ArrayDemo {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		sumNumber(arr);
		minNumber(arr);
		matrix();
		ransack();
		arrayRowColumnSwap();
		traceOfTheMatrix();
		getMonthDay();
		trap();
		tautog();
		arrayFill();
		arrayFillFromTo();
		arraySort();
		copyOf();
		copyOfRange();
		compareOneArrayToTwoArrayMemory();
		insertSort();
		bubbleSort();
		nineTable();
	}

	/**
	 * 一维数组各元素之和
	 * 
	 * @param arr
	 * @return
	 */
	private static int sumNumber(int[] arr) {
		int sum = 0;
		System.out.println("一维数组中各元素的和是：");
		for (int i : arr) {
			if (i == 9) {
				System.out.print(i + "=");
			} else {
				System.out.print(i + "+");
			}
			sum += i;
		}
		System.out.println(sum);
		return sum;
	}

	/**
	 * 数组中的最小值
	 * 
	 * @param arr
	 * @return
	 */
	private static int minNumber(int[] arr) {
		int min = arr[0];
		System.out.println("数组中最小的值是：");
		for (int i = 0; i < arr.length - 1; i++) {
			if (min > arr[i + 1]) {
				min = arr[i + 1];
			}
		}
		System.out.println(min);
		return min;
	}

	/**
	 * 3行4列，二维数组
	 */
	private static void matrix() {
		int[][] arr = new int[3][4];
		System.out.println("输出3行4列的数组：");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * 三维数组
	 */
	private static void ransack() {
		int[][][] arr = new int[][][] { { { 1, 2, 3 }, { 4, 5, 6 } }, { { 7, 8, 9 }, { 10, 11, 12 } }, { { 13, 14, 15 }, { 16, 17, 18 } } };
		for (int i = 0; i < arr.length; i++) {
			System.out.println("三维数组的第" + (i + 1) + "个元素是一个" + arr[0].length + "维数组，内容如下：");
			for (int j = 0; j < arr[0].length; j++) {
				for (int k = 0; k < arr[0][0].length; k++) {
					System.out.print(arr[i][j][k] + "\t");
				}
				System.out.println();
			}
		}
	}
	
	/**
	 * 矩阵转置预算
	 */
	private static void arrayRowColumnSwap() {
		int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		System.out.println("转置前的矩阵：");
		printArray(arr);
		System.out.println("转置后的矩阵：");
		int[][] swapArr = new int[arr.length][arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				swapArr[i][j] =  arr[j][i];
			}
		}
		printArray(swapArr);
	}
	
	/**
	 * 输出数组
	 * 
	 * @param arr
	 */
	private static void printArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 方阵的迹
	 */
	private static void traceOfTheMatrix() {
		int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		System.out.println("方阵arr是：");
		printArray(arr);
		int value = 0;
		for (int i = 0; i < arr.length; i++) {
			value += arr[i][i];
		}
		System.out.println("方阵arr的迹是：" + value);
	}
	
	/**
	 * 各月的天数输出，遍历一维数组
	 */
	private static void getMonthDay() {
		int[] day = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		System.out.println("遍历一维数组：");
		for (int i = 0; i < 12; i++) {
			System.out.print((i + 1) + "月有" + day[i] + "天" + "\t");
			if ((i+1) % 3 == 0) {
				System.out.print("\n");
			}
		}
	}
	
	/**
	 * 遍历二维数组
	 */
	private static void trap() {
		int[][] arr = {{1}, {2, 3}, {4, 5, 6}};
		System.out.println("遍历二维数组：");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 遍历二维数组
	 */
	private static void tautog() {
		int[][] arr = {{3, 2, 1}, {6, 5, 4}};
		System.out.println("foreach，遍历二维数组：");
		for (int[] is : arr) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 填充替换数组元素
	 */
	private static void arrayFill(){
		int[] arr = new int[5];
		System.out.println("填充替换数组元素：");
		Arrays.fill(arr, 8);
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	/**
	 * 填充替换数组元素
	 */
	private static void arrayFillFromTo() {
		int[] arr = new int[]{1, 2, 3, 4, 5};
		Arrays.fill(arr, 1, 3, 8);
		System.out.println("填充替换数组元素，起始+结束：");
		for (int i = 0; i < arr.length; i++) {
			System.out.println("第" + (i + 1) + "个元素是：" + arr[i]);
		}
	}
	
	/**
	 * 数组排序
	 */
	private static void arraySort() {
		int[] arr = new int[]{43, 12, 45, 1, 210};
		System.out.println("原一维数组是：");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		Arrays.sort(arr);
		System.out.println("\n升序排列后的一维数组是：");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	/**
	 * 数组复制 copyOf
	 */
	private static void copyOf() {
		int[] arr = new int[]{2, 12, 3};
		System.out.println("复制前的数组为：");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		int[] newArr = Arrays.copyOf(arr, 5);
		System.out.println("\n复制后的数组为：");
		for (int i = 0; i < newArr.length; i++) {
			System.out.print(newArr[i] + " ");
		}
		System.out.println();
	}
	
	/**
	 * 数组复制 copyOfRange
	 */
	private static void copyOfRange() {
		int[] arr = new int[]{1, 2, 3, 6, 7};
		System.out.println("复制前的数组：");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		int[] newArr = Arrays.copyOfRange(arr, 0, 3);
		System.out.println("\n复制后的数组：");
		for (int i : newArr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	/**
	 * 对比一维数组、二维数组所占内存
	 */
	private static void compareOneArrayToTwoArrayMemory() {
		int num1 = 1024*1024*2;
		int[] arr1 = new int[num1];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = i;
		}
		// 获取占用内存总数，并将单位转为MB
		long memory1 = Runtime.getRuntime().totalMemory()/1024/1024;
		System.out.println("一维数组占用内存数：" + memory1);
		int num2 = 1024*1024;
		int[][] arr2 = new int[num2][2];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i][0] = i;
			arr2[i][1] = i;
		}
		long memory2 = Runtime.getRuntime().totalMemory()/1024/1024;
		System.out.println("二维数组占用的内存数：" + memory2);
	}
	
	/**
	 * 插入排序
	 */
	private static void insertSort() {
		int[] arr = new int[]{20, 1, 34, 56, 3, 45, 120};
		System.out.println("插入排序前：");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		int temp;
		int j;
		for (int i = 1; i < arr.length; i++) {
			temp = arr[i];
			for (j = i-1; j >= 0 && arr[j] > temp; j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = temp;
		}
		System.out.println("\n插入排序后：");
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
 
	/**
	 * 冒泡排序
	 */
	private static void bubbleSort() {
		int[] arr = new int[]{12, 3, 45, 21, 1};
		System.out.println("\n冒泡排序的过程是：");
		int temp;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
				System.out.print(arr[j] + " ");
			}
			System.out.print("【");
			for (int j = arr.length - i; j < arr.length; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println("】");
		}
	}
	
	/**
	 * 输入九宫格
	 */
	private static void nineTable() {
		int[][] arr = new int[3][3];// 三阶方阵
		int a = 2;// 第三行的行下标
		int b = 3/2;// 第二列的列下标
		for (int i = 1; i <= 9; i++) {// 数组赋值
			arr[a++][b++] = i;
			if (i % 3 == 0) {// 如果i是3的倍数
				a = a -2;
				b = b -1;
			} else {
				a = a % 3;
				b = b % 3;
			}
		}
		System.out.println("输入九宫格：");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
}
