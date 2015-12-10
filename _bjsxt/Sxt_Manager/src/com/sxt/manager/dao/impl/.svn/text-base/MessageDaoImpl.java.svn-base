package com.sxt.manager.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sxt.manager.basedao.BaseDaoImpl;
import com.sxt.manager.dao.MessageDao;
import com.sxt.manager.model.Message;
import com.sxt.manager.utils.DBUtils;

public class MessageDaoImpl extends BaseDaoImpl<Message> implements MessageDao{

	@Override
	public Message findByUUID(String uuid) throws Exception {

		List<Message> mlist = this.queryListForParams("select * from message where uuid = ?", new Object[]{uuid});
		if(mlist.size() > 0){
			return mlist.get(0);
		}
		return null;
	}

	/**
	 * 获取发件箱列表 
	 */
	@Override
	public List<Message> getMessageOutList(int currentPage, int pageSize , int senderId , String flag) throws Exception {
	
		// 拿出指定账户(当前登录的用户) 所发的信息列表 
		return	this.queryListForParams("select * from message where senderId = ? and sendboxState = ? and realDelete = 0 limit "+ (currentPage-1)*pageSize +" , " + pageSize, new Object[]{senderId , "1".equals(flag)?"有效":"删除"});
	}

	@Override
	public int getoutListTotal(int senderid ,String flag) throws Exception {
	
		Connection conn = DBUtils.createConn();
		String sql = "select count(*) from message where senderId = ? and sendboxState = ?" ;
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		ps.setInt(1, senderid);
		if("1".equals(flag)){
			ps.setString(2, "有效");
		} else {
			ps.setString(2, "删除"); 
		}
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			return rs.getInt(1);
		}
		return 0;
	}
	
	@Override
	public int getinListTotal(int receiverid , String flag) throws Exception {
	
		Connection conn = DBUtils.createConn();
		String sql = "select count(*) from messagereceiver where receiverid = ? and receiverboxState = ?" ;
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		ps.setInt(1, receiverid);
		if("1".equals(flag)){
			ps.setString(2, "有效");
		} else {
			ps.setString(2, "删除"); 
		}
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			return rs.getInt(1);
		}
		return 0;
	}

}
