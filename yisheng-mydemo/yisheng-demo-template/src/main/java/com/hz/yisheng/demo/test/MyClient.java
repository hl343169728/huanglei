package com.hz.yisheng.demo.test;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 客户端
 * 
 * @author huanglei
 */
public class MyClient extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private PrintWriter writer;
	Socket socket;
	private JTextArea jTextArea = new JTextArea();
	private JTextField jTextField = new JTextField();
	Container container;
	
	public MyClient(String title) {
		super(title);
		container = this.getContentPane();
		container.add(jTextArea, "North");
		container.add(jTextField, "South");
		
		jTextField.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				writer.println(jTextField.getText());
				jTextArea.append(jTextField.getText() + "\n");
				jTextField.setText(" ");
			}
			
		});
	}
	
	private void connect() {
		jTextArea.append("尝试连接\n");
		try {
			socket = new Socket("192.168.1.121", 8998);
			writer = new PrintWriter(socket.getOutputStream(), true);
			jTextArea.append("连接成功\n");
			
			InetAddress netAddress =  socket.getInetAddress();
			String netIp = netAddress.getHostAddress();
			int netPort = socket.getPort();
			System.out.println("远程服务器IP地址：" + netIp);
			System.out.println("远程服务器端口：" + netPort);
			
			InetAddress localAddress = socket.getLocalAddress();
			String localIp = localAddress.getHostAddress();
			int localPort = socket.getPort();
			System.out.println("本地客户机IP地址：" + localIp);
			System.out.println("本地客户机端口：" + localPort);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MyClient client = new MyClient("向服务器发送数据~");
		client.setBounds(300, 260, 340, 220);
		client.setVisible(true);
		client.connect();
	}
}
