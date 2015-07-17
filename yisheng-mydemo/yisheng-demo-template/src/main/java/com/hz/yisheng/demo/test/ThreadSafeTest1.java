package com.hz.yisheng.demo.test;

public class ThreadSafeTest1 extends Thread {

	public static void main(String[] args) {
		ThreadSafeTest1 safe = new ThreadSafeTest1();
		safe.start();
	}
	
	int num = 10;
	
	public synchronized void doit() {
		while(true) {
			if (num > 0) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("车票还有 " + num-- + " 张");
			}
		}
	}
	
	public void run() {
		while(true) {
			doit();
		}
	}
}
