package com.bjsxt.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bjsxt.dao.UserDao;
import com.bjsxt.po.User;
import com.bjsxt.service.UserService;
import com.bjsxt.service.impl.UserServiceImpl;

@Component
@Scope("prototype")
public class UserAction {
	
	@Resource
	private UserDao userDao;
	private User user;
	private Integer id;
	private List<User> list;
	private String username;
	private String flag;
	private UserService userService = new UserServiceImpl();

	/**
	 * 存取款管理
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public String transfer() throws Exception{
		this.userService.transferMoney(1,2,1000);
		return null;
	}
	
	/**
	 * 主方法       测试
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		UserAction action = (UserAction) ac.getBean("userAction");
		System.out.println(action.getUserService().getClass().getName());
		action.transfer();
	}
	
	/**
	 * 验证用户名是否存在
	 * @return
	 * @throws Exception
	 */
	public String checkName() throws Exception{
//		List<User> list = this.userDao.checkName(username);
//		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
//			User user = (User) iterator.next();
//			if(user.getName().equals(username)){
//				this.flag = "false";
//			}else{
//				this.flag = "true";
//			}
//		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		if("xiaogao".equals(username)){
			response.getWriter().write("false");
		}else{
			response.getWriter().write("true");
		}
		response.getWriter().close();
		return null;
	}
	
	/**
	 * 保存方法
	 * @return
	 * @throws Exception
	 */
	public String save() throws Exception{
		this.userDao.save(this.user);
		return "list";
	}
	
	/**
	 * 获取所有的用户信息
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception{
		this.list = this.userDao.findAll();
		return "success";
	}
	
	/**
	 * 预修改的方法
	 * @return
	 * @throws Exception
	 */
	public String preUpdate() throws Exception{
		this.user = this.userDao.findById(this.id);
		return "update";
	}
	
	/**
	 * 真正的修改方法
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception{
		User u = this.userDao.findById(this.id);
		u.setName(this.user.getName());
		u.setPhone(this.user.getPhone());
		u.setAddress(this.user.getAddress());
		u.setMoney(this.user.getMoney());
		this.userDao.update(u);
		return "list";
	}
	
	/**
	 * 删除方法
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception{
		User u = this.userDao.findById(this.id);
		this.userDao.del(u);
		return "list";
	}
	
	
	/**
	 * getter和setter 方法
	 * @return
	 */
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
