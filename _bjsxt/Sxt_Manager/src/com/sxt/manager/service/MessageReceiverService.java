package com.sxt.manager.service;

import com.sxt.manager.model.MessageReceiver;

public interface MessageReceiverService {

	public abstract MessageReceiver changeVO(MessageReceiver mr) throws Exception;

	public abstract MessageReceiver findById(int id) throws Exception;

	public abstract void update(MessageReceiver mr) throws Exception;

	/**
	 * 删除收件箱信息(添加物理删除标识)
	 * @param id
	 * @throws Exception
	 */
	public abstract void deleteDustInBox(int id) throws Exception;

	/**
	 * 根据ReceiverId查找是否真正物理删除所有关联信息
	 * @param id
	 * @throws Exception
	 */
	public abstract void findByReceiverIdForDeleteAll(int id) throws Exception;
}