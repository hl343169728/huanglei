package com.hz.sunday.xccf.web.website;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javafans.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.collect.Maps;
import com.hz.sunday.xccf.bo.MessageInfoBO;
import com.hz.sunday.xccf.constants.ColumnType;
import com.hz.sunday.xccf.orm.MessageInfo;

/**
 * 首页
 * 
 * @author huanglei
 * @date 2015年4月14日
 * @version V1.0
 */
@Controller
public class WebIndexController extends BaseController {
	
	/** 网站首页*/
	private static final String WEBSITE_INDEX = "/website/index";
	
	@Autowired
	private MessageInfoBO messageInfoBO;

	/**
	 * 首页
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("columnValue", ColumnType.INDEX_TYPE);
		
		// 新闻中心信息
		initNesw(model);
		// 顶尖领袖团
		initLeader(model);
		// 拟邀请嘉宾
		initGuest(model);
		// 论坛日程
		initProgram(model);
		// 顶部轮番图片
		initTopTurn(model);
		// 首页广告位
		initAdvert(model);
		// 总策划人
		initOrganiger(model);
		// 底部轮播图片
		initDownTurn(model);
		// 组织机构
		initStructure(model);
		// 合作媒体
		initCooperation(model);
		// 销售宣传语
		initPropa(model);
		// 联系方式
		initContact(model);
		// 论坛接收
		initAbout(model);
		// 首页顶部广告位
		initUpAdvert(model);
		
		return WEBSITE_INDEX;
	}
	
	/**
	 * 初始化首页顶部广告位
	 * 
	 * @param model
	 */
	private void initUpAdvert(Model model) {
		Map<String, Object> queryMap = Maps.newHashMap();
		queryMap.put("mtype", ColumnType.UP_ADVERT_IMAGE);
		List<MessageInfo> upAdvertList = messageInfoBO.getList(queryMap);
		model.addAttribute("upAdvertList", upAdvertList);	
	}

	/**
	 * 初始化论坛介绍
	 * 
	 * @param model
	 */
	private void initAbout(Model model) {
		Map<String, Object> queryMap = Maps.newHashMap();
		queryMap.put("mtype", ColumnType.ABOUT_TYPE);
		List<MessageInfo> aboutList = messageInfoBO.getList(queryMap);
		model.addAttribute("aboutList", aboutList);		
	}

	/**
	 * 初始化联系方式
	 * 
	 * @param model
	 */
	private void initContact(Model model) {
		Map<String, Object> queryMap = Maps.newHashMap();
		queryMap.put("mtype", ColumnType.CONTACT_TYPE);
		List<MessageInfo> contactList = messageInfoBO.getList(queryMap);
		model.addAttribute("contactList", contactList);	
	}

	/**
	 * 初始化销售宣传语
	 * 
	 * @param model
	 */
	private void initPropa(Model model) {
		Map<String, Object> queryMap = Maps.newHashMap();
		queryMap.put("mtype", ColumnType.PROPAGANDA_IMAGE);
		List<MessageInfo> propaList = messageInfoBO.getList(queryMap);
		model.addAttribute("propaList", propaList);	
	}

	/**
	 * 初始化合作媒体
	 * 
	 * @param model
	 */
	private void initCooperation(Model model) {
		Map<String, Object> queryMap = Maps.newHashMap();
		queryMap.put("mtype", ColumnType.COOPERATION_TYPE);
		List<MessageInfo> cooperationList = messageInfoBO.getList(queryMap);
		model.addAttribute("cooperationList", cooperationList);		
	}

	/**
	 * 初始化组织机构
	 * 
	 * @param model
	 */
	private void initStructure(Model model) {
		Map<String, Object> queryMap = Maps.newHashMap();
		queryMap.put("mtype", ColumnType.STRUCTURE_TYPE);
		List<MessageInfo> structureList = messageInfoBO.getList(queryMap);
		List<MessageInfo> hostList = new ArrayList<MessageInfo>();
		List<MessageInfo> soleList = new ArrayList<MessageInfo>();
		List<MessageInfo> speciList = new ArrayList<MessageInfo>();
		if (null != structureList && structureList.size() > 0) {
			for (MessageInfo info : structureList) {
				if (null != info.getTitle() && info.getTitle().equals("1")) {
					hostList.add(info);
				} else if (null != info.getTitle() && info.getTitle().equals("2")) {
					soleList.add(info);
				} else {
					speciList.add(info);
				}
			}
		}
		model.addAttribute("hostList", hostList);
		model.addAttribute("soleList", soleList);
		model.addAttribute("speciList", speciList);
	}

	/**
	 * 初始化底部轮播图片
	 * 
	 * @param model
	 */
	private void initDownTurn(Model model) {
		Map<String,Object> downTurnMap = Maps.newHashMap();
		downTurnMap.put("mtype", ColumnType.DOWN_TURN_IMAGE);
		List<MessageInfo> downList = messageInfoBO.getList(downTurnMap);
		List<MessageInfo> infoList = new ArrayList<MessageInfo>();
		List<MessageInfo> resultList = new ArrayList<MessageInfo>();
		for (MessageInfo info : downList) {
			infoList.add(info);
			if (null != infoList && infoList.size()%2 == 0) {
				info.setInfoList(infoList);
				resultList.add(info);
				infoList = new ArrayList<MessageInfo>();
			}
		}
		model.addAttribute("resultList", resultList);
	}

	/**
	 * 初始化总策划人
	 * 
	 * @param model
	 */
	private void initOrganiger(Model model) {
		Map<String, Object> organigerMap = Maps.newHashMap();
		organigerMap.put("mtype", ColumnType.ORGANIGER_TYPE);
		List<MessageInfo> organigerList = messageInfoBO.getList(organigerMap);
		model.addAttribute("organigerList", organigerList);
	}

	/**
	 * 初始化首页广告位
	 * 
	 * @param model
	 */
	private void initAdvert(Model model) {
		Map<String,Object> advertMap = Maps.newHashMap();
		advertMap.put("mtype", ColumnType.ADVERT_IMAGE);
		List<MessageInfo> advertList = messageInfoBO.getList(advertMap);
		model.addAttribute("advertList", advertList);
	}

	/**
	 * 初始化顶部轮播图片
	 * 
	 * @param model
	 */
	private void initTopTurn(Model model) {
		Map<String,Object> turnMap = Maps.newHashMap();
		turnMap.put("mtype", ColumnType.TURN_IMAGE);
		List<MessageInfo> imgList = messageInfoBO.getList(turnMap);
		model.addAttribute("imgList", imgList);
	}

	/**
	 * 初始化论坛议程
	 * 
	 * @param model
	 */
	private void initProgram(Model model) {
		Map<String,Object> proMap = Maps.newHashMap();
		proMap.put("menuType",  ColumnType.PROGRAM_TYPE);
		proMap.put("startTime", new Date());
		proMap.put("mtype", ColumnType.PROGRAM_TYPE);
		List<MessageInfo> programList = messageInfoBO.getList(proMap);
		Long proCount = messageInfoBO.getCount(proMap);
		model.addAttribute("programList", programList);
		model.addAttribute("proCount", proCount);
	}

	/**
	 * 初始化拟邀请嘉宾
	 * 
	 * @param model
	 */
	private void initGuest(Model model) {
		Map<String, Object> guestMap = Maps.newHashMap();
		guestMap.put("mtype", ColumnType.GUEST_TYPE);
		List<MessageInfo> guestList = messageInfoBO.getList(guestMap);
		model.addAttribute("guestList", guestList);
	}

	/**
	 * 初始化顶尖领袖团
	 * 
	 * @param model
	 */
	private void initLeader(Model model) {
		Map<String, Object> leaderMap = Maps.newHashMap();
		leaderMap.put("mtype", ColumnType.LEADER_TYPE);
		List<MessageInfo> leaderList = messageInfoBO.getList(leaderMap);
		model.addAttribute("leaderList", leaderList);
	}

	/**
	 * 初始化新闻中心
	 * 
	 * @param model
	 */
	private void initNesw(Model model) {
		Map<String, Object> newsMap = Maps.newHashMap();
		newsMap.put("mtype", ColumnType.NEWS_TYPE);
		newsMap.put("menuType", ColumnType.NEWS_TYPE);
		List<MessageInfo> newsList = messageInfoBO.getList(newsMap);
		model.addAttribute("newsList", newsList);
	}

}
