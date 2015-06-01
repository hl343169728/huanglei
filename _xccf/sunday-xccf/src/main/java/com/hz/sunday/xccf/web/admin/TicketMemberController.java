package com.hz.sunday.xccf.web.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javafans.common.utils.query.QueryParamUtils;
import org.javafans.dto.page.Page;
import org.javafans.web.AjaxUtils;
import org.javafans.web.JSONUtils;
import org.javafans.web.JsonPageUtils;
import org.javafans.web.controller.BaseController;
import org.javafans.web.springmvc.controller.WebControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hz.sunday.xccf.bo.TicketMemberBO;
import com.hz.sunday.xccf.orm.TicketMemberBean;

/**
 * 报名管理
 * 
 * @author huanglei
 * @date 2015年4月14日
 * @version V1.0
 */
@Controller
@RequestMapping(value = "/admin/ticket")
public class TicketMemberController extends BaseController {

	@Autowired
	private TicketMemberBO ticketMemberBO;

	/**
	 * 获取分页数据
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		final Map<String, Object> sqlMap = QueryParamUtils.builderQueryMap(request);// 组装查询参数
		Page<TicketMemberBean> page = WebControllerUtils.preparePage(request, 10);// 组装page对象
		page = ticketMemberBO.pageQuery(page, sqlMap);
		JsonPageUtils.renderJsonPage(page.getTotalCount(), page.getResult(), response);
	}

	/**
	 * 新增
	 * 
	 * @param ticketMemberBean
	 * @param request
	 * @param response
	 */
	@RequestMapping("/add")
	public void add(@ModelAttribute TicketMemberBean ticketMemberBean,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			ticketMemberBO.insert(ticketMemberBean);
			JSONUtils.objToJSON(response, 1);
		} catch (Exception e) {
			e.printStackTrace();
			JSONUtils.objToJSON(response, 0);
		}
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping("/deleteById")
	public void deleteById(@RequestParam("id") Long id,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			ticketMemberBO.deleteById(id);
			AjaxUtils.renderText(response, "1");// 删除成功
		} catch (Exception e) {
			e.printStackTrace();
			AjaxUtils.renderText(response, "0");// 删除失败
		}
	}
}
