package com.sxt.manager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import com.sxt.manager.basedao.BaseDaoImpl;
import com.sxt.manager.dao.MemoDao;
import com.sxt.manager.model.Memo;
import com.sxt.manager.utils.DBUtils;

public class MemoDaoImpl extends BaseDaoImpl<Memo> implements MemoDao{

	/**
	 * 获取备忘录的列表信息
	 */
	@Override
	public List<Memo> getMemoList(String currentPage, String pageSize,
			int userId, String flag) throws Exception {
		return this.queryListForParams("select * from memo where userId=? limit "+(Integer.parseInt(currentPage)-1)*Integer.parseInt(pageSize)+","+Integer.parseInt(pageSize), new Object[]{userId});
	}

	/**
	 * 获取备忘录的总记录数
	 */
	@Override
	public int getMemoTotal(int userId, String flag) throws Exception {
		Connection conn = DBUtils.createConn();
		String sql = "";
		if("1".equals(flag)){
			sql = "select count(*) from memo where state='有效' or state='新创建' and userId=?";
		}else{
			sql = "select count(*) from memo where userId=?";
		}
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		ps.setInt(1,userId);
		ResultSet rs = ps.executeQuery();
		int total = 0;
		if(rs.next()){
			total = rs.getInt(1);
		}
		DBUtils.close(rs);
		DBUtils.close(ps);
		DBUtils.close(conn);
		return total;
	}
}
