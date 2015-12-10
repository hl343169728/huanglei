package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.dao.EmployeeDao;
import com.bjsxt.dao.PositionDao;
import com.bjsxt.dao.impl.EmployeeDaoImpl;
import com.bjsxt.dao.impl.PositionDaoImpl;
import com.bjsxt.model.Employee;
import com.bjsxt.model.Position;
import com.bjsxt.utils.CommonUtils;
import com.bjsxt.utils.Md5Encrypt;

public class EmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private PositionDao pdao = new PositionDaoImpl();
	private EmployeeDao edao = new EmployeeDaoImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String method = request.getParameter("method");

		if ("preSave".equals(method)) {
			preSave(request, response);
		} else if ("save".equals(method)) {
			save(request, response);
		} else if ("getList".equals(method)) {
			getList(request, response);
		} else if ("preUpdate".equals(method)) {
			preUpdate(request, response);
		} else if ("update".equals(method)) {
			update(request, response);
		} else if ("delete".equals(method)) {
			delete(request, response);
		} else if ("login".equals(method)) {
			login(request, response);
		}
	}

	/**
	 * 用户登录
	 * 
	 * @param request
	 * @param response
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) {
		try {
			String username = CommonUtils.changeUTF8(request.getParameter("username"));
			String password = Md5Encrypt.md5(request.getParameter("password"));
			Employee e = this.edao.findNameAndPassword(username, password);
			if (e != null) {
				request.getSession().setAttribute("loginUser", e);
				response.sendRedirect("jsp/facade/work.jsp");
			} else {
				request.setAttribute("error", "用户名或密码不正确！");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取列表中的数据
	 * 
	 * @param request
	 * @param response
	 */
	@SuppressWarnings("rawtypes")
	private void getList(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			/*
			 * List<Position> pList = new ArrayList<Position>(); List<Employee>
			 * eList = this.edao.findAll(); for (Iterator iterator =
			 * eList.iterator(); iterator.hasNext();) { Employee employee =
			 * (Employee) iterator.next(); Position p =
			 * this.pdao.findById(Integer.parseInt(employee.getP_id()));
			 * pList.add(p); } request.setAttribute("eList",eList);
			 * request.setAttribute("pList",pList);
			 */

			List<Map> list = this.edao.findEmpList();
			request.setAttribute("list", list);
			request.getRequestDispatcher("jsp/employee/employee_list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 预保存方法
	 * 
	 * @param request
	 * @param response
	 */
	private void preSave(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Position> pList = this.pdao.findAll();
			request.setAttribute("pList", pList);
			request.getRequestDispatcher("jsp/employee/employee_add.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 保存方法
	 * 
	 * @param request
	 * @param response
	 */
	private void save(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 获取表单内部的所有参数
			String name = CommonUtils.changeUTF8(request.getParameter("name"));
			String password = Md5Encrypt.md5(request.getParameter("password"));
			String salary = request.getParameter("salary");
			String tell = request.getParameter("tell");
			String birthday = request.getParameter("birthday");
			String hiredate = request.getParameter("hiredate");
			String pid = request.getParameter("pid");

			// 创建对象，设置参数内容
			Employee e = new Employee();
			e.setName(name);
			e.setPassword(password);
			e.setSalary(salary);
			e.setTell(tell);
			e.setBirthday(birthday);
			e.setHiredate(hiredate);
			e.setP_id(pid);

			// 进行持久化操作
			this.edao.save(e);

			// 重定向
			response.sendRedirect("EmployeeServlet?method=getList");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 预修改方法
	 * 
	 * @param request
	 * @param response
	 */
	private void preUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			/**
			 * 通过id获取对象
			 */
			String id = request.getParameter("id");
			Employee e = this.edao.findById(Integer.parseInt(id));
			List<Position> pList = this.pdao.findAll();
			// 设置到request作用域中
			request.setAttribute("emp", e);
			request.setAttribute("pList", pList);
			request.getRequestDispatcher("jsp/employee/employee_update.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 真正的修改方法
	 * 
	 * @param request
	 * @param response
	 */
	private void update(HttpServletRequest request, HttpServletResponse response) {
		try {
			/**
			 * 根据id获取指定的对象
			 */
			Employee e = this.edao.findById(Integer.parseInt(request.getParameter("id")));
			// 获取表单内部的所有参数
			String name = CommonUtils.changeUTF8(request.getParameter("name"));
			String salary = request.getParameter("salary");
			String tell = request.getParameter("tell");
			String birthday = request.getParameter("birthday");
			String hiredate = request.getParameter("hiredate");
			String pid = request.getParameter("pid");

			// 设置参数内容
			e.setName(name);
			e.setSalary(salary);
			e.setTell(tell);
			e.setBirthday(birthday);
			e.setHiredate(hiredate);
			e.setP_id(pid);

			// 进行持久化操作
			this.edao.update(e);

			// 重定向
			response.sendRedirect("EmployeeServlet?method=getList");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除数据
	 * 
	 * @param request
	 * @param response
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		try {
			String[] ids = request.getParameterValues("ids");
			for (int i = 0; i < ids.length; i++) {
				this.edao.delete(Integer.parseInt(ids[i]));
			}
			// 重定向到getList方法
			response.sendRedirect("EmployeeServlet?method=getList");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}