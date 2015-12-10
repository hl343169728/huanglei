package com.bjsxt.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bjsxt.po.Owner;
import com.bjsxt.service.OwnerService;

@Component
@Scope("prototype")
public class OwnerAction {
	@Resource
	private OwnerService ownerService;
	private Integer id;
	private Owner owner;
	private List<Owner> list;
	
	
	/**
	 * 添加信息的方法
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		this.ownerService.add(this.owner);
		return "list";
	}
	
	/**
	 * 获取所有的信息的方法
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception{
		this.list = this.ownerService.findAll();
		return "success";
	}
	
	/**
	 * 查询详细信息方法
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception{
		this.owner = this.ownerService.findById(this.id);
		return "detail";
	}
	
	/**
	 * 预修改的方法
	 * @return
	 * @throws Exception
	 */
	public String preUpdate() throws Exception{
		this.owner = this.ownerService.findById(this.id);
		return "update";
	}
	
	/**
	 * 真正修改的方法
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception{
		Owner o = this.ownerService.findById(this.id);
		o.setOname(this.owner.getOname());
		o.setAddress(this.owner.getAddress());
		o.setAge(this.owner.getAge());
		o.setCardid(this.owner.getCardid());
		o.setEmail(this.owner.getEmail());
		o.setNumber(this.owner.getNumber());
		o.setInTime(this.owner.getInTime());
		o.setOutTime(this.owner.getOutTime());
		this.ownerService.update(o);
		return "list";
	}
	
	/**
	 * 删除方法
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception{
		 this.ownerService.del(this.id);
		 return "list";
	}
	
	public OwnerService getOwnerService() {
		return ownerService;
	}
	public void setOwnerService(OwnerService ownerService) {
		this.ownerService = ownerService;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public List<Owner> getList() {
		return list;
	}
	public void setList(List<Owner> list) {
		this.list = list;
	}
}
