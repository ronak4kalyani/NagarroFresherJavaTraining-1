package com.nagarro.javatraining.assignment10.Dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.nagarro.javatraining.assignment10.model.User;

public class UserDaoImpl implements UserDao {
	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}
	
	public void saveUser(User user){  
	    Session session=template.getSessionFactory().openSession();
	    session.beginTransaction();
	    session.save(user);
	    session.getTransaction().commit();
	    session.close();
	} 
	
	public User getUser(String userId){
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) template.find("from User where userId="+ "'" + userId + "'" );
		if(listUser.isEmpty())
			return null ;
		return listUser.get(0) ;
	}
}
