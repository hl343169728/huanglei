package com.hz.sunday.trend.web.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javafans.common.constants.CommonConstants;
import org.javafans.common.utils.query.QueryParamUtils;
import org.javafans.dto.page.Page;
import org.javafans.web.AjaxUtils;
import org.javafans.web.JsonPageUtils;
import org.javafans.web.controller.BaseController;
import org.javafans.web.springmvc.controller.WebControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hz.sunday.trend.bo.OnlineServiceBO;
import com.hz.sunday.trend.orm.OnlineService;

/**
 * 在线客服管理
 * 
 * @author huanglei
 */
@Controller
@RequestMapping("/admin/service")
public class OnlineServiceController extends BaseController {

	@Autowired
	private OnlineServiceBO onlineServiceBO;

	/**
	 * 分页数据
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
	    Map<String, Object> sqlMap = QueryParamUtils.builderQueryMap(request);// 组装查询参数
		Page<OnlineService> page = WebControllerUtils.preparePage(request, 10);// 组装page对象
		page = onlineServiceBO.pageQuery(page, sqlMap);
		JsonPageUtils.renderJsonPage(page.getTotalCount(), page.getResult(), response);
	}

	/**
	 * 保存
	 * 
	 * @param onlineService
	 * @param response
	 */
	@RequestMapping("/save")
	public void save(@ModelAttribute OnlineService onlineService, HttpServletResponse response) {
		try {
			if (null == onlineService.getId()) {
				onlineServiceBO.insert(onlineService);
			}
			AjaxUtils.renderText(response, CommonConstants.SUCCESS);
		} catch (Exception e) {
			logger.error("OnlineServiceController save error", e);
			AjaxUtils.renderText(response, CommonConstants.FAIL);
		}
	}

	/**
	 * 根据ID，删除
	 * 
	 * @param id
	 * @param response
	 */
	@RequestMapping("/deleteById/{id}")
	public void delete(@PathVariable("id") Long id, HttpServletResponse response) {
		try {
			onlineServiceBO.deleteById(id);
			AjaxUtils.renderText(response, CommonConstants.SUCCESS);
		} catch (Exception e) {
			logger.error("OnlineServiceController deleteById error", e);
			AjaxUtils.renderText(response, CommonConstants.FAIL);
		}
	}

}
