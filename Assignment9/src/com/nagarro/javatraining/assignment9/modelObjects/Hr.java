package com.nagarro.javatraining.assignment9.modelObjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hr {
	@Id @GeneratedValue
	private int  id ;
	
	@Column(name="userId", unique=true)
	private String userId ;
	private String pass ;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
}
