package com.hz.yisheng.demo.test;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Weather extends Thread{

	String weather = "节目预报：八点有大型晚会，请收听~";
	int port = 9898;
	InetAddress iAddress = null;
	MulticastSocket socket = null;
	
	Weather() {
		try {
			iAddress = InetAddress.getByName("224.255.10.0");
			socket = new MulticastSocket(port);
			socket.setTimeToLive(1);
			socket.joinGroup(iAddress);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		DatagramPacket packet = null;
		while(true) {
			byte[] data = weather.getBytes();
			packet = new DatagramPacket(data, data.length, iAddress, port);
			System.out.println(new String(data));
			try {
				socket.send(packet);
				sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Weather w = new Weather();
		w.start();
	}
}
