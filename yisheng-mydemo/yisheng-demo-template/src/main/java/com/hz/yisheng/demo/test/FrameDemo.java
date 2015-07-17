package com.hz.yisheng.demo.test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class FrameDemo extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel jContentPanel = null;
	private JTextArea jTextArea = null;
	private JPanel controlPanel = null;
	private JButton openButton  = null;
	private JButton closeButton = null;
	
	public FrameDemo() {
		super();
		initialize();
	}
	
	@SuppressWarnings("unused")
	private JButton getOpenButton() {
		if (openButton == null) {
			openButton = new JButton();
			openButton.setText("写入文本~");
			openButton.addActionListener(new java.awt.event.ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					File file = new File("D:/myword/word.txt");
					FileWriter out = null;
					try {
					    out = new FileWriter(file);
						String s = jTextArea.getText();
						out.write(s);
					} catch (Exception e2) {
						e2.printStackTrace();
					} finally {
						try {
							out.close();
						} catch (Exception e3) {
							e3.printStackTrace();
						}
					}
				}
				
			});
		}
		return openButton;
	}
	
	@SuppressWarnings("unused")
	private JButton getCloseButton() {
		if (null == closeButton) {
			closeButton = new JButton();
			closeButton.setText("读取文本~");
			openButton.addActionListener(new java.awt.event.ActionListener(){

				@SuppressWarnings("null")
				@Override
				public void actionPerformed(ActionEvent e) {
					File file = new File("D:/myword/word.txt");
					FileReader in = null;
					try {
						char[] c = new char[1024];
						int len = in.read(c);
						jTextArea.setText(new String(c, 0, len));
					} catch (Exception e2) {
						e2.printStackTrace();
					} finally {
						try {
							in.close();
						} catch (Exception e3) {
							e3.printStackTrace();
						}
					}
				}
				
			});
		}
		return closeButton;
	}
	
	private void initialize() {
		this.setSize(300, 200);
		this.setContentPane(getJContentPanel());
		this.setTitle("JFrame");
	}
	
	private JPanel getJContentPanel() {
		if (null == jContentPanel) {
			jContentPanel = new JPanel();
			jContentPanel.setLayout(new BorderLayout());
			jContentPanel.add(getJTextArea(), BorderLayout.CENTER);
			jContentPanel.add(getControlPanel(), BorderLayout.SOUTH);
		}
		return jContentPanel;
	}

	private JPanel getControlPanel() {
		if (null == controlPanel) {
			controlPanel = new JPanel();
		}
		return controlPanel;
	}

	private JTextArea getJTextArea() {
		if (null == jTextArea) {
			jTextArea = new JTextArea();
		}
		return jTextArea;
	}
	
	public static void main(String[] args) {
		FrameDemo f = new FrameDemo();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
}
