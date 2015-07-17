package com.hz.yisheng.demo.test;

public class EmergencyThread implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 6; i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("紧急情况：" + i + "号车出发~");
		}
	}

}
