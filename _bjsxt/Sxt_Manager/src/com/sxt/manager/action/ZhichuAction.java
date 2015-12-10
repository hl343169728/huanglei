package com.sxt.manager.action;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.sxt.manager.model.User;
import com.sxt.manager.model.Zhichu;
import com.sxt.manager.service.ZhichuService;
import com.sxt.manager.service.impl.ZhichuServiceImpl;

public class ZhichuAction extends BaseAction{
	
	private Zhichu zhichu;

	public Zhichu getZhichu() {
		return zhichu;
	}
	public void setZhichu(Zhichu zhichu) {
		this.zhichu = zhichu;
	}

	private ZhichuService zhichuService = new ZhichuServiceImpl();
	private User loginUser = (User) this.session.getAttribute("loginUser");
	
	/**
	 * 保存方法
	 * @return
	 * @throws Exception
	 */
	public String saveZhichu() throws Exception{
		Zhichu z = new Zhichu();
		z.setUserId(this.loginUser.getId());
		z.setJine(this.zhichu.getJine());
		z.setType(this.zhichu.getType());
		z.setDescrpt(this.zhichu.getDescrpt());
		z.setBaoxiaoId(this.zhichu.getBaoxiaoId());
		z.setZhichuTime(this.zhichu.getZhichuTime());
		z.setStudentId(this.zhichu.getStudentId());
		z.setShenheId(this.zhichu.getShenheId());
		z.setSn(this.zhichu.getSn());
		this.zhichuService.save(z);
		this.request.setAttribute("url","/jsp/zhichu/zhichu_out.jsp");
		return "SUCCESSPAGE";
	}
	
	/**
	 * 获取支出列表信息
	 * @return
	 * @throws Exception
	 */
	public String getZhichuList() throws Exception{
		String currentPage = this.request.getParameter("page");  //当前页
		String pageSize = this.request.getParameter("rows");  //当前页的记录数
		List<Map> zList = this.zhichuService.getZhichuList(currentPage,pageSize);
		int total = this.zhichuService.getTotal();
		//传输数据
		response.setContentType("text/html;charset=UTF-8");
		//写出指定的JSON格式的数据
		String json ="{\"total\":"+total+",\"rows\":"+JSONArray.fromObject(zList).toString()+"}";
		response.getWriter().write(json);
		return NONE;
	}
	
	/**
	 * 预修改的方法
	 * @return
	 * @throws Exception
	 */
	public String preUpdate() throws Exception{
		this.zhichu = this.zhichuService.findById(this.id);
		return "PREUPDATE";
	}
	
	/**
	 * 真正的修改方法
	 * @return
	 * @throws Exception
	 */
	public String updateZhichu() throws Exception{
		Zhichu zc = this.zhichuService.findById(this.id);
		zc.setJine(this.zhichu.getJine());
		zc.setType(this.zhichu.getType());
		zc.setStudentId(this.zhichu.getStudentId());
		zc.setZhichuTime(this.zhichu.getZhichuTime());
		zc.setDescrpt(this.zhichu.getDescrpt());
		zc.setSn(this.zhichu.getSn());
		this.zhichuService.update(zc);
		this.request.setAttribute("url", "/jsp/zhichu/zhichu_outList.jsp");
		return "SUCCESSPAGE";
	}
	
	/**
	 * 删除支出列表中要删除的信息
	 * @return
	 * @throws Exception
	 */
	public String deleteZhichu() throws Exception{
		this.zhichuService.delete(this.id);
		this.request.setAttribute("url","/jsp/zhichu/zhichu_outList.jsp");
		return "SUCCESSPAGE";
	}
}
