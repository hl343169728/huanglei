package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.dao.UserDao;
import com.bjsxt.dao.impl.UserDaoImpl;
import com.bjsxt.model.User;
import com.bjsxt.utils.CommonUtils;

public class UserServlet extends HttpServlet {

	private UserDao udao = new UserDaoImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			String method = request.getParameter("method");
			
			//当值相等时，调用相应的方法
			if("save".equals(method)){
				save(request,response);				
			} else if ("getList".equals(method)){
				getList(request, response);
			} else if ("preUpdate".equals(method)){
				preUpdate(request,response);
			} else if ("update".equals(method)){
				update(request,response);
			} else if ("delete".equals(method)){
				delete(request,response);
			}
	}

	/**
	 * 查询用户列表
	 * @param request
	 * @param response
	 */
	private void getList(HttpServletRequest request,
			HttpServletResponse response) {
			try{				
				//1   根据dao 查询所有用户列表信息
				List<User> userList = udao.findAll();
				//2 设置request范围内的参数
				request.setAttribute("userList", userList);	
				//3利用请求转发 去forward到指定的JSP页面 ： user_list.jsp
				request.getRequestDispatcher("jsp/user/user_list.jsp").forward(request, response);				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * 保存用户信息方法
	 * @param request
	 * @param response
	 */
	@SuppressWarnings("unused")
	private void save(HttpServletRequest request, HttpServletResponse response) {
		try{
			// 1 获取表单内部所有的参数
			String username	 	= CommonUtils.changeUTF8(request.getParameter("username"));
			String password 	= request.getParameter("password");
			String sex      	= request.getParameter("sex");
			String age      	= request.getParameter("age");
			String address  	= request.getParameter("address");
			String tell     	= request.getParameter("tell");	
			String description 	= CommonUtils.changeUTF8(request.getParameter("description"));
			
			
			// 2创建对象 设置参数内容
			User user = new User();
			user.setName(username);
			user.setAge(Integer.parseInt(age));
			user.setPassword(password);
			user.setSex(sex);
			user.setAddress(address);
			user.setDescription(description);
			user.setTell(tell);
			
			// 3 进行持久化操作
			this.udao.save(user);
			
			//去重定向到查询列表方法
			response.sendRedirect("UserServlet?method=getList");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 预修改
	 * @param request
	 * @param response
	 */
	private void preUpdate(HttpServletRequest request,
		HttpServletResponse response) {
		try{
			/**
			 * 通过从前台获取id，根据id查询指定要修改的user对象
			 */
			String id = request.getParameter("id");
			User user = this.udao.findById(Integer.parseInt(id));
			//request注入要修改的对象
			request.setAttribute("user", user);		
			//请求转发
			request.getRequestDispatcher("jsp/user/user_update.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 真正的修改方法
	 * @param request
	 * @param response
	 */
	private void update(HttpServletRequest request, HttpServletResponse response) {
		try{
			/**
			 * 通过id 取得当前要修改的对象 (数据库里原先的对象)
			 */
			String id = request.getParameter("id");
			User user = udao.findById(Integer.parseInt(id));
			/**
			 * 取得修改页面上所有的参数内容 对user对象进行重新赋值
			 */
			String username	 	= CommonUtils.changeUTF8(request.getParameter("username"));
			String password 	= request.getParameter("password");
			String sex      	= request.getParameter("sex");
			String age      	= request.getParameter("age");
			String address  	= request.getParameter("address");
			String tell     	= request.getParameter("tell");	
			String description 	= CommonUtils.changeUTF8(request.getParameter("description"));	
			
			// 重新设置新内容
			user.setName(username);
			user.setAge(Integer.parseInt(age));
			user.setPassword(password);
			user.setSex(sex);
			user.setAddress(address);
			user.setDescription(description);
			user.setTell(tell);
			
			//进行更新操作 持久化操作
			udao.update(user);
			
			//跳转到列表页面
			response.sendRedirect("UserServlet?method=getList");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据id 删除一个指定的对象
	 * @param request
	 * @param response
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		try{
			/**
			 * 根据id取得要删除的对象
			 */
			String id = request.getParameter("id");
			this.udao.delete(Integer.parseInt(id));
			
			//跳转到列表页面
			response.sendRedirect("UserServlet?method=getList");					
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
