package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.dao.PositionDao;
import com.bjsxt.dao.impl.PositionDaoImpl;
import com.bjsxt.model.Position;
import com.bjsxt.utils.CommonUtils;

public class PositionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	PositionDao pdao = new PositionDaoImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String method = request.getParameter("method");
		if("save".equals(method)){
			save(request,response);
		}else if("getList".equals(method)){
			getList(request,response);
		}else if("preUpdate".equals(method)){
			preUpdate(request,response);
		}else if("update".equals(method)){
			update(request,response);
		}else if("delete".equals(method)){
			delete(request,response);
		}
	}
	/**
	 * 获取列表中的数据
	 * @param request
	 * @param response
	 */
	private void getList(HttpServletRequest request,HttpServletResponse response) {
		try {
			//查询列表信息
			List<Position> pList = this.pdao.findAll();
			request.setAttribute("pList",pList);
			//请求转发
			request.getRequestDispatcher("jsp/position/position_list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 保存方法
	 * @param request
	 * @param response
	 */
	private void save(HttpServletRequest request, HttpServletResponse response) {
		try {
			//获取form表单中的内容
			String name        = CommonUtils.changeUTF8(request.getParameter("name"));
			String level 	   = request.getParameter("level");
			String description = CommonUtils.changeUTF8(request.getParameter("description"));
			
			//设置对象
			Position p = new Position();
			p.setName(name);
			p.setLevel(level);
			p.setDescription(description);
			
			//保存信息，即进行持久化操作
			this.pdao.save(p);
			
			//重定向
			response.sendRedirect("PositionServlet?method=getList");
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * 预更新
	 * @param request
	 * @param response
	 */
	private void preUpdate(HttpServletRequest request,HttpServletResponse response) {
		try {
			/**
			 * 通过id获取对象，并且设置到request作用域中
			 */
			/*
			String id = request.getParameter("id");
			Position p = this.pdao.findById(Integer.parseInt(id));
			//把获取的指定对象设置到request作用域中
			request.setAttribute("position",p);
			*/
			request.setAttribute("position", pdao.findById(Integer.parseInt(request.getParameter("id"))));
			//请求转发
			request.getRequestDispatcher("jsp/position/position_update.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 真正的更新方法
	 * @param request
	 * @param response
	 */
	private void update(HttpServletRequest request, HttpServletResponse response) {
		try {
			/**
			 * 根据id获取指定的对象
			 */
			Position p         = this.pdao.findById(Integer.parseInt(request.getParameter("id")));
			
			//获取form表单的内容
			String name        = CommonUtils.changeUTF8(request.getParameter("name"));
			String level       = request.getParameter("level");
			String description = CommonUtils.changeUTF8(request.getParameter("description"));
			
			//重新赋值
			p.setName(name);
			p.setLevel(level);
			p.setDescription(description);
			
			//进行持久化操作
			this.pdao.update(p);
			
			//重定向
			response.sendRedirect("PositionServlet?method=getList");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除表中的数据
	 * @param request
	 * @param response
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		try {
			/**
			 * 利用表单提交参数获取
			 */
			String[] ids = request.getParameterValues("ids");
			for (int i = 0; i < ids.length; i++) {
				pdao.delete(Integer.parseInt(ids[i]));
			}
			//重定向到getList方法
			response.sendRedirect("PositionServlet?method=getList");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
