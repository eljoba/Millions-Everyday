package com.myproject.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.myproject.pojo.User;



public class UserDAO extends DAO {
	
	public UserDAO() {
	}

	public User get(String username, String password) {
		User user=null;
		try {
			begin();
			Query q = getSession().createQuery("from User where userName = :username and password = :password");
			q.setString("username", username);
			q.setString("password", password);			
			user = (User) q.uniqueResult();
			commit();
			
		} catch (HibernateException e) {
			rollback();
			
		}
		return user;
		
	}

}
