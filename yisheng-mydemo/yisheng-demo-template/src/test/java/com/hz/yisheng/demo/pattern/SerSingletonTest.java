package com.hz.yisheng.demo.pattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.hz.yisheng.demo.pattern.singleton.SerSingleton;

public class SerSingletonTest {

	public static void main(String[] args) throws Exception {

		SerSingleton s = null;
		SerSingleton s1 = SerSingleton.getInstance();
		// 写入
		FileOutputStream fos = new FileOutputStream("SerSingleton.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s1);
		oos.flush();
		oos.close();

		// 读入
		FileInputStream fis = new FileInputStream("SerSingleton.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		s = (SerSingleton) ois.readObject();
		
		System.out.println(s1.equals(s));
	}
}
