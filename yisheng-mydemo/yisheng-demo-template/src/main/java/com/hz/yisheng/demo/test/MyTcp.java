package com.hz.yisheng.demo.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端
 * 
 * @author huanglei
 */
public class MyTcp {

	private BufferedReader reader;
	private ServerSocket server;
	private Socket socket;
	
	void getServer() {
		try {
			server = new ServerSocket(8998);
			// server.setSoTimeout(10000);// 设置连接超时时间10秒
			System.out.println("服务器套接字已经创建成功~");
			while(true) {
				System.out.println("等待客户机的链接~");
				socket = server.accept();
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				getClientMessage();
			}
		} catch (Exception e) {
			// System.out.println("连接超时~");
			e.printStackTrace();
		}
	}

	private void getClientMessage() {
		try {
			while(true) {
				System.out.println("客户机：" + reader.readLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (null != reader) {
				reader.close();
			}
			if (null != socket) {
				socket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MyTcp tcp = new MyTcp();
		tcp.getServer();
	}
}
