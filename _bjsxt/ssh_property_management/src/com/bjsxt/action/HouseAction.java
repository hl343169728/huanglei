package com.bjsxt.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bjsxt.po.House;
import com.bjsxt.service.HouseService;
import com.bjsxt.service.impl.HouseServiceImpl;

@Component
@Scope("prototype")
public class HouseAction extends BaseAction{
	@Resource
	private HouseService houseService = new HouseServiceImpl();
	private Integer id;
	private House house;
	private List<House> list;
	
	/**
	 * 查询出房屋编号
	 * @return
	 * @throws Exception
	 */
	public String findHouse() throws Exception{
		List<House> hList = this.houseService.findAll();
		this.myWriter(JSONArray.fromObject(hList).toString());
		return null;
	}
	
	/**
	 * 房屋列表
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception{
		this.list = this.houseService.findAll();
		return "success";
	}
	
	
	
	public HouseService getHouseService() {
		return houseService;
	}
	public void setHouseService(HouseService houseService) {
		this.houseService = houseService;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	public List<House> getList() {
		return list;
	}
	public void setList(List<House> list) {
		this.list = list;
	}
}
