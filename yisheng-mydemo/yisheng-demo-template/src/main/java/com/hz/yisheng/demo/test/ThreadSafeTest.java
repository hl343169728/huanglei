package com.hz.yisheng.demo.test;

public class ThreadSafeTest implements Runnable {

	public static void main(String[] args) {
		ThreadSafeTest safe = new ThreadSafeTest();
		Thread t1 = new Thread(safe);
		Thread t2 = new Thread(safe);
		Thread t3 = new Thread(safe);
		Thread t4 = new Thread(safe);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

	int num = 10;
	
	@Override
	public void run() {
		while(true) {
			synchronized ("") {// 线程同步  同步块
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
	}
	
	
}
