package com.sxt.manager.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.sxt.manager.dao.EmployeeDao;
import com.sxt.manager.dao.MessageDao;
import com.sxt.manager.dao.MessageReceiverDao;
import com.sxt.manager.dao.OrgDao;
import com.sxt.manager.dao.UserDao;
import com.sxt.manager.dao.impl.EmployeeDaoImpl;
import com.sxt.manager.dao.impl.MessageDaoImpl;
import com.sxt.manager.dao.impl.MessageReceiverDaoImpl;
import com.sxt.manager.dao.impl.OrgDaoImpl;
import com.sxt.manager.dao.impl.UserDaoImpl;
import com.sxt.manager.dto.ZtreeDTO;
import com.sxt.manager.model.Employee;
import com.sxt.manager.model.Message;
import com.sxt.manager.model.MessageReceiver;
import com.sxt.manager.model.Org;
import com.sxt.manager.model.User;
import com.sxt.manager.service.MessageService;
import com.sxt.manager.utils.CommonsUtil;

public class MessageServiceImpl implements MessageService{


	private EmployeeDao edao = new EmployeeDaoImpl();
	private MessageDao  mdao = new MessageDaoImpl();
	private OrgDao 		odao = new OrgDaoImpl();
	private UserDao     udao = new UserDaoImpl();
	private MessageReceiverDao  mrDao = new MessageReceiverDaoImpl();
	
	/**
	 * 根据传入的user对象获取指定的根节点 
	 */
	@Override
	public Org getRootOrgByLoginUser(User loginUser) throws Exception {
			
		Employee ee = this.edao.findById(loginUser.getEmpId());
		Org org  =  this.odao.findById(ee.getOrgId());		
		Org parentOrg =  this.odao.findById(org.getPid());	
		
		if(parentOrg.getPid() == 999999){			// 总公司下面的直属部门
			return parentOrg;
		} else {									// 分公司
			return getLevelTwoOrg(parentOrg);
		}
	}
	
	
	
	/**
	 * 递归获取2级机构 即分公司
	 * @param org
	 * @return
	 * @throws Exception
	 */
	public Org getLevelTwoOrg(Org org) throws Exception{
	
		Org parentOrg =  this.odao.findById(org.getPid());
		if(parentOrg.getPid() == 999999){
			return org;						//总节点的下级节点 2级节点
		} else {
			return getLevelTwoOrg(parentOrg);		//把父节点放进去继续递归 寻找顶级节点
		}
	}
	
	@Override
	public ZtreeDTO getZtreeDTO(Org org) throws Exception {
		
		ZtreeDTO ztreeDTO = new ZtreeDTO();
		ztreeDTO.setId(org.getId());
		ztreeDTO.setName(org.getOname());
		ztreeDTO.setLeaf(org.getLeaf());
		ztreeDTO.setParentId(org.getPid());
		ztreeDTO.setOpen(true);
		
		//就是属于给 根级的组织机构准备的 
		//判断当前这个组织机构是否是跟机构 : 只有跟机构才有(人员)
		List<User> userList = this.edao.findByOrgId(org.getId());
		
		
		HashSet<ZtreeDTO> empSet = new LinkedHashSet<ZtreeDTO>();
		for (int i = 0; i < userList.size(); i++) {
			ZtreeDTO ztreeEmpDTO = new ZtreeDTO();
			User user = userList.get(i);
			ztreeEmpDTO.setId(user.getId());
			ztreeEmpDTO.setName(user.getUname());
			empSet.add(ztreeEmpDTO);
		}
		if(empSet.size()!= 0){
			ztreeDTO.setNodes(empSet);
		}
	
		
		
		// 根组织机构有关的操作 .....
		//根据id 查询所有的 子节点 返回集合 
		List<Org> ztreeList = this.odao.queryListForParams("select * from org where pid = ?", new Object[]{org.getId()});
		HashSet<ZtreeDTO> dtoSet = new LinkedHashSet<ZtreeDTO>();
		for (int i = 0; i < ztreeList.size(); i++) {
			
			 //  两种情况： 1是总节点    2  不是跟节点 分公司 
			 if(org.getPid() == 999999){
				 
				 if(ztreeList.get(i).getLeaf() == 1 && this.edao.findByOrgId(ztreeList.get(i).getId()).size() > 0 ){ // 总公司下的直属部门 
					 dtoSet.add(getZtreeDTO(ztreeList.get(i)));
				 }
				 
			 } else {
				 
				 if(this.edao.findByOrgId(ztreeList.get(i).getId()).size() > 0 ||  ztreeList.get(i).getLeaf() != 1 ){
						 dtoSet.add(getZtreeDTO(ztreeList.get(i)));
				 }				 
				 
			 }

		}
		if(dtoSet.size() != 0){
			ztreeDTO.setNodes(dtoSet);
		}
		return ztreeDTO;
	}
	
	
	
	
	/**
	 * 保存方法
	 */
	@Override
	public void save(User loginUser, String title, String receiverNames,
			String content) throws Exception {
			
		
		// 保存发信息的对象
		Message m = new Message();
		m.setContent(content);
		m.setSenderId(loginUser.getId());
		m.setCreateTime(CommonsUtil.FormateDate(new Date()));
		m.setTitle(title);
		String uuid = UUID.randomUUID().toString(); //aadsadsa-dsaiuih-jidsa18e32-dsads
		m.setUUID(uuid);
		this.mdao.save(m);
		
		
		Message into = this.mdao.findByUUID(uuid);
		//循环保存收件人 
		for(String receiverName : receiverNames.split(",")){
			User user = this.udao.findByName(receiverName);	
			MessageReceiver mr = new MessageReceiver();
			//根据uuid 取得对象 
			mr.setMessageId(into.getId());
			mr.setReceiverId(user.getId());
			this.mrDao.save(mr);
		}
	}

	/**
	 * 校验账号是否存在的方法 
	 */
	@Override
	public String checkedReceiverNames(String receiverNames) throws Exception {
		String str = "";
		for(String name :  receiverNames.split(",")){
				if(this.udao.findByName(name) == null){
					 str += name + "," ; 
				}
		}
		if("".equals(str)){
			str = "1";
		} else {
			str = str.substring(0, str.length()-1);
		}
		return str;
	}

	
	/**
	 * 获取发件箱列表 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Map> getOutList(int currentPage, int pageSize , int senderId , String flag) throws Exception {
		List<Message> messageList = this.mdao.getMessageOutList(currentPage , pageSize , senderId , flag);
		List<Map> mlist = new ArrayList();
		for (Iterator iterator = messageList.iterator(); iterator.hasNext();) {
			Message message = (Message) iterator.next();
			Map m = new HashMap<String, Object>();
			m.put("id", message.getId());
			m.put("title", message.getTitle());
			m.put("createTime", message.getCreateTime());
			//获得收件人名称
			m.put("receiverNames", this.mrDao.getReceiverNameByMessageId(message.getId()));
			mlist.add(m);
		}
		return mlist;
	}
	
	/**
	 * 查询发件箱 总记录数  
	 */
	@Override
	public int getoutListTotal(int id ,  String flag) throws Exception {
		return this.mdao.getoutListTotal(id , flag);
	}
	
	
	/**
	 * 查询收件箱列表信息 
	 */
	@Override
	public List<Map> getInList(int currentPage, int pageSize, int receiverId , String flag)
			throws Exception {
		//当前用户所有受到的信息 
		List<MessageReceiver> messageList = this.mrDao.getMessageReceiverInList(currentPage , pageSize , receiverId , flag);
		List<Map> inList = new ArrayList<Map>();
		for (Iterator iterator = messageList.iterator(); iterator.hasNext();) {
			MessageReceiver messageReceiver = (MessageReceiver) iterator.next();
			Map m = new HashMap<String, Object>();
			m.put("id", messageReceiver.getId());
			m.put("readState", messageReceiver.getReadState());
			Message message = this.mdao.findById(messageReceiver.getMessageId());
			m.put("messageId", message.getId());
			m.put("title", message.getTitle());
			m.put("createTime", message.getCreateTime());
			m.put("sendName", this.udao.findById(message.getSenderId()).getUname());
			inList.add(m);
		}
		return inList;
	}
	
	
	/**
	 * 根据id获取message对象 
	 */
	@Override
	public Message findById(int msgId) throws Exception {
		return this.mdao.findById(msgId);
	}


	@Override
	public void update(Message m) throws Exception {
		 this.mdao.update(m);
	}

	/**
	 * 查询收件箱 总记录数  
	 */
	@Override
	public int getinListTotal(int id , String flag) throws Exception {
		return this.mdao.getinListTotal(id , flag);
	}


	/**
	 * 根据messagereceiverid 查询指定对象 
	 */
	@Override
	public MessageReceiver findMessageReceiverById(int parseInt) throws Exception {
		return this.mrDao.findById(parseInt);
	}
	/**
	 * 更新messagereceived 对象 
	 */
	@Override
	public void updateMessageReceiver(MessageReceiver mr) throws Exception {
		this.mrDao.update(mr);
	}



	@Override
	public User findUserById(int parseInt) throws Exception {
		return this.udao.findById(parseInt);
	}


	//删除方法 message
	@Override
	public void deleteMessage(int id) throws Exception {
			Message message = this.mdao.findById(id);
			message.setRealDelete(1);		//做物理删除的标识
			this.mdao.update(message);
			
			List<MessageReceiver> mrList = this.mrDao.findByMessageId(message.getId());
			
			boolean flag = false; 
			for (Iterator iterator = mrList.iterator(); iterator.hasNext();) {
				MessageReceiver messageReceiver = (MessageReceiver) iterator
						.next();
				if(messageReceiver.getRealDelete() != 1){
					flag = true ;
				}
			}
			if(flag == false){
				this.mdao.delete(id);		//删除发件箱信息
				//循环删除发件箱所关联的收件人信息 
				for (Iterator iterator = mrList.iterator(); iterator.hasNext();) {
					MessageReceiver messageReceiver = (MessageReceiver) iterator
							.next();
					this.mrDao.delete(messageReceiver.getId());
				}
			}
	}


	//删除方法messagereceiver
	@Override
	public void deleteMessageReceiver(int id) throws Exception {
		 MessageReceiver mr = this.mrDao.findById(id);
		 mr.setRealDelete(1);
		 this.mrDao.update(mr);
		 
		 //获得指定的发件信息
		 Message message = this.mdao.findById(mr.getMessageId());
		 //查询出 根这个发件信息有关的所有的收件信息
		 List<MessageReceiver> mrList = this.mrDao.findByMessageId(message.getId());
		 
		 boolean flag = false ; 
		 for (Iterator iterator = mrList.iterator(); iterator.hasNext();) {
			MessageReceiver messageReceiver = (MessageReceiver) iterator.next();
			if(messageReceiver.getRealDelete() != 1){
				flag = true ;
			}			
		 }
		 if(flag == false  &&  message.getRealDelete() == 1 ){
			  this.mdao.delete(message.getId());
			  
			  for (Iterator iterator = mrList.iterator(); iterator.hasNext();) {
				MessageReceiver messageReceiver = (MessageReceiver) iterator
						.next();
				this.mrDao.delete(messageReceiver.getId());
			}
		 }
		 
		 
	}
}
