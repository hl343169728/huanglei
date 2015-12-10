package com.sxt.manager.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.sxt.manager.dao.TempDao;
import com.sxt.manager.dao.impl.TempDaoImpl;
import com.sxt.manager.model.Temp;

public class EditorAction extends BaseAction{

	private Temp temp ; 
	private TempDao tdao = new TempDaoImpl();

	
	public String getList() throws Exception {
		
		List<Temp> tlist = this.tdao.findAll();
		
		response.setContentType("text/html;charset=utf-8");
		String data = "{\"total\":"+tlist.size()+" , \"rows\":"+JSONArray.fromObject(tlist) +" }";
		System.out.println(data);
		response.getWriter().write(data);
		
		return NONE;
	}
	
	
	public String getRole() throws Exception{
		
		List roleList = new ArrayList();
		
		Map map1 = new HashMap();
		map1.put("id", "1");
		map1.put("name", "管理员");
		Map map2 = new HashMap();
		map2.put("id", "2");
		map2.put("name", "程序员");
		Map map3 = new HashMap();
		map3.put("id", "3");
		map3.put("name", "项目经理");
		
		roleList.add(map1);
		roleList.add(map2);
		roleList.add(map3);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(JSONArray.fromObject(roleList).toString());
		return NONE;
	}
	
	/**
	 * 保存方法
	 * @return
	 * @throws Exception
	 */
	public String save() throws Exception {
		
		return NONE;
	}
	
	/**
	 * 修改方法
	 * @return
	 */
	
	public String update() throws Exception {
		
		System.out.println("aaaa");
		return NONE;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Temp getTemp() {
		return temp;
	}

	public void setTemp(Temp temp) {
		this.temp = temp;
	}
	
	
	
	
}
