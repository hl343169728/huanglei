package com.sxt.manager.dao;

import java.util.List;

import com.sxt.manager.basedao.BaseDao;
import com.sxt.manager.model.MessageReceiver;

public interface MessageReceiverDao  extends BaseDao<MessageReceiver>{

	String getReceiverNameByMessageId(int id) throws Exception;

	List<MessageReceiver> getMessageReceiverInList(int currentPage,
			int pageSize, int receiverId , String flag) throws Exception;

	List<MessageReceiver> findByMessageId(int id) throws Exception;


}
