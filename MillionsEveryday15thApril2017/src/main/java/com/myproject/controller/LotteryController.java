package com.myproject.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.View;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.dao.CategoryDAO;
import com.myproject.dao.LotteryDAO;
import com.myproject.dao.RegisteredUserDAO;
import com.myproject.dao.RequestDAO;
import com.myproject.dao.RetailerDAO;
import com.myproject.pojo.Category;
import com.myproject.pojo.Lottery;
import com.myproject.pojo.MillionsEveryday;
import com.myproject.pojo.Payment;
import com.myproject.pojo.RegisteredUser;
import com.myproject.pojo.Request;
import com.myproject.pojo.Retailer;
import com.myproject.pojo.User;
import com.myproject.pojo.WinningNumbers;

import com.myproject.validator.UserValidation;

@Controller
@RequestMapping("/lottery/*")
public class LotteryController {
	
	@Autowired
	@Qualifier("lotteryDao")
	LotteryDAO lotteryDao;
	
	@Autowired
	@Qualifier("userDao")
	RegisteredUserDAO userDao;
	
	@Autowired
	@Qualifier("requestDao")
	RequestDAO requestDao;
	
	@Autowired
	@Qualifier("retailerDao")
	RetailerDAO retailerDao;
	
	@Autowired
	@Qualifier("categoryDao")
	CategoryDAO categoryDao;
	
	@Autowired
	ServletContext servletContext;
	


	
	@RequestMapping(value = "/lottery/addCategory", method = RequestMethod.POST)
	protected ModelAndView acceptRequest(HttpServletRequest req,  @ModelAttribute("lottery") Lottery lottery, BindingResult result) throws Exception {
		try {
			if (lottery.getFilename().trim() != "" || lottery.getFilename() != null) {
				File directory;
				String check = File.separator; // Checking if system is linux
												// based or windows based by
												// checking seprator used.
				String path = null;
				if (check.equalsIgnoreCase("\\")) {
					//path = servletContext.getRealPath("").replace("build\\", ""); // gives real path as Lab9/build/web/
																				  // so we need to replace build in the path
					path="D:";
						System.out.println("Path : " + path);																}

				if (check.equalsIgnoreCase("/")) {
					path = servletContext.getRealPath("").replace("build/", "");
					path += "/"; // Adding trailing slash for Mac systems.
				}
				//path="resources/cake.jpg";
				directory = new File(path + "\\" + lottery.getFilename());
				System.out.println("directory: " + directory.toString()  );
				System.out.println("directory abs: " + directory.getAbsolutePath()  );
				System.out.println("directory path: " + directory.getPath()  );
				boolean temp = directory.exists();
				if (!temp) {
					temp = directory.mkdir();
				}
				if (temp) {
					// We need to transfer to a file
					CommonsMultipartFile photoInMemory = lottery.getLogo();

					String fileName = photoInMemory.getOriginalFilename();
					// could generate file names as well

					File localFile = new File(directory.getPath(), fileName);

					// move the file from memory to the file

					photoInMemory.transferTo(localFile);
					lottery.setFilename(localFile.getPath());
					System.out.println("File is stored at" + localFile.getPath());
					System.out.print("registerNewUser");
					Lottery u = lotteryDao.register(lottery);

				} else {
					System.out.println("Failed to create directory!");
				}
			}

		} catch (IllegalStateException e) {
			System.out.println("*** IllegalStateException: " + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("*** IOException: " + e.getMessage());
		} 
		return new ModelAndView("success");
	}
	
//	@RequestMapping(value = "/lottery/numbers", method = RequestMethod.POST)
//	protected ModelAndView completeRegistration(HttpServletRequest request,  @ModelAttribute("winningNumbers") WinningNumbers winningNumbers, BindingResult result) throws Exception {
//		
//		//UserValidation validator= new UserValidation();
//		//validator.validate(user, result);
//
//		
//
//		
//
//			System.out.print("registerNewUser");
//			//RegisteredUserDAO userDao=new RegisteredUserDAO();
//			//WinningNumbers w = lotteryDao.addNumbers(winningNumbers);
//			
//			
//			
//			
//
//		
//			//System.out.println("Exception: " + e.getMessage());
//			//return new ModelAndView("error", "errorMessage", "error while login");
//		
//		
//		
//		return new ModelAndView("home");
//	}
	
	@RequestMapping(value = "/lottery/win", method = RequestMethod.POST)
	protected ModelAndView play(HttpServletRequest request,  @ModelAttribute("millions") MillionsEveryday millions, BindingResult result) throws Exception{
		
		Random rand = new Random();

		int  n1 = rand.nextInt(50) + 0;
		int  n2 = rand.nextInt(50) + 0;
		int  n3 = rand.nextInt(50) + 0;
		int  n4 = rand.nextInt(50) + 0;
		int  n5 = rand.nextInt(50) + 0;
		int  n6 = rand.nextInt(15) + 0;
		int prize=0;
		
		if(n5==millions.getNum5()&&n6==millions.getNum6()){
			prize=100000000;
		}
			else if(n5==millions.getNum5()){
				prize=1000000;
			}
			else if(n4==millions.getNum4()&&n6==millions.getNum6()){
				prize=5000;
			}
			else if(n4==millions.getNum4()){
				prize=500;
			}
			else if(n3==millions.getNum3()&&n6==millions.getNum6()){
				prize=50;
			}
			else if(n3==millions.getNum3()){
				prize=5;
			}
			else if(n2==millions.getNum2()&&n6==millions.getNum6()){
				prize=5;
			}
			else if(n1==millions.getNum1()&&n6==millions.getNum6()){
				prize=2;
			}
			else if(n6==millions.getNum6()){
				prize=1;
			}
		//prize=1;
		
		if(prize!=0){
			millions.setPrize(prize);
			HttpSession session = (HttpSession) request.getSession();
			User u= (User)session.getAttribute("user");
			RegisteredUser r=userDao.getUser(u.getUserID());
			MillionsEveryday m=lotteryDao.setWinning(millions,r);
		}
		HttpSession session = (HttpSession) request.getSession();
		User u= (User)session.getAttribute("user");
		List<Payment> p=userDao.getPay(u.getUserID());
		int count=p.size();
		String chance="no";
		String s=(String)session.getAttribute("chance");
		if(count%3==0 && s==null){
			chance="yes";
		}
		session.setAttribute("chance", chance);
		ModelAndView mv=new ModelAndView("result");
		mv.addObject("prize",prize);
		return mv;
	}
	
	@RequestMapping(value = "/lottery/where", method = RequestMethod.GET)
	protected ModelAndView whereToPlay(HttpServletRequest request){
		//List<Request> req=requestDao.where();
		return new ModelAndView("viewRetailers");
	}
	
	@RequestMapping(value = "/lottery/addWinning", method = RequestMethod.GET)
	protected ModelAndView addWin(HttpServletRequest request){
		//List<Request> req=requestDao.where();
		//return new ModelAndView("lotteryNumbers","lotNum", new WinningNumbers());
		ModelAndView mv=new ModelAndView("lotteryNumbers");
		String lot=null;
		mv.addObject("lotto",lot);
		mv.addObject("lotNum", new WinningNumbers());
		return mv;
	}
	
	@RequestMapping(value = "/lottery/retailersList", method = RequestMethod.POST)
	protected ModelAndView getRetailers(HttpServletRequest request){
		//List<Request> req=requestDao.where();
		String city=request.getParameter("city");
		List<Request> ret=retailerDao.ret(city);
		return new ModelAndView("viewRetailers","reatiler",ret);
	}
	
	@RequestMapping(value = "/lottery/lotNumber", method = RequestMethod.POST)
	protected ModelAndView setLot(HttpServletRequest request){
		//List<Request> req=requestDao.where();
		String lot=request.getParameter("lot");
		//List<Lottery> ret=lotteryDao.ret(lot);
		HttpSession session = (HttpSession) request.getSession();
		session.setAttribute("lottery", lot);
		ModelAndView mv=new ModelAndView("lotteryNumbers");
		mv.addObject("lotto", lot);
		mv.addObject("lotNum", new WinningNumbers());
		return mv;
		//return new ModelAndView("lotteryNumbers","lotNum",new Lottery());
	}
	
	@RequestMapping(value = "/lottery/enter", method = RequestMethod.GET)
	protected ModelAndView enter(HttpServletRequest request){
		//List<Request> req=requestDao.where();
		
		return new ModelAndView("enterTheGame","payment",new Payment());
	}
	
	@RequestMapping(value = "/lottery/addCategory", method = RequestMethod.GET)
	protected ModelAndView enterCateg(HttpServletRequest request){
		//List<Request> req=requestDao.where();
		
		return new ModelAndView("addCategory","category",new Category());
	}
	
	@RequestMapping(value = "/lottery/millionWin", method = RequestMethod.GET)
	protected ModelAndView millionWinners(HttpServletRequest request){
		//List<Request> req=requestDao.where();
		List<MillionsEveryday> m=lotteryDao.getWin();
		return new ModelAndView("millionWinners","million",m);
	}
	
	@RequestMapping(value = "/lottery/addNumbers", method = RequestMethod.GET)
	protected ModelAndView addnumbers(HttpServletRequest request){
		//List<Request> req=requestDao.where();
		//List<MillionsEveryday> m=lotteryDao.getWin();
		return new ModelAndView("addLoterry","lottery",new Lottery());
	}
	
	@RequestMapping(value = "/lottery/insertCategory", method = RequestMethod.POST)
	protected ModelAndView insertCateg(HttpServletRequest request,@ModelAttribute("category") Category category, BindingResult result){
		//List<Request> req=requestDao.where();
		//List<MillionsEveryday> m=lotteryDao.getWin();
		Category c=categoryDao.register(category);
		return new ModelAndView("success2");
	}
	
	@RequestMapping(value = "/lottery/ajax", method = RequestMethod.GET)
	protected ModelAndView searchLot(HttpServletRequest request){
		//List<Request> req=requestDao.where();
		//List<MillionsEveryday> m=lotteryDao.getWin();
		//Category c=categoryDao.register(category);
		return new ModelAndView("lotteryDraws");
	}
	
	@RequestMapping(value = "/lottery/rules", method = RequestMethod.GET)
	protected ModelAndView pdf(HttpServletRequest request,ModelMap model){
		//List<Request> req=requestDao.where();
		//List<MillionsEveryday> m=lotteryDao.getWin();
		//Category c=categoryDao.register(category);
		List<Category> c= categoryDao.getCat();
		model.addAttribute("categories", c);
		View v = new PDFView();
        return new ModelAndView(v);
		
	}
	
	@RequestMapping(value = "/lottery/lotNumberSet", method = RequestMethod.POST)
	protected ModelAndView setLoto(HttpServletRequest request,@ModelAttribute("lotNum") WinningNumbers w, BindingResult result) throws ParseException{
		//List<Request> req=requestDao.where();
		//List<MillionsEveryday> m=lotteryDao.getWin();
		//Category c=categoryDao.register(category);
		HttpSession session = (HttpSession) request.getSession();
		String l=(String)session.getAttribute("lottery");
		List<Lottery> lo=lotteryDao.ret(l);
		Lottery loto=null;
		for(Lottery lott:lo){
			loto=lott;
		}
		//w.setLottery(loto);
		String jDate=request.getParameter("jackpotDate");
		String nDate=request.getParameter("nextJackpot");
		WinningNumbers n=lotteryDao.addNumbers(w,loto,jDate,nDate);
		//return new ModelAndView("lotteryNumbers","lotNum",new WinningNumbers());
		return new ModelAndView("lotteryNumbers");
	}
	
	@RequestMapping(value = "/lottery/ajax", method = RequestMethod.POST)
    public String getAvailableNum(@RequestParam("name") String keyword, HttpServletResponse response) throws JSONException {

        System.out.println("parameter "+keyword);
        //JSONObject jobs = new JSONObject();
        JSONObject  json=null;
        WinningNumbers w=null;
        if (!keyword.isEmpty()) {

            List<WinningNumbers> wn = lotteryDao.wn(keyword);
            //System.out.println("joblist "+jobList.size());
            //JSONObject json = null;
            
             w=wn.get(0);

            

             json = new JSONObject();
             json.put("id", w);
                json.put("number1", w.getNum1());
                json.put("number2", w.getNum2());
                json.put("number3", w.getNum3());
                json.put("number4", w.getNum4());
                json.put("number5", w.getNum5());
                json.put("number6", w.getNum6());
                json.put("prize", w.getPrize());
                json.put("jackpotDate", w.getJackpotDate());
                json.put("nextJackpot", w.getNextJackpot());
                //jobs.append("jobs", json);

            

        }
        PrintWriter out;
        try {
            out = response.getWriter();
            out.println(json);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
	
	
}
