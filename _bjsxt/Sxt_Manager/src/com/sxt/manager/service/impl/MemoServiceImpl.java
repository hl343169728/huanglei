package com.sxt.manager.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sxt.manager.dao.MemoDao;
import com.sxt.manager.dao.impl.MemoDaoImpl;
import com.sxt.manager.model.Memo;
import com.sxt.manager.service.MemoService;
import com.sxt.manager.utils.CommonsUtil;

public class MemoServiceImpl implements MemoService{
	
	private MemoDao mdao = new MemoDaoImpl();

	/**
	 * 保存备忘录的方法
	 */
	@Override
	public void save(Memo memo) throws Exception {
		this.mdao.save(memo);
	}

	/**
	 * 获取备忘录的列表信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Map> getMemoList(String currentPage, String pageSize,int userId,
			String flag) throws Exception {
		List<Memo> mList = this.mdao.getMemoList(currentPage, pageSize,userId,flag);
		List<Map> list = new ArrayList<Map>();
		Date currentTime = new Date();
		//String currentTime = CommonsUtil.FormateDate(date);
		for (Iterator iterator = mList.iterator(); iterator.hasNext();) {
			Memo memo = (Memo) iterator.next();
			Map<String ,Object> map = new HashMap<String, Object>();
			map.put("id",memo.getId());
			map.put("content",memo.getContent());
			map.put("startTime",memo.getStartTime());
			map.put("endTime",memo.getEndTime());
			//System.out.println(memo.getStartTime());
			//System.out.println(memo.getEndTime());
			if("1".equals(flag)){
				if("过期".equals(getState(memo,currentTime))){
					continue;
				}else{
					map.put("state",getState(memo,currentTime));
				}
			}else{
				map.put("state",getState(memo,currentTime));
			}
			list.add(map);
		}
		return list;
	}

	/**
	 * 获取备忘录的状态
	 * @param memo
	 * @param currentTime
	 * @return
	 */
	private String getState(Memo memo, Date currentTime) throws Exception {
		if(currentTime.compareTo(CommonsUtil.StringToDate(memo.getStartTime()))<0){
			return "新创建";
		}else if(currentTime.compareTo(CommonsUtil.StringToDate(memo.getEndTime()))>0){
			//return currentTime.compareTo(memo.getStartTime())>0?"有效":"新创建";
			return "过期";
		}else{
			return "有效";
		}
	}

	/**
	 * 获取备忘录的总记录数
	 */
	@Override
	public int getMemoTotal(int userId,String flag) throws Exception {
		return this.mdao.getMemoTotal(userId , flag);
	}

	/**
	 * 通过id查找指定的Memo对象
	 */
	@Override
	public Memo findById(int id) throws Exception {
		return this.mdao.findById(id);
	}

	/**
	 * 通过id删除指定行的列表中的信息
	 */
	@Override
	public void delete(int id) throws Exception {
		this.mdao.delete(id);
		
	}

	/**
	 * 更新当前的对象
	 */
	@Override
	public void update(Memo m) throws Exception {
		this.mdao.update(m);
	}
}
