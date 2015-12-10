package com.sxt.manager.action;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.sxt.manager.dto.ZtreeDTO;
import com.sxt.manager.model.Message;
import com.sxt.manager.model.MessageReceiver;
import com.sxt.manager.model.Org;
import com.sxt.manager.model.User;
import com.sxt.manager.service.MessageReceiverService;
import com.sxt.manager.service.MessageService;
import com.sxt.manager.service.impl.MessageServiceImpl;

public class MessageAction extends BaseAction{

	private User loginUser = (User)this.session.getAttribute("loginUser");
	private MessageService messageService = new MessageServiceImpl();
	
	
	public String getOrgZtree() throws Exception {
		//根据当前的登录用户 获取指定的根节点 (要么当前的用户是属于总公司下的直属部门 , 属于总公司下面的分公司里的部门)
		Org rootOrg =  this.messageService.getRootOrgByLoginUser(this.loginUser); 
		ZtreeDTO  ztreeDTO = this.messageService.getZtreeDTO(rootOrg);
		this.myWriter(JSONArray.fromObject(ztreeDTO).toString());
		return NONE;
	}
	
	/**
	 * 保存信息
	 * @return
	 * @throws Exception
	 */
	public String saveMessage() throws Exception{
		
		String title = this.request.getParameter("title");
		String receiverNames = this.request.getParameter("receiverNames");
		String content = this.request.getParameter("content");
		this.messageService.save(this.loginUser , title , receiverNames ,content);
		this.request.setAttribute("url", "/jsp/message/message_add.jsp");
		return "SUCCESSPAGE";
	}
	
	/**
	 * 验证收件人是否存在 
	 * @return
	 * @throws Exception
	 */
	public String checkReceiverNames() throws Exception{
	
		String receiverNames = this.request.getParameter("receiverNames");
		String msg  = this.messageService.checkedReceiverNames(receiverNames); // 返回文本内容   1     错误的名字
		this.myWriter(msg);
		return NONE;
	}
	
	/**
	 * 获得信息列表方法 
	 * @return
	 * @throws Exception
	 */
	public String outList() throws Exception {
		
		String currentPage = this.request.getParameter("page");
		String pageSize    = this.request.getParameter("rows");
		
		String flag = this.request.getParameter("flag");
		
		List<Map> outList = this.messageService.getOutList(Integer.parseInt(currentPage) , Integer.parseInt(pageSize) , this.loginUser.getId() ,flag);
		int total = this.messageService.getoutListTotal(this.loginUser.getId() , flag);
		String json = "{\"total\": "+total+" , \"rows\": "+ JSONArray.fromObject(outList).toString()+"}";
		this.myWriter(json);
		return NONE;
	}
	
	
	/**
	 * 收件信息列表 
	 * @return
	 * @throws Exception
	 */
	public String inList() throws Exception{
		
		String currentPage = this.request.getParameter("page");
		String pageSize    = this.request.getParameter("rows");		
		
		String flag = this.request.getParameter("flag");
		
		List<Map> intList = this.messageService.getInList(Integer.parseInt(currentPage),Integer.parseInt(pageSize) , this.loginUser.getId() , flag);
		int total = this.messageService.getinListTotal(this.loginUser.getId() , flag);
		String json = "{\"total\": "+total+" , \"rows\": "+ JSONArray.fromObject(intList).toString()+"}";
		this.myWriter(json);
		return NONE;
	}
	
	/**
	 * 读取信件的方法 
	 * @return
	 * @throws Exception
	 */
	public String readMessage() throws Exception {
		
		String receiverid = this.request.getParameter("receiverid");			// messagereceiverid
		MessageReceiver mr = messageService.findMessageReceiverById(Integer.parseInt(receiverid));	// messagereceiver
		mr.setReadState("已读");
		this.messageService.updateMessageReceiver(mr);
	
		
		String messageId  = this.request.getParameter("messageId");		// 发件箱messageid
		Message message = this.messageService.findById(Integer.parseInt(messageId));
		User user = this.messageService.findUserById(message.getSenderId()); 
		this.request.setAttribute("message", message);
		this.request.setAttribute("senderName", user.getUname());
		return "WRITER";
	}
	
	
	/**
	 * 加入垃圾箱
	 * @return
	 * @throws Exception
	 */
	public String addDust() throws Exception{
		
		
		String receiverid = this.request.getParameter("receiverid");
		String messageid  = this.request.getParameter("messageid");
		
		if(receiverid != null){
			MessageReceiver mr = this.messageService.findMessageReceiverById(Integer.parseInt(receiverid));
			mr.setReceiverboxState("删除");
			this.messageService.updateMessageReceiver(mr);
			this.request.setAttribute("url", "/jsp/message/message_inBox.jsp");			
		}
 
		if(messageid != null){
			Message message  = this.messageService.findById(Integer.parseInt(messageid));
			message.setSendboxState("删除");
			this.messageService.update(message);
			this.request.setAttribute("url", "/jsp/message/message_outBox.jsp");		
		}
		return "SUCCESSPAGE";
	}
	
	
	/**
	 * 恢复信件的方法 
	 * @return
	 * @throws Exception
	 */
	public String recoverMessage() throws Exception{
		
		String messageid = this.request.getParameter("messageid");
		String messagereceiverid = this.request.getParameter("messagereceiverid");
		
		if(messageid != null){
				Message message = this.messageService.findById(Integer.parseInt(messageid));
				message.setSendboxState("有效");
				this.messageService.update(message);
				
		} 
		
		if(messagereceiverid != null){
			MessageReceiver mr = this.messageService.findMessageReceiverById(Integer.parseInt(messagereceiverid));
			mr.setReceiverboxState("有效");
			this.messageService.updateMessageReceiver(mr);
		}
		this.request.setAttribute("url", "/jsp/message/message_dustBox.jsp");
		return "SUCCESSPAGE";
	}
	
	
	
	/**
	 * 删除信件方法
	 */
	public String deleteDustBox() throws Exception {

		String flag = this.request.getParameter("flag");
		if("1".equals(flag)){		//发件箱的操作  message
			this.messageService.deleteMessage(this.id);
			
			
		} else if("2".equals(flag)) {		//收件箱的操作  messagereceiver
			this.messageService.deleteMessageReceiver(this.id);
		}
		
		this.request.setAttribute("url", "/jsp/message/message_dustBox.jsp");
		return "SUCCESSPAGE";
		
	}
	
	
	
	
	
	
	
	
	
	
}
