package com.sxt.manager.action;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.sxt.manager.model.User;
import com.sxt.manager.service.UserService;
import com.sxt.manager.service.impl.UserServiceImpl;

public class UserAction extends BaseAction{

	private UserService userService = new UserServiceImpl();
	
	/**
	 * 生成账号的方法 
	 * @return
	 * @throws Exception
	 */
	public String createAccount() throws Exception{
		
		String empId = this.request.getParameter("empId");
		//根据empId判断当前人员是否已经生成过账号
		if(this.userService.exsitsAccount(Integer.parseInt(empId))){
			this.myWriter("1");		
		} else {
			User user = this.userService.createAccount(Integer.parseInt(empId));
			this.myWriter(JSONArray.fromObject(user).toString());			
		}
		return NONE;
	}
	
	
	/**
	 * 用户登录方法
	 */
	public String login() throws Exception{
		String username = this.request.getParameter("uname");
		String password = this.request.getParameter("pwd");
		User user = this.userService.loginUser(username ,password);
		if(user != null){
			this.session.setAttribute("loginUser", user);
			return "WORK";
		} else {
			this.request.setAttribute("msg", "用户名或密码不正确!");
			return "LOGIN";
		}
	}
	
	/**
	 * 用户修改密码
	 * @return
	 * @throws Exception
	 */
	public String updatePassword() throws Exception {
			
		String pwd = this.request.getParameter("pwd1");
		User user = (User)this.session.getAttribute("loginUser");
		user.setPwd(pwd);
		this.userService.update(user);
		session.removeAttribute("loginUser");
		User newUser = this.userService.findById(user.getId());
		session.setAttribute("loginUser", newUser);
		this.request.setAttribute("url", "jsp/user/user_updatepassword.jsp");
		return "SUCCESSPAGE";
	}
	
	/**
	 * 查询user列表方法 
	 * @return
	 * @throws Exception
	 */
	public String getUserList() throws Exception{
		
		 String currentPage = this.request.getParameter("page");		//当前页
		 String pageSize    = this.request.getParameter("rows");		//每页显示记录数
		 List<Map> userlist = this.userService.findUserList(currentPage,pageSize);
		 int total = this.userService.getTotal();
		 String json = "{\"total\": "+ total + " , \"rows\": " +JSONArray.fromObject(userlist).toString()+"}" ;
		 this.myWriter(json);
		 return NONE;
	}
	
	public String logoutAndStart() throws Exception {
		String flag = this.request.getParameter("flag");
		User user = this.userService.findById(this.id);
		if("1".equals(flag)){
			user.setState("注销");
		} else {
			user.setState("有效");
		}
		this.userService.update(user);
		this.request.setAttribute("url", "jsp/user/user_list.jsp");
		return "SUCCESSPAGE";
	}
	
	
	
	
	
	
}
