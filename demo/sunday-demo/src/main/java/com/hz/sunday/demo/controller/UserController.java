package com.hz.sunday.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.javafans.common.constants.CommonConstants;
import org.javafans.common.utils.io.FileUtils;
import org.javafans.common.utils.query.QueryParamUtils;
import org.javafans.dto.page.Page;
import org.javafans.resources.ResourceConfig;
import org.javafans.web.AjaxUtils;
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
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.hz.sunday.demo.bo.UserBO;
import com.hz.sunday.demo.entity.User;
import com.hz.yisheng.commondata.dao.CityMapper;

/**
 * 用户信息管理
 * 
 * @author huanglei
 */
@Controller
@RequestMapping(value = "/demo/user")
public class UserController extends BaseController {

	@Autowired
	private UserBO userBO;
	@Autowired
	private CityMapper cityMapper;

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
	 * 跳转新增页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("input")
	public String previewUpdate(@RequestParam(required = false) Long id, Model model) {
		if (null != id) {
			model.addAttribute("user", userBO.findById(id));
		}
		return "/demo/user-input";
	}
	
	/**
	 * 异步获取单个用户对象
	 * 
	 * @param id
	 * @param response
	 */
	@RequestMapping("/findById/{id}")
	public void getUser(@PathVariable("id") Long id, HttpServletResponse response){
		AjaxUtils.renderJson(response, userBO.findById(id));
	}
	
	/**
	 * 获取省份、地区、县市区信息
	 * 
	 * @param id
	 * @param response
	 */
	@RequestMapping("/getCity/{id}")
	public void getCity(@PathVariable("id")Long id, HttpServletResponse response){
		AjaxUtils.renderJson(response, cityMapper.getCity(id));
	}

	/**
	 * 保存
	 * 
	 * @param user
	 * @param request
	 * @param response
	 */
	@RequestMapping("/save")
	public void add(@ModelAttribute User user, HttpServletRequest request, HttpServletResponse response,@RequestParam("logos") CommonsMultipartFile logos, Model model) {
		try {
			if(logos!=null && !logos.isEmpty()){
				FileItem item = logos.getFileItem();
				String filePath = FileUtils.saveFile(item.getInputStream(), ResourceConfig.getSysConfig("fileUploadPath"), item.getName(), item.getContentType());
				user.setLogo(filePath);
			}
			if (null != user.getId()) {
				userBO.update(user);
			} else {
				userBO.insert(user);
			}
			AjaxUtils.renderText(response, CommonConstants.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			AjaxUtils.renderText(response, CommonConstants.FAIL);
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
	
	/**
	 * 取消附件
	 * 
	 * @param id
	 * @param response
	 * @param model
	 */
	@RequestMapping("/cancel")
	public void cancel(@RequestParam("id") Long id, HttpServletResponse response, Model model) {
		try {
			userBO.cancel(id);
			AjaxUtils.renderText(response, CommonConstants.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			AjaxUtils.renderText(response, CommonConstants.FAIL);
		}
	}

}
