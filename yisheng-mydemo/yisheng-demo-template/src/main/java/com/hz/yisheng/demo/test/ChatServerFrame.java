package com.hz.yisheng.demo.test;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

import javax.swing.JFrame;

public class ChatServerFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private ServerSocket server;
	private Socket socket;
	ServerThread serverThread;
	private Hashtable<String, Socket> map = new Hashtable<String, Socket>();
	
	public void createSocket() {
		try {
			server = new ServerSocket(9898);
			System.out.println("等待新客户连接......\n");
			socket = server.accept();
			System.out.println("客户端连接成功。" + socket + "\n");
			serverThread = new ServerThread(socket);
			serverThread.start();;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class ServerThread extends Thread {
	
	public ServerThread(Socket socket) {
		
	}
}
