package com.hz.yisheng.demo.test;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class JFrameDemo {

	public static void main(String[] args) {
		createJFrame("创建一个JFrame窗体");
	}
	
	/**
	 * 创建一个JFrame窗体
	 * @param title
	 */
	private static void createJFrame(String title) {
		JFrame jFrame = new JFrame();
		Container container = jFrame.getContentPane();
		JLabel jLabel = new JLabel("这是一个JFrame窗体");
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(jLabel);
		container.setBackground(Color.white);
		
		jFrame.setVisible(true);
		jFrame.setSize(200, 150);
		jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	
}
