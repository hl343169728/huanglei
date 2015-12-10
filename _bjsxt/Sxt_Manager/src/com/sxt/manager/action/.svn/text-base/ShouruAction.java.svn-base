package com.sxt.manager.action;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.sxt.manager.model.Shouru;
import com.sxt.manager.service.ShouruService;
import com.sxt.manager.service.impl.ShouruServiceImpl;

public class ShouruAction  extends BaseAction{

	private Shouru shouru;

	public Shouru getShouru() {
		return shouru;
	}
	public void setShouru(Shouru shouru) {
		this.shouru = shouru;
	}

	private ShouruService shouruService = new ShouruServiceImpl();
	
	/**
	 * 保存方法
	 * @return
	 * @throws Exception
	 */
	public String saveShouru() throws Exception{
		this.shouruService.save(this.shouru);
		this.request.setAttribute("url","/jsp/shouru/shouru_in.jsp");
		return "SUCCESSPAGE";
	}
	
	/**
	 * 获取收入的信息列表
	 * @return
	 * @throws Exception
	 */
	public String getShouruList() throws Exception{
		String currentPage = this.request.getParameter("page");   //当前页
		String pageSize = this.request.getParameter("rows");	  //当前页的数据数目
		//获取收入表的信息
		List<Map> srList = this.shouruService.getShouruList(currentPage,pageSize);
		int total = this.shouruService.getTotal();
		//传输数据
		response.setContentType("text/html;charset=UTF-8");
		//写出指定的JSON格式的数据
		String json ="{\"total\":"+total+",\"rows\":"+JSONArray.fromObject(srList).toString()+"}";
		response.getWriter().write(json);
		return NONE;
	}
	
	/**
	 * 预修改的方法
	 * @return
	 * @throws Exception
	 */
	public String preUpdate() throws Exception{
		this.shouru = this.shouruService.findById(this.id);
		//这个方法暂时没有做完.....
		String className = this.shouruService.getClassName();
		return "PREUPDATE";
	}
	
	/**
	 * 真正的修改方法
	 * @return
	 * @throws Exception
	 */
	public String updateShouru() throws Exception{
		Shouru sr = this.shouruService.findById(this.id);
		sr.setStudentId(this.shouru.getStudentId());
		sr.setJine(this.shouru.getJine());
		sr.setShouruTime(this.shouru.getShouruTime());
		sr.setDescrpt(this.shouru.getDescrpt());
		this.shouruService.update(sr);
		this.request.setAttribute("url","/jsp/shouru/shouru_inList.jsp");
		return "SUCCESSPAGE";
	}
	
	/**
	 * 删除方法
	 * @return
	 * @throws Exception
	 */
	public String deleteShouru() throws Exception{
		this.shouruService.delete(this.id);
		this.request.setAttribute("url","/jsp/shouru/shouru_inList.jsp");
		return "SUCCESSPAGE";
	}
}
