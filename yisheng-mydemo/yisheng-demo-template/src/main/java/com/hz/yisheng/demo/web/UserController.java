package com.hz.yisheng.demo.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javafans.common.utils.query.QueryParamUtils;
import org.javafans.dto.page.Page;
import org.javafans.web.JSONUtils;
import org.javafans.web.JsonPageUtils;
import org.javafans.web.controller.BaseController;
import org.javafans.web.springmvc.controller.WebControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hz.yisheng.commondata.constants.DialogMode;
import com.hz.yisheng.demo.bo.UserBO;
import com.hz.yisheng.demo.orm.User;

/**
 * 用户信息管理
 * 
 * @author huanglei
 * @date 2015年4月29日 下午5:08:44
 * @version V1.0
 */
@Controller
@RequestMapping(value = "/demo/user")
public class UserController extends BaseController {

	@Autowired
	private UserBO userBO;

	/**
	 * 获取分页数据
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		final Map<String, Object> sqlMap = QueryParamUtils.builderQueryMap(request);// 组装查询参数
		Page<User> page = WebControllerUtils.preparePage(request, 10);// 组装page对象
		page = userBO.pageQuery(page, sqlMap);
		JsonPageUtils.renderJsonPage(page.getTotalCount(), page.getResult(),response);
	}

	/**
	 * 跳转新增、编辑、查看页面
	 * 
	 * @param mode
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/{mode}/dispatch")
	public String previewUpdate(@PathVariable String mode, @RequestParam(required = false) Long id, Model model) {
		model.addAttribute("mode", mode);
		if (DialogMode.EDIT_MODE.equals(mode)) {
			model.addAttribute("user", userBO.findById(id));
		} else if (DialogMode.VIEW_MODE.equals(mode)) {
			model.addAttribute("user", userBO.findById(id));
			return "/demo/viewUser";
		}
		return "/demo/userDlg";
	}

	/**
	 * 保存
	 * 
	 * @param user
	 * @param request
	 * @param response
	 */
	@RequestMapping("/save")
	public void add(@ModelAttribute User user, HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			if (null != user.getId()) {
				userBO.update(user);
			} else {
				userBO.insert(user);
			}
			JSONUtils.objToJSON(response, 1);
		} catch (Exception e) {
			e.printStackTrace();
			JSONUtils.objToJSON(response, 0);
		}
	}

	/**
	 * 根据ID，删除信息
	 * 
	 * @param id
	 * @param response
	 * @param model
	 */
	@RequestMapping("/deleteById")
	public void deleteById(@RequestParam("id") Long id, HttpServletResponse response, Model model) {
		try {
			userBO.deleteById(id);
			JSONUtils.objToJSON(response, 1);
		} catch (Exception e) {
			e.printStackTrace();
			JSONUtils.objToJSON(response, 0);
		}
	}

}
