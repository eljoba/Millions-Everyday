package com.myproject.dao;

import java.util.List;

import org.hibernate.Query;

import com.myproject.pojo.Category;
import com.myproject.pojo.Lottery;
import com.myproject.pojo.WinningNumbers;

public class CategoryDAO extends DAO{
	
public Category register(Category c){
		
		begin();
		
	
		getSession().save(c);
		commit();
		return c;

	
}

public List<Category> getCat(){
	
	begin();
	Query q = getSession().createQuery("from Category");
    
    
	
    List<Category> c= q.list();
    commit();
    return c;
	

	
}

}
