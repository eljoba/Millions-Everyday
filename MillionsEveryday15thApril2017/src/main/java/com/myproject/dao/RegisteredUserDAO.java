package com.myproject.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.myproject.pojo.Payment;
import com.myproject.pojo.RegisteredUser;
import com.myproject.pojo.Request;
import com.myproject.pojo.User;

public class RegisteredUserDAO extends DAO {
	
	public RegisteredUserDAO() {
	}
	
	public RegisteredUser register(RegisteredUser u){
			
			begin();
			

			
//			RegisteredUser user = new RegisteredUser();
//
//			user.setFirstName(u.getFirstName());
//			user.setLastName(u.getLastName());
//			user.setEmail(u.getEmail());
//			//email.setUser(user);
			u.setRole("reguser");
			getSession().save(u);
			commit();
			return u;

		
	}
	
	public Payment pay(Payment p,String da,long i) throws ParseException{
		
	
		
		Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //String expDate = format.format(da);
        //p.setExpiryDate(format.parse(da));
        String payDate = format.format(d);
        p.setPayDate(format.parse(payDate));
        Date fdate = new SimpleDateFormat("yyyy-MM-dd").parse(da);
        p.setExpiryDate(fdate);
       
        RegisteredUser r=getUser(i);
        p.setRegUser(r);
		begin();
		
		
		getSession().save(p);
		
		commit();
		return p;

	
}
	
public List<Payment> getPay(long i) throws ParseException{
		
	
		
	begin();
	Query q = getSession().createQuery("from Payment where reguserId =:u");
    q.setParameter("u", i);
    
    List<Payment> p = q.list();
    commit();
    return p;
	
}

public RegisteredUser getUser(long i) throws ParseException{
	
	
	
	begin();
	Query q = getSession().createQuery("from RegisteredUser where userID =:u");
	q.setParameter("u", i);
    
	RegisteredUser reg=null;
    List<RegisteredUser> r = q.list();
    for(RegisteredUser ru:r){
    	reg=ru;
    }
    commit();
    return reg;
	
}
	
	

}
