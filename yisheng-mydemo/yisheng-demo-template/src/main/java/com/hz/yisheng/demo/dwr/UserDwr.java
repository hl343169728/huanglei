package com.hz.yisheng.demo.dwr;

import org.apache.log4j.Logger;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hz.yisheng.demo.bo.UserBO;
import com.hz.yisheng.demo.orm.User;

/**
 * 用户信息管理DWR
 * 
 * @author huanglei
 * @date 2015年4月29日 下午4:10:27
 * @version V1.0
 */
@Controller
@RemoteProxy(name = "UserDwr")
public class UserDwr {

	private static Logger log = Logger.getLogger(UserDwr.class);

	@Autowired
	private UserBO userBO;

	/**
	 * 基本调用，参数字符串，返回字符串
	 * 
	 * @param test
	 * @return
	 * @throws Exception
	 */
	@RemoteMethod
	public String sayHello(String str) throws Exception {
		log.info("UserDwr sayHello, test: " + str);
		if (str.equals("error")) {
			throw new Exception("出现异常");
		}
		return "Java: " + str;
	}

	/**
	 * 根据ID，获取信息
	 * 
	 * @param id
	 * @return
	 */
	@RemoteMethod
	public User findById(Long id) {
		try {
			return userBO.findById(id);
		} catch (Exception e) {
			return null;
		}
	}

}
