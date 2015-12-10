package com.sxt.manager.dao;

import java.util.List;

import com.sxt.manager.basedao.BaseDao;
import com.sxt.manager.model.Message;

public interface MessageDao extends BaseDao<Message> {

	Message findByUUID(String uuid) throws Exception;

	List<Message> getMessageOutList(int currentPage, int pageSize , int senderId , String flag) throws Exception;
	
	int getoutListTotal( int senderid  , String flag) throws Exception;

	int getinListTotal(int id , String flag) throws Exception;


	

	
}
