package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.dao.StudentDao;
import com.bjsxt.dao.impl.StudentDaoImpl;
import com.bjsxt.model.Student;
import com.bjsxt.utils.CommonUtils;

public class StudentServlet extends HttpServlet {
	
	StudentDao sdao = new StudentDaoImpl();

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
	 * 查询学生列表信息
	 * @param request
	 * @param response
	 */
	private void getList(HttpServletRequest request,HttpServletResponse response) {
		try {
			//根据dao层， 查询所有学员的列表信息
			List<Student> sList = sdao.findAll();
			//设置request范围内的参数
			request.setAttribute("sList",sList);
			//利用请求转发，forward到指定的JSP页面--->student_list.jsp
			request.getRequestDispatcher("jsp/student/student_list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 保存学生信息
	 * @param request
	 * @param response
	 */
	private void save(HttpServletRequest request, HttpServletResponse response) {
		try {
			//获取表单内部的所有的参数
			String studentname   = CommonUtils.changeUTF8(request.getParameter("studentname"));
			String cardId        = request.getParameter("cardId");
			String birthday      = CommonUtils.changeUTF8(request.getParameter("birthday"));
			String sex           = request.getParameter("sex");
			String favorite      = request.getParameter("favorite");
			String university    = CommonUtils.changeUTF8(request.getParameter("university"));
			String nationality   = CommonUtils.changeUTF8(request.getParameter("nationality"));
			String constellation = CommonUtils.changeUTF8(request.getParameter("constellation"));
			
			//创建学员对象 ，设置相应的参数内容
			Student s = new Student();
			s.setName(studentname);
			s.setCardId(cardId);
			s.setBirthday(birthday);
			s.setSex(sex);
			s.setFavorite(favorite);
			s.setUniversity(university);
			s.setNationality(nationality);
			s.setConstellation(constellation);
			
			//保存学员数据信息，即进行持久化操作
			this.sdao.save(s);
			
			//去重定向到查询列表方法
			response.sendRedirect("StudentServlet?method=getList");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 预修改阶段
	 * @param request
	 * @param response
	 */
	private void preUpdate(HttpServletRequest request,HttpServletResponse response) {
		try {
			/**
			 * 通过从前台获取id，根据id查询指定要修改的student对象
			 */
			String id = request.getParameter("id");
			Student s = this.sdao.findById(Integer.parseInt(id));
			//request注入要修改的对象
			request.setAttribute("s",s);
			//请求转发
			request.getRequestDispatcher("jsp/student/student_update.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *真正要修改的方法 
	 * @param request
	 * @param response
	 */
	private void update(HttpServletRequest request, HttpServletResponse response) {
		try {
			/**
			 * 通过id取得当前要修改的对象（数据库里原先的对象）
			 */
			String id = request.getParameter("id");
			Student s = sdao.findById(Integer.parseInt(id));
			/**
			 * 取得修改页面上所有的参数内容，对student对象属性进行重新的赋值
			 */
			String studentname   = CommonUtils.changeUTF8(request.getParameter("studentname"));
			String cardId        = request.getParameter("cardId");
			String birthday      = CommonUtils.changeUTF8(request.getParameter("birthday"));
			String sex           = request.getParameter("sex");
			String favorite      = request.getParameter("favorite");
			String university    = CommonUtils.changeUTF8(request.getParameter("university"));
			String nationality   = CommonUtils.changeUTF8(request.getParameter("nationality"));
			String constellation = CommonUtils.changeUTF8(request.getParameter("constellation"));
			
			//重新设置参数内容
			s.setName(studentname);
			s.setCardId(cardId);
			s.setBirthday(birthday);
			s.setSex(sex);
			s.setFavorite(favorite);
			s.setUniversity(university);
			s.setNationality(nationality);
			s.setConstellation(constellation);
			
			//更新学员数据，即进行持久化操作
			this.sdao.update(s);
			
			//去重定向到查询列表方法
			response.sendRedirect("StudentServlet?method=getList");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 根据id删除一个指定的对象
	 * @param request
	 * @param response
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		try {
			/**
			 * 根据取得的id，删除指定的对象
			 */
			String id = request.getParameter("id");
			this.sdao.delete(Integer.parseInt(id));
			
			//重定向，跳转到列表页面
			response.sendRedirect("StudentServlet?method=getList");	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
