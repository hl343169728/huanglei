package com.sxt.manager.model;

public class MessageReceiver {

	
	private int id ; 
	private int messageId ; 
	private int receiverId ; 
	private String readState = "未读" ; 
	private String receiverboxState = "有效"; //默认值：有效。  可选值有：有效，删除 
	private int realDelete ;					//真正物理删除标识	 默认为0  状态为 1 时表示物理删除
	
	
	
	public MessageReceiver() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MessageReceiver(int id, int messageId, int receiverId,
			String readState, String receiverboxState , int readDelete ) {
		super();
		this.id = id;
		this.messageId = messageId;
		this.receiverId = receiverId;
		this.readState = readState;
		this.receiverboxState = receiverboxState;
		this.realDelete = readDelete;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public int getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}
	public String getReadState() {
		return readState;
	}
	public void setReadState(String readState) {
		this.readState = readState;
	}
	public String getReceiverboxState() {
		return receiverboxState;
	}
	public void setReceiverboxState(String receiverboxState) {
		this.receiverboxState = receiverboxState;
	}
	public int getRealDelete() {
		return realDelete;
	}
	public void setRealDelete(int realDelete) {
		this.realDelete = realDelete;
	} 
	
	
}
