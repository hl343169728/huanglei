package com.hz.yisheng.demo.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class IODemo {

	public static void main(String[] args) {
		
		fileTest();
		fileTest2();
		fileTest3();
		deleteFile(new File("D:/myword"));
		fileTest4();
		fileTest5();
		zipTest();
	}
	
	/**
	 * 文件存在则删除，否则创建文件
	 */
	private static void fileTest() {
		File file = new File("D:/myword","word.txt");
		if (file.exists()) {
			file.delete();
			System.out.println("文件被删除~");
		} else {
			try {
				file.createNewFile();
				System.out.println("文件被创建~");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 获取文件信息
	 */
	private static void fileTest2() {
		File file = new File("D:/myword", "word.txt");
		if (file.exists()) {
			System.out.println("文件名称：" + file.getName());
			System.out.println("文件长度：" + file.length());
			System.out.println("是否隐藏文件：" + file.isHidden());
			System.out.println("是否可读：" + file.canRead());
			System.out.println("是否可写：" + file.canWrite());
			System.out.println("是否可执行：" + file.canExecute());
			System.out.println("绝对路径：" + file.getAbsolutePath());
			System.out.println("父路径：" + file.getParent());
			System.out.println("是否文件：" + file.isFile());
			System.out.println("是否目录：" + file.isDirectory());
			System.out.println("最后修改时间：" + file.lastModified());
		} else {
			System.out.println("文件不存在~");
		}
	}
	
	/**
	 * 文件的读取，写入
	 */
	private static void fileTest3() {
		File file = new File("D:/myword", "word.txt");
		if (file.exists()) {
			System.out.println("写入文件~");
			FileOutputStream fos = null;
			try {
			    fos = new FileOutputStream(file);
				byte[] b = "易盛科技 JAVA 产品研发部门".getBytes();
				fos.write(b);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					fos.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			System.out.println("读取文件~");
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(file);
				byte[] b = new byte[1024];
				int len = fis.read(b);
				System.out.println("文件中的信息是：" + new String(b, 0, len));
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					fis.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		} else {
			System.out.println("文件不存在~");
		}
	}
	
	/**
	 * 删除文件夹中的所有的文件
	 * 
	 * @param file
	 */
	private static void deleteFile(File file) {
		if (file.isFile()) {
			file.delete();
		} else {
			File[] files = file.listFiles();
			for (File f : files) {
				if (f.isFile()) {
					f.delete();
				} else {
					deleteFile(f);
				}
			}
		}
		System.out.println("删除成功~");
	}
	
	/**
	 * 文件写入与读取
	 */
	private static void fileTest4() {
		String[] content = new String[]{"天下第一武道大会", "少林，武当，崆峒，昆仑，逍遥", "大力金刚指，凌波微步"};
		File file = new File("D:/myword/word1.txt");
		if (file.exists()) {
			System.out.println("写入文件~");
			FileWriter fw = null;
			BufferedWriter bw = null;
			try {
				fw = new FileWriter(file);
				bw = new BufferedWriter(fw);
				for (int i = 0; i < content.length; i++) {
					bw.write(content[i]);
					bw.newLine();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					bw.close();
					fw.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			System.out.println("读取文件~");
			FileReader fr = null;
			BufferedReader br = null;
			String s = null;
			int i = 0;
			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				while((s = br.readLine()) != null) {
					i ++;
					System.out.println("第" + i + "行:" + s);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					br.close();
					fr.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}  else {
			System.out.println("文件不存在~");
		}
	}
	
	/**
	 * 数据输入/输出
	 */
	@SuppressWarnings("static-access")
	private static void fileTest5() {
		File file = new File("D:/myword/word2.txt");
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		FileInputStream fis = null;
		DataInputStream dis = null;
		try {
			if (file.exists()) {
				System.out.println("写入文件~");
				fos = new FileOutputStream(file);
				dos = new DataOutputStream(fos);
				dos.writeUTF("使用 writeUTF() 方法写入数据~");
				dos.writeChars("使用 writeChars() 方法写入数据~");
				dos.writeBytes("使用 writeBytes() 方法写入数据~");
				dos.close();
				
				System.out.println("读取文件~");
				fis = new FileInputStream(file);
				dis = new DataInputStream(fis);
				System.out.println(dis.readUTF(dis));
			} else {
				System.out.println("文件不存在~");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 压缩文件
	 */
	private static void zipTest() {
		File file = new File("D:/myword");
		try {
			if (file.exists()) {
				zip("D:/work.zip", file);
				System.out.println("压缩完成~");
			} else {
				System.out.println("文件不存在~");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 文件压缩
	 * @param zipFileName
	 * @param inputFile
	 * @throws Exception
	 */
	private static void zip(String zipFileName, File file) throws Exception {
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
		zip(out, file, "");
		System.out.println("文件压缩中...");
		out.close();
	}

	// 方法重载
	private static void zip(ZipOutputStream out, File file, String base) throws Exception {
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			out.putNextEntry(new ZipEntry(base + "/"));// 写入此目录的entry
			base = base.length() == 0 ? "" : base + "/";
			for (int i = 0; i < files.length; i++) {
				zip(out, files[i], base);
			}
		} else {
			out.putNextEntry(new ZipEntry(base));
			FileInputStream in = new FileInputStream(file);
			int b = 0;
			System.out.println(base);
			while((b = in.read()) != -1) {
				out.write(b);
			}
			in.close();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
