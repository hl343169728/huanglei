package com.sxt.manager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.sxt.manager.basedao.BaseDaoImpl;
import com.sxt.manager.dao.MessageReceiverDao;
import com.sxt.manager.model.MessageReceiver;
import com.sxt.manager.model.User;
import com.sxt.manager.utils.DBUtils;

public class MessageReceiverDaoImpl extends BaseDaoImpl<MessageReceiver> implements MessageReceiverDao{

	@Override
	public String  getReceiverNameByMessageId(int id) throws Exception {
		
		Connection conn = DBUtils.createConn();
		String sql = "select u.* from messagereceiver mr , user u where mr.receiverid = u.id and messageid = ?";
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		String receiverNames = "";
		while(rs.next()){
			receiverNames += rs.getString("u.uname") + ",";
		}
		if(!"".equals(receiverNames)){
			return receiverNames.substring(0 , receiverNames.length()-1);
		}
		return "";
	}

	
	/**
	 * 收件信息列表
	 */
	@Override
	public List<MessageReceiver> getMessageReceiverInList(int currentPage,
			int pageSize, int receiverId , String flag) throws Exception {
		return this.queryListForParams("select * from messagereceiver where receiverid= ? and receiverboxState=? and realDelete = 0 limit " + (currentPage-1)*pageSize +" , " + pageSize, new Object[]{receiverId , "1".equals(flag)?"有效":"删除"});
	}

	/**
	 * 根据messageid 查询所有关联的messagereceiver的记录
	 */
	@Override
	public List<MessageReceiver> findByMessageId(int id) throws Exception {
		return this.queryListForParams("select * from messagereceiver where messageid = ?",	new Object[]{id});
	}




}
