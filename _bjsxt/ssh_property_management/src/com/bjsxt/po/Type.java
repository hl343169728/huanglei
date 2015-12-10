package com.bjsxt.po;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Type {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String typeName;
	@OneToMany
	private Set<User> user=new HashSet<User>();
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}
}
