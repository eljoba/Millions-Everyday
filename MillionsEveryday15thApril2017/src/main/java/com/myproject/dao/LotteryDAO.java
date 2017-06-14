package com.myproject.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.myproject.pojo.Lottery;
import com.myproject.pojo.MillionsEveryday;
import com.myproject.pojo.RegisteredUser;
import com.myproject.pojo.WinningNumbers;



public class LotteryDAO extends DAO{
	
	public Lottery register(Lottery l){
		
		begin();
		
	
		getSession().save(l);
		commit();
		return l;

	
}
	
	public WinningNumbers addNumbers(WinningNumbers w, Lottery l, String jd, String nd) throws ParseException{
		Date jDate = new SimpleDateFormat("yyyy-MM-dd").parse(jd);
        w.setJackpotDate(jDate);
        Date nDate = new SimpleDateFormat("yyyy-MM-dd").parse(nd);
        w.setNextJackpot(nDate);
        w.setLottery(l);
		begin();
		
	
		getSession().save(w);
		commit();
		return w;

	
}
	
public List<MillionsEveryday> getWin(){
		
	begin();
	Query q = getSession().createQuery("from MillionsEveryday");
	
    
	
    List<MillionsEveryday> m = q.list();
    
    commit();
    return m;
	

	
}

public List<Lottery> ret(String l){
	
	begin();
	Query q = getSession().createQuery("from Lottery where lotteryName=:lo");
	q.setParameter("lo",l);
    
	
    List<Lottery> lott = q.list();
    
    commit();
    return lott;
	

	
}

public MillionsEveryday setWinning(MillionsEveryday m,RegisteredUser i) throws ParseException{
		
	Date d = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    
    String playDate = format.format(d);
    m.setDatePlayed(format.parse(playDate));
    //RegisteredUser r=getUser(i);
    m.setRegisteredUser(i);
		begin();
		
	
		getSession().save(m);
		commit();
		return m;

	
}

public List<WinningNumbers> wn(String k){
	
	begin();
	Query q = getSession().createQuery("from WinningNumbers as wn where wn.lottery in(select l.lotteryId from Lottery l where l.lotteryName = :lo) order by wn.jackpotDate desc");
    q.setParameter("lo",k);
    
	
    List<WinningNumbers> w = q.list();
    commit();
    return w;
	

	
}


}
