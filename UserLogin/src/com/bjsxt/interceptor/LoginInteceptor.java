package com.bjsxt.interceptor;

import java.util.Map;

import com.bjsxt.po.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInteceptor implements Interceptor{

	/**
	 * 初始化方法
	 */
	public void init() {
		System.out.println("初始化了......");
	}

	/**
	 * 拦截器方法
	 */
	@SuppressWarnings("unchecked")
	public String intercept(ActionInvocation ai) throws Exception {
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> session = ac.getSession();
		Map<String,Object> request =(Map<String,Object>)ac.get("request");
		String method = ai.getProxy().getMethod();			//方法
		String actionName = ai.getProxy().getActionName();	//获取当前的action的名称
		System.out.println(actionName +"_"+ method);
		User user = (User) session.get("user");				//获取用户
		if(user == null){									//如果当前的用户为null
			if("login".equals(method)){//再判断当前的方法是不是login方法，如果是的话，继续往下执行
				return ai.invoke();
			}else{//否则，弹出信息“请先登录”,提醒用户再次登录
				request.put("error","请先登录！！！");
				return "login";
			}
		}else{//如果当前的用户不用空，直接往下执行
			return ai.invoke();
		}
	}
	
	/**
	 * 销毁方法
	 */
	public void destroy() {
		
	}
}
