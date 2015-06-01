package com.hz.sunday.xccf.web.weixin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.javafans.web.AjaxUtils;
import org.javafans.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hz.sunday.xccf.bo.TicketMemberBO;
import com.hz.sunday.xccf.orm.TicketMemberBean;

/**
 * 微信端报名管理
 * 
 * @author huanglei
 * @date 2015年4月27日 下午2:07:40
 * @version V1.0
 */
@Controller
@RequestMapping(value = "/xccf/wechat")
public class RegisterController extends BaseController {
	
	/** 报名页面*/
	private static final String SING_UP_PAGE = "/wechat/signup";
	/** 成功页面*/
	private static final String SUCCESS_PAGE = "/wechat/success";

	@Autowired
	private TicketMemberBO ticketMemberBO;
	
	/**
	 * 报名页面
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/signup")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		return SING_UP_PAGE;
	}
	
	/**
	 * 成功后，跳转的页面
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/success")
	public String success(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		return SUCCESS_PAGE;
	}

	/**
	 * 保存
	 * 
	 * @param member
	 * @param request
	 * @param response
	 */
	@RequestMapping("/save")
	public void doRegis(TicketMemberBean member, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (StringUtils.isBlank(member.getName())) {
				AjaxUtils.renderText(response, "-2"); // 姓名不能用为空
				return;
			}
			if (StringUtils.isBlank(member.getCompany())) {
				AjaxUtils.renderText(response, "-3"); // 公司不能用为空
				return;
			}
			if (StringUtils.isBlank(member.getPost())) {
				AjaxUtils.renderText(response, "-4"); // 职务不能用为空
				return;
			}
			if (StringUtils.isBlank(member.getPhone())) {
				AjaxUtils.renderText(response, "-5"); // 手机号不能用为空
				return;
			}
			if (StringUtils.isBlank(member.getGoal())) {
				AjaxUtils.renderText(response, "-6"); // 意向不能用为空
				return;
			}
			if (null == member.getNumber()) {
				AjaxUtils.renderText(response, "-7"); // 人数不能用为空
				return;
			}

			boolean isExist = ticketMemberBO.isExist(member.getPhone());
			if (isExist) {
				AjaxUtils.renderText(response, "-8"); // 该手机号已存在
				return;
			}
			ticketMemberBO.insert(member); // 执行报名操作
			request.getSession().setAttribute("member", member); // 将报名人员基本信息放入内存中
			AjaxUtils.renderText(response, "1"); // 报名成功
		} catch (Exception e) {
			e.printStackTrace();
			AjaxUtils.renderText(response, "-1"); // 报名失败，未知原因
		}
	}

}
