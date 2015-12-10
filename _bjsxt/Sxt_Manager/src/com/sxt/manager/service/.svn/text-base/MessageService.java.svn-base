package com.sxt.manager.service;

import java.util.List;
import java.util.Map;

import com.sxt.manager.dto.ZtreeDTO;
import com.sxt.manager.model.Message;
import com.sxt.manager.model.MessageReceiver;
import com.sxt.manager.model.Org;
import com.sxt.manager.model.User;

public interface MessageService {
	
	public Message findById(int msgId)  throws Exception;

	public void update(Message m) throws Exception;

	public Org getRootOrgByLoginUser(User loginUser) throws Exception;


	/**
	 * 递归获取2级机构 即分公司
	 * @param org
	 * @return
	 * @throws Exception
	 */
	public Org getLevelTwoOrg(Org org) throws Exception;

	public ZtreeDTO getZtreeDTO(Org rootOrg) throws Exception;

	public void save(User loginUser, String title, String receiverNames, String content) throws Exception;

	public String checkedReceiverNames(String receiverNames) throws Exception;

	public List<Map> getOutList(int parseInt, int parseInt2 , int senderId , String flag) throws Exception;

	public int getoutListTotal(int id , String flag) throws Exception;

	public List<Map> getInList(int parseInt, int parseInt2, int id , String flag) throws Exception;
	
	public int getinListTotal(int id , String flag) throws Exception;

	public MessageReceiver findMessageReceiverById(int parseInt) throws Exception;

	public void updateMessageReceiver(MessageReceiver mr) throws Exception;

	public User findUserById(int parseInt) throws Exception;

	public void deleteMessage(int id) throws Exception;

	public void deleteMessageReceiver(int id) throws Exception;
}
