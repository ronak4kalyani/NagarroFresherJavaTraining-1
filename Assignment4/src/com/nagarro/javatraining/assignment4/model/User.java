package com.nagarro.javatraining.assignment4.model;


import java.util.List;
import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.Query ;
import com.nagarro.javatraining.assignment4.HB.HibernateUtil;

@Entity
public class User {
	@Id @GeneratedValue
	int id ;
	String fullName ;
	
	@Column(name="username", unique=true)
	String userName ;
	String email ;
	String Pass ;
	
	@OneToMany(mappedBy="user", cascade= CascadeType.ALL , fetch=FetchType.EAGER)
	List<Image> imageList ;
	
	public int getId() {
		return id;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}

	public List<Image> getImageList() {
		return imageList;
	}

	public void setImageList(List<Image> imageList) {
		this.imageList = imageList;
	}
	
	public static List<Image> getImageList(String name) {
		
		Session session = HibernateUtil.sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from User where userName = :param");
		query.setParameter("param", name);
		User u = (User) query.uniqueResult();
		List<Image> li;
		try {
			li = u.getImageList();
		} catch (Exception e) {
			li = null ;
		}
		session.getTransaction().commit();
		session.close();
		return li; 
	} 
	
}
