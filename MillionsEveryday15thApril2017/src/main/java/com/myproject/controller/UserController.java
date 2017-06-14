package com.myproject.controller;
import com.myproject.exception.UserException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.mail.*;


import com.myproject.dao.RegisteredUserDAO;
import com.myproject.dao.RequestDAO;
import com.myproject.dao.UserDAO;
import com.myproject.pojo.MillionsEveryday;
import com.myproject.pojo.Payment;
import com.myproject.pojo.RegisteredUser;
import com.myproject.pojo.Request;
import com.myproject.pojo.User;
import com.myproject.validator.UserValidation;

@Controller
@RequestMapping("/user/*")
public class UserController {
	

	@Autowired
	@Qualifier("userDao")
	RegisteredUserDAO userDao;
	
	@Autowired
	@Qualifier("uDao")
	UserDAO uDao;
	
	@Autowired
	@Qualifier("requestDao")
	RequestDAO requestDao;
	
	@Autowired
	@Qualifier("registeredUserValidator")
	UserValidation validator;
	
	@InitBinder("registeredUserValidator")
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping(value = "user/login", method = RequestMethod.GET)
	protected String userLogin(HttpServletRequest request) throws Exception {
		return "login";
	}
	
	@RequestMapping(value = "user/home", method = RequestMethod.GET)
	protected String home(HttpServletRequest request) throws Exception {
		return "requestReply";
	}
	
	@RequestMapping(value = "user/book", method = RequestMethod.POST)
	protected String book(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession(true);
		int noBooks = Integer.parseInt(request.getParameter("noBooks"));
		session.setAttribute("noBooks",noBooks);
		return "disp";
	}
	
	@RequestMapping(value = "user/login", method = RequestMethod.POST)
	protected ModelAndView requestReply(HttpServletRequest request) throws Exception {
		

		List<Request> requests = requestDao.list();
		ModelAndView mv=new ModelAndView("requestReply");
		Map<String,String> status = new LinkedHashMap<String,String>();
        status.put("approve", "approve");
        status.put("reject", "reject");
        
        mv.addObject("status", status);
		mv.addObject("requests",requests);
		mv.addObject("reqobj",new Request());
		return mv;
		//return new ModelAndView("requestReply", "reqobj", new Request());
	}
	
	@RequestMapping(value = "user/admin", method = RequestMethod.POST)
	protected ModelAndView adminMenu(HttpServletRequest request) throws Exception {
		
		
		
HttpSession session = (HttpSession) request.getSession();
		User u=null;
		try {

			System.out.print("loginUser");

			u = uDao.get(request.getParameter("username"), request.getParameter("password"));
			
			if(u == null){
				System.out.println("UserName/Password does not exist");
				session.setAttribute("errorMessage", "UserName/Password does not exist");
				return new ModelAndView("error");
			}
			
			session.setAttribute("user", u);
			
			

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			session.setAttribute("errorMessage", "error while login");
			return new ModelAndView("error");
		}
		
		if(u.getRole().equals("retailer")||u.getRole().equals("reguser")){
		return new ModelAndView("home");
		}
		else{
			List<Request> requests = requestDao.list();
			ModelAndView mv=new ModelAndView("requestReply");
			Map<String,String> status = new LinkedHashMap<String,String>();
	        status.put("approve", "approve");
	        status.put("reject", "reject");
	        
	        mv.addObject("status", status);
			mv.addObject("requests",requests);
			mv.addObject("reqobj",new Request());
			return mv;
		}
		//return new ModelAndView("requestReply", "reqobj", new Request());
	}
	
	@RequestMapping(value = "user/register.htm", method = RequestMethod.GET)
	protected ModelAndView registerNewUser(HttpServletRequest request) throws Exception {

		//validator.validate(user, result);

		
			return new ModelAndView("userRegister", "user", new RegisteredUser());
		

}
	@RequestMapping(value = "user/h", method = RequestMethod.GET)
	protected ModelAndView h(HttpServletRequest request) throws Exception {

		//validator.validate(user, result);

		
			return new ModelAndView("login");
		

}
	
	@RequestMapping(value = "user/win", method = RequestMethod.POST)
	protected ModelAndView play(HttpServletRequest request, @ModelAttribute("payment") Payment pa, BindingResult result) throws Exception {

		//validator.validate(user, result);
		
		String eDate=request.getParameter("expiryDate");
		 HttpSession session = (HttpSession) request.getSession();
			User u= (User)session.getAttribute("user");
			pa.setAmount(1);
		Payment p= userDao.pay(pa,eDate,u.getUserID());
		//List <Payment> pl=userDao.getPay(u.getUserID());
		
		
			return new ModelAndView("play", "millions", new MillionsEveryday());
		

}
	
	@RequestMapping(value = "user/second", method = RequestMethod.POST)
	protected ModelAndView play(HttpServletRequest request) throws Exception {

		
		
		
			return new ModelAndView("play", "millions", new MillionsEveryday());
		

}
	
	@RequestMapping(value = "user/logout", method = RequestMethod.POST)
	protected ModelAndView logout(HttpServletRequest request) throws Exception {

		
		
		
			return new ModelAndView("home");
		

}
	
	
	
	@RequestMapping(value = "user/retReq", method = RequestMethod.GET)
	protected ModelAndView retailerReq(HttpServletRequest request) throws Exception {

		
		
		List<Request> requests = requestDao.list();
		ModelAndView mv=new ModelAndView("requestReply");
		Map<String,String> status = new LinkedHashMap<String,String>();
        status.put("approve", "approve");
        status.put("reject", "reject");
        
        mv.addObject("status", status);
		mv.addObject("requests",requests);
		mv.addObject("reqobj",new Request());
		return mv;
			//return new ModelAndView("play", "millions", new MillionsEveryday());
		

}
	
	
	
	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	protected ModelAndView completeRegistration(HttpServletRequest request,  @ModelAttribute("user") RegisteredUser user, BindingResult result) throws Exception {
		
		//UserValidation validator= new UserValidation();
		validator.validate(user, result);

		if (result.hasErrors()) {
			return new ModelAndView("userRegister", "user", user);
		}

		

			System.out.print("registerNewUser");
			//RegisteredUserDAO userDao=new RegisteredUserDAO();
			RegisteredUser u = userDao.register(user);
			
			

		
			//System.out.println("Exception: " + e.getMessage());
			//return new ModelAndView("error", "errorMessage", "error while login");
		
		
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("eljoba91@gmail.com", "Ronaldo@7"));
		email.setSSLOnConnect(true);
		email.setFrom("eljoba91@gmail.com");
		email.setSubject("Registration");
		email.setMsg("CONGRATULATIONS..You have successfully registered and on your way to becoming a millionaire :-)");
		email.addTo(u.getEmail());
		email.send();
		return new ModelAndView("login", "user", user);
	}
}
