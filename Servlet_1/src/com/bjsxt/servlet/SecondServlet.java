package com.bjsxt.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.jdom.xpath.XPath;

public class SecondServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("<-----程序执行了！----->");
		String name = request.getParameter("username");
		String str = new String(name.getBytes("iso8859-1"),"utf-8");
		String pwd = request.getParameter("password");
		System.out.println("姓名："+name+",密码：  "+pwd);
		System.out.println("---->"+str);
		
		try {
			createXML(str, pwd);
			//updateXml();
			//xPath();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *把 用户名及密码写入到XML中
	 * @param str
	 * @param pwd
	 * @throws Exception
	 */
	public static void createXML(String str,String pwd) throws Exception{
		//创建一个根节点
		Element root = new Element("information");
		//创建子节点
		Element n = new Element("name");
		n.setText(str);
		Element p = new Element("password");
		p.setText(pwd);
		
		//把子节点添加到根节点上
		root.addContent(n);
		root.addContent(p);
		
		//建立文档对象
		Document doc = new Document(root);
		//获取漂亮的输出格式
		Format f = Format.getPrettyFormat();
		//设置编码方式
		f.setEncoding("UTF-8");
		//输出
		XMLOutputter xmlOut = new XMLOutputter(f);
		xmlOut.output(doc,new FileOutputStream("d:"+File.separator+"Code(Me)"+File.separator+"XML"+File.separator+"2.xml"));
	}
	
	/**
	 * 可以用SAX对XML中的数据进行修改
	 * @throws Exception
	 */
	public static void updateXml() throws Exception{
		//创建SAXBuilder对象
		SAXBuilder sb = new SAXBuilder();
		//根据sb对象，创建document文档对象，将某一个XML文件读入到doc中
		Document doc = sb.build(new FileInputStream("d:"+File.separator+"Code(Me)"+File.separator+"XML"+File.separator+"2.xml"));
		//对doc进行操作,获取跟节点元素
		Element root = doc.getRootElement();
		//获取子节点
		Element name = root.getChild("name");
		System.out.println(name.getText());//获取姓名
		Element pwd = root.getChild("password");
		System.out.println(pwd.getText());//获取用户密码
		Format f = Format.getPrettyFormat();
		f.setEncoding("UTF-8");
		XMLOutputter xmlOut = new XMLOutputter(f);
		xmlOut.output(doc,new FileOutputStream("d:"+File.separator+"Code(Me)"+File.separator+"XML"+File.separator+"2.xml"));
	}
	/**
	 * 使用XPATH
	 * @throws Exception
	 */
	public static void xPath() throws Exception{
		//创建SAXBuilder对象
		SAXBuilder sb = new SAXBuilder();
		//根据sb对象，创建document文档对象，将某一个XML文件读入到doc中
		Document doc = sb.build(new FileInputStream("d:"+File.separator+"Code(Me)"+File.separator+"XML"+File.separator+"2.xml"));
		//对doc进行操作,获取跟节点元素
		Element root = doc.getRootElement();
		//拿到information下面的所有直接子节点
		XPath xPath = XPath.newInstance("/information/*");
		List list = xPath.selectNodes(root);
		//System.out.println(list.size());//大小
		for (int i = 0; i < list.size(); i++) {
			Element e = (Element)list.get(i);
			System.out.println(e.getText());
		}
	}
}
