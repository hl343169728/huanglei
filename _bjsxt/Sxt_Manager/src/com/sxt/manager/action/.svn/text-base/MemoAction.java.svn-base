package com.sxt.manager.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.sxt.manager.model.Memo;
import com.sxt.manager.model.User;
import com.sxt.manager.service.MemoService;
import com.sxt.manager.service.impl.MemoServiceImpl;
import com.sxt.manager.utils.CommonsUtil;

public class MemoAction extends BaseAction {
	
	private Memo memo ;
	private MemoService memoService = new MemoServiceImpl();
	private User loginUser = (User)this.session.getAttribute("loginUser");

	public Memo getMemo() {
		return memo;
	}
	public void setMemo(Memo memo) {
		this.memo = memo;
	}
	
	/**
	 * 保存备忘录的方法
	 * @return
	 * @throws Exception
	 */
	public String saveMemo() throws Exception{
		Memo m = new Memo();
		m.setUserId(this.loginUser.getId());
		m.setContent(this.memo.getContent());
		m.setStartTime(this.memo.getStartTime());
		m.setEndTime(this.memo.getEndTime());
		this.memoService.save(m);
		this.request.setAttribute("url","/jsp/memo/memo_add.jsp");
		return "SUCCESSPAGE";
	}
	
	/**
	 * 获取备忘录的列表信息
	 * @return
	 * @throws Exception
	 */
	public String getMemoList() throws Exception{
		String currentPage = this.request.getParameter("page");    //当前页
		String pageSize = this.request.getParameter("rows");	   //当前页的记录数	
		String flag = this.request.getParameter("flag");		   //标识
		//System.out.println(this.loginUser.getId());
		List<Map> mList = this.memoService.getMemoList(currentPage,pageSize,this.loginUser.getId(),flag);
		int total = this.memoService.getMemoTotal(this.loginUser.getId(),flag);
		//传输数据
		response.setContentType("text/html;charset=UTF-8");
		//写出指定的JSON格式的数据
		String json ="{\"total\":"+total+",\"rows\":"+JSONArray.fromObject(mList).toString()+"}";
		response.getWriter().write(json);
		return NONE;
	}
	
	/**
	 * 预修改的方法
	 * @return
	 * @throws Exception
	 */
	public String preUpdate() throws Exception{
		this.memo = this.memoService.findById(this.id);
		return "PREUPDATE";
	}
	
	/**
	 * 真正的修改方法
	 * @return
	 * @throws Exception
	 */
	public String updateMemo() throws Exception{
		String flag = this.request.getParameter("flag");
		Memo m = this.memoService.findById(this.id);
		m.setContent(this.memo.getContent());
		m.setStartTime(this.memo.getStartTime());
		m.setEndTime(this.memo.getEndTime());
		m.setUserId(this.loginUser.getId());
		this.memoService.update(m);
		if("1".equals(flag)){
			this.request.setAttribute("url","/jsp/memo/memo_validList.jsp");
		}else{
			this.request.setAttribute("url","/jsp/memo/memo_allList.jsp");
		}
		return "SUCCESSPAGE";
	}
	
	/**
	 * 删除备忘录列表指定行的信息
	 * @return
	 * @throws Exception
	 */
	public String deleteMemo() throws Exception{
		String flag = this.request.getParameter("flag");
		this.memoService.delete(this.id);
		if("1".equals(flag)){
			this.request.setAttribute("url","/jsp/memo/memo_validList.jsp");
		}else{
			this.request.setAttribute("url","/jsp/memo/memo_allList.jsp");
		}
		return "SUCCESSPAGE";
	}
	
	/**
	 * 验证日期是否符合标准
	 * @return
	 * @throws Exception
	 */
	public String checkDate() throws Exception{
		Date startTime = CommonsUtil.StringToDate(this.request.getParameter("startTime"));
		Date endTime   = CommonsUtil.StringToDate(this.request.getParameter("endTime"));
		if(startTime.compareTo(endTime)<=0){
			this.myWriter("1");
		}else{
			this.myWriter("");
		}
		return "SUCCESSPAGE";
	}
}
