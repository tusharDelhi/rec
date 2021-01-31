package com.rec.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.google.gson.Gson;
import com.rec.dao.Admin_DiscomDao;
//import com.rec.dao.LoginDao;
import com.rec.model.Admin;
import com.rec.model.Discom;
import com.rec.model.LoginDetails;
import com.rec.model.StateDiscom;
import com.rec.model.States;
import com.rec.service.Admin_DiscomService;
import com.rec.service.StateDiscomService;
import com.rec.service.StatesService;

//import com.rec.service.StatesService;

@Controller
public class HomeController {
	
	@Autowired
	private  SessionFactory sf;
	
	@Autowired
	private ServletContext sc;
	
	@Autowired
	 Admin_DiscomService adminService;
	
	@Autowired
	Admin_DiscomDao admin_DiscomDao;
	
	@Autowired
	StatesService stateService;
	
	@Autowired
	StateDiscomService stateDiscomService;
	private static Logger log = Logger.getLogger(HomeController.class);
	LoginDetails loginDetails = new LoginDetails();

	@RequestMapping(path = "/showMainForm", method = RequestMethod.GET)
	public String Home() {
		log.info("Home Controller");
		log.info("Launching Login page");

		System.out.println("Most welcome to home Controller");
        log.info(sc.getContextPath());
        
		// model.addAttribute("user", user);
		return "Home";

	}
	
	
	
	@RequestMapping(value = "/logOut",method = RequestMethod.GET)
	public String logOut(HttpServletRequest request,Model model)
	{
		HttpSession session1 = request.getSession(false);
		if(session1!=null)
		{
			session1.invalidate();
			  model.addAttribute("errMessage", "You have logged out successfully");
		}
		return "Home";
	}

	
	/*
	 * @RequestMapping(value = "/admin1", method = RequestMethod.GET)
	 * public @ResponseBody List<StateDiscom> admin1(HttpServletRequest req,
	 * HttpServletResponse ressponse, HttpSession session, Model model) throws
	 * IOException { List<StateDiscom> discomList =
	 * stateDiscomService.findAllDiscoms(); return discomList;
	 */
		
		
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(HttpServletRequest req, HttpServletResponse response, HttpSession session, Model model)
			throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
//        int id = Integer.parseInt(req.getParameter("copy"));		
//		System.out.println(id);
		model.addAttribute("userId", session.getAttribute("username"));
		// model.addAttribute("usertype",session.getAttribute("usertype"));
		List<Object[]> searchList = adminService.searchAll();
		for(Object[] data :searchList)
		{
			log.info(Arrays.deepToString(data));
		}
		//System.out.println(qlist);
		log.info(searchList.toString());
		model.addAttribute("searchList", searchList);
		List<States> state_List = stateService.findAllStates();
		for (States state1 : state_List) {
			System.out.println("states"+state1.getState()+"With their stateid"+state1.getStateId());
		}
        model.addAttribute("state_list", state_List);
        

		
		/*
		 * List<StateDiscom> discom_List = stateDiscomService.findByState(id); for
		 * (StateDiscom dis : discom_List) {
		 * System.out.println("discom"+dis.getName()+"With their stateid"+dis.getId());
		 * } model.addAttribute("dis_list", discom_List);
		 */
		 
        
              List<StateDiscom> discomList = stateDiscomService.findAllDiscoms();
              for(StateDiscom discoms:discomList)
              {
            	  System.out.println("discoms \t"+discoms.getName());
              }
              model.addAttribute("discomList", discomList);
              //adding jquery code to add
				/*
				 * out.println("<html>"); out.println(
				 * "head"+"<script src=\"https://code.jquery.com/jquery-3.5.1.min.js\"></script>"
				 * ); out.println("<script>"+"$('#StateSelect').change(function()" + "";
				 */
              
		return "Admin";
		
	}
	
	
	@RequestMapping(value = "loadStates/{id}",method=RequestMethod.GET)
	public String loadState(@PathVariable("id")int id)
	{
		Gson gson = new Gson();
		return gson.toJson(stateDiscomService.findByState(id));
	}
	
	
	
	
	
	
	  
	 
	 
	 
	
	 
			
		
			
	
	@RequestMapping(value="/searchBar",method = RequestMethod.POST)
	public String SearchForm(HttpServletRequest req,Model model) throws ParseException
	{
		
		String state = req.getParameter("keyword");
		String search = req.getParameter("search");
		String queryRegistered1=req.getParameter("queryRegistered");
		String queryCompliance1=req.getParameter("queryCompliance");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date queryRegistered=sdf.parse(queryRegistered1);
		Date queryCompliance=sdf.parse(queryCompliance1);
		System.out.println(search);
		System.out.println("hi");

		List<Object[]> searchList=null;
		if(search.equalsIgnoreCase("state")) {
		 searchList = 	adminService.searchbar(state, queryRegistered, queryCompliance);
		}else if(search.equalsIgnoreCase("discom"))
		{
	 searchList = 	adminService.searchbar2(state, queryRegistered, queryCompliance);
		}
		else
		{
			searchList = adminService.searchAll();
		}
		System.out.println(searchList.toString());
		model.addAttribute("searchList", searchList);
		//model.addAttribute("search",search)
		if(searchList.isEmpty())
		{
			model.addAttribute("error","No Data Found");
		}
		
		return "Admin";
	}


	@RequestMapping(value = "/discom", method = RequestMethod.GET)
	public String discom(HttpServletRequest req, HttpServletResponse ressponse, HttpSession session, Model model)
			throws IOException {
		model.addAttribute("discom", new Discom());
		model.addAttribute("userId", session.getAttribute("userName"));
		// model.addAttribute("usertype",session.getAttribute("usertype"));
		model.addAttribute("adddiscom", new Discom());
		List<Object[]> qlist = adminService.showQueries((String)session.getAttribute("userName"));
	//	qlist.get(0);
		for(Object[] data :qlist)
		{
			log.info(Arrays.deepToString(data));
		}
		
		//log.info(qlist.toString());
		model.addAttribute("qlist", qlist);

		
		return "Discom-user-page";
	}

	@SuppressWarnings({ "unused", "null" })
	@RequestMapping("/processLogin")
	public String processCredentials(@RequestParam("username") String userName, @RequestParam("password") String password,
			Model model, HttpSession session) throws IOException {
		// RedirectView view1 = new RedirectView();
		try
		{
		String message = "";
		List<LoginDetails> isValid1 =(List<LoginDetails>) admin_DiscomDao.CheckUser(userName, password);
		
		//log.info("is user valid?=" + isValid1.toString());
		
        if (isValid1!= null)
		{
			for (LoginDetails isValid : isValid1) {    //error coming these line
				session.setAttribute("userName", isValid.getUsername());
				System.out.println(isValid.getUsername());
				System.out.println(isValid.getPassword());
				
			//System.out.println(dis);
                session.setAttribute("state", isValid.getDiscom().getState());
                session.setAttribute("discom", isValid.getDiscom().getDiscomName());
				return "redirect:/discom";
			}
		}       
        List<Admin> isValid2 =(List<Admin>) admin_DiscomDao.findUser(userName, password);
		
			      
						if (isValid2!=null)
						{
							System.out.println(isValid2.toString());
				for (Admin isValid3 : isValid2) {
					session.setAttribute("username", isValid3.getUsername());
				    session.setAttribute("state", isValid3.getDiscom().getState());
	                session.setAttribute("discom", isValid3.getDiscom().getDiscomName());

					return "redirect:/admin";
						
		}
		}				message = "Invalid credentials";
		log.info(message);
			
		
		}
        
        
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "redirect:/showMainForm";
	}

	
}