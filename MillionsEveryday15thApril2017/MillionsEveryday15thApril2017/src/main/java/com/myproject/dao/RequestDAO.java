package com.myproject.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;


import com.myproject.pojo.Request;

public class RequestDAO extends DAO{
	
	 public List<Request> list() {
	    	
	    	
	            begin();
	            Query q = getSession().createQuery("from Request where status=:s");
	            q.setParameter("s", "pending");
	            
	            List<Request> request = q.list();
	            commit();
	            return request;
	         
	    	
	    }
	 
	 public Request edit(Request r){
		 
		 begin();
		 getSession().update(r);
		 commit();
			return r;
		 
	 }
	 
	 public List<Request> where() {
	    	
	    	
         begin();
         Query q = getSession().createQuery("from Request where status = :s");
         q.setParameter("s", "confirmed");
         List<Request> request = q.list();
         commit();
         return request;
      
 	
 }

	 public List<Request> getCur(long i) {
	    	
	    	
         begin();
         Query q = getSession().createQuery("from Request where status = :s and retId =:id");
         q.setParameter("s", "approved");
         q.setParameter("id", i);
         List<Request> request = q.list();
         commit();
         return request;
      
 	
 }
	 
	 public List<Request> getRequest(long i) {
	    	
	    	
         begin();
         Query q = getSession().createQuery("from Request where requestId=:id");
        // q.setParameter("s", "approved");
         q.setParameter("id", i);
         List<Request> request = q.list();
         commit();
         return request;
      
 	
 }
}
