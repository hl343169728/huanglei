package com.hz.yisheng.demo.test;

public class JoinThread {

	public static void main(String[] args) {
		Thread t = new Thread(new EmergencyThread());
		t.start();
		
		for (int i = 0; i < 6; i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("正常情况：" + i + "号车出发~");
			try {
				t.join();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
