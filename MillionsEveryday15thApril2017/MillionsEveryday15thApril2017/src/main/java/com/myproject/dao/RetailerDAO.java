package com.myproject.dao;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.myproject.pojo.Address;
import com.myproject.pojo.Filename;
import com.myproject.pojo.Payment;
import com.myproject.pojo.RegisteredUser;
import com.myproject.pojo.Request;
import com.myproject.pojo.Retailer;

public class RetailerDAO extends DAO{
	
	public RetailerDAO() {
	}
	
	public Retailer register(Retailer r){
			
		begin();
		System.out.println("inside DAO");

		Address address = new Address(r.getAddress().getStreet(),r.getAddress().getCity(),r.getAddress().getState());
		Retailer retailer = new Retailer(r.getName(), r.getPhone(), r.getEmail());

		retailer.setUserName(r.getUserName());
		retailer.setPassword(r.getPassword());
		retailer.setAddress(address);
		retailer.setRole("retailer");
		address.setRetailer(retailer);
		getSession().save(retailer);
		commit();
		return retailer;
		
	}
	
	public Payment finalPay(Payment p){
		
		begin();
		System.out.println("inside DAO");

		
		getSession().save(p);
		commit();
		return p;
		
	}
	
	public Request request(Request r) throws ParseException{
		
		begin();
		System.out.println("inside DAO");

//		Address address = new Address(r.getAddress().getStreet(),r.getAddress().getCity(),r.getAddress().getState());
//		Retailer retailer = new Retailer(r.getName(), r.getPhone(), r.getEmail(), r.getLongitude(), r.getLatitude(), r.getItvn());
//
//		retailer.setUserName(r.getUserName());
//		retailer.setPassword(r.getPassword());
//		retailer.setAddress(address);
//		address.setRetailer(retailer);
		
		Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String messageDate = format.format(d);
        r.setRequestDate(format.parse(messageDate));
//        Filename filename=new Filename();
//        filename.setFname(r.getImagename());
//        filename.setRequest(r);
       
		getSession().save(r);
		commit();
		return r;
		
	}
	
	public List<Request> ret(String city){
		
		begin();
		Query q = getSession().createQuery("from Request where status =:s and city =:c ");
        q.setParameter("c", city);
        q.setParameter("s", "confirmed");
        List<Request> r = q.list();
        commit();
        return r;
	}
	
public List<Retailer> getRetailer(long i){
		
		begin();
		Query q = getSession().createQuery("from Retailer where userID =:s");
        
        q.setParameter("s", i);
        List<Retailer> r = q.list();
        commit();
        return r;
	}

public List<Payment> getPay(long i) throws ParseException{
	
	
	
	begin();
    Query q = getSession().createQuery("from Payment as p where p.request in (select r.requestId from Request as r where r.retId =:id) ");
	
    q.setParameter("id", i);
    
    List<Payment> p = q.list();
    commit();
    return p;
	
}


}
