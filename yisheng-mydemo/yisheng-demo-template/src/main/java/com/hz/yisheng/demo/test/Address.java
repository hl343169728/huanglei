package com.hz.yisheng.demo.test;

import java.net.InetAddress;

public class Address {

	public static void main(String[] args) {
		
		InetAddress ip = null;
		try {
			ip = InetAddress.getLocalHost();
			System.out.println("本地主机名：" + ip.getHostName());
			System.out.println("本地主机IP：" + ip.getHostAddress());
			System.out.println(ip.getAddress());
			System.out.println(ip.getCanonicalHostName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
