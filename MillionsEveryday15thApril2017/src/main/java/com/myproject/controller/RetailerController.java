package com.myproject.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.myproject.dao.RegisteredUserDAO;
import com.myproject.dao.RequestDAO;
import com.myproject.dao.RetailerDAO;
import com.myproject.pojo.RegisteredUser;
import com.myproject.pojo.Request;
import com.myproject.pojo.Retailer;
import com.myproject.pojo.User;
import com.myproject.validator.RetailerValidation;
import com.myproject.validator.UserValidation;
import com.myproject.pojo.Filename;
import com.myproject.pojo.Payment;



@Controller
@RequestMapping("/retailer/*")
public class RetailerController {
	
	
	@Autowired
	@Qualifier("retailerDao")
	RetailerDAO retailerDao;
	
	@Autowired
	@Qualifier("requestDao")
	RequestDAO requestDao;
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	@Qualifier("RetailerValidator")
	RetailerValidation validator;
	
	@InitBinder("RetailerValidator")
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping(value = "retailer/register.htm", method = RequestMethod.GET)
	protected ModelAndView registerNewUser(HttpServletRequest request) throws Exception {

		//validator.validate(user, result);

		
			return new ModelAndView("retailerRegister", "retailer", new Retailer());
		

}
	
	@RequestMapping(value = "retailer/checkpay", method = RequestMethod.GET)
	protected ModelAndView paymentList(HttpServletRequest request) throws Exception {

		//validator.validate(user, result);
		HttpSession session = (HttpSession) request.getSession();
		User u=(User)session.getAttribute("user");
		    List<Request> r= requestDao.getCur(u.getUserID());
			//return new ModelAndView("paymentList","request",r);
		    ModelAndView mv=new ModelAndView("paymentList");
		    mv.addObject("request",r);
		    mv.addObject("pay",new Payment());
		    return mv;
		

}
	
	@RequestMapping(value = "retailer/engage", method = RequestMethod.GET)
	protected ModelAndView engage(HttpServletRequest request) throws Exception {

		//validator.validate(user, result);

		    
			return new ModelAndView("retailerRequest","req",new Request());
		

}
	
	@RequestMapping(value = "retailer/pay", method = RequestMethod.POST)
	protected ModelAndView pay(HttpServletRequest request,@ModelAttribute("pay") Payment p, BindingResult result) throws Exception {

		//validator.validate(user, result);

		HttpSession session = (HttpSession) request.getSession();
		session.setAttribute("pid", p);
		User u=(User)session.getAttribute("user");
		List<Payment> py=retailerDao.getPay(u.getUserID());
		String amt;
		if(py.size()>=1){
			amt="25$";
		}
		else{
			amt="50$";
		}
		session.setAttribute("amount", amt);
			return new ModelAndView("payment","pa",new Payment());
		

}
	
	@RequestMapping(value = "retailer/payFinal", method = RequestMethod.POST)
	protected ModelAndView payFinal(HttpServletRequest request,@ModelAttribute("pa") Payment p, BindingResult result) throws Exception {

		//validator.validate(user, result);
		Request re=null;
		HttpSession session = (HttpSession) request.getSession();
		Payment paym=(Payment)session.getAttribute("pid");
		List<Request> pl=requestDao.getRequest(paym.getRequestId());
		for(Request r:pl){
			
			re=r;
		}
		re.setStatus("confirmed");
		Request r=requestDao.edit(re);
		p.setRequest(r);
		Payment py=retailerDao.finalPay(p);
				return new ModelAndView("home");	
		

}
	
	@RequestMapping(value = "retailer/map", method = RequestMethod.GET)
	protected ModelAndView retMap(HttpServletRequest request) throws Exception {

		//validator.validate(user, result);
			ModelAndView mv=new ModelAndView("map");
		    String longitude=request.getParameter("lon");
		    String latitude=request.getParameter("lat");
			mv.addObject("longi", longitude);
			mv.addObject("lati", latitude);
			return mv;

}
	
	@RequestMapping(value = "/retailer/register", method = RequestMethod.POST)
	protected ModelAndView completeRegistration(HttpServletRequest request,  @ModelAttribute("retailer") Retailer retailer, BindingResult result) throws Exception {
		
		//UserValidation validator= new UserValidation();
		validator.validate(retailer, result);

		if (result.hasErrors()) {
			return new ModelAndView("retailerRegister", "retailer", retailer);
		}

		

			System.out.print("registerNewUser");
			//RegisteredUserDAO userDao=new RegisteredUserDAO();
			Retailer r = retailerDao.register(retailer);
			
			
			
			

		
			//System.out.println("Exception: " + e.getMessage());
			//return new ModelAndView("error", "errorMessage", "error while login");
		
		
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("eljoba91@gmail.com", "Ronaldo@7"));
		email.setSSLOnConnect(true);
		email.setFrom("eljoba1@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("barbosa.el@husky.neu.edu");
		email.send();
		ModelAndView m=new ModelAndView();
		//m.addObject(ratailerId", r);
		request.getSession().setAttribute("retId", r);
		//return new ModelAndView("retailerRequest", "request", new Request());
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/retailer/accept", method = RequestMethod.POST)
	protected ModelAndView acceptRequest(HttpServletRequest req,  @ModelAttribute("reqobj") Request request, BindingResult result) throws Exception {
		
		//UserValidation validator= new UserValidation();
		//validator.validate(user, result);

		

		

			System.out.print("registerNewUser");
			
			for(Request r:requestDao.list()){
				
				if(request.getRequestId()==r.getRequestId()){
				r.setStatus(request.getStatus());
				Request re=requestDao.edit(r);}
				
			}
			//RegisteredUserDAO userDao=new RegisteredUserDAO();
			//Retailer r = retailerDao.register(retailer);
			
			
			
			
			

		
			//System.out.println("Exception: " + e.getMessage());
			//return new ModelAndView("error", "errorMessage", "error while login");
		
		
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("eljoba91@gmail.com", "Ronaldo@7"));
		email.setSSLOnConnect(true);
		email.setFrom("eljoba91@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("barbosa.el@husky.neu.edu");
		email.send();
		ModelAndView m=new ModelAndView();
		//m.addObject(ratailerId", r);
		//request.getSession().setAttribute("retId", r);
		return new ModelAndView("retailerRequest", "req", new Request());
	}
	
	@RequestMapping(value = "/retailer/request", method = RequestMethod.POST)
	protected ModelAndView postRequest(HttpServletRequest request,  @ModelAttribute("req") Request req, BindingResult result) throws Exception {
		
		//UserValidation validator= new UserValidation();
		//validator.validate(user, result);

		

		

		try {
			List<Filename> fileNameList = new ArrayList<Filename>();
			
			
			
			if (req.getImagename().trim() != "" || req.getImagename() != null) {
				File directory;
				String check = File.separator; // Checking if system is linux
												// based or windows based by
												// checking seprator used.
				String path = null;
				if (check.equalsIgnoreCase("\\")) {
					path = servletContext.getRealPath("").replace("build\\", ""); // gives real path as Lab9/build/web/
																				  // so we need to replace build in the path
																						}

				if (check.equalsIgnoreCase("/")) {
					path = servletContext.getRealPath("").replace("build/", "");
					path += "/"; // Adding trailing slash for Mac systems.
				}
				directory = new File(path + "\\" + req.getImagename());
				boolean temp = directory.exists();
				if (!temp) {
					temp = directory.mkdir();
				}
				if (temp) {
					
					// We need to transfer to a file
					CommonsMultipartFile[] photoInMemory = req.getPhoto();

					for(int i=0;i<photoInMemory.length;i++){
						Filename oneFileName  = new Filename();
					String fileName=photoInMemory[i].getOriginalFilename();
					// could generate file names as well}
					//for(int j=0;j<fileName.size();j++){
					File localFile = new File(directory.getPath(), fileName);

					// move the file from memory to the file

					photoInMemory[i].transferTo(localFile);
					oneFileName.setFname(localFile.getPath());
					//req.setImagename(localFile.getPath());
//					fileNameList.add(oneFileName);
					req.setFilename(fileNameList);
					req.getFilename().add(oneFileName);
					Retailer r=new Retailer();
					r = (Retailer)request.getSession().getAttribute("user");
					req.setRetId(r.getUserID());
					//req.setRetailer(r);
					List<Retailer> ret=retailerDao.getRetailer(req.getRetId());
					for(Retailer re:ret){
						req.setRetailerName(re.getName());
					}
					oneFileName.setRequest(req);
					
					//req.get(localFile.getPath());
					System.out.println("File is stored at" + localFile.getPath());
					System.out.print("registerNewUser");
					
					}
					req.setStatus("pending");
					Request r = retailerDao.request(req);
					
				}
					//}

				 else {
					System.out.println("Failed to create directory!");
				}
			}

		 }
			catch (IllegalStateException e) {
			System.out.println("*** IllegalStateException: " + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("*** IOException: " + e.getMessage());
		} 

		return new ModelAndView("home");
	}

}
